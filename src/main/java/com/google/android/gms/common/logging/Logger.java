/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.common.logging;

import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

public class Logger {
    private final String zza;
    private final String zzb;
    private final GmsLogger zzc;
    private final int zzd;

    private Logger(String string2, String object) {
        int n10;
        int n11;
        this.zzb = object;
        this.zza = string2;
        this.zzc = object = new GmsLogger(string2);
        for (n11 = 2; (n10 = 7) >= n11 && (n10 = (int)(Log.isLoggable((String)(object = this.zza), (int)n11) ? 1 : 0)) == 0; ++n11) {
        }
        this.zzd = n11;
    }

    /*
     * WARNING - void declaration
     */
    public Logger(String string2, String ... object) {
        void var2_5;
        int n10 = ((Object)object).length;
        if (n10 == 0) {
            String string3 = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('[');
            for (Object object2 : object) {
                int n11;
                int n12 = stringBuilder.length();
                if (n12 > (n11 = 1)) {
                    String string4 = ",";
                    stringBuilder.append(string4);
                }
                stringBuilder.append((String)object2);
            }
            stringBuilder.append(']');
            char c10 = ' ';
            stringBuilder.append(c10);
            String string5 = stringBuilder.toString();
        }
        this(string2, (String)var2_5);
    }

    public void d(String string2, Throwable throwable, Object ... objectArray) {
        boolean bl2 = this.isLoggable(3);
        if (bl2) {
            String string3 = this.zza;
            string2 = this.format(string2, objectArray);
            Log.d((String)string3, (String)string2, (Throwable)throwable);
        }
    }

    public void d(String string2, Object ... objectArray) {
        boolean bl2 = this.isLoggable(3);
        if (bl2) {
            String string3 = this.zza;
            string2 = this.format(string2, objectArray);
            Log.d((String)string3, (String)string2);
        }
    }

    public void e(String string2, Throwable throwable, Object ... objectArray) {
        String string3 = this.zza;
        string2 = this.format(string2, objectArray);
        Log.e((String)string3, (String)string2, (Throwable)throwable);
    }

    public void e(String string2, Object ... objectArray) {
        String string3 = this.zza;
        string2 = this.format(string2, objectArray);
        Log.e((String)string3, (String)string2);
    }

    public String format(String string2, Object ... objectArray) {
        int n10;
        if (objectArray != null && (n10 = objectArray.length) > 0) {
            Locale locale = Locale.US;
            string2 = String.format(locale, string2, objectArray);
        }
        return this.zzb.concat(string2);
    }

    public String getTag() {
        return this.zza;
    }

    public void i(String string2, Object ... objectArray) {
        String string3 = this.zza;
        string2 = this.format(string2, objectArray);
        Log.i((String)string3, (String)string2);
    }

    public boolean isLoggable(int n10) {
        int n11 = this.zzd;
        return n11 <= n10;
    }

    public void v(String string2, Throwable throwable, Object ... objectArray) {
        boolean bl2 = this.isLoggable(2);
        if (bl2) {
            String string3 = this.zza;
            string2 = this.format(string2, objectArray);
            Log.v((String)string3, (String)string2, (Throwable)throwable);
        }
    }

    public void v(String string2, Object ... objectArray) {
        boolean bl2 = this.isLoggable(2);
        if (bl2) {
            String string3 = this.zza;
            string2 = this.format(string2, objectArray);
            Log.v((String)string3, (String)string2);
        }
    }

    public void w(String string2, Object ... objectArray) {
        String string3 = this.zza;
        string2 = this.format(string2, objectArray);
        Log.w((String)string3, (String)string2);
    }

    public void wtf(String string2, Throwable throwable, Object ... objectArray) {
        String string3 = this.zza;
        string2 = this.format(string2, objectArray);
        Log.wtf((String)string3, (String)string2, (Throwable)throwable);
    }

    public void wtf(Throwable throwable) {
        Log.wtf((String)this.zza, (Throwable)throwable);
    }
}

