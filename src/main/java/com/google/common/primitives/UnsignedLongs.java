/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.ParseRequest;
import com.google.common.primitives.UnsignedLongs$LexicographicalComparator;
import com.google.common.primitives.UnsignedLongs$ParseOverflowDetection;
import java.util.Arrays;
import java.util.Comparator;

public final class UnsignedLongs {
    public static final long MAX_VALUE = 255L;

    private UnsignedLongs() {
    }

    public static int compare(long l10, long l11) {
        l10 = UnsignedLongs.flip(l10);
        l11 = UnsignedLongs.flip(l11);
        return Longs.compare(l10, l11);
    }

    public static long decode(String string2) {
        Object object;
        ParseRequest parseRequest = ParseRequest.fromString(string2);
        try {
            object = parseRequest.rawValue;
        }
        catch (NumberFormatException numberFormatException) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error parsing value: ");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            object = new NumberFormatException(string2);
            ((Throwable)object).initCause(numberFormatException);
            throw object;
        }
        int n10 = parseRequest.radix;
        return UnsignedLongs.parseUnsignedLong((String)object, n10);
    }

    public static long divide(long l10, long l11) {
        long l12;
        long l13;
        int n10;
        long l14 = 0L;
        long l15 = l11 - l14;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object < 0) {
            int n11 = UnsignedLongs.compare(l10, l11);
            if (n11 < 0) {
                return l14;
            }
            return 1L;
        }
        Object object2 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
        if (object2 >= 0) {
            return l10 / l11;
        }
        object2 = 1;
        if ((n10 = UnsignedLongs.compare(l10 -= (l13 = (l12 = (l10 >>> object2) / l11 << object2) * l11), l11)) < 0) {
            object2 = 0;
        }
        l10 = object2;
        return l12 + l10;
    }

    private static long flip(long l10) {
        return l10 ^ Long.MIN_VALUE;
    }

    public static String join(String string2, long ... lArray) {
        int n10;
        Preconditions.checkNotNull(string2);
        int n11 = lArray.length;
        if (n11 == 0) {
            return "";
        }
        int n12 = lArray.length * 5;
        StringBuilder stringBuilder = new StringBuilder(n12);
        long l10 = lArray[0];
        String string3 = UnsignedLongs.toString(l10);
        stringBuilder.append(string3);
        for (n12 = 1; n12 < (n10 = lArray.length); ++n12) {
            stringBuilder.append(string2);
            long l11 = lArray[n12];
            String string4 = UnsignedLongs.toString(l11);
            stringBuilder.append(string4);
        }
        return stringBuilder.toString();
    }

    public static Comparator lexicographicalComparator() {
        return UnsignedLongs$LexicographicalComparator.INSTANCE;
    }

    public static long max(long ... lArray) {
        int n10;
        int n11;
        int n12 = lArray.length;
        n12 = n12 > 0 ? n11 : 0;
        Preconditions.checkArgument(n12 != 0);
        long l10 = UnsignedLongs.flip(lArray[0]);
        for (n11 = 1; n11 < (n10 = lArray.length); ++n11) {
            long l11 = UnsignedLongs.flip(lArray[n11]);
            long l12 = l11 - l10;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object <= 0) continue;
            l10 = l11;
        }
        return UnsignedLongs.flip(l10);
    }

    public static long min(long ... lArray) {
        int n10;
        int n11;
        int n12 = lArray.length;
        n12 = n12 > 0 ? n11 : 0;
        Preconditions.checkArgument(n12 != 0);
        long l10 = UnsignedLongs.flip(lArray[0]);
        for (n11 = 1; n11 < (n10 = lArray.length); ++n11) {
            long l11 = UnsignedLongs.flip(lArray[n11]);
            long l12 = l11 - l10;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object >= 0) continue;
            l10 = l11;
        }
        return UnsignedLongs.flip(l10);
    }

    public static long parseUnsignedLong(String string2) {
        return UnsignedLongs.parseUnsignedLong(string2, 10);
    }

    public static long parseUnsignedLong(String object, int n10) {
        Preconditions.checkNotNull(object);
        int n11 = ((String)object).length();
        if (n11 != 0) {
            n11 = 2;
            if (n10 >= n11 && n10 <= (n11 = 36)) {
                int n12;
                Object object2 = UnsignedLongs$ParseOverflowDetection.maxSafeDigits;
                n11 = object2[n10] + -1;
                long l10 = 0L;
                for (int i10 = 0; i10 < (n12 = ((String)object).length()); ++i10) {
                    int n13;
                    n12 = Character.digit(((String)object).charAt(i10), n10);
                    if (n12 != (n13 = -1)) {
                        if (i10 > n11 && (n13 = (int)(UnsignedLongs$ParseOverflowDetection.overflowInParse(l10, n12, n10) ? 1 : 0)) != 0) {
                            object2 = new StringBuilder;
                            ((StringBuilder)object2)();
                            ((StringBuilder)object2).append("Too large for unsigned long: ");
                            ((StringBuilder)object2).append((String)object);
                            object = ((StringBuilder)object2).toString();
                            NumberFormatException numberFormatException = new NumberFormatException((String)object);
                            throw numberFormatException;
                        }
                        long l11 = n10;
                        l10 *= l11;
                        long l12 = n12;
                        l10 += l12;
                        continue;
                    }
                    NumberFormatException numberFormatException = new NumberFormatException((String)object);
                    throw numberFormatException;
                }
                return l10;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("illegal radix: ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            object = new NumberFormatException(string2);
            throw object;
        }
        object = new NumberFormatException("empty string");
        throw object;
    }

    public static long remainder(long l10, long l11) {
        long l12;
        long l13;
        long l14 = 0L;
        long l15 = l11 - l14;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object < 0) {
            int n10 = UnsignedLongs.compare(l10, l11);
            if (n10 < 0) {
                return l10;
            }
            return l10 - l11;
        }
        object = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
        if (object >= 0) {
            return l10 % l11;
        }
        object = 1;
        if ((object = (Object)UnsignedLongs.compare(l10 -= (l13 = ((l12 = (l10 >>> object) / l11) << object) * l11), l11)) < 0) {
            l11 = l14;
        }
        return l10 - l11;
    }

    public static void sort(long[] lArray) {
        Preconditions.checkNotNull(lArray);
        int n10 = lArray.length;
        UnsignedLongs.sort(lArray, 0, n10);
    }

    public static void sort(long[] lArray, int n10, int n11) {
        Preconditions.checkNotNull(lArray);
        int n12 = lArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        for (n12 = n10; n12 < n11; ++n12) {
            long l10;
            lArray[n12] = l10 = UnsignedLongs.flip(lArray[n12]);
        }
        Arrays.sort(lArray, n10, n11);
        while (n10 < n11) {
            long l11;
            lArray[n10] = l11 = UnsignedLongs.flip(lArray[n10]);
            ++n10;
        }
    }

    public static void sortDescending(long[] lArray) {
        Preconditions.checkNotNull(lArray);
        int n10 = lArray.length;
        UnsignedLongs.sortDescending(lArray, 0, n10);
    }

    public static void sortDescending(long[] lArray, int n10, int n11) {
        long l10;
        long l11;
        Preconditions.checkNotNull(lArray);
        int n12 = lArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        n12 = n10;
        while (true) {
            l11 = Long.MAX_VALUE;
            if (n12 >= n11) break;
            l10 = lArray[n12];
            lArray[n12] = l11 ^= l10;
            ++n12;
        }
        Arrays.sort(lArray, n10, n11);
        while (n10 < n11) {
            lArray[n10] = l10 = lArray[n10] ^ l11;
            ++n10;
        }
    }

    public static String toString(long l10) {
        return UnsignedLongs.toString(l10, 10);
    }

    public static String toString(long l10, int n10) {
        int n11 = 1;
        int n12 = 2;
        n12 = n10 >= n12 && n10 <= (n12 = 36) ? n11 : 0;
        String string2 = "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX";
        Preconditions.checkArgument(n12 != 0, string2, n10);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            return "0";
        }
        if (l12 > 0) {
            return Long.toString(l10, n10);
        }
        l12 = 64;
        char[] cArray = new char[l12];
        int n13 = n10 + -1;
        int n14 = n10 & n13;
        if (n14 == 0) {
            long l13;
            n14 = Integer.numberOfTrailingZeros(n10);
            do {
                cArray[l12 += -1] = n11 = (int)Character.forDigit((int)l10 & n13, n10);
            } while ((n11 = (int)((l13 = (l10 >>>= n14) - l11) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0);
        } else {
            char c10;
            long l14;
            long l15;
            l12 = n10 & 1;
            if (l12 == false) {
                l15 = l10 >>> n11;
                n11 = n10 >>> 1;
                l14 = n11;
                l15 /= l14;
            } else {
                l15 = n10;
                l15 = UnsignedLongs.divide(l10, l15);
            }
            l14 = n10;
            long l16 = l15 * l14;
            n11 = 63;
            cArray[n11] = c10 = Character.forDigit((int)(l10 -= l16), n10);
            l12 = n11;
            while ((c10 = (char)(l15 == l11 ? 0 : (l15 < l11 ? -1 : 1))) > '\u0000') {
                l10 = l15 % l14;
                cArray[l12 += -1] = c10 = Character.forDigit((int)l10, n10);
                l15 /= l14;
            }
        }
        int n15 = 64 - l12;
        String string3 = new String(cArray, (int)l12, n15);
        return string3;
    }
}

