/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IBinder$DeathRecipient
 */
package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zacq;
import com.google.android.gms.common.api.internal.zacs;
import com.google.android.gms.common.api.zac;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;

public final class zacr
implements IBinder.DeathRecipient,
zacs {
    private final WeakReference zalc;
    private final WeakReference zald;
    private final WeakReference zale;

    private zacr(BasePendingResult weakReference, zac weakReference2, IBinder iBinder) {
        WeakReference<zac> weakReference3;
        this.zald = weakReference3 = new WeakReference<zac>((zac)((Object)weakReference2));
        this.zalc = weakReference2 = new WeakReference<BasePendingResult>((BasePendingResult)((Object)weakReference));
        this.zale = weakReference = new WeakReference<IBinder>(iBinder);
    }

    public /* synthetic */ zacr(BasePendingResult basePendingResult, zac zac2, IBinder iBinder, zacq zacq2) {
        this(basePendingResult, null, iBinder);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void zaby() {
        Object object = (BasePendingResult)this.zalc.get();
        zac zac2 = (zac)this.zald.get();
        if (zac2 != null && object != null) {
            object = ((PendingResult)object).zam();
            int n10 = (Integer)object;
            zac2.remove(n10);
        }
        if ((object = (IBinder)this.zale.get()) == null) return;
        zac2 = null;
        try {
            object.unlinkToDeath((IBinder.DeathRecipient)this, 0);
            return;
        }
        catch (NoSuchElementException noSuchElementException) {
            return;
        }
    }

    public final void binderDied() {
        this.zaby();
    }

    public final void zac(BasePendingResult basePendingResult) {
        this.zaby();
    }
}

