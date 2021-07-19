/*
 * Decompiled with CFR 0.151.
 */
package f.h2.t;

import f.h2.t.f0;

public abstract class m0 {
    private int a;
    private final Object[] b;
    private final int c;

    public m0(int n10) {
        this.c = n10;
        Object[] objectArray = new Object[n10];
        this.b = objectArray;
    }

    private static /* synthetic */ void d() {
    }

    public final void a(Object object) {
        int n10;
        f0.p(object, "spreadArgument");
        Object[] objectArray = this.b;
        int n11 = this.a;
        this.a = n10 = n11 + 1;
        objectArray[n11] = object;
    }

    public final int b() {
        return this.a;
    }

    public abstract int c(Object var1);

    public final void e(int n10) {
        this.a = n10;
    }

    public final int f() {
        int n10 = this.c;
        int n11 = 1;
        int n12 = 0;
        if ((n10 -= n11) >= 0) {
            int n13 = 0;
            while (true) {
                Object object;
                int n14 = (object = this.b[n13]) != null ? this.c(object) : n11;
                n12 += n14;
                if (n13 == n10) break;
                ++n13;
            }
        }
        return n12;
    }

    public final Object g(Object object, Object object2) {
        int n10;
        f0.p(object, "values");
        String string2 = "result";
        f0.p(object2, string2);
        int n11 = this.c + -1;
        int n12 = 0;
        if (n11 >= 0) {
            int n13 = 0;
            int n14 = 0;
            n10 = 0;
            while (true) {
                Object object3;
                if ((object3 = this.b[n13]) != null) {
                    if (n14 < n13) {
                        int n15 = n13 - n14;
                        System.arraycopy(object, n14, object2, n10, n15);
                        n10 += n15;
                    }
                    n14 = this.c(object3);
                    System.arraycopy(object3, 0, object2, n10, n14);
                    n10 += n14;
                    n14 = n13 + 1;
                }
                if (n13 == n11) break;
                ++n13;
            }
            n12 = n14;
        } else {
            n10 = 0;
        }
        n11 = this.c;
        if (n12 < n11) {
            System.arraycopy(object, n12, object2, n10, n11 -= n12);
        }
        return object2;
    }
}

