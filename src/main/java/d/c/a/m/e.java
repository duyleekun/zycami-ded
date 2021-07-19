/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.util.Log
 */
package d.c.a.m;

import android.graphics.Bitmap;
import android.util.Log;
import d.c.a.m.a;
import d.c.a.m.a$a;
import d.c.a.m.b;
import d.c.a.m.c;
import d.c.a.m.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class e
implements a {
    private static final String A = "e";
    private static final int B = 4096;
    private static final int C = 255;
    private static final int D = 255;
    private static final int E = 4;
    private static final int F = 255;
    private static final int G;
    private int[] f;
    private final int[] g;
    private final a$a h;
    private ByteBuffer i;
    private byte[] j;
    private d k;
    private short[] l;
    private byte[] m;
    private byte[] n;
    private byte[] o;
    private int[] p;
    private int q;
    private c r;
    private Bitmap s;
    private boolean t;
    private int u;
    private int v;
    private int w;
    private int x;
    private Boolean y;
    private Bitmap.Config z;

    public e(a$a object) {
        Object object2 = new int[256];
        this.g = object2;
        object2 = Bitmap.Config.ARGB_8888;
        this.z = (Bitmap.Config)object2;
        this.h = object;
        this.r = object = new c();
    }

    public e(a$a a$a, c c10, ByteBuffer byteBuffer) {
        this(a$a, c10, byteBuffer, 1);
    }

    public e(a$a a$a, c c10, ByteBuffer byteBuffer, int n10) {
        this(a$a);
        this.m(c10, byteBuffer, n10);
    }

    private int p(int n10, int n11, int n12) {
        byte[] byArray;
        Object[] objectArray;
        int n13;
        int n14;
        int n15;
        int n16 = 0;
        int n17 = 0;
        int n18 = 0;
        int n19 = 0;
        int n20 = 0;
        for (n15 = n10; n15 < (n14 = this.v + n10) && n15 < (n13 = (objectArray = this.o).length) && n15 < n11; ++n15) {
            n14 = objectArray[n15] & 0xFF;
            int[] nArray = this.f;
            if ((n14 = nArray[n14]) == 0) continue;
            n13 = n14 >> 24 & 0xFF;
            n16 += n13;
            n13 = n14 >> 16 & 0xFF;
            n17 += n13;
            n13 = n14 >> 8 & 0xFF;
            n18 += n13;
            n19 += (n14 &= 0xFF);
            ++n20;
        }
        n10 += n12;
        for (n12 = n10; n12 < (n15 = this.v + n10) && n12 < (n14 = (byArray = this.o).length) && n12 < n11; ++n12) {
            n15 = byArray[n12] & 0xFF;
            objectArray = this.f;
            if ((n15 = objectArray[n15]) == 0) continue;
            n14 = n15 >> 24 & 0xFF;
            n16 += n14;
            n14 = n15 >> 16 & 0xFF;
            n17 += n14;
            n14 = n15 >> 8 & 0xFF;
            n18 += n14;
            n19 += (n15 &= 0xFF);
            ++n20;
        }
        if (n20 == 0) {
            return 0;
        }
        n10 = n16 / n20 << 24;
        n11 = n17 / n20 << 16;
        n10 |= n11;
        n11 = n18 / n20 << 8;
        return (n10 |= n11) | (n19 /= n20);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void q(b b10) {
        e e10 = this;
        Object object = b10;
        Boolean bl2 = Boolean.TRUE;
        int[] nArray = this.p;
        int n10 = b10.d;
        int n11 = this.v;
        n10 /= n11;
        int n12 = b10.b / n11;
        int n13 = b10.c / n11;
        int n14 = b10.a / n11;
        int n15 = this.q;
        n15 = n15 == 0 ? 1 : 0;
        int n16 = e10.x;
        int n17 = e10.w;
        byte[] byArray = e10.o;
        int[] nArray2 = e10.f;
        Boolean bl3 = e10.y;
        int n18 = 8;
        Boolean bl4 = bl2;
        int n19 = 0;
        bl2 = null;
        int n20 = 0;
        int n21 = 1;
        while (true) {
            int n22;
            int n23;
            int n24;
            int n25;
            Boolean bl5;
            block27: {
                int n26;
                block24: {
                    block26: {
                        block25: {
                            block18: {
                                block23: {
                                    block22: {
                                        block19: {
                                            block17: {
                                                block20: {
                                                    block21: {
                                                        if (n20 >= n10) break block18;
                                                        bl5 = bl3;
                                                        n26 = ((b)object).e;
                                                        if (n26 == 0) break block19;
                                                        n26 = 2;
                                                        if (n19 < n10) break block20;
                                                        n25 = n19;
                                                        n19 = n21 + 1;
                                                        if (n19 == n26) break block21;
                                                        n26 = 3;
                                                        if (n19 != n26) {
                                                            n26 = 4;
                                                            if (n19 != n26) {
                                                                n21 = n19;
                                                                n19 = n25;
                                                                break block17;
                                                            } else {
                                                                n21 = n19;
                                                                n19 = 1;
                                                                n18 = 2;
                                                            }
                                                            break block17;
                                                        } else {
                                                            n26 = 4;
                                                            n21 = n19;
                                                            n18 = n26;
                                                            n19 = 2;
                                                        }
                                                        break block17;
                                                    }
                                                    n26 = 4;
                                                    n21 = n19;
                                                    n19 = n26;
                                                    break block17;
                                                }
                                                n25 = n19;
                                            }
                                            n25 = n26 = n19 + n18;
                                            break block22;
                                        }
                                        n25 = n19;
                                        n19 = n20;
                                    }
                                    n26 = 1;
                                    n24 = n11 == n26 ? n26 : 0;
                                    if ((n19 += n12) >= n17) break block23;
                                    n19 *= n16;
                                    if ((n19 += n16) < (n26 = (n23 = n19 + n14) + n13)) {
                                        n26 = n19;
                                    }
                                    n19 = n20 * n11;
                                    n22 = n10;
                                    n10 = ((b)object).c;
                                    n19 *= n10;
                                    if (n24 == 0) break block24;
                                    break block25;
                                }
                                n22 = n10;
                                break block26;
                            }
                            bl5 = bl3;
                            object = e10.y;
                            if (object == null) {
                                if (bl3 == null) {
                                    n26 = 0;
                                    bl3 = null;
                                } else {
                                    n26 = (int)(bl3.booleanValue() ? 1 : 0);
                                }
                                e10.y = object = Boolean.valueOf(n26 != 0);
                            }
                            return;
                        }
                        for (n10 = n23; n10 < n26; n19 += n11, ++n10) {
                            n24 = n12;
                            n12 = byArray[n19] & 0xFF;
                            if ((n12 = nArray2[n12]) != 0) {
                                nArray[n10] = n12;
                            } else if (n15 != 0 && bl5 == null) {
                                bl5 = bl4;
                            }
                            n12 = n24;
                        }
                    }
                    n24 = n12;
                    n23 = n13;
                    break block27;
                }
                n24 = n12;
                n10 = (n26 - n23) * n11 + n19;
                n12 = n23;
                while (true) {
                    n23 = n13;
                    if (n12 >= n26) break;
                    n13 = ((b)object).c;
                    if ((n13 = e10.p(n19, n10, n13)) != 0) {
                        nArray[n12] = n13;
                    } else if (n15 != 0 && bl5 == null) {
                        bl5 = bl4;
                    }
                    n19 += n11;
                    ++n12;
                    n13 = n23;
                }
            }
            bl3 = bl5;
            ++n20;
            n12 = n24;
            n13 = n23;
            n19 = n25;
            n10 = n22;
        }
    }

    private void r(b b10) {
        int n10;
        int n11;
        e e10 = this;
        Object object = b10;
        int[] nArray = this.p;
        int n12 = b10.d;
        int n13 = b10.b;
        int n14 = b10.c;
        int n15 = b10.a;
        int n16 = this.q;
        n16 = n16 == 0 ? 1 : 0;
        int n17 = e10.x;
        byte[] byArray = e10.o;
        int[] nArray2 = e10.f;
        int n18 = -1;
        for (int i10 = 0; i10 < n12; ++i10) {
            int n19 = (i10 + n13) * n17;
            int n20 = n19 + n17;
            int n21 = n19 + n15;
            n11 = n21 + n14;
            if (n20 < n11) {
                n11 = n20;
            }
            n20 = ((b)object).c * i10;
            for (int i11 = n21; i11 < n11; ++i11) {
                n10 = byArray[n20];
                n21 = n12;
                n12 = n10 & 0xFF;
                if (n12 != n18) {
                    if ((n12 = nArray2[n12]) != 0) {
                        nArray[i11] = n12;
                    } else {
                        n18 = n10;
                    }
                }
                ++n20;
                object = b10;
                n12 = n21;
            }
            n21 = n12;
            object = b10;
        }
        object = e10.y;
        n11 = object != null && (n10 = ((Boolean)object).booleanValue()) != 0 || (object = e10.y) == null && n16 != 0 && n18 != (n10 = -1) ? 1 : 0;
        e10.y = object = Boolean.valueOf(n11 != 0);
    }

    private void s(b b10) {
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        e e10 = this;
        Object object = b10;
        if (b10 != null) {
            ByteBuffer byteBuffer = this.i;
            n14 = b10.j;
            byteBuffer.position(n14);
        }
        if (object == null) {
            object = e10.r;
            n13 = ((c)object).f;
            n12 = ((c)object).g;
        } else {
            n13 = ((b)object).c;
            n12 = ((b)object).d;
        }
        n13 *= n12;
        object = e10.o;
        if (object == null || (n12 = ((Object)object).length) < n13) {
            object = e10.h.c(n13);
            e10.o = (byte[])object;
        }
        object = e10.o;
        short[] sArray = e10.l;
        int n15 = 4096;
        if (sArray == null) {
            e10.l = sArray = new short[n15];
        }
        sArray = e10.l;
        byte[] byArray = e10.m;
        if (byArray == null) {
            e10.m = byArray = new byte[n15];
        }
        byArray = e10.m;
        byte[] byArray2 = e10.n;
        if (byArray2 == null) {
            n11 = 4097;
            e10.n = byArray2 = new byte[n11];
        }
        byArray2 = e10.n;
        int n16 = this.w();
        int n17 = 1;
        int n18 = n17 << n16;
        int n19 = n18 + 1;
        int n20 = n18 + 2;
        int n21 = (n17 << (n16 += n17)) - n17;
        int n22 = 0;
        byte[] byArray3 = null;
        for (int i10 = 0; i10 < n18; ++i10) {
            sArray[i10] = 0;
            byArray[i10] = n10 = (int)((byte)i10);
        }
        byArray3 = e10.j;
        n10 = -1;
        int n23 = n16;
        int n24 = n20;
        int n25 = n21;
        int n26 = 0;
        int n27 = 0;
        int n28 = 0;
        int n29 = 0;
        int n30 = 0;
        int n31 = 0;
        int n32 = 0;
        int n33 = n10;
        block1: while (n22 < n13) {
            if (n26 == 0) {
                n26 = this.v();
                if (n26 <= 0) {
                    e10.u = n14 = 3;
                    break;
                }
                n27 = 0;
            }
            n15 = (byArray3[n27] & 0xFF) << n28;
            n29 += n15;
            ++n27;
            n26 += -1;
            n15 = n28 += 8;
            n17 = n24;
            n10 = n33;
            int n34 = n23;
            n33 = n16;
            n16 = n32;
            while (n15 >= n34) {
                n23 = n20;
                n20 = n29 & n25;
                n29 >>= n34;
                n15 -= n34;
                if (n20 == n18) {
                    n25 = n21;
                    n34 = n33;
                    n17 = n23;
                    n20 = n23;
                    n10 = -1;
                    continue;
                }
                if (n20 == n19) {
                    n28 = n15;
                    n32 = n16;
                    n24 = n17;
                    n16 = n33;
                    n20 = n23;
                    n15 = 4096;
                    n17 = 1;
                    n23 = n34;
                    n33 = n10;
                    n10 = -1;
                    e10 = this;
                    continue block1;
                }
                n32 = n15;
                n15 = -1;
                if (n10 == n15) {
                    n16 = byArray[n20];
                    object[n30] = n16;
                    ++n30;
                    ++n22;
                    n16 = n20;
                    n10 = n20;
                    n20 = n23;
                    n15 = n32;
                    continue;
                }
                if (n20 >= n17) {
                    byArray2[n31] = n16 = (int)((byte)n16);
                    ++n31;
                    n16 = n10;
                } else {
                    n16 = n20;
                }
                while (n16 >= n18) {
                    byArray2[n31] = n24 = byArray[n16];
                    ++n31;
                    n16 = sArray[n16];
                }
                n16 = byArray[n16] & 0xFF;
                n15 = (byte)n16;
                object[n30] = n15;
                while (true) {
                    ++n30;
                    ++n22;
                    if (n31 <= 0) break;
                    byte by2 = byArray2[n31 += -1];
                    object[n30] = by2;
                }
                byte[] byArray4 = byArray2;
                n11 = 4096;
                if (n17 < n11) {
                    sArray[n17] = n10 = (int)((short)n10);
                    byArray[n17] = n15;
                    if ((n15 = ++n17 & n25) == 0 && n17 < n11) {
                        ++n34;
                        n25 += n17;
                    }
                }
                n10 = n20;
                n20 = n23;
                n15 = n32;
                byArray2 = byArray4;
            }
            n32 = n15;
            n23 = n34;
            n24 = n17;
            n28 = n15;
            n15 = 4096;
            n17 = 1;
            e10 = this;
            n32 = n16;
            n16 = n33;
            n33 = n10;
            n10 = -1;
        }
        n22 = n30;
        Arrays.fill((byte[])object, n30, n13, (byte)0);
    }

    private d t() {
        d d10 = this.k;
        if (d10 == null) {
            this.k = d10 = new d();
        }
        return this.k;
    }

    private Bitmap u() {
        boolean bl2;
        Boolean bl3 = this.y;
        bl3 = bl3 != null && !(bl2 = bl3.booleanValue()) ? this.z : Bitmap.Config.ARGB_8888;
        a$a a$a = this.h;
        int n10 = this.x;
        int n11 = this.w;
        bl3 = a$a.b(n10, n11, (Bitmap.Config)bl3);
        bl3.setHasAlpha(true);
        return bl3;
    }

    private int v() {
        int n10 = this.w();
        if (n10 <= 0) {
            return n10;
        }
        ByteBuffer byteBuffer = this.i;
        byte[] byArray = this.j;
        int n11 = byteBuffer.remaining();
        n11 = Math.min(n10, n11);
        byteBuffer.get(byArray, 0, n11);
        return n10;
    }

    private int w() {
        return this.i.get() & 0xFF;
    }

    private Bitmap x(b b10, b b11) {
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        int n17;
        a$a a$a;
        Object object;
        int[] nArray = this.p;
        int n18 = 0;
        Object object2 = null;
        if (b11 == null) {
            object = this.s;
            if (object != null) {
                a$a = this.h;
                a$a.a((Bitmap)object);
            }
            n17 = 0;
            object = null;
            this.s = null;
            Arrays.fill(nArray, 0);
        }
        n17 = 3;
        if (b11 != null && (n16 = b11.g) == n17 && (a$a = this.s) == null) {
            Arrays.fill(nArray, 0);
        }
        if (b11 != null && (n16 = b11.g) > 0) {
            n15 = 2;
            if (n16 == n15) {
                n17 = (int)(b10.f ? 1 : 0);
                if (n17 == 0) {
                    object = this.r;
                    n16 = object.l;
                    int[] nArray2 = b10.k;
                    if (nArray2 == null || (n17 = object.j) != (n15 = b10.h)) {
                        n18 = n16;
                    }
                }
                n17 = b11.d;
                n16 = this.v;
                n17 /= n16;
                n15 = b11.b / n16;
                n14 = b11.c / n16;
                n13 = b11.a / n16;
                n16 = this.x;
                n17 = n17 * n16 + n15;
                for (n15 = n15 * n16 + n13; n15 < n17; n15 += n13) {
                    n13 = n15 + n14;
                    for (n16 = n15; n16 < n13; ++n16) {
                        nArray[n16] = n18;
                    }
                    n13 = this.x;
                }
            } else if (n16 == n17 && (object2 = this.s) != null) {
                n16 = 0;
                a$a = null;
                n12 = this.x;
                n14 = 0;
                n11 = this.w;
                object = nArray;
                n15 = n12;
                object2.getPixels(nArray, 0, n12, 0, 0, n12, n11);
            }
        }
        this.s(b10);
        n13 = b10.e;
        n18 = 1;
        if (n13 == 0 && (n13 = this.v) == n18) {
            this.r(b10);
        } else {
            this.q(b10);
        }
        n13 = (int)(this.t ? 1 : 0);
        if (n13 != 0 && ((n10 = b10.g) == 0 || n10 == n18)) {
            b10 = this.s;
            if (b10 == null) {
                b10 = this.u();
                this.s = b10;
            }
            object2 = this.s;
            n16 = 0;
            a$a = null;
            n12 = this.x;
            n14 = 0;
            n11 = this.w;
            object = nArray;
            n15 = n12;
            object2.setPixels(nArray, 0, n12, 0, 0, n12, n11);
        }
        b10 = this.u();
        n12 = this.x;
        n11 = this.w;
        object2 = b10;
        object = nArray;
        n15 = n12;
        b10.setPixels(nArray, 0, n12, 0, 0, n12, n11);
        return b10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Bitmap a() {
        synchronized (this) {
            int n10;
            Object object;
            boolean bl2;
            Object object2 = this.r;
            int n11 = ((c)object2).c;
            int n12 = 3;
            int n13 = 1;
            if (n11 <= 0 || (n11 = this.q) < 0) {
                object2 = A;
                bl2 = Log.isLoggable((String)object2, (int)n12);
                if (bl2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    object = "Unable to decode frame, frameCount=";
                    stringBuilder.append((String)object);
                    object = this.r;
                    n10 = ((c)object).c;
                    stringBuilder.append(n10);
                    object = ", framePointer=";
                    stringBuilder.append((String)object);
                    n10 = this.q;
                    stringBuilder.append(n10);
                    String string2 = stringBuilder.toString();
                    Log.d((String)object2, (String)string2);
                }
                this.u = n13;
            }
            n11 = this.u;
            bl2 = false;
            Object var6_8 = null;
            if (n11 != n13 && n11 != (n10 = 2)) {
                b b10;
                Object object3;
                int n14;
                n11 = 0;
                object2 = null;
                this.u = 0;
                byte[] byArray = this.j;
                if (byArray == null) {
                    a$a a$a = this.h;
                    n14 = 255;
                    byte[] byArray2 = a$a.c(n14);
                    this.j = byArray2;
                }
                c c10 = this.r;
                List list = c10.e;
                n14 = this.q;
                Object e10 = list.get(n14);
                b b11 = (b)e10;
                n14 = this.q - n13;
                if (n14 >= 0) {
                    object3 = this.r;
                    object3 = ((c)object3).e;
                    b10 = (b)object3.get(n14);
                    b10 = b10;
                } else {
                    n14 = 0;
                    b10 = null;
                }
                object3 = b11.k;
                if (object3 == null) {
                    object3 = this.r;
                    object3 = ((c)object3).a;
                }
                this.f = (int[])object3;
                if (object3 == null) {
                    object2 = A;
                    if ((n12 = (int)(Log.isLoggable((String)object2, (int)n12) ? 1 : 0)) != 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        object = "No valid color table found for frame #";
                        stringBuilder.append((String)object);
                        n10 = this.q;
                        stringBuilder.append(n10);
                        String string3 = stringBuilder.toString();
                        Log.d((String)object2, (String)string3);
                    }
                    this.u = n13;
                    return null;
                }
                n12 = (int)(b11.f ? 1 : 0);
                if (n12 == 0) return this.x(b11, b10);
                int[] nArray = this.g;
                n13 = ((Object)object3).length;
                System.arraycopy(object3, 0, nArray, 0, n13);
                int[] nArray2 = this.g;
                this.f = nArray2;
                n13 = b11.h;
                nArray2[n13] = 0;
                n11 = b11.g;
                if (n11 != n10) return this.x(b11, b10);
                n11 = this.q;
                if (n11 != 0) return this.x(b11, b10);
                this.y = object2 = Boolean.TRUE;
                return this.x(b11, b10);
            }
            object2 = A;
            if ((n12 = (int)(Log.isLoggable((String)object2, (int)n12) ? 1 : 0)) == 0) return null;
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "Unable to decode frame, status=";
            stringBuilder.append(string4);
            n13 = this.u;
            stringBuilder.append(n13);
            String string5 = stringBuilder.toString();
            Log.d((String)object2, (String)string5);
            return null;
        }
    }

    public void b() {
        int n10 = this.q + 1;
        int n11 = this.r.c;
        this.q = n10 %= n11;
    }

    public int c() {
        return this.r.c;
    }

    public void clear() {
        a$a a$a;
        byte[] byArray = null;
        this.r = null;
        Object object = this.o;
        if (object != null) {
            a$a = this.h;
            a$a.e((byte[])object);
        }
        if ((object = (Object)this.p) != null) {
            a$a = this.h;
            a$a.f((int[])object);
        }
        if ((object = (Object)this.s) != null) {
            a$a = this.h;
            a$a.a((Bitmap)object);
        }
        this.s = null;
        this.i = null;
        this.y = null;
        byArray = this.j;
        if (byArray != null) {
            object = this.h;
            object.e(byArray);
        }
    }

    public void d(Bitmap.Config object) {
        Object object2 = Bitmap.Config.ARGB_8888;
        if (object != object2 && object != (object2 = Bitmap.Config.RGB_565)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported format: ");
            stringBuilder.append(object);
            stringBuilder.append(", must be one of ");
            object = Bitmap.Config.ARGB_8888;
            stringBuilder.append(object);
            stringBuilder.append(" or ");
            object = Bitmap.Config.RGB_565;
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        this.z = object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int e(int n10) {
        if (n10 < 0) return -1;
        Object object = this.r;
        int n11 = ((c)object).c;
        if (n10 >= n11) return -1;
        object = ((c)object).e;
        b b10 = (b)object.get(n10);
        return b10.i;
    }

    public int f() {
        c c10 = this.r;
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

    public int g() {
        c c10 = this.r;
        int n10 = c10.m;
        int n11 = -1;
        if (n10 == n11) {
            n10 = 1;
        }
        return n10;
    }

    public ByteBuffer getData() {
        return this.i;
    }

    public int getHeight() {
        return this.r.g;
    }

    public int getStatus() {
        return this.u;
    }

    public int getWidth() {
        return this.r.f;
    }

    public void h(c c10, byte[] object) {
        synchronized (this) {
            object = ByteBuffer.wrap(object);
            this.k(c10, (ByteBuffer)object);
            return;
        }
    }

    public int i() {
        c c10 = this.r;
        int n10 = c10.c;
        if (n10 > 0 && (n10 = this.q) >= 0) {
            return this.e(n10);
        }
        return 0;
    }

    public void j() {
        this.q = -1;
    }

    public void k(c c10, ByteBuffer byteBuffer) {
        synchronized (this) {
            int n10 = 1;
            this.m(c10, byteBuffer, n10);
            return;
        }
    }

    public int l() {
        return this.q;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void m(c object, ByteBuffer iterator2, int n10) {
        synchronized (this) {
            Throwable throwable2;
            block7: {
                if (n10 > 0) {
                    a$a a$a;
                    int n11;
                    int n12;
                    try {
                        int n13;
                        n10 = Integer.highestOneBit(n10);
                        int n14 = 0;
                        b b10 = null;
                        this.u = 0;
                        this.r = object;
                        this.q = n13 = -1;
                        iterator2 = ((ByteBuffer)((Object)iterator2)).asReadOnlyBuffer();
                        this.i = iterator2;
                        ((ByteBuffer)((Object)iterator2)).position(0);
                        iterator2 = this.i;
                        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                        ((ByteBuffer)((Object)iterator2)).order(byteOrder);
                        this.t = false;
                        iterator2 = ((c)object).e;
                        iterator2 = iterator2.iterator();
                        while ((n14 = iterator2.hasNext()) != 0) {
                            b10 = (b)iterator2.next();
                            b10 = b10;
                            n14 = b10.g;
                            n13 = 3;
                            if (n14 != n13) continue;
                            n12 = 1;
                            this.t = n12;
                            break;
                        }
                        this.v = n10;
                        n12 = ((c)object).f;
                        this.x = n14 = n12 / n10;
                        n11 = ((c)object).g;
                        this.w = n10 = n11 / n10;
                        a$a = this.h;
                    }
                    catch (Throwable throwable2) {
                        break block7;
                    }
                    {
                        object = a$a.c(n12 *= n11);
                        this.o = (byte[])object;
                        object = this.h;
                        n12 = this.x;
                        n10 = this.w;
                    }
                    object = object.d(n12 *= n10);
                    this.p = (int[])object;
                    return;
                }
                iterator2 = new Iterator();
                String string2 = "Sample size must be >=0, not: ";
                ((StringBuilder)((Object)iterator2)).append(string2);
                ((StringBuilder)((Object)iterator2)).append(n10);
                iterator2 = ((StringBuilder)((Object)iterator2)).toString();
                object = new IllegalArgumentException((String)((Object)iterator2));
                throw object;
            }
            throw throwable2;
        }
    }

    public int n() {
        return this.r.m;
    }

    public int o() {
        int n10 = this.i.limit();
        int n11 = this.o.length;
        n10 += n11;
        n11 = this.p.length * 4;
        return n10 + n11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int read(InputStream inputStream, int n10) {
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
                this.read((byte[])object);
            }
            catch (IOException iOException) {
                string2 = A;
                String string3 = "Error reading data from stream";
                Log.w((String)string2, (String)string3, (Throwable)iOException);
            }
        } else {
            this.u = n10 = 2;
        }
        if (inputStream == null) return this.u;
        try {
            inputStream.close();
            return this.u;
        }
        catch (IOException iOException) {
            object = A;
            string2 = "Error closing stream";
            Log.w((String)object, (String)string2, (Throwable)iOException);
        }
        return this.u;
    }

    public int read(byte[] byArray) {
        synchronized (this) {
            Object object = this.t();
            object = ((d)object).r(byArray);
            this.r = object = ((d)object).d();
            if (byArray != null) {
                this.h((c)object, byArray);
            }
            int n10 = this.u;
            return n10;
        }
    }
}

