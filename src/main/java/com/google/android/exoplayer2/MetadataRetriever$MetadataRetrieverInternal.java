/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.HandlerThread
 *  android.os.Looper
 */
package com.google.android.exoplayer2;

import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

public final class MetadataRetriever$MetadataRetrieverInternal {
    private static final int MESSAGE_CHECK_FOR_FAILURE = 1;
    private static final int MESSAGE_CONTINUE_LOADING = 2;
    private static final int MESSAGE_PREPARE_SOURCE = 0;
    private static final int MESSAGE_RELEASE = 3;
    private final MediaSourceFactory mediaSourceFactory;
    private final HandlerWrapper mediaSourceHandler;
    private final HandlerThread mediaSourceThread;
    private final SettableFuture trackGroupsFuture;

    public MetadataRetriever$MetadataRetrieverInternal(MediaSourceFactory object, Clock clock) {
        this.mediaSourceFactory = object;
        super("ExoPlayer:MetadataRetriever");
        this.mediaSourceThread = object;
        object.start();
        object = object.getLooper();
        MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback metadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback = new MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback(this);
        this.mediaSourceHandler = object = clock.createHandler((Looper)object, metadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback);
        this.trackGroupsFuture = object = SettableFuture.create();
    }

    public static /* synthetic */ MediaSourceFactory access$000(MetadataRetriever$MetadataRetrieverInternal metadataRetriever$MetadataRetrieverInternal) {
        return metadataRetriever$MetadataRetrieverInternal.mediaSourceFactory;
    }

    public static /* synthetic */ HandlerWrapper access$100(MetadataRetriever$MetadataRetrieverInternal metadataRetriever$MetadataRetrieverInternal) {
        return metadataRetriever$MetadataRetrieverInternal.mediaSourceHandler;
    }

    public static /* synthetic */ SettableFuture access$200(MetadataRetriever$MetadataRetrieverInternal metadataRetriever$MetadataRetrieverInternal) {
        return metadataRetriever$MetadataRetrieverInternal.trackGroupsFuture;
    }

    public static /* synthetic */ HandlerThread access$300(MetadataRetriever$MetadataRetrieverInternal metadataRetriever$MetadataRetrieverInternal) {
        return metadataRetriever$MetadataRetrieverInternal.mediaSourceThread;
    }

    public ListenableFuture retrieveMetadata(MediaItem mediaItem) {
        this.mediaSourceHandler.obtainMessage(0, mediaItem).sendToTarget();
        return this.trackGroupsFuture;
    }
}

