/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.u;

import d.c.a.u.m;

public class j {
    private Class a;
    private Class b;
    private Class c;

    public j() {
    }

    public j(Class clazz, Class clazz2) {
        this.a(clazz, clazz2);
    }

    public j(Class clazz, Class clazz2, Class clazz3) {
        this.b(clazz, clazz2, clazz3);
    }

    public void a(Class clazz, Class clazz2) {
        this.b(clazz, clazz2, null);
    }

    public void b(Class clazz, Class clazz2, Class clazz3) {
        this.a = clazz;
        this.b = clazz2;
        this.c = clazz3;
    }

    public boolean equals(Object object) {
        Class clazz;
        Class clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = this.getClass()) == (clazz = object.getClass())) {
            object = (j)object;
            clazz2 = this.a;
            clazz = ((j)object).a;
            boolean bl3 = clazz2.equals(clazz);
            if (!bl3) {
                return false;
            }
            clazz2 = this.b;
            clazz = ((j)object).b;
            bl3 = clazz2.equals(clazz);
            if (!bl3) {
                return false;
            }
            clazz2 = this.c;
            object = ((j)object).c;
            boolean bl4 = m.d(clazz2, object);
            if (!bl4) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        Class clazz = this.a;
        int n10 = clazz.hashCode() * 31;
        int n11 = this.b.hashCode();
        n10 = (n10 + n11) * 31;
        Class clazz2 = this.c;
        if (clazz2 != null) {
            n11 = clazz2.hashCode();
        } else {
            n11 = 0;
            clazz2 = null;
        }
        return n10 + n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MultiClassKey{first=");
        Class clazz = this.a;
        stringBuilder.append(clazz);
        stringBuilder.append(", second=");
        clazz = this.b;
        stringBuilder.append(clazz);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

