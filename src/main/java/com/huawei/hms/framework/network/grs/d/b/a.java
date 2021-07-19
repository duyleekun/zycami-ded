/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.framework.network.grs.d.b;

import android.content.Context;
import d.j.f.a.a.j.g;
import d.j.f.a.a.j.i;
import d.j.f.a.a.j.n.b;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

public class a {
    public static HostnameVerifier a() {
        b b10 = new b();
        return b10;
    }

    /*
     * WARNING - void declaration
     */
    public static SSLSocketFactory a(Context object) {
        void var0_4;
        object = object.getAssets();
        Object object2 = "grs_sp.bks";
        object = object.open((String)object2);
        String string2 = "";
        object2 = new i((InputStream)object, string2);
        try {
            object = new g((X509TrustManager)object2);
            return object;
        }
        catch (KeyManagementException keyManagementException) {
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        object2 = new AssertionError(var0_4);
        throw object2;
    }
}

