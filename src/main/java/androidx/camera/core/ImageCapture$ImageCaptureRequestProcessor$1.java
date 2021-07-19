/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ForwardingImageProxy$OnImageCloseListener;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCapture$ImageCaptureRequest;
import androidx.camera.core.ImageCapture$ImageCaptureRequestProcessor;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.SingleCloseImageProxy;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.core.util.Preconditions;
import java.util.concurrent.CancellationException;

public class ImageCapture$ImageCaptureRequestProcessor$1
implements FutureCallback {
    public final /* synthetic */ ImageCapture$ImageCaptureRequestProcessor this$0;
    public final /* synthetic */ ImageCapture$ImageCaptureRequest val$imageCaptureRequest;

    public ImageCapture$ImageCaptureRequestProcessor$1(ImageCapture$ImageCaptureRequestProcessor imageCaptureRequestProcessor, ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest) {
        this.this$0 = imageCaptureRequestProcessor;
        this.val$imageCaptureRequest = imageCapture$ImageCaptureRequest;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onFailure(Throwable object) {
        Object object2 = this.this$0.mLock;
        synchronized (object2) {
            ImageCapture$ImageCaptureRequest imageCapture$ImageCaptureRequest;
            boolean bl2 = object instanceof CancellationException;
            if (!bl2) {
                imageCapture$ImageCaptureRequest = this.val$imageCaptureRequest;
                int n10 = ImageCapture.getError((Throwable)object);
                String string2 = object != null ? ((Throwable)object).getMessage() : "Unknown error";
                imageCapture$ImageCaptureRequest.notifyCallbackError(n10, string2, (Throwable)object);
            }
            object = this.this$0;
            bl2 = false;
            imageCapture$ImageCaptureRequest = null;
            ((ImageCapture$ImageCaptureRequestProcessor)object).mCurrentRequest = null;
            ((ImageCapture$ImageCaptureRequestProcessor)object).mCurrentRequestFuture = null;
            ((ImageCapture$ImageCaptureRequestProcessor)object).processNextRequest();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onSuccess(ImageProxy object) {
        Object object2 = this.this$0.mLock;
        synchronized (object2) {
            int n10;
            Preconditions.checkNotNull(object);
            SingleCloseImageProxy singleCloseImageProxy = new SingleCloseImageProxy((ImageProxy)object);
            object = this.this$0;
            singleCloseImageProxy.addOnImageCloseListener((ForwardingImageProxy$OnImageCloseListener)object);
            object = this.this$0;
            ((ImageCapture$ImageCaptureRequestProcessor)object).mOutstandingImages = n10 = ((ImageCapture$ImageCaptureRequestProcessor)object).mOutstandingImages + 1;
            object = this.val$imageCaptureRequest;
            ((ImageCapture$ImageCaptureRequest)object).dispatchImage(singleCloseImageProxy);
            object = this.this$0;
            singleCloseImageProxy = null;
            ((ImageCapture$ImageCaptureRequestProcessor)object).mCurrentRequest = null;
            ((ImageCapture$ImageCaptureRequestProcessor)object).mCurrentRequestFuture = null;
            ((ImageCapture$ImageCaptureRequestProcessor)object).processNextRequest();
            return;
        }
    }
}

