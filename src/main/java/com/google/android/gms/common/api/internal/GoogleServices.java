/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.R$string;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.internal.zzs;

public final class GoogleServices {
    private static final Object zza;
    private static GoogleServices zzb;
    private final String zzc;
    private final Status zzd;
    private final boolean zze;
    private final boolean zzf;

    static {
        Object object;
        zza = object = new Object();
    }

    public GoogleServices(Context object) {
        boolean bl2;
        Object object2 = object.getResources();
        int n10 = R$string.common_google_play_services_unknown_issue;
        String string2 = object2.getResourcePackageName(n10);
        String string3 = "integer";
        n10 = object2.getIdentifier("google_app_measurement_enable", string3, string2);
        int n11 = 0;
        float f10 = 0.0f;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 != 0) {
            int n13 = object2.getInteger(n10);
            if (n13 != 0) {
                n11 = n12;
                f10 = f11;
            }
            n13 = n11 ^ 1;
            this.zzf = n13;
            n12 = n11;
            f11 = f10;
        } else {
            this.zzf = false;
        }
        this.zze = n12;
        object2 = zzs.zza(object);
        if (object2 == null) {
            super((Context)object);
            object = "google_app_id";
            object2 = ((StringResourceValueReader)object2).getString((String)object);
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)object2)) {
            super(10, "Missing google app id value from from string resources with name google_app_id.");
            this.zzd = object;
            this.zzc = null;
            return;
        }
        this.zzc = object2;
        object = Status.RESULT_SUCCESS;
        this.zzd = object;
    }

    public GoogleServices(String object, boolean bl2) {
        boolean bl3;
        this.zzc = object;
        this.zzd = object = Status.RESULT_SUCCESS;
        this.zze = bl2;
        this.zzf = bl3 = bl2 ^ true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static GoogleServices checkInitialized(String string2) {
        Object object = zza;
        synchronized (object) {
            Object object2 = zzb;
            if (object2 != null) {
                return object2;
            }
            String string3 = String.valueOf(string2);
            int n10 = string3.length() + 34;
            StringBuilder stringBuilder = new StringBuilder(n10);
            string3 = "Initialize must be called before ";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            string2 = ".";
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            object2 = new IllegalStateException(string2);
            throw object2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void clearInstanceForTest() {
        Object object = zza;
        synchronized (object) {
            Object var1_1 = null;
            zzb = null;
            return;
        }
    }

    public static String getGoogleAppId() {
        return GoogleServices.checkInitialized((String)"getGoogleAppId").zzc;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Status initialize(Context object) {
        Preconditions.checkNotNull(object, "Context must not be null.");
        Object object2 = zza;
        synchronized (object2) {
            GoogleServices googleServices = zzb;
            if (googleServices == null) {
                zzb = googleServices = new GoogleServices((Context)object);
            }
            object = zzb;
            return object.zzd;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Status initialize(Context object, String object2, boolean bl2) {
        Object object3 = "Context must not be null.";
        Preconditions.checkNotNull(object, object3);
        Preconditions.checkNotEmpty((String)object2, "App ID must be nonempty.");
        object = zza;
        synchronized (object) {
            object3 = zzb;
            if (object3 != null) {
                return ((GoogleServices)object3).checkGoogleAppId((String)object2);
            }
            zzb = object3 = new GoogleServices((String)object2, bl2);
            return ((GoogleServices)object3).zzd;
        }
    }

    public static boolean isMeasurementEnabled() {
        boolean bl2;
        GoogleServices googleServices = GoogleServices.checkInitialized("isMeasurementEnabled");
        Status status = googleServices.zzd;
        boolean bl3 = status.isSuccess();
        return bl3 && (bl2 = googleServices.zze);
    }

    public static boolean isMeasurementExplicitlyDisabled() {
        return GoogleServices.checkInitialized((String)"isMeasurementExplicitlyDisabled").zzf;
    }

    public final Status checkGoogleAppId(String object) {
        boolean bl2;
        String string2 = this.zzc;
        if (string2 != null && !(bl2 = string2.equals(object))) {
            String string3 = this.zzc;
            int n10 = String.valueOf(string3).length() + 97;
            StringBuilder stringBuilder = new StringBuilder(n10);
            stringBuilder.append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
            stringBuilder.append(string3);
            stringBuilder.append("'.");
            string3 = stringBuilder.toString();
            object = new Status(10, string3);
            return object;
        }
        return Status.RESULT_SUCCESS;
    }
}

