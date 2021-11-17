package minhho;

import minhho.view.MainMenu;

public class Main {

    public static void main(String[] args) {
        MainMenu.printMenu();

        MainMenu.printChoice(MainMenu.makeChoice());
    }
}
