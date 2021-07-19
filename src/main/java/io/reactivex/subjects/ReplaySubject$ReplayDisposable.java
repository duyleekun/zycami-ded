/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.subjects.ReplaySubject;
import java.util.concurrent.atomic.AtomicInteger;

public final class ReplaySubject$ReplayDisposable
extends AtomicInteger
implements b {
    private static final long serialVersionUID = 466549804534799122L;
    public volatile boolean cancelled;
    public final g0 downstream;
    public Object index;
    public final ReplaySubject state;

    public ReplaySubject$ReplayDisposable(g0 g02, ReplaySubject replaySubject) {
        this.downstream = g02;
        this.state = replaySubject;
    }

    public void dispose() {
        boolean bl2 = this.cancelled;
        if (!bl2) {
            this.cancelled = bl2 = true;
            ReplaySubject replaySubject = this.state;
            replaySubject.z8(this);
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }
}

