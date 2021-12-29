package task2;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Task {

    private final int id;

    private final String title;

    private final TaskType type;

    private final LocalDate createdOn;

    private boolean done = false;

    private Set<String> tags = new HashSet<>();

    private LocalDate dueTo;

    public Task(int id, String title, TaskType type, LocalDate createdOn) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.createdOn = createdOn;
    }

    public static void collect(List<Task> tasks){
        System.out.println(tasks.stream().
                limit(3).
                sorted(new TaskComparator()).
                map(Task::getTitle).
                collect(Collectors.joining(",")));
    }
}
