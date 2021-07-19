/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.Releasable;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

public abstract class ResultCallbacks
implements ResultCallback {
    public abstract void onFailure(Status var1);

    public final void onResult(Result object) {
        block8: {
            Object object2;
            block7: {
                object2 = ((Result)object).getStatus();
                boolean bl2 = ((Status)object2).isSuccess();
                if (!bl2) break block7;
                this.onSuccess((Result)object);
            }
            this.onFailure((Status)object2);
            boolean bl3 = object instanceof Releasable;
            if (!bl3) break block8;
            object2 = object;
            object2 = (Releasable)object;
            try {
                object2.release();
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "Failed to release ";
                stringBuilder.append(string2);
                stringBuilder.append(object);
                stringBuilder.append(", reason: ");
                stringBuilder.append(exception);
                object = stringBuilder.toString();
                String string3 = "ResultCallbacks";
                HMSLog.w(string3, (String)object);
            }
        }
    }

    public abstract void onSuccess(Result var1);
}

