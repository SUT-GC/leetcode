package lc140;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public Map<String, List<String>> memory = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (null == s || s.isEmpty() || null == wordDict || wordDict.isEmpty()) {
            return new ArrayList<>();
        }

        List<String> ans = split(s, wordDict);

        return ans;
    }

    public List<String> split(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return new ArrayList<>();
        }

        if (memory.containsKey(s)) {
            return memory.get(s);
        }

        List<String> successWord = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String subS = s.substring(word.length());

                if (subS.isEmpty()) {
                    successWord.add(word);
                }

                List<String> splitWords = split(subS, wordDict);
                successWord.addAll(splitWords.stream().map(splitWord -> word + " " + splitWord).collect(Collectors.toList()));
            }
        }


        memory.put(s, successWord);
        return successWord;
    }
}
