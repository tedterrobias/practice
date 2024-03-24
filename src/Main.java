import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        List<String> input = new ArrayList<>();
        input.add("");
        input.add(" annie   ");
        input.add("MayA");
        input.add("ted");
        input.add(null);
        System.out.println("Hello world!");

        List<String> result = formatDedupSort(input);

        result.forEach(System.out::print);
    }

    public static List<String> formatDedupSort(final List<String> input) {
        List<String> temp = input.stream()
                .filter(s -> s != null && !s.isEmpty())
                .map(s -> {
                    s = s.trim();
                    s = s.toLowerCase();
                    s = Character.toUpperCase(s.charAt(0)) +
                            s.substring(1);
                    return s;
                })
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        // List<String> result = temp.stream().toList();

        return temp;
    }
}