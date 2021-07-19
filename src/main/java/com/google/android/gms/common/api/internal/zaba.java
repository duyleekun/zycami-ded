/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.api.internal.zaaw;

public final class zaba
implements ResultCallback {
    private final /* synthetic */ zaaw zahh;
    private final /* synthetic */ StatusPendingResult zahj;
    private final /* synthetic */ boolean zahk;
    private final /* synthetic */ GoogleApiClient zahl;

    public zaba(zaaw zaaw2, StatusPendingResult statusPendingResult, boolean bl2, GoogleApiClient googleApiClient) {
        this.zahh = zaaw2;
        this.zahj = statusPendingResult;
        this.zahk = bl2;
        this.zahl = googleApiClient;
    }

    public final /* synthetic */ void onResult(Result object) {
        object = (Status)object;
        Object object2 = Storage.getInstance(zaaw.zac(this.zahh));
        ((Storage)object2).zaf();
        boolean bl2 = ((Status)object).isSuccess();
        if (bl2 && (bl2 = ((GoogleApiClient)(object2 = this.zahh)).isConnected())) {
            object2 = this.zahh;
            ((GoogleApiClient)object2).reconnect();
        }
        object2 = this.zahj;
        ((BasePendingResult)object2).setResult((Result)object);
        boolean bl3 = this.zahk;
        if (bl3) {
            object = this.zahl;
            ((GoogleApiClient)object).disconnect();
        }
    }
}

