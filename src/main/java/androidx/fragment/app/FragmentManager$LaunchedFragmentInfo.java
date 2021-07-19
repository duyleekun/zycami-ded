/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager$LaunchedFragmentInfo$1;

public class FragmentManager$LaunchedFragmentInfo
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public int mRequestCode;
    public String mWho;

    static {
        FragmentManager$LaunchedFragmentInfo$1 fragmentManager$LaunchedFragmentInfo$1 = new FragmentManager$LaunchedFragmentInfo$1();
        CREATOR = fragmentManager$LaunchedFragmentInfo$1;
    }

    public FragmentManager$LaunchedFragmentInfo(Parcel parcel) {
        int n10;
        String string2;
        this.mWho = string2 = parcel.readString();
        this.mRequestCode = n10 = parcel.readInt();
    }

    public FragmentManager$LaunchedFragmentInfo(String string2, int n10) {
        this.mWho = string2;
        this.mRequestCode = n10;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        String string2 = this.mWho;
        parcel.writeString(string2);
        n10 = this.mRequestCode;
        parcel.writeInt(n10);
    }
}

