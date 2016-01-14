/*
 * Globalroam 2015 @copyright
 */
package com.gnum.experiments;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenglong
 * @description
 */
public class MatchTest {
    public static void main(String[] args) {
        String date = "12/30/1969";
        Pattern pattern = Pattern.compile("^(\\d\\d)[-/](\\d\\d)[-/](\\d\\d(?:\\d\\d)?)$");
        Matcher matcher = pattern.matcher(date);
        if (matcher.find()) {
            String month = matcher.group(1);
            String day = matcher.group(2);
            String year = matcher.group(3);
            System.out.printf("Found %s-%s-%s\n", year, month, day);
        }
    }
}
