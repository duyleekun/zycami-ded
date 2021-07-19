/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.clearcut.zzb;
import com.google.android.gms.internal.clearcut.zzc;
import com.google.android.gms.internal.clearcut.zzl;

public abstract class zzm
extends zzb
implements zzl {
    public zzm() {
        super("com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
    }

    public final boolean dispatchTransaction(int n10, Parcel zzeArray, Parcel parcel, int n11) {
        switch (n10) {
            default: {
                return false;
            }
            case 9: {
                Object object = Status.CREATOR;
                object = (Status)zzc.zza((Parcel)zzeArray, object);
                parcel = com.google.android.gms.clearcut.zzc.CREATOR;
                zzeArray = (com.google.android.gms.clearcut.zzc)zzc.zza((Parcel)zzeArray, (Parcelable.Creator)parcel);
                this.zzb((Status)object, (com.google.android.gms.clearcut.zzc)zzeArray);
                break;
            }
            case 8: {
                Object object = Status.CREATOR;
                object = (Status)zzc.zza((Parcel)zzeArray, object);
                parcel = com.google.android.gms.clearcut.zzc.CREATOR;
                zzeArray = (com.google.android.gms.clearcut.zzc)zzc.zza((Parcel)zzeArray, (Parcelable.Creator)parcel);
                this.zza((Status)object, (com.google.android.gms.clearcut.zzc)zzeArray);
                break;
            }
            case 7: {
                Object object = DataHolder.CREATOR;
                object = (DataHolder)zzc.zza((Parcel)zzeArray, object);
                this.zza((DataHolder)object);
                break;
            }
            case 6: {
                Object object = Status.CREATOR;
                object = (Status)zzc.zza((Parcel)zzeArray, object);
                parcel = zze.CREATOR;
                zzeArray = (zze[])zzeArray.createTypedArray((Parcelable.Creator)parcel);
                this.zza((Status)object, zzeArray);
                break;
            }
            case 5: {
                Object object = Status.CREATOR;
                object = (Status)zzc.zza((Parcel)zzeArray, object);
                long l10 = zzeArray.readLong();
                this.zzb((Status)object, l10);
                break;
            }
            case 4: {
                Object object = Status.CREATOR;
                object = (Status)zzc.zza((Parcel)zzeArray, object);
                this.zzc((Status)object);
                break;
            }
            case 3: {
                Object object = Status.CREATOR;
                object = (Status)zzc.zza((Parcel)zzeArray, object);
                long l11 = zzeArray.readLong();
                this.zza((Status)object, l11);
                break;
            }
            case 2: {
                Object object = Status.CREATOR;
                object = (Status)zzc.zza((Parcel)zzeArray, object);
                this.zzb((Status)object);
                break;
            }
            case 1: {
                Object object = Status.CREATOR;
                object = (Status)zzc.zza((Parcel)zzeArray, object);
                this.zza((Status)object);
            }
        }
        return true;
    }
}

