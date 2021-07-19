/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.http.SslError
 *  android.webkit.SslErrorHandler
 */
package d.j.f.a.a.j;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import d.j.f.a.a.j.k$a;
import d.j.f.a.a.j.o.d;
import d.j.f.a.a.j.o.i;
import d.j.f.a.a.j.o.l;
import java.security.cert.X509Certificate;

public class j {
    private static final String a = "WebViewSSLCheck";

    public static void a(SslErrorHandler sslErrorHandler, SslError sslError, Context context) {
        j.b(sslErrorHandler, sslError, null, context, null);
    }

    public static void b(SslErrorHandler sslErrorHandler, SslError object, String string2, Context context, k$a k$a) {
        String string3 = a;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append(" error type : ");
        int n10 = object.getPrimaryError();
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append(" , cn is : ");
        CharSequence charSequence = object.getCertificate().getIssuedTo().getCName();
        ((StringBuilder)object2).append((String)charSequence);
        object2 = ((StringBuilder)object2).toString();
        i.e(string3, (String)object2);
        object = d.a(object.getCertificate());
        object2 = new l(context);
        object2 = ((l)object2).a();
        charSequence = new StringBuilder();
        String string4 = "checkServerCertificateNew: error certificate is : ";
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append(object);
        charSequence = ((StringBuilder)charSequence).toString();
        i.b(string3, (String)charSequence);
        boolean bl2 = d.e((X509Certificate)object2, (X509Certificate)object);
        if (bl2) {
            object = "checkServerCertificateNew: proceed";
            i.e(string3, (String)object);
            if (k$a != null) {
                k$a.a(context, string2);
            } else {
                sslErrorHandler.proceed();
            }
            return;
        }
        object = "checkServerCertificateNew: cancel";
        i.d(string3, (String)object);
        if (k$a != null) {
            k$a.b(context, string2);
        } else {
            sslErrorHandler.cancel();
        }
    }

    public static boolean c(String string2, SslError sslError) {
        return j.d(d.b(string2), sslError);
    }

    public static boolean d(X509Certificate x509Certificate, SslError object) {
        object = d.a(object.getCertificate());
        return d.e(x509Certificate, (X509Certificate)object);
    }
}

