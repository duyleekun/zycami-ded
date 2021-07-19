/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.NotificationManager
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageInstaller$SessionInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.os.UserManager
 *  android.util.Log
 */
package com.google.android.gms.common;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.R$string;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.concurrent.atomic.AtomicBoolean;

public class GooglePlayServicesUtilLight {
    public static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
    public static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
    public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static final AtomicBoolean sCanceledAvailabilityNotification;
    private static boolean zza = false;
    private static boolean zzb = false;
    private static boolean zzc = false;
    private static boolean zzd = false;
    private static final AtomicBoolean zze;

    static {
        AtomicBoolean atomicBoolean;
        sCanceledAvailabilityNotification = atomicBoolean = new AtomicBoolean();
        zze = atomicBoolean = new AtomicBoolean();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void cancelAvailabilityErrorNotifications(Context object) {
        Object object2 = sCanceledAvailabilityNotification;
        boolean bl2 = true;
        int n10 = ((AtomicBoolean)object2).getAndSet(bl2);
        if (n10 != 0) {
            return;
        }
        object2 = "notification";
        try {
            Object object3 = object.getSystemService((String)object2);
            NotificationManager notificationManager = (NotificationManager)object3;
            if (notificationManager == null) return;
            n10 = 10436;
            notificationManager.cancel(n10);
            return;
        }
        catch (SecurityException securityException) {
            return;
        }
    }

    public static void enableUsingApkIndependentContext() {
        zze.set(true);
    }

    public static void ensurePlayServicesAvailable(Context object, int n10) {
        Object object2 = GoogleApiAvailabilityLight.getInstance();
        n10 = ((GoogleApiAvailabilityLight)object2).isGooglePlayServicesAvailable((Context)object, n10);
        if (n10 != 0) {
            object = GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent((Context)object, n10, "e");
            int n11 = 57;
            CharSequence charSequence = new StringBuilder(n11);
            charSequence.append("GooglePlayServices not available due to error ");
            charSequence.append(n10);
            object2 = charSequence.toString();
            charSequence = "GooglePlayServicesUtil";
            Log.e((String)charSequence, (String)object2);
            if (object == null) {
                object = new GooglePlayServicesNotAvailableException(n10);
                throw object;
            }
            object2 = new GooglePlayServicesRepairableException(n10, "Google Play Services not available", (Intent)object);
            throw object2;
        }
    }

    public static int getApkVersion(Context context) {
        String string2;
        try {
            context = context.getPackageManager();
            string2 = GOOGLE_PLAY_SERVICES_PACKAGE;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Log.w((String)"GooglePlayServicesUtil", (String)"Google Play services is missing.");
            return 0;
        }
        return context.getPackageInfo((String)string2, (int)0).versionCode;
    }

    public static int getClientVersion(Context context) {
        Preconditions.checkState(true);
        String string2 = context.getPackageName();
        return ClientLibraryUtils.getClientVersion(context, string2);
    }

    public static PendingIntent getErrorPendingIntent(int n10, Context context, int n11) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(context, n10, n11);
    }

