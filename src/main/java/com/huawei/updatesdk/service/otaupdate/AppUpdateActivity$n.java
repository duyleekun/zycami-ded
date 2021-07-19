/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ActivityNotFoundException
 *  android.content.Intent
 */
package com.huawei.updatesdk.service.otaupdate;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.huawei.updatesdk.a.a.c.a.a.a;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;
import com.huawei.updatesdk.service.otaupdate.c$a;

public class AppUpdateActivity$n
implements c$a {
    public final /* synthetic */ AppUpdateActivity a;

    public AppUpdateActivity$n(AppUpdateActivity appUpdateActivity) {
        this.a = appUpdateActivity;
    }

    public void a(Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            Object object = "com.huawei.appmarket.intent.action.ThirdUpdateRemindAction";
            bl2 = new Intent((String)object);
            object = this.a;
            object = AppUpdateActivity.c((AppUpdateActivity)object);
            bl2.setPackage((String)object);
            object = this.a;
            try {
                object.startActivity((Intent)bl2);
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                object = new StringBuilder();
                String string2 = "goHiappUpgrade error: ";
                ((StringBuilder)object).append(string2);
                String string3 = activityNotFoundException.toString();
                ((StringBuilder)object).append(string3);
                string3 = ((StringBuilder)object).toString();
                object = "AppUpdateActivity";
                com.huawei.updatesdk.a.a.c.a.a.a.b((String)object, string3);
            }
        }
        this.a.finish();
    }
}

