/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.network;

import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import com.alibaba.sdk.android.oss.network.ProgressTouchableResponseBody$1;
import g.d0;
import g.v;
import h.m0;
import h.o;
import h.z;

public class ProgressTouchableResponseBody
extends d0 {
    private o mBufferedSource;
    private OSSProgressCallback mProgressListener;
    private final d0 mResponseBody;
    private OSSRequest request;

    public ProgressTouchableResponseBody(d0 object, ExecutionContext executionContext) {
        this.mResponseBody = object;
        this.mProgressListener = object = executionContext.getProgressCallback();
        this.request = object = executionContext.getRequest();
    }

    public static /* synthetic */ OSSProgressCallback access$000(ProgressTouchableResponseBody progressTouchableResponseBody) {
        return progressTouchableResponseBody.mProgressListener;
    }

    public static /* synthetic */ OSSRequest access$100(ProgressTouchableResponseBody progressTouchableResponseBody) {
        return progressTouchableResponseBody.request;
    }

    public static /* synthetic */ d0 access$200(ProgressTouchableResponseBody progressTouchableResponseBody) {
        return progressTouchableResponseBody.mResponseBody;
    }

    private m0 source(m0 m02) {
        ProgressTouchableResponseBody$1 progressTouchableResponseBody$1 = new ProgressTouchableResponseBody$1(this, m02);
        return progressTouchableResponseBody$1;
    }

    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    public v contentType() {
        return this.mResponseBody.contentType();
    }

    public o source() {
        o o10 = this.mBufferedSource;
        if (o10 == null) {
            o10 = this.mResponseBody.source();
            this.mBufferedSource = o10 = z.d(this.source(o10));
        }
        return this.mBufferedSource;
    }
}

