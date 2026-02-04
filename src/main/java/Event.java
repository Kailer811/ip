public class Event extends Deadline {
	protected String from;

	public Event(String name, String from, String by) {
		super(name, by);
		this.from = from;
	}

	public String getFrom() {
		return this.from;
	}

	public void setFrom(String newFrom) {
		this.from = newFrom;
	}

	@Override
	public void printTask() {
		if (this.getIsDone()) {
			System.out.print("[E][X] " + this.getName());
			System.out.print(" (from: " + this.getFrom());
			System.out.println(" to: " + this.getBy() + ")");
		} else {
			System.out.print("[E][ ] " + this.getName());
			System.out.print(" (from: " + this.getFrom());
			System.out.println(" to: " + this.getBy() + ")");
		}
	}
}
