/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

public class yd {
    public static final int e = 65535;
    private float a;
    private float b;
    private float c;
    private int d;

    public yd() {
        float f10 = 65535.0f;
        this(f10, f10, f10);
    }

    public yd(float f10, float f11, float f12) {
        this.a = f10;
        this.b = f11;
        this.c = f12;
    }

    public static boolean e(float f10) {
        float f11 = 65535.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            object = true;
            f10 = Float.MIN_VALUE;
        } else {
            object = false;
            f10 = 0.0f;
        }
        return (boolean)object;
    }

    public float a() {
        return this.c;
    }

    public float b() {
        return this.b;
    }

    public int c() {
        return this.d;
    }

    public float d() {
        return this.a;
    }

    public void f(float f10) {
        this.c = f10;
    }

    public void g(float f10) {
        this.b = f10;
    }

    public void h(int n10) {
        this.d = n10;
    }

    public void i(float f10) {
        this.a = f10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Point{yaw=");
        float f10 = this.a;
        stringBuilder.append(f10);
        stringBuilder.append(", roll=");
        f10 = this.b;
        stringBuilder.append(f10);
        stringBuilder.append(", pitch=");
        f10 = this.c;
        stringBuilder.append(f10);
        stringBuilder.append(", time=");
        int n10 = this.d;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

