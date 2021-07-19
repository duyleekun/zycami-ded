/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.HttpMessage;
import com.alibaba.sdk.android.oss.internal.RequestMessage;
import g.c0;

public class ResponseMessage
extends HttpMessage {
    private RequestMessage request;
    private c0 response;
    private int statusCode;

    public RequestMessage getRequest() {
        return this.request;
    }

    public c0 getResponse() {
        return this.response;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setRequest(RequestMessage requestMessage) {
        this.request = requestMessage;
    }

    public void setResponse(c0 c02) {
        this.response = c02;
    }

    public void setStatusCode(int n10) {
        this.statusCode = n10;
    }
}

