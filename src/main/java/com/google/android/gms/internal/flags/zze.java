/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 */
package com.google.android.gms.internal.flags;

import android.os.StrictMode;
import java.util.concurrent.Callable;

public final class zze {
    public static Object zza(Callable callable) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.ThreadPolicy threadPolicy2 = StrictMode.ThreadPolicy.LAX;
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy2);
            callable = callable.call();
            return callable;
        }
        finally {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
    }
}

