/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.n.a.q0.x;

import android.content.Context;
import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.x.i;

public final class j
implements e {
    private final c a;
    private final c b;

    public j(c c10, c c11) {
        this.a = c10;
        this.b = c11;
    }

    public static j a(c c10, c c11) {
        j j10 = new j(c10, c11);
        return j10;
    }

    public static i c(Context context, String[] stringArray) {
        i i10 = new i(context, stringArray);
        return i10;
    }

    public i b() {
        Context context = (Context)this.a.get();
        String[] stringArray = (String[])this.b.get();
        i i10 = new i(context, stringArray);
        return i10;
    }
}

