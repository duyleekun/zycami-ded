/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.videodecoder;

import com.tencent.liteav.videodecoder.a;
import java.io.InputStream;
import java.io.OutputStream;

public class c {
    public a a;
    public int b;
    private InputStream c;
    private int d;
    private int e;
    private final OutputStream f;
    private int[] g;
    private int h;

    public c(InputStream inputStream, OutputStream outputStream) {
        int n10;
        int n11;
        Object object = new a(50);
        this.a = object;
        object = new int[8];
        this.g = (int[])object;
        this.c = inputStream;
        this.f = outputStream;
        this.d = n11 = inputStream.read();
        this.e = n10 = inputStream.read();
    }

    private void a(String string2, String string3) {
    }

    private void d() {
        int n10;
        this.d = n10 = this.e;
        this.e = n10 = this.c.read();
        this.b = 0;
    }

    private int e() {
        int n10;
        int n11;
        int n12 = 0;
        int n13 = 0;
        while ((n11 = this.b((n10 = 1) != 0)) == 0) {
            ++n13;
        }
        if (n13 > 0) {
            long l10 = this.a(n13);
            long l11 = (long)((n10 << n13) - n10) + l10;
            n12 = (int)l11;
        }
        return n12;
    }

    private void f() {
        int n10;
        int n11 = 0;
        while ((n10 = this.b(true)) == 0) {
            ++n11;
        }
        if (n11 > 0) {
            this.b(n11);
        }
    }

    private void g() {
        int[] nArray = this.g;
        int n10 = nArray[0];
        int n11 = 7;
        n10 <<= n11;
        int n12 = nArray[1];
        int n13 = 6;
        n10 |= (n12 <<= n13);
        int n14 = nArray[2];
        int n15 = 5;
        n10 |= (n14 <<= n15);
        int n16 = nArray[3];
        int n17 = 4;
        n10 |= (n16 <<= n17);
        n14 = nArray[n17] << 3;
        n10 |= n14;
        n12 = nArray[n15] << 2;
        n10 |= n12;
        int n18 = nArray[n13] << 1;
        int n19 = nArray[n11] | (n10 |= n18);
        this.f.write(n19);
    }

    public int a(String string2) {
        int n10 = this.e();
        String string3 = String.valueOf(n10);
        this.a(string2, string3);
        return n10;
    }

    public long a(int n10) {
        int n11 = 64;
        if (n10 <= n11) {
            long l10 = 0L;
            for (int i10 = 0; i10 < n10; ++i10) {
                int n12 = 1;
                l10 <<= n12;
                n12 = this.b(n12 != 0);
                long l11 = n12;
                l10 |= l11;
            }
            return l10;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can not readByte more then 64 bit");
        throw illegalArgumentException;
    }

    public long a(int n10, String string2) {
        long l10 = this.a(n10);
        String string3 = String.valueOf(l10);
        this.a(string2, string3);
        return l10;
    }

    public long a(int n10, boolean bl2) {
        int n11 = 64;
        if (n10 <= n11) {
            long l10 = 0L;
            for (int i10 = 0; i10 < n10; ++i10) {
                l10 <<= 1;
                int n12 = this.b(bl2);
                long l11 = n12;
                l10 |= l11;
            }
            return l10;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can not readByte more then 64 bit");
        throw illegalArgumentException;
    }

    public void a() {
        int n10;
        for (int i10 = this.h; i10 < (n10 = 8); ++i10) {
            int[] nArray = this.g;
            nArray[i10] = 0;
        }
        this.h = 0;
        this.g();
    }

    public void a(long l10, int n10) {
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = n10 - i10 + -1;
            long l11 = l10 >> n11;
            n11 = (int)l11 & 1;
            this.d(n11);
        }
    }

    public void a(boolean bl2, String string2) {
        this.d((int)(bl2 ? 1 : 0));
    }

    public boolean a(boolean bl2) {
        boolean bl3;
        if ((bl2 = this.b(bl2)) != (bl3 = true)) {
            bl3 = false;
        }
        return bl3;
    }

    public int b(boolean bl2) {
        OutputStream outputStream;
        int n10 = this.b;
        int n11 = 8;
        if (n10 == n11) {
            this.d();
            n10 = this.d;
            n11 = -1;
            if (n10 == n11) {
                return n11;
            }
        }
        n10 = this.d;
        n11 = this.b;
        int n12 = 7 - n11;
        n10 = n10 >> n12 & 1;
        this.b = ++n11;
        if (bl2 && (outputStream = this.f) != null) {
            this.d(n10);
        }
        return n10;
    }

    public void b() {
        int n10 = this.h;
        n10 = 8 - n10;
        this.a(0L, n10);
    }

    public void b(int n10) {
        int n11 = 64;
        if (n10 <= n11) {
            for (n11 = 0; n11 < n10; ++n11) {
                boolean bl2 = true;
                this.b(bl2);
            }
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can not skip more then 64 bit");
        throw illegalArgumentException;
    }

    public void b(int n10, String string2) {
        this.b(n10);
        this.a(string2, "skip NBits");
    }

    public void b(String string2) {
        this.f();
        this.a(string2, "skip UE");
    }

    public int c(String string2) {
        int n10 = this.e();
        int n11 = n10 & 1;
        int n12 = (n11 << 1) + -1;
        n10 = ((n10 >> 1) + n11) * n12;
        String string3 = String.valueOf(n10);
        this.a(string2, string3);
        return n10;
    }

    public int c(boolean bl2) {
        int n10;
        int n11 = 0;
        int n12 = 0;
        while ((n10 = this.b(bl2)) == 0) {
            ++n12;
        }
        if (n12 > 0) {
            long l10 = this.a(n12, bl2);
            bl2 = true;
            long l11 = (long)((bl2 << n12) - bl2) + l10;
            n11 = (int)l11;
        }
        return n11;
    }

    public void c() {
        this.d(1);
        this.b();
        this.a();
    }

    public void c(int n10) {
        int[] nArray = new int[n10];
        int n11 = 8;
        int n12 = n11;
        for (int i10 = 0; i10 < n10; ++i10) {
            if (n11 != 0) {
                String string2 = "deltaScale";
                n11 = (this.c(string2) + n12 + 256) % 256;
            }
            if (n11 != 0) {
                n12 = n11;
            }
            nArray[i10] = n12;
            n12 = nArray[i10];
        }
    }

    public void c(int n10, String string2) {
        this.e(n10);
    }

    public void d(int n10) {
        int n11;
        int[] nArray;
        int n12 = this.h;
        int n13 = 8;
        if (n12 == n13) {
            n12 = 0;
            nArray = null;
            this.h = 0;
            this.g();
        }
        nArray = this.g;
        n13 = this.h;
        this.h = n11 = n13 + 1;
        nArray[n13] = n10;
    }

    public boolean d(String string2) {
        boolean bl2 = this.a(true);
        String string3 = bl2 ? "1" : "0";
        this.a(string2, string3);
        return bl2;
    }

    public void e(int n10) {
        int n11;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        while (true) {
            int n15 = 15;
            n11 = 1;
            if (n13 >= n15) break;
            n15 = (n11 << n13) + n14;
            if (n10 < n15) {
                n12 = n13;
                break;
            }
            ++n13;
            n14 = n15;
        }
        this.a(0L, n12);
        this.d(n11);
        long l10 = n10 - n14;
        this.a(l10, n12);
    }

    public boolean e(String string2) {
        boolean bl2 = this.a(false);
        String string3 = bl2 ? "1" : "0";
        this.a(string2, string3);
        return bl2;
    }
}

