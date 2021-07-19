/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.zhiyun.cama.appeal;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.ActivityCompat;
import com.zhiyun.cama.appeal.AppealActivity;
import com.zhiyun.cama.data.api.entity.IntegerEntity;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.f.i.g;

public class AppealActivity$b
extends a {
    public final /* synthetic */ AppealActivity a;

    public AppealActivity$b(AppealActivity appealActivity) {
        this.a = appealActivity;
    }

    public void onError(Throwable object, int n10, String string2) {
        this.a.m();
        object = this.a;
        String string3 = g.m((Context)object, 2131951757);
        ((AppealActivity)object).D(string3);
    }

    public void onSuccess(BaseEntity object) {
        this.a.m();
        AppealActivity appealActivity = this.a;
        int n10 = 2131951652;
        String string2 = g.m((Context)appealActivity, n10);
        appealActivity.D(string2);
        boolean bl2 = AppealActivity.f();
        if (bl2) {
            int n11 = ((IntegerEntity)object).id;
            appealActivity = new Intent();
            string2 = AppealActivity.h(this.a);
            String string3 = "type";
            appealActivity.putExtra(string3, string2);
            object = String.valueOf(n11);
            string2 = "appeal_id";
            appealActivity.putExtra(string2, (String)object);
            object = this.a;
            n10 = -1;
            object.setResult(n10, (Intent)appealActivity);
        }
        ActivityCompat.finishAfterTransition(this.a);
    }
}

