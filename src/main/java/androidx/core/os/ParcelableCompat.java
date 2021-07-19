/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcelable$Creator
 */
package androidx.core.os;

import android.os.Parcelable;
import androidx.core.os.ParcelableCompat$ParcelableCompatCreatorHoneycombMR2;
import androidx.core.os.ParcelableCompatCreatorCallbacks;

public final class ParcelableCompat {
    private ParcelableCompat() {
    }

    public static Parcelable.Creator newCreator(ParcelableCompatCreatorCallbacks parcelableCompatCreatorCallbacks) {
        ParcelableCompat$ParcelableCompatCreatorHoneycombMR2 parcelableCompat$ParcelableCompatCreatorHoneycombMR2 = new ParcelableCompat$ParcelableCompatCreatorHoneycombMR2(parcelableCompatCreatorCallbacks);
        return parcelableCompat$ParcelableCompatCreatorHoneycombMR2;
    }
}

