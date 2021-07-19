/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.x1.a1;
import f.x1.b;

public final class a1$a
extends b {
    private int c;
    private int d;
    public final /* synthetic */ a1 e;

    public a1$a(a1 a12) {
        int n10;
        int n11;
        this.e = a12;
        this.c = n11 = a12.size();
        this.d = n10 = a1.h(a12);
    }

    public void b() {
        int n10 = this.c;
        if (n10 == 0) {
            this.c();
        } else {
            Object object = a1.e(this.e);
            int n11 = this.d;
            object = object[n11];
            this.e(object);
            object = this.e;
            n11 = this.d + 1;
            n10 = a1.f((a1)object);
            this.d = n11 %= n10;
            this.c = n10 = this.c + -1;
        }
    }
}

