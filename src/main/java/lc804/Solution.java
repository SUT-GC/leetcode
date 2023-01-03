package lc804;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        return (int) Stream.of(words).map(word -> word.chars().boxed().map(c -> Arrays.asList(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..").get(c - 97)).map(String::valueOf).collect(Collectors.joining())).distinct().count();
    }
}
