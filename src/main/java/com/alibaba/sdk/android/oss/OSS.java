/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss;

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

public interface OSS {
    public AbortMultipartUploadResult abortMultipartUpload(AbortMultipartUploadRequest var1);

    public void abortResumableUpload(ResumableUploadRequest var1);

    public AppendObjectResult appendObject(AppendObjectRequest var1);

    public OSSAsyncTask asyncAbortMultipartUpload(AbortMultipartUploadRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncAppendObject(AppendObjectRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncCompleteMultipartUpload(CompleteMultipartUploadRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncCopyObject(CopyObjectRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncCreateBucket(CreateBucketRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncDeleteBucket(DeleteBucketRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncDeleteBucketLifecycle(DeleteBucketLifecycleRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncDeleteBucketLogging(DeleteBucketLoggingRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncDeleteMultipleObject(DeleteMultipleObjectRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncDeleteObject(DeleteObjectRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncGetBucketACL(GetBucketACLRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncGetBucketInfo(GetBucketInfoRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncGetBucketLifecycle(GetBucketLifecycleRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncGetBucketLogging(GetBucketLoggingRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncGetBucketReferer(GetBucketRefererRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncGetObject(GetObjectRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncGetObjectACL(GetObjectACLRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncGetSymlink(GetSymlinkRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncHeadObject(HeadObjectRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncImagePersist(ImagePersistRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncInitMultipartUpload(InitiateMultipartUploadRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncListBuckets(ListBucketsRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncListMultipartUploads(ListMultipartUploadsRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncListObjects(ListObjectsRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncListParts(ListPartsRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncMultipartUpload(MultipartUploadRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncPutBucketLifecycle(PutBucketLifecycleRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncPutBucketLogging(PutBucketLoggingRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncPutBucketReferer(PutBucketRefererRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncPutObject(PutObjectRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncPutSymlink(PutSymlinkRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncRestoreObject(RestoreObjectRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncResumableUpload(ResumableUploadRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncSequenceUpload(ResumableUploadRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncTriggerCallback(TriggerCallbackRequest var1, OSSCompletedCallback var2);

    public OSSAsyncTask asyncUploadPart(UploadPartRequest var1, OSSCompletedCallback var2);

    public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest var1);

    public CopyObjectResult copyObject(CopyObjectRequest var1);

    public CreateBucketResult createBucket(CreateBucketRequest var1);

    public DeleteBucketResult deleteBucket(DeleteBucketRequest var1);

    public DeleteBucketLifecycleResult deleteBucketLifecycle(DeleteBucketLifecycleRequest var1);

    public DeleteBucketLoggingResult deleteBucketLogging(DeleteBucketLoggingRequest var1);

    public DeleteMultipleObjectResult deleteMultipleObject(DeleteMultipleObjectRequest var1);

    public DeleteObjectResult deleteObject(DeleteObjectRequest var1);

    public boolean doesObjectExist(String var1, String var2);

    public GetBucketACLResult getBucketACL(GetBucketACLRequest var1);

    public GetBucketInfoResult getBucketInfo(GetBucketInfoRequest var1);

    public GetBucketLifecycleResult getBucketLifecycle(GetBucketLifecycleRequest var1);

    public GetBucketLoggingResult getBucketLogging(GetBucketLoggingRequest var1);

    public GetBucketRefererResult getBucketReferer(GetBucketRefererRequest var1);

    public GetObjectResult getObject(GetObjectRequest var1);

    public GetObjectACLResult getObjectACL(GetObjectACLRequest var1);

    public GetSymlinkResult getSymlink(GetSymlinkRequest var1);

    public HeadObjectResult headObject(HeadObjectRequest var1);

    public ImagePersistResult imagePersist(ImagePersistRequest var1);

    public InitiateMultipartUploadResult initMultipartUpload(InitiateMultipartUploadRequest var1);

    public ListBucketsResult listBuckets(ListBucketsRequest var1);

    public ListMultipartUploadsResult listMultipartUploads(ListMultipartUploadsRequest var1);

    public ListObjectsResult listObjects(ListObjectsRequest var1);

    public ListPartsResult listParts(ListPartsRequest var1);

    public CompleteMultipartUploadResult multipartUpload(MultipartUploadRequest var1);

    public String presignConstrainedObjectURL(GeneratePresignedUrlRequest var1);

    public String presignConstrainedObjectURL(String var1, String var2, long var3);

    public String presignPublicObjectURL(String var1, String var2);

    public PutBucketLifecycleResult putBucketLifecycle(PutBucketLifecycleRequest var1);

    public PutBucketLoggingResult putBucketLogging(PutBucketLoggingRequest var1);

    public PutBucketRefererResult putBucketReferer(PutBucketRefererRequest var1);

    public PutObjectResult putObject(PutObjectRequest var1);

    public PutSymlinkResult putSymlink(PutSymlinkRequest var1);

    public RestoreObjectResult restoreObject(RestoreObjectRequest var1);

    public ResumableUploadResult resumableUpload(ResumableUploadRequest var1);

    public ResumableUploadResult sequenceUpload(ResumableUploadRequest var1);

    public TriggerCallbackResult triggerCallback(TriggerCallbackRequest var1);

    public void updateCredentialProvider(OSSCredentialProvider var1);

    public UploadPartResult uploadPart(UploadPartRequest var1);
}

