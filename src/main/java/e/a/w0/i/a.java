/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.i;

import e.a.g0;
import e.a.w0.i.a$a;
import i.g.d;
import io.reactivex.internal.util.NotificationLite;

public class a {
    public final int a;
    public final Object[] b;
    public Object[] c;
    public int d;

    public a(int n10) {
        this.a = n10;
        Object[] objectArray = new Object[n10 + 1];
        this.b = objectArray;
        this.c = objectArray;
    }

    public boolean a(g0 g02) {
        Object[] objectArray = this.b;
        int n10 = this.a;
        while (true) {
            Object object;
            if (objectArray == null) break;
            for (int i10 = 0; i10 < n10 && (object = objectArray[i10]) != null; ++i10) {
                boolean bl2 = NotificationLite.acceptFull(object, g02);
                if (!bl2) continue;
                return true;
            }
            objectArray = (Object[])objectArray[n10];
        }
        return false;
    }

    public boolean b(d d10) {
        Object[] objectArray = this.b;
        int n10 = this.a;
        while (true) {
            Object object;
            if (objectArray == null) break;
            for (int i10 = 0; i10 < n10 && (object = objectArray[i10]) != null; ++i10) {
                boolean bl2 = NotificationLite.acceptFull(object, d10);
                if (!bl2) continue;
                return true;
            }
            objectArray = (Object[])objectArray[n10];
        }
        return false;
    }

    public void c(Object object) {
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

    public void d(a$a a$a) {
        Object[] objectArray = this.b;
        int n10 = this.a;
        while (objectArray != null) {
            Object object;
            for (int i10 = 0; i10 < n10 && (object = objectArray[i10]) != null; ++i10) {
                boolean bl2 = a$a.test(object);
                if (!bl2) continue;
                return;
            }
            objectArray = (Object[])objectArray[n10];
        }
    }

    public void e(Object object, e.a.v0.d d10) {
        Object[] objectArray = this.b;
        int n10 = this.a;
        while (true) {
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object2 = objectArray[i10];
                if (object2 == null) {
                    return;
                }
                boolean bl2 = d10.a(object, object2);
                if (!bl2) continue;
                return;
            }
            objectArray = (Object[])objectArray[n10];
        }
    }

    public void f(Object object) {
        this.b[0] = object;
    }
}

