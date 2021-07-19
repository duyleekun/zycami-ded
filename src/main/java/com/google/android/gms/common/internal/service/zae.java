/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.service.zad;
import com.google.android.gms.common.internal.service.zaf;
import com.google.android.gms.common.internal.service.zah;
import com.google.android.gms.common.internal.service.zai;
import com.google.android.gms.common.internal.service.zal;

public final class zae
extends zah {
    public zae(zad zad2, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* synthetic */ void doExecute(Api$AnyClient object) {
        object = (zal)((zai)object).getService();
        zaf zaf2 = new zaf(this);
        object.zaa(zaf2);
    }
}

