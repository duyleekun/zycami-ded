/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.service.otaupdate;

import com.huawei.updatesdk.b.d.c;
import com.huawei.updatesdk.b.i.b;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;

public class AppUpdateActivity$f
implements b {
    public final /* synthetic */ AppUpdateActivity a;

    public AppUpdateActivity$f(AppUpdateActivity appUpdateActivity) {
        this.a = appUpdateActivity;
    }

    public void a() {
        AppUpdateActivity.d(this.a).setProgress(0);
        AppUpdateActivity.d(this.a).setMax(0);
        Object object = AppUpdateActivity.e(this.a);
        Object object2 = "";
        object.setText((CharSequence)object2);
        AppUpdateActivity.f(this.a);
        object = AppUpdateActivity.g(this.a);
        if (object != null) {
            object = AppUpdateActivity.g(this.a);
            ((c)((Object)object)).a();
        }
        AppUpdateActivity.h(this.a).a();
        object = this.a;
        boolean bl2 = AppUpdateActivity.i((AppUpdateActivity)object);
        if (bl2) {
            object = this.a;
            object2 = AppUpdateActivity.j((AppUpdateActivity)object);
            AppUpdateActivity.a((AppUpdateActivity)object, (ApkUpgradeInfo)object2);
            return;
        }
        AppUpdateActivity.b(this.a, 4);
        this.a.finish();
    }

    public void b() {
        AppUpdateActivity.h(this.a).a();
    }
}

