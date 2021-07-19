/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.BatchResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.zaa;
import java.util.List;

public final class Batch
extends BasePendingResult {
    private final Object mLock;
    private int zaaz;
    private boolean zaba;
    private boolean zabb;
    private final PendingResult[] zabc;

    private Batch(List object, GoogleApiClient pendingResultArray) {
        super((GoogleApiClient)pendingResultArray);
        int n10;
        pendingResultArray = new Object();
        this.mLock = pendingResultArray;
        this.zaaz = n10 = object.size();
        pendingResultArray = new PendingResult[n10];
        this.zabc = pendingResultArray;
        int n11 = object.isEmpty();
        if (n11 != 0) {
            Status status = Status.RESULT_SUCCESS;
            object = new BatchResult(status, pendingResultArray);
            this.setResult((Result)object);
            return;
        }
        pendingResultArray = null;
        for (n10 = 0; n10 < (n11 = object.size()); ++n10) {
            PendingResult pendingResult;
            this.zabc[n10] = pendingResult = (PendingResult)object.get(n10);
            zaa zaa2 = new zaa(this);
            pendingResult.addStatusListener(zaa2);
        }
    }

    public /* synthetic */ Batch(List list, GoogleApiClient googleApiClient, zaa zaa2) {
        this(list, googleApiClient);
    }

    public static /* synthetic */ Object zaa(Batch batch) {
        return batch.mLock;
    }

    public static /* synthetic */ boolean zaa(Batch batch, boolean bl2) {
        batch.zabb = bl2 = true;
        return bl2;
    }

    public static /* synthetic */ int zab(Batch batch) {
        int n10;
        int n11 = batch.zaaz;
        batch.zaaz = n10 = n11 + -1;
        return n11;
    }

    public static /* synthetic */ boolean zab(Batch batch, boolean bl2) {
        batch.zaba = bl2 = true;
        return bl2;
    }

    public static /* synthetic */ int zac(Batch batch) {
        return batch.zaaz;
    }

    public static /* synthetic */ boolean zad(Batch batch) {
        return batch.zabb;
    }

    public static /* synthetic */ void zae(Batch batch) {
        super.cancel();
    }

    public static /* synthetic */ boolean zaf(Batch batch) {
        return batch.zaba;
    }

    public static /* synthetic */ PendingResult[] zag(Batch batch) {
        return batch.zabc;
    }

    public final void cancel() {
        super.cancel();
        for (PendingResult pendingResult : this.zabc) {
            pendingResult.cancel();
        }
    }

    public final BatchResult createFailedResult(Status status) {
        PendingResult[] pendingResultArray = this.zabc;
        BatchResult batchResult = new BatchResult(status, pendingResultArray);
        return batchResult;
    }
}

