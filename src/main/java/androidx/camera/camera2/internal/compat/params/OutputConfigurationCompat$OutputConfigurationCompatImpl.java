/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package androidx.camera.camera2.internal.compat.params;

import android.view.Surface;
import java.util.List;

public interface OutputConfigurationCompat$OutputConfigurationCompatImpl {
    public void addSurface(Surface var1);

    public void enableSurfaceSharing();

    public int getMaxSharedSurfaceCount();

    public Object getOutputConfiguration();

    public String getPhysicalCameraId();

    public Surface getSurface();

    public int getSurfaceGroupId();

    public List getSurfaces();

    public void removeSurface(Surface var1);

    public void setPhysicalCameraId(String var1);
}

