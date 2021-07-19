/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.CameraX;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public class CameraX$1
implements FutureCallback {
    public final /* synthetic */ CameraX val$cameraX;
    public final /* synthetic */ CallbackToFutureAdapter$Completer val$completer;

    public CameraX$1(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, CameraX cameraX) {
        this.val$completer = callbackToFutureAdapter$Completer;
        this.val$cameraX = cameraX;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onFailure(Throwable throwable) {
        Object object = "CameraX initialize() failed";
        Logger.w("CameraX", (String)object, throwable);
        Object object2 = CameraX.INSTANCE_LOCK;
        synchronized (object2) {
            object = CameraX.sInstance;
            CameraX cameraX = this.val$cameraX;
            if (object == cameraX) {
                CameraX.shutdownLocked();
            }
        }
        this.val$completer.setException(throwable);
    }

    public void onSuccess(Void void_) {
        this.val$completer.set(null);
    }
}

