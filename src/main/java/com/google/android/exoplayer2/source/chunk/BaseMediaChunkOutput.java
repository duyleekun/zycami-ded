/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor$TrackOutputProvider;
import com.google.android.exoplayer2.util.Log;

public final class BaseMediaChunkOutput
implements ChunkExtractor$TrackOutputProvider {
    private static final String TAG = "BaseMediaChunkOutput";
    private final SampleQueue[] sampleQueues;
    private final int[] trackTypes;

    public BaseMediaChunkOutput(int[] nArray, SampleQueue[] sampleQueueArray) {
        this.trackTypes = nArray;
        this.sampleQueues = sampleQueueArray;
    }

    public int[] getWriteIndices() {
        Object object;
        int n10;
        int n11 = this.sampleQueues.length;
        int[] nArray = new int[n11];
        for (int i10 = 0; i10 < (n10 = ((SampleQueue[])(object = this.sampleQueues)).length); ++i10) {
            int n12;
            object = object[i10];
            nArray[i10] = n12 = ((SampleQueue)object).getWriteIndex();
        }
        return nArray;
    }

    public void setSampleOffsetUs(long l10) {
        for (SampleQueue sampleQueue : this.sampleQueues) {
            sampleQueue.setSampleOffsetUs(l10);
        }
    }

    public TrackOutput track(int n10, int n11) {
        Object object;
        int n12;
        Object object2 = null;
        for (n10 = 0; n10 < (n12 = ((int[])(object = this.trackTypes)).length); ++n10) {
            int n13 = object[n10];
            if (n11 != n13) continue;
            return this.sampleQueues[n10];
        }
        object = new StringBuilder;
        ((StringBuilder)object)(36);
        ((StringBuilder)object).append("Unmatched track of type: ");
        ((StringBuilder)object).append(n11);
        object2 = ((StringBuilder)object).toString();
        Log.e(TAG, (String)object2);
        object2 = new DummyTrackOutput();
        return object2;
    }
}

