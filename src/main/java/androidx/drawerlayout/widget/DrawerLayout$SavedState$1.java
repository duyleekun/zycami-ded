/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$ClassLoaderCreator
 */
package androidx.drawerlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.drawerlayout.widget.DrawerLayout$SavedState;

public class DrawerLayout$SavedState$1
implements Parcelable.ClassLoaderCreator {
    public DrawerLayout$SavedState createFromParcel(Parcel parcel) {
        DrawerLayout$SavedState drawerLayout$SavedState = new DrawerLayout$SavedState(parcel, null);
        return drawerLayout$SavedState;
    }

    public DrawerLayout$SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
        DrawerLayout$SavedState drawerLayout$SavedState = new DrawerLayout$SavedState(parcel, classLoader);
        return drawerLayout$SavedState;
    }

    public DrawerLayout$SavedState[] newArray(int n10) {
        return new DrawerLayout$SavedState[n10];
    }
}

