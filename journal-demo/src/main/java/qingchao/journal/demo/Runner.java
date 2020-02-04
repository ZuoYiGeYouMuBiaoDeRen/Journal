package qingchao.journal.demo;

import com.codahale.metrics.MetricRegistry;
import com.github.joschi.jadconfig.util.Size;
import org.joda.time.Duration;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import qingchao.journal.core.ServerStatus;
import qingchao.journal.core.journal.KafkaJournal;

import java.io.File;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Component
public class Runner implements ApplicationRunner {
    private ScheduledThreadPoolExecutor scheduler;
    private File journalDirectory=new File("D:\\tmp\\journal-2020-03-04");
    private ServerStatus serverStatus;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.prestartCoreThread();
//        journalDirectory = temporaryFolder.newFolder();
        final KafkaJournal journal = new KafkaJournal(journalDirectory.toPath(),
                scheduler,
                Size.megabytes(1L),
                Duration.standardHours(1),
                Size.megabytes(5L),
                Duration.standardHours(1),
                1_000_000,
                Duration.standardMinutes(1),
                100,
                new MetricRegistry(),
                serverStatus);
        try {
            journal.startUp();
        }catch (Exception e){
            System.out.println(e);
        }

        Producer producer=new Producer(journal);
        Consumer consumer=new Consumer(journal);
        Thread producerThread=new Thread(producer,"Producer");
        Thread consumerThread=new Thread(consumer,"Consumer");
        producerThread.start();
        consumerThread.start();
    }
}
