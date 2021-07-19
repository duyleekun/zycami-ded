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
import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.c.b2.w.b;
import d.v.c.b2.w.l.a;
import d.v.c.b2.x.d;
import d.v.h.d.c;

public class f
extends b
implements d.v.c.b2.w.l.b {
    private a g;
    private String h;

    public f(c object) {
        super((d.v.h.b)object);
        this.h = object = ((c)object).A();
    }

    private a t() {
        a a10 = this.g;
        if (a10 == null) {
            String string2 = this.h;
            this.g = a10 = new a(string2);
        }
        return this.g;
    }

    public void b() {
        a a10 = this.g;
        if (a10 != null) {
            a10.b();
            a10 = null;
            this.g = null;
        }
    }

    public boolean f() {
        boolean bl2;
        a a10 = this.g;
        if (a10 != null && (bl2 = a10.f())) {
            bl2 = true;
        } else {
            bl2 = false;
            a10 = null;
        }
        return bl2;
    }

    public void r() {
        a a10 = this.g;
        if (a10 != null) {
            a10.n();
            a10 = null;
            this.g = null;
        }
    }

    public Bitmap s(Context context, d d10) {
        return this.t().t(context, d10);
    }

    public boolean u() {
        boolean bl2;
        DecorationType decorationType;
        Object object = this.a();
        if (object != null && (object = ((c)this.a()).g()) == (decorationType = DecorationType.GIF_PASTER)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

