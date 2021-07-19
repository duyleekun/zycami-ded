/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.w.b;

import d.v.c.v0.w.b.h;
import java.util.ArrayList;

public final class d
implements Runnable {
    public final /* synthetic */ h a;
    public final /* synthetic */ ArrayList b;

    public /* synthetic */ d(h h10, ArrayList arrayList) {
        this.a = h10;
        this.b = arrayList;
    }

    public final void run() {
        h h10 = this.a;
        ArrayList arrayList = this.b;
        h10.p(arrayList);
    }
}

