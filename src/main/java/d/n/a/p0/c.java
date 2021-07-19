/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.n.a.p0;

import android.content.Context;
import d.n.a.a0;
import d.n.a.b$b;
import e.a.g0;
import e.a.z;

public class c
extends z {
    private final z a;

    public c(z z10) {
        this.a = z10;
    }

    public static c h8(Context context) {
        b$b b$b = a0.l();
        context = context.getApplicationContext();
        return b$b.a(context).build().a();
    }

    public void K5(g0 g02) {
        this.a.subscribe(g02);
    }
}

