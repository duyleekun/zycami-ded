/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.GetBucketRefererResult;

public final class ResponseParsers$GetBucketRefererResponseParser
extends AbstractResponseParser {
    public GetBucketRefererResult parseData(ResponseMessage responseMessage, GetBucketRefererResult getBucketRefererResult) {
        return ResponseParsers.access$400(responseMessage.getContent(), getBucketRefererResult);
    }
}

