/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.util.Size
 *  android.view.Surface
 */
package androidx.camera.camera2.internal.compat.params;

import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public final class OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21 {
    private static final String DETECT_SURFACE_TYPE_METHOD = "detectSurfaceType";
    private static final String GET_GENERATION_ID_METHOD = "getGenerationId";
    private static final String GET_SURFACE_SIZE_METHOD = "getSurfaceSize";
    private static final String LEGACY_CAMERA_DEVICE_CLASS = "android.hardware.camera2.legacy.LegacyCameraDevice";
    public static final int MAX_SURFACES_COUNT = 1;
    public final int mConfiguredFormat;
    public final int mConfiguredGenerationId;
    public final Size mConfiguredSize;
    public boolean mIsShared = false;
    public String mPhysicalCameraId;
    public final List mSurfaces;

    public OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21(Surface surface) {
        int n10;
        int n11;
        Size size;
        Preconditions.checkNotNull(surface, "Surface must not be null");
        this.mSurfaces = size = Collections.singletonList(surface);
        this.mConfiguredSize = size = OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21.getSurfaceSize(surface);
        this.mConfiguredFormat = n11 = OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21.getSurfaceFormat(surface);
        this.mConfiguredGenerationId = n10 = OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21.getSurfaceGenerationId(surface);
    }

    /*
     * WARNING - void declaration
     */
    private static int getSurfaceFormat(Surface object) {
        void var0_5;
        int n10;
        int n11;
        String string2;
        Object object2;
        block15: {
            object2 = LEGACY_CAMERA_DEVICE_CLASS;
            object2 = Class.forName((String)object2);
            string2 = DETECT_SURFACE_TYPE_METHOD;
            n11 = 1;
            Class[] classArray = new Class[n11];
            Class<Surface> clazz = Surface.class;
            classArray[0] = clazz;
            object2 = ((Class)object2).getDeclaredMethod(string2, classArray);
            n10 = Build.VERSION.SDK_INT;
            int n12 = 22;
            if (n10 >= n12) break block15;
            ((Method)object2).setAccessible(n11 != 0);
        }
        n10 = 0;
        string2 = null;
        Object[] objectArray = new Object[n11];
        objectArray[0] = object;
        object = ((Method)object2).invoke(null, objectArray);
        object = (Integer)object;
        try {
            return (Integer)object;
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        Logger.e("OutputConfigCompat", "Unable to retrieve surface format.", (Throwable)var0_5);
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    private static int getSurfaceGenerationId(Surface object) {
        void var0_4;
        Object object2 = Surface.class;
        Object[] objectArray = "getGenerationId";
        Class[] classArray = new Class[]{};
        object2 = ((Class)object2).getDeclaredMethod((String)objectArray, classArray);
        objectArray = new Object[]{};
        object = ((Method)object2).invoke(object, objectArray);
        object = (Integer)object;
        try {
            return (Integer)object;
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (NoSuchMethodException noSuchMethodException) {
            // empty catch block
        }
        Logger.e("OutputConfigCompat", "Unable to retrieve surface generation id.", (Throwable)var0_4);
        return -1;
    }

    /*
     * WARNING - void declaration
     */
    private static Size getSurfaceSize(Surface object) {
        void var0_5;
        Object object2 = LEGACY_CAMERA_DEVICE_CLASS;
        object2 = Class.forName((String)object2);
        Object[] objectArray = "getSurfaceSize";
        int n10 = 1;
        Class[] classArray = new Class[n10];
        Class<Surface> clazz = Surface.class;
        classArray[0] = clazz;
        object2 = ((Class)object2).getDeclaredMethod((String)objectArray, classArray);
        ((Method)object2).setAccessible(n10 != 0);
        objectArray = new Object[n10];
        objectArray[0] = object;
        object = ((Method)object2).invoke(null, objectArray);
        try {
            return (Size)object;
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        Logger.e("OutputConfigCompat", "Unable to retrieve surface size.", (Throwable)var0_5);
        return null;
    }

    public boolean equals(Object object) {
        int n10;
        int n11 = object instanceof OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21;
        if (n11 == 0) {
            return false;
        }
        object = (OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21)object;
        Object object2 = this.mConfiguredSize;
        Object object3 = ((OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21)object).mConfiguredSize;
        n11 = object2.equals(object3);
        if (n11 != 0 && (n11 = this.mConfiguredFormat) == (n10 = ((OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21)object).mConfiguredFormat) && (n11 = this.mConfiguredGenerationId) == (n10 = ((OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21)object).mConfiguredGenerationId) && (n11 = (int)(this.mIsShared ? 1 : 0)) == (n10 = (int)(((OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21)object).mIsShared ? 1 : 0)) && (n11 = (int)(Objects.equals(object2 = this.mPhysicalCameraId, object3 = ((OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21)object).mPhysicalCameraId) ? 1 : 0)) != 0) {
            object2 = this.mSurfaces;
            n11 = object2.size();
            n10 = ((OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21)object).mSurfaces.size();
            n11 = Math.min(n11, n10);
            object3 = null;
            for (n10 = 0; n10 < n11; ++n10) {
                Object e10;
                Object e11 = this.mSurfaces.get(n10);
                if (e11 == (e10 = ((OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21)object).mSurfaces.get(n10))) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.mSurfaces.hashCode() ^ 0x1F;
        int n11 = (n10 << 5) - n10;
        n10 = this.mConfiguredGenerationId ^ n11;
        n11 = (n10 << 5) - n10;
        n10 = this.mConfiguredSize.hashCode() ^ n11;
        n11 = (n10 << 5) - n10;
        n10 = this.mConfiguredFormat ^ n11;
        n11 = (n10 << 5) - n10;
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

