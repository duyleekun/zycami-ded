/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Android;
import com.google.protobuf.Utf8$Processor;
import com.google.protobuf.Utf8$SafeProcessor;
import com.google.protobuf.Utf8$UnpairedSurrogateException;
import com.google.protobuf.Utf8$UnsafeProcessor;
import java.nio.ByteBuffer;

public final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    public static final int COMPLETE = 0;
    public static final int MALFORMED = 255;
    public static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Utf8$Processor processor;

    static {
        boolean bl2 = Utf8$UnsafeProcessor.isAvailable();
        Utf8$Processor utf8$Processor = bl2 && !(bl2 = Android.isOnAndroidDevice()) ? new Utf8$UnsafeProcessor() : new Utf8$SafeProcessor();
        processor = utf8$Processor;
    }

    private Utf8() {
    }

    public static /* synthetic */ int access$000(int n10, int n11) {
        return Utf8.incompleteStateFor(n10, n11);
    }

    public static /* synthetic */ int access$100(int n10, int n11, int n12) {
        return Utf8.incompleteStateFor(n10, n11, n12);
    }

    public static /* synthetic */ int access$1100(byte[] byArray, int n10, int n11) {
        return Utf8.incompleteStateFor(byArray, n10, n11);
    }

    public static /* synthetic */ int access$1200(int n10) {
        return Utf8.incompleteStateFor(n10);
    }

    public static /* synthetic */ int access$200(ByteBuffer byteBuffer, int n10, int n11) {
        return Utf8.estimateConsecutiveAscii(byteBuffer, n10, n11);
    }

    public static /* synthetic */ int access$300(ByteBuffer byteBuffer, int n10, int n11, int n12) {
        return Utf8.incompleteStateFor(byteBuffer, n10, n11, n12);
    }

    public static String decodeUtf8(ByteBuffer byteBuffer, int n10, int n11) {
        return processor.decodeUtf8(byteBuffer, n10, n11);
    }

    public static String decodeUtf8(byte[] byArray, int n10, int n11) {
        return processor.decodeUtf8(byArray, n10, n11);
    }

    public static int encode(CharSequence charSequence, byte[] byArray, int n10, int n11) {
        return processor.encodeUtf8(charSequence, byArray, n10, n11);
    }

    public static void encodeUtf8(CharSequence charSequence, ByteBuffer byteBuffer) {
        processor.encodeUtf8(charSequence, byteBuffer);
    }

    public static int encodedLength(CharSequence object) {
        int n10;
        int n11;
        int n12;
        int n13 = object.length();
        for (n12 = 0; n12 < n13 && (n11 = (int)object.charAt(n12)) < (n10 = 128); ++n12) {
        }
        n11 = n13;
        while (n12 < n13) {
            int n14;
            n10 = object.charAt(n12);
            if (n10 < (n14 = 2048)) {
                n10 = 127 - n10 >>> 31;
                n11 += n10;
                ++n12;
                continue;
            }
            int n15 = Utf8.encodedLengthGeneral((CharSequence)object, n12);
            n11 += n15;
            break;
        }
        if (n11 >= n13) {
            return n11;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("UTF-8 length does not fit in int: ");
        long l10 = (long)n11 + 0x100000000L;
        charSequence.append(l10);
        charSequence = charSequence.toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }

    private static int encodedLengthGeneral(CharSequence object, int n10) {
        int n11 = object.length();
        int n12 = 0;
        while (n10 < n11) {
            int n13;
            int n14 = object.charAt(n10);
            if (n14 < (n13 = 2048)) {
                n14 = 127 - n14 >>> 31;
                n12 += n14;
            } else {
                n12 += 2;
                n13 = 55296;
                if (n13 <= n14 && n14 <= (n13 = 57343)) {
                    n14 = Character.codePointAt((CharSequence)object, n10);
                    if (n14 >= (n13 = 65536)) {
                        ++n10;
                    } else {
                        object = new Utf8$UnpairedSurrogateException(n10, n11);
                        throw object;
                    }
                }
            }
            ++n10;
        }
        return n12;
    }

    private static int estimateConsecutiveAscii(ByteBuffer byteBuffer, int n10, int n11) {
        long l10;
        long l11;
        long l12;
        long l13;
        int n12;
        for (n12 = n10; n12 < (n11 += -7) && (l13 = (l12 = (l11 = byteBuffer.getLong(n12) & 0x8080808080808080L) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false; n12 += 8) {
        }
        return n12 - n10;
    }

    private static int incompleteStateFor(int n10) {
        int n11 = -12;
        if (n10 > n11) {
            n10 = -1;
        }
        return n10;
    }

    private static int incompleteStateFor(int n10, int n11) {
        int n12 = -12;
        n10 = n10 <= n12 && n11 <= (n12 = -65) ? (n10 ^= (n11 <<= 8)) : -1;
        return n10;
    }

    private static int incompleteStateFor(int n10, int n11, int n12) {
        int n13 = -12;
        if (n10 <= n13 && n11 <= (n13 = -65) && n12 <= n13) {
            n10 ^= (n11 <<= 8);
            n11 = n12 << 16;
            n10 ^= n11;
        } else {
            n10 = -1;
        }
        return n10;
    }

    private static int incompleteStateFor(ByteBuffer object, int n10, int n11, int n12) {
        if (n12 != 0) {
            int n13 = 1;
            if (n12 != n13) {
                int n14 = 2;
                if (n12 == n14) {
                    n12 = ((ByteBuffer)object).get(n11);
                    byte by2 = ((ByteBuffer)object).get(n11 += n13);
                    return Utf8.incompleteStateFor(n10, n12, (int)by2);
                }
                object = new AssertionError();
                throw object;
            }
            byte by3 = ((ByteBuffer)object).get(n11);
            return Utf8.incompleteStateFor(n10, by3);
        }
        return Utf8.incompleteStateFor(n10);
    }

    private static int incompleteStateFor(byte[] object, int n10, int n11) {
        int n12 = n10 + -1;
        n12 = object[n12];
        if ((n11 -= n10) != 0) {
            int n13 = 1;
            if (n11 != n13) {
                int n14 = 2;
                if (n11 == n14) {
                    n11 = object[n10];
                    byte by2 = object[n10 += n13];
                    return Utf8.incompleteStateFor(n12, n11, (int)by2);
                }
                object = new AssertionError;
                object();
                throw object;
            }
            byte by3 = object[n10];
            return Utf8.incompleteStateFor(n12, by3);
        }
        return Utf8.incompleteStateFor(n12);
    }

    public static boolean isValidUtf8(ByteBuffer byteBuffer) {
        Utf8$Processor utf8$Processor = processor;
        int n10 = byteBuffer.position();
        int n11 = byteBuffer.remaining();
        return utf8$Processor.isValidUtf8(byteBuffer, n10, n11);
    }

    public static boolean isValidUtf8(byte[] byArray) {
        Utf8$Processor utf8$Processor = processor;
        int n10 = byArray.length;
        return utf8$Processor.isValidUtf8(byArray, 0, n10);
    }

    public static boolean isValidUtf8(byte[] byArray, int n10, int n11) {
        return processor.isValidUtf8(byArray, n10, n11);
    }

    public static int partialIsValidUtf8(int n10, ByteBuffer byteBuffer, int n11, int n12) {
        return processor.partialIsValidUtf8(n10, byteBuffer, n11, n12);
    }

    public static int partialIsValidUtf8(int n10, byte[] byArray, int n11, int n12) {
        return processor.partialIsValidUtf8(n10, byArray, n11, n12);
    }
}

