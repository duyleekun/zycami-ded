/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  cn.sharesdk.framework.utils.QRCodeUtil.a.b
 */
package cn.sharesdk.framework.utils.QRCodeUtil.a;

import cn.sharesdk.framework.utils.QRCodeUtil.a.b;

public final class d {
    public static int a(b b10) {
        int n10 = d.a(b10, true);
        int n11 = d.a(b10, false);
        return n10 + n11;
    }

    private static int a(b object, boolean bl2) {
        int n10 = bl2 ? object.a() : object.b();
        int n11 = bl2 ? object.b() : object.a();
        object = object.c();
        int n12 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n13;
            Object object2 = -1;
            int n14 = 0;
            int n15 = 0;
            while (true) {
                b b10;
                b b11;
                n13 = 5;
                if (n14 >= n11) break;
                if (bl2) {
                    b11 = object[i10];
                    b10 = b11[n14];
                } else {
                    b11 = object[n14];
                    b10 = b11[i10];
                }
                if (b10 == object2) {
                    ++n15;
                } else {
                    if (n15 >= n13) {
                        n15 = n15 + -5 + 3;
                        n12 += n15;
                    }
                    n15 = 1;
                    object2 = b10;
                }
                ++n14;
            }
            if (n15 < n13) continue;
            n15 = n15 + -5 + 3;
            n12 += n15;
        }
        return n12;
    }

    /*
     * Unable to fully structure code
     */
    public static boolean a(int var0, int var1_1, int var2_2) {
        block11: {
            var3_3 = 1;
            switch (var0) {
                default: {
                    var5_5 = new StringBuilder();
                    var5_5.append("Invalid mask pattern: ");
                    var5_5.append(var0);
                    var6_6 = var5_5.toString();
                    var4_4 = new IllegalArgumentException(var6_6);
                    throw var4_4;
                }
                case 7: {
                    var0 = var2_2 * var1_1 % 3;
                    var2_2 += var1_1;
                    var1_1 = var2_2 & 1;
                    var0 += var1_1;
                    ** GOTO lbl21
                }
                case 6: {
                    var0 = (var2_2 *= var1_1) & 1;
                    var0 += (var2_2 %= 3);
lbl21:
                    // 2 sources

                    var0 &= var3_3;
                    break block11;
                }
                case 5: {
                    var0 = (var2_2 *= var1_1) & 1;
                    var0 += (var2_2 %= 3);
                    break block11;
                }
                case 4: {
                    var2_2 /= 2;
                    var1_1 /= 3;
                    ** GOTO lbl37
                }
                case 3: {
                    var0 = (var2_2 += var1_1) % 3;
                    break block11;
                }
                case 2: {
                    var0 = var1_1 % 3;
                    break block11;
                }
lbl37:
                // 2 sources

                case 0: {
                    var2_2 += var1_1;
                }
                case 1: 
            }
            var0 = var2_2 & 1;
        }
        if (var0 != 0) {
            var3_3 = 0;
        }
        return (boolean)var3_3;
    }

    private static boolean a(byte[] byArray, int n10, int n11) {
        n10 = Math.max(n10, 0);
        byte by2 = byArray.length;
        n11 = Math.min(n11, by2);
        while (true) {
            by2 = 1;
            if (n10 >= n11) break;
            byte by3 = byArray[n10];
            if (by3 == by2) {
                return false;
            }
            ++n10;
        }
        return by2 != 0;
    }

    private static boolean a(byte[][] byArray, int n10, int n11, int n12) {
        n11 = Math.max(n11, 0);
        byte by2 = byArray.length;
        n12 = Math.min(n12, by2);
        while (true) {
            by2 = 1;
            if (n11 >= n12) break;
            byte[] byArray2 = byArray[n11];
            byte by3 = byArray2[n10];
            if (by3 == by2) {
                return false;
            }
            ++n11;
        }
        return by2 != 0;
    }

    public static int b(b b10) {
        int n10;
        byte[][] byArray = b10.c();
        int n11 = b10.b();
        int n12 = b10.a();
        int n13 = 0;
        for (int i10 = 0; i10 < (n10 = n12 + -1); ++i10) {
            int n14;
            byte[] byArray2 = byArray[i10];
            int n15 = 0;
            byte[] byArray3 = null;
            while (n15 < (n14 = n11 + -1)) {
                byte[] byArray4;
                n14 = byArray2[n15];
                int n16 = n15 + 1;
                int n17 = byArray2[n16];
                if (n14 == n17 && n14 == (n15 = (byArray4 = byArray[n17 = i10 + 1])[n15]) && n14 == (n15 = (byArray3 = byArray[n17])[n16])) {
                    ++n13;
                }
                n15 = n16;
            }
        }
        return n13 * 3;
    }

    public static int c(b b10) {
        byte[][] byArray = b10.c();
        int n10 = b10.b();
        int n11 = b10.a();
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            for (int i11 = 0; i11 < n10; ++i11) {
                byte[] byArray2;
                int n13;
                int n14;
                byte[] byArray3 = byArray[i10];
                int n15 = i11 + 6;
                int n16 = 1;
                if (n15 < n10 && (n14 = byArray3[i11]) == n16) {
                    n14 = i11 + 1;
                    if ((n14 = byArray3[n14]) == 0) {
                        n14 = i11 + 2;
                        if ((n14 = byArray3[n14]) == n16) {
                            n14 = i11 + 3;
                            if ((n14 = byArray3[n14]) == n16) {
                                n14 = i11 + 4;
                                if ((n14 = byArray3[n14]) == n16) {
                                    n14 = i11 + 5;
                                    if ((n14 = byArray3[n14]) == 0 && (n15 = byArray3[n15]) == n16) {
                                        n15 = i11 + -4;
                                        if ((n15 = (int)(d.a(byArray3, n15, i11) ? 1 : 0)) != 0 || (n13 = (int)(d.a(byArray3, n15 = i11 + 7, n14 = i11 + 11) ? 1 : 0)) != 0) {
                                            ++n12;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if ((n13 = i10 + 6) >= n11 || (n15 = (byArray2 = byArray[i10])[i11]) != n16) continue;
                n15 = i10 + 1;
                byArray2 = byArray[n15];
                if ((n15 = byArray2[i11]) != 0) continue;
                n15 = i10 + 2;
                byArray2 = byArray[n15];
                if ((n15 = byArray2[i11]) != n16) continue;
                n15 = i10 + 3;
                byArray2 = byArray[n15];
                if ((n15 = byArray2[i11]) != n16) continue;
                n15 = i10 + 4;
                byArray2 = byArray[n15];
                if ((n15 = byArray2[i11]) != n16) continue;
                n15 = i10 + 5;
                byArray2 = byArray[n15];
                if ((n15 = byArray2[i11]) != 0 || (n13 = (byArray3 = byArray[n13])[i11]) != n16) continue;
                n13 = i10 + -4;
                if ((n13 = (int)(d.a(byArray, i11, n13, i10) ? 1 : 0)) == 0) {
                    n13 = i10 + 7;
                    n15 = i10 + 11;
                    if ((n13 = (int)(d.a(byArray, i11, n13, n15) ? 1 : 0)) == 0) continue;
                }
                ++n12;
            }
        }
        return n12 * 40;
    }

    public static int d(b b10) {
        byte[][] byArray = b10.c();
        int n10 = b10.b();
        int n11 = b10.a();
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            byte[] byArray2 = byArray[i10];
            for (int i11 = 0; i11 < n10; ++i11) {
                byte by2 = byArray2[i11];
                byte by3 = 1;
                if (by2 != by3) continue;
                ++n12;
            }
        }
        int n13 = b10.a();
        int n14 = b10.b();
        return Math.abs(n12 * 2 - (n13 *= n14)) * 10 / n13 * 10;
    }
}

