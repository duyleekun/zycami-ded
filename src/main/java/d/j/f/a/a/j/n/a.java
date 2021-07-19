/*
 * Decompiled with CFR 0.151.
 */
package d.j.f.a.a.j.n;

import d.j.f.a.a.j.n.d;
import d.j.f.a.a.j.o.i;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public class a
implements HostnameVerifier {
    public boolean verify(String string2, SSLSession object) {
        String string3 = "";
        try {
            object = object.getPeerCertificates();
        }
        catch (SSLException sSLException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("SSLException : ");
            String string4 = sSLException.getMessage();
            ((StringBuilder)object).append(string4);
            string4 = ((StringBuilder)object).toString();
            i.d(string3, string4);
            return false;
        }
        object = object[0];
        object = (X509Certificate)object;
        CharSequence charSequence = new StringBuilder();
        Object object2 = "verify: certificate is : ";
        charSequence.append((String)object2);
        object2 = ((X509Certificate)object).getSubjectDN();
        object2 = object2.getName();
        charSequence.append((String)object2);
        charSequence = charSequence.toString();
        i.b(string3, (String)charSequence);
        d.a(string2, (X509Certificate)object, false);
        return true;
    }
}

