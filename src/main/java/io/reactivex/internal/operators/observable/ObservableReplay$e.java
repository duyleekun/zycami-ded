/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableReplay$InnerDisposable;

public interface ObservableReplay$e {
    public void complete();

    public void error(Throwable var1);

    public void next(Object var1);

    public void replay(ObservableReplay.InnerDisposable var1);
}

