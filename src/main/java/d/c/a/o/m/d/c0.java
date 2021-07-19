/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.m.d;

import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import d.c.a.o.f;
import d.c.a.o.g;
import d.c.a.o.k.s;
import d.c.a.o.k.x.b;
import d.c.a.o.m.d.c0$a;
import d.c.a.o.m.d.o;
import d.c.a.u.d;
import d.c.a.u.i;
import java.io.InputStream;

public class c0
implements g {
    private final o a;
    private final b b;

    public c0(o o10, b b10) {
        this.a = o10;
        this.b = b10;
    }

    public s c(InputStream inputStream, int n10, int n11, f f10) {
        Object object;
        boolean bl2 = inputStream instanceof RecyclableBufferedInputStream;
        if (bl2) {
            inputStream = (RecyclableBufferedInputStream)inputStream;
            bl2 = false;
            Object var6_6 = null;
        } else {
            boolean bl3;
            object = this.b;
            RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, (b)object);
            bl2 = bl3 = true;
            inputStream = recyclableBufferedInputStream;
        }
        object = d.q(inputStream);
        i i10 = new i((InputStream)object);
        c0$a c0$a = new c0$a((RecyclableBufferedInputStream)inputStream, (d)object);
        try {
            o o10 = this.a;
            s s10 = o10.g(i10, n10, n11, f10, c0$a);
            return s10;
        }
        finally {
            ((d)object).B();
            if (bl2) {
                ((RecyclableBufferedInputStream)inputStream).q();
            }
        }
    }

    public boolean d(InputStream inputStream, f f10) {
        return this.a.p(inputStream);
    }
}

