/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.j.f.a.a.j;

import android.content.Context;
import d.j.f.a.a.j.o.d;
import d.j.f.a.a.j.o.e;
import d.j.f.a.a.j.o.i;
import d.j.f.a.a.j.o.l;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.X509TrustManager;

public class m
implements X509TrustManager {
    private static final String c = "WebViewX509TrustManger";
    private X509Certificate a;
    private List b;

    public m(Context object) {
        Object object2 = new ArrayList();
        this.b = object2;
        Objects.requireNonNull(object, "WebViewX509TrustManger context is null");
        e.b(object);
        object2 = new l((Context)object);
        object = ((l)object2).c();
        this.a = object;
        Objects.requireNonNull(object, "WebViewX509TrustManger cannot get cbg root ca");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArray, String string2) {
        String string3 = "checkClientTrusted";
        i.e(c, string3);
        List list = this.b;
        boolean bl2 = list.isEmpty();
        if (!bl2) {
            ((X509TrustManager)this.b.get(0)).checkClientTrusted(x509CertificateArray, string2);
            return;
        }
        x509CertificateArray = new CertificateException("checkClientTrusted CertificateException");
        throw x509CertificateArray;
    }

    public void checkServerTrusted(X509Certificate[] object, String string2) {
        int n10;
        Object object2;
        Object object3;
        int n11;
        int n12;
        string2 = c;
        i.e(string2, "checkServerTrusted");
        boolean bl2 = false;
        Object object4 = null;
        for (n12 = 0; n12 < (n11 = ((X509Certificate[])object).length); ++n12) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("checkServerTrusted ");
            ((StringBuilder)object3).append(n12);
            ((StringBuilder)object3).append(" : ");
            object2 = object[n12].getIssuerDN().getName();
            ((StringBuilder)object3).append((String)object2);
            object3 = ((StringBuilder)object3).toString();
            i.b(string2, (String)object3);
        }
        n12 = ((X509Certificate[])object).length;
        object4 = new X509Certificate[n12];
        object3 = null;
        for (n11 = 0; n11 < (n10 = ((X509Certificate[])object).length); ++n11) {
            n10 = ((X509Certificate[])object).length + -1 - n11;
            object4[n11] = object2 = object[n10];
        }
        object3 = "CBG root CA CertificateException";
        object = new CertificateException((String)object3);
        object3 = this.a;
        try {
            bl2 = d.f((X509Certificate)object3, object4);
        }
        catch (CertificateException certificateException) {
            object4 = new StringBuilder();
            object4.append("checkServerTrusted CertificateException: ");
            object3 = certificateException.getMessage();
            object4.append((String)object3);
            object4 = object4.toString();
            i.d(string2, (String)object4);
        }
        catch (SignatureException signatureException) {
            object3 = new StringBuilder();
            object2 = "checkServerTrusted SignatureException: ";
            ((StringBuilder)object3).append((String)object2);
            String string3 = signatureException.getMessage();
            ((StringBuilder)object3).append(string3);
            string3 = ((StringBuilder)object3).toString();
            i.d(string2, string3);
        }
        catch (InvalidKeyException invalidKeyException) {
            object3 = new StringBuilder();
            object2 = "checkServerTrusted InvalidKeyException: ";
            ((StringBuilder)object3).append((String)object2);
            String string4 = invalidKeyException.getMessage();
            ((StringBuilder)object3).append(string4);
            string4 = ((StringBuilder)object3).toString();
            i.d(string2, string4);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object3 = new StringBuilder();
            object2 = "checkServerTrusted NoSuchAlgorithmException: ";
            ((StringBuilder)object3).append((String)object2);
            String string5 = noSuchAlgorithmException.getMessage();
            ((StringBuilder)object3).append(string5);
            string5 = ((StringBuilder)object3).toString();
            i.d(string2, string5);
        }
        catch (NoSuchProviderException noSuchProviderException) {
            object3 = new StringBuilder();
            object2 = "checkServerTrusted NoSuchProviderException: ";
            ((StringBuilder)object3).append((String)object2);
            String string6 = noSuchProviderException.getMessage();
            ((StringBuilder)object3).append(string6);
            string6 = ((StringBuilder)object3).toString();
            i.d(string2, string6);
        }
        if (bl2) {
            return;
        }
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public X509Certificate[] getAcceptedIssuers() {
        try {
            X509Certificate[] x509CertificateArray = new ArrayList();
            X509Certificate[] x509CertificateArray2 = this.b;
            x509CertificateArray2 = x509CertificateArray2.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = x509CertificateArray2.hasNext())) {
                    int n10 = x509CertificateArray.size();
                    x509CertificateArray2 = new X509Certificate[n10];
                    return x509CertificateArray.toArray(x509CertificateArray2);
                }
                Object object = x509CertificateArray2.next();
                object = (X509TrustManager)object;
                object = object.getAcceptedIssuers();
                object = Arrays.asList(object);
                x509CertificateArray.addAll(object);
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getAcceptedIssuers exception : ");
            String string2 = exception.getMessage();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            i.d(c, string2);
            return new X509Certificate[0];
        }
    }
}

