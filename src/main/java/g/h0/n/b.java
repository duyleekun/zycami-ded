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
import g.h0.n.b$a;
import g.h0.n.b$b;
import g.h0.n.h;
import g.h0.n.h$a;
import g.h0.n.i.f;
import g.h0.n.i.g;
import g.h0.n.i.i;
import g.h0.n.i.j$a;
import g.h0.n.i.k;
import g.h0.n.i.l;
import g.h0.n.i.l$a;
import g.h0.p.c;
import g.h0.p.e;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt__CollectionsKt;

public final class b
extends h {
    private static final boolean h;
    public static final b$a i;
    private final List f;
    private final g.h0.n.i.h g;

    /*
     * Enabled aggressive block sorting
     */
    static {
        int n10;
        Object var1_1 = null;
        Object object = new b$a(null);
        i = object;
        object = g.h0.n.h.e;
        int n11 = ((h$a)object).h();
        boolean bl2 = true;
        boolean bl3 = false;
        if (n11 == 0 || (n11 = Build.VERSION.SDK_INT) >= (n10 = 30)) {
            bl2 = false;
            Object var1_2 = null;
        } else {
            n10 = 21;
            if (n11 >= n10) {
                bl3 = bl2;
            }
            if (!bl3) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected Android API level 21+ but was ");
                stringBuilder.append(n11);
                object = stringBuilder.toString();
                object = object.toString();
                IllegalStateException illegalStateException = new IllegalStateException((String)object);
                throw illegalStateException;
            }
        }
        h = bl2;
    }

    public b() {
        int n10 = 4;
        Object object = new k[n10];
        ArrayList<j$a> arrayList = l.j;
        int n11 = 1;
        arrayList = l$a.b((l$a)((Object)arrayList), null, n11, null);
        object[0] = arrayList;
        j$a j$a = g.h0.n.i.f.g.d();
        arrayList = new ArrayList<j$a>(j$a);
        object[n11] = arrayList;
        j$a = g.h0.n.i.i.b.a();
        arrayList = new ArrayList<j$a>(j$a);
        object[2] = arrayList;
        j$a = g.h0.n.i.g.b.a();
        arrayList = new ArrayList<j$a>(j$a);
        int n12 = 3;
        object[n12] = arrayList;
        object = CollectionsKt__CollectionsKt.N((Object[])object);
        arrayList = new ArrayList<j$a>();
        object = object.iterator();
        while ((n12 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            j$a = object.next();
            Object object2 = j$a;
            object2 = (k)((Object)j$a);
            n11 = (int)(object2.b() ? 1 : 0);
            if (n11 == 0) continue;
            arrayList.add(j$a);
        }
        this.f = arrayList;
        this.g = object = g.h0.n.i.h.d.a();
    }

    public static final /* synthetic */ boolean t() {
        return h;
    }

    public c d(X509TrustManager x509TrustManager) {
        f0.p(x509TrustManager, "trustManager");
        c c10 = g.h0.n.i.b.d.a(x509TrustManager);
        if (c10 == null) {
            c10 = super.d(x509TrustManager);
        }
        return c10;
    }

    public e e(X509TrustManager x509TrustManager) {
        Object object = "trustManager";
        f0.p(x509TrustManager, (String)object);
        object = x509TrustManager.getClass();
        Object object2 = "findTrustAnchorByIssuerAndSignature";
        boolean bl2 = true;
        Class[] classArray = new Class[bl2];
        Class<X509Certificate> clazz = X509Certificate.class;
        classArray[0] = clazz;
        object = ((Class)object).getDeclaredMethod((String)object2, classArray);
        object2 = "method";
        f0.o(object, (String)object2);
        ((Method)object).setAccessible(bl2);
        try {
            object2 = new b$b(x509TrustManager, (Method)object);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object2 = super.e(x509TrustManager);
        }
        return object2;
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

    public void g(Socket socket, InetSocketAddress serializable, int n10) {
        f0.p(socket, "socket");
        String string2 = "address";
        f0.p(serializable, string2);
        try {
            socket.connect((SocketAddress)serializable, n10);
            return;
        }
        catch (ClassCastException classCastException) {
            int n11 = Build.VERSION.SDK_INT;
            n10 = 26;
            if (n11 == n10) {
                serializable = new IOException("Exception in connect", classCastException);
                throw serializable;
            }
            throw classCastException;
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

    public Object k(String string2) {
        f0.p(string2, "closer");
        return this.g.a(string2);
    }

    /*
     * WARNING - void declaration
     */
    public boolean l(String string2) {
        void var5_9;
        String string3 = "hostname";
        f0.p(string2, string3);
        int bl3 = Build.VERSION.SDK_INT;
        int bl4 = 24;
        if (bl3 >= bl4) {
            string3 = NetworkSecurityPolicy.getInstance();
            boolean bl2 = string3.isCleartextTrafficPermitted(string2);
        } else {
            int n10 = 23;
            if (bl3 >= n10) {
                string2 = NetworkSecurityPolicy.getInstance();
                string3 = "NetworkSecurityPolicy.getInstance()";
                f0.o(string2, string3);
                boolean bl2 = string2.isCleartextTrafficPermitted();
            } else {
                boolean bl5 = true;
            }
        }
        return (boolean)var5_9;
    }

    public void o(String string2, Object object) {
        f0.p(string2, "message");
        Object object2 = this.g;
        boolean bl2 = ((g.h0.n.i.h)object2).b(object);
        if (!bl2) {
            int n10 = 5;
            int n11 = 4;
            object2 = this;
            g.h0.n.h.n(this, string2, n10, null, n11, null);
        }
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

