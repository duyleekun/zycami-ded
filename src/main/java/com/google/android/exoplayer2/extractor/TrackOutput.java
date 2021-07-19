/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput$CryptoData;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;

public interface TrackOutput {
    public static final int SAMPLE_DATA_PART_ENCRYPTION = 1;
    public static final int SAMPLE_DATA_PART_MAIN = 0;
    public static final int SAMPLE_DATA_PART_SUPPLEMENTAL = 2;

    public void format(Format var1);

    default public int sampleData(DataReader dataReader, int n10, boolean bl2) {
        return this.sampleData(dataReader, n10, bl2, 0);
    }

    public int sampleData(DataReader var1, int var2, boolean var3, int var4);

    default public void sampleData(ParsableByteArray parsableByteArray, int n10) {
        this.sampleData(parsableByteArray, n10, 0);
    }

    public void sampleData(ParsableByteArray var1, int var2, int var3);

    public void sampleMetadata(long var1, int var3, int var4, int var5, TrackOutput$CryptoData var6);
}

