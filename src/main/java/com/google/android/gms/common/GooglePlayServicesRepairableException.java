/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.google.android.gms.common;

import android.content.Intent;
import com.google.android.gms.common.UserRecoverableException;

public class GooglePlayServicesRepairableException
extends UserRecoverableException {
    private final int zza;

    public GooglePlayServicesRepairableException(int n10, String string2, Intent intent) {
        super(string2, intent);
        this.zza = n10;
    }

    public int getConnectionStatusCode() {
        return this.zza;
    }
}

