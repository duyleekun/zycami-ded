/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.lbsapi.auth;

import com.baidu.lbsapi.auth.g;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class h
implements HostnameVerifier {
    public final /* synthetic */ g a;

    public h(g g10) {
        this.a = g10;
    }

    public boolean verify(String string2, SSLSession sSLSession) {
        String string3 = "api.map.baidu.com";
        boolean bl2 = string3.equals(string2);
        if (bl2) {
            return true;
        }
        return HttpsURLConnection.getDefaultHostnameVerifier().verify(string2, sSLSession);
    }
}

