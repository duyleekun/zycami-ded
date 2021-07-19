/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Bundle
 *  android.util.Log
 */
package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

public final class GmsClientSupervisor$zza {
    private static final Uri zzf;
    private final String zza;
    private final String zzb;
    private final ComponentName zzc;
    private final int zzd;
    private final boolean zze;

    static {
        Uri.Builder builder = new Uri.Builder();
        zzf = builder.scheme("content").authority("com.google.android.gms.chimera").build();
    }

    public GmsClientSupervisor$zza(ComponentName componentName, int n10) {
        this.zza = null;
        this.zzb = null;
        this.zzc = componentName = (ComponentName)Preconditions.checkNotNull(componentName);
        this.zzd = n10;
        this.zze = false;
    }

    public GmsClientSupervisor$zza(String string2, int n10) {
        this(string2, "com.google.android.gms", n10);
    }

    private GmsClientSupervisor$zza(String string2, String string3, int n10) {
        this(string2, string3, n10, false);
    }

    public GmsClientSupervisor$zza(String string2, String string3, int n10, boolean bl2) {
        this.zza = string2 = Preconditions.checkNotEmpty(string2);
        this.zzb = string2 = Preconditions.checkNotEmpty(string3);
        this.zzc = null;
        this.zzd = n10;
        this.zze = bl2;
    }

    private final Intent zzb(Context object) {
        String string2 = "ConnectionStatusConfig";
        Object object2 = new Bundle();
        String string3 = this.zza;
        CharSequence charSequence = "serviceActionBundleKey";
        object2.putString((String)charSequence, string3);
        string3 = null;
        object = object.getContentResolver();
        charSequence = zzf;
        String string4 = "serviceIntentCall";
        try {
            object = object.call((Uri)charSequence, string4, null, (Bundle)object2);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            object = String.valueOf(illegalArgumentException);
            int n10 = String.valueOf(object).length() + 34;
            charSequence = new StringBuilder(n10);
            object2 = "Dynamic intent resolution failed: ";
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            Log.w((String)string2, (String)object);
            object = null;
        }
        if (object != null) {
            object2 = "serviceResponseIntentKey";
            object = object.getParcelable((String)object2);
            string3 = object;
            string3 = (Intent)object;
        }
        if (string3 == null) {
            object = "Dynamic lookup for intent failed for action: ";
            object2 = String.valueOf(this.zza);
            int n11 = ((String)object2).length();
            object = n11 != 0 ? ((String)object).concat((String)object2) : (object2 = new String((String)object));
            Log.w((String)string2, (String)object);
        }
        return string3;
    }

    public final boolean equals(Object object) {
        int n10;
        int n11;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n12 = object instanceof GmsClientSupervisor$zza;
        if (n12 == 0) {
            return false;
        }
        object = (GmsClientSupervisor$zza)object;
        String string2 = this.zza;
        String string3 = ((GmsClientSupervisor$zza)object).zza;
        n12 = Objects.equal(string2, string3);
        if (n12 != 0 && (n12 = Objects.equal(string2 = this.zzb, string3 = ((GmsClientSupervisor$zza)object).zzb)) != 0 && (n12 = Objects.equal(string2 = this.zzc, string3 = ((GmsClientSupervisor$zza)object).zzc)) != 0 && (n12 = this.zzd) == (n11 = ((GmsClientSupervisor$zza)object).zzd) && (n12 = (int)(this.zze ? 1 : 0)) == (n10 = ((GmsClientSupervisor$zza)object).zze)) {
            return bl2;
        }
        return false;
    }

    public final int hashCode() {
        Object object = this.zza;
        object = this.zzb;
        object = this.zzc;
        object = this.zzd;
        Object[] objectArray = new Object[]{object, object, object, object, object = Boolean.valueOf(this.zze)};
        return Objects.hashCode(objectArray);
    }

    public final String toString() {
        String string2 = this.zza;
        if (string2 == null) {
            Preconditions.checkNotNull(this.zzc);
            string2 = this.zzc.flattenToString();
        }
        return string2;
    }

    public final Intent zza(Context object) {
        String string2 = this.zza;
        if (string2 != null) {
            boolean bl2 = this.zze;
            object = bl2 ? this.zzb((Context)object) : null;
            if (object == null) {
                string2 = this.zza;
                object = new Intent(string2);
                string2 = this.zzb;
                object = object.setPackage(string2);
            }
        } else {
            object = new Intent();
            string2 = this.zzc;
            object = object.setComponent((ComponentName)string2);
        }
        return object;
    }

    public final String zza() {
        return this.zzb;
    }

    public final ComponentName zzb() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zzd;
    }
}

