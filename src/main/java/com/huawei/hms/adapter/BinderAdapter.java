/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.IBinder
 *  android.os.Looper
 *  android.text.TextUtils
 */
package com.huawei.hms.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.adapter.BinderAdapter$1;
import com.huawei.hms.adapter.BinderAdapter$BinderCallBack;
import com.huawei.hms.api.BindingFailedResolution;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;

public class BinderAdapter
implements ServiceConnection {
    private static final Object LOCK_CONNECT_TIMEOUT_HANDLER;
    private static final int MSG_CONN_TIMEOUT = 1001;
    private static final String TAG = "BinderAdapter";
    private boolean bindfail = false;
    private BinderAdapter$BinderCallBack callback;
    private String mAction;
    private Handler mBinderTimeoutHandler = null;
    private Context mContext;
    private String mService;

    static {
        Object object;
        LOCK_CONNECT_TIMEOUT_HANDLER = object = new Object();
    }

    public BinderAdapter(Context context, String string2, String string3) {
        this.mContext = context;
        this.mAction = string2;
        this.mService = string3;
    }

    public static /* synthetic */ void access$000(BinderAdapter binderAdapter) {
        binderAdapter.binderServiceFailed();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void bindCoreService() {
        String string2 = this.mAction;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2 || (bl2 = TextUtils.isEmpty((CharSequence)(string2 = this.mService)))) {
            this.getBindFailPendingIntent();
        }
        Object object = this.mAction;
        string2 = new Intent((String)object);
        object = this.mService;
        string2.setPackage((String)object);
        object = LOCK_CONNECT_TIMEOUT_HANDLER;
        synchronized (object) {
            Context context = this.mContext;
            int n10 = 1;
            bl2 = context.bindService((Intent)string2, (ServiceConnection)this, n10);
            if (bl2) {
                this.postConnDelayHandle();
                return;
            }
            this.bindfail = n10;
        }
        this.getBindFailPendingIntent();
    }

    private void binderServiceFailed() {
        BinderAdapter$BinderCallBack binderAdapter$BinderCallBack = this.getCallBack();
        if (binderAdapter$BinderCallBack != null) {
            int n10 = -1;
            binderAdapter$BinderCallBack.onBinderFailed(n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void cancelConnDelayHandle() {
        Object object = LOCK_CONNECT_TIMEOUT_HANDLER;
        synchronized (object) {
            Handler handler = this.mBinderTimeoutHandler;
            if (handler != null) {
                int n10 = 1001;
                handler.removeMessages(n10);
                handler = null;
                this.mBinderTimeoutHandler = null;
            }
            return;
        }
    }

    private void getBindFailPendingIntent() {
        HMSLog.e(TAG, "In connect, bind core service fail");
        String string2 = this.mContext.getApplicationInfo().packageName;
        Object object = new ComponentName(string2, "com.huawei.hms.activity.BridgeActivity");
        string2 = new Intent();
        string2.setComponent(object);
        object = BindingFailedResolution.class.getName();
        string2.putExtra("intent.extra.DELEGATE_CLASS_OBJECT", (String)object);
        this.callback.onBinderFailed(-1, (Intent)string2);
    }

    private BinderAdapter$BinderCallBack getCallBack() {
        return this.callback;
    }

    private void postConnDelayHandle() {
        Handler handler = this.mBinderTimeoutHandler;
        int n10 = 1001;
        if (handler != null) {
            handler.removeMessages(n10);
        } else {
            Looper looper = Looper.getMainLooper();
            BinderAdapter$1 binderAdapter$1 = new BinderAdapter$1(this);
            this.mBinderTimeoutHandler = handler = new Handler(looper, (Handler.Callback)binderAdapter$1);
        }
        this.mBinderTimeoutHandler.sendEmptyMessageDelayed(n10, 5000L);
    }

    public void binder(BinderAdapter$BinderCallBack binderAdapter$BinderCallBack) {
        if (binderAdapter$BinderCallBack == null) {
            return;
        }
        this.callback = binderAdapter$BinderCallBack;
        this.bindCoreService();
    }

    public void onNullBinding(ComponentName componentName) {
        Object object = TAG;
        String string2 = "Enter onNullBinding, than unBind.";
        HMSLog.e((String)object, string2);
        boolean bl2 = this.bindfail;
        if (bl2) {
            this.bindfail = false;
            return;
        }
        this.unBind();
        this.cancelConnDelayHandle();
        object = this.getCallBack();
        if (object != null) {
            object.onNullBinding(componentName);
        }
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String string2 = "Enter onServiceConnected.";
        HMSLog.i(TAG, string2);
        this.cancelConnDelayHandle();
        BinderAdapter$BinderCallBack binderAdapter$BinderCallBack = this.getCallBack();
        if (binderAdapter$BinderCallBack != null) {
            binderAdapter$BinderCallBack.onServiceConnected(componentName, iBinder);
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        String string2 = "Enter onServiceDisconnected.";
        HMSLog.i(TAG, string2);
        BinderAdapter$BinderCallBack binderAdapter$BinderCallBack = this.getCallBack();
        if (binderAdapter$BinderCallBack != null) {
            binderAdapter$BinderCallBack.onServiceDisconnected(componentName);
        }
    }

    public void unBind() {
        Util.unBindServiceCatchException(this.mContext, this);
    }
}

