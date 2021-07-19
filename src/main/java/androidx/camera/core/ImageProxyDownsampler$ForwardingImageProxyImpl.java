/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageProxy$PlaneProxy;

public final class ImageProxyDownsampler$ForwardingImageProxyImpl
extends ForwardingImageProxy {
    private final int mDownsampledHeight;
    private final ImageProxy$PlaneProxy[] mDownsampledPlanes;
    private final int mDownsampledWidth;

    public ImageProxyDownsampler$ForwardingImageProxyImpl(ImageProxy imageProxy, ImageProxy$PlaneProxy[] imageProxy$PlaneProxyArray, int n10, int n11) {
        super(imageProxy);
        this.mDownsampledPlanes = imageProxy$PlaneProxyArray;
        this.mDownsampledWidth = n10;
        this.mDownsampledHeight = n11;
    }

    public int getHeight() {
        synchronized (this) {
            int n10 = this.mDownsampledHeight;
            return n10;
        }
    }

    public ImageProxy$PlaneProxy[] getPlanes() {
        synchronized (this) {
            ImageProxy$PlaneProxy[] imageProxy$PlaneProxyArray = this.mDownsampledPlanes;
            return imageProxy$PlaneProxyArray;
        }
    }

    public int getWidth() {
        synchronized (this) {
            int n10 = this.mDownsampledWidth;
            return n10;
        }
    }
}

