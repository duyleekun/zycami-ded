/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.GetBucketLoggingResult;

public final class ResponseParsers$GetBucketLoggingResponseParser
extends AbstractResponseParser {
    public GetBucketLoggingResult parseData(ResponseMessage responseMessage, GetBucketLoggingResult getBucketLoggingResult) {
        return ResponseParsers.access$500(responseMessage.getContent(), getBucketLoggingResult);
    }
}

