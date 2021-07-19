/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats$FloatArrayAsList;
import com.google.common.primitives.Floats$FloatConverter;
import com.google.common.primitives.Floats$LexicographicalComparator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;

public final class Floats {
    public static final int BYTES = 4;

    private Floats() {
    }

    public static /* synthetic */ int access$000(float[] fArray, float f10, int n10, int n11) {
        return Floats.indexOf(fArray, f10, n10, n11);
    }

    public static /* synthetic */ int access$100(float[] fArray, float f10, int n10, int n11) {
        return Floats.lastIndexOf(fArray, f10, n10, n11);
    }

    public static List asList(float ... fArray) {
        int n10 = fArray.length;
        if (n10 == 0) {
            return Collections.emptyList();
        }
        Floats$FloatArrayAsList floats$FloatArrayAsList = new Floats$FloatArrayAsList(fArray);
        return floats$FloatArrayAsList;
    }

    public static int compare(float f10, float f11) {
        return Float.compare(f10, f11);
    }

    public static float[] concat(float[] ... fArray) {
        int n10;
        float[] fArray2;
        int n11;
        int n12 = fArray.length;
        int n13 = 0;
        for (n11 = 0; n11 < n12; ++n11) {
            fArray2 = fArray[n11];
            n10 = fArray2.length;
            n13 += n10;
        }
        float[] fArray3 = new float[n13];
        n11 = fArray.length;
        n10 = 0;
        fArray2 = null;
        for (n13 = 0; n13 < n11; ++n13) {
            float[] fArray4 = fArray[n13];
            int n14 = fArray4.length;
            System.arraycopy(fArray4, 0, fArray3, n10, n14);
            int n15 = fArray4.length;
            n10 += n15;
        }
        return fArray3;
    }

    public static float constrainToRange(float f10, float f11, float f12) {
        Object object = f11 == f12 ? 0 : (f11 < f12 ? -1 : 1);
        object = object <= 0 ? (Object)true : (Object)false;
        Float f13 = Float.valueOf(f11);
        Float f14 = Float.valueOf(f12);
        Preconditions.checkArgument((boolean)object, "min (%s) must be less than or equal to max (%s)", (Object)f13, (Object)f14);
        return Math.min(Math.max(f10, f11), f12);
    }

