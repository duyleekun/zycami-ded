/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation;
import com.alibaba.sdk.android.oss.internal.MultipartUploadTask$1;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

public class MultipartUploadTask
extends BaseMultipartUploadTask
implements Callable {
    public MultipartUploadTask(InternalRequestOperation internalRequestOperation, MultipartUploadRequest multipartUploadRequest, OSSCompletedCallback oSSCompletedCallback, ExecutionContext executionContext) {
        super(internalRequestOperation, multipartUploadRequest, oSSCompletedCallback, executionContext);
    }

    public void abortThisUpload() {
        Object object = this.mUploadId;
        if (object != null) {
            Object object2 = this.mRequest.getBucketName();
            String string2 = this.mRequest.getObjectKey();
            String string3 = this.mUploadId;
            object = new AbortMultipartUploadRequest((String)object2, string2, string3);
            object2 = this.mApiOperation;
            string2 = null;
            object = ((InternalRequestOperation)object2).abortMultipartUpload((AbortMultipartUploadRequest)object, null);
            ((OSSAsyncTask)object).waitUntilFinished();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public CompleteMultipartUploadResult doMultipartUpload() {
        this.checkCancel();
        Object object = this.mPartAttr;
        Object object2 = null;
        int n10 = object[0];
        int n11 = object[1];
        int n12 = n10;
        n10 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            this.checkException();
            ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
            if (threadPoolExecutor == null) continue;
            int n13 = n11 + -1;
            if (i10 == n13) {
                long l10 = this.mFileLength;
                long l11 = n10;
                n12 = (int)(l10 -= l11);
            }
            n10 += n12;
            MultipartUploadTask$1 multipartUploadTask$1 = new MultipartUploadTask$1(this, i10, n12, n11);
            threadPoolExecutor.execute(multipartUploadTask$1);
        }
        if ((n11 = (int)(this.checkWaitCondition(n11) ? 1 : 0)) != 0) {
            object = this.mLock;
            synchronized (object) {
                object2 = this.mLock;
                object2.wait();
            }
        }
        if ((object = (Object)this.mUploadException) != null) {
            this.abortThisUpload();
        }
        this.checkException();
        object = this.completeMultipartUploadResult();
        this.releasePool();
        return object;
    }

    public void initMultipartUploadId() {
        String string2 = this.mRequest.getBucketName();
        String string3 = this.mRequest.getObjectKey();
        ObjectMetadata objectMetadata = this.mRequest.getMetadata();
        Object object = new InitiateMultipartUploadRequest(string2, string3, objectMetadata);
        this.mUploadId = object = ((InitiateMultipartUploadResult)this.mApiOperation.initMultipartUpload((InitiateMultipartUploadRequest)object, null).getResult()).getUploadId();
        this.mRequest.setUploadId((String)object);
    }

    public void preUploadPart(int n10, int n11, int n12) {
        this.checkException();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void processException(Exception object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            int n10;
            this.mPartExceptionCount = n10 = this.mPartExceptionCount + 1;
            Exception exception = this.mUploadException;
            if (exception == null) {
                this.mUploadException = object;
                object = this.mLock;
                object.notify();
            }
            return;
        }
    }
}

