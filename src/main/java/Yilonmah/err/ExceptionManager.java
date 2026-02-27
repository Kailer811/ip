package Yilonmah.err;

import Yilonmah.Print.Printer;

public class ExceptionManager {
    public static void handleException(YilonmahExceptions e) {
        Printer.dash();
        if (e instanceof YilonmahExceptions.NoCommand) {
            System.out.println("ayyo you didn't tell me anything fam");
        } else if (e instanceof YilonmahExceptions.WrongCommand) {
            System.out.println("ayyo idk what this command is fam");
        } else if (e instanceof YilonmahExceptions.OutOfBounds) {
            System.out.println("there isnt this task fam");
        } else if (e instanceof YilonmahExceptions.FileCorrupted) {
            System.out.println("save file is corrupted, pls fix it for me tq");
        } else if (e instanceof YilonmahExceptions.MissingDescription) {
            System.out.println("pls include the description after task");
        }
        Printer.dash();
    }
}
