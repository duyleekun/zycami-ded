/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.view.KeyEvent
 */
package com.huawei.updatesdk.service.otaupdate;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.huawei.updatesdk.b.i.a;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;

public class AppUpdateActivity$d
implements DialogInterface.OnKeyListener {
    public final /* synthetic */ a a;
    public final /* synthetic */ AppUpdateActivity b;

    public AppUpdateActivity$d(AppUpdateActivity appUpdateActivity, a a10) {
        this.b = appUpdateActivity;
        this.a = a10;
    }

    public boolean onKey(DialogInterface object, int n10, KeyEvent keyEvent) {
        int n11 = 4;
        if (n10 == n11 && (n10 = keyEvent.getAction()) == 0) {
            Object object2 = this.b;
            n10 = (int)(AppUpdateActivity.i((AppUpdateActivity)object2) ? 1 : 0);
            boolean bl2 = true;
            if (n10 != 0) {
                this.a.a();
                object = this.b;
                object2 = AppUpdateActivity.j((AppUpdateActivity)object);
                AppUpdateActivity.a((AppUpdateActivity)object, (ApkUpgradeInfo)object2);
                return bl2;
            }
            AppUpdateActivity.b(this.b, n11);
            this.b.finish();
            return bl2;
        }
        return false;
    }
}

