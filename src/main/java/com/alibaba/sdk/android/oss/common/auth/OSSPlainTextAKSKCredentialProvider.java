/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common.auth;

import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;

public class OSSPlainTextAKSKCredentialProvider
implements OSSCredentialProvider {
    private String accessKeyId;
    private String accessKeySecret;

    public OSSPlainTextAKSKCredentialProvider(String string2, String string3) {
        string2 = string2.trim();
        this.setAccessKeyId(string2);
        string2 = string3.trim();
        this.setAccessKeySecret(string2);
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public OSSFederationToken getFederationToken() {
        return null;
    }

    public void setAccessKeyId(String string2) {
        this.accessKeyId = string2;
    }

    public void setAccessKeySecret(String string2) {
        this.accessKeySecret = string2;
    }
}

