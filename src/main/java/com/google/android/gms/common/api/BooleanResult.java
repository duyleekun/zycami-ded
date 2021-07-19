/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

public class BooleanResult
implements Result {
    private final Status mStatus;
    private final boolean zabg;

    public BooleanResult(Status status, boolean bl2) {
        this.mStatus = status = (Status)Preconditions.checkNotNull(status, "Status must not be null");
        this.zabg = bl2;
    }

    public final boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof BooleanResult;
        if (!bl4) {
            return false;
        }
        object = (BooleanResult)object;
        Status status = this.mStatus;
        Status status2 = ((BooleanResult)object).mStatus;
        bl4 = status.equals(status2);
        if (bl4 && (bl4 = this.zabg) == (bl2 = ((BooleanResult)object).zabg)) {
            return bl3;
        }
        return false;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public boolean getValue() {
        return this.zabg;
    }

    public final int hashCode() {
        int n10 = (this.mStatus.hashCode() + 527) * 31;
        int n11 = this.zabg;
        return n10 + n11;
    }
}

