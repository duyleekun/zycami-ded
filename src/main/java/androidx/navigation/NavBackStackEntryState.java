/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.navigation;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryState$1;
import java.util.UUID;

public final class NavBackStackEntryState
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private final Bundle mArgs;
    private final int mDestinationId;
    private final Bundle mSavedState;
    private final UUID mUUID;

    static {
        NavBackStackEntryState$1 navBackStackEntryState$1 = new NavBackStackEntryState$1();
        CREATOR = navBackStackEntryState$1;
    }

    public NavBackStackEntryState(Parcel parcel) {
        int n10;
        Object object = UUID.fromString(parcel.readString());
        this.mUUID = object;
        this.mDestinationId = n10 = parcel.readInt();
        object = NavBackStackEntryState.class.getClassLoader();
        object = parcel.readBundle((ClassLoader)object);
        this.mArgs = object;
        object = NavBackStackEntryState.class.getClassLoader();
        parcel = parcel.readBundle((ClassLoader)object);
        this.mSavedState = parcel;
    }

    public NavBackStackEntryState(NavBackStackEntry navBackStackEntry) {
        int n10;
        UUID uUID;
        this.mUUID = uUID = navBackStackEntry.mId;
        this.mDestinationId = n10 = navBackStackEntry.getDestination().getId();
        uUID = navBackStackEntry.getArguments();
        this.mArgs = uUID;
        this.mSavedState = uUID;
        navBackStackEntry.saveState((Bundle)uUID);
    }

    public int describeContents() {
        return 0;
    }

    public Bundle getArgs() {
        return this.mArgs;
    }

    public int getDestinationId() {
        return this.mDestinationId;
    }

    public Bundle getSavedState() {
        return this.mSavedState;
    }

    public UUID getUUID() {
        return this.mUUID;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.mUUID.toString();
        parcel.writeString(string2);
        n10 = this.mDestinationId;
        parcel.writeInt(n10);
        string2 = this.mArgs;
        parcel.writeBundle((Bundle)string2);
        string2 = this.mSavedState;
        parcel.writeBundle((Bundle)string2);
    }
}

