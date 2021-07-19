/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.Toast
 */
package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.widget.Toast;
import com.huawei.updatesdk.a.a.d.i.a;
import com.huawei.updatesdk.b.i.b;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$n;
import com.huawei.updatesdk.service.otaupdate.c;

public class AppUpdateActivity$l
implements b {
    public final /* synthetic */ AppUpdateActivity a;

    public AppUpdateActivity$l(AppUpdateActivity appUpdateActivity) {
        this.a = appUpdateActivity;
    }

    public void a() {
        AppUpdateActivity appUpdateActivity = this.a;
        int n10 = 101;
        AppUpdateActivity.c(appUpdateActivity, n10);
        appUpdateActivity = this.a;
        boolean bl2 = com.huawei.updatesdk.a.a.d.i.a.d((Context)appUpdateActivity);
        if (!bl2) {
            appUpdateActivity = this.a;
            n10 = com.huawei.updatesdk.b.h.c.c((Context)appUpdateActivity, "upsdk_no_available_network_prompt_toast");
            Toast.makeText((Context)appUpdateActivity, (int)n10, (int)0).show();
            AppUpdateActivity.b(this.a, 2);
            this.a.finish();
            return;
        }
        AppUpdateActivity.a(this.a);
    }

    public void b() {
        AppUpdateActivity.b(this.a).a();
        AppUpdateActivity.b(this.a, 4);
        Object object = this.a;
        int n10 = 100;
        AppUpdateActivity.c((AppUpdateActivity)object, n10);
        object = this.a;
        boolean bl2 = AppUpdateActivity.i((AppUpdateActivity)object);
        if (!bl2) {
            object = new c();
            AppUpdateActivity appUpdateActivity = this.a;
            String string2 = AppUpdateActivity.c(appUpdateActivity);
            AppUpdateActivity appUpdateActivity2 = this.a;
            AppUpdateActivity$n appUpdateActivity$n = new AppUpdateActivity$n(appUpdateActivity2);
            ((c)object).a((Context)appUpdateActivity, string2, appUpdateActivity$n);
        } else {
            object = this.a;
            ((AppUpdateActivity)object).finish();
        }
    }
}

