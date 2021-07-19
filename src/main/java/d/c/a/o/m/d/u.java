/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory$Options
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package d.c.a.o.m.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;

public final class u {
    public static final int f = 128;
    private static final int g = 0;
    private static final File h;
    private static final int i = 50;
    private static final int j = 700;
    private static final int k = 20000;
    private static volatile u l;
    private final boolean a;
    private final int b;
    private final int c;
    private int d;
    private boolean e = true;

    static {
        File file;
        h = file = new File("/proc/self/fd");
    }

    public u() {
        int n10;
        this.a = n10 = u.d();
        n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            this.b = 20000;
            n10 = 0;
            this.c = 0;
        } else {
            this.b = 700;
            this.c = n10 = 128;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static u a() {
        Object object = l;
        if (object != null) return l;
        object = u.class;
        synchronized (object) {
            u u10 = l;
            if (u10 != null) return l;
            l = u10 = new u();
            return l;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean b() {
        synchronized (this) {
            int n10;
            int n11 = this.d;
            int n12 = 1;
            this.d = n11 += n12;
            int n13 = 50;
            if (n11 < n13) return (int)(this.e ? 1 : 0) != 0;
            n11 = 0;
            String string2 = null;
            this.d = 0;
            File file = h;
            String[] stringArray = file.list();
            n13 = stringArray.length;
            if (n13 >= (n10 = this.b)) {
                n12 = 0;
                Object var7_9 = null;
            }
            this.e = n12;
            if (n12 != 0) return (int)(this.e ? 1 : 0) != 0;
            string2 = "Downsampler";
            n12 = 5;
            n11 = (int)(Log.isLoggable((String)string2, (int)n12) ? 1 : 0);
            if (n11 == 0) return (int)(this.e ? 1 : 0) != 0;
            string2 = "Downsampler";
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ";
            stringBuilder.append(string3);
            stringBuilder.append(n13);
            String string4 = ", limit ";
            stringBuilder.append(string4);
            n13 = this.b;
            stringBuilder.append(n13);
            String string5 = stringBuilder.toString();
            Log.w((String)string2, (String)string5);
            return (int)(this.e ? 1 : 0) != 0;
        }
    }

    private static boolean d() {
        int n10;
        int n11;
        String string2 = Build.MODEL;
        int n12 = 1;
        if (string2 != null && (n11 = string2.length()) >= (n10 = 7)) {
            int n13;
            n11 = 0;
            string2 = string2.substring(0, n10);
            string2.hashCode();
            n10 = -1;
            int n14 = string2.hashCode();
            switch (n14) {
                default: {
                    break;
                }
                case -1398222624: {
                    String string3 = "SM-N935";
                    n13 = (int)(string2.equals(string3) ? 1 : 0);
                    if (n13 == 0) break;
                    n10 = 6;
                    break;
                }
                case -1398343746: {
                    String string4 = "SM-J720";
                    n13 = (int)(string2.equals(string4) ? 1 : 0);
                    if (n13 == 0) break;
                    n10 = 5;
                    break;
                }
                case -1398431068: {
                    String string5 = "SM-G965";
                    n13 = (int)(string2.equals(string5) ? 1 : 0);
                    if (n13 == 0) break;
                    n10 = 4;
                    break;
                }
                case -1398431073: {
                    String string6 = "SM-G960";
                    n13 = (int)(string2.equals(string6) ? 1 : 0);
                    if (n13 == 0) break;
                    n10 = 3;
                    break;
                }
                case -1398431161: {
                    String string7 = "SM-G935";
                    n13 = (int)(string2.equals(string7) ? 1 : 0);
                    if (n13 == 0) break;
                    n10 = 2;
                    break;
                }
                case -1398431166: {
                    String string8 = "SM-G930";
                    n13 = (int)(string2.equals(string8) ? 1 : 0);
                    if (n13 == 0) break;
                    n10 = n12;
                    break;
                }
                case -1398613787: {
                    String string9 = "SM-A520";
                    n13 = (int)(string2.equals(string9) ? 1 : 0);
                    if (n13 == 0) break;
                    n10 = 0;
                }
            }
            switch (n10) {
                default: {
                    return n12 != 0;
                }
                case 0: 
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: 
            }
            n13 = Build.VERSION.SDK_INT;
            n10 = 26;
            if (n13 == n10) {
                n12 = 0;
            }
        }
        return n12 != 0;
    }

    public boolean c(int n10, int n11, boolean n12, boolean bl2) {
        int n13;
        boolean bl3 = false;
        if (n12 != 0 && (n12 = this.a) != 0 && (n12 = Build.VERSION.SDK_INT) >= (n13 = 26) && !bl2 && n10 >= (n12 = this.c) && n11 >= n12 && (n10 = (int)(this.b() ? 1 : 0)) != 0) {
            bl3 = true;
        }
        return bl3;
    }

    public boolean e(int n10, int n11, BitmapFactory.Options options, boolean bl2, boolean bl3) {
        if ((n10 = (int)(this.c(n10, n11, bl2, bl3) ? 1 : 0)) != 0) {
            Bitmap.Config config;
            options.inPreferredConfig = config = Bitmap.Config.HARDWARE;
            n11 = 0;
            config = null;
            options.inMutable = false;
        }
        return n10 != 0;
    }
}

