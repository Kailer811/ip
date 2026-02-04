import java.util.Scanner;

public class Yilonmah {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = "";
        Task[] list = new Task[100];
        int listIdx = 0;

        Printer.dash();
        String logo = "YiLonMah";
        System.out.println("Hello! I'm " + logo);
        System.out.println("What can I do for you?");
        Printer.dash();

        while (!line.equals("bye")) {
            line = in.nextLine();
            if (line.equals("bye")) {
                System.out.println("Bai Baiii");
            } else if (line.equals("list")) {
                for (int i = 0; i < listIdx; i++) {
                    int j = i + 1;
                    System.out.print(j + ".");
                    list[i].printTask();
                }
                Printer.dash();
            } else if (line.length() > 7 && line.substring(0, 6).equals("unmark")) {
                int unmarkIdx = Integer.parseInt(line.substring(7));
                if (unmarkIdx > listIdx + 1) {
                    System.out.println("we dont even have that task fam");
                    Printer.dash();
                } else {
                    list[unmarkIdx - 1].unmark();
                    Printer.dash();
                }
            } else if (line.length() > 5 && line.substring(0, 4).equals("mark")) {
                int markIdx = Integer.parseInt(line.substring(5));
                if (markIdx > listIdx + 1) {
                    System.out.println("we dont even have that task fam");
                    Printer.dash();
                } else {
                    list[markIdx - 1].mark();
                    Printer.dash();
                }
            } else if (line.length() > 5 && line.substring(0, 4).equals("todo")) {
                String desc = line.substring(5);
                list[listIdx] = new Todo(desc);
                Printer.taskAdded();
                list[listIdx].printTask();
                listIdx++;
                Printer.listCount(listIdx);
                Printer.dash();

            } else if (line.length() > 8 && line.substring(0, 8).equals("deadline")) {
                String desc = line.substring(9);
                int separator = desc.indexOf("/");
                String name = desc.substring(0, separator - 1);
                String date = desc.substring(separator + 4);
                list[listIdx] = new Deadline(name, date);
                Printer.taskAdded();
                list[listIdx].printTask();
                listIdx++;
                Printer.listCount(listIdx);
                Printer.dash();
            } else if (line.length() > 6 && line.substring(0, 5).equals("event")) {
                String desc = line.substring(6);
                int separator1 = desc.indexOf("/");
                int separator2 = desc.indexOf("/", separator1 + 1);
                String name = desc.substring(0, separator1 - 1);
                String from = desc.substring(separator1 + 6, separator2 - 1);
                String by = desc.substring(separator2 + 4);
                list[listIdx] = new Event(name, from, by);
                Printer.taskAdded();
                list[listIdx].printTask();
                listIdx++;
                Printer.listCount(listIdx);
                Printer.dash();
            } else {
                System.out.println("idk watchu sayin fam.");
                System.out.println("wat is: " + line);
                Printer.dash();
            }
        }
    }
}
