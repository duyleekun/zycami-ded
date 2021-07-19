/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.a.b.c.c;

import com.huawei.updatesdk.a.b.c.c.b;
import com.huawei.updatesdk.a.b.c.c.d$a;

public class d
extends b {
    public static final int ERROR = 1;
    public static final int NETWORK_ERROR = 3;
    public static final int OK = 0;
    public static final int PROGUARD_ERROR = 6;
    public static final int REQ_PARAM_ERROR = 5;
    public static final int RTN_CODE_OK = 0;
    public static final int TIMEOUT = 2;
    private d$a errCause;
    private int httpRespondeCode;
    private String reason;
    private int responseCode = 1;
    private int rtnCode_ = 0;

    public d() {
        d$a d$a;
        this.errCause = d$a = d$a.a;
        this.httpRespondeCode = 0;
    }

    public d$a a() {
        return this.errCause;
    }

    public void a(int n10) {
        this.httpRespondeCode = n10;
    }

    public void a(d$a d$a) {
        this.errCause = d$a;
    }

    public void a(String string2) {
        this.reason = string2;
    }

    public int b() {
        return this.httpRespondeCode;
    }

    public void b(int n10) {
        this.responseCode = n10;
    }

    public String c() {
        return this.reason;
    }

    public int d() {
        return this.responseCode;
    }

    public int e() {
        return this.rtnCode_;
    }

    public boolean f() {
        int n10 = this.d();
        n10 = n10 == 0 && (n10 = this.e()) == 0 ? 1 : 0;
        return n10 != 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" { \n\tresponseCode: ");
        int n10 = this.d();
        stringBuilder.append(n10);
        stringBuilder.append("\n\trtnCode_: ");
        n10 = this.e();
        stringBuilder.append(n10);
        stringBuilder.append("\n\terrCause: ");
        d$a d$a = this.a();
        stringBuilder.append((Object)d$a);
        stringBuilder.append("\n}");
        return stringBuilder.toString();
    }
}

