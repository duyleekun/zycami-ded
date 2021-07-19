/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.os.Build$VERSION
 */
package com.google.android.gms.measurement.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.google.android.gms.measurement.internal.zzjv;
import com.google.android.gms.measurement.internal.zzkd;
import com.google.android.gms.measurement.internal.zzkm;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class zzeo
extends zzjv {
    private final SSLSocketFactory zzb;

    public zzeo(zzkd object) {
        super((zzkd)object);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 < n11) {
            SSLSocketFactory sSLSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
            object = new zzkm(sSLSocketFactory);
        } else {
            n10 = 0;
            object = null;
        }
        this.zzb = object;
    }

    public final boolean zzaz() {
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean zzb() {
        boolean bl2;
        this.zzX();
        ConnectivityManager connectivityManager = (ConnectivityManager)this.zzx.zzaw().getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager == null) return networkInfo != null && (bl2 = networkInfo.isConnected());
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && (bl2 = networkInfo.isConnected());
        }
        catch (SecurityException securityException) {}
        return networkInfo != null && (bl2 = networkInfo.isConnected());
    }

    public final HttpURLConnection zzc(URL object) {
        boolean bl2 = (object = ((URL)object).openConnection()) instanceof HttpURLConnection;
        if (bl2) {
            boolean bl3;
            SSLSocketFactory sSLSocketFactory = this.zzb;
            if (sSLSocketFactory != null && (bl3 = object instanceof HttpsURLConnection)) {
                Object object2 = object;
                object2 = (HttpsURLConnection)object;
                ((HttpsURLConnection)object2).setSSLSocketFactory(sSLSocketFactory);
            }
            object = (HttpURLConnection)object;
            ((URLConnection)object).setDefaultUseCaches(false);
            this.zzx.zzc();
            ((URLConnection)object).setConnectTimeout(60000);
            this.zzx.zzc();
            ((URLConnection)object).setReadTimeout(61000);
            ((HttpURLConnection)object).setInstanceFollowRedirects(false);
            ((URLConnection)object).setDoInput(true);
            return object;
        }
        object = new IOException("Failed to obtain HTTP connection");
        throw object;
    }
}

