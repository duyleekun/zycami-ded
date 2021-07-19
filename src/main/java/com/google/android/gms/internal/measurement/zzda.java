/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzcs;
import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzde;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zziy;
import java.util.Collections;
import java.util.List;

public final class zzda
extends zzho
implements zziy {
    private zzda() {
        zzdb zzdb2 = zzdb.zzm();
        super(zzdb2);
    }

    public /* synthetic */ zzda(zzcs object) {
        object = zzdb.zzm();
        super((zzhs)object);
    }

    public final List zza() {
        return Collections.unmodifiableList(((zzdb)this.zza).zza());
    }

    public final int zzb() {
        return ((zzdb)this.zza).zzb();
    }

    public final zzdf zzc(int n10) {
        return ((zzdb)this.zza).zzc(n10);
    }

    public final zzda zzd(int n10, zzdf zzdf2) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzdb.zzn((zzdb)this.zza, n10, zzdf2);
        return this;
    }

    public final zzda zze(int n10, zzde zziy2) {
        zzdb zzdb2;
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            zzdb2 = null;
            this.zzb = false;
        }
        zzdb2 = (zzdb)this.zza;
        zziy2 = (zzdf)zziy2.zzaA();
        zzdb.zzn(zzdb2, n10, (zzdf)zziy2);
        return this;
    }

    public final zzda zzf(zzdf zzdf2) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzdb.zzo((zzdb)this.zza, zzdf2);
        return this;
    }

    public final zzda zzg(zzde zziy2) {
        zzdb zzdb2;
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            zzdb2 = null;
            this.zzb = false;
        }
        zzdb2 = (zzdb)this.zza;
        zziy2 = (zzdf)zziy2.zzaA();
        zzdb.zzo(zzdb2, (zzdf)zziy2);
        return this;
    }

    public final zzda zzh(Iterable iterable) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzdb.zzp((zzdb)this.zza, iterable);
        return this;
    }

    public final zzda zzi() {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzdb.zzq((zzdb)this.zza);
        return this;
    }

    public final zzda zzj(int n10) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzdb.zzr((zzdb)this.zza, n10);
        return this;
    }

    public final String zzk() {
        return ((zzdb)this.zza).zzd();
    }

    public final zzda zzl(String string2) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzdb.zzs((zzdb)this.zza, string2);
        return this;
    }

    public final boolean zzm() {
        return ((zzdb)this.zza).zze();
    }

    public final long zzn() {
        return ((zzdb)this.zza).zzf();
    }

    public final zzda zzo(long l10) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzdb.zzt((zzdb)this.zza, l10);
        return this;
    }

    public final long zzp() {
        return ((zzdb)this.zza).zzh();
    }

    public final zzda zzq(long l10) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzdb.zzu((zzdb)this.zza, l10);
        return this;
    }
}

