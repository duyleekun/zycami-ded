/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n.i;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public interface k {
    public boolean a(SSLSocket var1);

    public boolean b();

    public String c(SSLSocket var1);

    public X509TrustManager d(SSLSocketFactory var1);

    public boolean e(SSLSocketFactory var1);

    public void f(SSLSocket var1, String var2, List var3);
}

