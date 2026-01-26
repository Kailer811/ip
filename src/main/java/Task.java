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

	public void toggleIsDone() {
		this.isDone = !this.isDone;
	}

	public void printTask() {
		if (this.getIsDone()) {
			System.out.println("[X] " + this.name);
		} else {
			System.out.println("[ ] " + this.name);
		}
	}
}
