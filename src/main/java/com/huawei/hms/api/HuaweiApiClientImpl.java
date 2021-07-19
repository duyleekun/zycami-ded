/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.IBinder
 *  android.os.Looper
 *  android.os.RemoteException
 *  android.text.TextUtils
 */
package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.CheckUpdatelistener;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.api.HuaweiApiClient$ConnectionCallbacks;
import com.huawei.hms.api.HuaweiApiClient$OnConnectionFailedListener;
import com.huawei.hms.api.HuaweiApiClientImpl$a;
import com.huawei.hms.api.HuaweiApiClientImpl$b;
import com.huawei.hms.api.HuaweiApiClientImpl$c;
import com.huawei.hms.api.HuaweiApiClientImpl$d;
import com.huawei.hms.api.HuaweiApiClientImpl$e;
import com.huawei.hms.api.HuaweiApiClientImpl$f;
import com.huawei.hms.api.HuaweiApiClientImpl$g;
import com.huawei.hms.api.HuaweiApiClientImpl$h;
import com.huawei.hms.api.HuaweiMobileServicesUtil;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.api.ProtocolNegotiate;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.a;
import com.huawei.hms.core.aidl.b;
import com.huawei.hms.core.aidl.c;
import com.huawei.hms.core.aidl.d;
import com.huawei.hms.core.aidl.d$a;
import com.huawei.hms.core.aidl.e;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import com.huawei.updatesdk.UpdateSdkAPI;
import com.huawei.updatesdk.service.otaupdate.CheckUpdateCallBack;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class HuaweiApiClientImpl
extends HuaweiApiClient
implements InnerApiClient,
ServiceConnection {
    private static final Object B;
    private static final Object C;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;
    private CheckUpdateCallBack A;
    private int a = -1;
    private final Context b;
    private final String c;
    private String d;
    private String e;
    private volatile d f;
    private String g;
    private WeakReference h;
    private WeakReference i;
    private boolean j = false;
    private AtomicInteger k;
    private List l;
    private List m;
    private Map n;
    private SubAppInfo o;
    private long p;
    private int q;
    private final Object r;
    private final ReentrantLock s;
    private final Condition t;
    private ConnectionResult u;
    private HuaweiApiClient$ConnectionCallbacks v;
    private HuaweiApiClient$OnConnectionFailedListener w;
    private Handler x;
    private Handler y;
    private CheckUpdatelistener z;

    static {
        Object object;
        B = object = new Object();
        C = object = new Object();
    }

    public HuaweiApiClientImpl(Context object) {
        Object object2;
        AtomicInteger atomicInteger;
        this.k = atomicInteger = new AtomicInteger(1);
        this.p = 0L;
        this.q = 0;
        this.r = object2 = new Object();
        this.s = object2 = new ReentrantLock();
        this.t = object2 = ((ReentrantLock)object2).newCondition();
        this.x = null;
        this.y = null;
        this.z = null;
        this.b = object;
        this.c = object2 = Util.getAppId(object);
        this.d = object2;
        object = Util.getCpId(object);
        this.e = object;
    }

    public static /* synthetic */ CheckUpdatelistener a(HuaweiApiClientImpl huaweiApiClientImpl) {
        return huaweiApiClientImpl.z;
    }

    public static /* synthetic */ CheckUpdatelistener a(HuaweiApiClientImpl huaweiApiClientImpl, CheckUpdatelistener checkUpdatelistener) {
        huaweiApiClientImpl.z = checkUpdatelistener;
        return checkUpdatelistener;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a() {
        int n10;
        Intent intent = new Intent("com.huawei.hms.core.aidlservice");
        HMSPackageManager.getInstance(this.b).refresh();
        Object object = HMSPackageManager.getInstance(this.b).getHMSPackageName();
        intent.setPackage((String)object);
        object = B;
        synchronized (object) {
            Context context = this.b;
            n10 = 1;
            boolean bl2 = context.bindService(intent, (ServiceConnection)this, n10);
            if (bl2) {
                this.i();
                return;
            }
        }
        this.c(n10);
        HMSLog.e("HuaweiApiClientImpl", "In connect, bind core service fail");
        this.b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(int n10) {
        int n11;
        Handler handler;
        Object object;
        int n12 = 2;
        if (n10 == n12) {
            object = B;
            synchronized (object) {
                handler = this.x;
                if (handler != null) {
                    handler.removeMessages(n10);
                    this.x = null;
                }
            }
        }
        if (n10 == (n11 = 3)) {
            object = C;
            synchronized (object) {
                handler = this.y;
                if (handler != null) {
                    handler.removeMessages(n10);
                    this.y = null;
                }
            }
        }
        Object object2 = B;
        synchronized (object2) {
            object = this.x;
            if (object != null) {
                object.removeMessages(n12);
                this.x = null;
            }
            return;
        }
    }

    public static /* synthetic */ void a(HuaweiApiClientImpl huaweiApiClientImpl, int n10) {
        huaweiApiClientImpl.c(n10);
    }

    public static /* synthetic */ void a(HuaweiApiClientImpl huaweiApiClientImpl, ResolveResult resolveResult) {
        huaweiApiClientImpl.b(resolveResult);
    }

    private void a(ResolveResult object) {
        int n10;
        int n11;
        Object object2 = "HuaweiApiClientImpl";
        HMSLog.i((String)object2, "Enter onConnectionResult");
        Object object3 = this.f;
        if (object3 != null && (n11 = ((AtomicInteger)(object3 = this.k)).get()) == (n10 = 2)) {
            n11 = 3;
            this.a(n11);
            Object object4 = (ConnectResp)((ResolveResult)object).getValue();
            if (object4 != null) {
                this.g = object4 = ((ConnectResp)object4).sessionId;
            }
            object4 = this.o;
            Object object5 = null;
            if (object4 == null) {
                n10 = 0;
                object4 = null;
            } else {
                object4 = ((SubAppInfo)object4).getSubAppID();
            }
            boolean n12 = TextUtils.isEmpty((CharSequence)object4);
            if (!n12) {
                this.d = object4;
            }
            object4 = ((Result)object).getStatus();
            n10 = ((Status)object4).getStatusCode();
            Object object6 = new StringBuilder();
            ((StringBuilder)object6).append("Enter onConnectionResult, connect to server result: ");
            ((StringBuilder)object6).append(n10);
            object6 = ((StringBuilder)object6).toString();
            HMSLog.i((String)object2, (String)object6);
            object6 = Status.SUCCESS;
            Status status = ((Result)object).getStatus();
            boolean bl2 = ((Status)object6).equals(status);
            if (bl2) {
                object4 = ((ResolveResult)object).getValue();
                if (object4 != null) {
                    object4 = ProtocolNegotiate.getInstance();
                    object = ((ConnectResp)object.getValue()).protocolVersion;
                    ((ProtocolNegotiate)object4).negotiate((List)object);
                }
                this.c(n11);
                this.u = null;
                object = this.v;
                if (object != null) {
                    object.onConnected();
                }
                if ((object = this.h) != null) {
                    this.n();
                }
                object = this.getApiMap().entrySet().iterator();
                while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    object3 = (Map.Entry)object.next();
                    object4 = ((Api)object3.getKey()).getmConnetctPostList();
                    if (object4 == null || (n10 = (int)((object4 = ((Api)object3.getKey()).getmConnetctPostList()).isEmpty() ? 1 : 0)) != 0) continue;
                    object4 = "Enter onConnectionResult, get the ConnetctPostList ";
                    HMSLog.i((String)object2, (String)object4);
                    object3 = ((Api)object3.getKey()).getmConnetctPostList().iterator();
                    while ((n10 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
                        object4 = (ConnectionPostProcessor)object3.next();
                        HMSLog.i((String)object2, "Enter onConnectionResult, processor.run");
                        object5 = this.h;
                        object4.run(this, (WeakReference)object5);
                    }
                }
            } else {
                int n13;
                int n14;
                object2 = ((Result)object).getStatus();
                int n15 = 1;
                if (object2 != null && (n14 = ((Status)(object = ((Result)object).getStatus())).getStatusCode()) == (n13 = 1001)) {
                    this.o();
                    this.c(n15);
                    object = this.v;
                    if (object != null) {
                        object.onConnectionSuspended(n11);
                    }
                } else {
                    this.o();
                    this.c(n15);
                    object = this.w;
                    if (object != null) {
                        object = this.h;
                        if (object != null && (object = ((Reference)object).get()) != null) {
                            object = HuaweiApiAvailability.getInstance();
                            object2 = (Activity)this.h.get();
                            object5 = ((HuaweiApiAvailability)object).getResolveErrorPendingIntent((Activity)object2, n10);
                        }
                        object = new ConnectionResult(n10, (PendingIntent)object5);
                        object2 = this.w;
                        object2.onConnectionFailed((ConnectionResult)object);
                        this.u = object;
                    }
                }
            }
            return;
        }
        HMSLog.e((String)object2, "Invalid onConnectionResult");
    }

    public static /* synthetic */ boolean a(HuaweiApiClientImpl huaweiApiClientImpl, boolean bl2) {
        huaweiApiClientImpl.j = bl2;
        return bl2;
    }

    public static /* synthetic */ AtomicInteger b(HuaweiApiClientImpl huaweiApiClientImpl) {
        return huaweiApiClientImpl.k;
    }

    private void b() {
        this.o();
        HuaweiApiClient$OnConnectionFailedListener huaweiApiClient$OnConnectionFailedListener = this.w;
        if (huaweiApiClient$OnConnectionFailedListener != null) {
            huaweiApiClient$OnConnectionFailedListener = this.b;
            int n10 = UIUtil.isBackground((Context)huaweiApiClient$OnConnectionFailedListener);
            n10 = n10 != 0 ? 7 : 6;
            HuaweiApiAvailability huaweiApiAvailability = null;
            Object object = this.h;
            if (object != null && (object = ((Reference)object).get()) != null) {
                huaweiApiAvailability = HuaweiApiAvailability.getInstance();
                object = (Activity)this.h.get();
                huaweiApiAvailability = huaweiApiAvailability.getResolveErrorPendingIntent((Activity)object, n10);
            }
            object = new ConnectionResult(n10, (PendingIntent)huaweiApiAvailability);
            huaweiApiClient$OnConnectionFailedListener = this.w;
            huaweiApiClient$OnConnectionFailedListener.onConnectionFailed((ConnectionResult)object);
            this.u = object;
        }
    }

    private void b(int n10) {
        Object object;
        Object object2 = this.h;
        if (object2 != null && (object2 = ((Reference)object2).get()) != null) {
            object2 = HuaweiApiAvailability.getInstance();
            object = (Activity)this.h.get();
            object2 = ((HuaweiApiAvailability)object2).getResolveErrorPendingIntent((Activity)object, n10);
            object = new StringBuilder();
            ((StringBuilder)object).append("connect 2.0 fail: ");
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            String string2 = "HuaweiApiClientImpl";
            HMSLog.i(string2, (String)object);
        } else {
            object2 = null;
        }
        object = new ConnectionResult(n10, (PendingIntent)object2);
        this.w.onConnectionFailed((ConnectionResult)object);
        this.u = object;
    }

    public static /* synthetic */ void b(HuaweiApiClientImpl huaweiApiClientImpl, ResolveResult resolveResult) {
        huaweiApiClientImpl.a(resolveResult);
    }

    private void b(ResolveResult object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Enter onDisconnectionResult, disconnect from server result: ");
        int n10 = ((Result)object).getStatus().getStatusCode();
        stringBuilder.append(n10);
        object = stringBuilder.toString();
        HMSLog.i("HuaweiApiClientImpl", (String)object);
        this.o();
        this.c(1);
    }

    private ConnectInfo c() {
        Object object = this.b;
        Object object2 = new PackageManagerHelper((Context)object);
        object = this.b.getPackageName();
        if ((object2 = ((PackageManagerHelper)object2).getPackageSignature((String)object)) == null) {
            object2 = "";
        }
        object = (object = this.o) == null ? null : ((SubAppInfo)object).getSubAppID();
        List list = this.getApiNameList();
        List list2 = this.l;
        ConnectInfo connectInfo = new ConnectInfo(list, list2, (String)object2, (String)object);
        return connectInfo;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void c(int n10) {
        AtomicInteger atomicInteger = this.k;
        atomicInteger.set(n10);
        int n11 = 1;
        if (n10 != n11 && n10 != (n11 = 3) && n10 != (n11 = 2)) return;
        Object object = this.s;
        ((ReentrantLock)object).lock();
        try {
            object = this.t;
        }
        catch (Throwable throwable) {
            this.s.unlock();
            throw throwable;
        }
        object.signalAll();
        object = this.s;
        ((ReentrantLock)object).unlock();
    }

    public static /* synthetic */ void c(HuaweiApiClientImpl huaweiApiClientImpl) {
        huaweiApiClientImpl.b();
    }

    private DisconnectInfo d() {
        Object object;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object2 = this.n;
        if (object2 != null) {
            boolean bl2;
            object2 = object2.keySet().iterator();
            while (bl2 = object2.hasNext()) {
                object = ((Api)object2.next()).getApiName();
                arrayList.add(object);
            }
        }
        object = this.l;
        object2 = new Object((List)object, arrayList);
        return object2;
    }

    public static /* synthetic */ WeakReference d(HuaweiApiClientImpl huaweiApiClientImpl) {
        return huaweiApiClientImpl.h;
    }

    private int e() {
        Context context = this.b;
        int n10 = Util.getHmsVersion(context);
        int n11 = 20503000;
        if (n10 != 0 && n10 >= n11) {
            return n10;
        }
        n10 = this.f();
        boolean bl2 = this.h();
        if (bl2) {
            if (n10 >= n11) {
                n11 = n10;
            }
            return n11;
        }
        n11 = 20600000;
        if (n10 < n11) {
            n10 = n11;
        }
        return n10;
    }

    private int f() {
        int n10;
        Object object = this.getApiMap();
        int n11 = 0;
        if (object == null) {
            return 0;
        }
        object = object.keySet().iterator();
        while ((n10 = object.hasNext()) != 0) {
            Map map;
            Object object2 = ((Api)object.next()).getApiName();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (bl2 || (object2 = (Integer)(map = HuaweiApiAvailability.getApiMap()).get(object2)) == null || (n10 = ((Integer)object2).intValue()) <= n11) continue;
            n11 = n10;
        }
        return n11;
    }

    private void g() {
        HuaweiApiClientImpl$a huaweiApiClientImpl$a = new HuaweiApiClientImpl$a(this);
        this.A = huaweiApiClientImpl$a;
    }

    private boolean h() {
        Object object = this.n;
        if (object != null) {
            boolean bl2;
            object = object.keySet().iterator();
            while (bl2 = object.hasNext()) {
                String string2 = "HuaweiGame.API";
                String string3 = ((Api)object.next()).getApiName();
                bl2 = string2.equals(string3);
                if (!bl2) continue;
                return true;
            }
        }
        return false;
    }

    private void i() {
        Handler handler = this.x;
        int n10 = 2;
        if (handler != null) {
            handler.removeMessages(n10);
        } else {
            Looper looper = Looper.getMainLooper();
            HuaweiApiClientImpl$b huaweiApiClientImpl$b = new HuaweiApiClientImpl$b(this);
            this.x = handler = new Handler(looper, (Handler.Callback)huaweiApiClientImpl$b);
        }
        this.x.sendEmptyMessageDelayed(n10, 5000L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void j() {
        Object object = C;
        synchronized (object) {
            Object object2;
            Object object3;
            Object object4 = this.y;
            int n10 = 3;
            if (object4 != null) {
                object4.removeMessages(n10);
            } else {
                object3 = Looper.getMainLooper();
                object2 = new HuaweiApiClientImpl$c(this);
                this.y = object4 = new Handler((Looper)object3, (Handler.Callback)object2);
            }
            object4 = this.y;
            long l10 = 3000L;
            boolean bl2 = object4.sendEmptyMessageDelayed(n10, l10);
            String string2 = "HuaweiApiClientImpl";
            object3 = new StringBuilder();
            object2 = "sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : ";
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(bl2);
            object4 = ((StringBuilder)object3).toString();
            HMSLog.d(string2, (String)object4);
            return;
        }
    }

    private void k() {
        HMSLog.i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
        Object object = this.c();
        object = ConnectService.connect(this, (ConnectInfo)object);
        HuaweiApiClientImpl$f huaweiApiClientImpl$f = new HuaweiApiClientImpl$f(this, null);
        ((PendingResult)object).setResultCallback(huaweiApiClientImpl$f);
    }

    private void l() {
        Object object = this.d();
        object = ConnectService.disconnect(this, (DisconnectInfo)object);
        HuaweiApiClientImpl$g huaweiApiClientImpl$g = new HuaweiApiClientImpl$g(this, null);
        ((PendingResultImpl)object).setResultCallback(huaweiApiClientImpl$g);
    }

    private void m() {
        HMSLog.i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
        Object object = this.c();
        object = ConnectService.forceConnect(this, (ConnectInfo)object);
        HuaweiApiClientImpl$f huaweiApiClientImpl$f = new HuaweiApiClientImpl$f(this, null);
        ((PendingResult)object).setResultCallback(huaweiApiClientImpl$f);
    }

    private void n() {
        Object object;
        int n10 = this.j;
        if (n10 != 0) {
            HMSLog.i("HuaweiApiClientImpl", "Connect notice has been shown.");
            return;
        }
        Object object2 = HuaweiApiAvailability.getInstance();
        n10 = ((HuaweiApiAvailability)object2).isHuaweiMobileNoticeAvailable((Context)(object = this.b));
        if (n10 == 0) {
            n10 = 0;
            object2 = ConnectService.getNotice(this, 0, "5.2.0.300");
            object = new HuaweiApiClientImpl$h(this, null);
            ((PendingResult)object2).setResultCallback((ResultCallback)object);
        }
    }

    private void o() {
        Util.unBindServiceCatchException(this.b, this);
        this.f = null;
    }

    public int asyncRequest(Bundle object, String object2, int n10, ResultCallback resultCallback) {
        String string2 = "HuaweiApiClientImpl";
        Object object3 = "Enter asyncRequest.";
        HMSLog.i(string2, (String)object3);
        if (resultCallback != null && object2 != null && object != null) {
            boolean bl2 = this.innerIsConnected();
            if (!bl2) {
                HMSLog.e(string2, "client is unConnect.");
                return 907135003;
            }
            object3 = new b((String)object2, n10);
            int n11 = ((b)object3).c();
            object2 = com.huawei.hms.core.aidl.a.a(n11);
            ((b)object3).a((Bundle)object);
            Object object4 = this.getAppID();
            String string3 = this.getPackageName();
            String string4 = this.getSessionId();
            int n12 = 50200300;
            object = new RequestHeader((String)object4, string3, n12, string4);
            object4 = this.getApiNameList();
            ((RequestHeader)object).setApiNameList((List)object4);
            object4 = new Bundle();
            object = ((e)object2).a((IMessageEntity)object, (Bundle)object4);
            ((b)object3).b = object;
            try {
                object = this.getService();
            }
            catch (RemoteException remoteException) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("remote exception:");
                String string5 = remoteException.getMessage();
                ((StringBuilder)object2).append(string5);
                string5 = ((StringBuilder)object2).toString();
                HMSLog.e(string2, string5);
                return 907135001;
            }
            object2 = new HuaweiApiClientImpl$d(this, resultCallback);
            object.a((b)object3, (c)object2);
            return 0;
        }
        HMSLog.e(string2, "arguments is invalid.");
        return 907135000;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void checkUpdate(Activity object, CheckUpdatelistener object2) {
        CheckUpdateCallBack checkUpdateCallBack;
        Object object3 = this.b;
        boolean bl2 = Util.isAvailableLibExist((Context)object3);
        String string2 = "HuaweiApiClientImpl";
        if (!bl2) {
            String string3 = "available lib does not exist.";
            HMSLog.i(string2, string3);
            return;
        }
        object3 = "Enter checkUpdate";
        HMSLog.i(string2, (String)object3);
        if (checkUpdateCallBack == null) {
            HMSLog.e(string2, "listener is null!");
            return;
        }
        if (object != null && !(bl2 = object.isFinishing())) {
            this.z = checkUpdateCallBack;
            checkUpdateCallBack = this.A;
            if (checkUpdateCallBack == null) {
                this.g();
            }
            checkUpdateCallBack = this.A;
            bl2 = false;
            object3 = null;
            boolean bl3 = true;
            UpdateSdkAPI.checkClientOTAUpdate((Context)object, checkUpdateCallBack, bl3, 0, bl3);
            return;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("checkUpdate, activity is illegal: ");
        ((StringBuilder)object3).append(object);
        String string4 = ((StringBuilder)object3).toString();
        HMSLog.e(string2, string4);
        checkUpdateCallBack.onResult(-1);
    }

    public void connect(int n10) {
        this.connect(null);
    }

    public void connect(Activity object) {
        int n10;
        int n11;
        Object object2 = "HuaweiApiClientImpl";
        HMSLog.i((String)object2, "====== HMSSDK version: 50200300 ======");
        Object object3 = this.k;
        int n12 = ((AtomicInteger)object3).get();
        CharSequence charSequence = new StringBuilder();
        String string2 = "Enter connect, Connection Status: ";
        charSequence.append(string2);
        charSequence.append(n12);
        charSequence = charSequence.toString();
        HMSLog.i((String)object2, (String)charSequence);
        int n13 = 3;
        if (n12 != n13 && n12 != (n13 = 5) && n12 != (n11 = 2) && n12 != (n10 = 4)) {
            int n14;
            int n15;
            if (object != null) {
                object3 = new WeakReference(object);
                this.h = object3;
                object3 = new WeakReference(object);
                this.i = object3;
            }
            object = (n15 = TextUtils.isEmpty((CharSequence)(object = this.c))) != 0 ? Util.getAppId(this.b) : this.c;
            this.d = object;
            n15 = this.e();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("connect minVersion:");
            ((StringBuilder)object3).append(n15);
            object3 = ((StringBuilder)object3).toString();
            HMSLog.i((String)object2, (String)object3);
            HuaweiApiAvailability.setServicesVersionCode(n15);
            n15 = HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.b, n15);
            object3 = new StringBuilder();
            String string3 = "In connect, isHuaweiMobileServicesAvailable result: ";
            ((StringBuilder)object3).append(string3);
            ((StringBuilder)object3).append(n15);
            object3 = ((StringBuilder)object3).toString();
            HMSLog.i((String)object2, (String)object3);
            object2 = HMSPackageManager.getInstance(this.b);
            this.q = n14 = ((HMSPackageManager)object2).getHmsVersionCode();
            if (n15 == 0) {
                this.c(n13);
                object = this.f;
                if (object == null) {
                    this.a();
                } else {
                    this.c(n11);
                    this.k();
                    this.j();
                }
            } else {
                object2 = this.w;
                if (object2 != null) {
                    this.b(n15);
                }
            }
        }
    }

    public void connectForeground() {
        String string2 = "HuaweiApiClientImpl";
        HMSLog.i(string2, "====== HMSSDK version: 50200300 ======");
        AtomicInteger atomicInteger = this.k;
        int n10 = atomicInteger.get();
        CharSequence charSequence = new StringBuilder();
        String string3 = "Enter forceConnect, Connection Status: ";
        charSequence.append(string3);
        charSequence.append(n10);
        charSequence = charSequence.toString();
        HMSLog.i(string2, (String)charSequence);
        int n11 = 3;
        if (n10 != n11 && n10 != (n11 = 5) && n10 != (n11 = 2) && n10 != (n11 = 4)) {
            string2 = this.c;
            n11 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
            string2 = n11 != 0 ? Util.getAppId(this.b) : this.c;
            this.d = string2;
            this.m();
        }
    }

    public void disableLifeCycleManagement(Activity object) {
        int n10 = this.a;
        if (n10 >= 0) {
            if ((object = AutoLifecycleFragment.getInstance((Activity)object)) == null) {
                return;
            }
            n10 = this.a;
            ((AutoLifecycleFragment)((Object)object)).stopAutoManage(n10);
            return;
        }
        object = new IllegalStateException("disableLifeCycleManagement failed");
        throw object;
    }

    public PendingResult discardAndReconnect() {
        HuaweiApiClientImpl$e huaweiApiClientImpl$e = new HuaweiApiClientImpl$e(this, null, null);
        return huaweiApiClientImpl$e;
    }

    public void disconnect() {
        AtomicInteger atomicInteger = this.k;
        int n10 = atomicInteger.get();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Enter disconnect, Connection Status: ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string2 = "HuaweiApiClientImpl";
        HMSLog.i(string2, (String)charSequence);
        int n11 = 2;
        int n12 = 4;
        if (n10 != n11) {
            int n13 = 3;
            if (n10 != n13) {
                n13 = 5;
                if (n10 == n13) {
                    this.a(n11);
                    this.c(n12);
                }
            } else {
                this.c(n12);
                this.l();
            }
        } else {
            this.c(n12);
        }
    }

    public Map getApiMap() {
        return this.n;
    }

    public List getApiNameList() {
        ArrayList<String> arrayList = new ArrayList<String>();
        Object object = this.n;
        if (object != null) {
            boolean bl2;
            object = object.keySet().iterator();
            while (bl2 = object.hasNext()) {
                String string2 = ((Api)object.next()).getApiName();
                arrayList.add(string2);
            }
        }
        return arrayList;
    }

    public String getAppID() {
        return this.d;
    }

    public ConnectionResult getConnectionResult(Api object) {
        boolean bl2 = this.isConnected();
        if (bl2) {
            this.u = null;
            object = new ConnectionResult(0, null);
            return object;
        }
        object = this.u;
        if (object != null) {
            return object;
        }
        object = new ConnectionResult(13, null);
        return object;
    }

    public Context getContext() {
        return this.b;
    }

    public String getCpID() {
        return this.e;
    }

    public String getPackageName() {
        return this.b.getPackageName();
    }

    public List getPermissionInfos() {
        return this.m;
    }

    public List getScopes() {
        return this.l;
    }

    public d getService() {
        return this.f;
    }

    public String getSessionId() {
        return this.g;
    }

    public final SubAppInfo getSubAppInfo() {
        return this.o;
    }

    public Activity getTopActivity() {
        WeakReference weakReference = this.i;
        if (weakReference == null) {
            return null;
        }
        return (Activity)weakReference.get();
    }

    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    public boolean hasConnectedApi(Api api) {
        return this.isConnected();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasConnectionFailureListener(HuaweiApiClient$OnConnectionFailedListener huaweiApiClient$OnConnectionFailedListener) {
        Checker.checkNonNull(huaweiApiClient$OnConnectionFailedListener, "onConnectionFailedListener should not be null");
        Object object = this.r;
        synchronized (object) {
            HuaweiApiClient$OnConnectionFailedListener huaweiApiClient$OnConnectionFailedListener2 = this.w;
            if (huaweiApiClient$OnConnectionFailedListener2 != huaweiApiClient$OnConnectionFailedListener) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasConnectionSuccessListener(HuaweiApiClient$ConnectionCallbacks huaweiApiClient$ConnectionCallbacks) {
        Checker.checkNonNull(huaweiApiClient$ConnectionCallbacks, "connectionCallbacksListener should not be null");
        Object object = this.r;
        synchronized (object) {
            HuaweiApiClient$ConnectionCallbacks huaweiApiClient$ConnectionCallbacks2 = this.v;
            if (huaweiApiClient$ConnectionCallbacks2 != huaweiApiClient$ConnectionCallbacks) return false;
            return true;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public ConnectionResult holdUpConnect() {
        var1_1 /* !! */  = Looper.myLooper();
        if (var1_1 /* !! */  != (var2_3 = Looper.getMainLooper())) {
            block18: {
                this.s.lock();
                var1_1 /* !! */  = null;
                this.connect(null);
                ** while (var3_4 = this.isConnecting())
lbl-1000:
                // 1 sources

                {
                    var2_3 = this.t;
                    try {
                        var2_3.await();
                        continue;
                    }
                    catch (InterruptedException v0) {
                        var2_3 = Thread.currentThread();
                        var2_3.interrupt();
                        var4_5 = 15;
                        var2_3 = new ConnectionResult(var4_5, null);
                        return var2_3;
                    }
                }
lbl23:
                // 2 sources

                var3_4 = this.isConnected();
                if (!var3_4) break block18;
                this.u = null;
                var4_6 = false;
                var2_3 = new ConnectionResult(0, null);
                this.s.unlock();
                return var2_3;
            }
            var2_3 = this.u;
            if (var2_3 != null) {
                this.s.unlock();
                return var2_3;
            }
            var4_7 = 13;
            var2_3 = new ConnectionResult(var4_7, null);
            this.s.unlock();
            return var2_3;
            {
                finally {
                    this.s.unlock();
                }
            }
        }
        var1_1 /* !! */  = new IllegalStateException("blockingConnect must not be called on the UI thread");
        throw var1_1 /* !! */ ;
    }

    /*
     * Loose catch block
     */
    public ConnectionResult holdUpConnect(long l10, TimeUnit object) {
        Looper looper;
        Looper looper2 = Looper.myLooper();
        if (looper2 != (looper = Looper.getMainLooper())) {
            Object object2;
            block24: {
                block22: {
                    this.s.lock();
                    looper2 = null;
                    this.connect(null);
                    l10 = ((TimeUnit)((Object)object)).toNanos(l10);
                    while (true) {
                        block23: {
                            Object object3 = this.isConnecting();
                            if (object3 == 0) break block22;
                            long l11 = 0L;
                            long l12 = l10 - l11;
                            object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                            if (object3 > 0) break block23;
                            this.disconnect();
                            int n10 = 14;
                            object2 = new ConnectionResult(n10, null);
                            return object2;
                        }
                        object = this.t;
                        l10 = object.awaitNanos(l10);
                        continue;
                        break;
                    }
                    catch (InterruptedException interruptedException) {
                        object2 = Thread.currentThread();
                        ((Thread)object2).interrupt();
                        int n11 = 15;
                        object2 = new ConnectionResult(n11, null);
                        this.s.unlock();
                        return object2;
                    }
                }
                boolean bl2 = this.isConnected();
                if (!bl2) break block24;
                {
                    catch (Throwable throwable) {
                        throw throwable;
                    }
                }
                this.u = null;
                boolean bl3 = false;
                object2 = new ConnectionResult(0, null);
                this.s.unlock();
                return object2;
            }
            object2 = this.u;
            if (object2 != null) {
                this.s.unlock();
                return object2;
            }
            int n12 = 13;
            try {
                object2 = new ConnectionResult(n12, null);
                this.s.unlock();
                return object2;
            }
            finally {
                this.s.unlock();
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("blockingConnect must not be called on the UI thread");
        throw illegalStateException;
    }

    public boolean innerIsConnected() {
        int n10;
        AtomicInteger atomicInteger = this.k;
        int n11 = atomicInteger.get();
        if (n11 != (n10 = 3) && (n11 = (atomicInteger = this.k).get()) != (n10 = 4)) {
            n11 = 0;
            atomicInteger = null;
        } else {
            n11 = 1;
        }
        return n11 != 0;
    }

    public boolean isConnected() {
        int n10;
        Object object;
        int n11 = this.q;
        if (n11 == 0) {
            object = HMSPackageManager.getInstance(this.b);
            this.q = n11 = ((HMSPackageManager)object).getHmsVersionCode();
        }
        if ((n11 = this.q) < (n10 = 20504000)) {
            long l10;
            long l11 = System.currentTimeMillis();
            long l12 = this.p;
            long l13 = (l11 -= l12) - (l12 = 0L);
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 > 0 && (n11 = (int)((l10 = l11 - (l12 = 300000L)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) < 0) {
                return this.innerIsConnected();
            }
            n11 = (int)(this.innerIsConnected() ? 1 : 0);
            if (n11 != 0) {
                object = new CheckConnectInfo();
                object = ConnectService.checkconnect(this, (CheckConnectInfo)object);
                Object object3 = TimeUnit.MILLISECONDS;
                l12 = 2000L;
                object = ((ResolveResult)((InnerPendingResult)object).awaitOnAnyThread(l12, (TimeUnit)((Object)object3))).getStatus();
                n10 = (int)(((Status)object).isSuccess() ? 1 : 0);
                object2 = 1;
                if (n10 != 0) {
                    this.p = l11 = System.currentTimeMillis();
                    return (boolean)object2;
                }
                n11 = ((Status)object).getStatusCode();
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("isConnected is false, statuscode:");
                ((StringBuilder)object3).append(n11);
                object3 = ((StringBuilder)object3).toString();
                String string2 = "HuaweiApiClientImpl";
                HMSLog.i(string2, (String)object3);
                n10 = 907135004;
                if (n11 != n10) {
                    this.o();
                    this.c((int)object2);
                    this.p = l11 = System.currentTimeMillis();
                }
            }
            return false;
        }
        return this.innerIsConnected();
    }

    public boolean isConnecting() {
        int n10;
        AtomicInteger atomicInteger = this.k;
        int n11 = atomicInteger.get();
        if (n11 != (n10 = 2) && n11 != (n10 = 5)) {
            n11 = 0;
            atomicInteger = null;
        } else {
            n11 = 1;
        }
        return n11 != 0;
    }

    public void onPause(Activity activity) {
        HMSLog.i("HuaweiApiClientImpl", "onPause");
    }

    public void onResume(Activity activity) {
        if (activity != null) {
            WeakReference<Activity> weakReference;
            String string2 = "onResume";
            HMSLog.i("HuaweiApiClientImpl", string2);
            this.i = weakReference = new WeakReference<Activity>(activity);
        }
    }

    public void onServiceConnected(ComponentName object, IBinder object2) {
        int n10;
        object = "HuaweiApiClientImpl";
        String string2 = "Enter onServiceConnected.";
        HMSLog.i((String)object, string2);
        int n11 = 2;
        this.a(n11);
        object2 = d$a.a(object2);
        this.f = object2;
        object2 = this.f;
        if (object2 == null) {
            object2 = "In onServiceConnected, mCoreService must not be null.";
            HMSLog.e((String)object, (String)object2);
            this.o();
            int n12 = 1;
            this.c(n12);
            object = this.w;
            if (object != null) {
                n12 = 0;
                object = null;
                object2 = this.h;
                n11 = 10;
                if (object2 != null && (object2 = object2.get()) != null) {
                    object = HuaweiApiAvailability.getInstance();
                    object2 = (Activity)this.h.get();
                    object = ((HuaweiApiAvailability)object).getResolveErrorPendingIntent((Activity)object2, n11);
                }
                object2 = new ConnectionResult(n11, (PendingIntent)object);
                object = this.w;
                object.onConnectionFailed((ConnectionResult)object2);
                this.u = object2;
            }
            return;
        }
        object = this.k;
        int n13 = ((AtomicInteger)object).get();
        if (n13 == (n10 = 5)) {
            this.c(n11);
            this.k();
            this.j();
        } else {
            object = this.k;
            n13 = ((AtomicInteger)object).get();
            if (n13 != (n10 = 3)) {
                this.o();
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
        this.f = null;
        int n10 = 1;
        this.c(n10);
        HuaweiApiClient$ConnectionCallbacks huaweiApiClient$ConnectionCallbacks = this.v;
        if (huaweiApiClient$ConnectionCallbacks != null) {
            huaweiApiClient$ConnectionCallbacks.onConnectionSuspended(n10);
        }
    }

    public void print(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
    }

    public void reconnect() {
        this.disconnect();
        this.connect(null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeConnectionFailureListener(HuaweiApiClient$OnConnectionFailedListener object) {
        Checker.checkNonNull(object, "onConnectionFailedListener should not be null");
        Object object2 = this.r;
        synchronized (object2) {
            Object object3 = this.w;
            if (object3 != object) {
                object = "HuaweiApiClientImpl";
                object3 = "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered";
                HMSLog.w((String)object, (String)object3);
            } else {
                object = null;
                this.w = null;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeConnectionSuccessListener(HuaweiApiClient$ConnectionCallbacks object) {
        Checker.checkNonNull(object, "connectionCallbacksListener should not be null");
        Object object2 = this.r;
        synchronized (object2) {
            Object object3 = this.v;
            if (object3 != object) {
                object = "HuaweiApiClientImpl";
                object3 = "unregisterConnectionCallback: this connectionCallbacksListener has not been registered";
                HMSLog.w((String)object, (String)object3);
            } else {
                object = null;
                this.v = null;
            }
            return;
        }
    }

    public void setApiMap(Map map) {
        this.n = map;
    }

    public void setAutoLifecycleClientId(int n10) {
        this.a = n10;
    }

    public void setConnectionCallbacks(HuaweiApiClient$ConnectionCallbacks huaweiApiClient$ConnectionCallbacks) {
        this.v = huaweiApiClient$ConnectionCallbacks;
    }

    public void setConnectionFailedListener(HuaweiApiClient$OnConnectionFailedListener huaweiApiClient$OnConnectionFailedListener) {
        this.w = huaweiApiClient$OnConnectionFailedListener;
    }

    public void setHasShowNotice(boolean bl2) {
        this.j = bl2;
    }

    public void setPermissionInfos(List list) {
        this.m = list;
    }

    public void setScopes(List list) {
        this.l = list;
    }

    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        Object object = "HuaweiApiClientImpl";
        HMSLog.i((String)object, "Enter setSubAppInfo");
        if (subAppInfo == null) {
            HMSLog.e((String)object, "subAppInfo is null");
            return false;
        }
        String string2 = subAppInfo.getSubAppID();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            HMSLog.e((String)object, "subAppId is empty");
            return false;
        }
        String string3 = this.c;
        bl2 = TextUtils.isEmpty((CharSequence)string3);
        string3 = bl2 ? Util.getAppId(this.b) : this.c;
        boolean bl3 = string2.equals(string3);
        if (bl3) {
            HMSLog.e((String)object, "subAppId is host appid");
            return false;
        }
        this.o = object = new SubAppInfo(subAppInfo);
        return true;
    }
}

