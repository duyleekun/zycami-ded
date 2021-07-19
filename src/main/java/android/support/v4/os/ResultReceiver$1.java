/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;

public class ResultReceiver$1
implements Parcelable.Creator {
    public ResultReceiver createFromParcel(Parcel parcel) {
        ResultReceiver resultReceiver = new ResultReceiver(parcel);
        return resultReceiver;
    }

    public ResultReceiver[] newArray(int n10) {
        return new ResultReceiver[n10];
    }
}

