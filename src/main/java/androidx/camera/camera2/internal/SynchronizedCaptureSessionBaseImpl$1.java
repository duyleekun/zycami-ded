/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.view.Surface
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.core.util.Preconditions;

public class SynchronizedCaptureSessionBaseImpl$1
extends CameraCaptureSession.StateCallback {
    public final /* synthetic */ SynchronizedCaptureSessionBaseImpl this$0;

    public SynchronizedCaptureSessionBaseImpl$1(SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl) {
        this.this$0 = synchronizedCaptureSessionBaseImpl;
    }

    public void onActive(CameraCaptureSession object) {
        this.this$0.createCaptureSessionCompat((CameraCaptureSession)object);
        object = this.this$0;
        ((SynchronizedCaptureSessionBaseImpl)object).onActive((SynchronizedCaptureSession)object);
    }

    public void onCaptureQueueEmpty(CameraCaptureSession object) {
        this.this$0.createCaptureSessionCompat((CameraCaptureSession)object);
        object = this.this$0;
        ((SynchronizedCaptureSessionBaseImpl)object).onCaptureQueueEmpty((SynchronizedCaptureSession)object);
    }

    public void onClosed(CameraCaptureSession object) {
        this.this$0.createCaptureSessionCompat((CameraCaptureSession)object);
        object = this.this$0;
        ((SynchronizedCaptureSessionBaseImpl)object).onClosed((SynchronizedCaptureSession)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onConfigureFailed(CameraCaptureSession object) {
        Object object2;
        Object object3;
        IllegalStateException illegalStateException = null;
        try {
            object3 = this.this$0;
            ((SynchronizedCaptureSessionBaseImpl)object3).createCaptureSessionCompat((CameraCaptureSession)object);
            object = this.this$0;
            ((SynchronizedCaptureSessionBaseImpl)object).onConfigureFailed((SynchronizedCaptureSession)object);
            object = this.this$0.mLock;
        }
        catch (Throwable throwable) {
            Object object4;
            Object object5 = this.this$0.mLock;
            synchronized (object5) {
                Object object6 = this.this$0;
                object6 = ((SynchronizedCaptureSessionBaseImpl)object6).mOpenCaptureSessionCompleter;
                object4 = "OpenCaptureSession completer should not null";
                Preconditions.checkNotNull(object6, object4);
                object6 = this.this$0;
                object4 = ((SynchronizedCaptureSessionBaseImpl)object6).mOpenCaptureSessionCompleter;
                ((SynchronizedCaptureSessionBaseImpl)object6).mOpenCaptureSessionCompleter = null;
            }
            illegalStateException = new IllegalStateException("onConfigureFailed");
            ((CallbackToFutureAdapter$Completer)object4).setException(illegalStateException);
            throw throwable;
        }
        synchronized (object) {
            object3 = this.this$0;
            object3 = ((SynchronizedCaptureSessionBaseImpl)object3).mOpenCaptureSessionCompleter;
            object2 = "OpenCaptureSession completer should not null";
            Preconditions.checkNotNull(object3, object2);
            object3 = this.this$0;
            object2 = ((SynchronizedCaptureSessionBaseImpl)object3).mOpenCaptureSessionCompleter;
            ((SynchronizedCaptureSessionBaseImpl)object3).mOpenCaptureSessionCompleter = null;
        }
        object = new IllegalStateException("onConfigureFailed");
        ((CallbackToFutureAdapter$Completer)object2).setException((Throwable)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onConfigured(CameraCaptureSession object) {
        Object object2;
        Object object3;
        Object var2_3 = null;
        try {
            object3 = this.this$0;
            ((SynchronizedCaptureSessionBaseImpl)object3).createCaptureSessionCompat((CameraCaptureSession)object);
            object = this.this$0;
            ((SynchronizedCaptureSessionBaseImpl)object).onConfigured((SynchronizedCaptureSession)object);
            object = this.this$0.mLock;
        }
        catch (Throwable throwable) {
            Object object4;
            Object object5 = this.this$0.mLock;
            synchronized (object5) {
                Object object6 = this.this$0;
                object6 = ((SynchronizedCaptureSessionBaseImpl)object6).mOpenCaptureSessionCompleter;
                object4 = "OpenCaptureSession completer should not null";
                Preconditions.checkNotNull(object6, object4);
                object6 = this.this$0;
                object4 = ((SynchronizedCaptureSessionBaseImpl)object6).mOpenCaptureSessionCompleter;
                ((SynchronizedCaptureSessionBaseImpl)object6).mOpenCaptureSessionCompleter = null;
            }
            ((CallbackToFutureAdapter$Completer)object4).set(null);
            throw throwable;
        }
        synchronized (object) {
            object3 = this.this$0;
            object3 = ((SynchronizedCaptureSessionBaseImpl)object3).mOpenCaptureSessionCompleter;
            object2 = "OpenCaptureSession completer should not null";
            Preconditions.checkNotNull(object3, object2);
            object3 = this.this$0;
            object2 = ((SynchronizedCaptureSessionBaseImpl)object3).mOpenCaptureSessionCompleter;
            ((SynchronizedCaptureSessionBaseImpl)object3).mOpenCaptureSessionCompleter = null;
        }
        ((CallbackToFutureAdapter$Completer)object2).set(null);
    }

    public void onReady(CameraCaptureSession object) {
        this.this$0.createCaptureSessionCompat((CameraCaptureSession)object);
        object = this.this$0;
        ((SynchronizedCaptureSessionBaseImpl)object).onReady((SynchronizedCaptureSession)object);
    }

    public void onSurfacePrepared(CameraCaptureSession object, Surface surface) {
        this.this$0.createCaptureSessionCompat((CameraCaptureSession)object);
        object = this.this$0;
        ((SynchronizedCaptureSessionBaseImpl)object).onSurfacePrepared((SynchronizedCaptureSession)object, surface);
    }
}

