/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.network;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.network.ProgressTouchableResponseBody;
import g.d0;
import h.m;
import h.m0;
import h.r;

public class ProgressTouchableResponseBody$1
extends r {
    public final /* synthetic */ ProgressTouchableResponseBody this$0;
    private long totalBytesRead;

    public ProgressTouchableResponseBody$1(ProgressTouchableResponseBody progressTouchableResponseBody, m0 m02) {
        this.this$0 = progressTouchableResponseBody;
        super(m02);
        this.totalBytesRead = 0L;
    }

    public long read(m m10, long l10) {
        long l11;
        long l12 = super.read(m10, l10);
        long l13 = this.totalBytesRead;
        long l14 = l12 - (long)-1;
        long l15 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        long l16 = 0L;
        long l17 = l15 != false ? l12 : l16;
        this.totalBytesRead = l13 += l17;
        OSSProgressCallback oSSProgressCallback = ProgressTouchableResponseBody.access$000(this.this$0);
        if (oSSProgressCallback != null && l15 != false && (l15 = (l11 = (l13 = this.totalBytesRead) - l16) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            oSSProgressCallback = ProgressTouchableResponseBody.access$000(this.this$0);
            OSSRequest oSSRequest = ProgressTouchableResponseBody.access$100(this.this$0);
            l16 = this.totalBytesRead;
            d0 d02 = ProgressTouchableResponseBody.access$200(this.this$0);
            l17 = d02.contentLength();
            oSSProgressCallback.onProgress(oSSRequest, l16, l17);
        }
        return l12;
    }
}

