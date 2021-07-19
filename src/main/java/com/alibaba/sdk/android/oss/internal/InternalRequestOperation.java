/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Proxy
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  com.alibaba.sdk.android.oss.common.utils.CRC64
 */
package com.alibaba.sdk.android.oss.internal;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.callback.OSSRetryCallback;
import com.alibaba.sdk.android.oss.common.HttpMethod;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.common.utils.CRC64;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.alibaba.sdk.android.oss.common.utils.HttpUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.common.utils.VersionInfoUtils;
import com.alibaba.sdk.android.oss.exception.InconsistentException;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation$1;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation$2;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation$3;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation$4;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation$5;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation$6;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation$7;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.internal.RequestMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$AbortMultipartUploadResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$AppendObjectResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$CompleteMultipartUploadResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$CopyObjectResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$CreateBucketResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$DeleteBucketLifecycleResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$DeleteBucketLoggingResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$DeleteBucketResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$DeleteMultipleObjectResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$DeleteObjectResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$GetBucketACLResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$GetBucketInfoResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$GetBucketLifecycleResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$GetBucketLoggingResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$GetBucketRefererResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$GetObjectACLResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$GetObjectResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$GetSymlinkResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$HeadObjectResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$ImagePersistResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$InitMultipartResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$ListBucketResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$ListMultipartUploadsResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$ListObjectsResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$ListPartsResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$PutBucketLifecycleResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$PutBucketLoggingResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$PutBucketRefererResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$PutObjectResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$PutSymlinkResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$RestoreObjectResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$TriggerCallbackResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers$UploadPartResponseParser;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.AppendObjectRequest;
import com.alibaba.sdk.android.oss.model.AppendObjectResult;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.CopyObjectRequest;
import com.alibaba.sdk.android.oss.model.CreateBucketRequest;
import com.alibaba.sdk.android.oss.model.DeleteBucketLifecycleRequest;
import com.alibaba.sdk.android.oss.model.DeleteBucketLoggingRequest;
import com.alibaba.sdk.android.oss.model.DeleteBucketRequest;
import com.alibaba.sdk.android.oss.model.DeleteMultipleObjectRequest;
import com.alibaba.sdk.android.oss.model.DeleteObjectRequest;
import com.alibaba.sdk.android.oss.model.GetBucketACLRequest;
import com.alibaba.sdk.android.oss.model.GetBucketInfoRequest;
import com.alibaba.sdk.android.oss.model.GetBucketLifecycleRequest;
import com.alibaba.sdk.android.oss.model.GetBucketLoggingRequest;
import com.alibaba.sdk.android.oss.model.GetBucketRefererRequest;
import com.alibaba.sdk.android.oss.model.GetObjectACLRequest;
import com.alibaba.sdk.android.oss.model.GetObjectRequest;
import com.alibaba.sdk.android.oss.model.GetSymlinkRequest;
import com.alibaba.sdk.android.oss.model.GetSymlinkResult;
import com.alibaba.sdk.android.oss.model.HeadObjectRequest;
import com.alibaba.sdk.android.oss.model.ImagePersistRequest;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.ListBucketsRequest;
import com.alibaba.sdk.android.oss.model.ListMultipartUploadsRequest;
import com.alibaba.sdk.android.oss.model.ListObjectsRequest;
import com.alibaba.sdk.android.oss.model.ListPartsRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest$CRC64Config;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.PutBucketLifecycleRequest;
import com.alibaba.sdk.android.oss.model.PutBucketLoggingRequest;
import com.alibaba.sdk.android.oss.model.PutBucketRefererRequest;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.alibaba.sdk.android.oss.model.PutSymlinkRequest;
import com.alibaba.sdk.android.oss.model.PutSymlinkResult;
import com.alibaba.sdk.android.oss.model.RestoreObjectRequest;
import com.alibaba.sdk.android.oss.model.RestoreObjectResult;
import com.alibaba.sdk.android.oss.model.StorageClass;
import com.alibaba.sdk.android.oss.model.TriggerCallbackRequest;
import com.alibaba.sdk.android.oss.model.TriggerCallbackResult;
import com.alibaba.sdk.android.oss.model.UploadPartRequest;
import com.alibaba.sdk.android.oss.model.UploadPartResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import com.alibaba.sdk.android.oss.network.OSSRequestTask;
import g.o;
import g.z;
import g.z$a;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;

public class InternalRequestOperation {
    private static final int LIST_PART_MAX_RETURNS = 1000;
    private static final int MAX_PART_NUMBER = 10000;
    private static ExecutorService executorService;
    private Context applicationContext;
    private ClientConfiguration conf;
    private OSSCredentialProvider credentialProvider;
    private volatile URI endpoint;
    private z innerClient;
    private int maxRetryCount;
    private URI service;

    static {
        InternalRequestOperation$1 internalRequestOperation$1 = new InternalRequestOperation$1();
        executorService = Executors.newFixedThreadPool(5, internalRequestOperation$1);
    }

    public InternalRequestOperation(Context object, OSSCredentialProvider object2, ClientConfiguration clientConfiguration) {
        block7: {
            Object object3;
            int n10;
            this.maxRetryCount = n10 = 2;
            Object object4 = "http://oss.aliyuncs.com";
            try {
                object3 = new URI((String)object4);
            }
            catch (Exception exception) {
                super("Endpoint must be a string like 'http://oss-cn-****.aliyuncs.com',or your cname like 'http://image.cnamedomain.com'!");
                throw object;
            }
            this.service = object3;
            object4 = "http://127.0.0.1";
            object3 = new URI((String)object4);
            this.endpoint = object3;
            this.applicationContext = object;
            this.credentialProvider = object2;
            this.conf = clientConfiguration;
            super();
            object = ((z$a)object).t(false).u(false).l0(false);
            int n11 = 0;
            object = ((z$a)object).g(null);
            object2 = new InternalRequestOperation$3(this);
            object = ((z$a)object).Z((HostnameVerifier)object2);
            if (clientConfiguration == null) break block7;
            object2 = new o();
            n10 = clientConfiguration.getMaxConcurrentRequest();
            ((o)object2).s(n10);
            n10 = clientConfiguration.getConnectionTimeout();
            long l10 = n10;
            Object object5 = TimeUnit.MILLISECONDS;
            object3 = ((z$a)object).k(l10, (TimeUnit)((Object)object5));
            long l11 = clientConfiguration.getSocketTimeout();
            object3 = ((z$a)object3).j0(l11, (TimeUnit)((Object)object5));
            int n12 = clientConfiguration.getSocketTimeout();
            l11 = n12;
            object3 = ((z$a)object3).R0(l11, (TimeUnit)((Object)object5));
            ((z$a)object3).p((o)object2);
            object2 = clientConfiguration.getProxyHost();
            if (object2 != null && (n11 = clientConfiguration.getProxyPort()) != 0) {
                object3 = Proxy.Type.HTTP;
                object5 = clientConfiguration.getProxyHost();
                int n13 = clientConfiguration.getProxyPort();
                object4 = new InetSocketAddress((String)object5, n13);
                object2 = new java.net.Proxy((Proxy.Type)((Object)object3), (SocketAddress)object4);
                ((z$a)object).g0((java.net.Proxy)object2);
            }
            this.maxRetryCount = n11 = clientConfiguration.getMaxErrorRetry();
        }
        this.innerClient = object = ((z$a)object).f();
    }

