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
        String logo = """
                 __    __   _______  __       __        ______   ____    __    ____     \s
                |  |  |  | |   ____||  |     |  |      /  __  \\  \\   \\  /  \\  /   /     \s
                |  |__|  | |  |__   |  |     |  |     |  |  |  |  \\   \\/    \\/   /      \s
                |   __   | |   __|  |  |     |  |     |  |  |  |   \\            /       \s
                |  |  |  | |  |____ |  `----.|  `----.|  `--'  |    \\    /\\    /        \s
                |__|  |__| |_______||_______||_______| \\______/      \\__/  \\__/         \s
                
                .___  ___. ____    ____    .__   __.      ___      .___  ___.  _______  \s
                |   \\/   | \\   \\  /   /    |  \\ |  |     /   \\     |   \\/   | |   ____| \s
                |  \\  /  |  \\   \\/   /     |   \\|  |    /  ^  \\    |  \\  /  | |  |__    \s
                |  |\\/|  |   \\_    _/      |  . `  |   /  /_\\  \\   |  |\\/|  | |   __|   \s
                |  |  |  |     |  |        |  |\\   |  /  _____  \\  |  |  |  | |  |____  \s
                |__|  |__|     |__|        |__| \\__| /__/     \\__\\ |__|  |__| |_______| \s
                
                ____    ____  __      __        ______   .__   __.                      \s
                \\   \\  /   / |  |    |  |      /  __  \\  |  \\ |  |                      \s
                 \\   \\/   /  |  |    |  |     |  |  |  | |   \\|  |                      \s
                  \\_    _/   |  |    |  |     |  |  |  | |  . `  |                      \s
                    |  |     |  |    |  `----.|  `--'  | |  |\\   |                      \s
                    |__|     |__|    |_______| \\______/  |__| \\__|                      \s
                
                .___  ___.      ___       __    __                                      \s
                |   \\/   |     /   \\     |  |  |  |                                     \s
                |  \\  /  |    /  ^  \\    |  |__|  |                                     \s
                |  |\\/|  |   /  /_\\  \\   |   __   |                                     \s
                |  |  |  |  /  _____  \\  |  |  |  |                                     \s
                |__|  |__| /__/     \\__\\ |__|  |__|                                     \s
                """;
        System.out.println(logo);
        System.out.println("What can I do for you?");
        System.out.println("type 'help' for list of commands");
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
        System.out.println("bye, ends session w me, hope to see you soon :<");
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