    public static String getErrorString(int n10) {
        return ConnectionResult.zza(n10);
    }

    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int n10) {
        return GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, n10, null);
    }

    public static Context getRemoteContext(Context context) {
        String string2 = GOOGLE_PLAY_SERVICES_PACKAGE;
        int n10 = 3;
        try {
            return context.createPackageContext(string2, n10);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        String string2;
        try {
            context = context.getPackageManager();
            string2 = GOOGLE_PLAY_SERVICES_PACKAGE;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return null;
        }
        return context.getResourcesForApplication(string2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean honorsDebugCertificates(Context context) {
        boolean bl2;
        boolean bl3;
        block5: {
            boolean bl4 = zzd;
            bl3 = true;
            if (!bl4) {
                Throwable throwable2222222;
                PackageManagerWrapper packageManagerWrapper = Wrappers.packageManager(context);
                String string2 = GOOGLE_PLAY_SERVICES_PACKAGE;
                int n10 = 64;
                packageManagerWrapper = packageManagerWrapper.getPackageInfo(string2, n10);
                GoogleSignatureVerifier.getInstance(context);
                zzc = packageManagerWrapper != null && !(bl2 = GoogleSignatureVerifier.zza((PackageInfo)packageManagerWrapper, false)) && (bl2 = GoogleSignatureVerifier.zza((PackageInfo)packageManagerWrapper, bl3)) ? bl3 : false;
                zzd = bl3;
                break block5;
                {
                    catch (Throwable throwable2222222) {
                    }
                    catch (PackageManager.NameNotFoundException nameNotFoundException) {}
                    String string3 = "GooglePlayServicesUtil";
                    String string4 = "Cannot find Google Play services package name.";
                    {
                        Log.w((String)string3, (String)string4, (Throwable)nameNotFoundException);
                        zzd = bl3;
                        break block5;
                    }
                }
                zzd = bl3;
                throw throwable2222222;
            }
        }
        if (bl2 = zzc) return bl3;
        bl2 = DeviceProperties.isUserBuild();
        if (bl2) return false;
        return bl3;
    }

    public static int isGooglePlayServicesAvailable(Context context) {
        int n10 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        return GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, n10);
    }

    public static int isGooglePlayServicesAvailable(Context object, int n10) {
        String string2;
        Object object2 = object.getResources();
        int n11 = R$string.common_google_play_services_unknown_issue;
        try {
            object2.getString(n11);
        }
        catch (Throwable throwable) {
            object2 = "GooglePlayServicesUtil";
            string2 = "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.";
            Log.e((String)object2, (String)string2);
        }
        object2 = object.getPackageName();
        string2 = GOOGLE_PLAY_SERVICES_PACKAGE;
        int n12 = string2.equals(object2);
        if (n12 == 0 && (n12 = ((AtomicBoolean)(object2 = zze)).get()) == 0) {
            n12 = zzs.zzb(object);
            if (n12 != 0) {
                n11 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
                if (n12 != n11) {
                    StringBuilder stringBuilder = new StringBuilder(320);
                    stringBuilder.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                    stringBuilder.append(n11);
                    stringBuilder.append(" but found ");
                    stringBuilder.append(n12);
                    stringBuilder.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                    String string3 = stringBuilder.toString();
                    object = new IllegalStateException(string3);
                    throw object;
                }
            } else {
                object = new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                throw object;
            }
        }
        if ((n12 = DeviceProperties.isWearableWithoutPlayStore(object)) == 0 && (n12 = DeviceProperties.zza(object)) == 0) {
            n12 = 1;
        } else {
            n12 = 0;
            object2 = null;
        }
        return GooglePlayServicesUtilLight.zza(object, n12 != 0, n10);
    }

    public static boolean isGooglePlayServicesUid(Context context, int n10) {
        return UidVerifier.isGooglePlayServicesUid(context, n10);
    }

    public static boolean isPlayServicesPossiblyUpdating(Context context, int n10) {
        int n11 = 1;
        int n12 = 18;
        if (n10 == n12) {
            return n11 != 0;
        }
        if (n10 == n11) {
            return GooglePlayServicesUtilLight.zza(context, GOOGLE_PLAY_SERVICES_PACKAGE);
        }
        return false;
    }

    public static boolean isPlayStorePossiblyUpdating(Context context, int n10) {
        int n11 = 9;
        if (n10 == n11) {
            return GooglePlayServicesUtilLight.zza(context, GOOGLE_PLAY_STORE_PACKAGE);
        }
        return false;
    }

    public static boolean isRestrictedUserProfile(Context object) {
        boolean bl2 = PlatformVersion.isAtLeastJellyBeanMR2();
        if (bl2) {
            boolean bl3;
            Object object2 = (UserManager)object.getSystemService("user");
            object = object.getPackageName();
            if ((object = object2.getApplicationRestrictions((String)object)) != null && (bl3 = ((String)(object2 = "true")).equals(object = object.getString("restricted_profile")))) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSidewinderDevice(Context context) {
        return DeviceProperties.isSidewinder(context);
    }

    public static boolean isUserRecoverableError(int n10) {
        int n11;
        int n12 = 1;
        if (n10 != n12 && n10 != (n11 = 2) && n10 != (n11 = 3) && n10 != (n11 = 9)) {
            return false;
        }
        return n12;
    }

    public static boolean uidHasPackageName(Context context, int n10, String string2) {
        return UidVerifier.uidHasPackageName(context, n10, string2);
    }

    private static int zza(Context object, boolean n10, int n11) {
        Object object2;
        PackageInfo packageInfo;
        int n12;
        String string2;
        int n13;
        CharSequence charSequence = GOOGLE_PLAY_SERVICES_PACKAGE;
        int n14 = 1;
        if (n11 >= 0) {
            n13 = n14;
        } else {
            n13 = 0;
            string2 = null;
        }
        Preconditions.checkArgument(n13 != 0);
        string2 = object.getPackageName();
        PackageManager packageManager = object.getPackageManager();
        String string3 = null;
        int n15 = 9;
        String string4 = "GooglePlayServicesUtil";
        if (n10 != 0) {
            string3 = GOOGLE_PLAY_STORE_PACKAGE;
            n12 = 8256;
            try {
                string3 = packageManager.getPackageInfo(string3, n12);
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                object = String.valueOf(string2).concat(" requires the Google Play Store, but it is missing.");
                Log.w((String)string4, (String)object);
                return n15;
            }
        }
        n12 = 64;
        try {
            packageInfo = packageManager.getPackageInfo((String)charSequence, n12);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object = String.valueOf(string2).concat(" requires Google Play services, but they are missing.");
            Log.w((String)string4, (String)object);
            return n14;
        }
        GoogleSignatureVerifier.getInstance(object);
        int n16 = GoogleSignatureVerifier.zza(packageInfo, n14 != 0);
        if (n16 == 0) {
            object = String.valueOf(string2).concat(" requires Google Play services, but their signature is invalid.");
            Log.w((String)string4, (String)object);
            return n15;
        }
        if (n10 != 0 && ((n16 = (int)(GoogleSignatureVerifier.zza((PackageInfo)(object = (PackageInfo)Preconditions.checkNotNull(string3)), n14 != 0) ? 1 : 0)) == 0 || (n16 = (int)((object = ((PackageInfo)string3).signatures[0]).equals(object2 = packageInfo.signatures[0]) ? 1 : 0)) == 0)) {
            object = String.valueOf(string2).concat(" requires Google Play Store, but its signature is invalid.");
            Log.w((String)string4, (String)object);
            return n15;
        }
        n16 = com.google.android.gms.common.util.zzb.zza(packageInfo.versionCode);
        if (n16 < (n10 = com.google.android.gms.common.util.zzb.zza(n11))) {
            n16 = packageInfo.versionCode;
            n10 = String.valueOf(string2).length() + 82;
            charSequence = new StringBuilder(n10);
            ((StringBuilder)charSequence).append("Google Play services out of date for ");
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(".  Requires ");
            ((StringBuilder)charSequence).append(n11);
            ((StringBuilder)charSequence).append(" but found ");
            ((StringBuilder)charSequence).append(n16);
            object = ((StringBuilder)charSequence).toString();
            Log.w((String)string4, (String)object);
            return 2;
        }
        object = packageInfo.applicationInfo;
        if (object == null) {
            try {
                object = packageManager.getApplicationInfo((String)charSequence, 0);
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                object2 = String.valueOf(string2).concat(" requires Google Play services, but they're missing when getting application info.");
                Log.wtf((String)string4, (String)object2, (Throwable)nameNotFoundException);
                return n14;
            }
        }
        if ((n16 = (int)(object.enabled ? 1 : 0)) == 0) {
            return 3;
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean zza(Context context, String string2) {
        int n10;
        Object object;
        String string3 = GOOGLE_PLAY_SERVICES_PACKAGE;
        boolean bl2 = string2.equals(string3);
        boolean bl3 = PlatformVersion.isAtLeastLollipop();
        boolean bl4 = true;
        if (bl3) {
            try {
                object = context.getPackageManager();
                object = object.getPackageInstaller();
                object = object.getAllSessions().iterator();
            }
            catch (Exception exception) {
                return false;
            }
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                String string4 = ((PackageInstaller.SessionInfo)object.next()).getAppPackageName();
                n10 = (int)(string2.equals(string4) ? 1 : 0);
                if (n10 == 0) continue;
                return bl4;
            }
        }
        object = context.getPackageManager();
        n10 = 8192;
        try {
            boolean bl5;
            string2 = object.getApplicationInfo(string2, n10);
            if (bl2) {
                return ((ApplicationInfo)string2).enabled;
            }
            boolean bl6 = ((ApplicationInfo)string2).enabled;
            if (!bl6 || (bl5 = GooglePlayServicesUtilLight.isRestrictedUserProfile(context))) return false;
            return bl4;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {}
        return false;
    }
}

