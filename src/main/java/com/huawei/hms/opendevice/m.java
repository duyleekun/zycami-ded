/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.d;
import com.huawei.hms.opendevice.e;
import com.huawei.hms.opendevice.n;
import com.huawei.hms.opendevice.o;
import com.huawei.hms.opendevice.p;
import com.huawei.hms.support.log.HMSLog;
import d.j.a.f.a;

public final class m
extends Thread {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    public m(Context context, String string2) {
        this.a = context;
        this.b = string2;
    }

    public void run() {
        boolean bl2 = p.a();
        String string2 = "ReportAaidToken";
        if (!bl2) {
            HMSLog.d(string2, "Not HW Phone.");
            return;
        }
        Object object = this.a;
        bl2 = n.a(object);
        if (bl2) {
            return;
        }
        object = o.a(this.a);
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (bl3) {
            HMSLog.w(string2, "AAID is empty.");
            return;
        }
        Object object2 = this.a;
        String string3 = this.b;
        bl3 = n.a((Context)object2, (String)object, string3);
        if (!bl3) {
            HMSLog.d(string2, "This time need not report.");
            return;
        }
        object2 = d.j.a.f.a.a(this.a);
        string3 = "region";
        boolean bl4 = TextUtils.isEmpty((CharSequence)(object2 = ((a)object2).g(string3)));
        if (bl4) {
            HMSLog.i(string2, "The data storage region is empty.");
            return;
        }
        string2 = this.a;
        string3 = "com.huawei.hms.opendevicesdk";
        CharSequence charSequence = "ROOT";
        bl3 = TextUtils.isEmpty((CharSequence)(string2 = e.a((Context)string2, string3, (String)charSequence, null, (String)object2)));
        if (bl3) {
            return;
        }
        object2 = this.a;
        string3 = this.b;
        object2 = n.b((Context)object2, (String)object, string3);
        string3 = this.a;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("/rest/appdata/v1/aaid/report");
        string2 = ((StringBuilder)charSequence).toString();
        string2 = d.a((Context)string3, string2, (String)object2, null);
        object2 = this.a;
        string3 = this.b;
        n.a((Context)object2, string2, (String)object, string3);
    }
}

