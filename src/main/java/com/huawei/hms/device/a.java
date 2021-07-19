/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONException
 */
package com.huawei.hms.device;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.support.log.common.Base64;
import com.huawei.hms.utils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

public class a {
    public static String a(String string2, String string3) {
        Object object = Locale.getDefault();
        object = string2.toUpperCase((Locale)object);
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string3);
        String string4 = "=";
        charSequence.append(string4);
        charSequence = charSequence.toString();
        int n10 = ((String)object).indexOf((String)charSequence);
        int n11 = -1;
        if (n10 == n11) {
            return null;
        }
        string4 = ",";
        int n12 = string2.indexOf(string4, n10);
        if (n12 != n11) {
            int n13 = string3.length();
            n10 = n10 + n13 + 1;
            return string2.substring(n10, n12);
        }
        int n14 = string3.length();
        n10 = n10 + n14 + 1;
        return string2.substring(n10);
    }

    public static X509Certificate a(Context context) {
        return a.a(context, "052root");
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static X509Certificate a(Context var0, String var1_1) {
        block34: {
            block33: {
                block35: {
                    block32: {
                        block31: {
                            var2_13 = "X509CertUtil";
                            var3_14 = null;
                            if (var0 /* !! */  == null || (var4_15 = TextUtils.isEmpty((CharSequence)var1_1))) break block34;
                            var5_16 = "bks";
                            var5_16 = KeyStore.getInstance((String)var5_16);
                            var0 /* !! */  = var0 /* !! */ .getAssets();
                            var6_17 = "hmsrootcas.bks";
                            var0 /* !! */  = var0 /* !! */ .open((String)var6_17);
                            var6_17 = "";
                            var6_17 = var6_17.toCharArray();
                            var5_16.load((InputStream)var0 /* !! */ , (char[])var6_17);
                            var7_18 = var5_16.containsAlias((String)var1_1);
                            if (var7_18) break block31;
                            var5_16 = new StringBuilder();
                            var6_17 = "Not include alias ";
                            var5_16.append((String)var6_17);
                            var5_16.append((String)var1_1);
                            var1_1 = var5_16.toString();
                            HMSLog.e(var2_13, (String)var1_1);
                            IOUtils.closeQuietly((InputStream)var0 /* !! */ );
                            return null;
                        }
                        try {
                            var1_1 = var5_16.getCertificate((String)var1_1);
                        }
                        catch (NoSuchAlgorithmException var1_2) {
                            break block32;
                        }
                        catch (CertificateException var1_3) {
                            break block32;
                        }
                        catch (IOException var1_4) {
                            break block32;
                        }
                        catch (KeyStoreException var1_5) {
                            break block32;
                        }
                        var4_15 = var1_1 instanceof X509Certificate;
                        if (var4_15) {
                            var1_1 = (X509Certificate)var1_1;
                            var1_1.checkValidity();
                            IOUtils.closeQuietly((InputStream)var0 /* !! */ );
                            return var1_1;
                        }
                        IOUtils.closeQuietly((InputStream)var0 /* !! */ );
                        break block35;
                        catch (Throwable var1_6) {
                            break block33;
                        }
                        catch (NoSuchAlgorithmException var1_7) lbl-1000:
                        // 4 sources

                        {
                            while (true) {
                                var0 /* !! */  = null;
                                break block32;
                                break;
                            }
                        }
                        catch (CertificateException var1_8) {
                            ** GOTO lbl-1000
                        }
                        catch (IOException var1_9) {
                            ** GOTO lbl-1000
                        }
                        catch (KeyStoreException var1_10) {
                            ** continue;
                        }
                    }
                    var5_16 = new StringBuilder();
                    var6_17 = "exception:";
                    var5_16.append((String)var6_17);
                    var1_1 = var1_1.getMessage();
                    var5_16.append((String)var1_1);
                    var1_1 = var5_16.toString();
                    try {
                        HMSLog.e(var2_13, (String)var1_1);
                    }
                    catch (Throwable var1_11) {
                        var3_14 = var0 /* !! */ ;
                    }
                    IOUtils.closeQuietly((InputStream)var0 /* !! */ );
                }
                return null;
            }
            IOUtils.closeQuietly(var3_14);
            throw var1_12;
        }
        HMSLog.e(var2_13, "args are error");
        return null;
    }

    public static X509Certificate a(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return null;
        }
        try {
            object = Base64.decode((String)object);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getCert failed : ");
            String string2 = illegalArgumentException.getMessage();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            HMSLog.e("X509CertUtil", string2);
            return null;
        }
        return a.a((byte[])object);
    }

    public static X509Certificate a(byte[] object) {
        Object object2 = "X.509";
        try {
            object2 = CertificateFactory.getInstance((String)object2);
        }
        catch (CertificateException certificateException) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Failed to get cert: ");
            String string2 = certificateException.getMessage();
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
            HMSLog.e("X509CertUtil", string2);
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])object);
        object = ((CertificateFactory)object2).generateCertificate(byteArrayInputStream);
        return (X509Certificate)object;
    }

    public static boolean a(X509Certificate object) {
        int n10;
        if (object == null) {
            return false;
        }
        int n11 = ((X509Certificate)object).getBasicConstraints();
        if (n11 == (n10 = -1)) {
            return false;
        }
        n10 = 5;
        n11 = ((Object)(object = (Object)((X509Certificate)object).getKeyUsage())).length;
        if (n10 < n11) {
            return (boolean)object[n10];
        }
        return false;
    }

    public static boolean a(X509Certificate x509Certificate, String string2) {
        return a.b(x509Certificate, "CN", string2);
    }

    public static boolean a(X509Certificate x509Certificate, String object, String object2) {
        String string2;
        String string3 = "UTF-8";
        object = ((String)object).getBytes(string3);
        object2 = Base64.decode((String)object2);
        try {
            return a.a(x509Certificate, (byte[])object, (byte[])object2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            // empty catch block
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(" plainText exception: ");
        string2 = ((Throwable)((Object)string2)).getMessage();
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        HMSLog.e("X509CertUtil", string2);
        return false;
    }

    public static boolean a(X509Certificate serializable, List object) {
        int n10;
        if (object != null && (n10 = object.size()) != 0) {
            boolean bl2;
            String string2 = "X509CertUtil";
            if (serializable == null) {
                HMSLog.e(string2, "rootCert is null,verify failed ");
                return false;
            }
            serializable = serializable.getPublicKey();
            Object object2 = object.iterator();
            while (bl2 = object2.hasNext()) {
                X509Certificate x509Certificate = (X509Certificate)object2.next();
                if (x509Certificate != null) {
                    String string3;
                    x509Certificate.checkValidity();
                    try {
                        x509Certificate.verify((PublicKey)serializable);
                        serializable = x509Certificate.getPublicKey();
                        continue;
                    }
                    catch (SignatureException signatureException) {
                    }
                    catch (NoSuchProviderException noSuchProviderException) {
                    }
                    catch (InvalidKeyException invalidKeyException) {
                    }
                    catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    }
                    catch (CertificateException certificateException) {
                        // empty catch block
                    }
                    object = new StringBuilder();
                    object2 = "verify failed ";
                    ((StringBuilder)object).append((String)object2);
                    string3 = ((Throwable)((Object)string3)).getMessage();
                    ((StringBuilder)object).append(string3);
                    string3 = ((StringBuilder)object).toString();
                    HMSLog.e(string2, string3);
                }
                return false;
            }
            return a.a((List)object);
        }
        return false;
    }

    public static boolean a(X509Certificate serializable, byte[] object, byte[] byArray) {
        String string2;
        Object object2 = serializable.getSigAlgName();
        object2 = Signature.getInstance((String)object2);
        serializable = serializable.getPublicKey();
        ((Signature)object2).initVerify((PublicKey)serializable);
        ((Signature)object2).update((byte[])object);
        try {
            return ((Signature)object2).verify(byArray);
        }
        catch (InvalidKeyException invalidKeyException) {
        }
        catch (SignatureException signatureException) {
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            // empty catch block
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("failed checkSignature : ");
        string2 = ((Throwable)((Object)string2)).getMessage();
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        HMSLog.e("X509CertUtil", string2);
        return false;
    }

    public static boolean a(List list) {
        int n10;
        int n11 = 0;
        while (true) {
            int n12 = list.size();
            n10 = 1;
            if (n11 >= (n12 -= n10)) break;
            X509Certificate x509Certificate = (X509Certificate)list.get(n11);
            n12 = (int)(a.a(x509Certificate) ? 1 : 0);
            if (n12 == 0) {
                return false;
            }
            ++n11;
        }
        return n10 != 0;
    }

    public static List b(String string2) {
        return a.b(a.c(string2));
    }

    public static List b(List object) {
        int n10 = object.size();
        ArrayList<X509Certificate> arrayList = new ArrayList<X509Certificate>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            X509Certificate x509Certificate = a.a((String)object.next());
            arrayList.add(x509Certificate);
        }
        return arrayList;
    }

    public static boolean b(X509Certificate x509Certificate, String string2) {
        return a.b(x509Certificate, "OU", string2);
    }

    public static boolean b(X509Certificate object, String string2, String string3) {
        boolean bl2;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2)) && !(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            object = a.a(((X509Certificate)object).getSubjectDN().getName(), string2);
            return string3.equals(object);
        }
        return false;
    }

    public static List c(String arrayList) {
        int n10;
        Object object;
        block10: {
            object = new JSONArray((String)((Object)arrayList));
            int n11 = object.length();
            n10 = 1;
            if (n11 > n10) break block10;
            return Collections.emptyList();
        }
        n10 = object.length();
        try {
            arrayList = new ArrayList<String>(n10);
            n10 = 0;
        }
        catch (JSONException jSONException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Failed to getCertChain: ");
            String string2 = jSONException.getMessage();
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            HMSLog.e("X509CertUtil", string2);
            return Collections.emptyList();
        }
        while (true) {
            int n12 = object.length();
            if (n10 >= n12) break;
            String string3 = object.getString(n10);
            arrayList.add(string3);
            ++n10;
            continue;
            break;
        }
        return arrayList;
    }
}

