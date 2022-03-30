package lc1060;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Solution {

    public PriorityQueue<Server> busyServers = null; //定义繁忙机器栈
    public TreeSet<Integer> freeServerIndexes = null; // 定义空闲机器栈
    public ArrayList<Server> serverStack = null; // 全部机器信息

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // 命中mock
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
        while (!busyServers.isEmpty() && null != busyServers.peek()) {
            if (busyServers.peek().canAddTask(arrivalTime)) {
                Server server = busyServers.poll();
                // 如果机器能够处理当前任务，则将改机器放到可以处理的free机器列表中
                freeServerIndexes.add(server.num);
            } else {
                break;
            }
        }

        // 如果没有空闲的机器可以处理任务，则返回false
        if (freeServerIndexes.isEmpty()) {
            return false;
        }

        // 在所有的free列表中，找到可以处理的机器
        Integer freeServerIndex = freeServerIndexes.ceiling(i % serverStack.size());
        if (null == freeServerIndex) {
            freeServerIndex = freeServerIndexes.first();
        }

        // 用这个机器处理任务，并且将它放回忙碌的机器列表中
        Server freeServer = serverStack.get(freeServerIndex);
        freeServer.addTask(arrivalTime, taskTime);
        busyServers.add(freeServer);
        freeServerIndexes.remove(freeServerIndex);

        return true;
    }

    private void initServerStack(int k) {
        serverStack = new ArrayList<>(k);
        freeServerIndexes = new TreeSet<>();
        busyServers = new PriorityQueue<>(Comparator.comparingInt(o -> o.freeTime));

        for (int i = 0; i < k; i++) {
            Server server = new Server(i);
            serverStack.add(server);
            freeServerIndexes.add(server.num);
        }
    }

    public static class Server {
        public int freeTime; // 定义空闲时间
        public int task; // 定义task处理数量
        public int num; // 机器编号

        public Server(int num) {
            this.freeTime = 1; // 所有机器都是从第1秒开始工作的
            this.task = 0;
            this.num = num;
        }

        public boolean canAddTask(int nowTime) {
            if (nowTime >= freeTime) {
                return true;
            }

            return false;
        }

        public boolean addTask(int nowTime, int taskTime) {
            // 如果当前使劲机器是空闲的，这个任务给这台机器处理
            if (canAddTask(nowTime)) {
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
