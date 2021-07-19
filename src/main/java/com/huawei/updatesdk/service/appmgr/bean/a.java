/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.updatesdk.service.appmgr.bean;

import android.content.Context;
import com.huawei.updatesdk.a.a.d.h.d;
import com.huawei.updatesdk.b.b.c;
import com.huawei.updatesdk.b.c.b;

public class a
extends c {
    public static final String APIMETHOD = "client.getMarketInfo";
    private String code = "0200";
    private int deviceType;
    private int international;
    private String lang;
    private String marketPkg;
    private int net;
    private String subsystem = "updatesdk";
    private int sysBits;
    private String version;

    public a(String string2) {
        int n10;
        String string3;
        int n11;
        this.a(APIMETHOD);
        this.marketPkg = string2;
        this.sysBits = n11 = com.huawei.updatesdk.a.a.d.h.c.g();
        this.lang = string2 = com.huawei.updatesdk.a.a.d.h.c.e();
        this.b("8.0");
        string2 = com.huawei.updatesdk.a.b.a.a.c().a();
        this.version = string3 = com.huawei.updatesdk.a.a.d.h.c.h((Context)string2);
        this.deviceType = n10 = b.a().b();
        this.international = n10 = d.a();
        this.net = n11 = com.huawei.updatesdk.a.a.d.i.a.c((Context)string2);
    }
}

