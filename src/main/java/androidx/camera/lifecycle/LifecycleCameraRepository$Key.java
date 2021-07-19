/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.lifecycle;

import androidx.camera.core.internal.CameraUseCaseAdapter$CameraId;
import androidx.camera.lifecycle.AutoValue_LifecycleCameraRepository_Key;
import androidx.lifecycle.LifecycleOwner;

public abstract class LifecycleCameraRepository$Key {
    public static LifecycleCameraRepository$Key create(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter$CameraId cameraUseCaseAdapter$CameraId) {
        AutoValue_LifecycleCameraRepository_Key autoValue_LifecycleCameraRepository_Key = new AutoValue_LifecycleCameraRepository_Key(lifecycleOwner, cameraUseCaseAdapter$CameraId);
        return autoValue_LifecycleCameraRepository_Key;
    }

    public abstract CameraUseCaseAdapter$CameraId getCameraId();

    public abstract LifecycleOwner getLifecycleOwner();
}

