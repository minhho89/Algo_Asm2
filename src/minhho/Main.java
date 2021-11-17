package minhho;

import minhho.views.MainMenu;

public class Main {

    public static void main(String[] args) {
        MainMenu.printMenu();

        MainMenu.printChoice(MainMenu.makeChoice());
    }
}
