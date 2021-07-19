/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult;

public final class ResponseParsers$InitMultipartResponseParser
extends AbstractResponseParser {
    public InitiateMultipartUploadResult parseData(ResponseMessage responseMessage, InitiateMultipartUploadResult initiateMultipartUploadResult) {
        return ResponseParsers.access$1000(responseMessage.getContent(), initiateMultipartUploadResult);
    }
}

