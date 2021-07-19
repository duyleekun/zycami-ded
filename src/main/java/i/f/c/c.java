/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.u;

public class c {
    public u a;
    public float b;
    public float c;
    public float d;
    public int e;
    public int f;

    public c() {
        this(0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0, -1);
    }

    public c(float f10, float f11, float f12) {
        this(f10, f11, f12, -1.0f, 0.0f, 0, -1);
    }

    public c(float f10, float f11, float f12, float f13) {
        this(f10, f11, f12, f13, 0.0f, 0, -1);
    }

    public c(float f10, float f11, float f12, float f13, float f14) {
        this(f10, f11, f12, f13, f14, 0, -1);
    }

    public c(float f10, float f11, float f12, float f13, float f14, int n10) {
        this(f10, f11, f12, f13, f14, n10, -1);
    }

    public c(float f10, float f11, float f12, float f13, float f14, int n10, int n11) {
        u u10;
        double d10 = f10;
        double d11 = f11;
        this.a = u10 = new u(d10, d11);
        this.b = f12;
        this.c = f13;
        this.d = f14;
        this.e = n10;
        this.f = n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("KeyPoint [pt=");
        u u10 = this.a;
        stringBuilder.append(u10);
        stringBuilder.append(", size=");
        float f10 = this.b;
        stringBuilder.append(f10);
        stringBuilder.append(", angle=");
        f10 = this.c;
        stringBuilder.append(f10);
        stringBuilder.append(", response=");
        f10 = this.d;
        stringBuilder.append(f10);
        stringBuilder.append(", octave=");
        int n10 = this.e;
        stringBuilder.append(n10);
        stringBuilder.append(", class_id=");
        n10 = this.f;
        stringBuilder.append(n10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

