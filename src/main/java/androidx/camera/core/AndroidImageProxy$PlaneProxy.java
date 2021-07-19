/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.Image$Plane
 */
package androidx.camera.core;

import android.media.Image;
import androidx.camera.core.ImageProxy$PlaneProxy;
import java.nio.ByteBuffer;

public final class AndroidImageProxy$PlaneProxy
implements ImageProxy$PlaneProxy {
    private final Image.Plane mPlane;

    public AndroidImageProxy$PlaneProxy(Image.Plane plane) {
        this.mPlane = plane;
    }

    public ByteBuffer getBuffer() {
        synchronized (this) {
            Object object = this.mPlane;
            object = object.getBuffer();
            return object;
        }
    }

    public int getPixelStride() {
        synchronized (this) {
            Image.Plane plane = this.mPlane;
            int n10 = plane.getPixelStride();
            return n10;
        }
    }

    public int getRowStride() {
        synchronized (this) {
            Image.Plane plane = this.mPlane;
            int n10 = plane.getRowStride();
            return n10;
        }
    }
}

