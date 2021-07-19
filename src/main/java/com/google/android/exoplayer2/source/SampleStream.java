/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

public interface SampleStream {
    public boolean isReady();

    public void maybeThrowError();

    public int readData(FormatHolder var1, DecoderInputBuffer var2, boolean var3);

    public int skipData(long var1);
}

