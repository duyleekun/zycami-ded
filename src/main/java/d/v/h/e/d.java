/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package d.v.h.e;

import android.util.Size;
import com.zhiyun.editorinterface.edit.MediaType;
import d.v.h.e.a;
import d.v.h.k.b;

public class d
extends a {
    private d.v.h.f.a A;
    private int B;
    private String C;
    private boolean D;
    private boolean E;
    private long h;
    private long i;
    private double j = 1.0;
    private float k;
    private boolean l;
    private int m;
    private int n;
    private String o;
    private Size p;
    private int q;
    private int r;
    private int s;
    private float t;
    private float u;
    private float v;
    private float w;
    private String x;
    private float y;
    private b z;

    public d() {
        float f10;
        this.k = f10 = 1.0f;
        this.t = f10;
        this.u = f10;
        this.y = f10;
        Object object = new b();
        this.z = object;
        this.A = object = new d.v.h.f.a();
        this.x = "0.5,0.5";
    }

    public int A() {
        return this.B;
    }

    public int B() {
        return this.s;
    }

    public String E() {
        boolean bl2 = this.j();
        String string2 = bl2 ? this.g() : this.e();
        return string2;
    }

    public int F() {
        return this.r;
    }

    public float G() {
        return this.t;
    }

    public float H() {
        return this.u;
    }

    public double I() {
        return this.j;
    }

    public long J() {
        return this.h;
    }

    public String K() {
        return this.o;
    }

    public float L() {
        return this.v;
    }

    public float M() {
        return this.w;
    }

    public b N() {
        return this.z;
    }

    public float O() {
        return this.k;
    }

    public boolean P() {
        return this.E;
    }

    public boolean Q() {
        return this.l;
    }

    public boolean R() {
        return this.D;
    }

    public d T(float f10) {
        this.y = f10;
        return this;
    }

    public d U(String string2) {
        this.x = string2;
        return this;
    }

    public d V(String string2) {
        this.C = string2;
        return this;
    }

    public d W(long l10) {
        this.i = l10;
        return this;
    }

    public d X(boolean bl2) {
        this.E = bl2;
        return this;
    }

    public d Y(int n10) {
        this.m = n10;
        return this;
    }

    public d Z(d.v.h.f.a a10) {
        this.A = a10;
        return this;
    }

    public d a0(int n10) {
        this.n = n10;
        return this;
    }

    public d b0(int n10) {
        this.q = n10;
        return this;
    }

    public d c0(Size size) {
        this.p = size;
        return this;
    }

    public d d0(int n10) {
        this.B = n10;
        return this;
    }

    public d e0(int n10) {
        this.s = n10;
        return this;
    }

    public d f0(boolean bl2) {
        this.l = bl2;
        return this;
    }

    public d g0(int n10) {
        this.r = n10;
        return this;
    }

    public d h0(float f10) {
        this.t = f10;
        return this;
    }

    public d i0(float f10) {
        this.u = f10;
        return this;
    }

    public d j0(double d10) {
        this.j = d10;
        return this;
    }

    public d k0(long l10) {
        this.h = l10;
        return this;
    }

    public d l0(String string2) {
        this.o = string2;
        return this;
    }

    public d m0(float f10) {
        this.v = f10;
        return this;
    }

    public d n0(float f10) {
        this.w = f10;
        return this;
    }

    public d o0(b b10) {
        this.z = b10;
        return this;
    }

    public d p0(boolean bl2) {
        this.D = bl2;
        return this;
    }

    public d q() {
        d d10 = new d();
        long l10 = this.u();
        d10 = d10.W(l10);
        l10 = this.J();
        d10 = d10.k0(l10);
        float f10 = this.r();
        d10 = d10.T(f10);
        int bl2 = this.v();
        d10 = d10.Y(bl2);
        Object object = this.w().a();
        d10 = d10.Z((d.v.h.f.a)object);
        int n10 = this.x();
        d10 = d10.a0(n10);
        int n11 = this.y();
        d10 = d10.b0(n11);
        int n12 = this.F();
        d10 = d10.g0(n12);
        int n13 = this.B();
        d10 = d10.e0(n13);
        f10 = this.G();
        d10 = d10.h0(f10);
        f10 = this.H();
        d10 = d10.i0(f10);
        f10 = this.L();
        d10 = d10.m0(f10);
        f10 = this.M();
        d10 = d10.n0(f10);
        object = this.s();
        d10 = d10.U((String)object);
        object = this.z();
        d10 = d10.c0((Size)object);
        boolean bl3 = this.Q();
        d10 = d10.f0(bl3);
        double d11 = this.I();
        d10 = d10.j0(d11);
        object = this.K();
        d10 = d10.l0((String)object);
        object = this.N();
        d10 = d10.o0((b)object);
        f10 = this.O();
        d10 = d10.q0(f10);
        object = this.t();
        d10 = d10.V((String)object);
        boolean bl4 = this.R();
        d10 = d10.p0(bl4);
        int n14 = this.A();
        d10 = d10.d0(n14);
        boolean bl5 = this.P();
        d10 = d10.X(bl5);
        l10 = this.d();
        object = d10.k(l10);
        Object object2 = this.e();
        object = ((a)object).l((String)object2);
        object2 = this.f();
        object = ((a)object).m((MediaType)((Object)object2));
        object2 = this.i();
        object = ((a)object).p((String)object2);
        boolean bl6 = this.j();
        object = ((a)object).n(bl6);
        object2 = this.g();
        ((a)object).o((String)object2);
        return d10;
    }

    public d q0(float f10) {
        this.k = f10;
        return this;
    }

    public float r() {
        return this.y;
    }

    public String s() {
        return this.x;
    }

    public String t() {
        return this.C;
    }

    public long u() {
        return this.i;
    }

    public int v() {
        return this.m;
    }

    public d.v.h.f.a w() {
        return this.A;
    }

    public int x() {
        return this.n;
    }

    public int y() {
        return this.q;
    }

    public Size z() {
        return this.p;
    }
}

