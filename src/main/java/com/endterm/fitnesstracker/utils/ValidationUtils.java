package com.endterm.fitnesstracker.utils;

public class ValidationUtils {

    public static void checkId(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }
    }
}
