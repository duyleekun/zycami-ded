/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.upstream.DataReader;

public interface ExtractorInput
extends DataReader {
    public void advancePeekPosition(int var1);

    public boolean advancePeekPosition(int var1, boolean var2);

    public long getLength();

    public long getPeekPosition();

    public long getPosition();

    public int peek(byte[] var1, int var2, int var3);

    public void peekFully(byte[] var1, int var2, int var3);

    public boolean peekFully(byte[] var1, int var2, int var3, boolean var4);

    public int read(byte[] var1, int var2, int var3);

    public void readFully(byte[] var1, int var2, int var3);

    public boolean readFully(byte[] var1, int var2, int var3, boolean var4);

    public void resetPeekPosition();

    public void setRetryPosition(long var1, Throwable var3);

    public int skip(int var1);

    public void skipFully(int var1);

    public boolean skipFully(int var1, boolean var2);
}

