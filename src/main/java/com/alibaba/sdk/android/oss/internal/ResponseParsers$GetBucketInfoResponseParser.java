/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.GetBucketInfoResult;

public final class ResponseParsers$GetBucketInfoResponseParser
extends AbstractResponseParser {
    public GetBucketInfoResult parseData(ResponseMessage responseMessage, GetBucketInfoResult getBucketInfoResult) {
        return ResponseParsers.access$200(responseMessage.getContent(), getBucketInfoResult);
    }
}

