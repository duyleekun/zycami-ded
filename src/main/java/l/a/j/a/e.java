/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Color
 *  android.util.TypedValue
 */
package l.a.j.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;
import l.a.j.a.d;
import l.a.l.a;

public class e {
    private static final ThreadLocal a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public static final int[] e;
    public static final int[] f;
    public static final int[] g;
    public static final int[] h;
    public static final int[] i;
    public static final int[] j;
    public static final int[] k;
    public static final int[] l;
    public static final int[] m;
    public static final int[] n;
    public static final int[] o;
    private static final int[] p;

    static {
        ThreadLocal threadLocal;
        a = threadLocal = new ThreadLocal();
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = -16842910;
        b = nArray;
        nArray = new int[n10];
        nArray[0] = 16842910;
        c = nArray;
        nArray = new int[n10];
        nArray[0] = 16842909;
        d = nArray;
        nArray = new int[n10];
        nArray[0] = 16842908;
        e = nArray;
        nArray = new int[n10];
        nArray[0] = 16843518;
        f = nArray;
        nArray = new int[n10];
        nArray[0] = 16843547;
        g = nArray;
        nArray = new int[n10];
        nArray[0] = 16843623;
        h = nArray;
        nArray = new int[n10];
        nArray[0] = 16843624;
        i = nArray;
        nArray = new int[n10];
        nArray[0] = 16843625;
        j = nArray;
        nArray = new int[n10];
        nArray[0] = 16842919;
        k = nArray;
        nArray = new int[n10];
        nArray[0] = 0x10100A0;
        l = nArray;
        nArray = new int[n10];
        nArray[0] = 0x10100A1;
        m = nArray;
        nArray = new int[]{-16842919, -16842908};
        n = nArray;
        o = new int[0];
        p = new int[n10];
    }

    public static int a(Context object, int n10) {
        boolean bl2;
        ColorStateList colorStateList = l.a.j.a.e.f(object, n10);
        if (colorStateList != null && (bl2 = colorStateList.isStateful())) {
            object = b;
            n10 = colorStateList.getDefaultColor();
            return colorStateList.getColorForState((int[])object, n10);
        }
        colorStateList = l.a.j.a.e.g();
        object.getTheme().resolveAttribute(0x1010033, (TypedValue)colorStateList, true);
        float f10 = colorStateList.getFloat();
        return l.a.j.a.e.e(object, n10, f10);
    }

    public static int b(Context context, int[] nArray) {
        context = context.obtainStyledAttributes(nArray);
        int n10 = context.getResourceId(0, 0);
        context.recycle();
        return n10;
    }

    public static int c(Context context) {
        int[] nArray = new int[]{16842806};
        return l.a.j.a.e.b(context, nArray);
    }

    public static int d(Context context, int n10) {
        TypedArray typedArray;
        block4: {
            int[] nArray = p;
            nArray[0] = n10;
            n10 = 0;
            typedArray = context.obtainStyledAttributes(null, nArray);
            int n11 = typedArray.getResourceId(0, 0);
            if (n11 == 0) break block4;
            int n12 = l.a.j.a.d.c(context, n11);
            return n12;
        }
        typedArray.recycle();
        return 0;
        finally {
            typedArray.recycle();
        }
    }

    public static int e(Context context, int n10, float f10) {
        int n11 = l.a.j.a.e.d(context, n10);
        n10 = Math.round((float)Color.alpha((int)n11) * f10);
        return l.a.l.a.a(n11, n10);
    }

    public static ColorStateList f(Context context, int n10) {
        Object object;
        block4: {
            object = p;
            int n11 = 0;
            object[0] = n10;
            n10 = 0;
            object = context.obtainStyledAttributes(null, object);
            n11 = object.getResourceId(0, 0);
            if (n11 == 0) break block4;
            context = l.a.j.a.d.e(context, n11);
            return context;
        }
        object.recycle();
        return null;
        finally {
            object.recycle();
        }
    }

    private static TypedValue g() {
        ThreadLocal threadLocal = a;
        TypedValue typedValue = (TypedValue)threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        return typedValue;
    }

    public static int h(Context context) {
        int[] nArray = new int[]{16842836};
        return l.a.j.a.e.b(context, nArray);
    }
}

