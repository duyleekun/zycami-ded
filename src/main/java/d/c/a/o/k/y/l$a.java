/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 */
package d.c.a.o.k.y;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import d.c.a.o.k.y.l;
import d.c.a.o.k.y.l$c;
import d.c.a.u.k;

public final class l$a {
    public static final int i = 2;
    public static final int j = 0;
    public static final float k = 0.4f;
    public static final float l = 0.33f;
    public static final int m = 0x400000;
    public final Context a;
    public ActivityManager b;
    public l$c c;
    public float d = 2.0f;
    public float e;
    public float f;
    public float g;
    public int h;

    static {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        n10 = n10 < n11 ? 4 : 1;
        j = n10;
    }

    public l$a(Context context) {
        Object object;
        float f10;
        this.e = f10 = (float)j;
        this.f = 0.4f;
        this.g = 0.33f;
        this.h = 0x400000;
        this.a = context;
        this.b = object = (ActivityManager)context.getSystemService("activity");
        context = context.getResources().getDisplayMetrics();
        super((DisplayMetrics)context);
        this.c = object;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        f10 = 3.6E-44f;
        if (n10 >= n11 && (n10 = (int)(d.c.a.o.k.y.l.e((ActivityManager)(context = this.b)) ? 1 : 0)) != 0) {
            n10 = 0;
            context = null;
            this.e = 0.0f;
        }
    }

    public l a() {
        l l10 = new l(this);
        return l10;
    }

    public l$a b(ActivityManager activityManager) {
        this.b = activityManager;
        return this;
    }

    public l$a c(int n10) {
        this.h = n10;
        return this;
    }

    public l$a d(float f10) {
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        object = object >= 0 ? (Object)true : (Object)false;
        d.c.a.u.k.a((boolean)object, "Bitmap pool screens must be greater than or equal to 0");
        this.e = f10;
        return this;
    }

    public l$a e(float f10) {
        float f11;
        float f12 = 0.0f;
        float f13 = f10 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object >= 0 && (object = (f11 = f10 - (f12 = 1.0f)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) <= 0) {
            object = true;
            f12 = Float.MIN_VALUE;
        } else {
            object = false;
            f12 = 0.0f;
        }
        d.c.a.u.k.a((boolean)object, "Low memory max size multiplier must be between 0 and 1");
        this.g = f10;
        return this;
    }

    public l$a f(float f10) {
        float f11;
        float f12 = 0.0f;
        float f13 = f10 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object >= 0 && (object = (f11 = f10 - (f12 = 1.0f)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) <= 0) {
            object = true;
            f12 = Float.MIN_VALUE;
        } else {
            object = false;
            f12 = 0.0f;
        }
        d.c.a.u.k.a((boolean)object, "Size multiplier must be between 0 and 1");
        this.f = f10;
        return this;
    }

    public l$a g(float f10) {
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        object = object >= 0 ? (Object)true : (Object)false;
        d.c.a.u.k.a((boolean)object, "Memory cache screens must be greater than or equal to 0");
        this.d = f10;
        return this;
    }

    public l$a h(l$c l$c) {
        this.c = l$c;
        return this;
    }
}

