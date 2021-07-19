/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.j.f.a.a.j.o;

import android.content.Context;
import d.j.f.a.a.j.o.h;
import d.j.f.a.a.j.o.i;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class l {
    private static final String b = "X509CertificateUtil";
    public static final String c = "hmsrootcas.bks";
    public static final String d = "";
    public static final String e = "bks";
    public static final String f = "052root";
    private static final String g = "hmsincas.bks";
    private static final String h = "huawei cbg application integration ca";
    private Context a;

    public l(Context context) {
        this.a = context;
    }

    public X509Certificate a() {
        return this.b(g, h);
    }

    /*
     * Unable to fully structure code
     */
    public X509Certificate b(String var1_1, String var2_2) {
        block27: {
            block25: {
                block26: {
                    var3_14 = null;
                    var4_15 = "bks";
                    var4_15 = KeyStore.getInstance((String)var4_15);
                    var5_16 = this.a;
                    var5_16 = var5_16.getAssets();
                    var1_1 = var5_16.open((String)var1_1);
                    var1_1.reset();
                    var5_16 = "";
                    var5_16 = var5_16.toCharArray();
                    var4_15.load((InputStream)var1_1, (char[])var5_16);
                    var2_2 = var4_15.getCertificate((String)var2_2);
                    try {
                        var3_14 = var2_2 = (X509Certificate)var2_2;
                        break block25;
                    }
                    catch (NoSuchAlgorithmException var2_3) {
                        break block26;
                    }
                    catch (IOException var2_4) {
                        break block26;
                    }
                    catch (CertificateException var2_5) {
                        break block26;
                    }
                    catch (KeyStoreException var2_6) {
                        break block26;
                    }
                    catch (Throwable var2_7) {
                        break block27;
                    }
                    catch (NoSuchAlgorithmException var2_8) lbl-1000:
                    // 4 sources

                    {
                        while (true) {
                            var1_1 = null;
                            break block26;
                            break;
                        }
                    }
                    catch (IOException var2_9) {
                        ** GOTO lbl-1000
                    }
                    catch (CertificateException var2_10) {
                        ** GOTO lbl-1000
                    }
                    catch (KeyStoreException var2_11) {
                        ** continue;
                    }
                }
                var4_15 = "X509CertificateUtil";
                var5_16 = new StringBuilder();
                var6_17 = "loadBksCA: exception : ";
                var5_16.append(var6_17);
                var2_2 = var2_2.getMessage();
                var5_16.append((String)var2_2);
                var2_2 = var5_16.toString();
                try {
                    i.d((String)var4_15, (String)var2_2);
                }
                catch (Throwable var2_12) {
                    var3_14 = var1_1;
                }
            }
            d.j.f.a.a.j.o.h.g((InputStream)var1_1);
            return var3_14;
        }
        d.j.f.a.a.j.o.h.g(var3_14);
        throw var2_13;
    }

    public X509Certificate c() {
        return this.b(c, f);
    }
}

