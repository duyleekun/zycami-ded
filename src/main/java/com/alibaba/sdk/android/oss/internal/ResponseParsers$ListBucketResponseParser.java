/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.ListBucketsResult;

public final class ResponseParsers$ListBucketResponseParser
extends AbstractResponseParser {
    public ListBucketsResult parseData(ResponseMessage responseMessage, ListBucketsResult listBucketsResult) {
        return ResponseParsers.access$900(responseMessage.getContent(), listBucketsResult);
    }
}

