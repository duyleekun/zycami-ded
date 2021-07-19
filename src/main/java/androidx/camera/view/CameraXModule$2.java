/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.CameraXModule;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LifecycleOwner;

public class CameraXModule$2
implements FutureCallback {
    public final /* synthetic */ CameraXModule this$0;

    public CameraXModule$2(CameraXModule cameraXModule) {
        this.this$0 = cameraXModule;
    }

    public void onFailure(Throwable throwable) {
        RuntimeException runtimeException = new RuntimeException("CameraX failed to initialize.", throwable);
        throw runtimeException;
    }

    public void onSuccess(ProcessCameraProvider object) {
        Preconditions.checkNotNull(object);
        CameraXModule cameraXModule = this.this$0;
        cameraXModule.mCameraProvider = object;
        object = cameraXModule.mCurrentLifecycle;
        if (object != null) {
            cameraXModule.bindToLifecycle((LifecycleOwner)object);
        }
    }
}

