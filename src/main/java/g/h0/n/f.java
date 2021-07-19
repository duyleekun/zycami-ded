/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n;

import f.h2.t.f0;
import f.q2.t;
import g.h0.n.f$a;
import g.h0.n.h;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class f
extends h {
    private static final boolean f;
    public static final f$a g;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        boolean bl2;
        block3: {
            Object object;
            block5: {
                Object object2;
                block4: {
                    int n10;
                    int n11 = 0;
                    object2 = null;
                    object = new f$a(null);
                    g = object;
                    object = System.getProperty("java.specification.version");
                    if (object != null) {
                        object2 = t.X0((String)object);
                    }
                    bl2 = true;
                    if (object2 == null) break block4;
                    n11 = (Integer)object2;
                    if (n11 < (n10 = 9)) break block5;
                    break block3;
                }
                object2 = SSLSocket.class;
                String string2 = "getApplicationProtocol";
                try {
                    Class[] classArray = new Class[]{};
                    ((Class)object2).getMethod(string2, classArray);
                    break block3;
                }
                catch (NoSuchMethodException noSuchMethodException) {}
            }
            bl2 = false;
            object = null;
        }
        f = bl2;
    }

    public static final /* synthetic */ boolean t() {
        return f;
    }

    public void f(SSLSocket sSLSocket, String object, List stringArray) {
        f0.p(sSLSocket, "sslSocket");
        f0.p(stringArray, "protocols");
        object = sSLSocket.getSSLParameters();
        stringArray = h.e.b((List)stringArray);
        f0.o(object, "sslParameters");
        String[] stringArray2 = new String[]{};
        stringArray = stringArray.toArray(stringArray2);
        Objects.requireNonNull(stringArray, "null cannot be cast to non-null type kotlin.Array<T>");
        ((SSLParameters)object).setApplicationProtocols(stringArray);
        sSLSocket.setSSLParameters((SSLParameters)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String j(SSLSocket object) {
        Object object2;
        block5: {
            f0.p(object, "sslSocket");
            object2 = null;
            try {
                object = ((SSLSocket)object).getApplicationProtocol();
                if (object == null) break block5;
            }
            catch (UnsupportedOperationException unsupportedOperationException) {
                return object2;
            }
            int n10 = ((String)object).hashCode();
            if (n10 != 0) return object;
            String string2 = "";
            n10 = (int)(((String)object).equals(string2) ? 1 : 0);
            if (n10 == 0) return object;
        }
        return object2;
    }

    public X509TrustManager s(SSLSocketFactory object) {
        f0.p(object, "sslSocketFactory");
        object = new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
        throw object;
    }
}

