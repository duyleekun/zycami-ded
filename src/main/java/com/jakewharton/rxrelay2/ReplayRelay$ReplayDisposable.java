/*
 * Decompiled with CFR 0.151.
 */
package com.jakewharton.rxrelay2;

import com.jakewharton.rxrelay2.ReplayRelay;
import e.a.g0;
import e.a.s0.b;
import java.util.concurrent.atomic.AtomicInteger;

public final class ReplayRelay$ReplayDisposable
extends AtomicInteger
implements b {
    private static final long serialVersionUID = 466549804534799122L;
    public volatile boolean cancelled;
    public final g0 downstream;
    public Object index;
    public final ReplayRelay state;

    public ReplayRelay$ReplayDisposable(g0 g02, ReplayRelay replayRelay) {
        this.downstream = g02;
        this.state = replayRelay;
    }

    public void dispose() {
        boolean bl2 = this.cancelled;
        if (!bl2) {
            this.cancelled = bl2 = true;
            ReplayRelay replayRelay = this.state;
            replayRelay.w8(this);
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }
}

