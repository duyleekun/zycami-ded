/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0.m;

import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.ads.AdsMediaSource$AdPrepareListener;

public final class c
implements Runnable {
    public final /* synthetic */ AdsMediaSource$AdPrepareListener a;
    public final /* synthetic */ MediaSource$MediaPeriodId b;

    public /* synthetic */ c(AdsMediaSource$AdPrepareListener adsMediaSource$AdPrepareListener, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        this.a = adsMediaSource$AdPrepareListener;
        this.b = mediaSource$MediaPeriodId;
    }

    public final void run() {
        AdsMediaSource$AdPrepareListener adsMediaSource$AdPrepareListener = this.a;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.b;
        adsMediaSource$AdPrepareListener.b(mediaSource$MediaPeriodId);
    }
}

