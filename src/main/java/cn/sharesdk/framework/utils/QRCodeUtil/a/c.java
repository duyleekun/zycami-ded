/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  cn.sharesdk.framework.utils.QRCodeUtil.a.b
 */
package cn.sharesdk.framework.utils.QRCodeUtil.a;

import cn.sharesdk.framework.utils.QRCodeUtil.WriterException;
import cn.sharesdk.framework.utils.QRCodeUtil.a.a;
import cn.sharesdk.framework.utils.QRCodeUtil.a.b;
import cn.sharesdk.framework.utils.QRCodeUtil.a.c$1;
import cn.sharesdk.framework.utils.QRCodeUtil.a.d;
import cn.sharesdk.framework.utils.QRCodeUtil.a.e;
import cn.sharesdk.framework.utils.QRCodeUtil.a.f;
import cn.sharesdk.framework.utils.QRCodeUtil.g;
import cn.sharesdk.framework.utils.QRCodeUtil.i;
import cn.sharesdk.framework.utils.QRCodeUtil.m;
import cn.sharesdk.framework.utils.QRCodeUtil.n;
import cn.sharesdk.framework.utils.QRCodeUtil.n$b;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

public final class c {
    private static final int[] a;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[96];
        int[] nArray3 = nArray;
        nArray2[0] = -1;
        nArray3[1] = -1;
        nArray2[2] = -1;
        nArray3[3] = -1;
        nArray2[4] = -1;
        nArray3[5] = -1;
        nArray2[6] = -1;
        nArray3[7] = -1;
        nArray2[8] = -1;
        nArray3[9] = -1;
        nArray2[10] = -1;
        nArray3[11] = -1;
        nArray2[12] = -1;
        nArray3[13] = -1;
        nArray2[14] = -1;
        nArray3[15] = -1;
        nArray2[16] = -1;
        nArray3[17] = -1;
        nArray2[18] = -1;
        nArray3[19] = -1;
        nArray2[20] = -1;
        nArray3[21] = -1;
        nArray2[22] = -1;
        nArray3[23] = -1;
        nArray2[24] = -1;
        nArray3[25] = -1;
        nArray2[26] = -1;
        nArray3[27] = -1;
        nArray2[28] = -1;
        nArray3[29] = -1;
        nArray2[30] = -1;
        nArray3[31] = -1;
        nArray2[32] = 36;
        nArray3[33] = -1;
        nArray2[34] = -1;
        nArray3[35] = -1;
        nArray2[36] = 37;
        nArray3[37] = 38;
        nArray2[38] = -1;
        nArray3[39] = -1;
        nArray2[40] = -1;
        nArray3[41] = -1;
        nArray2[42] = 39;
        nArray3[43] = 40;
        nArray2[44] = -1;
        nArray3[45] = 41;
        nArray2[46] = 42;
        nArray3[47] = 43;
        nArray2[48] = 0;
        nArray3[49] = 1;
        nArray2[50] = 2;
        nArray3[51] = 3;
        nArray2[52] = 4;
        nArray3[53] = 5;
        nArray2[54] = 6;
        nArray3[55] = 7;
        nArray2[56] = 8;
        nArray3[57] = 9;
        nArray2[58] = 44;
        nArray3[59] = -1;
        nArray2[60] = -1;
        nArray3[61] = -1;
        nArray2[62] = -1;
        nArray3[63] = -1;
        nArray2[64] = -1;
        nArray3[65] = 10;
        nArray2[66] = 11;
        nArray3[67] = 12;
        nArray2[68] = 13;
        nArray3[69] = 14;
        nArray2[70] = 15;
        nArray3[71] = 16;
        nArray2[72] = 17;
        nArray3[73] = 18;
        nArray2[74] = 19;
        nArray3[75] = 20;
        nArray2[76] = 21;
        nArray3[77] = 22;
        nArray2[78] = 23;
        nArray3[79] = 24;
        nArray2[80] = 25;
        nArray3[81] = 26;
        nArray2[82] = 27;
        nArray3[83] = 28;
        nArray2[84] = 29;
        nArray3[85] = 30;
        nArray2[86] = 31;
        nArray3[87] = 32;
        nArray2[88] = 33;
        nArray3[89] = 34;
        nArray2[90] = 35;
        nArray3[91] = -1;
        nArray2[92] = -1;
        nArray3[93] = -1;
        nArray2[94] = -1;
        nArray3[95] = -1;
        a = nArray;
    }

    public static int a(int n10) {
        int[] nArray = a;
        int n11 = nArray.length;
        if (n10 < n11) {
            return nArray[n10];
        }
        return -1;
    }

    private static int a(b b10) {
        int n10 = d.a(b10);
        int n11 = d.b(b10);
        n10 += n11;
        n11 = d.c(b10);
        int n12 = d.d(b10);
        return (n10 += n11) + n12;
    }

    private static int a(cn.sharesdk.framework.utils.QRCodeUtil.b b10, cn.sharesdk.framework.utils.QRCodeUtil.f f10, n n10, b b11) {
        int n11;
        int n12 = -1 >>> 1;
        int n13 = -1;
        for (int i10 = 0; i10 < (n11 = 8); ++i10) {
            e.a(b10, f10, n10, i10, b11);
            n11 = c.a(b11);
            if (n11 >= n12) continue;
            n13 = i10;
            n12 = n11;
        }
        return n13;
    }

    private static int a(i i10, cn.sharesdk.framework.utils.QRCodeUtil.b b10, cn.sharesdk.framework.utils.QRCodeUtil.b b11, n n10) {
        int n11 = b10.a();
        int n12 = i10.a(n10);
        n11 += n12;
        n12 = b11.a();
        return n11 + n12;
    }

    public static f a(String object, cn.sharesdk.framework.utils.QRCodeUtil.f f10, Map object2) {
        Object object3;
        boolean bl2;
        Object object4;
        Enum enum_;
        int n10;
        int n11 = 1;
        int n12 = 0;
        Object object5 = null;
        if (object2 != null && (n10 = object2.containsKey(enum_ = cn.sharesdk.framework.utils.QRCodeUtil.e.b)) != 0) {
            n10 = n11;
        } else {
            n10 = 0;
            enum_ = null;
        }
        if (n10 != 0) {
            object4 = cn.sharesdk.framework.utils.QRCodeUtil.e.b;
            object4 = object2.get(object4).toString();
        } else {
            object4 = "ISO-8859-1";
        }
        i i10 = c.a((String)object, (String)object4);
        cn.sharesdk.framework.utils.QRCodeUtil.b b10 = new cn.sharesdk.framework.utils.QRCodeUtil.b();
        i i11 = i.e;
        if (i10 == i11 && n10 != 0 && (enum_ = cn.sharesdk.framework.utils.QRCodeUtil.d.a((String)object4)) != null) {
            c.a((cn.sharesdk.framework.utils.QRCodeUtil.d)enum_, b10);
        }
        if (object2 == null || (n10 = object2.containsKey(enum_ = cn.sharesdk.framework.utils.QRCodeUtil.e.l)) == 0) {
            bl2 = false;
            object3 = null;
        }
        if (bl2) {
            object3 = cn.sharesdk.framework.utils.QRCodeUtil.e.l;
            boolean bl3 = (Boolean)(object3 = Boolean.valueOf(object2.get(object3).toString()));
            if (bl3) {
                object3 = i.h;
                c.a((i)((Object)object3), b10);
            }
        }
        c.a(i10, b10);
        object3 = new cn.sharesdk.framework.utils.QRCodeUtil.b();
        c.a((String)object, i10, (cn.sharesdk.framework.utils.QRCodeUtil.b)object3, (String)object4);
        if (object2 != null && (n10 = object2.containsKey(object5 = cn.sharesdk.framework.utils.QRCodeUtil.e.k)) != 0) {
            int n13 = Integer.parseInt(object2.get(object5).toString());
            n12 = c.a(c.a(i10, b10, (cn.sharesdk.framework.utils.QRCodeUtil.b)object3, (n)(object2 = n.a(n13))), (n)object2, f10);
            if (n12 == 0) {
                object = new WriterException("Data too big for requested version");
                throw object;
            }
        } else {
            object2 = c.a(f10, i10, b10, (cn.sharesdk.framework.utils.QRCodeUtil.b)object3);
        }
        object5 = new cn.sharesdk.framework.utils.QRCodeUtil.b();
        ((cn.sharesdk.framework.utils.QRCodeUtil.b)object5).a(b10);
        int n14 = i10 == i11 ? ((cn.sharesdk.framework.utils.QRCodeUtil.b)object3).b() : ((String)object).length();
        c.a(n14, (n)object2, i10, (cn.sharesdk.framework.utils.QRCodeUtil.b)object5);
        ((cn.sharesdk.framework.utils.QRCodeUtil.b)object5).a((cn.sharesdk.framework.utils.QRCodeUtil.b)object3);
        object = ((n)object2).a(f10);
        int n15 = ((n)object2).b();
        n10 = ((n$b)object).c();
        int n16 = n15 - n10;
        c.a(n16, (cn.sharesdk.framework.utils.QRCodeUtil.b)object5);
        n10 = ((n)object2).b();
        n14 = ((n$b)object).b();
        object = c.a((cn.sharesdk.framework.utils.QRCodeUtil.b)object5, n10, n16, n14);
        object3 = new f();
        ((f)object3).a(f10);
        ((f)object3).a(i10);
        ((f)object3).a((n)object2);
        n12 = ((n)object2).c();
        enum_ = new b(n12, n12);
        n12 = c.a((cn.sharesdk.framework.utils.QRCodeUtil.b)object, f10, (n)object2, (b)enum_);
        ((f)object3).a(n12);
        e.a((cn.sharesdk.framework.utils.QRCodeUtil.b)object, f10, (n)object2, n12, (b)enum_);
        ((f)object3).a((b)enum_);
        return object3;
    }

    public static cn.sharesdk.framework.utils.QRCodeUtil.b a(cn.sharesdk.framework.utils.QRCodeUtil.b b10, int n10, int n11, int n12) {
        int n13 = n10;
        int n14 = n11;
        int n15 = n12;
        int n16 = b10.b();
        if (n16 == n11) {
            Object object;
            Object object2;
            Object object3;
            Object object4;
            Object object5;
            int n17;
            int n18;
            ArrayList<int[]> arrayList = new ArrayList<int[]>(n12);
            int n19 = 0;
            int n20 = 0;
            int n21 = 0;
            int n22 = 0;
            for (int i10 = 0; i10 < n15; ++i10) {
                n16 = 1;
                int[] nArray = new int[n16];
                int[] nArray2 = new int[n16];
                n16 = n10;
                n18 = n11;
                n17 = n12;
                object5 = i10;
                object4 = nArray;
                c.a(n10, n11, n12, i10, nArray, nArray2);
                n16 = nArray[0];
                object3 = new byte[n16];
                n17 = n20 * 8;
                object2 = b10;
                b10.a(n17, (byte[])object3, 0, n16);
                n17 = nArray2[0];
                object = c.a((byte[])object3, n17);
                object4 = new a;
                object4((byte[])object3, (byte[])object);
                arrayList.add((int[])object4);
                n21 = Math.max(n21, n16);
                n16 = ((Object)object).length;
                n22 = Math.max(n22, n16);
                n16 = nArray[0];
                n20 += n16;
            }
            if (n14 == n20) {
                int n23;
                Object object6 = new cn.sharesdk.framework.utils.QRCodeUtil.b();
                n18 = 0;
                object3 = null;
                while (true) {
                    n17 = 8;
                    if (n18 >= n21) break;
                    object2 = arrayList.iterator();
                    while ((n23 = object2.hasNext()) != 0) {
                        object4 = ((a)object2.next()).a();
                        int n24 = ((int[])object4).length;
                        if (n18 >= n24) continue;
                        n23 = object4[n18];
                        ((cn.sharesdk.framework.utils.QRCodeUtil.b)object6).a(n23, n17);
                    }
                    ++n18;
                }
                while (n19 < n22) {
                    object3 = arrayList.iterator();
                    while ((object5 = (Object)object3.hasNext()) != 0) {
                        object2 = ((a)object3.next()).b();
                        n23 = ((Object)object2).length;
                        if (n19 >= n23) continue;
                        object5 = object2[n19];
                        ((cn.sharesdk.framework.utils.QRCodeUtil.b)object6).a((int)object5, n17);
                    }
                    ++n19;
                }
                n18 = ((cn.sharesdk.framework.utils.QRCodeUtil.b)object6).b();
                if (n13 == n18) {
                    return object6;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Interleaving error: ");
                ((StringBuilder)object).append(n13);
                ((StringBuilder)object).append(" and ");
                n16 = ((cn.sharesdk.framework.utils.QRCodeUtil.b)object6).b();
                ((StringBuilder)object).append(n16);
                ((StringBuilder)object).append(" differ.");
                object6 = ((StringBuilder)object).toString();
                object3 = new WriterException((String)object6);
                throw object3;
            }
            WriterException writerException = new WriterException("Data bytes does not match offset");
            throw writerException;
        }
        WriterException writerException = new WriterException("Number of bits and data bytes does not match");
        throw writerException;
    }

    private static i a(String string2, String string3) {
        int n10;
        String string4 = "Shift_JIS";
        int n11 = string4.equals(string3);
        if (n11 != 0 && (n11 = c.a(string2)) != 0) {
            return i.g;
        }
        string3 = null;
        int n12 = 0;
        string4 = null;
        int n13 = 0;
        for (n11 = 0; n11 < (n10 = string2.length()); ++n11) {
            n10 = string2.charAt(n11);
            int n14 = 48;
            int n15 = 1;
            if (n10 >= n14 && n10 <= (n14 = 57)) {
                n13 = n15;
                continue;
            }
            n12 = c.a(n10);
            if (n12 != (n10 = -1)) {
                n12 = n15;
                continue;
            }
            return i.e;
        }
        if (n12 != 0) {
            return i.c;
        }
        if (n13 != 0) {
            return i.b;
        }
        return i.e;
    }

    private static n a(int n10, cn.sharesdk.framework.utils.QRCodeUtil.f f10) {
        int n11;
        for (int i10 = 1; i10 <= (n11 = 40); ++i10) {
            n n12 = n.a(i10);
            boolean bl2 = c.a(n10, n12, f10);
            if (!bl2) continue;
            return n12;
        }
        WriterException writerException = new WriterException("Data too big");
        throw writerException;
    }

    private static n a(cn.sharesdk.framework.utils.QRCodeUtil.f f10, i i10, cn.sharesdk.framework.utils.QRCodeUtil.b b10, cn.sharesdk.framework.utils.QRCodeUtil.b b11) {
        n n10 = n.a(1);
        n10 = c.a(c.a(i10, b10, b11, n10), f10);
        return c.a(c.a(i10, b10, b11, n10), f10);
    }

    public static void a(int n10, int n11, int n12, int n13, int[] nArray, int[] nArray2) {
        if (n13 < n12) {
            int n14;
            int n15 = n10 % n12;
            int n16 = n12 - n15;
            int n17 = n10 / n12;
            int n18 = n17 + 1;
            if ((n17 -= (n11 /= n12)) == (n18 -= (n14 = n11 + 1))) {
                int n19 = n16 + n15;
                if (n12 == n19) {
                    n12 = (n11 + n17) * n16;
                    n19 = (n14 + n18) * n15;
                    if (n10 == (n12 += n19)) {
                        n10 = 0;
                        Object var12_12 = null;
                        if (n13 < n16) {
                            nArray[0] = n11;
                            nArray2[0] = n17;
                        } else {
                            nArray[0] = n14;
                            nArray2[0] = n18;
                        }
                        return;
                    }
                    WriterException writerException = new WriterException("Total bytes mismatch");
                    throw writerException;
                }
                WriterException writerException = new WriterException("RS blocks mismatch");
                throw writerException;
            }
            WriterException writerException = new WriterException("EC bytes mismatch");
            throw writerException;
        }
        WriterException writerException = new WriterException("Block ID too large");
        throw writerException;
    }

    public static void a(int n10, cn.sharesdk.framework.utils.QRCodeUtil.b object) {
        int n11 = n10 * 8;
        int n12 = ((cn.sharesdk.framework.utils.QRCodeUtil.b)object).a();
        if (n12 <= n11) {
            int n13;
            int n14;
            n12 = 0;
            Object var4_4 = null;
            for (n14 = 0; n14 < (n13 = 4) && (n13 = ((cn.sharesdk.framework.utils.QRCodeUtil.b)object).a()) < n11; ++n14) {
                ((cn.sharesdk.framework.utils.QRCodeUtil.b)object).a(false);
            }
            n13 = 8;
            if (n14 > 0) {
                for (n14 = ((cn.sharesdk.framework.utils.QRCodeUtil.b)object).a() & 7; n14 < n13; ++n14) {
                    ((cn.sharesdk.framework.utils.QRCodeUtil.b)object).a(false);
                }
            }
            n14 = ((cn.sharesdk.framework.utils.QRCodeUtil.b)object).b();
            n10 -= n14;
            while (n12 < n10) {
                n14 = n12 & 1;
                n14 = n14 == 0 ? 236 : 17;
                ((cn.sharesdk.framework.utils.QRCodeUtil.b)object).a(n14, n13);
                ++n12;
            }
            n10 = ((cn.sharesdk.framework.utils.QRCodeUtil.b)object).a();
            if (n10 == n11) {
                return;
            }
            WriterException writerException = new WriterException("Bits size does not equal capacity");
            throw writerException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("data bits cannot fit in the QR Code");
        int n15 = ((cn.sharesdk.framework.utils.QRCodeUtil.b)object).a();
        stringBuilder.append(n15);
        stringBuilder.append(" > ");
        stringBuilder.append(n11);
        object = stringBuilder.toString();
        WriterException writerException = new WriterException((String)object);
        throw writerException;
    }

    public static void a(int n10, n object, i i10, cn.sharesdk.framework.utils.QRCodeUtil.b object2) {
        int n11 = 1;
        int n12 = i10.a((n)object);
        int n13 = n11 << n12;
        if (n10 < n13) {
            ((cn.sharesdk.framework.utils.QRCodeUtil.b)object2).a(n10, n12);
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append(" is bigger than ");
        ((StringBuilder)object2).append(n13 -= n11);
        String string2 = ((StringBuilder)object2).toString();
        object = new WriterException(string2);
        throw object;
    }

    private static void a(cn.sharesdk.framework.utils.QRCodeUtil.d d10, cn.sharesdk.framework.utils.QRCodeUtil.b b10) {
        int n10 = i.f.a();
        b10.a(n10, 4);
        int n11 = d10.a();
        b10.a(n11, 8);
    }

    public static void a(i i10, cn.sharesdk.framework.utils.QRCodeUtil.b b10) {
        int n10 = i10.a();
        b10.a(n10, 4);
    }

    public static void a(CharSequence charSequence, cn.sharesdk.framework.utils.QRCodeUtil.b b10) {
        int n10 = charSequence.length();
        int n11 = 0;
        while (n11 < n10) {
            int n12 = charSequence.charAt(n11) + -48;
            int n13 = n11 + 2;
            if (n13 < n10) {
                int n14 = n11 + 1;
                n14 = charSequence.charAt(n14) + -48;
                n13 = charSequence.charAt(n13) + -48;
                n12 *= 100;
                int n15 = 10;
                n12 = n12 + (n14 *= n15) + n13;
                b10.a(n12, n15);
                n11 += 3;
                continue;
            }
            if (++n11 < n10) {
                n11 = charSequence.charAt(n11) + -48;
                n12 = n12 * 10 + n11;
                b10.a(n12, 7);
                n11 = n13;
                continue;
            }
            n13 = 4;
            b10.a(n12, n13);
        }
    }

    /*
     * Unable to fully structure code
     */
    public static void a(String var0, cn.sharesdk.framework.utils.QRCodeUtil.b var1_2) {
        var2_3 = "Shift_JIS";
        try {
            var0 = var0.getBytes(var2_3);
        }
        catch (UnsupportedEncodingException var0_1) {
            var1_2 = new WriterException(var0_1);
            throw var1_2;
        }
        var3_4 = ((Object)var0).length % 2;
        if (var3_4 == 0) {
            var3_4 = ((Object)var0).length + -1;
            for (var4_5 = 0; var4_5 < var3_4; var4_5 += 2) {
                var5_6 = var0[var4_5] & 255;
                var6_7 = var4_5 + 1;
                var6_7 = var0[var6_7] & 255;
                var5_6 = var5_6 << 8 | var6_7;
                var6_7 = 33088;
                var7_8 = -1;
                if (var5_6 >= var6_7 && var5_6 <= (var8_9 = 40956)) lbl-1000:
                // 2 sources

                {
                    while (true) {
                        var5_6 -= var6_7;
                        break;
                    }
                } else {
                    var6_7 = 57408;
                    if (var5_6 >= var6_7 && var5_6 <= (var6_7 = 60351)) {
                        var6_7 = 49472;
                        ** continue;
                    }
                    var5_6 = var7_8;
                }
                if (var5_6 != var7_8) {
                    var6_7 = (var5_6 >> 8) * 192;
                    var5_6 = 13;
                    var1_2.a(var6_7 += (var5_6 &= 255), var5_6);
                    continue;
                }
                var0 = new WriterException("Invalid byte sequence");
                throw var0;
            }
            return;
        }
        var0 = new WriterException("Kanji byte size not even");
        throw var0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(String object, cn.sharesdk.framework.utils.QRCodeUtil.b object2, String string2) {
        try {
            object = ((String)object).getBytes(string2);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object2 = new WriterException(unsupportedEncodingException);
            throw object2;
        }
        int n10 = ((Object)object).length;
        int n11 = 0;
        while (n11 < n10) {
            Object object3 = object[n11];
            int n12 = 8;
            ((cn.sharesdk.framework.utils.QRCodeUtil.b)object2).a((int)object3, n12);
            ++n11;
        }
        return;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static void a(String object, i object2, cn.sharesdk.framework.utils.QRCodeUtil.b object3, String string2) {
        StringBuilder stringBuilder;
        int[] nArray = c$1.a;
        int n10 = ((Enum)object2).ordinal();
        int n11 = nArray[n10];
        if (n11 == (n10 = 1)) {
            c.a((CharSequence)object, (cn.sharesdk.framework.utils.QRCodeUtil.b)((Object)stringBuilder));
            return;
        }
        n10 = 2;
        if (n11 == n10) {
            c.b((CharSequence)object, (cn.sharesdk.framework.utils.QRCodeUtil.b)((Object)stringBuilder));
            return;
        }
        n10 = 3;
        if (n11 == n10) {
            void var3_4;
            c.a((String)object, (cn.sharesdk.framework.utils.QRCodeUtil.b)((Object)stringBuilder), (String)var3_4);
            return;
        }
        int n12 = 4;
        if (n11 == n12) {
            c.a((String)object, (cn.sharesdk.framework.utils.QRCodeUtil.b)((Object)stringBuilder));
            return;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid mode: ");
        stringBuilder.append(object2);
        String string3 = stringBuilder.toString();
        object = new WriterException(string3);
        throw object;
    }

    private static boolean a(int n10, n object, cn.sharesdk.framework.utils.QRCodeUtil.f f10) {
        int n11 = ((n)object).b();
        int n12 = ((n$b)(object = ((n)object).a(f10))).c();
        n10 = (n11 -= n12) >= (n10 = (n10 + 7) / 8) ? 1 : 0;
        return n10 != 0;
    }

    private static boolean a(String object) {
        String string2 = "Shift_JIS";
        try {
            object = ((String)object).getBytes(string2);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return false;
        }
        int n10 = ((Object)object).length;
        int n11 = n10 % 2;
        if (n11 != 0) {
            return false;
        }
        for (n11 = 0; n11 < n10; n11 += 2) {
            int n12 = object[n11] & 0xFF;
            int n13 = 129;
            if (n12 >= n13 && n12 <= (n13 = 159) || n12 >= (n13 = 224) && n12 <= (n13 = 235)) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static byte[] a(byte[] object, int n10) {
        int n11;
        int n12 = ((byte[])object).length;
        int n13 = n12 + n10;
        int[] nArray = new int[n13];
        int n14 = 0;
        g g10 = null;
        for (n11 = 0; n11 < n12; ++n11) {
            int n15;
            nArray[n11] = n15 = object[n11] & 0xFF;
        }
        object = new m;
        g10 = g.e;
        object(g10);
        object.a(nArray, n10);
        object = new byte[n10];
        while (n14 < n10) {
            n11 = n12 + n14;
            object[n14] = n11 = (int)((byte)nArray[n11]);
            ++n14;
        }
        return object;
    }

    public static void b(CharSequence object, cn.sharesdk.framework.utils.QRCodeUtil.b b10) {
        int n10 = object.length();
        int n11 = 0;
        while (n11 < n10) {
            int n12;
            int n13 = c.a(object.charAt(n11));
            if (n13 != (n12 = -1)) {
                int n14 = n11 + 1;
                if (n14 < n10) {
                    if ((n14 = c.a(object.charAt(n14))) != n12) {
                        n13 = n13 * 45 + n14;
                        n12 = 11;
                        b10.a(n13, n12);
                        n11 += 2;
                        continue;
                    }
                    object = new WriterException();
                    throw object;
                }
                b10.a(n13, 6);
                n11 = n14;
                continue;
            }
            object = new WriterException();
            throw object;
        }
    }
}

