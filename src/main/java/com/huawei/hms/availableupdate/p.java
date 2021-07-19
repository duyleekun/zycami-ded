/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Intent
 *  android.content.pm.ResolveInfo
 *  android.text.TextUtils
 *  android.view.KeyEvent
 */
package com.huawei.hms.availableupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.availableupdate.n;
import com.huawei.hms.availableupdate.o;
import com.huawei.hms.availableupdate.y;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class p
extends n {
    public final void a(Intent intent) {
        boolean bl2;
        Object object = new Intent("com.apptouch.intent.action.update_hms");
        Object object2 = this.b().getPackageManager();
        boolean bl3 = false;
        if ((object = object2.queryIntentServices((Intent)object, 0)) != null && !(bl2 = object.isEmpty())) {
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                object2 = ((ResolveInfo)object.next()).serviceInfo;
                if (object2 == null || (bl3 = TextUtils.isEmpty((CharSequence)(object2 = object2.packageName)))) continue;
                break;
            }
        } else {
            bl2 = false;
            object2 = null;
        }
        boolean bl4 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl4) {
            intent.setPackage((String)object2);
        }
    }

    public void a(o o10) {
        String string2 = "AppTouchWizard";
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
            var2_6 = "AppTouchWizard";
            HMSLog.e((String)var2_6, var1_5);
        }
    }

    public void b(o o10) {
        String string2 = "AppTouchWizard";
        String string3 = "Enter onDoWork.";
        HMSLog.i(string2, string3);
        int n10 = o10 instanceof y;
        if (n10 != 0) {
            o10.b();
            int n11 = this.c();
            if (n11 == 0) {
                n11 = this.f;
                n10 = 8;
                this.a(n10, n11);
            }
        }
    }

    public final boolean c() {
        boolean bl2;
        Object object = this.b();
        if (object != null && !(bl2 = object.isFinishing())) {
            String string2 = this.g;
            bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) {
                return false;
            }
            string2 = new Intent();
            String string3 = "com.huawei.appmarket.intent.action.AppDetail";
            string2.setAction(string3);
            string3 = "APP_PACKAGENAME";
            String string4 = this.g;
            string2.putExtra(string3, string4);
            this.a((Intent)string2);
            int n10 = this.getRequestCode();
            try {
                object.startActivityForResult((Intent)string2, n10);
                return true;
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                object = "AppTouchWizard";
                string2 = "can not open AppTouch detail page";
                HMSLog.e((String)object, string2);
            }
        }
        return false;
    }

    public void d() {
        int n10 = this.f;
        this.c(13, n10);
    }

    public int getRequestCode() {
        return 2007;
    }

    public void onBridgeActivityCreate(Activity object) {
        boolean bl2;
        int n10;
        super.onBridgeActivityCreate((Activity)object);
        object = this.c;
        if (object == null) {
            return;
        }
        this.f = n10 = 7;
        boolean n11 = ((UpdateBean)object).isNeedConfirm();
        if (n11 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.h)))) {
            object = y.class;
            this.a((Class)object);
        } else {
            boolean bl3 = this.c();
            if (!bl3) {
                int n12 = this.f;
                n10 = 8;
                this.a(n10, n12);
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
        int n12 = 7;
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
            HMSLog.i("AppTouchWizard", (String)object);
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

