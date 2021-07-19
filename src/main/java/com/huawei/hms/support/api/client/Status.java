/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.Intent
 *  android.content.IntentSender
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.support.api.client;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status$a;
import java.util.Arrays;

public final class Status
extends Result
implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public static final Status CoreException;
    public static final Status FAILURE;
    public static final Status MessageNotFound;
    public static final Status RESULT_CANCELED;
    public static final Status RESULT_DEAD_CLIENT;
    public static final Status RESULT_INTERNAL_ERROR;
    public static final Status RESULT_INTERRUPTED;
    public static final Status RESULT_TIMEOUT;
    public static final Status SUCCESS;
    private Intent intent;
    private PendingIntent pendingIntent;
    private int statusCode;
    private String statusMessage;

    static {
        Object object = new Status(0);
        SUCCESS = object;
        object = new Status(1);
        FAILURE = object;
        object = new Status(16);
        RESULT_CANCELED = object;
        object = new Status(18);
        RESULT_DEAD_CLIENT = object;
        object = new Status(8);
        RESULT_INTERNAL_ERROR = object;
        object = new Status(14);
        RESULT_INTERRUPTED = object;
        object = new Status(15);
        RESULT_TIMEOUT = object;
        object = new Status(404);
        MessageNotFound = object;
        object = new Status(500);
        CoreException = object;
        object = new Status$a();
        CREATOR = object;
    }

    public Status(int n10) {
        this(n10, null);
    }

    public Status(int n10, String string2) {
        this.statusCode = n10;
        this.statusMessage = string2;
    }

    public Status(int n10, String string2, PendingIntent pendingIntent) {
        this.statusCode = n10;
        this.statusMessage = string2;
        this.pendingIntent = pendingIntent;
    }

    public Status(int n10, String string2, Intent intent) {
        this.statusCode = n10;
        this.statusMessage = string2;
        this.intent = intent;
    }

    private static boolean equal(Object object, Object object2) {
        boolean bl2;
        if (!(object == object2 || object != null && (bl2 = object.equals(object2)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof Status;
        if (n10 != 0) {
            boolean bl3;
            String string2;
            String string3;
            object = (Status)object;
            n10 = this.statusCode;
            int n11 = ((Status)object).statusCode;
            if (n10 != n11 || (n10 = (int)(Status.equal(string3 = this.statusMessage, string2 = ((Status)object).statusMessage) ? 1 : 0)) == 0 || (n10 = (int)(Status.equal(string3 = this.pendingIntent, string2 = ((Status)object).pendingIntent) ? 1 : 0)) == 0 || !(bl3 = Status.equal(string3 = this.intent, object = ((Status)object).intent))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getErrorString() {
        return this.getStatusMessage();
    }

    public PendingIntent getResolution() {
        return this.pendingIntent;
    }

    public Intent getResolutionIntent() {
        return this.intent;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public boolean hasResolution() {
        boolean bl2;
        PendingIntent pendingIntent = this.pendingIntent;
        if (pendingIntent == null && (pendingIntent = this.intent) == null) {
            bl2 = false;
            pendingIntent = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public int hashCode() {
        Object object = this.statusCode;
        Object[] objectArray = new Object[]{object, object = this.statusMessage, object = this.pendingIntent, object = this.intent};
        return Arrays.hashCode(objectArray);
    }

    public boolean isCanceled() {
        return false;
    }

    public boolean isInterrupted() {
        return false;
    }

    public boolean isSuccess() {
        int n10 = this.statusCode;
        n10 = n10 <= 0 ? 1 : 0;
        return n10 != 0;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public void setPendingIntent(PendingIntent pendingIntent) {
        this.pendingIntent = pendingIntent;
    }

    public void startResolutionForResult(Activity activity, int n10) {
        boolean bl2 = this.hasResolution();
        if (bl2) {
            PendingIntent pendingIntent = this.pendingIntent;
            if (pendingIntent != null) {
                IntentSender intentSender = pendingIntent.getIntentSender();
                activity.startIntentSenderForResult(intentSender, n10, null, 0, 0, 0);
            } else {
                pendingIntent = this.intent;
                activity.startActivityForResult((Intent)pendingIntent, n10);
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{statusCode: ");
        int n10 = this.statusCode;
        stringBuilder.append(n10);
        stringBuilder.append(", statusMessage: ");
        String string2 = this.statusMessage;
        stringBuilder.append(string2);
        stringBuilder.append(", pendingIntent: ");
        string2 = this.pendingIntent;
        stringBuilder.append((Object)string2);
        stringBuilder.append(", intent: ");
        string2 = this.intent;
        stringBuilder.append((Object)string2);
        stringBuilder.append(",}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = this.statusCode;
        parcel.writeInt(n11);
        String string2 = this.statusMessage;
        parcel.writeString(string2);
        string2 = this.pendingIntent;
        if (string2 != null) {
            string2.writeToParcel(parcel, n10);
        }
        PendingIntent.writePendingIntentOrNullToParcel((PendingIntent)this.pendingIntent, (Parcel)parcel);
        string2 = this.intent;
        if (string2 != null) {
            string2.writeToParcel(parcel, n10);
        }
    }
}

