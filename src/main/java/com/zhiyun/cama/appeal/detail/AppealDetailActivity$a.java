/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.cama.appeal.detail;

import android.content.Context;
import com.zhiyun.cama.appeal.detail.AppealDetailActivity;
import com.zhiyun.cama.data.api.entity.AppealDetailEntity;
import com.zhiyun.cama.data.database.model.Appeal;
import com.zhiyun.cama.data.database.model.Approval;
import com.zhiyun.net.Punish;
import d.v.a.f.b.a;
import d.v.c.p0.n.j;

public class AppealDetailActivity$a
extends a {
    public final /* synthetic */ String a;
    public final /* synthetic */ AppealDetailActivity b;

    public AppealDetailActivity$a(AppealDetailActivity appealDetailActivity, String string2) {
        this.b = appealDetailActivity;
        this.a = string2;
    }

    public void a(AppealDetailEntity appealDetailEntity) {
        j j10 = AppealDetailActivity.d(this.b);
        AppealDetailActivity appealDetailActivity = this.b;
        String string2 = this.a;
        Approval approval = appealDetailEntity.approval;
        Punish punish = appealDetailEntity.punish;
        Appeal appeal = appealDetailEntity.appeal;
        j10.r((Context)appealDetailActivity, string2, approval, punish, appeal);
    }

    public void onError(Throwable throwable, int n10, String string2) {
        this.b.u(string2);
    }
}

