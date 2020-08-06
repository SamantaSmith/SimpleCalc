package com.company;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.*;
import static com.company.AnalyzingMethods.*;

import static com.company.ConvertersAndSolver.converter;
import static com.company.ConvertersAndSolver.solver;
import static com.company.Utils.*;


public class Main {

    public static void main(String[] args) {

        System.out.println(TUTORIAL);
        System.out.println("Введите Ваш пример ниже: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        analyzeInputOperation(s);
        symbolsChecker(s);
        arabianOrRoman(s);
        converter(s, arabianOrRoman(s));
        solver(analyzeInputOperation(s), converter(s, arabianOrRoman(s)), arabianOrRoman(s));


    }



}
