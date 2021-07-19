/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.text.TextUtils
 */
package com.huawei.hms.update.manager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.availableupdate.n;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.PackageManagerHelper$PackageStates;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.huawei.hms.utils.StringUtil;
import java.io.Serializable;
import java.util.ArrayList;

public class UpdateManager {
    public static void a(Activity object, ArrayList arrayList) {
        int n10;
        String string2 = "com.huawei.appmarket";
        boolean bl2 = UpdateManager.a((Context)object, string2);
        if (bl2 && (n10 = string2.equals(object = object.getPackageName())) == 0) {
            n10 = 5;
            object = n10;
            arrayList.add(object);
        }
    }

    public static void a(Context object, ArrayList arrayList) {
        String string2;
        boolean bl2 = SystemUtils.isTVDevice();
        if (bl2) {
            object = 5;
            arrayList.add(object);
            return;
        }
        Context context = object.getApplicationContext();
        bl2 = SystemUtils.isSystemApp(context, string2 = "com.huawei.appmarket");
        if (bl2 && (bl2 = UpdateManager.b(object)) && (bl2 = SystemUtils.isChinaROM())) {
            object = 0;
            arrayList.add(object);
            int n10 = 6;
            object = n10;
            arrayList.add(object);
        } else {
            UpdateManager.c(object, arrayList);
        }
    }

    public static boolean a(Context object) {
        String string2;
        String string3;
        boolean bl2;
        block10: {
            String string4 = "com.huawei.hms.client.channel.androidMarket";
            bl2 = true;
            string3 = "UpdateManager";
            if (object == null) {
                HMSLog.e(string3, "In getAndroidMarketSetting, context is null.");
                return bl2;
            }
            PackageManager packageManager = object.getPackageManager();
            string2 = "In getAndroidMarketSetting, configuration not found for android channel market setting.";
            if (packageManager == null) {
                HMSLog.i(string3, string2);
                return bl2;
            }
            object = object.getPackageName();
            int n10 = 128;
            object = packageManager.getPackageInfo((String)object, n10);
            object = object.applicationInfo;
            if (object == null) break block10;
            packageManager = object.metaData;
            if (packageManager == null) break block10;
            boolean bl3 = packageManager.containsKey(string4);
            if (!bl3) break block10;
            object = object.metaData;
            try {
                return object.getBoolean(string4, bl2);
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                object = "In getAndroidMarketSetting, Failed to read meta data from android market channel.";
                HMSLog.e(string3, (String)object);
            }
        }
        HMSLog.i(string3, string2);
        return bl2;
    }

    public static boolean a(Context object, String object2) {
        boolean bl2;
        Object object3 = new PackageManagerHelper((Context)object);
        object = ((PackageManagerHelper)object3).getPackageStates((String)object2);
        object3 = new StringBuilder();
        String string2 = "app is: ";
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append((String)object2);
        ((StringBuilder)object3).append(";status is:");
        ((StringBuilder)object3).append(object);
        object2 = ((StringBuilder)object3).toString();
        object3 = "UpdateManager";
        HMSLog.i((String)object3, object2);
        object2 = PackageManagerHelper$PackageStates.ENABLED;
        if (object2 == object) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static void b(Context object, ArrayList arrayList) {
        int n10;
        String string2 = "com.huawei.appmarket";
        boolean bl2 = UpdateManager.a(object, string2);
        if (bl2 && (n10 = string2.equals(object = object.getPackageName())) == 0) {
            n10 = 5;
            object = n10;
            arrayList.add(object);
        }
    }

    /*
     * WARNING - void declaration
     */
    public static boolean b(Context object) {
        void var2_6;
        Object object2 = new PackageManagerHelper((Context)object);
        object = "com.huawei.appmarket";
        int bl2 = ((PackageManagerHelper)object2).getPackageVersionCode((String)object);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("getHiappVersion is ");
        ((StringBuilder)object2).append(bl2);
        object2 = ((StringBuilder)object2).toString();
        String string2 = "UpdateManager";
        HMSLog.i(string2, (String)object2);
        long l10 = bl2;
        long l11 = 70203000L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 >= 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            object = null;
        }
        return (boolean)var2_6;
    }

