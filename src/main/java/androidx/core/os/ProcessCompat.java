/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package androidx.core.os;

import android.os.Build;
import androidx.core.os.ProcessCompat$Api16Impl;
import androidx.core.os.ProcessCompat$Api17Impl;
import androidx.core.os.ProcessCompat$Api24Impl;

public final class ProcessCompat {
    private ProcessCompat() {
    }

    public static boolean isApplicationUid(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 24;
        if (n11 >= n12) {
            return ProcessCompat$Api24Impl.isApplicationUid(n10);
        }
        n12 = 17;
        if (n11 >= n12) {
            return ProcessCompat$Api17Impl.isApplicationUid(n10);
        }
        n12 = 16;
        if (n11 == n12) {
            return ProcessCompat$Api16Impl.isApplicationUid(n10);
        }
        return true;
    }
}

