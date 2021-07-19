/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.util.Log
 */
package d.c.a.o.k.z;

import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import d.c.a.o.k.z.b$a;
import java.io.File;
import java.util.regex.Pattern;

public final class b {
    private static final String a = "GlideRuntimeCompat";
    private static final String b = "cpu[0-9]+";
    private static final String c = "/sys/devices/system/cpu/";

    private b() {
    }

    public static int a() {
        Runtime runtime = Runtime.getRuntime();
        int n10 = runtime.availableProcessors();
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 17;
        if (n11 < n12) {
            n11 = d.c.a.o.k.z.b.b();
            n10 = Math.max(n11, n10);
        }
        return n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static int b() {
        int n10;
        File[] fileArray;
        block7: {
            fileArray = "GlideRuntimeCompat";
            StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
            try {
                Object object = c;
                File file = new File((String)object);
                object = b;
                object = Pattern.compile((String)object);
                b$a b$a = new b$a((Pattern)object);
                fileArray = file.listFiles(b$a);
            }
            catch (Throwable throwable) {
                int n11 = 6;
                try {
                    n11 = (int)(Log.isLoggable((String)fileArray, (int)n11) ? 1 : 0);
                    if (n11 != 0) {
                        String string2 = "Failed to calculate accurate cpu count";
                        Log.e((String)fileArray, (String)string2, (Throwable)throwable);
                    }
                    n10 = 0;
                    fileArray = null;
                    break block7;
                }
                finally {
                    StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
                }
            }
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        }
        int n12 = 1;
        if (fileArray != null) {
            n10 = fileArray.length;
            return Math.max(n12, n10);
        }
        n10 = 0;
        return Math.max(n12, n10);
    }
}

