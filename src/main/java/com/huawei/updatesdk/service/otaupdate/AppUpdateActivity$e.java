/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 */
package com.huawei.updatesdk.service.otaupdate;

import android.content.Intent;
import android.os.Bundle;
import com.huawei.updatesdk.a.b.b.b;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;
import com.huawei.updatesdk.service.otaupdate.d;

public class AppUpdateActivity$e
implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ AppUpdateActivity b;

    public AppUpdateActivity$e(AppUpdateActivity appUpdateActivity, b b10) {
        this.b = appUpdateActivity;
        this.a = b10;
    }

    public void run() {
        Bundle bundle = this.a.b();
        if (bundle == null) {
            return;
        }
        int n10 = bundle.getInt("INSTALL_STATE");
        int n11 = bundle.getInt("INSTALL_TYPE");
        d d10 = d.a();
        bundle = AppUpdateActivity.a(this.b, n10, n11, -1);
        d10.a((Intent)bundle);
        AppUpdateActivity.a(this.b, n10);
    }
}

