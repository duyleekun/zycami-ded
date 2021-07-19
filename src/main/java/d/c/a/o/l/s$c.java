/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.net.Uri
 */
package d.c.a.o.l;

import android.content.res.Resources;
import android.net.Uri;
import d.c.a.o.l.n;
import d.c.a.o.l.o;
import d.c.a.o.l.r;
import d.c.a.o.l.s;
import java.io.InputStream;

public class s$c
implements o {
    private final Resources a;

    public s$c(Resources resources) {
        this.a = resources;
    }

    public void a() {
    }

    public n c(r object) {
        Resources resources = this.a;
        object = ((r)object).d(Uri.class, InputStream.class);
        s s10 = new s(resources, (n)object);
        return s10;
    }
}

