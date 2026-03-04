package Yilonmah.TaskList;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    public Todo(String description, boolean isDone) {
        super(description, isDone);
    }

    /**
     * overrides the printTask function of Task to print out type as well
     */
    @Override
    public String printTask() {
        if (this.getIsDone()) {
            return ("[T][X] " + this.getName());
        }
        return ("[T][ ] " + this.getName());
    }
}
