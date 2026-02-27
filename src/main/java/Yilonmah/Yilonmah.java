package Yilonmah;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Yilonmah.Parser.Parser;
import Yilonmah.TaskList.*;
import Yilonmah.err.ExceptionManager;
import Yilonmah.err.YilonmahExceptions;
import Yilonmah.Print.Printer;
import Yilonmah.Storage.Storage;
import Yilonmah.Storage.Write;

public class Yilonmah {
    private Storage storage;
    private TaskList tasks;

    public Yilonmah(String filepath) {
        storage = new Storage(filepath);
        try {
            tasks = new TaskList(storage.load());
        } catch (FileNotFoundException e) {
            System.out.println("file save not found, making a brand new save");
            tasks = new TaskList();
        }
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        String line = "";
        Printer.opening();
        while (!line.equals("bye")) {
            line = in.nextLine();
            try {
                if (line.isEmpty()) {
                    throw new YilonmahExceptions.NoCommand();
                } else if (line.equals("bye")) {
                    System.out.println("Bai Baiii");
                } else if (line.equals("list")) {
                    Parser.list(tasks);
                } else if (line.length() >= 7 && line.startsWith("unmark")) {
                    Parser.unmark(tasks, line);
                } else if (line.length() > 5 && line.startsWith("mark")) {
                    Parser.mark(tasks, line);
                } else if (line.length() > 7 && line.startsWith("delete")) {
                    Parser.mark(tasks, line);
                } else if (line.length() > 5 && line.startsWith("todo")) {
                    Parser.todo(tasks, line);
                } else if (line.length() > 8 && line.startsWith("deadline")) {
                    Parser.deadline(tasks, line);
                } else if (line.length() > 6 && line.startsWith("event")) {
                    Parser.event(tasks, line);
                } else {
                    throw new YilonmahExceptions.WrongCommand();
                }
            } catch (YilonmahExceptions e) {
                ExceptionManager.handleException(e);
            }
        }
    }

    public static void main(String[] args) {
        new Yilonmah("./data/yilonmah.txt").run();
    }

}
