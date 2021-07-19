/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.uploader;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.quvideo.mobile.external.platform.uploader.OooO0O0;
import com.quvideo.mobile.external.platform.uploader.OooO0O0$a;

public class OooO0O0$b
implements OSSCompletedCallback {
    public final /* synthetic */ OooO0O0 a;

    private OooO0O0$b(OooO0O0 oooO0O0) {
        this.a = oooO0O0;
    }

    public /* synthetic */ OooO0O0$b(OooO0O0 oooO0O0, OooO0O0.a a10) {
        this(oooO0O0);
    }

    public void a(PutObjectRequest putObjectRequest, ClientException clientException, ServiceException serviceException) {
        OooO0O0.OooO00o(this.a, clientException, serviceException);
    }

    public void b(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {
        OooO0O0.OooO0O0(this.a);
    }
}

