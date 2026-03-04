package Yilonmah.TaskList;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
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
