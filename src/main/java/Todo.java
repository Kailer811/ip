public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public void printTask() {
        if (this.getIsDone()) {
            System.out.println("[T][X] " + this.getName());
        } else {
            System.out.println("[T][ ] " + this.getName());
        }
    }
}
