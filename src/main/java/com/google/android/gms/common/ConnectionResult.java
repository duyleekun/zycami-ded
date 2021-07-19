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
package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects$ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.zza;

public final class ConnectionResult
extends AbstractSafeParcelable {
    public static final int API_UNAVAILABLE = 16;
    public static final int CANCELED = 13;
    public static final Parcelable.Creator CREATOR;
    public static final int DEVELOPER_ERROR = 10;
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int RESTRICTED_PROFILE = 20;
    public static final ConnectionResult RESULT_SUCCESS;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UPDATING = 18;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 17;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    public static final int UNKNOWN = 255;
    private final int zza;
    private final int zzb;
    private final PendingIntent zzc;
    private final String zzd;

    static {
        Object object = new ConnectionResult(0);
        RESULT_SUCCESS = object;
        object = new zza();
        CREATOR = object;
    }

    public ConnectionResult(int n10) {
        this(n10, null, null);
    }

    public ConnectionResult(int n10, int n11, PendingIntent pendingIntent, String string2) {
        this.zza = n10;
        this.zzb = n11;
        this.zzc = pendingIntent;
        this.zzd = string2;
    }

    public ConnectionResult(int n10, PendingIntent pendingIntent) {
        this(n10, pendingIntent, null);
    }

    public ConnectionResult(int n10, PendingIntent pendingIntent, String string2) {
        this(1, n10, pendingIntent, string2);
    }

    public static String zza(int n10) {
        int n11 = 99;
        if (n10 != n11) {
            n11 = 1500;
            if (n10 != n11) {
                switch (n10) {
                    default: {
                        switch (n10) {
                            default: {
                                StringBuilder stringBuilder = new StringBuilder(31);
                                stringBuilder.append("UNKNOWN_ERROR_CODE(");
                                stringBuilder.append(n10);
                                stringBuilder.append(")");
                                return stringBuilder.toString();
                            }
                            case 21: {
                                return "API_VERSION_UPDATE_REQUIRED";
                            }
                            case 20: {
                                return "RESTRICTED_PROFILE";
                            }
                            case 19: {
                                return "SERVICE_MISSING_PERMISSION";
                            }
                            case 18: {
                                return "SERVICE_UPDATING";
                            }
                            case 17: {
                                return "SIGN_IN_FAILED";
                            }
                            case 16: {
                                return "API_UNAVAILABLE";
                            }
                            case 15: {
                                return "INTERRUPTED";
                            }
                            case 14: {
                                return "TIMEOUT";
                            }
                            case 13: 
                        }
                        return "CANCELED";
                    }
                    case 11: {
                        return "LICENSE_CHECK_FAILED";
                    }
                    case 10: {
                        return "DEVELOPER_ERROR";
                    }
                    case 9: {
                        return "SERVICE_INVALID";
                    }
                    case 8: {
                        return "INTERNAL_ERROR";
                    }
                    case 7: {
                        return "NETWORK_ERROR";
                    }
                    case 6: {
                        return "RESOLUTION_REQUIRED";
                    }
                    case 5: {
                        return "INVALID_ACCOUNT";
                    }
                    case 4: {
                        return "SIGN_IN_REQUIRED";
                    }
                    case 3: {
                        return "SERVICE_DISABLED";
                    }
                    case 2: {
                        return "SERVICE_VERSION_UPDATE_REQUIRED";
                    }
                    case 1: {
                        return "SERVICE_MISSING";
                    }
                    case 0: {
                        return "SUCCESS";
                    }
                    case -1: 
                }
                return "UNKNOWN";
            }
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        return "UNFINISHED";
    }

    public final boolean equals(Object object) {
        boolean bl2;
        PendingIntent pendingIntent;
        Object object2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        int n10 = object instanceof ConnectionResult;
        if (n10 == 0) {
            return false;
        }
        object = (ConnectionResult)object;
        n10 = this.zzb;
        int n11 = ((ConnectionResult)object).zzb;
        if (n10 == n11 && (n10 = (int)(Objects.equal(object2 = this.zzc, pendingIntent = ((ConnectionResult)object).zzc) ? 1 : 0)) != 0 && (bl2 = Objects.equal(object2 = this.zzd, object = ((ConnectionResult)object).zzd))) {
            return bl3;
        }
        return false;
    }

    public final int getErrorCode() {
        return this.zzb;
    }

    public final String getErrorMessage() {
        return this.zzd;
    }

    public final PendingIntent getResolution() {
        return this.zzc;
    }

    public final boolean hasResolution() {
        PendingIntent pendingIntent;
        int n10 = this.zzb;
        return n10 != 0 && (pendingIntent = this.zzc) != null;
    }

    public final int hashCode() {
        Object object = this.zzb;
        Object[] objectArray = new Object[]{object, object = this.zzc, object = this.zzd};
        return Objects.hashCode(objectArray);
    }

    public final boolean isSuccess() {
        int n10 = this.zzb;
        return n10 == 0;
    }

    public final void startResolutionForResult(Activity activity, int n10) {
        boolean bl2 = this.hasResolution();
        if (!bl2) {
            return;
        }
        IntentSender intentSender = ((PendingIntent)Preconditions.checkNotNull(this.zzc)).getIntentSender();
        activity.startIntentSenderForResult(intentSender, n10, null, 0, 0, 0);
    }

    public final String toString() {
        Objects$ToStringHelper objects$ToStringHelper = Objects.toStringHelper(this);
        String string2 = ConnectionResult.zza(this.zzb);
        objects$ToStringHelper = objects$ToStringHelper.add("statusCode", string2);
        string2 = this.zzc;
        objects$ToStringHelper = objects$ToStringHelper.add("resolution", string2);
        string2 = this.zzd;
        return objects$ToStringHelper.add("message", string2).toString();
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.zza;
        SafeParcelWriter.writeInt(parcel, 1, n12);
        n12 = this.getErrorCode();
        SafeParcelWriter.writeInt(parcel, 2, n12);
        PendingIntent pendingIntent = this.getResolution();
        SafeParcelWriter.writeParcelable(parcel, 3, (Parcelable)pendingIntent, n10, false);
        String string2 = this.getErrorMessage();
        SafeParcelWriter.writeString(parcel, 4, string2, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }
}

