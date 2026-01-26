import java.util.Scanner;

public class Yilonmah {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = "";
        String[] list = new String[100];
        int listIdx = 0;

        String logo = "YiLonMah";
        System.out.println("Hello! I'm " + logo);
        System.out.println("What can I do for you?");

        while (!line.equals("bye")) {
            line = in.nextLine();
            if (!line.equals("bye")) {
                if (!line.equals("list")) {
                    System.out.println("added: " + line);
                    list[listIdx] = line;
                    listIdx++;
                } else {
                    for (int i = 0; i < listIdx; i++) {
                        int j = i + 1;
                        System.out.println(j + ". " + list[i]);
                    }
                }
            } else {
                System.out.println("Bai Baiii");
            }
        }
    }
}
