package lc1060;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution2 {

    public ArrayList<Server> serverStack = null; //定义机器栈

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // 初始化机器栈
        initServerStack(k);

        // 开始处理每个任务
        for (int i = 0; i < arrival.length; i++) {
            int arrivalTime = arrival[i]; // 任务到达时间
            int taskTime = load[i]; // 任务消耗时间

            // 将任务给机器栈处理
            serverStackDispose(i, arrivalTime, taskTime);
        }

        // 将机器栈按照处理任务的数量排序
        sortServerStack();

        // 返回处理任务最多的机器
        return getMaxTaskServers();

    }

    private List<Integer> getMaxTaskServers() {
        List<Integer> result = new ArrayList<>();
        int max = serverStack.get(0).task;
        result.add(serverStack.get(0).num);
        for (int i = 1; i < serverStack.size(); i++) {
            if (serverStack.get(i).task == max) {
                result.add(serverStack.get(i).num);
            } else {
                break;
            }
        }

        return result;
    }

    private void sortServerStack() {
        serverStack.sort((o1, o2) -> Integer.compare(o2.task, o1.task));
    }

    private boolean serverStackDispose(int i, int arrivalTime, int taskTime) {
        // 环状遍历机器站，看是否有机器能够处理任务
        for (int j = 0; j < serverStack.size(); j++) {
            int index = i % serverStack.size();

            if (serverStack.get(index).addTask(arrivalTime, taskTime)) {
                return true;
            }

            i++;
        }

        return false;
    }

    private void initServerStack(int k) {
        serverStack = new ArrayList<>(k);

        for (int i = 0; i < k; i++) {
            Server server = new Server(i);
            serverStack.add(server);
        }
    }

    public class Server implements Comparator<Server> {
        public int freeTime; // 定义空闲时间
        public int task; // 定义task处理数量
        public int num; // 机器编号

        public Server(int num) {
            this.freeTime = 1; // 所有机器都是从第1秒开始工作的
            this.task = 0;
            this.num = num;
        }

        @Override
        public int compare(Server o1, Server o2) {
            return Integer.compare(o2.task, o1.task);
        }

        public boolean addTask(int nowTime, int taskTime) {
            // 如果当前使劲机器是空闲的，这个任务给这台机器处理
            if (nowTime >= freeTime) {
                // 空闲时间变为 当前时间+这个任务处理的时间
                freeTime = (nowTime + taskTime);
                task++;
                return true;
            }

            // 否则，任务添加失败
            return false;
        }
    }
}
