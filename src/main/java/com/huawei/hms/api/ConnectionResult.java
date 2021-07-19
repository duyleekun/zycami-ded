/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.api.ConnectionResult$a;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.Objects;

public final class ConnectionResult
implements Parcelable {
    public static final int API_UNAVAILABLE = 1000;
    public static final int BINDFAIL_RESOLUTION_BACKGROUND = 7;
    public static final int BINDFAIL_RESOLUTION_REQUIRED = 6;
    public static final int CANCELED = 13;
    public static final Parcelable.Creator CREATOR;
    public static final int DEVELOPER_ERROR = 10;
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 9002;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 9000;
    public static final int RESOLUTION_REQUIRED = 9001;
    public static final int RESTRICTED_PROFILE = 9003;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UNSUPPORTED = 21;
    public static final int SERVICE_UPDATING = 9004;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 9005;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    private int a = 1;
    private PendingIntent b = null;
    private String c = null;
    private int d;

    static {
        ConnectionResult$a connectionResult$a = new ConnectionResult$a();
        CREATOR = connectionResult$a;
    }

    public ConnectionResult(int n10) {
        this(n10, null);
    }

    public ConnectionResult(int n10, int n11, PendingIntent pendingIntent, String string2) {
        this.a = n10;
        this.d = n11;
        this.b = pendingIntent;
        this.c = string2;
    }

    public ConnectionResult(int n10, PendingIntent pendingIntent) {
        this(n10, pendingIntent, null);
    }

    public ConnectionResult(int n10, PendingIntent pendingIntent, String string2) {
        this(1, n10, pendingIntent, string2);
    }

    private ConnectionResult(Parcel parcel) {
        String string2;
        int n10;
        this.a = n10 = parcel.readInt();
        this.d = n10 = parcel.readInt();
        this.c = string2 = parcel.readString();
        string2 = PendingIntent.CREATOR;
        parcel = (Parcelable)string2.createFromParcel(parcel);
        if (parcel != null) {
            parcel = (PendingIntent)parcel;
            this.b = parcel;
        }
    }

    public /* synthetic */ ConnectionResult(Parcel parcel, ConnectionResult$a connectionResult$a) {
        this(parcel);
    }

    public static String a(int n10) {
        int n11 = -1;
        if (n10 != n11) {
            if (n10 != 0) {
                n11 = 1;
                if (n10 != n11) {
                    n11 = 2;
                    if (n10 != n11) {
                        n11 = 3;
                        if (n10 != n11) {
                            n11 = 13;
                            if (n10 != n11) {
                                n11 = 14;
                                if (n10 != n11) {
                                    n11 = 19;
                                    if (n10 != n11) {
                                        n11 = 21;
                                        if (n10 != n11) {
                                            switch (n10) {
                                                default: {
                                                    StringBuilder stringBuilder = new StringBuilder();
                                                    stringBuilder.append("UNKNOWN_ERROR_CODE(");
                                                    stringBuilder.append(n10);
                                                    stringBuilder.append(")");
                                                    return stringBuilder.toString();
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
                                                case 6: 
                                            }
                                            return "RESOLUTION_REQUIRED";
                                        }
                                        return "API_VERSION_UPDATE_REQUIRED";
                                    }
                                    return "SERVICE_MISSING_PERMISSION";
                                }
                                return "TIMEOUT";
                            }
                            return "CANCELED";
                        }
                        return "SERVICE_DISABLED";
                    }
                    return "SERVICE_VERSION_UPDATE_REQUIRED";
                }
                return "SERVICE_MISSING";
            }
            return "SUCCESS";
        }
        return "UNKNOWN";
    }

    public int describeContents() {
        return 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof ConnectionResult;
        if (n10 == 0) return false;
        try {
            n10 = this.a;
            object2 = object;
        }
        catch (Exception exception) {
            return false;
        }
        object2 = (ConnectionResult)object;
        int n11 = ((ConnectionResult)object2).a;
        if (n10 != n11) return false;
        n10 = this.d;
        object2 = object;
        object2 = (ConnectionResult)object;
        n11 = ((ConnectionResult)object2).d;
        if (n10 != n11) return false;
        String string2 = this.c;
        object2 = object;
        object2 = (ConnectionResult)object;
        object2 = ((ConnectionResult)object2).c;
        n10 = (int)(string2.equals(object2) ? 1 : 0);
        if (n10 == 0) return false;
        string2 = this.b;
        object = (ConnectionResult)object;
        object = ((ConnectionResult)object).b;
        boolean bl3 = string2.equals(object);
        if (!bl3) return false;
        return bl2;
    }

    public int getErrorCode() {
        return this.d;
    }

    public final String getErrorMessage() {
        return this.c;
    }

    public final PendingIntent getResolution() {
        return this.b;
    }

    public final boolean hasResolution() {
        HuaweiApiAvailability huaweiApiAvailability = HuaweiApiAvailability.getInstance();
        int n10 = this.d;
        PendingIntent pendingIntent = this.b;
        return huaweiApiAvailability.isUserResolvableError(n10, pendingIntent);
    }

    public int hashCode() {
        Object object = (long)this.a;
        Object[] objectArray = new Object[]{object, object = Long.valueOf(this.getErrorCode()), object = this.getErrorMessage(), object = this.b};
        return Objects.hashCode(objectArray);
    }

    public final boolean isSuccess() {
        int n10 = this.d;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public final void startResolutionForResult(Activity activity, int n10) {
        boolean bl2 = this.hasResolution();
        if (bl2) {
            HuaweiApiAvailability huaweiApiAvailability = HuaweiApiAvailability.getInstance();
            int n11 = this.d;
            PendingIntent pendingIntent = this.b;
            huaweiApiAvailability.resolveError(activity, n11, n10, pendingIntent);
        }
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = this.a;
        parcel.writeInt(n11);
        n11 = this.d;
        parcel.writeInt(n11);
        String string2 = this.c;
        parcel.writeString(string2);
        this.b.writeToParcel(parcel, n10);
    }
}

