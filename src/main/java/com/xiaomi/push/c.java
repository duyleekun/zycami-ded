/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.a;
import com.xiaomi.push.c$a;
import com.xiaomi.push.e;
import com.xiaomi.push.f;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class c {
    private final int a;
    private final OutputStream a;
    private final byte[] a;
    private int b;

    private c(OutputStream outputStream, byte[] byArray) {
        int n10;
        this.a = outputStream;
        this.a = byArray;
        this.b = 0;
        this.a = n10 = byArray.length;
    }

    private c(byte[] byArray, int n10, int n11) {
        this.a = null;
        this.a = byArray;
        this.b = n10;
        this.a = n10 += n11;
    }

    public static int a(int n10) {
        if (n10 >= 0) {
            return c.d(n10);
        }
        return 10;
    }

    public static int a(int n10, int n11) {
        n10 = c.c(n10);
        n11 = c.a(n11);
        return n10 + n11;
    }

    public static int a(int n10, long l10) {
        n10 = c.c(n10);
        int n11 = c.a(l10);
        return n10 + n11;
    }

    public static int a(int n10, a a10) {
        n10 = c.c(n10);
        int n11 = c.a(a10);
        return n10 + n11;
    }

    public static int a(int n10, e e10) {
        n10 = c.c(n10);
        int n11 = c.a(e10);
        return n10 + n11;
    }

    public static int a(int n10, String string2) {
        n10 = c.c(n10);
        int n11 = c.a(string2);
        return n10 + n11;
    }

    public static int a(int n10, boolean bl2) {
        n10 = c.c(n10);
        int n11 = c.a(bl2);
        return n10 + n11;
    }

    public static int a(long l10) {
        return c.c(l10);
    }

    public static int a(a a10) {
        int n10 = c.d(a10.a());
        int n11 = a10.a();
        return n10 + n11;
    }

    public static int a(e e10) {
        int n10 = e10.b();
        return c.d(n10) + n10;
    }

    public static int a(String object) {
        String string2 = "UTF-8";
        try {
            object = ((String)object).getBytes(string2);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = new RuntimeException("UTF-8 not supported.");
            throw object;
        }
        int n10 = ((Object)object).length;
        n10 = c.d(n10);
        int n11 = ((Object)object).length;
        return n10 + n11;
    }

    public static int a(boolean bl2) {
        return 1;
    }

    public static c a(OutputStream outputStream) {
        return c.a(outputStream, 4096);
    }

    public static c a(OutputStream outputStream, int n10) {
        byte[] byArray = new byte[n10];
        c c10 = new c(outputStream, byArray);
        return c10;
    }

    public static c a(byte[] byArray, int n10, int n11) {
        c c10 = new c(byArray, n10, n11);
        return c10;
    }

    public static int b(int n10) {
        return c.d(n10);
    }

    public static int b(int n10, int n11) {
        n10 = c.c(n10);
        n11 = c.b(n11);
        return n10 + n11;
    }

    public static int b(int n10, long l10) {
        n10 = c.c(n10);
        int n11 = c.b(l10);
        return n10 + n11;
    }

    public static int b(long l10) {
        return c.c(l10);
    }

    public static int c(int n10) {
        return c.d(f.a(n10, 0));
    }

    public static int c(long l10) {
        long l11 = (long)-128 & l10;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            return 1;
        }
        l11 = 0xFFFFFFFFFFFFC000L & l10;
        long l14 = l11 - l12;
        object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == false) {
            return 2;
        }
        l11 = 0xFFE00000L & l10;
        long l15 = l11 - l12;
        object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object == false) {
            return 3;
        }
        l11 = 0xF0000000L & l10;
        long l16 = l11 - l12;
        object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object == false) {
            return 4;
        }
        l11 = 0xFFFFFFF800000000L & l10;
        long l17 = l11 - l12;
        object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object == false) {
            return 5;
        }
        l11 = 0xFFFFFC0000000000L & l10;
        long l18 = l11 - l12;
        object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
        if (object == false) {
            return 6;
        }
        l11 = 0xFFFE000000000000L & l10;
        long l19 = l11 - l12;
        object = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
        if (object == false) {
            return 7;
        }
        l11 = 0xFF00000000000000L & l10;
        long l20 = l11 - l12;
        object = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
        if (object == false) {
            return 8;
        }
        l11 = Long.MIN_VALUE;
        long l21 = (l10 &= l11) - l12;
        Object object2 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
        if (object2 == false) {
            return 9;
        }
        return 10;
    }

    private void c() {
        Object object = this.a;
        if (object != null) {
            byte[] byArray = this.a;
            int n10 = this.b;
            ((OutputStream)object).write(byArray, 0, n10);
            this.b = 0;
            return;
        }
        object = new c$a();
        throw object;
    }

    public static int d(int n10) {
        int n11 = n10 & 0xFFFFFF80;
        if (n11 == 0) {
            return 1;
        }
        n11 = n10 & 0xFFFFC000;
        if (n11 == 0) {
            return 2;
        }
        n11 = 0xFFE00000 & n10;
        if (n11 == 0) {
            return 3;
        }
        n11 = -268435456;
        if ((n10 &= n11) == 0) {
            return 4;
        }
        return 5;
    }

    public int a() {
        Object object = this.a;
        if (object == null) {
            int n10 = this.a;
            int n11 = this.b;
            return n10 - n11;
        }
        object = new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
        throw object;
    }

    public void a() {
        OutputStream outputStream = this.a;
        if (outputStream != null) {
            this.c();
        }
    }

    public void a(byte by2) {
        int n10;
        int n11 = this.b;
        int n12 = this.a;
        if (n11 == n12) {
            this.c();
        }
        byte[] byArray = this.a;
        n12 = this.b;
        this.b = n10 = n12 + 1;
        byArray[n12] = by2;
    }

    public void a(int n10) {
        if (n10 >= 0) {
            this.d(n10);
        } else {
            long l10 = n10;
            this.c(l10);
        }
    }

    public void a(int n10, int n11) {
        this.c(n10, 0);
        this.a(n11);
    }

    public void a(int n10, long l10) {
        this.c(n10, 0);
        this.a(l10);
    }

    public void a(int n10, a a10) {
        this.c(n10, 2);
        this.a(a10);
    }

    public void a(int n10, e e10) {
        this.c(n10, 2);
        this.a(e10);
    }

    public void a(int n10, String string2) {
        this.c(n10, 2);
        this.a(string2);
    }

    public void a(int n10, boolean bl2) {
        this.c(n10, 0);
        this.a(bl2);
    }

    public void a(long l10) {
        this.c(l10);
    }

    public void a(a object) {
        object = ((a)object).a();
        int n10 = ((Object)object).length;
        this.d(n10);
        this.a((byte[])object);
    }

    public void a(e e10) {
        int n10 = e10.a();
        this.d(n10);
        e10.a(this);
    }

    public void a(String object) {
        object = ((String)object).getBytes("UTF-8");
        int n10 = ((Object)object).length;
        this.d(n10);
        this.a((byte[])object);
    }

    public void a(boolean bl2) {
        this.c((int)(bl2 ? 1 : 0));
    }

    public void a(byte[] byArray) {
        int n10 = byArray.length;
        this.a(byArray, 0, n10);
    }

    public void a(byte[] byArray, int n10, int n11) {
        int n12 = this.a;
        int n13 = this.b;
        int n14 = n12 - n13;
        if (n14 >= n11) {
            int n15;
            byte[] byArray2 = this.a;
            System.arraycopy(byArray, n10, byArray2, n13, n11);
            this.b = n15 = this.b + n11;
        } else {
            byte[] byArray3 = this.a;
            System.arraycopy(byArray, n10, byArray3, n13, n12 -= n13);
            n10 += n12;
            n11 -= n12;
            this.b = n12 = this.a;
            this.c();
            n12 = this.a;
            if (n11 <= n12) {
                byte[] byArray4 = this.a;
                n13 = 0;
                System.arraycopy(byArray, n10, byArray4, 0, n11);
                this.b = n11;
            } else {
                OutputStream outputStream = this.a;
                outputStream.write(byArray, n10, n11);
            }
        }
    }

    public void b() {
        int n10 = this.a();
        if (n10 == 0) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Did not write as much data as expected.");
        throw illegalStateException;
    }

    public void b(int n10) {
        this.d(n10);
    }

    public void b(int n10, int n11) {
        this.c(n10, 0);
        this.b(n11);
    }

    public void b(int n10, long l10) {
        this.c(n10, 0);
        this.b(l10);
    }

    public void b(long l10) {
        this.c(l10);
    }

    public void c(int n10) {
        n10 = (byte)n10;
        this.a((byte)n10);
    }

    public void c(int n10, int n11) {
        n10 = f.a(n10, n11);
        this.d(n10);
    }

    public void c(long l10) {
        while (true) {
            long l11;
            long l12;
            long l13;
            long l14;
            if ((l14 = (l13 = (l12 = (long)-128 & l10) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == false) {
                int n10 = (int)l10;
                this.c(n10);
                return;
            }
            l14 = (int)l10 & 0x7F | 0x80;
            this.c((int)l14);
            l14 = 7;
            l10 >>>= l14;
        }
    }

    public void d(int n10) {
        while (true) {
            int n11;
            if ((n11 = n10 & 0xFFFFFF80) == 0) {
                this.c(n10);
                return;
            }
            n11 = n10 & 0x7F | 0x80;
            this.c(n11);
            n10 >>>= 7;
        }
    }
}

