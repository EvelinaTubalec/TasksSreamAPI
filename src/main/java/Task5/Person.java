package Task5;

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
        this.skills = Arrays.asList(skills); }

    public static void findBestMatchingPerson(List<Person> persons, Skill... skills) {
        Map<String, String> result = new HashMap<>();
        for (Skill s : skills) {
            String name = s.getName();
            for (Person p : persons) {
                List<Skill> personSkills = p.getSkills();
                for (Skill skill : personSkills) {
                    if (skill.getName().equals(name) && skill.getKnownPercentage() > 50) {
                        result.put(name, p.getName());
                    }else  if (skill.getName().equals(name)) {
                        //[username=knownPercentage] use for specific skill
                        Map<String, Long> allPercentageOfSkill = new HashMap<>();
                        allPercentageOfSkill.put(p.getName(), skill.getKnownPercentage());
                        Map.Entry<String, Long> stringLongEntry = allPercentageOfSkill.entrySet().stream().max(Map.Entry.comparingByValue()).get();
                        result.put(name, stringLongEntry.getKey());
                    }
                }
            }
        }
        System.out.println(result);
    }
}