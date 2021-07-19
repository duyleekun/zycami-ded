/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.unity.UnityVersionProvider;

public class AppData {
    public final String buildId;
    public final String googleAppId;
    public final String installerPackageName;
    public final String packageName;
    public final UnityVersionProvider unityVersionProvider;
    public final String versionCode;
    public final String versionName;

    public AppData(String string2, String string3, String string4, String string5, String string6, String string7, UnityVersionProvider unityVersionProvider) {
        this.googleAppId = string2;
        this.buildId = string3;
        this.installerPackageName = string4;
        this.packageName = string5;
        this.versionCode = string6;
        this.versionName = string7;
        this.unityVersionProvider = unityVersionProvider;
    }

    public static AppData create(Context object, IdManager idManager, String string2, String string3, UnityVersionProvider unityVersionProvider) {
        String string4 = object.getPackageName();
        String string5 = idManager.getInstallerPackageName();
        object = object.getPackageManager();
        idManager = null;
        object = object.getPackageInfo(string4, 0);
        int n10 = object.versionCode;
        String string6 = Integer.toString(n10);
        object = object.versionName;
        if (object == null) {
            object = "0.0";
        }
        Object object2 = object;
        object = new AppData(string2, string3, string5, string4, string6, (String)object2, unityVersionProvider);
        return object;
    }
}

