/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.InternalRequestOperation;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class InternalRequestOperation$3
implements HostnameVerifier {
    public final /* synthetic */ InternalRequestOperation this$0;

    public InternalRequestOperation$3(InternalRequestOperation internalRequestOperation) {
        this.this$0 = internalRequestOperation;
    }

    public boolean verify(String object, SSLSession sSLSession) {
        object = HttpsURLConnection.getDefaultHostnameVerifier();
        String string2 = InternalRequestOperation.access$000(this.this$0).getHost();
        return object.verify(string2, sSLSession);
    }
}

