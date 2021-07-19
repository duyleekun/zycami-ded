/*
 * Decompiled with CFR 0.151.
 */
package i.d.m;

import i.d.m.a;
import i.d.m.b;
import java.net.InetAddress;
import java.net.URI;

public class b$a
implements a {
    public final /* synthetic */ b a;

    public b$a(b b10) {
        this.a = b10;
    }

    public InetAddress a(URI uRI) {
        return InetAddress.getByName(uRI.getHost());
    }
}

