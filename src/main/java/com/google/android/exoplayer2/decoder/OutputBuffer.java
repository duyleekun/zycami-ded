/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.decoder;

import com.google.android.exoplayer2.decoder.Buffer;

public abstract class OutputBuffer
extends Buffer {
    public int skippedOutputBufferCount;
    public long timeUs;

    public abstract void release();
}

