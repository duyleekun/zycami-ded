/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 */
package d.c.a.o.m.d;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import d.c.a.o.f;
import d.c.a.o.h;
import d.c.a.o.k.s;
import d.c.a.o.k.x.e;
import d.c.a.o.m.d.g;
import java.io.File;

public class b
implements h {
    private final e a;
    private final h b;

    public b(e e10, h h10) {
        this.a = e10;
        this.b = h10;
    }

    public EncodeStrategy b(f f10) {
        return this.b.b(f10);
    }

    public boolean c(s s10, File file, f f10) {
        h h10 = this.b;
        s10 = ((BitmapDrawable)s10.get()).getBitmap();
        e e10 = this.a;
        g g10 = new g((Bitmap)s10, e10);
        return h10.a(g10, file, f10);
    }
}

