/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.params.OutputConfiguration
 */
package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import java.util.Objects;

public final class OutputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26 {
    public final OutputConfiguration mOutputConfiguration;
    public String mPhysicalCameraId;

    public OutputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26(OutputConfiguration outputConfiguration) {
        this.mOutputConfiguration = outputConfiguration;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof OutputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26;
        boolean bl4 = false;
        if (!bl3) {
            return false;
        }
        object = (OutputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26)object;
        Object object2 = this.mOutputConfiguration;
        OutputConfiguration outputConfiguration = ((OutputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26)object).mOutputConfiguration;
        bl3 = Objects.equals(object2, outputConfiguration);
        if (bl3 && (bl2 = Objects.equals(object2 = this.mPhysicalCameraId, object = ((OutputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26)object).mPhysicalCameraId))) {
            bl4 = true;
        }
        return bl4;
    }

    public int hashCode() {
        int n10 = this.mOutputConfiguration.hashCode() ^ 0x1F;
        int n11 = (n10 << 5) - n10;
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

