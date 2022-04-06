package lc954;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution2 {
    public static class Num implements Comparable<Num> {
        public int number;
        public int index;
        public boolean doubled;

        public Num(int number, int index) {
            this.number = number;
            this.index = index;
            this.doubled = false;
        }

        @Override
        public int compareTo(Num o) {
            return Integer.compare(Math.abs(this.number), Math.abs(o.number));
        }
    }

    Map<Integer, Set<Num>> numCount = new HashMap<>();

    public boolean canReorderDoubled(int[] arr) {
        // 初始化参数列表
        List<Num> nums = initNums(arr);

        nums = sortByNumber(nums);

        // 统计数字
        calculateNumCount(nums);

        // 找对子
        return findDoubledAndDecrNumCount(nums);
    }

    private List<Num> sortByNumber(List<Num> nums) {
        Collections.sort(nums);
        return nums;
    }

    private List<Num> initNums(int[] arr) {
        List<Num> nums = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nums.add(new Num(arr[i], i));
        }

        return nums;
    }


    private boolean findDoubledAndDecrNumCount(List<Num> sortArr) {
        for (Num num : sortArr) {
            // 如果num配对过，则pass
            if (num.doubled) {
                continue;
            }

            // 找num可以配对的数字
            Set<Num> canDoubledNums = numCount.getOrDefault(num.number * 2, new HashSet<>());

            // 如果没有找到，失败
            Num canDoubledNum = canDoubledNums.stream().filter(p -> !p.doubled && p.index != num.index).findFirst().orElse(null);
            if (null == canDoubledNum) {
                return false;
            }

            // 如果找到了可以配对的，则都标记成配对完成
            num.doubled = true;
            canDoubledNum.doubled = true;

            // 将这两个删除
            numCount.get(num.number).remove(num);
            numCount.get(canDoubledNum.number).remove(num);
        }

        // 所有的配上对的话，则成功
        return true;
    }

    private void calculateNumCount(List<Num> nums) {
        for (Num num : nums) {
            numCount.compute(num.number, (k, v) -> {
                if (v == null) {
                    return new HashSet<Num>() {{
                        add(num);
                    }};
                } else {
                    v.add(num);
                    return v;
                }
            });
        }
    }
}
