/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.KeyEvent
 */
package com.huawei.hms.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

public class ResolutionDelegate
implements IBridgeActivityDelegate {
    public static final String CALLBACK_METHOD = "CALLBACK_METHOD";
    private WeakReference a;

    private BusResponseCallback a(String string2) {
        return ForegroundBusResponseMgr.getInstance().get(string2);
    }

    private void a() {
        boolean bl2;
        Activity activity = this.b();
        if (activity != null && !(bl2 = activity.isFinishing())) {
            activity.finish();
        }
    }

    private Activity b() {
        WeakReference weakReference = this.a;
        if (weakReference == null) {
            return null;
        }
        return (Activity)weakReference.get();
    }

    public int getRequestCode() {
        return 1002;
    }

    public void onBridgeActivityCreate(Activity activity) {
        Bundle bundle;
        this.a = bundle = new WeakReference(activity);
        bundle = activity.getIntent().getExtras();
        if (bundle != null) {
            String string2 = "resolution";
            bundle = (Intent)bundle.getParcelable(string2);
            int n10 = 1002;
            activity.startActivityForResult((Intent)bundle, n10);
        }
    }

    public void onBridgeActivityDestroy() {
        this.a = null;
    }

    public boolean onBridgeActivityResult(int n10, int n11, Intent intent) {
        int n12 = this.getRequestCode();
        if (n10 != n12) {
            return false;
        }
        Object object = this.a(CALLBACK_METHOD);
        intent = (Activity)this.a.get();
        Object object2 = HuaweiApiAvailability.getInstance();
        int n13 = 30000000;
        n12 = ((HuaweiApiAvailability)object2).isHuaweiMobileServicesAvailable((Context)intent, n13);
        int n14 = -1;
        if (n11 == n14 && n12 == 0) {
            object = "ResolutionDelegate";
            String string2 = "Make service available success.";
            HMSLog.i((String)object, string2);
        } else {
            intent = (Activity)this.a.get();
            object2 = "Make service available failed.";
            object.innerError((Activity)intent, n11, (String)object2);
        }
        this.a();
        return true;
    }

    public void onBridgeConfigurationChanged() {
    }

    public void onKeyUp(int n10, KeyEvent keyEvent) {
    }
}

