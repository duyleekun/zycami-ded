/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.m.e;

import d.c.a.o.j.e;
import java.nio.ByteBuffer;

public class a
implements e {
    private final ByteBuffer a;

    public a(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    public void b() {
    }

    public ByteBuffer c() {
        this.a.position(0);
        return this.a;
    }
}

