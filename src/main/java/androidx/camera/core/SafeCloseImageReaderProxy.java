/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.ForwardingImageProxy$OnImageCloseListener;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.SingleCloseImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;
import b.a.b.a1;
import b.a.b.b1;
import java.util.concurrent.Executor;

public class SafeCloseImageReaderProxy
implements ImageReaderProxy {
    private ForwardingImageProxy$OnImageCloseListener mImageCloseListener;
    private final ImageReaderProxy mImageReaderProxy;
    private volatile boolean mIsClosed;
    private final Object mLock;
    private volatile int mOutstandingImages;
    private final Surface mSurface;

    public SafeCloseImageReaderProxy(ImageReaderProxy imageReaderProxy) {
        Object object;
        this.mLock = object = new Object();
        this.mOutstandingImages = 0;
        this.mIsClosed = false;
        this.mImageCloseListener = object = new b1(this);
        this.mImageReaderProxy = imageReaderProxy;
        imageReaderProxy = imageReaderProxy.getSurface();
        this.mSurface = imageReaderProxy;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void a(ImageProxy object) {
        object = this.mLock;
        synchronized (object) {
            int n10;
            this.mOutstandingImages = n10 = this.mOutstandingImages + -1;
            n10 = (int)(this.mIsClosed ? 1 : 0);
            if (n10 != 0 && (n10 = this.mOutstandingImages) == 0) {
                this.close();
            }
            return;
        }
    }

    private /* synthetic */ void c(ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener, ImageReaderProxy imageReaderProxy) {
        imageReaderProxy$OnImageAvailableListener.onImageAvailable(this);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ImageProxy wrapImageProxy(ImageProxy object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            if (object != null) {
                int n10;
                this.mOutstandingImages = n10 = this.mOutstandingImages + 1;
                SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy((ImageProxy)object);
                object = this.mImageCloseListener;
                singleCloseImageProxy.addOnImageCloseListener((ForwardingImageProxy$OnImageCloseListener)object);
                return singleCloseImageProxy;
            }
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ImageProxy acquireLatestImage() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mImageReaderProxy;
            object2 = object2.acquireLatestImage();
            return this.wrapImageProxy((ImageProxy)object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ImageProxy acquireNextImage() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mImageReaderProxy;
            object2 = object2.acquireNextImage();
            return this.wrapImageProxy((ImageProxy)object2);
        }
    }

    public /* synthetic */ void b(ImageProxy imageProxy) {
        this.a(imageProxy);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clearOnImageAvailableListener() {
        Object object = this.mLock;
        synchronized (object) {
            ImageReaderProxy imageReaderProxy = this.mImageReaderProxy;
            imageReaderProxy.clearOnImageAvailableListener();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mSurface;
            if (object2 != null) {
                object2.release();
            }
            object2 = this.mImageReaderProxy;
            object2.close();
            return;
        }
    }

    public /* synthetic */ void d(ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener, ImageReaderProxy imageReaderProxy) {
        this.c(imageReaderProxy$OnImageAvailableListener, imageReaderProxy);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getHeight() {
        Object object = this.mLock;
        synchronized (object) {
            ImageReaderProxy imageReaderProxy = this.mImageReaderProxy;
            return imageReaderProxy.getHeight();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getImageFormat() {
        Object object = this.mLock;
        synchronized (object) {
            ImageReaderProxy imageReaderProxy = this.mImageReaderProxy;
            return imageReaderProxy.getImageFormat();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getMaxImages() {
        Object object = this.mLock;
        synchronized (object) {
            ImageReaderProxy imageReaderProxy = this.mImageReaderProxy;
            return imageReaderProxy.getMaxImages();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Surface getSurface() {
        Object object = this.mLock;
        synchronized (object) {
            ImageReaderProxy imageReaderProxy = this.mImageReaderProxy;
            return imageReaderProxy.getSurface();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int getWidth() {
        Object object = this.mLock;
        synchronized (object) {
            ImageReaderProxy imageReaderProxy = this.mImageReaderProxy;
            return imageReaderProxy.getWidth();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void safeClose() {
        Object object = this.mLock;
        synchronized (object) {
            int n10;
            this.mIsClosed = n10 = 1;
            ImageReaderProxy imageReaderProxy = this.mImageReaderProxy;
            imageReaderProxy.clearOnImageAvailableListener();
            n10 = this.mOutstandingImages;
            if (n10 == 0) {
                this.close();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setOnImageAvailableListener(ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener, Executor executor) {
        Object object = this.mLock;
        synchronized (object) {
            ImageReaderProxy imageReaderProxy = this.mImageReaderProxy;
            a1 a12 = new a1(this, imageReaderProxy$OnImageAvailableListener);
            imageReaderProxy.setOnImageAvailableListener(a12, executor);
            return;
        }
    }
}

