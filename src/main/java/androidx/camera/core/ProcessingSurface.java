/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Size
 *  android.view.Surface
 */
package androidx.camera.core;

import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.ProcessingSurface$1;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImageReaderProxy$OnImageAvailableListener;
import androidx.camera.core.impl.SingleImageProxyBundle;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import b.a.b.y0;
import b.a.b.z0;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public final class ProcessingSurface
extends DeferrableSurface {
    private static final int MAX_IMAGES = 2;
    private static final String TAG = "ProcessingSurfaceTextur";
    private final CameraCaptureCallback mCameraCaptureCallback;
    public final CaptureProcessor mCaptureProcessor;
    public final CaptureStage mCaptureStage;
    private final Handler mImageReaderHandler;
    public final MetadataImageReader mInputImageReader;
    public final Surface mInputSurface;
    public final Object mLock;
    private final DeferrableSurface mOutputDeferrableSurface;
    public boolean mReleased;
    private final Size mResolution;
    private String mTagBundleKey;
    private final ImageReaderProxy$OnImageAvailableListener mTransformedListener;

    public ProcessingSurface(int n10, int n11, int n12, Handler object, CaptureStage captureStage, CaptureProcessor captureProcessor, DeferrableSurface deferrableSurface, String string2) {
        block4: {
            Object object2;
            Size size;
            Object object3;
            block3: {
                block2: {
                    this.mLock = object3 = new Object();
                    this.mTransformedListener = object3 = new z0(this);
                    this.mReleased = false;
                    this.mResolution = size = new Size(n10, n11);
                    if (object == null) break block2;
                    this.mImageReaderHandler = object;
                    break block3;
                }
                object = Looper.myLooper();
                if (object == null) break block4;
                object2 = new Handler((Looper)object);
                this.mImageReaderHandler = object2;
            }
            object = CameraXExecutors.newHandlerExecutor(this.mImageReaderHandler);
            super(n10, n11, n12, 2);
            this.mInputImageReader = object2;
            ((MetadataImageReader)object2).setOnImageAvailableListener((ImageReaderProxy$OnImageAvailableListener)object3, (Executor)object);
            Object object4 = ((MetadataImageReader)object2).getSurface();
            this.mInputSurface = object4;
            object4 = ((MetadataImageReader)object2).getCameraCaptureCallback();
            this.mCameraCaptureCallback = object4;
            this.mCaptureProcessor = captureProcessor;
            captureProcessor.onResolutionUpdate(size);
            this.mCaptureStage = captureStage;
            this.mOutputDeferrableSurface = deferrableSurface;
            this.mTagBundleKey = string2;
            object4 = deferrableSurface.getSurface();
            Object object5 = new ProcessingSurface$1(this);
            Executor executor = CameraXExecutors.directExecutor();
            Futures.addCallback((ListenableFuture)object4, (FutureCallback)object5, executor);
            object4 = this.getTerminationFuture();
            object5 = new y0(this);
            executor = CameraXExecutors.directExecutor();
            object4.addListener((Runnable)object5, executor);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Creating a ProcessingSurface requires a non-null Handler, or be created  on a thread with a Looper.");
        throw illegalStateException;
    }

    public static /* synthetic */ void e(ProcessingSurface processingSurface) {
        processingSurface.release();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ void f(ImageReaderProxy imageReaderProxy) {
        Object object = this.mLock;
        synchronized (object) {
            this.imageIncoming(imageReaderProxy);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void release() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.mReleased;
            if (bl2) {
                return;
            }
            Object object2 = this.mInputImageReader;
            ((MetadataImageReader)object2).close();
            object2 = this.mInputSurface;
            object2.release();
            object2 = this.mOutputDeferrableSurface;
            ((DeferrableSurface)object2).close();
            this.mReleased = bl2 = true;
            return;
        }
    }

    public /* synthetic */ void g(ImageReaderProxy imageReaderProxy) {
        this.f(imageReaderProxy);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CameraCaptureCallback getCameraCaptureCallback() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.mReleased;
            if (!bl2) {
                return this.mCameraCaptureCallback;
            }
            String string2 = "ProcessingSurface already released!";
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
    }

    public void imageIncoming(ImageReaderProxy object) {
        int n10;
        Object object2;
        Object object3 = TAG;
        boolean bl2 = this.mReleased;
        if (bl2) {
            return;
        }
        bl2 = false;
        ImageProxy imageProxy = null;
        try {
            imageProxy = object.acquireNextImage();
        }
        catch (IllegalStateException illegalStateException) {
            object2 = "Failed to acquire next image.";
            Logger.e((String)object3, (String)object2, illegalStateException);
        }
        if (imageProxy == null) {
            return;
        }
        object = imageProxy.getImageInfo();
        if (object == null) {
            imageProxy.close();
            return;
        }
        object = object.getTagBundle();
        object2 = this.mTagBundleKey;
        if ((object = ((TagBundle)object).getTag((String)object2)) == null) {
            imageProxy.close();
            return;
        }
        object2 = this.mCaptureStage;
        int n11 = object2.getId();
        if (n11 != (n10 = ((Integer)object).intValue())) {
            object2 = new StringBuilder();
            String string2 = "ImageProxyBundle does not contain this id: ";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(object);
            object = ((StringBuilder)object2).toString();
            Logger.w((String)object3, (String)object);
            imageProxy.close();
        } else {
            object3 = this.mTagBundleKey;
            object = new SingleImageProxyBundle(imageProxy, (String)object3);
            object3 = this.mCaptureProcessor;
            object3.process((ImageProxyBundle)object);
            ((SingleImageProxyBundle)object).close();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ListenableFuture provideSurface() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mInputSurface;
            return Futures.immediateFuture(object2);
        }
    }
}

