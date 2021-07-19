/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzfe;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzge;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

public final class zzfg
extends FutureTask
implements Comparable {
    public final boolean zza;
    public final /* synthetic */ zzfi zzb;
    private final long zzc;
    private final String zzd;

    public zzfg(zzfi object, Runnable object2, boolean bl2, String string2) {
        long l10;
        this.zzb = object;
        super((Runnable)object2, null);
        Preconditions.checkNotNull(string2);
        object2 = zzfi.zzs();
        this.zzc = l10 = ((AtomicLong)object2).getAndIncrement();
        this.zzd = string2;
        this.zza = bl2;
        long l11 = Long.MAX_VALUE;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            object = ((zzge)object).zzx.zzat().zzb();
            object2 = "Tasks index overflow";
            ((zzeg)object).zza((String)object2);
        }
    }

    public zzfg(zzfi object, Callable object2, boolean bl2, String object3) {
        long l10;
        this.zzb = object;
        super(object2);
        object2 = "Task exception on worker thread";
        Preconditions.checkNotNull(object2);
        object3 = zzfi.zzs();
        this.zzc = l10 = ((AtomicLong)object3).getAndIncrement();
        this.zzd = object2;
        this.zza = bl2;
        long l11 = Long.MAX_VALUE;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            object = ((zzge)object).zzx.zzat().zzb();
            object2 = "Tasks index overflow";
            ((zzeg)object).zza((String)object2);
        }
    }

    public final void setException(Throwable throwable) {
        Object object = this.zzb.zzx.zzat().zzb();
        Object object2 = this.zzd;
        ((zzeg)object).zzb((String)object2, throwable);
        boolean bl2 = throwable instanceof zzfe;
        if (bl2 && (object = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            object2 = Thread.currentThread();
            object.uncaughtException((Thread)object2, throwable);
        }
        super.setException(throwable);
    }
}

