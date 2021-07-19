/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcelable
 */
package com.huawei.hms.common.internal;

import android.os.Parcelable;

public interface ResponseErrorCode {
    public int getErrorCode();

    public String getErrorReason();

    public Parcelable getParcelable();

    public String getResolution();

    public int getStatusCode();

    public String getTransactionId();

    public boolean hasResolution();
}

