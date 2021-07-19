/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.w0.g.a;
import e.a.w0.g.a$a;
import e.a.w0.g.a$c;
import e.a.w0.g.i;
import e.a.w0.g.i$a;
import java.util.concurrent.ThreadFactory;

public final class a$b
implements i {
    public final int a;
    public final a$c[] b;
    public long c;

    public a$b(int n10, ThreadFactory threadFactory) {
        this.a = n10;
        a$c[] a$cArray = new a$c[n10];
        this.b = a$cArray;
        a$cArray = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            a$c a$c;
            a$c[] a$cArray2 = this.b;
            a$cArray2[i10] = a$c = new a$c(threadFactory);
        }
    }

    public void a(int n10, i$a i$a) {
        int n11 = this.a;
        if (n11 == 0) {
            for (int i10 = 0; i10 < n10; ++i10) {
                a$c a$c = e.a.w0.g.a.i;
                i$a.a(i10, a$c);
            }
        } else {
            long l10;
            long l11 = this.c;
            int n12 = (int)l11 % n11;
            for (int i11 = 0; i11 < n10; ++i11) {
                a$c a$c = this.b[n12];
                a$a a$a = new a$a(a$c);
                i$a.a(i11, a$a);
                if (++n12 != n11) continue;
                n12 = 0;
            }
            this.c = l10 = (long)n12;
        }
    }

    public a$c b() {
        long l10;
        int n10 = this.a;
        if (n10 == 0) {
            return e.a.w0.g.a.i;
        }
        a$c[] a$cArray = this.b;
        long l11 = this.c;
        this.c = l10 = 1L + l11;
        l10 = n10;
        n10 = (int)(l11 % l10);
        return a$cArray[n10];
    }

    public void c() {
        for (a$c a$c : this.b) {
            a$c.dispose();
        }
    }
}