    public InternalRequestOperation(Context object, URI object2, OSSCredentialProvider object3, ClientConfiguration clientConfiguration) {
        int n10;
        this.maxRetryCount = n10 = 2;
        this.applicationContext = object;
        this.endpoint = object2;
        this.credentialProvider = object3;
        this.conf = clientConfiguration;
        object = ((z$a)object).t(false).u(false).l0(false);
        int n11 = 0;
        object = ((z$a)object).g(null);
        object3 = new InternalRequestOperation$2(this, (URI)object2);
        object = ((z$a)object).Z((HostnameVerifier)object3);
        if (clientConfiguration != null) {
            int n12;
            object2 = new o();
            n11 = clientConfiguration.getMaxConcurrentRequest();
            ((o)object2).s(n11);
            n11 = clientConfiguration.getConnectionTimeout();
            long l10 = n11;
            object3 = TimeUnit.MILLISECONDS;
            Object object4 = ((z$a)object).k(l10, (TimeUnit)((Object)object3));
            long l11 = clientConfiguration.getSocketTimeout();
            object4 = ((z$a)object4).j0(l11, (TimeUnit)((Object)object3));
            int n13 = clientConfiguration.getSocketTimeout();
            l11 = n13;
            object3 = ((z$a)object4).R0(l11, (TimeUnit)((Object)object3));
            ((z$a)object3).p((o)object2);
            object2 = clientConfiguration.getProxyHost();
            if (object2 != null && (n12 = clientConfiguration.getProxyPort()) != 0) {
                object3 = Proxy.Type.HTTP;
                String string2 = clientConfiguration.getProxyHost();
                int n14 = clientConfiguration.getProxyPort();
                object4 = new InetSocketAddress(string2, n14);
                object2 = new java.net.Proxy((Proxy.Type)((Object)object3), (SocketAddress)object4);
                ((z$a)object).g0((java.net.Proxy)object2);
            }
            this.maxRetryCount = n12 = clientConfiguration.getMaxErrorRetry();
        }
        this.innerClient = object = ((z$a)object).f();
    }

    public static /* synthetic */ URI access$000(InternalRequestOperation internalRequestOperation) {
        return internalRequestOperation.service;
    }

    public static /* synthetic */ void access$100(InternalRequestOperation internalRequestOperation, OSSRequest oSSRequest, OSSResult oSSResult, OSSCompletedCallback oSSCompletedCallback) {
        internalRequestOperation.checkCRC64(oSSRequest, oSSResult, oSSCompletedCallback);
    }

    public static /* synthetic */ long access$200(InternalRequestOperation internalRequestOperation, List list) {
        return internalRequestOperation.calcObjectCRCFromParts(list);
    }

