/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.i;

import e.a.w0.i.l;

public final class k {
    private static final int f = -1640531527;
    public final float a;
    public int b;
    public int c;
    public int d;
    public Object[] e;

    public k() {
        this(16, 0.75f);
    }

    public k(int n10) {
        this(n10, 0.75f);
    }

    public k(int n10, float f10) {
        int n11;
        int n12;
        this.a = f10;
        n10 = l.b(n10);
        this.b = n12 = n10 + -1;
        float f11 = n10;
        this.d = n11 = (int)(f10 * f11);
        Object[] objectArray = new Object[n10];
        this.e = objectArray;
    }

    public static int c(int n10) {
        int n11 = (n10 *= -1640531527) >>> 16;
        return n10 ^ n11;
    }

    public boolean a(Object object) {
        int n10;
        Object[] objectArray = this.e;
        int n11 = this.b;
        int n12 = k.c(object.hashCode()) & n11;
        Object object2 = objectArray[n12];
        int n13 = 1;
        if (object2 != null) {
            boolean bl2 = object2.equals(object);
            if (bl2) {
                return false;
            }
            while ((object2 = objectArray[n12 = n12 + n13 & n11]) != null) {
                bl2 = object2.equals(object);
                if (!bl2) continue;
                return false;
            }
        }
        objectArray[n12] = object;
        this.c = n10 = this.c + n13;
        int n14 = this.d;
        if (n10 >= n14) {
            this.d();
        }
        return n13 != 0;
    }

    public Object[] b() {
        return this.e;
    }

    public void d() {
        int n10;
        Object[] objectArray = this.e;
        int n11 = objectArray.length;
        int n12 = n11 << 1;
        int n13 = n12 + -1;
        Object[] objectArray2 = new Object[n12];
        int n14 = this.c;
        while (true) {
            Object object;
            int n15 = n14 + -1;
            if (n14 == 0) break;
            while ((object = objectArray[n11 += -1]) == null) {
            }
            object = objectArray[n11];
            n14 = k.c(object.hashCode()) & n13;
            Object object2 = objectArray2[n14];
            if (object2 != null) {
                while ((object2 = objectArray2[n14 = n14 + 1 & n13]) != null) {
                }
            }
            objectArray2[n14] = object2 = objectArray[n11];
            n14 = n15;
        }
        this.b = n13;
        float f10 = n12;
        float f11 = this.a;
        this.d = n10 = (int)(f10 * f11);
        this.e = objectArray2;
    }

    public boolean e(Object object) {
        Object[] objectArray = this.e;
        int n10 = this.b;
        int n11 = k.c(object.hashCode()) & n10;
        Object object2 = objectArray[n11];
        if (object2 == null) {
            return false;
        }
        boolean bl2 = object2.equals(object);
        if (bl2) {
            return this.f(n11, objectArray, n10);
        }
        do {
            if ((object2 = objectArray[n11 = n11 + 1 & n10]) != null) continue;
            return false;
        } while (!(bl2 = object2.equals(object)));
        return this.f(n11, objectArray, n10);
    }

    public boolean f(int n10, Object[] objectArray, int n11) {
        int n12 = this.c;
        int n13 = 1;
        this.c = n12 -= n13;
        block0: while (true) {
            n12 = n10 + 1;
            while (true) {
                Object object;
                if ((object = objectArray[n12 &= n11]) == null) {
                    objectArray[n10] = null;
                    return n13 != 0;
                }
                int n14 = k.c(object.hashCode()) & n11;
                if (n10 <= n12 ? n10 >= n14 || n14 > n12 : n10 >= n14 && n14 > n12) {
                    objectArray[n10] = object;
                    n10 = n12;
                    continue block0;
                }
                ++n12;
            }
            break;
        }
    }

    public int g() {
        return this.c;
    }
}

