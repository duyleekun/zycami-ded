/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;

public interface HlsMediaChunkExtractor {
    public void init(ExtractorOutput var1);

    public boolean isPackedAudioExtractor();

    public boolean isReusable();

    public void onTruncatedSegmentParsed();

    public boolean read(ExtractorInput var1);

    public HlsMediaChunkExtractor recreate();
}