    public static void c(Context object, ArrayList arrayList) {
        String string2;
        boolean bl2;
        String string3 = "com.huawei.appmarket";
        boolean bl3 = UpdateManager.a(object, string3);
        if (bl3 && !(bl2 = string3.equals(string2 = object.getPackageName())) && (bl2 = UpdateManager.c(object))) {
            int n10 = 5;
            object = n10;
            arrayList.add(object);
        } else {
            bl2 = UpdateManager.d(object);
            if (bl2) {
                int n11 = 7;
                object = n11;
                arrayList.add(object);
            } else {
                int n12 = UpdateManager.a(object);
                if (n12 == 0) {
                    n12 = 6;
                    object = n12;
                    arrayList.add(object);
                }
            }
        }
    }

    public static boolean c(Context object) {
        String string2;
        String string3;
        block18: {
            block19: {
                String string4 = ":";
                String[] stringArray = "com.huawei.hms.client.service.name:base";
                string3 = "UpdateManager";
                if (object == null) {
                    HMSLog.i(string3, "In isAgNewVersion, context is null.");
                    return false;
                }
                object = object.getPackageManager();
                string2 = "In isAgNewVersion, configuration not found for base version setting";
                if (object == null) {
                    HMSLog.i(string3, string2);
                    return false;
                }
                String string5 = "com.huawei.appmarket";
                int n10 = 128;
                object = object.getPackageInfo(string5, n10);
                object = ((PackageInfo)object).applicationInfo;
                if (object == null) break block18;
                string5 = ((ApplicationInfo)object).metaData;
                if (string5 == null) break block18;
                int n11 = string5.containsKey((String)stringArray);
                if (n11 == 0) break block18;
                object = ((ApplicationInfo)object).metaData;
                object = object.getString((String)stringArray);
                int n12 = TextUtils.isEmpty((CharSequence)object);
                if (n12 != 0) break block19;
                stringArray = ((String)object).split(string4);
                n12 = stringArray.length;
                n11 = 2;
                if (n12 != n11) break block19;
                object = ((String)object).split(string4);
                boolean bl2 = true;
                object = object[bl2];
                int n13 = StringUtil.convertVersion2Integer((String)object);
                n12 = 50004100;
                if (n13 >= n12) {
                    return bl2;
                }
            }
            HMSLog.i(string3, string2);
            return false;
        }
        try {
            HMSLog.i(string3, string2);
            return false;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object = "In isAgNewVersion, Failed to read meta data from base version setting channel.";
            HMSLog.e(string3, (String)object);
        }
        HMSLog.i(string3, string2);
        return false;
    }

