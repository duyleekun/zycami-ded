/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.BackStackState;
import androidx.fragment.app.FragmentManager$LaunchedFragmentInfo;
import androidx.fragment.app.FragmentManagerState$1;
import androidx.fragment.app.FragmentState;
import java.util.ArrayList;
import java.util.List;

public final class FragmentManagerState
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public ArrayList mActive;
    public ArrayList mAdded;
    public BackStackState[] mBackStack;
    public int mBackStackIndex;
    public ArrayList mLaunchedFragments;
    public String mPrimaryNavActiveWho = null;
    public ArrayList mResultKeys;
    public ArrayList mResults;

    static {
        FragmentManagerState$1 fragmentManagerState$1 = new FragmentManagerState$1();
        CREATOR = fragmentManagerState$1;
    }

    public FragmentManagerState() {
        ArrayList arrayList;
        this.mResultKeys = arrayList = new ArrayList();
        this.mResults = arrayList = new ArrayList();
    }

    public FragmentManagerState(Parcel object) {
        int n10;
        Object object2;
        this.mResultKeys = object2 = new ArrayList();
        this.mResults = object2 = new ArrayList();
        object2 = FragmentState.CREATOR;
        object2 = object.createTypedArrayList(object2);
        this.mActive = object2;
        object2 = object.createStringArrayList();
        this.mAdded = object2;
        object2 = BackStackState.CREATOR;
        object2 = (BackStackState[])object.createTypedArray(object2);
        this.mBackStack = object2;
        this.mBackStackIndex = n10 = object.readInt();
        object2 = object.readString();
        this.mPrimaryNavActiveWho = object2;
        object2 = object.createStringArrayList();
        this.mResultKeys = object2;
        object2 = Bundle.CREATOR;
        object2 = object.createTypedArrayList(object2);
        this.mResults = object2;
        object2 = FragmentManager$LaunchedFragmentInfo.CREATOR;
        object = object.createTypedArrayList(object2);
        this.mLaunchedFragments = object;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        Parcelable[] parcelableArray = this.mActive;
        parcel.writeTypedList((List)parcelableArray);
        parcelableArray = this.mAdded;
        parcel.writeStringList((List)parcelableArray);
        parcelableArray = this.mBackStack;
        parcel.writeTypedArray(parcelableArray, n10);
        n10 = this.mBackStackIndex;
        parcel.writeInt(n10);
        Object object = this.mPrimaryNavActiveWho;
        parcel.writeString((String)object);
        object = this.mResultKeys;
        parcel.writeStringList((List)object);
        object = this.mResults;
        parcel.writeTypedList((List)object);
        object = this.mLaunchedFragments;
        parcel.writeTypedList((List)object);
    }
}

