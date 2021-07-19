/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.util.Size
 */
package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;

public final class SettableImageProxy
extends ForwardingImageProxy {
    private Rect mCropRect;
    private final int mHeight;
    private final ImageInfo mImageInfo;
    private final int mWidth;

    public SettableImageProxy(ImageProxy imageProxy, Size size, ImageInfo imageInfo) {
        super(imageProxy);
        if (size == null) {
            int n10;
            this.mWidth = n10 = super.getWidth();
            this.mHeight = n10 = super.getHeight();
        } else {
            int n11;
            this.mWidth = n11 = size.getWidth();
            this.mHeight = n11 = size.getHeight();
        }
        this.mImageInfo = imageInfo;
    }

    public SettableImageProxy(ImageProxy imageProxy, ImageInfo imageInfo) {
        this(imageProxy, null, imageInfo);
    }

    public Rect getCropRect() {
        synchronized (this) {
            Rect rect;
            block10: {
                rect = this.mCropRect;
                if (rect != null) break block10;
                int n10 = this.getWidth();
                int n11 = this.getHeight();
                rect = new Rect(0, 0, n10, n11);
                return rect;
            }
            Rect rect2 = this.mCropRect;
            rect = new Rect(rect2);
            return rect;
        }
    }

    public int getHeight() {
        synchronized (this) {
            int n10 = this.mHeight;
            return n10;
        }
    }

    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    public int getWidth() {
        synchronized (this) {
            int n10 = this.mWidth;
            return n10;
        }
    }

    public void setCropRect(Rect rect) {
        synchronized (this) {
            if (rect != null) {
                Rect rect2;
                block9: {
                    rect2 = new Rect(rect);
                    int n10 = this.getWidth();
                    int n11 = this.getHeight();
                    n10 = (int)(rect2.intersect(0, 0, n10, n11) ? 1 : 0);
                    if (n10 != 0) break block9;
                    rect2.setEmpty();
                }
                rect = rect2;
            }
            this.mCropRect = rect;
            return;
        }
    }
}

