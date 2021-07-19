/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 *  android.view.KeyEvent
 */
package com.huawei.hms.availableupdate;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.availableupdate.e0;
import com.huawei.hms.availableupdate.f0;
import com.huawei.hms.availableupdate.o;
import com.huawei.hms.availableupdate.p;
import com.huawei.hms.availableupdate.x;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.NetWorkUtil;
import com.huawei.hms.utils.PackageManagerHelper;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class n
implements IBridgeActivityDelegate {
    public WeakReference a;
    public IBridgeActivityDelegate b;
    public UpdateBean c = null;
    public o d = null;
    public boolean e = false;
    public int f = -1;
    public String g = null;
    public String h = null;
    public int i = 0;

    public static String a(int n10) {
        if (n10 != 0) {
            int n11 = 5;
            if (n10 != n11) {
                n11 = 6;
                if (n10 != n11) {
                    n11 = 7;
                    if (n10 != n11) {
                        return "";
                    }
                    return p.class.getName();
                }
                return f0.class.getName();
            }
            return x.class.getName();
        }
        return e0.class.getName();
    }

    public void a() {
        o o10 = this.d;
        if (o10 == null) {
            return;
        }
        o10.b();
        o10 = null;
        try {
            this.d = null;
        }
        catch (IllegalStateException illegalStateException) {
            CharSequence charSequence = new StringBuilder();
            String string2 = "In dismissDialog, Failed to dismiss the dialog.";
            charSequence.append(string2);
            String string3 = illegalStateException.getMessage();
            charSequence.append(string3);
            string3 = charSequence.toString();
            charSequence = "AbsUpdateWizard";
            HMSLog.e((String)charSequence, string3);
        }
    }

    public void a(int n10, int n11) {
        int n12;
        boolean bl2 = SystemUtils.isChinaROM();
        if (!bl2) {
            HMSLog.i("AbsUpdateWizard", "not ChinaROM ");
            return;
        }
        Activity activity = this.b();
        if (activity != null && (n12 = activity.isFinishing()) == 0) {
            Object object = new PackageManagerHelper((Context)activity);
            HashMap<String, String> hashMap = this.g;
            n12 = ((PackageManagerHelper)object).getPackageVersionCode((String)((Object)hashMap));
            hashMap = new HashMap<String, String>();
            String string2 = activity.getPackageName();
            hashMap.put("package", string2);
            string2 = this.g;
            String string3 = "target_package";
            hashMap.put(string3, string2);
            object = String.valueOf(n12);
            hashMap.put("target_ver", (String)object);
            object = String.valueOf(50200300);
            hashMap.put("sdk_ver", (String)object);
            object = AGCUtils.getAppId((Context)activity);
            hashMap.put("app_id", (String)object);
            hashMap.put("trigger_api", "core.connnect");
            object = String.valueOf(n11);
            hashMap.put("update_type", (String)object);
            n12 = NetWorkUtil.getNetworkType((Context)activity);
            object = String.valueOf(n12);
            string2 = "net_type";
            hashMap.put(string2, (String)object);
            Object object2 = this.b(n10, n11);
            hashMap.put("result", (String)object2);
            object2 = HiAnalyticsUtils.getInstance();
            String string4 = "HMS_SDK_UPDATE";
            ((HiAnalyticsUtils)object2).onEvent((Context)activity, string4, hashMap);
        }
    }

    public void a(o o10) {
    }

    public final void a(UpdateBean updateBean) {
        this.c = updateBean;
    }

    public abstract void a(Class var1);

    public final void a(ArrayList object) {
        block12: {
            String string2;
            Object object2;
            int n10;
            if (object != null && (n10 = ((ArrayList)object).size()) > 0) {
                n10 = 0;
                object2 = null;
                int n11 = (Integer)((ArrayList)object).get(0);
                object = n.a(n11);
            } else {
                boolean bl2 = false;
                object = null;
            }
            if (object == null) {
                return;
            }
            object = Class.forName((String)object);
            object2 = IBridgeActivityDelegate.class;
            object = ((Class)object).asSubclass(object2);
            object = ((Class)object).newInstance();
            object = (IBridgeActivityDelegate)object;
            try {
                this.b = object;
                break block12;
            }
            catch (ClassNotFoundException classNotFoundException) {
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InstantiationException instantiationException) {
            }
            catch (ClassCastException classCastException) {
                // empty catch block
            }
            object2 = new StringBuilder();
            String string3 = "getBridgeActivityDelegate error";
            ((StringBuilder)object2).append(string3);
            string2 = ((Throwable)((Object)string2)).getMessage();
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
            object2 = "AbsUpdateWizard";
            HMSLog.e((String)object2, string2);
        }
    }

    public boolean a(String string2, int n10) {
        PackageManagerHelper packageManagerHelper;
        int n11;
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        boolean bl4 = false;
        if (bl3) {
            return false;
        }
        Activity activity = this.b();
        if (activity != null && !(bl2 = activity.isFinishing()) && (n11 = (packageManagerHelper = new PackageManagerHelper((Context)activity)).getPackageVersionCode(string2)) >= n10) {
            bl4 = true;
        }
        return bl4;
    }

    public boolean a(boolean bl2) {
        Object object;
        Activity activity = this.b();
        boolean bl3 = false;
        if (activity == null) {
            return false;
        }
        Serializable serializable = this.c.getTypeList();
        int n10 = ((ArrayList)serializable).size();
        if (n10 > 0) {
            ((ArrayList)serializable).remove(0);
        }
        if ((object = this.b) == null) {
            this.a((ArrayList)serializable);
        }
        if ((object = this.b) != null) {
            this.e = bl3 = true;
            object = this.c;
            ((UpdateBean)object).setTypeList((ArrayList)serializable);
            serializable = this.c;
            ((UpdateBean)serializable).setNeedConfirm(bl2);
            IBridgeActivityDelegate iBridgeActivityDelegate = this.b;
            boolean bl4 = iBridgeActivityDelegate instanceof n;
            if (bl4) {
                iBridgeActivityDelegate = (n)iBridgeActivityDelegate;
                serializable = this.c;
                ((n)iBridgeActivityDelegate).a((UpdateBean)serializable);
            }
            iBridgeActivityDelegate = this.b;
            iBridgeActivityDelegate.onBridgeActivityCreate(activity);
        }
        return bl3;
    }

    public Activity b() {
        WeakReference weakReference = this.a;
        if (weakReference == null) {
            return null;
        }
        return (Activity)weakReference.get();
    }

    public final String b(int n10, int n11) {
        String string2 = String.valueOf(n10);
        if (n11 != 0) {
            int n12 = 5;
            if (n11 != n12) {
                n12 = 6;
                if (n11 != n12) {
                    return string2;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("4000");
                stringBuilder.append(string2);
                return stringBuilder.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("5000");
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0000");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public void b(o o10) {
    }

    public void c(int n10, int n11) {
        boolean bl2;
        Activity activity = this.b();
        if (activity != null && !(bl2 = activity.isFinishing())) {
            this.a(n10, n11);
            Intent intent = new Intent();
            String string2 = this.getClass().getName();
            String string3 = "intent.extra.DELEGATE_CLASS_OBJECT";
            intent.putExtra(string3, string2);
            string2 = "intent.extra.RESULT";
            intent.putExtra(string2, n10);
            n10 = -1;
            activity.setResult(n10, intent);
            activity.finish();
        }
    }

    public void onBridgeActivityCreate(Activity object) {
        int n10;
        Object object2 = new WeakReference(object);
        this.a = object2;
        object2 = this.c;
        if (object2 == null) {
            if ((object = object.getIntent()) == null) {
                return;
            }
            object2 = "intent.extra.update.info";
            object = (UpdateBean)object.getSerializableExtra((String)object2);
            this.c = object;
            if (object == null) {
                return;
            }
        }
        object = this.c.b();
        this.g = object;
        object = this.c.getClientAppName();
        this.h = object;
        this.i = n10 = this.c.c();
        this.c.a();
        this.b = null;
        this.e = false;
        this.f = -1;
    }

    public void onBridgeActivityDestroy() {
        IBridgeActivityDelegate iBridgeActivityDelegate = null;
        this.a = null;
        this.a();
        boolean bl2 = this.e;
        if (bl2 && (iBridgeActivityDelegate = this.b) != null) {
            iBridgeActivityDelegate.onBridgeActivityDestroy();
        }
    }

    public void onBridgeConfigurationChanged() {
        Object object;
        boolean bl2 = this.e;
        if (bl2 && (object = this.b) != null) {
            object.onBridgeConfigurationChanged();
            return;
        }
        object = this.d;
        if (object == null) {
            return;
        }
        object = object.getClass();
        this.d.b();
        this.d = null;
        this.a((Class)object);
    }

    public void onKeyUp(int n10, KeyEvent keyEvent) {
        IBridgeActivityDelegate iBridgeActivityDelegate;
        boolean bl2 = this.e;
        if (bl2 && (iBridgeActivityDelegate = this.b) != null) {
            iBridgeActivityDelegate.onKeyUp(n10, keyEvent);
        }
    }
}

