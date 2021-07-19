/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzga;
import com.google.android.gms.internal.measurement.zzge;
import com.google.android.gms.internal.measurement.zzhe;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzjf;
import com.google.android.gms.internal.measurement.zzji;
import com.google.android.gms.internal.measurement.zzjv;
import java.io.IOException;

public class zzho
extends zzga {
    public zzhs zza;
    public boolean zzb;
    private final zzhs zzc;

    public zzho(zzhs zzhs2) {
        this.zzc = zzhs2;
        this.zza = zzhs2 = (zzhs)zzhs2.zzl(4, null, null);
        this.zzb = false;
    }

    private static final void zza(zzhs zzhs2, zzhs zzhs3) {
        zzjf zzjf2 = zzjf.zza();
        Class<?> clazz = zzhs2.getClass();
        zzjf2.zzb(clazz).zzd(zzhs2, zzhs3);
    }

    public final zzhs zzaA() {
        Object object;
        byte by2;
        zzhs zzhs2 = this.zzaz();
        Object object2 = (Byte)zzhs2.zzl(by2 = 1, null, null);
        byte by3 = (Byte)object2;
        if (by3 != by2) {
            if (by3 == 0) {
                by2 = 0;
                object = null;
            } else {
                object2 = zzjf.zza();
                Class<?> clazz = zzhs2.getClass();
                by3 = (byte)((object2 = ((zzjf)object2).zzb(clazz)).zzj(zzhs2) ? 1 : 0);
                if (by2 != by3) {
                    by2 = 0;
                    object = null;
                } else {
                    object = zzhs2;
                }
                int n10 = 2;
                zzhs2.zzl(n10, object, null);
                by2 = by3;
            }
        }
        if (by2 != 0) {
            return zzhs2;
        }
        object = new zzjv(zzhs2);
        throw object;
    }

    public final zzho zzaB(zzhs zzhs2) {
        boolean bl2 = this.zzb;
        if (bl2) {
            this.zzax();
            bl2 = false;
            this.zzb = false;
        }
        zzho.zza(this.zza, zzhs2);
        return this;
    }

    public final zzho zzaC(byte[] byArray, int n10, int n11, zzhe zzhe2) {
        Object object;
        n10 = (int)(this.zzb ? 1 : 0);
        if (n10 != 0) {
            this.zzax();
            n10 = 0;
            object = null;
            this.zzb = false;
        }
        object = zzjf.zza();
        Object object2 = this.zza;
        object2 = object2.getClass();
        zzji zzji2 = ((zzjf)object).zzb((Class)object2);
        zzhs zzhs2 = this.zza;
        zzge zzge2 = new zzge(zzhe2);
        try {
            zzji2.zzh(zzhs2, byArray, 0, n11, zzge2);
            return this;
        }
        catch (IOException iOException) {
            object = new RuntimeException("Reading from byte array should not throw IOException.", iOException);
            throw object;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw zzic.zza();
        }
        catch (zzic zzic2) {
            throw zzic2;
        }
    }

    public void zzax() {
        zzhs zzhs2 = (zzhs)this.zza.zzl(4, null, null);
        zzhs zzhs3 = this.zza;
        zzho.zza(zzhs2, zzhs3);
        this.zza = zzhs2;
    }

    public final zzho zzay() {
        zzho zzho2 = (zzho)this.zzc.zzl(5, null, null);
        zzhs zzhs2 = this.zzaz();
        zzho2.zzaB(zzhs2);
        return zzho2;
    }

    public zzhs zzaz() {
        boolean bl2 = this.zzb;
        if (bl2) {
            return this.zza;
        }
        zzhs zzhs2 = this.zza;
        zzjf zzjf2 = zzjf.zza();
        Class<?> clazz = zzhs2.getClass();
        zzjf2.zzb(clazz).zzi(zzhs2);
        this.zzb = true;
        return this.zza;
    }
}

