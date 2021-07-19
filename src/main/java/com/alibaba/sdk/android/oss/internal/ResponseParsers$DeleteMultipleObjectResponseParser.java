/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult;

public final class ResponseParsers$DeleteMultipleObjectResponseParser
extends AbstractResponseParser {
    public DeleteMultipleObjectResult parseData(ResponseMessage responseMessage, DeleteMultipleObjectResult deleteMultipleObjectResult) {
        return ResponseParsers.access$700(responseMessage.getContent(), deleteMultipleObjectResult);
    }
}

