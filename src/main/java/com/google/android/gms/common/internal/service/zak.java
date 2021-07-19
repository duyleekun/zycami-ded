/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.common.internal.service;

import android.os.Parcel;
import com.google.android.gms.common.internal.service.zaj;
import com.google.android.gms.internal.base.zab;

public abstract class zak
extends zab
implements zaj {
    public zak() {
        super("com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    public boolean dispatchTransaction(int n10, Parcel parcel, Parcel parcel2, int n11) {
        n11 = 1;
        if (n10 == n11) {
            n10 = parcel.readInt();
            this.zaj(n10);
            parcel2.writeNoException();
            return n11 != 0;
        }
        return false;
    }
}

