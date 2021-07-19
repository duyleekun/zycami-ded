/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Service$State;

public final class AbstractService$StateSnapshot {
    public final Throwable failure;
    public final boolean shutdownWhenStartupFinishes;
    public final Service$State state;

    public AbstractService$StateSnapshot(Service$State service$State) {
        this(service$State, false, null);
    }

    public AbstractService$StateSnapshot(Service$State service$State, boolean bl2, Throwable throwable) {
        boolean bl3;
        Service$State service$State2;
        boolean bl4 = false;
        boolean bl5 = true;
        if (bl2 && service$State != (service$State2 = Service$State.STARTING)) {
            bl3 = false;
            service$State2 = null;
        } else {
            bl3 = bl5;
        }
        Object object = "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.";
        Preconditions.checkArgument(bl3, object, (Object)service$State);
        if (throwable != null) {
            bl3 = bl5;
        } else {
            bl3 = false;
            service$State2 = null;
        }
        object = Service$State.FAILED;
        if (service$State == object) {
            bl4 = bl5;
        }
        Preconditions.checkArgument(bl4 ^ bl3 ^ bl5, "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", (Object)service$State, (Object)throwable);
        this.state = service$State;
        this.shutdownWhenStartupFinishes = bl2;
        this.failure = throwable;
    }

    public Service$State externalState() {
        Service$State service$State;
        Service$State service$State2;
        boolean bl2 = this.shutdownWhenStartupFinishes;
        if (bl2 && (service$State2 = this.state) == (service$State = Service$State.STARTING)) {
            return Service$State.STOPPING;
        }
        return this.state;
    }

    public Throwable failureCause() {
        boolean bl2;
        Service$State service$State = this.state;
        Service$State service$State2 = Service$State.FAILED;
        if (service$State == service$State2) {
            bl2 = true;
        } else {
            bl2 = false;
            service$State2 = null;
        }
        Preconditions.checkState(bl2, "failureCause() is only valid if the service has failed, service is %s", (Object)service$State);
        return this.failure;
    }
}

