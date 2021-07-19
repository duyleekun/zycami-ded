/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 */
package d.c.a.o.l;

import android.content.res.AssetManager;
import d.c.a.o.j.d;
import d.c.a.o.j.h;
import d.c.a.o.l.a;
import d.c.a.o.l.a$a;
import d.c.a.o.l.n;
import d.c.a.o.l.o;
import d.c.a.o.l.r;

public class a$b
implements o,
a$a {
    private final AssetManager a;

    public a$b(AssetManager assetManager) {
        this.a = assetManager;
    }

    public void a() {
    }

    public d b(AssetManager assetManager, String string2) {
        h h10 = new h(assetManager, string2);
        return h10;
    }

    public n c(r object) {
        AssetManager assetManager = this.a;
        object = new a(assetManager, this);
        return object;
    }
}

