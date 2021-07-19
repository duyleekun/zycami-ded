/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.format.Formatter
 *  android.util.Log
 */
package d.c.a.o.k.y;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.Log;
import d.c.a.o.k.y.l$a;

public final class l {
    private static final String e = "MemorySizeCalculator";
    public static final int f = 4;
    private static final int g = 2;
    private final int a;
    private final int b;
    private final Context c;
    private final int d;

    public l(l$a object) {
        Object object2;
        this.c = object2 = ((l$a)object).a;
        object2 = ((l$a)object).b;
        int n10 = l.e((ActivityManager)object2);
        n10 = n10 != 0 ? ((l$a)object).h / 2 : ((l$a)object).h;
        this.d = n10;
        ActivityManager activityManager = ((l$a)object).b;
        float f10 = ((l$a)object).f;
        float f11 = ((l$a)object).g;
        int n11 = l.c(activityManager, f10, f11);
        Object object3 = ((l$a)object).c;
        int n12 = object3.b();
        Object object4 = ((l$a)object).c;
        int n13 = object4.a();
        f10 = n12 * n13 * 4;
        f11 = ((l$a)object).e * f10;
        n13 = Math.round(f11);
        float f12 = ((l$a)object).d;
        n12 = Math.round(f10 *= f12);
        int n14 = n11 - n10;
        int n15 = n12 + n13;
        if (n15 <= n14) {
            this.b = n12;
            this.a = n13;
        } else {
            f10 = n14;
            f11 = ((l$a)object).e;
            f12 = ((l$a)object).d;
            f10 /= (f11 += f12);
            this.b = n13 = Math.round(f12 *= f10);
            f11 = ((l$a)object).e;
            this.a = n12 = Math.round(f10 *= f11);
        }
        f10 = 4.2E-45f;
        object4 = e;
        n12 = (int)(Log.isLoggable((String)object4, (int)3) ? 1 : 0);
        if (n12 != 0) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Calculation complete, Calculated memory cache size: ");
            n14 = this.b;
            String string2 = this.f(n14);
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(", pool size: ");
            n14 = this.a;
            string2 = this.f(n14);
            ((StringBuilder)object3).append(string2);
            string2 = ", byte array size: ";
            ((StringBuilder)object3).append(string2);
            object2 = this.f(n10);
            ((StringBuilder)object3).append((String)object2);
            object2 = ", memory class limited? ";
            ((StringBuilder)object3).append((String)object2);
            if (n15 > n11) {
                n10 = 1;
            } else {
                n10 = 0;
                object2 = null;
            }
            ((StringBuilder)object3).append(n10 != 0);
            ((StringBuilder)object3).append(", max size: ");
            object2 = this.f(n11);
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(", memoryClass: ");
            n10 = ((l$a)object).b.getMemoryClass();
            ((StringBuilder)object3).append(n10);
            object2 = ", isLowMemoryDevice: ";
            ((StringBuilder)object3).append((String)object2);
            boolean bl2 = l.e(((l$a)object).b);
            ((StringBuilder)object3).append(bl2);
            object = ((StringBuilder)object3).toString();
            Log.d((String)object4, (String)object);
        }
    }

    private static int c(ActivityManager activityManager, float f10, float f11) {
        int n10 = activityManager.getMemoryClass() * 1024 * 1024;
        boolean bl2 = l.e(activityManager);
        float f12 = n10;
        if (bl2) {
            f10 = f11;
        }
        return Math.round(f12 * f10);
    }

    public static boolean e(ActivityManager activityManager) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    private String f(int n10) {
        Context context = this.c;
        long l10 = n10;
        return Formatter.formatFileSize((Context)context, (long)l10);
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.a;
    }

    public int d() {
        return this.b;
    }
}

