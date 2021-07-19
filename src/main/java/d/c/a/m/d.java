/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.c.a.m;

import android.util.Log;
import d.c.a.m.b;
import d.c.a.m.c;
import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class d {
    private static final String e = "GifHeaderParser";
    private static final int f = 255;
    private static final int g = 44;
    private static final int h = 33;
    private static final int i = 59;
    private static final int j = 249;
    private static final int k = 255;
    private static final int l = 254;
    private static final int m = 1;
    private static final int n = 28;
    private static final int o = 2;
    private static final int p = 1;
    private static final int q = 128;
    private static final int r = 64;
    private static final int s = 7;
    private static final int t = 128;
    private static final int u = 7;
    public static final int v = 2;
    public static final int w = 10;
    private static final int x = 256;
    private final byte[] a;
    private ByteBuffer b;
    private c c;
    private int d;

    public d() {
        byte[] byArray = new byte[256];
        this.a = byArray;
        this.d = 0;
    }

    private boolean b() {
        c c10 = this.c;
        int n10 = c10.b;
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            c10 = null;
        }
        return n10 != 0;
    }

    private int e() {
        int n10;
        Object object = this.b;
        try {
            n10 = ((ByteBuffer)object).get() & 0xFF;
        }
        catch (Exception exception) {
            int n11;
            object = this.c;
            ((c)object).b = n11 = 1;
            n10 = 0;
            object = null;
        }
        return n10;
    }

    private void f() {
        Object object;
        int n10;
        Object object2 = this.c.d;
        ((b)object2).a = n10 = this.o();
        object2 = this.c.d;
        ((b)object2).b = n10 = this.o();
        object2 = this.c.d;
        ((b)object2).c = n10 = this.o();
        object2 = this.c.d;
        ((b)object2).d = n10 = this.o();
        int n11 = this.e();
        n10 = n11 & 0x80;
        int n12 = 0;
        int n13 = 1;
        if (n10 != 0) {
            n10 = n13;
        } else {
            n10 = 0;
            object = null;
        }
        int n14 = (n11 & 7) + n13;
        double d10 = n14;
        double d11 = Math.pow(2.0, d10);
        int n15 = (int)d11;
        b b10 = this.c.d;
        if ((n11 &= 0x40) != 0) {
            n12 = n13;
        }
        b10.e = n12;
        if (n10 != 0) {
            object2 = this.h(n15);
            b10.k = (int[])object2;
        } else {
            n11 = 0;
            object2 = null;
            b10.k = null;
        }
        object2 = this.c.d;
        object = this.b;
        ((b)object2).j = n10 = ((Buffer)object).position();
        this.t();
        n11 = (int)(this.b() ? 1 : 0);
        if (n11 != 0) {
            return;
        }
        object2 = this.c;
        ((c)object2).c = n10 = ((c)object2).c + n13;
        object = ((c)object2).e;
        object2 = ((c)object2).d;
        object.add(object2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void g() {
        int n10;
        this.d = n10 = this.e();
        if (n10 <= 0) return;
        n10 = 0;
        Object object2 = null;
        int n11 = 0;
        while (true) {
            Object object;
            try {
                n11 = this.d;
                if (n10 >= n11) return;
            }
            catch (Exception exception) {
                String string2 = e;
                boolean bl2 = Log.isLoggable((String)string2, (int)3);
                if (bl2) {
                    object = new StringBuilder();
                    String string3 = "Error Reading Block n: ";
                    ((StringBuilder)object).append(string3);
                    ((StringBuilder)object).append(n10);
                    ((StringBuilder)object).append(" count: ");
                    ((StringBuilder)object).append(n11);
                    ((StringBuilder)object).append(" blockSize: ");
                    n10 = this.d;
                    ((StringBuilder)object).append(n10);
                    object2 = ((StringBuilder)object).toString();
                    Log.d((String)string2, (String)object2, (Throwable)exception);
                }
                object2 = this.c;
                ((c)object2).b = n11 = 1;
                return;
            }
            {
                ByteBuffer byteBuffer = this.b;
                object = this.a;
                byteBuffer.get((byte[])object, n10, n11 -= n10);
                n10 += n11;
                continue;
            }
            break;
        }
    }

    private int[] h(int n10) {
        int n11 = n10 * 3;
        Object object = new byte[n11];
        int[] nArray = null;
        Object object2 = this.b;
        ((ByteBuffer)object2).get((byte[])object);
        int n12 = 256;
        nArray = new int[n12];
        n12 = 0;
        object2 = null;
        int n13 = 0;
        while (n12 < n10) {
            int n14 = n13 + 1;
            n13 = object[n13] & 0xFF;
            int n15 = n14 + 1;
            n14 = object[n14] & 0xFF;
            int n16 = n15 + 1;
            n15 = object[n15] & 0xFF;
            int n17 = n12 + 1;
            int n18 = -16777216;
            n13 = n13 << 16 | n18;
            n13 = n13 | (n14 <<= 8) | n15;
            try {
                nArray[n12] = n13;
                n13 = n16;
                n12 = n17;
            }
            catch (BufferUnderflowException bufferUnderflowException) {
                object = e;
                n12 = Log.isLoggable((String)object, (int)3);
                if (n12 != 0) {
                    object2 = "Format Error Reading Color Table";
                    Log.d((String)object, (String)object2, (Throwable)bufferUnderflowException);
                }
                c c10 = this.c;
                c10.b = n11 = 1;
                break;
            }
        }
        return nArray;
    }

    private void i() {
        this.j(-1 >>> 1);
    }

    private void j(int n10) {
        int n11;
        int n12 = 0;
        while (n12 == 0 && (n11 = this.b()) == 0) {
            Object object;
            Object object2 = this.c;
            n11 = ((c)object2).c;
            if (n11 > n10) break;
            n11 = this.e();
            int n13 = 33;
            int n14 = 1;
            if (n11 != n13) {
                n13 = 44;
                if (n11 != n13) {
                    n13 = 59;
                    if (n11 != n13) {
                        object2 = this.c;
                        ((c)object2).b = n14;
                        continue;
                    }
                    n12 = n14;
                    continue;
                }
                object2 = this.c;
                object = ((c)object2).d;
                if (object == null) {
                    object = new b();
                    ((c)object2).d = object;
                }
                this.f();
                continue;
            }
            n11 = this.e();
            if (n11 != n14) {
                n13 = 249;
                if (n11 != n13) {
                    n13 = 254;
                    if (n11 != n13) {
                        n13 = 255;
                        if (n11 != n13) {
                            this.s();
                            continue;
                        }
                        this.g();
                        object2 = new StringBuilder();
                        object = null;
                        for (n13 = 0; n13 < (n14 = 11); ++n13) {
                            byte[] byArray = this.a;
                            n14 = (char)byArray[n13];
                            ((StringBuilder)object2).append((char)n14);
                        }
                        n11 = (int)(((String)(object2 = ((StringBuilder)object2).toString())).equals(object = "NETSCAPE2.0") ? 1 : 0);
                        if (n11 != 0) {
                            this.n();
                            continue;
                        }
                        this.s();
                        continue;
                    }
                    this.s();
                    continue;
                }
                object2 = this.c;
                object = new b();
                ((c)object2).d = object;
                this.k();
                continue;
            }
            this.s();
        }
    }

    private void k() {
        this.e();
        int n10 = this.e();
        b b10 = this.c.d;
        int n11 = n10 & 0x1C;
        int n12 = 2;
        b10.g = n11 >>= n12;
        int n13 = 1;
        if (n11 == 0) {
            b10.g = n13;
        }
        if ((n10 &= n13) == 0) {
            n13 = 0;
        }
        b10.f = n13;
        n10 = this.o();
        int n14 = 10;
        if (n10 < n12) {
            n10 = n14;
        }
        b b11 = this.c.d;
        b11.i = n10 *= n14;
        b11.h = n10 = this.e();
        this.e();
    }

    private void l() {
        int n10;
        Object object;
        Object object2 = new StringBuilder();
        Object object3 = null;
        for (object = 0; object < (n10 = 6); ++object) {
            n10 = (char)this.e();
            ((StringBuilder)object2).append((char)n10);
        }
        boolean bl2 = ((String)(object2 = ((StringBuilder)object2).toString())).startsWith((String)(object3 = "GIF"));
        if (!bl2) {
            this.c.b = 1;
            return;
        }
        this.m();
        object2 = this.c;
        bl2 = ((c)object2).h;
        if (bl2 && !(bl2 = this.b())) {
            object2 = this.c;
            object = ((c)object2).i;
            object3 = this.h((int)object);
            ((c)object2).a = (int[])object3;
            object2 = this.c;
            object3 = ((c)object2).a;
            n10 = ((c)object2).j;
            ((c)object2).l = object = (Object)object3[n10];
        }
    }

    private void m() {
        int n10;
        c c10 = this.c;
        c10.f = n10 = this.o();
        c10 = this.c;
        c10.g = n10 = this.o();
        int n11 = this.e();
        c c11 = this.c;
        int n12 = n11 & 0x80;
        int n13 = 1;
        n12 = n12 != 0 ? n13 : 0;
        c11.h = n12;
        double d10 = (n11 & 7) + n13;
        c11.i = n11 = (int)Math.pow(2.0, d10);
        c10 = this.c;
        c10.j = n10 = this.e();
        c10 = this.c;
        c10.k = n10 = this.e();
    }

    private void n() {
        int n10;
        do {
            this.g();
            byte[] byArray = this.a;
            int n11 = byArray[0];
            int n12 = 1;
            if (n11 != n12) continue;
            n11 = byArray[n12] & 0xFF;
            n12 = 2;
            n10 = byArray[n12] & 0xFF;
            c c10 = this.c;
            c10.m = n10 = n10 << 8 | n11;
        } while ((n10 = this.d) > 0 && (n10 = (int)(this.b() ? 1 : 0)) == 0);
    }

    private int o() {
        return this.b.getShort();
    }

    private void p() {
        c c10;
        this.b = null;
        Arrays.fill(this.a, (byte)0);
        this.c = c10 = new c();
        this.d = 0;
    }

    private void s() {
        int n10;
        do {
            n10 = this.e();
            ByteBuffer byteBuffer = this.b;
            int n11 = byteBuffer.position() + n10;
            int n12 = this.b.limit();
            n11 = Math.min(n11, n12);
            ByteBuffer byteBuffer2 = this.b;
            byteBuffer2.position(n11);
        } while (n10 > 0);
    }

    private void t() {
        this.e();
        this.s();
    }

    public void a() {
        this.b = null;
        this.c = null;
    }

    public boolean c() {
        this.l();
        boolean bl2 = this.b();
        if (!bl2) {
            int n10 = 2;
            this.j(n10);
        }
        c c10 = this.c;
        int n11 = c10.c;
        int n12 = 1;
        if (n11 <= n12) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public c d() {
        Object object = this.b;
        if (object != null) {
            boolean bl2 = this.b();
            if (bl2) {
                return this.c;
            }
            this.l();
            bl2 = this.b();
            if (!bl2) {
                this.i();
                object = this.c;
                int n10 = ((c)object).c;
                if (n10 < 0) {
                    ((c)object).b = n10 = 1;
                }
            }
            return this.c;
        }
        object = new IllegalStateException("You must call setData() before parseHeader()");
        throw object;
    }

    public d q(ByteBuffer byteBuffer) {
        this.p();
        this.b = byteBuffer = byteBuffer.asReadOnlyBuffer();
        byteBuffer.position(0);
        byteBuffer = this.b;
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        byteBuffer.order(byteOrder);
        return this;
    }

    public d r(byte[] object) {
        if (object != null) {
            object = ByteBuffer.wrap(object);
            this.q((ByteBuffer)object);
        } else {
            int n10;
            this.b = null;
            object = this.c;
            object.b = n10 = 2;
        }
        return this;
    }
}

