/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import io.reactivex.internal.operators.flowable.FlowableGroupJoin$LeftRightEndSubscriber;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin$LeftRightSubscriber;

public interface FlowableGroupJoin$a {
    public void innerClose(boolean var1, FlowableGroupJoin.LeftRightEndSubscriber var2);

    public void innerCloseError(Throwable var1);

    public void innerComplete(FlowableGroupJoin.LeftRightSubscriber var1);

    public void innerError(Throwable var1);

    public void innerValue(boolean var1, Object var2);
}

