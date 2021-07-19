/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.huawei.updatesdk.service.otaupdate;

import android.view.View;
import com.huawei.updatesdk.service.otaupdate.AppUpdateActivity;

public class AppUpdateActivity$h
implements View.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ AppUpdateActivity b;

    public AppUpdateActivity$h(AppUpdateActivity appUpdateActivity, String string2) {
        this.b = appUpdateActivity;
        this.a = string2;
    }

    public void onClick(View object) {
        object = this.b;
        String string2 = this.a;
        AppUpdateActivity.a((AppUpdateActivity)object, string2);
    }
}

