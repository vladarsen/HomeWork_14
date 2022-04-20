package com.vladarsenjtev;

public class Main {

    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator();
        fileNavigator.add("/another/PlayStation/", "PlayStation", 1200, "/another/PlayStation/");
        fileNavigator.add("/another/PlayStation2/", "PlayStation2", 1300, "/another/PlayStation2/");
        fileNavigator.add("/another/Game/", "Game", 1400, "/another/Game/");

        System.out.println(fileNavigator.getFileData());
    }
}
