/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.security.NetworkSecurityPolicy
 */
package g.h0.n;

import android.os.Build;
import android.security.NetworkSecurityPolicy;
import f.h2.t.f0;
import g.h0.n.a$a;
import g.h0.n.h;
import g.h0.n.h$a;
import g.h0.n.i.b;
import g.h0.n.i.f;
import g.h0.n.i.g;
import g.h0.n.i.i;
import g.h0.n.i.j$a;
import g.h0.n.i.k;
import g.h0.p.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt__CollectionsKt;

public final class a
extends h {
    private static final boolean g;
    public static final a$a h;
    private final List f;

    /*
     * WARNING - void declaration
     */
    static {
        void var2_6;
        int n10;
        int n102 = 0;
        Object object = new a$a(null);
        h = object;
        object = g.h0.n.h.e;
        boolean n11 = ((h$a)object).h();
        if (n11 && (n10 = Build.VERSION.SDK_INT) >= (n102 = 29)) {
            boolean bl2 = true;
        } else {
            boolean bl3 = false;
            object = null;
        }
        g = var2_6;
    }

    public a() {
        int n10 = 4;
        Object object = new k[n10];
        ArrayList<j$a> arrayList = g.h0.n.i.a.a.a();
        object[0] = arrayList;
        j$a j$a = g.h0.n.i.f.g.d();
        super(j$a);
        object[1] = arrayList;
        j$a = i.b.a();
        super(j$a);
        object[2] = arrayList;
        j$a = g.h0.n.i.g.b.a();
        super(j$a);
        int n11 = 3;
        object[n11] = arrayList;
        object = CollectionsKt__CollectionsKt.N((Object[])object);
        arrayList = new ArrayList<j$a>();
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            j$a = object.next();
            Object object2 = j$a;
            object2 = (k)((Object)j$a);
            boolean bl2 = object2.b();
            if (!bl2) continue;
            arrayList.add(j$a);
        }
        this.f = arrayList;
    }

    public static final /* synthetic */ boolean t() {
        return g;
    }

    public c d(X509TrustManager x509TrustManager) {
        f0.p(x509TrustManager, "trustManager");
        c c10 = g.h0.n.i.b.d.a(x509TrustManager);
        if (c10 == null) {
            c10 = super.d(x509TrustManager);
        }
        return c10;
    }

    public void f(SSLSocket sSLSocket, String string2, List list) {
        Object object;
        block2: {
            boolean bl2;
            f0.p(sSLSocket, "sslSocket");
            f0.p(list, "protocols");
            Iterator iterator2 = this.f.iterator();
            while (bl2 = iterator2.hasNext()) {
                Object object2 = object = iterator2.next();
                object2 = (k)object;
                boolean bl3 = object2.a(sSLSocket);
                if (!bl3) continue;
                break block2;
            }
            bl2 = false;
            object = null;
        }
        object = (k)object;
        if (object != null) {
            object.f(sSLSocket, string2, list);
        }
    }

    public String j(SSLSocket sSLSocket) {
        String string2;
        Object object;
        block3: {
            boolean bl2;
            block2: {
                Object object2;
                boolean bl3;
                f0.p(sSLSocket, "sslSocket");
                Iterator iterator2 = this.f.iterator();
                do {
                    bl2 = iterator2.hasNext();
                    string2 = null;
                    if (!bl2) break block2;
                    object2 = object = iterator2.next();
                } while (!(bl3 = (object2 = (k)object).a(sSLSocket)));
                break block3;
            }
            bl2 = false;
            object = null;
        }
        object = (k)object;
        if (object != null) {
            string2 = object.c(sSLSocket);
        }
        return string2;
    }

    public boolean l(String string2) {
        f0.p(string2, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(string2);
    }

    public X509TrustManager s(SSLSocketFactory sSLSocketFactory) {
        X509TrustManager x509TrustManager;
        Object object;
        block3: {
            boolean bl2;
            block2: {
                Object object2;
                boolean bl3;
                f0.p(sSLSocketFactory, "sslSocketFactory");
                Iterator iterator2 = this.f.iterator();
                do {
                    bl2 = iterator2.hasNext();
                    x509TrustManager = null;
                    if (!bl2) break block2;
                    object2 = object = iterator2.next();
                } while (!(bl3 = (object2 = (k)object).e(sSLSocketFactory)));
                break block3;
            }
            bl2 = false;
            object = null;
        }
        object = (k)object;
        if (object != null) {
            x509TrustManager = object.d(sSLSocketFactory);
        }
        return x509TrustManager;
    }
}

