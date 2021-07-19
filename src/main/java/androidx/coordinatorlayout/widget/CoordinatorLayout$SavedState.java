/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.SparseArray
 */
package androidx.coordinatorlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.coordinatorlayout.widget.CoordinatorLayout$SavedState$1;
import androidx.customview.view.AbsSavedState;

public class CoordinatorLayout$SavedState
extends AbsSavedState {
    public static final Parcelable.Creator CREATOR;
    public SparseArray behaviorStates;

    static {
        CoordinatorLayout$SavedState$1 coordinatorLayout$SavedState$1 = new CoordinatorLayout$SavedState$1();
        CREATOR = coordinatorLayout$SavedState$1;
    }

    public CoordinatorLayout$SavedState(Parcel parcelableArray, ClassLoader classLoader) {
        super((Parcel)parcelableArray, classLoader);
        int n10 = parcelableArray.readInt();
        int[] nArray = new int[n10];
        parcelableArray.readIntArray(nArray);
        parcelableArray = parcelableArray.readParcelableArray(classLoader);
        super(n10);
        this.behaviorStates = classLoader;
        classLoader = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            SparseArray sparseArray = this.behaviorStates;
            int n11 = nArray[i10];
            Parcelable parcelable = parcelableArray[i10];
            sparseArray.append(n11, (Object)parcelable);
        }
    }

    public CoordinatorLayout$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11;
        super.writeToParcel(parcel, n10);
        SparseArray sparseArray = this.behaviorStates;
        int n12 = 0;
        if (sparseArray != null) {
            n11 = sparseArray.size();
        } else {
            n11 = 0;
            sparseArray = null;
        }
        parcel.writeInt(n11);
        int[] nArray = new int[n11];
        Parcelable[] parcelableArray = new Parcelable[n11];
        while (n12 < n11) {
            Parcelable parcelable;
            int n13;
            nArray[n12] = n13 = this.behaviorStates.keyAt(n12);
            parcelableArray[n12] = parcelable = (Parcelable)this.behaviorStates.valueAt(n12);
            ++n12;
        }
        parcel.writeIntArray(nArray);
        parcel.writeParcelableArray(parcelableArray, n10);
    }
}

