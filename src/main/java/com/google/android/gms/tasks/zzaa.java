/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class zzaa
implements Continuation {
    private final /* synthetic */ Collection zza;

    public zzaa(Collection collection) {
        this.zza = collection;
    }

    public final /* synthetic */ Object then(Task arrayList) {
        boolean bl2;
        arrayList = new ArrayList<Object>();
        Iterator iterator2 = this.zza.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = ((Task)iterator2.next()).getResult();
            arrayList.add(object);
        }
        return arrayList;
    }
}

