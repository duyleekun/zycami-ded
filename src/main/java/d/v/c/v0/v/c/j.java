/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.v.c;

import d.v.c.v0.v.c.s;
import java.util.List;

public final class j
implements Runnable {
    public final /* synthetic */ s a;
    public final /* synthetic */ List b;

    public /* synthetic */ j(s s10, List list) {
        this.a = s10;
        this.b = list;
    }

    public final void run() {
        s s10 = this.a;
        List list = this.b;
        s10.M(list);
    }
}

