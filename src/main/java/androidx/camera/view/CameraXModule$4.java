/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.view.CameraXModule;

public class CameraXModule$4
implements FutureCallback {
    public final /* synthetic */ CameraXModule this$0;

    public CameraXModule$4(CameraXModule cameraXModule) {
        this.this$0 = cameraXModule;
    }

    public void onFailure(Throwable throwable) {
        RuntimeException runtimeException = new RuntimeException(throwable);
        throw runtimeException;
    }

    public void onSuccess(Void void_) {
    }
}

