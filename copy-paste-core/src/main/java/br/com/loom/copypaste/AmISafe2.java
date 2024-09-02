package br.com.loom.copypaste;

import lombok.extern.apachecommons.CommonsLog;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@CommonsLog
public class AmISafe2 {

    public static void main(String[] args) {

        System.out.println(amISafe(new int[]{5, 10, 10}));
        System.out.println(amISafe(new int[]{5, 10, 5, 20}));
        System.out.println(amISafe(new int[]{10, 5, 5, 20}));
        System.out.println(amISafe(new int[]{5, 10, 5, 20, 5, 10, 5, 10, 5, 50}));
        System.out.println(amISafe(new int[]{5, 10, 5, 20, 50}));

    }

    private static boolean amISafe(int[] moneys) {

        List<Integer> myBills = new LinkedList<>();

        try {
            for (int money : moneys) {
                int change = money - 5;
                while (change > 0) {
                    int c = change;
                    int bill = myBills.stream()
                            .filter(j -> j <= c)
                            .max(Integer::compareTo)
                            .orElseThrow();
                    myBills.remove((Object) bill);
                    change -= bill;
                }
                myBills.add(money);
            }
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
