/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.hls.HlsSampleStreamWrapper;
import com.google.android.exoplayer2.source.hls.SampleQueueMappingException;
import com.google.android.exoplayer2.util.Assertions;

public final class HlsSampleStream
implements SampleStream {
    private int sampleQueueIndex;
    private final HlsSampleStreamWrapper sampleStreamWrapper;
    private final int trackGroupIndex;

    public HlsSampleStream(HlsSampleStreamWrapper hlsSampleStreamWrapper, int n10) {
        this.sampleStreamWrapper = hlsSampleStreamWrapper;
        this.trackGroupIndex = n10;
        this.sampleQueueIndex = -1;
    }

    private boolean hasValidSampleQueueIndex() {
        int n10 = this.sampleQueueIndex;
        int n11 = -1;
        n10 = n10 != n11 && n10 != (n11 = -3) && n10 != (n11 = -2) ? 1 : 0;
        return n10 != 0;
    }

    public void bindSampleQueue() {
        HlsSampleStreamWrapper hlsSampleStreamWrapper;
        int n10 = this.sampleQueueIndex;
        int n11 = -1;
        if (n10 == n11) {
            n10 = 1;
        } else {
            n10 = 0;
            hlsSampleStreamWrapper = null;
        }
        Assertions.checkArgument(n10 != 0);
        hlsSampleStreamWrapper = this.sampleStreamWrapper;
        n11 = this.trackGroupIndex;
        this.sampleQueueIndex = n10 = hlsSampleStreamWrapper.bindSampleQueueToSampleStream(n11);
    }

    public boolean isReady() {
        HlsSampleStreamWrapper hlsSampleStreamWrapper;
        int n10 = this.sampleQueueIndex;
        int n11 = -3;
        if (n10 != n11 && ((n10 = (int)(this.hasValidSampleQueueIndex() ? 1 : 0)) == 0 || (n10 = (int)((hlsSampleStreamWrapper = this.sampleStreamWrapper).isReady(n11 = this.sampleQueueIndex) ? 1 : 0)) == 0)) {
            n10 = 0;
            hlsSampleStreamWrapper = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public void maybeThrowError() {
        int n10 = this.sampleQueueIndex;
        int n11 = -2;
        if (n10 != n11) {
            n11 = -1;
            if (n10 == n11) {
                HlsSampleStreamWrapper hlsSampleStreamWrapper = this.sampleStreamWrapper;
                hlsSampleStreamWrapper.maybeThrowError();
            } else {
                n11 = -3;
                if (n10 != n11) {
                    HlsSampleStreamWrapper hlsSampleStreamWrapper = this.sampleStreamWrapper;
                    hlsSampleStreamWrapper.maybeThrowError(n10);
                }
            }
            return;
        }
        Object object = this.sampleStreamWrapper.getTrackGroups();
        int n12 = this.trackGroupIndex;
        object = object.get((int)n12).getFormat((int)0).sampleMimeType;
        SampleQueueMappingException sampleQueueMappingException = new SampleQueueMappingException((String)object);
        throw sampleQueueMappingException;
    }

    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean bl2) {
        int n10 = this.sampleQueueIndex;
        int n11 = -3;
        if (n10 == n11) {
            decoderInputBuffer.addFlag(4);
            return -4;
        }
        n10 = (int)(this.hasValidSampleQueueIndex() ? 1 : 0);
        if (n10 != 0) {
            HlsSampleStreamWrapper hlsSampleStreamWrapper = this.sampleStreamWrapper;
            n11 = this.sampleQueueIndex;
            n11 = hlsSampleStreamWrapper.readData(n11, formatHolder, decoderInputBuffer, bl2);
        }
        return n11;
    }

    public int skipData(long l10) {
        int n10;
        boolean bl2 = this.hasValidSampleQueueIndex();
        if (bl2) {
            HlsSampleStreamWrapper hlsSampleStreamWrapper = this.sampleStreamWrapper;
            int n11 = this.sampleQueueIndex;
            n10 = hlsSampleStreamWrapper.skipData(n11, l10);
        } else {
            n10 = 0;
        }
        return n10;
    }

    public void unbindSampleQueue() {
        int n10 = this.sampleQueueIndex;
        int n11 = -1;
        if (n10 != n11) {
            HlsSampleStreamWrapper hlsSampleStreamWrapper = this.sampleStreamWrapper;
            int n12 = this.trackGroupIndex;
            hlsSampleStreamWrapper.unbindSampleQueue(n12);
            this.sampleQueueIndex = n11;
        }
    }
}

