/*
 * Decompiled with CFR 0.151.
 */
package g.h0.j;

import f.h2.t.f0;
import g.a0;
import g.a0$a;
import g.b0;
import g.c0;
import g.c0$a;
import g.d0;
import g.h0.d;
import g.h0.j.e;
import g.h0.j.h;
import g.l;
import g.m;
import g.s;
import g.s$a;
import g.t;
import g.u;
import g.u$a;
import g.v;
import h.m0;
import h.o;
import h.z;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

public final class a
implements u {
    private final m b;

    public a(m m10) {
        f0.p(m10, "cookieJar");
        this.b = m10;
    }

    private final String a(List object) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        object = object.iterator();
        int n10 = 0;
        String string2 = null;
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            int n11 = n10 + 1;
            if (n10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            object2 = (l)object2;
            if (n10 > 0) {
                string2 = "; ";
                stringBuilder.append(string2);
            }
            string2 = ((l)object2).s();
            stringBuilder.append(string2);
            stringBuilder.append('=');
            string2 = ((l)object2).z();
            stringBuilder.append(string2);
            n10 = n11;
        }
        object = stringBuilder.toString();
        f0.o(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    public c0 intercept(u$a object) {
        long l10;
        Object object2;
        f0.p(object, "chain");
        Object object3 = object.C();
        Object object4 = ((a0)object3).n();
        Object object5 = ((a0)object3).f();
        String string2 = "Content-Type";
        long l11 = -1;
        String string3 = "Content-Length";
        if (object5 != null) {
            object2 = ((b0)object5).contentType();
            if (object2 != null) {
                object2 = ((v)object2).toString();
                ((a0$a)object4).n(string2, (String)object2);
            }
            long l12 = ((b0)object5).contentLength();
            l10 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
            String string4 = "Transfer-Encoding";
            if (l10 != false) {
                object5 = String.valueOf(l12);
                ((a0$a)object4).n(string3, (String)object5);
                ((a0$a)object4).t(string4);
            } else {
                object5 = "chunked";
                ((a0$a)object4).n(string4, (String)object5);
                ((a0$a)object4).t(string3);
            }
        }
        object5 = "Host";
        object2 = ((a0)object3).i((String)object5);
        int n10 = 0;
        h.u u10 = null;
        int n11 = 1;
        if (object2 == null) {
            object2 = d.b0(((a0)object3).q(), false, n11, null);
            ((a0$a)object4).n((String)object5, (String)object2);
        }
        if ((object2 = ((a0)object3).i((String)(object5 = "Connection"))) == null) {
            object2 = "Keep-Alive";
            ((a0$a)object4).n((String)object5, (String)object2);
        }
        object5 = "Accept-Encoding";
        object2 = ((a0)object3).i((String)object5);
        String string5 = "gzip";
        if (object2 == null && (object2 = ((a0)object3).i("Range")) == null) {
            ((a0$a)object4).n((String)object5, string5);
            n10 = n11;
        }
        object5 = this.b;
        object2 = ((a0)object3).q();
        int n12 = (object5 = object5.loadForRequest((t)object2)).isEmpty() ^ n11;
        if (n12 != 0) {
            object5 = this.a((List)object5);
            object2 = "Cookie";
            ((a0$a)object4).n((String)object2, (String)object5);
        }
        if ((object2 = ((a0)object3).i((String)(object5 = "User-Agent"))) == null) {
            object2 = "okhttp/4.9.0";
            ((a0$a)object4).n((String)object5, (String)object2);
        }
        object4 = ((a0$a)object4).b();
        object = object.c((a0)object4);
        object4 = this.b;
        object5 = ((a0)object3).q();
        object2 = ((c0)object).C0();
        e.g((m)object4, (t)object5, (s)object2);
        object4 = ((c0)object).G0();
        object3 = ((c0$a)object4).E((a0)object3);
        if (n10 != 0 && (n12 = (int)(f.q2.u.I1(string5, (String)(object2 = c0.A0((c0)object, (String)(object4 = "Content-Encoding"), null, (int)(l10 = (long)2), null)), n11 != 0) ? 1 : 0)) != 0 && (n12 = (int)(e.c((c0)object) ? 1 : 0)) != 0 && (object2 = ((c0)object).r0()) != null) {
            object2 = ((d0)object2).source();
            u10 = new h.u((m0)object2);
            object2 = ((c0)object).C0().j();
            object4 = ((s$a)object2).l((String)object4).l(string3).i();
            ((c0$a)object3).w((s)object4);
            object = c0.A0((c0)object, string2, null, (int)l10, null);
            object5 = z.d(u10);
            object4 = new h((String)object, l11, (o)object5);
            ((c0$a)object3).b((d0)object4);
        }
        return ((c0$a)object3).c();
    }
}

