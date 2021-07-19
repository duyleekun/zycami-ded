/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.hatool;

import android.content.Context;
import com.huawei.hms.hatool.f1;
import com.huawei.hms.hatool.g1;
import com.huawei.hms.hatool.h1;
import com.huawei.hms.hatool.k;
import com.huawei.hms.hatool.m1;
import com.huawei.hms.hatool.t0;
import com.huawei.hms.hatool.y;

public class k1 {
    public k a;
    public k b;
    public Context c;
    public String d;

    public k1(Context object) {
        if (object != null) {
            this.c = object = object.getApplicationContext();
        }
        this.a = object;
        super();
        this.b = object;
    }

    public k1 a(int n10, String string2) {
        block3: {
            k k10;
            block4: {
                block1: {
                    block2: {
                        CharSequence charSequence = new StringBuilder();
                        charSequence.append("Builder.setCollectURL(int type,String collectURL) is execute.TYPE : ");
                        charSequence.append(n10);
                        charSequence = charSequence.toString();
                        String string3 = "hmsSdk";
                        y.c(string3, (String)charSequence);
                        int n11 = t0.b(string2);
                        if (n11 == 0) {
                            string2 = "";
                        }
                        if (n10 == 0) break block1;
                        n11 = 1;
                        if (n10 == n11) break block2;
                        String string4 = "Builder.setCollectURL(int type,String collectURL): invalid type!";
                        y.f(string3, string4);
                        break block3;
                    }
                    k10 = this.b;
                    break block4;
                }
                k10 = this.a;
            }
            k10.b(string2);
        }
        return this;
    }

    public k1 a(String string2) {
        y.c("hmsSdk", "Builder.setAppID is execute");
        this.d = string2;
        return this;
    }

    public k1 a(boolean bl2) {
        y.c("hmsSdk", "Builder.setEnableImei(boolean isReportAndroidImei) is execute.");
        this.a.j().a(bl2);
        this.b.j().a(bl2);
        return this;
    }

    public void a() {
        Object object = this.c;
        Object object2 = "hmsSdk";
        if (object == null) {
            y.b((String)object2, "analyticsConf create(): context is null,create failed!");
            return;
        }
        y.c((String)object2, "Builder.create() is execute.");
        object = new h1("_hms_config_tag");
        k k10 = this.a;
        object2 = new k(k10);
        ((h1)object).b((k)object2);
        k10 = this.b;
        object2 = new k(k10);
        ((h1)object).a((k)object2);
        object2 = f1.a();
        k10 = this.c;
        ((f1)object2).a((Context)k10);
        object2 = g1.a();
        k10 = this.c;
        ((g1)object2).a((Context)k10);
        m1.c().a((h1)object);
        object = f1.a();
        object2 = this.d;
        ((f1)object).a((String)object2);
    }

    public k1 b(boolean bl2) {
        y.c("hmsSdk", "Builder.setEnableSN(boolean isReportSN) is execute.");
        this.a.j().b(bl2);
        this.b.j().b(bl2);
        return this;
    }

    public k1 c(boolean bl2) {
        y.c("hmsSdk", "Builder.setEnableUDID(boolean isReportUDID) is execute.");
        this.a.j().c(bl2);
        this.b.j().c(bl2);
        return this;
    }
}

