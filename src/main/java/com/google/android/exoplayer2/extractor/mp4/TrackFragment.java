/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues;
import com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class TrackFragment {
    public long atomPosition;
    public long auxiliaryDataPosition;
    public long dataPosition;
    public boolean definesEncryptionData;
    public DefaultSampleValues header;
    public long nextFragmentDecodeTime;
    public boolean nextFragmentDecodeTimeIncludesMoov;
    public int[] sampleCompositionTimeOffsetUsTable;
    public int sampleCount;
    public long[] sampleDecodingTimeUsTable;
    public final ParsableByteArray sampleEncryptionData;
    public boolean sampleEncryptionDataNeedsFill;
    public boolean[] sampleHasSubsampleEncryptionTable;
    public boolean[] sampleIsSyncFrameTable;
    public int[] sampleSizeTable;
    public TrackEncryptionBox trackEncryptionBox;
    public int trunCount;
    public long[] trunDataPosition;
    public int[] trunLength;

    public TrackFragment() {
        Object[] objectArray = new long[]{};
        this.trunDataPosition = objectArray;
        objectArray = new int[0];
        this.trunLength = (int[])objectArray;
        objectArray = new int[0];
        this.sampleSizeTable = (int[])objectArray;
        objectArray = new int[0];
        this.sampleCompositionTimeOffsetUsTable = (int[])objectArray;
        objectArray = new long[]{};
        this.sampleDecodingTimeUsTable = objectArray;
        objectArray = new boolean[0];
        this.sampleIsSyncFrameTable = (boolean[])objectArray;
        Object object = new boolean[]{};
        this.sampleHasSubsampleEncryptionTable = object;
        object = new ParsableByteArray;
        this.sampleEncryptionData = object;
    }

    public void fillEncryptionData(ExtractorInput extractorInput) {
        byte[] byArray = this.sampleEncryptionData.getData();
        int n10 = this.sampleEncryptionData.limit();
        extractorInput.readFully(byArray, 0, n10);
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }

    public void fillEncryptionData(ParsableByteArray parsableByteArray) {
        byte[] byArray = this.sampleEncryptionData.getData();
        int n10 = this.sampleEncryptionData.limit();
        parsableByteArray.readBytes(byArray, 0, n10);
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }

    public long getSamplePresentationTimeUs(int n10) {
        long l10 = this.sampleDecodingTimeUsTable[n10];
        long l11 = this.sampleCompositionTimeOffsetUsTable[n10];
        return l10 + l11;
    }

    public void initEncryptionData(int n10) {
        this.sampleEncryptionData.reset(n10);
        n10 = 1;
        this.definesEncryptionData = n10;
        this.sampleEncryptionDataNeedsFill = n10;
    }

    public void initTables(int n10, int n11) {
        Object[] objectArray;
        this.trunCount = n10;
        this.sampleCount = n11;
        Object[] objectArray2 = this.trunLength;
        int n12 = objectArray2.length;
        if (n12 < n10) {
            objectArray2 = new long[n10];
            this.trunDataPosition = objectArray2;
            objectArray = new int[n10];
            this.trunLength = objectArray;
        }
        if ((n10 = (objectArray = this.sampleSizeTable).length) < n11) {
            n11 = n11 * 125 / 100;
            this.sampleSizeTable = objectArray = new int[n11];
            objectArray = new int[n11];
            this.sampleCompositionTimeOffsetUsTable = objectArray;
            objectArray = new long[n11];
            this.sampleDecodingTimeUsTable = objectArray;
            objectArray = new boolean[n11];
            this.sampleIsSyncFrameTable = (boolean[])objectArray;
            objectArray = new boolean[n11];
            this.sampleHasSubsampleEncryptionTable = (boolean[])objectArray;
        }
    }

    public void reset() {
        this.trunCount = 0;
        this.nextFragmentDecodeTime = 0L;
        this.nextFragmentDecodeTimeIncludesMoov = false;
        this.definesEncryptionData = false;
        this.sampleEncryptionDataNeedsFill = false;
        this.trackEncryptionBox = null;
    }

    public boolean sampleHasSubsampleEncryptionTable(int n10) {
        boolean[] blArray;
        boolean bl2 = this.definesEncryptionData;
        n10 = bl2 && (n10 = (blArray = this.sampleHasSubsampleEncryptionTable)[n10]) != 0 ? 1 : 0;
        return n10 != 0;
    }
}

