/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package androidx.camera.core;

import android.os.SystemClock;
import androidx.camera.core.ImageCapture$CaptureCallbackChecker$1;
import androidx.camera.core.ImageCapture$CaptureCallbackChecker$CaptureResultChecker;
import androidx.camera.core.ImageCapture$CaptureCallbackChecker$CaptureResultListener;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import b.a.b.w;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashSet;
import java.util.Set;

public final class ImageCapture$CaptureCallbackChecker
extends CameraCaptureCallback {
    private static final long NO_TIMEOUT;
    private final Set mCaptureResultListeners;

    public ImageCapture$CaptureCallbackChecker() {
        HashSet hashSet;
        this.mCaptureResultListeners = hashSet = new HashSet();
    }

    private /* synthetic */ Object a(ImageCapture$CaptureCallbackChecker$CaptureResultChecker imageCapture$CaptureCallbackChecker$CaptureResultChecker, long l10, long l11, Object object, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        ImageCapture$CaptureCallbackChecker$1 imageCapture$CaptureCallbackChecker$1 = new ImageCapture$CaptureCallbackChecker$1(this, imageCapture$CaptureCallbackChecker$CaptureResultChecker, callbackToFutureAdapter$Completer, l10, l11, object);
        this.addListener(imageCapture$CaptureCallbackChecker$1);
        return "checkCaptureResult";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void deliverCaptureResultToListeners(CameraCaptureResult object) {
        Set set = this.mCaptureResultListeners;
        synchronized (set) {
            boolean bl2;
            HashSet<Object> hashSet = null;
            Object object2 = this.mCaptureResultListeners;
            Object object3 = new HashSet(object2);
            object3 = ((HashSet)object3).iterator();
            while (bl2 = object3.hasNext()) {
                object2 = object3.next();
                boolean bl3 = (object2 = (ImageCapture$CaptureCallbackChecker$CaptureResultListener)object2).onCaptureResult((CameraCaptureResult)object);
                if (!bl3) continue;
                if (hashSet == null) {
                    hashSet = new HashSet<Object>();
                }
                hashSet.add(object2);
            }
            if (hashSet != null) {
                object = this.mCaptureResultListeners;
                object.removeAll(hashSet);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addListener(ImageCapture$CaptureCallbackChecker$CaptureResultListener imageCapture$CaptureCallbackChecker$CaptureResultListener) {
        Set set = this.mCaptureResultListeners;
        synchronized (set) {
            Set set2 = this.mCaptureResultListeners;
            set2.add(imageCapture$CaptureCallbackChecker$CaptureResultListener);
            return;
        }
    }

    public /* synthetic */ Object b(ImageCapture$CaptureCallbackChecker$CaptureResultChecker imageCapture$CaptureCallbackChecker$CaptureResultChecker, long l10, long l11, Object object, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        return this.a(imageCapture$CaptureCallbackChecker$CaptureResultChecker, l10, l11, object, callbackToFutureAdapter$Completer);
    }

    public ListenableFuture checkCaptureResult(ImageCapture$CaptureCallbackChecker$CaptureResultChecker imageCapture$CaptureCallbackChecker$CaptureResultChecker) {
        return this.checkCaptureResult(imageCapture$CaptureCallbackChecker$CaptureResultChecker, 0L, null);
    }

    public ListenableFuture checkCaptureResult(ImageCapture$CaptureCallbackChecker$CaptureResultChecker object, long l10, Object object2) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 >= 0) {
            if (object3 != false) {
                l11 = SystemClock.elapsedRealtime();
            }
            w w10 = new w(this, (ImageCapture$CaptureCallbackChecker$CaptureResultChecker)object, l11, l10, object2);
            return CallbackToFutureAdapter.getFuture(w10);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Invalid timeout value: ");
        ((StringBuilder)object2).append(l10);
        String string2 = ((StringBuilder)object2).toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
        this.deliverCaptureResultToListeners(cameraCaptureResult);
    }
}

