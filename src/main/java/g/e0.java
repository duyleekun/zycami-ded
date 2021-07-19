/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.a;
import java.net.InetSocketAddress;
import java.net.Proxy;

public final class e0 {
    private final a a;
    private final Proxy b;
    private final InetSocketAddress c;

    public e0(a a10, Proxy proxy, InetSocketAddress inetSocketAddress) {
        f0.p(a10, "address");
        f0.p(proxy, "proxy");
        f0.p(inetSocketAddress, "socketAddress");
        this.a = a10;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public final a a() {
        return this.a;
    }

    public final Proxy b() {
        return this.b;
    }

    public final InetSocketAddress c() {
        return this.c;
    }

    public final a d() {
        return this.a;
    }

    public final Proxy e() {
        return this.b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        boolean bl2 = object instanceof e0;
        if (!bl2) return false;
        object = (e0)object;
        Object object2 = ((e0)object).a;
        Object object3 = this.a;
        bl2 = f0.g(object2, object3);
        if (!bl2) return false;
        object2 = ((e0)object).b;
        object3 = this.b;
        bl2 = f0.g(object2, object3);
        if (!bl2) return false;
        object = ((e0)object).c;
        object2 = this.c;
        boolean bl3 = f0.g(object, object2);
        if (!bl3) return false;
        return true;
    }

    public final boolean f() {
        boolean bl2;
        Proxy.Type type;
        Object object = this.a.v();
        if (object != null && (object = this.b.type()) == (type = Proxy.Type.HTTP)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public final InetSocketAddress g() {
        return this.c;
    }

    public int hashCode() {
        int n10 = this.a.hashCode();
        int n11 = (527 + n10) * 31;
        n10 = this.b.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = this.c.hashCode();
        return n11 + n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Route{");
        InetSocketAddress inetSocketAddress = this.c;
        stringBuilder.append(inetSocketAddress);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

