/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 */
package com.google.android.exoplayer2.source.ads;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.MediaItem$DrmConfiguration;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ads.AdPlaybackState;
import com.google.android.exoplayer2.source.ads.AdPlaybackState$AdGroup;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsLoader$AdViewProvider;
import com.google.android.exoplayer2.source.ads.AdsMediaSource$AdMediaSourceHolder;
import com.google.android.exoplayer2.source.ads.AdsMediaSource$ComponentListener;
import com.google.android.exoplayer2.source.ads.SinglePeriodAdTimeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import d.h.a.a.m0.m.a;
import d.h.a.a.m0.m.d;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class AdsMediaSource
extends CompositeMediaSource {
    private static final MediaSource$MediaPeriodId CHILD_SOURCE_MEDIA_PERIOD_ID;
    private final MediaSourceFactory adMediaSourceFactory;
    private AdsMediaSource$AdMediaSourceHolder[][] adMediaSourceHolders;
    private AdPlaybackState adPlaybackState;
    private final DataSpec adTagDataSpec;
    private final AdsLoader$AdViewProvider adViewProvider;
    private final Object adsId;
    private final AdsLoader adsLoader;
    private AdsMediaSource$ComponentListener componentListener;
    private final MediaSource contentMediaSource;
    private Timeline contentTimeline;
    private final Handler mainHandler;
    private final Timeline$Period period;

    static {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId;
        Object object = new Object();
        CHILD_SOURCE_MEDIA_PERIOD_ID = mediaSource$MediaPeriodId = new MediaSource$MediaPeriodId(object);
    }

    public AdsMediaSource(MediaSource object, DataSpec dataSpec, Object object2, MediaSourceFactory mediaSourceFactory, AdsLoader adsLoader, AdsLoader$AdViewProvider adsLoader$AdViewProvider) {
        this.contentMediaSource = object;
        this.adMediaSourceFactory = mediaSourceFactory;
        this.adsLoader = adsLoader;
        this.adViewProvider = adsLoader$AdViewProvider;
        this.adTagDataSpec = dataSpec;
        this.adsId = object2;
        dataSpec = Looper.getMainLooper();
        super((Looper)dataSpec);
        this.mainHandler = object;
        object = new Timeline$Period();
        this.period = object;
        object = new AdsMediaSource$AdMediaSourceHolder[][]{};
        this.adMediaSourceHolders = object;
        object = mediaSourceFactory.getSupportedTypes();
        adsLoader.setSupportedContentTypes((int[])object);
    }

    public static /* synthetic */ MediaSourceEventListener$EventDispatcher access$000(AdsMediaSource adsMediaSource, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        return adsMediaSource.createEventDispatcher(mediaSource$MediaPeriodId);
    }

    public static /* synthetic */ void access$100(AdsMediaSource adsMediaSource, AdPlaybackState adPlaybackState) {
        adsMediaSource.onAdPlaybackState(adPlaybackState);
    }

    public static /* synthetic */ Handler access$200(AdsMediaSource adsMediaSource) {
        return adsMediaSource.mainHandler;
    }

    public static /* synthetic */ MediaSourceEventListener$EventDispatcher access$300(AdsMediaSource adsMediaSource, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        return adsMediaSource.createEventDispatcher(mediaSource$MediaPeriodId);
    }

    public static /* synthetic */ AdsLoader access$400(AdsMediaSource adsMediaSource) {
        return adsMediaSource.adsLoader;
    }

    public static /* synthetic */ void access$500(AdsMediaSource adsMediaSource, Object object, MediaSource mediaSource) {
        adsMediaSource.prepareChildSource(object, mediaSource);
    }

    public static /* synthetic */ Timeline$Period access$600(AdsMediaSource adsMediaSource) {
        return adsMediaSource.period;
    }

    public static /* synthetic */ void access$700(AdsMediaSource adsMediaSource, Object object) {
        adsMediaSource.releaseChildSource(object);
    }

    private /* synthetic */ void c(AdsMediaSource$ComponentListener adsMediaSource$ComponentListener) {
        AdsLoader adsLoader = this.adsLoader;
        DataSpec dataSpec = this.adTagDataSpec;
        Object object = this.adsId;
        AdsLoader$AdViewProvider adsLoader$AdViewProvider = this.adViewProvider;
        adsLoader.start(this, dataSpec, object, adsLoader$AdViewProvider, adsMediaSource$ComponentListener);
    }

    private /* synthetic */ void e(AdsMediaSource$ComponentListener adsMediaSource$ComponentListener) {
        this.adsLoader.stop(this, adsMediaSource$ComponentListener);
    }

    private long[][] getAdDurationsUs() {
        Object object;
        int n10;
        int n11 = this.adMediaSourceHolders.length;
        long[][] lArrayArray = new long[n11][];
        for (int i10 = 0; i10 < (n10 = ((AdsMediaSource$AdMediaSourceHolder[][])(object = this.adMediaSourceHolders)).length); ++i10) {
            Object object2;
            Object[] objectArray;
            int n12;
            object = new long[object[i10].length];
            lArrayArray[i10] = (long[])object;
            object = null;
            for (int i11 = 0; i11 < (n12 = (objectArray = (object2 = this.adMediaSourceHolders)[i10]).length); ++i11) {
                object2 = object2[i10][i11];
                objectArray = lArrayArray[i10];
                long l10 = object2 == null ? -9223372036854775807L : ((AdsMediaSource$AdMediaSourceHolder)object2).getDurationUs();
                objectArray[i11] = (AdsMediaSource$AdMediaSourceHolder)l10;
            }
        }
        return lArrayArray;
    }

    private void maybeUpdateAdMediaSources() {
        AdsMediaSource$AdMediaSourceHolder[][] adsMediaSource$AdMediaSourceHolderArray;
        int n10;
        AdPlaybackState adPlaybackState = this.adPlaybackState;
        if (adPlaybackState == null) {
            return;
        }
        for (int i10 = 0; i10 < (n10 = (adsMediaSource$AdMediaSourceHolderArray = this.adMediaSourceHolders).length); ++i10) {
            Object object;
            Uri uri;
            int n11;
            adsMediaSource$AdMediaSourceHolderArray = null;
            for (n10 = 0; n10 < (n11 = ((AdsMediaSource$AdMediaSourceHolder[])(uri = (object = this.adMediaSourceHolders)[i10])).length); ++n10) {
                int n12;
                Object object2;
                if ((object = object[i10][n10]) == null || (n11 = (int)(((AdsMediaSource$AdMediaSourceHolder)object).hasMediaSource() ? 1 : 0)) != 0 || (object2 = (uri = adPlaybackState.adGroups)[i10]) == null || n10 >= (n12 = ((Uri[])(object2 = ((AdPlaybackState$AdGroup)uri[i10]).uris)).length) || (uri = ((AdPlaybackState$AdGroup)uri[i10]).uris[n10]) == null) continue;
                object2 = new MediaItem$Builder();
                object2 = ((MediaItem$Builder)object2).setUri(uri);
                Object object3 = this.contentMediaSource.getMediaItem().playbackProperties;
                if (object3 != null && (object3 = ((MediaItem$PlaybackProperties)object3).drmConfiguration) != null) {
                    Object object4 = ((MediaItem$DrmConfiguration)object3).uuid;
                    ((MediaItem$Builder)object2).setDrmUuid((UUID)object4);
                    object4 = ((MediaItem$DrmConfiguration)object3).getKeySetId();
                    ((MediaItem$Builder)object2).setDrmKeySetId((byte[])object4);
                    object4 = ((MediaItem$DrmConfiguration)object3).licenseUri;
                    ((MediaItem$Builder)object2).setDrmLicenseUri((Uri)object4);
                    boolean bl2 = ((MediaItem$DrmConfiguration)object3).forceDefaultLicenseUri;
                    ((MediaItem$Builder)object2).setDrmForceDefaultLicenseUri(bl2);
                    object4 = ((MediaItem$DrmConfiguration)object3).requestHeaders;
                    ((MediaItem$Builder)object2).setDrmLicenseRequestHeaders((Map)object4);
                    bl2 = ((MediaItem$DrmConfiguration)object3).multiSession;
                    ((MediaItem$Builder)object2).setDrmMultiSession(bl2);
                    bl2 = ((MediaItem$DrmConfiguration)object3).playClearContentWithoutKey;
                    ((MediaItem$Builder)object2).setDrmPlayClearContentWithoutKey(bl2);
                    object3 = ((MediaItem$DrmConfiguration)object3).sessionForClearTypes;
                    ((MediaItem$Builder)object2).setDrmSessionForClearTypes((List)object3);
                }
                object3 = this.adMediaSourceFactory;
                object2 = ((MediaItem$Builder)object2).build();
                object2 = object3.createMediaSource((MediaItem)object2);
                ((AdsMediaSource$AdMediaSourceHolder)object).initializeWithMediaSource((MediaSource)object2, uri);
            }
        }
    }

    private void maybeUpdateSourceInfo() {
        Object object = this.contentTimeline;
        Object object2 = this.adPlaybackState;
        if (object2 != null && object != null) {
            Object object3 = this.getAdDurationsUs();
            object2 = ((AdPlaybackState)object2).withAdDurationsUs((long[][])object3);
            this.adPlaybackState = object2;
            int n10 = ((AdPlaybackState)object2).adGroupCount;
            if (n10 != 0) {
                object3 = this.adPlaybackState;
                object = object2 = new SinglePeriodAdTimeline((Timeline)object, (AdPlaybackState)object3);
            }
            this.refreshSourceInfo((Timeline)object);
        }
    }

    private void onAdPlaybackState(AdPlaybackState adPlaybackState) {
        AdsMediaSource$AdMediaSourceHolder[][] adsMediaSource$AdMediaSourceHolderArrayArray = this.adPlaybackState;
        if (adsMediaSource$AdMediaSourceHolderArrayArray == null) {
            int n10 = adPlaybackState.adGroupCount;
            adsMediaSource$AdMediaSourceHolderArrayArray = new AdsMediaSource$AdMediaSourceHolder[n10][];
            this.adMediaSourceHolders = adsMediaSource$AdMediaSourceHolderArrayArray;
            AdsMediaSource$AdMediaSourceHolder[] adsMediaSource$AdMediaSourceHolderArray = new AdsMediaSource$AdMediaSourceHolder[]{};
            Arrays.fill((Object[])adsMediaSource$AdMediaSourceHolderArrayArray, adsMediaSource$AdMediaSourceHolderArray);
        }
        this.adPlaybackState = adPlaybackState;
        this.maybeUpdateAdMediaSources();
        this.maybeUpdateSourceInfo();
    }

    public MediaPeriod createPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Allocator object, long l10) {
        Object object2 = (AdPlaybackState)Assertions.checkNotNull(this.adPlaybackState);
        int n10 = ((AdPlaybackState)object2).adGroupCount;
        if (n10 > 0 && (n10 = (int)(mediaSource$MediaPeriodId.isAd() ? 1 : 0)) != 0) {
            Object object3 = this.adMediaSourceHolders;
            n10 = mediaSource$MediaPeriodId.adGroupIndex;
            AdsMediaSource$AdMediaSourceHolder[] adsMediaSource$AdMediaSourceHolderArray = object3[n10];
            int n11 = adsMediaSource$AdMediaSourceHolderArray.length;
            int n12 = mediaSource$MediaPeriodId.adIndexInAdGroup;
            if (n11 <= n12) {
                n11 = n12 + 1;
                AdsMediaSource$AdMediaSourceHolder[] adsMediaSource$AdMediaSourceHolderArray2 = object3[n10];
                adsMediaSource$AdMediaSourceHolderArray = Arrays.copyOf(adsMediaSource$AdMediaSourceHolderArray2, n11);
                object3[n10] = adsMediaSource$AdMediaSourceHolderArray;
            }
            if ((object3 = this.adMediaSourceHolders[n10][n12]) == null) {
                object3 = new AdsMediaSource$AdMediaSourceHolder(this, mediaSource$MediaPeriodId);
                adsMediaSource$AdMediaSourceHolderArray = this.adMediaSourceHolders;
                object2 = adsMediaSource$AdMediaSourceHolderArray[n10];
                object2[n12] = object3;
                this.maybeUpdateAdMediaSources();
            }
            return object3.createMediaPeriod(mediaSource$MediaPeriodId, (Allocator)object, l10);
        }
        object2 = new MaskingMediaPeriod(mediaSource$MediaPeriodId, (Allocator)object, l10);
        object = this.contentMediaSource;
        ((MaskingMediaPeriod)object2).setMediaSource((MediaSource)object);
        ((MaskingMediaPeriod)object2).createPeriod(mediaSource$MediaPeriodId);
        return object2;
    }

    public /* synthetic */ void d(AdsMediaSource$ComponentListener adsMediaSource$ComponentListener) {
        this.c(adsMediaSource$ComponentListener);
    }

    public /* synthetic */ void f(AdsMediaSource$ComponentListener adsMediaSource$ComponentListener) {
        this.e(adsMediaSource$ComponentListener);
    }

    public MediaItem getMediaItem() {
        return this.contentMediaSource.getMediaItem();
    }

    public MediaSource$MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, MediaSource$MediaPeriodId mediaSource$MediaPeriodId2) {
        boolean bl2 = mediaSource$MediaPeriodId.isAd();
        if (!bl2) {
            mediaSource$MediaPeriodId = mediaSource$MediaPeriodId2;
        }
        return mediaSource$MediaPeriodId;
    }

    public Object getTag() {
        return this.contentMediaSource.getTag();
    }

    public void onChildSourceInfoRefreshed(MediaSource$MediaPeriodId object, MediaSource adsMediaSource$AdMediaSourceHolderArray, Timeline timeline) {
        boolean n10 = ((MediaPeriodId)object).isAd();
        if (n10) {
            int n11 = ((MediaPeriodId)object).adGroupIndex;
            int n12 = ((MediaPeriodId)object).adIndexInAdGroup;
            AdsMediaSource$AdMediaSourceHolder[][] adsMediaSource$AdMediaSourceHolderArray2 = this.adMediaSourceHolders;
            adsMediaSource$AdMediaSourceHolderArray = adsMediaSource$AdMediaSourceHolderArray2[n11];
            object = (AdsMediaSource$AdMediaSourceHolder)Assertions.checkNotNull(adsMediaSource$AdMediaSourceHolderArray[n12]);
            ((AdsMediaSource$AdMediaSourceHolder)object).handleSourceInfoRefresh(timeline);
        } else {
            boolean bl2;
            int n13;
            int n14 = timeline.getPeriodCount();
            if (n14 != (n13 = 1)) {
                bl2 = false;
                adsMediaSource$AdMediaSourceHolderArray = null;
            }
            Assertions.checkArgument(bl2);
            this.contentTimeline = timeline;
        }
        this.maybeUpdateSourceInfo();
    }

    public void prepareSourceInternal(TransferListener object) {
        super.prepareSourceInternal((TransferListener)object);
        this.componentListener = object = new AdsMediaSource$ComponentListener(this);
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = CHILD_SOURCE_MEDIA_PERIOD_ID;
        Object object2 = this.contentMediaSource;
        this.prepareChildSource(mediaSource$MediaPeriodId, (MediaSource)object2);
        mediaSource$MediaPeriodId = this.mainHandler;
        object2 = new a(this, (AdsMediaSource$ComponentListener)object);
        mediaSource$MediaPeriodId.post((Runnable)object2);
    }

    public void releasePeriod(MediaPeriod adsMediaSource$AdMediaSourceHolderArray) {
        adsMediaSource$AdMediaSourceHolderArray = (MaskingMediaPeriod)adsMediaSource$AdMediaSourceHolderArray;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = adsMediaSource$AdMediaSourceHolderArray.id;
        int n10 = mediaSource$MediaPeriodId.isAd();
        if (n10 != 0) {
            Object object = this.adMediaSourceHolders;
            int n11 = mediaSource$MediaPeriodId.adGroupIndex;
            object = object[n11];
            n11 = mediaSource$MediaPeriodId.adIndexInAdGroup;
            object = (AdsMediaSource$AdMediaSourceHolder)Assertions.checkNotNull(object[n11]);
            ((AdsMediaSource$AdMediaSourceHolder)object).releaseMediaPeriod((MaskingMediaPeriod)adsMediaSource$AdMediaSourceHolderArray);
            boolean bl2 = ((AdsMediaSource$AdMediaSourceHolder)object).isInactive();
            if (bl2) {
                ((AdsMediaSource$AdMediaSourceHolder)object).release();
                adsMediaSource$AdMediaSourceHolderArray = this.adMediaSourceHolders;
                n10 = mediaSource$MediaPeriodId.adGroupIndex;
                adsMediaSource$AdMediaSourceHolderArray = adsMediaSource$AdMediaSourceHolderArray[n10];
                int n12 = mediaSource$MediaPeriodId.adIndexInAdGroup;
                n10 = 0;
                object = null;
                adsMediaSource$AdMediaSourceHolderArray[n12] = null;
            }
        } else {
            adsMediaSource$AdMediaSourceHolderArray.releasePeriod();
        }
    }

    public void releaseSourceInternal() {
        super.releaseSourceInternal();
        AdsMediaSource$ComponentListener adsMediaSource$ComponentListener = (AdsMediaSource$ComponentListener)Assertions.checkNotNull(this.componentListener);
        this.componentListener = null;
        adsMediaSource$ComponentListener.stop();
        this.contentTimeline = null;
        this.adPlaybackState = null;
        Handler handler = new Handler[][]{};
        this.adMediaSourceHolders = handler;
        handler = this.mainHandler;
        d d10 = new d(this, adsMediaSource$ComponentListener);
        handler.post((Runnable)d10);
    }
}

