/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 */
package com.google.android.gms.common.api;

import android.accounts.Account;
import com.google.android.gms.common.api.Api$ApiOptions$HasOptions;
import com.google.android.gms.common.api.Api$ApiOptions$NotRequiredOptions;

public interface Api$ApiOptions$HasAccountOptions
extends Api$ApiOptions$HasOptions,
Api$ApiOptions$NotRequiredOptions {
    public Account getAccount();
}

