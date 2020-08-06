package com.company;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;

import static com.company.Utils.*;
import static com.company.Utils.ROMAN;

public class AnalyzingMethods {

    public static int analyzeInputOperation(String s) {

        char currentSymbol;
        byte operationsCount = 0;
        int operationIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            currentSymbol = s.charAt(i);

            if (String.valueOf(currentSymbol).equals("/")) {
                operationIndex = DELENIE;
                operationsCount += 1;
            }
            if (String.valueOf(currentSymbol).equals("+")) {
                operationIndex = SLOZHENIE;
                operationsCount += 1;
            }
            if (String.valueOf(currentSymbol).equals("-")) {
                operationIndex = VUCHITANIE;
                operationsCount += 1;
            }
            if (String.valueOf(currentSymbol).equals("*")) {
                operationIndex = UMNOZHENIE;
                operationsCount += 1;
            }


        }

        if (operationsCount != 1) {
            throw new ArithmeticException(OP_EXCEPTION);
        } else {;
            return operationIndex;
        }
    }

    public static void symbolsChecker(String s) {

        char currentSymbol;
        boolean drop = false;
        for (int i = 0; i < s.length(); i++) {

            currentSymbol = s.charAt(i);

            if (!(Arrays.toString(UTILS).contains(CharBuffer.wrap(new char[]{currentSymbol}))) &&
                    !(Arrays.toString(ARABIC_NUMBERS).contains(CharBuffer.wrap(new char[]{currentSymbol}))) &&
                    !(Arrays.toString(ROMAN_NUMBER_FRAGMENTS).contains(CharBuffer.wrap(new char[]{currentSymbol})))) {
                drop = true;
            }
        }

        if (drop) {
            try {
                throw new IOException("Проверьте правильность введенных данных");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static int arabianOrRoman(String s) {

        char currentSymbol;

        boolean hasArabian = false;
        boolean hasRoman = false;

        for (int i = 0; i < s.length(); i++) {

            currentSymbol = s.charAt(i);
            if ((Arrays.toString(ARABIC_NUMBERS).contains(CharBuffer.wrap(new char[]{currentSymbol}))) && currentSymbol != ' ') {
                hasArabian = true;
            }
            if ((Arrays.toString(ROMAN_NUMBER_FRAGMENTS).contains(CharBuffer.wrap(new char[]{currentSymbol}))) && (currentSymbol != ' ')) {
                hasRoman = true;
            }

        }
        if (hasArabian && hasRoman) {
            try {
                throw new IOException("Арабские и римские цифры в одном примере");
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }

        } else {

            if (hasArabian) {
                return ARABIC;
            } else {
                return ROMAN;
            }
        }
    }

    public static int romanToArabic(String roman) {

        switch (roman) {

            case "I" : return 1;
            case "II" : return 2;
            case "III" : return 3;
            case "IV" : return 4;
            case "V" : return 5;
            case "VI" : return 6;
            case "VII" : return 7;
            case "VIII" : return 8;
            case "IX" : return 9;
            case "X" : return 10;
            default : return 0;
        }

    }
}
