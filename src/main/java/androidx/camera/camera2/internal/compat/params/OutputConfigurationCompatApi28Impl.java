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
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl;
import androidx.core.util.Preconditions;

public class OutputConfigurationCompatApi28Impl
extends OutputConfigurationCompatApi26Impl {
    public OutputConfigurationCompatApi28Impl(Surface surface) {
        OutputConfiguration outputConfiguration = new OutputConfiguration(surface);
        super(outputConfiguration);
    }

    public OutputConfigurationCompatApi28Impl(Object object) {
        super(object);
    }

    public static OutputConfigurationCompatApi28Impl wrap(OutputConfiguration outputConfiguration) {
        OutputConfigurationCompatApi28Impl outputConfigurationCompatApi28Impl = new OutputConfigurationCompatApi28Impl(outputConfiguration);
        return outputConfigurationCompatApi28Impl;
    }

    public int getMaxSharedSurfaceCount() {
        return ((OutputConfiguration)this.getOutputConfiguration()).getMaxSharedSurfaceCount();
    }

    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfiguration);
        return this.mObject;
    }

    public String getPhysicalCameraId() {
        return null;
    }

    public void removeSurface(Surface surface) {
        ((OutputConfiguration)this.getOutputConfiguration()).removeSurface(surface);
    }

    public void setPhysicalCameraId(String string2) {
        ((OutputConfiguration)this.getOutputConfiguration()).setPhysicalCameraId(string2);
    }
}

