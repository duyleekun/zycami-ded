/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.GetBucketACLResult;

public final class ResponseParsers$GetBucketACLResponseParser
extends AbstractResponseParser {
    public GetBucketACLResult parseData(ResponseMessage responseMessage, GetBucketACLResult getBucketACLResult) {
        return ResponseParsers.access$300(responseMessage.getContent(), getBucketACLResult);
    }
}

