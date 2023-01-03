package lc385;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class Solution {
    public NestedInteger deserialize(String s) {
        // 单串
        if (!s.contains("[")) {
            return new NestedInteger(Integer.parseInt(s));
        }

        // 拆包
        String substring = s.substring(1, s.length() - 1);
        // 切割
        List<String> strings = subString(substring);
        // 构造
        NestedInteger nestedInteger = new NestedInteger();
        for (String string : strings) {
            nestedInteger.add(deserialize(string));
        }

        return nestedInteger;
    }

    // "123,[456],123,[345,[341]],321"
    private List<String> subString(String s) {
        if (!s.contains("[")) {
            return Arrays.stream(s.split(",")).filter(p -> !p.isEmpty()).collect(Collectors.toList());
        }

        int leftIndex = s.indexOf('[');
        int rightIndex = findRightIndex(s, leftIndex);

        List<String> stringList = new ArrayList<>(Arrays.asList(s.substring(0, leftIndex).split(",")));
        stringList.add(s.substring(leftIndex, rightIndex + 1));
        stringList.addAll(Arrays.asList(s.substring(rightIndex + 1).split(",")));

        return stringList.stream().filter(p -> !p.isEmpty()).collect(Collectors.toList());
    }

    // "123,[456],123,[345,[341]],321"
    private int findRightIndex(String s, int leftIndex) {
        int leftCount = 0;
        for (int i = leftIndex; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                leftCount++;
            }

            if (s.charAt(i) == ']') {
                leftCount--;
            }

            if (leftCount == 0) {
                return i;
            }
        }

        return -1;
    }
}

