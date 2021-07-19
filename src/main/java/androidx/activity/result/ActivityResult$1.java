/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package androidx.activity.result;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;

public class ActivityResult$1
implements Parcelable.Creator {
    public ActivityResult createFromParcel(Parcel parcel) {
        ActivityResult activityResult = new ActivityResult(parcel);
        return activityResult;
    }

    public ActivityResult[] newArray(int n10) {
        return new ActivityResult[n10];
    }
}

