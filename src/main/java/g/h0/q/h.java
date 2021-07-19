/*
 * Decompiled with CFR 0.151.
 */
package g.h0.q;

import f.h2.t.f0;
import g.h0.d;
import g.h0.q.c;
import g.h0.q.g;
import g.h0.q.h$a;
import h.m;
import h.m$a;
import h.o;
import h.o0;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okio.ByteString;

public final class h
implements Closeable {
    private boolean a;
    private int b;
    private long c;
    private boolean d;
    private boolean e;
    private boolean f;
    private final m g;
    private final m h;
    private c i;
    private final byte[] j;
    private final m$a k;
    private final boolean l;
    private final o m;
    private final h$a n;
    private final boolean o;
    private final boolean p;

    public h(boolean bl2, o closeable, h$a object, boolean bl3, boolean bl4) {
        f0.p(closeable, "source");
        String string2 = "frameCallback";
        f0.p(object, string2);
        this.l = bl2;
        this.m = closeable;
        this.n = object;
        this.o = bl3;
        this.p = bl4;
        this.g = closeable;
        super();
        this.h = closeable;
        closeable = null;
        if (bl2) {
            boolean bl5 = false;
            object = null;
        } else {
            int n10 = 4;
            object = new byte[n10];
        }
        this.j = (byte[])object;
        if (!bl2) {
            super();
        }
        this.k = closeable;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void B() {
        long l10;
        long l11;
        int n10;
        String string2;
        Object object;
        int n11;
        o0 o02;
        int n12;
        int n13;
        int n14;
        int n15;
        Object object2;
        long l12;
        Object object3;
        int n16;
        block30: {
            n16 = this.a;
            if (n16 != 0) {
                IOException iOException = new IOException("closed");
                throw iOException;
            }
            object3 = this.m.timeout();
            l12 = ((o0)object3).j();
            object2 = this.m.timeout();
            ((o0)object2).b();
            object2 = this.m;
            n15 = object2.readByte();
            n14 = 255;
            n15 = g.h0.d.b((byte)n15, n14);
            this.b = n16 = n15 & 0xF;
            n13 = n15 & 0x80;
            n12 = 0;
            o02 = null;
            n11 = 1;
            if (n13 != 0) {
                n13 = n11;
            } else {
                n13 = 0;
                object = null;
            }
            this.d = n13;
            int n17 = n15 & 8;
            if (n17 != 0) {
                n17 = n11;
            } else {
                n17 = 0;
                string2 = null;
            }
            this.e = n17;
            if (n17 == 0 || n13 != 0) break block30;
            object3 = new ProtocolException("Control frames must be final.");
            throw object3;
        }
        n13 = n15 & 0x40;
        if (n13 != 0) {
            n13 = n11;
        } else {
            n13 = 0;
            object = null;
        }
        string2 = "Unexpected rsv1 flag";
        if (n16 != n11 && n16 != (n10 = 2)) {
            if (n13 != 0) {
                object3 = new ProtocolException(string2);
                throw object3;
            }
        } else {
            if (n13 != 0) {
                n16 = (int)(this.o ? 1 : 0);
                if (n16 == 0) {
                    object3 = new ProtocolException(string2);
                    throw object3;
                }
                n16 = n11;
            } else {
                n16 = 0;
                object3 = null;
            }
            this.f = n16;
        }
        n16 = n15 & 0x20;
        if (n16 != 0) {
            n16 = n11;
        } else {
            n16 = 0;
            object3 = null;
        }
        if (n16 != 0) {
            object3 = new ProtocolException("Unexpected rsv2 flag");
            throw object3;
        }
        n16 = n15 & 0x10;
        if (n16 != 0) {
            n16 = n11;
        } else {
            n16 = 0;
            object3 = null;
        }
        if (n16 != 0) {
            object3 = new ProtocolException("Unexpected rsv3 flag");
            throw object3;
        }
        object3 = this.m;
        n16 = g.h0.d.b(object3.readByte(), n14);
        n13 = n16 & 0x80;
        if (n13 != 0) {
            n12 = n11;
        }
        if (n12 == (n13 = (int)(this.l ? 1 : 0))) {
            n13 = (int)(this.l ? 1 : 0);
            object = n13 != 0 ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.";
            object3 = new ProtocolException((String)object);
            throw object3;
        }
        n13 = 127;
        this.c = l11 = (long)(n16 & n13);
        long l13 = 126;
        long l14 = l11 - l13;
        n16 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
        if (n16 == 0) {
            object3 = this.m;
            n16 = object3.readShort();
            n13 = (char)-1;
            n16 = g.h0.d.c((short)n16, n13);
            this.c = l12 = (long)n16;
        } else {
            l12 = n13;
            long l15 = l11 - l12;
            n16 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n16 == 0) {
                object3 = this.m;
                this.c = l12 = object3.readLong();
                l11 = 0L;
                long l16 = l12 - l11;
                n16 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
                if (n16 < 0) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Frame length 0x");
                    object2 = g.h0.d.Z(this.c);
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append(" > 0x7FFFFFFFFFFFFFFF");
                    object = ((StringBuilder)object).toString();
                    object3 = new ProtocolException((String)object);
                    throw object3;
                }
            }
        }
        n16 = (int)(this.e ? 1 : 0);
        if (n16 != 0 && (n16 = (int)((l10 = (l12 = this.c) - (l11 = (long)125)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) > 0) {
            object3 = new ProtocolException("Control frame must be less than 125B.");
            throw object3;
        }
        if (n12 != 0) {
            object3 = this.m;
            object = this.j;
            f0.m(object);
            object3.readFully((byte[])object);
        }
        return;
        finally {
            o02 = this.m.timeout();
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            o02.i(l12, timeUnit);
        }
    }

    private final void C() {
        Object object;
        int n10;
        while ((n10 = this.a) == 0) {
            Object object2;
            Object object3;
            long l10 = this.c;
            long l11 = 0L;
            long l12 = l10 - l11;
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 > 0) {
                object3 = this.m;
                m m10 = this.h;
                object3.k(m10, l10);
                n10 = (int)(this.l ? 1 : 0);
                if (n10 == 0) {
                    object = this.h;
                    object2 = this.k;
                    f0.m(object2);
                    ((m)object).G0((m$a)object2);
                    object = this.k;
                    long l13 = this.h.S0();
                    long l14 = this.c;
                    ((m$a)object).B(l13 -= l14);
                    object = g.h0.q.g.w;
                    object2 = this.k;
                    object3 = this.j;
                    f0.m(object3);
                    ((g)object).c((m$a)object2, (byte[])object3);
                    object = this.k;
                    ((m$a)object).close();
                }
            }
            if ((n10 = this.d) != 0) {
                return;
            }
            this.E();
            n10 = this.b;
            if (n10 == 0) continue;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Expected continuation opcode. Got: ");
            object3 = g.h0.d.Y(this.b);
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            object = new ProtocolException((String)object2);
            throw object;
        }
        object = new IOException("closed");
        throw object;
    }

    private final void D() {
        int n10;
        int n11 = this.b;
        int n12 = 1;
        if (n11 != n12 && n11 != (n10 = 2)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown opcode: ");
            String string2 = g.h0.d.Y(n11);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            ProtocolException protocolException = new ProtocolException(string2);
            throw protocolException;
        }
        this.C();
        n10 = (int)(this.f ? 1 : 0);
        if (n10 != 0) {
            c c10 = this.i;
            if (c10 == null) {
                boolean bl2 = this.p;
                this.i = c10 = new c(bl2);
            }
            m m10 = this.h;
            c10.a(m10);
        }
        if (n11 == n12) {
            h$a h$a = this.n;
            String string3 = this.h.f0();
            h$a.c(string3);
        } else {
            h$a h$a = this.n;
            ByteString byteString = this.h.b0();
            h$a.b(byteString);
        }
    }

    private final void E() {
        boolean bl2;
        while (!(bl2 = this.a)) {
            this.B();
            bl2 = this.e;
            if (!bl2) break;
            this.q();
        }
    }

    private final void q() {
        Object object;
        block10: {
            Object object2;
            int n10;
            long l10 = this.c;
            long l11 = 0L;
            long l12 = l10 - l11;
            Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 > 0) {
                Object object4 = this.m;
                m m10 = this.g;
                object4.k(m10, l10);
                n10 = (int)(this.l ? 1 : 0);
                if (n10 == 0) {
                    object = this.g;
                    object2 = this.k;
                    f0.m(object2);
                    ((m)object).G0((m$a)object2);
                    this.k.B(l11);
                    object = g.h0.q.g.w;
                    object2 = this.k;
                    object4 = this.j;
                    f0.m(object4);
                    ((g)object).c((m$a)object2, (byte[])object4);
                    object = this.k;
                    ((m$a)object).close();
                }
            }
            n10 = this.b;
            switch (n10) {
                default: {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Unknown control opcode: ");
                    String string2 = g.h0.d.Y(this.b);
                    ((StringBuilder)object2).append(string2);
                    object2 = ((StringBuilder)object2).toString();
                    object = new ProtocolException((String)object2);
                    throw object;
                }
                case 10: {
                    object = this.n;
                    object2 = this.g.b0();
                    object.f((ByteString)object2);
                    break;
                }
                case 9: {
                    object = this.n;
                    object2 = this.g.b0();
                    object.d((ByteString)object2);
                    break;
                }
                case 8: {
                    Object object5;
                    n10 = 1005;
                    object2 = this.g;
                    long l13 = ((m)object2).S0();
                    long l14 = 1L;
                    Object object6 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
                    if (object6 == false) break block10;
                    object6 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
                    if (object6 != false) {
                        object = this.g;
                        n10 = ((m)object).readShort();
                        object2 = this.g.f0();
                        object5 = g.h0.q.g.w.b(n10);
                        if (object5 != null) {
                            object = new ProtocolException((String)object5);
                            throw object;
                        }
                    } else {
                        object2 = "";
                    }
                    object5 = this.n;
                    object5.g(n10, (String)object2);
                    n10 = 1;
                    this.a = n10;
                }
            }
            return;
        }
        object = new ProtocolException("Malformed close payload length of 1.");
        throw object;
    }

    public final o a() {
        return this.m;
    }

    public void close() {
        c c10 = this.i;
        if (c10 != null) {
            c10.close();
        }
    }

    public final void h() {
        this.B();
        boolean bl2 = this.e;
        if (bl2) {
            this.q();
        } else {
            this.D();
        }
    }
}

