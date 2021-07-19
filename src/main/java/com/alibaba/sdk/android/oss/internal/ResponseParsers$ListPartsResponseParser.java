/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.ListPartsResult;

public final class ResponseParsers$ListPartsResponseParser
extends AbstractResponseParser {
    public ListPartsResult parseData(ResponseMessage responseMessage, ListPartsResult listPartsResult) {
        return ResponseParsers.access$1200(responseMessage.getContent(), listPartsResult);
    }
}

