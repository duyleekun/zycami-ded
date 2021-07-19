/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

public class CameraUnavailableException
extends Exception {
    public static final int CAMERA_DISABLED = 1;
    public static final int CAMERA_DISCONNECTED = 2;
    public static final int CAMERA_ERROR = 3;
    public static final int CAMERA_IN_USE = 4;
    public static final int CAMERA_MAX_IN_USE = 5;
    public static final int CAMERA_UNAVAILABLE_DO_NOT_DISTURB = 6;
    public static final int CAMERA_UNKNOWN_ERROR;
    private final int mReason;

    public CameraUnavailableException(int n10) {
        this.mReason = n10;
    }

    public CameraUnavailableException(int n10, String string2) {
        super(string2);
        this.mReason = n10;
    }

    public CameraUnavailableException(int n10, String string2, Throwable throwable) {
        super(string2, throwable);
        this.mReason = n10;
    }

    public CameraUnavailableException(int n10, Throwable throwable) {
        super(throwable);
        this.mReason = n10;
    }

    public int getReason() {
        return this.mReason;
    }
}

