/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.l;
import d.r.a.l$f;

public final class l$e
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ l b;

    public l$e(l l10, String string2) {
        this.b = l10;
        this.a = string2;
    }

    public final void run() {
        Object object = this.b;
        String string2 = this.a;
        if ((object = ((l)object).l(string2)) != null) {
            int n10 = 1003;
            Object[] objectArray = new Object[]{};
            ((l$f)object).b(n10, objectArray);
        }
    }
}

