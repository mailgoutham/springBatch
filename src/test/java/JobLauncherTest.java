import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * User: Goutham Rathnaswamy
 * Date: 19/07/2013
 * Time: 15:42
 */
public class JobLauncherTest {

    private JobLauncher jobLauncher;
    private Job job;
    private JobParameters jobParameters;


    @Before
    public void setup(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jobs/transferJob.xml");
        jobLauncher = (JobLauncher)context.getBean("jobLauncher");
        job = (Job)context.getBean("transferJob");
    }

    @Test
    public void shouldTransferJob() throws JobInstanceAlreadyCompleteException, JobParametersInvalidException, JobRestartException, JobExecutionAlreadyRunningException {
        //given
        jobParameters = new JobParametersBuilder().addString("inputFile", "files/input.txt").addString("outputFile", "/files/output.txt").toJobParameters() ;

        //when
        JobExecution execution = jobLauncher.run(job, jobParameters);

        //then
        assertThat(execution.getExitStatus().getExitCode(), is("COMPLETED"));


    }
}
