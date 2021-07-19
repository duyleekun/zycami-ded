/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Utf8;
import com.google.protobuf.Utf8$DecodeUtil;
import com.google.protobuf.Utf8$Processor;
import com.google.protobuf.Utf8$UnpairedSurrogateException;
import java.nio.ByteBuffer;

public final class Utf8$SafeProcessor
extends Utf8$Processor {
    private static int partialIsValidUtf8(byte[] byArray, int n10, int n11) {
        int n12;
        byte by2;
        while (n10 < n11 && (by2 = byArray[n10]) >= 0) {
            ++n10;
        }
        if (n10 >= n11) {
            n12 = 0;
            byArray = null;
        } else {
            n12 = Utf8$SafeProcessor.partialIsValidUtf8NonAscii(byArray, n10, n11);
        }
        return n12;
    }

    private static int partialIsValidUtf8NonAscii(byte[] byArray, int n10, int n11) {
        while (true) {
            int n12;
            block13: {
                int n13;
                block14: {
                    if (n10 >= n11) {
                        return 0;
                    }
                    n12 = n10 + 1;
                    if ((n10 = byArray[n10]) >= 0) break block13;
                    int n14 = -32;
                    n13 = -1;
                    int n15 = -65;
                    if (n10 < n14) {
                        if (n12 >= n11) {
                            return n10;
                        }
                        n14 = -62;
                        if (n10 >= n14) {
                            n10 = n12 + 1;
                            if ((n12 = byArray[n12]) <= n15) continue;
                        }
                        return n13;
                    }
                    int n16 = -16;
                    if (n10 < n16) {
                        n16 = n11 + -1;
                        if (n12 >= n16) {
                            return Utf8.access$1100(byArray, n12, n11);
                        }
                        n16 = n12 + 1;
                        if ((n12 = byArray[n12]) <= n15) {
                            int n17 = -96;
                            if (!(n10 == n14 && n12 < n17 || n10 == (n14 = -19) && n12 >= n17)) {
                                n10 = n16 + 1;
                                n12 = byArray[n16];
                                if (n12 <= n15) continue;
                            }
                        }
                        return n13;
                    }
                    n14 = n11 + -2;
                    if (n12 >= n14) {
                        return Utf8.access$1100(byArray, n12, n11);
                    }
                    n14 = n12 + 1;
                    if ((n12 = byArray[n12]) > n15) break block14;
                    n10 <<= 28;
                    if ((n10 = n10 + (n12 += 112) >> 30) != 0) break block14;
                    n10 = n14 + 1;
                    n12 = byArray[n14];
                    if (n12 > n15) break block14;
                    n12 = n10 + 1;
                    if ((n10 = byArray[n10]) <= n15) break block13;
                }
                return n13;
            }
            n10 = n12;
        }
    }

    public String decodeUtf8(byte[] object, int n10, int n11) {
        int n12 = n10 | n11;
        int n13 = ((byte[])object).length - n10 - n11;
        n12 |= n13;
        n13 = 0;
        int n14 = 1;
        if (n12 >= 0) {
            int n15;
            int n16;
            n12 = n10 + n11;
            char[] cArray = new char[n11];
            int n17 = 0;
            Object var9_9 = null;
            while (n10 < n12 && (n16 = Utf8$DecodeUtil.access$400((byte)(n15 = object[n10]))) != 0) {
                ++n10;
                n16 = n17 + 1;
                Utf8$DecodeUtil.access$500((byte)n15, cArray, n17);
                n17 = n16;
            }
            int n18 = n17;
            while (n10 < n12) {
                int n19;
                n17 = n10 + 1;
                n15 = (int)(Utf8$DecodeUtil.access$400((byte)(n10 = object[n10])) ? 1 : 0);
                if (n15 != 0) {
                    n15 = n18 + 1;
                    Utf8$DecodeUtil.access$500((byte)n10, cArray, n18);
                    while (n17 < n12 && (n16 = (int)(Utf8$DecodeUtil.access$400((byte)(n10 = object[n17])) ? 1 : 0)) != 0) {
                        ++n17;
                        n16 = n15 + 1;
                        Utf8$DecodeUtil.access$500((byte)n10, cArray, n15);
                        n15 = n16;
                    }
                    n10 = n17;
                    n18 = n15;
                    continue;
                }
                n15 = (int)(Utf8$DecodeUtil.access$600((byte)n10) ? 1 : 0);
                if (n15 != 0) {
                    if (n17 < n12) {
                        n15 = n17 + 1;
                        n17 = object[n17];
                        n16 = n18 + 1;
                        Utf8$DecodeUtil.access$700((byte)n10, (byte)n17, cArray, n18);
                        n10 = n15;
                        n18 = n16;
                        continue;
                    }
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
                n15 = (int)(Utf8$DecodeUtil.access$800((byte)n10) ? 1 : 0);
                if (n15 != 0) {
                    n15 = n12 + -1;
                    if (n17 < n15) {
                        n15 = n17 + 1;
                        n17 = object[n17];
                        n16 = n15 + 1;
                        n15 = object[n15];
                        n19 = n18 + 1;
                        Utf8$DecodeUtil.access$900((byte)n10, (byte)n17, (byte)n15, cArray, n18);
                        n10 = n16;
                        n18 = n19;
                        continue;
                    }
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
                n15 = n12 + -2;
                if (n17 < n15) {
                    n15 = n17 + 1;
                    n16 = object[n17];
                    n17 = n15 + 1;
                    n19 = object[n15];
                    int n20 = n17 + 1;
                    int n21 = object[n17];
                    int n22 = n18 + 1;
                    n17 = n10;
                    n15 = n16;
                    n16 = n19;
                    n19 = n21;
                    Utf8$DecodeUtil.access$1000((byte)n10, (byte)n15, (byte)n16, (byte)n21, cArray, n18);
                    n10 = n20;
                    n18 = n22 += n14;
                    continue;
                }
                throw InvalidProtocolBufferException.invalidUtf8();
            }
            object = new String;
            object(cArray, 0, n18);
            return object;
        }
        Object[] objectArray = new Object[3];
        object = ((byte[])object).length;
        objectArray[0] = object;
        object = n10;
        objectArray[n14] = object;
        object = n11;
        objectArray[2] = object;
        object = String.format("buffer length=%d, index=%d, size=%d", objectArray);
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException((String)object);
        throw arrayIndexOutOfBoundsException;
    }

    public String decodeUtf8Direct(ByteBuffer byteBuffer, int n10, int n11) {
        return this.decodeUtf8Default(byteBuffer, n10, n11);
    }

    /*
     * Unable to fully structure code
     */
    public int encodeUtf8(CharSequence var1_1, byte[] var2_2, int var3_3, int var4_4) {
        var5_5 = var1_1.length();
        var6_6 = 0;
        while (true) {
            var7_7 = 128;
            if (var6_6 >= var5_5 || (var8_8 = var6_6 + var3_3) >= (var4_4 += var3_3) || (var9_9 = var1_1.charAt(var6_6)) >= var7_7) break;
            var2_2[var8_8] = var7_7 = (int)((byte)var9_9);
            ++var6_6;
        }
        if (var6_6 == var5_5) {
            return var3_3 + var5_5;
        }
        var3_3 += var6_6;
        while (var6_6 < var5_5) {
            block19: {
                block20: {
                    block16: {
                        block17: {
                            block18: {
                                block14: {
                                    block15: {
                                        var8_8 = var1_1.charAt(var6_6);
                                        if (var8_8 < var7_7 && var3_3 < var4_4) {
                                            var9_9 = var3_3 + 1;
                                            var2_2[var3_3] = var8_8 = (int)((byte)var8_8);
lbl17:
                                            // 2 sources

                                            while (true) {
                                                var3_3 = var9_9;
                                                break block14;
                                                break;
                                            }
                                        }
                                        var9_9 = 2048;
                                        if (var8_8 >= var9_9 || var3_3 > (var9_9 = var4_4 + -2)) break block15;
                                        var9_9 = var3_3 + 1;
                                        var2_2[var3_3] = var10_10 = (int)((byte)(var8_8 >>> 6 | 960));
                                        var3_3 = var9_9 + 1;
                                        var8_8 = (byte)(var8_8 & 63 | var7_7);
                                        var2_2[var9_9] = var8_8;
                                        break block14;
                                    }
                                    var9_9 = 57343;
                                    var10_10 = 55296;
                                    if ((var8_8 < var10_10 || var9_9 < var8_8) && var3_3 <= (var11_11 = var4_4 + -3)) {
                                        var9_9 = var3_3 + 1;
                                        var10_10 = (byte)(var8_8 >>> 12 | 480);
                                        var2_2[var3_3] = var10_10;
                                        var3_3 = var9_9 + 1;
                                        var10_10 = (byte)(var8_8 >>> 6 & 63 | var7_7);
                                        var2_2[var9_9] = var10_10;
                                        var9_9 = var3_3 + 1;
                                        var8_8 = (byte)(var8_8 & 63 | var7_7);
                                        var2_2[var3_3] = var8_8;
                                        ** continue;
                                    }
                                    var11_11 = var4_4 + -4;
                                    if (var3_3 > var11_11) break block16;
                                    var9_9 = var6_6 + 1;
                                    var10_10 = var1_1.length();
                                    if (var9_9 == var10_10) break block17;
                                    var6_6 = var1_1.charAt(var9_9);
                                    var10_10 = (int)Character.isSurrogatePair((char)var8_8, (char)var6_6);
                                    if (var10_10 == 0) break block18;
                                    var6_6 = Character.toCodePoint((char)var8_8, (char)var6_6);
                                    var8_8 = var3_3 + 1;
                                    var10_10 = (byte)(var6_6 >>> 18 | 240);
                                    var2_2[var3_3] = var10_10;
                                    var3_3 = var8_8 + 1;
                                    var10_10 = (byte)(var6_6 >>> 12 & 63 | var7_7);
                                    var2_2[var8_8] = var10_10;
                                    var8_8 = var3_3 + 1;
                                    var10_10 = (byte)(var6_6 >>> 6 & 63 | var7_7);
                                    var2_2[var3_3] = var10_10;
                                    var3_3 = var8_8 + 1;
                                    var6_6 = (byte)(var6_6 & 63 | var7_7);
                                    var2_2[var8_8] = var6_6;
                                    var6_6 = var9_9;
                                }
                                ++var6_6;
                                continue;
                            }
                            var6_6 = var9_9;
                        }
                        var1_1 = new Utf8$UnpairedSurrogateException(var6_6 += -1, var5_5);
                        throw var1_1;
                    }
                    if (var10_10 > var8_8 || var8_8 > var9_9) break block19;
                    var12_12 = var6_6 + 1;
                    var4_4 = var1_1.length();
                    if (var12_12 == var4_4) break block20;
                    var13_13 = var1_1.charAt(var12_12);
                    if ((var13_13 = (char)Character.isSurrogatePair((char)var8_8, var13_13)) != '\u0000') break block19;
                }
                var1_1 = new Utf8$UnpairedSurrogateException(var6_6, var5_5);
                throw var1_1;
            }
            var2_2 = new StringBuilder;
            var2_2();
            var2_2.append("Failed writing ");
            var2_2.append((char)var8_8);
            var2_2.append(" at index ");
            var2_2.append(var3_3);
            var2_2 = var2_2.toString();
            var1_1 = new ArrayIndexOutOfBoundsException((String)var2_2);
            throw var1_1;
        }
        return var3_3;
    }

    public void encodeUtf8Direct(CharSequence charSequence, ByteBuffer byteBuffer) {
        this.encodeUtf8Default(charSequence, byteBuffer);
    }

    /*
     * Enabled aggressive block sorting
     */
    public int partialIsValidUtf8(int n10, byte[] byArray, int n11, int n12) {
        int n13;
        block19: {
            block17: {
                int n14;
                int n15;
                int n16;
                int n17;
                block18: {
                    block16: {
                        if (n10 == 0) return Utf8$SafeProcessor.partialIsValidUtf8(byArray, n11, n12);
                        if (n11 >= n12) {
                            return n10;
                        }
                        n17 = n10;
                        n16 = -32;
                        n13 = -1;
                        n15 = -65;
                        if (n17 >= n16) break block16;
                        n10 = -62;
                        if (n17 < n10) return n13;
                        n10 = n11 + 1;
                        if ((n11 = byArray[n11]) > n15) {
                            return n13;
                        }
                        break block17;
                    }
                    n14 = -16;
                    if (n17 >= n14) break block18;
                    if ((n10 = (int)((byte)(~(n10 >> 8)))) == 0) {
                        n10 = n11 + 1;
                        n11 = byArray[n11];
                        if (n10 >= n12) {
                            return Utf8.access$000(n17, n11);
                        }
                        int n18 = n11;
                        n11 = n10;
                        n10 = n18;
                    }
                    if (n10 > n15) return n13;
                    n14 = -96;
                    if (n17 == n16) {
                        if (n10 < n14) return n13;
                    }
                    if (n17 == (n16 = -19)) {
                        if (n10 >= n14) return n13;
                    }
                    n10 = n11 + 1;
                    if ((n11 = byArray[n11]) > n15) {
                        return n13;
                    }
                    break block17;
                }
                n16 = (byte)(~(n10 >> 8));
                n14 = 0;
                if (n16 == 0) {
                    n10 = n11 + 1;
                    n16 = byArray[n11];
                    if (n10 >= n12) {
                        return Utf8.access$000(n17, n16);
                    }
                    n11 = n10;
                } else {
                    n14 = (byte)(n10 >>= 16);
                }
                if (n14 == 0) {
                    n10 = n11 + 1;
                    n14 = byArray[n11];
                    if (n10 >= n12) {
                        return Utf8.access$100(n17, n16, n14);
                    }
                    n11 = n10;
                }
                if (n16 > n15) return n13;
                n10 = n17 << 28;
                if ((n10 = n10 + (n16 += 112) >> 30) != 0) return n13;
                if (n14 > n15) return n13;
                n10 = n11 + 1;
                if ((n11 = byArray[n11]) > n15) break block19;
            }
            n11 = n10;
            return Utf8$SafeProcessor.partialIsValidUtf8(byArray, n11, n12);
        }
        return n13;
    }

    public int partialIsValidUtf8Direct(int n10, ByteBuffer byteBuffer, int n11, int n12) {
        return this.partialIsValidUtf8Default(n10, byteBuffer, n11, n12);
    }
}

