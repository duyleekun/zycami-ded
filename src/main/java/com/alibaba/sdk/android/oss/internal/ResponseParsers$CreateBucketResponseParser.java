/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.model.CreateBucketResult;

public final class ResponseParsers$CreateBucketResponseParser
extends AbstractResponseParser {
    public CreateBucketResult parseData(ResponseMessage object, CreateBucketResult createBucketResult) {
        String string2;
        object = createBucketResult.getResponseHeader();
        boolean bl2 = object.containsKey(string2 = "Location");
        if (bl2) {
            createBucketResult.bucketLocation = object = (String)createBucketResult.getResponseHeader().get(string2);
        }
        return createBucketResult;
    }
}

