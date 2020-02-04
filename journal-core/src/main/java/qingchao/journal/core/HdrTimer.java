package qingchao.journal.core;

import com.codahale.metrics.*;

import java.util.concurrent.TimeUnit;

public class HdrTimer extends Timer {
    private final HdrHistogram hdrHistogram;

    public HdrTimer(final long highestTrackableValue, final TimeUnit unit, final int numberOfSignificantValueDigits) {
        this(highestTrackableValue, unit, numberOfSignificantValueDigits, new ExponentiallyDecayingReservoir());
    }

    public HdrTimer(long highestTrackableValue, TimeUnit unit, int numberOfSignificantValueDigits, Reservoir reservoir) {
        this(highestTrackableValue, unit, numberOfSignificantValueDigits, reservoir, Clock.defaultClock());
    }


    public HdrTimer(long highestTrackableValue,
                    TimeUnit unit,
                    int numberOfSignificantValueDigits,
                    Reservoir reservoir,
                    Clock clock) {
        super(reservoir, clock);
        hdrHistogram = new HdrHistogram(unit.toNanos(highestTrackableValue), numberOfSignificantValueDigits);
    }

    @Override
    public long getCount() {
        return hdrHistogram.getCount();
    }

    @Override
    public Snapshot getSnapshot() {
        return hdrHistogram.getSnapshot();
    }

    @Override
    public void update(long duration, TimeUnit unit) {
        super.update(duration, unit);
        if (duration >= 0) {
            hdrHistogram.update(unit.toNanos(duration));
        }
    }
}
