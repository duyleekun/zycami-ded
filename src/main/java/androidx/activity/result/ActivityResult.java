/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.activity.result;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult$1;

public final class ActivityResult
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private final Intent mData;
    private final int mResultCode;

    static {
        ActivityResult$1 activityResult$1 = new ActivityResult$1();
        CREATOR = activityResult$1;
    }

    public ActivityResult(int n10, Intent intent) {
        this.mResultCode = n10;
        this.mData = intent;
    }

    public ActivityResult(Parcel parcel) {
        int n10;
        this.mResultCode = n10 = parcel.readInt();
        n10 = parcel.readInt();
        if (n10 == 0) {
            parcel = null;
        } else {
            Parcelable.Creator creator = Intent.CREATOR;
            parcel = (Intent)creator.createFromParcel(parcel);
        }
        this.mData = parcel;
    }

    public static String resultCodeToString(int n10) {
        int n11 = -1;
        if (n10 != n11) {
            if (n10 != 0) {
                return String.valueOf(n10);
            }
            return "RESULT_CANCELED";
        }
        return "RESULT_OK";
    }

    public int describeContents() {
        return 0;
    }

    public Intent getData() {
        return this.mData;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActivityResult{resultCode=");
        String string2 = ActivityResult.resultCodeToString(this.mResultCode);
        stringBuilder.append(string2);
        stringBuilder.append(", data=");
        string2 = this.mData;
        stringBuilder.append((Object)string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = this.mResultCode;
        parcel.writeInt(n11);
        Intent intent = this.mData;
        if (intent == null) {
            n11 = 0;
            intent = null;
        } else {
            n11 = 1;
        }
        parcel.writeInt(n11);
        intent = this.mData;
        if (intent != null) {
            intent.writeToParcel(parcel, n10);
        }
    }
}

