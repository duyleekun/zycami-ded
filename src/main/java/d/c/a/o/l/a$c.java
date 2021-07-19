/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 */
package d.c.a.o.l;

import android.content.res.AssetManager;
import d.c.a.o.j.d;
import d.c.a.o.l.a;
import d.c.a.o.l.a$a;
import d.c.a.o.l.n;
import d.c.a.o.l.o;
import d.c.a.o.l.r;

public class a$c
implements o,
a$a {
    private final AssetManager a;

    public a$c(AssetManager assetManager) {
        this.a = assetManager;
    }

    public void a() {
    }

    public d b(AssetManager assetManager, String string2) {
        d.c.a.o.j.n n10 = new d.c.a.o.j.n(assetManager, string2);
        return n10;
    }

    public n c(r object) {
        AssetManager assetManager = this.a;
        object = new a(assetManager, this);
        return object;
    }
}

