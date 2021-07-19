/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.a;
import com.xiaomi.push.d;
import com.xiaomi.push.e;
import com.xiaomi.push.f;
import java.io.InputStream;
import java.util.Vector;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class b {
    private int a;
    private final InputStream a;
    private final byte[] a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f = -1 >>> 1;
    private int g;
    private int h = 64;
    private int i = 0x4000000;

    private b(InputStream inputStream) {
        byte[] byArray = new byte[4096];
        this.a = byArray;
        this.a = 0;
        this.c = 0;
        this.a = inputStream;
    }

    private b(byte[] byArray, int n10, int n11) {
        this.a = byArray;
        this.a = n11 += n10;
        this.c = n10;
        this.a = null;
    }

    public static b a(InputStream inputStream) {
        b b10 = new b(inputStream);
        return b10;
    }

    public static b a(byte[] byArray, int n10, int n11) {
        b b10 = new b(byArray, n10, n11);
        return b10;
    }

    private boolean a(boolean n10) {
        int n11 = this.c;
        int n12 = this.a;
        if (n11 >= n12) {
            n11 = this.e;
            int n13 = n11 + n12;
            int n14 = this.f;
            if (n13 == n14) {
                if (n10 == 0) {
                    return false;
                }
                throw com.xiaomi.push.d.a();
            }
            this.e = n11 += n12;
            this.c = 0;
            Object object = this.a;
            n12 = -1;
            if (object == null) {
                n11 = n12;
            } else {
                byte[] byArray = this.a;
                n11 = ((InputStream)object).read(byArray);
            }
            this.a = n11;
            if (n11 != 0 && n11 >= n12) {
                if (n11 == n12) {
                    this.a = 0;
                    if (n10 == 0) {
                        return false;
                    }
                    throw com.xiaomi.push.d.a();
                }
                this.b();
                n10 = this.e;
                n11 = this.a;
                n10 += n11;
                n11 = this.b;
                n10 += n11;
                n11 = this.i;
                if (n10 <= n11 && n10 >= 0) {
                    return true;
                }
                throw com.xiaomi.push.d.h();
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("InputStream#read(byte[]) returned invalid result: ");
            n12 = this.a;
            ((StringBuilder)object).append(n12);
            ((StringBuilder)object).append("\nThe InputStream implementation is buggy.");
            object = ((StringBuilder)object).toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)object);
            throw illegalStateException;
        }
        IllegalStateException illegalStateException = new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        throw illegalStateException;
    }

    private void b() {
        int n10 = this.a;
        int n11 = this.b;
        this.a = n10 += n11;
        n11 = this.e + n10;
        int n12 = this.f;
        if (n11 > n12) {
            this.b = n11 -= n12;
            this.a = n10 -= n11;
        } else {
            n10 = 0;
            this.b = 0;
        }
    }

    public byte a() {
        int n10;
        int n11 = this.c;
        int n12 = this.a;
        if (n11 == n12) {
            n11 = 1;
            this.a(n11 != 0);
        }
        byte[] byArray = this.a;
        n12 = this.c;
        this.c = n10 = n12 + 1;
        return byArray[n12];
    }

    public int a() {
        int n10 = this.b();
        if (n10 != 0) {
            this.d = 0;
            return 0;
        }
        this.d = n10 = this.d();
        if (n10 != 0) {
            return n10;
        }
        throw com.xiaomi.push.d.d();
    }

    public int a(int n10) {
        if (n10 >= 0) {
            int n11 = this.e;
            int n12 = this.c;
            n11 += n12;
            if ((n10 += n11) <= (n11 = this.f)) {
                this.f = n10;
                this.b();
                return n11;
            }
            throw com.xiaomi.push.d.a();
        }
        throw com.xiaomi.push.d.b();
    }

    public long a() {
        return this.c();
    }

    public a a() {
        int n10 = this.d();
        int n11 = this.a;
        int n12 = this.c;
        if (n10 <= (n11 -= n12) && n10 > 0) {
            a a10 = com.xiaomi.push.a.a(this.a, n12, n10);
            this.c = n12 = this.c + n10;
            return a10;
        }
        return com.xiaomi.push.a.a(this.a(n10));
    }

    public String a() {
        int n10 = this.d();
        int n11 = this.a;
        int n12 = this.c;
        String string2 = "UTF-8";
        if (n10 <= (n11 -= n12) && n10 > 0) {
            byte[] byArray = this.a;
            int n13 = this.c;
            String string3 = new String(byArray, n13, n10, string2);
            this.c = n12 = this.c + n10;
            return string3;
        }
        byte[] byArray = this.a(n10);
        String string4 = new String(byArray, string2);
        return string4;
    }

    public void a() {
        int n10;
        while ((n10 = this.a()) != 0 && (n10 = (int)(this.a(n10) ? 1 : 0)) != 0) {
        }
    }

    public void a(int n10) {
        int n11 = this.d;
        if (n11 == n10) {
            return;
        }
        throw com.xiaomi.push.d.e();
    }

    public void a(e e10) {
        int n10 = this.d();
        int n11 = this.g;
        int n12 = this.h;
        if (n11 < n12) {
            int n13;
            n10 = this.a(n10);
            this.g = n11 = this.g + 1;
            e10.a(this);
            this.a(0);
            this.g = n13 = this.g + -1;
            this.b(n10);
            return;
        }
        throw com.xiaomi.push.d.g();
    }

    public boolean a() {
        int n10 = this.d();
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean a(int n10) {
        int n11 = com.xiaomi.push.f.a(n10);
        int n12 = 1;
        if (n11) {
            if (n11 != n12) {
                int n13 = 2;
                if (n11 != n13) {
                    n13 = 3;
                    int n14 = 4;
                    if (n11 != n13) {
                        if (n11 != n14) {
                            n10 = 5;
                            if (n11 == n10) {
                                this.e();
                                return n12;
                            }
                            throw com.xiaomi.push.d.f();
                        }
                        return false;
                    }
                    this.a();
                    n10 = com.xiaomi.push.f.a(com.xiaomi.push.f.b(n10), n14);
                    this.a(n10);
                    return n12;
                }
                n10 = this.d();
                this.c(n10);
                return n12;
            }
            this.d();
            return n12;
        }
        this.b();
        return n12;
    }

    public byte[] a(int n10) {
        if (n10 >= 0) {
            int n11 = this.e;
            int n12 = this.c;
            int n13 = n11 + n12 + n10;
            int n14 = this.f;
            if (n13 <= n14) {
                int n15;
                n13 = this.a;
                n14 = n13 - n12;
                if (n10 <= n14) {
                    byte[] byArray = new byte[n10];
                    System.arraycopy(this.a, n12, byArray, 0, n10);
                    this.c = n12 = this.c + n10;
                    return byArray;
                }
                n14 = 4096;
                if (n10 < n14) {
                    byte[] byArray = new byte[n10];
                    byte[] byArray2 = this.a;
                    System.arraycopy(byArray2, n12, byArray, 0, n13 -= n12);
                    this.c = n12 = this.a;
                    n12 = 1;
                    while (true) {
                        this.a(n12 != 0);
                        n14 = n10 - n13;
                        int n16 = this.a;
                        if (n14 <= n16) break;
                        byArray2 = this.a;
                        System.arraycopy(byArray2, 0, byArray, n13, n16);
                        n14 = this.a;
                        n13 += n14;
                        this.c = n14;
                    }
                    System.arraycopy(this.a, 0, byArray, n13, n14);
                    this.c = n14;
                    return byArray;
                }
                this.e = n11 += n13;
                this.c = 0;
                this.a = 0;
                Vector<byte[]> vector = new Vector<byte[]>();
                for (n11 = n10 - (n13 -= n12); n11 > 0; n11 -= n15) {
                    int n17;
                    n15 = Math.min(n11, n14);
                    byte[] byArray = new byte[n15];
                    for (int i10 = 0; i10 < n15; i10 += n17) {
                        InputStream inputStream = this.a;
                        int n18 = -1;
                        if (inputStream == null) {
                            n17 = n18;
                        } else {
                            int n19 = n15 - i10;
                            n17 = inputStream.read(byArray, i10, n19);
                        }
                        if (n17 != n18) {
                            this.e = n18 = this.e + n17;
                            continue;
                        }
                        throw com.xiaomi.push.d.a();
                    }
                    vector.addElement(byArray);
                }
                byte[] byArray = new byte[n10];
                System.arraycopy(this.a, n12, byArray, 0, n13);
                Object var6_8 = null;
                for (n11 = 0; n11 < (n12 = vector.size()); ++n11) {
                    byte[] byArray3 = (byte[])vector.elementAt(n11);
                    n14 = byArray3.length;
                    System.arraycopy(byArray3, 0, byArray, n13, n14);
                    n12 = byArray3.length;
                    n13 += n12;
                }
                return byArray;
            }
            n14 = n14 - n11 - n12;
            this.c(n14);
            throw com.xiaomi.push.d.a();
        }
        throw com.xiaomi.push.d.b();
    }

    public int b() {
        return this.d();
    }

    public long b() {
        return this.c();
    }

    public void b(int n10) {
        this.f = n10;
        this.b();
    }

    public boolean b() {
        int n10 = this.c;
        int n11 = this.a;
        boolean bl2 = false;
        if (n10 == n11 && (n10 = (int)(this.a(false) ? 1 : 0)) == 0) {
            bl2 = true;
        }
        return bl2;
    }

    public int c() {
        return this.d();
    }

    public long c() {
        int n10;
        long l10 = 0L;
        for (int i10 = 0; i10 < (n10 = 64); i10 += 7) {
            n10 = this.a();
            int n11 = n10 & 0x7F;
            long l11 = (long)n11 << i10;
            l10 |= l11;
            if ((n10 &= 0x80) != 0) continue;
            return l10;
        }
        throw com.xiaomi.push.d.c();
    }

    public void c(int n10) {
        if (n10 >= 0) {
            int n11 = this.e;
            int n12 = this.c;
            int n13 = n11 + n12 + n10;
            int n14 = this.f;
            if (n13 <= n14) {
                n13 = this.a;
                n14 = n13 - n12;
                if (n10 <= n14) {
                    this.c = n12 += n10;
                } else {
                    this.e = n11 += n13;
                    n11 = 0;
                    InputStream inputStream = null;
                    this.c = 0;
                    this.a = 0;
                    for (n12 = n13 - n12; n12 < n10; n12 += n11) {
                        inputStream = this.a;
                        if (inputStream == null) {
                            n11 = -1;
                        } else {
                            n13 = n10 - n12;
                            long l10 = n13;
                            l10 = inputStream.skip(l10);
                            n11 = (int)l10;
                        }
                        if (n11 > 0) {
                            this.e = n13 = this.e + n11;
                            continue;
                        }
                        throw com.xiaomi.push.d.a();
                    }
                }
                return;
            }
            n14 = n14 - n11 - n12;
            this.c(n14);
            throw com.xiaomi.push.d.a();
        }
        throw com.xiaomi.push.d.b();
    }

    /*
     * Enabled aggressive block sorting
     */
    public int d() {
        int n10 = this.a();
        if (n10 >= 0) {
            return n10;
        }
        n10 &= 0x7F;
        int n11 = this.a();
        if (n11 >= 0) {
            n11 <<= 7;
            return n10 |= n11;
        }
        n11 = (n11 & 0x7F) << 7;
        n10 |= n11;
        n11 = this.a();
        if (n11 >= 0) {
            n11 <<= 14;
            return n10 |= n11;
        }
        n11 = (n11 & 0x7F) << 14;
        n10 |= n11;
        n11 = this.a();
        if (n11 >= 0) {
            n11 <<= 21;
            return n10 |= n11;
        }
        n11 = (n11 & 0x7F) << 21;
        n10 |= n11;
        n11 = this.a();
        int n12 = n11 << 28;
        n10 |= n12;
        if (n11 >= 0) return n10;
        n11 = 0;
        while (n11 < (n12 = 5)) {
            n12 = this.a();
            if (n12 >= 0) {
                return n10;
            }
            ++n11;
        }
        throw com.xiaomi.push.d.c();
    }

    public long d() {
        byte by2 = this.a();
        byte by3 = this.a();
        byte by4 = this.a();
        byte by5 = this.a();
        byte by6 = this.a();
        byte by7 = this.a();
        byte by8 = this.a();
        byte by9 = this.a();
        long l10 = by2;
        long l11 = 255L;
        long l12 = ((long)by3 & l11) << 8 | (l10 &= l11);
        l10 = ((long)by4 & l11) << 16;
        l12 |= l10;
        long l13 = ((long)by5 & l11) << 24;
        l12 |= l13;
        l13 = ((long)by6 & l11) << 32;
        l12 |= l13;
        l13 = ((long)by7 & l11) << 40;
        l12 |= l13;
        l13 = ((long)by8 & l11) << 48;
        l12 |= l13;
        l13 = ((long)by9 & l11) << 56;
        return l12 | l13;
    }

    public int e() {
        int n10 = this.a();
        int n11 = this.a();
        byte by2 = this.a();
        byte by3 = this.a();
        n10 &= 0xFF;
        n11 = (n11 & 0xFF) << 8;
        n10 |= n11;
        n11 = (by2 & 0xFF) << 16;
        n10 |= n11;
        n11 = (by3 & 0xFF) << 24;
        return n10 | n11;
    }
}

