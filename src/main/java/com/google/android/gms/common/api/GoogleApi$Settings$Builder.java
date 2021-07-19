/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApi$Settings;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.Preconditions;

public class GoogleApi$Settings$Builder {
    private Looper zabj;
    private StatusExceptionMapper zabl;

    public GoogleApi$Settings build() {
        Object object = this.zabl;
        if (object == null) {
            object = new ApiExceptionMapper();
            this.zabl = object;
        }
        if ((object = this.zabj) == null) {
            object = Looper.getMainLooper();
            this.zabj = object;
        }
        StatusExceptionMapper statusExceptionMapper = this.zabl;
        Looper looper = this.zabj;
        object = new GoogleApi$Settings(statusExceptionMapper, null, looper, null);
        return object;
    }

    public GoogleApi$Settings$Builder setLooper(Looper looper) {
        Preconditions.checkNotNull(looper, "Looper must not be null.");
        this.zabj = looper;
        return this;
    }

    public GoogleApi$Settings$Builder setMapper(StatusExceptionMapper statusExceptionMapper) {
        Preconditions.checkNotNull(statusExceptionMapper, "StatusExceptionMapper must not be null.");
        this.zabl = statusExceptionMapper;
        return this;
    }
}

