import java.util.Scanner;

public class Yilonmah {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = "";

        String logo = "YiLonMah";
        System.out.println("Hello! I'm " + logo);
        System.out.println("What can I do for you?");

        while (!line.equals("bye")) {
            line = in.nextLine();
            if (!line.equals("bye")) {
                System.out.println(line);
            } else {
                System.out.println("Bai Baiii");
            }
        }
    }
}
