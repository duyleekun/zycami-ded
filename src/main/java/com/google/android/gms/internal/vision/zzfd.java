/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfd$zza;
import com.google.android.gms.internal.vision.zzfg;
import com.google.android.gms.internal.vision.zzfh;
import com.google.android.gms.internal.vision.zzfj;
import java.io.PrintStream;
import java.lang.reflect.Field;

public final class zzfd {
    private static final zzfg zznw;
    private static final int zznx;

    /*
     * Loose catch block
     */
    static {
        Object object;
        Integer n10;
        int n11;
        block12: {
            block14: {
                block13: {
                    int n12;
                    block11: {
                        n11 = 1;
                        n10 = zzfd.zzdc();
                        if (n10 == null) break block11;
                        try {
                            n12 = n10;
                            int n13 = 19;
                            if (n12 < n13) break block11;
                        }
                        catch (Throwable throwable) {}
                        object = new zzfj();
                        break block12;
                    }
                    object = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic";
                    n12 = Boolean.getBoolean((String)object) ^ n11;
                    if (n12 == 0) break block13;
                    object = new zzfh();
                    break block12;
                }
                object = new zzfd$zza();
                break block12;
                break block14;
                catch (Throwable throwable) {
                    n10 = null;
                }
            }
            PrintStream printStream = System.err;
            String string2 = zzfd$zza.class.getName();
            int n14 = String.valueOf(string2).length() + 133;
            StringBuilder stringBuilder = new StringBuilder(n14);
            String string3 = "An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ";
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            stringBuilder.append("will be used. The error is: ");
            string2 = stringBuilder.toString();
            printStream.println(string2);
            printStream = System.err;
            ((Throwable)object).printStackTrace(printStream);
            object = new zzfd$zza();
        }
        zznw = object;
        if (n10 != null) {
            n11 = n10;
        }
        zznx = n11;
    }

    public static void zza(Throwable throwable) {
        zznw.zza(throwable);
    }

    public static void zza(Throwable throwable, Throwable throwable2) {
        zznw.zza(throwable, throwable2);
    }

    private static Integer zzdc() {
        Object object;
        Object object2 = "android.os.Build$VERSION";
        try {
            object2 = Class.forName((String)object2);
            object = "SDK_INT";
        }
        catch (Exception exception) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            object = System.err;
            exception.printStackTrace((PrintStream)object);
            return null;
        }
        object2 = ((Class)object2).getField((String)object);
        object2 = ((Field)object2).get(null);
        return (Integer)object2;
    }
}

