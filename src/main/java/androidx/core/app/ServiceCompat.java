/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Service
 *  android.os.Build$VERSION
 */
package androidx.core.app;

import android.app.Service;
import android.os.Build;

public final class ServiceCompat {
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    private ServiceCompat() {
    }

    public static void stopForeground(Service service, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 24;
        if (n11 >= n12) {
            service.stopForeground(n10);
        } else {
            n11 = 1;
            if ((n10 &= n11) == 0) {
                n11 = 0;
            }
            service.stopForeground(n11 != 0);
        }
    }
}

