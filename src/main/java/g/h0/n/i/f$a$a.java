/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n.i;

import f.h2.t.f0;
import f.q2.u;
import g.h0.n.i.f;
import g.h0.n.i.f$a;
import g.h0.n.i.j$a;
import g.h0.n.i.k;
import javax.net.ssl.SSLSocket;

public final class f$a$a
implements j$a {
    public final /* synthetic */ String a;

    public f$a$a(String string2) {
        this.a = string2;
    }

    public boolean a(SSLSocket object) {
        f0.p(object, "sslSocket");
        object = object.getClass().getName();
        f0.o(object, "sslSocket.javaClass.name");
        CharSequence charSequence = new StringBuilder();
        String string2 = this.a;
        charSequence.append(string2);
        charSequence.append('.');
        charSequence = charSequence.toString();
        return u.q2((String)object, (String)charSequence, false, 2, null);
    }

    public k b(SSLSocket object) {
        f0.p(object, "sslSocket");
        f$a f$a = f.g;
        object = object.getClass();
        return f$a.a(f$a, (Class)object);
    }
}

