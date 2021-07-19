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
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi24Impl;
import androidx.camera.camera2.internal.compat.params.OutputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.lang.reflect.Field;
import java.util.List;

public class OutputConfigurationCompatApi26Impl
extends OutputConfigurationCompatApi24Impl {
    private static final String MAX_SHARED_SURFACES_COUNT_FIELD = "MAX_SURFACES_COUNT";
    private static final String SURFACES_FIELD = "mSurfaces";

    public OutputConfigurationCompatApi26Impl(Surface surface) {
        OutputConfiguration outputConfiguration = new OutputConfiguration(surface);
        OutputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26 outputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26 = new OutputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26(outputConfiguration);
        this(outputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26);
    }

    public OutputConfigurationCompatApi26Impl(Object object) {
        super(object);
    }

    private static int getMaxSharedSurfaceCountApi26() {
        Field field = OutputConfiguration.class.getDeclaredField(MAX_SHARED_SURFACES_COUNT_FIELD);
        field.setAccessible(true);
        return field.getInt(null);
    }

    private static List getMutableSurfaceListApi26(OutputConfiguration outputConfiguration) {
        Field field = OutputConfiguration.class.getDeclaredField(SURFACES_FIELD);
        field.setAccessible(true);
        return (List)field.get(outputConfiguration);
    }

    public static OutputConfigurationCompatApi26Impl wrap(OutputConfiguration outputConfiguration) {
        OutputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26 outputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26 = new OutputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26(outputConfiguration);
        OutputConfigurationCompatApi26Impl outputConfigurationCompatApi26Impl = new OutputConfigurationCompatApi26Impl(outputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26);
        return outputConfigurationCompatApi26Impl;
    }

    public void addSurface(Surface surface) {
        ((OutputConfiguration)this.getOutputConfiguration()).addSurface(surface);
    }

    public void enableSurfaceSharing() {
        ((OutputConfiguration)this.getOutputConfiguration()).enableSurfaceSharing();
    }

    /*
     * WARNING - void declaration
     */
    public int getMaxSharedSurfaceCount() {
        void var1_3;
        try {
            return OutputConfigurationCompatApi26Impl.getMaxSharedSurfaceCountApi26();
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (NoSuchFieldException noSuchFieldException) {
            // empty catch block
        }
        Logger.e("OutputConfigCompat", "Unable to retrieve max shared surface count.", (Throwable)var1_3);
        return super.getMaxSharedSurfaceCount();
    }

    public Object getOutputConfiguration() {
        Preconditions.checkArgument(this.mObject instanceof OutputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26);
        return ((OutputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26)this.mObject).mOutputConfiguration;
    }

    public String getPhysicalCameraId() {
        return ((OutputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26)this.mObject).mPhysicalCameraId;
    }

    public List getSurfaces() {
        return ((OutputConfiguration)this.getOutputConfiguration()).getSurfaces();
    }

    public final boolean isSurfaceSharingEnabled() {
        AssertionError assertionError = new AssertionError((Object)"isSurfaceSharingEnabled() should not be called on API >= 26");
        throw assertionError;
    }

    /*
     * WARNING - void declaration
     */
    public void removeSurface(Surface object) {
        Object object2 = this.getSurface();
        if (object2 != object) {
            block9: {
                void var1_4;
                object2 = this.getOutputConfiguration();
                object2 = (OutputConfiguration)object2;
                object2 = OutputConfigurationCompatApi26Impl.getMutableSurfaceListApi26((OutputConfiguration)object2);
                boolean bl2 = object2.remove(object);
                if (bl2) break block9;
                object2 = "Surface is not part of this output configuration";
                try {
                    object = new IllegalArgumentException((String)object2);
                    throw object;
                }
                catch (NoSuchFieldException noSuchFieldException) {
                }
                catch (IllegalAccessException illegalAccessException) {
                    // empty catch block
                }
                object2 = "OutputConfigCompat";
                String string2 = "Unable to remove surface from this output configuration.";
                Logger.e((String)object2, string2, (Throwable)var1_4);
            }
            return;
        }
        object = new IllegalArgumentException("Cannot remove surface associated with this output configuration");
        throw object;
    }

    public void setPhysicalCameraId(String string2) {
        ((OutputConfigurationCompatApi26Impl$OutputConfigurationParamsApi26)this.mObject).mPhysicalCameraId = string2;
    }
}

