package com.bravi.time.helper;

import com.bravi.time.exception.InvalidTimeException;

public class NumberHelper {

    private NumberHelper() {
    }

    private static final String numbers[] = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen",
            "twenty",
            "twenty one",
            "twenty two",
            "twenty three",
            "twenty four",
            "twenty five",
            "twenty six",
            "twenty seven",
            "twenty eight",
            "twenty nine"
    };

    public static String textByNumber(Integer number){
       try {
           return numbers[number];
       } catch (Exception ex) {
           throw new InvalidTimeException("Invalid time format, EX: 11:59");
       }
    }

}
