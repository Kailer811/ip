package Yilonmah.TaskList;

public class Deadline extends Task {

    protected String by;

    public Deadline(String name, String date) {
        super(name);
        this.by = date;
    }

    public Deadline(String name, String date, Boolean isDone) {
        super(name, isDone);
        this.by = date;
    }


    public void setBy(String by) {
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    /**
     * overrides the printTask function of Task to print out type and getBy as well
     */
    @Override
    public String printTask() {
        if (this.getIsDone()) {
            String out = ("[D][X] " + this.getName());
            out += (" (by: " + this.getBy() + " )");
            return out;
        }
        String out = ("[D][ ] " + this.getName());
        out += (" (by: " + this.getBy() + ")");
        return out;
    }
}
