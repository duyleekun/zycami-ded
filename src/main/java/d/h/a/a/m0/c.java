/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0;

import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;

public final class c
implements Runnable {
    public final /* synthetic */ MediaSourceEventListener$EventDispatcher a;
    public final /* synthetic */ MediaSourceEventListener b;
    public final /* synthetic */ MediaSource$MediaPeriodId c;
    public final /* synthetic */ MediaLoadData d;

    public /* synthetic */ c(MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher, MediaSourceEventListener mediaSourceEventListener, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, MediaLoadData mediaLoadData) {
        this.a = mediaSourceEventListener$EventDispatcher;
        this.b = mediaSourceEventListener;
        this.c = mediaSource$MediaPeriodId;
        this.d = mediaLoadData;
    }

    public final void run() {
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.a;
        MediaSourceEventListener mediaSourceEventListener = this.b;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.c;
        MediaLoadData mediaLoadData = this.d;
        mediaSourceEventListener$EventDispatcher.l(mediaSourceEventListener, mediaSource$MediaPeriodId, mediaLoadData);
    }
}

