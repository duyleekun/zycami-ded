/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.media.Image
 */
package androidx.camera.core;

import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.ForwardingImageProxy$OnImageCloseListener;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageProxy$PlaneProxy;
import java.util.HashSet;
import java.util.Set;

public abstract class ForwardingImageProxy
implements ImageProxy {
    public final ImageProxy mImage;
    private final Set mOnImageCloseListeners;

    public ForwardingImageProxy(ImageProxy imageProxy) {
        HashSet hashSet;
        this.mOnImageCloseListeners = hashSet = new HashSet();
        this.mImage = imageProxy;
    }

    public void addOnImageCloseListener(ForwardingImageProxy$OnImageCloseListener forwardingImageProxy$OnImageCloseListener) {
        synchronized (this) {
            Set set = this.mOnImageCloseListeners;
            set.add(forwardingImageProxy$OnImageCloseListener);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        synchronized (this) {
            ImageProxy imageProxy = this.mImage;
            imageProxy.close();
        }
        this.notifyOnImageCloseListeners();
    }

    public Rect getCropRect() {
        synchronized (this) {
            ImageProxy imageProxy = this.mImage;
            imageProxy = imageProxy.getCropRect();
            return imageProxy;
        }
    }

    public int getFormat() {
        synchronized (this) {
            ImageProxy imageProxy = this.mImage;
            int n10 = imageProxy.getFormat();
            return n10;
        }
    }

    public int getHeight() {
        synchronized (this) {
            ImageProxy imageProxy = this.mImage;
            int n10 = imageProxy.getHeight();
            return n10;
        }
    }

    public Image getImage() {
        synchronized (this) {
            ImageProxy imageProxy = this.mImage;
            imageProxy = imageProxy.getImage();
            return imageProxy;
        }
    }

    public ImageInfo getImageInfo() {
        synchronized (this) {
            Object object = this.mImage;
            object = object.getImageInfo();
            return object;
        }
    }

    public ImageProxy$PlaneProxy[] getPlanes() {
        synchronized (this) {
            ImageProxy$PlaneProxy[] imageProxy$PlaneProxyArray = this.mImage;
            imageProxy$PlaneProxyArray = imageProxy$PlaneProxyArray.getPlanes();
            return imageProxy$PlaneProxyArray;
        }
    }

    public int getWidth() {
        synchronized (this) {
            ImageProxy imageProxy = this.mImage;
            int n10 = imageProxy.getWidth();
            return n10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void notifyOnImageCloseListeners() {
        Object object;
        Object object2;
        synchronized (this) {
            object2 = this.mOnImageCloseListeners;
            object = new HashSet(object2);
        }
        object = object.iterator();
        boolean bl2;
        while (bl2 = object.hasNext()) {
            object2 = (ForwardingImageProxy$OnImageCloseListener)object.next();
            object2.onImageClose(this);
        }
        return;
    }

    public void setCropRect(Rect rect) {
        synchronized (this) {
            ImageProxy imageProxy = this.mImage;
            imageProxy.setCropRect(rect);
            return;
        }
    }
}

