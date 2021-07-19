/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.IntentSenderRequest$1;

public final class IntentSenderRequest
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private final Intent mFillInIntent;
    private final int mFlagsMask;
    private final int mFlagsValues;
    private final IntentSender mIntentSender;

    static {
        IntentSenderRequest$1 intentSenderRequest$1 = new IntentSenderRequest$1();
        CREATOR = intentSenderRequest$1;
    }

    public IntentSenderRequest(IntentSender intentSender, Intent intent, int n10, int n11) {
        this.mIntentSender = intentSender;
        this.mFillInIntent = intent;
        this.mFlagsMask = n10;
        this.mFlagsValues = n11;
    }

    public IntentSenderRequest(Parcel parcel) {
        int n10;
        int n11;
        ClassLoader classLoader = IntentSender.class.getClassLoader();
        classLoader = (IntentSender)parcel.readParcelable(classLoader);
        this.mIntentSender = classLoader;
        classLoader = Intent.class.getClassLoader();
        classLoader = (Intent)parcel.readParcelable(classLoader);
        this.mFillInIntent = classLoader;
        this.mFlagsMask = n11 = parcel.readInt();
        this.mFlagsValues = n10 = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public Intent getFillInIntent() {
        return this.mFillInIntent;
    }

    public int getFlagsMask() {
        return this.mFlagsMask;
    }

    public int getFlagsValues() {
        return this.mFlagsValues;
    }

    public IntentSender getIntentSender() {
        return this.mIntentSender;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        IntentSender intentSender = this.mIntentSender;
        parcel.writeParcelable((Parcelable)intentSender, n10);
        intentSender = this.mFillInIntent;
        parcel.writeParcelable((Parcelable)intentSender, n10);
        n10 = this.mFlagsMask;
        parcel.writeInt(n10);
        n10 = this.mFlagsValues;
        parcel.writeInt(n10);
    }
}

