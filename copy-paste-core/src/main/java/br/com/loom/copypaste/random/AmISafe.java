package br.com.loom.copypaste.random;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class AmISafe {

    public static void main(String[] args) {

        System.out.println(amISafe(new int[]{5, 10, 10}));

    }

    private static boolean amISafe(int[] moneys) {
        for (int i = 0; i < moneys.length; i++) {
            if ((moneys[i] - 5) > 5 * i)
                return false;
        }
        return true;
    }

}
