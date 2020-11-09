package lc127;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<String>() {{
            add("hot");
            add("dot");
            add("dog");
            add("lot");
            add("log");
            add("cog");
        }};


        Solution2 solution = new Solution2();
        System.out.println(solution.ladderLength(beginWord, endWord, wordList));
    }
}
