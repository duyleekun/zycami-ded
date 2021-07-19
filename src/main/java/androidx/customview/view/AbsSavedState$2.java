/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;

public class AbsSavedState$2
implements Parcelable.ClassLoaderCreator {
    public AbsSavedState createFromParcel(Parcel parcel) {
        return this.createFromParcel(parcel, null);
    }

    public AbsSavedState createFromParcel(Parcel object, ClassLoader classLoader) {
        if ((object = object.readParcelable(classLoader)) == null) {
            return AbsSavedState.EMPTY_STATE;
        }
        object = new IllegalStateException("superState must be null");
        throw object;
    }

    public AbsSavedState[] newArray(int n10) {
        return new AbsSavedState[n10];
    }
}

