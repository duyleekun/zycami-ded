/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.connection;

import f.h2.t.f0;
import f.q2.u;
import g.a;
import g.a0;
import g.a0$a;
import g.c0;
import g.c0$a;
import g.d0;
import g.e0;
import g.h;
import g.h0.h.d;
import g.h0.i.c;
import g.h0.i.e;
import g.h0.i.f;
import g.h0.i.g;
import g.h0.k.b;
import g.h0.l.d$b;
import g.h0.l.d$d;
import g.h0.n.h$a;
import g.h0.q.e$d;
import g.i;
import g.k;
import g.q;
import g.s;
import g.t;
import h.k0;
import h.m;
import h.m0;
import h.n;
import h.o;
import h.o0;
import h.z;
import java.io.Closeable;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.text.StringsKt__IndentKt;
import okhttp3.CertificatePinner;
import okhttp3.CertificatePinner$b;
import okhttp3.Handshake;
import okhttp3.Handshake$Companion;
import okhttp3.Protocol;
import okhttp3.Protocol$a;
import okhttp3.TlsVersion;
import okhttp3.internal.connection.RealConnection$a;
import okhttp3.internal.connection.RealConnection$b;
import okhttp3.internal.connection.RealConnection$connectTls$1;
import okhttp3.internal.connection.RealConnection$connectTls$2;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

