package minhho;

import minhho.controllers.MainController;
import minhho.views.MainMenu;

public class Main {

    public static void main(String[] args) {
        MainMenu.printMenu();

        int choice = MainMenu.makeChoice();
        MainMenu.printChoice(choice);

        MainController.run(choice);
    }
}
