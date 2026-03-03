package Yilonmah.Print;

/**
 * contains all the fixed ui print outs
 */
public class Printer {
    public static void dash() {
        System.out.println("----------------------------------------------------");
    }

    public static void taskAdded() {
        System.out.println("Alrightt task has been added :>");
    }

    public static void taskCount(int count) {
        System.out.println("You now have " + count + " tasks, upz lah");
    }

    public static void opening() {
        Printer.dash();
        String logo = " __    __   _______  __       __        ______   ____    __    ____     ___________    ____  _______ .______     ____    ____ .______     ______    _______  ____    ____    .___  ___. ____    ____    .__   __.      ___      .___  ___.  _______     __       _______.\n" +
                "|  |  |  | |   ____||  |     |  |      /  __  \\  \\   \\  /  \\  /   /    |   ____\\   \\  /   / |   ____||   _  \\    \\   \\  /   / |   _  \\   /  __  \\  |       \\ \\   \\  /   /    |   \\/   | \\   \\  /   /    |  \\ |  |     /   \\     |   \\/   | |   ____|   |  |     /       |\n" +
                "|  |__|  | |  |__   |  |     |  |     |  |  |  |  \\   \\/    \\/   /     |  |__   \\   \\/   /  |  |__   |  |_)  |    \\   \\/   /  |  |_)  | |  |  |  | |  .--.  | \\   \\/   /     |  \\  /  |  \\   \\/   /     |   \\|  |    /  ^  \\    |  \\  /  | |  |__      |  |    |   (----`\n" +
                "|   __   | |   __|  |  |     |  |     |  |  |  |   \\            /      |   __|   \\      /   |   __|  |      /      \\_    _/   |   _  <  |  |  |  | |  |  |  |  \\_    _/      |  |\\/|  |   \\_    _/      |  . `  |   /  /_\\  \\   |  |\\/|  | |   __|     |  |     \\   \\    \n" +
                "|  |  |  | |  |____ |  `----.|  `----.|  `--'  |    \\    /\\    /       |  |____   \\    /    |  |____ |  |\\  \\----.   |  |     |  |_)  | |  `--'  | |  '--'  |    |  |        |  |  |  |     |  |        |  |\\   |  /  _____  \\  |  |  |  | |  |____    |  | .----)   |   \n" +
                "|__|  |__| |_______||_______||_______| \\______/      \\__/  \\__/        |_______|   \\__/     |_______|| _| `._____|   |__|     |______/   \\______/  |_______/     |__|        |__|  |__|     |__|        |__| \\__| /__/     \\__\\ |__|  |__| |_______|   |__| |_______/    \n" +
                "                                                                                                                                                                                                                                                                         \n" +
                "____    ____  __      __        ______   .__   __.    .___  ___.      ___       __    __                                                                                                                                                                                 \n" +
                "\\   \\  /   / |  |    |  |      /  __  \\  |  \\ |  |    |   \\/   |     /   \\     |  |  |  |                                                                                                                                                                                \n" +
                " \\   \\/   /  |  |    |  |     |  |  |  | |   \\|  |    |  \\  /  |    /  ^  \\    |  |__|  |                                                                                                                                                                                \n" +
                "  \\_    _/   |  |    |  |     |  |  |  | |  . `  |    |  |\\/|  |   /  /_\\  \\   |   __   |                                                                                                                                                                                \n" +
                "    |  |     |  |    |  `----.|  `--'  | |  |\\   |    |  |  |  |  /  _____  \\  |  |  |  |                                                                                                                                                                                \n" +
                "    |__|     |__|    |_______| \\______/  |__| \\__|    |__|  |__| /__/     \\__\\ |__|  |__|                                                                                                                                                                                \n" +
                "                                                                                                                                                                                                                                                                         ";
        System.out.println(logo);
        System.out.println("What can I do for you?");
        Printer.dash();
    }

    public static void loadingSave() {
        System.out.println("tryinggg to rememberr");
    }

    public static void saveLoaded() {
        System.out.println("I REMEMBER EVERYTHINGG");
    }

    public static void help() {
        System.out.println("heres the list of commands that i understand :>");
        System.out.println("list, list all tasks added");
        System.out.println("todo DESC, creates a todo task of name DESC");
        System.out.println("deadline DESC /by DATE, creates a deadline task of name DESC and by DATE");
        System.out.println("event DESC /from DATE0 /to DATE1, creates a event task of name DESC and from DATE0 to DATE1");
        System.out.println("mark x, marks task x on the tasklist");
        System.out.println("unmark x, unmarks task x on the tasklist");
        System.out.println("delete x, removes task x from the tasklist");
        System.out.println("DATE should be in the format of yyyy-mm-dd");
        Printer.dash();
    }
}
