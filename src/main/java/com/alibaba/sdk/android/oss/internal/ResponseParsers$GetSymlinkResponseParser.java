/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.model.GetSymlinkResult;

public final class ResponseParsers$GetSymlinkResponseParser
extends AbstractResponseParser {
    public GetSymlinkResult parseData(ResponseMessage object, GetSymlinkResult getSymlinkResult) {
        object = (String)((ResponseMessage)object).getHeaders().get("x-oss-symlink-target");
        getSymlinkResult.setTargetObjectName((String)object);
        return getSymlinkResult;
    }
}

