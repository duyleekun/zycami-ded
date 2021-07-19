/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.ListObjectsResult;

public final class ResponseParsers$ListObjectsResponseParser
extends AbstractResponseParser {
    public ListObjectsResult parseData(ResponseMessage responseMessage, ListObjectsResult listObjectsResult) {
        return ResponseParsers.access$800(responseMessage.getContent(), listObjectsResult);
    }
}

