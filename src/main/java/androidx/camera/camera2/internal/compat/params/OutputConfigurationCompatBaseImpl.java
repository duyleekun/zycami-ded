/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package androidx.camera.camera2.internal.compat.params;

import android.view.Surface;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat$OutputConfigurationCompatImpl;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.Objects;

public class OutputConfigurationCompatBaseImpl
implements OutputConfigurationCompat$OutputConfigurationCompatImpl {
    public static final String TAG = "OutputConfigCompat";
    public final Object mObject;

    public OutputConfigurationCompatBaseImpl(Surface surface) {
        OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21 outputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21 = new OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21(surface);
        this.mObject = outputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21;
    }

    public OutputConfigurationCompatBaseImpl(Object object) {
        this.mObject = object;
    }

    public void addSurface(Surface object) {
        Preconditions.checkNotNull(object, "Surface must not be null");
        Surface surface = this.getSurface();
        if (surface != object) {
            boolean bl2 = this.isSurfaceSharingEnabled();
            if (!bl2) {
                object = new IllegalStateException("Cannot have 2 surfaces for a non-sharing configuration");
                throw object;
            }
            object = new IllegalArgumentException("Exceeds maximum number of surfaces");
            throw object;
        }
        object = new IllegalStateException("Surface is already added!");
        throw object;
    }

    public void enableSurfaceSharing() {
        ((OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21)this.mObject).mIsShared = true;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof OutputConfigurationCompatBaseImpl;
        if (!bl2) {
            return false;
        }
        Object object2 = this.mObject;
        object = ((OutputConfigurationCompatBaseImpl)object).mObject;
        return Objects.equals(object2, object);
    }

    public int getMaxSharedSurfaceCount() {
        return 1;
    }

    public Object getOutputConfiguration() {
        return null;
    }

    public String getPhysicalCameraId() {
        return ((OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21)this.mObject).mPhysicalCameraId;
    }

    public Surface getSurface() {
        List list = ((OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21)this.mObject).mSurfaces;
        int n10 = list.size();
        if (n10 == 0) {
            return null;
        }
        return (Surface)list.get(0);
    }

    public int getSurfaceGroupId() {
        return -1;
    }

    public List getSurfaces() {
        return ((OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21)this.mObject).mSurfaces;
    }

    public int hashCode() {
        return this.mObject.hashCode();
    }

    public boolean isSurfaceSharingEnabled() {
        return ((OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21)this.mObject).mIsShared;
    }

    public void removeSurface(Surface object) {
        Surface surface = this.getSurface();
        if (surface == object) {
            object = new IllegalArgumentException("Cannot remove surface associated with this output configuration");
            throw object;
        }
        object = new IllegalArgumentException("Surface is not part of this output configuration");
        throw object;
    }

    public void setPhysicalCameraId(String string2) {
        ((OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21)this.mObject).mPhysicalCameraId = string2;
    }
}

