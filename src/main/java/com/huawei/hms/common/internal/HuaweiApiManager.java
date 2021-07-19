/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 */
package com.huawei.hms.common.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.HandlerMessageWrapper;
import com.huawei.hms.common.internal.HuaweiApiManager$1;
import com.huawei.hms.common.internal.HuaweiApiManager$ConnectionManager;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.common.internal.TaskApiCallWrapper;
import com.huawei.hms.support.log.HMSLog;
import d.j.d.a.l;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HuaweiApiManager
implements Handler.Callback {
    private static final String HANDLER_NAME = "HuaweiApiHandler";
    private static final Object LOCK_OBJECT;
    private static final int MSG_RECEIVE_SEND_REQ = 4;
    private static final String TAG = "HuaweiApiManager";
    private static HuaweiApiManager mInstance;
    private final Map mConnectionCache;
    private final Handler mHandler;
    private final AtomicInteger mSerial;

    static {
        Object object;
        LOCK_OBJECT = object = new Object();
    }

    private HuaweiApiManager(Context object, Looper looper, HuaweiApiAvailability huaweiApiAvailability) {
        super(0);
        this.mSerial = object;
        super(5, 0.75f, 1);
        this.mConnectionCache = object;
        super(looper, (Handler.Callback)this);
        this.mHandler = object;
    }

    public static /* synthetic */ void access$000(HuaweiApiManager huaweiApiManager, HuaweiApi huaweiApi, l l10) {
        huaweiApiManager.innerDisconnect(huaweiApi, l10);
    }

    public static /* synthetic */ Handler access$100(HuaweiApiManager huaweiApiManager) {
        return huaweiApiManager.mHandler;
    }

    public static /* synthetic */ Map access$400(HuaweiApiManager huaweiApiManager) {
        return huaweiApiManager.mConnectionCache;
    }

    private void connectAndSendRequest(HandlerMessageWrapper object) {
        Object object2 = ((HandlerMessageWrapper)object).mApi;
        Object object3 = this.mConnectionCache;
        Object object4 = ((HuaweiApi)object2).getConnectionManagerKey();
        if ((object3 = (HuaweiApiManager$ConnectionManager)object3.get(object4)) == null) {
            object3 = new HuaweiApiManager$ConnectionManager(this, (HuaweiApi)object2);
            object4 = this.mConnectionCache;
            object2 = ((HuaweiApi)object2).getConnectionManagerKey();
            object4.put(object2, object3);
        }
        object = (TaskApiCallWrapper)((HandlerMessageWrapper)object).mContentWrapper;
        ((HuaweiApiManager$ConnectionManager)object3).sendRequest((TaskApiCallWrapper)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static HuaweiApiManager getInstance(Context context) {
        Object object = LOCK_OBJECT;
        synchronized (object) {
            HuaweiApiManager huaweiApiManager = mInstance;
            if (huaweiApiManager == null) {
                Object object2 = TAG;
                huaweiApiManager = new HandlerThread((String)object2);
                huaweiApiManager.start();
                context = context.getApplicationContext();
                huaweiApiManager = huaweiApiManager.getLooper();
                HuaweiApiAvailability huaweiApiAvailability = HuaweiApiAvailability.getInstance();
                mInstance = object2 = new HuaweiApiManager(context, (Looper)huaweiApiManager, huaweiApiAvailability);
            }
            return mInstance;
        }
    }

    private void innerDisconnect(HuaweiApi object, l l10) {
        Map map = this.mConnectionCache;
        object = ((HuaweiApi)object).getConnectionManagerKey();
        if ((object = (HuaweiApiManager$ConnectionManager)map.get(object)) == null) {
            object = Boolean.FALSE;
            l10.d(object);
        } else {
            boolean bl2 = ((HuaweiApiManager$ConnectionManager)object).disconnect();
            object = bl2;
            l10.d(object);
        }
    }

    public void disconnectService(HuaweiApi huaweiApi, l l10) {
        Object object;
        Looper looper = Looper.myLooper();
        if (looper == (object = this.mHandler.getLooper())) {
            this.innerDisconnect(huaweiApi, l10);
        } else {
            looper = this.mHandler;
            object = new HuaweiApiManager$1(this, huaweiApi, l10);
            looper.post((Runnable)object);
        }
    }

    public boolean handleMessage(Message object) {
        int n10 = object.what;
        int n11 = 4;
        if (n10 != n11) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown message id: ");
            int n12 = object.what;
            stringBuilder.append(n12);
            object = stringBuilder.toString();
            HMSLog.w(TAG, (String)object);
            return false;
        }
        object = (HandlerMessageWrapper)object.obj;
        this.connectAndSendRequest((HandlerMessageWrapper)object);
        return true;
    }

    public final void sendRequest(HuaweiApi huaweiApi, TaskApiCall taskApiCall, l object) {
        TaskApiCallWrapper taskApiCallWrapper = new TaskApiCallWrapper(taskApiCall, (l)object);
        taskApiCall = this.mHandler;
        int n10 = this.mSerial.getAndIncrement();
        object = new HandlerMessageWrapper(taskApiCallWrapper, n10, huaweiApi);
        huaweiApi = taskApiCall.obtainMessage(4, object);
        taskApiCall.sendMessage((Message)huaweiApi);
    }
}

