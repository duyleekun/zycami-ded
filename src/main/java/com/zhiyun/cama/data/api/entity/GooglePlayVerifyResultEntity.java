/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import com.zhiyun.cama.data.api.entity.GooglePlayVerifyResultEntity$Result;
import com.zhiyun.net.BaseEntity;

public class GooglePlayVerifyResultEntity
extends BaseEntity {
    private GooglePlayVerifyResultEntity$Result mResult;

    public GooglePlayVerifyResultEntity$Result getResult() {
        return this.mResult;
    }

    public void setResult(GooglePlayVerifyResultEntity$Result googlePlayVerifyResultEntity$Result) {
        this.mResult = googlePlayVerifyResultEntity$Result;
    }
}

