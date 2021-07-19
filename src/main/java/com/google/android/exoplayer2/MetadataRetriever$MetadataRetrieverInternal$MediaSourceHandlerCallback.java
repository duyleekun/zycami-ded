/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MetadataRetriever$MetadataRetrieverInternal;
import com.google.android.exoplayer2.MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaSourceCaller;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.common.util.concurrent.SettableFuture;

public final class MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback
implements Handler.Callback {
    private static final int ERROR_POLL_INTERVAL_MS = 100;
    private MediaPeriod mediaPeriod;
    private MediaSource mediaSource;
    private final MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller mediaSourceCaller;
    public final /* synthetic */ MetadataRetriever$MetadataRetrieverInternal this$0;

    public MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback(MetadataRetriever$MetadataRetrieverInternal object) {
        this.this$0 = object;
        this.mediaSourceCaller = object = new MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller(this);
    }

    public static /* synthetic */ MediaPeriod access$500(MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback metadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback) {
        return metadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback.mediaPeriod;
    }

    public static /* synthetic */ MediaPeriod access$502(MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback metadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback, MediaPeriod mediaPeriod) {
        metadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback.mediaPeriod = mediaPeriod;
        return mediaPeriod;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean handleMessage(Message object) {
        boolean bl2 = ((Message)object).what;
        int n10 = 0;
        SettableFuture settableFuture = null;
        boolean bl3 = true;
        if (!bl2) {
            object = (MediaItem)((Message)object).obj;
            this.mediaSource = object = MetadataRetriever$MetadataRetrieverInternal.access$000(this.this$0).createMediaSource((MediaItem)object);
            MetadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller metadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller = this.mediaSourceCaller;
            object.prepareSource(metadataRetriever$MetadataRetrieverInternal$MediaSourceHandlerCallback$MediaSourceCaller, null);
            MetadataRetriever$MetadataRetrieverInternal.access$100(this.this$0).sendEmptyMessage((int)(bl3 ? 1 : 0));
            return bl3;
        }
        boolean bl4 = 3 != 0;
        if (bl2 != bl3) {
            Object object2;
            boolean bl5 = 2 != 0;
            if (bl2 == bl5) {
                ((MediaPeriod)Assertions.checkNotNull(this.mediaPeriod)).continueLoading(0L);
                return bl3;
            }
            if (bl2 != bl4) {
                return false;
            }
            object = this.mediaPeriod;
            if (object != null) {
                object = (MediaSource)Assertions.checkNotNull(this.mediaSource);
                object2 = this.mediaPeriod;
                object.releasePeriod((MediaPeriod)object2);
            }
            object = (MediaSource)Assertions.checkNotNull(this.mediaSource);
            object2 = this.mediaSourceCaller;
            object.releaseSource((MediaSource$MediaSourceCaller)object2);
            MetadataRetriever$MetadataRetrieverInternal.access$100(this.this$0).removeCallbacksAndMessages(null);
            MetadataRetriever$MetadataRetrieverInternal.access$300(this.this$0).quit();
            return bl3;
        }
        try {
            Object object3 = this.mediaPeriod;
            if (object3 == null) {
                object3 = this.mediaSource;
                object3 = Assertions.checkNotNull(object3);
                object3 = (MediaSource)object3;
                object3.maybeThrowSourceInfoRefreshError();
            } else {
                object3.maybeThrowPrepareError();
            }
            object3 = this.this$0;
            object3 = MetadataRetriever$MetadataRetrieverInternal.access$100((MetadataRetriever$MetadataRetrieverInternal)object3);
            n10 = 100;
            object3.sendEmptyMessageDelayed((int)(bl3 ? 1 : 0), n10);
            return bl3;
        }
        catch (Exception exception) {
            settableFuture = MetadataRetriever$MetadataRetrieverInternal.access$200(this.this$0);
            settableFuture.setException(exception);
            HandlerWrapper handlerWrapper = MetadataRetriever$MetadataRetrieverInternal.access$100(this.this$0);
            object = handlerWrapper.obtainMessage((int)(bl4 ? 1 : 0));
            object.sendToTarget();
        }
        return bl3;
    }
}

