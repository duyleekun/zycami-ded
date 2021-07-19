/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.uploader;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.quvideo.mobile.external.platform.uploader.OooO0O0;
import com.quvideo.mobile.external.platform.uploader.OooO0O0$a;

public class OooO0O0$c
implements OSSProgressCallback {
    public final /* synthetic */ OooO0O0 a;

    private OooO0O0$c(OooO0O0 oooO0O0) {
        this.a = oooO0O0;
    }

    public /* synthetic */ OooO0O0$c(OooO0O0 oooO0O0, OooO0O0$a oooO0O0$a) {
        this(oooO0O0);
    }

    public void a(PutObjectRequest putObjectRequest, long l10, long l11) {
        OooO0O0.OooO00o(this.a, l10, l11);
    }
}

