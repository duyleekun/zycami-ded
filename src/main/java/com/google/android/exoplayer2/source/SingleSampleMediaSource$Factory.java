/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem$Subtitle;
import com.google.android.exoplayer2.source.SingleSampleMediaSource;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;

public final class SingleSampleMediaSource$Factory {
    private final DataSource$Factory dataSourceFactory;
    private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private Object tag;
    private String trackId;
    private boolean treatLoadErrorsAsEndOfStream;

    public SingleSampleMediaSource$Factory(DataSource$Factory object) {
        object = (DataSource$Factory)Assertions.checkNotNull(object);
        this.dataSourceFactory = object;
        this.loadErrorHandlingPolicy = object = new DefaultLoadErrorHandlingPolicy();
        this.treatLoadErrorsAsEndOfStream = true;
    }

    public SingleSampleMediaSource createMediaSource(Uri uri, Format format, long l10) {
        SingleSampleMediaSource singleSampleMediaSource;
        Object object = format.id;
        if (object == null) {
            object = this.trackId;
        }
        String string2 = object;
        object = (String)Assertions.checkNotNull(format.sampleMimeType);
        Object object2 = format.language;
        int n10 = format.selectionFlags;
        MediaItem$Subtitle mediaItem$Subtitle = new MediaItem$Subtitle(uri, (String)object, (String)object2, n10);
        object2 = this.dataSourceFactory;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
        boolean bl2 = this.treatLoadErrorsAsEndOfStream;
        Object object3 = this.tag;
        object = singleSampleMediaSource;
        singleSampleMediaSource = new SingleSampleMediaSource(string2, mediaItem$Subtitle, (DataSource$Factory)object2, l10, loadErrorHandlingPolicy, bl2, object3, null);
        return singleSampleMediaSource;
    }

    public SingleSampleMediaSource createMediaSource(MediaItem$Subtitle mediaItem$Subtitle, long l10) {
        String string2 = this.trackId;
        DataSource$Factory dataSource$Factory = this.dataSourceFactory;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
        boolean bl2 = this.treatLoadErrorsAsEndOfStream;
        Object object = this.tag;
        SingleSampleMediaSource singleSampleMediaSource = new SingleSampleMediaSource(string2, mediaItem$Subtitle, dataSource$Factory, l10, loadErrorHandlingPolicy, bl2, object, null);
        return singleSampleMediaSource;
    }

    public SingleSampleMediaSource$Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        if (loadErrorHandlingPolicy == null) {
            loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        }
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        return this;
    }

    public SingleSampleMediaSource$Factory setTag(Object object) {
        this.tag = object;
        return this;
    }

    public SingleSampleMediaSource$Factory setTrackId(String string2) {
        this.trackId = string2;
        return this;
    }

    public SingleSampleMediaSource$Factory setTreatLoadErrorsAsEndOfStream(boolean bl2) {
        this.treatLoadErrorsAsEndOfStream = bl2;
        return this;
    }
}

