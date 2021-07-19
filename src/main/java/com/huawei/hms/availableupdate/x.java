/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ResolveInfo
 *  android.text.TextUtils
 *  android.view.KeyEvent
 */
package com.huawei.hms.availableupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.availableupdate.n;
import com.huawei.hms.availableupdate.o;
import com.huawei.hms.availableupdate.y;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.ArrayList;

public class x
extends n {
    public final void a(Intent intent) {
        Object object = this.b().getPackageManager();
        int n10 = 65536;
        if ((object = object.queryIntentActivities(intent, n10)) != null && (n10 = (int)(object.isEmpty() ? 1 : 0)) == 0) {
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add("com.huawei.appmarket.tv");
            arrayList.add("com.huawei.appmarket.car");
            String string2 = "com.huawei.appmarket";
            arrayList.add(string2);
            int n11 = object.size();
            int n12 = 1;
            if (n11 == n12) {
                return;
            }
            object = object.iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                string2 = (ResolveInfo)object.next();
                String string3 = string2.activityInfo.packageName;
                n12 = (int)(arrayList.contains(string3) ? 1 : 0);
                if (n12 == 0) continue;
                object = string2.activityInfo.packageName;
                intent.setPackage((String)object);
                break;
            }
        }
    }

    public void a(o o10) {
        String string2 = "HiappWizard";
        String string3 = "Enter onCancel.";
        HMSLog.i(string2, string3);
        boolean bl2 = o10 instanceof y;
        if (bl2) {
            this.d();
        }
    }

    /*
     * Unable to fully structure code
     */
    public void a(Class var1_1) {
        block12: {
            this.a();
            var1_1 = var1_1.newInstance();
            var1_1 = (o)var1_1;
            var2_6 = this.h;
            var3_7 = TextUtils.isEmpty((CharSequence)var2_6);
            if (var3_7 || !(var3_7 = var1_1 instanceof y)) ** GOTO lbl21
            var2_6 = "hms_update_title";
            var2_6 = ResourceLoaderUtil.getString((String)var2_6);
            this.h = var2_6;
            var4_8 = var1_1;
            var4_8 = (y)var1_1;
            var4_8.a((String)var2_6);
lbl21:
            // 2 sources

            ((o)var1_1).a(this);
            try {
                this.d = (o)var1_1;
                break block12;
            }
            catch (IllegalStateException var1_2) {
            }
            catch (IllegalAccessException var1_3) {
            }
            catch (InstantiationException var1_4) {
                // empty catch block
            }
            var2_6 = new StringBuilder();
            var4_8 = "In showDialog, Failed to show the dialog.";
            var2_6.append((String)var4_8);
            var1_5 = var1_5.getMessage();
            var2_6.append(var1_5);
            var1_5 = var2_6.toString();
            var2_6 = "HiappWizard";
            HMSLog.e((String)var2_6, var1_5);
        }
    }

    public void b(o o10) {
        String string2 = "HiappWizard";
        String string3 = "Enter onDoWork.";
        HMSLog.i(string2, string3);
        int n10 = o10 instanceof y;
        if (n10 != 0) {
            o10.b();
            int n11 = this.c();
            if (n11 == 0) {
                o10 = null;
                n11 = this.a(false);
                n10 = 8;
                if (n11 == 0) {
                    n11 = this.f;
                    this.c(n10, n11);
                } else {
                    n11 = this.f;
                    this.a(n10, n11);
                }
            }
        }
    }

    public final boolean c() {
        boolean bl2;
        String string2 = "HiappWizard";
        Object object = this.b();
        if (object != null && !(bl2 = object.isFinishing())) {
            boolean bl3;
            Object object2;
            String string3;
            block23: {
                string3 = this.g;
                bl2 = TextUtils.isEmpty((CharSequence)string3);
                if (bl2) {
                    return false;
                }
                string3 = new Intent();
                object2 = "com.huawei.appmarket.intent.action.AppDetail";
                string3.setAction((String)object2);
                object2 = "APP_PACKAGENAME";
                String string4 = this.g;
                string3.putExtra((String)object2, string4);
                boolean bl4 = SystemUtils.isTVDevice();
                bl3 = true;
                if (!bl4) break block23;
                object2 = new PackageManagerHelper((Context)object);
                CharSequence charSequence = "com.hisilicon.android.hiRMService";
                boolean bl5 = ((PackageManagerHelper)object2).getPackageVersionCode((String)charSequence);
                charSequence = new StringBuilder();
                String string5 = "version ";
                ((StringBuilder)charSequence).append(string5);
                ((StringBuilder)charSequence).append((int)(bl5 ? 1 : 0));
                charSequence = ((StringBuilder)charSequence).toString();
                HMSLog.i(string2, (String)charSequence);
                if (bl5 != bl3) break block23;
                object2 = "startActivity";
                HMSLog.i(string2, (String)object2);
                int n10 = 0x10000000;
                string3.addFlags(n10);
                this.a((Intent)string3);
                object.startActivity((Intent)string3);
                return bl3;
            }
            object2 = "startActivityForResult";
            HMSLog.i(string2, (String)object2);
            this.a((Intent)string3);
            int n11 = this.getRequestCode();
            try {
                object.startActivityForResult((Intent)string3, n11);
                return bl3;
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                object = "can not open hiapp";
                HMSLog.e(string2, (String)object);
            }
        }
        return false;
    }

    public void d() {
        int n10 = this.f;
        this.c(13, n10);
    }

    public int getRequestCode() {
        return 2005;
    }

    public void onBridgeActivityCreate(Activity object) {
        boolean bl2;
        int n10;
        super.onBridgeActivityCreate((Activity)object);
        object = this.c;
        if (object == null) {
            return;
        }
        this.f = n10 = 5;
        boolean n11 = ((UpdateBean)object).isNeedConfirm();
        if (n11 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.h)))) {
            object = y.class;
            this.a((Class)object);
        } else {
            boolean bl3 = this.c();
            if (!bl3) {
                object = null;
                boolean bl4 = this.a(false);
                n10 = 8;
                if (!bl4) {
                    int n12 = this.f;
                    this.c(n10, n12);
                } else {
                    int n13 = this.f;
                    this.a(n10, n13);
                }
            }
        }
    }

    public void onBridgeActivityDestroy() {
        super.onBridgeActivityDestroy();
    }

    public boolean onBridgeActivityResult(int n10, int n11, Intent intent) {
        IBridgeActivityDelegate iBridgeActivityDelegate;
        boolean bl2 = this.e;
        if (bl2 && (iBridgeActivityDelegate = this.b) != null) {
            return iBridgeActivityDelegate.onBridgeActivityResult(n10, n11, intent);
        }
        n11 = this.f;
        int n12 = 5;
        bl2 = false;
        iBridgeActivityDelegate = null;
        if (n11 == n12 && n10 == (n11 = this.getRequestCode())) {
            String string2 = this.g;
            n11 = this.i;
            n10 = (int)(this.a(string2, n11) ? 1 : 0);
            if (n10 != 0) {
                n10 = this.f;
                this.c(0, n10);
            } else {
                n10 = this.f;
                n11 = 8;
                this.c(n11, n10);
            }
            return true;
        }
        return false;
    }

    public void onBridgeConfigurationChanged() {
        super.onBridgeConfigurationChanged();
    }

    public void onKeyUp(int n10, KeyEvent object) {
        IBridgeActivityDelegate iBridgeActivityDelegate;
        boolean bl2 = this.e;
        if (bl2 && (iBridgeActivityDelegate = this.b) != null) {
            iBridgeActivityDelegate.onKeyUp(n10, (KeyEvent)object);
            return;
        }
        int n11 = 4;
        if (n11 == n10) {
            object = "In onKeyUp, Call finish.";
            HMSLog.i("HiappWizard", (String)object);
            Activity activity = this.b();
            if (activity != null && (n11 = (int)(activity.isFinishing() ? 1 : 0)) == 0) {
                n11 = 0;
                object = null;
                bl2 = false;
                iBridgeActivityDelegate = null;
                activity.setResult(0, null);
                activity.finish();
            }
        }
    }
}

