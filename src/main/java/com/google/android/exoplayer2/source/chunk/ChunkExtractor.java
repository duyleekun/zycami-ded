/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor$TrackOutputProvider;

public interface ChunkExtractor {
    public ChunkIndex getChunkIndex();

    public Format[] getSampleFormats();

    public void init(ChunkExtractor$TrackOutputProvider var1, long var2, long var4);

    public boolean read(ExtractorInput var1);

    public void release();
}

