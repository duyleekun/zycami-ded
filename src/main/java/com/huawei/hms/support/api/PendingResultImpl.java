/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.os.Looper
 *  android.text.TextUtils
 */
package com.huawei.hms.support.api;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.adapter.BaseAdapter$BaseRequestResultCallback;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl$a;
import com.huawei.hms.support.api.PendingResultImpl$b;
import com.huawei.hms.support.api.PendingResultImpl$c;
import com.huawei.hms.support.api.PendingResultImpl$d;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class PendingResultImpl
extends InnerPendingResult {
    private static final String TAG = "PendingResultImpl";
    private WeakReference api;
    private CountDownLatch countLatch;
    private boolean isNeedReport = true;
    private Result result = null;
    private String transId = null;
    public DatagramTransport transport = null;
    private String url = null;

    public PendingResultImpl(ApiClient apiClient, String string2, IMessageEntity iMessageEntity) {
        Class clazz = this.getResponseType();
        this.init(apiClient, string2, iMessageEntity, clazz, 0);
    }

    public PendingResultImpl(ApiClient apiClient, String string2, IMessageEntity iMessageEntity, int n10) {
        Class clazz = this.getResponseType();
        this.init(apiClient, string2, iMessageEntity, clazz, n10);
    }

    public PendingResultImpl(ApiClient apiClient, String string2, IMessageEntity iMessageEntity, Class clazz) {
        this.init(apiClient, string2, iMessageEntity, clazz, 0);
    }

    public static /* synthetic */ void access$000(PendingResultImpl pendingResultImpl, int n10, IMessageEntity iMessageEntity) {
        pendingResultImpl.setResult(n10, iMessageEntity);
    }

    public static /* synthetic */ CountDownLatch access$100(PendingResultImpl pendingResultImpl) {
        return pendingResultImpl.countLatch;
    }

    public static /* synthetic */ Result access$200(PendingResultImpl pendingResultImpl) {
        return pendingResultImpl.result;
    }

    private void biReportEvent(int n10, int n11) {
        Object object;
        boolean bl2;
        HashMap<String, Context> hashMap = "biReportEvent ====== ";
        HMSLog.i(TAG, (String)((Object)hashMap));
        Object object2 = (ApiClient)this.api.get();
        if (object2 != null && (hashMap = this.url) != null && !(bl2 = ((HiAnalyticsUtil)((Object)(hashMap = HiAnalyticsUtil.getInstance()))).hasError((Context)(object = object2.getContext())))) {
            Object object3;
            Object object4;
            hashMap = new HashMap<String, Context>();
            object = object2.getPackageName();
            hashMap.put("package", (Context)object);
            String string2 = "5.2.0.300";
            hashMap.put("baseVersion", (Context)string2);
            object = "direction";
            int n12 = 1;
            if (n11 == n12) {
                object4 = "req";
                hashMap.put((String)object, (Context)object4);
            } else {
                hashMap.put((String)object, (Context)"rsp");
                object4 = String.valueOf(n10);
                object3 = "result";
                hashMap.put((String)object3, (Context)object4);
                object4 = this.result;
                if (object4 != null && (object4 = ((Result)object4).getStatus()) != null) {
                    n10 = this.result.getStatus().getStatusCode();
                    object4 = String.valueOf(n10);
                    object3 = "statusCode";
                    hashMap.put((String)object3, (Context)object4);
                }
            }
            object3 = "0";
            hashMap.put("version", (Context)object3);
            object4 = Util.getAppId(object2.getContext());
            n11 = (int)(TextUtils.isEmpty((CharSequence)object4) ? 1 : 0);
            if (n11 != 0 && (object3 = object2.getSubAppInfo()) != null) {
                object4 = ((SubAppInfo)object3).getSubAppID();
            }
            hashMap.put("appid", (Context)object4);
            object3 = this.transId;
            n11 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
            object = "transId";
            if (n11 != 0) {
                object3 = this.url;
                this.transId = object4 = TransactionIdCreater.getId((String)object4, (String)object3);
                hashMap.put((String)object, (Context)object4);
            } else {
                object4 = this.transId;
                hashMap.put((String)object, (Context)object4);
                n10 = 0;
                object4 = null;
                this.transId = null;
            }
            object4 = this.url;
            object3 = "\\.";
            object4 = ((String)object4).split((String)object3);
            n11 = ((String[])object4).length;
            int n13 = 2;
            if (n11 >= n13) {
                n11 = 0;
                object3 = object4[0];
                object = "service";
                hashMap.put((String)object, (Context)object3);
                object4 = object4[n12];
                object3 = "apiName";
                hashMap.put((String)object3, (Context)object4);
            }
            long l10 = System.currentTimeMillis();
            object4 = String.valueOf(l10);
            hashMap.put("callTime", (Context)object4);
            object4 = Util.getSystemProperties("ro.logsystem.usertype", "");
            hashMap.put("phoneType", (Context)object4);
            object4 = HiAnalyticsUtil.getInstance();
            object3 = object2.getContext();
            object2 = "HMS_SDK_BASE_CALL_AIDL";
            ((HiAnalyticsUtil)object4).onEvent((Context)object3, (String)object2, hashMap);
        }
    }

    /*
     * WARNING - void declaration
     */
    private void init(ApiClient object, String object2, IMessageEntity object3, Class object4, int n10) {
        void var1_8;
        Object[] objectArray = new StringBuilder();
        objectArray.append("init uri:");
        objectArray.append((String)object2);
        objectArray = objectArray.toString();
        String string2 = TAG;
        HMSLog.i(string2, (String)objectArray);
        this.url = object2;
        if (object == null) {
            HMSLog.e(string2, "client is null");
            return;
        }
        objectArray = new WeakReference(object);
        this.api = objectArray;
        int n11 = 1;
        objectArray = new CountDownLatch(n11);
        this.countLatch = objectArray;
        object = object.getTransportName();
        object = Class.forName((String)object);
        int n12 = 4;
        Class[] classArray = new Class[n12];
        Class clazz = String.class;
        classArray[0] = clazz;
        clazz = IMessageEntity.class;
        classArray[n11] = clazz;
        clazz = Class.class;
        int n13 = 2;
        classArray[n13] = clazz;
        clazz = Integer.TYPE;
        int n14 = 3;
        classArray[n14] = clazz;
        object = ((Class)object).getConstructor(classArray);
        objectArray = new Object[n12];
        objectArray[0] = object2;
        objectArray[n11] = object3;
        objectArray[n13] = object4;
        object2 = n10;
        objectArray[n14] = object2;
        object = ((Constructor)object).newInstance(objectArray);
        object = (DatagramTransport)object;
        try {
            this.transport = object;
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
        }
        catch (NoSuchMethodException noSuchMethodException) {
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InstantiationException instantiationException) {
            // empty catch block
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("gen transport error:");
        object3 = var1_8.getMessage();
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        HMSLog.e(string2, (String)object2);
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Instancing transport exception, ");
        object4 = var1_8.getMessage();
        ((StringBuilder)object3).append((String)object4);
        object3 = ((StringBuilder)object3).toString();
        object2 = new IllegalStateException((String)object3, (Throwable)var1_8);
        throw object2;
    }

    private void setResult(int n10, IMessageEntity object) {
        Object object2;
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("setResult:");
        ((StringBuilder)object3).append(n10);
        object3 = ((StringBuilder)object3).toString();
        Object object4 = TAG;
        HMSLog.i((String)object4, (String)object3);
        boolean bl2 = object instanceof AbstractMessageEntity;
        if (bl2) {
            object3 = object;
            object3 = ((AbstractMessageEntity)object).getCommonStatus();
        } else {
            bl2 = false;
            object3 = null;
        }
        if (n10 == 0) {
            object = this.onComplete((IMessageEntity)object);
            this.result = object;
        } else {
            object = this.onError(n10);
            this.result = object;
        }
        int n11 = this.isNeedReport;
        if (n11 != 0) {
            n11 = 2;
            this.biReportEvent(n10, n11);
        }
        if ((object2 = this.result) != null && (object2 = ((Result)object2).getStatus()) != null && object3 != null) {
            n11 = ((Status)object2).getStatusCode();
            Object object5 = ((Status)object2).getStatusMessage();
            int n12 = ((Status)object3).getStatusCode();
            object3 = ((Status)object3).getStatusMessage();
            String string2 = ") is not equal commonStatus msg (";
            String string3 = "rstStatus msg (";
            String string4 = ")";
            if (n11 != n12) {
                object2 = new StringBuilder();
                String string5 = "rstStatus code (";
                ((StringBuilder)object2).append(string5);
                ((StringBuilder)object2).append(n11);
                object = ") is not equal commonStatus code (";
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(n12);
                ((StringBuilder)object2).append(string4);
                object2 = ((StringBuilder)object2).toString();
                HMSLog.e((String)object4, (String)object2);
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string3);
                ((StringBuilder)object2).append((String)object5);
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(string4);
                object2 = ((StringBuilder)object2).toString();
                HMSLog.e((String)object4, (String)object2);
            } else {
                n12 = (int)(TextUtils.isEmpty((CharSequence)object5) ? 1 : 0);
                if (n12 != 0 && (n12 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0)) == 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string3);
                    stringBuilder.append((String)object5);
                    stringBuilder.append(string2);
                    stringBuilder.append((String)object3);
                    stringBuilder.append(string4);
                    object5 = stringBuilder.toString();
                    HMSLog.i((String)object4, (String)object5);
                    object4 = this.result;
                    object2 = ((Status)object2).getResolution();
                    object5 = new Status(n11, (String)object3, (PendingIntent)object2);
                    ((Result)object4).setStatus((Status)object5);
                }
            }
        }
    }

    public final Result await() {
        Object object = TAG;
        HMSLog.i((String)object, "await");
        Looper looper = Looper.myLooper();
        Looper looper2 = Looper.getMainLooper();
        if (looper != looper2) {
            return this.awaitOnAnyThread();
        }
        HMSLog.e((String)object, "await in main thread");
        object = new IllegalStateException("await must not be called on the UI thread");
        throw object;
    }

    public Result await(long l10, TimeUnit timeUnit) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("await timeout:");
        charSequence.append(l10);
        charSequence.append(" unit:");
        String string2 = timeUnit.toString();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        string2 = TAG;
        HMSLog.i(string2, (String)charSequence);
        charSequence = Looper.myLooper();
        Looper looper = Looper.getMainLooper();
        if (charSequence != looper) {
            return this.awaitOnAnyThread(l10, timeUnit);
        }
        HMSLog.i(string2, "await in main thread");
        IllegalStateException illegalStateException = new IllegalStateException("await must not be called on the UI thread");
        throw illegalStateException;
    }

    public final Result awaitOnAnyThread() {
        DatagramTransport datagramTransport;
        String string2 = TAG;
        HMSLog.i(string2, "awaitOnAnyThread");
        Object object = this.api;
        int n10 = 907135003;
        if (object == null) {
            HMSLog.e(string2, "api is null");
            this.setResult(n10, null);
            return this.result;
        }
        int n11 = (int)(this.checkApiClient((ApiClient)(object = (ApiClient)((Reference)object).get())) ? 1 : 0);
        if (n11 == 0) {
            HMSLog.e(string2, "client invalid");
            this.setResult(n10, null);
            return this.result;
        }
        n10 = (int)(this.isNeedReport ? 1 : 0);
        if (n10 != 0) {
            n10 = 0;
            datagramTransport = null;
            n11 = 1;
            this.biReportEvent(0, n11);
        }
        datagramTransport = this.transport;
        PendingResultImpl$a pendingResultImpl$a = new PendingResultImpl$a(this);
        datagramTransport.send((ApiClient)object, pendingResultImpl$a);
        object = this.countLatch;
        try {
            ((CountDownLatch)object).await();
        }
        catch (InterruptedException interruptedException) {
            object = "await in anythread InterruptedException";
            HMSLog.e(string2, (String)object);
            int n12 = 907135001;
            this.setResult(n12, null);
        }
        return this.result;
    }

    public final Result awaitOnAnyThread(long l10, TimeUnit timeUnit) {
        block8: {
            DatagramTransport datagramTransport;
            Object object = new StringBuilder();
            ((StringBuilder)object).append("awaitOnAnyThread timeout:");
            ((StringBuilder)object).append(l10);
            ((StringBuilder)object).append(" unit:");
            String string2 = timeUnit.toString();
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            string2 = TAG;
            HMSLog.i(string2, (String)object);
            object = this.api;
            int n10 = 907135003;
            if (object == null) {
                HMSLog.e(string2, "api is null");
                this.setResult(n10, null);
                return this.result;
            }
            boolean bl2 = this.checkApiClient((ApiClient)(object = (ApiClient)((Reference)object).get()));
            if (!bl2) {
                HMSLog.e(string2, "client invalid");
                this.setResult(n10, null);
                return this.result;
            }
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            bl2 = this.isNeedReport;
            boolean bl3 = true;
            if (bl2) {
                bl2 = false;
                datagramTransport = null;
                this.biReportEvent(0, (int)(bl3 ? 1 : 0));
            }
            datagramTransport = this.transport;
            PendingResultImpl$b pendingResultImpl$b = new PendingResultImpl$b(this, atomicBoolean);
            datagramTransport.post((ApiClient)object, pendingResultImpl$b);
            object = this.countLatch;
            boolean n11 = ((CountDownLatch)object).await(l10, timeUnit);
            if (n11) break block8;
            atomicBoolean.set(bl3);
            int n12 = 907135004;
            try {
                this.setResult(n12, null);
            }
            catch (InterruptedException interruptedException) {
                String string3 = "awaitOnAnyThread InterruptedException";
                HMSLog.e(string2, string3);
                int n13 = 907135001;
                this.setResult(n13, null);
            }
        }
        return this.result;
    }

    public void cancel() {
    }

    public boolean checkApiClient(ApiClient apiClient) {
        return true;
    }

    public Class getResponseType() {
        Object object = this.getClass().getGenericSuperclass();
        if (object != null) {
            object = ((ParameterizedType)object).getActualTypeArguments();
            int n10 = 1;
            if ((object = object[n10]) != null) {
                return (Class)object;
            }
        }
        return null;
    }

    public boolean isCanceled() {
        return false;
    }

    public abstract Result onComplete(IMessageEntity var1);

    public Result onError(int n10) {
        Status status;
        Object object = this.getClass().getGenericSuperclass();
        if (object != null) {
            object = ((ParameterizedType)object).getActualTypeArguments();
            status = null;
            object = object[0];
        } else {
            object = null;
        }
        object = object != null ? GenericTypeReflector.getType((Type)object) : null;
        if (object != null) {
            try {
                object = ((Class)object).newInstance();
            }
            catch (Exception exception) {
                object = new StringBuilder();
                ((StringBuilder)object).append("on Error:");
                String string2 = exception.getMessage();
                ((StringBuilder)object).append(string2);
                string2 = ((StringBuilder)object).toString();
                HMSLog.e("PendingResultImpl", string2);
                return null;
            }
            object = (Result)object;
            this.result = object;
            status = new Status(n10);
            ((Result)object).setStatus(status);
        }
        return this.result;
    }

    public final void setResultCallback(Looper object, ResultCallback resultCallback) {
        Object object2 = "PendingResultImpl";
        HMSLog.i((String)object2, "setResultCallback");
        if (object == null) {
            object = Looper.myLooper();
        }
        PendingResultImpl$d pendingResultImpl$d = new PendingResultImpl$d((Looper)object);
        object = this.api;
        int n10 = 0;
        PendingResultImpl$c pendingResultImpl$c = null;
        int n11 = 907135003;
        if (object == null) {
            HMSLog.e((String)object2, "api is null");
            this.setResult(n11, null);
            return;
        }
        boolean bl2 = this.checkApiClient((ApiClient)(object = (ApiClient)((Reference)object).get()));
        if (!bl2) {
            HMSLog.e((String)object2, "client is invalid");
            this.setResult(n11, null);
            object = this.result;
            pendingResultImpl$d.a(resultCallback, (Result)object);
            return;
        }
        boolean bl3 = this.isNeedReport;
        if (bl3) {
            bl3 = false;
            object2 = null;
            n10 = 1;
            this.biReportEvent(0, n10);
        }
        object2 = this.transport;
        pendingResultImpl$c = new PendingResultImpl$c(this, pendingResultImpl$d, resultCallback);
        object2.post((ApiClient)object, pendingResultImpl$c);
    }

    public void setResultCallback(ResultCallback resultCallback) {
        boolean bl2;
        this.isNeedReport = bl2 = resultCallback instanceof BaseAdapter$BaseRequestResultCallback ^ true;
        Looper looper = Looper.getMainLooper();
        this.setResultCallback(looper, resultCallback);
    }

    public void setResultCallback(ResultCallback resultCallback, long l10, TimeUnit timeUnit) {
        this.setResultCallback(resultCallback);
    }
}

