/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.ArrayMap
 */
package androidx.camera.camera2.internal;

import android.util.ArrayMap;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import b.a.a.d.c;
import b.a.a.d.d;
import b.a.a.d.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class Camera2CameraControlImpl$CameraCaptureCallbackSet
extends CameraCaptureCallback {
    public Map mCallbackExecutors;
    public Set mCallbacks;

    public Camera2CameraControlImpl$CameraCaptureCallbackSet() {
        ArrayMap arrayMap;
        this.mCallbacks = arrayMap = new HashSet();
        arrayMap = new ArrayMap();
        this.mCallbackExecutors = arrayMap;
    }

    public static /* synthetic */ void a(CameraCaptureCallback cameraCaptureCallback) {
        cameraCaptureCallback.onCaptureCancelled();
    }

    public static /* synthetic */ void b(CameraCaptureCallback cameraCaptureCallback, CameraCaptureResult cameraCaptureResult) {
        cameraCaptureCallback.onCaptureCompleted(cameraCaptureResult);
    }

    public static /* synthetic */ void c(CameraCaptureCallback cameraCaptureCallback, CameraCaptureFailure cameraCaptureFailure) {
        cameraCaptureCallback.onCaptureFailed(cameraCaptureFailure);
    }

    public void addCaptureCallback(Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        this.mCallbacks.add(cameraCaptureCallback);
        this.mCallbackExecutors.put(cameraCaptureCallback, executor);
    }

    public void onCaptureCancelled() {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureCallback cameraCaptureCallback = (CameraCaptureCallback)iterator2.next();
            Object object = this.mCallbackExecutors;
            object = object.get(cameraCaptureCallback);
            object = (Executor)object;
            Object object2 = new d(cameraCaptureCallback);
            try {
                object.execute((Runnable)object2);
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                object = "Camera2CameraControlImp";
                object2 = "Executor rejected to invoke onCaptureCancelled.";
                Logger.e((String)object, (String)object2, rejectedExecutionException);
            }
        }
    }

    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureCallback cameraCaptureCallback = (CameraCaptureCallback)iterator2.next();
            Object object = this.mCallbackExecutors;
            object = object.get(cameraCaptureCallback);
            object = (Executor)object;
            Object object2 = new c(cameraCaptureCallback, cameraCaptureResult);
            try {
                object.execute((Runnable)object2);
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                object = "Camera2CameraControlImp";
                object2 = "Executor rejected to invoke onCaptureCompleted.";
                Logger.e((String)object, (String)object2, rejectedExecutionException);
            }
        }
    }

    public void onCaptureFailed(CameraCaptureFailure cameraCaptureFailure) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureCallback cameraCaptureCallback = (CameraCaptureCallback)iterator2.next();
            Object object = this.mCallbackExecutors;
            object = object.get(cameraCaptureCallback);
            object = (Executor)object;
            Object object2 = new e(cameraCaptureCallback, cameraCaptureFailure);
            try {
                object.execute((Runnable)object2);
            }
            catch (RejectedExecutionException rejectedExecutionException) {
                object = "Camera2CameraControlImp";
                object2 = "Executor rejected to invoke onCaptureFailed.";
                Logger.e((String)object, (String)object2, rejectedExecutionException);
            }
        }
    }

    public void removeCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
        this.mCallbacks.remove(cameraCaptureCallback);
        this.mCallbackExecutors.remove(cameraCaptureCallback);
    }
}

