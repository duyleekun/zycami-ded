/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common;

import com.huawei.hms.support.api.client.Status;

public class ApiException
extends Exception {
    public final Status mStatus;

    public ApiException(Status status) {
        CharSequence charSequence = new StringBuilder();
        int n10 = status.getStatusCode();
        charSequence.append(n10);
        charSequence.append(": ");
        String string2 = status.getStatusMessage();
        string2 = string2 != null ? status.getStatusMessage() : "";
        charSequence.append(string2);
        charSequence = charSequence.toString();
        super((String)charSequence);
        this.mStatus = status;
    }

    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    public String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }
}

