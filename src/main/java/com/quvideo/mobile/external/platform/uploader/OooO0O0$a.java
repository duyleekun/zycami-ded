/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.uploader;

import com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.quvideo.mobile.external.platform.uploader.OooO0O0;

public class OooO0O0$a
extends OSSFederationCredentialProvider {
    public final /* synthetic */ OooO0O0 a;

    public OooO0O0$a(OooO0O0 oooO0O0) {
        this.a = oooO0O0;
    }

    public OSSFederationToken getFederationToken() {
        return OooO0O0.OooO00o(this.a);
    }
}

