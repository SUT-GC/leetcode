package lc79;

import java.util.Arrays;

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (null == board || null == word || word.isEmpty()) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean e = exist(board, new int[board.length][board[0].length], i, j, word);
                if (e) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean exist(char[][] board, int[][] map, int i, int j, String word) {
        if (word.isEmpty()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }

        if (map[i][j] == 1) {
            return false;
        }

        if (board[i][j] != word.charAt(0)) {
            return false;
        }


        int[][] mapCopy = Arrays.copyOf(map, map.length);
        mapCopy[i][j] = 1;

        return exist(board, mapCopy, i, j + 1, word.substring(1))
                || exist(board, mapCopy, i + 1, j, word.substring(1))
                || exist(board, mapCopy, i, j - 1, word.substring(1))
                || exist(board, mapCopy, i - 1, j, word.substring(1));
    }
}
