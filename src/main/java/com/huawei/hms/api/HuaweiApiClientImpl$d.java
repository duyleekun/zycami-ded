/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.huawei.hms.api;

import android.os.Bundle;
import com.huawei.hms.api.HuaweiApiClientImpl;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.core.aidl.a;
import com.huawei.hms.core.aidl.b;
import com.huawei.hms.core.aidl.c$a;
import com.huawei.hms.core.aidl.e;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.log.HMSLog;

public class HuaweiApiClientImpl$d
extends c$a {
    public final /* synthetic */ ResultCallback a;

    public HuaweiApiClientImpl$d(HuaweiApiClientImpl huaweiApiClientImpl, ResultCallback resultCallback) {
        this.a = resultCallback;
    }

    public void call(b object) {
        Object object2 = "HuaweiApiClientImpl";
        if (object != null) {
            int n10 = ((b)object).c();
            Object object3 = com.huawei.hms.core.aidl.a.a(n10);
            ResponseHeader responseHeader = new ResponseHeader();
            Bundle bundle = ((b)object).b;
            ((e)object3).a(bundle, responseHeader);
            int n11 = responseHeader.getStatusCode();
            object = ((b)object).a();
            object3 = new BundleResult(n11, (Bundle)object);
            HMSLog.i((String)object2, "Exit asyncRequest onResult");
            object = this.a;
            object.onResult(object3);
        } else {
            HMSLog.i((String)object2, "Exit asyncRequest onResult -1");
            object = this.a;
            int n12 = -1;
            boolean bl2 = false;
            Object var5_7 = null;
            object2 = new BundleResult(n12, null);
            object.onResult(object2);
        }
    }
}

