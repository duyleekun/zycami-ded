/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 */
package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.common.internal.zzv;

public abstract class IGmsServiceBroker$Stub
extends Binder
implements IGmsServiceBroker {
    public IGmsServiceBroker$Stub() {
        this.attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
    }

    public IBinder asBinder() {
        return this;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean onTransact(int var1_1, Parcel var2_2, Parcel var3_3, int var4_4) {
        block19: {
            block18: {
                var5_5 = 0xFFFFFF;
                if (var1_1 > var5_5) {
                    return super.onTransact(var1_1, var2_2, var3_3, var4_4);
                }
                var2_2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                var6_6 = var2_2.readStrongBinder();
                var5_5 = 0;
                var7_7 = null;
                var8_8 /* !! */  = var6_6 == null ? null : ((var9_9 = (var8_8 /* !! */  = var6_6.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks")) instanceof IGmsCallbacks) != 0 ? (IGmsCallbacks)var8_8 /* !! */  : new zzo(var6_6));
                var4_4 = 46;
                var9_9 = 1;
                if (var1_1 == var4_4) {
                    var1_1 = var2_2.readInt();
                    if (var1_1 != 0) {
                        var7_7 = var10_10 = GetServiceRequest.CREATOR.createFromParcel(var2_2);
                        var7_7 = (GetServiceRequest)var10_10;
                    }
                    this.getService((IGmsCallbacks)var8_8 /* !! */ , (GetServiceRequest)var7_7);
                    var3_3.writeNoException();
                    return (boolean)var9_9;
                }
                var11_13 = 47;
                if (var1_1 == var11_13) {
                    var1_1 = var2_2.readInt();
                    if (var1_1 != 0) {
                        var10_11 = (zzv)zzv.CREATOR.createFromParcel(var2_2);
                    }
                    var10_11 = new UnsupportedOperationException();
                    throw var10_11;
                }
                var2_2.readInt();
                var11_13 = 4;
                if (var1_1 != var11_13) {
                    var2_2.readString();
                }
                if (var1_1 == var9_9) break block18;
                var11_13 = 2;
                if (var1_1 == var11_13 || var1_1 == (var11_13 = 23) || var1_1 == (var11_13 = 25) || var1_1 == (var11_13 = 27)) ** GOTO lbl-1000
                var11_13 = 30;
                if (var1_1 == var11_13) ** GOTO lbl-1000
                var11_13 = 34;
                if (var1_1 == var11_13) ** GOTO lbl74
                var11_13 = 41;
                if (var1_1 == var11_13 || var1_1 == (var11_13 = 43) || var1_1 == (var11_13 = 37) || var1_1 == (var11_13 = 38)) ** GOTO lbl-1000
                switch (var1_1) {
                    default: {
                        break;
                    }
                    case 19: {
                        var2_2.readStrongBinder();
                        var1_1 = var2_2.readInt();
                        if (var1_1 != 0) {
                            var10_12 = (Bundle)Bundle.CREATOR.createFromParcel(var2_2);
                            break;
                        }
                        break block19;
                    }
                    case 10: {
                        var2_2.readString();
                        var2_2.createStringArray();
                        break;
                    }
                    case 9: {
                        var2_2.readString();
                        var2_2.createStringArray();
                        var2_2.readString();
                        var2_2.readStrongBinder();
                        var2_2.readString();
                        var1_1 = var2_2.readInt();
                        if (var1_1 != 0) {
                            var10_12 = (Bundle)Bundle.CREATOR.createFromParcel(var2_2);
                            break;
                        }
                        break block19;
                    }
lbl74:
                    // 1 sources

                    var2_2.readString();
                    break;
                    case 20: lbl-1000:
                    // 2 sources

                    {
                        var2_2.createStringArray();
                        var2_2.readString();
                        var1_1 = var2_2.readInt();
                        if (var1_1 != 0) {
                            var10_12 = (Bundle)Bundle.CREATOR.createFromParcel(var2_2);
                            break;
                        }
                        break block19;
                    }
                    case 5: 
                    case 6: 
                    case 7: 
                    case 8: 
                    case 11: 
                    case 12: 
                    case 13: 
                    case 14: 
                    case 15: 
                    case 16: 
                    case 17: 
                    case 18: lbl-1000:
                    // 3 sources

                    {
                        if ((var1_1 = var2_2.readInt()) != 0) {
                            var10_12 = (Bundle)Bundle.CREATOR.createFromParcel(var2_2);
                            break;
                        }
                        break block19;
                    }
                }
                break block19;
            }
            var2_2.readString();
            var2_2.createStringArray();
            var2_2.readString();
            var1_1 = var2_2.readInt();
            if (var1_1 != 0) {
                var10_12 = (Bundle)Bundle.CREATOR.createFromParcel(var2_2);
            }
        }
        var10_12 = new UnsupportedOperationException();
        throw var10_12;
    }
}

