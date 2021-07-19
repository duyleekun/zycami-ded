/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.service.otaupdate;

import com.huawei.updatesdk.b.i.a;
import com.huawei.updatesdk.b.i.b;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.appmgr.bean.c;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;

public class AppUpdateActivity$b
implements b {
    public final /* synthetic */ c a;
    public final /* synthetic */ a b;
    public final /* synthetic */ AppUpdateActivity c;

    public AppUpdateActivity$b(AppUpdateActivity appUpdateActivity, c c10, a a10) {
        this.c = appUpdateActivity;
        this.a = c10;
        this.b = a10;
    }

    public void a() {
        AppUpdateActivity appUpdateActivity = this.c;
        c c10 = this.a;
        AppUpdateActivity.b(appUpdateActivity, c10);
        this.b.a();
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

