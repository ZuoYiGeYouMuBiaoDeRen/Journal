package qingchao.journal.demo;

import qingchao.journal.core.journal.Journal;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Producer implements Runnable {
    private Journal journal;

    public Producer(Journal journal) {
        this.journal = journal;
    }

    @Override
    public void run() {
        while (true) {
            final byte[] idBytes = "id".getBytes(UTF_8);
            final byte[] messageBytes = "messagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessagemessage".getBytes(UTF_8);
            final long position = journal.write( messageBytes);
            System.out.println(position);
            try {
                Thread.sleep(10L);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
