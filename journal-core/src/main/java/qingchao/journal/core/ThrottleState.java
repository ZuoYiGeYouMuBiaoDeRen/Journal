package qingchao.journal.core;

import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
public class ThrottleState {
    public long uncommittedJournalEntries;
    public long appendEventsPerSec;
    public long journalSize;
    public long journalSizeLimit;
    public long readEventsPerSec;
    public long processBufferCapacity;

    public ThrottleState(ThrottleState o) {
        this.uncommittedJournalEntries = o.uncommittedJournalEntries;
        this.appendEventsPerSec = o.appendEventsPerSec;
        this.journalSize = o.journalSize;
        this.journalSizeLimit = o.journalSizeLimit;
        this.readEventsPerSec = o.readEventsPerSec;
        this.processBufferCapacity = o.processBufferCapacity;
    }
}
