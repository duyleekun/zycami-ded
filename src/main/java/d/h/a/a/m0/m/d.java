/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0.m;

import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.ads.AdsMediaSource$ComponentListener;

public final class d
implements Runnable {
    public final /* synthetic */ AdsMediaSource a;
    public final /* synthetic */ AdsMediaSource$ComponentListener b;

    public /* synthetic */ d(AdsMediaSource adsMediaSource, AdsMediaSource$ComponentListener adsMediaSource$ComponentListener) {
        this.a = adsMediaSource;
        this.b = adsMediaSource$ComponentListener;
    }

    public final void run() {
        AdsMediaSource adsMediaSource = this.a;
        AdsMediaSource$ComponentListener adsMediaSource$ComponentListener = this.b;
        adsMediaSource.f(adsMediaSource$ComponentListener);
    }
}

