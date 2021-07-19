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
import androidx.activity.result.IntentSenderRequest;

public class IntentSenderRequest$1
implements Parcelable.Creator {
    public IntentSenderRequest createFromParcel(Parcel parcel) {
        IntentSenderRequest intentSenderRequest = new IntentSenderRequest(parcel);
        return intentSenderRequest;
    }

    public IntentSenderRequest[] newArray(int n10) {
        return new IntentSenderRequest[n10];
    }
}

