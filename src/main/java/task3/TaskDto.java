package task3;

import lombok.Data;
import task2.Task;
import task2.TaskType;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class TaskDto {

    private  int id;

    private  String title;

    private TaskType type;

    private  LocalDate createdOn;

    private Set<String> tags = new HashSet<>();

    public TaskDto(Task task) {
        setId(task.getId());
        setTitle(task.getTitle());
        setType(task.getType());
        setCreatedOn(task.getCreatedOn());
        setTags(task.getTags());
    }

    public static void converting(List<Task> tasks){
        tasks.stream().
                map(s -> new TaskDto(s)).
                forEach(System.out::println);
    }
}

