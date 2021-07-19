/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import java.nio.ByteBuffer;

public interface ImageProxy$PlaneProxy {
    public ByteBuffer getBuffer();

    public int getPixelStride();

    public int getRowStride();
}

