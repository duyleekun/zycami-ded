/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask;
import com.alibaba.sdk.android.oss.internal.InternalRequestOperation;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.internal.ResumableUploadTask$1;
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
import com.alibaba.sdk.android.oss.network.CancellationHandler;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;

public class ResumableUploadTask
extends BaseMultipartUploadTask
implements Callable {
    private List mAlreadyUploadIndex;
    private File mCRC64RecordFile;
    private File mRecordFile;
    private OSSSharedPreferences mSp;

    public ResumableUploadTask(ResumableUploadRequest object, OSSCompletedCallback oSSCompletedCallback, ExecutionContext executionContext, InternalRequestOperation internalRequestOperation) {
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
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ResumableUploadResult doMultipartUpload() {
        Object object;
        Object object2;
        Object object3;
        long l10 = this.mUploadedLength;
        this.checkCancel();
        int[] nArray = this.mPartAttr;
        int n10 = 0;
        int n11 = nArray[0];
        int n12 = nArray[1];
        Object object4 = this.mPartETags;
        int n13 = object4.size();
        if (n13 > 0 && (n13 = (object4 = this.mAlreadyUploadIndex).size()) > 0) {
            long l11 = this.mUploadedLength;
            long l12 = this.mFileLength;
            long l13 = l11 - l12;
            Object object5 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object5 > 0) {
                ClientException clientException = new ClientException("The uploading file is inconsistent with before");
                throw clientException;
            }
            Object object6 = this.mSp;
            Object object7 = this.mUploadId;
            object5 = TextUtils.isEmpty((CharSequence)(object6 = ((OSSSharedPreferences)object6).getStringValue((String)object7)));
            if (object5 == false) {
                object4 = this.mSp;
                object3 = this.mUploadId;
                object4 = Long.valueOf(((OSSSharedPreferences)object4).getStringValue((String)object3));
                l11 = (Long)object4;
            }
            if ((object6 = this.mProgressCallback) != null) {
                object7 = this.mRequest;
                long l14 = this.mFileLength;
                object6.onProgress(object7, l11, l14);
            }
            object4 = this.mSp;
            object3 = this.mUploadId;
            ((OSSSharedPreferences)object4).removeKey((String)object3);
        }
        object4 = this.mPartETags;
        this.mRunPartTaskCount = n13 = object4.size();
        while (n10 < n12) {
            int n14;
            object4 = this.mAlreadyUploadIndex;
            n13 = object4.size();
            if ((n13 == 0 || (n13 = (int)((object4 = this.mAlreadyUploadIndex).contains(object3 = Integer.valueOf(n14 = n10 + 1)) ? 1 : 0)) == 0) && (object4 = this.mPoolExecutor) != null) {
                long l15;
                n14 = n12 + -1;
                if (n10 == n14) {
                    l15 = this.mFileLength - l10;
                    n11 = (int)l15;
                }
                l15 = n11;
                l10 += l15;
                object3 = new ResumableUploadTask$1(this, n10, n11, n12);
                ((ThreadPoolExecutor)object4).execute((Runnable)object3);
            }
            ++n10;
        }
        boolean bl2 = this.checkWaitCondition(n12);
        if (bl2) {
            object2 = this.mLock;
            synchronized (object2) {
                object = this.mLock;
                object.wait();
            }
        }
        this.checkException();
        object2 = this.completeMultipartUploadResult();
        object = null;
        if (object2 != null) {
            object = new ResumableUploadResult((CompleteMultipartUploadResult)object2);
        }
        if ((object2 = this.mRecordFile) != null) {
            ((File)object2).delete();
        }
        if ((object2 = this.mCRC64RecordFile) != null) {
            ((File)object2).delete();
        }
        this.releasePool();
        return object;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void initMultipartUploadId() {
        block39: {
            block40: {
                block42: {
                    block41: {
                        block34: {
                            block33: {
                                block32: {
                                    var1_1 = this;
                                    var2_2 = "[initUploadId] -  ";
                                    var3_3 = ((ResumableUploadRequest)this.mRequest).getRecordDirectory();
                                    var4_12 = OSSUtils.isEmptyString((String)var3_3);
                                    var5_13 = 0;
                                    var6_14 = null;
                                    if (var4_12) break block39;
                                    var3_3 = new StringBuilder();
                                    var3_3.append("[initUploadId] - mUploadFilePath : ");
                                    var7_15 = this.mUploadFilePath;
                                    var3_3.append((String)var7_15);
                                    OSSLog.logDebug(var3_3.toString());
                                    var3_3 = BinaryUtil.calculateMd5Str(this.mUploadFilePath);
                                    var7_15 = new StringBuilder();
                                    var7_15.append("[initUploadId] - mRequest.getPartSize() : ");
                                    var8_16 = (ResumableUploadRequest)this.mRequest;
                                    var9_17 = var8_16.getPartSize();
                                    var7_15.append(var9_17);
                                    OSSLog.logDebug(var7_15.toString());
                                    var7_15 = new StringBuilder();
                                    var7_15.append((String)var3_3);
                                    var3_3 = ((ResumableUploadRequest)this.mRequest).getBucketName();
                                    var7_15.append((String)var3_3);
                                    var3_3 = ((ResumableUploadRequest)this.mRequest).getObjectKey();
                                    var7_15.append((String)var3_3);
                                    var9_17 = ((ResumableUploadRequest)this.mRequest).getPartSize();
                                    var3_3 = String.valueOf(var9_17);
                                    var7_15.append((String)var3_3);
                                    var4_12 = this.mCheckCRC64;
                                    var3_3 = var4_12 != false ? "-crc64" : "";
                                    var7_15.append((String)var3_3);
                                    var3_3 = BinaryUtil.calculateMd5Str(var7_15.toString().getBytes());
                                    var7_15 = new StringBuilder();
                                    var8_16 = ((ResumableUploadRequest)var1_1.mRequest).getRecordDirectory();
                                    var7_15.append((String)var8_16);
                                    var8_16 = File.separator;
                                    var7_15.append((String)var8_16);
                                    var7_15.append((String)var3_3);
                                    var3_3 = var7_15.toString();
                                    var1_1.mRecordFile = var7_15 = new File((String)var3_3);
                                    var4_12 = var7_15.exists();
                                    if (var4_12) {
                                        var11_18 = var1_1.mRecordFile;
                                        var7_15 = new FileReader((File)var11_18);
                                        var3_3 = new BufferedReader((Reader)var7_15);
                                        var1_1.mUploadId = var7_15 = var3_3.readLine();
                                        var3_3.close();
                                    }
                                    var3_3 = new StringBuilder();
                                    var3_3.append("[initUploadId] - mUploadId : ");
                                    var7_15 = var1_1.mUploadId;
                                    var3_3.append((String)var7_15);
                                    OSSLog.logDebug(var3_3.toString());
                                    var3_3 = var1_1.mUploadId;
                                    var4_12 = OSSUtils.isEmptyString((String)var3_3);
                                    if (var4_12) break block40;
                                    var4_12 = var1_1.mCheckCRC64;
                                    if (!var4_12) break block41;
                                    var3_3 = new StringBuilder();
                                    var7_15 = ((ResumableUploadRequest)var1_1.mRequest).getRecordDirectory();
                                    var3_3.append((String)var7_15);
                                    var3_3.append((String)var8_16);
                                    var7_15 = var1_1.mUploadId;
                                    var3_3.append((String)var7_15);
                                    var3_3 = var3_3.toString();
                                    var7_15 = new File((String)var3_3);
                                    var4_12 = var7_15.exists();
                                    if (!var4_12) break block41;
                                    var3_3 = new FileInputStream((File)var7_15);
                                    var8_16 = new ObjectInputStream((InputStream)var3_3);
                                    try {
                                        try {
                                            var11_18 = var3_3 = var8_16.readObject();
                                            var11_18 = (Map)var3_3;
                                        }
                                        catch (ClassNotFoundException var3_6) {
                                            var11_18 = null;
                                            break block32;
                                        }
                                        try {
                                            var7_15.delete();
                                            break block33;
                                        }
                                        catch (ClassNotFoundException var3_4) {
                                        }
                                    }
                                    catch (Throwable var3_5) {
                                        break block34;
                                    }
                                }
                                OSSLog.logThrowable2Local((Throwable)var3_3);
                            }
                            var8_16.close();
                            var7_15.delete();
                            break block42;
                        }
                        var8_16.close();
                        var7_15.delete();
                        throw var3_5;
                    }
                    var11_18 = null;
                }
                var12_19 = 0;
                var7_15 = null;
                var13_20 = 0;
                var8_16 = null;
                while (true) {
                    block45: {
                        block37: {
                            block35: {
                                block36: {
                                    block38: {
                                        var14_21 = ((ResumableUploadRequest)var1_1.mRequest).getBucketName();
                                        var15_22 = ((ResumableUploadRequest)var1_1.mRequest).getObjectKey();
                                        var16_23 = var1_1.mUploadId;
                                        var3_3 = new ListPartsRequest((String)var14_21, var15_22, (String)var16_23);
                                        if (var13_20 > 0) {
                                            var14_21 = var13_20;
                                            var3_3.setPartNumberMarker((Integer)var14_21);
                                        }
                                        var14_21 = var1_1.mApiOperation.listParts((ListPartsRequest)var3_3, null);
                                        try {
                                            var3_3 = var14_21.getResult();
                                            var3_3 = (ListPartsResult)var3_3;
                                            var17_24 = var3_3.isTruncated();
                                            var13_20 = var3_3.getNextPartNumberMarker();
                                        }
                                        catch (ServiceException var3_11) {
                                            var39_42 = var2_2;
                                            break block35;
                                        }
                                        try {
                                            var3_3 = var3_3.getParts();
                                            var16_23 = var1_1.mPartAttr;
                                            var18_25 = var16_23[0];
                                            var19_26 = 1;
                                            var20_27 = var16_23[var19_26];
                                            var21_28 = 0;
                                            var22_29 = null;
lbl148:
                                            // 2 sources

                                            while (var21_28 < (var23_30 = var3_3.size())) {
                                                var24_31 = var3_3.get(var21_28);
                                                var24_31 = (PartSummary)var24_31;
                                                var26_33 = var24_31.getPartNumber();
                                                var7_15 = var24_31.getETag();
                                                var25_32 = new PartETag(var26_33, (String)var7_15);
                                                var27_34 = var24_31.getSize();
                                                var25_32.setPartSize(var27_34);
                                                if (var11_18 == null) ** GOTO lbl-1000
                                                ** GOTO lbl-1000
                                            }
                                            break block36;
                                        }
                                        catch (ServiceException var3_10) {
                                            var39_42 = var2_2;
                                            var35_39 = var13_20;
                                            break block35;
                                        }
lbl-1000:
                                        // 1 sources

                                        {
                                            var5_13 = var11_18.size();
                                            if (var5_13 <= 0) ** GOTO lbl-1000
                                            var5_13 = var25_32.getPartNumber();
                                            var6_14 = var5_13;
                                            if ((var5_13 = (int)var11_18.containsKey(var6_14)) == 0) ** GOTO lbl-1000
                                            var5_13 = var25_32.getPartNumber();
                                            var6_14 = var5_13;
                                            var6_14 = var11_18.get(var6_14);
                                            var6_14 = (Long)var6_14;
                                            var27_34 = var6_14.longValue();
                                            var25_32.setCRC64(var27_34);
                                        }
lbl-1000:
                                        // 4 sources

                                        {
                                            var6_14 = new StringBuilder();
                                            var6_14.append((String)var2_2);
                                            var6_14.append(var21_28);
                                            var7_15 = " part.getPartNumber() : ";
                                            var6_14.append((String)var7_15);
                                            var12_19 = var24_31.getPartNumber();
                                            var6_14.append(var12_19);
                                            var6_14 = var6_14.toString();
                                            OSSLog.logDebug((String)var6_14);
                                            var6_14 = new StringBuilder();
                                            var6_14.append((String)var2_2);
                                            var6_14.append(var21_28);
                                            var7_15 = " part.getSize() : ";
                                            var6_14.append((String)var7_15);
                                            var29_35 = var21_28;
                                            var30_36 = var24_31.getSize();
                                            var6_14.append(var30_36);
                                            var6_14 = var6_14.toString();
                                            OSSLog.logDebug((String)var6_14);
                                            var5_13 = var24_31.getPartNumber();
                                            if (var5_13 == var20_27) {
                                                var5_13 = 1;
                                            } else {
                                                var5_13 = 0;
                                                var6_14 = null;
                                            }
                                            var32_37 = " or lastPartSize : ";
                                            var22_29 = " setting is inconsistent with PartSize : ";
                                            var7_15 = "current part size ";
                                            if (var5_13 == 0) ** GOTO lbl244
                                        }
                                        var33_38 = var24_31.getSize();
                                        var35_39 = var13_20;
                                        var36_40 = var11_18;
                                        {
                                            block43: {
                                                catch (ServiceException var3_7) {
                                                    var35_39 = var13_20;
                                                    var36_40 = var11_18;
                                                    var39_42 = var2_2;
                                                    break block37;
                                                }
                                                ** try [egrp 9[TRYBLOCK] [101 : 1111->1255)] { 
lbl222:
                                                // 1 sources

                                                var9_17 = var1_1.mLastPartSize;
                                                var13_20 = (int)(var33_38 == var9_17 ? 0 : (var33_38 < var9_17 ? -1 : 1));
                                                if (var13_20 != 0) {
                                                    var6_14 = new StringBuilder();
                                                    var6_14.append((String)var7_15);
                                                    var37_41 = var24_31.getSize();
                                                    var6_14.append(var37_41);
                                                    var6_14.append(var22_29);
                                                    var6_14.append((int)var18_25);
                                                    var6_14.append(var32_37);
                                                    var37_41 = var1_1.mLastPartSize;
                                                    var6_14.append(var37_41);
                                                    var6_14 = var6_14.toString();
                                                    var3_3 = new ClientException((String)var6_14);
                                                    throw var3_3;
                                                }
                                                break block43;
lbl244:
                                                // 1 sources

                                                var35_39 = var13_20;
                                                var36_40 = var11_18;
                                            }
                                            if (var5_13 == 0) {
                                                var9_17 = var24_31.getSize();
                                                var39_42 = var2_2;
                                            }
                                            ** GOTO lbl279
                                        }
lbl-1000:
                                        // 1 sources

                                        {
                                            block44: {
                                                catch (ServiceException var3_8) {
                                                    var39_42 = var2_2;
                                                    break block38;
                                                }
                                                var40_43 = (long)var18_25;
                                                cfr_temp_0 = var9_17 - var40_43;
                                                var42_44 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                                if (var42_44 != 0) {
                                                    ** try [egrp 10[TRYBLOCK] [133 : 1280->1437)] { 
lbl260:
                                                    // 1 sources

                                                    var2_2 = new StringBuilder();
                                                    var2_2.append((String)var7_15);
                                                    var27_34 = var24_31.getSize();
                                                    var2_2.append(var27_34);
                                                    var2_2.append(var22_29);
                                                    var2_2.append((int)var18_25);
                                                    var2_2.append(var32_37);
                                                    var27_34 = var1_1.mLastPartSize;
                                                    var2_2.append(var27_34);
                                                    var2_2 = var2_2.toString();
                                                    var3_3 = new ClientException((String)var2_2);
                                                    throw var3_3;
                                                }
                                                break block44;
lbl279:
                                                // 1 sources

                                                var39_42 = var2_2;
                                            }
                                            var2_2 = var1_1.mPartETags;
                                            var2_2.add(var25_32);
                                            var40_43 = var1_1.mUploadedLength;
                                            var37_41 = var24_31.getSize();
                                            var1_1.mUploadedLength = var40_43 += var37_41;
                                            var2_2 = var1_1.mAlreadyUploadIndex;
                                            var5_13 = var24_31.getPartNumber();
                                            var6_14 = var5_13;
                                            var2_2.add(var6_14);
                                            var21_28 = var29_35 + 1;
                                            var2_2 = var39_42;
                                            var11_18 = var36_40;
                                            var13_20 = var35_39;
                                            var5_13 = 0;
                                            var6_14 = null;
                                            var12_19 = 0;
                                            var7_15 = null;
                                            var19_26 = 1;
                                            ** GOTO lbl148
                                        }
lbl302:
                                        // 1 sources

                                        catch (ServiceException var3_9) {
                                            // empty catch block
                                        }
                                    }
                                    var13_20 = var35_39;
                                    break block37;
                                }
                                var39_42 = var2_2;
                                var35_39 = var13_20;
                                var36_40 = var11_18;
                                break block45;
                            }
                            var36_40 = var11_18;
                        }
                        var42_44 = var3_3.getStatusCode();
                        var5_13 = 404;
                        if (var42_44 != var5_13) {
                            throw var3_3;
                        }
                        var42_44 = 0;
                        var2_2 = null;
                        var1_1.mUploadId = null;
                        var17_24 = false;
                        var15_22 = null;
                    }
                    var14_21.waitUntilFinished();
                    if (!var17_24) break;
                    var2_2 = var39_42;
                    var11_18 = var36_40;
                    var5_13 = 0;
                    var6_14 = null;
                    var12_19 = 0;
                    var7_15 = null;
                }
            }
            if (!(var4_12 = (var3_3 = var1_1.mRecordFile).exists()) && !(var4_12 = (var3_3 = var1_1.mRecordFile).createNewFile())) {
                var2_2 = new StringBuilder();
                var2_2.append("Can't create file at path: ");
                var6_14 = var1_1.mRecordFile.getAbsolutePath();
                var2_2.append((String)var6_14);
                var2_2.append("\nPlease make sure the directory exist!");
                var2_2 = var2_2.toString();
                var3_3 = new ClientException((String)var2_2);
                throw var3_3;
            }
        }
        if (var4_12 = OSSUtils.isEmptyString((String)(var3_3 = var1_1.mUploadId))) {
            var2_2 = ((ResumableUploadRequest)var1_1.mRequest).getBucketName();
            var6_14 = ((ResumableUploadRequest)var1_1.mRequest).getObjectKey();
            var7_15 = ((ResumableUploadRequest)var1_1.mRequest).getMetadata();
            var3_3 = new InitiateMultipartUploadRequest((String)var2_2, (String)var6_14, (ObjectMetadata)var7_15);
            var2_2 = var1_1.mApiOperation;
            var5_13 = 0;
            var6_14 = null;
            var1_1.mUploadId = var3_3 = ((InitiateMultipartUploadResult)var2_2.initMultipartUpload((InitiateMultipartUploadRequest)var3_3, null).getResult()).getUploadId();
            var3_3 = var1_1.mRecordFile;
            if (var3_3 != null) {
                var6_14 = var1_1.mRecordFile;
                var2_2 = new FileWriter((File)var6_14);
                var3_3 = new BufferedWriter((Writer)var2_2);
                var2_2 = var1_1.mUploadId;
                var3_3.write((String)var2_2);
                var3_3.close();
            }
        }
        var3_3 = (ResumableUploadRequest)var1_1.mRequest;
        var2_2 = var1_1.mUploadId;
        var3_3.setUploadId((String)var2_2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void processException(Exception object) {
        Object object2 = this.mLock;
        synchronized (object2) {
            int n10 = this.mPartExceptionCount;
            int n11 = 1;
            this.mPartExceptionCount = n10 += n11;
            this.mUploadException = object;
            OSSLog.logThrowable2Local((Throwable)object);
            object = this.mContext;
            object = ((ExecutionContext)object).getCancellationHandler();
            int n12 = ((CancellationHandler)object).isCancelled();
            if (n12 != 0 && (n12 = this.mIsCancel) == 0) {
                this.mIsCancel = n11;
                object = this.mLock;
                object.notify();
            }
            object = this.mPartETags;
            n12 = object.size();
            n10 = this.mRunPartTaskCount;
            n11 = this.mPartExceptionCount;
            if (n12 == (n10 -= n11)) {
                this.notifyMultipartThread();
            }
            return;
        }
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

