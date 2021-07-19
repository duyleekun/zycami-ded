/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback;
import com.google.android.exoplayer2.MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller$MediaPeriodCallback;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod$Callback;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource$MediaSourceCaller;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;

public final class MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller
implements MediaSource$MediaSourceCaller {
    private final Allocator allocator;
    private final MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller$MediaPeriodCallback mediaPeriodCallback;
    private boolean mediaPeriodCreated;
    public final /* synthetic */ MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback this$1;

    public MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller(MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback object) {
        this.this$1 = object;
        this.mediaPeriodCallback = object = new MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller$MediaPeriodCallback(this, null);
        this.allocator = object = new DefaultAllocator(true, 65536);
    }

    public void onSourceInfoRefreshed(MediaSource object, Timeline object2) {
        boolean bl2 = this.mediaPeriodCreated;
        if (bl2) {
            return;
        }
        this.mediaPeriodCreated = true;
        MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback metadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback = this.this$1;
        object2 = ((Timeline)object2).getUidOfPeriod(0);
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = new MediaSource$MediaPeriodId(object2);
        object2 = this.allocator;
        long l10 = 0L;
        object = object.createPeriod(mediaSource$MediaPeriodId, (Allocator)object2, l10);
        MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback.access$502(metadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback, (MediaPeriod)object);
        object = MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback.access$500(this.this$1);
        object2 = this.mediaPeriodCallback;
        object.prepare((MediaPeriod$Callback)object2, l10);
    }
}

