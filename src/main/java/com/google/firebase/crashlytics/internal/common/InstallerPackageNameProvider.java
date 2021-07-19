/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 */
package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.pm.PackageManager;

public class InstallerPackageNameProvider {
    private static final String NO_INSTALLER_PACKAGE_NAME = "";
    private String installerPackageName;

    private static String loadInstallerPackageName(Context object) {
        PackageManager packageManager = object.getPackageManager();
        object = object.getPackageName();
        if ((object = packageManager.getInstallerPackageName((String)object)) == null) {
            object = NO_INSTALLER_PACKAGE_NAME;
        }
        return object;
    }

    public String getInstallerPackageName(Context object) {
        synchronized (this) {
            block10: {
                String string2;
                block9: {
                    string2 = this.installerPackageName;
                    if (string2 != null) break block9;
                    object = InstallerPackageNameProvider.loadInstallerPackageName((Context)object);
                    this.installerPackageName = object;
                }
                object = NO_INSTALLER_PACKAGE_NAME;
                string2 = this.installerPackageName;
                boolean bl2 = ((String)object).equals(string2);
                if (!bl2) break block10;
                bl2 = false;
                object = null;
            }
            object = this.installerPackageName;
            return object;
            finally {
            }
        }
    }
}

