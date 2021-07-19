/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.l2.f;

public final class e
implements f {
    private final float a;
    private final float b;

    public e(float f10, float f11) {
        this.a = f10;
        this.b = f11;
    }

    public boolean a(float f10) {
        float f11;
        int n10;
        float f12 = this.a;
        float f13 = f10 - f12;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object >= 0 && (n10 = (f11 = f10 - (f12 = this.b)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) <= 0) {
            n10 = 1;
            f10 = Float.MIN_VALUE;
        } else {
            n10 = 0;
            f10 = 0.0f;
        }
        return n10 != 0;
    }

    public Float d() {
        return Float.valueOf(this.b);
    }

    public Float e() {
        return Float.valueOf(this.a);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        boolean bl2 = object instanceof e;
        if (!bl2) return false;
        boolean bl3 = this.isEmpty();
        if (bl3) {
            Object object2 = object;
            object2 = (e)object;
            boolean bl4 = ((e)object2).isEmpty();
            if (bl4) return true;
        }
        float f10 = this.a;
        object = (e)object;
        float f11 = ((e)object).a;
        float f12 = f10 - f11;
        Object object3 = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object3 != false) return false;
        f10 = this.b;
        float f13 = ((e)object).b;
        float f14 = f10 - f13;
        Object object4 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (object4) return false;
        return true;
    }

    public boolean f(float f10, float f11) {
        Object object = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
        if (object <= 0) {
            object = true;
            f10 = Float.MIN_VALUE;
        } else {
            object = false;
            f10 = 0.0f;
        }
        return (boolean)object;
    }

    public int hashCode() {
        int n10 = this.isEmpty();
        if (n10 != 0) {
            n10 = -1;
            float f10 = 0.0f / 0.0f;
        } else {
            float f11 = this.a;
            Float f12 = Float.valueOf(f11);
            n10 = ((Object)f12).hashCode() * 31;
            float f13 = this.b;
            Float f14 = Float.valueOf(f13);
            int n11 = ((Object)f14).hashCode();
            n10 += n11;
        }
        return n10;
    }

    public boolean isEmpty() {
        float f10 = this.a;
        float f11 = this.b;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object > 0) {
            object = true;
            f10 = Float.MIN_VALUE;
        } else {
            object = false;
            f10 = 0.0f;
        }
        return (boolean)object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        float f10 = this.a;
        stringBuilder.append(f10);
        stringBuilder.append("..");
        f10 = this.b;
        stringBuilder.append(f10);
        return stringBuilder.toString();
    }
}

