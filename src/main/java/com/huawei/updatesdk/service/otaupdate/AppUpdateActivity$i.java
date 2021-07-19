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
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.c;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;

public class AppUpdateActivity$i
implements b {
    public final /* synthetic */ c a;
    public final /* synthetic */ com.huawei.updatesdk.b.i.a b;
    public final /* synthetic */ AppUpdateActivity c;

    public AppUpdateActivity$i(AppUpdateActivity appUpdateActivity, c c10, com.huawei.updatesdk.b.i.a a10) {
        this.c = appUpdateActivity;
        this.a = c10;
        this.b = a10;
    }

    public void a() {
        Object object = this.c;
        int n10 = com.huawei.updatesdk.a.a.d.i.a.d((Context)object);
        if (n10 == 0) {
            object = this.c;
            String string2 = "upsdk_no_available_network_prompt_toast";
            int n11 = com.huawei.updatesdk.b.h.c.c((Context)object, string2);
            Toast.makeText((Context)object, (int)n11, (int)0).show();
            object = this.c;
            ((AppUpdateActivity)object).finish();
        } else {
            int n12;
            object = this.c;
            n10 = com.huawei.updatesdk.a.a.d.i.a.c((Context)object);
            if (n10 != (n12 = 1)) {
                object = this.c;
                c c10 = this.a;
                AppUpdateActivity.a((AppUpdateActivity)object, c10);
            } else {
                object = this.c;
                c c11 = this.a;
                AppUpdateActivity.b((AppUpdateActivity)object, c11);
                object = this.b;
                ((com.huawei.updatesdk.b.i.a)object).a();
            }
        }
    }

    public void b() {
        this.b.a();
        AppUpdateActivity appUpdateActivity = this.c;
        boolean bl2 = AppUpdateActivity.i(appUpdateActivity);
        if (bl2) {
            appUpdateActivity = this.c;
            ApkUpgradeInfo apkUpgradeInfo = AppUpdateActivity.j(appUpdateActivity);
            AppUpdateActivity.a(appUpdateActivity, apkUpgradeInfo);
            return;
        }
        AppUpdateActivity.b(this.c, 4);
        this.c.finish();
    }
}

