/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Monitor;
import java.util.concurrent.locks.Condition;

public abstract class Monitor$Guard {
    public final Condition condition;
    public final Monitor monitor;
    public Monitor$Guard next;
    public int waiterCount = 0;

    public Monitor$Guard(Monitor object) {
        Monitor monitor;
        this.monitor = monitor = (Monitor)Preconditions.checkNotNull(object, "monitor");
        this.condition = object = Monitor.access$000((Monitor)object).newCondition();
    }

    public abstract boolean isSatisfied();
}

