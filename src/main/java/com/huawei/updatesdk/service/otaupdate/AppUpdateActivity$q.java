/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.service.otaupdate;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.updatesdk.b.h.b;
import com.huawei.updatesdk.b.i.a;
import com.huawei.updatesdk.service.appmgr.bean.ApkUpgradeInfo;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity$e;
import com.huawei.updatesdk.service.otaupdate.d;

public class AppUpdateActivity$q
extends com.huawei.updatesdk.a.b.b.a {
    public final /* synthetic */ AppUpdateActivity a;

    private AppUpdateActivity$q(AppUpdateActivity appUpdateActivity) {
        this.a = appUpdateActivity;
    }

    public /* synthetic */ AppUpdateActivity$q(AppUpdateActivity appUpdateActivity, AppUpdateActivity$e appUpdateActivity$e) {
        this(appUpdateActivity);
    }

    public void a(Context object, com.huawei.updatesdk.a.b.b.b object2) {
        int n10;
        int n11;
        boolean bl2 = ((com.huawei.updatesdk.a.b.b.b)object2).d();
        if (!bl2) {
            return;
        }
        object = AppUpdateActivity.h(this.a);
        if (object != null) {
            object = AppUpdateActivity.h(this.a);
            ((a)object).a();
        }
        AppUpdateActivity.f(this.a);
        object = ((com.huawei.updatesdk.a.b.b.b)object2).a();
        object2 = ((com.huawei.updatesdk.a.b.b.b)object2).c().getDataString();
        if (object2 != null && (n11 = ((String)object2).length()) >= (n10 = 9)) {
            n11 = 8;
            object2 = ((String)object2).substring(n11);
            String string2 = "android.intent.action.PACKAGE_ADDED";
            bl2 = string2.equals(object);
            if (bl2 && (bl2 = TextUtils.equals((CharSequence)(object = AppUpdateActivity.c(this.a)), (CharSequence)object2))) {
                object = d.a();
                object2 = this.a;
                n11 = 6;
                n10 = 0;
                int n12 = -1;
                object2 = AppUpdateActivity.a((AppUpdateActivity)object2, n11, 0, n12);
                ((d)object).a((Intent)object2);
                b.a();
                object = this.a;
                object2 = AppUpdateActivity.j((AppUpdateActivity)object).getPackage_();
                string2 = AppUpdateActivity.j(this.a).getDetailId_();
                AppUpdateActivity.a((AppUpdateActivity)object, (String)object2, string2);
                object = this.a;
                bl2 = AppUpdateActivity.i((AppUpdateActivity)object);
                if (bl2) {
                    object = this.a;
                    object2 = AppUpdateActivity.j((AppUpdateActivity)object);
                    AppUpdateActivity.a((AppUpdateActivity)object, (ApkUpgradeInfo)object2);
                }
            }
        }
    }
}

