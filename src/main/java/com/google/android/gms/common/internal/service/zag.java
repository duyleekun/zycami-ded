/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.internal.service.Common;

public abstract class zag
extends BaseImplementation$ApiMethodImpl {
    public zag(GoogleApiClient googleApiClient) {
        Api api = Common.API;
        super(api, googleApiClient);
    }
}

