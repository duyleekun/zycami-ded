/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.mkv.EbmlProcessor;

public interface EbmlReader {
    public void init(EbmlProcessor var1);

    public boolean read(ExtractorInput var1);

    public void reset();
}

