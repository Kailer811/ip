public class Task {
	private String name;
	private boolean isDone;

	public Task(String name) {
		this.name = name;
		this.isDone = false;
	}

	public String getTask() {
		return this.name;
	}

	public boolean getIsDone() {
		return this.isDone;
	}

	public void mark() {
		this.isDone = true;
		System.out.println("Okk marked as done, very naisu");
		this.printTask();
	}

	public void unmark() {
		this.isDone = false;
		System.out.println("Okk marked as not done, when u gonna do it tho...");
		this.printTask();
	}

	public void printTask() {
		if (this.getIsDone()) {
			System.out.println("[X] " + this.name);
		} else {
			System.out.println("[ ] " + this.name);
		}
	}
}
