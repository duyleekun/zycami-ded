/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.Image
 *  android.media.ImageReader
 *  android.os.Handler
 *  android.view.Surface
 */
package androidx.camera.core;

import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.core.AndroidImageProxy;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import b.a.b.b;
import b.a.b.c;
import java.util.concurrent.Executor;

public final class AndroidImageReaderProxy
implements ImageReaderProxy {
    private final ImageReader mImageReader;

    public AndroidImageReaderProxy(ImageReader imageReader) {
        this.mImageReader = imageReader;
    }

    private /* synthetic */ void a(ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener) {
        imageReaderProxy$OnImageAvailableListener.onImageAvailable(this);
    }

    private /* synthetic */ void c(Executor executor, ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener, ImageReader object) {
        object = new c(this, imageReaderProxy$OnImageAvailableListener);
        executor.execute((Runnable)object);
    }

    private boolean isImageReaderContextNotInitializedException(RuntimeException object) {
        object = ((Throwable)object).getMessage();
        return "ImageReaderContext is not initialized".equals(object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ImageProxy acquireLatestImage() {
        synchronized (this) {
            Throwable throwable22;
            ImageReader imageReader;
            block6: {
                AndroidImageProxy androidImageProxy = null;
                try {
                    try {
                        imageReader = this.mImageReader;
                        imageReader = imageReader.acquireLatestImage();
                    }
                    catch (RuntimeException runtimeException) {
                        boolean bl2 = this.isImageReaderContextNotInitializedException(runtimeException);
                        if (!bl2) throw runtimeException;
                        return null;
                    }
                    if (imageReader != null) break block6;
                }
                catch (Throwable throwable22) {}
                return null;
            }
            return new AndroidImageProxy((Image)imageReader);
            throw throwable22;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ImageProxy acquireNextImage() {
        synchronized (this) {
            Throwable throwable22;
            ImageReader imageReader;
            block6: {
                AndroidImageProxy androidImageProxy = null;
                try {
                    try {
                        imageReader = this.mImageReader;
                        imageReader = imageReader.acquireNextImage();
                    }
                    catch (RuntimeException runtimeException) {
                        boolean bl2 = this.isImageReaderContextNotInitializedException(runtimeException);
                        if (!bl2) throw runtimeException;
                        return null;
                    }
                    if (imageReader != null) break block6;
                }
                catch (Throwable throwable22) {}
                return null;
            }
            return new AndroidImageProxy((Image)imageReader);
            throw throwable22;
        }
    }

    public /* synthetic */ void b(ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener) {
        this.a(imageReaderProxy$OnImageAvailableListener);
    }

    public void clearOnImageAvailableListener() {
        synchronized (this) {
            ImageReader imageReader = this.mImageReader;
            imageReader.setOnImageAvailableListener(null, null);
            return;
        }
    }

    public void close() {
        synchronized (this) {
            ImageReader imageReader = this.mImageReader;
            imageReader.close();
            return;
        }
    }

    public /* synthetic */ void d(Executor executor, ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener, ImageReader imageReader) {
        this.c(executor, imageReaderProxy$OnImageAvailableListener, imageReader);
    }

    public int getHeight() {
        synchronized (this) {
            ImageReader imageReader = this.mImageReader;
            int n10 = imageReader.getHeight();
            return n10;
        }
    }

    public int getImageFormat() {
        synchronized (this) {
            ImageReader imageReader = this.mImageReader;
            int n10 = imageReader.getImageFormat();
            return n10;
        }
    }

    public int getMaxImages() {
        synchronized (this) {
            ImageReader imageReader = this.mImageReader;
            int n10 = imageReader.getMaxImages();
            return n10;
        }
    }

    public Surface getSurface() {
        synchronized (this) {
            ImageReader imageReader = this.mImageReader;
            imageReader = imageReader.getSurface();
            return imageReader;
        }
    }

    public int getWidth() {
        synchronized (this) {
            ImageReader imageReader = this.mImageReader;
            int n10 = imageReader.getWidth();
            return n10;
        }
    }

    public void setOnImageAvailableListener(ImageReaderProxy$OnImageAvailableListener imageReaderProxy$OnImageAvailableListener, Executor executor) {
        synchronized (this) {
            b b10 = new b(this, executor, imageReaderProxy$OnImageAvailableListener);
            imageReaderProxy$OnImageAvailableListener = this.mImageReader;
            executor = MainThreadAsyncHandler.getInstance();
            imageReaderProxy$OnImageAvailableListener.setOnImageAvailableListener(b10, (Handler)executor);
            return;
        }
    }
}

