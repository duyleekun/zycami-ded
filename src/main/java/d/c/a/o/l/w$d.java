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
import d.c.a.o.j.d;
import d.c.a.o.l.n;
import d.c.a.o.l.o;
import d.c.a.o.l.r;
import d.c.a.o.l.w;
import d.c.a.o.l.w$c;

public class w$d
implements o,
w$c {
    private final ContentResolver a;

    public w$d(ContentResolver contentResolver) {
        this.a = contentResolver;
    }

    public void a() {
    }

    public d b(Uri uri) {
        ContentResolver contentResolver = this.a;
        d.c.a.o.j.o o10 = new d.c.a.o.j.o(contentResolver, uri);
        return o10;
    }

    public n c(r object) {
        object = new w(this);
        return object;
    }
}

