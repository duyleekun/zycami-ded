/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package androidx.camera.camera2.internal;

import android.os.SystemClock;
import androidx.camera.camera2.internal.Camera2CameraImpl$StateCallback;

public class Camera2CameraImpl$StateCallback$CameraReopenMonitor {
    public static final int INVALID_TIME = 255;
    public static final int REOPEN_LIMIT_MS = 10000;
    private long mFirstReopenTime = -1;
    public final /* synthetic */ Camera2CameraImpl.StateCallback this$1;

    public Camera2CameraImpl$StateCallback$CameraReopenMonitor(Camera2CameraImpl.StateCallback stateCallback) {
        this.this$1 = stateCallback;
    }

    public boolean canScheduleCameraReopen() {
        long l10 = SystemClock.uptimeMillis();
        long l11 = this.mFirstReopenTime;
        long l12 = -1;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        boolean bl2 = true;
        if (l13 == false) {
            this.mFirstReopenTime = l10;
            return bl2;
        }
        long l14 = (l10 -= l11) - (l11 = 10000L);
        long l15 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        l15 = l15 >= 0 ? (long)bl2 : (long)0;
        if (l15 != false) {
            this.reset();
            return false;
        }
        return bl2;
    }

    public void reset() {
        this.mFirstReopenTime = -1;
    }
}

