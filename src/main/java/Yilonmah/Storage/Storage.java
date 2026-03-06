package Yilonmah.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Yilonmah.TaskList.*;
import Yilonmah.err.YilonmahExceptions;
import Yilonmah.err.ExceptionManager;

/**
 * Handles loading and saving of TaskList. Contents are written to ./data/yilonmah.txt
 * With assumption that code is launched from /ip dir
 */
public class Storage {
    private static String filepath = "./data/yilonmah.txt";

    /**
     * checks if file yilonmah.txt exist in ./data. If it does not, create one
     * It then reads each line of the text file checks the task type, desc, date, marked or unmarked and adds it to the array list
     * Once the whole file is read it return the ArrayList with each task listed
     *
     * @return ArrayList<Task>
     * @throws FileNotFoundException if file is not found
     */
    public ArrayList<Task> load() throws FileNotFoundException {
        File f = new File(filepath);
        if (!f.exists()) {
            try {
                f.getParentFile().mkdirs();
                if (f.createNewFile()) {
                    System.out.println("no save file found making one now");
                    System.out.println("new save file has been made");
                }
            } catch (IOException e) {
                System.out.println("error occurred when making file");
            }
        }
        Scanner s = new Scanner(f);
        ArrayList<Task> list = new ArrayList<>();
        Boolean isDone = false;
        while (s.hasNext()) {
            String line = s.nextLine();
            char c = line.charAt(1);
            try {
                switch (c) {
                case 'T':
                    String desc = line.substring(7);
                    isDone = checkIsDone(line);
                    list.add(new Todo(desc, isDone));
                    break;
                case 'D':
                    desc = line.substring(7);
                    int separator = desc.indexOf(":");
                    String name = desc.substring(0, separator - 4);
                    String date = desc.substring(separator + 2, desc.length() - 1);
                    isDone = checkIsDone(line);
                    list.add(new Deadline(name, date, isDone));
                    break;
                case 'E':
                    desc = line.substring(7);
                    int separator1 = desc.indexOf(":");
                    int separator2 = desc.indexOf(":", separator1 + 1);
                    name = desc.substring(0, separator1 - 6);
                    String from = desc.substring(separator1 + 2, separator2 - 3);
                    String by = desc.substring(separator2 + 2, desc.length() - 1);
                    isDone = checkIsDone(line);
                    list.add(new Event(name, from, by, isDone));
                    break;
                default:
                    throw new YilonmahExceptions.FileCorrupted();
                }
            } catch (YilonmahExceptions e) {
                ExceptionManager.handleException(e);
            }
        }
        return list;
    }

    private Boolean checkIsDone(String line) {
        char isDone = line.charAt(4);
        return isDone == 'X';
    }

    public static void writeToFile(String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filepath);
        fw.write(textToAdd);
        fw.close();
    }

    public static void appendToFile(String textToAppend) throws IOException {
        FileWriter fw = new FileWriter(filepath, true);
        fw.write(textToAppend);
        fw.write("\n");
        fw.close();
    }

    /**
     * rewrites the entire .txt file to the latest TaskList
     *
     * @param tasks the task list that yilonmah reads from
     * @throws IOException if file unable to be written into
     */
    public static void save(TaskList tasks) throws IOException {
        writeToFile("");
        for (int i = 0; i < tasks.size(); i++) {
            appendToFile(tasks.get(i).printTask());
        }
    }
}
