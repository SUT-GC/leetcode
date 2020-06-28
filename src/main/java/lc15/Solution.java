package lc15;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // corner case
        List<List<Integer>> ans = new ArrayList<>();
        Set<String> dup = new HashSet<>();

        // 从小到大排序
        Arrays.sort(nums);

        // list 转 set
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int three = -nums[i] - nums[j];
                String dupS = String.format("%s-%s-%s", nums[i], nums[j], -nums[i] - nums[j]);

                if (numMap.containsKey(three) && numMap.getOrDefault(three, -1) > j && !dup.contains(dupS)) {
                    ans.add(Arrays.asList(nums[i], nums[j], three));
                    dup.add(dupS);
                }
            }
        }

        return ans;
    }
}
