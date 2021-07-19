/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal.model;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.URL;
import java.net.URLConnection;

public class URLWrapper {
    private final URL zza;

    public URLWrapper(String string2) {
        URL uRL;
        this.zza = uRL = new URL(string2);
    }

    public URLConnection openConnection() {
        return (URLConnection)FirebasePerfUrlConnection.instrument(this.zza.openConnection());
    }
}

