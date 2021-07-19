/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IFragmentWrapper;
import com.google.android.gms.dynamic.IFragmentWrapper$Stub$zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper$Stub;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzd;

public abstract class IFragmentWrapper$Stub
extends zza
implements IFragmentWrapper {
    public IFragmentWrapper$Stub() {
        super("com.google.android.gms.dynamic.IFragmentWrapper");
    }

    public static IFragmentWrapper asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
        boolean bl2 = iInterface instanceof IFragmentWrapper;
        if (bl2) {
            return (IFragmentWrapper)iInterface;
        }
        iInterface = new IFragmentWrapper$Stub$zza(iBinder);
        return iInterface;
    }

    public final boolean zza(int n10, Parcel parcel, Parcel parcel2, int n11) {
        switch (n10) {
            default: {
                return false;
            }
            case 27: {
                IObjectWrapper iObjectWrapper = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
                this.zzb(iObjectWrapper);
                parcel2.writeNoException();
                break;
            }
            case 26: {
                Parcelable.Creator creator = Intent.CREATOR;
                creator = (Intent)zzd.zza(parcel, creator);
                int n12 = parcel.readInt();
                this.zza((Intent)creator, n12);
                parcel2.writeNoException();
                break;
            }
            case 25: {
                Parcelable.Creator creator = Intent.CREATOR;
                creator = (Intent)zzd.zza(parcel, creator);
                this.zza((Intent)creator);
                parcel2.writeNoException();
                break;
            }
            case 24: {
                n10 = (int)(zzd.zza(parcel) ? 1 : 0);
                this.zzd(n10 != 0);
                parcel2.writeNoException();
                break;
            }
            case 23: {
                n10 = (int)(zzd.zza(parcel) ? 1 : 0);
                this.zzc(n10 != 0);
                parcel2.writeNoException();
                break;
            }
            case 22: {
                n10 = (int)(zzd.zza(parcel) ? 1 : 0);
                this.zzb(n10 != 0);
                parcel2.writeNoException();
                break;
            }
            case 21: {
                n10 = (int)(zzd.zza(parcel) ? 1 : 0);
                this.zza(n10 != 0);
                parcel2.writeNoException();
                break;
            }
            case 20: {
                IObjectWrapper iObjectWrapper = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
                this.zza(iObjectWrapper);
                parcel2.writeNoException();
                break;
            }
            case 19: {
                n10 = (int)(this.zzr() ? 1 : 0);
                parcel2.writeNoException();
                zzd.zza(parcel2, n10 != 0);
                break;
            }
            case 18: {
                n10 = (int)(this.zzq() ? 1 : 0);
                parcel2.writeNoException();
                zzd.zza(parcel2, n10 != 0);
                break;
            }
            case 17: {
                n10 = (int)(this.zzp() ? 1 : 0);
                parcel2.writeNoException();
                zzd.zza(parcel2, n10 != 0);
                break;
            }
            case 16: {
                n10 = (int)(this.zzo() ? 1 : 0);
                parcel2.writeNoException();
                zzd.zza(parcel2, n10 != 0);
                break;
            }
            case 15: {
                n10 = (int)(this.zzn() ? 1 : 0);
                parcel2.writeNoException();
                zzd.zza(parcel2, n10 != 0);
                break;
            }
            case 14: {
                n10 = (int)(this.zzm() ? 1 : 0);
                parcel2.writeNoException();
                zzd.zza(parcel2, n10 != 0);
                break;
            }
            case 13: {
                n10 = (int)(this.zzl() ? 1 : 0);
                parcel2.writeNoException();
                zzd.zza(parcel2, n10 != 0);
                break;
            }
            case 12: {
                IObjectWrapper iObjectWrapper = this.zzk();
                parcel2.writeNoException();
                zzd.zza(parcel2, iObjectWrapper);
                break;
            }
            case 11: {
                n10 = (int)(this.zzj() ? 1 : 0);
                parcel2.writeNoException();
                zzd.zza(parcel2, n10 != 0);
                break;
            }
            case 10: {
                n10 = this.zzi();
                parcel2.writeNoException();
                parcel2.writeInt(n10);
                break;
            }
            case 9: {
                IFragmentWrapper iFragmentWrapper = this.zzh();
                parcel2.writeNoException();
                zzd.zza(parcel2, iFragmentWrapper);
                break;
            }
            case 8: {
                String string2 = this.zzg();
                parcel2.writeNoException();
                parcel2.writeString(string2);
                break;
            }
            case 7: {
                n10 = (int)(this.zzf() ? 1 : 0);
                parcel2.writeNoException();
                zzd.zza(parcel2, n10 != 0);
                break;
            }
            case 6: {
                IObjectWrapper iObjectWrapper = this.zze();
                parcel2.writeNoException();
                zzd.zza(parcel2, iObjectWrapper);
                break;
            }
            case 5: {
                IFragmentWrapper iFragmentWrapper = this.zzd();
                parcel2.writeNoException();
                zzd.zza(parcel2, iFragmentWrapper);
                break;
            }
            case 4: {
                n10 = this.zzc();
                parcel2.writeNoException();
                parcel2.writeInt(n10);
                break;
            }
            case 3: {
                Bundle bundle = this.zzb();
                parcel2.writeNoException();
                zzd.zzb(parcel2, (Parcelable)bundle);
                break;
            }
            case 2: {
                IObjectWrapper iObjectWrapper = this.zza();
                parcel2.writeNoException();
                zzd.zza(parcel2, iObjectWrapper);
            }
        }
        return true;
    }
}

