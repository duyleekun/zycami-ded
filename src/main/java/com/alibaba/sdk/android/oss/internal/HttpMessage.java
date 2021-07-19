/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.common.utils.CaseInsensitiveHashMap;
import java.io.InputStream;
import java.util.Map;

public abstract class HttpMessage {
    private InputStream content;
    private long contentLength;
    private Map headers;
    private String stringBody;

    public HttpMessage() {
        CaseInsensitiveHashMap caseInsensitiveHashMap = new CaseInsensitiveHashMap();
        this.headers = caseInsensitiveHashMap;
    }

    public void addHeader(String string2, String string3) {
        this.headers.put(string2, string3);
    }

    public void close() {
        InputStream inputStream = this.content;
        if (inputStream != null) {
            inputStream.close();
            inputStream = null;
            this.content = null;
        }
    }

    public InputStream getContent() {
        return this.content;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public Map getHeaders() {
        return this.headers;
    }

    public String getStringBody() {
        return this.stringBody;
    }

    public void setContent(InputStream inputStream) {
        this.content = inputStream;
    }

    public void setContentLength(long l10) {
        this.contentLength = l10;
    }

    public void setHeaders(Map map) {
        int n10;
        Map map2 = this.headers;
        if (map2 == null) {
            this.headers = map2 = new CaseInsensitiveHashMap();
        }
        if ((map2 = this.headers) != null && (n10 = map2.size()) > 0) {
            map2 = this.headers;
            map2.clear();
        }
        this.headers.putAll(map);
    }

    public void setStringBody(String string2) {
        this.stringBody = string2;
    }
}

