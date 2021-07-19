/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0.m;

import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.AdsMediaSource$ComponentListener;

public final class e
implements Runnable {
    public final /* synthetic */ AdsMediaSource$ComponentListener a;
    public final /* synthetic */ AdPlaybackState b;

    public /* synthetic */ e(AdsMediaSource$ComponentListener adsMediaSource$ComponentListener, AdPlaybackState adPlaybackState) {
        this.a = adsMediaSource$ComponentListener;
        this.b = adPlaybackState;
    }

    public final void run() {
        AdsMediaSource$ComponentListener adsMediaSource$ComponentListener = this.a;
        AdPlaybackState adPlaybackState = this.b;
        adsMediaSource$ComponentListener.b(adPlaybackState);
    }
}

