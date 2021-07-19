/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.nvconvertorlib;

import java.nio.ByteBuffer;

public class NvVideoFrame {
    public ByteBuffer buffer;
    public int bufferFlags;
    public int bufferSize;
    public int imageHeight;
    public int imageWidth;
    public int[] pitch;
    public int pixelFormat;
    public long streamTime;
    public int[] textureId;

    public NvVideoFrame() {
        int[] nArray = new int[1];
        this.textureId = nArray;
        nArray = new int[4];
        this.pitch = nArray;
    }
}

