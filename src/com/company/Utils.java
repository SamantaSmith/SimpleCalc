package com.company;

public class Utils {

    public static final int DELENIE = 1;
    public static final int UMNOZHENIE = 2;
    public static final int SLOZHENIE = 3;
    public static final int VUCHITANIE = 4;

    public static final String OP_EXCEPTION = "\"Отсутствует операция или количество операций больше 1. Проверьте валидность введенного примера\"";

    public static final char[] ARABIC_NUMBERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static final char[] UTILS = {'+', '-', '/', '*', ' '};
    public static final char[] ROMAN_NUMBER_FRAGMENTS = {'I', 'V', 'X'};

    public static final int ARABIC = 1;
    public static final int ROMAN = 2;

    public static final String TUTORIAL = "\nДобрый день!\n\nУ данного ковертера есть некоторые ограничения:\n1. Доступны только целые числа от 1 до 10\n" +
            "2. Начинайте запись примера сразу с первого числа, пробелы в начале выкинут ошибку\n3. При деление римских цифр друг на друга выводится" +
            " целая часть от этого деления\n4. Римские цифры записываются СТРОГО большими буквами\n";
}
