/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.chunk.BaseMediaChunk;
import com.google.android.exoplayer2.source.chunk.ChunkSampleStream;
import com.google.android.exoplayer2.util.Assertions;

public final class ChunkSampleStream$EmbeddedSampleStream
implements SampleStream {
    private final int index;
    private boolean notifiedDownstreamFormat;
    public final ChunkSampleStream parent;
    private final SampleQueue sampleQueue;
    public final /* synthetic */ ChunkSampleStream this$0;

    public ChunkSampleStream$EmbeddedSampleStream(ChunkSampleStream chunkSampleStream, ChunkSampleStream chunkSampleStream2, SampleQueue sampleQueue, int n10) {
        this.this$0 = chunkSampleStream;
        this.parent = chunkSampleStream2;
        this.sampleQueue = sampleQueue;
        this.index = n10;
    }

    private void maybeNotifyDownstreamFormat() {
        boolean bl2 = this.notifiedDownstreamFormat;
        if (!bl2) {
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = ChunkSampleStream.access$500(this.this$0);
            Object object = ChunkSampleStream.access$200(this.this$0);
            int n10 = this.index;
            n10 = object[n10];
            object = ChunkSampleStream.access$300(this.this$0);
            int n11 = this.index;
            int n12 = object[n11];
            object = this.this$0;
            long l10 = ChunkSampleStream.access$400((ChunkSampleStream)object);
            mediaSourceEventListener$EventDispatcher.downstreamFormatChanged(n10, (Format)n12, 0, null, l10);
            this.notifiedDownstreamFormat = bl2 = true;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isReady() {
        Object object = this.this$0;
        boolean bl2 = ((ChunkSampleStream)object).isPendingReset();
        if (bl2) return false;
        object = this.sampleQueue;
        ChunkSampleStream chunkSampleStream = this.this$0;
        boolean bl3 = chunkSampleStream.loadingFinished;
        bl2 = ((SampleQueue)object).isReady(bl3);
        if (!bl2) return false;
        return true;
    }

    public void maybeThrowError() {
    }

    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean bl2) {
        Object object = this.this$0;
        boolean n10 = ((ChunkSampleStream)object).isPendingReset();
        int n11 = -3;
        if (n10) {
            return n11;
        }
        object = ChunkSampleStream.access$000(this.this$0);
        if (object != null) {
            SampleQueue sampleQueue;
            object = ChunkSampleStream.access$000(this.this$0);
            int n12 = this.index + 1;
            int n13 = ((BaseMediaChunk)object).getFirstSampleIndex(n12);
            if (n13 <= (n12 = (sampleQueue = this.sampleQueue).getReadIndex())) {
                return n11;
            }
        }
        this.maybeNotifyDownstreamFormat();
        object = this.sampleQueue;
        n11 = (int)(this.this$0.loadingFinished ? 1 : 0);
        return ((SampleQueue)object).read(formatHolder, decoderInputBuffer, bl2, n11 != 0);
    }

    public void release() {
        boolean[] blArray = ChunkSampleStream.access$100(this.this$0);
        int n10 = this.index;
        Assertions.checkState(blArray[n10]);
        blArray = ChunkSampleStream.access$100(this.this$0);
        n10 = this.index;
        blArray[n10] = false;
    }

    public int skipData(long l10) {
        Object object = this.this$0;
        boolean n10 = ((ChunkSampleStream)object).isPendingReset();
        if (n10) {
            return 0;
        }
        object = this.sampleQueue;
        ChunkSampleStream chunkSampleStream = this.this$0;
        boolean bl2 = chunkSampleStream.loadingFinished;
        int n11 = ((SampleQueue)object).getSkipCount(l10, bl2);
        Object object2 = ChunkSampleStream.access$000(this.this$0);
        if (object2 != null) {
            object2 = ChunkSampleStream.access$000(this.this$0);
            int n12 = this.index + 1;
            int n13 = ((BaseMediaChunk)object2).getFirstSampleIndex(n12);
            object = this.sampleQueue;
            int n14 = ((SampleQueue)object).getReadIndex();
            n11 = Math.min(n11, n13 -= n14);
        }
        object2 = this.sampleQueue;
        ((SampleQueue)object2).skip(n11);
        if (n11 > 0) {
            this.maybeNotifyDownstreamFormat();
        }
        return n11;
    }
}

