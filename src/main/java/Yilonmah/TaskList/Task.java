package Yilonmah.TaskList;

import Yilonmah.Print.Printer;

public class Task {
    private String name;
    private boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public Task(String name, boolean isDone) {
        this.name = name;
        this.isDone = isDone;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsDone() {
        return this.isDone;
    }

    public void mark() {
        this.isDone = true;
        System.out.println("Okk marked as done, very naisu");
        this.printTask();
        Printer.dash();
    }

    public void unmark() {
        this.isDone = false;
        System.out.println("Okk marked as not done, when u gonna do it tho...");
        this.printTask();
        Printer.dash();
    }

    public String printTask() {
        if (this.getIsDone()) {
            return ("[X] " + this.name);
        }
        return ("[ ] " + this.name);
    }
}
