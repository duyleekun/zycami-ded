/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.m0.m;

import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.ads.AdsMediaSource$ComponentListener;

public final class a
implements Runnable {
    public final /* synthetic */ AdsMediaSource a;
    public final /* synthetic */ AdsMediaSource.ComponentListener b;

    public /* synthetic */ a(AdsMediaSource adsMediaSource, AdsMediaSource.ComponentListener componentListener) {
        this.a = adsMediaSource;
        this.b = componentListener;
    }

    public final void run() {
        AdsMediaSource adsMediaSource = this.a;
        AdsMediaSource.ComponentListener componentListener = this.b;
        adsMediaSource.d(componentListener);
    }
}

