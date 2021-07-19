/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.v.c.x1.q;

import android.graphics.Bitmap;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import d.c.a.o.j.d;
import d.c.a.o.j.d$a;
import d.v.c.x1.q.c;
import d.v.v.o.b.a;
import d.v.v.q.h;

public class b
implements d {
    private final c a;
    private a b;
    private boolean c;

    public b(c c10) {
        this(c10, null);
    }

    public b(c c10, a a10) {
        this.a = c10;
        this.b = a10;
    }

    private void c(d$a d$a) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("\u7f29\u7565\u56fe\u52a0\u8f7d\u5931\u8d25, mModel: ");
        c c10 = this.a;
        charSequence.append(c10);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        d$a.c(illegalStateException);
    }

    private void e(d$a d$a, Bitmap bitmap) {
        d$a.e(bitmap);
    }

    private boolean f() {
        return this.c;
    }

    public Class a() {
        return Bitmap.class;
    }

    public void b() {
    }

    public void cancel() {
        this.c = true;
    }

    public void d(Priority object, d$a d$a) {
        int n10 = this.f();
        if (n10 != 0) {
            this.c(d$a);
            return;
        }
        object = this.b;
        if (object != null) {
            c c10 = this.a;
            long l10 = c10.d();
            c c11 = this.a;
            int n11 = c11.c();
            object = ((a)object).c(l10, n11);
        } else {
            n10 = this.a.c();
            String string2 = this.a.e();
            c c12 = this.a;
            long l11 = c12.d();
            object = h.O(n10, string2, l11);
        }
        boolean bl2 = this.f();
        if (bl2) {
            this.c(d$a);
            return;
        }
        if (object != null && !(bl2 = object.isRecycled())) {
            this.e(d$a, (Bitmap)object);
        } else {
            this.c(d$a);
        }
    }

    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}

