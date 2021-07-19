/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.clearcut.ClearcutLogger$LogEventBuilder;
import com.google.android.gms.common.internal.GmsLogger;
import com.google.android.gms.internal.mlkit_vision_common.zzcl;
import com.google.android.gms.internal.mlkit_vision_common.zzcq$zzb;
import com.google.android.gms.internal.mlkit_vision_common.zzda;
import com.google.android.gms.internal.mlkit_vision_common.zzr$zzad;
import com.google.firebase.components.Component;
import com.google.firebase.components.Component$Builder;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;

public class zzcm
implements zzcq$zzb {
    public static final Component zza;
    private static final GmsLogger zzb;
    private final ClearcutLogger zzc;

    static {
        Object object = new GmsLogger("ClearcutTransport", "");
        zzb = object;
        object = Component.builder(zzcm.class);
        Object object2 = Dependency.required(Context.class);
        object = ((Component$Builder)object).add((Dependency)object2);
        object2 = zzcl.zza;
        zza = ((Component$Builder)object).factory((ComponentFactory)object2).build();
    }

    public zzcm(Context object) {
        object = ClearcutLogger.anonymousLogger(object, "FIREBASE_ML_SDK");
        this.zzc = object;
    }

    public final void zza(zzr$zzad object) {
        Object object2 = zzb;
        String string2 = String.valueOf(object);
        int n10 = String.valueOf(string2).length() + 30;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("Logging FirebaseMlSdkLogEvent ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        String string3 = "ClearcutTransport";
        ((GmsLogger)object2).d(string3, string2);
        try {
            object2 = this.zzc;
        }
        catch (SecurityException securityException) {
            zzb.e(string3, "Exception thrown from the logging side", securityException);
            return;
        }
        object = ((zzda)object).zzf();
        object = ((ClearcutLogger)object2).newEvent((byte[])object);
        ((ClearcutLogger$LogEventBuilder)object).log();
    }
}

