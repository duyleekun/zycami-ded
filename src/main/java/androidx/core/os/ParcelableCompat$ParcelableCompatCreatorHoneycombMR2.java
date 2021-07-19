/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.os.ParcelableCompatCreatorCallbacks;

public class ParcelableCompat$ParcelableCompatCreatorHoneycombMR2
implements Parcelable.ClassLoaderCreator {
    private final ParcelableCompatCreatorCallbacks mCallbacks;

    public ParcelableCompat$ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
        this.mCallbacks = parcelableCompatCreatorCallbacks;
    }

    public Object createFromParcel(Parcel parcel) {
        return this.mCallbacks.createFromParcel(parcel, null);
    }

    public Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.mCallbacks.createFromParcel(parcel, classLoader);
    }

    public Object[] newArray(int n10) {
        return this.mCallbacks.newArray(n10);
    }
}

