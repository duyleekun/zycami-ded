/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package d.m.a.e;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import d.m.a.e.a$a;
import d.m.a.e.b;
import d.m.a.e.c;
import d.m.a.e.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class a {
    private static final String r = "a";
    public static final int s = 0;
    public static final int t = 1;
    public static final int u = 2;
    public static final int v = 3;
    public static final int w;
    private static final Bitmap.Config x;
    private int[] a;
    private final int[] b;
    private ByteBuffer c;
    private final byte[] d;
    private d e;
    private short[] f;
    private byte[] g;
    private byte[] h;
    private byte[] i;
    private int[] j;
    private int k;
    private byte[] l;
    private c m;
    private a$a n;
    private Bitmap o;
    private boolean p;
    private int q;

    static {
        x = Bitmap.Config.ARGB_8888;
    }

    public a(a$a object) {
        int n10 = 256;
        int[] nArray = new int[n10];
        this.b = nArray;
        byte[] byArray = new byte[n10];
        this.d = byArray;
        this.n = object;
        this.m = object = new c();
    }

    /*
     * Enabled aggressive block sorting
     */
    private Bitmap a(b b10, b b11) {
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        c c10;
        int n15;
        int n16;
        int[] nArray;
        int n17;
        int n18;
        float f10;
        int n19;
        int n20;
        int n21;
        int[] nArray2;
        int n22;
        int n23;
        b b12;
        a a10;
        block23: {
            block18: {
                b b13;
                block22: {
                    Bitmap bitmap;
                    block19: {
                        block21: {
                            block20: {
                                a10 = this;
                                b12 = b10;
                                b13 = b11;
                                c c11 = this.m;
                                n23 = c11.f;
                                n22 = c11.g;
                                nArray2 = this.j;
                                n21 = 0;
                                if (b11 == null) {
                                    Arrays.fill(nArray2, 0);
                                }
                                n20 = 3;
                                n19 = 2;
                                f10 = 2.8E-45f;
                                if (b13 == null || (n18 = b13.g) <= 0) break block18;
                                if (n18 != n19) break block19;
                                n18 = (int)(b12.f ? 1 : 0);
                                if (n18 != 0) break block20;
                                c c12 = a10.m;
                                n17 = c12.l;
                                nArray = b12.k;
                                if (nArray == null || (n18 = c12.j) != (n16 = b12.h)) break block21;
                            }
                            n17 = 0;
                            Object var19_23 = null;
                        }
                        n18 = b13.b * n23;
                        n16 = b13.a;
                        n18 += n16;
                        n16 = b13.d * n23 + n18;
                        break block22;
                    }
                    if (n18 != n20 || (bitmap = a10.o) == null) break block18;
                    n16 = 0;
                    nArray = null;
                    n15 = 0;
                    c10 = null;
                    n14 = 0;
                    int[] nArray3 = nArray2;
                    n13 = n23;
                    n12 = n23;
                    n11 = n19;
                    n19 = n22;
                    bitmap.getPixels(nArray2, 0, n23, 0, 0, n23, n22);
                    break block23;
                }
                while (n18 < n16) {
                    n13 = b13.c + n18;
                    for (n15 = n18; n15 < n13; ++n15) {
                        nArray2[n15] = n17;
                    }
                    n18 += n23;
                }
            }
            n11 = n19;
        }
        this.d(b10);
        n18 = 8;
        n19 = 1;
        f10 = Float.MIN_VALUE;
        n16 = n19;
        n17 = 0;
        Object var19_26 = null;
        while (n21 < (n13 = b12.d)) {
            block27: {
                block24: {
                    block25: {
                        block26: {
                            n15 = b12.e;
                            if (n15 == 0) break block24;
                            n15 = 4;
                            if (n17 < n13) break block25;
                            if (++n16 == n11) break block26;
                            if (n16 != n20) {
                                if (n16 == n15) {
                                    n18 = n11;
                                    n17 = n19;
                                }
                                break block25;
                            } else {
                                n17 = n11;
                                n18 = n15;
                            }
                            break block25;
                        }
                        n17 = n15;
                    }
                    n13 = n17 + n18;
                    break block27;
                }
                n13 = n17;
                n17 = n21;
            }
            n15 = b12.b;
            c10 = a10.m;
            n14 = c10.g;
            if ((n17 += n15) < n14) {
                n15 = c10.f;
                n20 = (n17 *= n15) + n15;
                n12 = b12.c;
                if (n20 < (n11 = (n14 = b12.a + n17) + n12)) {
                    n11 = n17 + n15;
                }
                n12 *= n21;
                while (n14 < n11) {
                    byte[] byArray = a10.i;
                    n15 = n12 + 1;
                    n17 = byArray[n12] & 0xFF;
                    int[] nArray4 = a10.a;
                    if ((n17 = nArray4[n17]) != 0) {
                        nArray2[n14] = n17;
                    }
                    ++n14;
                    n12 = n15;
                }
            }
            ++n21;
            n17 = n13;
            n11 = 2;
            n20 = 3;
        }
        n11 = (int)(a10.p ? 1 : 0);
        if (n11 != 0 && ((n10 = b12.g) == 0 || n10 == n19)) {
            b12 = a10.o;
            if (b12 == null) {
                b12 = this.i();
                a10.o = b12;
            }
            Bitmap bitmap = a10.o;
            n16 = 0;
            nArray = null;
            n15 = 0;
            c10 = null;
            n14 = 0;
            int[] nArray5 = nArray2;
            n13 = n23;
            n12 = n23;
            n19 = n22;
            bitmap.setPixels(nArray2, 0, n23, 0, 0, n23, n22);
        }
        b b14 = b12 = this.i();
        int[] nArray6 = nArray2;
        n13 = n23;
        n12 = n23;
        n19 = n22;
        b12.setPixels(nArray2, 0, n23, 0, 0, n23, n22);
        return b12;
    }

    private d b() {
        d d10 = this.e;
        if (d10 == null) {
            this.e = d10 = new d();
        }
        return this.e;
    }

    private static void c(Bitmap bitmap) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 12;
        if (n10 >= n11) {
            n10 = 1;
            bitmap.setHasAlpha(n10 != 0);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private void d(b b10) {
        int n10;
        byte[] byArray;
        int n11;
        void var7_9;
        int n12;
        int n13;
        int n14;
        a a10 = this;
        Object object = b10;
        if (b10 != null) {
            ByteBuffer byteBuffer = this.c;
            n14 = b10.j;
            byteBuffer.position(n14);
        }
        if (object == null) {
            object = a10.m;
            n13 = ((c)object).f;
            int n15 = ((c)object).g;
        } else {
            n13 = ((b)object).c;
            int n16 = ((b)object).d;
        }
        object = a10.i;
        if (object == null || (n12 = ((Object)object).length) < (n13 *= var7_9)) {
            object = new byte[n13];
            a10.i = (byte[])object;
        }
        object = a10.f;
        n14 = 4096;
        if (object == null) {
            object = new short[n14];
            a10.f = (short[])object;
        }
        if ((object = (Object)a10.g) == null) {
            object = new byte[n14];
            a10.g = (byte[])object;
        }
        if ((object = (Object)a10.h) == null) {
            int n17 = 4097;
            object = new byte[n17];
            a10.h = (byte[])object;
        }
        int n18 = this.f();
        int n19 = 1;
        int n20 = n19 << n18;
        int n21 = n20 + 1;
        int n22 = n20 + 2;
        int n23 = n18 + n19;
        int n24 = (n19 << n23) - n19;
        int n25 = 0;
        for (n11 = 0; n11 < n20; ++n11) {
            a10.f[n11] = 0;
            byArray = a10.g;
            byArray[n11] = n10 = (int)n11;
        }
        n11 = -1;
        int n26 = n23;
        int n27 = n22;
        int n28 = n24;
        int n29 = 0;
        byArray = null;
        n10 = 0;
        int n30 = 0;
        int n31 = 0;
        int n32 = 0;
        int n33 = 0;
        int n34 = 0;
        int n35 = 0;
        int n36 = n11;
        while (true) {
            block26: {
                int n37;
                byte[] byArray2;
                int n38;
                block30: {
                    byte[] byArray3;
                    block27: {
                        block28: {
                            block29: {
                                if (n29 >= n13) break block27;
                                n25 = 3;
                                if (n10 != 0) break block28;
                                n10 = this.g();
                                if (n10 > 0) break block29;
                                a10.q = n25;
                                break block27;
                            }
                            n32 = 0;
                        }
                        byArray3 = a10.d;
                        n14 = (byArray3[n32] & 0xFF) << n30;
                        n31 += n14;
                        n30 += 8;
                        n32 += n19;
                        n10 += n11;
                        n14 = n27;
                        n19 = n36;
                        n11 = n26;
                        n38 = n35;
                        break block30;
                    }
                    int n39 = n33;
                    while (true) {
                        void var7_16;
                        if (++var7_16 >= n13) {
                            return;
                        }
                        byArray3 = a10.i;
                        n19 = 0;
                        byArray2 = null;
                        byArray3[var7_16] = 0;
                    }
                }
                while (n30 >= n11) {
                    int n40;
                    Object object2;
                    block38: {
                        block37: {
                            block36: {
                                block32: {
                                    block35: {
                                        block34: {
                                            block33: {
                                                block31: {
                                                    n25 = n31 & n28;
                                                    n31 >>= n11;
                                                    n30 -= n11;
                                                    if (n25 != n20) break block31;
                                                    n11 = object2;
                                                    n14 = n22;
                                                    n28 = n24;
                                                    n19 = -1;
                                                    break block32;
                                                }
                                                n35 = object2;
                                                object2 = 3;
                                                if (n25 <= n14) break block33;
                                                a10.q = object2;
                                                break block34;
                                            }
                                            if (n25 != n21) break block35;
                                        }
                                        n27 = n14;
                                        n36 = n19;
                                        n26 = n11;
                                        object2 = n35;
                                        n35 = n38;
                                        break block26;
                                    }
                                    object2 = -1;
                                    if (n19 != object2) break block36;
                                    byArray2 = a10.h;
                                    n36 = n34 + 1;
                                    object = a10.g;
                                    byArray2[n34] = object2 = (Object)object[n25];
                                    n19 = n25;
                                    n38 = n25;
                                    n34 = n36;
                                    object2 = n35;
                                }
                                n25 = 3;
                                continue;
                            }
                            if (n25 >= n14) {
                                object = a10.h;
                                n36 = n34 + 1;
                                n37 = n21;
                                n21 = n38;
                                n21 = (byte)n38;
                                object[n34] = n21;
                                object2 = n19;
                                n34 = n36;
                            } else {
                                n37 = n21;
                                object2 = n25;
                            }
                            while (object2 >= n20) {
                                byte[] byArray4 = a10.h;
                                n36 = n34 + 1;
                                n38 = n20;
                                byArray4[n34] = n20 = a10.g[object2];
                                short[] sArray = a10.f;
                                object2 = sArray[object2];
                                n34 = n36;
                                n20 = n38;
                            }
                            n38 = n20;
                            byte[] byArray5 = a10.g;
                            object2 = byArray5[object2] & 0xFF;
                            byte[] byArray6 = a10.h;
                            n36 = n34 + 1;
                            n40 = n22;
                            byArray6[n34] = n22 = (int)((byte)object2);
                            n21 = 4096;
                            if (n14 >= n21) break block37;
                            short[] sArray = a10.f;
                            sArray[n14] = n19 = (int)((short)n19);
                            byArray5[n14] = n22;
                            if ((n19 = ++n14 & n28) == 0) {
                                n19 = 4096;
                                if (n14 < n19) {
                                    ++n11;
                                    n28 += n14;
                                }
                                break block38;
                            } else {
                                n19 = 4096;
                            }
                            break block38;
                        }
                        n19 = n21;
                    }
                    n34 = n36;
                    while (n34 > 0) {
                        byte[] byArray7 = a10.i;
                        n21 = n33 + 1;
                        byte[] byArray8 = a10.h;
                        byArray7[n33] = n22 = byArray8[n34 += -1];
                        ++n29;
                        n33 = n21;
                    }
                    n19 = n25;
                    n20 = n38;
                    n21 = n37;
                    n22 = n40;
                    n25 = 3;
                    n38 = object2;
                    object2 = n35;
                }
                n37 = n21;
                n21 = n38;
                n27 = n14;
                n36 = n19;
                n35 = n38;
                n26 = n11;
                n21 = n37;
            }
            n14 = 4096;
            n19 = 1;
            n25 = 0;
            n11 = -1;
        }
    }

    private int f() {
        int n10;
        ByteBuffer byteBuffer = this.c;
        try {
            n10 = byteBuffer.get() & 0xFF;
        }
        catch (Exception exception) {
            this.q = 1;
            n10 = 0;
            byteBuffer = null;
        }
        return n10;
    }

    private int g() {
        int n10;
        int n11 = this.f();
        if (n11 > 0) {
            int n12;
            for (n10 = 0; n10 < n11; n10 += n12) {
                n12 = n11 - n10;
                Object object = this.c;
                byte[] byArray = this.d;
                try {
                    ((ByteBuffer)object).get(byArray, n10, n12);
                    continue;
                }
                catch (Exception exception) {
                    String string2 = r;
                    object = "Error Reading Block";
                    Log.w((String)string2, (String)object, (Throwable)exception);
                    this.q = n11 = 1;
                    break;
                }
            }
        }
        return n10;
    }

    private Bitmap i() {
        Object object = this.n;
        c c10 = this.m;
        int n10 = c10.f;
        int n11 = c10.g;
        Bitmap.Config config = x;
        if ((object = object.b(n10, n11, config)) == null) {
            object = this.m;
            n11 = ((c)object).f;
            int n12 = ((c)object).g;
            object = Bitmap.createBitmap((int)n11, (int)n12, (Bitmap.Config)config);
        }
        d.m.a.e.a.c((Bitmap)object);
        return object;
    }

    public void e() {
        int n10 = this.k + 1;
        int n11 = this.m.c;
        this.k = n10 %= n11;
    }

    public void h() {
        this.m = null;
        this.l = null;
        this.i = null;
        this.j = null;
        Bitmap bitmap = this.o;
        if (bitmap != null) {
            a$a a$a = this.n;
            a$a.a(bitmap);
        }
        this.o = null;
        this.c = null;
    }

    public int j() {
        return this.k;
    }

    public byte[] k() {
        return this.l;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int l(int n10) {
        if (n10 < 0) return -1;
        Object object = this.m;
        int n11 = ((c)object).c;
        if (n10 >= n11) return -1;
        object = ((c)object).e;
        b b10 = (b)object.get(n10);
        return b10.i;
    }

    public int m() {
        return this.m.c;
    }

    public int n() {
        return this.m.g;
    }

    public int o() {
        c c10 = this.m;
        int n10 = c10.m;
        int n11 = -1;
        if (n10 == n11) {
            n10 = 1;
        }
        return n10;
    }

    public int p() {
        return this.m.m;
    }

    public int q() {
        c c10 = this.m;
        int n10 = c10.c;
        if (n10 > 0 && (n10 = this.k) >= 0) {
            return this.l(n10);
        }
        return -1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Bitmap r() {
        synchronized (this) {
            int n10;
            Object object;
            boolean bl2;
            Object object2 = this.m;
            int n11 = ((c)object2).c;
            int n12 = 3;
            int n13 = 1;
            if (n11 <= 0 || (n11 = this.k) < 0) {
                object2 = r;
                bl2 = Log.isLoggable((String)object2, (int)n12);
                if (bl2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    object = "unable to decode frame, frameCount=";
                    stringBuilder.append((String)object);
                    object = this.m;
                    n10 = ((c)object).c;
                    stringBuilder.append(n10);
                    object = " framePointer=";
                    stringBuilder.append((String)object);
                    n10 = this.k;
                    stringBuilder.append(n10);
                    String string2 = stringBuilder.toString();
                    Log.d((String)object2, (String)string2);
                }
                this.q = n13;
            }
            n11 = this.q;
            bl2 = false;
            Object var6_8 = null;
            if (n11 != n13 && n11 != (n10 = 2)) {
                b b10;
                Object object3;
                n11 = 0;
                object2 = null;
                this.q = 0;
                object = this.m;
                object = ((c)object).e;
                int n14 = this.k;
                object = object.get(n14);
                object = (b)object;
                n14 = this.k - n13;
                if (n14 >= 0) {
                    object3 = this.m;
                    object3 = ((c)object3).e;
                    b10 = (b)object3.get(n14);
                    b10 = b10;
                } else {
                    n14 = 0;
                    b10 = null;
                }
                object3 = ((b)object).k;
                if (object3 == null) {
                    object3 = this.m;
                    object3 = ((c)object3).a;
                }
                this.a = (int[])object3;
                if (object3 == null) {
                    object2 = r;
                    if ((n12 = (int)(Log.isLoggable((String)object2, (int)n12) ? 1 : 0)) != 0) {
                        String string3 = "No Valid Color Table";
                        Log.d((String)object2, (String)string3);
                    }
                    this.q = n13;
                    return null;
                }
                n12 = (int)(((b)object).f ? 1 : 0);
                if (n12 == 0) return this.a((b)object, b10);
                int[] nArray = this.b;
                n13 = ((Object)object3).length;
                System.arraycopy(object3, 0, nArray, 0, n13);
                int[] nArray2 = this.b;
                this.a = nArray2;
                n13 = ((b)object).h;
                nArray2[n13] = 0;
                return this.a((b)object, b10);
            }
            object2 = r;
            if ((n12 = (int)(Log.isLoggable((String)object2, (int)n12) ? 1 : 0)) == 0) return null;
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "Unable to decode frame, status=";
            stringBuilder.append(string4);
            n13 = this.q;
            stringBuilder.append(n13);
            String string5 = stringBuilder.toString();
            Log.d((String)object2, (String)string5);
            return null;
        }
    }

    public int s() {
        return this.q;
    }

    public int t() {
        c c10 = this.m;
        int n10 = c10.m;
        int n11 = 1;
        int n12 = -1;
        if (n10 == n12) {
            return n11;
        }
        if (n10 == 0) {
            return 0;
        }
        return n10 + n11;
    }

    public int u() {
        return this.m.f;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int v(InputStream inputStream, int n10) {
        String string2;
        Object object;
        if (inputStream != null) {
            int n11 = 16384;
            n10 = n10 > 0 ? (n10 += 4096) : n11;
            try {
                int n12;
                int n13;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n10);
                object = new byte[n11];
                while ((n13 = inputStream.read((byte[])object, 0, n11)) != (n12 = -1)) {
                    byteArrayOutputStream.write((byte[])object, 0, n13);
                }
                byteArrayOutputStream.flush();
                object = byteArrayOutputStream.toByteArray();
                this.w((byte[])object);
            }
            catch (IOException iOException) {
                string2 = r;
                String string3 = "Error reading data from stream";
                Log.w((String)string2, (String)string3, (Throwable)iOException);
            }
        } else {
            this.q = n10 = 2;
        }
        if (inputStream == null) return this.q;
        try {
            inputStream.close();
            return this.q;
        }
        catch (IOException iOException) {
            object = r;
            string2 = "Error closing stream";
            Log.w((String)object, (String)string2, (Throwable)iOException);
        }
        return this.q;
    }

    public int w(byte[] object) {
        this.l = object;
        Object object2 = this.b().r((byte[])object).q();
        this.m = object2;
        if (object != null) {
            object = ByteBuffer.wrap((byte[])object);
            this.c = object;
            ((ByteBuffer)object).rewind();
            object = this.c;
            object2 = ByteOrder.LITTLE_ENDIAN;
            ((ByteBuffer)object).order((ByteOrder)object2);
            object = this.m;
            int n10 = ((c)object).f;
            int n11 = ((c)object).g;
            int n12 = n10 * n11;
            byte[] byArray = new byte[n12];
            this.i = byArray;
            object2 = new int[n10 * n11];
            this.j = (int[])object2;
            n10 = 0;
            object2 = null;
            this.p = false;
            object = ((c)object).e.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                boolean bl2;
                object2 = (b)object.next();
                n10 = ((b)object2).g;
                n11 = 3;
                if (n10 != n11) continue;
                this.p = bl2 = true;
                break;
            }
        }
        return this.q;
    }

    public void x() {
        this.k = -1;
    }

    public void y(c object, byte[] object2) {
        int n10;
        int n11;
        this.m = object;
        this.l = object2;
        int n12 = 0;
        Object object3 = null;
        this.q = 0;
        this.k = n11 = -1;
        object2 = ByteBuffer.wrap((byte[])object2);
        this.c = object2;
        ((ByteBuffer)object2).rewind();
        object2 = this.c;
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        ((ByteBuffer)object2).order(byteOrder);
        this.p = false;
        object2 = ((c)object).e.iterator();
        while ((n12 = object2.hasNext()) != 0) {
            object3 = (b)object2.next();
            n12 = ((b)object3).g;
            n11 = 3;
            if (n12 != n11) continue;
            n10 = 1;
            this.p = n10;
            break;
        }
        n10 = ((c)object).f;
        int n13 = ((c)object).g;
        object3 = new byte[n10 * n13];
        this.i = (byte[])object3;
        object = new int[n10 * n13];
        this.j = (int[])object;
    }
}

