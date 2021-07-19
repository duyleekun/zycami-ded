/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 */
package com.google.android.gms.internal.measurement;

import android.os.Binder;
import com.google.android.gms.internal.measurement.zzeq;

public final class zzep {
    public static Object zza(zzeq object) {
        long l10;
        try {
            object = object.zza();
        }
        catch (SecurityException securityException) {
            l10 = Binder.clearCallingIdentity();
            object = object.zza();
            return object;
        }
        return object;
        {
            finally {
                Binder.restoreCallingIdentity((long)l10);
            }
        }
    }
}

