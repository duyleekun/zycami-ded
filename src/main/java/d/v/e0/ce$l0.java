/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import androidx.core.util.Pair;
import d.v.e0.ce;
import d.v.e0.ie.l;

public class ce$l0
implements l {
    public final /* synthetic */ l a;
    public final /* synthetic */ ce b;

    public ce$l0(ce ce2, l l10) {
        this.b = ce2;
        this.a = l10;
    }

    public void onFailed(Throwable throwable) {
        this.a.onFailed(throwable);
    }

    public void s(Pair object) {
        if (object == null) {
            object = this.a;
            int n10 = -1;
            Integer n11 = n10;
            object.call(n11);
        } else {
            l l10 = this.a;
            object = ((Pair)object).second;
            l10.call(object);
        }
    }
}

