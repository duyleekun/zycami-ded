/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0.m;

import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.ads.AdsMediaSource$AdPrepareListener;
import java.io.IOException;

public final class b
implements Runnable {
    public final /* synthetic */ AdsMediaSource$AdPrepareListener a;
    public final /* synthetic */ MediaSource$MediaPeriodId b;
    public final /* synthetic */ IOException c;

    public /* synthetic */ b(AdsMediaSource$AdPrepareListener adsMediaSource$AdPrepareListener, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, IOException iOException) {
        this.a = adsMediaSource$AdPrepareListener;
        this.b = mediaSource$MediaPeriodId;
        this.c = iOException;
    }

    public final void run() {
        AdsMediaSource$AdPrepareListener adsMediaSource$AdPrepareListener = this.a;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.b;
        IOException iOException = this.c;
        adsMediaSource$AdPrepareListener.d(mediaSource$MediaPeriodId, iOException);
    }
}

