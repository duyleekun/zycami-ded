/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.HttpDataSource$Factory;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.util.List;

public interface MediaSourceFactory {
    default public MediaSource createMediaSource(Uri object) {
        object = MediaItem.fromUri(object);
        return this.createMediaSource((MediaItem)object);
    }

    public MediaSource createMediaSource(MediaItem var1);

    public int[] getSupportedTypes();

    public MediaSourceFactory setDrmHttpDataSourceFactory(HttpDataSource$Factory var1);

    public MediaSourceFactory setDrmSessionManager(DrmSessionManager var1);

    public MediaSourceFactory setDrmSessionManagerProvider(DrmSessionManagerProvider var1);

    public MediaSourceFactory setDrmUserAgent(String var1);

    public MediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy var1);

    default public MediaSourceFactory setStreamKeys(List list) {
        return this;
    }
}

