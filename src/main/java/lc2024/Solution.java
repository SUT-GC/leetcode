package lc2024;

public class Solution {

    // 记录上下文
    public static class Context {
        public int max; // 记录最大连续字符数量
        public int start; // 记录开始指针
        public int end; // 记录结束指针
        public int nowCount; // 记录当前统计
        public String target; // 记录目标
        public int maxChange; // 记录最大变化
        public int nowChange; // 记录当前已经改变了的数量
        private char from; // 从哪个字符
        private char to; // 变到哪个字符
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int T2F = maxChange(answerKey, k, 'T', 'F');
        int F2T = maxChange(answerKey, k, 'F', 'T');

        return Math.max(T2F, F2T);
    }

    public int maxChange(String answerKey, int k, char from, char to) {
        Context context = new Context();
        context.max = 0;
        context.start = 0;
        context.end = 0;
        context.target = answerKey;
        context.maxChange = k;
        context.nowChange = 0;
        context.from = from;
        context.to = to;

        // 开始滑动窗口
        while (true) {
            // 滑动指针 end
            boolean endResult = slideEndIndex(context);
            // 如果end指针滑动成功，则继续滑动 end
            if (endResult) {
                continue;
            }

            // 如果end指针滑动失败，开始互动指针 start
            boolean startResult = slideStartIndex(context);

            // 如果start指针滑动成功，则继续循环
            if (startResult) {
                continue;
            }

            // 否则结束滑动
            break;
        }

        return context.max;
    }

    private boolean slideStartIndex(Context context) {
        //  如果滑到了跟end一样的值，就不能滑动了
        if (context.start >= context.end) {
            return false;
        }
        if (context.target.charAt(context.start) == context.to) {
            // 如果当前是 T，则max少一个
            context.nowCount--;
        } else if (context.target.charAt(context.start) == context.from) {
            // 如果当前是 F，则max少一个，nowCount也少一个
            context.nowCount--;
            context.nowChange--;
        }

        //滑动下一个
        context.start++;

        context.max = Math.max(context.nowCount, context.max);

        return true;
    }

    private boolean slideEndIndex(Context context) {
        // 如果滑到底了，就不能滑动了
        if (context.end >= context.target.length()) {
            return false;
        }

        if (context.target.charAt(context.end) == context.from) {
            if (context.nowChange >= context.maxChange) {
                // 如果已经没有变换机会了，就不能再变换了
                return false;
            } else {
                // 否则可以变换一个
                context.nowChange++;
                context.nowCount++;
            }
        } else if (context.target.charAt(context.end) == context.to) {
            context.nowCount++;
        }

        //滑动
        context.end++;

        context.max = Math.max(context.nowCount, context.max);

        return true;
    }
}
