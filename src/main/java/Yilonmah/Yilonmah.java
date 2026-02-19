import err.ExceptionManager;
import err.YilonmahExceptions;
import java.io.IOException;
import java.util.Scanner;
import print.Printer;
import saves.Write;
import task.Deadline;
import task.Event;
import task.Task;
import task.Todo;

public class Yilonmah {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = "";
        Task[] list = new Task[100];
        int taskCount = 0;
        Printer.opening();
        while (!line.equals("bye")) {
            line = in.nextLine();
            try {
                if (line.equals("")) {
                    throw new YilonmahExceptions.NoCommand();
                } else if (line.equals("bye")) {
                    System.out.println("Bai Baiii");
                } else if (line.equals("list")) {
                    for (int i = 0; i < taskCount; i++) {
                        int j = i + 1;
                        System.out.print(j + ".");
                        System.out.println(list[i].printTask());
                    }
                    Printer.dash();
                } else if (line.length() > 7 && line.startsWith("unmark")) {
                    int unmarkIdx = Integer.parseInt(line.substring(7));
                    if (unmarkIdx > taskCount + 1) {
                        throw new YilonmahExceptions.OutOfBounds();
                    } else {
                        list[unmarkIdx - 1].unmark();
                        for (int i = 0; i < taskCount; i++) {
                            try {
                                Write.writeToFile(list[i].printTask());
                            } catch (IOException e) {
                                System.out.println("ruh roh riting idnt rork");
                            }
                        }
                        Printer.dash();
                    }
                } else if (line.length() > 5 && line.startsWith("mark")) {
                    int markIdx = Integer.parseInt(line.substring(5));
                    if (markIdx > taskCount + 1) {
                        throw new YilonmahExceptions.OutOfBounds();
                    } else {
                        list[markIdx - 1].mark();
                        for (int i = 0; i < taskCount; i++) {
                            try {
                                Write.writeToFile(list[i].printTask());
                            } catch (IOException e) {
                                System.out.println("ruh roh riting idnt rork");
                            }
                        }
                        Printer.dash();
                    }
                } else if (line.length() > 5 && line.startsWith("todo")) {
                    String desc = line.substring(5);
                    list[taskCount] = new Todo(desc);
                    Printer.taskAdded();
                    System.out.println(list[taskCount].printTask());
                    try {
                        Write.appendToFile(list[taskCount].printTask());
                    } catch (IOException e) {
                        System.out.println("ruh roh someing idnt rork");
                    }
                    taskCount++;
                    Printer.listCount(taskCount);
                    Printer.dash();
                } else if (line.length() > 8 && line.startsWith("deadline")) {
                    String desc = line.substring(9);
                    int separator = desc.indexOf("/");
                    String name = desc.substring(0, separator - 1);
                    String date = desc.substring(separator + 4);
                    list[taskCount] = new Deadline(name, date);
                    Printer.taskAdded();
                    System.out.println(list[taskCount].printTask());
                    try {
                        Write.appendToFile(list[taskCount].printTask());
                    } catch (IOException e) {
                        System.out.println("ruh roh someing idnt rork");
                    }
                    taskCount++;
                    Printer.listCount(taskCount);
                    Printer.dash();
                } else if (line.length() > 6 && line.startsWith("event")) {
                    String desc = line.substring(6);
                    int separator1 = desc.indexOf("/");
                    int separator2 = desc.indexOf("/", separator1 + 1);
                    String name = desc.substring(0, separator1 - 1);
                    String from = desc.substring(separator1 + 6, separator2 - 1);
                    String by = desc.substring(separator2 + 4);
                    list[taskCount] = new Event(name, from, by);
                    Printer.taskAdded();
                    System.out.println(list[taskCount].printTask());
                    try {
                        Write.appendToFile(list[taskCount].printTask());
                    } catch (IOException e) {
                        System.out.println("ruh roh someing idnt rork");
                    }
                    taskCount++;
                    Printer.listCount(taskCount);
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
