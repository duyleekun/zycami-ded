/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package androidx.appcompat.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState$SavedState;

public class AppCompatDelegateImpl$PanelFeatureState$SavedState$1
implements Parcelable.ClassLoaderCreator {
    public AppCompatDelegateImpl$PanelFeatureState$SavedState createFromParcel(Parcel parcel) {
        return AppCompatDelegateImpl$PanelFeatureState$SavedState.readFromParcel(parcel, null);
    }

    public AppCompatDelegateImpl$PanelFeatureState$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return AppCompatDelegateImpl$PanelFeatureState$SavedState.readFromParcel(parcel, classLoader);
    }

    public AppCompatDelegateImpl$PanelFeatureState$SavedState[] newArray(int n10) {
        return new AppCompatDelegateImpl$PanelFeatureState$SavedState[n10];
    }
}

