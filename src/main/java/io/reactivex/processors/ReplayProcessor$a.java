/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import io.reactivex.processors.ReplayProcessor$ReplaySubscription;

public interface ReplayProcessor$a {
    public void a(ReplayProcessor.ReplaySubscription var1);

    public void complete();

    public void error(Throwable var1);

    public Throwable getError();

    public Object getValue();

    public Object[] getValues(Object[] var1);

    public boolean isDone();

    public void next(Object var1);

    public int size();

    public void trimHead();
}

