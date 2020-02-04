package qingchao.journal.demo;

import com.google.common.collect.Iterators;
import qingchao.journal.core.journal.Journal;

import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Consumer implements Runnable {
    private Journal journal;

    public Consumer(Journal journal) {
        this.journal = journal;
    }

    @Override
    public void run() {
        while (true) {
            List<Journal.JournalReadEntry> messages = journal.read(1);
            Journal.JournalReadEntry firstMessage = Iterators.getOnlyElement(messages.iterator());
            System.out.println("position:"+firstMessage.getOffset()+", message:"+new String(firstMessage.getPayload(), UTF_8));
            try {
                Thread.sleep(10L);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
