/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;
import java.util.Collection;

public final class zzz
implements Continuation {
    private final /* synthetic */ Collection zza;

    public zzz(Collection collection) {
        this.zza = collection;
    }

    public final /* synthetic */ Object then(Task arrayList) {
        arrayList = new ArrayList();
        Collection collection = this.zza;
        arrayList.addAll(collection);
        return Tasks.forResult(arrayList);
    }
}

