/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.network;

import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class NetworkHelper$SimpleX509TrustManager
implements X509TrustManager {
    private X509TrustManager standardTrustManager;

    public NetworkHelper$SimpleX509TrustManager(KeyStore object) {
        Object object2;
        Object[] objectArray;
        block8: {
            objectArray = null;
            object2 = "X509";
            object2 = TrustManagerFactory.getInstance((String)object2);
            ((TrustManagerFactory)object2).init((KeyStore)object);
            object = ((TrustManagerFactory)object2).getTrustManagers();
            if (object == null) break block8;
            int n10 = ((TrustManager[])object).length;
            if (n10 == 0) break block8;
            object = object[0];
            object = (X509TrustManager)object;
            this.standardTrustManager = object;
        }
        object2 = "no trust manager found.";
        try {
            super((String)object2);
            throw object;
        }
        catch (Exception exception) {
            object2 = MobLog.getInstance();
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "failed to initialize the standard trust manager: ";
            stringBuilder.append(string2);
            String string3 = exception.getMessage();
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            objectArray = new Object[]{};
            ((NLog)object2).d(string3, objectArray);
            string3 = null;
            this.standardTrustManager = null;
        }
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArray, String string2) {
    }

    public void checkServerTrusted(X509Certificate[] object, String string2) {
        block2: {
            block5: {
                block4: {
                    block3: {
                        if (object == null) break block2;
                        int n10 = ((X509Certificate[])object).length;
                        int n11 = 1;
                        if (n10 != n11) break block3;
                        string2 = null;
                        object = object[0];
                        object.checkValidity();
                        break block4;
                    }
                    X509TrustManager x509TrustManager = this.standardTrustManager;
                    if (x509TrustManager == null) break block5;
                    x509TrustManager.checkServerTrusted((X509Certificate[])object, string2);
                }
                return;
            }
            object = new CertificateException("there were one more certificates but no trust manager found.");
            throw object;
        }
        object = new IllegalArgumentException("there were no certificates.");
        throw object;
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}

