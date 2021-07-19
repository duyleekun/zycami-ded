/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.http.SslCertificate
 */
package d.j.f.a.a.j.o;

import android.net.http.SslCertificate;
import d.j.f.a.a.j.o.i;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;

public class d {
    private static final String a = "b";
    private static final int b = 5;

    public static X509Certificate a(SslCertificate object) {
        block7: {
            object = SslCertificate.saveState((SslCertificate)object);
            Object object2 = "x509-certificate";
            if ((object = (Object)object.getByteArray((String)object2)) != null) {
                object2 = "X.509";
                object2 = CertificateFactory.getInstance((String)object2);
                Object object3 = new ByteArrayInputStream((byte[])object);
                object = ((CertificateFactory)object2).generateCertificate((InputStream)object3);
                try {
                    object = (X509Certificate)object;
                    break block7;
                }
                catch (CertificateException certificateException) {
                    object2 = a;
                    object3 = "exception";
                    i.c((String)object2, (String)object3, certificateException);
                }
            }
            object = null;
        }
        return object;
    }

    public static X509Certificate b(String object) {
        Object object2 = "X509";
        object2 = CertificateFactory.getInstance((String)object2);
        object = ((String)object).getBytes();
        Object object3 = new ByteArrayInputStream((byte[])object);
        object = ((CertificateFactory)object2).generateCertificate((InputStream)object3);
        try {
            object = (X509Certificate)object;
        }
        catch (CertificateException certificateException) {
            object2 = a;
            object3 = new StringBuilder();
            String string2 = "generateX509FromStr: CertificateException";
            ((StringBuilder)object3).append(string2);
            object = certificateException.getMessage();
            ((StringBuilder)object3).append((String)object);
            object = ((StringBuilder)object3).toString();
            i.d((String)object2, (String)object);
            object = null;
        }
        return object;
    }

    public static boolean c(X509Certificate x509Certificate) {
        int n10;
        if (x509Certificate == null) {
            return false;
        }
        int n11 = x509Certificate.getBasicConstraints();
        if (n11 == (n10 = -1)) {
            return false;
        }
        return x509Certificate.getKeyUsage()[5];
    }

    public static boolean d(X509Certificate object, String string2) {
        boolean bl2 = string2.equals(object = ((X509Certificate)object).getSubjectDN().getName());
        if (!bl2) {
            i.d(a, "verify: subject name is error");
            return false;
        }
        return true;
    }

    public static boolean e(X509Certificate x509Certificate, X509Certificate object) {
        int n10;
        X509Certificate[] x509CertificateArray = x509Certificate.getPublicKey();
        try {
            ((Certificate)object).verify((PublicKey)x509CertificateArray);
            n10 = 2;
        }
        catch (Exception exception) {
            object = a;
            x509CertificateArray = new StringBuilder();
            x509CertificateArray.append("verify: Exception ");
            String string2 = exception.getMessage();
            x509CertificateArray.append(string2);
            string2 = x509CertificateArray.toString();
            i.d((String)object, string2);
            return false;
        }
        catch (SignatureException signatureException) {
            object = a;
            x509CertificateArray = new StringBuilder();
            x509CertificateArray.append("verify: publickey SignatureException ");
            String string3 = signatureException.getMessage();
            x509CertificateArray.append(string3);
            string3 = x509CertificateArray.toString();
            i.d((String)object, string3);
            return false;
        }
        catch (NoSuchProviderException noSuchProviderException) {
            object = a;
            x509CertificateArray = new StringBuilder();
            x509CertificateArray.append("verify: publickey NoSuchProviderException ");
            String string4 = noSuchProviderException.getMessage();
            x509CertificateArray.append(string4);
            string4 = x509CertificateArray.toString();
            i.d((String)object, string4);
            return false;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object = a;
            x509CertificateArray = new StringBuilder();
            x509CertificateArray.append("verify: publickey NoSuchAlgorithmException ");
            String string5 = noSuchAlgorithmException.getMessage();
            x509CertificateArray.append(string5);
            string5 = x509CertificateArray.toString();
            i.d((String)object, string5);
            return false;
        }
        catch (InvalidKeyException invalidKeyException) {
            object = a;
            x509CertificateArray = new StringBuilder();
            x509CertificateArray.append("verify: publickey InvalidKeyException ");
            String string6 = invalidKeyException.getMessage();
            x509CertificateArray.append(string6);
            string6 = x509CertificateArray.toString();
            i.d((String)object, string6);
            return false;
        }
        catch (CertificateException certificateException) {
            object = a;
            x509CertificateArray = new StringBuilder();
            x509CertificateArray.append("verify: publickey CertificateException ");
            String string7 = certificateException.getMessage();
            x509CertificateArray.append(string7);
            string7 = x509CertificateArray.toString();
            i.d((String)object, string7);
            return false;
        }
        x509CertificateArray = new X509Certificate[n10];
        x509CertificateArray[0] = x509Certificate;
        boolean bl2 = true;
        x509CertificateArray[bl2] = object;
        boolean bl3 = d.j(x509CertificateArray);
        if (!bl3) {
            i.d(a, "verify: date not right");
            return false;
        }
        return bl2;
    }

