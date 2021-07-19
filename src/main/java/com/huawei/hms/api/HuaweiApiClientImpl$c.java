/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.huawei.hms.api;

import android.os.Handler;
import android.os.Message;
import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.support.log.HMSLog;
import java.util.concurrent.atomic.AtomicInteger;

public class HuaweiApiClientImpl$c
implements Handler.Callback {
    public final /* synthetic */ HuaweiApiClientImpl a;

    public HuaweiApiClientImpl$c(HuaweiApiClientImpl huaweiApiClientImpl) {
        this.a = huaweiApiClientImpl;
    }

    public boolean handleMessage(Message object) {
        int n10;
        int n11;
        if (object != null && (n11 = ((Message)object).what) == (n10 = 3)) {
            String string2 = "In connect, process time out";
            HMSLog.e("HuaweiApiClientImpl", string2);
            object = HuaweiApiClientImpl.b(this.a);
            n11 = ((AtomicInteger)object).get();
            n10 = 2;
            int n12 = 1;
            if (n11 == n10) {
                HuaweiApiClientImpl.a(this.a, n12);
                object = this.a;
                HuaweiApiClientImpl.c((HuaweiApiClientImpl)object);
            }
            return n12 != 0;
        }
        return false;
    }
}

