import java.util.Scanner;

public class Yilonmah {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = "";
        Task[] list = new Task[100];
        int listIdx = 0;

        String logo = "YiLonMah";
        System.out.println("Hello! I'm " + logo);
        System.out.println("What can I do for you?");

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
            } else if (line.substring(0, 5).equals("unmark")) {
                int unmarkIdx = Integer.parseInt(line.substring(7));
                if (unmarkIdx > listIdx + 1) {
                    System.out.println("we dont even have that task fam");
                } else {
                    list[unmarkIdx - 1].unmark();
                }
            } else if (line.substring(0, 3).equals("mark")) {
                int markIdx = Integer.parseInt(line.substring(5));
                if (markIdx > listIdx + 1) {
                    System.out.println("we dont even have that task fam");
                } else {
                    list[markIdx - 1].mark();
                }
            } else if (line.substring(0, 3).equals("todo")) {
                String desc = line.substring(5);
                list[listIdx] = new Todo(desc);
                listIdx++;
            } else if (line.substring(0, 7).equals("deadline")) {
                String desc = line.substring(7);
                int separator = desc.indexOf("/");
                String name = desc.substring(0, separator - 2);
                String date = desc.substring(separator + 4);
                list[listIdx] = new Deadline(name, date);
                listIdx++;
            } else if (line.substring(0, 4).equals("event")) {
                String desc = line.substring(6);
                int separator1 = desc.indexOf("/");
                int separator2 = desc.indexOf("/", separator1 + 1);
                String name = desc.substring(0, separator1 - 2);
                String from = desc.substring(separator1 + 6, separator2 - 2);
                String by = desc.substring(separator2 + 4);
                list[listIdx] = new Event(name, from, by);
                listIdx++;
            }
        }
    }
}
