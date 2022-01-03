package task4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Task4 {

    public static void getResult(String s){
        String[] splitS = s.split("");
        IntStream chars = s.chars();
        System.out.println(Arrays.stream(splitS).
                collect(groupingBy(t -> t, counting())).
                entrySet().
                stream().
                max(Map.Entry.comparingByValue()).
                get());
    }
}
