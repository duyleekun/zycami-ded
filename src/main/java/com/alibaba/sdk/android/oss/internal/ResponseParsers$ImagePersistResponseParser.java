/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.model.ImagePersistResult;

public final class ResponseParsers$ImagePersistResponseParser
extends AbstractResponseParser {
    public ImagePersistResult parseData(ResponseMessage responseMessage, ImagePersistResult imagePersistResult) {
        return imagePersistResult;
    }
}

