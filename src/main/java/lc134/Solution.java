package lc134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (null == gas || null == cost || gas.length == 0 || cost.length == 0) {
            return -1;
        }

        int size = gas.length;
        for (int i = 0; i < gas.length; i++) {
            int loop = size;
            int init = 0;
            int index = i;
            boolean ok = true;
            while (--loop >= 0) {
                init += gas[index % size];
                init -= cost[index % size];
                if (init < 0) {
                    ok = false;
                    break;
                }
                index++;
            }

            if (ok) {
                return i;
            }
        }

        return -1;
    }
}
