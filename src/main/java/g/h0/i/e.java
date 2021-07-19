/*
 * Decompiled with CFR 0.151.
 */
package g.h0.i;

import f.h2.t.f0;
import f.q1;
import f.x1.y;
import g.a;
import g.a0;
import g.b;
import g.c;
import g.c0;
import g.f;
import g.h0.i.d;
import g.h0.i.e$a;
import g.h0.i.e$b;
import g.h0.i.e$c;
import g.h0.i.g;
import g.h0.j.j;
import g.h0.n.h;
import g.m;
import g.o;
import g.p;
import g.q;
import g.t;
import g.z;
import h.k;
import h.o0;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.CertificatePinner;
import okhttp3.internal.connection.RealConnection;

public final class e
implements g.e {
    private final g a;
    private final q b;
    private final e$c c;
    private final AtomicBoolean d;
    private Object e;
    private d f;
    private RealConnection g;
    private boolean h;
    private g.h0.i.c i;
    private boolean j;
    private boolean k;
    private boolean l;
    private volatile boolean m;
    private volatile g.h0.i.c n;
    private volatile RealConnection o;
    private final z p;
    private final a0 q;
    private final boolean r;

    public e(z object, a0 object2, boolean bl2) {
        f0.p(object, "client");
        f0.p(object2, "originalRequest");
        this.p = object;
        this.q = object2;
        this.r = bl2;
        this.a = object2 = object.O().c();
        this.b = object2 = object.U().a(this);
        object2 = new e$c(this);
        long l10 = object.K();
        object = TimeUnit.MILLISECONDS;
        ((o0)object2).i(l10, (TimeUnit)((Object)object));
        object = q1.a;
        this.c = object2;
        this.d = object;
        this.l = true;
    }

    private final IOException B(IOException iOException) {
        boolean bl2 = this.h;
        if (bl2) {
            return iOException;
        }
        Object object = this.c;
        bl2 = ((k)object).w();
        if (!bl2) {
            return iOException;
        }
        String string2 = "timeout";
        object = new InterruptedIOException(string2);
        if (iOException != null) {
            ((Throwable)object).initCause(iOException);
        }
        return object;
    }

    private final String E() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl2 = this.isCanceled();
        String string2 = bl2 ? "canceled " : "";
        stringBuilder.append(string2);
        bl2 = this.r;
        string2 = bl2 ? "web socket" : "call";
        stringBuilder.append(string2);
        stringBuilder.append(" to ");
        string2 = this.v();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static final /* synthetic */ e$c a(e e10) {
        return e10.c;
    }

    public static final /* synthetic */ String b(e e10) {
        return e10.E();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final IOException d(IOException object) {
        Object object2;
        boolean bl2;
        boolean bl3 = g.h0.d.h;
        if (bl3 && (bl2 = Thread.holdsLock(this))) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Thread ");
            Object object3 = Thread.currentThread();
            f0.o(object3, "Thread.currentThread()");
            object3 = ((Thread)object3).getName();
            charSequence.append((String)object3);
            charSequence.append(" MUST NOT hold lock on ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            object = new AssertionError(charSequence);
            throw object;
        }
        RealConnection realConnection = this.g;
        if (realConnection != null) {
            if (bl3 && (bl3 = Thread.holdsLock(realConnection))) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Thread ");
                Object object4 = Thread.currentThread();
                f0.o(object4, "Thread.currentThread()");
                object4 = ((Thread)object4).getName();
                charSequence.append((String)object4);
                charSequence.append(" MUST NOT hold lock on ");
                charSequence.append(realConnection);
                charSequence = charSequence.toString();
                object = new AssertionError(charSequence);
                throw object;
            }
            synchronized (realConnection) {
                object2 = this.w();
            }
            RealConnection realConnection2 = this.g;
            if (realConnection2 == null) {
                if (object2 != null) {
                    g.h0.d.n((Socket)object2);
                }
                object2 = this.b;
                ((q)object2).l(this, realConnection);
            } else {
                if (object2 == null) {
                    bl3 = true;
                } else {
                    bl3 = false;
                    object2 = null;
                }
                if (!bl3) {
                    object = "Check failed.".toString();
                    object2 = new IllegalStateException((String)object);
                    throw object2;
                }
            }
        }
        object2 = this.B((IOException)object);
        if (object != null) {
            object = this.b;
            f0.m(object2);
            ((q)object).e(this, (IOException)object2);
            return object2;
        }
        object = this.b;
        ((q)object).d(this);
        return object2;
    }

    private final void e() {
        Object object;
        this.e = object = g.h0.n.h.e.g().k("response.body().close()");
        this.b.f(this);
    }

    private final a g(t t10) {
        CertificatePinner certificatePinner;
        SSLSocketFactory sSLSocketFactory;
        Object object;
        Object object2;
        e e10 = this;
        boolean bl2 = t10.G();
        SSLSocketFactory sSLSocketFactory2 = null;
        if (bl2) {
            sSLSocketFactory2 = this.p.l0();
            object2 = this.p.Y();
            CertificatePinner certificatePinner2 = this.p.M();
            object = object2;
            sSLSocketFactory = sSLSocketFactory2;
            certificatePinner = certificatePinner2;
        } else {
            sSLSocketFactory = null;
            object = null;
            certificatePinner = null;
        }
        String string2 = t10.F();
        int n10 = t10.N();
        p p10 = e10.p.T();
        SocketFactory socketFactory = e10.p.k0();
        b b10 = e10.p.g0();
        Proxy proxy = e10.p.f0();
        List list = e10.p.e0();
        List list2 = e10.p.P();
        ProxySelector proxySelector = e10.p.h0();
        object2 = new a(string2, n10, p10, socketFactory, sSLSocketFactory, (HostnameVerifier)object, certificatePinner, b10, proxy, list, list2, proxySelector);
        return object2;
    }

    public final void A() {
        boolean bl2 = this.h;
        boolean bl3 = true;
        if (bl2 ^= bl3) {
            this.h = bl3;
            this.c.w();
            return;
        }
        String string2 = "Check failed.".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public a0 C() {
        return this.q;
    }

    public boolean D() {
        return this.d.get();
    }

    public void S(f object) {
        f0.p(object, "responseCallback");
        Object object2 = this.d;
        e$a e$a = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object2).compareAndSet(false, bl2);
        if (bl3) {
            this.e();
            object2 = this.p.R();
            e$a = new e$a(this, (f)object);
            ((o)object2).c(e$a);
            return;
        }
        object2 = "Already Executed".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public final void c(RealConnection object) {
        Object object2 = "connection";
        f0.p(object, (String)object2);
        boolean bl2 = g.h0.d.h;
        if (bl2 && !(bl2 = Thread.holdsLock(object))) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Object object3 = Thread.currentThread();
            f0.o(object3, "Thread.currentThread()");
            object3 = ((Thread)object3).getName();
            stringBuilder.append((String)object3);
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new AssertionError(object);
            throw object2;
        }
        object2 = this.g;
        if (object2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        if (bl2) {
            this.g = object;
            object = ((RealConnection)object).u();
            Object object4 = this.e;
            object2 = new e$b(this, object4);
            object.add(object2);
            return;
        }
        object2 = "Check failed.".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public void cancel() {
        boolean bl2 = this.m;
        if (bl2) {
            return;
        }
        this.m = bl2 = true;
        Object object = this.n;
        if (object != null) {
            ((g.h0.i.c)object).b();
        }
        if ((object = this.o) != null) {
            ((RealConnection)object).k();
        }
        this.b.g(this);
    }

    public c0 execute() {
        Object object = this.d;
        String string2 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = this.c;
            ((k)object).v();
            this.e();
            try {
                object = this.p;
                object = ((z)object).R();
                ((o)object).d(this);
                object = this.r();
                return object;
            }
            finally {
                this.p.R().i(this);
            }
        }
        string2 = "Already Executed".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public e f() {
        z z10 = this.p;
        a0 a02 = this.q;
        boolean bl2 = this.r;
        e e10 = new e(z10, a02, bl2);
        return e10;
    }

    public final void i(a0 object, boolean bl2) {
        boolean bl3;
        f0.p(object, "request");
        Object object2 = this.i;
        boolean bl4 = true;
        if (object2 == null) {
            bl3 = bl4;
        } else {
            bl3 = false;
            object2 = null;
        }
        if (bl3) {
            synchronized (this) {
                block16: {
                    block17: {
                        bl3 = this.k ^ bl4;
                        if (!bl3) break block16;
                        bl3 = this.j ^ bl4;
                        if (!bl3) break block17;
                        object2 = q1.a;
                        if (bl2) {
                            d d10;
                            object2 = this.a;
                            object = ((a0)object).q();
                            object = this.g((t)object);
                            q q10 = this.b;
                            this.f = d10 = new d((g)object2, (a)object, this, q10);
                        }
                        return;
                    }
                    object = "Check failed.";
                    object = object.toString();
                    IllegalStateException illegalStateException = new IllegalStateException((String)object);
                    throw illegalStateException;
                }
                object = "cannot make a new request because the previous response is still open: please call response.close()";
                object = object.toString();
                IllegalStateException illegalStateException = new IllegalStateException((String)object);
                throw illegalStateException;
            }
        }
        object = "Check failed.".toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public boolean isCanceled() {
        return this.m;
    }

    public final void j(boolean bl2) {
        synchronized (this) {
            block9: {
                g.h0.i.c c10;
                boolean bl3 = this.l;
                if (!bl3) break block9;
                q1 q12 = q1.a;
                if (bl2 && (c10 = this.n) != null) {
                    c10.d();
                }
                this.i = null;
                return;
            }
            String string2 = "released";
            string2 = string2.toString();
            IllegalStateException illegalStateException = new IllegalStateException(string2);
            throw illegalStateException;
        }
    }

    public final z k() {
        return this.p;
    }

    public final RealConnection l() {
        return this.g;
    }

    public final RealConnection m() {
        return this.o;
    }

    public final q n() {
        return this.b;
    }

    public final boolean o() {
        return this.r;
    }

    public final g.h0.i.c p() {
        return this.i;
    }

    public final a0 q() {
        return this.q;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final c0 r() {
        String string2;
        boolean bl2;
        Object object;
        block12: {
            g.h0.j.g g10;
            object = new ArrayList();
            List list = this.p.Z();
            y.q0(object, list);
            Object object2 = this.p;
            j j10 = new j((z)object2);
            object.add(j10);
            object2 = this.p.Q();
            g.h0.j.a a10 = new g.h0.j.a((m)object2);
            object.add(a10);
            object2 = this.p.J();
            g.h0.f.a a11 = new g.h0.f.a((c)object2);
            object.add(a11);
            g.h0.i.a a12 = g.h0.i.a.b;
            object.add(a12);
            bl2 = this.r;
            if (!bl2) {
                List list2 = this.p.b0();
                y.q0(object, list2);
            }
            boolean bl3 = this.r;
            g.h0.j.b b10 = new g.h0.j.b(bl3);
            object.add(b10);
            boolean bl4 = false;
            string2 = null;
            a0 a02 = this.q;
            int n10 = this.p.N();
            int n11 = this.p.i0();
            int n12 = this.p.n0();
            g.h0.j.g g11 = g10;
            object2 = this;
            g10 = new g.h0.j.g(this, (List)object, 0, null, a02, n10, n11, n12);
            bl2 = false;
            Object var2_12 = null;
            bl3 = false;
            object2 = null;
            object = this.q;
            object = g10.c((a0)object);
            bl4 = this.isCanceled();
            if (bl4) break block12;
            this.u(null);
            return object;
        }
        g.h0.d.l((Closeable)object);
        string2 = "Canceled";
        try {
            object = new IOException(string2);
            throw object;
        }
        catch (Throwable throwable) {
        }
        catch (IOException iOException) {
            boolean bl5 = true;
            IOException iOException2 = this.u(iOException);
            if (iOException2 != null) throw iOException2;
            string2 = "null cannot be cast to non-null type kotlin.Throwable";
            try {
                NullPointerException nullPointerException = new NullPointerException(string2);
                throw nullPointerException;
            }
            catch (Throwable throwable) {
                object = throwable;
                bl2 = bl5;
            }
        }
        if (bl2) throw object;
        this.u(null);
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final g.h0.i.c s(g.h0.j.g object) {
        boolean bl2;
        Object object2 = "chain";
        f0.p(object, (String)object2);
        synchronized (this) {
            boolean bl3 = this.l;
            if (!bl3) {
                object = "released";
                object = object.toString();
                object2 = new IllegalStateException((String)object);
                throw object2;
            }
            bl3 = this.k;
            bl2 = true;
            if (!(bl3 ^= bl2)) {
                object = "Check failed.";
                object = object.toString();
                object2 = new IllegalStateException((String)object);
                throw object2;
            }
            bl3 = this.j ^ bl2;
            if (!bl3) {
                object = "Check failed.";
                object = object.toString();
                object2 = new IllegalStateException((String)object);
                throw object2;
            }
            object2 = q1.a;
        }
        object2 = this.f;
        f0.m(object2);
        Object object3 = this.p;
        object = ((d)object2).a((z)object3, (g.h0.j.g)object);
        q q10 = this.b;
        this.i = object3 = new g.h0.i.c(this, q10, (d)object2, (g.h0.j.d)object);
        this.n = object3;
        synchronized (this) {
            this.j = bl2;
            this.k = bl2;
        }
        boolean bl4 = this.m;
        if (!bl4) {
            return object3;
        }
        object = new IOException("Canceled");
        throw object;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final IOException t(g.h0.i.c var1_1, boolean var2_3, boolean var3_4, IOException var4_5) {
        f0.p(var1_1, "exchange");
        var5_6 = this.n;
        var6_7 = f0.g(var1_1, var5_6);
        var7_8 = true;
        var8_9 = 1.4E-45f;
        if (var6_7 ^= var7_8) {
            return var4_5;
        }
        synchronized (this) {
            block14: {
                var6_7 = false;
                var1_1 = null;
                if (!var2_3) break block14;
                try {
                    var9_10 = this.j;
                    if (!var9_10) {
                    }
                    ** GOTO lbl-1000
                }
                catch (Throwable var1_2) {
                    ** break block13
                }
            }
            if (var3_4 && (var9_10 = this.k)) lbl-1000:
            // 2 sources

            {
                if (var2_3) {
                    this.j = false;
                }
                if (var3_4) {
                    this.k = false;
                }
                var3_4 = (var2_3 = this.j) == false && (var3_4 = this.k) == false ? var7_8 : false;
                if (var2_3 || (var2_3 = this.k) || (var2_3 = this.l)) {
                    var7_8 = false;
                    var5_6 = null;
                    var8_9 = 0.0f;
                }
                var6_7 = var3_4;
            } else {
                var7_8 = false;
                var5_6 = null;
                var8_9 = 0.0f;
            }
            ** if (!var6_7) goto lbl42
        }
lbl-1000:
        // 1 sources

        {
            var6_7 = false;
            this.n = null;
            var1_1 = this.g;
            if (var1_1 != null) {
                var1_1.z();
            }
        }
lbl42:
        // 4 sources

        if (var7_8) {
            return this.d(var4_5);
        }
        return var4_5;
lbl-1000:
        // 1 sources

        {
            throw var1_2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final IOException u(IOException iOException) {
        boolean bl2;
        synchronized (this) {
            boolean bl3 = this.l;
            bl2 = false;
            if (bl3) {
                this.l = false;
                bl3 = this.j;
                if (!bl3 && !(bl3 = this.k)) {
                    bl2 = bl3 = true;
                }
            }
        }
        if (!bl2) return iOException;
        return this.d(iOException);
    }

    public final String v() {
        return this.q.q().V();
    }

    public final Socket w() {
        int n10;
        int n11;
        boolean bl2;
        Iterator iterator2;
        Object object;
        boolean bl3;
        Object object2;
        block7: {
            object2 = this.g;
            f0.m(object2);
            bl3 = g.h0.d.h;
            if (bl3 && !(bl3 = Thread.holdsLock(object2))) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Thread ");
                Object object3 = Thread.currentThread();
                f0.o(object3, "Thread.currentThread()");
                object3 = ((Thread)object3).getName();
                stringBuilder.append((String)object3);
                stringBuilder.append(" MUST hold lock on ");
                stringBuilder.append(object2);
                object2 = stringBuilder.toString();
                AssertionError assertionError = new AssertionError(object2);
                throw assertionError;
            }
            object = ((RealConnection)object2).u();
            iterator2 = object.iterator();
            bl2 = false;
            Object var5_8 = null;
            n11 = 0;
            while (true) {
                boolean bl4 = iterator2.hasNext();
                n10 = -1;
                if (!bl4) break;
                e e10 = (e)((Reference)iterator2.next()).get();
                bl4 = f0.g(e10, this);
                if (!bl4) {
                    ++n11;
                    continue;
                }
                break block7;
                break;
            }
            n11 = n10;
        }
        if (n11 != n10) {
            bl2 = true;
        }
        if (bl2) {
            object.remove(n11);
            iterator2 = null;
            this.g = null;
            bl3 = object.isEmpty();
            if (bl3) {
                long l10 = System.nanoTime();
                ((RealConnection)object2).I(l10);
                object = this.a;
                bl3 = ((g)object).c((RealConnection)object2);
                if (bl3) {
                    return ((RealConnection)object2).d();
                }
            }
            return null;
        }
        object = "Check failed.".toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public final boolean x() {
        d d10 = this.f;
        f0.m(d10);
        return d10.e();
    }

    public final void y(RealConnection realConnection) {
        this.o = realConnection;
    }

    public k z() {
        return this.c;
    }
}

