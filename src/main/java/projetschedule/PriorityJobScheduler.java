package projetschedule;
import java.util.Comparator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PriorityJobScheduler {

    private ExecutorService priorityJobPoolExecutor;
    private ExecutorService priorityJobScheduler = 
      Executors.newSingleThreadExecutor();
    private PriorityBlockingQueue<Jobs> priorityQueue;

    public PriorityJobScheduler(Integer poolSize, Integer queueSize) {
        priorityJobPoolExecutor = Executors.newFixedThreadPool(poolSize);
        priorityQueue = new PriorityBlockingQueue<Jobs>(queueSize,   Comparator.comparing(Jobs::getJobPriority));

        priorityJobScheduler.execute(()->{
            while (true) {
                try {
                    priorityJobPoolExecutor.execute((Runnable) priorityQueue.take());
                } catch (InterruptedException e) {
                    // exception needs special handling
                    break;
                }
            }
        });
    }

    public void scheduleJob(Jobs job) {
        priorityQueue.add(job);
    }

    public int getQueuedTaskCount() {
        return priorityQueue.size();
    }

    protected void close(ExecutorService scheduler) {
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
        }
    }

    public void closeScheduler() {
        close(priorityJobPoolExecutor);
        close(priorityJobScheduler);
    }
}