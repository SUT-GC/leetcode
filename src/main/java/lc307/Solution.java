package lc307;


public class Solution {
    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(numArray.sumRange(1, 3));
        System.out.println(numArray.sumRange(1, 6));
        System.out.println(numArray.sumRange(0, 6));
        System.out.println(numArray.sumRange(3, 6));
    }
}