public final class RealConnection
extends d$d
implements i {
    private static final String t = "throw with null exception";
    private static final int u = 21;
    public static final long v = 10000000000L;
    public static final RealConnection$a w;
    private Socket c;
    private Socket d;
    private Handshake e;
    private Protocol f;
    private g.h0.l.d g;
    private o h;
    private n i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private int o;
    private final List p;
    private long q;
    private final g r;
    private final e0 s;

    static {
        RealConnection$a realConnection$a;
        w = realConnection$a = new RealConnection$a(null);
    }

    public RealConnection(g arrayList, e0 e02) {
        f0.p(arrayList, "connectionPool");
        f0.p(e02, "route");
        this.r = arrayList;
        this.s = e02;
        this.o = 1;
        this.p = arrayList = new ArrayList();
        this.q = Long.MAX_VALUE;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean H(List iterator2) {
        boolean bl2 = iterator2 instanceof Collection;
        boolean bl3 = true;
        if (bl2 && (bl2 = iterator2.isEmpty())) {
            return false;
        }
        iterator2 = iterator2.iterator();
        do {
            InetSocketAddress inetSocketAddress;
            Proxy.Type type;
            Proxy.Type type2;
            if (!(bl2 = iterator2.hasNext())) return false;
            Object object = (e0)iterator2.next();
            Proxy.Type type3 = ((e0)object).e().type();
            if (type3 == (type2 = Proxy.Type.DIRECT) && (type = this.s.e().type()) == (type2 = Proxy.Type.DIRECT) && (bl2 = f0.g(inetSocketAddress = this.s.g(), object = ((e0)object).g()))) {
                bl2 = bl3;
                continue;
            }
            bl2 = false;
            object = null;
        } while (!bl2);
        return bl3;
    }

    private final void L(int n10) {
        int n11;
        g.h0.l.d d10;
        Socket socket = this.d;
        f0.m(socket);
        o o10 = this.h;
        f0.m(o10);
        n n12 = this.i;
        f0.m(n12);
        socket.setSoTimeout(0);
        Object object = g.h0.h.d.h;
        d$b d$b = new d$b(true, (d)object);
        object = this.s.d().w().F();
        this.g = d10 = d$b.y(socket, (String)object, o10, n12).k(this).l(n10).a();
        this.o = n11 = g.h0.l.d.J.a().f();
        g.h0.l.d.k1(d10, false, null, 3, null);
    }

    private final boolean M(t object) {
        boolean bl2 = g.h0.d.h;
        if (bl2 && !(bl2 = Thread.holdsLock(this))) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Thread ");
            Object object2 = Thread.currentThread();
            f0.o(object2, "Thread.currentThread()");
            object2 = ((Thread)object2).getName();
            charSequence.append((String)object2);
            charSequence.append(" MUST hold lock on ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            object = new AssertionError(charSequence);
            throw object;
        }
        Object object3 = this.s.d().w();
        int n10 = ((t)object).N();
        int n11 = ((t)object3).N();
        int n12 = 0;
        if (n10 != n11) {
            return false;
        }
        String string2 = ((t)object).F();
        object3 = ((t)object3).F();
        bl2 = f0.g(string2, object3);
        n10 = 1;
        if (bl2) {
            return n10;
        }
        bl2 = this.k;
        if (!bl2 && (object3 = this.e) != null) {
            f0.m(object3);
            boolean bl3 = this.l((t)object, (Handshake)object3);
            if (bl3) {
                n12 = n10;
            }
        }
        return n12;
    }

    public static final /* synthetic */ Handshake g(RealConnection realConnection) {
        return realConnection.e;
    }

    public static final /* synthetic */ Socket h(RealConnection realConnection) {
        return realConnection.d;
    }

    public static final /* synthetic */ void i(RealConnection realConnection, Handshake handshake2) {
        realConnection.e = handshake2;
    }

    public static final /* synthetic */ void j(RealConnection realConnection, Socket socket) {
        realConnection.d = socket;
    }

    private final boolean l(t object, Handshake object2) {
        boolean bl2;
        block3: {
            block2: {
                object2 = ((Handshake)object2).m();
                boolean bl3 = object2.isEmpty();
                bl2 = true;
                if (!(bl3 ^= bl2)) break block2;
                g.h0.p.d d10 = g.h0.p.d.c;
                object = ((t)object).F();
                object2 = object2.get(0);
                String string2 = "null cannot be cast to non-null type java.security.cert.X509Certificate";
                Objects.requireNonNull(object2, string2);
                object2 = (X509Certificate)object2;
                boolean bl4 = d10.c((String)object, (X509Certificate)object2);
                if (bl4) break block3;
            }
            bl2 = false;
        }
        return bl2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final void o(int var1_1, int var2_2, g.e var3_3, q var4_4) {
        block14: {
            var5_5 = this.s.e();
            var6_6 = this.s.d();
            var7_7 /* !! */  = var5_5.type();
            if (var7_7 /* !! */  == null) ** GOTO lbl-1000
            var8_8 = g.h0.i.f.a;
            var9_9 = var7_7 /* !! */ .ordinal();
            var10_10 = 1;
            if ((var9_9 = var8_8[var9_9]) != var10_10 && var9_9 != (var10_10 = 2)) lbl-1000:
            // 2 sources

            {
                var6_6 = new Socket(var5_5);
            } else {
                var6_6 = var6_6.u().createSocket();
                f0.m(var6_6);
            }
            this.c = var6_6;
            var7_7 /* !! */  = this.s.g();
            var4_4.j((g.e)var3_3, (InetSocketAddress)var7_7 /* !! */ , var5_5);
            var6_6.setSoTimeout(var2_2);
            try {
                var11_11 = g.h0.n.h.e;
            }
            catch (ConnectException var12_14) {
                var3_3 = new StringBuilder();
                var3_3.append("Failed to connect to ");
                var4_4 = this.s.g();
                var3_3.append(var4_4);
                var3_3 = var3_3.toString();
                var11_11 = new ConnectException((String)var3_3);
                var11_11.initCause(var12_14);
                throw var11_11;
            }
            var11_11 = var11_11.g();
            var3_3 = this.s;
            var3_3 = var3_3.g();
            var11_11.g((Socket)var6_6, (InetSocketAddress)var3_3, var1_1);
            var12_12 /* !! */  = z.n((Socket)var6_6);
            var12_12 /* !! */  = z.d(var12_12 /* !! */ );
            this.h = var12_12 /* !! */ ;
            var12_12 /* !! */  = z.i((Socket)var6_6);
            var12_12 /* !! */  = z.c((k0)var12_12 /* !! */ );
            try {
                this.i = var12_12 /* !! */ ;
            }
            catch (NullPointerException var12_13) {
                var11_11 = var12_13.getMessage();
                var3_3 = "throw with null exception";
                var2_2 = (int)f0.g(var11_11, var3_3);
                if (var2_2 != 0) break block14;
            }
            return;
        }
        var11_11 = new IOException(var12_13);
        throw var11_11;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void p(g.h0.i.b object) {
        void var1_4;
        Object object2;
        Object object3;
        block17: {
            block16: {
                object3 = this.s.d();
                Object object4 = ((a)object3).v();
                object2 = null;
                f0.m(object4);
                Object object5 = this.c;
                Object object6 = ((a)object3).w();
                object6 = ((t)object6).F();
                Object object7 = ((a)object3).w();
                int n10 = ((t)object7).N();
                int n11 = 1;
                object4 = ((SSLSocketFactory)object4).createSocket((Socket)object5, (String)object6, n10, n11 != 0);
                if (object4 == null) break block16;
                object4 = (SSLSocket)object4;
                try {
                    object = ((g.h0.i.b)object).a((SSLSocket)object4);
                    boolean bl2 = ((k)object).k();
                    if (bl2) {
                        object5 = g.h0.n.h.e;
                        object5 = ((h$a)object5).g();
                        object6 = ((a)object3).w();
                        object6 = ((t)object6).F();
                        object7 = ((a)object3).q();
                        ((g.h0.n.h)object5).f((SSLSocket)object4, (String)object6, (List)object7);
                    }
                    ((SSLSocket)object4).startHandshake();
                    object5 = ((SSLSocket)object4).getSession();
                    object6 = Handshake.e;
                    object7 = "sslSocketSession";
                    f0.o(object5, (String)object7);
                    object6 = ((Handshake$Companion)object6).b((SSLSession)object5);
                    object7 = ((a)object3).p();
                    f0.m(object7);
                    Object object8 = ((a)object3).w();
                    object8 = ((t)object8).F();
                    bl2 = object7.verify((String)object8, (SSLSession)object5);
                    if (!bl2) {
                        object = ((Handshake)object6).m();
                        bl2 = object.isEmpty() ^ n11;
                        if (bl2) {
                            bl2 = false;
                            object5 = null;
                            if ((object = object.get(0)) == null) {
                                object3 = "null cannot be cast to non-null type java.security.cert.X509Certificate";
                                object = new NullPointerException((String)object3);
                                throw object;
                            }
                            object = (X509Certificate)object;
                            object6 = new StringBuilder();
                            object7 = "\n              |Hostname ";
                            ((StringBuilder)object6).append((String)object7);
                            object3 = ((a)object3).w();
                            object3 = ((t)object3).F();
                            ((StringBuilder)object6).append((String)object3);
                            object3 = " not verified:\n              |    certificate: ";
                            ((StringBuilder)object6).append((String)object3);
                            object3 = CertificatePinner.d;
                            object3 = ((CertificatePinner$b)object3).a((Certificate)object);
                            ((StringBuilder)object6).append((String)object3);
                            object3 = "\n              |    DN: ";
                            ((StringBuilder)object6).append((String)object3);
                            object3 = ((X509Certificate)object).getSubjectDN();
                            object7 = "cert.subjectDN";
                            f0.o(object3, (String)object7);
                            object3 = object3.getName();
                            ((StringBuilder)object6).append((String)object3);
                            object3 = "\n              |    subjectAltNames: ";
                            ((StringBuilder)object6).append((String)object3);
                            object3 = g.h0.p.d.c;
                            object = ((g.h0.p.d)object3).a((X509Certificate)object);
                            ((StringBuilder)object6).append(object);
                            object = "\n              ";
                            ((StringBuilder)object6).append((String)object);
                            object = ((StringBuilder)object6).toString();
                            object = StringsKt__IndentKt.r((String)object, null, n11, null);
                            object5 = new SSLPeerUnverifiedException((String)object);
                            throw object5;
                        }
                        object2 = new StringBuilder();
                        object5 = "Hostname ";
                        ((StringBuilder)object2).append((String)object5);
                        object3 = ((a)object3).w();
                        object3 = ((t)object3).F();
                        ((StringBuilder)object2).append((String)object3);
                        object3 = " not verified (no certificates)";
                        ((StringBuilder)object2).append((String)object3);
                        object3 = ((StringBuilder)object2).toString();
                        object = new SSLPeerUnverifiedException((String)object3);
                        throw object;
                    }
                    object5 = ((a)object3).l();
                    f0.m(object5);
                    TlsVersion tlsVersion = ((Handshake)object6).o();
                    object8 = ((Handshake)object6).g();
                    List list = ((Handshake)object6).k();
                    RealConnection$connectTls$1 realConnection$connectTls$1 = new RealConnection$connectTls$1((CertificatePinner)object5, (Handshake)object6, (a)object3);
                    this.e = object7 = new Handshake(tlsVersion, (h)object8, list, realConnection$connectTls$1);
                    object3 = ((a)object3).w();
                    object3 = ((t)object3).F();
                    object6 = new RealConnection$connectTls$2(this);
                    ((CertificatePinner)object5).c((String)object3, (f.h2.s.a)object6);
                    boolean bl3 = ((k)object).k();
                    if (bl3) {
                        object = g.h0.n.h.e;
                        object = ((h$a)object).g();
                        object2 = ((g.h0.n.h)object).j((SSLSocket)object4);
                    }
                    this.d = object4;
                    object = z.n((Socket)object4);
                    this.h = object = z.d((m0)object);
                    object = z.i((Socket)object4);
                    this.i = object = z.c((k0)object);
                    if (object2 != null) {
                        object = Protocol.Companion;
                        object = ((Protocol$a)object).a((String)object2);
                    } else {
                        object = Protocol.HTTP_1_1;
                    }
                    this.f = object;
                    if (object4 != null) {
                        object = g.h0.n.h.e.g();
                        ((g.h0.n.h)object).c((SSLSocket)object4);
                    }
                    return;
                }
                catch (Throwable throwable) {
                    object2 = object4;
                }
                break block17;
            }
            try {
                object3 = "null cannot be cast to non-null type javax.net.ssl.SSLSocket";
                object = new NullPointerException((String)object3);
                throw object;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (object2 != null) {
            object3 = g.h0.n.h.e.g();
            ((g.h0.n.h)object3).c((SSLSocket)object2);
        }
        if (object2 != null) {
            g.h0.d.n(object2);
        }
        throw var1_4;
    }

    private final void q(int n10, int n11, int n12, g.e e10, q q10) {
        int n13;
        a0 a02 = this.s();
        t t10 = a02.q();
        for (int i10 = 0; i10 < (n13 = 21); ++i10) {
            this.o(n10, n11, e10, q10);
            a02 = this.r(n11, n12, a02, t10);
            if (a02 == null) break;
            Socket socket = this.c;
            if (socket != null) {
                g.h0.d.n(socket);
            }
            n13 = 0;
            socket = null;
            this.c = null;
            this.i = null;
            this.h = null;
            InetSocketAddress inetSocketAddress = this.s.g();
            Proxy proxy = this.s.e();
            q10.h(e10, inetSocketAddress, proxy, null);
        }
    }

    private final a0 r(int n10, int n11, a0 object, t object2) {
        Object object3;
        Object object4;
        block3: {
            int n12;
            block4: {
                object4 = new StringBuilder();
                String string2 = "CONNECT ";
                ((StringBuilder)object4).append(string2);
                boolean bl2 = true;
                object2 = g.h0.d.a0((t)object2, bl2);
                ((StringBuilder)object4).append((String)object2);
                ((StringBuilder)object4).append(" HTTP/1.1");
                object2 = ((StringBuilder)object4).toString();
                while (true) {
                    object4 = this.h;
                    f0.m(object4);
                    object3 = this.i;
                    f0.m(object3);
                    Object object5 = new b(null, this, (o)object4, (n)object3);
                    Object object6 = object4.timeout();
                    long l10 = n10;
                    TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                    ((o0)object6).i(l10, timeUnit);
                    object6 = object3.timeout();
                    l10 = n11;
                    ((o0)object6).i(l10, timeUnit);
                    object6 = ((a0)object).k();
                    ((b)object5).C((s)object6, (String)object2);
                    ((b)object5).a();
                    object6 = ((b)object5).g(false);
                    f0.m(object6);
                    object = ((c0$a)object6).E((a0)object).c();
                    ((b)object5).B((c0)object);
                    int n13 = ((c0)object).v0();
                    int n14 = 200;
                    if (n13 == n14) break block3;
                    int n15 = 407;
                    if (n13 != n15) break block4;
                    object4 = this.s.d().s();
                    object3 = this.s;
                    if ((object4 = object4.a((e0)object3, (c0)object)) == null) break;
                    object3 = "close";
                    object5 = "Connection";
                    int n16 = 2;
                    n12 = (int)(f.q2.u.I1((String)object3, (String)(object = c0.A0((c0)object, (String)object5, null, n16, null)), bl2) ? 1 : 0);
                    if (n12 != 0) {
                        return object4;
                    }
                    object = object4;
                }
                IOException iOException = new IOException("Failed to authenticate with proxy");
                throw iOException;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Unexpected response code for CONNECT: ");
            n12 = ((c0)object).v0();
            charSequence.append(n12);
            charSequence = charSequence.toString();
            IOException iOException = new IOException((String)charSequence);
            throw iOException;
        }
        Object object7 = object4.getBuffer();
        n10 = (int)(((m)object7).V() ? 1 : 0);
        if (n10 != 0 && (n10 = (int)(((m)(object7 = object3.getBuffer())).V() ? 1 : 0)) != 0) {
            return null;
        }
        object7 = new IOException("TLS tunnel buffered too many bytes!");
        throw object7;
    }

    private final a0 s() {
        e0 e02;
        Object object = new a0$a();
        Object object2 = this.s.d().w();
        object = ((a0$a)object).D((t)object2).p("CONNECT", null);
        object2 = g.h0.d.a0(this.s.d().w(), true);
        object = ((a0$a)object).n("Host", (String)object2).n("Proxy-Connection", "Keep-Alive").n("User-Agent", "okhttp/4.9.0").b();
        object2 = new c0$a();
        object2 = ((c0$a)object2).E((a0)object);
        Object object3 = Protocol.HTTP_1_1;
        object2 = ((c0$a)object2).B((Protocol)((Object)object3));
        int n10 = 407;
        object2 = ((c0$a)object2).g(n10).y("Preemptive Authenticate");
        object3 = g.h0.d.c;
        object2 = ((c0$a)object2).b((d0)object3);
        long l10 = -1;
        object2 = ((c0$a)object2).F(l10).C(l10).v("Proxy-Authenticate", "OkHttp-Preemptive").c();
        object3 = this.s.d().s();
        object2 = object3.a(e02 = this.s, (c0)object2);
        if (object2 != null) {
            object = object2;
        }
        return object;
    }

    private final void t(g.h0.i.b object, int n10, g.e object2, q q10) {
        SSLSocketFactory sSLSocketFactory = this.s.d().v();
        if (sSLSocketFactory == null) {
            object = this.s.d().q();
            boolean bl2 = object.contains(object2 = Protocol.H2_PRIOR_KNOWLEDGE);
            if (bl2) {
                object = this.c;
                this.d = object;
                this.f = object2;
                this.L(n10);
                return;
            }
            object = this.c;
            this.d = object;
            object = Protocol.HTTP_1_1;
            this.f = object;
            return;
        }
        q10.C((g.e)object2);
        this.p((g.h0.i.b)object);
        object = this.e;
        q10.B((g.e)object2, (Handshake)object);
        object = this.f;
        object2 = Protocol.HTTP_2;
        if (object == object2) {
            this.L(n10);
        }
    }

    public final boolean A(a object, List object2) {
        int n10;
        Object object3 = "address";
        f0.p(object, (String)object3);
        int n11 = g.h0.d.h;
        if (n11 != 0 && (n11 = Thread.holdsLock(this)) == 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Thread ");
            object3 = Thread.currentThread();
            f0.o(object3, "Thread.currentThread()");
            object3 = ((Thread)object3).getName();
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(" MUST hold lock on ");
            ((StringBuilder)object2).append(this);
            object2 = ((StringBuilder)object2).toString();
            object = new AssertionError(object2);
            throw object;
        }
        object3 = this.p;
        n11 = object3.size();
        if (n11 < (n10 = this.o) && (n11 = (int)(this.j ? 1 : 0)) == 0) {
            boolean bl2;
            object3 = this.s.d();
            n11 = (int)(((a)object3).o((a)object) ? 1 : 0);
            if (n11 == 0) {
                return false;
            }
            object3 = ((a)object).w().F();
            String string2 = this.b().d().w().F();
            n11 = (int)(f0.g(object3, string2) ? 1 : 0);
            n10 = 1;
            if (n11 != 0) {
                return n10;
            }
            object3 = this.g;
            if (object3 == null) {
                return false;
            }
            if (object2 != null && (bl2 = this.H((List)object2))) {
                object2 = ((a)object).p();
                if (object2 != (object3 = g.h0.p.d.c)) {
                    return false;
                }
                object2 = ((a)object).w();
                bl2 = this.M((t)object2);
                if (!bl2) {
                    return false;
                }
                try {
                    object2 = ((a)object).l();
                }
                catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {}
                f0.m(object2);
                object = ((a)object).w();
                object = ((t)object).F();
                object3 = this.c();
                f0.m(object3);
                object3 = ((Handshake)object3).m();
                ((CertificatePinner)object2).a((String)object, (List)object3);
                return n10;
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean B(boolean bl2) {
        long l10;
        int n10 = g.h0.d.h;
        if (n10 != 0 && (n10 = Thread.holdsLock(this)) != 0) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Thread ");
            Object object = Thread.currentThread();
            f0.o(object, "Thread.currentThread()");
            object = ((Thread)object).getName();
            charSequence.append((String)object);
            charSequence.append(" MUST NOT hold lock on ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            AssertionError assertionError = new AssertionError(charSequence);
            throw assertionError;
        }
        long l11 = System.nanoTime();
        Closeable closeable = this.c;
        f0.m(closeable);
        Socket socket = this.d;
        f0.m(socket);
        o o10 = this.h;
        f0.m(o10);
        boolean bl3 = ((Socket)closeable).isClosed();
        if (bl3) return false;
        bl3 = socket.isClosed();
        if (bl3) return false;
        bl3 = socket.isInputShutdown();
        if (bl3) return false;
        bl3 = socket.isOutputShutdown();
        if (bl3) {
            return false;
        }
        closeable = this.g;
        if (closeable != null) {
            return ((g.h0.l.d)closeable).Q0(l11);
        }
        synchronized (this) {
            l10 = this.q;
            l11 -= l10;
        }
        l10 = 10000000000L;
        n10 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (n10 < 0) return true;
        if (!bl2) return true;
        return g.h0.d.K(socket, o10);
    }

    public final boolean C() {
        boolean bl2;
        g.h0.l.d d10 = this.g;
        if (d10 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            d10 = null;
        }
        return bl2;
    }

    public final g.h0.j.d D(g.z z10, g.h0.j.g g10) {
        f0.p(z10, "client");
        f0.p(g10, "chain");
        Object object = this.d;
        f0.m(object);
        o o10 = this.h;
        f0.m(o10);
        n n10 = this.i;
        f0.m(n10);
        g.h0.l.d d10 = this.g;
        if (d10 != null) {
            object = new g.h0.l.e(z10, this, g10, d10);
        } else {
            int n11 = g10.a();
            ((Socket)object).setSoTimeout(n11);
            object = o10.timeout();
            n11 = g10.n();
            long l10 = n11;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            ((o0)object).i(l10, timeUnit);
            object = n10.timeout();
            int n12 = g10.p();
            l10 = n12;
            ((o0)object).i(l10, timeUnit);
            object = new b(z10, this, o10, n10);
        }
        return object;
    }

    public final e$d E(c c10) {
        f0.p(c10, "exchange");
        Closeable closeable = this.d;
        f0.m(closeable);
        o o10 = this.h;
        f0.m(o10);
        n n10 = this.i;
        f0.m(n10);
        closeable.setSoTimeout(0);
        this.G();
        closeable = new RealConnection$b(c10, o10, n10, true, o10, n10);
        return closeable;
    }

    public final void F() {
        synchronized (this) {
            boolean bl2 = true;
            this.k = bl2;
            return;
        }
    }

    public final void G() {
        synchronized (this) {
            boolean bl2 = true;
            this.j = bl2;
            return;
        }
    }

    public final void I(long l10) {
        this.q = l10;
    }

    public final void J(boolean bl2) {
        this.j = bl2;
    }

    public final void K(int n10) {
        this.l = n10;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void N(e cloneable, IOException object) {
        synchronized (this) {
            block14: {
                int n10;
                int n11;
                void var2_2;
                block13: {
                    String string2 = "call";
                    f0.p(cloneable, string2);
                    n11 = var2_2 instanceof StreamResetException;
                    n10 = 1;
                    if (n11 == 0) break block13;
                    void var3_6 = var2_2;
                    StreamResetException streamResetException = (StreamResetException)var2_2;
                    ErrorCode errorCode = streamResetException.errorCode;
                    ErrorCode errorCode2 = ErrorCode.REFUSED_STREAM;
                    if (errorCode == errorCode2) {
                        int n12;
                        this.n = n12 = this.n + n10;
                        if (n12 > n10) {
                            this.j = n10;
                            this.l = n12 = this.l + n10;
                        }
                        break block14;
                    } else {
                        int n13;
                        object = (StreamResetException)var2_2;
                        ErrorCode errorCode3 = ((StreamResetException)object).errorCode;
                        ErrorCode errorCode4 = ErrorCode.CANCEL;
                        if (errorCode3 != errorCode4 || (n13 = ((e)cloneable).isCanceled()) == 0) {
                            this.j = n10;
                            this.l = n13 = this.l + n10;
                        }
                    }
                    break block14;
                }
                n11 = this.C();
                if (n11 == 0 || (n11 = var2_2 instanceof ConnectionShutdownException) != 0) {
                    this.j = n10;
                    n11 = this.m;
                    if (n11 == 0) {
                        int n14;
                        if (var2_2 != null) {
                            cloneable = ((e)cloneable).k();
                            e0 e02 = this.s;
                            this.n((g.z)cloneable, e02, (IOException)var2_2);
                        }
                        this.l = n14 = this.l + n10;
                    }
                }
            }
            return;
        }
    }

    public Protocol a() {
        Protocol protocol = this.f;
        f0.m((Object)protocol);
        return protocol;
    }

    public e0 b() {
        return this.s;
    }

    public Handshake c() {
        return this.e;
    }

    public Socket d() {
        Socket socket = this.d;
        f0.m(socket);
        return socket;
    }

    public void e(g.h0.l.d object, g.h0.l.k k10) {
        synchronized (this) {
            String string2 = "connection";
            f0.p(object, string2);
            object = "settings";
            f0.p(k10, (String)object);
            int n10 = k10.f();
            this.o = n10;
            return;
        }
    }

    public void f(g.h0.l.g g10) {
        f0.p(g10, "stream");
        ErrorCode errorCode = ErrorCode.REFUSED_STREAM;
        g10.d(errorCode, null);
    }

    public final void k() {
        Socket socket = this.c;
        if (socket != null) {
            g.h0.d.n(socket);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void m(int n10, int n11, int n12, int n13, boolean bl2, g.e e10, q q10) {
        boolean bl3;
        void var13_18;
        RealConnection realConnection = this;
        g.e e11 = e10;
        q q11 = q10;
        f0.p(e10, "call");
        f0.p(q10, "eventListener");
        Object object = this.f;
        int n15 = 1;
        if (object == null) {
            int n14 = n15;
        } else {
            boolean bl4 = false;
            object = null;
        }
        if (var13_18 == false) {
            String string2 = "already connected".toString();
            object = new IllegalStateException(string2);
            throw object;
        }
        object = realConnection.s.d().m();
        g.h0.i.b b10 = new g.h0.i.b((List)object);
        Object object2 = realConnection.s.d().v();
        if (object2 == null) {
            object2 = g.k.j;
            boolean bl5 = object.contains(object2);
            if (!bl5) {
                object2 = new UnknownServiceException("CLEARTEXT communication not enabled for client");
                object = new RouteException((IOException)object2);
                throw object;
            }
            object = realConnection.s.d().w().F();
            object2 = g.h0.n.h.e.g();
            boolean bl6 = ((g.h0.n.h)object2).l((String)object);
            if (!bl6) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("CLEARTEXT communication to ");
                stringBuilder.append((String)object);
                stringBuilder.append(" not permitted by network security policy");
                object = stringBuilder.toString();
                UnknownServiceException unknownServiceException = new UnknownServiceException((String)object);
                object2 = new RouteException(unknownServiceException);
                throw object2;
            }
        } else {
            object = realConnection.s.d().q();
            boolean bl7 = object.contains(object2 = Protocol.H2_PRIOR_KNOWLEDGE);
            if (bl7) {
                object2 = new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
                object = new RouteException((IOException)object2);
                throw object;
            }
        }
        RouteException routeException = null;
        do {
            Object object3;
            block22: {
                long l10;
                block21: {
                    block20: {
                        block19: {
                            try {
                                object = realConnection.s;
                                bl3 = ((e0)object).f();
                                if (!bl3) break block19;
                                object2 = this;
                                this.q(n10, n11, n12, e10, q10);
                                object = realConnection.c;
                                if (object != null) break block20;
                                break block21;
                            }
                            catch (IOException iOException) {
                                // empty catch block
                                break block22;
                            }
                        }
                        try {
                            realConnection.o(n10, n11, e11, q11);
                        }
                        catch (IOException iOException) {
                            break block22;
                        }
                    }
                    try {
                        realConnection.t(b10, n13, e11, q11);
                        object = realConnection.s;
                        object = ((e0)object).g();
                        object2 = realConnection.s;
                        object2 = ((e0)object2).e();
                        object3 = realConnection.f;
                        q11.h(e11, (InetSocketAddress)object, (Proxy)object2, (Protocol)((Object)object3));
                    }
                    catch (IOException iOException) {
                        break block22;
                    }
                }
                object = realConnection.s;
                boolean bl8 = ((e0)object).f();
                if (bl8 && (object = realConnection.c) == null) {
                    object2 = new ProtocolException("Too many tunnel connections attempted: 21");
                    object = new RouteException((IOException)object2);
                    throw object;
                }
                realConnection.q = l10 = System.nanoTime();
                return;
            }
            object2 = realConnection.d;
            if (object2 != null) {
                g.h0.d.n((Socket)object2);
            }
            if ((object2 = realConnection.c) != null) {
                g.h0.d.n((Socket)object2);
            }
            realConnection.d = null;
            realConnection.c = null;
            realConnection.h = null;
            realConnection.i = null;
            realConnection.e = null;
            realConnection.f = null;
            realConnection.g = null;
            realConnection.o = n15;
            InetSocketAddress inetSocketAddress = realConnection.s.g();
            Proxy proxy = realConnection.s.e();
            object2 = q10;
            object3 = e10;
            q10.i(e10, inetSocketAddress, proxy, null, (IOException)object);
            if (routeException == null) {
                routeException = new RouteException((IOException)object);
                continue;
            }
            routeException.addConnectException((IOException)object);
        } while (bl2 && (bl3 = b10.b((IOException)object)));
        throw routeException;
    }

    public final void n(g.z z10, e0 e02, IOException iOException) {
        f0.p(z10, "client");
        f0.p(e02, "failedRoute");
        f0.p(iOException, "failure");
        Object object = e02.e().type();
        Object object2 = Proxy.Type.DIRECT;
        if (object != object2) {
            object = e02.d();
            object2 = ((a)object).t();
            object = ((a)object).w().Z();
            SocketAddress socketAddress = e02.e().address();
            ((ProxySelector)object2).connectFailed((URI)object, socketAddress, iOException);
        }
        z10.X().b(e02);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Connection{");
        Object object = this.s.d().w().F();
        stringBuilder.append((String)object);
        stringBuilder.append(':');
        int c10 = this.s.d().w().N();
        stringBuilder.append(c10);
        char c11 = ',';
        stringBuilder.append(c11);
        stringBuilder.append(" proxy=");
        object = this.s.e();
        stringBuilder.append(object);
        stringBuilder.append(" hostAddress=");
        object = this.s.g();
        stringBuilder.append(object);
        stringBuilder.append(" cipherSuite=");
        object = this.e;
        if (object == null || (object = ((Handshake)object).g()) == null) {
            object = "none";
        }
        stringBuilder.append(object);
        stringBuilder.append(" protocol=");
        object = this.f;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final List u() {
        return this.p;
    }

    public final g v() {
        return this.r;
    }

    public final long w() {
        return this.q;
    }

    public final boolean x() {
        return this.j;
    }

    public final int y() {
        return this.l;
    }

    public final void z() {
        synchronized (this) {
            int n10 = this.m + 1;
            this.m = n10;
            return;
        }
    }
}

