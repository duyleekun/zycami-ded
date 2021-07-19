/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.h0;
import io.reactivex.internal.operators.observable.ObservableReplay$SizeAndTimeBoundReplayBuffer;
import io.reactivex.internal.operators.observable.ObservableReplay$a;
import io.reactivex.internal.operators.observable.ObservableReplay$e;
import java.util.concurrent.TimeUnit;

public final class ObservableReplay$h
implements ObservableReplay$a {
    private final int a;
    private final long b;
    private final TimeUnit c;
    private final h0 d;

    public ObservableReplay$h(int n10, long l10, TimeUnit timeUnit, h0 h02) {
        this.a = n10;
        this.b = l10;
        this.c = timeUnit;
        this.d = h02;
    }

    public ObservableReplay$e call() {
        int n10 = this.a;
        long l10 = this.b;
        TimeUnit timeUnit = this.c;
        h0 h02 = this.d;
        ObservableReplay$SizeAndTimeBoundReplayBuffer observableReplay$SizeAndTimeBoundReplayBuffer = new ObservableReplay$SizeAndTimeBoundReplayBuffer(n10, l10, timeUnit, h02);
        return observableReplay$SizeAndTimeBoundReplayBuffer;
    }
}

