/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.MetadataRetriever$1;
import com.google.android.exoplayer2.MetadataRetriever$MetadataRetrieverInternal;
import com.google.android.exoplayer2.MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod$Callback;
import com.google.common.util.concurrent.SettableFuture;

public final class MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller$MediaPeriodCallback
implements MediaPeriod$Callback {
    public final /* synthetic */ MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller this$2;

    private MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller$MediaPeriodCallback(MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller metadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller) {
        this.this$2 = metadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller;
    }

    public /* synthetic */ MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller$MediaPeriodCallback(MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller metadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller, MetadataRetriever$1 metadataRetriever$1) {
        this(metadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller);
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        MetadataRetriever$MetadataRetrieverInternal.access$100(this.this$2.this$1.this$0).obtainMessage(2).sendToTarget();
    }

    public void onPrepared(MediaPeriod object) {
        SettableFuture settableFuture = MetadataRetriever$MetadataRetrieverInternal.access$200(this.this$2.this$1.this$0);
        object = object.getTrackGroups();
        settableFuture.set(object);
        MetadataRetriever$MetadataRetrieverInternal.access$100(this.this$2.this$1.this$0).obtainMessage(3).sendToTarget();
    }
}

