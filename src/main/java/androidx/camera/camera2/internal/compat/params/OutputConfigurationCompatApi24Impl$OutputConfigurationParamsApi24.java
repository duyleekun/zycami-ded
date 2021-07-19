/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.params.OutputConfiguration
 */
package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import java.util.Objects;

public final class OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24 {
    public boolean mIsShared;
    public final OutputConfiguration mOutputConfiguration;
    public String mPhysicalCameraId;

    public OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24(OutputConfiguration outputConfiguration) {
        this.mOutputConfiguration = outputConfiguration;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3;
        boolean bl4 = object instanceof OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24;
        boolean bl5 = false;
        if (!bl4) {
            return false;
        }
        object = (OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24)object;
        Object object2 = this.mOutputConfiguration;
        OutputConfiguration outputConfiguration = ((OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24)object).mOutputConfiguration;
        bl4 = Objects.equals(object2, outputConfiguration);
        if (bl4 && (bl4 = this.mIsShared) == (bl3 = ((OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24)object).mIsShared) && (bl2 = Objects.equals(object2 = this.mPhysicalCameraId, object = ((OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24)object).mPhysicalCameraId))) {
            bl5 = true;
        }
        return bl5;
    }

    public int hashCode() {
        int n10 = this.mOutputConfiguration.hashCode() ^ 0x1F;
        int n11 = (n10 << 5) - n10;
        n10 = this.mIsShared ^ n11;
        n11 = (n10 << 5) - n10;
        String string2 = this.mPhysicalCameraId;
        if (string2 == null) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = string2.hashCode();
        }
        return n10 ^ n11;
    }
}

