/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation;
import com.alibaba.sdk.android.oss.model.UploadPartRequest;
import com.alibaba.sdk.android.oss.model.UploadPartResult;

public class InternalRequestOperation$6
implements OSSCompletedCallback {
    public final /* synthetic */ InternalRequestOperation this$0;
    public final /* synthetic */ OSSCompletedCallback val$completedCallback;

    public InternalRequestOperation$6(InternalRequestOperation internalRequestOperation, OSSCompletedCallback oSSCompletedCallback) {
        this.this$0 = internalRequestOperation;
        this.val$completedCallback = oSSCompletedCallback;
    }

    public void onFailure(UploadPartRequest uploadPartRequest, ClientException clientException, ServiceException serviceException) {
        this.val$completedCallback.onFailure(uploadPartRequest, clientException, serviceException);
    }

    public void onSuccess(UploadPartRequest uploadPartRequest, UploadPartResult uploadPartResult) {
        InternalRequestOperation internalRequestOperation = this.this$0;
        OSSCompletedCallback oSSCompletedCallback = this.val$completedCallback;
        InternalRequestOperation.access$100(internalRequestOperation, uploadPartRequest, uploadPartResult, oSSCompletedCallback);
    }
}

