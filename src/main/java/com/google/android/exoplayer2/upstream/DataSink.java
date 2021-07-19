/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.upstream.DataSpec;

public interface DataSink {
    public void close();

    public void open(DataSpec var1);

    public void write(byte[] var1, int var2, int var3);
}

