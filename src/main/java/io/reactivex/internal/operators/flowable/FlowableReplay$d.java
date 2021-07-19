/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription;

public interface FlowableReplay$d {
    public void complete();

    public void error(Throwable var1);

    public void next(Object var1);

    public void replay(FlowableReplay.InnerSubscription var1);
}

