/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package androidx.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.navigation.NavBackStackEntryState;

public class NavBackStackEntryState$1
implements Parcelable.Creator {
    public NavBackStackEntryState createFromParcel(Parcel parcel) {
        NavBackStackEntryState navBackStackEntryState = new NavBackStackEntryState(parcel);
        return navBackStackEntryState;
    }

    public NavBackStackEntryState[] newArray(int n10) {
        return new NavBackStackEntryState[n10];
    }
}

