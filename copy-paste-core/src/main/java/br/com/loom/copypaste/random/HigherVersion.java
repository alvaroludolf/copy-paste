package br.com.loom.copypaste.random;

public class HigherVersion {

    public static void main(String[] args) {
        System.out.println(compareVersion("", "1.0.0"));
        System.out.println(compareVersion("1.0", "1.0.0"));
        System.out.println(compareVersion("1.0.1", "1.0.1"));
        System.out.println(compareVersion("1.0.1", "1.0.01"));
        System.out.println(compareVersion("1.2.01", "1.20.1"));
        System.out.println(compareVersion("1.0.22", "1.0.20.2"));
    }

    private static int compareVersion(String s1, String s2) {
        String[] parts1 = s1.split("\\.", 2);
        String[] parts2 = s2.split("\\.", 2);
        int i1 = Integer.parseInt("0" + parts1[0]);
        int i2 = Integer.parseInt("0" + parts2[0]);
        return (i1 != i2) ? i1 - i2 :
                (parts1.length == 1 && parts2.length == 1) ? 0 :
                        parts1.length == 1 ? 1 :
                                parts2.length == 1 ? -1 :
                                        compareVersion(parts1[1], parts2[1]);
    }

}
