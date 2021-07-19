/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.alibaba.sdk.android.oss;

import android.content.Context;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSImpl;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.AppendObjectRequest;
import com.alibaba.sdk.android.oss.model.AppendObjectResult;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.CopyObjectRequest;
import com.alibaba.sdk.android.oss.model.CopyObjectResult;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.alibaba.sdk.android.oss.model.CreateBucketResult;
import com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleRequest;
import com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleResult;
import com.alibaba.sdk.android.oss.model.DeleteBucketLoggingRequest;
import com.alibaba.sdk.android.oss.model.DeleteBucketLoggingResult;
import com.alibaba.sdk.android.oss.model.DeleteBucketRequest;
import com.alibaba.sdk.android.oss.model.DeleteBucketResult;
import com.alibaba.sdk.android.oss.model.DeleteMultipleObjectRequest;
import com.alibaba.sdk.android.oss.model.DeleteMultipleObjectResult;
import com.alibaba.sdk.android.oss.model.DeleteObjectRequest;
import com.alibaba.sdk.android.oss.model.DeleteObjectResult;
import com.alibaba.sdk.android.oss.model.GeneratePresignedUrlRequest;
import com.alibaba.sdk.android.oss.model.GetBucketACLRequest;
import com.alibaba.sdk.android.oss.model.GetBucketACLResult;
import com.alibaba.sdk.android.oss.model.GetBucketInfoRequest;
import com.alibaba.sdk.android.oss.model.GetBucketInfoResult;
import com.alibaba.sdk.android.oss.model.GetBucketLifecycleRequest;
import com.alibaba.sdk.android.oss.model.GetBucketLifecycleResult;
import com.alibaba.sdk.android.oss.model.GetBucketLoggingRequest;
import com.alibaba.sdk.android.oss.model.GetBucketLoggingResult;
import com.alibaba.sdk.android.oss.model.GetBucketRefererRequest;
import com.alibaba.sdk.android.oss.model.GetBucketRefererResult;
import com.alibaba.sdk.android.oss.model.GetObjectACLRequest;
import com.alibaba.sdk.android.oss.model.GetObjectACLResult;
import com.alibaba.sdk.android.oss.model.GetObjectRequest;
import com.alibaba.sdk.android.oss.model.GetObjectResult;
import com.alibaba.sdk.android.oss.model.GetSymlinkRequest;
import com.alibaba.sdk.android.oss.model.GetSymlinkResult;
import com.alibaba.sdk.android.oss.model.HeadObjectRequest;
import com.alibaba.sdk.android.oss.model.HeadObjectResult;
import com.alibaba.sdk.android.oss.model.ImagePersistRequest;
import com.alibaba.sdk.android.oss.model.ImagePersistResult;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.ListBucketsRequest;
import com.alibaba.sdk.android.oss.model.ListBucketsResult;
import com.alibaba.sdk.android.oss.model.ListMultipartUploadsRequest;
import com.alibaba.sdk.android.oss.model.ListMultipartUploadsResult;
import com.alibaba.sdk.android.oss.model.ListObjectsRequest;
import com.alibaba.sdk.android.oss.model.ListObjectsResult;
import com.alibaba.sdk.android.oss.model.ListPartsRequest;
import com.alibaba.sdk.android.oss.model.ListPartsResult;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.PutBucketLifecycleRequest;
import com.alibaba.sdk.android.oss.model.PutBucketLifecycleResult;
import com.alibaba.sdk.android.oss.model.PutBucketLoggingRequest;
import com.alibaba.sdk.android.oss.model.PutBucketLoggingResult;
import com.alibaba.sdk.android.oss.model.PutBucketRefererRequest;
import com.alibaba.sdk.android.oss.model.PutBucketRefererResult;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.alibaba.sdk.android.oss.model.PutSymlinkRequest;
import com.alibaba.sdk.android.oss.model.PutSymlinkResult;
import com.alibaba.sdk.android.oss.model.RestoreObjectRequest;
import com.alibaba.sdk.android.oss.model.RestoreObjectResult;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.model.TriggerCallbackRequest;
import com.alibaba.sdk.android.oss.model.TriggerCallbackResult;
import com.alibaba.sdk.android.oss.model.UploadPartRequest;
import com.alibaba.sdk.android.oss.model.UploadPartResult;

