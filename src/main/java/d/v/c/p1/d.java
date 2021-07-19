/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.p1;

public class d {
    private float a;
    private float b;
    private int c;
    private float d;
    private float e;
    private int f;

    public d() {
        float f10;
        this.a = f10 = 1.0f;
        this.b = f10;
        this.c = 0;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0;
    }

    public d(float f10, float f11, int n10, float f12, float f13, int n11) {
        this.a = f10;
        this.b = f11;
        this.c = n10;
        this.d = f12;
        this.e = f13;
        this.f = n11;
    }

    public d a() {
        float f10 = this.d();
        float f11 = this.e();
        int n10 = this.c();
        float f12 = this.f();
        float f13 = this.g();
        int n11 = this.b();
        d d10 = new d(f10, f11, n10, f12, f13, n11);
        return d10;
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.c;
    }

    public float d() {
        return this.a;
    }

    public float e() {
        return this.b;
    }

    public float f() {
        return this.d;
    }

    public float g() {
        return this.e;
    }

    public d h(int n10) {
        this.f = n10;
        return this;
    }

    public d i(int n10) {
        this.c = n10;
        return this;
    }

    public d j(float f10) {
        this.a = f10;
        return this;
    }

    public d k(float f10) {
        this.b = f10;
        return this;
    }

    public d l(float f10) {
        this.d = f10;
        return this;
    }

    public d m(float f10) {
        this.e = f10;
        return this;
    }
}

