/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.t;

import android.content.Context;
import d.r.a.a;
import d.r.a.t.c;
import d.r.a.t.d;
import d.r.a.t.f;

public final class f$a
implements a {
    public final /* synthetic */ d a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ f c;

    public f$a(f f10, d d10, Context context) {
        this.c = f10;
        this.a = d10;
        this.b = context;
    }

    public final void onStateChanged(int n10) {
        d d10 = this.a;
        String string2 = d.r.a.d.f(this.b).g();
        c c10 = new c(n10, string2);
        d10.onResult(c10);
    }
}

