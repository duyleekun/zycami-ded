/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles$DoubleArrayAsList;
import com.google.common.primitives.Doubles$DoubleConverter;
import com.google.common.primitives.Doubles$LexicographicalComparator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Doubles {
    public static final int BYTES = 8;
    public static final Pattern FLOATING_POINT_PATTERN = Doubles.fpPattern();

    private Doubles() {
    }

    public static /* synthetic */ int access$000(double[] dArray, double d10, int n10, int n11) {
        return Doubles.indexOf(dArray, d10, n10, n11);
    }

    public static /* synthetic */ int access$100(double[] dArray, double d10, int n10, int n11) {
        return Doubles.lastIndexOf(dArray, d10, n10, n11);
    }

    public static List asList(double ... dArray) {
        int n10 = dArray.length;
        if (n10 == 0) {
            return Collections.emptyList();
        }
        Doubles$DoubleArrayAsList doubles$DoubleArrayAsList = new Doubles$DoubleArrayAsList(dArray);
        return doubles$DoubleArrayAsList;
    }

    public static int compare(double d10, double d11) {
        return Double.compare(d10, d11);
    }

    public static double[] concat(double[] ... dArray) {
        int n10;
        double[] dArray2;
        int n11;
        int n12 = dArray.length;
        int n13 = 0;
        for (n11 = 0; n11 < n12; ++n11) {
            dArray2 = dArray[n11];
            n10 = dArray2.length;
            n13 += n10;
        }
        double[] dArray3 = new double[n13];
        n11 = dArray.length;
        n10 = 0;
        dArray2 = null;
        for (n13 = 0; n13 < n11; ++n13) {
            double[] dArray4 = dArray[n13];
            int n14 = dArray4.length;
            System.arraycopy(dArray4, 0, dArray3, n10, n14);
            int n15 = dArray4.length;
            n10 += n15;
        }
        return dArray3;
    }

    public static double constrainToRange(double d10, double d11, double d12) {
        Object object = d11 == d12 ? 0 : (d11 < d12 ? -1 : 1);
        object = object <= 0 ? (Object)true : (Object)false;
        Double d13 = d11;
        Double d14 = d12;
        Preconditions.checkArgument((boolean)object, "min (%s) must be less than or equal to max (%s)", (Object)d13, (Object)d14);
        return Math.min(Math.max(d10, d11), d12);
    }

    public static boolean contains(double[] dArray, double d10) {
        for (double d11 : dArray) {
            double d12 = d11 - d10;
            Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
            if (object != false) continue;
            return true;
        }
        return false;
    }

    public static double[] ensureCapacity(double[] dArray, int n10, int n11) {
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
        n12 = dArray.length;
        if (n12 < n10) {
            dArray = Arrays.copyOf(dArray, n10 += n11);
        }
        return dArray;
    }

    private static Pattern fpPattern() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)");
        charSequence.append("(?:[eE][+-]?\\d+#)?[fFdD]?");
        charSequence = charSequence.toString();
        CharSequence charSequence2 = new StringBuilder();
        charSequence2.append("0[xX]");
        charSequence2.append("(?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)");
        charSequence2.append("[pP][+-]?\\d+#[fFdD]?");
        charSequence2 = charSequence2.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[+-]?(?:NaN|Infinity|");
        stringBuilder.append((String)charSequence);
        stringBuilder.append("|");
        stringBuilder.append((String)charSequence2);
        stringBuilder.append(")");
        return Pattern.compile(stringBuilder.toString().replace("#", "+"));
    }

    public static int hashCode(double d10) {
        return Double.valueOf(d10).hashCode();
    }

    public static int indexOf(double[] dArray, double d10) {
        int n10 = dArray.length;
        return Doubles.indexOf(dArray, d10, 0, n10);
    }

    private static int indexOf(double[] dArray, double d10, int n10, int n11) {
        while (n10 < n11) {
            double d11 = dArray[n10];
            double d12 = d11 - d10;
            Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
            if (object == false) {
                return n10;
            }
            ++n10;
        }
        return -1;
    }

    public static int indexOf(double[] dArray, double[] dArray2) {
        block3: {
            Preconditions.checkNotNull(dArray, "array");
            String string2 = "target";
            Preconditions.checkNotNull(dArray2, string2);
            int n10 = dArray2.length;
            if (n10 == 0) {
                return 0;
            }
            n10 = 0;
            string2 = null;
            block0: while (true) {
                int n11 = dArray.length;
                int n12 = dArray2.length;
                if (n10 >= (n11 = n11 - n12 + 1)) break block3;
                for (n11 = 0; n11 < (n12 = dArray2.length); ++n11) {
                    n12 = n10 + n11;
                    double d10 = dArray[n12];
                    double d11 = dArray2[n11];
                    double d12 = d10 - d11;
                    if ((n12 = (int)(d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1))) == 0) continue;
                    ++n10;
                    continue block0;
                }
                break;
            }
            return n10;
        }
        return -1;
    }

    public static boolean isFinite(double d10) {
        double d11;
        int n10;
        double d12 = -1.0 / 0.0;
        double d13 = d12 - d10;
        Object object = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
        n10 = object < 0 && (n10 = (d11 = d10 - (d12 = 1.0 / 0.0)) == 0.0 ? 0 : (d11 < 0.0 ? -1 : 1)) < 0 ? 1 : 0;
        return n10 != 0;
    }

    public static String join(String string2, double ... dArray) {
        int n10;
        Preconditions.checkNotNull(string2);
        int n11 = dArray.length;
        if (n11 == 0) {
            return "";
        }
        int n12 = dArray.length * 12;
        StringBuilder stringBuilder = new StringBuilder(n12);
        double d10 = dArray[0];
        stringBuilder.append(d10);
        for (n12 = 1; n12 < (n10 = dArray.length); ++n12) {
            stringBuilder.append(string2);
            double d11 = dArray[n12];
            stringBuilder.append(d11);
        }
        return stringBuilder.toString();
    }

    public static int lastIndexOf(double[] dArray, double d10) {
        int n10 = dArray.length;
        return Doubles.lastIndexOf(dArray, d10, 0, n10);
    }

    private static int lastIndexOf(double[] dArray, double d10, int n10, int n11) {
        n11 += -1;
        while (n11 >= n10) {
            double d11 = dArray[n11];
            double d12 = d11 - d10;
            Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
            if (object == false) {
                return n11;
            }
            n11 += -1;
        }
        return -1;
    }

    public static Comparator lexicographicalComparator() {
        return Doubles$LexicographicalComparator.INSTANCE;
    }

    public static double max(double ... dArray) {
        int n10;
        int n11;
        int n12 = dArray.length;
        n12 = n12 > 0 ? n11 : 0;
        Preconditions.checkArgument(n12 != 0);
        double d10 = dArray[0];
        for (n11 = 1; n11 < (n10 = dArray.length); ++n11) {
            double d11 = dArray[n11];
            d10 = Math.max(d10, d11);
        }
        return d10;
    }

    public static double min(double ... dArray) {
        int n10;
        int n11;
        int n12 = dArray.length;
        n12 = n12 > 0 ? n11 : 0;
        Preconditions.checkArgument(n12 != 0);
        double d10 = dArray[0];
        for (n11 = 1; n11 < (n10 = dArray.length); ++n11) {
            double d11 = dArray[n11];
            d10 = Math.min(d10, d11);
        }
        return d10;
    }

    public static void reverse(double[] dArray) {
        Preconditions.checkNotNull(dArray);
        int n10 = dArray.length;
        Doubles.reverse(dArray, 0, n10);
    }

    public static void reverse(double[] dArray, int n10, int n11) {
        Preconditions.checkNotNull(dArray);
        int n12 = dArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        n11 += -1;
        while (n10 < n11) {
            double d10;
            double d11 = dArray[n10];
            dArray[n10] = d10 = dArray[n11];
            dArray[n11] = d11;
            ++n10;
            n11 += -1;
        }
    }

    public static void sortDescending(double[] dArray) {
        Preconditions.checkNotNull(dArray);
        int n10 = dArray.length;
        Doubles.sortDescending(dArray, 0, n10);
    }

    public static void sortDescending(double[] dArray, int n10, int n11) {
        Preconditions.checkNotNull(dArray);
        int n12 = dArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        Arrays.sort(dArray, n10, n11);
        Doubles.reverse(dArray, n10, n11);
    }

    public static Converter stringConverter() {
        return Doubles$DoubleConverter.INSTANCE;
    }

    public static double[] toArray(Collection objectArray) {
        int n10 = objectArray instanceof Doubles$DoubleArrayAsList;
        if (n10 != 0) {
            return ((Doubles$DoubleArrayAsList)objectArray).toDoubleArray();
        }
        objectArray = objectArray.toArray();
        n10 = objectArray.length;
        double[] dArray = new double[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10;
            Number number = (Number)Preconditions.checkNotNull(objectArray[i10]);
            dArray[i10] = d10 = number.doubleValue();
        }
        return dArray;
    }

    public static Double tryParse(String string2) {
        Matcher matcher = FLOATING_POINT_PATTERN.matcher(string2);
        boolean bl2 = matcher.matches();
        if (bl2) {
            double d10;
            try {
                d10 = Double.parseDouble(string2);
            }
            catch (NumberFormatException numberFormatException) {}
            return d10;
        }
        return null;
    }
}

