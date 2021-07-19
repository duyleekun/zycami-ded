/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.connection;

import f.h2.t.f0;
import g.e0;
import java.util.List;
import java.util.NoSuchElementException;

public final class RouteSelector$b {
    private int a;
    private final List b;

    public RouteSelector$b(List list) {
        f0.p(list, "routes");
        this.b = list;
    }

    public final List a() {
        return this.b;
    }

    public final boolean b() {
        int n10 = this.a;
        List list = this.b;
        int n11 = list.size();
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public final e0 c() {
        boolean bl2 = this.b();
        if (bl2) {
            int n10;
            List list = this.b;
            int n11 = this.a;
            this.a = n10 = n11 + 1;
            return (e0)list.get(n11);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}

