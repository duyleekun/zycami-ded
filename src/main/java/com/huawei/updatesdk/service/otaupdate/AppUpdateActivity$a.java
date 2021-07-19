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
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;

public class AppUpdateActivity$a
implements DialogInterface.OnKeyListener {
    public final /* synthetic */ AppUpdateActivity a;

    public AppUpdateActivity$a(AppUpdateActivity appUpdateActivity) {
        this.a = appUpdateActivity;
    }

    public boolean onKey(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        int n11 = 4;
        if (n10 == n11 && (n10 = keyEvent.getAction()) == 0) {
            AppUpdateActivity.b(this.a, n11);
            this.a.finish();
            return true;
        }
        return false;
    }
}

