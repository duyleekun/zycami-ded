/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.IntentSender
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.zzb;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects$ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class Status
extends AbstractSafeParcelable
implements Result,
ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    public static final Status RESULT_CANCELED;
    public static final Status RESULT_DEAD_CLIENT;
    public static final Status RESULT_INTERNAL_ERROR;
    public static final Status RESULT_INTERRUPTED;
    public static final Status RESULT_SUCCESS;
    public static final Status RESULT_TIMEOUT;
    private static final Status zza;
    private final int zzb;
    private final int zzc;
    private final String zzd;
    private final PendingIntent zze;

    static {
        Object object = new Status(0);
        RESULT_SUCCESS = object;
        object = new Status(14);
        RESULT_INTERRUPTED = object;
        object = new Status(8);
        RESULT_INTERNAL_ERROR = object;
        object = new Status(15);
        RESULT_TIMEOUT = object;
        object = new Status(16);
        RESULT_CANCELED = object;
        object = new Status(17);
        zza = object;
        object = new Status(18);
        RESULT_DEAD_CLIENT = object;
        object = new zzb();
        CREATOR = object;
    }

    public Status(int n10) {
        this(n10, null);
    }

    public Status(int n10, int n11, String string2, PendingIntent pendingIntent) {
        this.zzb = n10;
        this.zzc = n11;
        this.zzd = string2;
        this.zze = pendingIntent;
    }

    public Status(int n10, String string2) {
        this(1, n10, string2, null);
    }

    public Status(int n10, String string2, PendingIntent pendingIntent) {
        this(1, n10, string2, pendingIntent);
    }

    public final boolean equals(Object object) {
        boolean bl2;
        String string2;
        String string3;
        int n10 = object instanceof Status;
        if (n10 == 0) {
            return false;
        }
        object = (Status)object;
        n10 = this.zzb;
        int n11 = ((Status)object).zzb;
        return n10 == n11 && (n10 = this.zzc) == (n11 = ((Status)object).zzc) && (n10 = (int)(Objects.equal(string3 = this.zzd, string2 = ((Status)object).zzd) ? 1 : 0)) != 0 && (bl2 = Objects.equal(string3 = this.zze, object = ((Status)object).zze));
    }

    public final PendingIntent getResolution() {
        return this.zze;
    }

    public final Status getStatus() {
        return this;
    }

    public final int getStatusCode() {
        return this.zzc;
    }

    public final String getStatusMessage() {
        return this.zzd;
    }

    public final boolean hasResolution() {
        PendingIntent pendingIntent = this.zze;
        return pendingIntent != null;
    }

    public final int hashCode() {
        Object object = this.zzb;
        Object[] objectArray = new Object[]{object, object = Integer.valueOf(this.zzc), object = this.zzd, object = this.zze};
        return Objects.hashCode(objectArray);
    }

    public final boolean isCanceled() {
        int n10 = this.zzc;
        int n11 = 16;
        return n10 == n11;
    }

    public final boolean isInterrupted() {
        int n10 = this.zzc;
        int n11 = 14;
        return n10 == n11;
    }

    public final boolean isSuccess() {
        int n10 = this.zzc;
        return n10 <= 0;
    }

    public final void startResolutionForResult(Activity activity, int n10) {
        boolean bl2 = this.hasResolution();
        if (!bl2) {
            return;
        }
        IntentSender intentSender = ((PendingIntent)Preconditions.checkNotNull(this.zze)).getIntentSender();
        activity.startIntentSenderForResult(intentSender, n10, null, 0, 0, 0);
    }

    public final String toString() {
        Objects$ToStringHelper objects$ToStringHelper = Objects.toStringHelper(this);
        String string2 = this.zza();
        objects$ToStringHelper = objects$ToStringHelper.add("statusCode", string2);
        string2 = this.zze;
        return objects$ToStringHelper.add("resolution", string2).toString();
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.getStatusCode();
        SafeParcelWriter.writeInt(parcel, 1, n12);
        String string2 = this.getStatusMessage();
        SafeParcelWriter.writeString(parcel, 2, string2, false);
        string2 = this.zze;
        SafeParcelWriter.writeParcelable(parcel, 3, (Parcelable)string2, n10, false);
        n10 = this.zzb;
        SafeParcelWriter.writeInt(parcel, 1000, n10);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }

    public final String zza() {
        String string2 = this.zzd;
        if (string2 != null) {
            return string2;
        }
        return CommonStatusCodes.getStatusCodeString(this.zzc);
    }
}

