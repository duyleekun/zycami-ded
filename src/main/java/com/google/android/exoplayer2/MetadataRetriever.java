/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.exoplayer2;

import android.content.Context;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MetadataRetriever$MetadataRetrieverInternal;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.util.Clock;
import com.google.common.util.concurrent.ListenableFuture;

public final class MetadataRetriever {
    private MetadataRetriever() {
    }

    public static ListenableFuture retrieveMetadata(Context context, MediaItem mediaItem) {
        Clock clock = Clock.DEFAULT;
        return MetadataRetriever.retrieveMetadata(context, mediaItem, clock);
    }

    public static ListenableFuture retrieveMetadata(Context context, MediaItem mediaItem, Clock clock) {
        DefaultExtractorsFactory defaultExtractorsFactory = new DefaultExtractorsFactory();
        defaultExtractorsFactory = defaultExtractorsFactory.setMp4ExtractorFlags(6);
        DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory(context, (ExtractorsFactory)defaultExtractorsFactory);
        return MetadataRetriever.retrieveMetadata(defaultMediaSourceFactory, mediaItem, clock);
    }

    public static ListenableFuture retrieveMetadata(MediaSourceFactory mediaSourceFactory, MediaItem mediaItem) {
        Clock clock = Clock.DEFAULT;
        return MetadataRetriever.retrieveMetadata(mediaSourceFactory, mediaItem, clock);
    }

    private static ListenableFuture retrieveMetadata(MediaSourceFactory mediaSourceFactory, MediaItem mediaItem, Clock clock) {
        MetadataRetriever$MetadataRetrieverInternal metadataRetriever$MetadataRetrieverInternal = new MetadataRetriever$MetadataRetrieverInternal(mediaSourceFactory, clock);
        return metadataRetriever$MetadataRetrieverInternal.retrieveMetadata(mediaItem);
    }
}

