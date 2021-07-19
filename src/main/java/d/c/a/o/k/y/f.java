/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.c.a.o.k.y;

import android.content.Context;
import d.c.a.o.k.y.d;
import d.c.a.o.k.y.f$a;

public final class f
extends d {
    public f(Context context) {
        this(context, "image_manager_disk_cache", 0xFA00000);
    }

    public f(Context context, int n10) {
        this(context, "image_manager_disk_cache", n10);
    }

    public f(Context context, String string2, int n10) {
        f$a f$a = new f$a(context, string2);
        long l10 = n10;
        super(f$a, l10);
    }
}

