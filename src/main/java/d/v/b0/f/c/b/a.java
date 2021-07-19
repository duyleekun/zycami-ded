/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.f.c.b;

import d.v.b0.f.c.b.e;
import java.nio.FloatBuffer;

public class a {
    public static final int d = 4;
    public static final int e = 2;
    public static final int f = 8;
    public static final int g = 8;
    private FloatBuffer a;
    private FloatBuffer b;
    private int c;

    public a() {
    }

    public a(float[] fArray) {
        this.c(fArray);
    }

    public a(float[] fArray, float[] fArray2) {
        this.c(fArray);
        this.b(fArray2);
    }

    public FloatBuffer a() {
        return this.a;
    }

    public void b(float[] object) {
        object = d.v.b0.f.c.b.e.f(object);
        this.a = object;
    }

    public void c(float[] fArray) {
        int n10;
        FloatBuffer floatBuffer;
        this.b = floatBuffer = d.v.b0.f.c.b.e.f(fArray);
        this.c = n10 = fArray.length / 2;
    }

    public FloatBuffer d() {
        return this.b;
    }

    public int e() {
        return this.c;
    }
}

