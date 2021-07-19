/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.a;
import d.r.a.l;

public final class l$c
implements a {
    public final /* synthetic */ l a;

    public l$c(l l10) {
        this.a = l10;
    }

    public final void onStateChanged(int n10) {
        String string2 = "APP_TOKEN";
        if (n10 == 0) {
            String string3;
            l l10 = this.a;
            l10.j = string3 = "";
            l10.i.g(string2, string3);
            this.a.r();
            this.a.i.k("APP_TAGS");
            return;
        }
        l l11 = this.a;
        l11.j = null;
        l11.i.k(string2);
    }
}

