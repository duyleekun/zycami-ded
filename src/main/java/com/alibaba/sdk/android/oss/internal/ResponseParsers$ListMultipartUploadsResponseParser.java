/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.model.ListMultipartUploadsResult;

public final class ResponseParsers$ListMultipartUploadsResponseParser
extends AbstractResponseParser {
    public ListMultipartUploadsResult parseData(ResponseMessage responseMessage, ListMultipartUploadsResult listMultipartUploadsResult) {
        return listMultipartUploadsResult.parseData(responseMessage);
    }
}

