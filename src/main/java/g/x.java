/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.d0;
import g.h0.k.a;
import g.s;
import g.v;
import g.x$a;
import g.x$b;
import g.x$c;
import h.c0;
import h.c0$a;
import h.m;
import h.o;
import h.z;
import java.io.Closeable;
import java.net.ProtocolException;
import okio.ByteString;
import okio.ByteString$a;

public final class x
implements Closeable {
    private static final c0 i;
    public static final x$a j;
    private final ByteString a;
    private final ByteString b;
    private int c;
    private boolean d;
    private boolean e;
    private x$c f;
    private final o g;
    private final String h;

    static {
        ByteString byteString;
        Object object = new x$a(null);
        j = object;
        object = c0.d;
        ByteString[] byteStringArray = new ByteString[4];
        Object object2 = ByteString.Companion;
        byteStringArray[0] = byteString = ((ByteString$a)object2).l("\r\n");
        byteStringArray[1] = byteString = ((ByteString$a)object2).l("--");
        byteStringArray[2] = byteString = ((ByteString$a)object2).l(" ");
        byteStringArray[3] = object2 = ((ByteString$a)object2).l("\t");
        i = ((c0$a)object).d(byteStringArray);
    }

    public x(d0 object) {
        String string2;
        f0.p(object, "response");
        o o10 = ((d0)object).source();
        object = ((d0)object).contentType();
        if (object != null && (object = ((v)object).i(string2 = "boundary")) != null) {
            this(o10, (String)object);
            return;
        }
        object = new ProtocolException("expected the Content-Type to have a boundary parameter");
        throw object;
    }

    public x(o object, String string2) {
        f0.p(object, "source");
        f0.p(string2, "boundary");
        this.g = object;
        this.h = string2;
        this.a = object = ((m)object).p1("--").p1(string2).b0();
        object = new m();
        this.b = object = ((m)object).p1("\r\n--").p1(string2).b0();
    }

    public static final /* synthetic */ o B(x x10) {
        return x10.g;
    }

    public static final /* synthetic */ void C(x x10, x$c c10) {
        x10.f = c10;
    }

    private final long E(long l10) {
        o o10 = this.g;
        int n10 = this.b.size();
        long l11 = n10;
        o10.L(l11);
        o10 = this.g.getBuffer();
        ByteString byteString = this.b;
        long l12 = ((m)o10).i(byteString);
        long l13 = -1;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l14 == false) {
            o10 = this.g.getBuffer();
            l12 = ((m)o10).S0();
            ByteString byteString2 = this.b;
            l14 = byteString2.size();
            l13 = l14;
            l12 -= l13;
            l13 = 1L;
            l10 = Math.min(l10, l12 += l13);
        } else {
            l10 = Math.min(l10, l12);
        }
        return l10;
    }

    public static final /* synthetic */ long a(x x10, long l10) {
        return x10.E(l10);
    }

    public static final /* synthetic */ c0 h() {
        return i;
    }

    public static final /* synthetic */ x$c q(x x10) {
        return x10.f;
    }

    public final String D() {
        return this.h;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final x$b O() {
        int n10;
        Object object;
        Object object2;
        Object object3;
        int n11 = this.d;
        int n12 = 1;
        if ((n11 ^= n12) == 0) {
            String string2 = "closed".toString();
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
        n11 = this.e;
        x$b x$b = null;
        if (n11 != 0) {
            return null;
        }
        n11 = this.c;
        long l10 = 0L;
        if (n11 == 0 && (n11 = (int)((object3 = this.g).s(l10, (ByteString)(object2 = this.a)) ? 1 : 0)) != 0) {
            object3 = this.g;
            object = this.a;
            n10 = ((ByteString)object).size();
            l10 = n10;
            object3.skip(l10);
        } else {
            while (true) {
                long l11;
                long l12;
                if ((n11 = (int)((l12 = (l11 = this.E(8192L)) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0) {
                    object3 = this.g;
                    object = this.b;
                    n10 = ((ByteString)object).size();
                    l10 = n10;
                    object3.skip(l10);
                    break;
                }
                object3 = this.g;
                object3.skip(l11);
            }
        }
        n11 = 0;
        object3 = null;
        while (true) {
            object = this.g;
            c0 c02 = i;
            n10 = object.m0(c02);
            int n13 = -1;
            object2 = "unexpected characters after boundary";
            if (n10 == n13) {
                object3 = new ProtocolException((String)object2);
                throw object3;
            }
            if (n10 == 0) {
                x$c x$c;
                this.c = n11 = this.c + n12;
                o o10 = this.g;
                object3 = new a(o10);
                object3 = ((a)object3).b();
                this.f = x$c = new x$c(this);
                o o11 = z.d(x$c);
                return new x$b((s)object3, o11);
            }
            if (n10 == n12) break;
            n13 = 2;
            if (n10 != n13 && n10 != (n13 = 3)) continue;
            n11 = n12;
        }
        if (n11 != 0) {
            object3 = new ProtocolException((String)object2);
            throw object3;
        }
        n11 = this.c;
        if (n11 != 0) {
            this.e = n12;
            return null;
        }
        object3 = new ProtocolException("expected at least 1 part");
        throw object3;
    }

    public void close() {
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        this.d = true;
        this.f = null;
        this.g.close();
    }
}

