package com.ood.singleton;

public class Mouse {
    private static Mouse mouseInstance = null;

    private Mouse() {
        System.out.println("Mouse first initiate");
    }

    public static Mouse getMouse() {
        if (mouseInstance == null) {
            mouseInstance = new Mouse();
        }
        return mouseInstance;
    }
}
