/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import java.io.File;

public class ResumableUploadRequest
extends MultipartUploadRequest {
    private Boolean deleteUploadOnCancelling;
    private String recordDirectory;

    public ResumableUploadRequest(String string2, String string3, String string4) {
        this(string2, string3, string4, null, null);
    }

    public ResumableUploadRequest(String string2, String string3, String string4, ObjectMetadata objectMetadata) {
        this(string2, string3, string4, objectMetadata, null);
    }

    public ResumableUploadRequest(String object, String string2, String string3, ObjectMetadata objectMetadata, String string4) {
        super((String)object, string2, string3, objectMetadata);
        this.deleteUploadOnCancelling = object = Boolean.TRUE;
        this.setRecordDirectory(string4);
    }

    public ResumableUploadRequest(String string2, String string3, String string4, String string5) {
        this(string2, string3, string4, null, string5);
    }

    public Boolean deleteUploadOnCancelling() {
        return this.deleteUploadOnCancelling;
    }

    public String getRecordDirectory() {
        return this.recordDirectory;
    }

    public void setDeleteUploadOnCancelling(Boolean bl2) {
        this.deleteUploadOnCancelling = bl2;
    }

    public void setRecordDirectory(String object) {
        File file;
        boolean bl2;
        boolean bl3 = OSSUtils.isEmptyString((String)object);
        if (!(bl3 || (bl2 = (file = new File((String)object)).exists()) && (bl3 = file.isDirectory()))) {
            object = new IllegalArgumentException("Record directory must exist, and it should be a directory!");
            throw object;
        }
        this.recordDirectory = object;
    }
}

