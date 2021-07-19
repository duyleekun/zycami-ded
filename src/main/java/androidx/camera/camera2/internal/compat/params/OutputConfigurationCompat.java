/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.params.OutputConfiguration
 *  android.os.Build$VERSION
 *  android.util.Size
 *  android.view.Surface
 */
package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.OutputConfiguration;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat$OutputConfigurationCompatImpl;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi28Impl;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl;
import java.util.List;

public final class OutputConfigurationCompat {
    public static final int SURFACE_GROUP_ID_NONE = 255;
    private final OutputConfigurationCompat$OutputConfigurationCompatImpl mImpl;

    public OutputConfigurationCompat(Size object, Class clazz) {
        OutputConfiguration outputConfiguration = new OutputConfiguration(object, clazz);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            object = OutputConfigurationCompatApi28Impl.wrap(outputConfiguration);
            this.mImpl = object;
        } else {
            object = OutputConfigurationCompatApi26Impl.wrap(outputConfiguration);
            this.mImpl = object;
        }
    }

    public OutputConfigurationCompat(Surface surface) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            OutputConfigurationCompatApi28Impl outputConfigurationCompatApi28Impl = new OutputConfigurationCompatApi28Impl(surface);
            this.mImpl = outputConfigurationCompatApi28Impl;
        } else {
            n11 = 26;
            if (n10 >= n11) {
                OutputConfigurationCompatApi26Impl outputConfigurationCompatApi26Impl = new OutputConfigurationCompatApi26Impl(surface);
                this.mImpl = outputConfigurationCompatApi26Impl;
            } else {
                n11 = 24;
                if (n10 >= n11) {
                    OutputConfigurationCompatApi24Impl outputConfigurationCompatApi24Impl = new OutputConfigurationCompatApi24Impl(surface);
                    this.mImpl = outputConfigurationCompatApi24Impl;
                } else {
                    OutputConfigurationCompatBaseImpl outputConfigurationCompatBaseImpl = new OutputConfigurationCompatBaseImpl(surface);
                    this.mImpl = outputConfigurationCompatBaseImpl;
                }
            }
        }
    }

    private OutputConfigurationCompat(OutputConfigurationCompat$OutputConfigurationCompatImpl outputConfigurationCompat$OutputConfigurationCompatImpl) {
        this.mImpl = outputConfigurationCompat$OutputConfigurationCompatImpl;
    }

    public static OutputConfigurationCompat wrap(Object object) {
        OutputConfigurationCompat outputConfigurationCompat = null;
        if (object == null) {
            return null;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        object = n10 >= n11 ? OutputConfigurationCompatApi28Impl.wrap((OutputConfiguration)object) : (n10 >= (n11 = 26) ? OutputConfigurationCompatApi26Impl.wrap((OutputConfiguration)object) : (n10 >= (n11 = 24) ? OutputConfigurationCompatApi24Impl.wrap((OutputConfiguration)object) : null));
        if (object == null) {
            return null;
        }
        outputConfigurationCompat = new OutputConfigurationCompat((OutputConfigurationCompat$OutputConfigurationCompatImpl)object);
        return outputConfigurationCompat;
    }

    public void addSurface(Surface surface) {
        this.mImpl.addSurface(surface);
    }

    public void enableSurfaceSharing() {
        this.mImpl.enableSurfaceSharing();
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof OutputConfigurationCompat;
        if (!bl2) {
            return false;
        }
        OutputConfigurationCompat$OutputConfigurationCompatImpl outputConfigurationCompat$OutputConfigurationCompatImpl = this.mImpl;
        object = ((OutputConfigurationCompat)object).mImpl;
        return outputConfigurationCompat$OutputConfigurationCompatImpl.equals(object);
    }

    public int getMaxSharedSurfaceCount() {
        return this.mImpl.getMaxSharedSurfaceCount();
    }

    public String getPhysicalCameraId() {
        return this.mImpl.getPhysicalCameraId();
    }

    public Surface getSurface() {
        return this.mImpl.getSurface();
    }

    public int getSurfaceGroupId() {
        return this.mImpl.getSurfaceGroupId();
    }

    public List getSurfaces() {
        return this.mImpl.getSurfaces();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public void removeSurface(Surface surface) {
        this.mImpl.removeSurface(surface);
    }

    public void setPhysicalCameraId(String string2) {
        this.mImpl.setPhysicalCameraId(string2);
    }

    public Object unwrap() {
        return this.mImpl.getOutputConfiguration();
    }
}

