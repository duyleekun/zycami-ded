/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.mlkit.common.sdkinternal;

import android.util.Log;
import com.google.android.gms.internal.mlkit_common.zzav$zzad;
import com.google.android.gms.internal.mlkit_common.zzav$zzad$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzaj;
import com.google.android.gms.internal.mlkit_common.zzav$zzaj$zza;
import com.google.android.gms.internal.mlkit_common.zzav$zzaj$zzb;
import com.google.android.gms.internal.mlkit_common.zzbg;
import com.google.android.gms.internal.mlkit_common.zzds;
import com.google.mlkit.common.sdkinternal.Cleaner;
import com.google.mlkit.common.sdkinternal.Cleaner$Cleanable;
import com.google.mlkit.common.sdkinternal.zze;
import java.io.Closeable;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class CloseGuard
implements Closeable {
    public static final int API_TRANSLATE = 1;
    private final AtomicBoolean zza;
    private final String zzb;
    private final Runnable zzc;
    private final Cleaner$Cleanable zzd;
    private final zzds zze;
    private final zzav$zzaj$zza zzf;

    public CloseGuard(Object object, zzav$zzaj$zza object2, Cleaner cleaner, zzds zzds2, Runnable runnable) {
        this.zzf = object2;
        this.zze = zzds2;
        this.zza = object2 = new AtomicBoolean();
        this.zzb = object2 = object.toString();
        this.zzc = runnable;
        object2 = new zze(this);
        this.zzd = object = cleaner.register(object, (Runnable)object2);
    }

    public void close() {
        this.zza.set(true);
        this.zzd.clean();
    }

    public final /* synthetic */ void zza() {
        Object object = this.zza;
        boolean bl2 = ((AtomicBoolean)object).get();
        if (!bl2) {
            object = Locale.ENGLISH;
            int n10 = 1;
            Object object2 = new Object[n10];
            String string2 = this.zzb;
            object2[0] = string2;
            object = String.format((Locale)object, "%s has not been closed", (Object[])object2);
            Log.e((String)"MlKitCloseGuard", (String)object);
            object = zzav$zzad.zzb();
            object2 = zzav$zzaj.zza();
            Enum enum_ = this.zzf;
            object2 = ((zzav$zzaj$zzb)object2).zza((zzav$zzaj$zza)enum_);
            ((zzav$zzad$zza)object).zza((zzav$zzaj$zzb)object2);
            object2 = this.zze;
            enum_ = zzbg.zzb;
            ((zzds)object2).zza((zzav$zzad$zza)object, (zzbg)enum_);
        }
        this.zzc.run();
    }
}

