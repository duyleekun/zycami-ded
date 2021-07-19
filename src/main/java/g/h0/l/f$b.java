/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import g.h0.d;
import g.h0.l.c;
import g.h0.l.f;
import g.h0.l.f$a;
import h.m;
import h.m0;
import h.o;
import h.o0;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class f$b
implements m0 {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private final o f;

    public f$b(o o10) {
        f0.p(o10, "source");
        this.f = o10;
    }

    private final void D() {
        Level level;
        int n10;
        int n11 = this.c;
        this.d = n10 = g.h0.d.R(this.f);
        this.a = n10;
        Object object = this.f;
        n10 = object.readByte();
        int n12 = 255;
        n10 = g.h0.d.b((byte)n10, n12);
        this.b = n12 = g.h0.d.b(this.f.readByte(), n12);
        Object object2 = g.h0.l.f.f;
        Object object3 = ((f$a)object2).a();
        boolean n13 = ((Logger)object3).isLoggable(level = Level.FINE);
        if (n13) {
            object2 = ((f$a)object2).a();
            object3 = g.h0.l.c.x;
            boolean bl2 = true;
            int n14 = this.c;
            int n15 = this.a;
            int n16 = this.b;
            object3 = ((c)object3).c(bl2, n14, n15, n10, n16);
            ((Logger)object2).fine((String)object3);
        }
        object2 = this.f;
        this.c = n12 = object2.readInt() & -1 >>> 1;
        int n17 = 9;
        if (n10 == n17) {
            if (n12 == n11) {
                return;
            }
            IOException iOException = new IOException("TYPE_CONTINUATION streamId changed");
            throw iOException;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append(" != TYPE_CONTINUATION");
        object = ((StringBuilder)object2).toString();
        IOException iOException = new IOException((String)object);
        throw iOException;
    }

    public final int B() {
        return this.e;
    }

    public final int C() {
        return this.c;
    }

    public final void E(int n10) {
        this.b = n10;
    }

    public final void O(int n10) {
        this.d = n10;
    }

    public final void S(int n10) {
        this.a = n10;
    }

    public final int a() {
        return this.b;
    }

    public void close() {
    }

    public final int h() {
        return this.d;
    }

    public final void n0(int n10) {
        this.e = n10;
    }

    public final void o0(int n10) {
        this.c = n10;
    }

    public final int q() {
        return this.a;
    }

    public long read(m m10, long l10) {
        long l11;
        int n10;
        Object object = "sink";
        f0.p(m10, (String)object);
        while (true) {
            n10 = this.d;
            l11 = -1;
            if (n10 != 0) break;
            object = this.f;
            int n11 = this.e;
            long l12 = n11;
            object.skip(l12);
            object = null;
            this.e = 0;
            n10 = this.b & 4;
            if (n10 != 0) {
                return l11;
            }
            this.D();
        }
        o o10 = this.f;
        long l13 = n10;
        long l14 = o10.read(m10, l10 = Math.min(l10, l13));
        long l15 = l14 - l11;
        Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object2 == false) {
            return l11;
        }
        object2 = this.d;
        n10 = (int)l14;
        this.d = (int)(object2 -= n10);
        return l14;
    }

    public o0 timeout() {
        return this.f.timeout();
    }
}

