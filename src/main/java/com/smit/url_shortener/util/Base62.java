package com.smit.url_shortener.util;

public final class Base62 {
    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private Base62() {
    }
    public static String encode(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative numbers are not allowed");
        }
        if (number == 0) {
            return "0";
        }
        StringBuilder encoded = new StringBuilder();
        while (number > 0) {
            int index = (int) (number % 62);
            number = number / 62;
            encoded.append(ALPHABET.charAt(index));
        }
        return encoded.reverse().toString();
    }


    public static long decode(String code){
        if(code ==null || code.isEmpty()){
            throw new IllegalArgumentException("null not allowed");
        }



        long result =0;
        for(int i=0;i<code.length();i++) {
            char ch = code.charAt(i);
            int value = ALPHABET.indexOf((ch));
            if(value==-1){
                throw new IllegalArgumentException("not allowed");
            }

            result = result * 62 + value;
            //TODO check for overflow

        }
        return result;
    }
}
