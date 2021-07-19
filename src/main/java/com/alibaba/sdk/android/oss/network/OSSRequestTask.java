/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.alibaba.sdk.android.oss.common.utils.CRC64
 */
package com.alibaba.sdk.android.oss.network;

import android.content.Context;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.CRC64;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.internal.OSSRetryHandler;
import com.alibaba.sdk.android.oss.internal.OSSRetryType;
import com.alibaba.sdk.android.oss.internal.RequestMessage;
import com.alibaba.sdk.android.oss.internal.ResponseMessage;
import com.alibaba.sdk.android.oss.internal.ResponseParser;
import com.alibaba.sdk.android.oss.internal.ResponseParsers;
import com.alibaba.sdk.android.oss.model.GetObjectRequest;
import com.alibaba.sdk.android.oss.model.ListBucketsRequest;
import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.network.ExecutionContext;
import com.alibaba.sdk.android.oss.network.NetworkProgressHelper;
import com.alibaba.sdk.android.oss.network.OSSRequestTask$1;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import g.a0;
import g.a0$a;
import g.b0;
import g.c0;
import g.e;
import g.s;
import g.v;
import g.z;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.CheckedInputStream;
import java.util.zip.Checksum;

public class OSSRequestTask
implements Callable {
    private z client;
    private ExecutionContext context;
    private int currentRetryCount = 0;
    private RequestMessage message;
    private ResponseParser responseParser;
    private OSSRetryHandler retryHandler;

    public OSSRequestTask(RequestMessage object, ResponseParser responseParser, ExecutionContext executionContext, int n10) {
        this.responseParser = responseParser;
        this.message = object;
        this.context = executionContext;
        this.client = object = executionContext.getClient();
        this.retryHandler = object = new OSSRetryHandler(n10);
    }

    private ResponseMessage buildResponseMessage(RequestMessage object, c0 c02) {
        int n10;
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setRequest((RequestMessage)object);
        responseMessage.setResponse(c02);
        object = new HashMap();
        s s10 = c02.C0();
        for (int i10 = 0; i10 < (n10 = s10.size()); ++i10) {
            String string2 = s10.h(i10);
            String string3 = s10.n(i10);
            object.put(string2, string3);
        }
        responseMessage.setHeaders((Map)object);
        int n11 = c02.v0();
        responseMessage.setStatusCode(n11);
        long l10 = c02.r0().contentLength();
        responseMessage.setContentLength(l10);
        object = c02.r0().byteStream();
        responseMessage.setContent((InputStream)object);
        return responseMessage;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public OSSResult call() {
        block47: {
            block46: {
                var1_1 = "\n";
                var2_6 = 1;
                var3_7 = null;
                try {
                    var4_8 = this.context;
                    var4_8 = var4_8.getApplicationContext();
                    if (var4_8 != null) {
                        var4_8 = this.context;
                        var4_8 = var4_8.getApplicationContext();
                        var4_8 = OSSUtils.buildBaseLogInfo((Context)var4_8);
                        OSSLog.logInfo((String)var4_8);
                    }
                    var4_8 = "[call] - ";
                    OSSLog.logDebug((String)var4_8);
                    var4_8 = this.context;
                    var4_8 = var4_8.getRequest();
                    var5_9 /* !! */  = this.message;
                    OSSUtils.ensureRequestValid((OSSRequest)var4_8, (RequestMessage)var5_9 /* !! */ );
                    var5_9 /* !! */  = this.message;
                    OSSUtils.signRequest((RequestMessage)var5_9 /* !! */ );
                    var5_9 /* !! */  = this.context;
                    var5_9 /* !! */  = var5_9 /* !! */ .getCancellationHandler();
                    var6_11 = var5_9 /* !! */ .isCancelled();
                    if (var6_11 == 0) {
                        var5_9 /* !! */  = new a0$a();
                    }
                    ** GOTO lbl-1000
                }
                catch (Exception var1_4) {
                    var21_24 = false;
                    var4_8 = null;
                    var6_11 = 0;
                    var5_9 /* !! */  = null;
                    break block46;
                }
                var7_12 = (int)(var4_8 instanceof ListBucketsRequest);
                if (var7_12 == false) ** GOTO lbl38
                {
                    block51: {
                        block49: {
                            block50: {
                                block48: {
                                    var8_13 = this.message;
                                    var8_13 = var8_13.buildOSSServiceURL();
                                    break block48;
lbl38:
                                    // 1 sources

                                    var8_13 = this.message;
                                    var8_13 = var8_13.buildCanonicalURL();
                                }
                                var5_9 /* !! */  = var5_9 /* !! */ .B((String)var8_13);
                                var8_13 = this.message;
                                var8_13 = var8_13.getHeaders();
                                var8_13 = var8_13.keySet();
                                var8_13 = var8_13.iterator();
                                while ((var9_14 /* !! */  = (int)var8_13.hasNext()) != 0) {
                                    var10_15 = var8_13.next();
                                    var10_15 = (String)var10_15;
                                    var11_16 = this.message;
                                    var11_16 = var11_16.getHeaders();
                                    var11_16 = var11_16.get(var10_15);
                                    var11_16 = (String)var11_16;
                                    var5_9 /* !! */  = var5_9 /* !! */ .a((String)var10_15, (String)var11_16);
                                }
                                var8_13 = this.message;
                                var8_13 = var8_13.getHeaders();
                                var10_15 = "Content-Type";
                                var8_13 = var8_13.get(var10_15);
                                var8_13 = (String)var8_13;
                                var10_15 = new StringBuilder();
                                var11_16 = "request method = ";
                                var10_15.append((String)var11_16);
                                var11_16 = this.message;
                                var11_16 = var11_16.getMethod();
                                var10_15.append(var11_16);
                                var10_15 = var10_15.toString();
                                OSSLog.logDebug((String)var10_15);
                                var10_15 = OSSRequestTask$1.$SwitchMap$com$alibaba$sdk$android$oss$common$HttpMethod;
                                var11_16 = this.message;
                                var11_16 = var11_16.getMethod();
                                var12_17 = var11_16.ordinal();
                                var9_14 /* !! */  = (int)var10_15[var12_17];
                                var12_17 = 0;
                                var11_16 = null;
                                if (var9_14 /* !! */  == var2_6 || var9_14 /* !! */  == (var13_18 = 2 != 0)) break block49;
                                var7_12 = 3 != 0;
                                if (var9_14 /* !! */  == var7_12) break block50;
                                var7_12 = 4;
                                if (var9_14 /* !! */  != var7_12) {
                                    var7_12 = 5;
                                    if (var9_14 /* !! */  == var7_12) {
                                        var5_9 /* !! */  = var5_9 /* !! */ .d();
                                    }
                                    break block51;
                                } else {
                                    var5_9 /* !! */  = var5_9 /* !! */ .m();
                                }
                                break block51;
                            }
                            var5_9 /* !! */  = var5_9 /* !! */ .g();
                            break block51;
                        }
                        if (var8_13 != null) {
                            var9_14 /* !! */  = var2_6;
                        } else {
                            var9_14 /* !! */  = false;
                            var10_15 = null;
                        }
                        var14_19 = "Content type can't be null when upload!";
                        OSSUtils.assertTrue((boolean)var9_14 /* !! */ , (String)var14_19);
                        var10_15 = this.message;
                        var10_15 = var10_15.getUploadData();
                        var15_20 = 0L;
                        if (var10_15 != null) {
                            var14_19 = this.message;
                            var14_19 = var14_19.getUploadData();
                            var10_15 = new ByteArrayInputStream((byte[])var14_19);
                            var14_19 = this.message;
                            var14_19 = var14_19.getUploadData();
                            var13_18 = ((Object)var14_19).length;
                            var15_20 = var13_18;
lbl110:
                            // 2 sources

                            while (true) {
                                var17_21 = var15_20;
                                var13_18 = 0;
                                var14_19 = null;
                                break;
                            }
                        } else {
                            var10_15 = this.message;
                            if ((var10_15 = var10_15.getUploadFilePath()) != null) {
                                var19_22 = this.message;
                                var19_22 = var19_22.getUploadFilePath();
                                var10_15 = new File((String)var19_22);
                                var19_22 = new FileInputStream((File)var10_15);
                                var17_21 = var10_15.length();
                                cfr_temp_0 = var17_21 - var15_20;
                                var9_14 /* !! */  = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                                if (var9_14 /* !! */  <= 0) {
                                    var4_8 = "the length of file is 0!";
                                    var1_1 = new ClientException((String)var4_8);
                                    throw var1_1;
                                }
                                var13_18 = 0;
                                var14_19 = null;
                                var10_15 = var19_22;
                            } else {
                                var10_15 = this.message;
                                if ((var10_15 = var10_15.getContent()) != null) {
                                    var10_15 = this.message;
                                    var10_15 = var10_15.getContent();
                                    var14_19 = this.message;
                                    var15_20 = var14_19.getContentLength();
                                    ** continue;
                                }
                                var10_15 = this.message;
                                var10_15 = var10_15.getStringBody();
                                var17_21 = var15_20;
                                var14_19 = var10_15;
                                var9_14 /* !! */  = false;
                                var10_15 = null;
                            }
                        }
                        if (var10_15 != null) {
                            var14_19 = this.message;
                            var13_18 = (int)var14_19.isCheckCRC64();
                            if (var13_18 != 0) {
                                var20_23 = new CRC64();
                                var10_15 = var14_19 = new CheckedInputStream((InputStream)var10_15, (Checksum)var20_23);
                            }
                            var14_19 = this.message;
                            var14_19.setContent((InputStream)var10_15);
                            var14_19 = this.message;
                            var14_19.setContentLength(var17_21);
                            var14_19 = this.message;
                            var14_19 = var14_19.getMethod();
                            var14_19 = var14_19.toString();
                            var20_23 = this.context;
                            var8_13 = NetworkProgressHelper.addProgressRequestBody((InputStream)var10_15, var17_21, (String)var8_13, (ExecutionContext)var20_23);
                            var5_9 /* !! */  = var5_9 /* !! */ .p((String)var14_19, (b0)var8_13);
                        } else if (var14_19 != null) {
                            var10_15 = this.message;
                            var10_15 = var10_15.getMethod();
                            var10_15 = var10_15.toString();
                            var8_13 = v.j((String)var8_13);
                            var20_23 = "UTF-8";
                            var14_19 = var14_19.getBytes((String)var20_23);
                            var8_13 = b0.create((v)var8_13, (byte[])var14_19);
                            var5_9 /* !! */  = var5_9 /* !! */ .p((String)var10_15, (b0)var8_13);
                        } else {
                            var8_13 = this.message;
                            var8_13 = var8_13.getMethod();
                            var8_13 = var8_13.toString();
                            var10_15 = new byte[0];
                            var10_15 = b0.create(null, (byte[])var10_15);
                            var5_9 /* !! */  = var5_9 /* !! */ .p((String)var8_13, (b0)var10_15);
                        }
                    }
                    var5_9 /* !! */  = var5_9 /* !! */ .b();
                }
                var21_24 = var4_8 instanceof GetObjectRequest;
                if (!var21_24) ** GOTO lbl188
                try {
                    var4_8 = this.client;
                    var8_13 = this.context;
                    this.client = var4_8 = NetworkProgressHelper.addProgressResponseListener((z)var4_8, (ExecutionContext)var8_13);
                    var4_8 = "getObject";
                    OSSLog.logDebug((String)var4_8);
lbl188:
                    // 2 sources

                    var4_8 = this.client;
                    var4_8 = var4_8.a((a0)var5_9 /* !! */ );
                }
                catch (Exception var1_3) {
                    var21_24 = false;
                    var4_8 = null;
                    break block46;
                }
                try {
                    var8_13 = this.context;
                    var8_13 = var8_13.getCancellationHandler();
                    var8_13.setCall((e)var4_8);
                    var8_13 = FirebasePerfOkHttpClient.execute((e)var4_8);
                    var9_14 /* !! */  = OSSLog.isEnableLog();
                    if (var9_14 /* !! */  != 0) {
                        var10_15 = var8_13.C0();
                        var10_15 = var10_15.m();
                        var14_19 = new StringBuilder();
                        var20_23 = "response:---------------------\n";
                        var14_19.append((String)var20_23);
                        var20_23 = new StringBuilder();
                        var19_22 = "response code: ";
                        var20_23.append((String)var19_22);
                        var22_25 = var8_13.v0();
                        var20_23.append(var22_25);
                        var19_22 = " for url: ";
                        var20_23.append((String)var19_22);
                        var19_22 = var5_9 /* !! */ .q();
                        var20_23.append(var19_22);
                        var20_23.append((String)var1_1);
                        var20_23 = var20_23.toString();
                        var14_19.append((String)var20_23);
                        var20_23 = var10_15.keySet();
                        var20_23 = var20_23.iterator();
                        while ((var22_25 = (int)var20_23.hasNext()) != 0) {
                            var19_22 = var20_23.next();
                            var19_22 = (String)var19_22;
                            var23_26 = new StringBuilder();
                            var24_27 = "responseHeader [";
                            var23_26.append(var24_27);
                            var23_26.append((String)var19_22);
                            var24_27 = "]: ";
                            var23_26.append(var24_27);
                            var23_26 = var23_26.toString();
                            var14_19.append((String)var23_26);
                            var23_26 = new StringBuilder();
                            var19_22 = var10_15.get(var19_22);
                            var19_22 = (List)var19_22;
                            var19_22 = var19_22.get(0);
                            var19_22 = (String)var19_22;
                            var23_26.append((String)var19_22);
                            var23_26.append((String)var1_1);
                            var19_22 = var23_26.toString();
                            var14_19.append((String)var19_22);
                        }
                        var1_1 = var14_19.toString();
                        OSSLog.logDebug((String)var1_1);
                    }
                    var1_1 = this.message;
                    var1_1 = this.buildResponseMessage((RequestMessage)var1_1, (c0)var8_13);
                    var7_12 = 0;
                    var8_13 = null;
                    break block47;
                }
                catch (Exception var1_2) {
                    break block46;
                }
lbl-1000:
                // 1 sources

                {
                    var4_8 = "This task is cancelled!";
                    var1_1 = new InterruptedIOException((String)var4_8);
                    throw var1_1;
                }
            }
            var8_13 = new StringBuilder();
            var8_13.append("Encounter local execpiton: ");
            var10_15 = var1_1.toString();
            var8_13.append((String)var10_15);
            var8_13 = var8_13.toString();
            OSSLog.logError((String)var8_13);
            var7_12 = OSSLog.isEnableLog();
            if (var7_12 != 0) {
                var1_1.printStackTrace();
            }
            var10_15 = var1_1.getMessage();
            var8_13 = new ClientException((String)var10_15, (Throwable)var1_1);
            var25_28 = 0;
            var1_1 = null;
        }
        if (var8_13 == null && ((var9_14 /* !! */  = var1_1.getStatusCode()) == (var12_17 = 203) || (var9_14 /* !! */  = var1_1.getStatusCode()) >= (var12_17 = 300))) {
            var5_9 /* !! */  = var5_9 /* !! */ .m();
            var6_11 = var5_9 /* !! */ .equals("HEAD");
            var8_13 = ResponseParsers.parseResponseErrorXML((ResponseMessage)var1_1, (boolean)var6_11);
        } else if (var8_13 == null) {
            try {
                var5_9 /* !! */  = this.responseParser;
                var5_9 /* !! */  = var5_9 /* !! */ .parse((ResponseMessage)var1_1);
                var8_13 = this.context;
                var8_13 = var8_13.getCompletedCallback();
                if (var8_13 == null) return var5_9 /* !! */ ;
                var8_13 = this.context;
                var8_13 = var8_13.getCompletedCallback();
                var10_15 = this.context;
                var10_15 = var10_15.getRequest();
                var8_13.onSuccess((OSSRequest)var10_15, (OSSResult)var5_9 /* !! */ );
                return var5_9 /* !! */ ;
            }
            catch (IOException var5_10) {
                var10_15 = var5_10.getMessage();
                var8_13 = new ClientException((String)var10_15, var5_10);
            }
        }
        if (var4_8 != null && (var21_24 = var4_8.isCanceled()) || (var21_24 = (var4_8 = this.context.getCancellationHandler()).isCancelled())) {
            var5_9 /* !! */  = var8_13.getCause();
            var8_13 = Boolean.TRUE;
            var10_15 = "Task is cancelled!";
            var8_13 = var4_8 = new ClientException((String)var10_15, (Throwable)var5_9 /* !! */ , (Boolean)var8_13);
        }
        var4_8 = this.retryHandler;
        var6_11 = this.currentRetryCount;
        var4_8 = var4_8.shouldRetry((Exception)var8_13, var6_11);
        var5_9 /* !! */  = new StringBuilder();
        var10_15 = "[run] - retry, retry type: ";
        var5_9 /* !! */ .append((String)var10_15);
        var5_9 /* !! */ .append(var4_8);
        OSSLog.logError(var5_9 /* !! */ .toString());
        var5_9 /* !! */  = OSSRetryType.OSSRetryTypeShouldRetry;
        if (var4_8 == var5_9 /* !! */ ) {
            this.currentRetryCount = var25_28 = this.currentRetryCount + var2_6;
            var1_1 = this.context.getRetryCallback();
            if (var1_1 != null) {
                var1_1 = this.context.getRetryCallback();
                var1_1.onRetryCallback();
            }
            try {
                var1_1 = this.retryHandler;
                var2_6 = this.currentRetryCount;
                var26_29 = var1_1.timeInterval(var2_6, (OSSRetryType)var4_8);
                Thread.sleep(var26_29);
                return this.call();
            }
            catch (InterruptedException var1_5) {
                var28_30 = Thread.currentThread();
                var28_30.interrupt();
                var1_5.printStackTrace();
            }
            return this.call();
        }
        var5_9 /* !! */  = OSSRetryType.OSSRetryTypeShouldFixedTimeSkewedAndRetry;
        if (var4_8 == var5_9 /* !! */ ) {
            if (var1_1 != null) {
                var1_1 = var1_1.getHeaders();
                var3_7 = "Date";
                var1_1 = (String)var1_1.get(var3_7);
                try {
                    var4_8 = DateUtil.parseRfc822Date((String)var1_1);
                    var29_33 = var4_8.getTime();
                    DateUtil.setCurrentServerTime(var29_33);
                    var4_8 = this.message;
                    var4_8 = var4_8.getHeaders();
                    var4_8.put(var3_7, var1_1);
                }
                catch (Exception v0) {
                    var3_7 = new StringBuilder();
                    var4_8 = "[error] - synchronize time, reponseDate:";
                    var3_7.append((String)var4_8);
                    var3_7.append((String)var1_1);
                    var1_1 = var3_7.toString();
                    OSSLog.logError((String)var1_1);
                }
            }
            this.currentRetryCount = var25_28 = this.currentRetryCount + var2_6;
            var1_1 = this.context.getRetryCallback();
            if (var1_1 == null) return this.call();
            var1_1 = this.context.getRetryCallback();
            var1_1.onRetryCallback();
            return this.call();
        }
        var25_28 = var8_13 instanceof ClientException;
        if (var25_28 != 0) {
            var1_1 = this.context.getCompletedCallback();
            if (var1_1 == null) throw (Throwable)var8_13;
            var1_1 = this.context.getCompletedCallback();
            var28_31 = this.context.getRequest();
            var4_8 = var8_13;
            var4_8 = (ClientException)var8_13;
            var1_1.onFailure(var28_31, (ClientException)var4_8, null);
            throw (Throwable)var8_13;
        }
        var1_1 = this.context.getCompletedCallback();
        if (var1_1 == null) throw (Throwable)var8_13;
        var1_1 = this.context.getCompletedCallback();
        var28_32 = this.context.getRequest();
        var4_8 = var8_13;
        var4_8 = (ServiceException)var8_13;
        var1_1.onFailure(var28_32, null, (ServiceException)var4_8);
        throw (Throwable)var8_13;
    }
}

