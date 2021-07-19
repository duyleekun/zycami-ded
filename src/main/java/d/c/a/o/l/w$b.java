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
import d.c.a.o.j.i;
import d.c.a.o.l.n;
import d.c.a.o.l.o;
import d.c.a.o.l.r;
import d.c.a.o.l.w;
import d.c.a.o.l.w$c;

public class w$b
implements o,
w$c {
    private final ContentResolver a;

    public w$b(ContentResolver contentResolver) {
        this.a = contentResolver;
    }

    public void a() {
    }

    public d b(Uri uri) {
        ContentResolver contentResolver = this.a;
        i i10 = new i(contentResolver, uri);
        return i10;
    }

    public n c(r object) {
        object = new w(this);
        return object;
    }
}

