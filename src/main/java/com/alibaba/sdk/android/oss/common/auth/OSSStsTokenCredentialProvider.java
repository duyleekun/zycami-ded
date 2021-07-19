/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common.auth;

import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;

public class OSSStsTokenCredentialProvider
implements OSSCredentialProvider {
    private String accessKeyId;
    private String secretKeyId;
    private String securityToken;

    public OSSStsTokenCredentialProvider(OSSFederationToken object) {
        String string2 = ((OSSFederationToken)object).getTempAK().trim();
        this.setAccessKeyId(string2);
        string2 = ((OSSFederationToken)object).getTempSK().trim();
        this.setSecretKeyId(string2);
        object = ((OSSFederationToken)object).getSecurityToken().trim();
        this.setSecurityToken((String)object);
    }

    public OSSStsTokenCredentialProvider(String string2, String string3, String string4) {
        string2 = string2.trim();
        this.setAccessKeyId(string2);
        string2 = string3.trim();
        this.setSecretKeyId(string2);
        string2 = string4.trim();
        this.setSecurityToken(string2);
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public OSSFederationToken getFederationToken() {
        String string2 = this.accessKeyId;
        String string3 = this.secretKeyId;
        String string4 = this.securityToken;
        OSSFederationToken oSSFederationToken = new OSSFederationToken(string2, string3, string4, Long.MAX_VALUE);
        return oSSFederationToken;
    }

    public String getSecretKeyId() {
        return this.secretKeyId;
    }

    public String getSecurityToken() {
        return this.securityToken;
    }

    public void setAccessKeyId(String string2) {
        this.accessKeyId = string2;
    }

    public void setSecretKeyId(String string2) {
        this.secretKeyId = string2;
    }

    public void setSecurityToken(String string2) {
        this.securityToken = string2;
    }
}

