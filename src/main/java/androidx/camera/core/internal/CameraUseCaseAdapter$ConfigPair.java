/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.internal;

import androidx.camera.core.impl.UseCaseConfig;

public class CameraUseCaseAdapter$ConfigPair {
    public UseCaseConfig mCameraConfig;
    public UseCaseConfig mExtendedConfig;

    public CameraUseCaseAdapter$ConfigPair(UseCaseConfig useCaseConfig, UseCaseConfig useCaseConfig2) {
        this.mExtendedConfig = useCaseConfig;
        this.mCameraConfig = useCaseConfig2;
    }
}

