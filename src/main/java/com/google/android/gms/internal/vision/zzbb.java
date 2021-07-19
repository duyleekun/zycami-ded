/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 */
package com.google.android.gms.internal.vision;

import android.os.Binder;
import com.google.android.gms.internal.vision.zzba;

public final class zzbb {
    public static Object zza(zzba object) {
        long l10;
        try {
            object = object.zzac();
        }
        catch (SecurityException securityException) {
            l10 = Binder.clearCallingIdentity();
            object = object.zzac();
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