public class OSSClient
implements OSS {
    private OSS mOss;

    public OSSClient(Context context, OSSCredentialProvider oSSCredentialProvider, ClientConfiguration clientConfiguration) {
        OSSImpl oSSImpl = new OSSImpl(context, oSSCredentialProvider, clientConfiguration);
        this.mOss = oSSImpl;
    }

    public OSSClient(Context context, String string2, OSSCredentialProvider oSSCredentialProvider) {
        this(context, string2, oSSCredentialProvider, null);
    }

    public OSSClient(Context context, String string2, OSSCredentialProvider oSSCredentialProvider, ClientConfiguration clientConfiguration) {
        OSSImpl oSSImpl = new OSSImpl(context, string2, oSSCredentialProvider, clientConfiguration);
        this.mOss = oSSImpl;
    }

    public AbortMultipartUploadResult abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) {
        return this.mOss.abortMultipartUpload(abortMultipartUploadRequest);
    }

    public void abortResumableUpload(ResumableUploadRequest resumableUploadRequest) {
        this.mOss.abortResumableUpload(resumableUploadRequest);
    }

    public AppendObjectResult appendObject(AppendObjectRequest appendObjectRequest) {
        return this.mOss.appendObject(appendObjectRequest);
    }

    public OSSAsyncTask asyncAbortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncAbortMultipartUpload(abortMultipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncAppendObject(AppendObjectRequest appendObjectRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncAppendObject(appendObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncCompleteMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncCompleteMultipartUpload(completeMultipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncCopyObject(CopyObjectRequest copyObjectRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncCopyObject(copyObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncCreateBucket(CreateBucketRequest createBucketRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncCreateBucket(createBucketRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncDeleteBucket(DeleteBucketRequest deleteBucketRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncDeleteBucket(deleteBucketRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncDeleteBucketLifecycle(DeleteBucketLifecycleRequest deleteBucketLifecycleRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncDeleteBucketLifecycle(deleteBucketLifecycleRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncDeleteBucketLogging(DeleteBucketLoggingRequest deleteBucketLoggingRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncDeleteBucketLogging(deleteBucketLoggingRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncDeleteMultipleObject(DeleteMultipleObjectRequest deleteMultipleObjectRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncDeleteMultipleObject(deleteMultipleObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncDeleteObject(DeleteObjectRequest deleteObjectRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncDeleteObject(deleteObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncGetBucketACL(GetBucketACLRequest getBucketACLRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncGetBucketACL(getBucketACLRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncGetBucketInfo(GetBucketInfoRequest getBucketInfoRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncGetBucketInfo(getBucketInfoRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncGetBucketLifecycle(GetBucketLifecycleRequest getBucketLifecycleRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncGetBucketLifecycle(getBucketLifecycleRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncGetBucketLogging(GetBucketLoggingRequest getBucketLoggingRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncGetBucketLogging(getBucketLoggingRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncGetBucketReferer(GetBucketRefererRequest getBucketRefererRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncGetBucketReferer(getBucketRefererRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncGetObject(GetObjectRequest getObjectRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncGetObject(getObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncGetObjectACL(GetObjectACLRequest getObjectACLRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncGetObjectACL(getObjectACLRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncGetSymlink(GetSymlinkRequest getSymlinkRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncGetSymlink(getSymlinkRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncHeadObject(HeadObjectRequest headObjectRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncHeadObject(headObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncImagePersist(ImagePersistRequest imagePersistRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncImagePersist(imagePersistRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncInitMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncInitMultipartUpload(initiateMultipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncListBuckets(ListBucketsRequest listBucketsRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncListBuckets(listBucketsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncListMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncListMultipartUploads(listMultipartUploadsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncListObjects(ListObjectsRequest listObjectsRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncListObjects(listObjectsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncListParts(ListPartsRequest listPartsRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncListParts(listPartsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncMultipartUpload(MultipartUploadRequest multipartUploadRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncMultipartUpload(multipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncPutBucketLifecycle(PutBucketLifecycleRequest putBucketLifecycleRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncPutBucketLifecycle(putBucketLifecycleRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncPutBucketLogging(PutBucketLoggingRequest putBucketLoggingRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncPutBucketLogging(putBucketLoggingRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncPutBucketReferer(PutBucketRefererRequest putBucketRefererRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncPutBucketReferer(putBucketRefererRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncPutObject(PutObjectRequest putObjectRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncPutObject(putObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncPutSymlink(PutSymlinkRequest putSymlinkRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncPutSymlink(putSymlinkRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncRestoreObject(RestoreObjectRequest restoreObjectRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncRestoreObject(restoreObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncResumableUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncResumableUpload(resumableUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncSequenceUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncSequenceUpload(resumableUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncTriggerCallback(TriggerCallbackRequest triggerCallbackRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncTriggerCallback(triggerCallbackRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncUploadPart(UploadPartRequest uploadPartRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.mOss.asyncUploadPart(uploadPartRequest, oSSCompletedCallback);
    }

    public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) {
        return this.mOss.completeMultipartUpload(completeMultipartUploadRequest);
    }

    public CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest) {
        return this.mOss.copyObject(copyObjectRequest);
    }

    public CreateBucketResult createBucket(CreateBucketRequest createBucketRequest) {
        return this.mOss.createBucket(createBucketRequest);
    }

    public DeleteBucketResult deleteBucket(DeleteBucketRequest deleteBucketRequest) {
        return this.mOss.deleteBucket(deleteBucketRequest);
    }

    public DeleteBucketLifecycleResult deleteBucketLifecycle(DeleteBucketLifecycleRequest deleteBucketLifecycleRequest) {
        return this.mOss.deleteBucketLifecycle(deleteBucketLifecycleRequest);
    }

    public DeleteBucketLoggingResult deleteBucketLogging(DeleteBucketLoggingRequest deleteBucketLoggingRequest) {
        return this.mOss.deleteBucketLogging(deleteBucketLoggingRequest);
    }

    public DeleteMultipleObjectResult deleteMultipleObject(DeleteMultipleObjectRequest deleteMultipleObjectRequest) {
        return this.mOss.deleteMultipleObject(deleteMultipleObjectRequest);
    }

    public DeleteObjectResult deleteObject(DeleteObjectRequest deleteObjectRequest) {
        return this.mOss.deleteObject(deleteObjectRequest);
    }

    public boolean doesObjectExist(String string2, String string3) {
        return this.mOss.doesObjectExist(string2, string3);
    }

    public GetBucketACLResult getBucketACL(GetBucketACLRequest getBucketACLRequest) {
        return this.mOss.getBucketACL(getBucketACLRequest);
    }

    public GetBucketInfoResult getBucketInfo(GetBucketInfoRequest getBucketInfoRequest) {
        return this.mOss.getBucketInfo(getBucketInfoRequest);
    }

    public GetBucketLifecycleResult getBucketLifecycle(GetBucketLifecycleRequest getBucketLifecycleRequest) {
        return this.mOss.getBucketLifecycle(getBucketLifecycleRequest);
    }

    public GetBucketLoggingResult getBucketLogging(GetBucketLoggingRequest getBucketLoggingRequest) {
        return this.mOss.getBucketLogging(getBucketLoggingRequest);
    }

    public GetBucketRefererResult getBucketReferer(GetBucketRefererRequest getBucketRefererRequest) {
        return this.mOss.getBucketReferer(getBucketRefererRequest);
    }

    public GetObjectResult getObject(GetObjectRequest getObjectRequest) {
        return this.mOss.getObject(getObjectRequest);
    }

    public GetObjectACLResult getObjectACL(GetObjectACLRequest getObjectACLRequest) {
        return this.mOss.getObjectACL(getObjectACLRequest);
    }

    public GetSymlinkResult getSymlink(GetSymlinkRequest getSymlinkRequest) {
        return this.mOss.getSymlink(getSymlinkRequest);
    }

    public HeadObjectResult headObject(HeadObjectRequest headObjectRequest) {
        return this.mOss.headObject(headObjectRequest);
    }

    public ImagePersistResult imagePersist(ImagePersistRequest imagePersistRequest) {
        return this.mOss.imagePersist(imagePersistRequest);
    }

    public InitiateMultipartUploadResult initMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest) {
        return this.mOss.initMultipartUpload(initiateMultipartUploadRequest);
    }

    public ListBucketsResult listBuckets(ListBucketsRequest listBucketsRequest) {
        return this.mOss.listBuckets(listBucketsRequest);
    }

    public ListMultipartUploadsResult listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest) {
        return this.mOss.listMultipartUploads(listMultipartUploadsRequest);
    }

    public ListObjectsResult listObjects(ListObjectsRequest listObjectsRequest) {
        return this.mOss.listObjects(listObjectsRequest);
    }

    public ListPartsResult listParts(ListPartsRequest listPartsRequest) {
        return this.mOss.listParts(listPartsRequest);
    }

    public CompleteMultipartUploadResult multipartUpload(MultipartUploadRequest multipartUploadRequest) {
        return this.mOss.multipartUpload(multipartUploadRequest);
    }

    public String presignConstrainedObjectURL(GeneratePresignedUrlRequest generatePresignedUrlRequest) {
        return this.mOss.presignConstrainedObjectURL(generatePresignedUrlRequest);
    }

    public String presignConstrainedObjectURL(String string2, String string3, long l10) {
        return this.mOss.presignConstrainedObjectURL(string2, string3, l10);
    }

    public String presignPublicObjectURL(String string2, String string3) {
        return this.mOss.presignPublicObjectURL(string2, string3);
    }

    public PutBucketLifecycleResult putBucketLifecycle(PutBucketLifecycleRequest putBucketLifecycleRequest) {
        return this.mOss.putBucketLifecycle(putBucketLifecycleRequest);
    }

    public PutBucketLoggingResult putBucketLogging(PutBucketLoggingRequest putBucketLoggingRequest) {
        return this.mOss.putBucketLogging(putBucketLoggingRequest);
    }

    public PutBucketRefererResult putBucketReferer(PutBucketRefererRequest putBucketRefererRequest) {
        return this.mOss.putBucketReferer(putBucketRefererRequest);
    }

    public PutObjectResult putObject(PutObjectRequest putObjectRequest) {
        return this.mOss.putObject(putObjectRequest);
    }

    public PutSymlinkResult putSymlink(PutSymlinkRequest putSymlinkRequest) {
        return this.mOss.putSymlink(putSymlinkRequest);
    }

    public RestoreObjectResult restoreObject(RestoreObjectRequest restoreObjectRequest) {
        return this.mOss.restoreObject(restoreObjectRequest);
    }

    public ResumableUploadResult resumableUpload(ResumableUploadRequest resumableUploadRequest) {
        return this.mOss.resumableUpload(resumableUploadRequest);
    }

    public ResumableUploadResult sequenceUpload(ResumableUploadRequest resumableUploadRequest) {
        return this.mOss.sequenceUpload(resumableUploadRequest);
    }

    public TriggerCallbackResult triggerCallback(TriggerCallbackRequest triggerCallbackRequest) {
        return this.mOss.triggerCallback(triggerCallbackRequest);
    }

    public void updateCredentialProvider(OSSCredentialProvider oSSCredentialProvider) {
        this.mOss.updateCredentialProvider(oSSCredentialProvider);
    }

    public UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) {
        return this.mOss.uploadPart(uploadPartRequest);
    }
}

