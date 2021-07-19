/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult;

public final class ResponseParsers$AbortMultipartUploadResponseParser
extends AbstractResponseParser {
    public AbortMultipartUploadResult parseData(ResponseMessage responseMessage, AbortMultipartUploadResult abortMultipartUploadResult) {
        return abortMultipartUploadResult;
    }
}

