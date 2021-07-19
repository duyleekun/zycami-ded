/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.m.a.e;

import android.util.Log;
import d.m.a.e.b;
import d.m.a.e.c;
import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class d {
    public static final String f = "GifHeaderParser";
    private final byte[] a;
    private ByteBuffer b;
    private c c;
    private int d;
    public boolean e;

    public d() {
        byte[] byArray = new byte[256];
        this.a = byArray;
        this.d = 0;
        this.e = true;
    }

    private void a() {
        c c10;
        this.b = null;
        Arrays.fill(this.a, (byte)0);
        this.c = c10 = new c();
        this.d = 0;
    }

    private int[] b(int n10) {
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
                object = f;
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

    private void c() {
        int n10;
        int n11 = 0;
        while (n11 == 0 && (n10 = this.p()) == 0) {
            Object object;
            Object object2;
            n10 = this.n();
            int n12 = 33;
            int n13 = 1;
            if (n10 != n12) {
                n12 = 44;
                if (n10 != n12) {
                    n12 = 59;
                    if (n10 != n12) {
                        object2 = this.c;
                        ((c)object2).b = n13;
                        continue;
                    }
                    n11 = n13;
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
            n10 = this.n();
            if (n10 != n13) {
                n12 = 249;
                if (n10 != n12) {
                    n12 = 254;
                    if (n10 != n12 && n10 == (n12 = 255)) {
                        this.m();
                        object2 = "";
                        object = null;
                        for (n12 = 0; n12 < (n13 = 11); ++n12) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append((String)object2);
                            n10 = (char)this.a[n12];
                            stringBuilder.append((char)n10);
                            object2 = stringBuilder.toString();
                        }
                        object = "NETSCAPE2.0";
                        n10 = (int)(((String)object2).equals(object) ? 1 : 0);
                        if (n10 != 0) {
                            this.g();
                            continue;
                        }
                    }
                } else {
                    object2 = this.c;
                    object = new b();
                    ((c)object2).d = object;
                    this.d();
                    continue;
                }
            }
            this.k();
        }
    }

    private void d() {
        int n10;
        this.n();
        int n11 = this.n();
        b b10 = this.c.d;
        b10.g = n10 = (n11 & 0x1C) >> 2;
        int n12 = 1;
        if (n10 == 0) {
            b10.g = n12;
        }
        if ((n11 &= n12) == 0) {
            n12 = 0;
        }
        b10.f = n12;
        n11 = this.o();
        int n13 = 3;
        n10 = 10;
        if (n11 < n13) {
            n11 = n10;
        }
        b10 = this.c.d;
        b10.i = n11 *= n10;
        b10.h = n11 = this.n();
        this.n();
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
        int n11 = this.n();
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
            object2 = this.b(n15);
            b10.k = (int[])object2;
        } else {
            n11 = 0;
            object2 = null;
            b10.k = null;
        }
        object2 = this.c.d;
        object = this.b;
        ((b)object2).j = n10 = ((Buffer)object).position();
        this.j();
        n11 = (int)(this.p() ? 1 : 0);
        if (n11 != 0) {
            return;
        }
        object2 = this.c;
        ((c)object2).c = n10 = ((c)object2).c + n13;
        object = ((c)object2).e;
        object2 = ((c)object2).d;
        object.add(object2);
    }

    private void g() {
        int n10;
        do {
            this.m();
            byte[] byArray = this.a;
            int n11 = byArray[0];
            int n12 = 1;
            if (n11 != n12) continue;
            n11 = byArray[n12] & 0xFF;
            n12 = 2;
            n10 = byArray[n12] & 0xFF;
            c c10 = this.c;
            c10.m = n10 = n10 << 8 | n11;
        } while ((n10 = this.d) > 0 && (n10 = (int)(this.p() ? 1 : 0)) == 0);
    }

    private void h() {
        Object object;
        int n10;
        int n11;
        boolean bl2 = false;
        c c10 = null;
        Object object2 = "";
        String string2 = null;
        for (n11 = 0; n11 < (n10 = 6); ++n11) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object2);
            object = (char)this.n();
            stringBuilder.append((char)object);
            object2 = stringBuilder.toString();
        }
        string2 = "GIF";
        object = ((String)object2).startsWith(string2);
        if (object == 0) {
            this.c.b = 1;
            this.e = false;
            return;
        }
        this.i();
        c10 = this.c;
        bl2 = c10.h;
        if (bl2 && !(bl2 = this.p())) {
            c10 = this.c;
            object = c10.i;
            object2 = this.b((int)object);
            c10.a = (int[])object2;
            c10 = this.c;
            object2 = c10.a;
            n11 = c10.j;
            object = object2[n11];
            c10.l = object;
        }
    }

    private void i() {
        int n10;
        c c10 = this.c;
        c10.f = n10 = this.o();
        c10 = this.c;
        c10.g = n10 = this.o();
        int n11 = this.n();
        c c11 = this.c;
        int n12 = n11 & 0x80;
        n12 = n12 != 0 ? 1 : 0;
        c11.h = n12;
        n11 &= 7;
        c11.i = n11 = 2 << n11;
        c11.j = n11 = this.n();
        c10 = this.c;
        c10.k = n10 = this.n();
    }

    private void j() {
        this.n();
        this.k();
    }

    private void k() {
        int n10;
        do {
            n10 = this.n();
            ByteBuffer byteBuffer = this.b;
            int n11 = byteBuffer.position() + n10;
            byteBuffer.position(n11);
        } while (n10 > 0);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int m() {
        int n11;
        this.d = n11 = this.n();
        int n10 = 0;
        if (n11 <= 0) return n10;
        n11 = 0;
        Object object2 = null;
        while (true) {
            Object object;
            try {
                n11 = this.d;
                if (n10 >= n11) return n10;
            }
            catch (Exception exception) {
                int n12;
                String string2 = f;
                boolean bl2 = Log.isLoggable((String)string2, (int)3);
                if (bl2) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Error Reading Block n: ");
                    ((StringBuilder)object).append(n10);
                    String string3 = " count: ";
                    ((StringBuilder)object).append(string3);
                    ((StringBuilder)object).append(n11);
                    ((StringBuilder)object).append(" blockSize: ");
                    n11 = this.d;
                    ((StringBuilder)object).append(n11);
                    object2 = ((StringBuilder)object).toString();
                    Log.d((String)string2, (String)object2, (Throwable)exception);
                }
                object2 = this.c;
                ((c)object2).b = n12 = 1;
                return n10;
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

    private int n() {
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

    private int o() {
        return this.b.getShort();
    }

    private boolean p() {
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

    public void e() {
        this.b = null;
        this.c = null;
    }

    public boolean l() {
        return this.e;
    }

    public c q() {
        Object object = this.b;
        if (object != null) {
            boolean bl2 = this.p();
            if (bl2) {
                return this.c;
            }
            this.h();
            bl2 = this.p();
            if (!bl2) {
                this.c();
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

    public d r(byte[] object) {
        this.a();
        if (object != null) {
            object = ByteBuffer.wrap((byte[])object);
            this.b = object;
            ((ByteBuffer)object).rewind();
            object = this.b;
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            ((ByteBuffer)object).order(byteOrder);
        } else {
            int n10;
            this.b = null;
            object = this.c;
            ((c)object).b = n10 = 2;
        }
        return this;
    }
}

