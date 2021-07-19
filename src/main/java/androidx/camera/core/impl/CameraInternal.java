/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.UseCase$StateChangeCallback;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.Observable;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public interface CameraInternal
extends Camera,
UseCase$StateChangeCallback {
    public void attachUseCases(Collection var1);

    public void close();

    public void detachUseCases(Collection var1);

    default public CameraControl getCameraControl() {
        return this.getCameraControlInternal();
    }

    public CameraControlInternal getCameraControlInternal();

    default public CameraInfo getCameraInfo() {
        return this.getCameraInfoInternal();
    }

    public CameraInfoInternal getCameraInfoInternal();

    default public LinkedHashSet getCameraInternals() {
        Set<CameraInternal> set = Collections.singleton(this);
        LinkedHashSet<CameraInternal> linkedHashSet = new LinkedHashSet<CameraInternal>(set);
        return linkedHashSet;
    }

    public Observable getCameraState();

    default public CameraConfig getExtendedConfig() {
        return CameraConfigs.emptyConfig();
    }

    public void open();

    public ListenableFuture release();

    default public void setExtendedConfig(CameraConfig cameraConfig) {
    }
}

