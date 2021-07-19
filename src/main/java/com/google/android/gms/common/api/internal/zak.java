/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Set;

public final class zak {
    private final ArrayMap zaay;
    private final ArrayMap zadb;
    private final TaskCompletionSource zadc;
    private int zadd;
    private boolean zade;

    public zak(Iterable object) {
        int n10;
        Object object2 = new ArrayMap();
        this.zadb = object2;
        this.zadc = object2 = new TaskCompletionSource();
        boolean bl2 = false;
        this.zade = false;
        this.zaay = object2 = new ArrayMap();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (GoogleApi)object.next();
            ArrayMap arrayMap = this.zaay;
            object2 = ((GoogleApi)object2).zak();
            arrayMap.put(object2, (Object)null);
        }
        this.zadd = n10 = this.zaay.keySet().size();
    }

    public final Task getTask() {
        return this.zadc.getTask();
    }

    public final void zaa(zai object, ConnectionResult object2, String string2) {
        this.zaay.put(object, object2);
        ArrayMap arrayMap = this.zadb;
        arrayMap.put(object, string2);
        int n10 = this.zadd;
        int n11 = 1;
        this.zadd = n10 -= n11;
        n10 = (int)(((ConnectionResult)object2).isSuccess() ? 1 : 0);
        if (n10 == 0) {
            this.zade = n11;
        }
        if ((n10 = this.zadd) == 0) {
            n10 = (int)(this.zade ? 1 : 0);
            if (n10 != 0) {
                object2 = this.zaay;
                object = new AvailabilityException((ArrayMap)object2);
                this.zadc.setException((Exception)object);
                return;
            }
            object = this.zadc;
            object2 = this.zadb;
            ((TaskCompletionSource)object).setResult(object2);
        }
    }

    public final Set zap() {
        return this.zaay.keySet();
    }
}

