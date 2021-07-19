/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import java.util.List;

public class InternalRequestOperation$7
implements OSSCompletedCallback {
    public final /* synthetic */ InternalRequestOperation this$0;
    public final /* synthetic */ OSSCompletedCallback val$completedCallback;

    public InternalRequestOperation$7(InternalRequestOperation internalRequestOperation, OSSCompletedCallback oSSCompletedCallback) {
        this.this$0 = internalRequestOperation;
        this.val$completedCallback = oSSCompletedCallback;
    }

    public void onFailure(CompleteMultipartUploadRequest completeMultipartUploadRequest, ClientException clientException, ServiceException serviceException) {
        this.val$completedCallback.onFailure(completeMultipartUploadRequest, clientException, serviceException);
    }

    public void onSuccess(CompleteMultipartUploadRequest completeMultipartUploadRequest, CompleteMultipartUploadResult completeMultipartUploadResult) {
        Object object;
        Object object2 = completeMultipartUploadResult.getServerCRC();
        if (object2 != null) {
            object2 = this.this$0;
            object = completeMultipartUploadRequest.getPartETags();
            long l10 = InternalRequestOperation.access$200((InternalRequestOperation)object2, (List)object);
            object2 = l10;
            completeMultipartUploadResult.setClientCRC((Long)object2);
        }
        object2 = this.this$0;
        object = this.val$completedCallback;
        InternalRequestOperation.access$100((InternalRequestOperation)object2, completeMultipartUploadRequest, completeMultipartUploadResult, (OSSCompletedCallback)object);
    }
}

