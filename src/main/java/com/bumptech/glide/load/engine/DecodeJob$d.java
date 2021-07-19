/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.DecodeJob$e;
import d.c.a.o.c;
import d.c.a.o.f;
import d.c.a.o.h;
import d.c.a.o.k.d;
import d.c.a.o.k.r;
import d.c.a.u.o.b;

public class DecodeJob$d {
    private c a;
    private h b;
    private r c;

    public void a() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    public void b(DecodeJob$e object, f f10) {
        Object object2 = "DecodeJob.encode";
        d.c.a.u.o.b.a((String)object2);
        try {
            object = object.a();
            object2 = this.a;
            h h10 = this.b;
            r r10 = this.c;
            d d10 = new d(h10, r10, f10);
            object.a((c)object2, d10);
            return;
        }
        finally {
            this.c.f();
            d.c.a.u.o.b.e();
        }
    }

    public boolean c() {
        boolean bl2;
        r r10 = this.c;
        if (r10 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            r10 = null;
        }
        return bl2;
    }

    public void d(c c10, h h10, r r10) {
        this.a = c10;
        this.b = h10;
        this.c = r10;
    }
}

