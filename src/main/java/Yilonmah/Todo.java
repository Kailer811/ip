public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String printTask() {
        if (this.getIsDone()) {
            return ("[T][X] " + this.getName());
        }
        return ("[T][ ] " + this.getName());
    }
}
