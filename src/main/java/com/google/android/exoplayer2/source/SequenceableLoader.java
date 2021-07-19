/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

public interface SequenceableLoader {
    public boolean continueLoading(long var1);

    public long getBufferedPositionUs();

    public long getNextLoadPositionUs();

    public boolean isLoading();

    public void reevaluateBuffer(long var1);
}

