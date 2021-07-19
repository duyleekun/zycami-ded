/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader$EsInfo;

public interface TsPayloadReader$Factory {
    public SparseArray createInitialPayloadReaders();

    public TsPayloadReader createPayloadReader(int var1, TsPayloadReader$EsInfo var2);
}

