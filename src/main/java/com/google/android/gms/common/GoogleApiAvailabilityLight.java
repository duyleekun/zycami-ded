/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.text.TextUtils
 */
package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.zzi;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

public class GoogleApiAvailabilityLight {
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 0;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static final String TRACKING_SOURCE_DIALOG = "d";
    public static final String TRACKING_SOURCE_NOTIFICATION = "n";
    private static final GoogleApiAvailabilityLight zza;

    static {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        GOOGLE_PLAY_SERVICES_VERSION_CODE = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        zza = googleApiAvailabilityLight = new GoogleApiAvailabilityLight();
    }

    public static GoogleApiAvailabilityLight getInstance() {
        return zza;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String zza(Context object, String object2) {
        Object object3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        int n10 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        stringBuilder.append(n10);
        String string2 = "-";
        stringBuilder.append(string2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object3);
        if (!bl2) {
            stringBuilder.append((String)object3);
        }
        stringBuilder.append(string2);
        if (object != null) {
            object3 = object.getPackageName();
            stringBuilder.append((String)object3);
        }
        stringBuilder.append(string2);
        if (object == null) return stringBuilder.toString();
        try {
            object3 = Wrappers.packageManager((Context)object);
            String string3 = object.getPackageName();
            n10 = 0;
            string2 = null;
            PackageInfo packageInfo = ((PackageManagerWrapper)object3).getPackageInfo(string3, 0);
            int n11 = packageInfo.versionCode;
            stringBuilder.append(n11);
            return stringBuilder.toString();
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return stringBuilder.toString();
        }
    }

    public void cancelAvailabilityErrorNotifications(Context context) {
        GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
    }

    public int getApkVersion(Context context) {
        return GooglePlayServicesUtilLight.getApkVersion(context);
    }

    public int getClientVersion(Context context) {
        return GooglePlayServicesUtilLight.getClientVersion(context);
    }

    public Intent getErrorResolutionIntent(int n10) {
        return this.getErrorResolutionIntent(null, n10, null);
    }

    public Intent getErrorResolutionIntent(Context object, int n10, String string2) {
        int n11 = 1;
        String string3 = GOOGLE_PLAY_SERVICES_PACKAGE;
        if (n10 != n11 && n10 != (n11 = 2)) {
            int n12 = 3;
            if (n10 != n12) {
                return null;
            }
            return zzi.zza(string3);
        }
        if (object != null && (n10 = (int)(DeviceProperties.isWearableWithoutPlayStore(object) ? 1 : 0)) != 0) {
            return zzi.zza();
        }
        object = GoogleApiAvailabilityLight.zza(object, string2);
        return zzi.zza(string3, (String)object);
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int n10, int n11) {
        return this.getErrorResolutionPendingIntent(context, n10, n11, null);
    }

    public PendingIntent getErrorResolutionPendingIntent(Context context, int n10, int n11, String string2) {
        Intent intent = this.getErrorResolutionIntent(context, n10, string2);
        if (intent == null) {
            return null;
        }
        return PendingIntent.getActivity((Context)context, (int)n11, (Intent)intent, (int)0x8000000);
    }

    public String getErrorString(int n10) {
        return GooglePlayServicesUtilLight.getErrorString(n10);
    }

    public int isGooglePlayServicesAvailable(Context context) {
        int n10 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return this.isGooglePlayServicesAvailable(context, n10);
    }

    public int isGooglePlayServicesAvailable(Context context, int n10) {
        boolean bl2 = GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, n10 = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, n10));
        if (bl2) {
            n10 = 18;
        }
        return n10;
    }

    public boolean isPlayServicesPossiblyUpdating(Context context, int n10) {
        return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, n10);
    }

    public boolean isPlayStorePossiblyUpdating(Context context, int n10) {
        return GooglePlayServicesUtilLight.isPlayStorePossiblyUpdating(context, n10);
    }

    public boolean isUninstalledAppPossiblyUpdating(Context context, String string2) {
        return GooglePlayServicesUtilLight.zza(context, string2);
    }

    public boolean isUserResolvableError(int n10) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(n10);
    }

    public void verifyGooglePlayServicesIsAvailable(Context context, int n10) {
        GooglePlayServicesUtilLight.ensurePlayServicesAvailable(context, n10);
    }
}

