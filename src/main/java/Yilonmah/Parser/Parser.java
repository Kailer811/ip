package Yilonmah.Parser;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Yilonmah.Print.Printer;
import Yilonmah.Storage.Storage;
import Yilonmah.TaskList.Deadline;
import Yilonmah.TaskList.Event;
import Yilonmah.TaskList.Task;
import Yilonmah.TaskList.TaskList;
import Yilonmah.TaskList.Todo;
import Yilonmah.err.YilonmahExceptions;

/**
 * contains all the command functions that the user will use, throws exception when command is incorrect format or
 * outOfBounds
 */

public class Parser {
    /**
     * converts any dates from yyyy-MM-dd to MMM dd yyyy
     * checks if format is correct if input format is not correct it just returns the inputted string
     *
     * @param input string in the format of yyyy-MM-dd
     * @return dateformat string in the format of MMM dd yyyy
     */
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

    /**
     * finds the description of todo from line
     * adds it to tail end of tasks
     *
     * @param tasks the TaskList that yilonmah reads from
     * @param line  input string containing the todo description
     * @throws YilonmahExceptions.MissingDescription thrown when user inputs todo without anything
     */
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
            Storage.appendToFile(tasks.get(listSize - 1).printTask());
        } catch (IOException e) {
            System.out.println("ruh roh someing idnt rork");
        }
        Printer.dash();
    }

    /**
     * finds the description and date range of event from line
     * adds it to tail end of tasks
     *
     * @param tasks the TaskList that yilonmah reads from
     * @param line  input string containing the event description and date range
     * @throws YilonmahExceptions.MissingDescription thrown when user inputs event without anything else
     */
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
            Storage.appendToFile(tasks.get(listSize - 1).printTask());
        } catch (IOException e) {
            System.out.println("ruh roh someing idnt rork");
        }
        Printer.dash();
    }

    /**
     * finds the description and due date of deadline from line
     * adds it to tail end of tasks
     *
     * @param tasks the TaskList that yilonmah reads from
     * @param line  input string containing the deadline description and due date
     * @throws YilonmahExceptions.MissingDescription thrown when user inputs event without anything else
     */
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
            Storage.appendToFile(tasks.get(listSize - 1).printTask());
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

    /**
     * checks which task is to be marked, and updates tasks
     *
     * @param tasks the TaskList that yilonmah reads from
     * @param line  contains which task to be marked as done
     * @throws YilonmahExceptions.OutOfBounds        if marked task is less or more than the taskslist err is thrown
     * @throws YilonmahExceptions.MissingDescription thrown when user inputs event without anything else
     */
    public static void mark(TaskList tasks, String line) throws YilonmahExceptions.OutOfBounds, YilonmahExceptions.MissingDescription {
        if (line.length() < 6) {
            throw new YilonmahExceptions.MissingDescription();
        }
        try {
            int markIdx = Integer.parseInt(line.substring(5));
            if (markIdx > tasks.size()) {
                throw new YilonmahExceptions.OutOfBounds();
            } else {
                tasks.get(markIdx - 1).mark();
                try {
                    Storage.save(tasks);
                } catch (Exception e) {
                    System.out.println("ruh roh riting idnt rork");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("ayyo mb fam input which task number uw me to mark");
        }
    }

    /**
     * checks which task is to be unmarked, and updates tasks
     *
     * @param tasks the TaskList that yilonmah reads from
     * @param line  contains which task to be unmarked as not done
     * @throws YilonmahExceptions.OutOfBounds        if unmarked task is less or more than the taskslist err is thrown
     * @throws YilonmahExceptions.MissingDescription thrown when user inputs event without anything else
     */
    public static void unmark(TaskList tasks, String line) throws YilonmahExceptions.OutOfBounds, YilonmahExceptions.MissingDescription {
        if (line.length() < 8) {
            throw new YilonmahExceptions.MissingDescription();
        }
        try {
            int unmarkIdx = Integer.parseInt(line.substring(7));
            if (unmarkIdx > tasks.size()) {
                throw new YilonmahExceptions.OutOfBounds();
            } else {
                tasks.get(unmarkIdx - 1).unmark();
                try {
                    Storage.save(tasks);
                } catch (Exception e) {
                    System.out.println("ruh roh riting idnt rork");
                }
            }
            Printer.dash();
        } catch (NumberFormatException e) {
            System.out.println("ayyo mb fam input which task number uw me to unmark");
        }
    }

    /**
     * checks which task is to be deleted, and removes it from tasks
     *
     * @param tasks the TaskList that yilonmah reads from
     * @param line  contains which task to be deleted
     * @throws YilonmahExceptions.OutOfBounds        if deleted task is less or more than the taskslist err is thrown
     * @throws YilonmahExceptions.MissingDescription thrown when user inputs event without anything else
     */
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
            try {
                Storage.save(tasks);
            } catch (Exception e) {
                System.out.println("ruh roh riting idnt rork");
            }
        }
        Printer.dash();
    }

    /**
     * sweeps through task list and finds any task description that contains the findFor
     * if found, task is printed
     * else notifies user no task was found
     *
     * @param tasks the list of tasks yilonmah remembers
     * @param line  contains "find NAME" where NAME is task we are searching for
     * @throws YilonmahExceptions.MissingDescription
     */
    public static void find(TaskList tasks, String line) throws YilonmahExceptions.MissingDescription {
        if (line.length() < 6) {
            throw new YilonmahExceptions.MissingDescription();
        }
        String findFor = line.substring(5);
        boolean isFound = false;
        for (int i = 0; i < tasks.size(); i++) {
            Task curr = tasks.get(i);
            if (curr.getName().contains(findFor)) {
                System.out.println(curr.printTask());
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("no tasks were found containing: " + line);
        }
        Printer.dash();
    }

    public static void help() {
        Printer.help();
    }
}
