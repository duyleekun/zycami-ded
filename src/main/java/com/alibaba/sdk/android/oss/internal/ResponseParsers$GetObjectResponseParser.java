/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.alibaba.sdk.android.oss.common.utils.CRC64
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.common.utils.CRC64;
import com.alibaba.sdk.android.oss.internal.AbstractResponseParser;
import com.alibaba.sdk.android.oss.internal.CheckCRC64DownloadInputStream;
import com.alibaba.sdk.android.oss.internal.RequestMessage;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.GetObjectResult;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import java.io.InputStream;
import java.util.zip.Checksum;

public final class ResponseParsers$GetObjectResponseParser
extends AbstractResponseParser {
    public boolean needCloseResponse() {
        return false;
    }

    public GetObjectResult parseData(ResponseMessage object, GetObjectResult getObjectResult) {
        Object object2 = ResponseParsers.parseObjectMetadata(getObjectResult.getResponseHeader());
        getObjectResult.setMetadata((ObjectMetadata)object2);
        long l10 = ((ResponseMessage)object).getContentLength();
        getObjectResult.setContentLength(l10);
        object2 = ((ResponseMessage)object).getRequest();
        boolean bl2 = ((RequestMessage)object2).isCheckCRC64();
        if (bl2) {
            InputStream inputStream = ((ResponseMessage)object).getContent();
            CRC64 cRC64 = new CRC64();
            long l11 = ((ResponseMessage)object).getContentLength();
            object = getObjectResult.getServerCRC();
            long l12 = (Long)object;
            String string2 = getObjectResult.getRequestId();
            object2 = new CheckCRC64DownloadInputStream(inputStream, (Checksum)cRC64, l11, l12, string2);
            getObjectResult.setObjectContent((InputStream)object2);
        } else {
            object = ((ResponseMessage)object).getContent();
            getObjectResult.setObjectContent((InputStream)object);
        }
        return getObjectResult;
    }
}

