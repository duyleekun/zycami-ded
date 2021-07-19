/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.CopyObjectResult;

public final class ResponseParsers$CopyObjectResponseParser
extends AbstractResponseParser {
    public CopyObjectResult parseData(ResponseMessage responseMessage, CopyObjectResult copyObjectResult) {
        return ResponseParsers.access$100(responseMessage.getContent(), copyObjectResult);
    }
}

