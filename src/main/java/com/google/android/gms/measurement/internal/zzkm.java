/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzkl;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class zzkm
extends SSLSocketFactory {
    private final SSLSocketFactory zza;

    public zzkm() {
        SSLSocketFactory sSLSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
        this.zza = sSLSocketFactory;
    }

    public zzkm(SSLSocketFactory sSLSocketFactory) {
        this.zza = sSLSocketFactory;
    }

    public final Socket createSocket() {
        SSLSocket sSLSocket = (SSLSocket)this.zza.createSocket();
        zzkl zzkl2 = new zzkl(this, sSLSocket);
        return zzkl2;
    }

    public final Socket createSocket(String object, int n10) {
        object = (SSLSocket)this.zza.createSocket((String)object, n10);
        zzkl zzkl2 = new zzkl(this, (SSLSocket)object);
        return zzkl2;
    }

    public final Socket createSocket(String object, int n10, InetAddress inetAddress, int n11) {
        object = (SSLSocket)this.zza.createSocket((String)object, n10, inetAddress, n11);
        zzkl zzkl2 = new zzkl(this, (SSLSocket)object);
        return zzkl2;
    }

    public final Socket createSocket(InetAddress object, int n10) {
        object = (SSLSocket)this.zza.createSocket((InetAddress)object, n10);
        zzkl zzkl2 = new zzkl(this, (SSLSocket)object);
        return zzkl2;
    }

    public final Socket createSocket(InetAddress object, int n10, InetAddress inetAddress, int n11) {
        object = (SSLSocket)this.zza.createSocket((InetAddress)object, n10, inetAddress, n11);
        zzkl zzkl2 = new zzkl(this, (SSLSocket)object);
        return zzkl2;
    }

    public final Socket createSocket(Socket socket, String object, int n10, boolean bl2) {
        socket = (SSLSocket)this.zza.createSocket(socket, (String)object, n10, bl2);
        object = new zzkl(this, (SSLSocket)socket);
        return object;
    }

    public final String[] getDefaultCipherSuites() {
        return this.zza.getDefaultCipherSuites();
    }

    public final String[] getSupportedCipherSuites() {
        return this.zza.getSupportedCipherSuites();
    }
}

