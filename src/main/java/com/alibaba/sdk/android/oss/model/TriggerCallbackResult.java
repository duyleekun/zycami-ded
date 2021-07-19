/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSResult;

public class TriggerCallbackResult
extends OSSResult {
    private String mServerCallbackReturnBody;

    public String getServerCallbackReturnBody() {
        return this.mServerCallbackReturnBody;
    }

    public void setServerCallbackReturnBody(String string2) {
        this.mServerCallbackReturnBody = string2;
    }
}

