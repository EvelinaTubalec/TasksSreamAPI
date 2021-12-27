package task1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Student {

    private Map<Subject, Integer> rating;

    private String name;

    public Student(String name){
        rating = new HashMap<>();
        this.name = name;
    }
}
