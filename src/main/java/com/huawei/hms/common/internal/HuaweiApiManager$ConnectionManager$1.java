/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.common.internal;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.AnyClient$CallBack;
import com.huawei.hms.common.internal.HuaweiApiManager$ConnectionManager;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.common.internal.TaskApiCallWrapper;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.hianalytics.b;
import com.huawei.hms.support.log.HMSLog;
import d.j.d.a.l;
import java.util.concurrent.atomic.AtomicBoolean;

public class HuaweiApiManager$ConnectionManager$1
implements AnyClient$CallBack {
    private AtomicBoolean isFirstRsp;
    public final /* synthetic */ HuaweiApiManager$ConnectionManager this$1;
    public final /* synthetic */ TaskApiCallWrapper val$req;

    public HuaweiApiManager$ConnectionManager$1(HuaweiApiManager$ConnectionManager object, TaskApiCallWrapper taskApiCallWrapper) {
        this.this$1 = object;
        this.val$req = taskApiCallWrapper;
        this.isFirstRsp = object = new AtomicBoolean(true);
    }

    public void onCallback(IMessageEntity iMessageEntity, String string2) {
        Object object;
        boolean bl2 = iMessageEntity instanceof ResponseHeader;
        Object object2 = "HuaweiApiManager";
        if (!bl2) {
            HMSLog.e((String)object2, "header is not instance of ResponseHeader");
            return;
        }
        Object object3 = ((ResponseHeader)(iMessageEntity = (ResponseHeader)iMessageEntity)).getResolution();
        bl2 = TextUtils.isEmpty((CharSequence)object3);
        if (!bl2) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Response has resolution: ");
            object = ((ResponseHeader)iMessageEntity).getResolution();
            ((StringBuilder)object3).append((String)object);
            object3 = ((StringBuilder)object3).toString();
            HMSLog.e((String)object2, (String)object3);
        }
        object3 = this.isFirstRsp;
        int n10 = 1;
        object = null;
        bl2 = ((AtomicBoolean)object3).compareAndSet(n10 != 0, false);
        if (bl2) {
            object3 = HuaweiApiManager$ConnectionManager.access$200(this.this$1).getContext();
            n10 = HuaweiApiManager$ConnectionManager.access$200(this.this$1).getKitSdkVersion();
            object2 = String.valueOf(n10);
            b.a((Context)object3, (ResponseHeader)iMessageEntity, (String)object2);
        }
        object3 = this.val$req.getTaskApiCall();
        object2 = HuaweiApiManager$ConnectionManager.access$300(this.this$1);
        object = this.val$req.getTaskCompletionSource();
        ((TaskApiCall)object3).onResponse((AnyClient)object2, (ResponseErrorCode)((Object)iMessageEntity), string2, (l)object);
    }
}

