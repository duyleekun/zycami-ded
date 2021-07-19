/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Batch;
import com.google.android.gms.common.api.BatchResultToken;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import java.util.ArrayList;
import java.util.List;

public final class Batch$Builder {
    private List zabe;
    private GoogleApiClient zabf;

    public Batch$Builder(GoogleApiClient googleApiClient) {
        ArrayList arrayList;
        this.zabe = arrayList = new ArrayList();
        this.zabf = googleApiClient;
    }

    public final BatchResultToken add(PendingResult pendingResult) {
        int n10 = this.zabe.size();
        BatchResultToken batchResultToken = new BatchResultToken(n10);
        this.zabe.add(pendingResult);
        return batchResultToken;
    }

    public final Batch build() {
        List list = this.zabe;
        GoogleApiClient googleApiClient = this.zabf;
        Batch batch = new Batch(list, googleApiClient, null);
        return batch;
    }
}

