/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.google.android.gms.measurement.internal;

import android.os.Build;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzgf;
import com.google.android.gms.measurement.internal.zzkm;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class zzhr
extends zzgf {
    private final SSLSocketFactory zza;

    public zzhr(zzfl object) {
        super((zzfl)object);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 < n11) {
            SSLSocketFactory sSLSocketFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
            object = new zzkm(sSLSocketFactory);
        } else {
            n10 = 0;
            object = null;
        }
        this.zza = object;
    }

    public final boolean zza() {
        return false;
    }

    public final HttpURLConnection zzd(URL object) {
        boolean bl2 = (object = ((URL)object).openConnection()) instanceof HttpURLConnection;
        if (bl2) {
            boolean bl3;
            SSLSocketFactory sSLSocketFactory = this.zza;
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

