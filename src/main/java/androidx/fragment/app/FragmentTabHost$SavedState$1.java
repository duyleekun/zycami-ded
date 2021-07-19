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
import androidx.fragment.app.FragmentTabHost$SavedState;

public class FragmentTabHost$SavedState$1
implements Parcelable.Creator {
    public FragmentTabHost$SavedState createFromParcel(Parcel parcel) {
        FragmentTabHost$SavedState fragmentTabHost$SavedState = new FragmentTabHost$SavedState(parcel);
        return fragmentTabHost$SavedState;
    }

    public FragmentTabHost$SavedState[] newArray(int n10) {
        return new FragmentTabHost$SavedState[n10];
    }
}

