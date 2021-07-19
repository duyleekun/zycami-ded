/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net;

import g.a0;
import g.a0$a;
import g.c0;
import g.t;
import g.t$a;
import g.u;
import g.u$a;

public class RequestInterceptor
implements u {
    private String appVersion;
    private String env;
    private String production;

    public RequestInterceptor(String string2, String string3, String string4) {
        this.env = string2;
        this.production = string3;
        this.appVersion = string4;
    }

    private a0 addCommonParams(a0 a02) {
        Object object = a02.q().H();
        String string2 = this.env;
        object = ((t$a)object).g("env", string2).h();
        return a02.n().D((t)object).b();
    }

    private a0 addPlatform(a0 object) {
        object = ((a0)object).n().a("X-ZY-Platform", "Android");
        String string2 = this.production;
        object = ((a0$a)object).a("X-ZY-Production", string2);
        string2 = this.appVersion;
        return ((a0$a)object).a("X-ZY-Version", string2).b();
    }

    public String getEnv() {
        return this.env;
    }

    public c0 intercept(u$a u$a) {
        a0 a02 = u$a.C();
        a02 = this.addPlatform(a02);
        a02 = this.addCommonParams(a02);
        return u$a.c(a02);
    }

    public void setEnv(String string2) {
        this.env = string2;
    }
}

