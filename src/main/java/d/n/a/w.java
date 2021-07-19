/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.n.a;

import android.content.Context;
import c.a.l.e;
import c.b.a.c;
import d.n.a.b$d;

public final class w
implements e {
    private final c a;

    public w(c c10) {
        this.a = c10;
    }

    public static w a(c c10) {
        w w10 = new w(c10);
        return w10;
    }

    public static int c(Context context) {
        return b$d.A(context);
    }

    public Integer b() {
        return b$d.A((Context)this.a.get());
    }
}

