package lc140;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s1 = "catsanddog";
        List<String> words1 = new ArrayList<String>() {{
            add("cat");
            add("cats");
            add("and");
            add("sand");
            add("dog");
        }};

        String s2 = "pineapplepenapple";
        List<String> words2 = new ArrayList<String>() {{
            add("apple");
            add("pen");
            add("applepen");
            add("pine");
            add("pineapple");
        }};


        String s3 = "catsandog";
        List<String> words3 = new ArrayList<String>() {{
            add("cats");
            add("dog");
            add("sand");
            add("and");
            add("cat");
        }};
        System.out.println(new Solution().wordBreak(s3, words3));
    }
}