    public static boolean contains(float[] fArray, float f10) {
        for (float f11 : fArray) {
            float f12 = f11 - f10;
            Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object != false) continue;
            return true;
        }
        return false;
    }

    public static float[] ensureCapacity(float[] fArray, int n10, int n11) {
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
        n12 = fArray.length;
        if (n12 < n10) {
            fArray = Arrays.copyOf(fArray, n10 += n11);
        }
        return fArray;
    }

    public static int hashCode(float f10) {
        return Float.valueOf(f10).hashCode();
    }

    public static int indexOf(float[] fArray, float f10) {
        int n10 = fArray.length;
        return Floats.indexOf(fArray, f10, 0, n10);
    }

    private static int indexOf(float[] fArray, float f10, int n10, int n11) {
        while (n10 < n11) {
            float f11 = fArray[n10];
            float f12 = f11 - f10;
            Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object == false) {
                return n10;
            }
            ++n10;
        }
        return -1;
    }

    public static int indexOf(float[] fArray, float[] fArray2) {
        block3: {
            Preconditions.checkNotNull(fArray, "array");
            String string2 = "target";
            Preconditions.checkNotNull(fArray2, string2);
            int n10 = fArray2.length;
            if (n10 == 0) {
                return 0;
            }
            n10 = 0;
            string2 = null;
            block0: while (true) {
                int n11 = fArray.length;
                int n12 = fArray2.length;
                if (n10 >= (n11 = n11 - n12 + 1)) break block3;
                for (n11 = 0; n11 < (n12 = fArray2.length); ++n11) {
                    n12 = n10 + n11;
                    float f10 = fArray[n12];
                    float f11 = fArray2[n11];
                    float f12 = f10 - f11;
                    if ((n12 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) == 0) continue;
                    ++n10;
                    continue block0;
                }
                break;
            }
            return n10;
        }
        return -1;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean isFinite(float f10) {
        void var3_7;
        float f11 = -1.0f / 0.0f;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object < 0) {
            int n10 = 2139095040;
            f11 = 1.0f / 0.0f;
            float f13 = f10 - f11;
            Object object2 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
            if (object2 < 0) {
                return (boolean)var3_7;
            }
        }
        boolean bl2 = false;
        return (boolean)var3_7;
    }

    public static String join(String string2, float ... fArray) {
        int n10;
        Preconditions.checkNotNull(string2);
        int n11 = fArray.length;
        if (n11 == 0) {
            return "";
        }
        int n12 = fArray.length * 12;
        StringBuilder stringBuilder = new StringBuilder(n12);
        float f10 = fArray[0];
        stringBuilder.append(f10);
        f10 = Float.MIN_VALUE;
        for (n12 = 1; n12 < (n10 = fArray.length); ++n12) {
            stringBuilder.append(string2);
            float f11 = fArray[n12];
            stringBuilder.append(f11);
        }
        return stringBuilder.toString();
    }

    public static int lastIndexOf(float[] fArray, float f10) {
        int n10 = fArray.length;
        return Floats.lastIndexOf(fArray, f10, 0, n10);
    }

    private static int lastIndexOf(float[] fArray, float f10, int n10, int n11) {
        n11 += -1;
        while (n11 >= n10) {
            float f11 = fArray[n11];
            float f12 = f11 - f10;
            Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            if (object == false) {
                return n11;
            }
            n11 += -1;
        }
        return -1;
    }

    public static Comparator lexicographicalComparator() {
        return Floats$LexicographicalComparator.INSTANCE;
    }

    public static float max(float ... fArray) {
        float f10;
        int n10 = fArray.length;
        int n11 = 0;
        float f11 = 0.0f;
        int n12 = 1;
        float f12 = Float.MIN_VALUE;
        if (n10 > 0) {
            n10 = n12;
            f10 = f12;
        } else {
            n10 = 0;
            f10 = 0.0f;
        }
        Preconditions.checkArgument(n10 != 0);
        f10 = fArray[0];
        while (n12 < (n11 = fArray.length)) {
            f11 = fArray[n12];
            f10 = Math.max(f10, f11);
            ++n12;
        }
        return f10;
    }

    public static float min(float ... fArray) {
        float f10;
        int n10 = fArray.length;
        int n11 = 0;
        float f11 = 0.0f;
        int n12 = 1;
        float f12 = Float.MIN_VALUE;
        if (n10 > 0) {
            n10 = n12;
            f10 = f12;
        } else {
            n10 = 0;
            f10 = 0.0f;
        }
        Preconditions.checkArgument(n10 != 0);
        f10 = fArray[0];
        while (n12 < (n11 = fArray.length)) {
            f11 = fArray[n12];
            f10 = Math.min(f10, f11);
            ++n12;
        }
        return f10;
    }

    public static void reverse(float[] fArray) {
        Preconditions.checkNotNull(fArray);
        int n10 = fArray.length;
        Floats.reverse(fArray, 0, n10);
    }

    public static void reverse(float[] fArray, int n10, int n11) {
        Preconditions.checkNotNull(fArray);
        int n12 = fArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        n11 += -1;
        while (n10 < n11) {
            float f10;
            float f11 = fArray[n10];
            fArray[n10] = f10 = fArray[n11];
            fArray[n11] = f11;
            ++n10;
            n11 += -1;
        }
    }

    public static void sortDescending(float[] fArray) {
        Preconditions.checkNotNull(fArray);
        int n10 = fArray.length;
        Floats.sortDescending(fArray, 0, n10);
    }

    public static void sortDescending(float[] fArray, int n10, int n11) {
        Preconditions.checkNotNull(fArray);
        int n12 = fArray.length;
        Preconditions.checkPositionIndexes(n10, n11, n12);
        Arrays.sort(fArray, n10, n11);
        Floats.reverse(fArray, n10, n11);
    }

    public static Converter stringConverter() {
        return Floats$FloatConverter.INSTANCE;
    }

    public static float[] toArray(Collection objectArray) {
        int n10 = objectArray instanceof Floats$FloatArrayAsList;
        if (n10 != 0) {
            return ((Floats$FloatArrayAsList)objectArray).toFloatArray();
        }
        objectArray = objectArray.toArray();
        n10 = objectArray.length;
        float[] fArray = new float[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10;
            Number number = (Number)Preconditions.checkNotNull(objectArray[i10]);
            fArray[i10] = f10 = number.floatValue();
        }
        return fArray;
    }

    public static Float tryParse(String string2) {
        Matcher matcher = Doubles.FLOATING_POINT_PATTERN.matcher(string2);
        boolean bl2 = matcher.matches();
        if (bl2) {
            float f10;
            try {
                f10 = Float.parseFloat(string2);
            }
            catch (NumberFormatException numberFormatException) {}
            return Float.valueOf(f10);
        }
        return null;
    }
}

