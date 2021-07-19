/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.IBinder
 *  android.os.Looper
 *  android.view.KeyEvent
 */
package com.huawei.hms.api;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.api.BindingFailedResolution$a;
import com.huawei.hms.api.BindingFailedResolution$b;
import com.huawei.hms.api.BindingFailedResolution$c;
import com.huawei.hms.api.BindingFailedResolution$d;
import com.huawei.hms.api.a;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;

public class BindingFailedResolution
implements IBridgeActivityDelegate,
ServiceConnection {
    private static final Object f;
    private Activity a;
    private boolean b = true;
    private BindingFailedResolution$d c;
    private Handler d = null;
    private Handler e = null;

    static {
        Object object;
        f = object = new Object();
    }

    public static /* synthetic */ BindingFailedResolution$d a(BindingFailedResolution bindingFailedResolution, BindingFailedResolution$d d10) {
        bindingFailedResolution.c = d10;
        return d10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a() {
        Activity activity = this.getActivity();
        if (activity == null) {
            HMSLog.e("BindingFailedResolution", "In connect, bind core try fail");
            this.a(false);
            return;
        }
        Intent intent = new Intent("com.huawei.hms.core.aidlservice");
        Object object = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
        intent.setPackage((String)object);
        object = f;
        synchronized (object) {
            int n10 = 1;
            boolean bl2 = activity.bindService(intent, (ServiceConnection)this, n10);
            if (bl2) {
                this.c();
                return;
            }
        }
        HMSLog.e("BindingFailedResolution", "In connect, bind core try fail");
        this.a(false);
    }

    private void a(int n10) {
        boolean bl2;
        Activity activity = this.getActivity();
        if (activity != null && !(bl2 = activity.isFinishing())) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("finishBridgeActivity\uff1a");
            charSequence.append(n10);
            charSequence = charSequence.toString();
            HMSLog.i("BindingFailedResolution", (String)charSequence);
            charSequence = new Intent();
            String string2 = "intent.extra.RESULT";
            charSequence.putExtra(string2, n10);
            n10 = -1;
            activity.setResult(n10, (Intent)charSequence);
            activity.finish();
        }
    }

    private void a(Activity activity) {
        Object object = new Intent();
        String string2 = HMSPackageManager.getInstance(activity.getApplicationContext()).getHMSPackageName();
        object.setClassName(string2, "com.huawei.hms.core.activity.JumpActivity");
        string2 = "BindingFailedResolution";
        String string3 = "onBridgeActivityCreate\uff1atry to start HMS";
        HMSLog.i(string2, string3);
        int n10 = this.getRequestCode();
        try {
            activity.startActivityForResult((Intent)object, n10);
        }
        catch (Throwable throwable) {
            object = new StringBuilder();
            string3 = "ActivityNotFoundException\uff1a";
            ((StringBuilder)object).append(string3);
            String string4 = throwable.getMessage();
            ((StringBuilder)object).append(string4);
            string4 = ((StringBuilder)object).toString();
            HMSLog.e(string2, string4);
            string4 = this.e;
            if (string4 != null) {
                int n11 = 3;
                string4.removeMessages(n11);
                string4 = null;
                this.e = null;
            }
            this.a();
        }
    }

    public static /* synthetic */ void a(BindingFailedResolution bindingFailedResolution, int n10) {
        bindingFailedResolution.a(n10);
    }

    public static /* synthetic */ void a(BindingFailedResolution bindingFailedResolution, boolean bl2) {
        bindingFailedResolution.a(bl2);
    }

    private void a(boolean bl2) {
        boolean bl3 = this.b;
        if (bl3) {
            bl3 = false;
            this.b = false;
            this.onStartResult(bl2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b() {
        Object object = f;
        synchronized (object) {
            Handler handler = this.d;
            if (handler != null) {
                int n10 = 2;
                handler.removeMessages(n10);
                handler = null;
                this.d = null;
            }
            return;
        }
    }

    private void c() {
        Handler handler = this.d;
        int n10 = 2;
        if (handler != null) {
            handler.removeMessages(n10);
        } else {
            Looper looper = Looper.getMainLooper();
            BindingFailedResolution$b bindingFailedResolution$b = new BindingFailedResolution$b(this);
            this.d = handler = new Handler(looper, (Handler.Callback)bindingFailedResolution$b);
        }
        this.d.sendEmptyMessageDelayed(n10, 5000L);
    }

    private void d() {
        Handler handler = this.e;
        int n10 = 3;
        if (handler != null) {
            handler.removeMessages(n10);
        } else {
            Looper looper = Looper.getMainLooper();
            BindingFailedResolution$a bindingFailedResolution$a = new BindingFailedResolution$a(this);
            this.e = handler = new Handler(looper, (Handler.Callback)bindingFailedResolution$a);
        }
        this.e.sendEmptyMessageDelayed(n10, 4000L);
    }

    private void e() {
        boolean bl2;
        Activity activity = this.getActivity();
        if (activity != null && !(bl2 = activity.isFinishing())) {
            BindingFailedResolution$c bindingFailedResolution$c;
            BindingFailedResolution$d bindingFailedResolution$d = this.c;
            if (bindingFailedResolution$d == null) {
                bindingFailedResolution$c = null;
                this.c = bindingFailedResolution$d = new BindingFailedResolution$d(null);
            } else {
                bindingFailedResolution$d.dismiss();
            }
            HMSLog.i("BindingFailedResolution", "showPromptdlg to resolve conn error");
            bindingFailedResolution$d = this.c;
            bindingFailedResolution$c = new BindingFailedResolution$c(this);
            bindingFailedResolution$d.show(activity, bindingFailedResolution$c);
        }
    }

    public Activity getActivity() {
        return this.a;
    }

    public int getRequestCode() {
        return 2003;
    }

    public void onBridgeActivityCreate(Activity activity) {
        this.a = activity;
        com.huawei.hms.api.a.b.a(activity);
        this.d();
        this.a(activity);
    }

    public void onBridgeActivityDestroy() {
        this.b();
        a a10 = com.huawei.hms.api.a.b;
        Activity activity = this.a;
        a10.b(activity);
        this.a = null;
    }

    public boolean onBridgeActivityResult(int n10, int n11, Intent intent) {
        n11 = this.getRequestCode();
        if (n10 != n11) {
            return false;
        }
        String string2 = "onBridgeActivityResult";
        HMSLog.i("BindingFailedResolution", string2);
        Handler handler = this.e;
        if (handler != null) {
            n11 = 3;
            handler.removeMessages(n11);
            n10 = 0;
            handler = null;
            this.e = null;
        }
        this.a();
        return true;
    }

    public void onBridgeConfigurationChanged() {
        BindingFailedResolution$d bindingFailedResolution$d = this.c;
        if (bindingFailedResolution$d == null) {
            return;
        }
        HMSLog.i("BindingFailedResolution", "re show prompt dialog");
        this.e();
    }

    public void onKeyUp(int n10, KeyEvent keyEvent) {
        HMSLog.i("BindingFailedResolution", "On key up when resolve conn error");
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.b();
        boolean bl2 = true;
        this.a(bl2);
        componentName = this.getActivity();
        if (componentName == null) {
            return;
        }
        Util.unBindServiceCatchException((Context)componentName, this);
        HMSLog.i("BindingFailedResolution", "test connect success, try to reConnect and reply message");
        BindResolveClients.getInstance().notifyClientReconnect();
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }

    public void onStartResult(boolean bl2) {
        Activity activity = this.getActivity();
        if (activity == null) {
            return;
        }
        if (bl2) {
            this.a(0);
            return;
        }
        this.e();
    }
}

