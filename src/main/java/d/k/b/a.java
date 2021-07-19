/*
 * Decompiled with CFR 0.151.
 */
package d.k.b;

import d.k.b.a$a;
import d.k.b.c;

public class a {
    private final int a;
    private final Object[] b;
    private Object[] c;
    private int d;

    public a(int n10) {
        this.a = n10;
        Object[] objectArray = new Object[n10 + 1];
        this.b = objectArray;
        this.c = objectArray;
    }

    public void a(c c10) {
        Object[] objectArray = this.b;
        int n10 = this.a;
        while (objectArray != null) {
            Object object;
            for (int i10 = 0; i10 < n10 && (object = objectArray[i10]) != null; ++i10) {
                c10.accept(object);
            }
            objectArray = (Object[])objectArray[n10];
        }
    }

    public void b(Object object) {
        int n10 = this.d;
        int n11 = this.a;
        if (n10 == n11) {
            Object[] objectArray = new Object[n11 + 1];
            Object[] objectArray2 = this.c;
            objectArray2[n11] = objectArray;
            this.c = objectArray;
            n10 = 0;
            objectArray = null;
        }
        this.c[n10] = object;
        this.d = ++n10;
    }

    public void c(a$a a$a) {
        Object[] objectArray = this.b;
        int n10 = this.a;
        while (objectArray != null) {
            boolean bl2;
            Object object;
            for (int i10 = 0; i10 < n10 && (object = objectArray[i10]) != null && !(bl2 = a$a.test(object)); ++i10) {
            }
            objectArray = (Object[])objectArray[n10];
        }
    }
}

