/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.i;

import android.content.Context;
import d.r.a.i.g;
import d.r.a.s.c;
import java.util.List;

public final class g$b
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ List b;
    public final /* synthetic */ List c;
    public final /* synthetic */ String d;
    public final /* synthetic */ g e;

    public g$b(g g10, int n10, List list, List list2, String string2) {
        this.e = g10;
        this.a = n10;
        this.b = list;
        this.c = list2;
        this.d = string2;
    }

    public final void run() {
        g g10 = this.e;
        c c10 = g10.d;
        Context context = g.e(g10);
        int n10 = this.a;
        List list = this.b;
        List list2 = this.c;
        String string2 = this.d;
        c10.onDelAlias(context, n10, list, list2, string2);
    }
}

