/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zac;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zad;
import com.google.android.gms.signin.internal.zaj;

public abstract class zae
extends zab
implements zad {
    public zae() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    public boolean dispatchTransaction(int n10, Parcel object, Parcel parcel, int n11) {
        n11 = 3;
        if (n10 != n11) {
            n11 = 4;
            if (n10 != n11) {
                n11 = 6;
                if (n10 != n11) {
                    n11 = 7;
                    if (n10 != n11) {
                        n11 = 8;
                        if (n10 != n11) {
                            return false;
                        }
                        Object object2 = zaj.CREATOR;
                        object2 = (zaj)zac.zaa(object, object2);
                        this.zab((zaj)object2);
                    } else {
                        Object object3 = Status.CREATOR;
                        object3 = (Status)zac.zaa(object, object3);
                        Parcelable.Creator creator = GoogleSignInAccount.CREATOR;
                        object = (GoogleSignInAccount)zac.zaa(object, creator);
                        this.zaa((Status)object3, (GoogleSignInAccount)object);
                    }
                } else {
                    Object object4 = Status.CREATOR;
                    object4 = (Status)zac.zaa(object, object4);
                    this.zah((Status)object4);
                }
            } else {
                Object object5 = Status.CREATOR;
                object5 = (Status)zac.zaa(object, object5);
                this.zag((Status)object5);
            }
        } else {
            Object object6 = ConnectionResult.CREATOR;
            object6 = (ConnectionResult)zac.zaa(object, object6);
            Parcelable.Creator creator = zaa.CREATOR;
            object = (zaa)zac.zaa(object, creator);
            this.zaa((ConnectionResult)object6, (zaa)object);
        }
        parcel.writeNoException();
        return true;
    }
}

