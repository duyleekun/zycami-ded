/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.common.internal;

import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;

public final class GmsLogger {
    private static final int zza = 15;
    private static final String zzb;
    private final String zzc;
    private final String zzd;

    public GmsLogger(String string2) {
        this(string2, null);
    }

    /*
     * WARNING - void declaration
     */
    public GmsLogger(String string2, String string3) {
        int n10;
        void var4_7;
        String string4 = "log tag cannot be null";
        Preconditions.checkNotNull(string2, string4);
        int bl2 = string2.length();
        int n11 = 1;
        Integer n12 = null;
        int n13 = 23;
        if (bl2 <= n13) {
            int n14 = n11;
        } else {
            boolean bl3 = false;
            string4 = null;
        }
        int n15 = 2;
        Object[] objectArray = new Object[n15];
        objectArray[0] = string2;
        n12 = n13;
        objectArray[n11] = n12;
        String string5 = "tag \"%s\" is longer than the %d character maximum";
        Preconditions.checkArgument((boolean)var4_7, string5, objectArray);
        this.zzc = string2;
        if (string3 != null && (n10 = string3.length()) > 0) {
            this.zzd = string3;
            return;
        }
        this.zzd = null;
    }

    private final String zza(String string2) {
        String string3 = this.zzd;
        if (string3 == null) {
            return string2;
        }
        return string3.concat(string2);
    }

    private final String zza(String string2, Object ... object) {
        string2 = String.format(string2, (Object[])object);
        object = this.zzd;
        if (object == null) {
            return string2;
        }
        return ((String)object).concat(string2);
    }

    public final boolean canLog(int n10) {
        return Log.isLoggable((String)this.zzc, (int)n10);
    }

    public final boolean canLogPii() {
        return false;
    }

    public final void d(String string2, String string3) {
        boolean bl2 = this.canLog(3);
        if (bl2) {
            string3 = this.zza(string3);
            Log.d((String)string2, (String)string3);
        }
    }

    public final void d(String string2, String string3, Throwable throwable) {
        boolean bl2 = this.canLog(3);
        if (bl2) {
            string3 = this.zza(string3);
            Log.d((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public final void e(String string2, String string3) {
        boolean bl2 = this.canLog(6);
        if (bl2) {
            string3 = this.zza(string3);
            Log.e((String)string2, (String)string3);
        }
    }

    public final void e(String string2, String string3, Throwable throwable) {
        boolean bl2 = this.canLog(6);
        if (bl2) {
            string3 = this.zza(string3);
            Log.e((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public final void efmt(String string2, String string3, Object ... objectArray) {
        boolean bl2 = this.canLog(6);
        if (bl2) {
            string3 = this.zza(string3, objectArray);
            Log.e((String)string2, (String)string3);
        }
    }

    public final void i(String string2, String string3) {
        boolean bl2 = this.canLog(4);
        if (bl2) {
            string3 = this.zza(string3);
            Log.i((String)string2, (String)string3);
        }
    }

    public final void i(String string2, String string3, Throwable throwable) {
        boolean bl2 = this.canLog(4);
        if (bl2) {
            string3 = this.zza(string3);
            Log.i((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public final void pii(String string2, String string3) {
        boolean bl2 = this.canLogPii();
        if (bl2) {
            string2 = String.valueOf(string2);
            String string4 = " PII_LOG";
            int n10 = string4.length();
            string2 = n10 != 0 ? string2.concat(string4) : (string4 = new String(string2));
            string3 = this.zza(string3);
            Log.i((String)string2, (String)string3);
        }
    }

    public final void pii(String string2, String string3, Throwable throwable) {
        boolean bl2 = this.canLogPii();
        if (bl2) {
            string2 = String.valueOf(string2);
            String string4 = " PII_LOG";
            int n10 = string4.length();
            string2 = n10 != 0 ? string2.concat(string4) : (string4 = new String(string2));
            string3 = this.zza(string3);
            Log.i((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public final void v(String string2, String string3) {
        boolean bl2 = this.canLog(2);
        if (bl2) {
            string3 = this.zza(string3);
            Log.v((String)string2, (String)string3);
        }
    }

    public final void v(String string2, String string3, Throwable throwable) {
        boolean bl2 = this.canLog(2);
        if (bl2) {
            string3 = this.zza(string3);
            Log.v((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public final void w(String string2, String string3) {
        boolean bl2 = this.canLog(5);
        if (bl2) {
            string3 = this.zza(string3);
            Log.w((String)string2, (String)string3);
        }
    }

    public final void w(String string2, String string3, Throwable throwable) {
        boolean bl2 = this.canLog(5);
        if (bl2) {
            string3 = this.zza(string3);
            Log.w((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public final void wfmt(String string2, String string3, Object ... objectArray) {
        boolean bl2 = this.canLog(5);
        if (bl2) {
            string2 = this.zzc;
            string3 = this.zza(string3, objectArray);
            Log.w((String)string2, (String)string3);
        }
    }

    public final void wtf(String string2, String string3, Throwable throwable) {
        boolean bl2 = this.canLog(7);
        if (bl2) {
            String string4 = this.zza(string3);
            Log.e((String)string2, (String)string4, (Throwable)throwable);
            string3 = this.zza(string3);
            Log.wtf((String)string2, (String)string3, (Throwable)throwable);
        }
    }
}

