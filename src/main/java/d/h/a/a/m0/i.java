/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0;

import com.google.android.exoplayer2.source.ProgressiveMediaPeriod;

public final class i
implements Runnable {
    public final /* synthetic */ ProgressiveMediaPeriod a;

    public /* synthetic */ i(ProgressiveMediaPeriod progressiveMediaPeriod) {
        this.a = progressiveMediaPeriod;
    }

    public final void run() {
        ProgressiveMediaPeriod.a(this.a);
    }
}

