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
import androidx.fragment.app.FragmentManagerState;

public class FragmentManagerState$1
implements Parcelable.Creator {
    public FragmentManagerState createFromParcel(Parcel parcel) {
        FragmentManagerState fragmentManagerState = new FragmentManagerState(parcel);
        return fragmentManagerState;
    }

    public FragmentManagerState[] newArray(int n10) {
        return new FragmentManagerState[n10];
    }
}

