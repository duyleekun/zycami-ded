/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final class zacl
implements Continuation {
    public final /* synthetic */ Object then(Task object) {
        boolean bl2 = (Boolean)(object = (Boolean)((Task)object).getResult());
        if (bl2) {
            return null;
        }
        Status status = new Status(13, "listener already unregistered");
        object = new ApiException(status);
        throw object;
    }
}

