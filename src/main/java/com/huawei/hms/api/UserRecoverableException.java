/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package com.huawei.hms.api;

import android.content.Intent;

public class UserRecoverableException
extends Exception {
    private final Intent a;

    public UserRecoverableException(String string2, Intent intent) {
        super(string2);
        this.a = intent;
    }

    public Intent getIntent() {
        Intent intent = this.a;
        Intent intent2 = new Intent(intent);
        return intent2;
    }
}

