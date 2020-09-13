package br.com.devpaulosouza.utils;

public class MathUtils {

    public static int round(float value) {
        if (value % 1 < 0.5) {
            return Math.round(value);
        } else {
            return (int) Math.ceil(value);
        }
    }

    public static long round(double value) {
        if (value % 1 < 0.5) {
            return Math.round(value);
        } else {
            return (long) Math.ceil(value);
        }
    }

}
