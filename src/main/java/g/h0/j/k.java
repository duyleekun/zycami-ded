/*
 * Decompiled with CFR 0.151.
 */
package g.h0.j;

import f.h2.t.f0;
import g.h0.j.k$a;
import okhttp3.Protocol;

public final class k {
    public static final int d = 307;
    public static final int e = 308;
    public static final int f = 421;
    public static final int g = 100;
    public static final k$a h;
    public final Protocol a;
    public final int b;
    public final String c;

    static {
        k$a k$a;
        h = k$a = new k$a(null);
    }

    public k(Protocol protocol, int n10, String string2) {
        f0.p((Object)protocol, "protocol");
        f0.p(string2, "message");
        this.a = protocol;
        this.b = n10;
        this.c = string2;
    }

    public String toString() {
        CharSequence charSequence = new StringBuilder();
        Object object = this.a;
        Protocol protocol = Protocol.HTTP_1_0;
        if (object == protocol) {
            object = "HTTP/1.0";
            charSequence.append((String)object);
        } else {
            object = "HTTP/1.1";
            charSequence.append((String)object);
        }
        char c10 = ' ';
        charSequence.append(c10);
        int n10 = this.b;
        charSequence.append(n10);
        charSequence.append(c10);
        object = this.c;
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        f0.o(charSequence, "StringBuilder().apply(builderAction).toString()");
        return charSequence;
    }
}

