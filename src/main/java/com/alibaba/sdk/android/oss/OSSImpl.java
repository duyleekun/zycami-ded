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
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.OSSLogToFileUtils;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.internal.ExtensionRequestOperation;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.internal.ObjectURLPresigner;
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
import java.net.URI;
import java.net.URISyntaxException;

public class OSSImpl
implements OSS {
    private ClientConfiguration conf;
    private OSSCredentialProvider credentialProvider;
    private URI endpointURI;
    private ExtensionRequestOperation extensionRequestOperation;
    private InternalRequestOperation internalRequestOperation;

    public OSSImpl(Context object, OSSCredentialProvider object2, ClientConfiguration object3) {
        this.credentialProvider = object2;
        if (object3 == null) {
            object3 = ClientConfiguration.getDefaultConf();
        }
        this.conf = object3;
        object = object.getApplicationContext();
        ClientConfiguration clientConfiguration = this.conf;
        object2 = this.internalRequestOperation = (object3 = new InternalRequestOperation((Context)object, (OSSCredentialProvider)object2, clientConfiguration));
        super((InternalRequestOperation)object2);
        this.extensionRequestOperation = object;
    }

    public OSSImpl(Context object, String object2, OSSCredentialProvider oSSCredentialProvider, ClientConfiguration object3) {
        block17: {
            boolean bl2;
            String string2;
            boolean bl3;
            Object object4;
            block16: {
                object4 = object.getApplicationContext();
                OSSLogToFileUtils.init((Context)object4, (ClientConfiguration)object3);
                try {
                    object2 = ((String)object2).trim();
                    object4 = "http";
                }
                catch (URISyntaxException uRISyntaxException) {
                    super("Endpoint must be a string like 'http://oss-cn-****.aliyuncs.com',or your cname like 'http://image.cnamedomain.com'!");
                    throw object;
                }
                bl3 = ((String)object2).startsWith((String)object4);
                if (bl3) break block16;
                super();
                string2 = "http://";
                ((StringBuilder)object4).append(string2);
                ((StringBuilder)object4).append((String)object2);
                object2 = ((StringBuilder)object4).toString();
            }
            super((String)object2);
            this.endpointURI = object4;
            if (oSSCredentialProvider == null) break block17;
            object2 = Boolean.FALSE;
            object4 = ((URI)object4).getHost();
            bl3 = OSSUtils.isValidateIP((String)object4);
            try {
                object2 = bl3;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            object4 = this.endpointURI.getScheme();
            string2 = "https";
            bl3 = ((String)object4).equals(string2);
            if (bl3 && (bl2 = ((Boolean)object2).booleanValue())) {
                super("endpoint should not be format with https://ip.");
                throw object;
            }
            this.credentialProvider = oSSCredentialProvider;
            if (object3 == null) {
                object3 = ClientConfiguration.getDefaultConf();
            }
            this.conf = object3;
            object = object.getApplicationContext();
            object3 = this.endpointURI;
            object4 = this.conf;
            object2 = this.internalRequestOperation = (object2 = new InternalRequestOperation((Context)object, (URI)object3, oSSCredentialProvider, (ClientConfiguration)object4));
            super((InternalRequestOperation)object2);
            this.extensionRequestOperation = object;
            return;
        }
        super("CredentialProvider can't be null.");
        throw object;
    }

    public AbortMultipartUploadResult abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest) {
        return (AbortMultipartUploadResult)this.internalRequestOperation.abortMultipartUpload(abortMultipartUploadRequest, null).getResult();
    }

    public void abortResumableUpload(ResumableUploadRequest resumableUploadRequest) {
        this.extensionRequestOperation.abortResumableUpload(resumableUploadRequest);
    }

    public AppendObjectResult appendObject(AppendObjectRequest appendObjectRequest) {
        return this.internalRequestOperation.syncAppendObject(appendObjectRequest);
    }

    public OSSAsyncTask asyncAbortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.abortMultipartUpload(abortMultipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncAppendObject(AppendObjectRequest appendObjectRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.appendObject(appendObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncCompleteMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.completeMultipartUpload(completeMultipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncCopyObject(CopyObjectRequest copyObjectRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.copyObject(copyObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncCreateBucket(CreateBucketRequest createBucketRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.createBucket(createBucketRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncDeleteBucket(DeleteBucketRequest deleteBucketRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.deleteBucket(deleteBucketRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncDeleteBucketLifecycle(DeleteBucketLifecycleRequest deleteBucketLifecycleRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.deleteBucketLifecycle(deleteBucketLifecycleRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncDeleteBucketLogging(DeleteBucketLoggingRequest deleteBucketLoggingRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.deleteBucketLogging(deleteBucketLoggingRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncDeleteMultipleObject(DeleteMultipleObjectRequest deleteMultipleObjectRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.deleteMultipleObject(deleteMultipleObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncDeleteObject(DeleteObjectRequest deleteObjectRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.deleteObject(deleteObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncGetBucketACL(GetBucketACLRequest getBucketACLRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.getBucketACL(getBucketACLRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncGetBucketInfo(GetBucketInfoRequest getBucketInfoRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.getBucketInfo(getBucketInfoRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncGetBucketLifecycle(GetBucketLifecycleRequest getBucketLifecycleRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.getBucketLifecycle(getBucketLifecycleRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncGetBucketLogging(GetBucketLoggingRequest getBucketLoggingRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.getBucketLogging(getBucketLoggingRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncGetBucketReferer(GetBucketRefererRequest getBucketRefererRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.getBucketReferer(getBucketRefererRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncGetObject(GetObjectRequest getObjectRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.getObject(getObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncGetObjectACL(GetObjectACLRequest getObjectACLRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.getObjectACL(getObjectACLRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncGetSymlink(GetSymlinkRequest getSymlinkRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.getSymlink(getSymlinkRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncHeadObject(HeadObjectRequest headObjectRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.headObject(headObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncImagePersist(ImagePersistRequest imagePersistRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.imageActionPersist(imagePersistRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncInitMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.initMultipartUpload(initiateMultipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncListBuckets(ListBucketsRequest listBucketsRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.listBuckets(listBucketsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncListMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.listMultipartUploads(listMultipartUploadsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncListObjects(ListObjectsRequest listObjectsRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.listObjects(listObjectsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncListParts(ListPartsRequest listPartsRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.listParts(listPartsRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncMultipartUpload(MultipartUploadRequest multipartUploadRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.extensionRequestOperation.multipartUpload(multipartUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncPutBucketLifecycle(PutBucketLifecycleRequest putBucketLifecycleRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.putBucketLifecycle(putBucketLifecycleRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncPutBucketLogging(PutBucketLoggingRequest putBucketLoggingRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.putBucketLogging(putBucketLoggingRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncPutBucketReferer(PutBucketRefererRequest putBucketRefererRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.putBucketReferer(putBucketRefererRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncPutObject(PutObjectRequest putObjectRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.putObject(putObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncPutSymlink(PutSymlinkRequest putSymlinkRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.putSymlink(putSymlinkRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncRestoreObject(RestoreObjectRequest restoreObjectRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.restoreObject(restoreObjectRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncResumableUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.extensionRequestOperation.resumableUpload(resumableUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncSequenceUpload(ResumableUploadRequest resumableUploadRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.extensionRequestOperation.sequenceUpload(resumableUploadRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncTriggerCallback(TriggerCallbackRequest triggerCallbackRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.triggerCallback(triggerCallbackRequest, oSSCompletedCallback);
    }

    public OSSAsyncTask asyncUploadPart(UploadPartRequest uploadPartRequest, OSSCompletedCallback oSSCompletedCallback) {
        return this.internalRequestOperation.uploadPart(uploadPartRequest, oSSCompletedCallback);
    }

    public CompleteMultipartUploadResult completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) {
        return this.internalRequestOperation.syncCompleteMultipartUpload(completeMultipartUploadRequest);
    }

    public CopyObjectResult copyObject(CopyObjectRequest copyObjectRequest) {
        return (CopyObjectResult)this.internalRequestOperation.copyObject(copyObjectRequest, null).getResult();
    }

    public CreateBucketResult createBucket(CreateBucketRequest createBucketRequest) {
        return (CreateBucketResult)this.internalRequestOperation.createBucket(createBucketRequest, null).getResult();
    }

    public DeleteBucketResult deleteBucket(DeleteBucketRequest deleteBucketRequest) {
        return (DeleteBucketResult)this.internalRequestOperation.deleteBucket(deleteBucketRequest, null).getResult();
    }

    public DeleteBucketLifecycleResult deleteBucketLifecycle(DeleteBucketLifecycleRequest deleteBucketLifecycleRequest) {
        return (DeleteBucketLifecycleResult)this.internalRequestOperation.deleteBucketLifecycle(deleteBucketLifecycleRequest, null).getResult();
    }

    public DeleteBucketLoggingResult deleteBucketLogging(DeleteBucketLoggingRequest deleteBucketLoggingRequest) {
        return (DeleteBucketLoggingResult)this.internalRequestOperation.deleteBucketLogging(deleteBucketLoggingRequest, null).getResult();
    }

    public DeleteMultipleObjectResult deleteMultipleObject(DeleteMultipleObjectRequest deleteMultipleObjectRequest) {
        return (DeleteMultipleObjectResult)this.internalRequestOperation.deleteMultipleObject(deleteMultipleObjectRequest, null).getResult();
    }

    public DeleteObjectResult deleteObject(DeleteObjectRequest deleteObjectRequest) {
        return (DeleteObjectResult)this.internalRequestOperation.deleteObject(deleteObjectRequest, null).getResult();
    }

    public boolean doesObjectExist(String string2, String string3) {
        return this.extensionRequestOperation.doesObjectExist(string2, string3);
    }

    public GetBucketACLResult getBucketACL(GetBucketACLRequest getBucketACLRequest) {
        return (GetBucketACLResult)this.internalRequestOperation.getBucketACL(getBucketACLRequest, null).getResult();
    }

    public GetBucketInfoResult getBucketInfo(GetBucketInfoRequest getBucketInfoRequest) {
        return (GetBucketInfoResult)this.internalRequestOperation.getBucketInfo(getBucketInfoRequest, null).getResult();
    }

    public GetBucketLifecycleResult getBucketLifecycle(GetBucketLifecycleRequest getBucketLifecycleRequest) {
        return (GetBucketLifecycleResult)this.internalRequestOperation.getBucketLifecycle(getBucketLifecycleRequest, null).getResult();
    }

    public GetBucketLoggingResult getBucketLogging(GetBucketLoggingRequest getBucketLoggingRequest) {
        return (GetBucketLoggingResult)this.internalRequestOperation.getBucketLogging(getBucketLoggingRequest, null).getResult();
    }

    public GetBucketRefererResult getBucketReferer(GetBucketRefererRequest getBucketRefererRequest) {
        return (GetBucketRefererResult)this.internalRequestOperation.getBucketReferer(getBucketRefererRequest, null).getResult();
    }

    public GetObjectResult getObject(GetObjectRequest getObjectRequest) {
        return (GetObjectResult)this.internalRequestOperation.getObject(getObjectRequest, null).getResult();
    }

    public GetObjectACLResult getObjectACL(GetObjectACLRequest getObjectACLRequest) {
        return (GetObjectACLResult)this.internalRequestOperation.getObjectACL(getObjectACLRequest, null).getResult();
    }

    public GetSymlinkResult getSymlink(GetSymlinkRequest getSymlinkRequest) {
        return this.internalRequestOperation.syncGetSymlink(getSymlinkRequest);
    }

    public HeadObjectResult headObject(HeadObjectRequest headObjectRequest) {
        return (HeadObjectResult)this.internalRequestOperation.headObject(headObjectRequest, null).getResult();
    }

    public ImagePersistResult imagePersist(ImagePersistRequest imagePersistRequest) {
        return (ImagePersistResult)this.internalRequestOperation.imageActionPersist(imagePersistRequest, null).getResult();
    }

    public InitiateMultipartUploadResult initMultipartUpload(InitiateMultipartUploadRequest initiateMultipartUploadRequest) {
        return (InitiateMultipartUploadResult)this.internalRequestOperation.initMultipartUpload(initiateMultipartUploadRequest, null).getResult();
    }

    public ListBucketsResult listBuckets(ListBucketsRequest listBucketsRequest) {
        return (ListBucketsResult)this.internalRequestOperation.listBuckets(listBucketsRequest, null).getResult();
    }

    public ListMultipartUploadsResult listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest) {
        return (ListMultipartUploadsResult)this.internalRequestOperation.listMultipartUploads(listMultipartUploadsRequest, null).getResult();
    }

    public ListObjectsResult listObjects(ListObjectsRequest listObjectsRequest) {
        return (ListObjectsResult)this.internalRequestOperation.listObjects(listObjectsRequest, null).getResult();
    }

    public ListPartsResult listParts(ListPartsRequest listPartsRequest) {
        return (ListPartsResult)this.internalRequestOperation.listParts(listPartsRequest, null).getResult();
    }

    public CompleteMultipartUploadResult multipartUpload(MultipartUploadRequest multipartUploadRequest) {
        return (CompleteMultipartUploadResult)this.extensionRequestOperation.multipartUpload(multipartUploadRequest, null).getResult();
    }

    public String presignConstrainedObjectURL(GeneratePresignedUrlRequest generatePresignedUrlRequest) {
        URI uRI = this.endpointURI;
        OSSCredentialProvider oSSCredentialProvider = this.credentialProvider;
        ClientConfiguration clientConfiguration = this.conf;
        ObjectURLPresigner objectURLPresigner = new ObjectURLPresigner(uRI, oSSCredentialProvider, clientConfiguration);
        return objectURLPresigner.presignConstrainedURL(generatePresignedUrlRequest);
    }

    public String presignConstrainedObjectURL(String string2, String string3, long l10) {
        URI uRI = this.endpointURI;
        OSSCredentialProvider oSSCredentialProvider = this.credentialProvider;
        ClientConfiguration clientConfiguration = this.conf;
        ObjectURLPresigner objectURLPresigner = new ObjectURLPresigner(uRI, oSSCredentialProvider, clientConfiguration);
        return objectURLPresigner.presignConstrainedURL(string2, string3, l10);
    }

    public String presignPublicObjectURL(String string2, String string3) {
        URI uRI = this.endpointURI;
        OSSCredentialProvider oSSCredentialProvider = this.credentialProvider;
        ClientConfiguration clientConfiguration = this.conf;
        ObjectURLPresigner objectURLPresigner = new ObjectURLPresigner(uRI, oSSCredentialProvider, clientConfiguration);
        return objectURLPresigner.presignPublicURL(string2, string3);
    }

    public PutBucketLifecycleResult putBucketLifecycle(PutBucketLifecycleRequest putBucketLifecycleRequest) {
        return (PutBucketLifecycleResult)this.internalRequestOperation.putBucketLifecycle(putBucketLifecycleRequest, null).getResult();
    }

    public PutBucketLoggingResult putBucketLogging(PutBucketLoggingRequest putBucketLoggingRequest) {
        return (PutBucketLoggingResult)this.internalRequestOperation.putBucketLogging(putBucketLoggingRequest, null).getResult();
    }

    public PutBucketRefererResult putBucketReferer(PutBucketRefererRequest putBucketRefererRequest) {
        return (PutBucketRefererResult)this.internalRequestOperation.putBucketReferer(putBucketRefererRequest, null).getResult();
    }

    public PutObjectResult putObject(PutObjectRequest putObjectRequest) {
        return this.internalRequestOperation.syncPutObject(putObjectRequest);
    }

    public PutSymlinkResult putSymlink(PutSymlinkRequest putSymlinkRequest) {
        return this.internalRequestOperation.syncPutSymlink(putSymlinkRequest);
    }

    public RestoreObjectResult restoreObject(RestoreObjectRequest restoreObjectRequest) {
        return this.internalRequestOperation.syncRestoreObject(restoreObjectRequest);
    }

    public ResumableUploadResult resumableUpload(ResumableUploadRequest resumableUploadRequest) {
        return (ResumableUploadResult)this.extensionRequestOperation.resumableUpload(resumableUploadRequest, null).getResult();
    }

    public ResumableUploadResult sequenceUpload(ResumableUploadRequest resumableUploadRequest) {
        return (ResumableUploadResult)this.extensionRequestOperation.sequenceUpload(resumableUploadRequest, null).getResult();
    }

    public TriggerCallbackResult triggerCallback(TriggerCallbackRequest triggerCallbackRequest) {
        return this.internalRequestOperation.asyncTriggerCallback(triggerCallbackRequest);
    }

    public void updateCredentialProvider(OSSCredentialProvider oSSCredentialProvider) {
        this.credentialProvider = oSSCredentialProvider;
        this.internalRequestOperation.setCredentialProvider(oSSCredentialProvider);
    }

    public UploadPartResult uploadPart(UploadPartRequest uploadPartRequest) {
        return this.internalRequestOperation.syncUploadPart(uploadPartRequest);
    }
}

