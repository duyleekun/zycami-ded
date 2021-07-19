/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleResult;

public final class ResponseParsers$DeleteBucketLifecycleResponseParser
extends AbstractResponseParser {
    public DeleteBucketLifecycleResult parseData(ResponseMessage responseMessage, DeleteBucketLifecycleResult deleteBucketLifecycleResult) {
        return deleteBucketLifecycleResult;
    }
}