    private long calcObjectCRCFromParts(List object) {
        boolean bl2;
        long l10;
        object = object.iterator();
        long l11 = l10 = 0L;
        while (bl2 = object.hasNext()) {
            long l12;
            PartETag partETag = (PartETag)object.next();
            long l13 = partETag.getCRC64();
            long l14 = l13 - l10;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 != false && (object2 = (l12 = (l13 = partETag.getPartSize()) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                l13 = partETag.getCRC64();
                long l15 = partETag.getPartSize();
                l11 = CRC64.combine((long)l11, (long)l13, (long)l15);
                continue;
            }
            return l10;
        }
        return l11;
    }

    private void canonicalizeRequestMessage(RequestMessage object, OSSRequest oSSRequest) {
        boolean bl2;
        Object object2;
        Object object3 = object.getHeaders();
        Object object4 = object3.get(object2 = "Date");
        if (object4 == null) {
            object4 = DateUtil.currentFixedSkewedTimeInRFC822Format();
            object3.put(object2, object4);
        }
        if (((object2 = object.getMethod()) == (object4 = HttpMethod.POST) || (object2 = object.getMethod()) == (object4 = HttpMethod.PUT)) && (bl2 = OSSUtils.isEmptyString(object4 = (String)object3.get(object2 = "Content-Type")))) {
            bl2 = false;
            String string2 = object.getUploadFilePath();
            String string3 = object.getObjectKey();
            object4 = OSSUtils.determineContentType(null, string2, string3);
            object3.put(object2, object4);
        }
        boolean bl3 = this.conf.isHttpDnsEnable();
        bl3 = this.checkIfHttpDnsAvailable(bl3);
        object.setHttpDnsEnable(bl3);
        object3 = this.credentialProvider;
        object.setCredentialProvider((OSSCredentialProvider)object3);
        object3 = this.conf.getIpWithHeader();
        object.setIpWithHeader((String)object3);
        object3 = object.getHeaders();
        object2 = VersionInfoUtils.getUserAgent(this.conf.getCustomUserMark());
        object4 = "User-Agent";
        object3.put(object4, object2);
        object3 = object.getHeaders();
        bl3 = object3.containsKey("Range");
        boolean bl4 = false;
        object2 = null;
        if (bl3 || (bl3 = (object3 = object.getParameters()).containsKey(object4 = "x-oss-process"))) {
            object.setCheckCRC64(false);
        }
        object3 = this.endpoint.getHost();
        object4 = this.conf.getCustomCnameExcludeList();
        bl3 = OSSUtils.isInCustomCnameExcludeList((String)object3, object4);
        object.setIsInCustomCnameExcludeList(bl3);
        object3 = oSSRequest.getCRC64();
        object4 = OSSRequest$CRC64Config.NULL;
        if (object3 != object4) {
            object3 = oSSRequest.getCRC64();
            if (object3 == (object4 = OSSRequest$CRC64Config.YES)) {
                bl4 = true;
            }
        } else {
            object3 = this.conf;
            bl4 = ((ClientConfiguration)object3).isCheckCRC64();
        }
        object.setCheckCRC64(bl4);
        object = bl4 ? OSSRequest$CRC64Config.YES : OSSRequest$CRC64Config.NO;
        oSSRequest.setCRC64((Enum)object);
    }

    private void checkCRC64(OSSRequest object, OSSResult object2) {
        Object object3;
        if ((object = ((OSSRequest)object).getCRC64()) == (object3 = OSSRequest$CRC64Config.YES)) {
            try {
                object = ((OSSResult)object2).getClientCRC();
            }
            catch (InconsistentException inconsistentException) {
                object3 = inconsistentException.getMessage();
                object2 = new ClientException((String)object3, inconsistentException);
                throw object2;
            }
            object3 = ((OSSResult)object2).getServerCRC();
            object2 = ((OSSResult)object2).getRequestId();
            OSSUtils.checkChecksum((Long)object, (Long)object3, (String)object2);
        }
    }

    private void checkCRC64(OSSRequest oSSRequest, OSSResult oSSResult, OSSCompletedCallback oSSCompletedCallback) {
        block3: {
            this.checkCRC64(oSSRequest, oSSResult);
            if (oSSCompletedCallback == null) break block3;
            try {
                oSSCompletedCallback.onSuccess(oSSRequest, oSSResult);
            }
            catch (ClientException clientException) {
                if (oSSCompletedCallback == null) break block3;
                oSSCompletedCallback.onFailure(oSSRequest, clientException, null);
            }
        }
    }

    private boolean checkIfHttpDnsAvailable(boolean bl2) {
        boolean bl3 = false;
        String string2 = null;
        if (bl2) {
            Object object = this.applicationContext;
            if (object == null) {
                return false;
            }
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 14;
            if (n10 >= n11) {
                bl3 = true;
            }
            object = bl3 ? System.getProperty("http.proxyHost") : Proxy.getHost((Context)object);
            string2 = this.conf.getProxyHost();
            n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
            if (n10 == 0) {
                object = string2;
            }
            return TextUtils.isEmpty((CharSequence)object);
        }
        return false;
    }

    public OSSAsyncTask abortMultipartUpload(AbortMultipartUploadRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        boolean bl2 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(bl2);
        Object object3 = this.endpoint;
        requestMessage.setEndpoint((URI)object3);
        object3 = HttpMethod.DELETE;
        requestMessage.setMethod((HttpMethod)((Object)object3));
        object3 = ((AbortMultipartUploadRequest)object).getBucketName();
        requestMessage.setBucketName((String)object3);
        object3 = ((AbortMultipartUploadRequest)object).getObjectKey();
        requestMessage.setObjectKey((String)object3);
        object3 = requestMessage.getParameters();
        Object object4 = ((AbortMultipartUploadRequest)object).getUploadId();
        object3.put("uploadId", object4);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$AbortMultipartUploadResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask appendObject(AppendObjectRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        boolean bl2 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(bl2);
        Object object3 = this.endpoint;
        requestMessage.setEndpoint((URI)object3);
        object3 = HttpMethod.POST;
        requestMessage.setMethod((HttpMethod)((Object)object3));
        object3 = ((AppendObjectRequest)object).getBucketName();
        requestMessage.setBucketName((String)object3);
        object3 = ((AppendObjectRequest)object).getObjectKey();
        requestMessage.setObjectKey((String)object3);
        object3 = ((AppendObjectRequest)object).getUploadData();
        if (object3 != null) {
            object3 = ((AppendObjectRequest)object).getUploadData();
            requestMessage.setUploadData((byte[])object3);
        }
        if ((object3 = ((AppendObjectRequest)object).getUploadFilePath()) != null) {
            object3 = ((AppendObjectRequest)object).getUploadFilePath();
            requestMessage.setUploadFilePath((String)object3);
        }
        requestMessage.getParameters().put("append", "");
        object3 = requestMessage.getParameters();
        long l10 = ((AppendObjectRequest)object).getPosition();
        Object object4 = String.valueOf(l10);
        object3.put("position", object4);
        object3 = requestMessage.getHeaders();
        object4 = ((AppendObjectRequest)object).getMetadata();
        OSSUtils.populateRequestMetadata((Map)object3, (ObjectMetadata)object4);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, context);
        if (object2 != null) {
            object4 = new InternalRequestOperation$5(this, (OSSCompletedCallback)object2);
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object4);
        }
        object = ((AppendObjectRequest)object).getProgressCallback();
        ((ExecutionContext)object3).setProgressCallback((OSSProgressCallback)object);
        object = new ResponseParsers$AppendObjectResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public TriggerCallbackResult asyncTriggerCallback(TriggerCallbackRequest triggerCallbackRequest) {
        return (TriggerCallbackResult)this.triggerCallback(triggerCallbackRequest, null).getResult();
    }

    public OSSAsyncTask completeMultipartUpload(CompleteMultipartUploadRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        boolean bl2 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(bl2);
        Object object3 = this.endpoint;
        requestMessage.setEndpoint((URI)object3);
        object3 = HttpMethod.POST;
        requestMessage.setMethod((HttpMethod)((Object)object3));
        object3 = ((CompleteMultipartUploadRequest)object).getBucketName();
        requestMessage.setBucketName((String)object3);
        object3 = ((CompleteMultipartUploadRequest)object).getObjectKey();
        requestMessage.setObjectKey((String)object3);
        object3 = OSSUtils.buildXMLFromPartEtagList(((CompleteMultipartUploadRequest)object).getPartETags());
        requestMessage.setStringBody((String)object3);
        object3 = requestMessage.getParameters();
        Object object4 = ((CompleteMultipartUploadRequest)object).getUploadId();
        String string2 = "uploadId";
        object3.put(string2, object4);
        object3 = ((CompleteMultipartUploadRequest)object).getCallbackParam();
        if (object3 != null) {
            object3 = requestMessage.getHeaders();
            object4 = OSSUtils.populateMapToBase64JsonString(((CompleteMultipartUploadRequest)object).getCallbackParam());
            string2 = "x-oss-callback";
            object3.put(string2, object4);
        }
        if ((object3 = ((CompleteMultipartUploadRequest)object).getCallbackVars()) != null) {
            object3 = requestMessage.getHeaders();
            object4 = OSSUtils.populateMapToBase64JsonString(((CompleteMultipartUploadRequest)object).getCallbackVars());
            string2 = "x-oss-callback-var";
            object3.put(string2, object4);
        }
        object3 = requestMessage.getHeaders();
        object4 = ((CompleteMultipartUploadRequest)object).getMetadata();
        OSSUtils.populateRequestMetadata((Map)object3, (ObjectMetadata)object4);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        string2 = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, (Context)string2);
        if (object2 != null) {
            object = new InternalRequestOperation$7(this, (OSSCompletedCallback)object2);
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object);
        }
        object = new ResponseParsers$CompleteMultipartUploadResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask copyObject(CopyObjectRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        boolean bl2 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(bl2);
        Object object3 = this.endpoint;
        requestMessage.setEndpoint((URI)object3);
        object3 = HttpMethod.PUT;
        requestMessage.setMethod((HttpMethod)((Object)object3));
        object3 = ((CopyObjectRequest)object).getDestinationBucketName();
        requestMessage.setBucketName((String)object3);
        object3 = ((CopyObjectRequest)object).getDestinationKey();
        requestMessage.setObjectKey((String)object3);
        object3 = requestMessage.getHeaders();
        OSSUtils.populateCopyObjectHeaders((CopyObjectRequest)object, (Map)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        z z10 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext(z10, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$CopyObjectResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask createBucket(CreateBucketRequest object, OSSCompletedCallback object2) {
        Object object3;
        Object object4;
        Object object5;
        RequestMessage requestMessage;
        block11: {
            requestMessage = new RequestMessage();
            boolean bl2 = ((OSSRequest)object).isAuthorizationRequired();
            requestMessage.setIsAuthorizationRequired(bl2);
            object5 = this.endpoint;
            requestMessage.setEndpoint((URI)object5);
            object5 = HttpMethod.PUT;
            requestMessage.setMethod((HttpMethod)((Object)object5));
            object5 = ((CreateBucketRequest)object).getBucketName();
            requestMessage.setBucketName((String)object5);
            object5 = ((CreateBucketRequest)object).getBucketACL();
            if (object5 != null) {
                object5 = requestMessage.getHeaders();
                object4 = ((CreateBucketRequest)object).getBucketACL().toString();
                object3 = "x-oss-acl";
                object5.put(object3, object4);
            }
            try {
                object5 = new HashMap();
                object4 = ((CreateBucketRequest)object).getLocationConstraint();
                if (object4 == null) break block11;
                object4 = "LocationConstraint";
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
                return null;
            }
            object3 = ((CreateBucketRequest)object).getLocationConstraint();
            object5.put(object4, object3);
        }
        object4 = "StorageClass";
        object3 = ((CreateBucketRequest)object).getBucketStorageClass();
        object3 = ((StorageClass)((Object)object3)).toString();
        object5.put(object4, object3);
        requestMessage.createBucketRequestBodyMarshall((Map)object5);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        object3 = this.applicationContext;
        object5 = new ExecutionContext((z)object4, (OSSRequest)object, (Context)object3);
        if (object2 != null) {
            ((ExecutionContext)object5).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$CreateBucketResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object5, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object5);
    }

    public OSSAsyncTask deleteBucket(DeleteBucketRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        boolean bl2 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(bl2);
        Object object3 = this.endpoint;
        requestMessage.setEndpoint((URI)object3);
        object3 = HttpMethod.DELETE;
        requestMessage.setMethod((HttpMethod)((Object)object3));
        object3 = ((DeleteBucketRequest)object).getBucketName();
        requestMessage.setBucketName((String)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        z z10 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext(z10, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$DeleteBucketResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask deleteBucketLifecycle(DeleteBucketLifecycleRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        Object object3 = new LinkedHashMap();
        object3.put("lifecycle", "");
        boolean n10 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(n10);
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.DELETE;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        object4 = ((DeleteBucketLifecycleRequest)object).getBucketName();
        requestMessage.setBucketName((String)object4);
        requestMessage.setParameters((Map)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$DeleteBucketLifecycleResponseParser();
        int n11 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n11);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask deleteBucketLogging(DeleteBucketLoggingRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        Object object3 = new LinkedHashMap();
        object3.put("logging", "");
        boolean n10 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(n10);
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.DELETE;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        object4 = ((DeleteBucketLoggingRequest)object).getBucketName();
        requestMessage.setBucketName((String)object4);
        requestMessage.setParameters((Map)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$DeleteBucketLoggingResponseParser();
        int n11 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n11);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask deleteMultipleObject(DeleteMultipleObjectRequest object, OSSCompletedCallback object2) {
        Object object3;
        String string2;
        Object object4;
        RequestMessage requestMessage;
        block13: {
            requestMessage = new RequestMessage();
            object4 = new LinkedHashMap();
            string2 = "";
            object4.put("delete", string2);
            boolean n10 = ((OSSRequest)object).isAuthorizationRequired();
            requestMessage.setIsAuthorizationRequired(n10);
            object3 = this.endpoint;
            requestMessage.setEndpoint((URI)object3);
            object3 = HttpMethod.POST;
            requestMessage.setMethod((HttpMethod)((Object)object3));
            object3 = ((DeleteMultipleObjectRequest)object).getBucketName();
            requestMessage.setBucketName((String)object3);
            requestMessage.setParameters((Map)object4);
            try {
                object4 = ((DeleteMultipleObjectRequest)object).getObjectKeys();
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
                return null;
            }
            object3 = ((DeleteMultipleObjectRequest)object).getQuiet();
            boolean bl2 = (Boolean)object3;
            object4 = requestMessage.deleteMultipleObjectRequestBodyMarshall((List)object4, bl2);
            if (object4 == null) break block13;
            int n11 = ((Object)object4).length;
            if (n11 <= 0) break block13;
            object3 = requestMessage.getHeaders();
            string2 = "Content-MD5";
            String string3 = BinaryUtil.calculateBase64Md5((byte[])object4);
            object3.put(string2, string3);
            object3 = requestMessage.getHeaders();
            string2 = "Content-Length";
            int n12 = ((Object)object4).length;
            object4 = String.valueOf(n12);
            object3.put(string2, object4);
        }
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object3 = this.getInnerClient();
        string2 = this.applicationContext;
        object4 = new ExecutionContext((z)object3, (OSSRequest)object, (Context)string2);
        if (object2 != null) {
            ((ExecutionContext)object4).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$DeleteMultipleObjectResponseParser();
        int n13 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object4, n13);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object4);
    }

    public OSSAsyncTask deleteObject(DeleteObjectRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        boolean bl2 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(bl2);
        Object object3 = this.endpoint;
        requestMessage.setEndpoint((URI)object3);
        object3 = HttpMethod.DELETE;
        requestMessage.setMethod((HttpMethod)((Object)object3));
        object3 = ((DeleteObjectRequest)object).getBucketName();
        requestMessage.setBucketName((String)object3);
        object3 = ((DeleteObjectRequest)object).getObjectKey();
        requestMessage.setObjectKey((String)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        z z10 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext(z10, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$DeleteObjectResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public OSSAsyncTask getBucketACL(GetBucketACLRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        Object object3 = new LinkedHashMap();
        object3.put("acl", "");
        boolean n10 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(n10);
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.GET;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        object4 = ((GetBucketACLRequest)object).getBucketName();
        requestMessage.setBucketName((String)object4);
        requestMessage.setParameters((Map)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$GetBucketACLResponseParser();
        int n11 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n11);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask getBucketInfo(GetBucketInfoRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        Object object3 = new LinkedHashMap();
        object3.put("bucketInfo", "");
        boolean n10 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(n10);
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.GET;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        object4 = ((GetBucketInfoRequest)object).getBucketName();
        requestMessage.setBucketName((String)object4);
        requestMessage.setParameters((Map)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$GetBucketInfoResponseParser();
        int n11 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n11);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask getBucketLifecycle(GetBucketLifecycleRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        Object object3 = new LinkedHashMap();
        object3.put("lifecycle", "");
        boolean n10 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(n10);
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.GET;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        object4 = ((GetBucketLifecycleRequest)object).getBucketName();
        requestMessage.setBucketName((String)object4);
        requestMessage.setParameters((Map)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$GetBucketLifecycleResponseParser();
        int n11 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n11);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask getBucketLogging(GetBucketLoggingRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        Object object3 = new LinkedHashMap();
        object3.put("logging", "");
        boolean n10 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(n10);
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.GET;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        object4 = ((GetBucketLoggingRequest)object).getBucketName();
        requestMessage.setBucketName((String)object4);
        requestMessage.setParameters((Map)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$GetBucketLoggingResponseParser();
        int n11 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n11);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask getBucketReferer(GetBucketRefererRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        Object object3 = new LinkedHashMap();
        object3.put("referer", "");
        boolean n10 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(n10);
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.GET;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        object4 = ((GetBucketRefererRequest)object).getBucketName();
        requestMessage.setBucketName((String)object4);
        requestMessage.setParameters((Map)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$GetBucketRefererResponseParser();
        int n11 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n11);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public ClientConfiguration getConf() {
        return this.conf;
    }

    public z getInnerClient() {
        return this.innerClient;
    }

    public OSSAsyncTask getObject(GetObjectRequest object, OSSCompletedCallback object2) {
        int n10;
        Object object3;
        Object object4;
        RequestMessage requestMessage = new RequestMessage();
        boolean bl2 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(bl2);
        Object object5 = this.endpoint;
        requestMessage.setEndpoint((URI)object5);
        object5 = HttpMethod.GET;
        requestMessage.setMethod((HttpMethod)((Object)object5));
        object5 = ((GetObjectRequest)object).getBucketName();
        requestMessage.setBucketName((String)object5);
        object5 = ((GetObjectRequest)object).getObjectKey();
        requestMessage.setObjectKey((String)object5);
        object5 = ((GetObjectRequest)object).getRange();
        if (object5 != null) {
            object5 = requestMessage.getHeaders();
            object4 = ((GetObjectRequest)object).getRange().toString();
            object3 = "Range";
            object5.put(object3, object4);
        }
        if ((object5 = ((GetObjectRequest)object).getxOssProcess()) != null) {
            object5 = requestMessage.getParameters();
            object4 = ((GetObjectRequest)object).getxOssProcess();
            object3 = "x-oss-process";
            object5.put(object3, object4);
        }
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object5 = ((GetObjectRequest)object).getRequestHeaders();
        if (object5 != null) {
            object5 = ((GetObjectRequest)object).getRequestHeaders().entrySet().iterator();
            while ((n10 = object5.hasNext()) != 0) {
                object4 = (Map.Entry)object5.next();
                object3 = requestMessage.getHeaders();
                Object k10 = object4.getKey();
                object4 = object4.getValue();
                object3.put(k10, object4);
            }
        }
        object4 = this.getInnerClient();
        object3 = this.applicationContext;
        object5 = new ExecutionContext((z)object4, (OSSRequest)object, (Context)object3);
        if (object2 != null) {
            ((ExecutionContext)object5).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = ((GetObjectRequest)object).getProgressListener();
        ((ExecutionContext)object5).setProgressCallback((OSSProgressCallback)object);
        object = new ResponseParsers$GetObjectResponseParser();
        n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object5, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object5);
    }

    public OSSAsyncTask getObjectACL(GetObjectACLRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        Object object3 = new LinkedHashMap();
        object3.put("acl", "");
        boolean n10 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(n10);
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.GET;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        requestMessage.setParameters((Map)object3);
        object3 = ((GetObjectACLRequest)object).getBucketName();
        requestMessage.setBucketName((String)object3);
        object3 = ((GetObjectACLRequest)object).getObjectKey();
        requestMessage.setObjectKey((String)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$GetObjectACLResponseParser();
        int n11 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n11);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask getSymlink(GetSymlinkRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        Object object3 = new LinkedHashMap();
        object3.put("symlink", "");
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.GET;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        object4 = ((GetSymlinkRequest)object).getBucketName();
        requestMessage.setBucketName((String)object4);
        object4 = ((GetSymlinkRequest)object).getObjectKey();
        requestMessage.setObjectKey((String)object4);
        requestMessage.setParameters((Map)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$GetSymlinkResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask headObject(HeadObjectRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        boolean bl2 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(bl2);
        Object object3 = this.endpoint;
        requestMessage.setEndpoint((URI)object3);
        object3 = HttpMethod.HEAD;
        requestMessage.setMethod((HttpMethod)((Object)object3));
        object3 = ((HeadObjectRequest)object).getBucketName();
        requestMessage.setBucketName((String)object3);
        object3 = ((HeadObjectRequest)object).getObjectKey();
        requestMessage.setObjectKey((String)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        z z10 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext(z10, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$HeadObjectResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask imageActionPersist(ImagePersistRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        Object object3 = new LinkedHashMap();
        object3.put("x-oss-process", "");
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.POST;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        object4 = ((ImagePersistRequest)object).mFromBucket;
        requestMessage.setBucketName((String)object4);
        object4 = ((ImagePersistRequest)object).mFromObjectkey;
        requestMessage.setObjectKey((String)object4);
        requestMessage.setParameters((Map)object3);
        object3 = ((ImagePersistRequest)object).mToBucketName;
        object4 = ((ImagePersistRequest)object).mToObjectKey;
        String string2 = ((ImagePersistRequest)object).mAction;
        object3 = OSSUtils.buildImagePersistentBody((String)object3, (String)object4, string2);
        requestMessage.setStringBody((String)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        string2 = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, (Context)string2);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$ImagePersistResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask initMultipartUpload(InitiateMultipartUploadRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        boolean bl2 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(bl2);
        Object object3 = this.endpoint;
        requestMessage.setEndpoint((URI)object3);
        object3 = HttpMethod.POST;
        requestMessage.setMethod((HttpMethod)((Object)object3));
        object3 = ((InitiateMultipartUploadRequest)object).getBucketName();
        requestMessage.setBucketName((String)object3);
        object3 = ((InitiateMultipartUploadRequest)object).getObjectKey();
        requestMessage.setObjectKey((String)object3);
        object3 = requestMessage.getParameters();
        Object object4 = "uploads";
        String string2 = "";
        object3.put(object4, string2);
        bl2 = ((InitiateMultipartUploadRequest)object).isSequential;
        if (bl2) {
            object3 = requestMessage.getParameters();
            object4 = "sequential";
            object3.put(object4, string2);
        }
        object3 = requestMessage.getHeaders();
        object4 = ((InitiateMultipartUploadRequest)object).getMetadata();
        OSSUtils.populateRequestMetadata((Map)object3, (ObjectMetadata)object4);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        string2 = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, (Context)string2);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$InitMultipartResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask listBuckets(ListBucketsRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        boolean bl2 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(bl2);
        Object object3 = HttpMethod.GET;
        requestMessage.setMethod((HttpMethod)((Object)object3));
        object3 = this.service;
        requestMessage.setService((URI)object3);
        object3 = this.endpoint;
        requestMessage.setEndpoint((URI)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object3 = requestMessage.getParameters();
        OSSUtils.populateListBucketRequestParameters((ListBucketsRequest)object, (Map)object3);
        z z10 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext(z10, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$ListBucketResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask listMultipartUploads(ListMultipartUploadsRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        boolean bl2 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(bl2);
        Object object3 = this.endpoint;
        requestMessage.setEndpoint((URI)object3);
        object3 = HttpMethod.GET;
        requestMessage.setMethod((HttpMethod)((Object)object3));
        object3 = ((ListMultipartUploadsRequest)object).getBucketName();
        requestMessage.setBucketName((String)object3);
        requestMessage.getParameters().put("uploads", "");
        object3 = requestMessage.getParameters();
        OSSUtils.populateListMultipartUploadsRequestParameters((ListMultipartUploadsRequest)object, (Map)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        z z10 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext(z10, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$ListMultipartUploadsResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask listObjects(ListObjectsRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        boolean bl2 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(bl2);
        Object object3 = this.endpoint;
        requestMessage.setEndpoint((URI)object3);
        object3 = HttpMethod.GET;
        requestMessage.setMethod((HttpMethod)((Object)object3));
        object3 = ((ListObjectsRequest)object).getBucketName();
        requestMessage.setBucketName((String)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object3 = requestMessage.getParameters();
        OSSUtils.populateListObjectsRequestParameters((ListObjectsRequest)object, (Map)object3);
        z z10 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext(z10, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$ListObjectsResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask listParts(ListPartsRequest object, OSSCompletedCallback object2) {
        int n10;
        boolean bl2;
        long l10;
        boolean bl3;
        long l11;
        long l12;
        RequestMessage requestMessage = new RequestMessage();
        boolean bl4 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(bl4);
        Object object3 = this.endpoint;
        requestMessage.setEndpoint((URI)object3);
        object3 = HttpMethod.GET;
        requestMessage.setMethod((HttpMethod)((Object)object3));
        object3 = ((ListPartsRequest)object).getBucketName();
        requestMessage.setBucketName((String)object3);
        object3 = ((ListPartsRequest)object).getObjectKey();
        requestMessage.setObjectKey((String)object3);
        object3 = requestMessage.getParameters();
        Object object4 = ((ListPartsRequest)object).getUploadId();
        String string2 = "uploadId";
        object3.put(string2, object4);
        object3 = ((ListPartsRequest)object).getMaxParts();
        if (object3 != null) {
            l12 = ((Integer)object3).intValue();
            n10 = OSSUtils.checkParamRange(l12, l11 = 0L, bl3 = true, l10 = 1000L, bl2 = true);
            if (n10 != 0) {
                object4 = requestMessage.getParameters();
                object3 = ((Integer)object3).toString();
                string2 = "max-parts";
                object4.put(string2, object3);
            } else {
                object = new IllegalArgumentException("MaxPartsOutOfRange: 1000");
                throw object;
            }
        }
        if ((object3 = ((ListPartsRequest)object).getPartNumberMarker()) != null) {
            l12 = ((Integer)object3).intValue();
            l11 = 0L;
            bl3 = false;
            l10 = 10000L;
            bl2 = true;
            n10 = OSSUtils.checkParamRange(l12, l11, false, l10, bl2);
            if (n10 != 0) {
                object4 = requestMessage.getParameters();
                object3 = ((Integer)object3).toString();
                string2 = "part-number-marker";
                object4.put(string2, object3);
            } else {
                object = new IllegalArgumentException("PartNumberMarkerOutOfRange: 10000");
                throw object;
            }
        }
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        string2 = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, (Context)string2);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$ListPartsResponseParser();
        n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask putBucketLifecycle(PutBucketLifecycleRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        Object object3 = new LinkedHashMap();
        String string2 = "";
        object3.put("lifecycle", string2);
        boolean n10 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(n10);
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.PUT;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        object4 = ((PutBucketLifecycleRequest)object).getBucketName();
        requestMessage.setBucketName((String)object4);
        requestMessage.setParameters((Map)object3);
        try {
            object3 = ((PutBucketLifecycleRequest)object).getLifecycleRules();
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
            return null;
        }
        requestMessage.putBucketLifecycleRequestBodyMarshall((ArrayList)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        string2 = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, (Context)string2);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$PutBucketLifecycleResponseParser();
        int n11 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n11);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask putBucketLogging(PutBucketLoggingRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        Object object3 = new LinkedHashMap();
        String string2 = "";
        object3.put("logging", string2);
        boolean n10 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(n10);
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.PUT;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        object4 = ((PutBucketLoggingRequest)object).getBucketName();
        requestMessage.setBucketName((String)object4);
        requestMessage.setParameters((Map)object3);
        try {
            object3 = ((PutBucketLoggingRequest)object).getTargetBucketName();
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
            return null;
        }
        object4 = ((PutBucketLoggingRequest)object).getTargetPrefix();
        requestMessage.putBucketLoggingRequestBodyMarshall((String)object3, (String)object4);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        string2 = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, (Context)string2);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$PutBucketLoggingResponseParser();
        int n11 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n11);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask putBucketReferer(PutBucketRefererRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        Object object3 = new LinkedHashMap();
        String string2 = "";
        object3.put("referer", string2);
        boolean n10 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(n10);
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.PUT;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        object4 = ((PutBucketRefererRequest)object).getBucketName();
        requestMessage.setBucketName((String)object4);
        requestMessage.setParameters((Map)object3);
        try {
            object3 = ((PutBucketRefererRequest)object).getReferers();
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
            return null;
        }
        boolean bl2 = ((PutBucketRefererRequest)object).isAllowEmpty();
        requestMessage.putBucketRefererRequestBodyMarshall((ArrayList)object3, bl2);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        string2 = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, (Context)string2);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$PutBucketRefererResponseParser();
        int n11 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n11);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask putObject(PutObjectRequest object, OSSCompletedCallback object2) {
        String string2;
        Object object3;
        OSSLog.logDebug(" Internal putObject Start ");
        RequestMessage requestMessage = new RequestMessage();
        boolean bl2 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(bl2);
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.PUT;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        object4 = ((PutObjectRequest)object).getBucketName();
        requestMessage.setBucketName((String)object4);
        object4 = ((PutObjectRequest)object).getObjectKey();
        requestMessage.setObjectKey((String)object4);
        object4 = ((PutObjectRequest)object).getUploadData();
        if (object4 != null) {
            object4 = ((PutObjectRequest)object).getUploadData();
            requestMessage.setUploadData((byte[])object4);
        }
        if ((object4 = ((PutObjectRequest)object).getUploadFilePath()) != null) {
            object4 = ((PutObjectRequest)object).getUploadFilePath();
            requestMessage.setUploadFilePath((String)object4);
        }
        if ((object4 = ((PutObjectRequest)object).getCallbackParam()) != null) {
            object4 = requestMessage.getHeaders();
            object3 = OSSUtils.populateMapToBase64JsonString(((PutObjectRequest)object).getCallbackParam());
            string2 = "x-oss-callback";
            object4.put(string2, object3);
        }
        if ((object4 = ((PutObjectRequest)object).getCallbackVars()) != null) {
            object4 = requestMessage.getHeaders();
            object3 = OSSUtils.populateMapToBase64JsonString(((PutObjectRequest)object).getCallbackVars());
            string2 = "x-oss-callback-var";
            object4.put(string2, object3);
        }
        OSSLog.logDebug(" populateRequestMetadata ");
        object4 = requestMessage.getHeaders();
        object3 = ((PutObjectRequest)object).getMetadata();
        OSSUtils.populateRequestMetadata((Map)object4, (ObjectMetadata)object3);
        OSSLog.logDebug(" canonicalizeRequestMessage ");
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        OSSLog.logDebug(" ExecutionContext ");
        object3 = this.getInnerClient();
        string2 = this.applicationContext;
        object4 = new ExecutionContext((z)object3, (OSSRequest)object, (Context)string2);
        if (object2 != null) {
            object3 = new InternalRequestOperation$4(this, (OSSCompletedCallback)object2);
            ((ExecutionContext)object4).setCompletedCallback((OSSCompletedCallback)object3);
        }
        if ((object2 = ((PutObjectRequest)object).getRetryCallback()) != null) {
            object2 = ((PutObjectRequest)object).getRetryCallback();
            ((ExecutionContext)object4).setRetryCallback((OSSRetryCallback)object2);
        }
        object = ((PutObjectRequest)object).getProgressCallback();
        ((ExecutionContext)object4).setProgressCallback((OSSProgressCallback)object);
        object = new ResponseParsers$PutObjectResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object4, n10);
        OSSLog.logDebug(" call OSSRequestTask ");
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object4);
    }

    public OSSAsyncTask putSymlink(PutSymlinkRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        Object object3 = new LinkedHashMap();
        String string2 = "";
        object3.put("symlink", string2);
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.PUT;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        object4 = ((PutSymlinkRequest)object).getBucketName();
        requestMessage.setBucketName((String)object4);
        object4 = ((PutSymlinkRequest)object).getObjectKey();
        requestMessage.setObjectKey((String)object4);
        requestMessage.setParameters((Map)object3);
        object3 = ((PutSymlinkRequest)object).getTargetObjectName();
        boolean bl2 = OSSUtils.isEmptyString((String)object3);
        if (!bl2) {
            object3 = HttpUtil.urlEncode(((PutSymlinkRequest)object).getTargetObjectName(), "utf-8");
            object4 = requestMessage.getHeaders();
            string2 = "x-oss-symlink-target";
            object4.put(string2, object3);
        }
        object3 = requestMessage.getHeaders();
        object4 = ((PutSymlinkRequest)object).getMetadata();
        OSSUtils.populateRequestMetadata((Map)object3, (ObjectMetadata)object4);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        string2 = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, (Context)string2);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$PutSymlinkResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask restoreObject(RestoreObjectRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        Object object3 = new LinkedHashMap();
        object3.put("restore", "");
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.POST;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        object4 = ((RestoreObjectRequest)object).getBucketName();
        requestMessage.setBucketName((String)object4);
        object4 = ((RestoreObjectRequest)object).getObjectKey();
        requestMessage.setObjectKey((String)object4);
        requestMessage.setParameters((Map)object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$RestoreObjectResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public void setCredentialProvider(OSSCredentialProvider oSSCredentialProvider) {
        this.credentialProvider = oSSCredentialProvider;
    }

    public AppendObjectResult syncAppendObject(AppendObjectRequest appendObjectRequest) {
        boolean bl2;
        Object object;
        AppendObjectResult appendObjectResult = (AppendObjectResult)this.appendObject(appendObjectRequest, null).getResult();
        Object object2 = appendObjectRequest.getCRC64();
        if (object2 == (object = OSSRequest$CRC64Config.YES)) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        object = appendObjectRequest.getInitCRC64();
        if (object != null && bl2) {
            long l10 = appendObjectRequest.getInitCRC64();
            long l11 = appendObjectResult.getClientCRC();
            long l12 = appendObjectResult.getNextPosition();
            long l13 = appendObjectRequest.getPosition();
            long l14 = CRC64.combine((long)l10, (long)l11, (long)(l12 -= l13));
            object2 = l14;
            appendObjectResult.setClientCRC((Long)object2);
        }
        this.checkCRC64(appendObjectRequest, appendObjectResult);
        return appendObjectResult;
    }

    public CompleteMultipartUploadResult syncCompleteMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest) {
        CompleteMultipartUploadResult completeMultipartUploadResult = (CompleteMultipartUploadResult)this.completeMultipartUpload(completeMultipartUploadRequest, null).getResult();
        Object object = completeMultipartUploadResult.getServerCRC();
        if (object != null) {
            object = completeMultipartUploadRequest.getPartETags();
            long l10 = this.calcObjectCRCFromParts((List)object);
            object = l10;
            completeMultipartUploadResult.setClientCRC((Long)object);
        }
        this.checkCRC64(completeMultipartUploadRequest, completeMultipartUploadResult);
        return completeMultipartUploadResult;
    }

    public GetSymlinkResult syncGetSymlink(GetSymlinkRequest getSymlinkRequest) {
        return (GetSymlinkResult)this.getSymlink(getSymlinkRequest, null).getResult();
    }

    public PutObjectResult syncPutObject(PutObjectRequest putObjectRequest) {
        PutObjectResult putObjectResult = (PutObjectResult)this.putObject(putObjectRequest, null).getResult();
        this.checkCRC64(putObjectRequest, putObjectResult);
        return putObjectResult;
    }

    public PutSymlinkResult syncPutSymlink(PutSymlinkRequest putSymlinkRequest) {
        return (PutSymlinkResult)this.putSymlink(putSymlinkRequest, null).getResult();
    }

    public RestoreObjectResult syncRestoreObject(RestoreObjectRequest restoreObjectRequest) {
        return (RestoreObjectResult)this.restoreObject(restoreObjectRequest, null).getResult();
    }

    public UploadPartResult syncUploadPart(UploadPartRequest uploadPartRequest) {
        UploadPartResult uploadPartResult = (UploadPartResult)this.uploadPart(uploadPartRequest, null).getResult();
        this.checkCRC64(uploadPartRequest, uploadPartResult);
        return uploadPartResult;
    }

    public OSSAsyncTask triggerCallback(TriggerCallbackRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        Object object3 = new LinkedHashMap();
        object3.put("x-oss-process", "");
        Object object4 = this.endpoint;
        requestMessage.setEndpoint((URI)object4);
        object4 = HttpMethod.POST;
        requestMessage.setMethod((HttpMethod)((Object)object4));
        object4 = ((TriggerCallbackRequest)object).getBucketName();
        requestMessage.setBucketName((String)object4);
        object4 = ((TriggerCallbackRequest)object).getObjectKey();
        requestMessage.setObjectKey((String)object4);
        requestMessage.setParameters((Map)object3);
        object3 = ((TriggerCallbackRequest)object).getCallbackParam();
        object4 = ((TriggerCallbackRequest)object).getCallbackVars();
        object3 = OSSUtils.buildTriggerCallbackBody(object3, (Map)object4);
        requestMessage.setStringBody((String)object3);
        object3 = BinaryUtil.calculateBase64Md5(((String)object3).getBytes());
        requestMessage.getHeaders().put("Content-MD5", object3);
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        Context context = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, context);
        if (object2 != null) {
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object2);
        }
        object = new ResponseParsers$TriggerCallbackResponseParser();
        int n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }

    public OSSAsyncTask uploadPart(UploadPartRequest object, OSSCompletedCallback object2) {
        RequestMessage requestMessage = new RequestMessage();
        boolean bl2 = ((OSSRequest)object).isAuthorizationRequired();
        requestMessage.setIsAuthorizationRequired(bl2);
        Object object3 = this.endpoint;
        requestMessage.setEndpoint((URI)object3);
        object3 = HttpMethod.PUT;
        requestMessage.setMethod((HttpMethod)((Object)object3));
        object3 = ((UploadPartRequest)object).getBucketName();
        requestMessage.setBucketName((String)object3);
        object3 = ((UploadPartRequest)object).getObjectKey();
        requestMessage.setObjectKey((String)object3);
        object3 = requestMessage.getParameters();
        Object object4 = ((UploadPartRequest)object).getUploadId();
        object3.put("uploadId", object4);
        object3 = requestMessage.getParameters();
        int n10 = ((UploadPartRequest)object).getPartNumber();
        object4 = String.valueOf(n10);
        String string2 = "partNumber";
        object3.put(string2, object4);
        object3 = ((UploadPartRequest)object).getPartContent();
        requestMessage.setUploadData((byte[])object3);
        object3 = ((UploadPartRequest)object).getMd5Digest();
        if (object3 != null) {
            object3 = requestMessage.getHeaders();
            object4 = ((UploadPartRequest)object).getMd5Digest();
            string2 = "Content-MD5";
            object3.put(string2, object4);
        }
        this.canonicalizeRequestMessage(requestMessage, (OSSRequest)object);
        object4 = this.getInnerClient();
        string2 = this.applicationContext;
        object3 = new ExecutionContext((z)object4, (OSSRequest)object, (Context)string2);
        if (object2 != null) {
            object4 = new InternalRequestOperation$6(this, (OSSCompletedCallback)object2);
            ((ExecutionContext)object3).setCompletedCallback((OSSCompletedCallback)object4);
        }
        object = ((UploadPartRequest)object).getProgressCallback();
        ((ExecutionContext)object3).setProgressCallback((OSSProgressCallback)object);
        object = new ResponseParsers$UploadPartResponseParser();
        n10 = this.maxRetryCount;
        object2 = new OSSRequestTask(requestMessage, (ResponseParser)object, (ExecutionContext)object3, n10);
        return OSSAsyncTask.wrapRequestTask(executorService.submit(object2), (ExecutionContext)object3);
    }
}

