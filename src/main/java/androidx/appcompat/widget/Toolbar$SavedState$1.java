/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.Toolbar$SavedState;

public class Toolbar$SavedState$1
implements Parcelable.ClassLoaderCreator {
    public Toolbar$SavedState createFromParcel(Parcel parcel) {
        Toolbar$SavedState toolbar$SavedState = new Toolbar$SavedState(parcel, null);
        return toolbar$SavedState;
    }

    public Toolbar$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        Toolbar$SavedState toolbar$SavedState = new Toolbar$SavedState(parcel, classLoader);
        return toolbar$SavedState;
    }

    public Toolbar$SavedState[] newArray(int n10) {
        return new Toolbar$SavedState[n10];
    }
}

