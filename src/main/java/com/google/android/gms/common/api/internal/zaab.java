/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult$StatusListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.zaac;
import com.google.android.gms.common.api.internal.zaad;
import com.google.android.gms.common.api.internal.zacp;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zaab {
    private final Map zafk;
    private final Map zafl;

    public zaab() {
        Map map = new Map();
        map = Collections.synchronizedMap(map);
        this.zafk = map;
        map = new Map();
        this.zafl = map = Collections.synchronizedMap(map);
    }

    public static /* synthetic */ Map zaa(zaab zaab2) {
        return zaab2.zafk;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void zaa(boolean bl2, Status status) {
        boolean bl3;
        Object object;
        Object object2;
        Object object3;
        Object object4 = this.zafk;
        synchronized (object4) {
            object3 = this.zafk;
            object2 = new HashMap(object3);
        }
        object3 = this.zafl;
        synchronized (object3) {
            object = this.zafl;
            object4 = new HashMap(object);
        }
        object2 = object2.entrySet().iterator();
        while (bl3 = object2.hasNext()) {
            boolean bl4;
            object3 = (Map.Entry)object2.next();
            if (!bl2 && !(bl4 = ((Boolean)(object = (Boolean)object3.getValue())).booleanValue())) continue;
            object3 = (BasePendingResult)object3.getKey();
            ((BasePendingResult)object3).zab(status);
        }
        object4 = object4.entrySet().iterator();
        boolean bl5;
        while (bl5 = object4.hasNext()) {
            object2 = (Map.Entry)object4.next();
            if (!bl2 && !(bl3 = ((Boolean)(object3 = (Boolean)object2.getValue())).booleanValue())) continue;
            object2 = (TaskCompletionSource)object2.getKey();
            object3 = new ApiException(status);
            ((TaskCompletionSource)object2).trySetException((Exception)object3);
        }
        return;
    }

    public static /* synthetic */ Map zab(zaab zaab2) {
        return zaab2.zafl;
    }

    public final void zaa(BasePendingResult basePendingResult, boolean bl2) {
        Map map = this.zafk;
        Object object = bl2;
        map.put(basePendingResult, object);
        object = new zaac(this, basePendingResult);
        ((PendingResult)basePendingResult).addStatusListener((PendingResult$StatusListener)object);
    }

    public final void zaa(TaskCompletionSource taskCompletionSource, boolean bl2) {
        Object object = this.zafl;
        Object object2 = bl2;
        object.put(taskCompletionSource, object2);
        object2 = taskCompletionSource.getTask();
        object = new zaad(this, taskCompletionSource);
        ((Task)object2).addOnCompleteListener((OnCompleteListener)object);
    }

    public final boolean zaag() {
        Map map = this.zafk;
        boolean bl2 = map.isEmpty();
        return !bl2 || !(bl2 = (map = this.zafl).isEmpty());
        {
        }
    }

    public final void zaah() {
        Status status = GoogleApiManager.zahx;
        this.zaa(false, status);
    }

    public final void zaai() {
        Status status = zacp.zakx;
        this.zaa(true, status);
    }
}

