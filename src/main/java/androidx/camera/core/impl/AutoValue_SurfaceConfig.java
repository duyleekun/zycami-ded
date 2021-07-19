/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.SurfaceConfig$ConfigSize;
import androidx.camera.core.impl.SurfaceConfig$ConfigType;
import java.util.Objects;

public final class AutoValue_SurfaceConfig
extends SurfaceConfig {
    private final SurfaceConfig$ConfigSize configSize;
    private final SurfaceConfig$ConfigType configType;

    public AutoValue_SurfaceConfig(SurfaceConfig$ConfigType surfaceConfig$ConfigType, SurfaceConfig$ConfigSize surfaceConfig$ConfigSize) {
        Objects.requireNonNull(surfaceConfig$ConfigType, "Null configType");
        this.configType = surfaceConfig$ConfigType;
        Objects.requireNonNull(surfaceConfig$ConfigSize, "Null configSize");
        this.configSize = surfaceConfig$ConfigSize;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof SurfaceConfig;
        if (bl3) {
            boolean bl4;
            Enum enum_ = this.configType;
            SurfaceConfig$ConfigType surfaceConfig$ConfigType = ((SurfaceConfig)(object = (SurfaceConfig)object)).getConfigType();
            bl3 = enum_.equals((Object)surfaceConfig$ConfigType);
            if (!bl3 || !(bl4 = (enum_ = this.configSize).equals(object = ((SurfaceConfig)object).getConfigSize()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public SurfaceConfig$ConfigSize getConfigSize() {
        return this.configSize;
    }

    public SurfaceConfig$ConfigType getConfigType() {
        return this.configType;
    }

    public int hashCode() {
        int n10 = this.configType.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        n11 = this.configSize.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SurfaceConfig{configType=");
        Enum enum_ = this.configType;
        stringBuilder.append(enum_);
        stringBuilder.append(", configSize=");
        enum_ = this.configSize;
        stringBuilder.append(enum_);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

