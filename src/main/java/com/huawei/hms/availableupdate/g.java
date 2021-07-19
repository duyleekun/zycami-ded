/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.availableupdate;

public class g {
    public int a = 0;
    public String b;
    public String c;
    public int d;
    public String e;

    public g(String string2, int n10, String string3, int n11, String string4) {
        String string5;
        this.b = string5 = "";
        this.c = string5;
        this.d = 0;
        this.e = string5;
        this.b = string2;
        this.a = n10;
        this.c = string3;
        this.d = n11;
        this.e = string4;
    }

    public boolean a() {
        String string2;
        int n10 = this.a;
        if (n10 > 0 && (n10 = this.d) > 0 && (string2 = this.c) != null && !(n10 = string2.isEmpty())) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        return n10 != 0;
    }
}

