/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment$SavedState$1;

public class Fragment$SavedState
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final Bundle mState;

    static {
        Fragment$SavedState$1 fragment$SavedState$1 = new Fragment$SavedState$1();
        CREATOR = fragment$SavedState$1;
    }

    public Fragment$SavedState(Bundle bundle) {
        this.mState = bundle;
    }

    public Fragment$SavedState(Parcel parcel, ClassLoader classLoader) {
        parcel = parcel.readBundle();
        this.mState = parcel;
        if (classLoader != null && parcel != null) {
            parcel.setClassLoader(classLoader);
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Bundle bundle = this.mState;
        parcel.writeBundle(bundle);
    }
}

