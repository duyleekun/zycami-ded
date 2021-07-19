/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;

public interface Extractor {
    public static final int RESULT_CONTINUE = 0;
    public static final int RESULT_END_OF_INPUT = 255;
    public static final int RESULT_SEEK = 1;

    public void init(ExtractorOutput var1);

    public int read(ExtractorInput var1, PositionHolder var2);

    public void release();

    public void seek(long var1, long var3);

    public boolean sniff(ExtractorInput var1);
}

