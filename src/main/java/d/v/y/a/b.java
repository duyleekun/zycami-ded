/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.a;

import d.v.y.a.b$a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class b {
    public final ByteBuffer a;
    private b$a b;

    public b(int n10, ByteOrder byteOrder) {
        ByteBuffer byteBuffer;
        this.a = byteBuffer = ByteBuffer.allocate(n10);
        byteBuffer.order(byteOrder);
    }

    public void a(byte[] byArray) {
        int n10 = this.a.capacity();
        this.a.limit(n10);
        this.a.put(byArray);
        this.a.flip();
        this.c();
    }

    public final void b(byte[] byArray) {
        b$a b$a = this.b;
        if (b$a != null) {
            b$a.a(byArray);
        }
    }

    public abstract void c();

    public final boolean d() {
        ByteBuffer byteBuffer = this.a;
        boolean bl2 = byteBuffer.hasRemaining();
        if (!bl2) {
            this.a.compact();
            this.a.clear();
            return false;
        }
        return true;
    }

    public final boolean e(int n10) {
        ByteBuffer byteBuffer = this.a;
        int n11 = byteBuffer.remaining();
        if (n11 < n10) {
            n10 = this.a.remaining();
            this.a.compact();
            this.a.position(n10);
            this.a.limit(n10);
            return false;
        }
        return true;
    }

    public void f(b$a b$a) {
        this.b = b$a;
    }
}

