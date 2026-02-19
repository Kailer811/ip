public class Deadline extends Task {

    protected String by;

    public Deadline(String name, String date) {
        super(name);
        this.by = date;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public void printTask() {
        if (this.getIsDone()) {
            System.out.print("[D][X] " + this.getName());
            System.out.println(" (by: " + this.getBy() + " )");
        } else {
            System.out.print("[D][ ] " + this.getName());
            System.out.println(" (by: " + this.getBy() + ")");
        }
    }
}
