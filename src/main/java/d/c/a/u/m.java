/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Build$VERSION
 *  android.os.Looper
 */
package d.c.a.u;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import d.c.a.o.l.l;
import d.c.a.u.m$a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

public final class m {
    private static final int a = 31;
    private static final int b = 17;
    private static final char[] c = "0123456789abcdef".toCharArray();
    private static final char[] d = new char[64];

    private m() {
    }

    public static void a() {
        boolean bl2 = m.s();
        if (bl2) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You must call this method on a background thread");
        throw illegalArgumentException;
    }

    public static void b() {
        boolean bl2 = m.t();
        if (bl2) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You must call this method on the main thread");
        throw illegalArgumentException;
    }

    public static boolean c(Object object, Object object2) {
        if (object == null) {
            boolean bl2;
            if (object2 == null) {
                bl2 = true;
            } else {
                bl2 = false;
                object = null;
            }
            return bl2;
        }
        boolean bl3 = object instanceof l;
        if (bl3) {
            return ((l)object).a(object2);
        }
        return object.equals(object2);
    }

    public static boolean d(Object object, Object object2) {
        boolean bl2;
        if (object == null) {
            if (object2 == null) {
                bl2 = true;
            } else {
                bl2 = false;
                object = null;
            }
        } else {
            bl2 = object.equals(object2);
        }
        return bl2;
    }

    private static String e(byte[] object, char[] cArray) {
        int n10;
        for (int i10 = 0; i10 < (n10 = ((byte[])object).length); ++i10) {
            n10 = object[i10] & 0xFF;
            int n11 = i10 * 2;
            char[] cArray2 = c;
            int n12 = n10 >>> 4;
            cArray[n11] = n12 = cArray2[n12];
            n10 &= 0xF;
            cArray[++n11] = n10 = cArray2[n10];
        }
        object = new String;
        object(cArray);
        return object;
    }

    public static Queue f(int n10) {
        ArrayDeque arrayDeque = new ArrayDeque(n10);
        return arrayDeque;
    }

    public static int g(int n10, int n11, Bitmap.Config config) {
        n10 *= n11;
        n11 = m.i(config);
        return n10 * n11;
    }

    public static int h(Bitmap object) {
        int n10 = object.isRecycled();
        if (n10 == 0) {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 19;
            if (n10 >= n11) {
                try {
                    return object.getAllocationByteCount();
                }
                catch (NullPointerException nullPointerException) {}
            }
            n10 = object.getHeight();
            int n12 = object.getRowBytes();
            return n10 * n12;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot obtain size for recycled Bitmap: ");
        stringBuilder.append(object);
        stringBuilder.append("[");
        int n13 = object.getWidth();
        stringBuilder.append(n13);
        stringBuilder.append("x");
        n13 = object.getHeight();
        stringBuilder.append(n13);
        stringBuilder.append("] ");
        object = object.getConfig();
        stringBuilder.append(object);
        object = stringBuilder.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    private static int i(Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int[] nArray = m$a.a;
        int n10 = config.ordinal();
        n10 = nArray[n10];
        int n11 = 4;
        int n12 = 2;
        int n13 = 1;
        if (n10 != n13) {
            if (n10 != n12 && n10 != (n13 = 3)) {
                if (n10 == n11) {
                    n11 = 8;
                }
            } else {
                n11 = n12;
            }
        } else {
            n11 = n13;
        }
        return n11;
    }

    public static int j(Bitmap bitmap) {
        return m.h(bitmap);
    }

    public static List k(Collection object) {
        int n10 = object.size();
        ArrayList arrayList = new ArrayList(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object e10 = object.next();
            if (e10 == null) continue;
            arrayList.add(e10);
        }
        return arrayList;
    }

    public static int l(float f10) {
        return m.m(f10, 17);
    }

    public static int m(float f10, int n10) {
        return m.o(Float.floatToIntBits(f10), n10);
    }

    public static int n(int n10) {
        return m.o(n10, 17);
    }

    public static int o(int n10, int n11) {
        return n11 * 31 + n10;
    }

    public static int p(Object object, int n10) {
        int n11;
        if (object == null) {
            n11 = 0;
            object = null;
        } else {
            n11 = object.hashCode();
        }
        return m.o(n11, n10);
    }

    public static int q(boolean bl2) {
        return m.r(bl2, 17);
    }

    public static int r(boolean bl2, int n10) {
        return m.o((int)(bl2 ? 1 : 0), n10);
    }

    public static boolean s() {
        return m.t() ^ true;
    }

    public static boolean t() {
        boolean bl2;
        Looper looper;
        Looper looper2 = Looper.myLooper();
        if (looper2 == (looper = Looper.getMainLooper())) {
            bl2 = true;
        } else {
            bl2 = false;
            looper2 = null;
        }
        return bl2;
    }

    private static boolean u(int n10) {
        int n11;
        n10 = n10 <= 0 && n10 != (n11 = -1 << -1) ? 0 : 1;
        return n10 != 0;
    }

    public static boolean v(int n10, int n11) {
        n10 = (n10 = (int)(m.u(n10) ? 1 : 0)) != 0 && (n10 = (int)(m.u(n11) ? 1 : 0)) != 0 ? 1 : 0;
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String w(byte[] object) {
        char[] cArray = d;
        synchronized (cArray) {
            return m.e(object, cArray);
        }
    }
}

