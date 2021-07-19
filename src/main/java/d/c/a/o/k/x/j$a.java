/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.x;

import d.c.a.o.k.x.j$b;
import d.c.a.o.k.x.m;

public final class j$a
implements m {
    private final j$b a;
    public int b;
    private Class c;

    public j$a(j$b b10) {
        this.a = b10;
    }

    public void a() {
        this.a.c(this);
    }

    public void b(int n10, Class clazz) {
        this.b = n10;
        this.c = clazz;
    }

    public boolean equals(Object object) {
        int n10 = object instanceof j$a;
        boolean bl2 = false;
        if (n10 != 0) {
            Class clazz;
            object = (j$a)object;
            n10 = this.b;
            int n11 = ((j$a)object).b;
            if (n10 == n11 && (clazz = this.c) == (object = ((j$a)object).c)) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        int n10;
        int n11 = this.b * 31;
        Class clazz = this.c;
        if (clazz != null) {
            n10 = clazz.hashCode();
        } else {
            n10 = 0;
            clazz = null;
        }
        return n11 + n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Key{size=");
        int n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append("array=");
        Class clazz = this.c;
        stringBuilder.append(clazz);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

