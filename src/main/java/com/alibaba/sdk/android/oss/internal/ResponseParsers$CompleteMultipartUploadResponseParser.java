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
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import java.io.InputStream;

public final class ResponseParsers$CompleteMultipartUploadResponseParser
extends AbstractResponseParser {
    public CompleteMultipartUploadResult parseData(ResponseMessage object, CompleteMultipartUploadResult completeMultipartUploadResult) {
        String string2;
        String string3 = (String)((ResponseMessage)object).getHeaders().get("Content-Type");
        boolean bl2 = string3.equals(string2 = "application/xml");
        if (bl2) {
            object = ((ResponseMessage)object).getContent();
            completeMultipartUploadResult = ResponseParsers.access$1100((InputStream)object, completeMultipartUploadResult);
        } else {
            bl2 = TextUtils.isEmpty((CharSequence)(object = ((ResponseMessage)object).getResponse().r0().string()));
            if (!bl2) {
                completeMultipartUploadResult.setServerCallbackReturnBody((String)object);
            }
        }
        return completeMultipartUploadResult;
    }
}

