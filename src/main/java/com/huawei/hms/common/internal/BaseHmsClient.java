/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.os.Handler
 *  android.text.TextUtils
 */
package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.AvailableAdapter$AvailableCallBack;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.adapter.BinderAdapter$BinderCallBack;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.common.internal.BaseHmsClient$1;
import com.huawei.hms.common.internal.BaseHmsClient$2;
import com.huawei.hms.common.internal.BaseHmsClient$ConnectionCallbacks;
import com.huawei.hms.common.internal.BaseHmsClient$OnConnectionFailedListener;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.core.aidl.d;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseHmsClient
implements AidlApiClient {
    private static final int BINDING = 5;
    private static final int CONNECTED = 3;
    private static final int DISCONNECTED = 1;
    private static final int DISCONNECTING = 4;
    private static final Object LOCK_CONNECT_TIMEOUT_HANDLER;
    private static final int MSG_CONN_TIMEOUT = 2;
    private static final String TAG = "BaseHmsClient";
    private String mAppID;
    private BinderAdapter mBinderAdapter;
    private final ClientSettings mClientSettings;
    private final AtomicInteger mConnStatus;
    private Handler mConnectTimeoutHandler;
    private final BaseHmsClient$ConnectionCallbacks mConnectionCallbacks;
    private final BaseHmsClient$OnConnectionFailedListener mConnectionFailedListener;
    private final Context mContext;
    private volatile d mService;
    public String sessionId;

    static {
        Object object;
        LOCK_CONNECT_TIMEOUT_HANDLER = object = new Object();
    }

    public BaseHmsClient(Context object, ClientSettings clientSettings, BaseHmsClient$OnConnectionFailedListener baseHmsClient$OnConnectionFailedListener, BaseHmsClient$ConnectionCallbacks baseHmsClient$ConnectionCallbacks) {
        AtomicInteger atomicInteger;
        this.mConnStatus = atomicInteger = new AtomicInteger(1);
        this.mConnectTimeoutHandler = null;
        this.mContext = object;
        this.mClientSettings = clientSettings;
        object = clientSettings.getAppID();
        this.mAppID = object;
        this.mConnectionFailedListener = baseHmsClient$OnConnectionFailedListener;
        this.mConnectionCallbacks = baseHmsClient$ConnectionCallbacks;
    }

    public static /* synthetic */ d access$000(BaseHmsClient baseHmsClient) {
        return baseHmsClient.mService;
    }

    public static /* synthetic */ d access$002(BaseHmsClient baseHmsClient, d d10) {
        baseHmsClient.mService = d10;
        return d10;
    }

    public static /* synthetic */ BinderAdapter access$100(BaseHmsClient baseHmsClient) {
        return baseHmsClient.mBinderAdapter;
    }

    public static /* synthetic */ void access$200(BaseHmsClient baseHmsClient, int n10) {
        baseHmsClient.setConnectStatus(n10);
    }

    public static /* synthetic */ void access$300(BaseHmsClient baseHmsClient, int n10) {
        baseHmsClient.notifyFailed(n10);
    }

    public static /* synthetic */ Context access$400(BaseHmsClient baseHmsClient) {
        return baseHmsClient.mContext;
    }

    public static /* synthetic */ void access$500(BaseHmsClient baseHmsClient, ConnectionResult connectionResult) {
        baseHmsClient.notifyFailed(connectionResult);
    }

    public static /* synthetic */ BaseHmsClient$ConnectionCallbacks access$600(BaseHmsClient baseHmsClient) {
        return baseHmsClient.mConnectionCallbacks;
    }

    public static /* synthetic */ void access$700(BaseHmsClient baseHmsClient) {
        baseHmsClient.bindCoreService();
    }

    private void bindCoreService() {
        boolean bl2;
        Object object = this.mClientSettings.getInnerHmsPkg();
        CharSequence charSequence = this.getServiceAction();
        Object object2 = this.mContext.getPackageName();
        boolean bl3 = ((String)object).equalsIgnoreCase((String)object2);
        if (bl3 && !(bl2 = TextUtils.isEmpty((CharSequence)(object2 = Util.getServiceActionMetadata(this.mContext))))) {
            charSequence = object2;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("enter bindCoreService, packageName is ");
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(", serviceAction is ");
        ((StringBuilder)object2).append((String)charSequence);
        object2 = ((StringBuilder)object2).toString();
        HMSLog.i(TAG, (String)object2);
        Context context = this.mContext;
        this.mBinderAdapter = object2 = new BinderAdapter(context, (String)charSequence, (String)object);
        object = new BaseHmsClient$1(this);
        ((BinderAdapter)object2).binder((BinderAdapter$BinderCallBack)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void cancelConnDelayHandle() {
        Object object = LOCK_CONNECT_TIMEOUT_HANDLER;
        synchronized (object) {
            Handler handler = this.mConnectTimeoutHandler;
            if (handler != null) {
                int n10 = 2;
                handler.removeMessages(n10);
                handler = null;
                this.mConnectTimeoutHandler = null;
            }
            return;
        }
    }

    private void checkAvailabilityAndConnect(int n10, boolean n11) {
        String string2 = TAG;
        HMSLog.i(string2, "====== HMSSDK version: 50200300 ======");
        Object object = this.mConnStatus;
        int n12 = ((AtomicInteger)object).get();
        CharSequence charSequence = new StringBuilder();
        String string3 = "Enter connect, Connection Status: ";
        charSequence.append(string3);
        charSequence.append(n12);
        charSequence = charSequence.toString();
        HMSLog.i(string2, (String)charSequence);
        int n13 = 5;
        if (n11 == 0 && (n12 == (n11 = 3) || n12 == n13 || n12 == (n11 = 4))) {
            return;
        }
        this.setConnectStatus(n13);
        n11 = this.getMinApkVersion();
        if (n11 > n10) {
            n10 = this.getMinApkVersion();
        }
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("connect minVersion:");
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append(" packageName:");
        object = this.mClientSettings.getInnerHmsPkg();
        ((StringBuilder)object2).append((String)object);
        object2 = ((StringBuilder)object2).toString();
        HMSLog.i(string2, (String)object2);
        object2 = this.mContext.getPackageName();
        object = this.mClientSettings.getInnerHmsPkg();
        n11 = (int)(((String)object2).equals(object) ? 1 : 0);
        if (n11 != 0) {
            HMSLog.i(string2, "service packageName is same, bind core service return");
            this.bindCoreService();
            return;
        }
        object2 = this.mContext;
        n11 = (int)(Util.isAvailableLibExist((Context)object2) ? 1 : 0);
        if (n11 != 0) {
            object2 = new AvailableAdapter(n10);
            Context context = this.mContext;
            n10 = ((AvailableAdapter)object2).isHuaweiMobileServicesAvailable(context);
            object = new StringBuilder();
            charSequence = "check available result: ";
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            HMSLog.i(string2, (String)object);
            if (n10 == 0) {
                this.bindCoreService();
            } else {
                n12 = (int)(((AvailableAdapter)object2).isUserResolvableError(n10) ? 1 : 0);
                if (n12 != 0) {
                    object = "bindCoreService3.0 fail, start resolution now.";
                    HMSLog.i(string2, (String)object);
                    this.resolution((AvailableAdapter)object2, n10);
                } else {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("bindCoreService3.0 fail: ");
                    ((StringBuilder)object2).append(n10);
                    object = " is not resolvable.";
                    ((StringBuilder)object2).append((String)object);
                    object2 = ((StringBuilder)object2).toString();
                    HMSLog.i(string2, (String)object2);
                    this.notifyFailed(n10);
                }
            }
        } else {
            object2 = HuaweiApiAvailability.getInstance();
            object = this.mContext;
            n10 = ((HuaweiApiAvailability)object2).isHuaweiMobileServicesAvailable((Context)object, n10);
            object2 = new StringBuilder();
            object = "HuaweiApiAvailability check available result: ";
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(n10);
            object2 = ((StringBuilder)object2).toString();
            HMSLog.i(string2, (String)object2);
            if (n10 == 0) {
                this.bindCoreService();
            } else {
                this.notifyFailed(n10);
            }
        }
    }

    private void notifyFailed(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("notifyFailed result: ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        Object object2 = TAG;
        HMSLog.i((String)object2, (String)object);
        object = this.mConnectionFailedListener;
        if (object != null) {
            object2 = new ConnectionResult(n10);
            object.onConnectionFailed((ConnectionResult)object2);
        }
    }

    private void notifyFailed(ConnectionResult connectionResult) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("notifyFailed result: ");
        int n10 = connectionResult.getErrorCode();
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        HMSLog.i(string2, (String)object);
        object = this.mConnectionFailedListener;
        if (object != null) {
            object.onConnectionFailed(connectionResult);
        }
    }

    private void resolution(AvailableAdapter object, int n10) {
        String string2 = "enter HmsCore resolution";
        HMSLog.i(TAG, string2);
        Object object2 = this.getClientSettings();
        boolean bl2 = ((ClientSettings)object2).isHasActivity();
        int n11 = 26;
        if (!bl2) {
            object = HuaweiApiAvailability.getInstance();
            object2 = this.mContext;
            object = ((HuaweiApiAvailability)object).getErrPendingIntent((Context)object2, n10, 0);
            ConnectionResult connectionResult = new ConnectionResult(n11, (PendingIntent)object);
            this.notifyFailed(connectionResult);
            return;
        }
        Activity activity = this.getClientSettings().getCpActivity();
        object2 = this.getContext();
        if ((activity = Util.getActiveActivity(activity, (Context)object2)) != null) {
            object2 = new BaseHmsClient$2(this);
            ((AvailableAdapter)object).startResolution(activity, (AvailableAdapter$AvailableCallBack)object2);
        } else {
            this.notifyFailed(n11);
        }
    }

    private void setConnectStatus(int n10) {
        this.mConnStatus.set(n10);
    }

    public final void checkConnected() {
        boolean bl2 = this.isConnected();
        if (bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        throw illegalStateException;
    }

    public void connect(int n10) {
        this.checkAvailabilityAndConnect(n10, false);
    }

    public void connect(int n10, boolean bl2) {
        this.checkAvailabilityAndConnect(n10, bl2);
    }

    public final void connectionConnected() {
        int n10 = 3;
        this.setConnectStatus(n10);
        BaseHmsClient$ConnectionCallbacks baseHmsClient$ConnectionCallbacks = this.mConnectionCallbacks;
        if (baseHmsClient$ConnectionCallbacks != null) {
            baseHmsClient$ConnectionCallbacks.onConnected();
        }
    }

    public void disconnect() {
        Object object = this.mConnStatus;
        int n10 = ((AtomicInteger)object).get();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Enter disconnect, Connection Status: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = TAG;
        HMSLog.i(string2, (String)charSequence);
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 3;
            if (n10 != n12) {
                n11 = 4;
                if (n10 != n11 && n10 == (n12 = 5)) {
                    this.cancelConnDelayHandle();
                    this.setConnectStatus(n11);
                }
            } else {
                object = this.mBinderAdapter;
                if (object != null) {
                    ((BinderAdapter)object).unBind();
                }
                this.setConnectStatus(n11);
            }
        }
    }

    public List getApiNameList() {
        return this.mClientSettings.getApiName();
    }

    public String getAppID() {
        return this.mAppID;
    }

    public ClientSettings getClientSettings() {
        return this.mClientSettings;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getCpID() {
        return this.mClientSettings.getCpID();
    }

    public int getMinApkVersion() {
        return 30000000;
    }

    public String getPackageName() {
        return this.mClientSettings.getClientPackageName();
    }

    public d getService() {
        return this.mService;
    }

    public String getServiceAction() {
        return "com.huawei.hms.core.aidlservice";
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public SubAppInfo getSubAppInfo() {
        return this.mClientSettings.getSubAppID();
    }

    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    public boolean isConnected() {
        int n10;
        AtomicInteger atomicInteger = this.mConnStatus;
        int n11 = atomicInteger.get();
        if (n11 != (n10 = 3) && (n11 = (atomicInteger = this.mConnStatus).get()) != (n10 = 4)) {
            n11 = 0;
            atomicInteger = null;
        } else {
            n11 = 1;
        }
        return n11 != 0;
    }

    public boolean isConnecting() {
        int n10;
        AtomicInteger atomicInteger = this.mConnStatus;
        int n11 = atomicInteger.get();
        if (n11 == (n10 = 5)) {
            n11 = 1;
        } else {
            n11 = 0;
            atomicInteger = null;
        }
        return n11 != 0;
    }

    public void onConnecting() {
        this.connectionConnected();
    }
}

