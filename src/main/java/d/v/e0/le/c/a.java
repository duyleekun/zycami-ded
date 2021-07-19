/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.le.c;

import com.zhiyun.net.BaseEntity;

public class a
extends BaseEntity {
    private int A;
    private String B;
    private int C;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private long f;
    private String g;
    private String h;
    private int i;
    private int j;
    private double k;
    private double l;
    private double m;
    private double n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private double t;
    private double u;
    private double v;
    private double w;
    private double x;
    private int y;
    private int z;

    public int A() {
        return this.o;
    }

    public double B() {
        return this.w;
    }

    public double C() {
        return this.x;
    }

    public void D(double d10) {
        this.m = d10;
    }

    public void E(String string2) {
        this.h = string2;
    }

    public void F(String string2) {
        this.g = string2;
    }

    public void G(int n10) {
        this.s = n10;
    }

    public void H(String string2) {
        this.B = string2;
    }

    public void I(double d10) {
        this.n = d10;
    }

    public void J(int n10) {
        this.errcode = n10;
    }

    public void K(String string2) {
        this.errmsg = string2;
    }

    public void L(int n10) {
        this.q = n10;
    }

    public void M(double d10) {
        this.l = d10;
    }

    public void N(int n10) {
        this.j = n10;
    }

    public void O(double d10) {
        this.k = d10;
    }

    public void P(double d10) {
        this.v = d10;
    }

    public void Q(double d10) {
        this.t = d10;
    }

    public void R(double d10) {
        this.u = d10;
    }

    public void S(int n10) {
        this.r = n10;
    }

    public void T(String string2) {
        this.b = string2;
    }

    public void U(int n10) {
        this.i = n10;
    }

    public void V(int n10) {
        this.p = n10;
    }

    public void W(int n10) {
        this.C = n10;
    }

    public void X(String string2) {
        this.d = string2;
    }

    public void Y(int n10) {
        this.y = n10;
    }

    public void Z(long l10) {
        this.f = l10;
    }

    public double a() {
        return this.m;
    }

    public void a0(String string2) {
        this.c = string2;
    }

    public String b() {
        return this.h;
    }

    public void b0(int n10) {
        this.A = n10;
    }

    public String c() {
        return this.g;
    }

    public void c0(int n10) {
        this.z = n10;
    }

    public int d() {
        return this.s;
    }

    public void d0(int n10) {
        this.o = n10;
    }

    public String e() {
        return this.B;
    }

    public void e0(double d10) {
        this.w = d10;
    }

    public double f() {
        return this.n;
    }

    public void f0(double d10) {
        this.x = d10;
    }

    public int g() {
        return this.errcode;
    }

    public String getCreateAt() {
        return this.e;
    }

    public String getName() {
        return this.a;
    }

    public String h() {
        return this.errmsg;
    }

    public int i() {
        return this.q;
    }

    public double j() {
        return this.l;
    }

    public int k() {
        return this.j;
    }

    public double l() {
        return this.k;
    }

    public double m() {
        return this.v;
    }

    public double n() {
        return this.t;
    }

    public double o() {
        return this.u;
    }

    public int p() {
        return this.r;
    }

    public String q() {
        return this.b;
    }

    public int r() {
        return this.i;
    }

    public int s() {
        return this.p;
    }

    public void setCreateAt(String string2) {
        this.e = string2;
    }

    public void setName(String string2) {
        this.a = string2;
    }

    public int t() {
        return this.C;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("FileDetail{name='");
        String string2 = this.a;
        stringBuilder.append(string2);
        int n10 = 39;
        stringBuilder.append((char)n10);
        stringBuilder.append(", id='");
        String string3 = this.b;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", thumbnail='");
        string3 = this.c;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", path='");
        string3 = this.d;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", createAt='");
        string3 = this.e;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", size=");
        long l10 = this.f;
        stringBuilder.append(l10);
        stringBuilder.append(", CameraModel='");
        string3 = this.g;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", CameraMake='");
        string3 = this.h;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", IsColor=");
        int n11 = this.i;
        stringBuilder.append(n11);
        stringBuilder.append(", FlashUsed=");
        n11 = this.j;
        stringBuilder.append(n11);
        stringBuilder.append(", FocalLength=");
        double d10 = this.k;
        stringBuilder.append(d10);
        stringBuilder.append(", ExposureTime=");
        d10 = this.l;
        stringBuilder.append(d10);
        stringBuilder.append(", ApertureFNumber=");
        d10 = this.m;
        stringBuilder.append(d10);
        stringBuilder.append(", Distance=");
        d10 = this.n;
        stringBuilder.append(d10);
        stringBuilder.append(", Whitebalance=");
        n11 = this.o;
        stringBuilder.append(n11);
        stringBuilder.append(", MeteringMode=");
        n11 = this.p;
        stringBuilder.append(n11);
        stringBuilder.append(", ExposureProgram=");
        n11 = this.q;
        stringBuilder.append(n11);
        stringBuilder.append(", ISOequivalent=");
        n11 = this.r;
        stringBuilder.append(n11);
        stringBuilder.append(", CompressionLevel=");
        n11 = this.s;
        stringBuilder.append(n11);
        stringBuilder.append(", FocalplaneXRes=");
        d10 = this.t;
        stringBuilder.append(d10);
        stringBuilder.append(", FocalplaneYRes=");
        d10 = this.u;
        stringBuilder.append(d10);
        stringBuilder.append(", FocalplaneUnits=");
        d10 = this.v;
        stringBuilder.append(d10);
        stringBuilder.append(", Xresolution=");
        d10 = this.w;
        stringBuilder.append(d10);
        stringBuilder.append(", Yresolution=");
        d10 = this.x;
        stringBuilder.append(d10);
        stringBuilder.append(", ResolutionUnit=");
        n11 = this.y;
        stringBuilder.append(n11);
        stringBuilder.append(", ThumbnailSize=");
        n11 = this.z;
        stringBuilder.append(n11);
        stringBuilder.append(", ThumbnailOffset=");
        n11 = this.A;
        stringBuilder.append(n11);
        stringBuilder.append(", DateTimeDigitized='");
        string3 = this.B;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", Onlineplay=");
        n10 = this.C;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public String u() {
        return this.d;
    }

    public int v() {
        return this.y;
    }

    public long w() {
        return this.f;
    }

    public String x() {
        return this.c;
    }

    public int y() {
        return this.A;
    }

    public int z() {
        return this.z;
    }
}

