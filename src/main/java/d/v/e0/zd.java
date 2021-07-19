/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ae;

public class zd {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public float j;
    public float k;
    public float l;
    public ae m;

    public int a() {
        return this.d;
    }

    public float b() {
        return this.j;
    }

    public int c() {
        return this.a;
    }

    public int d() {
        return this.g;
    }

    public ae e() {
        return this.m;
    }

    public int f() {
        return this.e;
    }

    public float g() {
        return this.k;
    }

    public int h() {
        return this.b;
    }

    public int i() {
        return this.h;
    }

    public int j() {
        return this.f;
    }

    public float k() {
        return this.l;
    }

    public int l() {
        return this.c;
    }

    public int m() {
        return this.i;
    }

    public void n(int n10) {
        this.d = n10;
    }

    public void o(float f10) {
        this.j = f10;
    }

    public void p(int n10) {
        this.a = n10;
    }

    public void q(int n10) {
        this.g = n10;
    }

    public void r(ae ae2) {
        this.m = ae2;
    }

    public void s(int n10) {
        this.e = n10;
    }

    public void t(float f10) {
        this.k = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PtzScene{pitchFollowMaxRate=");
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(", rollFollowMaxRate=");
        n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(", yawFollowMaxRate=");
        n10 = this.c;
        stringBuilder.append(n10);
        stringBuilder.append(", pitchControlMaxRate=");
        n10 = this.d;
        stringBuilder.append(n10);
        stringBuilder.append(", rollControlMaxRate=");
        n10 = this.e;
        stringBuilder.append(n10);
        stringBuilder.append(", yawControlMaxRate=");
        n10 = this.f;
        stringBuilder.append(n10);
        stringBuilder.append(", pitchSmoothness=");
        n10 = this.g;
        stringBuilder.append(n10);
        stringBuilder.append(", rollSmoothness=");
        n10 = this.h;
        stringBuilder.append(n10);
        stringBuilder.append(", yawSmoothness=");
        n10 = this.i;
        stringBuilder.append(n10);
        stringBuilder.append(", pitchDeadband=");
        float f10 = this.j;
        stringBuilder.append(f10);
        stringBuilder.append(", rollDeadband=");
        f10 = this.k;
        stringBuilder.append(f10);
        stringBuilder.append(", yawDeadband=");
        f10 = this.l;
        stringBuilder.append(f10);
        stringBuilder.append(", reverse=");
        ae ae2 = this.m;
        stringBuilder.append(ae2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void u(int n10) {
        this.b = n10;
    }

    public void v(int n10) {
        this.h = n10;
    }

    public void w(int n10) {
        this.f = n10;
    }

    public void x(float f10) {
        this.l = f10;
    }

    public void y(int n10) {
        this.c = n10;
    }

    public void z(int n10) {
        this.i = n10;
    }
}

