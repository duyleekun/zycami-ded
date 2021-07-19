/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.alibaba.sdk.android.oss.common.utils.CRC64
 */
package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.TaskCancelException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.common.utils.CRC64;
import com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult;
import com.alibaba.sdk.android.oss.model.ListPartsRequest;
import com.alibaba.sdk.android.oss.model.ListPartsResult;
import com.alibaba.sdk.android.oss.model.MultipartUploadRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;
import com.alibaba.sdk.android.oss.model.PartETag;
import com.alibaba.sdk.android.oss.model.PartSummary;
import com.alibaba.sdk.android.oss.model.ResumableUploadRequest;
import com.alibaba.sdk.android.oss.model.ResumableUploadResult;
import com.alibaba.sdk.android.oss.model.UploadPartRequest;
import com.alibaba.sdk.android.oss.network.CancellationHandler;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

public class SequenceUploadTask
extends BaseMultipartUploadTask
implements Callable {
    private List mAlreadyUploadIndex;
    private File mCRC64RecordFile;
    private long mFirstPartSize;
    private File mRecordFile;
    private OSSSharedPreferences mSp;

    public SequenceUploadTask(ResumableUploadRequest object, OSSCompletedCallback oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, (MultipartUploadRequest)object, oSSCompletedCallback, executionContext);
        object = new ArrayList();
        this.mAlreadyUploadIndex = object;
        this.mSp = object = OSSSharedPreferences.instance(this.mContext.getApplicationContext());
    }

    public void abortThisUpload() {
        Object object = this.mUploadId;
        if (object != null) {
            Object object2 = ((ResumableUploadRequest)this.mRequest).getBucketName();
            String string2 = ((ResumableUploadRequest)this.mRequest).getObjectKey();
            String string3 = this.mUploadId;
            object = new AbortMultipartUploadRequest((String)object2, string2, string3);
            object2 = this.mApiOperation;
            string2 = null;
            object = ((InternalRequestOperation)object2).abortMultipartUpload((AbortMultipartUploadRequest)object, null);
            ((OSSAsyncTask)object).waitUntilFinished();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void checkException() {
        block13: {
            block12: {
                block14: {
                    var1_1 = this.mContext.getCancellationHandler();
                    var2_7 = var1_1.isCancelled();
                    if (var2_7 == 0) break block13;
                    var1_1 = ((ResumableUploadRequest)this.mRequest).deleteUploadOnCancelling();
                    var2_7 = var1_1.booleanValue();
                    if (var2_7 == 0) break block14;
                    this.abortThisUpload();
                    var1_1 = this.mRecordFile;
                    if (var1_1 != null) {
                        var1_1.delete();
                    }
                    break block13;
                }
                var1_1 = this.mPartETags;
                if (var1_1 == null || (var2_7 = var1_1.size()) <= 0 || (var2_7 = (int)this.mCheckCRC64) == 0 || (var1_1 = ((ResumableUploadRequest)this.mRequest).getRecordDirectory()) == null) break block13;
                var1_1 = new Object();
                var3_8 = this.mPartETags.iterator();
                while (var4_9 = var3_8.hasNext()) {
                    var5_10 = (PartETag)var3_8.next();
                    var6_11 = var5_10.getPartNumber();
                    var7_12 = var6_11;
                    var8_13 = var5_10.getCRC64();
                    var5_10 = var8_13;
                    var1_1.put(var7_12, var5_10);
                }
                var3_8 = null;
                try {
                    var5_10 = new StringBuilder();
                    var7_12 = this.mRequest;
                    var7_12 = (ResumableUploadRequest)var7_12;
                    var7_12 = var7_12.getRecordDirectory();
                    var5_10.append((String)var7_12);
                    var7_12 = File.separator;
                    var5_10.append((String)var7_12);
                    var7_12 = this.mUploadId;
                    var5_10.append((String)var7_12);
                    var5_10 = var5_10.toString();
                    this.mCRC64RecordFile = var7_12 = new File((String)var5_10);
                    var4_9 = var7_12.exists();
                    if (!var4_9) {
                        var5_10 = this.mCRC64RecordFile;
                        var5_10.createNewFile();
                    }
                    var10_14 = this.mCRC64RecordFile;
                    var7_12 = new FileOutputStream(var10_14);
                    var5_10 = new ObjectOutputStream((OutputStream)var7_12);
                }
                catch (Throwable var1_4) {
                    break block12;
                }
                catch (IOException var1_5) {
                    // empty catch block
                    ** GOTO lbl-1000
                }
                try {
                    var5_10.writeObject(var1_1);
                }
                catch (Throwable var1_2) {
                    var3_8 = var5_10;
                    break block12;
                }
                catch (IOException var1_3) {
                    var3_8 = var5_10;
                    ** GOTO lbl-1000
                }
                var5_10.close();
                break block13;
lbl-1000:
                // 2 sources

                {
                    OSSLog.logThrowable2Local(var1_1);
                    ** if (var3_8 == null) goto lbl-1000
                }
lbl-1000:
                // 1 sources

                {
                    var3_8.close();
                }
lbl-1000:
                // 2 sources

                {
                    break block13;
                }
            }
            if (var3_8 != null) {
                var3_8.close();
            }
            throw var1_6;
        }
        super.checkException();
    }

    /*
     * Enabled aggressive block sorting
     */
    public ResumableUploadResult doMultipartUpload() {
        Object object;
        long l10;
        long l11 = this.mUploadedLength;
        this.checkCancel();
        int[] nArray = this.mPartAttr;
        int n10 = 0;
        int n11 = nArray[0];
        int n12 = nArray[1];
        Object object2 = this.mPartETags;
        int n13 = object2.size();
        if (n13 > 0 && (n13 = (object2 = this.mAlreadyUploadIndex).size()) > 0) {
            l10 = this.mUploadedLength;
            long l12 = this.mFileLength;
            long l13 = l10 - l12;
            Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 > 0) {
                ClientException clientException = new ClientException("The uploading file is inconsistent with before");
                throw clientException;
            }
            l12 = this.mFirstPartSize;
            long l14 = n11;
            long l15 = l12 - l14;
            Object object4 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object4 != false) {
                ClientException clientException = new ClientException("The part size setting is inconsistent with before");
                throw clientException;
            }
            Object object5 = this.mSp;
            Object object6 = this.mUploadId;
            boolean bl2 = TextUtils.isEmpty((CharSequence)(object5 = ((OSSSharedPreferences)object5).getStringValue((String)object6)));
            if (!bl2) {
                object2 = this.mSp;
                object = this.mUploadId;
                object2 = Long.valueOf(((OSSSharedPreferences)object2).getStringValue((String)object));
                l10 = (Long)object2;
            }
            l14 = l10;
            object5 = this.mProgressCallback;
            if (object5 != null) {
                object6 = this.mRequest;
                long l16 = this.mFileLength;
                object5.onProgress(object6, l10, l16);
            }
            object2 = this.mSp;
            object = this.mUploadId;
            ((OSSSharedPreferences)object2).removeKey((String)object);
        }
        while (n10 < n12) {
            int n14;
            object2 = this.mAlreadyUploadIndex;
            n13 = object2.size();
            if (n13 == 0 || (n13 = (int)((object2 = this.mAlreadyUploadIndex).contains(object = Integer.valueOf(n14 = n10 + 1)) ? 1 : 0)) == 0) {
                n13 = n12 + -1;
                if (n10 == n13) {
                    long l17 = this.mFileLength - l11;
                    n11 = (int)l17;
                }
                object2 = new StringBuilder();
                object = "upload part readByte : ";
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(n11);
                OSSLog.logDebug(((StringBuilder)object2).toString());
                l10 = n11;
                l11 += l10;
                this.uploadPart(n10, n11, n12);
                object2 = this.mUploadException;
                if (object2 != null) break;
            }
            ++n10;
        }
        this.checkException();
        Object object7 = this.completeMultipartUploadResult();
        ResumableUploadResult resumableUploadResult = null;
        if (object7 != null) {
            resumableUploadResult = new ResumableUploadResult((CompleteMultipartUploadResult)object7);
        }
        if ((object7 = this.mRecordFile) != null) {
            ((File)object7).delete();
        }
        if ((object7 = this.mCRC64RecordFile) != null) {
            ((File)object7).delete();
        }
        return resumableUploadResult;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void initMultipartUploadId() {
        boolean bl2;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        boolean bl3;
        Object object5;
        block22: {
            block23: {
                ServiceException serviceException2;
                block21: {
                    int n10;
                    block25: {
                        block24: {
                            Throwable throwable2;
                            block20: {
                                block19: {
                                    block18: {
                                        object5 = ((ResumableUploadRequest)this.mRequest).getRecordDirectory();
                                        bl3 = OSSUtils.isEmptyString((String)object5);
                                        object4 = null;
                                        if (bl3) break block22;
                                        object5 = BinaryUtil.calculateMd5Str(this.mUploadFilePath);
                                        object3 = new StringBuilder();
                                        ((StringBuilder)object3).append((String)object5);
                                        object5 = ((ResumableUploadRequest)this.mRequest).getBucketName();
                                        ((StringBuilder)object3).append((String)object5);
                                        object5 = ((ResumableUploadRequest)this.mRequest).getObjectKey();
                                        ((StringBuilder)object3).append((String)object5);
                                        long l10 = ((ResumableUploadRequest)this.mRequest).getPartSize();
                                        object5 = String.valueOf(l10);
                                        ((StringBuilder)object3).append((String)object5);
                                        bl3 = this.mCheckCRC64;
                                        object5 = bl3 ? "-crc64" : "";
                                        ((StringBuilder)object3).append((String)object5);
                                        ((StringBuilder)object3).append("-sequence");
                                        object5 = BinaryUtil.calculateMd5Str(((StringBuilder)object3).toString().getBytes());
                                        object3 = new StringBuilder();
                                        object2 = ((ResumableUploadRequest)this.mRequest).getRecordDirectory();
                                        ((StringBuilder)object3).append((String)object2);
                                        object2 = File.separator;
                                        ((StringBuilder)object3).append((String)object2);
                                        ((StringBuilder)object3).append((String)object5);
                                        object5 = ((StringBuilder)object3).toString();
                                        this.mRecordFile = object3 = new File((String)object5);
                                        bl3 = ((File)object3).exists();
                                        if (bl3) {
                                            object = this.mRecordFile;
                                            object3 = new FileReader((File)object);
                                            object5 = new BufferedReader((Reader)object3);
                                            this.mUploadId = object3 = ((BufferedReader)object5).readLine();
                                            ((BufferedReader)object5).close();
                                            object5 = new StringBuilder();
                                            ((StringBuilder)object5).append("sequence [initUploadId] - Found record file, uploadid: ");
                                            object3 = this.mUploadId;
                                            ((StringBuilder)object5).append((String)object3);
                                            object5 = ((StringBuilder)object5).toString();
                                            OSSLog.logDebug((String)object5);
                                        }
                                        if (bl3 = OSSUtils.isEmptyString((String)(object5 = this.mUploadId))) break block23;
                                        bl3 = this.mCheckCRC64;
                                        if (!bl3) break block24;
                                        object5 = new StringBuilder();
                                        object3 = ((ResumableUploadRequest)this.mRequest).getRecordDirectory();
                                        ((StringBuilder)object5).append((String)object3);
                                        ((StringBuilder)object5).append((String)object2);
                                        object3 = this.mUploadId;
                                        ((StringBuilder)object5).append((String)object3);
                                        object5 = ((StringBuilder)object5).toString();
                                        object3 = new File((String)object5);
                                        bl3 = ((File)object3).exists();
                                        if (!bl3) break block24;
                                        object5 = new FileInputStream((File)object3);
                                        object2 = new ObjectInputStream((InputStream)object5);
                                        try {
                                            try {
                                                object5 = ((ObjectInputStream)object2).readObject();
                                                object5 = (Map)object5;
                                            }
                                            catch (ClassNotFoundException classNotFoundException) {
                                                bl3 = false;
                                                object5 = null;
                                                break block18;
                                            }
                                            try {
                                                ((File)object3).delete();
                                                break block19;
                                            }
                                            catch (ClassNotFoundException classNotFoundException) {
                                            }
                                        }
                                        catch (Throwable throwable2) {
                                            break block20;
                                        }
                                    }
                                    OSSLog.logThrowable2Local((Throwable)object);
                                }
                                ((ObjectInputStream)object2).close();
                                ((File)object3).delete();
                                break block25;
                            }
                            ((ObjectInputStream)object2).close();
                            ((File)object3).delete();
                            throw throwable2;
                        }
                        bl3 = false;
                        object5 = null;
                    }
                    bl2 = false;
                    object3 = null;
                    int n11 = 0;
                    object2 = null;
                    do {
                        int n12;
                        Object object6 = ((ResumableUploadRequest)this.mRequest).getBucketName();
                        String string2 = ((ResumableUploadRequest)this.mRequest).getObjectKey();
                        String string3 = this.mUploadId;
                        object = new ListPartsRequest((String)object6, string2, string3);
                        if (n11 > 0) {
                            object6 = n11;
                            ((ListPartsRequest)object).setPartNumberMarker((Integer)object6);
                        }
                        object6 = this.mApiOperation;
                        object = ((InternalRequestOperation)object6).listParts((ListPartsRequest)object, null);
                        try {
                            int n13;
                            object6 = ((OSSAsyncTask)object).getResult();
                            object6 = (ListPartsResult)object6;
                            n10 = (int)(((ListPartsResult)object6).isTruncated() ? 1 : 0);
                            n11 = ((ListPartsResult)object6).getNextPartNumberMarker();
                            object6 = ((ListPartsResult)object6).getParts();
                            string3 = null;
                            for (n12 = 0; n12 < (n13 = object6.size()); ++n12) {
                                long l11;
                                Object object7;
                                Object object8 = object6.get(n12);
                                object8 = (PartSummary)object8;
                                int n14 = ((PartSummary)object8).getPartNumber();
                                String string4 = ((PartSummary)object8).getETag();
                                Object object9 = new PartETag(n14, string4);
                                long l12 = ((PartSummary)object8).getSize();
                                ((PartETag)object9).setPartSize(l12);
                                if (object5 != null && (n14 = object5.size()) > 0) {
                                    n14 = ((PartETag)object9).getPartNumber();
                                    object7 = n14;
                                    if ((n14 = (int)(object5.containsKey(object7) ? 1 : 0)) != 0) {
                                        n14 = ((PartETag)object9).getPartNumber();
                                        object7 = n14;
                                        object7 = object5.get(object7);
                                        object7 = (Long)object7;
                                        l12 = (Long)object7;
                                        ((PartETag)object9).setCRC64(l12);
                                    }
                                }
                                object7 = this.mPartETags;
                                object7.add(object9);
                                long l13 = this.mUploadedLength;
                                long l14 = ((PartSummary)object8).getSize();
                                this.mUploadedLength = l13 += l14;
                                object9 = this.mAlreadyUploadIndex;
                                n14 = ((PartSummary)object8).getPartNumber();
                                object7 = n14;
                                object9.add(object7);
                                if (n12 != 0) continue;
                                this.mFirstPartSize = l11 = ((PartSummary)object8).getSize();
                            }
                        }
                        catch (ClientException clientException) {
                            throw clientException;
                        }
                        catch (ServiceException serviceException2) {
                            n10 = serviceException2.getStatusCode();
                            n12 = 404;
                            if (n10 != n12) break block21;
                            this.mUploadId = null;
                            n10 = 0;
                            string2 = null;
                        }
                        ((OSSAsyncTask)object).waitUntilFinished();
                    } while (n10 != 0);
                    break block23;
                }
                throw serviceException2;
            }
            if (!(bl3 = ((File)(object5 = this.mRecordFile)).exists()) && !(bl3 = ((File)(object5 = this.mRecordFile)).createNewFile())) {
                object4 = new StringBuilder();
                ((StringBuilder)object4).append("Can't create file at path: ");
                object3 = this.mRecordFile.getAbsolutePath();
                ((StringBuilder)object4).append((String)object3);
                ((StringBuilder)object4).append("\nPlease make sure the directory exist!");
                object4 = ((StringBuilder)object4).toString();
                object5 = new ClientException((String)object4);
                throw object5;
            }
        }
        if (bl3 = OSSUtils.isEmptyString((String)(object5 = this.mUploadId))) {
            object3 = ((ResumableUploadRequest)this.mRequest).getBucketName();
            object2 = ((ResumableUploadRequest)this.mRequest).getObjectKey();
            object = ((ResumableUploadRequest)this.mRequest).getMetadata();
            object5 = new InitiateMultipartUploadRequest((String)object3, (String)object2, (ObjectMetadata)object);
            ((InitiateMultipartUploadRequest)object5).isSequential = bl2 = true;
            object3 = this.mApiOperation;
            this.mUploadId = object5 = ((InitiateMultipartUploadResult)((InternalRequestOperation)object3).initMultipartUpload((InitiateMultipartUploadRequest)object5, null).getResult()).getUploadId();
            object5 = this.mRecordFile;
            if (object5 != null) {
                object3 = this.mRecordFile;
                object4 = new FileWriter((File)object3);
                object5 = new BufferedWriter((Writer)object4);
                object4 = this.mUploadId;
                ((Writer)object5).write((String)object4);
                ((BufferedWriter)object5).close();
            }
        }
        object5 = (ResumableUploadRequest)this.mRequest;
        object4 = this.mUploadId;
        ((MultipartUploadRequest)object5).setUploadId((String)object4);
    }

    public void processException(Exception object) {
        String string2;
        boolean bl2;
        Object object2 = this.mUploadException;
        if (object2 == null || !(bl2 = ((String)(object2 = ((Throwable)object).getMessage())).equals(string2 = this.mUploadException.getMessage()))) {
            this.mUploadException = object;
        }
        OSSLog.logThrowable2Local((Throwable)object);
        object = this.mContext.getCancellationHandler();
        boolean bl3 = ((CancellationHandler)object).isCancelled();
        if (bl3 && !(bl3 = this.mIsCancel)) {
            this.mIsCancel = bl3 = true;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void uploadPart(int var1_1, int var2_2, int var3_3) {
        block27: {
            block28: {
                var4_4 = null;
                var5_5 = this.mContext;
                var5_5 = var5_5.getCancellationHandler();
                var6_6 = var5_5.isCancelled();
                if (var6_6 != 0) {
                    return;
                }
                this.mRunPartTaskCount = var6_6 = this.mRunPartTaskCount + 1;
                this.preUploadPart(var1_1, var2_2, var3_3);
                var5_5 = this.mUploadFile;
                var8_8 = "r";
                var7_7 = new RandomAccessFile((File)var5_5, (String)var8_8);
                ** try [egrp 1[TRYBLOCK] [28, 29 : 75->166)] { 
lbl14:
                // 1 sources

                break block28;
lbl15:
                // 1 sources

                catch (Throwable var14_21) {
                    var4_4 = var7_7;
                    break block27;
                }
                catch (Throwable var14_17) {
                    break block27;
                }
                catch (Exception var14_18) {
                    // empty catch block
                    ** GOTO lbl-1000
                }
                catch (ServiceException var14_20) {
                    var3_3 = 0;
                    var7_7 = null;
                    ** GOTO lbl-1000
                }
            }
            try {
                var8_8 = this.mRequest;
                var8_8 = (ResumableUploadRequest)var8_8;
                var8_8 = var8_8.getBucketName();
                var9_9 = this.mRequest;
                var9_9 = (ResumableUploadRequest)var9_9;
                var9_9 = var9_9.getObjectKey();
                var10_10 = this.mUploadId;
                var11_11 = var1_1 + 1;
                var5_5 = new UploadPartRequest((String)var8_8, (String)var9_9, var10_10, var11_11);
            }
            catch (ServiceException var14_16) {
                ** GOTO lbl-1000
            }
            var12_12 = var1_1;
            try {
                var14_13 = this.mRequest;
                var14_13 = (ResumableUploadRequest)var14_13;
                var15_23 = var14_13.getPartSize();
            }
            catch (ServiceException var14_14) {
                var4_4 = var5_5;
                ** GOTO lbl-1000
            }
            var14_13 = new byte[var2_2];
            var7_7.seek(var12_12 *= var15_23);
            var4_4 = null;
            var7_7.readFully((byte[])var14_13, 0, var2_2);
            var5_5.setPartContent((byte[])var14_13);
            var14_13 = BinaryUtil.calculateBase64Md5((byte[])var14_13);
            var5_5.setMd5Digest((String)var14_13);
            var14_13 = this.mRequest;
            var14_13 = (ResumableUploadRequest)var14_13;
            var14_13 = var14_13.getCRC64();
            var5_5.setCRC64((Enum)var14_13);
            var14_13 = this.mApiOperation;
            var14_13 = var14_13.syncUploadPart((UploadPartRequest)var5_5);
            var17_24 = var5_5.getPartNumber();
            var9_9 = var14_13.getETag();
            var4_4 = new PartETag(var17_24, (String)var9_9);
            var12_12 = var2_2;
            var4_4.setPartSize(var12_12);
            var18_25 = this.mCheckCRC64;
            if (var18_25) {
                var14_13 = var14_13.getClientCRC();
                var15_23 = var14_13.longValue();
                var4_4.setCRC64(var15_23);
            }
            var14_13 = this.mPartETags;
            var14_13.add(var4_4);
            this.mUploadedLength = var15_23 = this.mUploadedLength + var12_12;
            this.uploadPartFinish((PartETag)var4_4);
            var14_13 = this.mContext;
            var14_13 = var14_13.getCancellationHandler();
            var1_1 = (int)var14_13.isCancelled();
            if (var1_1 == 0) {
                var9_9 = this.mRequest;
                var15_23 = this.mUploadedLength;
                var19_26 = this.mFileLength;
                var8_8 = this;
                this.onProgressCallback((MultipartUploadRequest)var9_9, var15_23, var19_26);
                {
                    var7_7.close();
                    return;
                }
            }
            try {
                var4_4 = "sequence upload task cancel";
                var14_13 = new TaskCancelException((String)var4_4);
                var8_8 = var14_13.getMessage();
                var9_9 = Boolean.TRUE;
                var4_4 = new ClientException((String)var8_8, (Throwable)var14_13, (Boolean)var9_9);
                throw var4_4;
            }
lbl96:
            // 2 sources

            catch (Exception var14_15) {
                var4_4 = var7_7;
            }
lbl-1000:
            // 2 sources

            {
                this.processException((Exception)var14_13);
                if (var4_4 == null) return;
            }
            {
                var4_4.close();
                return;
            }
lbl-1000:
            // 3 sources

            {
                var6_6 = var14_13.getStatusCode();
                var17_24 = 409;
                if (var6_6 != var17_24) {
                    this.processException((Exception)var14_13);
                } else {
                    var17_24 = var4_4.getPartNumber();
                    var14_13 = var14_13.getPartEtag();
                    var5_5 = new PartETag(var17_24, (String)var14_13);
                    var14_13 = var4_4.getPartContent();
                    var1_1 = ((Object)var14_13).length;
                    var12_12 = var1_1;
                    var5_5.setPartSize(var12_12);
                    var1_1 = (int)this.mCheckCRC64;
                    if (var1_1 != 0) {
                        var14_13 = var4_4.getPartContent();
                        var4_4 = new ByteArrayInputStream((byte[])var14_13);
                        var8_8 = new CRC64();
                        var14_13 = new CheckedInputStream((InputStream)var4_4, (Checksum)var8_8);
                        var14_13 = var14_13.getChecksum();
                        var12_12 = var14_13.getValue();
                        var5_5.setCRC64(var12_12);
                    }
                    var14_13 = this.mPartETags;
                    var14_13.add(var5_5);
                    var21_27 = this.mUploadedLength;
                    var23_28 = var2_2;
                    this.mUploadedLength = var21_27 += var23_28;
                }
                if (var7_7 == null) return;
            }
            {
                var7_7.close();
                return;
            }
        }
        if (var4_4 == null) throw var14_22;
        try {
            var4_4.close();
            throw var14_22;
        }
        catch (IOException var25_29) {
            OSSLog.logThrowable2Local(var25_29);
        }
        throw var14_22;
    }

    public void uploadPartFinish(PartETag object) {
        String string2;
        object = this.mContext.getCancellationHandler();
        boolean bl2 = ((CancellationHandler)object).isCancelled();
        if (bl2 && !(bl2 = ((OSSSharedPreferences)(object = this.mSp)).contains(string2 = this.mUploadId))) {
            object = this.mSp;
            string2 = this.mUploadId;
            long l10 = this.mUploadedLength;
            String string3 = String.valueOf(l10);
            ((OSSSharedPreferences)object).setStringValue(string2, string3);
            MultipartUploadRequest multipartUploadRequest = this.mRequest;
            long l11 = this.mUploadedLength;
            long l12 = this.mFileLength;
            this.onProgressCallback(multipartUploadRequest, l11, l12);
        }
    }
}

