/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableGroupJoin$LeftRightEndObserver;
import io.reactivex.internal.operators.observable.ObservableGroupJoin$LeftRightObserver;

public interface ObservableGroupJoin$a {
    public void innerClose(boolean var1, ObservableGroupJoin.LeftRightEndObserver var2);

    public void innerCloseError(Throwable var1);

    public void innerComplete(ObservableGroupJoin.LeftRightObserver var1);

    public void innerError(Throwable var1);

    public void innerValue(boolean var1, Object var2);
}

