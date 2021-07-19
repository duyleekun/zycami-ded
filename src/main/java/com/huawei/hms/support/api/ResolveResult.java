/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api;

import com.huawei.hms.support.api.client.Result;

public class ResolveResult
extends Result {
    private Object entity;

    public ResolveResult() {
        this.entity = null;
    }

    public ResolveResult(Object object) {
        this.entity = object;
    }

    public Object getValue() {
        return this.entity;
    }
}

