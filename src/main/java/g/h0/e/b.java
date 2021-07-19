/*
 * Decompiled with CFR 0.151.
 */
package g.h0.e;

import f.h2.t.f0;
import f.q2.u;
import g.a0;
import g.c0;
import g.e0;
import g.g;
import g.h0.e.a;
import g.n;
import g.p;
import g.t;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Objects;
import kotlin.collections.CollectionsKt___CollectionsKt;

public final class b
implements g.b {
    private final p d;

    public b() {
        this(null, 1, null);
    }

    public b(p p10) {
        f0.p(p10, "defaultDns");
        this.d = p10;
    }

    public /* synthetic */ b(p p10, int n10, f.h2.t.u u10) {
        if ((n10 &= 1) != 0) {
            p10 = p.a;
        }
        this(p10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final InetAddress b(Proxy object, t object2, p p10) {
        Proxy.Type type = ((Proxy)object).type();
        if (type != null) {
            int[] nArray = a.a;
            int n10 = type.ordinal();
            int n11 = 1;
            if ((n10 = nArray[n10]) != n11) {
            } else {
                object = ((t)object2).F();
                return (InetAddress)CollectionsKt___CollectionsKt.o2(p10.lookup((String)object));
            }
        }
        object = ((Proxy)object).address();
        Objects.requireNonNull(object, "null cannot be cast to non-null type java.net.InetSocketAddress");
        object = ((InetSocketAddress)object).getAddress();
        object2 = "(address() as InetSocketAddress).address";
        f0.o(object, (String)object2);
        return object;
    }

    /*
     * WARNING - void declaration
     */
    public a0 a(e0 e02, c0 c02) {
        boolean bl2;
        Proxy proxy;
        b b10 = this;
        Object object = c02;
        f0.p(c02, "response");
        Object object2 = c02.u0();
        a0 a02 = c02.L0();
        Object object3 = a02.q();
        int bl3 = c02.v0();
        boolean bl4 = true;
        int n10 = 407;
        if (bl3 == n10) {
            boolean bl5 = bl4;
        } else {
            boolean bl6 = false;
            object = null;
        }
        if (e02 == null || (proxy = e02.e()) == null) {
            proxy = Proxy.NO_PROXY;
        }
        object2 = object2.iterator();
        while (bl2 = object2.hasNext()) {
            Object object4;
            Object object5;
            String string2;
            Object object6;
            Object object7;
            void var8_11;
            Object object8 = "Basic";
            g g10 = (g)object2.next();
            Object object9 = g10.h();
            boolean bl7 = u.I1((String)object8, (String)object9, bl4);
            if (!bl7) continue;
            if (e02 == null || (object9 = e02.d()) == null || (object9 = ((g.a)object9).n()) == null) {
                object9 = b10.d;
            }
            object8 = "proxy";
            if (var8_11 != false) {
                object7 = proxy.address();
                Objects.requireNonNull(object7, "null cannot be cast to non-null type java.net.InetSocketAddress");
                object7 = (InetSocketAddress)object7;
                String string3 = ((InetSocketAddress)object7).getHostName();
                f0.o(proxy, (String)object8);
                object6 = b10.b(proxy, (t)object3, (p)object9);
                int n11 = ((InetSocketAddress)object7).getPort();
                string2 = ((t)object3).X();
                object5 = g10.g();
                object4 = g10.h();
                URL uRL = ((t)object3).a0();
                Authenticator.RequestorType requestorType = Authenticator.RequestorType.PROXY;
                object9 = Authenticator.requestPasswordAuthentication(string3, (InetAddress)object6, n11, string2, (String)object5, (String)object4, uRL, requestorType);
            } else {
                object7 = ((t)object3).F();
                f0.o(proxy, (String)object8);
                object9 = b10.b(proxy, (t)object3, (p)object9);
                int n12 = ((t)object3).N();
                object6 = ((t)object3).X();
                String string4 = g10.g();
                string2 = g10.h();
                object5 = ((t)object3).a0();
                object4 = Authenticator.RequestorType.SERVER;
                object8 = object7;
                object7 = object9;
                object9 = Authenticator.requestPasswordAuthentication((String)object8, (InetAddress)object9, n12, (String)object6, string4, string2, (URL)object5, object4);
            }
            if (object9 == null) continue;
            object2 = var8_11 != false ? "Proxy-Authorization" : "Authorization";
            object = ((PasswordAuthentication)object9).getUserName();
            f0.o(object, "auth.userName");
            object3 = ((PasswordAuthentication)object9).getPassword();
            f0.o(object3, "auth.password");
            String string5 = new String((char[])object3);
            object3 = g10.f();
            object = n.b((String)object, string5, (Charset)object3);
            return a02.n().n((String)object2, (String)object).b();
        }
        return null;
    }
}

