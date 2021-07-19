/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import androidx.core.util.Pair;
import d.v.e0.ce;
import d.v.e0.ie.l;

public class ce$m0
implements l {
    public final /* synthetic */ l a;
    public final /* synthetic */ ce b;

    public ce$m0(ce ce2, l l10) {
        this.b = ce2;
        this.a = l10;
    }

    public void onFailed(Throwable throwable) {
        l l10 = this.a;
        if (l10 != null) {
            l10.onFailed(throwable);
        }
    }

    public void s(Pair object) {
        l l10 = this.a;
        if (l10 == null) {
            return;
        }
        if (object == null) {
            object = Boolean.FALSE;
            l10.call(object);
        } else {
            object = Boolean.TRUE;
            l10.call(object);
        }
    }
}

