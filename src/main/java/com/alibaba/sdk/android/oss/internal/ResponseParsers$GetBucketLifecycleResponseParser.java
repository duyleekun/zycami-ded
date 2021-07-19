/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult;

public final class ResponseParsers$GetBucketLifecycleResponseParser
extends AbstractResponseParser {
    public GetBucketLifecycleResult parseData(ResponseMessage responseMessage, GetBucketLifecycleResult getBucketLifecycleResult) {
        return ResponseParsers.access$600(responseMessage.getContent(), getBucketLifecycleResult);
    }
}

