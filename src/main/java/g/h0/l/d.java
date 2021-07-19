/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import f.q1;
import g.h0.h.a;
import g.h0.h.c;
import g.h0.h.c$b;
import g.h0.l.d$a;
import g.h0.l.d$b;
import g.h0.l.d$c;
import g.h0.l.d$d;
import g.h0.l.d$e;
import g.h0.l.d$f;
import g.h0.l.d$g;
import g.h0.l.d$h;
import g.h0.l.d$i;
import g.h0.l.d$j;
import g.h0.l.d$k;
import g.h0.l.d$l;
import g.h0.l.f;
import g.h0.l.g;
import g.h0.l.h;
import g.h0.l.j;
import g.h0.l.k;
import h.m;
import h.n;
import h.o;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;

public final class d
implements Closeable {
    public static final int D = 0x1000000;
    private static final k E;
    public static final int F = 1;
    public static final int G = 2;
    public static final int H = 3;
    public static final int I = 1000000000;
    public static final d$c J;
    private final h A;
    private final d$e B;
    private final Set C;
    private final boolean a;
    private final d$d b;
    private final Map c;
    private final String d;
    private int e;
    private int f;
    private boolean g;
    private final g.h0.h.d h;
    private final c i;
    private final c j;
    private final c k;
    private final j l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;
    private long r;
    private long s;
    private final k t;
    private k u;
    private long v;
    private long w;
    private long x;
    private long y;
    private final Socket z;

    static {
        Object object = new d$c(null);
        J = object;
        object = new k();
        ((k)object).k(7, (char)-1);
        ((k)object).k(5, 16384);
        E = object;
    }

    /*
     * WARNING - void declaration
     */
    public d(d$b object) {
        long l10;
        c c10;
        void var5_8;
        int n10;
        Object object2 = "builder";
        f0.p(object, (String)object2);
        this.a = n10 = ((d$b)object).b();
        Object object3 = ((d$b)object).d();
        this.b = object3;
        object3 = new LinkedHashMap();
        this.c = object3;
        this.d = object3 = ((d$b)object).c();
        boolean n11 = ((d$b)object).b();
        if (n11) {
            int n12 = 3;
        } else {
            int n13 = 2;
        }
        this.f = var5_8;
        Object object4 = ((d$b)object).j();
        this.h = object4;
        this.i = c10 = ((g.h0.h.d)object4).j();
        Object object5 = ((g.h0.h.d)object4).j();
        this.j = object5;
        this.k = object4 = ((g.h0.h.d)object4).j();
        this.l = object4 = ((d$b)object).f();
        object4 = new k();
        boolean bl2 = ((d$b)object).b();
        if (bl2) {
            int n14 = 7;
            int n15 = 0x1000000;
            ((k)object4).k(n14, n15);
        }
        object5 = q1.a;
        this.t = object4;
        this.u = object4 = E;
        int n16 = ((k)object4).e();
        this.y = l10 = (long)n16;
        this.z = object4 = ((d$b)object).h();
        object5 = ((d$b)object).g();
        this.A = object4 = new h((n)object5, n10 != 0);
        o o10 = ((d$b)object).i();
        object5 = new f(o10, n10 != 0);
        this.B = object4 = new d$e(this, (f)object5);
        object2 = new LinkedHashSet();
        this.C = object2;
        n10 = ((d$b)object).e();
        if (n10 != 0) {
            object2 = TimeUnit.MILLISECONDS;
            int n17 = ((d$b)object).e();
            l10 = n17;
            l10 = ((TimeUnit)((Object)object2)).toNanos(l10);
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object3);
            object2 = " ping";
            ((StringBuilder)object).append((String)object2);
            String string2 = ((StringBuilder)object).toString();
            object = new d$a(string2, string2, this, l10);
            c10.n((a)object, l10);
        }
    }

    public static final /* synthetic */ k B() {
        return E;
    }

    public static final /* synthetic */ long C(d d10) {
        return d10.p;
    }

    public static final /* synthetic */ long D(d d10) {
        return d10.m;
    }

    public static final /* synthetic */ long E(d d10) {
        return d10.n;
    }

    public static final /* synthetic */ j O(d d10) {
        return d10.l;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private final g R0(int n10, List object, boolean n11) {
        h h10;
        Object object2;
        long l10;
        long l11;
        long l12;
        long l13;
        g g10;
        Object object3;
        boolean bl2 = n11 ^ 1;
        h h11 = this.A;
        // MONITORENTER : h11
        // MONITORENTER : this
        int n12 = this.f;
        int n13 = -1 >>> 2;
        if (n12 > n13) {
            object3 = ErrorCode.REFUSED_STREAM;
            this.g1((ErrorCode)((Object)object3));
        }
        if ((n12 = (int)(this.g ? 1 : 0)) != 0) {
            ConnectionShutdownException connectionShutdownException = new ConnectionShutdownException();
            throw connectionShutdownException;
        }
        int n14 = this.f;
        this.f = n12 = n14 + 2;
        object3 = g10;
        n13 = n14;
        Object object4 = this;
        g10 = new g(n14, this, bl2, false, null);
        n12 = 1;
        n11 = n11 != 0 && (n11 = (int)((l13 = (l12 = this.x) - (l11 = this.y)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) < 0 && (n11 = (int)((l10 = (l12 = g10.t()) - (l11 = g10.s())) == 0L ? 0 : (l10 < 0L ? -1 : 1))) < 0 ? 0 : n12;
        n13 = (int)(g10.w() ? 1 : 0);
        if (n13 != 0) {
            object2 = this.c;
            object4 = n14;
            object2.put(object4, g10);
        }
        object2 = q1.a;
        // MONITOREXIT : this
        if (n10 == 0) {
            h10 = this.A;
            h10.O(bl2, n14, (List)object);
        } else {
            n13 = (int)(this.a ? 1 : 0);
            if ((n12 ^= n13) == 0) {
                String string2 = "client streams shouldn't have associated stream IDs";
                string2 = string2.toString();
                object = new IllegalArgumentException(string2);
                throw object;
            }
            object3 = this.A;
            ((h)object3).o0(n10, n14, (List)object);
        }
        // MONITOREXIT : h11
        if (n11 == 0) return g10;
        h10 = this.A;
        h10.flush();
        return g10;
    }

    public static final /* synthetic */ c S(d d10) {
        return d10.k;
    }

    public static final /* synthetic */ void a(d d10, IOException iOException) {
        d10.z0(iOException);
    }

    public static final /* synthetic */ long h(d d10) {
        return d10.r;
    }

    public static /* synthetic */ void k1(d d10, boolean bl2, g.h0.h.d d11, int n10, Object object) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            bl2 = true;
        }
        if ((n10 &= 2) != 0) {
            d11 = g.h0.h.d.h;
        }
        d10.j1(bl2, d11);
    }

    public static final /* synthetic */ g.h0.h.d n0(d d10) {
        return d10.h;
    }

    public static final /* synthetic */ long o0(d d10) {
        return d10.y;
    }

    public static final /* synthetic */ c p0(d d10) {
        return d10.i;
    }

    public static final /* synthetic */ Set q(d d10) {
        return d10.C;
    }

    public static final /* synthetic */ boolean q0(d d10) {
        return d10.g;
    }

    public static final /* synthetic */ void r0(d d10, long l10) {
        d10.r = l10;
    }

    public static final /* synthetic */ void s0(d d10, long l10) {
        d10.p = l10;
    }

    public static final /* synthetic */ void t0(d d10, long l10) {
        d10.m = l10;
    }

    public static final /* synthetic */ void u0(d d10, long l10) {
        d10.n = l10;
    }

    public static final /* synthetic */ void v0(d d10, boolean bl2) {
        d10.g = bl2;
    }

    public static final /* synthetic */ void w0(d d10, long l10) {
        d10.y = l10;
    }

    private final void z0(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        this.y0(errorCode, errorCode, iOException);
    }

    public final boolean A0() {
        return this.a;
    }

    public final String B0() {
        return this.d;
    }

    public final int C0() {
        return this.e;
    }

    public final d$d D0() {
        return this.b;
    }

    public final int E0() {
        return this.f;
    }

    public final k F0() {
        return this.t;
    }

    public final k G0() {
        return this.u;
    }

    public final long H0() {
        return this.w;
    }

    public final long I0() {
        return this.v;
    }

    public final d$e J0() {
        return this.B;
    }

    public final Socket K0() {
        return this.z;
    }

    public final g L0(int n10) {
        synchronized (this) {
            Map map = this.c;
            Object object = n10;
            object = map.get(object);
            object = (g)object;
            return object;
        }
    }

    public final Map M0() {
        return this.c;
    }

    public final long N0() {
        return this.y;
    }

    public final long O0() {
        return this.x;
    }

    public final h P0() {
        return this.A;
    }

    public final boolean Q0(long l10) {
        synchronized (this) {
            block7: {
                int n10;
                block6: {
                    n10 = this.g;
                    if (n10 == 0) break block6;
                    return false;
                }
                long l11 = this.p;
                long l12 = this.o;
                n10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                if (n10 >= 0) break block7;
                l11 = this.s;
                long l13 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (l13 < 0) break block7;
                return false;
            }
            return true;
        }
    }

    public final g S0(List list, boolean bl2) {
        f0.p(list, "requestHeaders");
        return this.R0(0, list, bl2);
    }

    public final int T0() {
        synchronized (this) {
            Map map = this.c;
            int n10 = map.size();
            return n10;
        }
    }

    public final void U0(int n10, o object, int n11, boolean bl2) {
        f0.p(object, "source");
        m m10 = new m();
        long l10 = n11;
        object.L(l10);
        object.read(m10, l10);
        object = this.j;
        Object object2 = new StringBuilder();
        Object object3 = this.d;
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append('[');
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append("] onData");
        String string2 = ((StringBuilder)object2).toString();
        boolean bl3 = true;
        object3 = object2;
        object2 = new d$f(string2, bl3, string2, bl3, this, n10, m10, n11, bl2);
        ((c)object).n((a)object2, 0L);
    }

    public final void V0(int n10, List list, boolean bl2) {
        f0.p(list, "requestHeaders");
        c c10 = this.j;
        Object object = new StringBuilder();
        String string2 = this.d;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append('[');
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("] onHeaders");
        String string3 = ((StringBuilder)object).toString();
        boolean bl3 = true;
        object = new d$g(string3, bl3, string3, bl3, this, n10, list, bl2);
        c10.n((a)object, 0L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void W0(int n10, List object) {
        Comparable<Integer> comparable;
        Object object2 = "requestHeaders";
        f0.p(object, (String)object2);
        synchronized (this) {
            object2 = this.C;
            comparable = n10;
            boolean bl2 = object2.contains(comparable);
            if (bl2) {
                ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
                this.s1(n10, errorCode);
                return;
            }
            object2 = this.C;
            comparable = n10;
            object2.add(comparable);
        }
        object2 = this.j;
        comparable = new Comparable<Integer>();
        String string2 = this.d;
        ((StringBuilder)comparable).append(string2);
        ((StringBuilder)comparable).append('[');
        ((StringBuilder)comparable).append(n10);
        ((StringBuilder)comparable).append("] onRequest");
        String string3 = ((StringBuilder)comparable).toString();
        boolean bl3 = true;
        d$h d$h = new d$h(string3, bl3, string3, bl3, this, n10, (List)object);
        ((c)object2).n(d$h, 0L);
    }

    public final void X0(int n10, ErrorCode errorCode) {
        f0.p((Object)errorCode, "errorCode");
        c c10 = this.j;
        Object object = new StringBuilder();
        String string2 = this.d;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append('[');
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("] onReset");
        String string3 = ((StringBuilder)object).toString();
        boolean bl2 = true;
        object = new d$i(string3, bl2, string3, bl2, this, n10, errorCode);
        c10.n((a)object, 0L);
    }

    public final g Y0(int n10, List object, boolean bl2) {
        String string2 = "requestHeaders";
        f0.p(object, string2);
        boolean bl3 = this.a ^ true;
        if (bl3) {
            return this.R0(n10, (List)object, bl2);
        }
        object = "Client cannot push requests.".toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public final boolean Z0(int n10) {
        int n11 = 1;
        if (n10 == 0 || (n10 &= n11) != 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public final g a1(int n10) {
        synchronized (this) {
            Map map = this.c;
            Object object = n10;
            object = map.remove(object);
            object = (g)object;
            this.notifyAll();
            return object;
        }
    }

    public final void b1() {
        synchronized (this) {
            long l10;
            long l11;
            block7: {
                l11 = this.p;
                l10 = this.o;
                long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                if (l12 >= 0) break block7;
                return;
            }
            l11 = 1L;
            l10 += l11;
            this.o = l10;
            l11 = System.nanoTime();
            int n10 = 1000000000;
            l10 = n10;
            l11 += l10;
            this.s = l11;
            Object object = q1.a;
            object = this.i;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = this.d;
            stringBuilder.append(string2);
            stringBuilder.append(" ping");
            String string3 = stringBuilder.toString();
            boolean bl2 = true;
            d$j d$j = new d$j(string3, bl2, string3, bl2, this);
            ((c)object).n(d$j, 0L);
            return;
            finally {
            }
        }
    }

    public final void c1(int n10) {
        this.e = n10;
    }

    public void close() {
        ErrorCode errorCode = ErrorCode.NO_ERROR;
        ErrorCode errorCode2 = ErrorCode.CANCEL;
        this.y0(errorCode, errorCode2, null);
    }

    public final void d1(int n10) {
        this.f = n10;
    }

    public final void e1(k k10) {
        f0.p(k10, "<set-?>");
        this.u = k10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void f1(k object) {
        f0.p(object, "settings");
        h h10 = this.A;
        synchronized (h10) {
            synchronized (this) {
                boolean bl2 = this.g;
                if (!bl2) {
                    Object object2 = this.t;
                    ((k)object2).j((k)object);
                    object2 = q1.a;
                    // MONITOREXIT @DISABLED, blocks:[5, 6, 7] lbl10 : MonitorExitStatement: MONITOREXIT : this
                    object2 = this.A;
                    ((h)object2).q0((k)object);
                    return;
                }
                object = new ConnectionShutdownException();
                throw object;
            }
        }
    }

    public final void flush() {
        this.A.flush();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void g1(ErrorCode errorCode) {
        f0.p((Object)errorCode, "statusCode");
        h h10 = this.A;
        synchronized (h10) {
            Object object;
            int n10;
            synchronized (this) {
                n10 = this.g;
                if (n10 != 0) {
                    return;
                }
                this.g = n10 = 1;
                n10 = this.e;
                object = q1.a;
            }
            object = this.A;
            byte[] byArray = g.h0.d.a;
            ((h)object).E(n10, errorCode, byArray);
            return;
        }
    }

    public final void h1() {
        g.h0.l.d.k1(this, false, null, 3, null);
    }

    public final void i1(boolean bl2) {
        g.h0.l.d.k1(this, bl2, null, 2, null);
    }

    public final void j1(boolean c10, g.h0.h.d object) {
        Object object2;
        Object object3;
        c$b c$b;
        Object object4 = "taskRunner";
        f0.p(c$b, (String)object4);
        if (c10 != '\u0000') {
            this.A.h();
            object3 = this.A;
            object4 = this.t;
            ((h)object3).q0((k)object4);
            object3 = this.t;
            int n10 = ((k)object3).e();
            char c11 = (char)-1;
            if (n10 != c11) {
                object2 = this.A;
                int n11 = n10 - c11;
                long l10 = n11;
                ((h)object2).r0(0, l10);
            }
        }
        object3 = ((g.h0.h.d)((Object)c$b)).j();
        String string2 = this.d;
        object2 = this.B;
        boolean bl2 = true;
        object4 = c$b;
        c$b = new c$b((f.h2.s.a)object2, string2, bl2, string2, bl2);
        ((c)object3).n(c$b, 0L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void l1(long l10) {
        synchronized (this) {
            long l11;
            this.v = l11 = this.v + l10;
            l10 = this.w;
            l11 -= l10;
            k k10 = this.t;
            int n10 = k10.e();
            l10 = n10 / 2;
            n10 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
            if (n10 >= 0) {
                n10 = 0;
                k10 = null;
                this.t1(0, l11);
                this.w = l10 = this.w + l11;
            }
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void m1(int n10, boolean bl2, m m10, long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            this.A.q(bl2, n10, m10, 0);
            return;
        }
        while ((object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) > 0) {
            long l13;
            boolean bl3;
            Object object2;
            long l14;
            long l15;
            long l16;
            // MONITORENTER : this
            while ((object = (l16 = (l15 = this.x) - (l14 = this.y)) == 0L ? 0 : (l16 < 0L ? -1 : 1)) >= 0) {
                Map map = this.c;
                object2 = n10;
                object = map.containsKey(object2);
                if (object == false) {
                    String string2 = "stream closed";
                    IOException iOException = new IOException(string2);
                    throw iOException;
                }
                this.wait();
            }
            l14 -= l15;
            l15 = Math.min(l10, l14);
            object = (int)l15;
            object2 = this.A;
            int n11 = ((h)object2).S();
            object = Math.min((int)object, n11);
            l15 = this.x;
            l14 = object;
            this.x = l15 += l14;
            object2 = q1.a;
            object2 = this.A;
            bl3 = bl2 && !(bl3 = (l13 = (l10 -= l14) - l11) == 0L ? 0 : (l13 < 0L ? -1 : 1));
            ((h)object2).q(bl3, n10, m10, (int)object);
        }
        return;
        {
            catch (Throwable throwable) {
                throw throwable;
            }
            catch (InterruptedException interruptedException) {}
            {
                Object object3 = Thread.currentThread();
                ((Thread)object3).interrupt();
                object3 = new InterruptedIOException();
                throw object3;
            }
        }
    }

    public final void n1(int n10, boolean bl2, List list) {
        f0.p(list, "alternating");
        this.A.O(bl2, n10, list);
    }

    public final void o1() {
        synchronized (this) {
            long l10 = this.q;
            long l11 = 1L;
            l10 += l11;
            this.q = l10;
            // MONITOREXIT @DISABLED, blocks:[1, 2] lbl8 : MonitorExitStatement: MONITOREXIT : this
            this.p1(false, 3, 1330343787);
            return;
        }
    }

    public final void p1(boolean bl2, int n10, int n11) {
        h h10 = this.A;
        try {
            h10.n0(bl2, n10, n11);
        }
        catch (IOException iOException) {
            this.z0(iOException);
        }
    }

    public final void q1() {
        this.o1();
        this.x0();
    }

    public final void r1(int n10, ErrorCode errorCode) {
        f0.p((Object)errorCode, "statusCode");
        this.A.p0(n10, errorCode);
    }

    public final void s1(int n10, ErrorCode errorCode) {
        f0.p((Object)errorCode, "errorCode");
        c c10 = this.i;
        Object object = new StringBuilder();
        String string2 = this.d;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append('[');
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("] writeSynReset");
        String string3 = ((StringBuilder)object).toString();
        boolean bl2 = true;
        object = new d$k(string3, bl2, string3, bl2, this, n10, errorCode);
        c10.n((a)object, 0L);
    }

    public final void t1(int n10, long l10) {
        c c10 = this.i;
        Object object = new StringBuilder();
        String string2 = this.d;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append('[');
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("] windowUpdate");
        String string3 = ((StringBuilder)object).toString();
        boolean bl2 = true;
        object = new d$l(string3, bl2, string3, bl2, this, n10, l10);
        c10.n((a)object, 0L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void x0() {
        synchronized (this) {
            long l10;
            long l11;
            long l12;
            long l13;
            while ((l13 = (l12 = (l11 = this.r) - (l10 = this.q)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) < 0) {
                this.wait();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public final void y0(ErrorCode object, ErrorCode object2, IOException object3) {
        Object object4;
        CharSequence charSequence;
        f0.p(object, "connectionCode");
        Object object5 = "streamCode";
        f0.p(charSequence, (String)object5);
        int n10 = g.h0.d.h;
        if (n10 != 0 && (n10 = Thread.holdsLock(this)) != 0) {
            charSequence = new StringBuilder();
            charSequence.append("Thread ");
            object4 = Thread.currentThread();
            f0.o(object4, "Thread.currentThread()");
            object4 = ((Thread)object4).getName();
            charSequence.append((String)object4);
            charSequence.append(" MUST NOT hold lock on ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            object = new AssertionError(charSequence);
            throw object;
        }
        try {
            this.g1((ErrorCode)((Object)object));
        }
        catch (IOException iOException) {}
        object = null;
        // MONITORENTER : this
        object5 = this.c;
        n10 = object5.isEmpty() ^ 1;
        int n11 = 0;
        if (n10 != 0) {
            object = this.c;
            object = object.values();
            object5 = new g[0];
            if ((object = object.toArray((T[])object5)) == null) {
                charSequence = "null cannot be cast to non-null type kotlin.Array<T>";
                object = new NullPointerException((String)charSequence);
                throw object;
            }
            object = (g[])object;
            object5 = this.c;
            object5.clear();
        }
        object5 = q1.a;
        // MONITOREXIT : this
        if (object != null) {
            n10 = ((Object)object).length;
            while (n11 < n10) {
                Object object6 = object[n11];
                try {
                    ((g)object6).d((ErrorCode)((Object)charSequence), (IOException)object4);
                }
                catch (IOException iOException) {}
                ++n11;
            }
        }
        try {
            object = this.A;
            ((h)object).close();
        }
        catch (IOException iOException) {}
        try {
            object = this.z;
            ((Socket)object).close();
        }
        catch (IOException iOException) {}
        this.i.u();
        this.j.u();
        this.k.u();
    }
}

