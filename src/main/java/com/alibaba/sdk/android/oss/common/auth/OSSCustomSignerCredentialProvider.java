/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common.auth;

import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;

public abstract class OSSCustomSignerCredentialProvider
implements OSSCredentialProvider {
    public OSSFederationToken getFederationToken() {
        return null;
    }

    public abstract String signContent(String var1);
}

