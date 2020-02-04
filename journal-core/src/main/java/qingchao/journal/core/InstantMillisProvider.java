package qingchao.journal.core;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.Period;

@Slf4j
public class InstantMillisProvider implements DateTimeUtils.MillisProvider {
    private DateTime currentTick;

    public InstantMillisProvider(DateTime instant) {
        setTimeTo(instant);
    }

    public void setTimeTo(DateTime instant) {
        log.debug("Setting clock to {}", instant);
        currentTick = instant;
    }

    @Override
    public long getMillis() {
        return currentTick.getMillis();
    }

    public void tick(Period period) {
        currentTick = currentTick.plus(period);
        log.debug("Ticking clock by {} to {}", period, currentTick);
    }
}
