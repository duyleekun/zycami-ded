/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.InternalRequestOperation;
import java.net.URI;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class InternalRequestOperation$2
implements HostnameVerifier {
    public final /* synthetic */ InternalRequestOperation this$0;
    public final /* synthetic */ URI val$endpoint;

    public InternalRequestOperation$2(InternalRequestOperation internalRequestOperation, URI uRI) {
        this.this$0 = internalRequestOperation;
        this.val$endpoint = uRI;
    }

    public boolean verify(String object, SSLSession sSLSession) {
        object = HttpsURLConnection.getDefaultHostnameVerifier();
        String string2 = this.val$endpoint.getHost();
        return object.verify(string2, sSLSession);
    }
}

