package projetschedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Jobs implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(Job.class);

    private final String jobName;
    private final JobPriority jobPriority;

    public Jobs(String jobName, JobPriority jobPriority) {
        this.jobName = jobName;
        this.jobPriority = jobPriority != null ? jobPriority : JobPriority.MEDIUM;
    }

    public JobPriority getJobPriority() {
        return jobPriority;
    }

    @Override
    public void run() {
        try {
            LOGGER.debug("Job:{} Priority:{}", jobName, jobPriority);
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        	
        }
        }
    }