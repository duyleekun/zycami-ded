/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0;

import com.google.android.exoplayer2.source.ProgressiveMediaPeriod;

public final class k
implements Runnable {
    public final /* synthetic */ ProgressiveMediaPeriod a;

    public /* synthetic */ k(ProgressiveMediaPeriod progressiveMediaPeriod) {
        this.a = progressiveMediaPeriod;
    }

    public final void run() {
        this.a.c();
    }
}

