/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraUnavailableException;

public final class CameraUnavailableExceptionHelper {
    private CameraUnavailableExceptionHelper() {
    }

    public static CameraUnavailableException createFrom(CameraAccessExceptionCompat cameraAccessExceptionCompat) {
        int n10 = cameraAccessExceptionCompat.getReason();
        int n11 = 5;
        int n12 = 4;
        int n13 = 3;
        int n14 = 2;
        int n15 = 1;
        if (n10 != n15) {
            if (n10 != n14) {
                if (n10 != n13) {
                    if (n10 != n12) {
                        if (n10 != n11) {
                            n11 = 10001;
                            n11 = n10 != n11 ? 0 : 6;
                        }
                    } else {
                        n11 = n12;
                    }
                } else {
                    n11 = n13;
                }
            } else {
                n11 = n14;
            }
        } else {
            n11 = n15;
        }
        CameraUnavailableException cameraUnavailableException = new CameraUnavailableException(n11, (Throwable)cameraAccessExceptionCompat);
        return cameraUnavailableException;
    }
}

