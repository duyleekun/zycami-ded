/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.Intent
 */
package com.huawei.hms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;

public class ResolvableApiException
extends ApiException {
    public ResolvableApiException(ResponseErrorCode responseErrorCode) {
        int n10 = responseErrorCode.getErrorCode();
        String string2 = responseErrorCode.getErrorReason();
        Status status = new Status(n10, string2);
        super(status);
        boolean bl2 = responseErrorCode.hasResolution();
        if (bl2) {
            status = responseErrorCode.getParcelable();
            bl2 = status instanceof PendingIntent;
            if (bl2) {
                status = this.mStatus;
                responseErrorCode = (PendingIntent)responseErrorCode.getParcelable();
                status.setPendingIntent((PendingIntent)responseErrorCode);
            } else {
                status = responseErrorCode.getParcelable();
                bl2 = status instanceof Intent;
                if (bl2) {
                    status = this.mStatus;
                    responseErrorCode = (Intent)responseErrorCode.getParcelable();
                    status.setIntent((Intent)responseErrorCode);
                }
            }
        }
    }

    public ResolvableApiException(Status status) {
        super(status);
    }

    public PendingIntent getResolution() {
        return this.mStatus.getResolution();
    }

    public Intent getResolutionIntent() {
        return this.mStatus.getResolutionIntent();
    }

    public void startResolutionForResult(Activity activity, int n10) {
        this.mStatus.startResolutionForResult(activity, n10);
    }
}

