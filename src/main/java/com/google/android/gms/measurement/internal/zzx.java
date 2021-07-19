/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzby;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzcf;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzdu;
import com.google.android.gms.internal.measurement.zzlo;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzed;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzkf;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzy;

public final class zzx
extends zzw {
    public final /* synthetic */ zzy zza;
    private final zzcf zzh;

    public zzx(zzy zzy2, String string2, int n10, zzcf zzcf2) {
        this.zza = zzy2;
        super(string2, n10);
        this.zzh = zzcf2;
    }

    public final int zza() {
        return this.zzh.zzb();
    }

    public final boolean zzb() {
        return true;
    }

    public final boolean zzc() {
        return false;
    }

    public final boolean zzd(Long object, Long number, zzdu zzhs2, boolean bl2) {
        zzcf zzcf2;
        Object object2;
        Object object3;
        zzlo.zzb();
        zzae zzae2 = this.zza.zzx.zzc();
        Object object4 = this.zzb;
        Object object5 = zzdw.zzY;
        boolean bl3 = zzae2.zzn((String)object4, (zzdv)object5);
        object4 = this.zzh;
        boolean bl4 = ((zzcf)object4).zze();
        object5 = this.zzh;
        boolean bl5 = ((zzcf)object5).zzf();
        zzcf zzcf3 = this.zzh;
        boolean bl6 = zzcf3.zzh();
        Boolean bl7 = null;
        boolean bl8 = true;
        if (!(bl4 || bl5 || bl6)) {
            bl4 = false;
            object4 = null;
        } else {
            bl4 = bl8;
        }
        bl5 = false;
        object5 = null;
        if (bl2 && !bl4) {
            object = this.zza.zzx.zzat().zzk();
            int n10 = this.zzc;
            number = n10;
            zzhs2 = this.zzh;
            boolean n11 = ((zzcf)zzhs2).zza();
            if (n11) {
                zzhs2 = this.zzh;
                int n12 = ((zzcf)zzhs2).zzb();
                object5 = n12;
            }
            ((zzeg)object).zzc("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", number, object5);
            return bl8;
        }
        Object object6 = this.zzh.zzd();
        boolean bl9 = ((zzby)object6).zzf();
        boolean bl10 = ((zzdu)zzhs2).zzf();
        if (bl10) {
            bl10 = ((zzby)object6).zzc();
            if (!bl10) {
                object6 = this.zza.zzx.zzat().zze();
                object3 = this.zza.zzx.zzm();
                object2 = ((zzdu)zzhs2).zzc();
                object3 = ((zzed)object3).zze((String)object2);
                object2 = "No number filter for long property. property";
                ((zzeg)object6).zzb((String)object2, object3);
            } else {
                long l10 = ((zzdu)zzhs2).zzg();
                object5 = ((zzby)object6).zzd();
                object5 = zzw.zze(zzw.zzg(l10, (zzcd)object5), bl9);
            }
        } else {
            bl10 = ((zzdu)zzhs2).zzh();
            if (bl10) {
                bl10 = ((zzby)object6).zzc();
                if (!bl10) {
                    object6 = this.zza.zzx.zzat().zze();
                    object3 = this.zza.zzx.zzm();
                    object2 = ((zzdu)zzhs2).zzc();
                    object3 = ((zzed)object3).zze((String)object2);
                    object2 = "No number filter for double property. property";
                    ((zzeg)object6).zzb((String)object2, object3);
                } else {
                    double d10 = ((zzdu)zzhs2).zzi();
                    object5 = ((zzby)object6).zzd();
                    object5 = zzw.zze(zzw.zzh(d10, (zzcd)object5), bl9);
                }
            } else {
                bl10 = ((zzdu)zzhs2).zzd();
                if (bl10) {
                    bl10 = ((zzby)object6).zza();
                    if (!bl10) {
                        bl10 = ((zzby)object6).zzc();
                        if (!bl10) {
                            object6 = this.zza.zzx.zzat().zze();
                            object3 = this.zza.zzx.zzm();
                            object2 = ((zzdu)zzhs2).zzc();
                            object3 = ((zzed)object3).zze((String)object2);
                            object2 = "No string or number filter defined. property";
                            ((zzeg)object6).zzb((String)object2, object3);
                        } else {
                            object2 = ((zzdu)zzhs2).zze();
                            bl10 = zzkf.zzl((String)object2);
                            if (bl10) {
                                object5 = ((zzdu)zzhs2).zze();
                                object6 = ((zzby)object6).zzd();
                                object5 = zzw.zze(zzw.zzi((String)object5, (zzcd)object6), bl9);
                            } else {
                                object6 = this.zza.zzx.zzat().zze();
                                object3 = this.zza.zzx.zzm();
                                object2 = ((zzdu)zzhs2).zzc();
                                object3 = ((zzed)object3).zze((String)object2);
                                object2 = ((zzdu)zzhs2).zze();
                                String string2 = "Invalid user property value for Numeric number filter. property, value";
                                ((zzeg)object6).zzc(string2, object3, object2);
                            }
                        }
                    } else {
                        object5 = ((zzdu)zzhs2).zze();
                        object6 = ((zzby)object6).zzb();
                        object2 = this.zza.zzx.zzat();
                        object5 = zzw.zze(zzw.zzf((String)object5, (zzck)object6, (zzei)object2), bl9);
                    }
                } else {
                    object6 = this.zza.zzx.zzat().zze();
                    object3 = this.zza.zzx.zzm();
                    object2 = ((zzdu)zzhs2).zzc();
                    object3 = ((zzed)object3).zze((String)object2);
                    object2 = "User property has no value, property";
                    ((zzeg)object6).zzb((String)object2, object3);
                }
            }
        }
        object6 = this.zza.zzx.zzat().zzk();
        object3 = object5 == null ? "null" : object5;
        object2 = "Property filter result";
        ((zzeg)object6).zzb((String)object2, object3);
        if (object5 == null) {
            return false;
        }
        this.zzd = bl7 = Boolean.TRUE;
        if (bl6 && !(bl6 = ((Boolean)object5).booleanValue())) {
            return bl8;
        }
        if (!bl2 || (bl2 = (zzcf2 = this.zzh).zze())) {
            this.zze = object5;
        }
        if ((bl2 = ((Boolean)object5).booleanValue()) && bl4 && (bl2 = ((zzdu)zzhs2).zza())) {
            boolean bl11;
            long l11 = ((zzdu)zzhs2).zzb();
            if (object != null) {
                l11 = (Long)object;
            }
            if (bl3 && (bl11 = ((zzcf)(object = this.zzh)).zze()) && !(bl11 = ((zzcf)(object = this.zzh)).zzf()) && number != null) {
                l11 = (Long)number;
            }
            if (bl11 = ((zzcf)(object = this.zzh)).zzf()) {
                this.zzg = object = Long.valueOf(l11);
            } else {
                this.zzf = object = Long.valueOf(l11);
            }
        }
        return bl8;
    }
}

