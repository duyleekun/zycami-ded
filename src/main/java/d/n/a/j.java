/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 */
package d.n.a;

import android.content.ContentResolver;
import android.content.Context;
import c.a.l.e;
import c.a.l.l;
import c.b.a.c;
import d.n.a.b$d;

public final class j
implements e {
    private final c a;

    public j(c c10) {
        this.a = c10;
    }

    public static j a(c c10) {
        j j10 = new j(c10);
        return j10;
    }

    public static ContentResolver c(Context context) {
        return (ContentResolver)l.b(b$d.m(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    public ContentResolver b() {
        return (ContentResolver)l.b(b$d.m((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

