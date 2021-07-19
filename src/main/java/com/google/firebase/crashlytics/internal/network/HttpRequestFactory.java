/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.network;

import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import java.util.Collections;
import java.util.Map;

public class HttpRequestFactory {
    public HttpGetRequest buildHttpGetRequest(String string2) {
        Map map = Collections.emptyMap();
        return this.buildHttpGetRequest(string2, map);
    }

    public HttpGetRequest buildHttpGetRequest(String string2, Map map) {
        HttpGetRequest httpGetRequest = new HttpGetRequest(string2, map);
        return httpGetRequest;
    }
}

