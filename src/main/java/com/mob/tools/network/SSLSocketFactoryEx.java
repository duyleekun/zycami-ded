/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.http.conn.ssl.SSLSocketFactory
 *  org.apache.http.conn.ssl.X509HostnameVerifier
 */
package com.mob.tools.network;

import com.mob.tools.network.NetworkHelper$SimpleX509TrustManager;
import java.net.Socket;
import java.security.KeyStore;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class SSLSocketFactoryEx
extends SSLSocketFactory {
    public SSLContext sslContext;

    public SSLSocketFactoryEx(KeyStore trustManagerArray) {
        super((KeyStore)trustManagerArray);
        trustManagerArray = SSLContext.getInstance("TLS");
        this.sslContext = trustManagerArray;
        trustManagerArray = new TrustManager[1];
        Object object = new NetworkHelper$SimpleX509TrustManager(null);
        trustManagerArray[0] = object;
        object = this.sslContext;
        SecureRandom secureRandom = new SecureRandom();
        ((SSLContext)object).init(null, trustManagerArray, secureRandom);
    }

    public void allowAllHostnameVerifier() {
        X509HostnameVerifier x509HostnameVerifier = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
        this.setHostnameVerifier(x509HostnameVerifier);
    }

    public Socket createSocket() {
        return this.sslContext.getSocketFactory().createSocket();
    }

    public Socket createSocket(Socket socket, String string2, int n10, boolean bl2) {
        return this.sslContext.getSocketFactory().createSocket(socket, string2, n10, bl2);
    }
}

