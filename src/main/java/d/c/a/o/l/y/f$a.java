/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 */
package d.c.a.o.l.y;

import android.content.Context;
import android.net.Uri;
import d.c.a.o.l.n;
import d.c.a.o.l.o;
import d.c.a.o.l.r;
import d.c.a.o.l.y.f;
import java.io.File;

public abstract class f$a
implements o {
    private final Context a;
    private final Class b;

    public f$a(Context context, Class clazz) {
        this.a = context;
        this.b = clazz;
    }

    public final void a() {
    }

    public final n c(r object) {
        Context context = this.a;
        Class clazz = this.b;
        n n10 = ((r)object).d(File.class, clazz);
        Class clazz2 = this.b;
        object = ((r)object).d(Uri.class, clazz2);
        clazz = this.b;
        f f10 = new f(context, n10, (n)object, clazz);
        return f10;
    }
}

