/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MaskingMediaPeriod$PrepareListener;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.ads.AdsMediaSource$AdLoadException;
import com.google.android.exoplayer2.upstream.DataSpec;
import d.h.a.a.m0.m.b;
import d.h.a.a.m0.m.c;
import java.io.IOException;

public final class AdsMediaSource$AdPrepareListener
implements MaskingMediaPeriod$PrepareListener {
    private final Uri adUri;
    public final /* synthetic */ AdsMediaSource this$0;

    public AdsMediaSource$AdPrepareListener(AdsMediaSource adsMediaSource, Uri uri) {
        this.this$0 = adsMediaSource;
        this.adUri = uri;
    }

    private /* synthetic */ void a(MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        AdsLoader adsLoader = AdsMediaSource.access$400(this.this$0);
        AdsMediaSource adsMediaSource = this.this$0;
        int n10 = mediaSource$MediaPeriodId.adGroupIndex;
        int n11 = mediaSource$MediaPeriodId.adIndexInAdGroup;
        adsLoader.handlePrepareComplete(adsMediaSource, n10, n11);
    }

    private /* synthetic */ void c(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, IOException iOException) {
        AdsLoader adsLoader = AdsMediaSource.access$400(this.this$0);
        AdsMediaSource adsMediaSource = this.this$0;
        int n10 = mediaSource$MediaPeriodId.adGroupIndex;
        int n11 = mediaSource$MediaPeriodId.adIndexInAdGroup;
        adsLoader.handlePrepareError(adsMediaSource, n10, n11, iOException);
    }

    public /* synthetic */ void b(MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        this.a(mediaSource$MediaPeriodId);
    }

    public /* synthetic */ void d(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, IOException iOException) {
        this.c(mediaSource$MediaPeriodId, iOException);
    }

    public void onPrepareComplete(MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        Handler handler = AdsMediaSource.access$200(this.this$0);
        c c10 = new c(this, mediaSource$MediaPeriodId);
        handler.post((Runnable)c10);
    }

    public void onPrepareError(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, IOException iOException) {
        LoadEventInfo loadEventInfo;
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = AdsMediaSource.access$300(this.this$0, mediaSource$MediaPeriodId);
        long l10 = LoadEventInfo.getNewId();
        Object object = this.adUri;
        DataSpec dataSpec = new DataSpec((Uri)object);
        long l11 = SystemClock.elapsedRealtime();
        object = loadEventInfo;
        loadEventInfo = new LoadEventInfo(l10, dataSpec, l11);
        object = AdsMediaSource$AdLoadException.createForAd(iOException);
        mediaSourceEventListener$EventDispatcher.loadError(loadEventInfo, 6, (IOException)object, true);
        mediaSourceEventListener$EventDispatcher = AdsMediaSource.access$200(this.this$0);
        object = new b(this, mediaSource$MediaPeriodId, iOException);
        mediaSourceEventListener$EventDispatcher.post((Runnable)object);
    }
}

