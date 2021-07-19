/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import java.nio.ByteBuffer;

public interface TeeAudioProcessor$AudioBufferSink {
    public void flush(int var1, int var2, int var3);

    public void handleBuffer(ByteBuffer var1);
}

