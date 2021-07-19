/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.lifecycle;

import androidx.camera.core.internal.CameraUseCaseAdapter$CameraId;
import androidx.camera.lifecycle.LifecycleCameraRepository$Key;
import androidx.lifecycle.LifecycleOwner;
import java.util.Objects;

public final class AutoValue_LifecycleCameraRepository_Key
extends LifecycleCameraRepository$Key {
    private final CameraUseCaseAdapter$CameraId cameraId;
    private final LifecycleOwner lifecycleOwner;

    public AutoValue_LifecycleCameraRepository_Key(LifecycleOwner lifecycleOwner, CameraUseCaseAdapter$CameraId cameraUseCaseAdapter$CameraId) {
        Objects.requireNonNull(lifecycleOwner, "Null lifecycleOwner");
        this.lifecycleOwner = lifecycleOwner;
        Objects.requireNonNull(cameraUseCaseAdapter$CameraId, "Null cameraId");
        this.cameraId = cameraUseCaseAdapter$CameraId;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof LifecycleCameraRepository$Key;
        if (bl3) {
            boolean bl4;
            Object object2 = this.lifecycleOwner;
            LifecycleOwner lifecycleOwner = ((LifecycleCameraRepository$Key)(object = (LifecycleCameraRepository$Key)object)).getLifecycleOwner();
            bl3 = object2.equals(lifecycleOwner);
            if (!bl3 || !(bl4 = ((CameraUseCaseAdapter$CameraId)(object2 = this.cameraId)).equals(object = ((LifecycleCameraRepository$Key)object).getCameraId()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public CameraUseCaseAdapter$CameraId getCameraId() {
        return this.cameraId;
    }

    public LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public int hashCode() {
        int n10 = this.lifecycleOwner.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        n11 = this.cameraId.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Key{lifecycleOwner=");
        Object object = this.lifecycleOwner;
        stringBuilder.append(object);
        stringBuilder.append(", cameraId=");
        object = this.cameraId;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

