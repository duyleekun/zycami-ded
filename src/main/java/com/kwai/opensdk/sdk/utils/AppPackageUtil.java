/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.kwai.opensdk.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Log;

public final class AppPackageUtil {
    public static int getAppSupportAPILevel(Context context, String charSequence) {
        int n10;
        int n11 = 0;
        if (context != null && (n10 = TextUtils.isEmpty((CharSequence)charSequence)) == 0) {
            block6: {
                context = context.getPackageManager();
                n10 = 128;
                context = context.getApplicationInfo((String)charSequence, n10);
                context = context.metaData;
                if (context == null) break block6;
                charSequence = "openSocialSdkVersionNumber";
                try {
                    n11 = context.getInt((String)charSequence, 0);
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    charSequence = new StringBuilder();
                    String string2 = "get kwai api level failed, ";
                    ((StringBuilder)charSequence).append(string2);
                    ((StringBuilder)charSequence).append((Object)nameNotFoundException);
                    String string3 = ((StringBuilder)charSequence).toString();
                    charSequence = "Kwai Open Sdk";
                    Log.e((String)charSequence, (String)string3);
                }
            }
            return n11;
        }
        return 0;
    }

    private static Signature[] getPackageSignature(Context object, String string2) {
        int n10;
        if (object != null && (n10 = TextUtils.isEmpty((CharSequence)string2)) == 0) {
            object = object.getPackageManager();
            n10 = 64;
            try {
                object = object.getPackageInfo(string2, n10);
                if (object == null) {
                    return null;
                }
                return object.signatures;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                object = nameNotFoundException.getMessage();
                string2 = "PackageUtil";
                Log.e((String)string2, (String)object);
            }
        }
        return null;
    }

    public static String getPackageVersion(Context context) {
        String string2 = context.getPackageName();
        return AppPackageUtil.getPackageVersion(context, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getPackageVersion(Context object, String string2) {
        String string3;
        Object object2;
        block5: {
            object2 = null;
            if (object == null) return null;
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) {
                return null;
            }
            try {
                object = object.getPackageManager();
                bl2 = false;
                object = object.getPackageInfo(string2, 0);
                object = ((PackageInfo)object).versionName;
            }
            catch (Exception exception) {
                // empty catch block
                break block5;
            }
            try {
                boolean bl3 = TextUtils.isEmpty((CharSequence)object);
                if (!bl3) return object;
                return null;
            }
            catch (Exception exception) {
                object2 = object;
            }
        }
        object = ((Throwable)((Object)string3)).getMessage();
        string3 = "PackageUtil";
        Log.e((String)string3, (String)object);
        return object2;
    }

    public static int getVersionCode(Context context) {
        String string2 = context.getPackageName();
        return AppPackageUtil.getVersionCode(context, string2);
    }

    public static int getVersionCode(Context object, String string2) {
        boolean bl2;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            object = object.getPackageManager();
            object = object.getPackageInfo(string2, 0);
            try {
                return object.versionCode;
            }
            catch (Exception exception) {
                object = exception.getMessage();
                string2 = "PackageUtil";
                Log.e((String)string2, (String)object);
            }
        }
        return 0;
    }

    public static boolean isAppPackageInstalled(Context context, String string2) {
        boolean bl2;
        boolean bl3 = false;
        if (context != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            context = context.getPackageManager();
            try {
                context = context.getPackageInfo(string2, 0);
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                context = null;
            }
            if (context != null) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public static boolean validateSignature(Context object, String string2, String string3) {
        int n10;
        if (object != null && (n10 = TextUtils.isEmpty((CharSequence)string2)) == 0 && (n10 = TextUtils.isEmpty((CharSequence)string3)) == 0) {
            object = AppPackageUtil.getPackageSignature((Context)object, string2);
            string2 = "Kwai Open Sdk";
            if (object != null && (n10 = ((Signature[])object).length) != 0) {
                int n11;
                for (n10 = 0; n10 < (n11 = ((Signature[])object).length); ++n10) {
                    String string4 = object[n10].toCharsString().toLowerCase();
                    n11 = (int)(string3.equals(string4) ? 1 : 0);
                    if (n11 == 0) continue;
                    return true;
                }
                Log.e((String)string2, (String)"Signature check failed.");
                return false;
            }
            object = "Get signature failed";
            Log.e((String)string2, (String)object);
        }
        return false;
    }
}

