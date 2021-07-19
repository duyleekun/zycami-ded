/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UnsafeUtil;
import com.google.protobuf.Utf8;
import com.google.protobuf.Utf8$DecodeUtil;
import com.google.protobuf.Utf8$Processor;
import com.google.protobuf.Utf8$UnpairedSurrogateException;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class Utf8$UnsafeProcessor
extends Utf8$Processor {
    public static boolean isAvailable() {
        boolean bl2 = UnsafeUtil.hasUnsafeArrayOperations();
        bl2 = bl2 && (bl2 = UnsafeUtil.hasUnsafeByteBufferOperations());
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int partialIsValidUtf8(long l10, int n10) {
        int n11 = Utf8$UnsafeProcessor.unsafeEstimateConsecutiveAscii(l10, n10);
        long l11 = n11;
        l10 += l11;
        n10 -= n11;
        while (true) {
            int n12;
            long l12;
            int n13;
            block15: {
                long l13;
                n11 = 0;
                n13 = 0;
                while (true) {
                    l12 = 1L;
                    if (n10 <= 0) break block15;
                    l13 = l10 + l12;
                    n13 = UnsafeUtil.getByte(l10);
                    if (n13 < 0) break;
                    n10 += -1;
                    l10 = l13;
                }
                l10 = l13;
            }
            if (n10 == 0) {
                return 0;
            }
            n10 += -1;
            n11 = -32;
            int n14 = -65;
            int n15 = -1;
            if (n13 < n11) {
                if (n10 == 0) {
                    return n13;
                }
                n10 += -1;
                n11 = -62;
                if (n13 < n11) return n15;
                l12 += l10;
                n12 = UnsafeUtil.getByte(l10);
                if (n12 > n14) {
                    return n15;
                }
            } else {
                int n16;
                long l14;
                int n17 = -16;
                if (n13 < n17) {
                    n17 = 2;
                    if (n10 < n17) {
                        return Utf8$UnsafeProcessor.unsafeIncompleteStateFor(l10, n13, n10);
                    }
                    n10 += -2;
                    l14 = l10 + l12;
                    n12 = UnsafeUtil.getByte(l10);
                    if (n12 > n14) return n15;
                    n16 = -96;
                    if (n13 == n11) {
                        if (n12 < n16) return n15;
                    }
                    if (n13 == (n11 = -19)) {
                        if (n12 >= n16) return n15;
                    }
                    l12 += l14;
                    n12 = UnsafeUtil.getByte(l14);
                    if (n12 > n14) {
                        return n15;
                    }
                } else {
                    n11 = 3;
                    if (n10 < n11) {
                        return Utf8$UnsafeProcessor.unsafeIncompleteStateFor(l10, n13, n10);
                    }
                    n10 += -3;
                    l14 = l10 + l12;
                    n12 = UnsafeUtil.getByte(l10);
                    if (n12 > n14) return n15;
                    n16 = n13 << 28;
                    n12 += 112;
                    if ((n12 = (n16 += n12) >> 30) != 0) return n15;
                    l10 = l14 + l12;
                    n11 = UnsafeUtil.getByte(l14);
                    if (n11 > n14) return n15;
                    l12 += l10;
                    n12 = UnsafeUtil.getByte(l10);
                    if (n12 > n14) {
                        return n15;
                    }
                }
            }
            l10 = l12;
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int partialIsValidUtf8(byte[] byArray, long l10, int n10) {
        int n11 = Utf8$UnsafeProcessor.unsafeEstimateConsecutiveAscii(byArray, l10, n10);
        n10 -= n11;
        long l11 = n11;
        l10 += l11;
        while (true) {
            int n12;
            long l12;
            int n13;
            block15: {
                long l13;
                n11 = 0;
                n13 = 0;
                while (true) {
                    l12 = 1L;
                    if (n10 <= 0) break block15;
                    l13 = l10 + l12;
                    n13 = UnsafeUtil.getByte(byArray, l10);
                    if (n13 < 0) break;
                    n10 += -1;
                    l10 = l13;
                }
                l10 = l13;
            }
            if (n10 == 0) {
                return 0;
            }
            n10 += -1;
            n11 = -32;
            int n14 = -65;
            int n15 = -1;
            if (n13 < n11) {
                if (n10 == 0) {
                    return n13;
                }
                n10 += -1;
                n11 = -62;
                if (n13 < n11) return n15;
                l12 += l10;
                n12 = UnsafeUtil.getByte(byArray, l10);
                if (n12 > n14) {
                    return n15;
                }
            } else {
                int n16;
                long l14;
                int n17 = -16;
                if (n13 < n17) {
                    n17 = 2;
                    if (n10 < n17) {
                        return Utf8$UnsafeProcessor.unsafeIncompleteStateFor(byArray, n13, l10, n10);
                    }
                    n10 += -2;
                    l14 = l10 + l12;
                    n12 = UnsafeUtil.getByte(byArray, l10);
                    if (n12 > n14) return n15;
                    n16 = -96;
                    if (n13 == n11) {
                        if (n12 < n16) return n15;
                    }
                    if (n13 == (n11 = -19)) {
                        if (n12 >= n16) return n15;
                    }
                    l12 += l14;
                    n12 = UnsafeUtil.getByte(byArray, l14);
                    if (n12 > n14) {
                        return n15;
                    }
                } else {
                    n11 = 3;
                    if (n10 < n11) {
                        return Utf8$UnsafeProcessor.unsafeIncompleteStateFor(byArray, n13, l10, n10);
                    }
                    n10 += -3;
                    l14 = l10 + l12;
                    n12 = UnsafeUtil.getByte(byArray, l10);
                    if (n12 > n14) return n15;
                    n16 = n13 << 28;
                    n12 += 112;
                    if ((n12 = (n16 += n12) >> 30) != 0) return n15;
                    l10 = l14 + l12;
                    n11 = UnsafeUtil.getByte(byArray, l14);
                    if (n11 > n14) return n15;
                    l12 += l10;
                    n12 = UnsafeUtil.getByte(byArray, l10);
                    if (n12 > n14) {
                        return n15;
                    }
                }
            }
            l10 = l12;
        }
    }

    private static int unsafeEstimateConsecutiveAscii(long l10, int n10) {
        long l11;
        long l12;
        long l13;
        int n11;
        int n12 = 16;
        if (n10 < n12) {
            return 0;
        }
        n12 = (int)l10 & 7;
        int n13 = 8;
        for (n11 = n12 = 8 - n12; n11 > 0; n11 += -1) {
            long l14 = 1L + l10;
            byte by2 = UnsafeUtil.getByte(l10);
            if (by2 < 0) {
                return n12 - n11;
            }
            l10 = l14;
        }
        for (n12 = n10 - n12; n12 >= n13 && (n11 = (int)((l13 = (l12 = UnsafeUtil.getLong(l10) & 0x8080808080808080L) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) == 0; n12 += -8) {
            l12 = 8;
            l10 += l12;
        }
        return n10 - n12;
    }

    private static int unsafeEstimateConsecutiveAscii(byte[] byArray, long l10, int n10) {
        int n11 = 16;
        if (n10 < n11) {
            return 0;
        }
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = 1L + l10;
            byte by2 = UnsafeUtil.getByte(byArray, l10);
            if (by2 < 0) {
                return i10;
            }
            l10 = l11;
        }
        return n10;
    }

    private static int unsafeIncompleteStateFor(long l10, int n10, int n11) {
        if (n11 != 0) {
            int n12 = 1;
            if (n11 != n12) {
                n12 = 2;
                if (n11 == n12) {
                    n11 = UnsafeUtil.getByte(l10);
                    byte by2 = UnsafeUtil.getByte(l10 + 1L);
                    return Utf8.access$100(n10, n11, by2);
                }
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
            byte by3 = UnsafeUtil.getByte(l10);
            return Utf8.access$000(n10, by3);
        }
        return Utf8.access$1200(n10);
    }

    private static int unsafeIncompleteStateFor(byte[] object, int n10, long l10, int n11) {
        if (n11 != 0) {
            int n12 = 1;
            if (n11 != n12) {
                n12 = 2;
                if (n11 == n12) {
                    n11 = UnsafeUtil.getByte(object, l10);
                    byte by2 = UnsafeUtil.getByte(object, ++l10);
                    return Utf8.access$100(n10, n11, by2);
                }
                object = new AssertionError;
                object();
                throw object;
            }
            byte by3 = UnsafeUtil.getByte(object, l10);
            return Utf8.access$000(n10, by3);
        }
        return Utf8.access$1200(n10);
    }

    public String decodeUtf8(byte[] object, int n10, int n11) {
        int n12 = n10 | n11;
        int n13 = ((byte[])object).length - n10 - n11;
        n12 |= n13;
        n13 = 0;
        int n14 = 1;
        if (n12 >= 0) {
            long l10;
            int n15;
            int n16;
            n12 = n10 + n11;
            char[] cArray = new char[n11];
            int n17 = 0;
            Object var9_9 = null;
            while (n10 < n12 && (n16 = Utf8$DecodeUtil.access$400((byte)(n15 = UnsafeUtil.getByte(object, l10 = (long)n10)))) != 0) {
                ++n10;
                n16 = n17 + 1;
                Utf8$DecodeUtil.access$500((byte)n15, cArray, n17);
                n17 = n16;
            }
            int n18 = n17;
            while (n10 < n12) {
                int n19;
                long l11;
                long l12;
                n17 = n10 + 1;
                l10 = n10;
                n15 = (int)(Utf8$DecodeUtil.access$400((byte)(n10 = (int)UnsafeUtil.getByte(object, l10))) ? 1 : 0);
                if (n15 != 0) {
                    n15 = n18 + 1;
                    Utf8$DecodeUtil.access$500((byte)n10, cArray, n18);
                    while (n17 < n12 && (n16 = (int)(Utf8$DecodeUtil.access$400((byte)(n10 = (int)UnsafeUtil.getByte(object, l12 = (long)n17))) ? 1 : 0)) != 0) {
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
                        l12 = n17;
                        n17 = UnsafeUtil.getByte(object, l12);
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
                        l12 = n17;
                        n17 = UnsafeUtil.getByte(object, l12);
                        n16 = n15 + 1;
                        l11 = n15;
                        n15 = UnsafeUtil.getByte(object, l11);
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
                    l12 = n17;
                    n16 = UnsafeUtil.getByte(object, l12);
                    n17 = n15 + 1;
                    l11 = n15;
                    n19 = UnsafeUtil.getByte(object, l11);
                    int n20 = n17 + 1;
                    long l13 = n17;
                    byte by2 = UnsafeUtil.getByte(object, l13);
                    int n21 = n18 + 1;
                    n17 = n10;
                    n15 = n16;
                    n16 = n19;
                    n19 = by2;
                    Utf8$DecodeUtil.access$1000((byte)n10, (byte)n15, (byte)n16, by2, cArray, n18);
                    n10 = n20;
                    n18 = n21 += n14;
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String decodeUtf8Direct(ByteBuffer byteBuffer, int n10, int n11) {
        Object object;
        int n12 = n11;
        int n13 = n10 | n11;
        int n14 = byteBuffer.limit() - n10 - n11;
        n13 |= n14;
        n14 = 0;
        int n15 = 1;
        if (n13 >= 0) {
            int n16;
            long l10;
            long l11 = UnsafeUtil.addressOffset(byteBuffer);
            long l12 = n10;
            l11 += l12;
            l12 = (long)n11 + l11;
            char[] cArray = new char[n11];
            n12 = 0;
            String string2 = null;
            while (true) {
                n13 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
                l10 = 1L;
                if (n13 >= 0 || (n16 = Utf8$DecodeUtil.access$400((byte)(n13 = (int)UnsafeUtil.getByte(l11)))) == 0) break;
                l11 += l10;
                n16 = n12 + 1;
                Utf8$DecodeUtil.access$500((byte)n13, cArray, n12);
                n12 = n16;
            }
            while (true) {
                int n17;
                long l13;
                int n18;
                block8: {
                    n18 = n12;
                    while ((n12 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1))) < 0) {
                        l13 = l11 + l10;
                        n16 = UnsafeUtil.getByte(l11);
                        n17 = Utf8$DecodeUtil.access$400((byte)n16);
                        if (n17 != 0) {
                            long l14;
                            n17 = n18 + 1;
                            Utf8$DecodeUtil.access$500((byte)n16, cArray, n18);
                            while ((l14 = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1)) < 0 && (n16 = (int)(Utf8$DecodeUtil.access$400((byte)(l14 = (long)UnsafeUtil.getByte(l13))) ? 1 : 0)) != 0) {
                                l13 += l10;
                                n16 = n17 + 1;
                                Utf8$DecodeUtil.access$500((byte)l14, cArray, n17);
                                n17 = n16;
                            }
                            n18 = n17;
                            l11 = l13;
                            continue;
                        }
                        n17 = Utf8$DecodeUtil.access$600((byte)n16);
                        if (n17 != 0) {
                            n17 = (int)(l13 == l12 ? 0 : (l13 < l12 ? -1 : 1));
                            if (n17 >= 0) throw InvalidProtocolBufferException.invalidUtf8();
                            l11 = l13 + l10;
                            n12 = UnsafeUtil.getByte(l13);
                            n13 = n18 + 1;
                            Utf8$DecodeUtil.access$700((byte)n16, (byte)n12, cArray, n18);
                            n18 = n13;
                            continue;
                        }
                        n17 = (int)(Utf8$DecodeUtil.access$800((byte)n16) ? 1 : 0);
                        if (n17 != 0) {
                            l11 = l12 - l10;
                            long l15 = l13 - l11;
                            n17 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
                            if (n17 >= 0) throw InvalidProtocolBufferException.invalidUtf8();
                            l11 = l13 + l10;
                            n12 = UnsafeUtil.getByte(l13);
                            long l16 = l11 + l10;
                            n13 = UnsafeUtil.getByte(l11);
                            n17 = n18 + 1;
                            Utf8$DecodeUtil.access$900((byte)n16, (byte)n12, (byte)n13, cArray, n18);
                            n18 = n17;
                            l11 = l16;
                            continue;
                        }
                        break block8;
                    }
                    return new String(cArray, 0, n18);
                }
                l11 = l12 - (long)2;
                long l17 = l13 - l11;
                n17 = (int)(l17 == 0L ? 0 : (l17 < 0L ? -1 : 1));
                if (n17 >= 0) throw InvalidProtocolBufferException.invalidUtf8();
                l11 = l13 + l10;
                byte by2 = UnsafeUtil.getByte(l13);
                l13 = l11 + l10;
                byte by3 = UnsafeUtil.getByte(l11);
                l11 = l13 + l10;
                byte by4 = UnsafeUtil.getByte(l13);
                n12 = n18 + 1;
                Utf8$DecodeUtil.access$1000((byte)n16, by2, by3, by4, cArray, n18);
                n12 += n15;
            }
        }
        Object[] objectArray = new Object[3];
        Integer n19 = byteBuffer.limit();
        objectArray[0] = n19;
        objectArray[n15] = object = Integer.valueOf(n10);
        Integer n20 = n11;
        objectArray[2] = n20;
        object = String.format("buffer limit=%d, index=%d, limit=%d", objectArray);
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException((String)object);
        throw arrayIndexOutOfBoundsException;
    }

    /*
     * WARNING - void declaration
     */
    public int encodeUtf8(CharSequence charSequence, byte[] byArray, int n10, int n11) {
        String string2;
        String string3;
        int n12;
        int by3;
        Object object;
        Object object2;
        block9: {
            int n13;
            void var7_9;
            double d10;
            long l10;
            float f10;
            int n14;
            object2 = charSequence;
            object = byArray;
            by3 = n10;
            n12 = n11;
            long l11 = n10;
            long l12 = (long)n11 + l11;
            int n15 = charSequence.length();
            string3 = " at index ";
            string2 = "Failed writing ";
            if (n15 > n11 || (n14 = byArray.length - n11) < n10) break block9;
            boolean bl2 = false;
            while (true) {
                byte by2;
                byte by4 = 128;
                f10 = 1.794E-43f;
                l10 = 1L;
                d10 = Double.MIN_VALUE;
                if (++var7_9 >= n15 || (by2 = object2.charAt((int)var7_9)) >= by4) break;
                by4 = by2;
                UnsafeUtil.putByte((byte[])object, l11, by4);
                l11 = l10 += l11;
            }
            if (var7_9 == n15) {
                return (int)l11;
            }
            while (++n13 < n15) {
                int n16;
                block17: {
                    block18: {
                        int n17;
                        int n18;
                        block14: {
                            int n19;
                            block15: {
                                block16: {
                                    long l13;
                                    float f11;
                                    int n20;
                                    long l14;
                                    double d11;
                                    block11: {
                                        long l15;
                                        long l16;
                                        block13: {
                                            long l17;
                                            long l18;
                                            byte by5;
                                            long l19;
                                            block12: {
                                                long l20;
                                                block10: {
                                                    n16 = object2.charAt(n13);
                                                    if (n16 >= n18 || (n17 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1))) >= 0) break block10;
                                                    l16 = l11 + l10;
                                                    n16 = (byte)n16;
                                                    UnsafeUtil.putByte((byte[])object, l11, (byte)n16);
                                                    l11 = l10;
                                                    d11 = d10;
                                                    l14 = l16;
                                                    n20 = n18;
                                                    f11 = f10;
                                                    break block11;
                                                }
                                                n17 = 2048;
                                                if (n16 >= n17 || (n17 = (int)((l20 = l11 - (l16 = l12 - (long)2)) == 0L ? 0 : (l20 < 0L ? -1 : 1))) > 0) break block12;
                                                l16 = l11 + l10;
                                                n18 = (byte)(n16 >>> 6 | 0x3C0);
                                                UnsafeUtil.putByte((byte[])object, l11, (byte)n18);
                                                l19 = l16 + l10;
                                                by5 = n16 & 0x3F;
                                                n16 = 128;
                                                by5 = (byte)(by5 | n16);
                                                UnsafeUtil.putByte((byte[])object, l16, by5);
                                                l13 = l10;
                                                n20 = 128;
                                                f11 = 1.794E-43f;
                                                l14 = l19;
                                                l11 = l10;
                                                d11 = d10;
                                                break block11;
                                            }
                                            n18 = 57343;
                                            f10 = 8.0355E-41f;
                                            n17 = 55296;
                                            if (n16 >= n17 && n18 >= n16 || (l15 = (l18 = l11 - (l17 = l12 - (long)3)) == 0L ? 0 : (l18 < 0L ? -1 : 1)) > 0) break block13;
                                            l16 = l11 + l10;
                                            n18 = (byte)(n16 >>> 12 | 0x1E0);
                                            UnsafeUtil.putByte((byte[])object, l11, (byte)n18);
                                            l19 = l16 + l10;
                                            by5 = n16 >>> 6 & 0x3F;
                                            n20 = 128;
                                            by5 = (byte)(by5 | n20);
                                            UnsafeUtil.putByte((byte[])object, l16, by5);
                                            l16 = 1L;
                                            long l21 = l19 + l16;
                                            by5 = (byte)(n16 & 0x3F | n20);
                                            UnsafeUtil.putByte((byte[])object, l19, by5);
                                            l14 = l21;
                                            l11 = 1L;
                                            d11 = Double.MIN_VALUE;
                                            n20 = 128;
                                            f11 = 1.794E-43f;
                                            break block11;
                                        }
                                        d10 = 2.0E-323;
                                        l10 = l12 - (long)4;
                                        long l22 = l11 - l10;
                                        n20 = (int)(l22 == 0L ? 0 : (l22 < 0L ? -1 : 1));
                                        if (n20 > 0) break block14;
                                        n18 = n13 + true;
                                        if (n18 == n15) break block15;
                                        n13 = object2.charAt(n18);
                                        n20 = (int)(Character.isSurrogatePair((char)n16, (char)n13) ? 1 : 0);
                                        if (n20 == 0) break block16;
                                        n13 = Character.toCodePoint((char)n16, (char)n13);
                                        l10 = 1L;
                                        d10 = Double.MIN_VALUE;
                                        long l23 = l11 + l10;
                                        l15 = (byte)(n13 >>> 18 | 0xF0);
                                        UnsafeUtil.putByte((byte[])object, l11, (byte)l15);
                                        l11 = l23 + l10;
                                        l15 = n13 >>> 12 & 0x3F;
                                        n20 = 128;
                                        f11 = 1.794E-43f;
                                        byte by6 = (byte)(l15 | 0x80);
                                        UnsafeUtil.putByte((byte[])object, l23, by6);
                                        l16 = l11 + 1L;
                                        int n21 = n13 >>> 6;
                                        by6 = (byte)(n21 & 0x3F | n20);
                                        UnsafeUtil.putByte((byte[])object, l11, by6);
                                        l11 = 1L;
                                        d11 = Double.MIN_VALUE;
                                        l14 = l16 + l11;
                                        n13 = (byte)(n13 & 0x3F | n20);
                                        UnsafeUtil.putByte((byte[])object, l16, (byte)n13);
                                        n13 = n18;
                                    }
                                    n18 = n20;
                                    f10 = f11;
                                    l13 = l11;
                                    l11 = l14;
                                    l10 = l13;
                                    d10 = d11;
                                    continue;
                                }
                                n19 = n18;
                            }
                            void var7_12 = n19 + -1;
                            object2 = new Utf8$UnpairedSurrogateException((int)var7_12, n15);
                            throw object2;
                        }
                        if (n17 > n16 || n16 > n18) break block17;
                        void var45_42 = n13 + true;
                        if (var45_42 == n15) break block18;
                        char c10 = object2.charAt((int)var45_42);
                        if ((c10 = (char)(Character.isSurrogatePair((char)n16, c10) ? 1 : 0)) != '\u0000') break block17;
                    }
                    object2 = new Utf8$UnpairedSurrogateException(n13, n15);
                    throw object2;
                }
                object = new StringBuilder;
                ((StringBuilder)object)();
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append((char)n16);
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(l11);
                object = ((StringBuilder)object).toString();
                object2 = new ArrayIndexOutOfBoundsException((String)object);
                throw object2;
            }
            return (int)l11;
        }
        object = new ArrayIndexOutOfBoundsException;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        int n22 = object2.charAt(n15 += -1);
        stringBuilder.append((char)n22);
        stringBuilder.append(string3);
        n22 = by3 + n12;
        stringBuilder.append(n22);
        object2 = stringBuilder.toString();
        ((ArrayIndexOutOfBoundsException)object)((String)object2);
        throw object;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void encodeUtf8Direct(CharSequence var1_1, ByteBuffer var2_2) {
        block15: {
            var3_3 = var1_1;
            var4_4 = var2_2;
            var5_5 = UnsafeUtil.addressOffset(var2_2);
            var7_6 = var2_2.position();
            var8_7 = (long)var7_6 + var5_5;
            var10_8 = var2_2.limit();
            var11_9 = (long)var10_8 + var5_5;
            var13_10 = var1_1.length();
            var14_11 = var13_10;
            var16_12 = var11_9 - var8_7;
            var18_13 = var14_11 == var16_12 ? 0 : (var14_11 < var16_12 ? -1 : 1);
            var19_14 = " at index ";
            var20_15 = "Failed writing ";
            if (var18_13 > 0) break block15;
            var18_13 = 0;
            var21_16 = 0.0f;
            while (true) {
                var22_17 = 128;
                var23_18 = 1.794E-43f;
                var24_19 = 1L;
                if (var18_13 >= var13_10 || (var26_20 = var3_3.charAt((int)var18_13)) >= var22_17) break;
                var27_21 = var8_7 + var24_19;
                var29_22 = var26_20;
                UnsafeUtil.putByte(var8_7, var29_22);
                ++var18_13;
                var8_7 = var27_21;
            }
            if (var18_13 == var13_10) {
                var30_23 = (int)(var8_7 - var5_5);
                var4_4.position(var30_23);
                return;
            }
            while (var18_13 < var13_10) {
                block20: {
                    block21: {
                        block17: {
                            block18: {
                                block19: {
                                    block14: {
                                        block16: {
                                            var26_20 = var3_3.charAt((int)var18_13);
                                            if (var26_20 >= var22_17 || (var31_27 = var8_7 == var11_9 ? 0 : (var8_7 < var11_9 ? -1 : 1)) >= 0) break block16;
                                            var32_28 = var8_7 + var24_19;
                                            var26_20 = var26_20;
                                            UnsafeUtil.putByte(var8_7, var26_20);
                                            var34_29 = var11_9;
                                            var36_30 = (byte)var18_13;
                                            var18_13 = var22_17;
                                            var21_16 = var23_18;
                                            var8_7 = var32_28;
                                            var37_31 = var5_5;
                                            break block14;
                                        }
                                        var22_17 = 2048;
                                        var23_18 = 2.87E-42f;
                                        if (var26_20 < var22_17 && (var22_17 = (byte)((cfr_temp_0 = var8_7 - (var37_31 = var11_9 - (long)2)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) <= 0) {
                                            var37_31 = var5_5;
                                            var39_32 = var8_7 + var24_19;
                                            var41_33 /* !! */  = (byte)(var26_20 >>> 6 | 960);
                                            UnsafeUtil.putByte(var8_7, (byte)var41_33 /* !! */ );
                                            var42_34 = var39_32 + var24_19;
                                            var44_35 = var26_20 & 63;
                                            var22_17 = 128;
                                            var23_18 = 1.794E-43f;
                                            var44_35 = (byte)(var44_35 | var22_17);
                                            UnsafeUtil.putByte(var39_32, var44_35);
                                            var8_7 = var42_34;
lbl61:
                                            // 2 sources

                                            while (true) {
                                                var34_29 = var11_9;
                                                var36_30 = (byte)var18_13;
                                                var18_13 = 128;
                                                var21_16 = 1.794E-43f;
                                                break block14;
                                                break;
                                            }
                                        }
                                        var37_31 = var5_5;
                                        var36_30 = 57343;
                                        var45_36 = 55296;
                                        if ((var26_20 < var45_36 || var36_30 < var26_20) && (var41_33 /* !! */  = (cfr_temp_1 = var8_7 - (var34_29 = var11_9 - (long)3)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) <= 0) {
                                            var39_32 = var8_7 + var24_19;
                                            var41_33 /* !! */  = (byte)(var26_20 >>> 12 | 480);
                                            UnsafeUtil.putByte(var8_7, (byte)var41_33 /* !! */ );
                                            var42_34 = var39_32 + var24_19;
                                            var44_35 = var26_20 >>> 6 & 63;
                                            var22_17 = 128;
                                            var23_18 = 1.794E-43f;
                                            var44_35 = (byte)(var44_35 | var22_17);
                                            UnsafeUtil.putByte(var39_32, var44_35);
                                            var39_32 = var42_34 + var24_19;
                                            var44_35 = (byte)(var26_20 & 63 | var22_17);
                                            UnsafeUtil.putByte(var42_34, var44_35);
                                            var8_7 = var39_32;
                                            ** continue;
                                        }
                                        var34_29 = var11_9 - (long)4;
                                        cfr_temp_2 = var8_7 - var34_29;
                                        var41_33 /* !! */  = (long)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                                        if (var41_33 /* !! */  > 0) break block17;
                                        var36_30 = (byte)(var18_13 + true);
                                        if (var36_30 == var13_10) break block18;
                                        var45_36 = (byte)var3_3.charAt(var36_30);
                                        var41_33 /* !! */  = (long)Character.isSurrogatePair((char)var26_20, (char)var45_36);
                                        if (var41_33 /* !! */  == false) break block19;
                                        var45_36 = Character.toCodePoint((char)var26_20, (char)var45_36);
                                        var34_29 = var11_9;
                                        var11_9 = var8_7 + var24_19;
                                        var41_33 /* !! */  = (byte)(var45_36 >>> 18 | 240);
                                        UnsafeUtil.putByte(var8_7, (byte)var41_33 /* !! */ );
                                        var42_34 = var11_9 + var24_19;
                                        var44_35 = var45_36 >>> 12 & 63;
                                        var18_13 = 128;
                                        var21_16 = 1.794E-43f;
                                        var44_35 = (byte)(var44_35 | var18_13);
                                        UnsafeUtil.putByte(var11_9, var44_35);
                                        var46_37 = var42_34 + var24_19;
                                        var48_38 = (byte)(var45_36 >>> 6 & 63 | var18_13);
                                        UnsafeUtil.putByte(var42_34, var48_38);
                                        var42_34 = var46_37 + var24_19;
                                        var45_36 = (byte)(var45_36 & 63 | var18_13);
                                        UnsafeUtil.putByte(var46_37, var45_36);
                                        var8_7 = var42_34;
                                    }
                                    var22_17 = (byte)var18_13;
                                    var23_18 = var21_16;
                                    var5_5 = var37_31;
                                    var11_9 = var34_29;
                                    var18_13 = ++var36_30;
                                    var4_4 = var2_2;
                                    continue;
                                }
                                var18_13 = var36_30;
                            }
                            var3_3 = new Utf8$UnpairedSurrogateException((int)(var18_13 += -1), var13_10);
                            throw var3_3;
                        }
                        if (var45_36 > var26_20 || var26_20 > var36_30) break block20;
                        var36_30 = (byte)(var18_13 + true);
                        if (var36_30 == var13_10) break block21;
                        var30_24 = var3_3.charAt(var36_30);
                        if ((var30_24 = (char)Character.isSurrogatePair((char)var26_20, var30_24)) != '\u0000') break block20;
                    }
                    var3_3 = new Utf8$UnpairedSurrogateException((int)var18_13, var13_10);
                    throw var3_3;
                }
                var4_4 = new StringBuilder();
                var4_4.append(var20_15);
                var4_4.append((char)var26_20);
                var4_4.append(var19_14);
                var4_4.append(var8_7);
                var4_4 = var4_4.toString();
                var3_3 = new ArrayIndexOutOfBoundsException((String)var4_4);
                throw var3_3;
            }
            var37_31 = var5_5;
            var30_25 = (int)(var8_7 - var5_5);
            var4_4 = var2_2;
            var2_2.position(var30_25);
            return;
        }
        var50_40 = new StringBuilder();
        var50_40.append(var20_15);
        var30_26 = var1_1.charAt(var13_10 += -1);
        var50_40.append((char)var30_26);
        var50_40.append(var19_14);
        var30_26 = var2_2.limit();
        var50_40.append(var30_26);
        var3_3 = var50_40.toString();
        var49_39 = new ArrayIndexOutOfBoundsException((String)var3_3);
        throw var49_39;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public int partialIsValidUtf8(int n10, byte[] object, int n11, int n12) {
        void var4_6;
        void var3_5;
        int n13 = var3_5 | var4_6;
        int n14 = ((byte[])object).length - var4_6;
        n13 |= n14;
        n14 = 0;
        if (n13 < 0) {
            Object[] objectArray = new Object[3];
            Integer n15 = ((byte[])object).length;
            objectArray[0] = n15;
            Integer n16 = (int)var3_5;
            objectArray[1] = n16;
            n16 = (int)var4_6;
            objectArray[2] = n16;
            String string2 = String.format("Array length=%d, index=%d, limit=%d", objectArray);
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(string2);
            throw arrayIndexOutOfBoundsException;
        }
        long l10 = (long)var3_5;
        long l11 = (long)var4_6;
        if (n10 != 0) {
            n13 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
            if (n13 >= 0) {
                return n10;
            }
            n13 = (byte)n10;
            int n17 = -32;
            int n18 = -1;
            int n19 = -65;
            long l12 = 1L;
            if (n13 < n17) {
                n10 = -62;
                if (n13 < n10) return n18;
                l12 += l10;
                n10 = UnsafeUtil.getByte(object, l10);
                if (n10 > n19) {
                    return n18;
                }
                l10 = l12;
            } else {
                long l13;
                int n20 = -16;
                if (n13 < n20) {
                    if ((n10 = (int)((byte)(~(n10 >> 8)))) == 0) {
                        long l14 = l10 + l12;
                        n10 = UnsafeUtil.getByte(object, l10);
                        n14 = (int)(l14 == l11 ? 0 : (l14 < l11 ? -1 : 1));
                        if (n14 >= 0) {
                            return Utf8.access$000(n13, n10);
                        }
                        l10 = l14;
                    }
                    if (n10 > n19) return n18;
                    n14 = -96;
                    if (n13 == n17) {
                        if (n10 < n14) return n18;
                    }
                    if (n13 == (n17 = -19)) {
                        if (n10 >= n14) return n18;
                    }
                    l13 = l10 + l12;
                    n10 = UnsafeUtil.getByte(object, l10);
                    if (n10 > n19) {
                        return n18;
                    }
                } else {
                    long l15;
                    n17 = (byte)(~(n10 >> 8));
                    if (n17 == 0) {
                        l15 = l10 + l12;
                        n17 = UnsafeUtil.getByte(object, l10);
                        n10 = (int)(l15 == l11 ? 0 : (l15 < l11 ? -1 : 1));
                        if (n10 >= 0) {
                            return Utf8.access$000(n13, n17);
                        }
                        l10 = l15;
                    } else {
                        n14 = (byte)(n10 >>= 16);
                    }
                    if (n14 == 0) {
                        l15 = l10 + l12;
                        n14 = UnsafeUtil.getByte(object, l10);
                        n10 = (int)(l15 == l11 ? 0 : (l15 < l11 ? -1 : 1));
                        if (n10 >= 0) {
                            return Utf8.access$100(n13, n17, n14);
                        }
                        l10 = l15;
                    }
                    if (n17 > n19) return n18;
                    n10 = n13 << 28;
                    if ((n10 = n10 + (n17 += 112) >> 30) != 0) return n18;
                    if (n14 > n19) return n18;
                    l13 = l10 + l12;
                    n10 = UnsafeUtil.getByte(object, l10);
                    if (n10 > n19) {
                        return n18;
                    }
                }
                l10 = l13;
            }
        }
        n10 = (int)(l11 - l10);
        return Utf8$UnsafeProcessor.partialIsValidUtf8(object, l10, n10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public int partialIsValidUtf8Direct(int n10, ByteBuffer object, int n11, int n12) {
        int n13 = n11 | n12;
        int n14 = ((Buffer)object).limit() - n12;
        n13 |= n14;
        n14 = 0;
        if (n13 < 0) {
            Object[] objectArray = new Object[3];
            objectArray[0] = object = Integer.valueOf(((Buffer)object).limit());
            Integer n15 = n11;
            objectArray[1] = n15;
            n15 = n12;
            objectArray[2] = n15;
            object = String.format("buffer limit=%d, index=%d, limit=%d", objectArray);
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException((String)object);
            throw arrayIndexOutOfBoundsException;
        }
        long l10 = UnsafeUtil.addressOffset((ByteBuffer)object);
        long l11 = n11;
        long l12 = (long)(n12 -= n11) + (l10 += l11);
        if (n10 != 0) {
            n12 = (int)(l10 == l12 ? 0 : (l10 < l12 ? -1 : 1));
            if (n12 >= 0) {
                return n10;
            }
            n12 = (byte)n10;
            n13 = -32;
            int n16 = -1;
            int n17 = -65;
            long l13 = 1L;
            if (n12 < n13) {
                n10 = -62;
                if (n12 < n10) return n16;
                l13 += l10;
                n10 = UnsafeUtil.getByte(l10);
                if (n10 > n17) {
                    return n16;
                }
                l10 = l13;
            } else {
                long l14;
                int n18 = -16;
                if (n12 < n18) {
                    if ((n10 = (int)((byte)(~(n10 >> 8)))) == 0) {
                        long l15 = l10 + l13;
                        n10 = UnsafeUtil.getByte(l10);
                        n14 = (int)(l15 == l12 ? 0 : (l15 < l12 ? -1 : 1));
                        if (n14 >= 0) {
                            return Utf8.access$000(n12, n10);
                        }
                        l10 = l15;
                    }
                    if (n10 > n17) return n16;
                    n14 = -96;
                    if (n12 == n13) {
                        if (n10 < n14) return n16;
                    }
                    if (n12 == (n13 = -19)) {
                        if (n10 >= n14) return n16;
                    }
                    l14 = l10 + l13;
                    n10 = UnsafeUtil.getByte(l10);
                    if (n10 > n17) {
                        return n16;
                    }
                } else {
                    long l16;
                    n13 = (byte)(~(n10 >> 8));
                    if (n13 == 0) {
                        l16 = l10 + l13;
                        n13 = UnsafeUtil.getByte(l10);
                        n10 = (int)(l16 == l12 ? 0 : (l16 < l12 ? -1 : 1));
                        if (n10 >= 0) {
                            return Utf8.access$000(n12, n13);
                        }
                        l10 = l16;
                    } else {
                        n14 = (byte)(n10 >>= 16);
                    }
                    if (n14 == 0) {
                        l16 = l10 + l13;
                        n14 = UnsafeUtil.getByte(l10);
                        n10 = (int)(l16 == l12 ? 0 : (l16 < l12 ? -1 : 1));
                        if (n10 >= 0) {
                            return Utf8.access$100(n12, n13, n14);
                        }
                        l10 = l16;
                    }
                    if (n13 > n17) return n16;
                    n10 = n12 << 28;
                    if ((n10 = n10 + (n13 += 112) >> 30) != 0) return n16;
                    if (n14 > n17) return n16;
                    l14 = l10 + l13;
                    n10 = UnsafeUtil.getByte(l10);
                    if (n10 > n17) {
                        return n16;
                    }
                }
                l10 = l14;
            }
        }
        n10 = (int)(l12 - l10);
        return Utf8$UnsafeProcessor.partialIsValidUtf8(l10, n10);
    }
}

