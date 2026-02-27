package Yilonmah.Print;

public class Printer {
	public static void dash() {
		System.out.println("----------------------------------------------------");
	}

	public static void taskAdded() {
		System.out.println("Alrightt task has been added :>");
	}

	public static void listCount(int count) {
		System.out.println("You now have " + count + " tasks, upz lah");
	}

	public static void opening() {
		Printer.dash();
		String logo = "YiLonMah";
		System.out.println("Hello! I'm " + logo);
		System.out.println("What can I do for you?");
		Printer.dash();
	}
	public static void loadingSave() {
		System.out.println("tryinggg to rememberr");
	}

	public static void saveLoaded() {
		System.out.println("I REMEMBER EVERYTHINGG");
	}
}
