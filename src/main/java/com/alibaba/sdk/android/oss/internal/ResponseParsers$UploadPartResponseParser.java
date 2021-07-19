/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.UploadPartResult;

public final class ResponseParsers$UploadPartResponseParser
extends AbstractResponseParser {
    public UploadPartResult parseData(ResponseMessage object, UploadPartResult uploadPartResult) {
        object = ResponseParsers.trimQuotes((String)((ResponseMessage)object).getHeaders().get("ETag"));
        uploadPartResult.setETag((String)object);
        return uploadPartResult;
    }
}

