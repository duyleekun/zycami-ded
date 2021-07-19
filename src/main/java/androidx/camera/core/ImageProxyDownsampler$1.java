/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ImageProxy$PlaneProxy;
import java.nio.ByteBuffer;

public class ImageProxyDownsampler$1
implements ImageProxy$PlaneProxy {
    public final ByteBuffer mBuffer;
    public final /* synthetic */ byte[] val$data;
    public final /* synthetic */ int val$pixelStride;
    public final /* synthetic */ int val$rowStride;

    public ImageProxyDownsampler$1(byte[] object, int n10, int n11) {
        this.val$data = object;
        this.val$rowStride = n10;
        this.val$pixelStride = n11;
        object = ByteBuffer.wrap(object);
        this.mBuffer = object;
    }

    public ByteBuffer getBuffer() {
        return this.mBuffer;
    }

    public int getPixelStride() {
        return this.val$pixelStride;
    }

    public int getRowStride() {
        return this.val$rowStride;
    }
}

