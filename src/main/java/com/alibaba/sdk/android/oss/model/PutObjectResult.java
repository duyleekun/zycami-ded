/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSResult;

public class PutObjectResult
extends OSSResult {
    private String eTag;
    private String serverCallbackReturnBody;

    public String getETag() {
        return this.eTag;
    }

    public String getServerCallbackReturnBody() {
        return this.serverCallbackReturnBody;
    }

    public void setETag(String string2) {
        this.eTag = string2;
    }

    public void setServerCallbackReturnBody(String string2) {
        this.serverCallbackReturnBody = string2;
    }
}

