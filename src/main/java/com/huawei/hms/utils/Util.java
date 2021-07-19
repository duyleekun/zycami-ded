/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ServiceConnection
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources$NotFoundException
 *  android.text.TextUtils
 */
package com.huawei.hms.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.StringUtil;
import com.huawei.hms.utils.UIUtil;

public class Util {
    private static final String AVAILABLE_LOADED = "availableLoaded";
    private static final Object LOCK_OBJECT;
    private static final String META_HMSVERSION_NAME = "com.huawei.hms.version";
    private static final String SERVICE_ACTION = "com.huawei.hms.core.aidl.action";
    private static final String TAG = "Util";
    private static boolean availableInit = false;
    private static boolean isAvailableAvailable = false;
    private static String serviceAction;

    static {
        Object object;
        LOCK_OBJECT = object = new Object();
    }

    public static int compareHmsVersion(String object, String object2) {
        int n10 = TextUtils.isEmpty((CharSequence)object);
        int n11 = -1;
        if (n10 != 0) {
            return n11;
        }
        n10 = TextUtils.isEmpty((CharSequence)object2);
        int n12 = 1;
        if (n10 != 0) {
            return n12;
        }
        n10 = StringUtil.checkVersion((String)object);
        if (n10 != 0 && (n10 = StringUtil.checkVersion((String)object2)) != 0) {
            String string2 = "\\.";
            object = object.split(string2);
            object2 = object2.split(string2);
            int n13 = 2;
            n10 = ((String[])object).length;
            if (n13 < n10 && n13 < (n10 = ((String[])object2).length)) {
                int n14;
                String string3;
                int n15;
                string2 = object[0];
                n10 = Integer.parseInt(string2);
                if (n10 > (n15 = Integer.parseInt(string3 = object2[0]))) {
                    return n12;
                }
                string2 = object[0];
                n10 = Integer.parseInt(string2);
                if (n10 < (n15 = Integer.parseInt(string3 = object2[0]))) {
                    return n11;
                }
                string2 = object[n12];
                n10 = Integer.parseInt(string2);
                if (n10 > (n15 = Integer.parseInt(string3 = object2[n12]))) {
                    return n12;
                }
                string2 = object[n12];
                n10 = Integer.parseInt(string2);
                if (n10 < (n15 = Integer.parseInt(string3 = object2[n12]))) {
                    return n11;
                }
                string2 = object[n13];
                n10 = Integer.parseInt(string2);
                if (n10 > (n15 = Integer.parseInt(string3 = object2[n13]))) {
                    return n12;
                }
                int n16 = Integer.parseInt((String)(object = object[n13]));
                if (n16 < (n14 = Integer.parseInt((String)(object2 = object2[n13])))) {
                    return n11;
                }
            }
        }
        return 0;
    }

    public static Activity getActiveActivity(Activity activity, Context context) {
        return UIUtil.getActiveActivity(activity, context);
    }

    public static String getAppId(Context context) {
        return AGCUtils.getAppId(context);
    }

