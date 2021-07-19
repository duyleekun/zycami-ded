/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.j.f.a.a.j;

import android.content.Context;
import d.j.f.a.a.j.o.a;
import d.j.f.a.a.j.o.e;
import d.j.f.a.a.j.o.h;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class i
implements X509TrustManager {
    private static final String c = i.class.getSimpleName();
    public static final String d = "hmsrootcas.bks";
    private static final String e = "";
    private static final String f = "X509";
    private static final String g = "bks";
    private static final String h = "AndroidCAStore";
    public List a;
    private X509Certificate[] b;

    public i(Context context) {
        this(context, false);
    }

    public i(Context object, boolean bl2) {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
        if (object != null) {
            d.j.f.a.a.j.o.e.b((Context)object);
            if (bl2) {
                this.a();
            }
            this.b((Context)object);
            object = this.a;
            boolean bl3 = object.isEmpty();
            if (!bl3) {
                return;
            }
            object = new CertificateException("X509TrustManager is empty");
            throw object;
        }
        super("context is null");
        throw object;
    }

    public i(InputStream inputStream, String string2) {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
        this.d(inputStream, string2);
    }

    public i(InputStream inputStream, String string2, boolean bl2) {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
        if (bl2) {
            this.a();
        }
        this.d(inputStream, string2);
    }

    public i(String string2) {
        this(string2, false);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public i(String string2, boolean bl2) {
        void var1_4;
        Object object;
        block5: {
            object = new ArrayList();
            this.a = object;
            try {
                object = new FileInputStream(string2);
                string2 = e;
            }
            catch (Throwable throwable) {
                object = null;
                break block5;
            }
            try {
                this.d((InputStream)object, string2);
            }
            catch (Throwable throwable) {
                break block5;
            }
            d.j.f.a.a.j.o.h.g((InputStream)object);
            if (bl2) {
                this.a();
            }
            return;
        }
        d.j.f.a.a.j.o.h.g((InputStream)object);
        throw var1_4;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void a() {
        block17: {
            block18: {
                var1_1 = i.c;
                var2_2 = "loadSystemCA";
                d.j.f.a.a.j.o.i.e(var1_1, var2_2);
                var3_3 = System.currentTimeMillis();
                var5_4 /* !! */  = "AndroidCAStore";
                var5_4 /* !! */  = KeyStore.getInstance((String)var5_4 /* !! */ );
                var6_9 = 0;
                var7_10 = null;
                var5_4 /* !! */ .load(null, null);
                var7_10 = "X509";
                var7_10 = TrustManagerFactory.getInstance((String)var7_10);
                try {
                    var7_10.init((KeyStore)var5_4 /* !! */ );
                    var5_4 /* !! */  = var7_10.getTrustManagers();
                    var6_9 = 0;
                    var7_10 = null;
                }
                catch (NoSuchAlgorithmException var5_5) {
                    break block18;
                }
                catch (IOException var5_6) {
                    break block18;
                }
                catch (CertificateException var5_7) {
                    break block18;
                }
                catch (KeyStoreException var5_8) {
                    // empty catch block
                }
                while (true) {
                    var8_11 = var5_4 /* !! */ .length;
                    ** if (var6_9 >= var8_11) goto lbl-1000
lbl-1000:
                    // 1 sources

                    {
                        var9_12 = var5_4 /* !! */ [var6_9];
                        var8_11 = var9_12 instanceof X509TrustManager;
                        if (var8_11 != 0) {
                            var9_12 = this.a;
                            var10_13 = var5_4 /* !! */ [var6_9];
                            var10_13 = (X509TrustManager)var10_13;
                            var9_12.add(var10_13);
                        }
                        ++var6_9;
                        continue;
                    }
lbl-1000:
                    // 1 sources

                    {
                        break block17;
                    }
                    break;
                }
            }
            var7_10 = i.c;
            var9_12 = new StringBuilder();
            var10_13 = "loadSystemCA: exception : ";
            var9_12.append((String)var10_13);
            var5_4 /* !! */  = var5_4 /* !! */ .getMessage();
            var9_12.append((String)var5_4 /* !! */ );
            var5_4 /* !! */  = var9_12.toString();
            d.j.f.a.a.j.o.i.d((String)var7_10, (String)var5_4 /* !! */ );
        }
        var5_4 /* !! */  = i.c;
        var7_10 = new StringBuilder();
        var7_10.append("loadSystemCA: cost : ");
        var11_14 = System.currentTimeMillis() - var3_3;
        var7_10.append(var11_14);
        var7_10.append(" ms");
        var1_1 = var7_10.toString();
        d.j.f.a.a.j.o.i.b((String)var5_4 /* !! */ , var1_1);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void b(Context var1_1) {
        var2_2 = i.c;
        var3_7 = "loadBksCA";
        d.j.f.a.a.j.o.i.e((String)var2_2, var3_7);
        var4_8 = System.currentTimeMillis();
        var6_9 = d.j.f.a.a.j.o.a.o(var1_1 /* !! */ );
        if (var6_9 != null) {
            var7_10 = "get bks not from assets";
            d.j.f.a.a.j.o.i.e((String)var2_2, var7_10);
            try {
                this.c((InputStream)var6_9);
                ** break block9
            }
            catch (IOException var2_3) {
            }
            catch (CertificateException var2_4) {
            }
            catch (KeyStoreException var2_5) {
            }
            catch (NoSuchAlgorithmException var2_6) {
                // empty catch block
            }
            var7_10 = i.c;
            var8_11 = new StringBuilder();
            var9_12 = "loadBksCA: exception : ";
            var8_11.append(var9_12);
            var2_2 = var2_2.getMessage();
            var8_11.append((String)var2_2);
            var2_2 = var8_11.toString();
            d.j.f.a.a.j.o.i.d(var7_10, (String)var2_2);
            var10_13 = false;
            var2_2 = null;
        } else lbl-1000:
        // 2 sources

        {
            var10_13 = true;
        }
        if (!var10_13 || var6_9 == null) {
            var2_2 = i.c;
            var6_9 = " get bks from assets ";
            d.j.f.a.a.j.o.i.e((String)var2_2, (String)var6_9);
            var1_1 /* !! */  = var1_1 /* !! */ .getAssets();
            var2_2 = "hmsrootcas.bks";
            var1_1 /* !! */  = var1_1 /* !! */ .open((String)var2_2);
            this.c((InputStream)var1_1 /* !! */ );
        }
        var1_1 /* !! */  = i.c;
        var2_2 = new StringBuilder();
        var2_2.append("loadBksCA: cost : ");
        var11_14 = System.currentTimeMillis() - var4_8;
        var2_2.append(var11_14);
        var2_2.append(" ms");
        var2_2 = var2_2.toString();
        d.j.f.a.a.j.o.i.b((String)var1_1 /* !! */ , (String)var2_2);
    }

    private void c(InputStream inputStream) {
        int n10;
        TrustManager[] trustManagerArray = f;
        trustManagerArray = TrustManagerFactory.getInstance((String)trustManagerArray);
        Object object = g;
        object = KeyStore.getInstance((String)object);
        Object object2 = e;
        object2 = ((String)object2).toCharArray();
        ((KeyStore)object).load(inputStream, (char[])object2);
        try {
            trustManagerArray.init((KeyStore)object);
            trustManagerArray = trustManagerArray.getTrustManagers();
            n10 = 0;
            object = null;
        }
        catch (Throwable throwable) {
            d.j.f.a.a.j.o.h.g(inputStream);
            throw throwable;
        }
        while (true) {
            int n11 = trustManagerArray.length;
            if (n10 >= n11) break;
            object2 = trustManagerArray[n10];
            n11 = object2 instanceof X509TrustManager;
            if (n11 != 0) {
                object2 = this.a;
                TrustManager trustManager = trustManagerArray[n10];
                trustManager = (X509TrustManager)trustManager;
                object2.add(trustManager);
            }
            ++n10;
        }
        d.j.f.a.a.j.o.h.g(inputStream);
        return;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void d(InputStream var1_1, String var2_2) {
        block9: {
            block11: {
                if (var1_1 == null || var2_2 == null) ** GOTO lbl14
                var3_8 = System.currentTimeMillis();
                var5_9 = "X509";
                try {
                    block10: {
                        var5_9 = TrustManagerFactory.getInstance((String)var5_9);
                        var6_10 = "bks";
                        var6_10 = KeyStore.getInstance((String)var6_10);
                        var2_2 = var2_2.toCharArray();
                        var6_10.load((InputStream)var1_1, (char[])var2_2);
                        var5_9.init((KeyStore)var6_10);
                        var2_2 = var5_9.getTrustManagers();
                        var5_9 = null;
                        break block10;
lbl14:
                        // 1 sources

                        var1_1 = new IllegalArgumentException("inputstream or trustPwd is null");
                        throw var1_1;
                    }
                    ** for (var7_11 = 0;
                    ; var7_11 < (var8_12 = ((Object)var2_2).length); ++var7_11)
                }
                catch (Throwable var2_3) {
                    break block9;
                }
                catch (NoSuchAlgorithmException var2_4) {
                    ** GOTO lbl-1000
                }
                catch (IOException var2_5) {
                    ** GOTO lbl-1000
                }
                catch (CertificateException var2_6) {
                    ** GOTO lbl-1000
                }
                catch (KeyStoreException var2_7) {
                    // empty catch block
                }
lbl-1000:
                // 1 sources

                {
                    var6_10 = var2_2[var7_11];
                    var8_12 = var6_10 instanceof X509TrustManager;
                    if (var8_12 == 0) continue;
                    var6_10 = this.a;
                    var9_13 = var2_2[var7_11];
                    var9_13 = (X509TrustManager)var9_13;
                    var6_10.add(var9_13);
                    continue;
                }
lbl28:
                // 1 sources

                d.j.f.a.a.j.o.h.g((InputStream)var1_1);
                break block11;
lbl-1000:
                // 4 sources

                {
                    var5_9 = i.c;
                    var6_10 = new StringBuilder();
                    var9_13 = "loadInputStream: exception : ";
                    var6_10.append((String)var9_13);
                    var2_2 = var2_2.getMessage();
                    var6_10.append((String)var2_2);
                    var2_2 = var6_10.toString();
                    d.j.f.a.a.j.o.i.d((String)var5_9, (String)var2_2);
                }
                d.j.f.a.a.j.o.h.g((InputStream)var1_1);
            }
            var1_1 = i.c;
            var2_2 = new StringBuilder();
            var2_2.append("loadInputStream: cost : ");
            var10_14 = System.currentTimeMillis() - var3_8;
            var2_2.append(var10_14);
            var2_2.append(" ms");
            var2_2 = var2_2.toString();
            d.j.f.a.a.j.o.i.b((String)var1_1, (String)var2_2);
            return;
        }
        d.j.f.a.a.j.o.h.g((InputStream)var1_1);
        throw var2_3;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArray, String string2) {
        String string3;
        Object object = c;
        Object object2 = "checkClientTrusted: ";
        d.j.f.a.a.j.o.i.e((String)object, (String)object2);
        object = this.a.iterator();
        while (true) {
            boolean bl2 = object.hasNext();
            string3 = "checkServerTrusted CertificateException";
            if (!bl2) break;
            object2 = (X509TrustManager)object.next();
            try {
                object2.checkServerTrusted(x509CertificateArray, string2);
                return;
            }
            catch (CertificateException certificateException) {
                String string4 = c;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                object2 = certificateException.getMessage();
                stringBuilder.append((String)object2);
                object2 = stringBuilder.toString();
                d.j.f.a.a.j.o.i.d(string4, (String)object2);
                continue;
            }
            break;
        }
        x509CertificateArray = new CertificateException(string3);
        throw x509CertificateArray;
    }

    public void checkServerTrusted(X509Certificate[] object, String charSequence) {
        Object object2;
        Object object3;
        Object object4;
        CharSequence charSequence2;
        this.g((X509Certificate[])object);
        String string2 = c;
        CharSequence charSequence3 = new StringBuilder();
        charSequence3.append("checkServerTrusted begin ,server ca chain size is : ");
        int n10 = ((Object)object).length;
        charSequence3.append(n10);
        Object object5 = " ,auth type is : ";
        charSequence3.append((String)object5);
        charSequence3.append((String)charSequence2);
        charSequence3 = charSequence3.toString();
        d.j.f.a.a.j.o.i.e(string2, (String)charSequence3);
        long l10 = System.currentTimeMillis();
        for (Object object6 : object) {
            object4 = c;
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("server ca chain: getSubjectDN is :");
            object2 = ((X509Certificate)object6).getSubjectDN();
            ((StringBuilder)object3).append(object2);
            object3 = ((StringBuilder)object3).toString();
            d.j.f.a.a.j.o.i.b((String)object4, (String)object3);
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("IssuerDN :");
            object2 = ((X509Certificate)object6).getIssuerDN();
            ((StringBuilder)object3).append(object2);
            object3 = ((StringBuilder)object3).toString();
            d.j.f.a.a.j.o.i.b((String)object4, (String)object3);
            object3 = new StringBuilder();
            object2 = "SerialNumber : ";
            ((StringBuilder)object3).append((String)object2);
            BigInteger bigInteger = ((X509Certificate)object6).getSerialNumber();
            ((StringBuilder)object3).append(bigInteger);
            String string3 = ((StringBuilder)object3).toString();
            d.j.f.a.a.j.o.i.b((String)object4, string3);
        }
        object5 = this.a;
        n10 = object5.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            String string4;
            block36: {
                String string5 = c;
                object4 = new StringBuilder();
                object3 = "check server i : ";
                ((StringBuilder)object4).append((String)object3);
                ((StringBuilder)object4).append(i10);
                object4 = ((StringBuilder)object4).toString();
                d.j.f.a.a.j.o.i.e(string5, (String)object4);
                object4 = this.a;
                object4 = object4.get(i10);
                object4 = (X509TrustManager)object4;
                object3 = object4.getAcceptedIssuers();
                if (object3 == null) break block36;
                object2 = new StringBuilder();
                CharSequence charSequence4 = "client root ca size is : ";
                ((StringBuilder)object2).append((String)charSequence4);
                int n12 = ((CharSequence)object3).length;
                ((StringBuilder)object2).append(n12);
                object2 = ((StringBuilder)object2).toString();
                d.j.f.a.a.j.o.i.e(string5, (String)object2);
                int n13 = 0;
                Object var10_17 = null;
                while (true) {
                    int n14 = ((Object)object3).length;
                    if (n13 >= n14) break;
                    object2 = c;
                    charSequence4 = new StringBuilder();
                    Object object7 = "client root ca getIssuerDN :";
                    ((StringBuilder)charSequence4).append((String)object7);
                    object7 = object3[n13];
                    object7 = ((X509Certificate)object7).getIssuerDN();
                    ((StringBuilder)charSequence4).append(object7);
                    charSequence4 = ((StringBuilder)charSequence4).toString();
                    d.j.f.a.a.j.o.i.b((String)object2, (String)charSequence4);
                    ++n13;
                    continue;
                    break;
                }
            }
            try {
                object4.checkServerTrusted((X509Certificate[])object, (String)charSequence2);
                string4 = c;
            }
            catch (CertificateException certificateException) {
                int n15;
                object4 = c;
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("checkServerTrusted error :");
                object2 = certificateException.getMessage();
                ((StringBuilder)object3).append((String)object2);
                object2 = " , time : ";
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append(i10);
                object3 = ((StringBuilder)object3).toString();
                d.j.f.a.a.j.o.i.d((String)object4, (String)object3);
                n11 = n10 + -1;
                if (i10 != n11) continue;
                if (object != null && (n15 = ((Object)object).length) > 0) {
                    charSequence2 = new StringBuilder();
                    string2 = "root ca issuer : ";
                    ((StringBuilder)charSequence2).append(string2);
                    int n16 = ((Object)object).length + -1;
                    Principal principal = ((X509Certificate)object[n16]).getIssuerDN();
                    ((StringBuilder)charSequence2).append(principal);
                    String string6 = ((StringBuilder)charSequence2).toString();
                    d.j.f.a.a.j.o.i.d((String)object4, string6);
                }
                throw certificateException;
            }
            object4 = new StringBuilder();
            object3 = "checkServerTrusted succeed ,root ca issuer is : ";
            ((StringBuilder)object4).append((String)object3);
            n11 = ((Object)object).length + -1;
            object3 = object[n11];
            object3 = ((X509Certificate)object3).getIssuerDN();
            ((StringBuilder)object4).append(object3);
            object4 = ((StringBuilder)object4).toString();
            d.j.f.a.a.j.o.i.e(string4, (String)object4);
            return;
        }
        String string7 = c;
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("checkServerTrusted: cost : ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)charSequence2).append(l11);
        ((StringBuilder)charSequence2).append(" ms");
        charSequence2 = ((StringBuilder)charSequence2).toString();
        d.j.f.a.a.j.o.i.b(string7, (String)charSequence2);
    }

    public X509Certificate[] e() {
        return this.b;
    }

    public List f() {
        return this.a;
    }

    public void g(X509Certificate[] x509CertificateArray) {
        this.b = x509CertificateArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public X509Certificate[] getAcceptedIssuers() {
        try {
            X509Certificate[] x509CertificateArray = new ArrayList();
            X509Certificate[] x509CertificateArray2 = this.a;
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
            String string2 = c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getAcceptedIssuers exception : ");
            String string3 = exception.getMessage();
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            d.j.f.a.a.j.o.i.d(string2, string3);
            return new X509Certificate[0];
        }
    }

    public void h(List list) {
        this.a = list;
    }
}

