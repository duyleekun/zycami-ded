/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Parcelable
 *  android.text.TextUtils
 */
package com.huawei.hms.common.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.AnyClient$CallBack;
import com.huawei.hms.common.internal.BaseHmsClient$ConnectionCallbacks;
import com.huawei.hms.common.internal.BaseHmsClient$OnConnectionFailedListener;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.common.internal.ConnectionManagerKey;
import com.huawei.hms.common.internal.HuaweiApiManager;
import com.huawei.hms.common.internal.HuaweiApiManager$ConnectionManager$1;
import com.huawei.hms.common.internal.HuaweiApiManager$ConnectionManager$2;
import com.huawei.hms.common.internal.HuaweiApiManager$ConnectionManager$3;
import com.huawei.hms.common.internal.HuaweiApiManager$ConnectionManager$4;
import com.huawei.hms.common.internal.HuaweiApiManager$TaskApiCallbackWrapper;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResolveClientBean;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.common.internal.TaskApiCallWrapper;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.hianalytics.b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import d.j.d.a.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class HuaweiApiManager$ConnectionManager
implements BaseHmsClient$ConnectionCallbacks,
BaseHmsClient$OnConnectionFailedListener {
    private final Queue callbackQueue;
    private final HuaweiApi mApi;
    private final AnyClient mClient;
    private final ConnectionManagerKey mConnectionManagerKey;
    private ConnectionResult mConnectionResult;
    private ResolveClientBean mResolveClientBean;
    public final /* synthetic */ HuaweiApiManager this$0;

    public HuaweiApiManager$ConnectionManager(HuaweiApiManager object, HuaweiApi huaweiApi) {
        LinkedList linkedList;
        this.this$0 = object;
        this.callbackQueue = linkedList = new LinkedList();
        this.mApi = huaweiApi;
        object = HuaweiApiManager.access$100((HuaweiApiManager)object).getLooper();
        this.mClient = object = huaweiApi.getClient((Looper)object, this);
        this.mConnectionResult = null;
        this.mConnectionManagerKey = object = huaweiApi.getConnectionManagerKey();
    }

    public static /* synthetic */ HuaweiApi access$200(HuaweiApiManager$ConnectionManager huaweiApiManager$ConnectionManager) {
        return huaweiApiManager$ConnectionManager.mApi;
    }

    public static /* synthetic */ AnyClient access$300(HuaweiApiManager$ConnectionManager huaweiApiManager$ConnectionManager) {
        return huaweiApiManager$ConnectionManager.mClient;
    }

    public static /* synthetic */ void access$500(HuaweiApiManager$ConnectionManager huaweiApiManager$ConnectionManager, ConnectionResult connectionResult) {
        huaweiApiManager$ConnectionManager.innerConnectionFailed(connectionResult);
    }

    public static /* synthetic */ void access$600(HuaweiApiManager$ConnectionManager huaweiApiManager$ConnectionManager) {
        huaweiApiManager$ConnectionManager.innerConnected();
    }

    public static /* synthetic */ void access$700(HuaweiApiManager$ConnectionManager huaweiApiManager$ConnectionManager, int n10) {
        huaweiApiManager$ConnectionManager.innerConnectionSuspended(n10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String errorReason(ConnectionResult object) {
        Context context = this.mApi.getContext();
        int n10 = Util.isAvailableLibExist(context);
        int n11 = 10;
        int n12 = 8;
        int n13 = -1;
        if (n10 != 0) {
            int n14 = ((ConnectionResult)object).getErrorCode();
            if (n14 == n13) return "get update result, but has other error codes";
            n10 = 3;
            if (n14 == n10) return "HuaWei Mobile Service is disabled";
            if (n14 == n12) return "internal error";
            if (n14 == n11) return "application configuration error, please developer check configuration";
            n10 = 13;
            if (n14 == n10) return "update cancelled";
            n10 = 21;
            if (n14 == n10) return "device is too old to be support";
            switch (n14) {
                default: {
                    return "unknown errorReason";
                }
                case 27: {
                    return "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while";
                }
                case 26: {
                    return "update failed, because no activity incoming, can't pop update page";
                }
                case 25: {
                    return "failed to get update result";
                }
            }
        }
        int n15 = ((ConnectionResult)object).getErrorCode();
        if (n15 == n13) return "get update result, but has other error codes";
        if (n15 == n12) return "internal error";
        if (n15 == n11) return "application configuration error, please developer check configuration";
        return "unknown errorReason";
    }

    private String getTransactionId(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = TransactionIdCreater.getId(this.mApi.getAppID(), string3);
        }
        return string2;
    }

    private void innerConnected() {
        boolean bl2;
        Checker.assertHandlerThread(HuaweiApiManager.access$100(this.this$0));
        this.mConnectionResult = null;
        Iterator iterator2 = this.callbackQueue.iterator();
        while (bl2 = iterator2.hasNext()) {
            HuaweiApiManager$TaskApiCallbackWrapper huaweiApiManager$TaskApiCallbackWrapper = (HuaweiApiManager$TaskApiCallbackWrapper)iterator2.next();
            this.postMessage(huaweiApiManager$TaskApiCallbackWrapper);
        }
        this.callbackQueue.clear();
    }

    private void innerConnectionFailed(ConnectionResult object) {
        boolean bl2;
        int n10;
        Checker.assertHandlerThread(HuaweiApiManager.access$100(this.this$0));
        this.mConnectionResult = object;
        Object object2 = this.callbackQueue.iterator();
        int n11 = n10 = 1;
        while (bl2 = object2.hasNext()) {
            Object object3 = ((HuaweiApiManager$TaskApiCallbackWrapper)object2.next()).getApiCallWrapper();
            Object object4 = new StringBuilder();
            ((StringBuilder)object4).append("Connection Failed:");
            Object object5 = this.errorReason((ConnectionResult)object);
            ((StringBuilder)object4).append((String)object5);
            ((StringBuilder)object4).append("(");
            int n12 = ((ConnectionResult)object).getErrorCode();
            ((StringBuilder)object4).append(n12);
            ((StringBuilder)object4).append(")");
            object4 = ((StringBuilder)object4).toString();
            ResponseHeader responseHeader = new ResponseHeader(n10, 907135003, (String)object4);
            object4 = ((TaskApiCallWrapper)object3).getTaskApiCall().getTransactionId();
            responseHeader.setTransactionId((String)object4);
            object4 = this.mApi.getContext();
            n12 = this.mApi.getKitSdkVersion();
            object5 = String.valueOf(n12);
            b.a((Context)object4, responseHeader, (String)object5);
            object4 = this.mConnectionResult.getResolution();
            if (object4 != null && n11 != 0) {
                PendingIntent pendingIntent = this.mConnectionResult.getResolution();
                responseHeader.setParcelable((Parcelable)pendingIntent);
                n11 = 0;
                pendingIntent = null;
                object4 = this.mApi.getContext();
                int n13 = Util.isAvailableLibExist((Context)object4);
                if (n13 != 0 && (n13 = ((ConnectionResult)(object4 = this.mConnectionResult)).getErrorCode()) == (n12 = 26)) {
                    object4 = "hasContextResolution";
                    responseHeader.setResolution((String)object4);
                }
            }
            object4 = ((TaskApiCallWrapper)object3).getTaskApiCall();
            object5 = this.mClient;
            object3 = ((TaskApiCallWrapper)object3).getTaskCompletionSource();
            ((TaskApiCall)object4).onResponse((AnyClient)object5, responseHeader, null, (l)object3);
        }
        this.callbackQueue.clear();
        this.mConnectionResult = null;
        this.mClient.disconnect();
        object = HuaweiApiManager.access$400(this.this$0);
        object2 = this.mConnectionManagerKey;
        object.remove(object2);
    }

    private void innerConnectionSuspended(int n10) {
        Object object;
        boolean bl2;
        Checker.assertHandlerThread(HuaweiApiManager.access$100(this.this$0));
        Object object2 = this.callbackQueue.iterator();
        while (bl2 = object2.hasNext()) {
            object = ((HuaweiApiManager$TaskApiCallbackWrapper)object2.next()).getApiCallWrapper();
            int n11 = 1;
            int n12 = 907135003;
            String string2 = "Connection Suspended";
            ResponseHeader responseHeader = new ResponseHeader(n11, n12, string2);
            Object object3 = ((TaskApiCallWrapper)object).getTaskApiCall().getTransactionId();
            responseHeader.setTransactionId((String)object3);
            object3 = ((TaskApiCallWrapper)object).getTaskApiCall();
            AnyClient anyClient = this.mClient;
            object = ((TaskApiCallWrapper)object).getTaskCompletionSource();
            ((TaskApiCall)object3).onResponse(anyClient, responseHeader, null, (l)object);
        }
        this.callbackQueue.clear();
        this.mConnectionResult = null;
        this.mClient.disconnect();
        object2 = HuaweiApiManager.access$400(this.this$0);
        object = this.mConnectionManagerKey;
        object2.remove(object);
    }

    private void postMessage(HuaweiApiManager$TaskApiCallbackWrapper object) {
        Object object2 = ((HuaweiApiManager$TaskApiCallbackWrapper)object).getApiCallWrapper().getTaskApiCall().getUri();
        RequestHeader requestHeader = new RequestHeader();
        Object object3 = ((String)object2).split("\\.")[0];
        requestHeader.setSrvName((String)object3);
        requestHeader.setApiName((String)object2);
        object3 = new StringBuilder();
        String string2 = this.mApi.getAppID();
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append("|");
        string2 = this.mApi.getSubAppID();
        ((StringBuilder)object3).append(string2);
        object3 = ((StringBuilder)object3).toString();
        requestHeader.setAppID((String)object3);
        object3 = this.mApi.getContext().getPackageName();
        requestHeader.setPkgName((String)object3);
        object3 = this.mClient.getSessionId();
        requestHeader.setSessionId((String)object3);
        object3 = ((HuaweiApiManager$TaskApiCallbackWrapper)object).getApiCallWrapper().getTaskApiCall();
        string2 = ((TaskApiCall)object3).getTransactionId();
        object2 = this.getTransactionId(string2, (String)object2);
        requestHeader.setTransactionId((String)object2);
        object2 = ((TaskApiCall)object3).getParcelable();
        requestHeader.setParcelable((Parcelable)object2);
        int n10 = this.mApi.getKitSdkVersion();
        requestHeader.setKitSdkVersion(n10);
        n10 = this.mApi.getApiLevel();
        int n11 = ((TaskApiCall)object3).getApiLevel();
        n10 = Math.max(n10, n11);
        requestHeader.setApiLevel(n10);
        object2 = this.mClient;
        object3 = ((TaskApiCall)object3).getRequestJson();
        object = ((HuaweiApiManager$TaskApiCallbackWrapper)object).getCallBack();
        object2.post(requestHeader, (String)object3, (AnyClient$CallBack)object);
    }

    private HuaweiApiManager$TaskApiCallbackWrapper wrapperRequest(TaskApiCallWrapper taskApiCallWrapper) {
        HuaweiApiManager$ConnectionManager$1 huaweiApiManager$ConnectionManager$1 = new HuaweiApiManager$ConnectionManager$1(this, taskApiCallWrapper);
        HuaweiApiManager$TaskApiCallbackWrapper huaweiApiManager$TaskApiCallbackWrapper = new HuaweiApiManager$TaskApiCallbackWrapper(taskApiCallWrapper, huaweiApiManager$ConnectionManager$1);
        return huaweiApiManager$TaskApiCallbackWrapper;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void connect(int n10) {
        synchronized (this) {
            Object object = this.this$0;
            object = HuaweiApiManager.access$100((HuaweiApiManager)object);
            Checker.assertHandlerThread((Handler)object);
            object = this.mClient;
            boolean bl2 = object.isConnected();
            if (bl2) {
                String string2 = "HuaweiApiManager";
                object = "client is connected";
                HMSLog.d(string2, (String)object);
                return;
            }
            object = this.mClient;
            bl2 = object.isConnecting();
            if (bl2) {
                String string3 = "HuaweiApiManager";
                object = "client is isConnecting";
                HMSLog.d(string3, (String)object);
                return;
            }
            object = this.mApi;
            if ((object = ((HuaweiApi)object).getActivity()) != null) {
                Object object2;
                object = this.mResolveClientBean;
                if (object == null) {
                    object2 = this.mClient;
                    this.mResolveClientBean = object = new ResolveClientBean((AnyClient)object2, n10);
                }
                if (bl2 = ((BindResolveClients)(object = BindResolveClients.getInstance())).isClientRegistered((ResolveClientBean)(object2 = this.mResolveClientBean))) {
                    String string4 = "HuaweiApiManager";
                    object = "mResolveClientBean has already register, return!";
                    HMSLog.i(string4, (String)object);
                    return;
                }
                object = BindResolveClients.getInstance();
                object2 = this.mResolveClientBean;
                ((BindResolveClients)object).register((ResolveClientBean)object2);
            }
            object = this.mClient;
            object.connect(n10);
            return;
        }
    }

    public boolean disconnect() {
        Checker.assertHandlerThread(HuaweiApiManager.access$100(this.this$0));
        this.mClient.disconnect();
        return true;
    }

    public void onConnected() {
        HMSLog.d("HuaweiApiManager", "onConnected");
        BindResolveClients bindResolveClients = BindResolveClients.getInstance();
        Object object = this.mResolveClientBean;
        bindResolveClients.unRegister((ResolveClientBean)object);
        this.mResolveClientBean = null;
        bindResolveClients = Looper.myLooper();
        object = HuaweiApiManager.access$100(this.this$0).getLooper();
        if (bindResolveClients == object) {
            this.innerConnected();
        } else {
            bindResolveClients = HuaweiApiManager.access$100(this.this$0);
            object = new HuaweiApiManager$ConnectionManager$3(this);
            bindResolveClients.post((Runnable)object);
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        HMSLog.i("HuaweiApiManager", "onConnectionFailed");
        BindResolveClients bindResolveClients = BindResolveClients.getInstance();
        Object object = this.mResolveClientBean;
        bindResolveClients.unRegister((ResolveClientBean)object);
        this.mResolveClientBean = null;
        bindResolveClients = Looper.myLooper();
        object = HuaweiApiManager.access$100(this.this$0).getLooper();
        if (bindResolveClients == object) {
            this.innerConnectionFailed(connectionResult);
        } else {
            bindResolveClients = HuaweiApiManager.access$100(this.this$0);
            object = new HuaweiApiManager$ConnectionManager$2(this, connectionResult);
            bindResolveClients.post((Runnable)object);
        }
    }

    public void onConnectionSuspended(int n10) {
        HMSLog.i("HuaweiApiManager", "onConnectionSuspended");
        BindResolveClients bindResolveClients = BindResolveClients.getInstance();
        Object object = this.mResolveClientBean;
        bindResolveClients.unRegister((ResolveClientBean)object);
        this.mResolveClientBean = null;
        bindResolveClients = Looper.myLooper();
        object = HuaweiApiManager.access$100(this.this$0).getLooper();
        if (bindResolveClients == object) {
            this.innerConnectionSuspended(n10);
        } else {
            bindResolveClients = HuaweiApiManager.access$100(this.this$0);
            object = new HuaweiApiManager$ConnectionManager$4(this, n10);
            bindResolveClients.post((Runnable)object);
        }
    }

    public void sendRequest(TaskApiCallWrapper object) {
        HMSLog.i("HuaweiApiManager", "sendRequest");
        Checker.assertHandlerThread(HuaweiApiManager.access$100(this.this$0));
        Object object2 = this.wrapperRequest((TaskApiCallWrapper)object);
        object = ((TaskApiCallWrapper)object).getTaskApiCall();
        int n10 = ((TaskApiCall)object).getMinApkVersion();
        Object object3 = this.mClient;
        boolean bl2 = object3.isConnected();
        if (bl2) {
            object3 = HMSPackageManager.getInstance(this.mApi.getContext());
            bl2 = ((HMSPackageManager)object3).hmsVerHigherThan(n10);
            if (bl2) {
                this.postMessage((HuaweiApiManager$TaskApiCallbackWrapper)object2);
            } else {
                this.disconnect();
                object3 = this.callbackQueue;
                object3.add(object2);
                this.connect(n10);
            }
        } else {
            int n11;
            object3 = this.callbackQueue;
            object3.add(object2);
            object2 = this.mConnectionResult;
            if (object2 != null && (n11 = ((ConnectionResult)object2).getErrorCode()) != 0) {
                object = this.mConnectionResult;
                this.onConnectionFailed((ConnectionResult)object);
            } else {
                this.connect(n10);
            }
        }
    }
}

