/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.BackStackState;

public class BackStackState$1
implements Parcelable.Creator {
    public BackStackState createFromParcel(Parcel parcel) {
        BackStackState backStackState = new BackStackState(parcel);
        return backStackState;
    }

    public BackStackState[] newArray(int n10) {
        return new BackStackState[n10];
    }
}

