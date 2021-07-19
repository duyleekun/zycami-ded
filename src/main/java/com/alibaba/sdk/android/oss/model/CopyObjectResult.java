/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSResult;
import java.util.Date;

public class CopyObjectResult
extends OSSResult {
    private String etag;
    private Date lastModified;

    public String getETag() {
        return this.etag;
    }

    public Date getLastModified() {
        return this.lastModified;
    }

    public void setEtag(String string2) {
        this.etag = string2;
    }

    public void setLastModified(Date date) {
        this.lastModified = date;
    }
}

