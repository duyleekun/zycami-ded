/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AppOpsManager
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.os.Binder
 *  android.os.Process
 */
package com.google.android.gms.common.wrappers;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.InstantApps;

public class PackageManagerWrapper {
    private final Context zza;

    public PackageManagerWrapper(Context context) {
        this.zza = context;
    }

    public int checkCallingOrSelfPermission(String string2) {
        return this.zza.checkCallingOrSelfPermission(string2);
    }

    public int checkPermission(String string2, String string3) {
        return this.zza.getPackageManager().checkPermission(string2, string3);
    }

    public ApplicationInfo getApplicationInfo(String string2, int n10) {
        return this.zza.getPackageManager().getApplicationInfo(string2, n10);
    }

    public CharSequence getApplicationLabel(String string2) {
        PackageManager packageManager = this.zza.getPackageManager();
        string2 = this.zza.getPackageManager().getApplicationInfo(string2, 0);
        return packageManager.getApplicationLabel((ApplicationInfo)string2);
    }

    public PackageInfo getPackageInfo(String string2, int n10) {
        return this.zza.getPackageManager().getPackageInfo(string2, n10);
    }

    public boolean isCallerInstantApp() {
        int n10;
        int n11 = Binder.getCallingUid();
        if (n11 == (n10 = Process.myUid())) {
            return InstantApps.isInstantApp(this.zza);
        }
        n11 = (int)(PlatformVersion.isAtLeastO() ? 1 : 0);
        if (n11 != 0) {
            Object object = this.zza.getPackageManager();
            n10 = Binder.getCallingUid();
            if ((object = object.getNameForUid(n10)) != null) {
                return this.zza.getPackageManager().isInstantApp((String)object);
            }
        }
        return false;
    }

    public final PackageInfo zza(String string2, int n10, int n11) {
        return this.zza.getPackageManager().getPackageInfo(string2, 64);
    }

    public final boolean zza(int n10, String string2) {
        int n11 = PlatformVersion.isAtLeastKitKat();
        boolean bl2 = true;
        if (n11 != 0) {
            String string3;
            Object object;
            try {
                object = this.zza;
                string3 = "appops";
            }
            catch (SecurityException securityException) {
                return false;
            }
            object = object.getSystemService(string3);
            object = (AppOpsManager)object;
            object.checkPackage(n10, string2);
            return bl2;
        }
        PackageManager packageManager = this.zza.getPackageManager();
        String[] stringArray = packageManager.getPackagesForUid(n10);
        if (string2 != null && stringArray != null) {
            int n12;
            packageManager = null;
            for (n11 = 0; n11 < (n12 = stringArray.length); ++n11) {
                String string4 = stringArray[n11];
                n12 = (int)(string2.equals(string4) ? 1 : 0);
                if (n12 == 0) continue;
                return bl2;
            }
        }
        return false;
    }

    public final String[] zza(int n10) {
        return this.zza.getPackageManager().getPackagesForUid(n10);
    }
}

