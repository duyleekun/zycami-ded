/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Dialog
 *  android.app.Fragment
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.os.Build$VERSION
 */
package com.huawei.hms.api;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.support.common.ActivityMgr;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.PackageManagerHelper$PackageStates;

public abstract class HuaweiMobileServicesUtil {
    public static final String HMS_ERROR_DIALOG = "HuaweiMobileServicesErrorDialog";

    public static Dialog getErrorDialog(int n10, Activity activity, int n11) {
        return HuaweiApiAvailability.getInstance().getErrorDialog(activity, n10, n11, null);
    }

    public static Dialog getErrorDialog(int n10, Activity activity, int n11, DialogInterface.OnCancelListener onCancelListener) {
        return HuaweiApiAvailability.getInstance().getErrorDialog(activity, n10, n11, onCancelListener);
    }

    public static String getErrorString(int n10) {
        return HuaweiApiAvailability.getInstance().getErrorString(n10);
    }

    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        return "";
    }

    public static Context getRemoteContext(Context context) {
        Object object;
        try {
            object = HMSPackageManager.getInstance(context);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return null;
        }
        object = ((HMSPackageManager)object).getHMSPackageName();
        int n10 = 2;
        return context.createPackageContext((String)object, n10);
    }

    public static Resources getRemoteResource(Context object) {
        PackageManager packageManager;
        try {
            packageManager = object.getPackageManager();
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return null;
        }
        object = HMSPackageManager.getInstance((Context)object);
        object = ((HMSPackageManager)object).getHMSPackageName();
        return packageManager.getResourcesForApplication((String)object);
    }

    public static int isHuaweiMobileServicesAvailable(Context context) {
        return HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context);
    }

    public static int isHuaweiMobileServicesAvailable(Context object, int n10) {
        Object object2 = "context must not be null.";
        Checker.checkNonNull(object, (String)object2);
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 < n12) {
            return 21;
        }
        object2 = new PackageManagerHelper((Context)object);
        CharSequence charSequence = HMSPackageManager.getInstance((Context)object).getHMSPackageName();
        Object object3 = new StringBuilder();
        object3.append("hmsPackageName is ");
        object3.append((String)charSequence);
        object3 = object3.toString();
        String string2 = "HuaweiMobileServicesUtil";
        HMSLog.i(string2, (String)object3);
        object3 = ((PackageManagerHelper)object2).getPackageStates((String)charSequence);
        PackageManagerHelper$PackageStates packageManagerHelper$PackageStates = PackageManagerHelper$PackageStates.NOT_INSTALLED;
        boolean bl2 = packageManagerHelper$PackageStates.equals(object3);
        if (bl2) {
            HMSLog.i(string2, "HMS is not installed");
            return 1;
        }
        PackageManagerHelper$PackageStates packageManagerHelper$PackageStates2 = PackageManagerHelper$PackageStates.DISABLED;
        boolean bl3 = packageManagerHelper$PackageStates2.equals(object3);
        if (bl3) {
            HMSLog.i(string2, "HMS is disabled");
            return 3;
        }
        object3 = HMSPackageManager.getInstance((Context)object).getHMSPackageStates();
        bl3 = packageManagerHelper$PackageStates.equals(object3);
        if (bl3 && (n12 = (int)(((String)(charSequence = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05")).equalsIgnoreCase((String)(object2 = ((PackageManagerHelper)object2).getPackageSignature((String)charSequence))) ? 1 : 0)) == 0 && !(bl3 = ((String)(charSequence = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C")).equalsIgnoreCase((String)object2)) && (n11 = (int)(((String)charSequence).equalsIgnoreCase((String)object2) ? 1 : 0)) == 0) {
            return 9;
        }
        n11 = HMSPackageManager.getInstance((Context)object).getHmsVersionCode();
        charSequence = new StringBuilder();
        object3 = "connect versionCode:";
        ((StringBuilder)charSequence).append((String)object3);
        ((StringBuilder)charSequence).append(n11);
        object2 = ((StringBuilder)charSequence).toString();
        HMSLog.i(string2, (String)object2);
        object = HMSPackageManager.getInstance((Context)object);
        boolean bl4 = ((HMSPackageManager)object).isApkUpdateNecessary(n10);
        if (bl4) {
            HMSLog.i(string2, "The current version does not meet the minimum version requirements");
            return 2;
        }
        return 0;
    }

    public static boolean isUserRecoverableError(int n10) {
        return HuaweiApiAvailability.getInstance().isUserResolvableError(n10);
    }

    public static boolean popupErrDlgFragment(int n10, Activity activity, int n11, DialogInterface.OnCancelListener onCancelListener) {
        return HuaweiApiAvailability.getInstance().showErrorDialogFragment(activity, n10, n11, onCancelListener);
    }

    public static boolean popupErrDlgFragment(int n10, Activity activity, Fragment fragment, int n11, DialogInterface.OnCancelListener onCancelListener) {
        return HuaweiApiAvailability.getInstance().showErrorDialogFragment(activity, n10, fragment, n11, onCancelListener);
    }

    public static void setApplication(Application application) {
        ActivityMgr.INST.init(application);
    }

    public static boolean showErrorDialogFragment(int n10, Activity activity, int n11) {
        return HuaweiApiAvailability.getInstance().showErrorDialogFragment(activity, n10, n11, null);
    }

    public static void showErrorNotification(int n10, Context context) {
        HuaweiApiAvailability.getInstance().showErrorNotification(context, n10);
    }
}

