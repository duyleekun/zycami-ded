/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import g.h0.d;
import g.h0.l.b$b;
import g.h0.l.c;
import g.h0.l.h$a;
import g.h0.l.k;
import h.m;
import h.n;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.ErrorCode;
import okio.ByteString;

public final class h
implements Closeable {
    private static final Logger g;
    public static final h$a h;
    private final m a;
    private int b;
    private boolean c;
    private final b$b d;
    private final n e;
    private final boolean f;

    static {
        h$a h$a;
        h = h$a = new h$a(null);
        g = Logger.getLogger(c.class.getName());
    }

    public h(n object, boolean bl2) {
        m m10;
        f0.p(object, "sink");
        this.e = object;
        this.f = bl2;
        this.a = m10 = new m();
        this.b = 16384;
        this.d = object = new b$b(0, false, m10, 3, null);
    }

    private final void s0(int n10, long l10) {
        long l11;
        long l12;
        long l13;
        while ((l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            n n11;
            l13 = this.b;
            long l14 = Math.min(l13, l10);
            int n12 = (int)l14;
            int n13 = 9;
            long l15 = (l10 -= l14) - l11;
            Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object == false) {
                object = 4;
            } else {
                object = 0;
                n11 = null;
            }
            this.C(n10, n12, n13, (int)object);
            n11 = this.e;
            m m10 = this.a;
            n11.t(m10, l14);
        }
    }

    public final void B(int n10, int n11, m m10, int n12) {
        this.C(n10, n12, 0, n11);
        if (n12 > 0) {
            n n13 = this.e;
            f0.m(m10);
            long l10 = n12;
            n13.t(m10, l10);
        }
    }

    public final void C(int n10, int n11, int n12, int n13) {
        c c10;
        Logger logger = g;
        Object object = Level.FINE;
        boolean bl2 = logger.isLoggable((Level)object);
        if (bl2) {
            c10 = g.h0.l.c.x;
            object = c10.c(false, n10, n11, n12, n13);
            logger.fine((String)object);
        }
        int n14 = this.b;
        bl2 = true;
        c10 = null;
        if (n11 <= n14) {
            n14 = (int)(bl2 ? 1 : 0);
        } else {
            n14 = 0;
            logger = null;
        }
        if (n14 != 0) {
            long l10 = 0x80000000L;
            n14 = (int)l10 & n10;
            if (n14 != 0) {
                bl2 = false;
                object = null;
            }
            if (bl2) {
                g.h0.d.k0(this.e, n11);
                n n15 = this.e;
                n15.writeByte(n12 &= 0xFF);
                n15 = this.e;
                n12 = n13 & 0xFF;
                n15.writeByte(n12);
                n15 = this.e;
                n15.writeInt(n10 &= -1 >>> 1);
                return;
            }
            Serializable serializable = new StringBuilder();
            serializable.append("reserved bit set: ");
            serializable.append(n10);
            String string2 = serializable.toString();
            string2 = string2.toString();
            serializable = new IllegalArgumentException(string2);
            throw serializable;
        }
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("FRAME_SIZE_ERROR length > ");
        n12 = this.b;
        ((StringBuilder)charSequence).append(n12);
        ((StringBuilder)charSequence).append(": ");
        ((StringBuilder)charSequence).append(n11);
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = ((Object)charSequence).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence);
        throw illegalArgumentException;
    }

    public final b$b D() {
        return this.d;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void E(int n10, ErrorCode object, byte[] byArray) {
        synchronized (this) {
            Object object2 = "errorCode";
            f0.p(object, (String)object2);
            object2 = "debugData";
            f0.p(byArray, (String)object2);
            int n11 = this.c;
            if (n11 != 0) {
                object = "closed";
                IOException iOException = new IOException((String)object);
                throw iOException;
            }
            n11 = ((ErrorCode)((Object)object)).getHttpCode();
            int n12 = -1;
            int n13 = 1;
            int n14 = 0;
            if (n11 != n12) {
                n11 = n13;
            } else {
                n11 = 0;
                object2 = null;
            }
            if (n11 == 0) {
                String string2 = "errorCode.httpCode == -1";
                string2 = string2.toString();
                object = new IllegalArgumentException(string2);
                throw object;
            }
            n11 = byArray.length + 8;
            n12 = 7;
            this.C(0, n11, n12, 0);
            object2 = this.e;
            object2.writeInt(n10);
            n n15 = this.e;
            int n16 = ((ErrorCode)((Object)object)).getHttpCode();
            n15.writeInt(n16);
            n10 = byArray.length;
            if (n10 == 0) {
                n14 = n13;
            }
            if ((n10 = n14 ^ 1) != 0) {
                n15 = this.e;
                n15.write(byArray);
            }
            n15 = this.e;
            n15.flush();
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void O(boolean bl2, int n10, List object) {
        synchronized (this) {
            void var2_3;
            m m10;
            int n11;
            m m11;
            Object object2 = "headerBlock";
            f0.p(m11, (String)object2);
            boolean bl3 = this.c;
            if (bl3) {
                String string2 = "closed";
                IOException iOException = new IOException(string2);
                throw iOException;
            }
            object2 = this.d;
            ((b$b)object2).g((List)((Object)m11));
            m11 = this.a;
            long l10 = m11.S0();
            int n12 = this.b;
            long l11 = n12;
            l11 = Math.min(l11, l10);
            n12 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
            if (n12 == 0) {
                n11 = 4;
            } else {
                n11 = 0;
                m10 = null;
            }
            if (bl2) {
                n11 |= 1;
            }
            int n13 = (int)l11;
            int n14 = 1;
            this.C((int)var2_3, n13, n14, n11);
            n n15 = this.e;
            m10 = this.a;
            n15.t(m10, l11);
            if (n12 > 0) {
                this.s0((int)var2_3, l10 -= l11);
            }
            return;
        }
    }

    public final int S() {
        return this.b;
    }

    public final void a(k object) {
        synchronized (this) {
            Object object2;
            block12: {
                int n10;
                int n11;
                int n12;
                block13: {
                    object2 = "peerSettings";
                    f0.p(object, (String)object2);
                    n12 = this.c;
                    if (n12 != 0) break block12;
                    n12 = this.b;
                    n12 = ((k)object).g(n12);
                    this.b = n12;
                    n12 = ((k)object).d();
                    n11 = -1;
                    if (n12 == n11) break block13;
                    object2 = this.d;
                    n10 = ((k)object).d();
                    ((b$b)object2).e(n10);
                }
                n10 = 4;
                n12 = 1;
                n11 = 0;
                this.C(0, 0, n10, n12);
                object = this.e;
                object.flush();
                return;
            }
            object2 = "closed";
            object = new IOException((String)object2);
            throw object;
        }
    }

    public void close() {
        synchronized (this) {
            boolean bl2 = true;
            this.c = bl2;
            n n10 = this.e;
            n10.close();
            return;
        }
    }

    public final void flush() {
        synchronized (this) {
            Object object;
            block6: {
                boolean bl2 = this.c;
                if (bl2) break block6;
                object = this.e;
                object.flush();
                return;
            }
            String string2 = "closed";
            object = new IOException(string2);
            throw object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void h() {
        synchronized (this) {
            boolean bl2 = this.c;
            if (bl2) {
                String string2 = "closed";
                IOException iOException = new IOException(string2);
                throw iOException;
            }
            bl2 = this.f;
            if (!bl2) {
                return;
            }
            Object object = g;
            Object object2 = Level.FINE;
            boolean bl3 = ((Logger)object).isLoggable((Level)object2);
            if (bl3) {
                object2 = new StringBuilder();
                Object[] objectArray = ">> CONNECTION ";
                ((StringBuilder)object2).append((String)objectArray);
                objectArray = g.h0.l.c.a;
                objectArray = objectArray.hex();
                ((StringBuilder)object2).append((String)objectArray);
                object2 = ((StringBuilder)object2).toString();
                objectArray = null;
                objectArray = new Object[]{};
                object2 = g.h0.d.v((String)object2, objectArray);
                ((Logger)object).fine((String)object2);
            }
            object = this.e;
            object2 = g.h0.l.c.a;
            object.h0((ByteString)object2);
            object = this.e;
            object.flush();
            return;
        }
    }

    public final void n0(boolean bl2, int n10, int n11) {
        synchronized (this) {
            Object object;
            block9: {
                int n12;
                int n13;
                block10: {
                    n13 = this.c;
                    if (n13 != 0) break block9;
                    n13 = 8;
                    n12 = 6;
                    if (bl2) {
                        bl2 = true;
                        break block10;
                    }
                    bl2 = false;
                    object = null;
                }
                this.C(0, n13, n12, (int)(bl2 ? 1 : 0));
                object = this.e;
                object.writeInt(n10);
                object = this.e;
                object.writeInt(n11);
                object = this.e;
                object.flush();
                return;
            }
            String string2 = "closed";
            object = new IOException(string2);
            throw object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void o0(int n10, int n11, List object) {
        synchronized (this) {
            Object object2 = "requestHeaders";
            f0.p(object, (String)object2);
            boolean bl2 = this.c;
            if (bl2) {
                String string2 = "closed";
                IOException iOException = new IOException(string2);
                throw iOException;
            }
            object2 = this.d;
            ((b$b)object2).g((List)object);
            object = this.a;
            long l10 = ((m)object).S0();
            int n12 = this.b;
            long l11 = n12;
            long l12 = 4;
            l11 -= l12;
            l11 = Math.min(l11, l10);
            n12 = (int)l11;
            int n13 = n12 + 4;
            int n14 = 5;
            l12 = n12;
            n12 = (int)(l10 == l12 ? 0 : (l10 < l12 ? -1 : 1));
            int n15 = n12 == 0 ? 4 : 0;
            this.C(n10, n13, n14, n15);
            n n16 = this.e;
            n14 = -1 >>> 1;
            n16.writeInt(n11 &= n14);
            n n17 = this.e;
            n16 = this.a;
            n17.t((m)n16, l12);
            if (n12 > 0) {
                this.s0(n10, l10 -= l12);
            }
            return;
        }
    }

    public final void p0(int n10, ErrorCode object) {
        synchronized (this) {
            Object object2;
            block14: {
                block15: {
                    String string2 = "errorCode";
                    f0.p(object, string2);
                    int n11 = this.c;
                    if (n11 != 0) break block14;
                    n11 = ((ErrorCode)((Object)object)).getHttpCode();
                    int n12 = -1;
                    if (n11 != n12) {
                        n11 = 1;
                    } else {
                        n11 = 0;
                        string2 = null;
                    }
                    if (n11 == 0) break block15;
                    n11 = 4;
                    n12 = 3;
                    this.C(n10, n11, n12, 0);
                    object2 = this.e;
                    int n13 = ((ErrorCode)((Object)object)).getHttpCode();
                    object2.writeInt(n13);
                    object2 = this.e;
                    object2.flush();
                    return;
                }
                object2 = "Failed requirement.";
                object2 = object2.toString();
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
            object = "closed";
            object2 = new IOException((String)object);
            throw object2;
        }
    }

    public final void q(boolean bl2, int n10, m m10, int n11) {
        synchronized (this) {
            block5: {
                int n12;
                block6: {
                    boolean n122 = this.c;
                    if (n122) break block5;
                    boolean bl3 = false;
                    if (!bl2) break block6;
                    n12 = 1;
                }
                this.B(n10, n12, m10, n11);
                return;
            }
            String string2 = "closed";
            IOException iOException = new IOException(string2);
            throw iOException;
        }
    }

    public final void q0(k object) {
        synchronized (this) {
            String string2;
            block15: {
                string2 = "settings";
                f0.p(object, string2);
                int n10 = this.c;
                if (n10 != 0) break block15;
                n10 = ((k)object).l() * 6;
                int n11 = 4;
                this.C(0, n10, n11, 0);
                n10 = 10;
                for (int i10 = 0; i10 < n10; ++i10) {
                    int n12;
                    block16: {
                        n12 = ((k)object).i(i10);
                        if (n12 == 0) continue;
                        if (i10 != n11) {
                            int n12 = 7;
                            n12 = i10 != n12 ? i10 : n11;
                            break block16;
                        }
                        n12 = 3;
                    }
                    n n13 = this.e;
                    n13.writeShort(n12);
                    n n14 = this.e;
                    int n15 = ((k)object).b(i10);
                    n14.writeInt(n15);
                }
                object = this.e;
                object.flush();
                return;
            }
            string2 = "closed";
            object = new IOException(string2);
            throw object;
        }
    }

    public final void r0(int n10, long l10) {
        synchronized (this) {
            Object object;
            block15: {
                String string2;
                block16: {
                    long l11;
                    long l12;
                    Object object2 = this.c;
                    if (object2 != 0) break block15;
                    long l13 = 0L;
                    long l14 = l10 - l13;
                    object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                    if (object2 != 0 && (object2 = (l12 = l10 - (l11 = Integer.MAX_VALUE)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0) {
                        object2 = 1;
                    } else {
                        object2 = 0;
                        string2 = null;
                    }
                    if (object2 == 0) break block16;
                    object2 = 4;
                    int n11 = 8;
                    this.C(n10, (int)object2, n11, 0);
                    object = this.e;
                    int n12 = (int)l10;
                    object.writeInt(n12);
                    object = this.e;
                    object.flush();
                    return;
                }
                object = new StringBuilder();
                string2 = "windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: ";
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(l10);
                object = ((StringBuilder)object).toString();
                object = object.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                throw illegalArgumentException;
            }
            String string3 = "closed";
            object = new IOException(string3);
            throw object;
        }
    }
}

