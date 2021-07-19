/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

import androidx.camera.view.CameraXModule;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;

public class CameraXModule$1
implements LifecycleObserver {
    public final /* synthetic */ CameraXModule this$0;

    public CameraXModule$1(CameraXModule cameraXModule) {
        this.this$0 = cameraXModule;
    }

    public void onDestroy(LifecycleOwner lifecycleOwner) {
        CameraXModule cameraXModule = this.this$0;
        LifecycleOwner lifecycleOwner2 = cameraXModule.mCurrentLifecycle;
        if (lifecycleOwner == lifecycleOwner2) {
            cameraXModule.clearCurrentLifecycle();
        }
    }
}

