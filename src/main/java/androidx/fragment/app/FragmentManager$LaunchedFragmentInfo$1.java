/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager$LaunchedFragmentInfo;

public class FragmentManager$LaunchedFragmentInfo$1
implements Parcelable.Creator {
    public FragmentManager$LaunchedFragmentInfo createFromParcel(Parcel parcel) {
        FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = new FragmentManager$LaunchedFragmentInfo(parcel);
        return fragmentManager$LaunchedFragmentInfo;
    }

    public FragmentManager$LaunchedFragmentInfo[] newArray(int n10) {
        return new FragmentManager$LaunchedFragmentInfo[n10];
    }
}

