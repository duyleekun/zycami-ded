/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Status;

public class ApiException
extends Exception {
    public final Status mStatus;

    public ApiException(Status status) {
        int n10 = status.getStatusCode();
        String string2 = status.getStatusMessage();
        string2 = string2 != null ? status.getStatusMessage() : "";
        int n11 = String.valueOf(string2).length() + 13;
        StringBuilder stringBuilder = new StringBuilder(n11);
        stringBuilder.append(n10);
        stringBuilder.append(": ");
        stringBuilder.append(string2);
        String string3 = stringBuilder.toString();
        super(string3);
        this.mStatus = status;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    public String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }
}

