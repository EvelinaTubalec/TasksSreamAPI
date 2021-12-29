package task1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Subject {

    private String subjectName;

    public static void currentSubjectRating(List<Student> studentList, Subject subject){
        System.out.println(studentList.stream().
                mapToInt(s -> s.getRating().get(subject)).
                average().
                orElse(0));
    }
}
