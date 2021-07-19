/*
 * Decompiled with CFR 0.151.
 */
package com.heytap.mcssdk.c;

import java.util.List;

public class a
extends d.i.a.a.c.a {
    private static final String a = "&";
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private String g;
    private int h = -2;
    private String i;

    public static String a(List object) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            stringBuilder.append(object2);
            object2 = a;
            stringBuilder.append((String)object2);
        }
        return stringBuilder.toString();
    }

    public String a() {
        return this.b;
    }

    public void a(int n10) {
        this.f = n10;
    }

    public void a(String string2) {
        this.b = string2;
    }

    public String b() {
        return this.c;
    }

    public void b(int n10) {
        this.h = n10;
    }

    public void b(String string2) {
        this.c = string2;
    }

    public String c() {
        return this.d;
    }

    public void c(String string2) {
        this.d = string2;
    }

    public String d() {
        return this.e;
    }

    public void d(String string2) {
        this.e = string2;
    }

    public int e() {
        return this.f;
    }

    public void e(String string2) {
        this.g = string2;
    }

    public String f() {
        return this.g;
    }

    public void f(String string2) {
        this.i = string2;
    }

    public int g() {
        return this.h;
    }

    public int getType() {
        return 4105;
    }

    public String h() {
        return this.i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CallBackResult{, mRegisterID='");
        String string2 = this.d;
        stringBuilder.append(string2);
        int n10 = 39;
        stringBuilder.append((char)n10);
        stringBuilder.append(", mSdkVersion='");
        String string3 = this.e;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", mCommand=");
        int n11 = this.f;
        stringBuilder.append(n11);
        stringBuilder.append((char)n10);
        stringBuilder.append(", mContent='");
        string3 = this.g;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", mAppPackage=");
        string3 = this.i;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", mResponseCode=");
        n10 = this.h;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

