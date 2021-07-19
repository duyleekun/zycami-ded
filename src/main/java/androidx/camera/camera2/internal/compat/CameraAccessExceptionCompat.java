/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraAccessException
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CameraAccessExceptionCompat
extends Exception {
    public static final int CAMERA_CHARACTERISTICS_CREATION_ERROR = 10002;
    public static final int CAMERA_DEPRECATED_HAL = 1000;
    public static final int CAMERA_DISABLED = 1;
    public static final int CAMERA_DISCONNECTED = 2;
    public static final int CAMERA_ERROR = 3;
    public static final int CAMERA_IN_USE = 4;
    public static final int CAMERA_UNAVAILABLE_DO_NOT_DISTURB = 10001;
    public static final Set COMPAT_ERRORS;
    public static final int MAX_CAMERAS_IN_USE = 5;
    public static final Set PLATFORM_ERRORS;
    private final CameraAccessException mCameraAccessException;
    private final int mReason;

    static {
        Integer n10;
        int n11 = 5;
        Object object = new Integer[n11];
        int n12 = 4;
        object[0] = n10 = Integer.valueOf(n12);
        Object object2 = n11;
        int n13 = 1;
        object[n13] = object2;
        object2 = n13;
        int n14 = 2;
        object[n14] = object2;
        object2 = n14;
        int n15 = 3;
        object[n15] = object2;
        object2 = n15;
        object[n12] = object2;
        object2 = Arrays.asList(object);
        HashSet hashSet = new HashSet(object2);
        PLATFORM_ERRORS = Collections.unmodifiableSet(hashSet);
        object2 = new Integer[n14];
        object2[0] = object = Integer.valueOf(10001);
        object2[n13] = object = Integer.valueOf(10002);
        object2 = Arrays.asList(object2);
        hashSet = new HashSet(object2);
        COMPAT_ERRORS = Collections.unmodifiableSet(hashSet);
    }

    public CameraAccessExceptionCompat(int n10) {
        Object object = CameraAccessExceptionCompat.getDefaultMessage(n10);
        super((String)object);
        this.mReason = n10;
        object = PLATFORM_ERRORS;
        Integer n11 = n10;
        boolean bl2 = object.contains(n11);
        if (bl2) {
            object = new CameraAccessException(n10);
        } else {
            bl2 = false;
            object = null;
        }
        this.mCameraAccessException = object;
    }

    public CameraAccessExceptionCompat(int n10, String string2) {
        Object object = CameraAccessExceptionCompat.getCombinedMessage(n10, string2);
        super((String)object);
        this.mReason = n10;
        object = PLATFORM_ERRORS;
        Integer n11 = n10;
        boolean bl2 = object.contains(n11);
        if (bl2) {
            object = new CameraAccessException(n10, string2);
        } else {
            bl2 = false;
            object = null;
        }
        this.mCameraAccessException = object;
    }

    public CameraAccessExceptionCompat(int n10, String string2, Throwable throwable) {
        Object object = CameraAccessExceptionCompat.getCombinedMessage(n10, string2);
        super((String)object, throwable);
        this.mReason = n10;
        object = PLATFORM_ERRORS;
        Integer n11 = n10;
        boolean bl2 = object.contains(n11);
        if (bl2) {
            object = new CameraAccessException(n10, string2, throwable);
        } else {
            bl2 = false;
            object = null;
        }
        this.mCameraAccessException = object;
    }

    public CameraAccessExceptionCompat(int n10, Throwable throwable) {
        Object object = CameraAccessExceptionCompat.getDefaultMessage(n10);
        super((String)object, throwable);
        this.mReason = n10;
        object = PLATFORM_ERRORS;
        Object object2 = n10;
        boolean bl2 = object.contains(object2);
        object2 = null;
        if (bl2) {
            object = new CameraAccessException(n10, null, throwable);
            object2 = object;
        }
        this.mCameraAccessException = object2;
    }

    private CameraAccessExceptionCompat(CameraAccessException cameraAccessException) {
        int n10;
        String string2 = cameraAccessException.getMessage();
        Throwable throwable = cameraAccessException.getCause();
        super(string2, throwable);
        this.mReason = n10 = cameraAccessException.getReason();
        this.mCameraAccessException = cameraAccessException;
    }

    private static String getCombinedMessage(int n10, String string2) {
        String string3 = CameraAccessExceptionCompat.getProblemString(n10);
        Object[] objectArray = new Object[3];
        objectArray[0] = string3;
        Integer n11 = n10;
        objectArray[1] = n11;
        objectArray[2] = string2;
        return String.format("%s (%d): %s", objectArray);
    }

    private static String getDefaultMessage(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        n11 = 5;
                        if (n10 != n11) {
                            n11 = 10001;
                            if (n10 != n11) {
                                n11 = 10002;
                                if (n10 != n11) {
                                    return null;
                                }
                                return "Failed to create CameraCharacteristics.";
                            }
                            return "Some API 28 devices cannot access the camera when the device is in \"Do Not Disturb\" mode. The camera will not be accessible until \"Do Not Disturb\" mode is disabled.";
                        }
                        return "The system-wide limit for number of open cameras has been reached, and more camera devices cannot be opened until previous instances are closed.";
                    }
                    return "The camera device is in use already";
                }
                return "The camera device is currently in the error state; no further calls to it will succeed.";
            }
            return "The camera device is removable and has been disconnected from the Android device, or the camera service has shut down the connection due to a higher-priority access request for the camera device.";
        }
        return "The camera is disabled due to a device policy, and cannot be opened.";
    }

    private static String getProblemString(int n10) {
        int n11 = 1;
        String string2 = n10 != n11 ? (n10 != (n11 = 2) ? (n10 != (n11 = 3) ? (n10 != (n11 = 4) ? (n10 != (n11 = 5) ? (n10 != (n11 = 1000) ? (n10 != (n11 = 10001) ? (n10 != (n11 = 10002) ? "<UNKNOWN ERROR>" : "CAMERA_CHARACTERISTICS_CREATION_ERROR") : "CAMERA_UNAVAILABLE_DO_NOT_DISTURB") : "CAMERA_DEPRECATED_HAL") : "MAX_CAMERAS_IN_USE") : "CAMERA_IN_USE") : "CAMERA_ERROR") : "CAMERA_DISCONNECTED") : "CAMERA_DISABLED";
        return string2;
    }

    public static CameraAccessExceptionCompat toCameraAccessExceptionCompat(CameraAccessException cameraAccessException) {
        Objects.requireNonNull(cameraAccessException, "cameraAccessException should not be null");
        CameraAccessExceptionCompat cameraAccessExceptionCompat = new CameraAccessExceptionCompat(cameraAccessException);
        return cameraAccessExceptionCompat;
    }

    public final int getReason() {
        return this.mReason;
    }

    public CameraAccessException toCameraAccessException() {
        return this.mCameraAccessException;
    }
}

