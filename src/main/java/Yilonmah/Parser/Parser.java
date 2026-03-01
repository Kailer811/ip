package Yilonmah.Parser;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Yilonmah.Print.Printer;
import Yilonmah.Storage.Write;
import Yilonmah.TaskList.Deadline;
import Yilonmah.TaskList.Event;
import Yilonmah.TaskList.TaskList;
import Yilonmah.TaskList.Todo;
import Yilonmah.err.YilonmahExceptions;

public class Parser {

    private static String dateFormat(String input) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        String formattedDate = input;

        try {
            LocalDate date = LocalDate.parse(input, inputFormatter);
            formattedDate = date.format(outputFormatter);
        } catch (Exception e) {
            Printer.dash();
            System.out.println("wrong date format fam, pls use yyyy-MM-dd for my smooth brain tks");
            Printer.dash();
        }
        return formattedDate;
    }

    public static void todo(TaskList tasks, String line) throws YilonmahExceptions.MissingDescription {
        if (line.length() < 6) {
            throw new YilonmahExceptions.MissingDescription();
        }
        String desc = line.substring(5);
        tasks.add(new Todo(desc));
        Printer.taskAdded();
        System.out.println(tasks.get(tasks.size() - 1).printTask());
        Printer.taskCount(tasks.size());
        try {
            int listSize = tasks.size();
            Write.appendToFile(tasks.get(listSize - 1).printTask());
        } catch (IOException e) {
            System.out.println("ruh roh someing idnt rork");
        }
        Printer.dash();
    }

    public static void event(TaskList tasks, String line) throws YilonmahExceptions.MissingDescription {
        if (line.length() < 7) {
            throw new YilonmahExceptions.MissingDescription();
        }
        String desc = line.substring(6);
        int separator1 = desc.indexOf("/");
        if (separator1 == -1) {
        }
        int separator2 = desc.indexOf("/", separator1 + 1);
        String name = desc.substring(0, separator1 - 1);
        String from = desc.substring(separator1 + 6, separator2 - 1);
        from = dateFormat(from);
        String by = desc.substring(separator2 + 4);
        by = dateFormat(by);
        tasks.add(new Event(name, from, by));
        Printer.taskAdded();
        System.out.println(tasks.get(tasks.size() - 1).printTask());
        try {
            int listSize = tasks.size();
            Write.appendToFile(tasks.get(listSize - 1).printTask());
        } catch (IOException e) {
            System.out.println("ruh roh someing idnt rork");
        }
        Printer.dash();
    }

    public static void deadline(TaskList tasks, String line) throws YilonmahExceptions.MissingDescription {
        if (line.length() < 10) {
            throw new YilonmahExceptions.MissingDescription();
        }
        String desc = line.substring(9);
        int separator = desc.indexOf("/");
        String name = desc.substring(0, separator - 1);
        String date = desc.substring(separator + 4);
        date = dateFormat(date);
        tasks.add(new Deadline(name, date));
        Printer.taskAdded();
        System.out.println(tasks.get(tasks.size() - 1).printTask());
        Printer.taskCount(tasks.size());
        try {
            int listSize = tasks.size();
            Write.appendToFile(tasks.get(listSize - 1).printTask());
        } catch (IOException e) {
            System.out.println("ruh roh someing idnt rork");
        }
        Printer.dash();
    }

    public static void list(TaskList tasks) {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i).printTask());
        }
        Printer.dash();
    }

    public static void mark(TaskList tasks, String line) throws YilonmahExceptions.OutOfBounds, YilonmahExceptions.MissingDescription {
        if (line.length() < 6) {
            throw new YilonmahExceptions.MissingDescription();
        }
        int markIdx = Integer.parseInt(line.substring(5));
        if (markIdx > tasks.size() + 1) {
            throw new YilonmahExceptions.OutOfBounds();
        } else {
            tasks.get(markIdx - 1).mark();
            for (int i = 0; i < tasks.size(); i++) {
                try {
                    Write.writeToFile(tasks.get(markIdx - 1).printTask());
                } catch (IOException e) {
                    System.out.println("ruh roh riting idnt rork");
                }
            }
            Printer.dash();
        }
    }

    public static void unmark(TaskList tasks, String line) throws YilonmahExceptions.OutOfBounds, YilonmahExceptions.MissingDescription {
        if (line.length() < 8) {
            throw new YilonmahExceptions.MissingDescription();
        }
        int unmarkIdx = Integer.parseInt(line.substring(7));
        if (unmarkIdx > tasks.size() + 1) {
            throw new YilonmahExceptions.OutOfBounds();
        } else {
            tasks.get(unmarkIdx - 1).unmark();
            for (int i = 0; i < tasks.size(); i++) {
                try {
                    Write.writeToFile(tasks.get(unmarkIdx - 1).printTask());
                } catch (IOException e) {
                    System.out.println("ruh roh riting idnt rork");
                }
            }
            Printer.dash();
        }
    }

    public static void delete(TaskList tasks, String line) throws YilonmahExceptions.OutOfBounds, YilonmahExceptions.MissingDescription {
        if (line.length() < 8) {
            throw new YilonmahExceptions.MissingDescription();
        }
        String delete = line.substring(7);
        System.out.println(delete);
        int deleteIdx = Integer.parseInt(line.substring(7));
        if (deleteIdx > tasks.size() + 1) {
            throw new YilonmahExceptions.OutOfBounds();
        } else {
            System.out.print("alrightyy deleting: ");
            System.out.println(tasks.get(deleteIdx - 1).printTask());
            tasks.delete(deleteIdx - 1); //INCLUDE
        }
        Printer.dash();
    }
}
