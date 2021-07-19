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
import androidx.fragment.app.FragmentState;

public class FragmentState$1
implements Parcelable.Creator {
    public FragmentState createFromParcel(Parcel parcel) {
        FragmentState fragmentState = new FragmentState(parcel);
        return fragmentState;
    }

    public FragmentState[] newArray(int n10) {
        return new FragmentState[n10];
    }
}

