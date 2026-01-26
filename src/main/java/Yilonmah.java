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
            switch (line) {
            case "bye":
                System.out.println("Bai Baiii");
                break;
            case "list":
                for (int i = 0; i < listIdx; i++) {
                    int j = i + 1;
                    System.out.print(j + ".");
                    list[i].printTask();
                }
                break;
            default:
                if (line.contains("unmark")) {
                    int unmarkIdx = Integer.parseInt(line.substring(7));
                    if (unmarkIdx > listIdx + 1) {
                        System.out.println("we dont even have that task fam");
                    } else {
                        list[unmarkIdx - 1].unmark();
                    }
                } else if (line.contains("mark")) {
                    int markIdx = Integer.parseInt(line.substring(7));
                    if (markIdx > listIdx + 1) {
                        System.out.println("we dont even have that task fam");
                    } else {
                        list[markIdx - 1].mark();
                    }
                } else {
                    System.out.println("added: " + line);
                    list[listIdx] = new Task(line);
                    listIdx++;
                    break;
                }
            }
        }
    }
}
