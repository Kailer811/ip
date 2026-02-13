package err;

public class YilonmahExceptions extends Exception {
	public static class NoCommand extends YilonmahExceptions {
		public NoCommand() {
		}
	}

	public static class WrongCommand extends YilonmahExceptions {
		public WrongCommand() {
		}
	}

	public static class OutOfBounds extends YilonmahExceptions {
		public OutOfBounds() {
		}
	}
}
