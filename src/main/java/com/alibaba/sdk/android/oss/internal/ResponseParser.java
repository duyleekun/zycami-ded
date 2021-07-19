/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.model.OSSResult;

public interface ResponseParser {
    public OSSResult parse(ResponseMessage var1);
}

