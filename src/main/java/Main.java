import task1.Student;
import task1.Subject;
import task2.Task;
import task2.TaskType;
import task3.TaskDto;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //task 1
        //create types of subject
        Subject math = new Subject("Math");
        Subject english = new Subject("English");
        Subject informatics = new Subject("Informatics");

        //create information about students
        Student student = new Student("Ivan");
        Map<Subject, Integer> ratingOfIvan = student.getRating();
        ratingOfIvan.put(math, 9);
        ratingOfIvan.put(english, 8);
        ratingOfIvan.put(informatics, 6);

        Student student1 = new Student("Petr");
        Map<Subject, Integer> ratingOfPetr = student1.getRating();
        ratingOfPetr.put(math, 7);
        ratingOfPetr.put(english, 4);
        ratingOfPetr.put(informatics, 5);

        Student student2 = new Student("Oleg");
        Map<Subject, Integer> ratingOfOleg = student2.getRating();
        ratingOfOleg.put(math, 6);
        ratingOfOleg.put(english, 7);
        ratingOfOleg.put(informatics, 9);

        //List of all students
        List<Student> studentList = Stream.of(student, student1, student2).collect(Collectors.toList());

        Subject.currentSubjectRating(studentList, math);
        Subject.currentSubjectRating(studentList, english);
        Subject.currentSubjectRating(studentList, informatics);

        //task 2
        Task task1 = new Task(1, "Read Version Control with Git book", TaskType.READING, LocalDate.of(2015, Month.JULY, 1));
        Task task2 = new Task(2, "Read Java 8 Lambdas book", TaskType.READING, LocalDate.of(2015, Month.JULY, 2));
        Task task3 = new Task(3, "Write a mobile application to store my tasks", TaskType.CODING, LocalDate.of(2015, Month.JULY, 3));
        Task task4 = new Task(4, "Write a blog on Java 8 Streams", TaskType.WRITING, LocalDate.of(2015, Month.JULY, 4));
        Task task5 = new Task(5, "Read Domain Driven Design book", TaskType.READING, LocalDate.of(2015, Month.JULY, 5));

        List<Task> tasks = Stream.of(task1, task2, task3, task4, task5).collect(Collectors.toList());
        Task.collect(tasks);

        //task 3
        TaskDto.converting(tasks);
    }
}
