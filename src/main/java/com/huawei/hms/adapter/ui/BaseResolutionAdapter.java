/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.ActivityNotFoundException
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.content.IntentSender$SendIntentException
 *  android.os.Bundle
 *  android.view.KeyEvent
 */
package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import java.lang.ref.WeakReference;

public class BaseResolutionAdapter
implements IBridgeActivityDelegate {
    public WeakReference a;
    public String b = "";

    public final void a() {
        boolean bl2;
        Activity activity = this.b();
        if (activity != null && !(bl2 = activity.isFinishing())) {
            activity.finish();
        }
    }

    public final Activity b() {
        WeakReference weakReference = this.a;
        if (weakReference == null) {
            return null;
        }
        return (Activity)weakReference.get();
    }

    public final void c() {
        SystemManager systemManager = SystemManager.getInstance();
        String string2 = this.b;
        systemManager.notifyResolutionResult(null, string2);
        this.a();
    }

    public int getRequestCode() {
        return 1001;
    }

    public void onBridgeActivityCreate(Activity object) {
        Object object2;
        this.a = object2 = new WeakReference(object);
        object2 = object.getIntent();
        if (object2 == null) {
            this.c();
            return;
        }
        Bundle bundle = object2.getExtras();
        String string2 = "transaction_id";
        object2 = object2.getStringExtra(string2);
        this.b = object2;
        if (bundle == null) {
            this.c();
            return;
        }
        object2 = bundle.getParcelable("resolution");
        if (object2 == null) {
            this.c();
            return;
        }
        int n10 = object2 instanceof Intent;
        string2 = "BaseResolutionAdapter";
        if (n10 != 0) {
            n10 = 1001;
            try {
                object.startActivityForResult(object2, n10);
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                this.c();
                object = "ActivityNotFoundException:exception";
                HMSLog.e(string2, (String)object);
            }
        } else {
            n10 = object2 instanceof PendingIntent;
            if (n10 != 0) {
                object2 = (PendingIntent)object2;
                IntentSender intentSender = object2.getIntentSender();
                int n11 = 1001;
                try {
                    object.startIntentSenderForResult(intentSender, n11, null, 0, 0, 0);
                }
                catch (IntentSender.SendIntentException sendIntentException) {
                    this.c();
                    object = "SendIntentException:exception";
                    HMSLog.e(string2, (String)object);
                }
            }
        }
    }

    public void onBridgeActivityDestroy() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeActivityDestroy");
        this.a = null;
    }

    public boolean onBridgeActivityResult(int n10, int n11, Intent intent) {
        int n12 = this.getRequestCode();
        if (n10 != n12) {
            return false;
        }
        Object object = "BaseResolutionAdapter";
        String string2 = "onBridgeActivityResult";
        HMSLog.i((String)object, string2);
        n10 = -1;
        if (n11 != n10 && (n10 = (int)(intent.hasExtra((String)(object = "kit_update_result")) ? 1 : 0)) == 0) {
            object = SystemManager.getInstance();
            String string3 = this.b;
            intent = null;
            ((SystemManager)object).notifyResolutionResult(null, string3);
        } else {
            object = SystemManager.getInstance();
            String string4 = this.b;
            ((SystemManager)object).notifyResolutionResult(intent, string4);
        }
        this.a();
        return true;
    }

    public void onBridgeConfigurationChanged() {
        HMSLog.i("BaseResolutionAdapter", "onBridgeConfigurationChanged");
    }

    public void onKeyUp(int n10, KeyEvent keyEvent) {
        HMSLog.i("BaseResolutionAdapter", "On key up when resolve conn error");
    }
}