    public static boolean d(Context context) {
        boolean bl2;
        Object object = new Intent("com.apptouch.intent.action.update_hms");
        Object object2 = context.getPackageManager();
        boolean bl3 = false;
        if ((object = object2.queryIntentServices((Intent)object, 0)) != null && !(bl2 = object.isEmpty())) {
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                Context context2;
                boolean bl4;
                object2 = ((ResolveInfo)object.next()).serviceInfo;
                if (object2 == null || (bl4 = TextUtils.isEmpty((CharSequence)(object2 = object2.packageName))) || !(bl4 = SystemUtils.isSystemApp(context2 = context.getApplicationContext(), (String)object2))) continue;
                break;
            }
        } else {
            bl2 = false;
            object2 = null;
        }
        if (object2 != null) {
            bl3 = true;
        }
        return bl3;
    }

    public static Intent getStartUpdateIntent(Activity activity, UpdateBean updateBean) {
        if (activity != null && updateBean != null) {
            Object object = new ArrayList();
            Object object2 = updateBean.getClientAppName();
            int n10 = TextUtils.isEmpty((CharSequence)object2);
            if (n10 == 0) {
                UpdateManager.a((Context)activity, object);
            } else {
                UpdateManager.a(activity, object);
            }
            n10 = -2;
            int n11 = ((ArrayList)object).size();
            if (n11 > 0) {
                object2 = (Integer)((ArrayList)object).get(0);
                n10 = (Integer)object2;
            } else {
                String string2 = "UpdateManager";
                String string3 = "typeList is empty, no upgrade solution";
                HMSLog.i(string2, string3);
            }
            updateBean.setTypeList((ArrayList)object);
            object = n.a(n10);
            activity = BridgeActivity.getIntentStartBridgeActivity(activity, (String)object);
            activity.putExtra("intent.extra.update.info", (Serializable)updateBean);
            return activity;
        }
        return null;
    }

    public static Intent getStartUpdateIntent(Context context, UpdateBean updateBean) {
        if (context != null && updateBean != null) {
            Object object = new ArrayList();
            Object object2 = updateBean.getClientAppName();
            int n10 = TextUtils.isEmpty((CharSequence)object2);
            if (n10 == 0) {
                UpdateManager.a(context, object);
            } else {
                UpdateManager.b(context, object);
            }
            n10 = -2;
            int n11 = ((ArrayList)object).size();
            if (n11 > 0) {
                object2 = (Integer)((ArrayList)object).get(0);
                n10 = (Integer)object2;
            } else {
                String string2 = "UpdateManager";
                String string3 = "typeList is empty, no upgrade solution";
                HMSLog.i(string2, string3);
            }
            updateBean.setTypeList((ArrayList)object);
            object = n.a(n10);
            context = BridgeActivity.getIntentStartBridgeActivity(context, (String)object);
            context.putExtra("intent.extra.update.info", (Serializable)updateBean);
            return context;
        }
        return null;
    }

    public static void startUpdate(Activity activity, int n10, UpdateBean updateBean) {
        if ((updateBean = UpdateManager.getStartUpdateIntent(activity, updateBean)) != null) {
            activity.startActivityForResult((Intent)updateBean, n10);
        }
    }

    public static Intent startUpdateIntent(Activity activity) {
        if (activity == null) {
            return null;
        }
        UpdateBean updateBean = new UpdateBean();
        int n10 = 1;
        updateBean.setHmsOrApkUpgrade(n10 != 0);
        String string2 = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
        updateBean.setClientPackageName(string2);
        int n11 = HMSPackageManager.getInstance(activity.getApplicationContext()).getHmsVersionCode();
        updateBean.setClientVersionCode(n11);
        updateBean.setClientAppId("C10132067");
        n11 = 0;
        string2 = null;
        updateBean.setNeedConfirm(false);
        Object object = ResourceLoaderUtil.getmContext();
        if (object == null) {
            object = activity.getApplicationContext();
            ResourceLoaderUtil.setmContext((Context)object);
        }
        object = ResourceLoaderUtil.getString("hms_update_title");
        updateBean.setClientAppName((String)object);
        object = new ArrayList();
        String string3 = updateBean.getClientAppName();
        int n12 = TextUtils.isEmpty((CharSequence)string3);
        if (n12 == 0) {
            UpdateManager.a((Context)activity, (ArrayList)object);
        } else {
            UpdateManager.a(activity, (ArrayList)object);
        }
        updateBean.setTypeList((ArrayList)object);
        n12 = ((ArrayList)object).size();
        if (n12 > n10) {
            n10 = (Integer)((ArrayList)object).get(n10);
            String string4 = n.a(n10);
            activity = BridgeActivity.getIntentStartBridgeActivity(activity, string4);
        } else {
            Object object2;
            n10 = -2;
            n12 = ((ArrayList)object).size();
            if (n12 > 0) {
                object2 = (Integer)((ArrayList)object).get(0);
                n10 = (Integer)object2;
            } else {
                string2 = "UpdateManager";
                object = "typeList is empty, no upgrade solution";
                HMSLog.i(string2, (String)object);
            }
            object2 = n.a(n10);
            activity = BridgeActivity.getIntentStartBridgeActivity(activity, (String)object2);
        }
        activity.putExtra("intent.extra.update.info", (Serializable)updateBean);
        return activity;
    }
}

