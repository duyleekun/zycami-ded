/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Chars$CharArrayAsList;
import com.google.common.primitives.Chars$LexicographicalComparator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class Chars {
    public static final int BYTES = 2;

    private Chars() {
    }

    public static /* synthetic */ int access$000(char[] cArray, char c10, int n10, int n11) {
        return Chars.indexOf(cArray, c10, n10, n11);
    }

    public static /* synthetic */ int access$100(char[] cArray, char c10, int n10, int n11) {
        return Chars.lastIndexOf(cArray, c10, n10, n11);
    }

    public static List asList(char ... cArray) {
        int n10 = cArray.length;
        if (n10 == 0) {
            return Collections.emptyList();
        }
        Chars$CharArrayAsList chars$CharArrayAsList = new Chars$CharArrayAsList(cArray);
        return chars$CharArrayAsList;
    }

    public static char checkedCast(long l10) {
        char c10 = (char)l10;
        long l11 = c10;
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        Preconditions.checkArgument((boolean)object, "Out of range: %s", l10);
        return c10;
    }

    public static int compare(char c10, char c11) {
        return c10 - c11;
    }

    public static char[] concat(char[] ... cArray) {
        int n10;
        char[] cArray2;
        int n11;
        int n12 = cArray.length;
        int n13 = 0;
        for (n11 = 0; n11 < n12; ++n11) {
            cArray2 = cArray[n11];
            n10 = cArray2.length;
            n13 += n10;
        }
        char[] cArray3 = new char[n13];
        n11 = cArray.length;
        n10 = 0;
        cArray2 = null;
        for (n13 = 0; n13 < n11; ++n13) {
            char[] cArray4 = cArray[n13];
            int n14 = cArray4.length;
            System.arraycopy(cArray4, 0, cArray3, n10, n14);
            int n15 = cArray4.length;
            n10 += n15;
        }
        return cArray3;
    }

    public static char constrainToRange(char c10, char c11, char c12) {
        boolean bl2 = c11 <= c12;
        String string2 = "min (%s) must be less than or equal to max (%s)";
        Preconditions.checkArgument(bl2, string2, c11, c12);
        if (c10 < c11) {
            c10 = c11;
        } else if (c10 >= c12) {
            c10 = c12;
        }
        return c10;
    }

    public static boolean contains(char[] cArray, char c10) {
        for (char c11 : cArray) {
            if (c11 != c10) continue;
            return true;
        }
        return false;
    }

    public static char[] ensureCapacity(char[] cArray, int n10, int n11) {
        int n12 = 1;
        String string2 = null;
        int n13 = n10 >= 0 ? n12 : 0;
        String string3 = "Invalid minLength: %s";
        Preconditions.checkArgument(n13 != 0, string3, n10);
        if (n11 < 0) {
            n12 = 0;
        }
        string2 = "Invalid padding: %s";
        Preconditions.checkArgument(n12 != 0, string2, n11);
        n12 = cArray.length;
        if (n12 < n10) {
            cArray = Arrays.copyOf(cArray, n10 += n11);
        }
        return cArray;
    }

    public static char fromByteArray(byte[] byArray) {
        byte by2 = byArray.length;
        byte by3 = 1;
        byte by4 = 2;
        by2 = by2 >= by4 ? by3 : (byte)0;
        int n10 = byArray.length;
        Preconditions.checkArgument(by2 != 0, "array too small: %s < %s", n10, (int)by4);
        by2 = byArray[0];
        byte by5 = byArray[by3];
        return Chars.fromBytes(by2, by5);
    }

    public static char fromBytes(byte by2, byte by3) {
        by2 = (byte)(by2 << 8);
        by3 = (byte)(by3 & 0xFF);
        return (char)(by2 | by3);
    }

    public static int hashCode(char c10) {
        return c10;
    }

    public static int indexOf(char[] cArray, char c10) {
        int n10 = cArray.length;
        return Chars.indexOf(cArray, c10, 0, n10);
    }

    private static int indexOf(char[] cArray, char c10, int n10, int n11) {
        while (n10 < n11) {
            char c11 = cArray[n10];
            if (c11 == c10) {
                return n10;
            }
            ++n10;
        }
        return -1;
    }

    public static int indexOf(char[] cArray, char[] cArray2) {
        block3: {
            Preconditions.checkNotNull(cArray, "array");
            String string2 = "target";
            Preconditions.checkNotNull(cArray2, string2);
            int n10 = cArray2.length;
            if (n10 == 0) {
                return 0;
            }
            n10 = 0;
            string2 = null;
            block0: while (true) {
                int n11 = cArray.length;
                int n12 = cArray2.length;
                if (n10 >= (n11 = n11 - n12 + 1)) break block3;
                for (n11 = 0; n11 < (n12 = cArray2.length); ++n11) {
                    n12 = n10 + n11;
                    char c10 = cArray2[n11];
                    if ((n12 = cArray[n12]) == c10) continue;
                    ++n10;
                    continue block0;
                }
                break;
            }
            return n10;
        }
        return -1;
    }

    public static String join(String string2, char ... cArray) {
        Preconditions.checkNotNull(string2);
        int n10 = cArray.length;
        if (n10 == 0) {
            return "";
        }
        int n11 = string2.length();
        int c10 = n10 + -1;
        n11 = n11 * c10 + n10;
        StringBuilder stringBuilder = new StringBuilder(n11);
        n11 = cArray[0];
        stringBuilder.append((char)n11);
        for (n11 = 1; n11 < n10; ++n11) {
            stringBuilder.append(string2);
            char c11 = cArray[n11];
            stringBuilder.append(c11);
        }
        return stringBuilder.toString();
    }

    public static int lastIndexOf(char[] cArray, char c10) {
        int n10 = cArray.length;
        return Chars.lastIndexOf(cArray, c10, 0, n10);
    }

    private static int lastIndexOf(char[] cArray, char c10, int n10, int n11) {
        n11 += -1;
        while (n11 >= n10) {
            char c11 = cArray[n11];
            if (c11 == c10) {
                return n11;
            }
            n11 += -1;
        }
        return -1;
    }

    public static Comparator lexicographicalComparator() {
        return Chars$LexicographicalComparator.INSTANCE;
    }

    public static char max(char ... cArray) {
        int n10;
        int n11 = cArray.length;
        int n12 = 0;
        n11 = n11 > 0 ? n10 : 0;
        Preconditions.checkArgument(n11 != 0);
        n11 = cArray[0];
        for (n10 = 1; n10 < (n12 = cArray.length); ++n10) {
            n12 = cArray[n10];
            if (n12 <= n11) continue;
            n11 = cArray[n10];
        }
        return (char)n11;
    }

    public static char min(char ... cArray) {
        int n10;
        int n11 = cArray.length;
        int n12 = 0;
        n11 = n11 > 0 ? n10 : 0;
        Preconditions.checkArgument(n11 != 0);
        n11 = cArray[0];
        for (n10 = 1; n10 < (n12 = cArray.length); ++n10) {
            n12 = cArray[n10];
            if (n12 >= n11) continue;
            n11 = cArray[n10];
        }
        return (char)n11;
    }

    public static void reverse(char[] cArray) {
        Preconditions.checkNotNull(cArray);
        int n10 = cArray.length;
        Chars.reverse(cArray, 0, n10);
    }

    public static void reverse(char[] cArray, int n10, int n11) {
        Preconditions.checkNotNull(cArray);
        int n12 = cArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        n11 += -1;
        while (n10 < n11) {
            char c10;
            n12 = cArray[n10];
            cArray[n10] = c10 = cArray[n11];
            cArray[n11] = n12;
            ++n10;
            n11 += -1;
        }
    }

    public static char saturatedCast(long l10) {
        long l11 = (char)-1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            return (char)-1;
        }
        l11 = 0L;
        long l13 = l10 - l11;
        object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object < 0) {
            return '\u0000';
        }
        return (char)l10;
    }

    public static void sortDescending(char[] cArray) {
        Preconditions.checkNotNull(cArray);
        int n10 = cArray.length;
        Chars.sortDescending(cArray, 0, n10);
    }

    public static void sortDescending(char[] cArray, int n10, int n11) {
        Preconditions.checkNotNull(cArray);
        int n12 = cArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        Arrays.sort(cArray, n10, n11);
        Chars.reverse(cArray, n10, n11);
    }

    public static char[] toArray(Collection objectArray) {
        int n10 = objectArray instanceof Chars$CharArrayAsList;
        if (n10 != 0) {
            return ((Chars$CharArrayAsList)objectArray).toCharArray();
        }
        objectArray = objectArray.toArray();
        n10 = objectArray.length;
        char[] cArray = new char[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10;
            Character c11 = (Character)Preconditions.checkNotNull(objectArray[i10]);
            cArray[i10] = c10 = c11.charValue();
        }
        return cArray;
    }

    public static byte[] toByteArray(char c10) {
        byte by2 = (byte)(c10 >> 8);
        byte[] byArray = new byte[]{by2, c10 = (char)c10};
        return byArray;
    }
}

