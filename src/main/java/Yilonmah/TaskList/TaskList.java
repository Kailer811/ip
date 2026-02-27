package Yilonmah.TaskList;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> load) {
        tasks = load;
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public void delete(int taskIdx) {
        tasks.remove(taskIdx);
    }

    public void list() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i).printTask());
        }
    }
    public int size() {
        return tasks.size();
    }

    public Task get(int Idx) {
        return tasks.get(Idx);
    }
}
