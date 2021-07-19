/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor$AudioFormat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public interface AudioProcessor {
    public static final ByteBuffer EMPTY_BUFFER;

    static {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(0);
        ByteOrder byteOrder = ByteOrder.nativeOrder();
        EMPTY_BUFFER = byteBuffer.order(byteOrder);
    }

    public AudioProcessor$AudioFormat configure(AudioProcessor$AudioFormat var1);

    public void flush();

    public ByteBuffer getOutput();

    public boolean isActive();

    public boolean isEnded();

    public void queueEndOfStream();

    public void queueInput(ByteBuffer var1);

    public void reset();
}

