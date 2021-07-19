/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.huawei.hms.api;

import android.content.Intent;
import com.huawei.hms.api.UserRecoverableException;

public class HuaweiServicesRepairableException
extends UserRecoverableException {
    private final int b;

    public HuaweiServicesRepairableException(int n10, String string2, Intent intent) {
        super(string2, intent);
        this.b = n10;
    }

    public int getConnectionStatusCode() {
        return this.b;
    }
}

