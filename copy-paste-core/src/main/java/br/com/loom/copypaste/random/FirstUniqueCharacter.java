package br.com.loom.copypaste.random;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class FirstUniqueCharacter {

    public static void main(String[] args) {
        try {

            log.info(getFirstUnique("abaddccbab"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static char getFirstUnique(String s) {
        return (char) s.chars().filter(c -> s.indexOf(c) == s.lastIndexOf(c)).findFirst().orElseThrow();
    }

}
