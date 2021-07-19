/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.params.OutputConfiguration
 *  android.view.Surface
 */
package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.List;

public class OutputConfigurationCompatApi24Impl
extends OutputConfigurationCompatBaseImpl {
    public OutputConfigurationCompatApi24Impl(Surface surface) {
        OutputConfiguration outputConfiguration = new OutputConfiguration(surface);
        OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24 outputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24 = new OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24(outputConfiguration);
        this(outputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24);
    }

    public OutputConfigurationCompatApi24Impl(Object object) {
        super(object);
    }

    public static OutputConfigurationCompatApi24Impl wrap(OutputConfiguration outputConfiguration) {
        OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24 outputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24 = new OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24(outputConfiguration);
        OutputConfigurationCompatApi24Impl outputConfigurationCompatApi24Impl = new OutputConfigurationCompatApi24Impl(outputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24);
        return outputConfigurationCompatApi24Impl;
    }

    public void enableSurfaceSharing() {
        ((OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24)this.mObject).mIsShared = true;
    }

    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24);
        return ((OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24)this.mObject).mOutputConfiguration;
    }

    public String getPhysicalCameraId() {
        return ((OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24)this.mObject).mPhysicalCameraId;
    }

    public Surface getSurface() {
        return ((OutputConfiguration)this.getOutputConfiguration()).getSurface();
    }

    public int getSurfaceGroupId() {
        return ((OutputConfiguration)this.getOutputConfiguration()).getSurfaceGroupId();
    }

    public List getSurfaces() {
        return Collections.singletonList(this.getSurface());
    }

    public boolean isSurfaceSharingEnabled() {
        return ((OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24)this.mObject).mIsShared;
    }

    public void setPhysicalCameraId(String string2) {
        ((OutputConfigurationCompatApi24Impl$OutputConfigurationParamsApi24)this.mObject).mPhysicalCameraId = string2;
    }
}

