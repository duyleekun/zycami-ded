/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.BroadcastReceiver
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Handler
 *  android.text.TextUtils
 *  android.view.KeyEvent
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.availableupdate;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.availableupdate.e0$b;
import com.huawei.hms.availableupdate.m;
import com.huawei.hms.availableupdate.n;
import com.huawei.hms.availableupdate.o;
import com.huawei.hms.availableupdate.w;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.ui.SafeBundle;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.ResourceLoaderUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class e0
extends n {
    public BroadcastReceiver j;
    public Handler k;
    public int l;
    public Handler m;

    public e0() {
        Handler handler;
        this.k = handler = new Handler();
        this.l = 0;
        super(this);
        this.m = handler;
    }

    public static /* synthetic */ void a(e0 e02, int n10) {
        e02.c(n10);
    }

    public static /* synthetic */ void a(e0 e02, SafeBundle safeBundle) {
        e02.a(safeBundle);
    }

    public static /* synthetic */ void b(e0 e02, SafeBundle safeBundle) {
        e02.b(safeBundle);
    }

    public static /* synthetic */ void c(e0 e02, SafeBundle safeBundle) {
        e02.c(safeBundle);
    }

    public final void a(SafeBundle safeBundle) {
        String string2;
        int n10;
        CharSequence charSequence = "UpgradePkgName";
        boolean bl2 = safeBundle.containsKey((String)charSequence);
        if (bl2) {
            charSequence = safeBundle.getString((String)charSequence);
        } else {
            n10 = 0;
            charSequence = null;
        }
        if (charSequence != null && (n10 = ((String)charSequence).equals(string2 = this.g)) != 0 && (bl2 = safeBundle.containsKey((String)(charSequence = "downloadtask.status")))) {
            int n11 = safeBundle.getInt((String)charSequence);
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("handleDownloadStatus-status is ");
            ((StringBuilder)charSequence).append(n11);
            charSequence = ((StringBuilder)charSequence).toString();
            string2 = "SilentUpdateWizard";
            HMSLog.i(string2, (String)charSequence);
            n10 = 3;
            if (n11 != n10 && n11 != (n10 = 5) && n11 != (n10 = 6) && n11 != (n10 = 8)) {
                n10 = 4;
                if (n11 == n10) {
                    n11 = 60000;
                    this.b(n11);
                } else {
                    n11 = 20000;
                    this.b(n11);
                }
            } else {
                this.c(n11);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void a(Class var1_1) {
        block9: {
            var1_1 = var1_1.newInstance();
            var1_1 = (o)var1_1;
            var2_6 = this.l;
            if (var2_6 <= 0 || !(var3_7 = var1_1 instanceof w)) ** GOTO lbl13
            var4_8 = var1_1;
            var4_8 = (w)var1_1;
            var4_8.a(var2_6);
lbl13:
            // 2 sources

            ((o)var1_1).a(this);
            try {
                this.d = (o)var1_1;
                break block9;
            }
            catch (IllegalStateException var1_2) {
            }
            catch (IllegalAccessException var1_3) {
            }
            catch (InstantiationException var1_4) {
                // empty catch block
            }
            var5_9 /* !! */  = new StringBuilder();
            var4_8 = "In showDialog, Failed to show the dialog.";
            var5_9 /* !! */ .append((String)var4_8);
            var1_5 = var1_5.getMessage();
            var5_9 /* !! */ .append(var1_5);
            var1_5 = var5_9 /* !! */ .toString();
            var5_9 /* !! */  = "SilentUpdateWizard";
            HMSLog.e((String)var5_9 /* !! */ , var1_5);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean a(Activity activity) {
        String string2 = "SilentUpdateWizard";
        CharSequence charSequence = this.g;
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (bl2) {
            return false;
        }
        charSequence = new Intent("com.huawei.appmarket.intent.action.ThirdUpdateAction");
        charSequence.setPackage("com.huawei.appmarket");
        Object object = new JSONArray();
        Object object2 = new JSONObject();
        String string3 = "pkgName";
        try {
            String string4 = this.g;
            object2.put(string3, (Object)string4);
            string3 = "versioncode";
            int n11 = this.i;
            object2.put(string3, n11);
        }
        catch (JSONException jSONException) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("create hmsJsonObject fail");
            String string5 = jSONException.getMessage();
            ((StringBuilder)charSequence).append(string5);
            string5 = ((StringBuilder)charSequence).toString();
            HMSLog.e(string2, string5);
            return false;
        }
        object.put(object2);
        object = object.toString();
        charSequence.putExtra("params", (String)object);
        boolean bl3 = this.c.d();
        charSequence.putExtra("isHmsOrApkUpgrade", bl3);
        object = ResourceLoaderUtil.getString("hms_install");
        charSequence.putExtra("buttonDlgY", (String)object);
        object = ResourceLoaderUtil.getString("hms_cancel");
        charSequence.putExtra("buttonDlgN", (String)object);
        bl3 = true;
        object2 = new Object[bl3];
        object2[0] = "%P";
        object2 = ResourceLoaderUtil.getString("hms_update_message_new", object2);
        string3 = "upgradeDlgContent";
        charSequence.putExtra(string3, (String)object2);
        object2 = "start silent activity of AppMarket";
        try {
            HMSLog.i(string2, (String)object2);
            int n10 = this.getRequestCode();
            activity.startActivityForResult((Intent)charSequence, n10);
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            HMSLog.e(string2, "ActivityNotFoundException");
            return false;
        }
        HMSLog.i(string2, "start silent activity finished");
        return bl3;
    }

    public final void b(int n10) {
        this.k.removeCallbacksAndMessages(null);
        Handler handler = this.k;
        e0$b e0$b = new e0$b(this, null);
        long l10 = n10;
        handler.postDelayed((Runnable)e0$b, l10);
    }

    public final void b(SafeBundle safeBundle) {
        String string2;
        int n10;
        Object object = "UpgradePkgName";
        boolean bl2 = safeBundle.containsKey((String)object);
        if (bl2) {
            object = safeBundle.getString((String)object);
        } else {
            n10 = 0;
            object = null;
        }
        if (object != null && (n10 = ((String)object).equals(string2 = this.g)) != 0 && (bl2 = safeBundle.containsKey((String)(object = "UpgradeDownloadProgress"))) && (bl2 = safeBundle.containsKey(string2 = "UpgradeAppName"))) {
            int n11 = safeBundle.getInt((String)object);
            object = new StringBuilder();
            ((StringBuilder)object).append("handlerDownloadProgress-progress is ");
            ((StringBuilder)object).append(n11);
            object = ((StringBuilder)object).toString();
            string2 = "SilentUpdateWizard";
            HMSLog.i(string2, (String)object);
            this.b(20000);
            n10 = 99;
            if (n11 >= n10) {
                n11 = n10;
            }
            this.l = n11;
            object = this.d;
            if (object == null) {
                object = w.class;
                this.a((Class)object);
            }
            if ((object = this.d) != null) {
                object = (w)object;
                ((w)object).b(n11);
            }
        }
    }

    public final void c() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.appmarket.service.downloadservice.Receiver");
        intentFilter.addAction("com.huawei.appmarket.service.downloadservice.progress.Receiver");
        intentFilter.addAction("com.huawei.appmarket.service.installerservice.Receiver");
        Handler handler = this.m;
        m m10 = new m(handler);
        this.j = m10;
        m10 = this.b();
        if (m10 != null) {
            handler = this.j;
            m10.registerReceiver((BroadcastReceiver)handler, intentFilter);
        }
    }

    public final void c(int n10) {
        this.k.removeCallbacksAndMessages(null);
        this.d();
        this.a();
        int n11 = this.a(false);
        if (n11 == 0) {
            n11 = this.f;
            this.c(n10, n11);
        } else {
            n11 = this.f;
            this.a(n10, n11);
        }
    }

    public final void c(SafeBundle object) {
        CharSequence charSequence;
        boolean bl2;
        String string2 = "packagename";
        boolean bl3 = ((SafeBundle)object).containsKey(string2);
        if (bl3 && (bl2 = ((SafeBundle)object).containsKey((String)(charSequence = "status")))) {
            int n10;
            string2 = ((SafeBundle)object).getString(string2);
            int n11 = ((SafeBundle)object).getInt((String)charSequence);
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("handlerInstallStatus-status is ");
            ((StringBuilder)charSequence).append(n11);
            charSequence = ((StringBuilder)charSequence).toString();
            String string3 = "SilentUpdateWizard";
            HMSLog.i(string3, (String)charSequence);
            if (string2 != null && (n10 = string2.equals(charSequence = this.g)) != 0) {
                n10 = 2;
                if (n11 == n10) {
                    object = this.k;
                    n10 = 0;
                    string2 = null;
                    object.removeCallbacksAndMessages(null);
                    object = this.d;
                    if (object != null) {
                        object = (w)object;
                        n10 = 100;
                        ((w)object).b(n10);
                    }
                    n11 = this.f;
                    n10 = 0;
                    string2 = null;
                    this.c(0, n11);
                } else {
                    n10 = -1;
                    if (n11 != n10 && n11 != (n10 = -2)) {
                        n11 = 60000;
                        this.b(n11);
                    } else {
                        this.c(n11);
                    }
                }
            }
        }
    }

    public final void d() {
        BroadcastReceiver broadcastReceiver;
        Activity activity = this.b();
        if (activity != null && (broadcastReceiver = this.j) != null) {
            activity.unregisterReceiver(broadcastReceiver);
            activity = null;
            this.j = null;
        }
    }

    public void e() {
        int n10 = this.f;
        this.c(13, n10);
    }

    public int getRequestCode() {
        return 2000;
    }

    public void onBridgeActivityCreate(Activity activity) {
        super.onBridgeActivityCreate(activity);
        UpdateBean updateBean = this.c;
        if (updateBean == null) {
            return;
        }
        int n10 = 0;
        updateBean = null;
        this.f = 0;
        int n11 = this.a(activity);
        if (n11 == 0) {
            n11 = this.a(true);
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

    public void onBridgeActivityDestroy() {
        this.k.removeCallbacksAndMessages(null);
        this.d();
        super.onBridgeActivityDestroy();
    }

    public boolean onBridgeActivityResult(int n10, int n11, Intent object) {
        Object object2;
        boolean bl2 = this.e;
        if (bl2 && (object2 = this.b) != null) {
            return object2.onBridgeActivityResult(n10, n11, (Intent)object);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("onBridgeActivityResult requestCode is ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("resultCode is ");
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        object2 = "SilentUpdateWizard";
        HMSLog.i((String)object2, (String)object);
        int n12 = this.getRequestCode();
        if (n10 == n12) {
            n10 = 1;
            if (n11 == 0) {
                this.c();
                this.b(20000);
                return n10 != 0;
            }
            n12 = 4;
            if (n11 == n12) {
                this.e();
                return n10 != 0;
            }
            n12 = (int)(this.a(n10 != 0) ? 1 : 0);
            if (n12 == 0) {
                n12 = this.f;
                this.c(n11, n12);
            } else {
                n12 = this.f;
                this.a(n11, n12);
            }
            return n10 != 0;
        }
        return false;
    }

    public void onBridgeConfigurationChanged() {
        super.onBridgeConfigurationChanged();
    }

    public void onKeyUp(int n10, KeyEvent keyEvent) {
        super.onKeyUp(n10, keyEvent);
    }
}

