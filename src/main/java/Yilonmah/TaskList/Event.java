package Yilonmah.TaskList;

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
	public String printTask() {
		if (this.getIsDone()) {
			String out = ("[E][X] " + this.getName());
			out += (" (from: " + this.getFrom());
			out += (" to: " + this.getBy() + ")");
			return out;
		}
		String out = ("[E][ ] " + this.getName());
		out += (" (from: " + this.getFrom());
		out += (" to: " + this.getBy() + ")");
		return out;
	}
}
