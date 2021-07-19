/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.transformer;

import com.google.android.exoplayer2.Format;
import java.nio.ByteBuffer;

public interface Muxer {
    public int addTrack(Format var1);

    public void release(boolean var1);

    public boolean supportsSampleMimeType(String var1);

    public void writeSampleData(int var1, ByteBuffer var2, boolean var3, long var4);
}

