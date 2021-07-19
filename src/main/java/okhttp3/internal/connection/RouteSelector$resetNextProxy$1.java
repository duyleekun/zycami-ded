/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.connection;

import f.h2.s.a;
import f.x1.t;
import g.h0.d;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.connection.RouteSelector;

public final class RouteSelector$resetNextProxy$1
extends Lambda
implements a {
    public final /* synthetic */ Proxy $proxy;
    public final /* synthetic */ g.t $url;
    public final /* synthetic */ RouteSelector this$0;

    public RouteSelector$resetNextProxy$1(RouteSelector routeSelector, Proxy proxy, g.t t10) {
        this.this$0 = routeSelector;
        this.$proxy = proxy;
        this.$url = t10;
        super(0);
    }

    public final List invoke() {
        int n10;
        Object object = this.$proxy;
        if (object != null) {
            return t.k(object);
        }
        object = this.$url.Z();
        Object object2 = object.getHost();
        int n11 = 1;
        if (object2 == null) {
            object = new Proxy[n11];
            object[0] = object2 = Proxy.NO_PROXY;
            return d.z(object);
        }
        object2 = RouteSelector.a(this.this$0).t();
        object = ((ProxySelector)object2).select((URI)object);
        if (object != null && (n10 = (int)(object.isEmpty() ? 1 : 0)) == 0) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = n11;
        }
        if (n10 != 0) {
            object = new Proxy[n11];
            object[0] = object2 = Proxy.NO_PROXY;
            return d.z(object);
        }
        return d.c0((List)object);
    }
}

