/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 */
package d.v.c.b2.w;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Priority;
import d.v.c.b2.w.l.a;
import d.v.c.b2.w.l.b;
import d.v.c.b2.x.d;
import d.v.c.x1.q.c;

public class h
implements b {
    public c a;
    private a b;

    public h(long l10, String string2, int n10) {
        c c10;
        this.a = c10 = c.b(string2, l10, n10);
    }

    private a i() {
        a a10 = this.b;
        if (a10 == null) {
            c c10 = this.a;
            Priority priority = Priority.LOW;
            this.b = a10 = new a((Object)c10, priority);
        }
        return this.b;
    }

    public void a() {
        a a10 = this.b;
        if (a10 != null) {
            a10.n();
            a10 = null;
            this.b = null;
        }
    }

    public void b() {
        a a10 = this.b;
        if (a10 != null) {
            a10.b();
            this.b = null;
        }
        this.a = null;
    }

    public boolean f() {
        boolean bl2;
        a a10 = this.b;
        if (a10 != null && (bl2 = a10.f())) {
            bl2 = true;
        } else {
            bl2 = false;
            a10 = null;
        }
        return bl2;
    }

    public Bitmap g() {
        return this.i().s(null);
    }

    public Bitmap h(Context context, d d10) {
        return this.i().t(context, d10);
    }

    public long j() {
        return this.a.d();
    }

    public String l() {
        return this.a.e();
    }

    public void m(String object) {
        long l10 = this.a.d();
        int n10 = this.a.c();
        this.a = object = c.b((String)object, l10, n10);
        this.b = null;
    }
}

