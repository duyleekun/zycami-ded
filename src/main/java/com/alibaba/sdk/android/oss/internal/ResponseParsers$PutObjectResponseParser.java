/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.PutObjectResult;

public final class ResponseParsers$PutObjectResponseParser
extends AbstractResponseParser {
    public PutObjectResult parseData(ResponseMessage object, PutObjectResult putObjectResult) {
        Object object2 = ((ResponseMessage)object).getHeaders();
        String string2 = "ETag";
        object2 = ResponseParsers.trimQuotes((String)object2.get(string2));
        putObjectResult.setETag((String)object2);
        object = ((ResponseMessage)object).getResponse().r0().string();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            putObjectResult.setServerCallbackReturnBody((String)object);
        }
        return putObjectResult;
    }
}

