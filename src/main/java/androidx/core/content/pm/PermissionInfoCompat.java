/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.pm.PermissionInfo
 *  android.os.Build$VERSION
 */
package androidx.core.content.pm;

import android.content.pm.PermissionInfo;
import android.os.Build;

public final class PermissionInfoCompat {
    private PermissionInfoCompat() {
    }

    public static int getProtection(PermissionInfo permissionInfo) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return permissionInfo.getProtection();
        }
        return permissionInfo.protectionLevel & 0xF;
    }

    public static int getProtectionFlags(PermissionInfo permissionInfo) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return permissionInfo.getProtectionFlags();
        }
        return permissionInfo.protectionLevel & 0xFFFFFFF0;
    }
}

