/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

public class b {
    public int a;
    public int b;
    public int c;
    public float d;

    public b() {
        int n10 = -1;
        this(n10, n10, Float.MAX_VALUE);
    }

    public b(int n10, int n11, float f10) {
        this.a = n10;
        this.b = n11;
        this.c = -1;
        this.d = f10;
    }

    public b(int n10, int n11, int n12, float f10) {
        this.a = n10;
        this.b = n11;
        this.c = n12;
        this.d = f10;
    }

    public boolean a(b b10) {
        float f10 = this.d;
        float f11 = b10.d;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object < 0) {
            object = true;
            f11 = Float.MIN_VALUE;
        } else {
            object = false;
            f11 = 0.0f;
            b10 = null;
        }
        return (boolean)object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DMatch [queryIdx=");
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(", trainIdx=");
        n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(", imgIdx=");
        n10 = this.c;
        stringBuilder.append(n10);
        stringBuilder.append(", distance=");
        float f10 = this.d;
        stringBuilder.append(f10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

