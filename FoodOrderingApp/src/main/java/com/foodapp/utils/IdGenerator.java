package com.foodapp.utils;

public class IdGenerator {

    private static int orderItemIDCounter = 1000;
    private static int userIDCounter = 1000;

    private IdGenerator() { }

    public static int getNextOrderItemID() {
        return ++orderItemIDCounter;
    }

    public static int getNextUserID() {
        return ++userIDCounter;
    }
}
