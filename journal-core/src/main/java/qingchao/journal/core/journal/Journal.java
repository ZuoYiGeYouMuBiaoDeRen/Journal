package qingchao.journal.core.journal;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public interface Journal {
    Entry createEntry(byte[] messageBytes);
//    Entry createEntry(byte[] idBytes, byte[] messageBytes);

    long write(List<Entry> entries);

    long write(byte[] messageBytes);

    List<JournalReadEntry> read(long maximumCount);

    void markJournalOffsetCommitted(long offset);

    @AllArgsConstructor
    @Getter
    class Entry {
        //        private final byte[] idBytes;
        private final byte[] messageBytes;
    }

    @AllArgsConstructor
    @Getter
    class JournalReadEntry {
        private final byte[] payload;
        private final long offset;
    }
}
