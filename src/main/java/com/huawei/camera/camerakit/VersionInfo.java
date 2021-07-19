/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.util.Log
 *  com.huawei.camerakit.api.VersionInfoInterface
 */
package com.huawei.camera.camerakit;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.huawei.camerakit.api.VersionInfoInterface;

public final class VersionInfo {
    public static final int API_LEVEL_1 = 1;
    private static final int CURRENT_SDK_VERSIONCODE = 10104000;
    private static final String CURRENT_SDK_VERSIONNAME = "1.1.4";
    private static final String HUAWEI_CAMERAKIT_RUNTIME_PACKAGE_NAME = "com.huawei.camerakit.impl";
    public static final int MAX_PREVIEW_SURFACE_NUMBER_API_LEVEL_1 = 1;
    private static final String TAG = "CameraKit";
    private VersionInfoInterface versionInfo;

    public VersionInfo(VersionInfoInterface versionInfoInterface) {
        this.versionInfo = versionInfoInterface;
    }

    private VersionInfoInterface getObject() {
        return this.versionInfo;
    }

    private boolean isDeviceCompatible() {
        VersionInfoInterface versionInfoInterface = this.getObject();
        if (versionInfoInterface != null) {
            return this.getObject().isDeviceCompatible();
        }
        Log.e((String)TAG, (String)"CameraKit is NOT supported on this device!");
        return false;
    }

    public static boolean isKitRuntimeAvailable(Context object) {
        object = object.getPackageManager();
        String string2 = HUAWEI_CAMERAKIT_RUNTIME_PACKAGE_NAME;
        try {
            object = object.getPackageInfo(string2, 0);
            if (object != null) {
                return true;
            }
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object = TAG;
            string2 = "CameraKit is NOT installed on this device!";
            Log.e((String)object, (String)string2);
        }
        return false;
    }

    private boolean isVersionCompatible(String string2, int n10) {
        VersionInfoInterface versionInfoInterface = this.getObject();
        if (versionInfoInterface != null) {
            return this.getObject().isVersionCompatible(string2, n10);
        }
        Log.e((String)TAG, (String)"SDK is NOT compatible with Runtime !");
        return false;
    }

    public int getApiLevel() {
        VersionInfoInterface versionInfoInterface = this.getObject();
        if (versionInfoInterface != null) {
            return this.getObject().getApiLevel();
        }
        return -1;
    }

    public String getVersionName() {
        VersionInfoInterface versionInfoInterface = this.getObject();
        if (versionInfoInterface != null) {
            return this.getObject().getVersionName();
        }
        return null;
    }

    public boolean isAllCompatible() {
        String string2;
        boolean bl2;
        boolean bl3 = this.isDeviceCompatible();
        if (bl3 == (bl2 = true) && (bl3 = this.isVersionCompatible(string2 = CURRENT_SDK_VERSIONNAME, 10104000))) {
            return bl2;
        }
        return false;
    }
}

