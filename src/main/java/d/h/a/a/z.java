/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a;

import com.google.android.exoplayer2.MediaPeriodQueue;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.common.collect.ImmutableList$Builder;

public final class z
implements Runnable {
    public final /* synthetic */ MediaPeriodQueue a;
    public final /* synthetic */ ImmutableList$Builder b;
    public final /* synthetic */ MediaSource$MediaPeriodId c;

    public /* synthetic */ z(MediaPeriodQueue mediaPeriodQueue, ImmutableList$Builder immutableList$Builder, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        this.a = mediaPeriodQueue;
        this.b = immutableList$Builder;
        this.c = mediaSource$MediaPeriodId;
    }

    public final void run() {
        MediaPeriodQueue mediaPeriodQueue = this.a;
        ImmutableList$Builder immutableList$Builder = this.b;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.c;
        mediaPeriodQueue.b(immutableList$Builder, mediaSource$MediaPeriodId);
    }
}

