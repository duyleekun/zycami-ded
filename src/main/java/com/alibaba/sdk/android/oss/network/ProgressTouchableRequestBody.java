/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.network;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import g.b0;
import g.v;
import h.m;
import h.m0;
import h.n;
import h.z;
import java.io.InputStream;

public class ProgressTouchableRequestBody
extends b0 {
    private static final int SEGMENT_SIZE = 2048;
    private OSSProgressCallback callback;
    private long contentLength;
    private String contentType;
    private InputStream inputStream;
    private OSSRequest request;

    public ProgressTouchableRequestBody(InputStream object, long l10, String string2, ExecutionContext executionContext) {
        this.inputStream = object;
        this.contentType = string2;
        this.contentLength = l10;
        this.callback = object = executionContext.getProgressCallback();
        this.request = object = executionContext.getRequest();
    }

    public long contentLength() {
        return this.contentLength;
    }

    public v contentType() {
        return v.j(this.contentType);
    }

    public void writeTo(n n10) {
        long l10;
        long l11;
        Object object;
        long l12;
        m0 m02 = z.m(this.inputStream);
        long l13 = l12 = 0L;
        while ((object = (l11 = l13 - (l10 = this.contentLength)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            long l14;
            long l15;
            long l16;
            l10 = Math.min(l10 - l13, 2048L);
            m m10 = n10.b();
            l10 = m02.read(m10, l10);
            long l17 = l10 - (l16 = (long)-1);
            object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object == false) break;
            n10.flush();
            OSSProgressCallback oSSProgressCallback = this.callback;
            if (oSSProgressCallback == null || (l15 = (l14 = (l13 += l10) - l12) == 0L ? 0 : (l14 < 0L ? -1 : 1)) == false) continue;
            OSSRequest oSSRequest = this.request;
            long l18 = this.contentLength;
            oSSProgressCallback.onProgress(oSSRequest, l13, l18);
        }
        if (m02 != null) {
            m02.close();
        }
    }
}

