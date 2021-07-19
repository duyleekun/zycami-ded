/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.media.Image
 *  android.media.Image$Plane
 */
package androidx.camera.core;

import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.AndroidImageProxy$PlaneProxy;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageProxy$PlaneProxy;
import androidx.camera.core.ImmutableImageInfo;
import androidx.camera.core.impl.TagBundle;

public final class AndroidImageProxy
implements ImageProxy {
    private final Image mImage;
    private final ImageInfo mImageInfo;
    private final AndroidImageProxy$PlaneProxy[] mPlanes;

    public AndroidImageProxy(Image object) {
        this.mImage = object;
        Object object2 = object.getPlanes();
        if (object2 != null) {
            int n10;
            AndroidImageProxy$PlaneProxy[] androidImageProxy$PlaneProxyArray = new AndroidImageProxy$PlaneProxy[((Image.Plane[])object2).length];
            this.mPlanes = androidImageProxy$PlaneProxyArray;
            androidImageProxy$PlaneProxyArray = null;
            for (int i10 = 0; i10 < (n10 = ((Image.Plane[])object2).length); ++i10) {
                AndroidImageProxy$PlaneProxy androidImageProxy$PlaneProxy;
                AndroidImageProxy$PlaneProxy[] androidImageProxy$PlaneProxyArray2 = this.mPlanes;
                Image.Plane plane = object2[i10];
                androidImageProxy$PlaneProxyArray2[i10] = androidImageProxy$PlaneProxy = new AndroidImageProxy$PlaneProxy(plane);
            }
        } else {
            object2 = new AndroidImageProxy$PlaneProxy[]{};
            this.mPlanes = object2;
        }
        object2 = TagBundle.emptyBundle();
        long l10 = object.getTimestamp();
        object = ImmutableImageInfo.create((TagBundle)object2, l10, 0);
        this.mImageInfo = object;
    }

    public void close() {
        synchronized (this) {
            Image image = this.mImage;
            image.close();
            return;
        }
    }

    public Rect getCropRect() {
        synchronized (this) {
            Image image = this.mImage;
            image = image.getCropRect();
            return image;
        }
    }

    public int getFormat() {
        synchronized (this) {
            Image image = this.mImage;
            int n10 = image.getFormat();
            return n10;
        }
    }

    public int getHeight() {
        synchronized (this) {
            Image image = this.mImage;
            int n10 = image.getHeight();
            return n10;
        }
    }

    public Image getImage() {
        synchronized (this) {
            Image image = this.mImage;
            return image;
        }
    }

    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    public ImageProxy$PlaneProxy[] getPlanes() {
        synchronized (this) {
            ImageProxy$PlaneProxy[] imageProxy$PlaneProxyArray = this.mPlanes;
            return imageProxy$PlaneProxyArray;
        }
    }

    public int getWidth() {
        synchronized (this) {
            Image image = this.mImage;
            int n10 = image.getWidth();
            return n10;
        }
    }

    public void setCropRect(Rect rect) {
        synchronized (this) {
            Image image = this.mImage;
            image.setCropRect(rect);
            return;
        }
    }
}

