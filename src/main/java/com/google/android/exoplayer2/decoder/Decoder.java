/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.decoder;

public interface Decoder {
    public Object dequeueInputBuffer();

    public Object dequeueOutputBuffer();

    public void flush();

    public String getName();

    public void queueInputBuffer(Object var1);

    public void release();
}

