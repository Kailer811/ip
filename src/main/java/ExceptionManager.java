
public class ExceptionManager {
	public static void handleException(YilonmahExceptions e) {
		Printer.dash();
		if (e instanceof NoCommand) {
			System.out.println("ayyo you didn't tell me anything fam");
		} else if (e instanceof WrongCommand) {
			System.out.println("ayyo idk what this command is fam");
		}
		Printer.dash();
	}
}
