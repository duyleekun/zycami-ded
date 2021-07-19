/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata$SeekTable;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ogg.OggSeeker;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class FlacReader$FlacOggSeeker
implements OggSeeker {
    private long firstFrameOffset;
    private long pendingSeekGranule;
    private FlacStreamMetadata$SeekTable seekTable;
    private FlacStreamMetadata streamMetadata;

    public FlacReader$FlacOggSeeker(FlacStreamMetadata flacStreamMetadata, FlacStreamMetadata$SeekTable flacStreamMetadata$SeekTable) {
        long l10;
        this.streamMetadata = flacStreamMetadata;
        this.seekTable = flacStreamMetadata$SeekTable;
        this.firstFrameOffset = l10 = (long)-1;
        this.pendingSeekGranule = l10;
    }

    public SeekMap createSeekMap() {
        FlacSeekTableSeekMap flacSeekTableSeekMap;
        long l10 = this.firstFrameOffset;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            object = 1;
        } else {
            object = 0;
            flacSeekTableSeekMap = null;
        }
        Assertions.checkState((boolean)object);
        FlacStreamMetadata flacStreamMetadata = this.streamMetadata;
        l11 = this.firstFrameOffset;
        flacSeekTableSeekMap = new FlacSeekTableSeekMap(flacStreamMetadata, l11);
        return flacSeekTableSeekMap;
    }

    public long read(ExtractorInput extractorInput) {
        long l10 = this.pendingSeekGranule;
        long l11 = l10 - 0L;
        long l12 = l11 == 0L ? 0 : (l11 < 0L ? -1 : 1);
        long l13 = -1;
        if (l12 >= 0) {
            l10 = -(l10 + (long)2);
            this.pendingSeekGranule = l13;
            return l10;
        }
        return l13;
    }

    public void setFirstFrameOffset(long l10) {
        this.firstFrameOffset = l10;
    }

    public void startSeek(long l10) {
        long[] lArray = this.seekTable.pointSampleNumbers;
        boolean bl2 = true;
        int n10 = Util.binarySearchFloor(lArray, l10, bl2, bl2);
        this.pendingSeekGranule = l10 = lArray[n10];
    }
}

