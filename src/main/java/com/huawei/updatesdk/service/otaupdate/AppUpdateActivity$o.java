/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.Intent
 */
package com.huawei.updatesdk.service.otaupdate;

import android.content.DialogInterface;
import android.content.Intent;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$e;
import com.huawei.updatesdk.service.otaupdate.d;

public class AppUpdateActivity$o
implements DialogInterface.OnDismissListener {
    private AppUpdateActivity$o() {
    }

    public /* synthetic */ AppUpdateActivity$o(AppUpdateActivity$e appUpdateActivity$e) {
        this();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        dialogInterface = new Intent();
        dialogInterface.putExtra("dialogstatus", 10001);
        d.a().b((Intent)dialogInterface);
    }
}

