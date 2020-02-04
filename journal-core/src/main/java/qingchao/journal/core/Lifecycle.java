package qingchao.journal.core;

public enum Lifecycle {
    UNINITIALIZED("Uninitialized", LoadBalancerStatus.DEAD),
    STARTING("Starting", LoadBalancerStatus.DEAD),
    RUNNING("Running", LoadBalancerStatus.ALIVE),
    PAUSED("Paused", LoadBalancerStatus.ALIVE),
    HALTING("Halting", LoadBalancerStatus.DEAD),
    FAILED("Failed", LoadBalancerStatus.DEAD),
    THROTTLED("Throttled", LoadBalancerStatus.THROTTLED),

    // Manual lifecycle override, usually set by REST calls.
    OVERRIDE_LB_DEAD("Override lb:DEAD", LoadBalancerStatus.DEAD),
    OVERRIDE_LB_ALIVE("Override lb:ALIVE", LoadBalancerStatus.ALIVE),
    OVERRIDE_LB_THROTTLED("Override lb:THROTTLED", LoadBalancerStatus.THROTTLED);

    private final String description;
    private final LoadBalancerStatus loadBalancerStatus;

    Lifecycle(String description, LoadBalancerStatus loadBalancerStatus) {
        this.description = description;
        this.loadBalancerStatus = loadBalancerStatus;
    }

    public LoadBalancerStatus getLoadbalancerStatus() {
        return loadBalancerStatus;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description + " [LB:" + getLoadbalancerStatus() + "]";
    }
}
