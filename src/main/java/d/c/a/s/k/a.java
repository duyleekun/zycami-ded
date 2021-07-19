/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.c.a.s.k;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DataSource;
import d.c.a.s.k.a$a;
import d.c.a.s.k.f;
import d.c.a.s.k.g;

public abstract class a
implements g {
    private final g a;

    public a(g g10) {
        this.a = g10;
    }

    public f a(DataSource object, boolean bl2) {
        object = this.a.a((DataSource)((Object)object), bl2);
        a$a a$a = new a$a(this, (f)object);
        return a$a;
    }

    public abstract Bitmap b(Object var1);
}

