/*
 * Decompiled with CFR 0.151.
 */
package g.h0.q;

import f.h2.t.f0;
import g.h0.q.a;
import g.h0.q.g;
import h.m;
import h.m$a;
import h.n;
import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import okio.ByteString;

public final class i
implements Closeable {
    private final m a;
    private final m b;
    private boolean c;
    private a d;
    private final byte[] e;
    private final m$a f;
    private final boolean g;
    private final n h;
    private final Random i;
    private final boolean j;
    private final boolean k;
    private final long l;

    public i(boolean bl2, n closeable, Random object, boolean bl3, boolean bl4, long l10) {
        f0.p(closeable, "sink");
        String string2 = "random";
        f0.p(object, string2);
        this.g = bl2;
        this.h = closeable;
        this.i = object;
        this.j = bl3;
        this.k = bl4;
        this.l = l10;
        this.a = object = new m();
        closeable = closeable.getBuffer();
        this.b = closeable;
        closeable = null;
        if (bl2) {
            int n10 = 4;
            object = new byte[n10];
        } else {
            boolean bl5 = false;
            object = null;
        }
        this.e = (byte[])object;
        if (bl2) {
        }
        this.f = closeable;
    }

    private final void B(int n10, ByteString object) {
        int n11 = this.c;
        if (n11 == 0) {
            Object object2;
            long l10;
            n11 = ((ByteString)object).size();
            long l11 = n11;
            long l12 = l11 - (l10 = (long)125);
            Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 <= 0) {
                object3 = 1;
            } else {
                object3 = 0;
                object2 = null;
            }
            if (object3 != false) {
                object2 = this.b;
                ((m)object2).b1(n10 |= 0x80);
                n10 = (int)(this.g ? 1 : 0);
                if (n10 != 0) {
                    n10 = n11 | 0x80;
                    this.b.b1(n10);
                    Object object4 = this.i;
                    object2 = this.e;
                    f0.m(object2);
                    ((Random)object4).nextBytes((byte[])object2);
                    object4 = this.b;
                    object2 = this.e;
                    ((m)object4).Z0((byte[])object2);
                    if (n11 > 0) {
                        long l13 = this.b.S0();
                        this.b.W0((ByteString)object);
                        object4 = this.b;
                        object = this.f;
                        f0.m(object);
                        ((m)object4).G0((m$a)object);
                        this.f.B(l13);
                        object4 = g.h0.q.g.w;
                        object = this.f;
                        byte[] byArray = this.e;
                        ((g)object4).c((m$a)object, byArray);
                        object4 = this.f;
                        ((m$a)object4).close();
                    }
                } else {
                    this.b.b1(n11);
                    m m10 = this.b;
                    m10.W0((ByteString)object);
                }
                this.h.flush();
                return;
            }
            object = "Payload size must be less than or equal to 125".toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        IOException iOException = new IOException("closed");
        throw iOException;
    }

    public final void C(int n10, ByteString object) {
        Object object2 = "data";
        f0.p(object, (String)object2);
        int n11 = this.c;
        if (n11 == 0) {
            long l10;
            long l11;
            long l12;
            long l13;
            object2 = this.a;
            ((m)object2).W0((ByteString)object);
            n11 = 128;
            n10 |= n11;
            boolean bl2 = this.j;
            if (bl2 && (l13 = (l12 = (l11 = (long)((ByteString)object).size()) - (l10 = this.l)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) >= 0) {
                object = this.d;
                if (object == null) {
                    bl2 = this.k;
                    this.d = object = new a(bl2);
                }
                m m10 = this.a;
                ((a)object).a(m10);
                n10 |= 0x40;
            }
            l11 = this.a.S0();
            object = this.b;
            ((m)object).b1(n10);
            n10 = 0;
            Object object3 = null;
            l13 = (long)this.g;
            if (l13 == false) {
                n11 = 0;
                object2 = null;
            }
            long l14 = 125;
            n10 = (int)(l11 == l14 ? 0 : (l11 < l14 ? -1 : 1));
            if (n10 <= 0) {
                n10 = (int)l11 | n11;
                object = this.b;
                ((m)object).b1(n10);
            } else {
                l14 = (char)-1;
                long l15 = l11 - l14;
                n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
                if (n10 <= 0) {
                    n10 = n11 | 0x7E;
                    object = this.b;
                    ((m)object).b1(n10);
                    object3 = this.b;
                    l13 = (int)l11;
                    ((m)object3).i1((int)l13);
                } else {
                    n10 = n11 | 0x7F;
                    object = this.b;
                    ((m)object).b1(n10);
                    object3 = this.b;
                    ((m)object3).g1(l11);
                }
            }
            n10 = (int)(this.g ? 1 : 0);
            if (n10 != 0) {
                object3 = this.i;
                object = this.e;
                f0.m(object);
                ((Random)object3).nextBytes((byte[])object);
                object3 = this.b;
                object = this.e;
                ((m)object3).Z0((byte[])object);
                l14 = 0L;
                n11 = (int)(l11 == l14 ? 0 : (l11 < l14 ? -1 : 1));
                if (n11 > 0) {
                    object2 = this.a;
                    m$a m$a = this.f;
                    f0.m(m$a);
                    ((m)object2).G0(m$a);
                    this.f.B(l14);
                    object3 = g.h0.q.g.w;
                    object = this.f;
                    object2 = this.e;
                    ((g)object3).c((m$a)object, (byte[])object2);
                    object3 = this.f;
                    ((m$a)object3).close();
                }
            }
            object3 = this.b;
            object = this.a;
            ((m)object3).t((m)object, l11);
            this.h.d();
            return;
        }
        IOException iOException = new IOException("closed");
        throw iOException;
    }

    public final void D(ByteString byteString) {
        f0.p(byteString, "payload");
        this.B(9, byteString);
    }

    public final void E(ByteString byteString) {
        f0.p(byteString, "payload");
        this.B(10, byteString);
    }

    public final Random a() {
        return this.i;
    }

    public void close() {
        a a10 = this.d;
        if (a10 != null) {
            a10.close();
        }
    }

    public final n h() {
        return this.h;
    }

    public final void q(int n10, ByteString byteString) {
        Object object = ByteString.EMPTY;
        if (n10 != 0 || byteString != null) {
            if (n10 != 0) {
                object = g.h0.q.g.w;
                ((g)object).d(n10);
            }
            object = new m();
            ((m)object).i1(n10);
            if (byteString != null) {
                ((m)object).W0(byteString);
            }
            object = ((m)object).b0();
        }
        n10 = 8;
        boolean bl2 = true;
        try {
            this.B(n10, (ByteString)object);
            return;
        }
        finally {
            this.c = bl2;
        }
    }
}