    public static String getAppName(Context object, String string2) {
        String string3;
        block9: {
            PackageManager packageManager;
            String string4;
            block8: {
                string4 = TAG;
                string3 = "";
                if (object == null) {
                    HMSLog.e(string4, "In getAppName, context is null.");
                    return string3;
                }
                packageManager = object.getPackageManager();
                if (packageManager == null) {
                    HMSLog.e(string4, "In getAppName, Failed to get 'PackageManager' instance.");
                    return string3;
                }
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl2) break block8;
                string2 = object.getPackageName();
            }
            object = null;
            object = packageManager.getApplicationInfo(string2, 0);
            object = packageManager.getApplicationLabel((ApplicationInfo)object);
            if (object == null) break block9;
            try {
                string3 = object.toString();
            }
            catch (PackageManager.NameNotFoundException | Resources.NotFoundException throwable) {
                HMSLog.e(string4, "In getAppName, Failed to get app name.");
                return string3;
            }
        }
        return string3;
    }

    public static String getCpId(Context context) {
        return AGCUtils.getCpId(context);
    }

    public static int getHmsVersion(Context object) {
        String string2;
        String string3;
        block11: {
            int n10;
            string3 = "In getHmsVersion, Failed to read meta data for the HMS VERSION.";
            Object object2 = object.getPackageManager();
            string2 = TAG;
            if (object2 == null) {
                HMSLog.e(string2, "In getHmsVersion, Failed to get 'PackageManager' instance.");
                return 0;
            }
            try {
                object = object.getPackageName();
                n10 = 128;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                HMSLog.e(string2, string3);
                return 0;
            }
            object = object2.getPackageInfo((String)object, n10);
            object = object.applicationInfo;
            if (object == null) break block11;
            object = object.metaData;
            if (object == null) break block11;
            object2 = META_HMSVERSION_NAME;
            object = object.get((String)object2);
            if (object == null) break block11;
            object = String.valueOf(object);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) break block11;
            return StringUtil.convertVersion2Integer((String)object);
        }
        HMSLog.i(string2, string3);
        return 0;
    }

    public static String getNetType(Context context) {
        return SystemUtils.getNetType(context);
    }

    public static String getProcessName(Context context, int n10) {
        return UIUtil.getProcessName(context, n10);
    }

    public static String getProductCountry() {
        int n10;
        String string2;
        String string3 = "";
        String string4 = Util.getSystemProperties("ro.product.locale.region", string3);
        int n11 = TextUtils.isEmpty((CharSequence)string4);
        if (n11 == 0) {
            return string4;
        }
        string4 = Util.getSystemProperties("ro.product.locale", string3);
        n11 = TextUtils.isEmpty((CharSequence)string4);
        if (n11 == 0 && (n11 = string4.lastIndexOf(string2 = "-")) != (n10 = -1)) {
            return string4.substring(++n11);
        }
        string4 = SystemUtils.getLocalCountry();
        n11 = TextUtils.isEmpty((CharSequence)string4);
        if (n11 == 0) {
            string3 = string4;
        }
        return string3;
    }

    public static String getServiceActionMetadata(Context object) {
        String string2;
        String string3;
        block12: {
            string3 = "In getServiceActionMetadata, Failed to read meta data for the SERVICE ACTION.";
            String string4 = serviceAction;
            if (string4 != null) {
                return string4;
            }
            string4 = object.getPackageManager();
            string2 = TAG;
            if (string4 == null) {
                HMSLog.e(string2, "In getHmsVersion, Failed to get 'PackageManager' instance.");
                return null;
            }
            object = object.getPackageName();
            int n10 = 128;
            object = string4.getPackageInfo((String)object, n10);
            object = object.applicationInfo;
            if (object == null) break block12;
            object = object.metaData;
            if (object == null) break block12;
            string4 = SERVICE_ACTION;
            object = object.get(string4);
            if (object == null) break block12;
            object = String.valueOf(object);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) break block12;
            serviceAction = object;
            return object;
        }
        try {
            HMSLog.i(string2, string3);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            HMSLog.w(string2, string3);
        }
        object = "";
        serviceAction = object;
        return object;
    }

    public static String getSystemProperties(String string2, String string3) {
        return SystemUtils.getSystemProperties(string2, string3);
    }

    public static Activity getValidActivity(Activity activity, Activity activity2) {
        boolean bl2;
        if (activity == null || (bl2 = activity.isFinishing())) {
            boolean bl3;
            if (activity2 != null && !(bl3 = activity2.isFinishing())) {
                activity = activity2;
            } else {
                bl3 = false;
                activity = null;
            }
        }
        return activity;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean isAvailableLibExist(Context object) {
        Object object2 = LOCK_OBJECT;
        synchronized (object2) {
            boolean bl2 = availableInit;
            if (!bl2) {
                boolean bl3;
                block12: {
                    block11: {
                        bl2 = false;
                        Object object3 = object.getPackageManager();
                        bl3 = true;
                        if (object3 == null) {
                            object = TAG;
                            object3 = "In isAvailableLibExist, Failed to get 'PackageManager' instance.";
                            HMSLog.e((String)object, (String)object3);
                            object = "com.huawei.hms.adapter.AvailableAdapter";
                            try {
                                Class.forName((String)object);
                                break block11;
                            }
                            catch (ClassNotFoundException classNotFoundException) {
                                object = TAG;
                                object3 = "In isAvailableLibExist, Failed to find class AvailableAdapter.";
                                HMSLog.e((String)object, (String)object3);
                                break block12;
                            }
                        }
                        try {
                            boolean bl4;
                            object = object.getPackageName();
                            int n10 = 128;
                            object = object3.getPackageInfo((String)object, n10);
                            object = ((PackageInfo)object).applicationInfo;
                            if (object == null || (object = ((ApplicationInfo)object).metaData) == null || (object = object.get((String)(object3 = AVAILABLE_LOADED))) == null || !(bl4 = ((String)(object = String.valueOf(object))).equalsIgnoreCase((String)(object3 = "yes")))) break block12;
                            object = TAG;
                            object3 = "available exist: true";
                            HMSLog.i((String)object, (String)object3);
                        }
                        catch (PackageManager.NameNotFoundException nameNotFoundException) {
                            object = TAG;
                            object3 = "In isAvailableLibExist, Failed to read meta data for the availableLoaded.";
                            HMSLog.e((String)object, (String)object3);
                            break block12;
                        }
                    }
                    bl2 = bl3;
                }
                isAvailableAvailable = bl2;
                availableInit = bl3;
            }
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("available exist: ");
        boolean bl5 = isAvailableAvailable;
        ((StringBuilder)object).append(bl5);
        object = ((StringBuilder)object).toString();
        HMSLog.i(TAG, (String)object);
        return isAvailableAvailable;
    }

    public static boolean isChinaROM() {
        return SystemUtils.isChinaROM();
    }

    public static boolean isEMUI() {
        return SystemUtils.isEMUI();
    }

    public static void unBindServiceCatchException(Context context, ServiceConnection object) {
        String string2 = TAG;
        CharSequence charSequence = new StringBuilder();
        String string3 = "Trying to unbind service from ";
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(object);
        charSequence = ((StringBuilder)charSequence).toString();
        HMSLog.i(string2, (String)charSequence);
        try {
            context.unbindService((ServiceConnection)object);
        }
        catch (Exception exception) {
            object = new StringBuilder();
            charSequence = "On unBindServiceException:";
            ((StringBuilder)object).append((String)charSequence);
            String string4 = exception.getMessage();
            ((StringBuilder)object).append(string4);
            string4 = ((StringBuilder)object).toString();
            HMSLog.e(string2, string4);
        }
    }
}

