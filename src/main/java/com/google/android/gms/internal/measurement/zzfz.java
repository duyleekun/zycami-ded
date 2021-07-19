/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzfw;
import com.google.android.gms.internal.measurement.zzfx;
import com.google.android.gms.internal.measurement.zzfy;
import java.io.PrintStream;
import java.lang.reflect.Field;

public final class zzfz {
    public static final zzft zza;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object3 = null;
        Object object2 = "android.os.Build$VERSION";
        try {
            int n10;
            int n11;
            try {
                object2 = Class.forName((String)object2);
                String object = "SDK_INT";
                object2 = ((Class)object2).getField(object);
                object2 = ((Field)object2).get(null);
                object3 = object2 = (Integer)object2;
            }
            catch (Exception exception) {
                PrintStream printStream = System.err;
                String string2 = "Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.";
                printStream.println(string2);
                printStream = System.err;
                exception.printStackTrace(printStream);
            }
            object2 = object3 != null && (n11 = ((Integer)object3).intValue()) >= (n10 = 19) ? new zzfy() : ((n11 = (int)(Boolean.getBoolean((String)(object2 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) ? 1 : 0)) == 0 ? new zzfw() : new zzfx());
        }
        catch (Throwable throwable) {
            PrintStream printStream = System.err;
            String string3 = zzfx.class.getName();
            int n12 = String.valueOf(string3).length();
            StringBuilder stringBuilder = new StringBuilder(n12 += 133);
            String string4 = "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ";
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            stringBuilder.append("will be used. The error is: ");
            string3 = stringBuilder.toString();
            printStream.println(string3);
            printStream = System.err;
            throwable.printStackTrace(printStream);
            object2 = new zzfx();
        }
        zza = object2;
        if (object3 == null) {
            return;
        }
        ((Integer)object3).intValue();
    }

    public static void zza(Throwable throwable, Throwable throwable2) {
        zza.zza(throwable, throwable2);
    }
}

