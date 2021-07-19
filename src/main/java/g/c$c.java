/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.e2.b;
import f.h2.t.f0;
import f.q1;
import f.q2.u;
import g.a0;
import g.a0$a;
import g.c;
import g.c$a;
import g.c$b;
import g.c$c$a;
import g.c0;
import g.c0$a;
import g.d0;
import g.h;
import g.h$b;
import g.h0.j.k;
import g.h0.j.k$a;
import g.h0.n.h$a;
import g.s;
import g.s$a;
import h.m;
import h.m0;
import h.n;
import h.o;
import h.z;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import okhttp3.Handshake;
import okhttp3.Handshake$Companion;
import okhttp3.Protocol;
import okhttp3.TlsVersion;
import okhttp3.TlsVersion$a;
import okhttp3.internal.cache.DiskLruCache$Editor;
import okhttp3.internal.cache.DiskLruCache$c;
import okio.ByteString;
import okio.ByteString$a;

public final class c$c {
    private static final String k;
    private static final String l;
    public static final c$c$a m;
    private final String a;
    private final s b;
    private final String c;
    private final Protocol d;
    private final int e;
    private final String f;
    private final s g;
    private final Handshake h;
    private final long i;
    private final long j;

    static {
        Object object = new c$c$a(null);
        m = object;
        object = new StringBuilder();
        Object object2 = g.h0.n.h.e;
        String string2 = ((h$a)object2).g().i();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("-Sent-Millis");
        k = ((StringBuilder)object).toString();
        object = new StringBuilder();
        object2 = ((h$a)object2).g().i();
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("-Received-Millis");
        l = ((StringBuilder)object).toString();
    }

    public c$c(c0 c02) {
        long l10;
        int n10;
        f0.p(c02, "response");
        Object object = c02.L0().q().toString();
        this.a = object;
        this.b = object = g.c.k.f(c02);
        this.c = object = c02.L0().m();
        object = c02.J0();
        this.d = object;
        this.e = n10 = c02.v0();
        object = c02.E0();
        this.f = object;
        object = c02.C0();
        this.g = object;
        object = c02.x0();
        this.h = object;
        this.i = l10 = c02.M0();
        this.j = l10 = c02.K0();
    }

    public c$c(m0 m02) {
        block64: {
            Object object;
            block62: {
                char c10;
                Object object2;
                Object object3;
                Object object4;
                block63: {
                    long l10;
                    int n10;
                    Object object5;
                    boolean bl2;
                    int n11;
                    block61: {
                        long l11;
                        String string2;
                        block60: {
                            String string3;
                            object = "rawSource";
                            f0.p(m02, (String)object);
                            object = z.d(m02);
                            object4 = object.w();
                            this.a = object4;
                            object4 = object.w();
                            this.c = object4;
                            object4 = new s$a();
                            object3 = g.c.k;
                            n11 = ((c$b)object3).c((o)object);
                            bl2 = false;
                            object2 = null;
                            object5 = null;
                            for (n10 = 0; n10 < n11; ++n10) {
                                string3 = object.w();
                                ((s$a)object4).f(string3);
                                continue;
                            }
                            object4 = ((s$a)object4).i();
                            this.b = object4;
                            object4 = g.h0.j.k.h;
                            object3 = object.w();
                            object4 = ((k$a)object4).b((String)object3);
                            object3 = ((k)object4).a;
                            this.d = object3;
                            n11 = ((k)object4).b;
                            this.e = n11;
                            object4 = ((k)object4).c;
                            this.f = object4;
                            object4 = new s$a();
                            object3 = g.c.k;
                            n11 = ((c$b)object3).c((o)object);
                            object5 = null;
                            for (n10 = 0; n10 < n11; ++n10) {
                                string3 = object.w();
                                ((s$a)object4).f(string3);
                                continue;
                            }
                            object3 = k;
                            object5 = ((s$a)object4).j((String)object3);
                            string3 = l;
                            string2 = ((s$a)object4).j(string3);
                            ((s$a)object4).l((String)object3);
                            ((s$a)object4).l(string3);
                            l10 = 0L;
                            if (object5 == null) break block60;
                            l11 = Long.parseLong((String)object5);
                        }
                        l11 = l10;
                        this.i = l11;
                        if (string2 == null) break block61;
                        l10 = Long.parseLong(string2);
                    }
                    this.j = l10;
                    object4 = ((s$a)object4).i();
                    this.g = object4;
                    c10 = this.a();
                    if (c10 == '\u0000') break block62;
                    object4 = object.w();
                    n11 = object4.length();
                    if (n11 > 0) {
                        bl2 = true;
                    }
                    if (bl2) break block63;
                    object4 = object.w();
                    object3 = g.h.s1;
                    object4 = ((h$b)object3).b((String)object4);
                    object3 = this.c((o)object);
                    object2 = this.c((o)object);
                    n10 = (int)(object.V() ? 1 : 0);
                    if (n10 == 0) {
                        object5 = TlsVersion.Companion;
                        object = object.w();
                        object = ((TlsVersion$a)object5).a((String)object);
                    } else {
                        object = TlsVersion.SSL_3_0;
                    }
                    object5 = Handshake.e;
                    object = ((Handshake$Companion)object5).c((TlsVersion)((Object)object), (h)object4, (List)object3, (List)object2);
                    this.h = object;
                    break block64;
                }
                object3 = new StringBuilder();
                object2 = "expected \"\" but was \"";
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append((String)object4);
                c10 = '\"';
                ((StringBuilder)object3).append(c10);
                object4 = ((StringBuilder)object3).toString();
                object = new IOException((String)object4);
                throw object;
            }
            object = null;
            this.h = null;
        }
        return;
        finally {
            m02.close();
        }
    }

