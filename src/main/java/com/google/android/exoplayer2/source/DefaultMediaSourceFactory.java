/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.util.Pair
 *  android.util.SparseArray
 *  com.google.android.exoplayer2.source.MergingMediaSource
 */
package com.google.android.exoplayer2.source;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$AdsConfiguration;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.MediaItem$ClippingProperties;
import com.google.android.exoplayer2.MediaItem$LiveConfiguration;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.MediaItem$Subtitle;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ClippingMediaSource;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory$AdsLoaderProvider;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.MergingMediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource$Factory;
import com.google.android.exoplayer2.source.SingleSampleMediaSource$Factory;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsLoader$AdViewProvider;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.HttpDataSource$Factory;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;

public final class DefaultMediaSourceFactory
implements MediaSourceFactory {
    private static final String TAG = "DefaultMediaSourceFactory";
    private AdsLoader$AdViewProvider adViewProvider;
    private DefaultMediaSourceFactory$AdsLoaderProvider adsLoaderProvider;
    private final DataSource$Factory dataSourceFactory;
    private long liveMaxOffsetMs;
    private float liveMaxSpeed;
    private long liveMinOffsetMs;
    private float liveMinSpeed;
    private long liveTargetOffsetMs;
    private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final SparseArray mediaSourceFactories;
    private final int[] supportedTypes;

    public DefaultMediaSourceFactory(Context context) {
        DefaultDataSourceFactory defaultDataSourceFactory = new DefaultDataSourceFactory(context);
        this(defaultDataSourceFactory);
    }

    public DefaultMediaSourceFactory(Context context, ExtractorsFactory extractorsFactory) {
        DefaultDataSourceFactory defaultDataSourceFactory = new DefaultDataSourceFactory(context);
        this(defaultDataSourceFactory, extractorsFactory);
    }

    public DefaultMediaSourceFactory(DataSource$Factory dataSource$Factory) {
        DefaultExtractorsFactory defaultExtractorsFactory = new DefaultExtractorsFactory();
        this(dataSource$Factory, (ExtractorsFactory)defaultExtractorsFactory);
    }

    public DefaultMediaSourceFactory(DataSource$Factory object, ExtractorsFactory object2) {
        long l10;
        int n10;
        this.dataSourceFactory = object;
        object = DefaultMediaSourceFactory.loadDelegates((DataSource$Factory)object, (ExtractorsFactory)object2);
        this.mediaSourceFactories = object;
        object = new int[object.size()];
        this.supportedTypes = (int[])object;
        float f10 = 0.0f;
        object = null;
        for (int i10 = 0; i10 < (n10 = (object2 = this.mediaSourceFactories).size()); ++i10) {
            object2 = this.supportedTypes;
            SparseArray sparseArray = this.mediaSourceFactories;
            int n11 = sparseArray.keyAt(i10);
            object2[i10] = n11;
        }
        this.liveTargetOffsetMs = l10 = -9223372036854775807L;
        this.liveMinOffsetMs = l10;
        this.liveMaxOffsetMs = l10;
        this.liveMinSpeed = f10 = -3.4028235E38f;
        this.liveMaxSpeed = f10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static SparseArray loadDelegates(DataSource$Factory dataSource$Factory, ExtractorsFactory extractorsFactory) {
        Object[] objectArray;
        Object object = DataSource$Factory.class;
        Object[] objectArray2 = MediaSourceFactory.class;
        SparseArray sparseArray = new SparseArray();
        int n10 = 1;
        Object object2 = "com.google.android.exoplayer2.source.dash.DashMediaSource$Factory";
        try {
            object2 = Class.forName((String)object2);
            object2 = ((Class)object2).asSubclass(objectArray2);
            objectArray = new Class[n10];
            objectArray[0] = object;
            object2 = ((Class)object2).getConstructor((Class<?>[])objectArray);
            objectArray = new Object[n10];
            objectArray[0] = dataSource$Factory;
            object2 = ((Constructor)object2).newInstance(objectArray);
            object2 = (MediaSourceFactory)object2;
            sparseArray.put(0, object2);
        }
        catch (Exception exception) {}
        object2 = "com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory";
        try {
            object2 = Class.forName(object2);
            object2 = ((Class)object2).asSubclass(objectArray2);
            objectArray = new Class[n10];
            objectArray[0] = object;
            object2 = ((Class)object2).getConstructor((Class<?>[])objectArray);
            objectArray = new Object[n10];
            objectArray[0] = dataSource$Factory;
            object2 = ((Constructor)object2).newInstance(objectArray);
            object2 = (MediaSourceFactory)object2;
            sparseArray.put(n10, object2);
        }
        catch (Exception exception) {}
        object2 = "com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory";
        try {
            object2 = Class.forName(object2);
            objectArray2 = ((Class)object2).asSubclass(objectArray2);
            int n11 = 2;
            objectArray = new Class[n10];
            objectArray[0] = object;
            object = objectArray2.getConstructor((Class<?>[])objectArray);
            objectArray2 = new Object[n10];
            objectArray2[0] = dataSource$Factory;
            object = ((Constructor)object).newInstance(objectArray2);
            object = (MediaSourceFactory)object;
            sparseArray.put(n11, object);
        }
        catch (Exception exception) {}
        objectArray2 = new ProgressiveMediaSource$Factory(dataSource$Factory, extractorsFactory);
        sparseArray.put(3, objectArray2);
        return sparseArray;
    }

    private static MediaSource maybeClipMediaSource(MediaItem object, MediaSource mediaSource) {
        boolean bl2;
        long l10;
        long l11;
        Object object2 = ((MediaItem)object).clippingProperties;
        long l12 = ((MediaItem$ClippingProperties)object2).startPositionMs;
        long l13 = 0L;
        long l14 = l12 - l13;
        Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object3 == false && (object3 = (l11 = (l13 = ((MediaItem$ClippingProperties)object2).endPositionMs) - (l10 = Long.MIN_VALUE)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false && !(bl2 = ((MediaItem$ClippingProperties)object2).relativeToDefaultPosition)) {
            return mediaSource;
        }
        l10 = C.msToUs(l12);
        long l15 = C.msToUs(object.clippingProperties.endPositionMs);
        object = ((MediaItem)object).clippingProperties;
        boolean bl3 = ((MediaItem$ClippingProperties)object).startsAtKeyFrame ^ true;
        boolean bl4 = ((MediaItem$ClippingProperties)object).relativeToLiveWindow;
        boolean bl5 = ((MediaItem$ClippingProperties)object).relativeToDefaultPosition;
        object2 = new ClippingMediaSource(mediaSource, l10, l15, bl3, bl4, bl5);
        return object2;
    }

    private MediaSource maybeWrapWithAdsMediaSource(MediaItem object, MediaSource mediaSource) {
        Assertions.checkNotNull(((MediaItem)object).playbackProperties);
        MediaItem$AdsConfiguration mediaItem$AdsConfiguration = object.playbackProperties.adsConfiguration;
        if (mediaItem$AdsConfiguration == null) {
            return mediaSource;
        }
        Object object2 = this.adsLoaderProvider;
        AdsLoader$AdViewProvider adsLoader$AdViewProvider = this.adViewProvider;
        Object object3 = TAG;
        if (object2 != null && adsLoader$AdViewProvider != null) {
            Object object4;
            AdsLoader adsLoader = object2.getAdsLoader(mediaItem$AdsConfiguration);
            if (adsLoader == null) {
                Log.w((String)object3, "Playing media without ads, as no AdsLoader was provided.");
                return mediaSource;
            }
            object3 = mediaItem$AdsConfiguration.adTagUri;
            DataSpec dataSpec = new DataSpec((Uri)object3);
            object3 = mediaItem$AdsConfiguration.adsId;
            if (object3 != null) {
                object4 = object3;
            } else {
                object = ((MediaItem)object).mediaId;
                mediaItem$AdsConfiguration = mediaItem$AdsConfiguration.adTagUri;
                object4 = object = Pair.create((Object)object, (Object)mediaItem$AdsConfiguration);
            }
            object3 = object2;
            object2 = new AdsMediaSource(mediaSource, dataSpec, object4, this, adsLoader, adsLoader$AdViewProvider);
            return object2;
        }
        Log.w((String)object3, "Playing media without ads. Configure ad support by calling setAdsLoaderProvider and setAdViewProvider.");
        return mediaSource;
    }

    public MediaSource createMediaSource(MediaItem object) {
        Object object2;
        long l10;
        long l11;
        long l12;
        long l13;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        long l14;
        long l15;
        Assertions.checkNotNull(((MediaItem)object).playbackProperties);
        Object object3 = ((MediaItem)object).playbackProperties;
        Object object4 = ((MediaItem$PlaybackProperties)object3).uri;
        object3 = ((MediaItem$PlaybackProperties)object3).mimeType;
        int n10 = Util.inferContentTypeForUriAndMimeType((Uri)object4, (String)object3);
        object4 = (MediaSourceFactory)this.mediaSourceFactories.get(n10);
        MediaSource[] mediaSourceArray = new StringBuilder(68);
        Object object5 = "No suitable media source factory found for content type: ";
        mediaSourceArray.append((String)object5);
        mediaSourceArray.append(n10);
        object3 = mediaSourceArray.toString();
        Assertions.checkNotNull(object4, object3);
        object3 = ((MediaItem)object).liveConfiguration;
        long l16 = ((MediaItem$LiveConfiguration)object3).targetOffsetMs;
        long l17 = -9223372036854775807L;
        Object object6 = l16 == l17 ? 0 : (l16 < l17 ? -1 : 1);
        int n11 = -8388609;
        float f15 = -3.4028235E38f;
        if (object6 == false && (object6 = (l15 = (l14 = this.liveTargetOffsetMs) - l17) == 0L ? 0 : (l15 < 0L ? -1 : 1)) != false || (object6 = (Object)((f14 = (f13 = ((MediaItem$LiveConfiguration)object3).minPlaybackSpeed) - f15) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1))) == false && (object6 = (Object)((f12 = (f13 = this.liveMinSpeed) - f15) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) != false || (object6 = (Object)((f11 = (f13 = ((MediaItem$LiveConfiguration)object3).maxPlaybackSpeed) - f15) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) == false && (object6 = (Object)((f10 = (f13 = this.liveMaxSpeed) - f15) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1))) != false || (object6 = (l13 = (l14 = ((MediaItem$LiveConfiguration)object3).minOffsetMs) - l17) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == false && (object6 = (l12 = (l14 = this.liveMinOffsetMs) - l17) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false || (n10 = (int)((l11 = (l14 = ((MediaItem$LiveConfiguration)object3).maxOffsetMs) - l17) == 0L ? 0 : (l11 < 0L ? -1 : 1))) == 0 && (n10 = (int)((l10 = (l14 = this.liveMaxOffsetMs) - l17) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
            object3 = ((MediaItem)object).buildUpon();
            mediaSourceArray = ((MediaItem)object).liveConfiguration;
            l14 = mediaSourceArray.targetOffsetMs;
            long l18 = l14 - l17;
            object6 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object6 == false) {
                l14 = this.liveTargetOffsetMs;
            }
            object3 = ((MediaItem$Builder)object3).setLiveTargetOffsetMs(l14);
            mediaSourceArray = ((MediaItem)object).liveConfiguration;
            f13 = mediaSourceArray.minPlaybackSpeed;
            float f16 = f13 - f15;
            object2 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
            if (object2 == false) {
                f13 = this.liveMinSpeed;
            }
            object3 = ((MediaItem$Builder)object3).setLiveMinPlaybackSpeed(f13);
            mediaSourceArray = ((MediaItem)object).liveConfiguration;
            f13 = mediaSourceArray.maxPlaybackSpeed;
            float f17 = f13 - f15;
            n11 = (int)(f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1));
            if (n11 == 0) {
                f13 = this.liveMaxSpeed;
            }
            object3 = ((MediaItem$Builder)object3).setLiveMaxPlaybackSpeed(f13);
            mediaSourceArray = ((MediaItem)object).liveConfiguration;
            l16 = mediaSourceArray.minOffsetMs;
            long l19 = l16 - l17;
            object2 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
            if (object2 == false) {
                l16 = this.liveMinOffsetMs;
            }
            object3 = ((MediaItem$Builder)object3).setLiveMinOffsetMs(l16);
            object = ((MediaItem)object).liveConfiguration;
            l16 = ((MediaItem$LiveConfiguration)object).maxOffsetMs;
            long l20 = l16 - l17;
            Object object7 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
            if (object7 == false) {
                l16 = this.liveMaxOffsetMs;
            }
            object = ((MediaItem$Builder)object3).setLiveMaxOffsetMs(l16).build();
        }
        object3 = object4.createMediaSource((MediaItem)object);
        object4 = ((MediaItem$PlaybackProperties)Util.castNonNull((Object)object.playbackProperties)).subtitles;
        object6 = object4.isEmpty();
        if (object6 == false) {
            object6 = object4.size() + 1;
            mediaSourceArray = new MediaSource[object6];
            n11 = 0;
            f15 = 0.0f;
            object5 = null;
            mediaSourceArray[0] = object3;
            Object object8 = this.dataSourceFactory;
            object3 = new SingleSampleMediaSource$Factory((DataSource$Factory)object8);
            object8 = this.loadErrorHandlingPolicy;
            object3 = ((SingleSampleMediaSource$Factory)object3).setLoadErrorHandlingPolicy((LoadErrorHandlingPolicy)object8);
            while (n11 < (object2 = (Object)object4.size())) {
                object2 = n11 + 1;
                object5 = (MediaItem$Subtitle)object4.get(n11);
                mediaSourceArray[object2] = object5 = ((SingleSampleMediaSource$Factory)object3).createMediaSource((MediaItem$Subtitle)object5, l17);
                n11 = (int)object2;
            }
            object3 = new MergingMediaSource(mediaSourceArray);
        }
        object3 = DefaultMediaSourceFactory.maybeClipMediaSource((MediaItem)object, (MediaSource)object3);
        return this.maybeWrapWithAdsMediaSource((MediaItem)object, (MediaSource)object3);
    }

    public int[] getSupportedTypes() {
        int[] nArray = this.supportedTypes;
        int n10 = nArray.length;
        return Arrays.copyOf(nArray, n10);
    }

    public DefaultMediaSourceFactory setAdViewProvider(AdsLoader$AdViewProvider adsLoader$AdViewProvider) {
        this.adViewProvider = adsLoader$AdViewProvider;
        return this;
    }

    public DefaultMediaSourceFactory setAdsLoaderProvider(DefaultMediaSourceFactory$AdsLoaderProvider defaultMediaSourceFactory$AdsLoaderProvider) {
        this.adsLoaderProvider = defaultMediaSourceFactory$AdsLoaderProvider;
        return this;
    }

    public DefaultMediaSourceFactory setDrmHttpDataSourceFactory(HttpDataSource$Factory httpDataSource$Factory) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.mediaSourceFactories).size()); ++i10) {
            object = (MediaSourceFactory)this.mediaSourceFactories.valueAt(i10);
            object.setDrmHttpDataSourceFactory(httpDataSource$Factory);
        }
        return this;
    }

    public DefaultMediaSourceFactory setDrmSessionManager(DrmSessionManager drmSessionManager) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.mediaSourceFactories).size()); ++i10) {
            object = (MediaSourceFactory)this.mediaSourceFactories.valueAt(i10);
            object.setDrmSessionManager(drmSessionManager);
        }
        return this;
    }

    public DefaultMediaSourceFactory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.mediaSourceFactories).size()); ++i10) {
            object = (MediaSourceFactory)this.mediaSourceFactories.valueAt(i10);
            object.setDrmSessionManagerProvider(drmSessionManagerProvider);
        }
        return this;
    }

    public DefaultMediaSourceFactory setDrmUserAgent(String string2) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.mediaSourceFactories).size()); ++i10) {
            object = (MediaSourceFactory)this.mediaSourceFactories.valueAt(i10);
            object.setDrmUserAgent(string2);
        }
        return this;
    }

    public DefaultMediaSourceFactory setLiveMaxOffsetMs(long l10) {
        this.liveMaxOffsetMs = l10;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMaxSpeed(float f10) {
        this.liveMaxSpeed = f10;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMinOffsetMs(long l10) {
        this.liveMinOffsetMs = l10;
        return this;
    }

    public DefaultMediaSourceFactory setLiveMinSpeed(float f10) {
        this.liveMinSpeed = f10;
        return this;
    }

    public DefaultMediaSourceFactory setLiveTargetOffsetMs(long l10) {
        this.liveTargetOffsetMs = l10;
        return this;
    }

    public DefaultMediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        Object object;
        int n10;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        for (int i10 = 0; i10 < (n10 = (object = this.mediaSourceFactories).size()); ++i10) {
            object = (MediaSourceFactory)this.mediaSourceFactories.valueAt(i10);
            object.setLoadErrorHandlingPolicy(loadErrorHandlingPolicy);
        }
        return this;
    }

    public DefaultMediaSourceFactory setStreamKeys(List list) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.mediaSourceFactories).size()); ++i10) {
            object = (MediaSourceFactory)this.mediaSourceFactories.valueAt(i10);
            object.setStreamKeys(list);
        }
        return this;
    }
}

