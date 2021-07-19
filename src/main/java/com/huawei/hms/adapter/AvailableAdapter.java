/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Build$VERSION
 *  android.os.Looper
 */
package com.huawei.hms.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Looper;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.adapter.AvailableAdapter$AvailableCallBack;
import com.huawei.hms.adapter.AvailableAdapter$a;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.adapter.sysobs.SystemObserver;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper$PackageStates;
import com.huawei.hms.utils.UIUtil;
import java.util.concurrent.atomic.AtomicBoolean;

public class AvailableAdapter {
    public static AtomicBoolean d;
    public static int e;
    public final int a;
    public AvailableAdapter$AvailableCallBack b;
    public SystemObserver c;

    static {
        AtomicBoolean atomicBoolean;
        d = atomicBoolean = new AtomicBoolean(false);
        e = 0;
    }

    public AvailableAdapter(int n10) {
        AvailableAdapter$a availableAdapter$a = new AvailableAdapter$a(this);
        this.c = availableAdapter$a;
        this.a = n10;
    }

    public static /* synthetic */ int a(int n10) {
        e = n10;
        return n10;
    }

    public static /* synthetic */ AvailableAdapter$AvailableCallBack a(AvailableAdapter availableAdapter) {
        return availableAdapter.a();
    }

    public static /* synthetic */ int b() {
        return e;
    }

    public static /* synthetic */ AtomicBoolean c() {
        return d;
    }

    public final AvailableAdapter$AvailableCallBack a() {
        return this.b;
    }

    public final void a(AvailableAdapter$AvailableCallBack availableAdapter$AvailableCallBack) {
        String string2;
        int n10 = 0;
        String string3 = null;
        while (true) {
            Object object = d;
            int n11 = ((AtomicBoolean)object).get();
            string2 = "AvailableAdapter";
            if (n11 == 0) break;
            n11 = 300;
            if (n10 >= n11) {
                string3 = "Previous popup is not handled by user or download has not finished within 1min.";
                HMSLog.i(string2, string3);
                if (availableAdapter$AvailableCallBack != null) {
                    n10 = 27;
                    availableAdapter$AvailableCallBack.onComplete(n10);
                }
                return;
            }
            object = "Concurrent startResolution thread is waiting.";
            HMSLog.d(string2, (String)object);
            long l10 = 200L;
            try {
                Thread.sleep(l10);
                ++n10;
            }
            catch (InterruptedException interruptedException) {
                object = "Concurrent startResolution thread waiting is interrupted.";
                HMSLog.d(string2, (String)object);
            }
        }
        string3 = "Concurrent startResolution thread waiting finished.";
        HMSLog.i(string2, string3);
        if (availableAdapter$AvailableCallBack != null) {
            n10 = e;
            availableAdapter$AvailableCallBack.onComplete(n10);
        }
    }

    public final boolean a(Activity object) {
        int n10;
        int n11 = ((HMSPackageManager)(object = HMSPackageManager.getInstance((Context)object))).getHmsVersionCode();
        if (n11 >= (n10 = 40000000)) {
            object = "AvailableAdapter";
            String string2 = "enter 4.0 HmsCore upgrade process";
            HMSLog.i((String)object, string2);
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }

    public int isHuaweiMobileServicesAvailable(Context object) {
        Object object2 = "context must not be null.";
        Checker.checkNonNull(object, object2);
        int n10 = Build.VERSION.SDK_INT;
        String string2 = "AvailableAdapter";
        int n11 = 16;
        if (n10 < n11) {
            HMSLog.i(string2, "HMS can not be supported under android 4.1");
            return 21;
        }
        PackageManagerHelper$PackageStates packageManagerHelper$PackageStates = PackageManagerHelper$PackageStates.NOT_INSTALLED;
        object2 = ((HMSPackageManager)(object = HMSPackageManager.getInstance((Context)object))).getHMSPackageStates();
        n11 = (int)(packageManagerHelper$PackageStates.equals(object2) ? 1 : 0);
        if (n11 != 0) {
            HMSLog.i(string2, "HMS is not installed");
            return 1;
        }
        packageManagerHelper$PackageStates = PackageManagerHelper$PackageStates.DISABLED;
        n10 = (int)(packageManagerHelper$PackageStates.equals(object2) ? 1 : 0);
        if (n10 != 0) {
            HMSLog.i(string2, "HMS is disabled");
            return 3;
        }
        n10 = this.a;
        boolean bl2 = ((HMSPackageManager)object).isApkUpdateNecessary(n10);
        if (bl2) {
            HMSLog.i(string2, "The current version does not meet the minimum version requirements");
            return 2;
        }
        return 0;
    }

    public boolean isUserResolvableError(int n10) {
        int n11;
        int n12 = 1;
        if (n10 != n12 && n10 != (n11 = 2)) {
            return false;
        }
        return n12;
    }

    public void startResolution(Activity activity, AvailableAdapter$AvailableCallBack object) {
        if (activity != null && object != null) {
            Looper looper;
            boolean bl2 = UIUtil.isBackground((Context)activity);
            String string2 = "AvailableAdapter";
            if (bl2) {
                HMSLog.i(string2, "current app is in Background");
                object.onComplete(28);
                return;
            }
            Object object2 = d;
            boolean bl3 = ((AtomicBoolean)object2).get();
            if (bl3 && (object2 = Looper.getMainLooper()) != (looper = Looper.myLooper())) {
                HMSLog.i(string2, "Another thread start to resolution.");
                this.a((AvailableAdapter$AvailableCallBack)object);
                return;
            }
            object2 = d;
            looper = null;
            boolean bl4 = true;
            boolean bl5 = ((AtomicBoolean)object2).compareAndSet(false, bl4);
            if (bl5) {
                object2 = "Start to resolution for the 1st time.";
                HMSLog.i(string2, (String)object2);
            } else {
                object2 = Looper.getMainLooper();
                if (object2 == (looper = Looper.myLooper())) {
                    object2 = "main thread invokes resolution.";
                    HMSLog.i(string2, (String)object2);
                }
            }
            HMSLog.i(string2, "startResolution");
            this.b = object;
            object = SystemManager.getSystemNotifier();
            object2 = this.c;
            object.registerObserver((SystemObserver)object2);
            object = UpdateAdapter.class.getName();
            object = BridgeActivity.getIntentStartBridgeActivity(activity, (String)object);
            int n10 = this.a;
            object.putExtra("update_version", n10);
            boolean bl6 = this.a(activity);
            string2 = "new_update";
            object.putExtra(string2, bl6);
            activity.startActivity((Intent)object);
        }
    }
}