    private final boolean a() {
        return u.q2(this.a, "https://", false, 2, null);
    }

    private final List c(o o10) {
        ArrayList<Object> arrayList;
        int n10;
        Object object = g.c.k;
        int n11 = ((c$b)object).c(o10);
        if (n11 == (n10 = -1)) {
            return CollectionsKt__CollectionsKt.E();
        }
        Object object2 = "X.509";
        object2 = CertificateFactory.getInstance((String)object2);
        try {
            arrayList = new ArrayList<Object>(n11);
        }
        catch (CertificateException certificateException) {
            String string2 = certificateException.getMessage();
            object = new IOException(string2);
            throw object;
        }
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object3 = o10.w();
            m m10 = new m();
            ByteString$a byteString$a = ByteString.Companion;
            object3 = byteString$a.h((String)object3);
            f0.m(object3);
            m10.W0((ByteString)object3);
            object3 = m10.l0();
            object3 = ((CertificateFactory)object2).generateCertificate((InputStream)object3);
            arrayList.add(object3);
            continue;
        }
        return arrayList;
    }

    private final void e(n n10, List object) {
        int n11;
        int n12 = object.size();
        long l10 = n12;
        n n13 = n10.M(l10);
        int n14 = 10;
        n13.writeByte(n14);
        n13 = null;
        try {
            n11 = object.size();
        }
        catch (CertificateEncodingException certificateEncodingException) {
            String string2 = certificateEncodingException.getMessage();
            object = new IOException(string2);
            throw object;
        }
        for (n12 = 0; n12 < n11; ++n12) {
            Object object2 = object.get(n12);
            object2 = (Certificate)object2;
            byte[] byArray = ((Certificate)object2).getEncoded();
            ByteString$a byteString$a = ByteString.Companion;
            object2 = "bytes";
            f0.o(byArray, (String)object2);
            int n15 = 3;
            object2 = ByteString$a.p(byteString$a, byArray, 0, 0, n15, null);
            object2 = ((ByteString)object2).base64();
            object2 = n10.r((String)object2);
            object2.writeByte(n14);
            continue;
        }
        return;
    }

    public final boolean b(a0 a02, c0 c02) {
        boolean bl2;
        f0.p(a02, "request");
        f0.p(c02, "response");
        Object object = this.a;
        Object object2 = a02.q().toString();
        boolean bl3 = f0.g(object, object2);
        if (bl3 && (bl3 = f0.g(object = this.c, object2 = a02.m())) && (bl2 = ((c$b)(object = g.c.k)).g(c02, (s)(object2 = this.b), a02))) {
            bl2 = true;
        } else {
            bl2 = false;
            a02 = null;
        }
        return bl2;
    }

    public final c0 d(DiskLruCache$c object) {
        f0.p(object, "snapshot");
        Object object2 = this.g.e("Content-Type");
        String string2 = this.g.e("Content-Length");
        Object object3 = new a0$a();
        Object object4 = this.a;
        object3 = ((a0$a)object3).B((String)object4);
        object4 = this.c;
        object3 = ((a0$a)object3).p((String)object4, null);
        object4 = this.b;
        object3 = ((a0$a)object3).o((s)object4).b();
        object4 = new c0$a();
        object3 = ((c0$a)object4).E((a0)object3);
        object4 = this.d;
        object3 = ((c0$a)object3).B((Protocol)((Object)object4));
        int n10 = this.e;
        object3 = ((c0$a)object3).g(n10);
        object4 = this.f;
        object3 = ((c0$a)object3).y((String)object4);
        object4 = this.g;
        object3 = ((c0$a)object3).w((s)object4);
        object4 = new c$a((DiskLruCache$c)object, (String)object2, string2);
        object = ((c0$a)object3).b((d0)object4);
        object2 = this.h;
        object = ((c0$a)object).u((Handshake)object2);
        long l10 = this.i;
        object = ((c0$a)object).F(l10);
        l10 = this.j;
        return ((c0$a)object).C(l10).c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void f(DiskLruCache$Editor object) {
        f0.p(object, "editor");
        int n10 = 0;
        Object object2 = null;
        object = z.c(((DiskLruCache$Editor)object).f(0));
        try {
            Object object3;
            Object object4;
            Object object5 = this.a;
            object5 = object.r((String)object5);
            int n11 = 10;
            object5.writeByte(n11);
            object5 = this.c;
            object5 = object.r((String)object5);
            object5.writeByte(n11);
            object5 = this.b;
            int n12 = ((s)object5).size();
            long l10 = n12;
            object5 = object.M(l10);
            object5.writeByte(n11);
            object5 = this.b;
            n12 = ((s)object5).size();
            int n13 = 0;
            Object object6 = null;
            while (true) {
                object4 = ": ";
                if (n13 >= n12) break;
                object3 = this.b;
                object3 = ((s)object3).h(n13);
                object3 = object.r((String)object3);
                object4 = object3.r((String)object4);
                object3 = this.b;
                object3 = ((s)object3).n(n13);
                object4 = object4.r((String)object3);
                object4.writeByte(n11);
                ++n13;
            }
            object6 = this.d;
            int n14 = this.e;
            String string2 = this.f;
            object5 = new k((Protocol)((Object)object6), n14, string2);
            object5 = ((k)object5).toString();
            object5 = object.r((String)object5);
            object5.writeByte(n11);
            object5 = this.g;
            n12 = ((s)object5).size() + 2;
            long l11 = n12;
            object5 = object.M(l11);
            object5.writeByte(n11);
            object5 = this.g;
            n12 = ((s)object5).size();
            while (n10 < n12) {
                object6 = this.g;
                object6 = ((s)object6).h(n10);
                object6 = object.r((String)object6);
                object6 = object6.r((String)object4);
                object3 = this.g;
                object3 = ((s)object3).n(n10);
                object6 = object6.r((String)object3);
                object6.writeByte(n11);
                ++n10;
            }
            object2 = k;
            object2 = object.r((String)object2);
            object2 = object2.r((String)object4);
            l11 = this.i;
            object2 = object2.M(l11);
            object2.writeByte(n11);
            object2 = l;
            object2 = object.r((String)object2);
            object2 = object2.r((String)object4);
            l10 = this.j;
            object2 = object2.M(l10);
            object2.writeByte(n11);
            n10 = (int)(this.a() ? 1 : 0);
            if (n10 != 0) {
                object.writeByte(n11);
                object2 = this.h;
                f0.m(object2);
                object2 = ((Handshake)object2).g();
                object2 = ((h)object2).e();
                object2 = object.r((String)object2);
                object2.writeByte(n11);
                object2 = this.h;
                object2 = ((Handshake)object2).m();
                this.e((n)object, (List)object2);
                object2 = this.h;
                object2 = ((Handshake)object2).k();
                this.e((n)object, (List)object2);
                object2 = this.h;
                object2 = ((Handshake)object2).o();
                object2 = ((TlsVersion)((Object)object2)).javaName();
                object2 = object.r((String)object2);
                object2.writeByte(n11);
            }
            object2 = q1.a;
        }
        catch (Throwable throwable) {
            try {
                throw throwable;
            }
            catch (Throwable throwable2) {
                f.e2.b.a((Closeable)object, throwable);
                throw throwable2;
            }
        }
        f.e2.b.a((Closeable)object, null);
    }
}

