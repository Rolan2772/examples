package com.rolan.examples.regex;

import java.util.regex.Pattern;

public class App {

    public static final String EXAMPLE_TEST = "This is my small example "
            + "string which I'm going to " + "use for pattern matching.";

    public static void main(String... args) {
        App app = new App();

        System.out.println(RegexPattern.WORD + ": " + app.isWordString(EXAMPLE_TEST));


        String[] splitString = (EXAMPLE_TEST.split("\\s+"));
        System.out.println(splitString.length);// should be 14
        for (String string : splitString) {
            System.out.println(string);
        }
        // replace all whitespace with tabs
        System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));
    }

    public boolean isWordString(String str) {
        return RegexPattern.WORD.matches(str);
    }

    public boolean isZeroMoneyValue(String str) {
        return RegexPattern.ZERO_MONEY.matches(str);
    }

    public enum RegexPattern {

        WORD("Word characters", "\\w*"),
        ZERO_MONEY("Zero money value", "^(-|\\+)?0{1,3}(\\,0{3})*(\\.0+)?");

        RegexPattern(String name, String pattern) {
            this.name = name;
            this.pattern = Pattern.compile(pattern);
        }

        public boolean matches(String str) {
            return Pattern.matches(pattern.pattern(), str);
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "RegexPattern{name='" + name + "\'" + ", pattern='" + pattern + "\'}";
        }

        private String name;
        private Pattern pattern;
    }
}
