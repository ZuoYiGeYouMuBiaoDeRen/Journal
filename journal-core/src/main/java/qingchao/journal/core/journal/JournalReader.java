package qingchao.journal.core.journal;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JournalReader {
//public class JournalReader extends AbstractExecutionThreadService {
//    private final Journal journal;
//    private final ProcessBuffer processBuffer;
//    private final Semaphore journalFilled;
//    private final MetricRegistry metricRegistry;
//    private final EventBus eventBus;
//    private final Meter readMessages;
//    private volatile boolean shouldBeReading;
//    private Histogram requestedReadCount;
//    private final Counter readBlocked;
//    private Thread executionThread;
//
//    @Override
//    protected void startUp() throws Exception {
//        eventBus.register(this);
//        executionThread = Thread.currentThread();
//    }
//
//    @Override
//    protected void shutDown() throws Exception {
//        eventBus.unregister(this);
//    }
//
//    @Override
//    protected void triggerShutdown() {
//        executionThread.interrupt();
//    }
//
//    @Subscribe
//    public void listenForLifecycleChanges(Lifecycle lifecycle) {
//        switch (lifecycle) {
//            case UNINITIALIZED:
//                shouldBeReading = false;
//                break;
//            case STARTING:
//                shouldBeReading = false;
//                break;
//            case RUNNING:
//                shouldBeReading = true;
//                break;
//            case THROTTLED:
//                shouldBeReading = true;
//                break;
//            case PAUSED:
//                shouldBeReading = false;
//                break;
//            case HALTING:
//                shouldBeReading = false;
//                break;
//            case FAILED:
//                triggerShutdown();
//                break;
//            case OVERRIDE_LB_DEAD:
//            case OVERRIDE_LB_ALIVE:
//            case OVERRIDE_LB_THROTTLED:
//            default:
//                // don't care, keep processing journal
//                break;
//        }
//    }
//
//    @Override
//    protected void run() throws Exception {
//        try {
//            requestedReadCount = metricRegistry.register(name(this.getClass(), "requestedReadCount"), new HdrHistogram(processBuffer.getRingBufferSize() + 1, 3));
//        } catch (IllegalArgumentException e) {
//            log.warn("Metric already exists", e);
//            throw e;
//        }
//
//        while (isRunning()) {
//            // TODO interfere with reading if we are not 100% certain we should be reading, see #listenForLifecycleChanges
//            if (!shouldBeReading) {
//                Uninterruptibles.sleepUninterruptibly(100, MILLISECONDS);
//                // don't read immediately, but check if we should be shutting down.
//                continue;
//            }
//            // approximate count to read from the journal to backfill the processing chain
//            final long remainingCapacity = processBuffer.getRemainingCapacity();
//            requestedReadCount.update(remainingCapacity);
//            final List<Journal.JournalReadEntry> encodedRawMessages = journal.read(remainingCapacity);
//            if (encodedRawMessages.isEmpty()) {
//                log.debug("No messages to read from Journal, waiting until the writer adds more messages.");
//                // block until something is written to the journal again
//                try {
//                    readBlocked.inc();
//                    journalFilled.acquire();
//                } catch (InterruptedException ignored) {
//                    // this can happen when we are blocked but the system wants to shut down. We don't have to do anything in that case.
//                    continue;
//                }
//                log.debug("Messages have been written to Journal, continuing to read.");
//                // we don't care how many messages were inserted in the meantime, we'll read all of them eventually
//                journalFilled.drainPermits();
//            } else {
//                readMessages.mark(encodedRawMessages.size());
//                log.debug("Processing {} messages from journal.", encodedRawMessages.size());
//                for (final Journal.JournalReadEntry encodedRawMessage : encodedRawMessages) {
//                    final RawMessage rawMessage = RawMessage.decode(encodedRawMessage.getPayload(),
//                            encodedRawMessage.getOffset());
//                    if (rawMessage == null) {
//                        // never insert null objects into the ringbuffer, as that is useless
//                        log.error("Found null raw message!");
//                        journal.markJournalOffsetCommitted(encodedRawMessage.getOffset());
//                        continue;
//                    }
//
//                    processBuffer.insertBlocking(rawMessage);
//                }
//            }
//        }
//        log.info("Stopping.");
//    }
}
