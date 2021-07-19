/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.h$c;
import d.r.a.l;
import d.r.a.o;

public final class l$b
implements Runnable {
    public final /* synthetic */ h$c a;
    public final /* synthetic */ String b;
    public final /* synthetic */ l c;

    public l$b(l l10, h$c h$c, String string2) {
        this.c = l10;
        this.a = h$c;
        this.b = string2;
    }

    public final void run() {
        l l10 = this.c;
        Object object = this.a;
        l10.e((o)object);
        l10 = this.c;
        object = this.b;
        l10.p((String)object);
    }
}

