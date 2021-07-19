/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.appcompat.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState$SavedState$1;

public class AppCompatDelegateImpl$PanelFeatureState$SavedState
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public int featureId;
    public boolean isOpen;
    public Bundle menuState;

    static {
        AppCompatDelegateImpl$PanelFeatureState$SavedState$1 appCompatDelegateImpl$PanelFeatureState$SavedState$1 = new AppCompatDelegateImpl$PanelFeatureState$SavedState$1();
        CREATOR = appCompatDelegateImpl$PanelFeatureState$SavedState$1;
    }

    public static AppCompatDelegateImpl$PanelFeatureState$SavedState readFromParcel(Parcel parcel, ClassLoader classLoader) {
        int n10;
        int n11;
        AppCompatDelegateImpl$PanelFeatureState$SavedState appCompatDelegateImpl$PanelFeatureState$SavedState = new AppCompatDelegateImpl$PanelFeatureState$SavedState();
        appCompatDelegateImpl$PanelFeatureState$SavedState.featureId = n11 = parcel.readInt();
        n11 = parcel.readInt();
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        appCompatDelegateImpl$PanelFeatureState$SavedState.isOpen = n10;
        if (n10 != 0) {
            parcel = parcel.readBundle(classLoader);
            appCompatDelegateImpl$PanelFeatureState$SavedState.menuState = parcel;
        }
        return appCompatDelegateImpl$PanelFeatureState$SavedState;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        n10 = this.featureId;
        parcel.writeInt(n10);
        n10 = this.isOpen ? 1 : 0;
        parcel.writeInt(n10);
        n10 = this.isOpen ? 1 : 0;
        if (n10 != 0) {
            Bundle bundle = this.menuState;
            parcel.writeBundle(bundle);
        }
    }
}

