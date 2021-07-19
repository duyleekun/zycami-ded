/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package androidx.recyclerview.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.RecyclerView$SavedState;

public class RecyclerView$SavedState$1
implements Parcelable.ClassLoaderCreator {
    public RecyclerView$SavedState createFromParcel(Parcel parcel) {
        RecyclerView$SavedState recyclerView$SavedState = new RecyclerView$SavedState(parcel, null);
        return recyclerView$SavedState;
    }

    public RecyclerView$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        RecyclerView$SavedState recyclerView$SavedState = new RecyclerView$SavedState(parcel, classLoader);
        return recyclerView$SavedState;
    }

    public RecyclerView$SavedState[] newArray(int n10) {
        return new RecyclerView$SavedState[n10];
    }
}

