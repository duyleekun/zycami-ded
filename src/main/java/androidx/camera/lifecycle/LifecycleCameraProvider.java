/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.lifecycle;

import androidx.camera.core.CameraProvider;
import androidx.camera.core.UseCase;

public interface LifecycleCameraProvider
extends CameraProvider {
    public boolean isBound(UseCase var1);

    public void unbind(UseCase ... var1);

    public void unbindAll();
}

