/*
 * Decompiled with CFR 0.151.
 */
package d.m.a.f;

import java.io.FileOutputStream;
import java.io.UTFDataFormatException;

public class a
extends FileOutputStream {
    public int a;

    public a(String string2) {
        super(string2);
    }

    public void B(int n10) {
        int n11 = n10 & 0xFF;
        this.write(n11);
        n10 = n10 >>> 8 & 0xFF;
        this.write(n10);
        this.a = n10 = this.a + 2;
    }

    public void C(String string2) {
        int n10 = string2.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = string2.charAt(i10);
            int n12 = n11 & 0xFF;
            this.write(n12);
            n11 = n11 >>> 8 & 0xFF;
            this.write(n11);
        }
        int n13 = this.a;
        this.a = n13 += (n10 *= 2);
    }

    public final void D(double d10) {
        long l10 = Double.doubleToLongBits(d10);
        this.S(l10);
    }

    public final void E(float f10) {
        int n10 = Float.floatToIntBits(f10);
        this.O(n10);
    }

    public void O(int n10) {
        int n11 = n10 & 0xFF;
        this.write(n11);
        n11 = n10 >>> 8 & 0xFF;
        this.write(n11);
        n11 = n10 >>> 16 & 0xFF;
        this.write(n11);
        n10 = n10 >>> 24 & 0xFF;
        this.write(n10);
        this.a = n10 = this.a + 4;
    }

    public void S(long l10) {
        int n10 = (int)l10 & 0xFF;
        this.write(n10);
        n10 = 8;
        int n11 = (int)(l10 >>> n10) & 0xFF;
        this.write(n11);
        n11 = (int)(l10 >>> 16) & 0xFF;
        this.write(n11);
        n11 = (int)(l10 >>> 24) & 0xFF;
        this.write(n11);
        n11 = (int)(l10 >>> 32) & 0xFF;
        this.write(n11);
        n11 = (int)(l10 >>> 40) & 0xFF;
        this.write(n11);
        n11 = (int)(l10 >>> 48) & 0xFF;
        this.write(n11);
        int n12 = (int)(l10 >>> 56) & 0xFF;
        this.write(n12);
        this.a = n12 = this.a + n10;
    }

    public void a(boolean bl2) {
        bl2 = bl2;
        this.write((int)(bl2 ? 1 : 0));
    }

    public void h(int n10) {
        this.write(n10);
        this.a = n10 = this.a + 1;
    }

    public void n0(int n10) {
        int n11 = n10 & 0xFF;
        this.write(n11);
        n10 = n10 >>> 8 & 0xFF;
        this.write(n10);
        this.a = n10 = this.a + 2;
    }

    public void o0(String object) {
        char c10;
        char c11;
        char c12;
        int n10 = ((String)object).length();
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        while (true) {
            c12 = '\u007f';
            c11 = '\u07ff';
            c10 = '\u0001';
            if (n12 >= n10) break;
            char c13 = ((String)object).charAt(n12);
            n13 = c13 >= c10 && c13 <= c12 ? ++n13 : (c13 > c11 ? (n13 += 3) : (n13 += 2));
            ++n12;
        }
        n12 = (char)-1;
        if (n13 <= n12) {
            n12 = n13 >>> 8 & 0xFF;
            this.write(n12);
            n12 = n13 & 0xFF;
            this.write(n12);
            while (n11 < n10) {
                n12 = ((String)object).charAt(n11);
                if (n12 >= c10 && n12 <= c12) {
                    this.write(n12);
                } else {
                    if (n12 > c11) {
                        n13 = n12 >> 12 & 0xF | 0xE0;
                        this.write(n13);
                        n13 = n12 >> 6 & 0x3F | 0x80;
                        this.write(n13);
                        n12 = n12 & 0x3F | 0x80;
                        this.write(n12);
                        n12 = this.a + 2;
                    } else {
                        n13 = n12 >> 6 & 0x1F | 0xC0;
                        this.write(n13);
                        n12 = n12 & 0x3F | 0x80;
                        this.write(n12);
                        n12 = this.a + c10;
                    }
                    this.a = n12;
                }
                ++n11;
            }
            int n14 = this.a;
            this.a = n14 += (n10 += 2);
            return;
        }
        object = new UTFDataFormatException();
        throw object;
    }

    public void q(String string2) {
        int n10;
        int n11 = string2.length();
        for (int i10 = 0; i10 < n11; ++i10) {
            byte by2 = (byte)string2.charAt(i10);
            this.write(by2);
        }
        this.a = n10 = this.a + n11;
    }
}

