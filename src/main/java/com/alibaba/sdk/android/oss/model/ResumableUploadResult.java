/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.OSSResult;
import java.util.Map;

public class ResumableUploadResult
extends CompleteMultipartUploadResult {
    public ResumableUploadResult(CompleteMultipartUploadResult object) {
        Object object2 = ((OSSResult)object).getRequestId();
        this.setRequestId((String)object2);
        object2 = ((OSSResult)object).getResponseHeader();
        this.setResponseHeader((Map)object2);
        int n10 = ((OSSResult)object).getStatusCode();
        this.setStatusCode(n10);
        object2 = ((OSSResult)object).getClientCRC();
        this.setClientCRC((Long)object2);
        object2 = ((OSSResult)object).getServerCRC();
        this.setServerCRC((Long)object2);
        object2 = ((CompleteMultipartUploadResult)object).getBucketName();
        this.setBucketName((String)object2);
        object2 = ((CompleteMultipartUploadResult)object).getObjectKey();
        this.setObjectKey((String)object2);
        object2 = ((CompleteMultipartUploadResult)object).getETag();
        this.setETag((String)object2);
        object2 = ((CompleteMultipartUploadResult)object).getLocation();
        this.setLocation((String)object2);
        object = ((CompleteMultipartUploadResult)object).getServerCallbackReturnBody();
        this.setServerCallbackReturnBody((String)object);
    }
}

