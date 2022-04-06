package lc307;

import java.util.ArrayList;
import java.util.List;

class NumArray {

    public static class SumCached {
        int sum;
        int start;
        int end;

        public SumCached(int sum, int start, int end) {
            this.sum = sum;
            this.start = start;
            this.end = end;
        }

        public void reCal(int oldNum, int newNum) {
            this.sum = this.sum - oldNum + newNum;
        }
    }

    int[] _nums;

    int _cacheStep = 0;
    List<SumCached> _cached = null;

    public NumArray(int[] nums) {
        this._nums = nums;

        this._cacheStep = nums.length / 100;
        if (this._cacheStep == 0) {
            this._cacheStep = nums.length;
        }
        initCache(nums);
    }

    public void update(int index, int val) {
        int from = this._nums[index];
        int to = val;
        this._nums[index] = val;
        updateCached(index, from, to);
    }

    public int sumRange(int left, int right) {
        int leftBlockIndex = left / this._cacheStep;
        int rightBlockIndex = right / this._cacheStep;

        if (leftBlockIndex == rightBlockIndex) {
            int sum = 0;
            for (int i = left; i <= right; i++) {
                sum += this._nums[i];
            }

            return sum;
        }

        // 找到左块和右块
        SumCached leftBlock = this._cached.get(leftBlockIndex);
        SumCached rightBlock = this._cached.get(rightBlockIndex);

        int leftSum = 0;
        int rightSum = 0;
        if (left == leftBlock.start) {
            leftSum += leftBlock.sum;
        } else {
            for (int i = left; i <= leftBlock.end; i++) {
                leftSum += this._nums[i];
            }
        }

        if (right == rightBlock.end) {
            rightSum += rightBlock.sum;
        } else {
            for (int i = rightBlock.start; i <= right; i++) {
                rightSum += this._nums[i];
            }
        }

        int midSum = 0;
        for (int i = left / this._cacheStep + 1; i <= right / this._cacheStep - 1; i++) {
            midSum += this._cached.get(i).sum;
        }

        return leftSum + midSum + rightSum;
    }

    private void initCache(int[] nums) {
        this._cached = new ArrayList<>();

        int sum = 0;
        int sumCount = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumCount++;
            end = i;
            if (sumCount >= this._cacheStep) {
                this._cached.add(new SumCached(sum, start, end));
                sum = 0;
                sumCount = 0;
                start = i + 1;
            }
        }

        if (sumCount > 0) {
            this._cached.add(new SumCached(sum, start, nums.length - 1));
        }
    }

    private void updateCached(int index, int from, int to) {
        int cacheBlockIndex = index / this._cacheStep;
        this._cached.get(cacheBlockIndex).reCal(from, to);
    }
}