package lc164;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{100, 3, 2, 1};
        int gap = solution.maximumGap(nums);
        System.out.println(gap);
    }
}
