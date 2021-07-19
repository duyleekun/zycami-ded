/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.huawei.hms.support.api.client;

import android.app.Activity;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallbacks;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.log.HMSLog;

public abstract class ResolvingResultCallbacks
extends ResultCallbacks {
    private final Activity a;
    private final int b;

    public ResolvingResultCallbacks(Activity activity, int n10) {
        this.a = activity = (Activity)Preconditions.checkNotNull(activity, "Activity must not be null");
        this.b = n10;
    }

    public final void onFailure(Status status) {
        CharSequence charSequence;
        block6: {
            boolean bl2 = status.hasResolution();
            if (!bl2) break block6;
            charSequence = this.a;
            int n10 = this.b;
            status.startResolutionForResult((Activity)charSequence, n10);
        }
        try {
            this.onUnresolvableFailure(status);
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            String string2 = "Failed to start resolution: ";
            charSequence.append(string2);
            charSequence.append(exception);
            Object object = charSequence.toString();
            charSequence = "ResolvingResultCallbacks";
            HMSLog.e((String)charSequence, (String)object);
            object = Status.RESULT_INTERNAL_ERROR;
            this.onUnresolvableFailure((Status)object);
        }
    }

    public abstract void onSuccess(Result var1);

    public abstract void onUnresolvableFailure(Status var1);
}

