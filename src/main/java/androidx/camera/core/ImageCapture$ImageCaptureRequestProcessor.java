/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy$OnImageCloseListener;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$ImageCaptureRequest;
import androidx.camera.core.ImageCapture$ImageCaptureRequestProcessor$1;
import androidx.camera.core.ImageCapture$ImageCaptureRequestProcessor$ImageCaptor;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Executor;

public class ImageCapture$ImageCaptureRequestProcessor
implements ForwardingImageProxy$OnImageCloseListener {
    public ImageCapture$ImageCaptureRequest mCurrentRequest;
    public ListenableFuture mCurrentRequestFuture;
    private final ImageCapture$ImageCaptureRequestProcessor$ImageCaptor mImageCaptor;
    public final Object mLock;
    private final int mMaxImages;
    public int mOutstandingImages;
    private final Deque mPendingRequests;

    public ImageCapture$ImageCaptureRequestProcessor(int n10, ImageCapture$ImageCaptureRequestProcessor$ImageCaptor imageCapture$ImageCaptureRequestProcessor$ImageCaptor) {
        Object object = new ArrayDeque();
        this.mPendingRequests = object;
        this.mCurrentRequest = null;
        this.mCurrentRequestFuture = null;
        this.mOutstandingImages = 0;
        this.mLock = object = new Object();
        this.mMaxImages = n10;
        this.mImageCaptor = imageCapture$ImageCaptureRequestProcessor$ImageCaptor;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void cancelRequests(Throwable throwable) {
        boolean bl2;
        Iterator iterator2 = this.mLock;
        // MONITORENTER : iterator2
        ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest = this.mCurrentRequest;
        int n10 = 0;
        ArrayList arrayList = null;
        this.mCurrentRequest = null;
        Object object = this.mCurrentRequestFuture;
        this.mCurrentRequestFuture = null;
        Object object2 = this.mPendingRequests;
        arrayList = new ArrayList(object2);
        object2 = this.mPendingRequests;
        object2.clear();
        // MONITOREXIT : iterator2
        if (imageCapture$ImageCaptureRequest != null && object != null) {
            boolean bl3 = ImageCapture.getError(throwable);
            object2 = throwable.getMessage();
            imageCapture$ImageCaptureRequest.notifyCallbackError((int)(bl3 ? 1 : 0), (String)object2, throwable);
            bl3 = true;
            object.cancel(bl3);
        }
        iterator2 = arrayList.iterator();
        while (bl2 = iterator2.hasNext()) {
            imageCapture$ImageCaptureRequest = (ImageCapture$ImageCaptureRequest)iterator2.next();
            n10 = ImageCapture.getError(throwable);
            object = throwable.getMessage();
            imageCapture$ImageCaptureRequest.notifyCallbackError(n10, (String)object, throwable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onImageClose(ImageProxy object) {
        object = this.mLock;
        synchronized (object) {
            int n10;
            this.mOutstandingImages = n10 = this.mOutstandingImages + -1;
            this.processNextRequest();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void processNextRequest() {
        Object object = this.mLock;
        synchronized (object) {
            Object object2 = this.mCurrentRequest;
            if (object2 != null) {
                return;
            }
            int n10 = this.mOutstandingImages;
            int n11 = this.mMaxImages;
            if (n10 >= n11) {
                object2 = "ImageCapture";
                String string2 = "Too many acquire images. Close image to be able to process next.";
                Logger.w((String)object2, string2);
                return;
            }
            object2 = this.mPendingRequests;
            object2 = object2.poll();
            if ((object2 = (ImageCapture$ImageCaptureRequest)object2) == null) {
                return;
            }
            this.mCurrentRequest = object2;
            Object object3 = this.mImageCaptor;
            this.mCurrentRequestFuture = object3 = object3.capture((ImageCapture$ImageCaptureRequest)object2);
            ImageCapture$ImageCaptureRequestProcessor$1 imageCapture$ImageCaptureRequestProcessor$1 = new ImageCapture$ImageCaptureRequestProcessor$1(this, (ImageCapture$ImageCaptureRequest)object2);
            object2 = CameraXExecutors.directExecutor();
            Futures.addCallback((ListenableFuture)object3, imageCapture$ImageCaptureRequestProcessor$1, (Executor)object2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void sendRequest(ImageCapture$ImageCaptureRequest object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            int n10;
            Object object3 = this.mPendingRequests;
            object3.offer(object);
            object = "ImageCapture";
            object3 = Locale.US;
            String string2 = "Send image capture request [current, pending] = [%d, %d]";
            int n11 = 2;
            Object[] objectArray = new Object[n11];
            Object object4 = this.mCurrentRequest;
            int n12 = 1;
            if (object4 != null) {
                n10 = n12;
            } else {
                n10 = 0;
                object4 = null;
            }
            objectArray[0] = object4 = Integer.valueOf(n10);
            object4 = this.mPendingRequests;
            n10 = object4.size();
            objectArray[n12] = object4 = Integer.valueOf(n10);
            object3 = String.format((Locale)object3, string2, objectArray);
            Logger.d((String)object, (String)object3);
            this.processNextRequest();
            return;
        }
    }
}

