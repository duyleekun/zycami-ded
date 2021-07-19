/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.net.Uri
 */
package d.c.a.o.l;

import android.content.ContentResolver;
import android.net.Uri;
import d.c.a.o.j.a;
import d.c.a.o.j.d;
import d.c.a.o.l.n;
import d.c.a.o.l.o;
import d.c.a.o.l.r;
import d.c.a.o.l.w;
import d.c.a.o.l.w$c;

public final class w$a
implements o,
w$c {
    private final ContentResolver a;

    public w$a(ContentResolver contentResolver) {
        this.a = contentResolver;
    }

    public void a() {
    }

    public d b(Uri uri) {
        ContentResolver contentResolver = this.a;
        a a10 = new a(contentResolver, uri);
        return a10;
    }

    public n c(r object) {
        object = new w(this);
        return object;
    }
}

