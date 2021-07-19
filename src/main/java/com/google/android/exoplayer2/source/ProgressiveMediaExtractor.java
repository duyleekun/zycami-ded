/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.upstream.DataReader;
import java.util.Map;

public interface ProgressiveMediaExtractor {
    public void disableSeekingOnMp3Streams();

    public long getCurrentInputPosition();

    public void init(DataReader var1, Uri var2, Map var3, long var4, long var6, ExtractorOutput var8);

    public int read(PositionHolder var1);

    public void release();

    public void seek(long var1, long var3);
}

