/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.HeadObjectResult;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;

public final class ResponseParsers$HeadObjectResponseParser
extends AbstractResponseParser {
    public HeadObjectResult parseData(ResponseMessage object, HeadObjectResult headObjectResult) {
        object = ResponseParsers.parseObjectMetadata(headObjectResult.getResponseHeader());
        headObjectResult.setMetadata((ObjectMetadata)object);
        return headObjectResult;
    }
}

