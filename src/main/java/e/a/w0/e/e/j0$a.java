/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.w0.b.a;
import e.a.w0.d.b;

public final class j0$a
extends b {
    public final g0 a;
    public final Object[] b;
    public int c;
    public boolean d;
    public volatile boolean e;

    public j0$a(g0 g02, Object[] objectArray) {
        this.a = g02;
        this.b = objectArray;
    }

    public void a() {
        boolean bl2;
        Object object = this.b;
        int n10 = ((Object[])object).length;
        String string2 = null;
        for (int i10 = 0; i10 < n10 && !(bl2 = this.isDisposed()); ++i10) {
            Object object2 = object[i10];
            if (object2 == null) {
                object = this.a;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("The element at index ");
                ((StringBuilder)object2).append(i10);
                ((StringBuilder)object2).append(" is null");
                string2 = ((StringBuilder)object2).toString();
                NullPointerException nullPointerException = new NullPointerException(string2);
                object.onError(nullPointerException);
                return;
            }
            g0 g02 = this.a;
            g02.onNext(object2);
        }
        boolean bl3 = this.isDisposed();
        if (!bl3) {
            object = this.a;
            object.onComplete();
        }
    }

    public void clear() {
        int n10;
        this.c = n10 = this.b.length;
    }

    public void dispose() {
        this.e = true;
    }

    public boolean isDisposed() {
        return this.e;
    }

    public boolean isEmpty() {
        int n10 = this.c;
        Object[] objectArray = this.b;
        int n11 = objectArray.length;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public Object poll() {
        int n10 = this.c;
        Object[] objectArray = this.b;
        int n11 = objectArray.length;
        if (n10 != n11) {
            this.c = n11 = n10 + 1;
            return e.a.w0.b.a.g(objectArray[n10], "The array element is null");
        }
        return null;
    }

    public int requestFusion(int n10) {
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            this.d = n11;
            return n11;
        }
        return 0;
    }
}

