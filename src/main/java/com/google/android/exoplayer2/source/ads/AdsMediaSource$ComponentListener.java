/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.source.ads;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.AdsLoader$EventListener;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.ads.AdsMediaSource$AdLoadException;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.m0.m.e;
import java.io.IOException;

public final class AdsMediaSource$ComponentListener
implements AdsLoader$EventListener {
    private final Handler playerHandler;
    private volatile boolean stopped;
    public final /* synthetic */ AdsMediaSource this$0;

    public AdsMediaSource$ComponentListener(AdsMediaSource adsMediaSource) {
        this.this$0 = adsMediaSource;
        adsMediaSource = Util.createHandlerForCurrentLooper();
        this.playerHandler = adsMediaSource;
    }

    private /* synthetic */ void a(AdPlaybackState adPlaybackState) {
        boolean bl2 = this.stopped;
        if (bl2) {
            return;
        }
        AdsMediaSource.access$100(this.this$0, adPlaybackState);
    }

    public /* synthetic */ void b(AdPlaybackState adPlaybackState) {
        this.a(adPlaybackState);
    }

    public void onAdLoadError(AdsMediaSource$AdLoadException adsMediaSource$AdLoadException, DataSpec dataSpec) {
        boolean bl2 = this.stopped;
        if (bl2) {
            return;
        }
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = AdsMediaSource.access$000(this.this$0, null);
        long l10 = LoadEventInfo.getNewId();
        long l11 = SystemClock.elapsedRealtime();
        LoadEventInfo loadEventInfo = new LoadEventInfo(l10, dataSpec, l11);
        mediaSourceEventListener$EventDispatcher.loadError(loadEventInfo, 6, (IOException)adsMediaSource$AdLoadException, true);
    }

    public void onAdPlaybackState(AdPlaybackState adPlaybackState) {
        boolean bl2 = this.stopped;
        if (bl2) {
            return;
        }
        Handler handler = this.playerHandler;
        e e10 = new e(this, adPlaybackState);
        handler.post((Runnable)e10);
    }

    public void stop() {
        this.stopped = true;
        this.playerHandler.removeCallbacksAndMessages(null);
    }
}

