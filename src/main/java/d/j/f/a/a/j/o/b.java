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

public final class b {
    private static final String a = "CertificateUtil";

    private b() {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static X509Certificate a(Context var0) {
        block26: {
            block24: {
                block25: {
                    var1_2 /* !! */  = null;
                    var2_3 = "bks";
                    var2_3 = KeyStore.getInstance((String)var2_3);
                    var0 = var0.getAssets();
                    var3_13 = "hmsrootcas.bks";
                    var0 = var0.open((String)var3_13);
                    var0.reset();
                    var3_13 = "";
                    var3_13 = var3_13.toCharArray();
                    var2_3.load((InputStream)var0, (char[])var3_13);
                    var3_13 = "052root";
                    var2_3 = var2_3.getCertificate((String)var3_13);
                    try {
                        var2_3 = (X509Certificate)var2_3;
                        var1_2 /* !! */  = var2_3;
                        break block24;
                    }
                    catch (NoSuchAlgorithmException var2_4) {
                        break block25;
                    }
                    catch (IOException var2_5) {
                        break block25;
                    }
                    catch (CertificateException var2_6) {
                        break block25;
                    }
                    catch (KeyStoreException var2_7) {
                        break block25;
                    }
                    catch (Throwable var0_1) {
                        break block26;
                    }
                    catch (NoSuchAlgorithmException var2_8) lbl-1000:
                    // 4 sources

                    {
                        while (true) {
                            var0 = null;
                            break block25;
                            break;
                        }
                    }
                    catch (IOException var2_10) {
                        ** GOTO lbl-1000
                    }
                    catch (CertificateException var2_11) {
                        ** GOTO lbl-1000
                    }
                    catch (KeyStoreException var2_12) {
                        ** continue;
                    }
                }
                var3_13 = "CertificateUtil";
                var4_14 = new StringBuilder();
                var5_15 = "loadBksCA: exception : ";
                var4_14.append(var5_15);
                var2_9 = var2_9.getMessage();
                var4_14.append(var2_9);
                var2_9 = var4_14.toString();
                try {
                    i.d((String)var3_13, var2_9);
                }
                catch (Throwable var6_16) {
                    var1_2 /* !! */  = var0;
                    var0 = var6_16;
                }
            }
            h.g((InputStream)var0);
            return var1_2 /* !! */ ;
        }
        h.g(var1_2 /* !! */ );
        throw var0;
    }
}

