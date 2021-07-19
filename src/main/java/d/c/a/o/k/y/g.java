/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.c.a.o.k.y;

import android.content.Context;
import d.c.a.o.k.y.d;
import d.c.a.o.k.y.g$a;

public final class g
extends d {
    public g(Context context) {
        this(context, "image_manager_disk_cache", 0xFA00000L);
    }

    public g(Context context, long l10) {
        this(context, "image_manager_disk_cache", l10);
    }

    public g(Context context, String string2, long l10) {
        g$a g$a = new g$a(context, string2);
        super(g$a, l10);
    }
}

