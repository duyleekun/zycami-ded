/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 */
package com.baidu.lbsapi.auth;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.baidu.lbsapi.auth.a;
import com.baidu.lbsapi.auth.b$a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Locale;

public class b {
    public static String a() {
        return Locale.getDefault().getLanguage();
    }

    public static String a(Context object) {
        String string2 = object.getPackageName();
        object = b.a(object, string2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        stringBuilder.append(";");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    private static String a(Context object, String object2) {
        int n10;
        String string2 = "";
        int n11 = 0;
        object = object.getPackageManager();
        int n12 = 64;
        object = object.getPackageInfo((String)object2, n12);
        object = ((PackageInfo)object).signatures;
        object2 = "X.509";
        object2 = CertificateFactory.getInstance((String)object2);
        object = object[0];
        object = object.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])object);
        object = ((CertificateFactory)object2).generateCertificate(byteArrayInputStream);
        object = (X509Certificate)object;
        try {
            object = b.a((X509Certificate)object);
        }
        catch (PackageManager.NameNotFoundException | CertificateException throwable) {
            object = string2;
        }
        if (object == null) {
            return string2;
        }
        object2 = new StringBuffer();
        while (n11 < (n10 = ((String)object).length())) {
            n10 = ((String)object).charAt(n11);
            ((StringBuffer)object2).append((char)n10);
            if (n11 > 0 && (n10 = n11 % 2) == (n12 = 1) && n11 < (n10 = ((String)object).length() - n12)) {
                string2 = ":";
                ((StringBuffer)object2).append(string2);
            }
            ++n11;
        }
        return ((StringBuffer)object2).toString();
    }

    public static String a(X509Certificate object) {
        try {
            object = ((Certificate)object).getEncoded();
        }
        catch (CertificateEncodingException certificateEncodingException) {
            return null;
        }
        object = b.a((byte[])object);
        return b$a.a((byte[])object);
    }

    public static byte[] a(byte[] byArray) {
        Object object = "SHA1";
        try {
            object = MessageDigest.getInstance((String)object);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            return null;
        }
        return ((MessageDigest)object).digest(byArray);
    }

    public static String[] b(Context stringArray) {
        String[] stringArray2;
        int n10;
        String string2 = stringArray.getPackageName();
        if ((stringArray = b.b((Context)stringArray, string2)) != null && (n10 = stringArray.length) > 0) {
            n10 = stringArray.length;
            stringArray2 = new String[n10];
            for (int i10 = 0; i10 < n10; ++i10) {
                CharSequence charSequence = new StringBuilder();
                String string3 = stringArray[i10];
                ((StringBuilder)charSequence).append(string3);
                string3 = ";";
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                stringArray2[i10] = charSequence;
                boolean bl2 = a.a;
                if (!bl2) continue;
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("mcode");
                string3 = stringArray2[i10];
                ((StringBuilder)charSequence).append(string3);
                charSequence = ((StringBuilder)charSequence).toString();
                a.a((String)charSequence);
            }
        } else {
            stringArray2 = null;
        }
        return stringArray2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String[] b(Context signatureArray, String stringArray) {
        int n10;
        Object object;
        Object object2;
        int n11;
        CharSequence charSequence;
        int n12;
        String[] stringArray2;
        block10: {
            block9: {
                int n13;
                block8: {
                    stringArray2 = null;
                    try {
                        signatureArray = signatureArray.getPackageManager();
                        n12 = 64;
                        signatureArray = signatureArray.getPackageInfo((String)stringArray, n12);
                        signatureArray = signatureArray.signatures;
                        if (signatureArray == null || (n13 = signatureArray.length) <= 0) break block8;
                        n13 = signatureArray.length;
                        stringArray = new String[n13];
                        charSequence = null;
                        break block9;
                    }
                    catch (PackageManager.NameNotFoundException | CertificateException throwable) {}
                }
                n13 = 0;
                stringArray = null;
                break block10;
            }
            try {
                for (n12 = 0; n12 < (n11 = signatureArray.length); ++n12) {
                    object2 = "X.509";
                    object2 = CertificateFactory.getInstance((String)object2);
                    Signature signature = signatureArray[n12];
                    byte[] byArray = signature.toByteArray();
                    object = new ByteArrayInputStream(byArray);
                    object2 = ((CertificateFactory)object2).generateCertificate((InputStream)object);
                    object2 = (X509Certificate)object2;
                    stringArray[n12] = object2 = b.a((X509Certificate)object2);
                }
            }
            catch (PackageManager.NameNotFoundException | CertificateException throwable) {}
        }
        if (stringArray != null && (n10 = stringArray.length) > 0) {
            stringArray2 = new String[stringArray.length];
            signatureArray = null;
            for (n10 = 0; n10 < (n12 = stringArray.length); ++n10) {
                int n14;
                charSequence = stringArray[n10];
                if (charSequence == null || (n12 = ((String)(charSequence = stringArray[n10])).length()) == 0) continue;
                charSequence = new StringBuffer();
                object2 = null;
                for (n11 = 0; n11 < (n14 = ((String)(object = stringArray[n10])).length()); ++n11) {
                    int n15;
                    object = stringArray[n10];
                    n14 = ((String)object).charAt(n11);
                    ((StringBuffer)charSequence).append((char)n14);
                    if (n11 <= 0 || (n14 = n11 % 2) != (n15 = 1) || n11 >= (n14 = ((String)(object = stringArray[n10])).length() - n15)) continue;
                    object = ":";
                    ((StringBuffer)charSequence).append((String)object);
                }
                charSequence = ((StringBuffer)charSequence).toString();
                stringArray2[n10] = charSequence;
            }
        }
        return stringArray2;
    }
}

