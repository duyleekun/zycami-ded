/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  android.content.Intent
 */
package com.huawei.updatesdk.service.otaupdate;

import android.content.DialogInterface;
import android.content.Intent;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$e;
import com.huawei.updatesdk.service.otaupdate.d;

public class AppUpdateActivity$p
implements DialogInterface.OnShowListener {
    private AppUpdateActivity$p() {
    }

    public /* synthetic */ AppUpdateActivity$p(AppUpdateActivity$e appUpdateActivity$e) {
        this();
    }

    public void onShow(DialogInterface dialogInterface) {
        dialogInterface = new Intent();
        dialogInterface.putExtra("dialogstatus", 10002);
        d.a().b((Intent)dialogInterface);
    }
}

