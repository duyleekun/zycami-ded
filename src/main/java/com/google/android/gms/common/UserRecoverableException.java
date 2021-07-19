/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.google.android.gms.common;

import android.content.Intent;

public class UserRecoverableException
extends Exception {
    private final Intent zza;

    public UserRecoverableException(String string2, Intent intent) {
        super(string2);
        this.zza = intent;
    }

    public Intent getIntent() {
        Intent intent = this.zza;
        Intent intent2 = new Intent(intent);
        return intent2;
    }
}

