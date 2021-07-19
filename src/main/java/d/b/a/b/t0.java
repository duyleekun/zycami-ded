/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import d.b.a.b.c;
import d.b.a.b.h;
import d.b.a.b.h$a;
import d.b.a.b.r0;

public final class t0
implements Runnable {
    private final /* synthetic */ int a;
    private final /* synthetic */ String b;
    private final /* synthetic */ r0 c;

    public t0(r0 r02, int n10, String string2) {
        this.c = r02;
        this.a = n10;
        this.b = string2;
    }

    public final void run() {
        c c10 = this.c.b;
        Object object = h.c();
        int n10 = this.a;
        object = ((h$a)object).c(n10);
        String string2 = this.b;
        object = ((h$a)object).b(string2).a();
        c10.e((h)object);
    }
}

