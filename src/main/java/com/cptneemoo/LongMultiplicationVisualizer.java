package com.cptneemoo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LongMultiplicationVisualizer {

    private int multiplicand1;
    private int multiplicand2;
    private static final String newLine  = "\n";

    public static void main(String[] args) {
        System.out.println(new LongMultiplicationVisualizer(1234352,2));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        long result = (long) multiplicand1 * multiplicand2;
        int resultLength = getLongLength(result);
        sb.append(fixedLengthStringLine(Integer.toString(multiplicand1), resultLength,0));
        sb.append(fixedLengthStringLine(Integer.toString(multiplicand2), resultLength,0));
        int maxMultiplicandsLength = Math.max(getLongLength(multiplicand1),
                getLongLength(multiplicand2));
        sb.append(fixedLengthStringLine(generateStringLine("_",maxMultiplicandsLength),
                resultLength,0));
        long temp = multiplicand2;
        for (int i = 0; i < getLongLength(multiplicand2); i++) {
            long digit = temp % 10;
            temp /= 10;
            long row = (long) multiplicand1 * digit;
            sb.append(fixedLengthStringLine(Long.toString(row),resultLength,i));
        }
        if (getLongLength(multiplicand2) != 1){
            sb.append(fixedLengthStringLine(
                    generateStringLine("_",resultLength), resultLength,0));
            sb.append(result);
        }
        return sb.toString();
    }

    private String generateStringLine(String s, int times){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    private String fixedLengthStringLine(String string, int length, int rightSideSpaces) {
        StringBuilder sb = new StringBuilder();
        int leftSideSpaces = length - string.length() - rightSideSpaces;
        sb.append(generateStringLine(" ", leftSideSpaces));
        sb.append(string);
        sb.append(generateStringLine(" ", rightSideSpaces));
        sb.append(newLine);
        return sb.toString();
    }

    private int getLongLength(long number){
        int length = 0;
        long temp = 1;
        while (temp <= number) {
            length++;
            temp *= 10;
        }
        return length;
    }
}
