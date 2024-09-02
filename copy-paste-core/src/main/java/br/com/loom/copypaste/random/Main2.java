package br.com.loom.copypaste.random;


import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class Main2 {

    public static void main(String[] args) {
        Sample(5,10);
        Brasil();
    }

    public static void Sample(int a, int b) {
        System.out.println(a + b);
    }

    public static void Brasil() {
        System.out.println("Welcome from Brasil");
    }

}
