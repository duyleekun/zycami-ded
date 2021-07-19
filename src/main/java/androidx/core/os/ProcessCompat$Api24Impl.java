/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Process
 */
package androidx.core.os;

import android.os.Process;

public class ProcessCompat$Api24Impl {
    private ProcessCompat$Api24Impl() {
    }

    public static boolean isApplicationUid(int n10) {
        return Process.isApplicationUid((int)n10);
    }
}

