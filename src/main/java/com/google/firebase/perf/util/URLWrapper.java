/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf.util;

import java.net.URL;
import java.net.URLConnection;

public class URLWrapper {
    private final URL mURL;

    public URLWrapper(URL uRL) {
        this.mURL = uRL;
    }

    public URLConnection openConnection() {
        return this.mURL.openConnection();
    }

    public String toString() {
        return this.mURL.toString();
    }
}

