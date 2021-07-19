/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.model.AppendObjectResult;

public final class ResponseParsers$AppendObjectResponseParser
extends AbstractResponseParser {
    public AppendObjectResult parseData(ResponseMessage object, AppendObjectResult appendObjectResult) {
        Object object2 = ((ResponseMessage)object).getHeaders();
        String string2 = "x-oss-next-append-position";
        if ((object2 = (String)object2.get(string2)) != null) {
            object2 = Long.valueOf((String)object2);
            appendObjectResult.setNextPosition((Long)object2);
        }
        object = (String)((ResponseMessage)object).getHeaders().get("x-oss-hash-crc64ecma");
        appendObjectResult.setObjectCRC64((String)object);
        return appendObjectResult;
    }
}

