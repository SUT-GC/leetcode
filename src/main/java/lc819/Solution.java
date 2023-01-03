package lc819;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        return Arrays.stream(paragraph.toLowerCase()
                        .replaceAll(",", " ")
                        .replaceAll("\\.", " ")
                        .replaceAll("!", "")
                        .replaceAll("\\?", " ")
                        .replaceAll(";", " ")
                        .replaceAll("'", " ")
                        .split(" "))
                .filter(word -> !Arrays.stream(banned).collect(Collectors.toSet()).contains(word))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(o -> o.getValue().size()))
                .map(Entry::getKey)
                .orElse("");
    }
}
