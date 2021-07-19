/*
 * Decompiled with CFR 0.151.
 */
package g.h0.g;

import f.h2.t.f0;
import f.q1;
import g.h0.d;
import g.h0.g.a;
import g.h0.g.b;
import h.m;
import h.m0;
import h.o0;
import java.io.Closeable;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public final class b$b
implements m0 {
    private final o0 a;
    private a b;
    private long c;
    public final /* synthetic */ b d;

    public b$b(b object) {
        this.d = object;
        Object object2 = new o0();
        this.a = object2;
        object = ((b)object).f();
        f0.m(object);
        object = ((RandomAccessFile)object).getChannel();
        f0.o(object, "file!!.channel");
        this.b = object2 = new a((FileChannel)object);
    }

    public void close() {
        Object object = this.b;
        if (object == null) {
            return;
        }
        object = null;
        this.b = null;
        b b10 = this.d;
        synchronized (b10) {
            block14: {
                Object object2 = this.d;
                int n10 = ((b)object2).g() + -1;
                ((b)object2).q(n10);
                object2 = this.d;
                int n11 = ((b)object2).g();
                if (n11 == 0) {
                    object2 = this.d;
                    object2 = ((b)object2).f();
                    b b11 = this.d;
                    b11.p(null);
                    object = object2;
                }
                object2 = q1.a;
                if (object == null) break block14;
                g.h0.d.l((Closeable)object);
            }
            return;
            finally {
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public long read(m m10, long l10) {
        Object object;
        Object object2;
        long l11;
        long l12;
        long l13;
        long l14;
        Object object3;
        Object object4;
        long l15;
        b$b b$b;
        block34: {
            b b10;
            int n10;
            b b11;
            int n11;
            block33: {
                b$b = this;
                l15 = l10;
                f0.p(m10, "sink");
                object4 = this.b;
                n11 = 1;
                if (object4 != null) {
                    object3 = n11;
                } else {
                    object3 = 0;
                    object4 = null;
                }
                if (object3 == 0) {
                    object4 = "Check failed.".toString();
                    IllegalStateException illegalStateException = new IllegalStateException((String)object4);
                    throw illegalStateException;
                }
                b11 = b$b.d;
                // MONITORENTER : b11
                while (true) {
                    object4 = b$b.d;
                    l14 = ((b)object4).j();
                    long l16 = b$b.c - l14;
                    object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                    n10 = 2;
                    float f10 = 2.8E-45f;
                    l13 = -1;
                    if (object3 != 0) {
                        object4 = b$b.d;
                        l12 = ((b)object4).j();
                        object4 = b$b.d;
                        object4 = ((b)object4).c();
                        long l17 = ((m)object4).S0();
                        l17 = b$b.c;
                        long l18 = l17 - (l12 -= l17);
                        object3 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                        if (object3 >= 0) {
                            object4 = b$b.d;
                            l14 = ((b)object4).j();
                            l13 = b$b.c;
                            l14 -= l13;
                            l13 = Math.min(l15, l14);
                            object4 = b$b.d;
                            m m11 = ((b)object4).c();
                            long l19 = b$b.c;
                            l14 = l19 - l12;
                            m m12 = m10;
                            long l20 = l14;
                            l14 = l13;
                            m11.s0(m10, l20, l13);
                            b$b.c = l15 = b$b.c + l13;
                            // MONITOREXIT : b11
                            return l13;
                        }
                        n11 = n10;
                        break block33;
                    }
                    object4 = b$b.d;
                    object3 = ((b)object4).e();
                    if (object3 != 0) {
                        // MONITOREXIT : b11
                        return l13;
                    }
                    object4 = b$b.d;
                    if ((object4 = ((b)object4).k()) == null) break;
                    object4 = b$b.a;
                    b10 = b$b.d;
                    ((o0)object4).k(b10);
                }
                object4 = b$b.d;
                Thread thread = Thread.currentThread();
                ((b)object4).t(thread);
            }
            // MONITOREXIT : b11
            l12 = 32;
            if (n11 == n10) {
                l14 = b$b.d.j();
                long l21 = b$b.c;
                l14 -= l21;
                l21 = Math.min(l15, l14);
                a a10 = b$b.b;
                f0.m(a10);
                long l22 = b$b.c + l12;
                l14 = l21;
                a10.a(l22, m10, l21);
                b$b.c = l15 = b$b.c + l21;
                return l21;
            }
            b11 = null;
            try {
                object4 = b$b.d;
                object4 = ((b)object4).h();
                f0.m(object4);
                Object object5 = b$b.d;
                object5 = ((b)object5).i();
                b10 = b$b.d;
                l14 = b10.d();
                l11 = object4.read((m)object5, l14);
                object3 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
                if (object3 != 0) break block34;
                object4 = b$b.d;
                l15 = ((b)object4).j();
                ((b)object4).b(l15);
                b b12 = b$b.d;
            }
            catch (Throwable throwable) {
                object2 = b$b.d;
                // MONITORENTER : object2
                object = b$b.d;
                ((b)object).t(null);
                object = b$b.d;
                if (object == null) {
                    object = "null cannot be cast to non-null type java.lang.Object";
                    NullPointerException nullPointerException = new NullPointerException((String)object);
                    throw nullPointerException;
                }
                object.notifyAll();
                object = q1.a;
                // MONITOREXIT : object2
                throw throwable;
            }
            object4 = b$b.d;
            ((b)object4).t(null);
            object4 = b$b.d;
            if (object4 != null) {
                object4.notifyAll();
                object4 = q1.a;
                // MONITOREXIT : b12
                return l13;
            }
            String string2 = "null cannot be cast to non-null type java.lang.Object";
            object4 = new NullPointerException(string2);
            throw object4;
        }
        l13 = Math.min(l11, l15);
        object4 = b$b.d;
        object2 = ((b)object4).i();
        object = m10;
        long l23 = 0L;
        l14 = l13;
        ((m)object2).s0(m10, l23, l13);
        b$b.c = l15 = b$b.c + l13;
        a a11 = b$b.b;
        f0.m(a11);
        object4 = b$b.d;
        l15 = ((b)object4).j() + l12;
        object4 = b$b.d;
        object4 = ((b)object4).i();
        m m13 = ((m)object4).E();
        l23 = l11;
        l11 = l15;
        a11.b(l15, m13, l23);
        object2 = b$b.d;
        // MONITORENTER : object2
        object4 = b$b.d;
        object4 = ((b)object4).c();
        object = b$b.d;
        object = ((b)object).i();
        ((m)object4).t((m)object, l23);
        object4 = b$b.d;
        object4 = ((b)object4).c();
        l14 = ((m)object4).S0();
        object4 = b$b.d;
        l12 = ((b)object4).d();
        object3 = l14 == l12 ? 0 : (l14 < l12 ? -1 : 1);
        if (object3 > 0) {
            object4 = b$b.d;
            object4 = ((b)object4).c();
            object = b$b.d;
            object = ((b)object).c();
            l14 = ((m)object).S0();
            object = b$b.d;
            l12 = ((b)object).d();
            ((m)object4).skip(l14 -= l12);
        }
        object4 = b$b.d;
        l14 = ((b)object4).j() + l23;
        ((b)object4).s(l14);
        object4 = q1.a;
        object2 = b$b.d;
        // MONITORENTER : object2
        object4 = b$b.d;
        ((b)object4).t(null);
        object4 = b$b.d;
        if (object4 != null) {
            object4.notifyAll();
            // MONITOREXIT : object2
            return l13;
        }
        object = "null cannot be cast to non-null type java.lang.Object";
        object4 = new NullPointerException((String)object);
        throw object4;
    }

    public o0 timeout() {
        return this.a;
    }
}

