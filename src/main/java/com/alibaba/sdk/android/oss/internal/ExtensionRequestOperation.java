/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Environment
 */
package com.alibaba.sdk.android.oss.internal;

import android.content.Context;
import android.os.Environment;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.internal.ExtensionRequestOperation$1;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation;
import com.alibaba.sdk.android.oss.internal.MultipartUploadTask;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.internal.ResumableUploadTask;
import com.alibaba.sdk.android.oss.internal.SequenceUploadTask;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.HeadObjectRequest;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest$CRC64Config;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import g.z;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExtensionRequestOperation {
    private static ExecutorService executorService;
    private InternalRequestOperation apiOperation;

    static {
        ExtensionRequestOperation$1 extensionRequestOperation$1 = new ExtensionRequestOperation$1();
        executorService = Executors.newFixedThreadPool(5, extensionRequestOperation$1);
    }

    public ExtensionRequestOperation(InternalRequestOperation internalRequestOperation) {
        this.apiOperation = internalRequestOperation;
    }

    private void setCRC64(OSSRequest oSSRequest) {
        boolean bl2;
        OSSRequest$CRC64Config oSSRequest$CRC64Config;
        Object object = oSSRequest.getCRC64();
        object = object != (oSSRequest$CRC64Config = OSSRequest$CRC64Config.NULL) ? oSSRequest.getCRC64() : ((bl2 = ((ClientConfiguration)(object = this.apiOperation.getConf())).isCheckCRC64()) ? OSSRequest$CRC64Config.YES : OSSRequest$CRC64Config.NO);
        oSSRequest.setCRC64((Enum)object);
    }

    public void abortResumableUpload(ResumableUploadRequest object) {
        this.setCRC64((OSSRequest)object);
        Object object2 = ((MultipartUploadRequest)object).getUploadFilePath();
        Object object3 = ((ResumableUploadRequest)object).getRecordDirectory();
        boolean bl2 = OSSUtils.isEmptyString((String)object3);
        if (!bl2) {
            object2 = BinaryUtil.calculateMd5Str((String)object2);
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object2);
            object2 = ((MultipartUploadRequest)object).getBucketName();
            ((StringBuilder)object3).append((String)object2);
            object2 = ((MultipartUploadRequest)object).getObjectKey();
            ((StringBuilder)object3).append((String)object2);
            long l10 = ((MultipartUploadRequest)object).getPartSize();
            object2 = String.valueOf(l10);
            ((StringBuilder)object3).append((String)object2);
            object2 = BinaryUtil.calculateMd5Str(((StringBuilder)object3).toString().getBytes());
            object3 = new StringBuilder();
            Object object4 = ((ResumableUploadRequest)object).getRecordDirectory();
            ((StringBuilder)object3).append((String)object4);
            object4 = "/";
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append((String)object2);
            object2 = ((StringBuilder)object3).toString();
            object3 = new File((String)object2);
            boolean bl3 = ((File)object3).exists();
            if (bl3) {
                object4 = new FileReader((File)object3);
                object2 = new BufferedReader((Reader)object4);
                object4 = ((BufferedReader)object2).readLine();
                ((BufferedReader)object2).close();
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("[initUploadId] - Found record file, uploadid: ");
                ((StringBuilder)object2).append((String)object4);
                OSSLog.logDebug(((StringBuilder)object2).toString());
                object2 = ((OSSRequest)object).getCRC64();
                Object object5 = OSSRequest$CRC64Config.YES;
                if (object2 == object5) {
                    object2 = new StringBuilder();
                    object5 = Environment.getExternalStorageDirectory().getPath();
                    ((StringBuilder)object2).append((String)object5);
                    object5 = File.separator;
                    ((StringBuilder)object2).append((String)object5);
                    String string2 = "oss";
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append((String)object5);
                    ((StringBuilder)object2).append((String)object4);
                    object2 = ((StringBuilder)object2).toString();
                    object5 = new File((String)object2);
                    bl3 = ((File)object5).exists();
                    if (bl3) {
                        ((File)object5).delete();
                    }
                }
                object5 = ((MultipartUploadRequest)object).getBucketName();
                object = ((MultipartUploadRequest)object).getObjectKey();
                object2 = new AbortMultipartUploadRequest((String)object5, (String)object, (String)object4);
                object = this.apiOperation;
                object4 = null;
                ((InternalRequestOperation)object).abortMultipartUpload((AbortMultipartUploadRequest)object2, null);
            }
            ((File)object3).delete();
        }
    }

    public boolean doesObjectExist(String object, String string2) {
        int n10;
        HeadObjectRequest headObjectRequest;
        try {
            headObjectRequest = new HeadObjectRequest((String)object, string2);
            object = this.apiOperation;
            n10 = 0;
            string2 = null;
        }
        catch (ServiceException serviceException) {
            n10 = serviceException.getStatusCode();
            int n11 = 404;
            if (n10 == n11) {
                return false;
            }
            throw serviceException;
        }
        object = ((InternalRequestOperation)object).headObject(headObjectRequest, null);
        ((OSSAsyncTask)object).getResult();
        return true;
    }

    public OSSAsyncTask multipartUpload(MultipartUploadRequest multipartUploadRequest, OSSCompletedCallback oSSCompletedCallback) {
        this.setCRC64(multipartUploadRequest);
        Object object = this.apiOperation.getInnerClient();
        Object object2 = this.apiOperation.getApplicationContext();
        ExecutionContext executionContext = new ExecutionContext((z)object, multipartUploadRequest, (Context)object2);
        object = executorService;
        InternalRequestOperation internalRequestOperation = this.apiOperation;
        object2 = new MultipartUploadTask(internalRequestOperation, multipartUploadRequest, oSSCompletedCallback, executionContext);
        return OSSAsyncTask.wrapRequestTask(object.submit(object2), executionContext);
    }

    public OSSAsyncTask resumableUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback oSSCompletedCallback) {
        this.setCRC64(resumableUploadRequest);
        Object object = this.apiOperation.getInnerClient();
        Object object2 = this.apiOperation.getApplicationContext();
        ExecutionContext executionContext = new ExecutionContext((z)object, resumableUploadRequest, (Context)object2);
        object = executorService;
        InternalRequestOperation internalRequestOperation = this.apiOperation;
        object2 = new ResumableUploadTask(resumableUploadRequest, oSSCompletedCallback, executionContext, internalRequestOperation);
        return OSSAsyncTask.wrapRequestTask(object.submit(object2), executionContext);
    }

    public OSSAsyncTask sequenceUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback oSSCompletedCallback) {
        this.setCRC64(resumableUploadRequest);
        Object object = this.apiOperation.getInnerClient();
        Object object2 = this.apiOperation.getApplicationContext();
        ExecutionContext executionContext = new ExecutionContext((z)object, resumableUploadRequest, (Context)object2);
        object2 = this.apiOperation;
        object = new SequenceUploadTask(resumableUploadRequest, oSSCompletedCallback, executionContext, (InternalRequestOperation)object2);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object), executionContext);
    }
}

