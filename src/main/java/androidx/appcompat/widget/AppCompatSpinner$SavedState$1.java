/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.AppCompatSpinner$SavedState;

public class AppCompatSpinner$SavedState$1
implements Parcelable.Creator {
    public AppCompatSpinner$SavedState createFromParcel(Parcel parcel) {
        AppCompatSpinner$SavedState appCompatSpinner$SavedState = new AppCompatSpinner$SavedState(parcel);
        return appCompatSpinner$SavedState;
    }

    public AppCompatSpinner$SavedState[] newArray(int n10) {
        return new AppCompatSpinner$SavedState[n10];
    }
}

