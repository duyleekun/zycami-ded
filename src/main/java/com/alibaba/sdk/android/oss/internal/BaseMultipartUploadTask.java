/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask$1;
import com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask$2;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest$CRC64Config;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.UploadPartRequest;
import com.alibaba.sdk.android.oss.model.UploadPartResult;
import com.alibaba.sdk.android.oss.network.CancellationHandler;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class BaseMultipartUploadTask
implements Callable {
    public final int CPU_SIZE;
    public final int KEEP_ALIVE_TIME;
    public final int MAX_CORE_POOL_SIZE;
    public final int MAX_IMUM_POOL_SIZE;
    public final int MAX_QUEUE_SIZE;
    public InternalRequestOperation mApiOperation;
    public boolean mCheckCRC64;
    public OSSCompletedCallback mCompletedCallback;
    public ExecutionContext mContext;
    public long mFileLength;
    public boolean mIsCancel;
    public long mLastPartSize;
    public Object mLock;
    public int[] mPartAttr;
    public List mPartETags;
    public int mPartExceptionCount;
    public ThreadPoolExecutor mPoolExecutor;
    public OSSProgressCallback mProgressCallback;
    public MultipartUploadRequest mRequest;
    public int mRunPartTaskCount;
    public Exception mUploadException;
    public File mUploadFile;
    public String mUploadFilePath;
    public String mUploadId;
    public long mUploadedLength;

    public BaseMultipartUploadTask(InternalRequestOperation object, MultipartUploadRequest object2, OSSCompletedCallback oSSCompletedCallback, ExecutionContext executionContext) {
        long l10;
        ThreadPoolExecutor threadPoolExecutor;
        int n10;
        Object object3 = Runtime.getRuntime();
        int n11 = ((Runtime)object3).availableProcessors();
        int n12 = 2;
        this.CPU_SIZE = n10 = n11 * 2;
        n11 = 5;
        int n13 = n10 < n11 ? n10 : n11;
        this.MAX_CORE_POOL_SIZE = n13;
        this.MAX_IMUM_POOL_SIZE = n10;
        this.KEEP_ALIVE_TIME = 3000;
        this.MAX_QUEUE_SIZE = n11 = 5000;
        long l11 = 3000L;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<Runnable>(n11);
        BaseMultipartUploadTask$1 baseMultipartUploadTask$1 = new BaseMultipartUploadTask$1(this);
        this.mPoolExecutor = threadPoolExecutor = new ThreadPoolExecutor(n13, n10, l11, timeUnit, arrayBlockingQueue, baseMultipartUploadTask$1);
        object3 = new ArrayList();
        this.mPartETags = object3;
        this.mLock = object3 = new Object();
        this.mUploadedLength = l10 = 0L;
        n11 = 0;
        object3 = null;
        this.mCheckCRC64 = false;
        int[] nArray = new int[n12];
        this.mPartAttr = nArray;
        this.mApiOperation = object;
        this.mRequest = object2;
        this.mProgressCallback = object = object2.getProgressCallback();
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        object = object2.getCRC64();
        object2 = OSSRequest$CRC64Config.YES;
        if (object == object2) {
            n11 = 1;
        }
        this.mCheckCRC64 = n11;
    }

    public abstract void abortThisUpload();

    public CompleteMultipartUploadResult call() {
        CompleteMultipartUploadResult completeMultipartUploadResult;
        block10: {
            this.checkInitData();
            this.initMultipartUploadId();
            completeMultipartUploadResult = this.doMultipartUpload();
            Object object = this.mCompletedCallback;
            if (object == null) break block10;
            Object object2 = this.mRequest;
            try {
                object.onSuccess((OSSRequest)object2, completeMultipartUploadResult);
            }
            catch (Exception exception) {
                Object object3;
                boolean bl2 = exception instanceof ClientException;
                if (bl2) {
                    object3 = (ClientException)exception;
                } else {
                    object2 = exception.toString();
                    object3 = object = new ClientException((String)object2, exception);
                }
                object = this.mCompletedCallback;
                if (object != null) {
                    object2 = this.mRequest;
                    object.onFailure((OSSRequest)object2, (ClientException)object3, null);
                }
                throw object3;
            }
            catch (ServiceException serviceException) {
                object = this.mCompletedCallback;
                if (object != null) {
                    object2 = this.mRequest;
                    object.onFailure((OSSRequest)object2, null, serviceException);
                }
                throw serviceException;
            }
        }
        return completeMultipartUploadResult;
    }

    public void checkCancel() {
        Object object = this.mContext.getCancellationHandler();
        boolean bl2 = ((CancellationHandler)object).isCancelled();
        if (!bl2) {
            return;
        }
        object = new TaskCancelException("multipart cancel");
        String string2 = ((Throwable)object).getMessage();
        Boolean bl3 = Boolean.TRUE;
        ClientException clientException = new ClientException(string2, (Throwable)object, bl3);
        throw clientException;
    }

    public void checkException() {
        Exception exception = this.mUploadException;
        if (exception != null) {
            this.releasePool();
            exception = this.mUploadException;
            boolean bl2 = exception instanceof IOException;
            if (!bl2) {
                bl2 = exception instanceof ServiceException;
                if (!bl2) {
                    bl2 = exception instanceof ClientException;
                    if (bl2) {
                        throw (ClientException)exception;
                    }
                    String string2 = this.mUploadException.getMessage();
                    Exception exception2 = this.mUploadException;
                    exception = new ClientException(string2, exception2);
                    throw exception;
                }
                throw (ServiceException)exception;
            }
            throw (IOException)exception;
        }
    }

    public void checkInitData() {
        long l10;
        long l11;
        Object object = this.mRequest.getUploadFilePath();
        this.mUploadFilePath = object;
        this.mUploadedLength = l11 = 0L;
        String string2 = this.mUploadFilePath;
        Object object2 = new File(string2);
        this.mUploadFile = object2;
        this.mFileLength = l10 = ((File)object2).length();
        Object object3 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object3 != false) {
            long l12;
            object = this.mPartAttr;
            this.checkPartSize((int[])object);
            object = this.mRequest;
            l11 = ((MultipartUploadRequest)object).getPartSize();
            object2 = this.mPartAttr;
            int n10 = 1;
            Object object4 = object2[n10];
            CharSequence charSequence = new StringBuilder();
            charSequence.append("[checkInitData] - partNumber : ");
            charSequence.append((int)object4);
            OSSLog.logDebug(charSequence.toString());
            charSequence = new StringBuilder();
            String string3 = "[checkInitData] - partSize : ";
            charSequence.append(string3);
            charSequence.append(l11);
            charSequence = charSequence.toString();
            OSSLog.logDebug((String)charSequence);
            if (object4 > n10 && (object3 = (l12 = l11 - (l10 = 102400L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) < 0) {
                object = new ClientException("Part size must be greater than or equal to 100KB!");
                throw object;
            }
            return;
        }
        object = new ClientException("file length must not be 0");
        throw object;
    }

    public void checkPartSize(int[] object) {
        int n10;
        MultipartUploadRequest multipartUploadRequest = this.mRequest;
        long l10 = multipartUploadRequest.getPartSize();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("[checkPartSize] - mFileLength : ");
        long l11 = this.mFileLength;
        charSequence.append(l11);
        OSSLog.logDebug(charSequence.toString());
        charSequence = new StringBuilder();
        String string2 = "[checkPartSize] - partSize : ";
        charSequence.append(string2);
        charSequence.append(l10);
        charSequence = charSequence.toString();
        OSSLog.logDebug((String)charSequence);
        long l12 = this.mFileLength;
        int n11 = (int)(l12 / l10);
        long l13 = l12 % l10;
        long l14 = 0L;
        long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        if (l15 != false) {
            ++n11;
        }
        l15 = 5000;
        int n12 = 1;
        if (n11 == n12) {
            l10 = l12;
        } else if (n11 > l15) {
            l10 = l15;
            l10 = l12 / l10;
            n11 = (int)l15;
        }
        object[0] = n10 = (int)l10;
        object[n12] = n11;
        object = this.mRequest;
        l13 = n10;
        ((MultipartUploadRequest)object).setPartSize(l13);
        object = new StringBuilder();
        String string3 = "[checkPartSize] - partNumber : ";
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append(n11);
        OSSLog.logDebug(((StringBuilder)object).toString());
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        OSSLog.logDebug((String)object);
        long l16 = this.mFileLength % l10;
        long l17 = l16 == l14 ? 0 : (l16 < l14 ? -1 : 1);
        if (l17 != false) {
            l10 = l16;
        }
        this.mLastPartSize = l10;
    }

    public boolean checkWaitCondition(int n10) {
        List list = this.mPartETags;
        int n11 = list.size();
        return n11 != n10;
    }

    public CompleteMultipartUploadResult completeMultipartUploadResult() {
        Object object = this.mPartETags;
        int n10 = object.size();
        if (n10 > 0) {
            object = this.mPartETags;
            Object object2 = new BaseMultipartUploadTask$2(this);
            Collections.sort(object, object2);
            object2 = this.mRequest.getBucketName();
            String string2 = this.mRequest.getObjectKey();
            String string3 = this.mUploadId;
            List list = this.mPartETags;
            object = new CompleteMultipartUploadRequest((String)object2, string2, string3, list);
            object2 = this.mRequest.getMetadata();
            ((CompleteMultipartUploadRequest)object).setMetadata((ObjectMetadata)object2);
            object2 = this.mRequest.getCallbackParam();
            if (object2 != null) {
                object2 = this.mRequest.getCallbackParam();
                ((CompleteMultipartUploadRequest)object).setCallbackParam((Map)object2);
            }
            if ((object2 = this.mRequest.getCallbackVars()) != null) {
                object2 = this.mRequest.getCallbackVars();
                ((CompleteMultipartUploadRequest)object).setCallbackVars((Map)object2);
            }
            object2 = this.mRequest.getCRC64();
            ((OSSRequest)object).setCRC64((Enum)object2);
            object2 = this.mApiOperation;
            object = ((InternalRequestOperation)object2).syncCompleteMultipartUpload((CompleteMultipartUploadRequest)object);
        } else {
            n10 = 0;
            object = null;
        }
        this.mUploadedLength = 0L;
        return object;
    }

    public abstract CompleteMultipartUploadResult doMultipartUpload();

    public abstract void initMultipartUploadId();

    public void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0;
    }

    public void onProgressCallback(MultipartUploadRequest multipartUploadRequest, long l10, long l11) {
        OSSProgressCallback oSSProgressCallback = this.mProgressCallback;
        if (oSSProgressCallback != null) {
            oSSProgressCallback.onProgress(multipartUploadRequest, l10, l11);
        }
    }

    public void preUploadPart(int n10, int n11, int n12) {
    }

    public abstract void processException(Exception var1);

    public void releasePool() {
        ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            threadPoolExecutor = this.mPoolExecutor;
            threadPoolExecutor.shutdown();
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void uploadPart(int n10, int n11, int n12) {
        void var8_15;
        Object object;
        block30: {
            Object object2;
            block31: {
                long l10;
                int n13;
                int n14 = 0;
                object = null;
                Object object3 = this.mContext;
                object3 = ((ExecutionContext)object3).getCancellationHandler();
                boolean bl2 = ((CancellationHandler)object3).isCancelled();
                if (bl2) {
                    Object object4 = this.mPoolExecutor;
                    object4 = ((ThreadPoolExecutor)object4).getQueue();
                    object4.clear();
                    return;
                }
                object3 = this.mLock;
                // MONITORENTER : object3
                this.mRunPartTaskCount = n13 = this.mRunPartTaskCount + 1;
                // MONITOREXIT : object3
                this.preUploadPart(n10, n11, n12);
                Object object5 = this.mUploadFile;
                Object object6 = "r";
                object3 = new RandomAccessFile((File)object5, (String)object6);
                object5 = this.mRequest;
                object5 = ((MultipartUploadRequest)object5).getBucketName();
                object6 = this.mRequest;
                object6 = ((MultipartUploadRequest)object6).getObjectKey();
                Object object7 = this.mUploadId;
                int n15 = n10 + 1;
                object = new UploadPartRequest((String)object5, (String)object6, (String)object7, n15);
                long l11 = n10;
                object2 = this.mRequest;
                long l12 = ((MultipartUploadRequest)object2).getPartSize();
                object2 = new byte[n11];
                ((RandomAccessFile)object3).seek(l11 *= l12);
                n13 = 0;
                object5 = null;
                ((RandomAccessFile)object3).readFully((byte[])object2, 0, n11);
                ((UploadPartRequest)object).setPartContent((byte[])object2);
                object2 = BinaryUtil.calculateBase64Md5((byte[])object2);
                ((UploadPartRequest)object).setMd5Digest((String)object2);
                object2 = this.mRequest;
                object2 = ((OSSRequest)object2).getCRC64();
                ((OSSRequest)object).setCRC64((Enum)object2);
                object2 = this.mApiOperation;
                object2 = ((InternalRequestOperation)object2).syncUploadPart((UploadPartRequest)object);
                object5 = this.mLock;
                // MONITORENTER : object5
                n14 = ((UploadPartRequest)object).getPartNumber();
                object7 = ((UploadPartResult)object2).getETag();
                object6 = new PartETag(n14, (String)object7);
                l12 = n11;
                ((PartETag)object6).setPartSize(l12);
                n11 = (int)(this.mCheckCRC64 ? 1 : 0);
                if (n11 != 0) {
                    object2 = ((OSSResult)object2).getClientCRC();
                    l10 = (Long)object2;
                    ((PartETag)object6).setCRC64(l10);
                }
                object2 = this.mPartETags;
                object2.add(object6);
                this.mUploadedLength = l10 = this.mUploadedLength + l12;
                this.uploadPartFinish((PartETag)object6);
                object2 = this.mContext;
                object2 = ((ExecutionContext)object2).getCancellationHandler();
                n10 = (int)(((CancellationHandler)object2).isCancelled() ? 1 : 0);
                if (n10 != 0) {
                    object2 = this.mPartETags;
                    n10 = object2.size();
                    n11 = this.mRunPartTaskCount;
                    n12 = this.mPartExceptionCount;
                    if (n10 == (n11 -= n12)) {
                        Object object8 = "multipart cancel";
                        object2 = new TaskCancelException((String)object8);
                        String string2 = ((Throwable)object2).getMessage();
                        object = Boolean.TRUE;
                        object8 = new ClientException(string2, (Throwable)object2, (Boolean)object);
                        throw object8;
                    }
                } else {
                    object2 = this.mPartETags;
                    n10 = object2.size();
                    if (n10 == (n12 -= (n11 = this.mPartExceptionCount))) {
                        this.notifyMultipartThread();
                    }
                    object7 = this.mRequest;
                    long l13 = this.mUploadedLength;
                    long l14 = this.mFileLength;
                    object6 = this;
                    this.onProgressCallback((MultipartUploadRequest)object7, l13, l14);
                }
                // MONITOREXIT : object5
                ((RandomAccessFile)object3).close();
                return;
                catch (Throwable throwable) {
                    object = object3;
                    break block30;
                }
                catch (Exception exception) {
                    object = object3;
                    break block31;
                }
                catch (Throwable throwable) {
                    break block30;
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            this.processException((Exception)object2);
            if (object == null) return;
            try {
                ((RandomAccessFile)object).close();
                return;
            }
            catch (IOException iOException) {
                OSSLog.logThrowable2Local(iOException);
            }
            return;
        }
        if (object == null) throw var8_15;
        try {
            ((RandomAccessFile)object).close();
            throw var8_15;
        }
        catch (IOException iOException) {
            OSSLog.logThrowable2Local(iOException);
        }
        throw var8_15;
    }

    public void uploadPartFinish(PartETag partETag) {
    }
}

