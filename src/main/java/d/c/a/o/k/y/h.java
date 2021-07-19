/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.c.a.o.k.y;

import android.content.Context;
import d.c.a.o.k.y.d;
import d.c.a.o.k.y.h$a;

public final class h
extends d {
    public h(Context context) {
        this(context, "image_manager_disk_cache", 0xFA00000L);
    }

    public h(Context context, long l10) {
        this(context, "image_manager_disk_cache", l10);
    }

    public h(Context context, String string2, long l10) {
        h$a h$a = new h$a(context, string2);
        super(h$a, l10);
    }
}

