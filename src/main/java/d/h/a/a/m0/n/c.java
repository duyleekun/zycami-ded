/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0.n;

import com.google.android.exoplayer2.source.dash.DashMediaSource;

public final class c
implements Runnable {
    public final /* synthetic */ DashMediaSource a;

    public /* synthetic */ c(DashMediaSource dashMediaSource) {
        this.a = dashMediaSource;
    }

    public final void run() {
        this.a.c();
    }
}

