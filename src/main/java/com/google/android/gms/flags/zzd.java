/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 */
package com.google.android.gms.flags;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper$Stub;
import com.google.android.gms.flags.zzc;
import com.google.android.gms.flags.zze;
import com.google.android.gms.internal.flags.zzb;

public abstract class zzd
extends zzb
implements zzc {
    public zzd() {
        super("com.google.android.gms.flags.IFlagProvider");
    }

    public static zzc asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.flags.IFlagProvider");
        boolean bl2 = iInterface instanceof zzc;
        if (bl2) {
            return (zzc)iInterface;
        }
        iInterface = new zze(iBinder);
        return iInterface;
    }

    public final boolean dispatchTransaction(int n10, Parcel parcel, Parcel parcel2, int n11) {
        n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 != n12) {
                n12 = 3;
                if (n10 != n12) {
                    n12 = 4;
                    if (n10 != n12) {
                        n12 = 5;
                        if (n10 != n12) {
                            return false;
                        }
                        String string2 = parcel.readString();
                        String string3 = parcel.readString();
                        int n13 = parcel.readInt();
                        string2 = this.getStringFlagValue(string2, string3, n13);
                        parcel2.writeNoException();
                        parcel2.writeString(string2);
                    } else {
                        String string4 = parcel.readString();
                        long l10 = parcel.readLong();
                        int n14 = parcel.readInt();
                        long l11 = this.getLongFlagValue(string4, l10, n14);
                        parcel2.writeNoException();
                        parcel2.writeLong(l11);
                    }
                } else {
                    String string5 = parcel.readString();
                    n12 = parcel.readInt();
                    int n15 = parcel.readInt();
                    n10 = this.getIntFlagValue(string5, n12, n15);
                    parcel2.writeNoException();
                    parcel2.writeInt(n10);
                }
            } else {
                String string6 = parcel.readString();
                n12 = (int)(com.google.android.gms.internal.flags.zzc.zza(parcel) ? 1 : 0);
                int n16 = parcel.readInt();
                n10 = (int)(this.getBooleanFlagValue(string6, n12 != 0, n16) ? 1 : 0);
                parcel2.writeNoException();
                com.google.android.gms.internal.flags.zzc.writeBoolean(parcel2, n10 != 0);
            }
        } else {
            IObjectWrapper iObjectWrapper = IObjectWrapper$Stub.asInterface(parcel.readStrongBinder());
            this.init(iObjectWrapper);
            parcel2.writeNoException();
        }
        return n11 != 0;
    }
}

