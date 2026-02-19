import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import err.ExceptionManager;
import err.YilonmahExceptions;
import print.Printer;
import saves.Read;
import saves.Write;
import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

public class Yilonmah {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = "";
        ArrayList<Task> list = new ArrayList<>();
        Printer.opening();
        try {
            System.out.println("tryinggg to rememberr");
            list = Read.initList();
            System.out.println("I REMEMBER EVERYTHINGG");
        } catch (FileNotFoundException e) {
            System.out.println("file save not found, making a brand new save");
        }
        Printer.dash();
        while (!line.equals("bye")) {
            line = in.nextLine();
            try {
                if (line.equals("")) {
                    throw new YilonmahExceptions.NoCommand();
                } else if (line.equals("bye")) {
                    System.out.println("Bai Baiii");
                } else if (line.equals("list")) {
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i).printTask());
                    }
                    Printer.dash();
                } else if (line.length() >= 7 && line.startsWith("unmark")) {
                    int unmarkIdx = Integer.parseInt(line.substring(7));
                    if (unmarkIdx > list.size() + 1) {
                        throw new YilonmahExceptions.OutOfBounds();
                    } else {
                        list.get(unmarkIdx - 1).unmark();
                        for (int i = 0; i < list.size(); i++) {
                            try {
                                Write.writeToFile(list.get(unmarkIdx - 1).printTask());
                            } catch (IOException e) {
                                System.out.println("ruh roh riting idnt rork");
                            }
                        }
                        Printer.dash();
                    }
                } else if (line.length() > 5 && line.startsWith("mark")) {
                    int markIdx = Integer.parseInt(line.substring(5));
                    if (markIdx > list.size() + 1) {
                        throw new YilonmahExceptions.OutOfBounds();
                    } else {
                        list.get(markIdx - 1).mark();
                        for (int i = 0; i < list.size(); i++) {
                            try {
                                Write.writeToFile(list.get(markIdx - 1).printTask());
                            } catch (IOException e) {
                                System.out.println("ruh roh riting idnt rork");
                            }
                        }
                        Printer.dash();
                    }
                } else if (line.length() > 5 && line.startsWith("todo")) {
                    String desc = line.substring(5);
                    list.add(new Todo(desc));
                    Printer.taskAdded();
                    System.out.println(list.get(list.size() - 1).printTask());
                    Printer.listCount(list.size());
                    try {
                        int listSize = list.size();
                        Write.appendToFile(list.get(listSize - 1).printTask());
                    } catch (IOException e) {
                        System.out.println("ruh roh someing idnt rork");
                    }
                    Printer.dash();
                } else if (line.length() > 8 && line.startsWith("deadline")) {
                    String desc = line.substring(9);
                    int separator = desc.indexOf("/");
                    String name = desc.substring(0, separator - 1);
                    String date = desc.substring(separator + 4);
                    list.add(new Deadline(name, date));
                    Printer.taskAdded();
                    System.out.println(list.get(list.size() - 1).printTask());
                    Printer.listCount(list.size());
                    try {
                        int listSize = list.size();
                        Write.appendToFile(list.get(listSize - 1).printTask());
                    } catch (IOException e) {
                        System.out.println("ruh roh someing idnt rork");
                    }
                    Printer.dash();
                } else if (line.length() > 6 && line.startsWith("event")) {
                    String desc = line.substring(6);
                    int separator1 = desc.indexOf("/");
                    int separator2 = desc.indexOf("/", separator1 + 1);
                    String name = desc.substring(0, separator1 - 1);
                    String from = desc.substring(separator1 + 6, separator2 - 1);
                    String by = desc.substring(separator2 + 4);
                    list.add(new Event(name, from, by));
                    Printer.taskAdded();
                    System.out.println(list.get(list.size() - 1).printTask());
                    try {
                        int listSize = list.size();
                        Write.appendToFile(list.get(listSize - 1).printTask());
                    } catch (IOException e) {
                        System.out.println("ruh roh someing idnt rork");
                    }
                    Printer.dash();
                } else {
                    throw new YilonmahExceptions.WrongCommand();
                }
            } catch (YilonmahExceptions e) {
                ExceptionManager.handleException(e);
            }
        }
    }
}
