package lc394;

public class Solution {
    public String decodeString(String s) {

        char[] chars = s.toCharArray();
        int leftIndex = -1;
        int rightIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            int type = checkChar(chars[i]);
            if (type == 2) {
                leftIndex = i;
            } else if (type == 3) {
                rightIndex = i;
                break;
            }
        }


        if (leftIndex == -1) {
            return s;
        }

        int numIndex = leftIndex - 1;
        int dupNum = 0;
        int cheng = 1;
        int numCount = 0;
        while (numIndex >= 0 && checkChar(s.charAt(numIndex)) == 1) {
            numCount++;
            dupNum += cheng * (s.charAt(numIndex) - 48);
            cheng *= 10;
            numIndex--;
        }

        String dupStr = s.substring(leftIndex + 1, rightIndex);
        StringBuilder repStr = new StringBuilder();
        while (--dupNum >= 0) {
            repStr.append(dupStr);
        }

        String newResult = s.substring(0, leftIndex - numCount) + repStr + s.substring(rightIndex + 1, s.length());

        return decodeString(newResult);
    }

    /**
     * 1 number
     */
    public int checkChar(char c) {
        if (c >= 48 && c <= 57) {
            return 1;
        }
        if (c == '[') {
            return 2;
        }

        if (c == ']') {
            return 3;
        }

        return 4;
    }
}
