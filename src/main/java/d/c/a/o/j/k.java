/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.j;

import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import d.c.a.o.j.e;
import d.c.a.o.k.x.b;
import java.io.InputStream;

public final class k
implements e {
    private static final int b = 0x500000;
    private final RecyclableBufferedInputStream a;

    public k(InputStream inputStream, b b10) {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        this.a = recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, b10);
        recyclableBufferedInputStream.mark(0x500000);
    }

    public void b() {
        this.a.q();
    }

    public void c() {
        this.a.h();
    }

    public InputStream d() {
        this.a.reset();
        return this.a;
    }
}

