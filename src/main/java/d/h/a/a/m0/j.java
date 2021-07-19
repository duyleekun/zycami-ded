/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.source.ProgressiveMediaPeriod;

public final class j
implements Runnable {
    public final /* synthetic */ ProgressiveMediaPeriod a;
    public final /* synthetic */ SeekMap b;

    public /* synthetic */ j(ProgressiveMediaPeriod progressiveMediaPeriod, SeekMap seekMap) {
        this.a = progressiveMediaPeriod;
        this.b = seekMap;
    }

    public final void run() {
        ProgressiveMediaPeriod progressiveMediaPeriod = this.a;
        SeekMap seekMap = this.b;
        progressiveMediaPeriod.e(seekMap);
    }
}

