/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.PowerManager
 */
package androidx.appcompat.app;

import android.os.PowerManager;

public class AppCompatDelegateImpl$Api21Impl {
    private AppCompatDelegateImpl$Api21Impl() {
    }

    public static boolean isPowerSaveMode(PowerManager powerManager) {
        return powerManager.isPowerSaveMode();
    }
}

