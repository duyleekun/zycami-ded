/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.connection;

import f.h2.t.f0;
import f.x1.y;
import g.a;
import g.e;
import g.e0;
import g.h0.i.h;
import g.p;
import g.q;
import g.t;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import okhttp3.internal.connection.RouteSelector$a;
import okhttp3.internal.connection.RouteSelector$b;
import okhttp3.internal.connection.RouteSelector$resetNextProxy$1;

public final class RouteSelector {
    public static final RouteSelector$a i;
    private List a;
    private int b;
    private List c;
    private final List d;
    private final a e;
    private final h f;
    private final e g;
    private final q h;

    static {
        RouteSelector$a routeSelector$a;
        i = routeSelector$a = new RouteSelector$a(null);
    }

    public RouteSelector(a object, h object2, e e10, q q10) {
        f0.p(object, "address");
        f0.p(object2, "routeDatabase");
        f0.p(e10, "call");
        f0.p(q10, "eventListener");
        this.e = object;
        this.f = object2;
        this.g = e10;
        this.h = q10;
        this.a = object2 = CollectionsKt__CollectionsKt.E();
        this.c = object2 = CollectionsKt__CollectionsKt.E();
        object2 = new ArrayList();
        this.d = object2;
        object2 = ((a)object).w();
        object = ((a)object).r();
        this.g((t)object2, (Proxy)object);
    }

    public static final /* synthetic */ a a(RouteSelector routeSelector) {
        return routeSelector.e;
    }

    private final boolean c() {
        int n10 = this.b;
        List list = this.a;
        int n11 = list.size();
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    private final Proxy e() {
        boolean bl2 = this.c();
        if (bl2) {
            int n10;
            Object object = this.a;
            int n11 = this.b;
            this.b = n10 = n11 + 1;
            object = (Proxy)object.get(n11);
            this.f((Proxy)object);
            return object;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("No route to ");
        Object object = this.e.w().F();
        charSequence.append((String)object);
        charSequence.append("; exhausted proxy configurations: ");
        object = this.a;
        charSequence.append(object);
        charSequence = charSequence.toString();
        SocketException socketException = new SocketException((String)charSequence);
        throw socketException;
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void f(Proxy object) {
        int n10;
        boolean bl2;
        Proxy.Type type;
        Object object2;
        Object object3 = new ArrayList();
        this.c = object3;
        Proxy.Type type2 = ((Proxy)object).type();
        if (type2 != (object2 = Proxy.Type.DIRECT) && (type = ((Proxy)object).type()) != (object2 = Proxy.Type.SOCKS)) {
            SocketAddress socketAddress = ((Proxy)object).address();
            bl2 = socketAddress instanceof InetSocketAddress;
            if (!bl2) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Proxy.address() is not an InetSocketAddress: ");
                object3 = socketAddress.getClass();
                ((StringBuilder)object).append(object3);
                object = ((StringBuilder)object).toString();
                object = object.toString();
                object3 = new IllegalArgumentException((String)object);
                throw object3;
            }
            object2 = i;
            InetSocketAddress inetSocketAddress = (InetSocketAddress)socketAddress;
            object2 = ((RouteSelector$a)object2).a(inetSocketAddress);
            n10 = inetSocketAddress.getPort();
        } else {
            object2 = this.e.w().F();
            t t10 = this.e.w();
            n10 = t10.N();
        }
        char c10 = (char)-1;
        int n11 = 1;
        if (n11 <= n10 && c10 >= n10) {
            Object object4;
            if ((object = ((Proxy)object).type()) == (object4 = Proxy.Type.SOCKS)) {
                object = InetSocketAddress.createUnresolved((String)object2, n10);
                object3.add(object);
                return;
            }
            object = this.h;
            object4 = this.g;
            ((q)object).n((e)object4, (String)object2);
            object = this.e.n().lookup((String)object2);
            c10 = (char)(object.isEmpty() ? 1 : 0);
            if (c10 != '\u0000') {
                object3 = new StringBuilder();
                p p10 = this.e.n();
                ((StringBuilder)object3).append(p10);
                ((StringBuilder)object3).append(" returned no addresses for ");
                ((StringBuilder)object3).append((String)object2);
                object3 = ((StringBuilder)object3).toString();
                object = new UnknownHostException((String)object3);
                throw object;
            }
            object4 = this.h;
            e e10 = this.g;
            ((q)object4).m(e10, (String)object2, (List)object);
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                object2 = (InetAddress)object.next();
                object4 = new InetSocketAddress((InetAddress)object2, n10);
                object3.add(object4);
            }
            return;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("No route to ");
        ((StringBuilder)object3).append((String)object2);
        ((StringBuilder)object3).append(':');
        ((StringBuilder)object3).append(n10);
        ((StringBuilder)object3).append("; port is out of range");
        object3 = ((StringBuilder)object3).toString();
        object = new SocketException((String)object3);
        throw object;
    }

    private final void g(t t10, Proxy object) {
        Object object2 = new RouteSelector$resetNextProxy$1(this, (Proxy)object, t10);
        object = this.h;
        e e10 = this.g;
        ((q)object).p(e10, t10);
        this.a = object = ((RouteSelector$resetNextProxy$1)object2).invoke();
        this.b = 0;
        object2 = this.h;
        e10 = this.g;
        ((q)object2).o(e10, t10, (List)object);
    }

    public final boolean b() {
        List list;
        boolean bl2 = this.c();
        boolean bl3 = true;
        if (!bl2 && !(bl2 = (list = this.d).isEmpty() ^ bl3)) {
            bl3 = false;
        }
        return bl3;
    }

    public final RouteSelector$b d() {
        boolean bl2 = this.b();
        if (bl2) {
            Object object;
            boolean bl3;
            ArrayList<e0> arrayList = new ArrayList<e0>();
            while (bl3 = this.c()) {
                boolean bl4;
                object = this.e();
                Iterator iterator2 = this.c.iterator();
                while (bl4 = iterator2.hasNext()) {
                    Object object2 = (InetSocketAddress)iterator2.next();
                    object2 = this.f;
                    a a10 = this.e;
                    e0 e02 = new e0(a10, (Proxy)object, (InetSocketAddress)object2);
                    bl4 = ((h)object2).c(e02);
                    if (bl4) {
                        object2 = this.d;
                        object2.add(e02);
                        continue;
                    }
                    arrayList.add(e02);
                }
                bl3 = arrayList.isEmpty() ^ true;
                if (!bl3) continue;
            }
            if (bl3 = arrayList.isEmpty()) {
                object = this.d;
                y.q0(arrayList, (Iterable)object);
                object = this.d;
                object.clear();
            }
            object = new RouteSelector$b(arrayList);
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}

