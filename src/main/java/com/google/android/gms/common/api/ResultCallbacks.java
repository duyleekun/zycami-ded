/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.common.api;

import android.util.Log;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public abstract class ResultCallbacks
implements ResultCallback {
    public abstract void onFailure(Status var1);

    public final void onResult(Result object) {
        Object object2 = object.getStatus();
        boolean n10 = ((Status)object2).isSuccess();
        if (n10) {
            this.onSuccess((Result)object);
            return;
        }
        this.onFailure((Status)object2);
        boolean bl2 = object instanceof Releasable;
        if (bl2) {
            object2 = object;
            object2 = (Releasable)object;
            try {
                object2.release();
                return;
            }
            catch (RuntimeException runtimeException) {
                object = String.valueOf(object);
                int n11 = String.valueOf(object).length() + 18;
                StringBuilder stringBuilder = new StringBuilder(n11);
                stringBuilder.append("Unable to release ");
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                String string2 = "ResultCallbacks";
                Log.w((String)string2, (String)object, (Throwable)runtimeException);
            }
        }
    }

    public abstract void onSuccess(Result var1);
}

