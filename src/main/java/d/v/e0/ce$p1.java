/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import androidx.core.util.Pair;
import d.v.e0.ce;
import d.v.e0.oe.q;
import e.a.e0;
import e.a.v0.o;
import e.a.z;

public class ce$p1
implements o {
    public final /* synthetic */ int[] a;
    public final /* synthetic */ ce b;

    public ce$p1(ce ce2, int[] nArray) {
        this.b = ce2;
        this.a = nArray;
    }

    public e0 a(Pair pair) {
        int[] nArray = this.a;
        int n10 = nArray[0];
        int n11 = 1;
        if (n10 == n11) {
            q.i("[addr ==1, invoke mStabilizer.byPass()]");
            return ce.s(this.b).O1();
        }
        return z.t3(pair);
    }
}

