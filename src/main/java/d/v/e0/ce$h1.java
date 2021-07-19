/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce;
import d.v.e0.ce$h1$a;
import d.v.e0.ie.d;
import d.v.e0.oe.q;
import e.a.e0;
import e.a.v0.o;
import e.a.z;
import java.util.List;

public class ce$h1
implements o {
    public final /* synthetic */ int[] a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ d c;
    public final /* synthetic */ ce d;

    public ce$h1(ce ce2, int[] nArray, boolean bl2, d d10) {
        this.d = ce2;
        this.a = nArray;
        this.b = bl2;
        this.c = d10;
    }

    public e0 a(List list) {
        int[] nArray = this.a;
        int n10 = 3;
        Object object = null;
        nArray[n10] = 0;
        int n11 = this.b;
        n11 = n11 != 0 ? 4 : 1;
        n10 = list.size();
        object = new StringBuilder();
        ((StringBuilder)object).append("maxConcurrency = ");
        ((StringBuilder)object).append(n11);
        q.i(((StringBuilder)object).toString());
        q.i("Start write Fw data ");
        object = z.W2(list);
        ce$h1$a ce$h1$a = new ce$h1$a(this, list, n10);
        return ((z)object).t2(ce$h1$a, n11);
    }
}

