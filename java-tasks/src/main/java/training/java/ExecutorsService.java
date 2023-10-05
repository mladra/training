package training.java;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ExecutorsService {

    public static void main(String[] args) {
        ExecutionData[] data = new ExecutionData[] {
                new ExecutionData("a", 3),
                new ExecutionData("b", 2),
                new ExecutionData("c", 1),
                new ExecutionData("d", 2),
                new ExecutionData("e", 3),
                new ExecutionData("f", 4),
                new ExecutionData("g", 5),
                new ExecutionData("h", 4),
                new ExecutionData("i", 3),
                new ExecutionData("j", 2),
                new ExecutionData("k", 1)
        };

        ExecutorsService service = new ExecutorsService();
        service.run(data);
        service.getExecutorService().shutdown();
    }

    private final ExecutorService executorService = Executors.newFixedThreadPool(5, new ThreadFactory() {

        private static int NUM = 1;

        @Override
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "thread-" + NUM++);
        }
    });

    private void run(ExecutionData... executionData) {
        for (ExecutionData data : executionData) {
            executorService.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " -> ExecutionData: " + data.name() + ", sleeping for " + data.timeInSeconds() + " sec");
                    TimeUnit.SECONDS.sleep(data.timeInSeconds());
                    System.out.println(Thread.currentThread().getName() + " -> Processing of data " + data.name() + " ended");
                } catch (InterruptedException exception) {
                    System.err.println(exception.getMessage());
                }
            });
        }
    }

    private ExecutorService getExecutorService() {
        return executorService;
    }

    private record ExecutionData(String name, int timeInSeconds) {

    }
}
