/*
 * Decompiled with CFR 0.151.
 */
package com.quvideo.mobile.external.platform.uploader;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.quvideo.mobile.external.platform.uploader.OooO0O0;
import com.quvideo.mobile.external.platform.uploader.OooO0O0$a;

public class OooO0O0$d
implements OSSCompletedCallback {
    public final /* synthetic */ OooO0O0 a;

    private OooO0O0$d(OooO0O0 oooO0O0) {
        this.a = oooO0O0;
    }

    public /* synthetic */ OooO0O0$d(OooO0O0 oooO0O0, OooO0O0$a oooO0O0$a) {
        this(oooO0O0);
    }

    public void a(ResumableUploadRequest resumableUploadRequest, ClientException clientException, ServiceException serviceException) {
        OooO0O0.OooO00o(this.a, clientException, serviceException);
    }

    public void b(ResumableUploadRequest resumableUploadRequest, ResumableUploadResult resumableUploadResult) {
        OooO0O0.OooO0O0(this.a);
    }
}

