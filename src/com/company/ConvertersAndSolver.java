package com.company;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;

import static com.company.AnalyzingMethods.romanToArabic;
import static com.company.Utils.*;

public class ConvertersAndSolver {


    public static int[] converter(String s, int a) {

        int[] numbers = {0, 0};

        if (a == ROMAN) {

            char currentSymbol;

            int newIndex = 0;
            int newIndex2 = 0;
            String romanMaker = "";

            if (s.charAt(0) == ' ') {
                try {
                    throw new IOException("Пожалуйста, не начинайте ввод с пробела");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < s.length(); i++) {

                currentSymbol = s.charAt(i);

                if (!(Arrays.toString(UTILS).contains(CharBuffer.wrap(new char[]{currentSymbol})))) {
                    romanMaker += currentSymbol;
                } else {
                    numbers[0] = romanToArabic(romanMaker);
                    newIndex = i;
                    romanMaker = "";
                    break;
                }

            }

            for (int i = newIndex; i < s.length(); i++) {

                currentSymbol = s.charAt(i);

                if (currentSymbol == 'I' || currentSymbol == 'V' || currentSymbol == 'X') {

                    newIndex2 = i;
                    break;
                }
            }


            for (int i = newIndex2; i<s.length(); i++) {

                currentSymbol = s.charAt(i);

                if (currentSymbol != ' ') {
                    romanMaker += currentSymbol;
                } else {

                    break;
                }
            }
            numbers[1] = romanToArabic(romanMaker);




        }

        if (a == ARABIC) {

            char currentSymbol;

            int newIndex = 0;
            int newIndex2 = 0;
            String romanMaker = "";

            if (s.charAt(0) == ' ') {
                try {
                    throw new IOException("Пожалуйста, не начинайте ввод с пробела");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            for (int i = 0; i < s.length(); i++) {

                currentSymbol = s.charAt(i);

                if (!(Arrays.toString(UTILS).contains(CharBuffer.wrap(new char[]{currentSymbol})))) {
                    romanMaker += currentSymbol;
                } else {
                    numbers[0] = Integer.parseInt(romanMaker);
                    newIndex = i;
                    romanMaker = "";
                    break;
                }

            }

            for (int i = newIndex; i < s.length(); i++) {

                currentSymbol = s.charAt(i);

                if ((Arrays.toString(ARABIC_NUMBERS).contains(CharBuffer.wrap(new char[]{currentSymbol}))) && currentSymbol != ' ') {

                    newIndex2 = i;
                    break;
                }
            }


            for (int i = newIndex2; i<s.length(); i++) {

                currentSymbol = s.charAt(i);

                if (currentSymbol != ' ') {
                    romanMaker += currentSymbol;
                } else {

                    break;
                }
            }
            numbers[1] = Integer.parseInt(romanMaker);


        }

        return numbers;
    }

    public static void solver(int operationIndex, int[] numbers, int arabianOrRoman) {

        double itog = 0;

        if (arabianOrRoman == ARABIC) {

            if (numbers[0]>10 || numbers[0] < 1 || numbers[1]>10 || numbers[1] < 1) {
                try {
                    throw new IOException("Вычисления возможны только для целых чисел от 1 до 10");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {

                switch (operationIndex) {
                    case DELENIE: itog = (double)numbers[0] / (double)numbers[1]; System.out.println(itog); break;
                    case UMNOZHENIE: itog = numbers[0] * numbers[1]; System.out.println((int)itog); break;
                    case SLOZHENIE: itog = numbers[0] + numbers[1]; System.out.println((int)itog); break;
                    case VUCHITANIE: itog = numbers[0] - numbers[1]; System.out.println((int)itog); break;

                }

            }


        }

        if (arabianOrRoman == ROMAN) {

            if (numbers[0]==0  ||  numbers[1] ==0) {
                try {
                    throw new IOException("Вычисления возможны только для целых чисел от 1 до 10. Проверьте соответствие чисел правилам римской формы записи");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {

                switch (operationIndex) {
                    case DELENIE: itog = (double)numbers[0] / (double)numbers[1]; break;
                    case UMNOZHENIE: itog = numbers[0] * numbers[1]; break;
                    case SLOZHENIE: itog = numbers[0] + numbers[1]; break;
                    case VUCHITANIE: itog = numbers[0] - numbers[1]; break;

                }
                System.out.println(InverseConverter(itog));

            }
        }


    }

    public static String InverseConverter(double romanNumber) {

        String itogRomanNumber = "";

        switch((int)romanNumber/10) {

            case 0: break;
            case 1: itogRomanNumber+="X"; break;
            case 2: itogRomanNumber+="XX"; break;
            case 3: itogRomanNumber+="XXX"; break;
            case 4: itogRomanNumber+="XL"; break;
            case 5: itogRomanNumber+="L"; break;
            case 6: itogRomanNumber+="LX"; break;
            case 7: itogRomanNumber+="LXX"; break;
            case 8: itogRomanNumber+="LXXX"; break;
            case 9: itogRomanNumber+="XC"; break;

        }

        switch((int)romanNumber%10) {

            case 0: break;
            case 1: itogRomanNumber+="I"; break;
            case 2: itogRomanNumber+="II"; break;
            case 3: itogRomanNumber+="III"; break;
            case 4: itogRomanNumber = "I" + itogRomanNumber; break;
            case 5: itogRomanNumber+="V"; break;
            case 6: itogRomanNumber+="VI"; break;
            case 7: itogRomanNumber+="VII"; break;
            case 8: itogRomanNumber+="VIII"; break;
            case 9: if (itogRomanNumber != "") {itogRomanNumber = "X" + itogRomanNumber; break;} else {itogRomanNumber = "IX";}
        }

        if (romanNumber == 100) {return "C";} else {
            return itogRomanNumber;}


    }
}
