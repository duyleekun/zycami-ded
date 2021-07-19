/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.m.d;

import d.c.a.o.f;
import d.c.a.o.g;
import d.c.a.o.k.s;
import d.c.a.o.m.d.o;
import d.c.a.u.a;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class j
implements g {
    private final o a;

    public j(o o10) {
        this.a = o10;
    }

    public s c(ByteBuffer object, int n10, int n11, f f10) {
        object = d.c.a.u.a.f((ByteBuffer)object);
        return this.a.f((InputStream)object, n10, n11, f10);
    }

    public boolean d(ByteBuffer byteBuffer, f f10) {
        return this.a.q(byteBuffer);
    }
}

