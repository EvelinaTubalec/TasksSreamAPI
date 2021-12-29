package task5;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Person {
    private Long personId;

    private String name;

    private List<Skill> skills;

    public Person(Long personId, String name, Skill... skills) {
        this.personId = personId;
        this.name = name;
        this.skills = Arrays.asList(skills);
    }

    public static void findBestMatchingPerson(List<Person> persons, Skill... skills) {
        Map<String, String> result = new HashMap<>();
        Map<String, Long> allPercentageOfSkill = new HashMap<>();

        Arrays.stream(skills).map(Skill::getName).forEach(name -> {
            persons.forEach(p -> {
                List<Skill> personSkills = p.getSkills();
                personSkills.stream().filter(skill -> skill.getName().equals(name)).forEach(skill -> {
                    allPercentageOfSkill.put(p.getName(), skill.getKnownPercentage());
                    Map.Entry<String, Long> stringLongEntry = allPercentageOfSkill.entrySet().stream().max(Map.Entry.comparingByValue()).get();
                    result.put(name, stringLongEntry.getKey());
                });
            });
        });
        System.out.println(result);
    }
}