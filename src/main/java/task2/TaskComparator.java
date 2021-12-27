package task2;

import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {
    public int compare(Task t, Task t1) {
        return t.getCreatedOn().compareTo(t1.getCreatedOn());
    }
}
