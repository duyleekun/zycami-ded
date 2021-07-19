/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.internal.CheckCRC64DownloadInputStream;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import java.io.InputStream;

public class GetObjectResult
extends OSSResult {
    private long contentLength;
    private ObjectMetadata metadata;
    private InputStream objectContent;

    public GetObjectResult() {
        ObjectMetadata objectMetadata;
        this.metadata = objectMetadata = new ObjectMetadata();
    }

    public Long getClientCRC() {
        boolean bl2;
        InputStream inputStream = this.objectContent;
        if (inputStream != null && (bl2 = inputStream instanceof CheckCRC64DownloadInputStream)) {
            return ((CheckCRC64DownloadInputStream)inputStream).getClientCRC64();
        }
        return super.getClientCRC();
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public InputStream getObjectContent() {
        return this.objectContent;
    }

    public void setContentLength(long l10) {
        this.contentLength = l10;
    }

    public void setMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void setObjectContent(InputStream inputStream) {
        this.objectContent = inputStream;
    }
}

