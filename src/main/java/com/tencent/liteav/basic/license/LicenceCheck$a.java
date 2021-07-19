/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.license;

import com.tencent.liteav.basic.license.LicenceCheck;

public class LicenceCheck$a {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public boolean g;
    public int h;
    public String i;
    public final /* synthetic */ LicenceCheck j;

    public LicenceCheck$a(LicenceCheck object, String string2) {
        this.j = object;
        this.a = string2;
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(".tmp");
        this.b = object = ((StringBuilder)object).toString();
        this.c = object = "";
        this.d = object;
        this.e = object;
        this.f = false;
        this.g = false;
        this.h = -1;
        this.i = object;
    }
}

