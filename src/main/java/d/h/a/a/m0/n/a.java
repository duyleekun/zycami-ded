/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0.n;

import com.google.android.exoplayer2.source.dash.DashMediaSource;

public final class a
implements Runnable {
    public final /* synthetic */ DashMediaSource a;

    public /* synthetic */ a(DashMediaSource dashMediaSource) {
        this.a = dashMediaSource;
    }

    public final void run() {
        DashMediaSource.a(this.a);
    }
}

