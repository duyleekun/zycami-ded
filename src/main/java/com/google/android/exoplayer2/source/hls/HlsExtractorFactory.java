/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.HlsMediaChunkExtractor;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.List;
import java.util.Map;

public interface HlsExtractorFactory {
    public static final HlsExtractorFactory DEFAULT;

    static {
        DefaultHlsExtractorFactory defaultHlsExtractorFactory = new DefaultHlsExtractorFactory();
        DEFAULT = defaultHlsExtractorFactory;
    }

    public HlsMediaChunkExtractor createExtractor(Uri var1, Format var2, List var3, TimestampAdjuster var4, Map var5, ExtractorInput var6);
}

