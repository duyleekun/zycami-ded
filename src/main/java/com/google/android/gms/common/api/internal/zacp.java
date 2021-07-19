/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IBinder$DeathRecipient
 *  android.os.RemoteException
 */
package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation$ApiMethodImpl;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zacq;
import com.google.android.gms.common.api.internal.zacr;
import com.google.android.gms.common.api.internal.zacs;
import com.google.android.gms.common.api.zac;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zacp {
    public static final Status zakx;
    private static final BasePendingResult[] zaky;
    private final Map zagz;
    public final Set zakz;
    private final zacs zala;

    static {
        Status status;
        zakx = status = new Status(8, "The connection to Google Play services was lost");
        zaky = new BasePendingResult[0];
    }

    public zacp(Map map) {
        Object object = new WeakHashMap();
        this.zakz = object = Collections.synchronizedSet(Collections.newSetFromMap(object));
        this.zala = object = new zacq(this);
        this.zagz = map;
    }

    public final void release() {
        BasePendingResult[] basePendingResultArray = this.zakz;
        BasePendingResult[] basePendingResultArray2 = zaky;
        for (BasePendingResult basePendingResult : basePendingResultArray.toArray(basePendingResultArray2)) {
            int n10;
            boolean bl2 = false;
            Set set = null;
            basePendingResult.zaa((zacs)null);
            Object object = ((PendingResult)basePendingResult).zam();
            if (object == null) {
                bl2 = basePendingResult.zat();
                if (!bl2) continue;
                set = this.zakz;
                set.remove(basePendingResult);
                continue;
            }
            ((PendingResult)basePendingResult).setResultCallback(null);
            object = this.zagz;
            Object object2 = basePendingResult;
            object2 = ((BaseImplementation$ApiMethodImpl)basePendingResult).getClientKey();
            object = ((Api$Client)object.get(object2)).getServiceBrokerBinder();
            boolean bl3 = basePendingResult.isReady();
            if (bl3) {
                object2 = new zacr(basePendingResult, null, (IBinder)object, null);
                basePendingResult.zaa((zacs)object2);
            } else if (object != null && (bl3 = object.isBinderAlive())) {
                object2 = new zacr(basePendingResult, null, (IBinder)object, null);
                basePendingResult.zaa((zacs)object2);
                try {
                    object.linkToDeath((IBinder.DeathRecipient)object2, 0);
                }
                catch (RemoteException remoteException) {
                    ((PendingResult)basePendingResult).cancel();
                    object = ((PendingResult)basePendingResult).zam();
                    n10 = (Integer)object;
                    ((zac)null).remove(n10);
                }
            } else {
                basePendingResult.zaa((zacs)null);
                ((PendingResult)basePendingResult).cancel();
                object = ((PendingResult)basePendingResult).zam();
                n10 = (Integer)object;
                ((zac)null).remove(n10);
            }
            set = this.zakz;
            set.remove(basePendingResult);
        }
    }

    public final void zab(BasePendingResult basePendingResult) {
        this.zakz.add(basePendingResult);
        zacs zacs2 = this.zala;
        basePendingResult.zaa(zacs2);
    }

    public final void zabx() {
        BasePendingResult[] basePendingResultArray = this.zakz;
        BasePendingResult[] basePendingResultArray2 = zaky;
        for (BasePendingResult basePendingResult : basePendingResultArray.toArray(basePendingResultArray2)) {
            Status status = zakx;
            basePendingResult.zab(status);
        }
    }
}

