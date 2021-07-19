/*
 * Decompiled with CFR 0.151.
 */
package d.t.a.g;

public class c {
    private int a;
    private int b;
    private int c;

    public c(int n10, int n11, int n12) {
        this.a = n10;
        this.b = n11;
        this.c = n12;
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.c;
    }

    public void d(int n10) {
        this.b = n10;
    }

    public void e(int n10) {
        this.a = n10;
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<?> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = this.getClass()) == (clazz = object.getClass())) {
            object = (c)object;
            int n10 = this.a;
            int n11 = ((c)object).a;
            if (n10 != n11) {
                return false;
            }
            n10 = this.b;
            n11 = ((c)object).b;
            if (n10 != n11) {
                return false;
            }
            n10 = this.c;
            int n12 = ((c)object).c;
            if (n10 != n12) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public void f(int n10) {
        this.c = n10;
    }

    public int hashCode() {
        int n10 = this.a * 31;
        int n11 = this.b;
        n10 = (n10 + n11) * 31;
        n11 = this.c;
        return n10 + n11;
    }
}