    public static boolean f(X509Certificate x509Certificate, X509Certificate[] x509CertificateArray) {
        int n10;
        int n11 = 0;
        Object object = null;
        for (int i10 = 0; i10 < (n10 = x509CertificateArray.length); ++i10) {
            Object object2 = x509CertificateArray[i10];
            Object object3 = ((X509Certificate)object2).getIssuerDN();
            object2 = ((X509Certificate)object2).getSubjectDN();
            if (object != null) {
                n11 = object3.equals(object);
                if (n11 != 0) {
                    n11 = i10 + -1;
                    object = x509CertificateArray[n11].getPublicKey();
                    object3 = x509CertificateArray[i10];
                    ((Certificate)object3).verify((PublicKey)object);
                } else {
                    i.d(a, "verify: principalIssuer not match");
                    return false;
                }
            }
            object = object2;
        }
        object = x509CertificateArray[0];
        n11 = d.e(x509Certificate, (X509Certificate)object);
        if (n11 == 0) {
            return false;
        }
        n11 = d.j(x509CertificateArray);
        if (n11 == 0) {
            return false;
        }
        boolean bl2 = d.c(x509Certificate);
        if (!bl2) {
            return false;
        }
        bl2 = d.h(x509CertificateArray);
        return bl2;
    }

    public static boolean g(X509Certificate x509Certificate, X509Certificate[] x509CertificateArray, X509CRL x509CRL, String string2) {
        int n10 = d.f(x509Certificate, x509CertificateArray);
        if (n10 != 0) {
            return false;
        }
        n10 = d.i(x509CertificateArray, x509CRL);
        if (n10 != 0) {
            return false;
        }
        n10 = x509CertificateArray.length;
        int n11 = 1;
        n10 -= n11;
        x509Certificate = x509CertificateArray[n10];
        if ((n10 = (int)(d.d(x509Certificate, string2) ? 1 : 0)) == 0) {
            return false;
        }
        n10 = (int)(d.j(x509CertificateArray) ? 1 : 0);
        if (n10 == 0) {
            return false;
        }
        return n11 != 0;
    }

    public static boolean h(X509Certificate[] x509CertificateArray) {
        int n10;
        int n11 = 0;
        while (true) {
            int n12 = x509CertificateArray.length;
            n10 = 1;
            if (n11 >= (n12 -= n10)) break;
            X509Certificate x509Certificate = x509CertificateArray[n11];
            n12 = (int)(d.c(x509Certificate) ? 1 : 0);
            if (n12 == 0) {
                return false;
            }
            ++n11;
        }
        return n10 != 0;
    }

    public static boolean i(X509Certificate[] object, X509CRL object2) {
        block14: {
            Serializable serializable = new ArrayList();
            int n10 = ((X509Certificate[])object).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                BigInteger bigInteger = object[i10].getSerialNumber();
                ((ArrayList)serializable).add(bigInteger);
            }
            if (object2 != null) {
                object = ((X509CRL)object2).getRevokedCertificates();
                if (object == null) break block14;
                boolean bl2 = object.isEmpty();
                if (bl2) break block14;
                object = object.iterator();
                while (true) {
                    bl2 = object.hasNext();
                    if (!bl2) break block14;
                    object2 = object.next();
                    object2 = (X509CRLEntry)object2;
                    object2 = ((X509CRLEntry)object2).getSerialNumber();
                    if (!(bl2 = ((ArrayList)serializable).contains(object2))) continue;
                    break;
                }
                try {
                    object = a;
                    object2 = "verify: certificate revoked";
                }
                catch (Exception exception) {
                    object2 = a;
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append("verify: revoked verify exception : ");
                    String string2 = exception.getMessage();
                    ((StringBuilder)serializable).append(string2);
                    string2 = ((StringBuilder)serializable).toString();
                    i.d((String)object2, string2);
                    return false;
                }
                i.d((String)object, (String)object2);
                return false;
            }
        }
        return true;
    }

    public static boolean j(X509Certificate[] x509CertificateArray) {
        Object object = new Date();
        for (X509Certificate x509Certificate : x509CertificateArray) {
            String string2;
            try {
                x509Certificate.checkValidity((Date)object);
                continue;
            }
            catch (Exception exception) {
                object = a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("verifyCertificateDate : exception : ");
                String string3 = exception.getMessage();
                stringBuilder.append(string3);
                string3 = stringBuilder.toString();
                i.d((String)object, string3);
                return false;
            }
            catch (CertificateNotYetValidException certificateNotYetValidException) {
            }
            catch (CertificateExpiredException certificateExpiredException) {
                // empty catch block
            }
            object = a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("verifyCertificateDate: exception : ");
            string2 = ((Throwable)((Object)string2)).getMessage();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            i.d((String)object, string2);
            return false;
        }
        return true;
    }
}

