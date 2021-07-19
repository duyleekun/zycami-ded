/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Batch;
import com.google.android.gms.common.api.BatchResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult$StatusListener;
import com.google.android.gms.common.api.Status;

public final class zaa
implements PendingResult$StatusListener {
    private final /* synthetic */ Batch zabd;

    public zaa(Batch batch) {
        this.zabd = batch;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onComplete(Status object) {
        Object object2 = Batch.zaa(this.zabd);
        synchronized (object2) {
            int n10;
            Batch batch = this.zabd;
            int n11 = ((PendingResult)batch).isCanceled();
            if (n11 != 0) {
                return;
            }
            n11 = ((Status)object).isCanceled();
            boolean bl2 = true;
            if (n11 != 0) {
                object = this.zabd;
                Batch.zaa((Batch)object, bl2);
            } else {
                n10 = ((Status)object).isSuccess();
                if (n10 == 0) {
                    object = this.zabd;
                    Batch.zab((Batch)object, bl2);
                }
            }
            object = this.zabd;
            Batch.zab((Batch)object);
            object = this.zabd;
            n10 = Batch.zac((Batch)object);
            if (n10 == 0) {
                object = this.zabd;
                n10 = (int)(Batch.zad((Batch)object) ? 1 : 0);
                if (n10 != 0) {
                    object = this.zabd;
                    Batch.zae((Batch)object);
                } else {
                    object = this.zabd;
                    n10 = (int)(Batch.zaf((Batch)object) ? 1 : 0);
                    if (n10 != 0) {
                        n11 = 13;
                        object = new Status(n11);
                    } else {
                        object = Status.RESULT_SUCCESS;
                    }
                    batch = this.zabd;
                    PendingResult[] pendingResultArray = Batch.zag(batch);
                    BatchResult batchResult = new BatchResult((Status)object, pendingResultArray);
                    batch.setResult(batchResult);
                }
            }
            return;
        }
    }
}

