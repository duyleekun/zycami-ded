/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.AutoValue_SurfaceConfig;
import androidx.camera.core.impl.SurfaceConfig$ConfigSize;
import androidx.camera.core.impl.SurfaceConfig$ConfigType;

public abstract class SurfaceConfig {
    public static SurfaceConfig create(SurfaceConfig$ConfigType surfaceConfig$ConfigType, SurfaceConfig$ConfigSize surfaceConfig$ConfigSize) {
        AutoValue_SurfaceConfig autoValue_SurfaceConfig = new AutoValue_SurfaceConfig(surfaceConfig$ConfigType, surfaceConfig$ConfigSize);
        return autoValue_SurfaceConfig;
    }

    public abstract SurfaceConfig$ConfigSize getConfigSize();

    public abstract SurfaceConfig$ConfigType getConfigType();

    public final boolean isSupported(SurfaceConfig object) {
        SurfaceConfig$ConfigSize surfaceConfig$ConfigSize;
        int n10;
        SurfaceConfig$ConfigType surfaceConfig$ConfigType = object.getConfigType();
        int n11 = ((SurfaceConfig$ConfigSize)((Object)(object = object.getConfigSize()))).getId();
        if (n11 <= (n10 = (surfaceConfig$ConfigSize = this.getConfigSize()).getId()) && surfaceConfig$ConfigType == (object = this.getConfigType())) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }
}

