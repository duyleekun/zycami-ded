/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableReplay$SizeBoundReplayBuffer;
import io.reactivex.internal.operators.observable.ObservableReplay$a;
import io.reactivex.internal.operators.observable.ObservableReplay$e;

public final class ObservableReplay$f
implements ObservableReplay$a {
    private final int a;

    public ObservableReplay$f(int n10) {
        this.a = n10;
    }

    public ObservableReplay$e call() {
        int n10 = this.a;
        ObservableReplay$SizeBoundReplayBuffer observableReplay$SizeBoundReplayBuffer = new ObservableReplay$SizeBoundReplayBuffer(n10);
        return observableReplay$SizeBoundReplayBuffer;
    }
}

