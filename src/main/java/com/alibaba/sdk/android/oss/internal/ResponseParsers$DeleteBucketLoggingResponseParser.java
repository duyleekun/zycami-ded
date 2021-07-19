/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.model.DeleteBucketLoggingResult;

public final class ResponseParsers$DeleteBucketLoggingResponseParser
extends AbstractResponseParser {
    public DeleteBucketLoggingResult parseData(ResponseMessage responseMessage, DeleteBucketLoggingResult deleteBucketLoggingResult) {
        return deleteBucketLoggingResult;
    }
}

