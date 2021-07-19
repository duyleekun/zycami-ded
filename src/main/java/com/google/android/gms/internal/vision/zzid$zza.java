/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzge;
import com.google.android.gms.internal.vision.zzgh;
import com.google.android.gms.internal.vision.zzgm;
import com.google.android.gms.internal.vision.zzhe;
import com.google.android.gms.internal.vision.zzhj;
import com.google.android.gms.internal.vision.zzho;
import com.google.android.gms.internal.vision.zzid;
import com.google.android.gms.internal.vision.zzid$zzf;
import com.google.android.gms.internal.vision.zzin;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjp;
import com.google.android.gms.internal.vision.zzkb;
import com.google.android.gms.internal.vision.zzkc;
import com.google.android.gms.internal.vision.zzkf;
import com.google.android.gms.internal.vision.zzku;
import java.io.IOException;

public class zzid$zza
extends zzgh {
    private final zzid zzxw;
    public zzid zzxx;
    public boolean zzxy;

    public zzid$zza(zzid zzid2) {
        this.zzxw = zzid2;
        int n10 = zzid$zzf.zzyk;
        this.zzxx = zzid2 = (zzid)zzid2.zza(n10, null, null);
        this.zzxy = false;
    }

    private static void zza(zzid zzid2, zzid zzid3) {
        zzkb.zzik().zzx(zzid2).zzd(zzid2, zzid3);
    }

    private final zzid$zza zzb(zzhe object, zzho object2) {
        Object object3;
        boolean bl2 = this.zzxy;
        if (bl2) {
            this.zzgs();
            bl2 = false;
            object3 = null;
            this.zzxy = false;
        }
        try {
            object3 = zzkb.zzik();
        }
        catch (RuntimeException runtimeException) {
            object2 = runtimeException.getCause();
            boolean bl3 = object2 instanceof IOException;
            if (bl3) {
                throw (IOException)runtimeException.getCause();
            }
            throw runtimeException;
        }
        zzid zzid2 = this.zzxx;
        object3 = ((zzkb)object3).zzx(zzid2);
        zzid2 = this.zzxx;
        object = zzhj.zza((zzhe)object);
        object3.zza(zzid2, (zzkc)object, (zzho)object2);
        return this;
    }

    private final zzid$zza zzb(byte[] byArray, int n10, int n11, zzho zzho2) {
        Object object;
        n10 = (int)(this.zzxy ? 1 : 0);
        if (n10 != 0) {
            this.zzgs();
            n10 = 0;
            object = null;
            this.zzxy = false;
        }
        object = zzkb.zzik();
        zzid zzid2 = this.zzxx;
        zzkf zzkf2 = ((zzkb)object).zzx(zzid2);
        zzid zzid3 = this.zzxx;
        zzgm zzgm2 = new zzgm(zzho2);
        try {
            zzkf2.zza(zzid3, byArray, 0, n11, zzgm2);
            return this;
        }
        catch (IOException iOException) {
            object = new RuntimeException("Reading from byte array should not throw IOException.", iOException);
            throw object;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw zzin.zzhh();
        }
        catch (zzin zzin2) {
            throw zzin2;
        }
    }

    public /* synthetic */ Object clone() {
        zzjp zzjp2 = this.zzxw;
        int n10 = zzid$zzf.zzyl;
        zzjp2 = (zzid$zza)((zzid)zzjp2).zza(n10, null, null);
        zzid zzid2 = (zzid)this.zzgv();
        ((zzid$zza)zzjp2).zza(zzid2);
        return zzjp2;
    }

    public final boolean isInitialized() {
        return zzid.zza(this.zzxx, false);
    }

    public final /* synthetic */ zzgh zza(zzge zzge2) {
        zzge2 = (zzid)zzge2;
        return this.zza((zzid)zzge2);
    }

    public final /* synthetic */ zzgh zza(zzhe zzhe2, zzho zzho2) {
        return this.zzb(zzhe2, zzho2);
    }

    public final /* synthetic */ zzgh zza(byte[] byArray, int n10, int n11, zzho zzho2) {
        return this.zzb(byArray, 0, n11, zzho2);
    }

    public final zzid$zza zza(zzid zzid2) {
        boolean bl2 = this.zzxy;
        if (bl2) {
            this.zzgs();
            bl2 = false;
            this.zzxy = false;
        }
        zzid$zza.zza(this.zzxx, zzid2);
        return this;
    }

    public final /* synthetic */ zzgh zzeh() {
        return (zzid$zza)((zzgh)this).clone();
    }

    public void zzgs() {
        zzid zzid2 = this.zzxx;
        int n10 = zzid$zzf.zzyk;
        zzid2 = (zzid)zzid2.zza(n10, null, null);
        zzid zzid3 = this.zzxx;
        zzid$zza.zza(zzid2, zzid3);
        this.zzxx = zzid2;
    }

    public zzid zzgt() {
        boolean bl2 = this.zzxy;
        if (bl2) {
            return this.zzxx;
        }
        zzid zzid2 = this.zzxx;
        zzkb.zzik().zzx(zzid2).zzj(zzid2);
        this.zzxy = true;
        return this.zzxx;
    }

    public final zzid zzgu() {
        zzid zzid2 = (zzid)this.zzgv();
        boolean bl2 = zzid2.isInitialized();
        if (bl2) {
            return zzid2;
        }
        zzku zzku2 = new zzku(zzid2);
        throw zzku2;
    }

    public /* synthetic */ zzjn zzgv() {
        return this.zzgt();
    }

    public /* synthetic */ zzjn zzgw() {
        return this.zzgu();
    }

    public final /* synthetic */ zzjn zzgx() {
        return this.zzxw;
    }
}

