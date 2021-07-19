/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.measurement.internal.zzaa;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzdz;
import com.google.android.gms.measurement.internal.zzkg;
import com.google.android.gms.measurement.internal.zzp;
import java.util.List;

public abstract class zzdy
extends zzb
implements zzdz {
    public zzdy() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final boolean zza(int n10, Parcel object, Parcel parcel, int n11) {
        switch (n10) {
            default: {
                return false;
            }
            case 20: {
                Object object2 = zzp.CREATOR;
                object2 = (zzp)zzc.zzc(object, object2);
                this.zzu((zzp)object2);
                parcel.writeNoException();
                break;
            }
            case 19: {
                Parcelable.Creator creator = Bundle.CREATOR;
                creator = (Bundle)zzc.zzc(object, creator);
                Parcelable.Creator creator2 = zzp.CREATOR;
                object = (zzp)zzc.zzc(object, creator2);
                this.zzt((Bundle)creator, (zzp)object);
                parcel.writeNoException();
                break;
            }
            case 18: {
                Object object3 = zzp.CREATOR;
                object3 = (zzp)zzc.zzc(object, object3);
                this.zzs((zzp)object3);
                parcel.writeNoException();
                break;
            }
            case 17: {
                Object object4 = object.readString();
                String string2 = object.readString();
                object = object.readString();
                object4 = this.zzr((String)object4, string2, (String)object);
                parcel.writeNoException();
                parcel.writeTypedList((List)object4);
                break;
            }
            case 16: {
                Object object5 = object.readString();
                String string3 = object.readString();
                Parcelable.Creator creator = zzp.CREATOR;
                object = (zzp)zzc.zzc(object, creator);
                object5 = this.zzq((String)object5, string3, (zzp)object);
                parcel.writeNoException();
                parcel.writeTypedList((List)object5);
                break;
            }
            case 15: {
                Object object6 = object.readString();
                String string4 = object.readString();
                String string5 = object.readString();
                boolean bl2 = zzc.zza(object);
                object6 = this.zzp((String)object6, string4, string5, bl2);
                parcel.writeNoException();
                parcel.writeTypedList((List)object6);
                break;
            }
            case 14: {
                Object object7 = object.readString();
                String string6 = object.readString();
                boolean bl3 = zzc.zza(object);
                Parcelable.Creator creator = zzp.CREATOR;
                object = (zzp)zzc.zzc(object, creator);
                object7 = this.zzo((String)object7, string6, bl3, (zzp)object);
                parcel.writeNoException();
                parcel.writeTypedList((List)object7);
                break;
            }
            case 13: {
                Object object8 = zzaa.CREATOR;
                object8 = (zzaa)zzc.zzc(object, object8);
                this.zzn((zzaa)object8);
                parcel.writeNoException();
                break;
            }
            case 12: {
                Object object9 = zzaa.CREATOR;
                object9 = (zzaa)zzc.zzc(object, object9);
                Parcelable.Creator creator = zzp.CREATOR;
                object = (zzp)zzc.zzc(object, creator);
                this.zzm((zzaa)object9, (zzp)object);
                parcel.writeNoException();
                break;
            }
            case 11: {
                Object object10 = zzp.CREATOR;
                object10 = (zzp)zzc.zzc(object, object10);
                object10 = this.zzl((zzp)object10);
                parcel.writeNoException();
                parcel.writeString((String)object10);
                break;
            }
            case 10: {
                long l10 = object.readLong();
                String string7 = object.readString();
                String string8 = object.readString();
                String string9 = object.readString();
                zzdy zzdy2 = this;
                this.zzk(l10, string7, string8, string9);
                parcel.writeNoException();
                break;
            }
            case 9: {
                Object object11 = zzas.CREATOR;
                object11 = (zzas)zzc.zzc(object, object11);
                object = object.readString();
                object11 = this.zzj((zzas)object11, (String)object);
                parcel.writeNoException();
                parcel.writeByteArray((byte[])object11);
                break;
            }
            case 7: {
                Object object12 = zzp.CREATOR;
                object12 = (zzp)zzc.zzc(object, object12);
                boolean bl4 = zzc.zza(object);
                object12 = this.zzi((zzp)object12, bl4);
                parcel.writeNoException();
                parcel.writeTypedList((List)object12);
                break;
            }
            case 6: {
                Object object13 = zzp.CREATOR;
                object13 = (zzp)zzc.zzc(object, object13);
                this.zzh((zzp)object13);
                parcel.writeNoException();
                break;
            }
            case 5: {
                Object object14 = zzas.CREATOR;
                object14 = (zzas)zzc.zzc(object, object14);
                String string10 = object.readString();
                object = object.readString();
                this.zzg((zzas)object14, string10, (String)object);
                parcel.writeNoException();
                break;
            }
            case 4: {
                Object object15 = zzp.CREATOR;
                object15 = (zzp)zzc.zzc(object, object15);
                this.zzf((zzp)object15);
                parcel.writeNoException();
                break;
            }
            case 2: {
                Object object16 = zzkg.CREATOR;
                object16 = (zzkg)zzc.zzc(object, object16);
                Parcelable.Creator creator = zzp.CREATOR;
                object = (zzp)zzc.zzc(object, creator);
                this.zze((zzkg)object16, (zzp)object);
                parcel.writeNoException();
                break;
            }
            case 1: {
                Object object17 = zzas.CREATOR;
                object17 = (zzas)zzc.zzc(object, object17);
                Parcelable.Creator creator = zzp.CREATOR;
                object = (zzp)zzc.zzc(object, creator);
                this.zzd((zzas)object17, (zzp)object);
                parcel.writeNoException();
            }
        }
        return true;
    }
}

