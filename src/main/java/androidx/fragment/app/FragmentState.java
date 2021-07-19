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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentState$1;

public final class FragmentState
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final Bundle mArguments;
    public final String mClassName;
    public final int mContainerId;
    public final boolean mDetached;
    public final int mFragmentId;
    public final boolean mFromLayout;
    public final boolean mHidden;
    public final int mMaxLifecycleState;
    public final boolean mRemoving;
    public final boolean mRetainInstance;
    public Bundle mSavedFragmentState;
    public final String mTag;
    public final String mWho;

    static {
        FragmentState$1 fragmentState$1 = new FragmentState$1();
        CREATOR = fragmentState$1;
    }

    public FragmentState(Parcel parcel) {
        int n10;
        String string2;
        this.mClassName = string2 = parcel.readString();
        this.mWho = string2 = parcel.readString();
        int n11 = parcel.readInt();
        int n12 = 1;
        if (n11 != 0) {
            n11 = n12;
        } else {
            n11 = 0;
            string2 = null;
        }
        this.mFromLayout = n11;
        this.mFragmentId = n11 = parcel.readInt();
        this.mContainerId = n11 = parcel.readInt();
        this.mTag = string2 = parcel.readString();
        n11 = parcel.readInt();
        if (n11 != 0) {
            n11 = n12;
        } else {
            n11 = 0;
            string2 = null;
        }
        this.mRetainInstance = n11;
        n11 = parcel.readInt();
        if (n11 != 0) {
            n11 = n12;
        } else {
            n11 = 0;
            string2 = null;
        }
        this.mRemoving = n11;
        n11 = parcel.readInt();
        if (n11 != 0) {
            n11 = n12;
        } else {
            n11 = 0;
            string2 = null;
        }
        this.mDetached = n11;
        string2 = parcel.readBundle();
        this.mArguments = string2;
        n11 = parcel.readInt();
        if (n11 == 0) {
            n12 = 0;
        }
        this.mHidden = n12;
        string2 = parcel.readBundle();
        this.mSavedFragmentState = string2;
        this.mMaxLifecycleState = n10 = parcel.readInt();
    }

    public FragmentState(Fragment fragment) {
        int n10;
        int n11;
        String string2;
        this.mClassName = string2 = fragment.getClass().getName();
        this.mWho = string2 = fragment.mWho;
        this.mFromLayout = n11 = fragment.mFromLayout;
        this.mFragmentId = n11 = fragment.mFragmentId;
        this.mContainerId = n11 = fragment.mContainerId;
        this.mTag = string2 = fragment.mTag;
        n11 = (int)(fragment.mRetainInstance ? 1 : 0);
        this.mRetainInstance = n11;
        n11 = (int)(fragment.mRemoving ? 1 : 0);
        this.mRemoving = n11;
        n11 = (int)(fragment.mDetached ? 1 : 0);
        this.mDetached = n11;
        string2 = fragment.mArguments;
        this.mArguments = string2;
        n11 = (int)(fragment.mHidden ? 1 : 0);
        this.mHidden = n11;
        this.mMaxLifecycleState = n10 = fragment.mMaxState.ordinal();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentState{");
        String string2 = this.mClassName;
        stringBuilder.append(string2);
        stringBuilder.append(" (");
        string2 = this.mWho;
        stringBuilder.append(string2);
        string2 = ")}:";
        stringBuilder.append(string2);
        int n10 = this.mFromLayout;
        if (n10 != 0) {
            string2 = " fromLayout";
            stringBuilder.append(string2);
        }
        if ((n10 = this.mContainerId) != 0) {
            stringBuilder.append(" id=0x");
            n10 = this.mContainerId;
            string2 = Integer.toHexString(n10);
            stringBuilder.append(string2);
        }
        if ((string2 = this.mTag) != null && (n10 = (int)(string2.isEmpty() ? 1 : 0)) == 0) {
            stringBuilder.append(" tag=");
            string2 = this.mTag;
            stringBuilder.append(string2);
        }
        if ((n10 = (int)(this.mRetainInstance ? 1 : 0)) != 0) {
            string2 = " retainInstance";
            stringBuilder.append(string2);
        }
        if ((n10 = (int)(this.mRemoving ? 1 : 0)) != 0) {
            string2 = " removing";
            stringBuilder.append(string2);
        }
        if ((n10 = (int)(this.mDetached ? 1 : 0)) != 0) {
            string2 = " detached";
            stringBuilder.append(string2);
        }
        if ((n10 = (int)(this.mHidden ? 1 : 0)) != 0) {
            string2 = " hidden";
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.mClassName;
        parcel.writeString(string2);
        string2 = this.mWho;
        parcel.writeString(string2);
        n10 = (int)(this.mFromLayout ? 1 : 0);
        parcel.writeInt(n10);
        n10 = this.mFragmentId;
        parcel.writeInt(n10);
        n10 = this.mContainerId;
        parcel.writeInt(n10);
        string2 = this.mTag;
        parcel.writeString(string2);
        n10 = (int)(this.mRetainInstance ? 1 : 0);
        parcel.writeInt(n10);
        n10 = (int)(this.mRemoving ? 1 : 0);
        parcel.writeInt(n10);
        n10 = (int)(this.mDetached ? 1 : 0);
        parcel.writeInt(n10);
        string2 = this.mArguments;
        parcel.writeBundle((Bundle)string2);
        n10 = (int)(this.mHidden ? 1 : 0);
        parcel.writeInt(n10);
        string2 = this.mSavedFragmentState;
        parcel.writeBundle((Bundle)string2);
        n10 = this.mMaxLifecycleState;
        parcel.writeInt(n10);
    }
}

