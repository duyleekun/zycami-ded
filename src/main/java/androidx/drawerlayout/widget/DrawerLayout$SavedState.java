/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.drawerlayout.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout$SavedState$1;

public class DrawerLayout$SavedState
extends AbsSavedState {
    public static final Parcelable.Creator CREATOR;
    public int lockModeEnd;
    public int lockModeLeft;
    public int lockModeRight;
    public int lockModeStart;
    public int openDrawerGravity = 0;

    static {
        DrawerLayout$SavedState$1 drawerLayout$SavedState$1 = new DrawerLayout$SavedState$1();
        CREATOR = drawerLayout$SavedState$1;
    }

    public DrawerLayout$SavedState(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int n10;
        int n11;
        this.openDrawerGravity = n11 = parcel.readInt();
        this.lockModeLeft = n11 = parcel.readInt();
        this.lockModeRight = n11 = parcel.readInt();
        this.lockModeStart = n11 = parcel.readInt();
        this.lockModeEnd = n10 = parcel.readInt();
    }

    public DrawerLayout$SavedState(Parcelable parcelable) {
        super(parcelable);
    }

    public void writeToParcel(Parcel parcel, int n10) {
        super.writeToParcel(parcel, n10);
        n10 = this.openDrawerGravity;
        parcel.writeInt(n10);
        n10 = this.lockModeLeft;
        parcel.writeInt(n10);
        n10 = this.lockModeRight;
        parcel.writeInt(n10);
        n10 = this.lockModeStart;
        parcel.writeInt(n10);
        n10 = this.lockModeEnd;
        parcel.writeInt(n10);
    }
}

