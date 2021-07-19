/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.core.util.Pair;
import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.c.i1.h2;
import d.v.c.i1.h2$c;
import d.v.e.i.h;
import d.v.e.i.j;
import d.v.h.e.b;

public class h2$a
implements b {
    public final /* synthetic */ h2 a;

    public h2$a(h2 h22) {
        this.a = h22;
    }

    public void g(int n10, DecorationType decorationType) {
        int n11;
        Object object = h2$c.a;
        int n12 = decorationType.ordinal();
        n10 = object[n12];
        if (n10 != (n12 = 1) && n10 != (n11 = 2)) {
            n11 = 3;
            if (n10 == n11 || n10 == (n11 = 4)) {
                this.a.t2();
                object = this.a;
                long l10 = 524288L;
                h2.b((h2)object, n12 != 0, l10);
            }
        } else {
            this.a.s2();
            object = this.a;
            long l11 = 32768L;
            h2.b((h2)object, n12 != 0, l11);
        }
    }

    public void i() {
        j j10 = h2.c(this.a);
        Integer n10 = 0;
        Pair pair = new Pair(n10, null);
        h.g(j10, pair);
    }

    public void k(int n10, DecorationType object, int n11) {
        n10 = 1;
        if (n11 == n10) {
            int[] nArray = h2$c.a;
            int n12 = object.ordinal();
            if ((n12 = nArray[n12]) != n10 && n12 != (n11 = 2)) {
                n11 = 3;
                if (n12 == n11 || n12 == (n11 = 4)) {
                    object = this.a;
                    long l10 = 0x200000L;
                    h2.b((h2)object, n10 != 0, l10);
                }
            } else {
                object = this.a;
                long l11 = 131072L;
                h2.b((h2)object, n10 != 0, l11);
            }
        }
    }

    public void m(boolean bl2) {
        if (bl2) {
            h2 h22 = this.a;
            h22.I0();
        }
    }

    public void s(int n10, DecorationType decorationType) {
        j j10 = h2.c(this.a);
        Integer n11 = n10;
        Pair pair = new Pair(n11, (Object)decorationType);
        h.g(j10, pair);
    }

    public void u() {
    }
}

