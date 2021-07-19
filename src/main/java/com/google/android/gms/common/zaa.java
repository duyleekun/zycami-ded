/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common;

import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final class zaa
implements Continuation {
    public zaa(GoogleApiAvailability googleApiAvailability) {
    }

    public final /* synthetic */ Object then(Task task) {
        task.getResult();
        return null;
    }
}

