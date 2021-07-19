/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.f0;
import f.x1.l;
import f.x1.m;
import f.x1.n$a;
import f.x1.n$b;
import f.x1.n$c;
import f.x1.n$d;
import f.x1.n$e;
import f.x1.n$f;
import f.x1.n$g;
import f.x1.n$h;
import f.x1.o;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.collections.ArraysKt___ArraysKt;

public class n
extends m {
    public static final int A(int[] nArray, int n10, int n11, int n12) {
        f0.p(nArray, "$this$binarySearch");
        return Arrays.binarySearch(nArray, n11, n12, n10);
    }

    private static final int A0(long[] lArray) {
        return Arrays.hashCode(lArray);
    }

    private static final Object[] A1(Object[] objectArray) {
        int n10 = objectArray.length;
        objectArray = Arrays.copyOf(objectArray, n10);
        f0.o(objectArray, "java.util.Arrays.copyOf(this, size)");
        return objectArray;
    }

    public static final Collection A2(Object[] objectArray, Collection collection, Class clazz) {
        f0.p(objectArray, "$this$filterIsInstanceTo");
        f0.p(collection, "destination");
        String string2 = "klass";
        f0.p(clazz, string2);
        for (Object object : objectArray) {
            boolean bl2 = clazz.isInstance(object);
            if (!bl2) continue;
            collection.add(object);
        }
        return collection;
    }

    public static /* synthetic */ void A3(long[] lArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = lArray.length;
        }
        n.o3(lArray, n10, n11);
    }

    public static final int B(long[] lArray, long l10, int n10, int n11) {
        f0.p(lArray, "$this$binarySearch");
        return Arrays.binarySearch(lArray, n10, n11, l10);
    }

    private static final int B0(Object[] objectArray) {
        return Arrays.hashCode(objectArray);
    }

    private static final Object[] B1(Object[] objectArray, int n10) {
        objectArray = Arrays.copyOf(objectArray, n10);
        f0.o(objectArray, "java.util.Arrays.copyOf(this, newSize)");
        return objectArray;
    }

    public static final byte[] B2(byte[] byArray, byte by2) {
        f0.p(byArray, "$this$plus");
        int n10 = byArray.length;
        int n11 = n10 + 1;
        byArray = Arrays.copyOf(byArray, n11);
        byArray[n10] = by2;
        f0.o(byArray, "result");
        return byArray;
    }

    public static /* synthetic */ void B3(Comparable[] comparableArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = comparableArray.length;
        }
        n.q3(comparableArray, n10, n11);
    }

    public static final int C(Object[] objectArray, Object object, int n10, int n11) {
        f0.p(objectArray, "$this$binarySearch");
        return Arrays.binarySearch(objectArray, n10, n11, object);
    }

    private static final int C0(short[] sArray) {
        return Arrays.hashCode(sArray);
    }

    private static final short[] C1(short[] sArray) {
        int n10 = sArray.length;
        sArray = Arrays.copyOf(sArray, n10);
        f0.o(sArray, "java.util.Arrays.copyOf(this, size)");
        return sArray;
    }

    public static final byte[] C2(byte[] byArray, Collection object) {
        f0.p(byArray, "$this$plus");
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = byArray.length;
        int n11 = object.size() + n10;
        byArray = Arrays.copyOf(byArray, n11);
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Number number = (Number)object.next();
            n11 = number.byteValue();
            int n12 = n10 + 1;
            byArray[n10] = n11;
            n10 = n12;
        }
        f0.o(byArray, "result");
        return byArray;
    }

    public static /* synthetic */ void C3(Object[] objectArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = objectArray.length;
        }
        n.s3(objectArray, n10, n11);
    }

    public static final int D(Object[] objectArray, Object object, Comparator comparator, int n10, int n11) {
        f0.p(objectArray, "$this$binarySearch");
        f0.p(comparator, "comparator");
        return Arrays.binarySearch(objectArray, n10, n11, object, comparator);
    }

    private static final int D0(boolean[] blArray) {
        return Arrays.hashCode(blArray);
    }

    private static final short[] D1(short[] sArray, int n10) {
        sArray = Arrays.copyOf(sArray, n10);
        f0.o(sArray, "java.util.Arrays.copyOf(this, newSize)");
        return sArray;
    }

    public static final byte[] D2(byte[] byArray, byte[] byArray2) {
        f0.p(byArray, "$this$plus");
        f0.p(byArray2, "elements");
        int n10 = byArray.length;
        int n11 = byArray2.length;
        int n12 = n10 + n11;
        byArray = Arrays.copyOf(byArray, n12);
        System.arraycopy(byArray2, 0, byArray, n10, n11);
        f0.o(byArray, "result");
        return byArray;
    }

    public static /* synthetic */ void D3(short[] sArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = sArray.length;
        }
        n.u3(sArray, n10, n11);
    }

    public static final int E(short[] sArray, short s10, int n10, int n11) {
        f0.p(sArray, "$this$binarySearch");
        return Arrays.binarySearch(sArray, n10, n11, s10);
    }

    private static final /* synthetic */ String E0(byte[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    private static final boolean[] E1(boolean[] blArray) {
        int n10 = blArray.length;
        blArray = Arrays.copyOf(blArray, n10);
        f0.o(blArray, "java.util.Arrays.copyOf(this, size)");
        return blArray;
    }

    public static final char[] E2(char[] cArray, char c10) {
        f0.p(cArray, "$this$plus");
        int n10 = cArray.length;
        int n11 = n10 + 1;
        cArray = Arrays.copyOf(cArray, n11);
        cArray[n10] = c10;
        f0.o(cArray, "result");
        return cArray;
    }

    public static final void E3(Object[] objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$sortWith");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = objectArray.length;
        int n11 = 1;
        if (n10 > n11) {
            Arrays.sort(objectArray, comparator);
        }
    }

    public static /* synthetic */ int F(byte[] byArray, byte by2, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = byArray.length;
        }
        return n.w(byArray, by2, n10, n11);
    }

    private static final /* synthetic */ String F0(char[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    private static final boolean[] F1(boolean[] blArray, int n10) {
        blArray = Arrays.copyOf(blArray, n10);
        f0.o(blArray, "java.util.Arrays.copyOf(this, newSize)");
        return blArray;
    }

    public static final char[] F2(char[] cArray, Collection object) {
        f0.p(cArray, "$this$plus");
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = cArray.length;
        int n11 = object.size() + n10;
        cArray = Arrays.copyOf(cArray, n11);
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Character c10 = (Character)object.next();
            n11 = c10.charValue();
            int n12 = n10 + 1;
            cArray[n10] = n11;
            n10 = n12;
        }
        f0.o(cArray, "result");
        return cArray;
    }

    public static final void F3(Object[] objectArray, Comparator comparator, int n10, int n11) {
        f0.p(objectArray, "$this$sortWith");
        f0.p(comparator, "comparator");
        Arrays.sort(objectArray, n10, n11, comparator);
    }

    public static /* synthetic */ int G(char[] cArray, char c10, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = cArray.length;
        }
        return n.x(cArray, c10, n10, n11);
    }

    private static final /* synthetic */ String G0(double[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    public static final byte[] G1(byte[] byArray, int n10, int n11) {
        f0.p(byArray, "$this$copyOfRangeImpl");
        int n12 = byArray.length;
        l.c(n11, n12);
        byArray = Arrays.copyOfRange(byArray, n10, n11);
        f0.o(byArray, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
        return byArray;
    }

    public static final char[] G2(char[] cArray, char[] cArray2) {
        f0.p(cArray, "$this$plus");
        f0.p(cArray2, "elements");
        int n10 = cArray.length;
        int n11 = cArray2.length;
        int n12 = n10 + n11;
        cArray = Arrays.copyOf(cArray, n12);
        System.arraycopy(cArray2, 0, cArray, n10, n11);
        f0.o(cArray, "result");
        return cArray;
    }

    public static /* synthetic */ void G3(Object[] objectArray, Comparator comparator, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = objectArray.length;
        }
        n.F3(objectArray, comparator, n10, n11);
    }

    public static /* synthetic */ int H(double[] dArray, double d10, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = dArray.length;
        }
        return n.y(dArray, d10, n10, n11);
    }

    private static final /* synthetic */ String H0(float[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    public static final char[] H1(char[] cArray, int n10, int n11) {
        f0.p(cArray, "$this$copyOfRangeImpl");
        int n12 = cArray.length;
        l.c(n11, n12);
        cArray = Arrays.copyOfRange(cArray, n10, n11);
        f0.o(cArray, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
        return cArray;
    }

    public static final double[] H2(double[] dArray, double d10) {
        f0.p(dArray, "$this$plus");
        int n10 = dArray.length;
        int n11 = n10 + 1;
        dArray = Arrays.copyOf(dArray, n11);
        dArray[n10] = d10;
        f0.o(dArray, "result");
        return dArray;
    }

    private static final BigDecimal H3(byte[] byArray, f.h2.s.l l10) {
        long l11 = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(l11);
        String string2 = "BigDecimal.valueOf(this.toLong())";
        f0.o(bigDecimal, string2);
        for (byte by2 : byArray) {
            Object object = by2;
            object = (BigDecimal)l10.invoke(object);
            bigDecimal = bigDecimal.add((BigDecimal)object);
            object = "this.add(other)";
            f0.o(bigDecimal, (String)object);
        }
        return bigDecimal;
    }

    public static /* synthetic */ int I(float[] fArray, float f10, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = fArray.length;
        }
        return n.z(fArray, f10, n10, n11);
    }

    private static final /* synthetic */ String I0(int[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    public static final double[] I1(double[] dArray, int n10, int n11) {
        f0.p(dArray, "$this$copyOfRangeImpl");
        int n12 = dArray.length;
        l.c(n11, n12);
        dArray = Arrays.copyOfRange(dArray, n10, n11);
        f0.o(dArray, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
        return dArray;
    }

    public static final double[] I2(double[] dArray, Collection object) {
        f0.p(dArray, "$this$plus");
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = dArray.length;
        int n11 = object.size() + n10;
        dArray = Arrays.copyOf(dArray, n11);
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Number number = (Number)object.next();
            double d10 = number.doubleValue();
            int n12 = n10 + 1;
            dArray[n10] = d10;
            n10 = n12;
        }
        f0.o(dArray, "result");
        return dArray;
    }

    private static final BigDecimal I3(char[] cArray, f.h2.s.l l10) {
        long l11 = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(l11);
        String string2 = "BigDecimal.valueOf(this.toLong())";
        f0.o(bigDecimal, string2);
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            object = (BigDecimal)l10.invoke(object);
            bigDecimal = bigDecimal.add((BigDecimal)object);
            object = "this.add(other)";
            f0.o(bigDecimal, (String)object);
        }
        return bigDecimal;
    }

    public static /* synthetic */ int J(int[] nArray, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n11 = 0;
        }
        if ((n13 &= 4) != 0) {
            n12 = nArray.length;
        }
        return n.A(nArray, n10, n11, n12);
    }

    private static final /* synthetic */ String J0(long[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    public static final float[] J1(float[] fArray, int n10, int n11) {
        f0.p(fArray, "$this$copyOfRangeImpl");
        int n12 = fArray.length;
        l.c(n11, n12);
        fArray = Arrays.copyOfRange(fArray, n10, n11);
        f0.o(fArray, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
        return fArray;
    }

    public static final double[] J2(double[] dArray, double[] dArray2) {
        f0.p(dArray, "$this$plus");
        f0.p(dArray2, "elements");
        int n10 = dArray.length;
        int n11 = dArray2.length;
        int n12 = n10 + n11;
        dArray = Arrays.copyOf(dArray, n12);
        System.arraycopy(dArray2, 0, dArray, n10, n11);
        f0.o(dArray, "result");
        return dArray;
    }

    private static final BigDecimal J3(double[] dArray, f.h2.s.l l10) {
        long l11 = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(l11);
        String string2 = "BigDecimal.valueOf(this.toLong())";
        f0.o(bigDecimal, string2);
        for (double d10 : dArray) {
            Object object = d10;
            object = (BigDecimal)l10.invoke(object);
            bigDecimal = bigDecimal.add((BigDecimal)object);
            object = "this.add(other)";
            f0.o(bigDecimal, (String)object);
        }
        return bigDecimal;
    }

    public static /* synthetic */ int K(long[] lArray, long l10, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = lArray.length;
        }
        return n.B(lArray, l10, n10, n11);
    }

    private static final /* synthetic */ String K0(Object[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    public static final int[] K1(int[] nArray, int n10, int n11) {
        f0.p(nArray, "$this$copyOfRangeImpl");
        int n12 = nArray.length;
        l.c(n11, n12);
        nArray = Arrays.copyOfRange(nArray, n10, n11);
        f0.o(nArray, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
        return nArray;
    }

    public static final float[] K2(float[] fArray, float f10) {
        f0.p(fArray, "$this$plus");
        int n10 = fArray.length;
        int n11 = n10 + 1;
        fArray = Arrays.copyOf(fArray, n11);
        fArray[n10] = f10;
        f0.o(fArray, "result");
        return fArray;
    }

    private static final BigDecimal K3(float[] fArray, f.h2.s.l l10) {
        long l11 = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(l11);
        String string2 = "BigDecimal.valueOf(this.toLong())";
        f0.o(bigDecimal, string2);
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            object = (BigDecimal)l10.invoke(object);
            bigDecimal = bigDecimal.add((BigDecimal)object);
            object = "this.add(other)";
            f0.o(bigDecimal, (String)object);
        }
        return bigDecimal;
    }

    public static /* synthetic */ int L(Object[] objectArray, Object object, int n10, int n11, int n12, Object object2) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = objectArray.length;
        }
        return n.C(objectArray, object, n10, n11);
    }

    private static final /* synthetic */ String L0(short[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    public static final long[] L1(long[] lArray, int n10, int n11) {
        f0.p(lArray, "$this$copyOfRangeImpl");
        int n12 = lArray.length;
        l.c(n11, n12);
        lArray = Arrays.copyOfRange(lArray, n10, n11);
        f0.o(lArray, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
        return lArray;
    }

    public static final float[] L2(float[] fArray, Collection object) {
        f0.p(fArray, "$this$plus");
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = fArray.length;
        int n11 = object.size() + n10;
        fArray = Arrays.copyOf(fArray, n11);
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Number number = (Number)object.next();
            float f10 = number.floatValue();
            int n12 = n10 + 1;
            fArray[n10] = f10;
            n10 = n12;
        }
        f0.o(fArray, "result");
        return fArray;
    }

    private static final BigDecimal L3(int[] nArray, f.h2.s.l l10) {
        long l11 = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(l11);
        String string2 = "BigDecimal.valueOf(this.toLong())";
        f0.o(bigDecimal, string2);
        for (int n10 : nArray) {
            Object object = n10;
            object = (BigDecimal)l10.invoke(object);
            bigDecimal = bigDecimal.add((BigDecimal)object);
            object = "this.add(other)";
            f0.o(bigDecimal, (String)object);
        }
        return bigDecimal;
    }

    public static /* synthetic */ int M(Object[] objectArray, Object object, Comparator comparator, int n10, int n11, int n12, Object object2) {
        int n13 = n12 & 4;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 8) != 0) {
            n11 = objectArray.length;
        }
        return n.D(objectArray, object, comparator, n10, n11);
    }

    private static final /* synthetic */ String M0(boolean[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    public static final Object[] M1(Object[] objectArray, int n10, int n11) {
        f0.p(objectArray, "$this$copyOfRangeImpl");
        int n12 = objectArray.length;
        l.c(n11, n12);
        objectArray = Arrays.copyOfRange(objectArray, n10, n11);
        f0.o(objectArray, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
        return objectArray;
    }

    public static final float[] M2(float[] fArray, float[] fArray2) {
        f0.p(fArray, "$this$plus");
        f0.p(fArray2, "elements");
        int n10 = fArray.length;
        int n11 = fArray2.length;
        int n12 = n10 + n11;
        fArray = Arrays.copyOf(fArray, n12);
        System.arraycopy(fArray2, 0, fArray, n10, n11);
        f0.o(fArray, "result");
        return fArray;
    }

    private static final BigDecimal M3(long[] lArray, f.h2.s.l l10) {
        long l11 = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(l11);
        String string2 = "BigDecimal.valueOf(this.toLong())";
        f0.o(bigDecimal, string2);
        for (long l12 : lArray) {
            Object object = l12;
            object = (BigDecimal)l10.invoke(object);
            bigDecimal = bigDecimal.add((BigDecimal)object);
            object = "this.add(other)";
            f0.o(bigDecimal, (String)object);
        }
        return bigDecimal;
    }

    public static /* synthetic */ int N(short[] sArray, short s10, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = sArray.length;
        }
        return n.E(sArray, s10, n10, n11);
    }

    private static final String N0(byte[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    public static final short[] N1(short[] sArray, int n10, int n11) {
        f0.p(sArray, "$this$copyOfRangeImpl");
        int n12 = sArray.length;
        l.c(n11, n12);
        sArray = Arrays.copyOfRange(sArray, n10, n11);
        f0.o(sArray, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
        return sArray;
    }

    public static final int[] N2(int[] nArray, int n10) {
        f0.p(nArray, "$this$plus");
        int n11 = nArray.length;
        int n12 = n11 + 1;
        nArray = Arrays.copyOf(nArray, n12);
        nArray[n11] = n10;
        f0.o(nArray, "result");
        return nArray;
    }

    private static final BigDecimal N3(Object[] objectArray, f.h2.s.l l10) {
        long l11 = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(l11);
        String string2 = "BigDecimal.valueOf(this.toLong())";
        f0.o(bigDecimal, string2);
        for (Object object : objectArray) {
            object = (BigDecimal)l10.invoke(object);
            bigDecimal = bigDecimal.add((BigDecimal)object);
            object = "this.add(other)";
            f0.o(bigDecimal, (String)object);
        }
        return bigDecimal;
    }

    private static final boolean O(Object[] objectArray, Object[] objectArray2) {
        int n10 = 3;
        boolean bl2 = f.d2.l.a(1, n10, 0);
        boolean bl3 = bl2 ? m.g(objectArray, objectArray2) : Arrays.deepEquals(objectArray, objectArray2);
        return bl3;
    }

    private static final String O0(char[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    public static final boolean[] O1(boolean[] blArray, int n10, int n11) {
        f0.p(blArray, "$this$copyOfRangeImpl");
        int n12 = blArray.length;
        l.c(n11, n12);
        blArray = Arrays.copyOfRange(blArray, n10, n11);
        f0.o(blArray, "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)");
        return blArray;
    }

    public static final int[] O2(int[] nArray, Collection object) {
        f0.p(nArray, "$this$plus");
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = nArray.length;
        int n11 = object.size() + n10;
        nArray = Arrays.copyOf(nArray, n11);
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Number number = (Number)object.next();
            n11 = number.intValue();
            int n12 = n10 + 1;
            nArray[n10] = n11;
            n10 = n12;
        }
        f0.o(nArray, "result");
        return nArray;
    }

    private static final BigDecimal O3(short[] sArray, f.h2.s.l l10) {
        long l11 = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(l11);
        String string2 = "BigDecimal.valueOf(this.toLong())";
        f0.o(bigDecimal, string2);
        for (short s10 : sArray) {
            Object object = s10;
            object = (BigDecimal)l10.invoke(object);
            bigDecimal = bigDecimal.add((BigDecimal)object);
            object = "this.add(other)";
            f0.o(bigDecimal, (String)object);
        }
        return bigDecimal;
    }

    private static final boolean P(Object[] objectArray, Object[] objectArray2) {
        int n10 = 3;
        boolean bl2 = f.d2.l.a(1, n10, 0);
        if (bl2) {
            return m.g(objectArray, objectArray2);
        }
        return Arrays.deepEquals(objectArray, objectArray2);
    }

    private static final String P0(double[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    private static final byte[] P1(byte[] object, int n10, int n11) {
        block4: {
            block3: {
                int n12;
                block2: {
                    int n13 = 3;
                    n12 = f.d2.l.a(1, n13, 0);
                    if (n12 == 0) break block2;
                    object = n.G1(object, n10, n11);
                    break block3;
                }
                n12 = ((byte[])object).length;
                if (n11 > n12) break block4;
                object = Arrays.copyOfRange(object, n10, n11);
                String string2 = "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)";
                f0.o(object, string2);
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("toIndex: ");
        stringBuilder.append(n11);
        stringBuilder.append(", size: ");
        int n14 = ((byte[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    public static final int[] P2(int[] nArray, int[] nArray2) {
        f0.p(nArray, "$this$plus");
        f0.p(nArray2, "elements");
        int n10 = nArray.length;
        int n11 = nArray2.length;
        int n12 = n10 + n11;
        nArray = Arrays.copyOf(nArray, n12);
        System.arraycopy(nArray2, 0, nArray, n10, n11);
        f0.o(nArray, "result");
        return nArray;
    }

    private static final BigDecimal P3(boolean[] blArray, f.h2.s.l l10) {
        long l11 = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(l11);
        String string2 = "BigDecimal.valueOf(this.toLong())";
        f0.o(bigDecimal, string2);
        for (boolean bl2 : blArray) {
            Object object = bl2;
            object = (BigDecimal)l10.invoke(object);
            bigDecimal = bigDecimal.add((BigDecimal)object);
            object = "this.add(other)";
            f0.o(bigDecimal, (String)object);
        }
        return bigDecimal;
    }

    private static final int Q(Object[] objectArray) {
        int n10 = 3;
        boolean bl2 = f.d2.l.a(1, n10, 0);
        int n11 = bl2 ? l.b(objectArray) : Arrays.deepHashCode(objectArray);
        return n11;
    }

    private static final String Q0(float[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    private static final char[] Q1(char[] object, int n10, int n11) {
        block4: {
            block3: {
                int n12;
                block2: {
                    int n13 = 3;
                    n12 = f.d2.l.a(1, n13, 0);
                    if (n12 == 0) break block2;
                    object = n.H1(object, n10, n11);
                    break block3;
                }
                n12 = ((char[])object).length;
                if (n11 > n12) break block4;
                object = Arrays.copyOfRange(object, n10, n11);
                String string2 = "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)";
                f0.o(object, string2);
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("toIndex: ");
        stringBuilder.append(n11);
        stringBuilder.append(", size: ");
        int n14 = ((char[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    public static final long[] Q2(long[] lArray, long l10) {
        f0.p(lArray, "$this$plus");
        int n10 = lArray.length;
        int n11 = n10 + 1;
        lArray = Arrays.copyOf(lArray, n11);
        lArray[n10] = l10;
        f0.o(lArray, "result");
        return lArray;
    }

    private static final BigInteger Q3(byte[] byArray, f.h2.s.l l10) {
        long l11 = 0;
        BigInteger bigInteger = BigInteger.valueOf(l11);
        String string2 = "BigInteger.valueOf(this.toLong())";
        f0.o(bigInteger, string2);
        for (byte by2 : byArray) {
            Object object = by2;
            object = (BigInteger)l10.invoke(object);
            bigInteger = bigInteger.add((BigInteger)object);
            object = "this.add(other)";
            f0.o(bigInteger, (String)object);
        }
        return bigInteger;
    }

    private static final int R(Object[] objectArray) {
        int n10 = 3;
        boolean bl2 = f.d2.l.a(1, n10, 0);
        if (bl2) {
            return l.b(objectArray);
        }
        return Arrays.deepHashCode(objectArray);
    }

    private static final String R0(int[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    private static final double[] R1(double[] object, int n10, int n11) {
        block4: {
            block3: {
                int n12;
                block2: {
                    int n13 = 3;
                    n12 = f.d2.l.a(1, n13, 0);
                    if (n12 == 0) break block2;
                    object = n.I1(object, n10, n11);
                    break block3;
                }
                n12 = ((double[])object).length;
                if (n11 > n12) break block4;
                object = Arrays.copyOfRange(object, n10, n11);
                String string2 = "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)";
                f0.o(object, string2);
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("toIndex: ");
        stringBuilder.append(n11);
        stringBuilder.append(", size: ");
        int n14 = ((double[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    public static final long[] R2(long[] lArray, Collection object) {
        f0.p(lArray, "$this$plus");
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = lArray.length;
        int n11 = object.size() + n10;
        lArray = Arrays.copyOf(lArray, n11);
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Number number = (Number)object.next();
            long l10 = number.longValue();
            int n12 = n10 + 1;
            lArray[n10] = l10;
            n10 = n12;
        }
        f0.o(lArray, "result");
        return lArray;
    }

    private static final BigInteger R3(char[] cArray, f.h2.s.l l10) {
        long l11 = 0;
        BigInteger bigInteger = BigInteger.valueOf(l11);
        String string2 = "BigInteger.valueOf(this.toLong())";
        f0.o(bigInteger, string2);
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            object = (BigInteger)l10.invoke(object);
            bigInteger = bigInteger.add((BigInteger)object);
            object = "this.add(other)";
            f0.o(bigInteger, (String)object);
        }
        return bigInteger;
    }

    private static final String S(Object[] object) {
        int n10 = 3;
        boolean bl2 = f.d2.l.a(1, n10, 0);
        if (bl2) {
            object = m.h(object);
        } else {
            object = Arrays.deepToString(object);
            String string2 = "java.util.Arrays.deepToString(this)";
            f0.o(object, string2);
        }
        return object;
    }

    private static final String S0(long[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    private static final float[] S1(float[] object, int n10, int n11) {
        block4: {
            block3: {
                int n12;
                block2: {
                    int n13 = 3;
                    n12 = f.d2.l.a(1, n13, 0);
                    if (n12 == 0) break block2;
                    object = n.J1(object, n10, n11);
                    break block3;
                }
                n12 = ((float[])object).length;
                if (n11 > n12) break block4;
                object = Arrays.copyOfRange(object, n10, n11);
                String string2 = "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)";
                f0.o(object, string2);
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("toIndex: ");
        stringBuilder.append(n11);
        stringBuilder.append(", size: ");
        int n14 = ((float[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    public static final long[] S2(long[] lArray, long[] lArray2) {
        f0.p(lArray, "$this$plus");
        f0.p(lArray2, "elements");
        int n10 = lArray.length;
        int n11 = lArray2.length;
        int n12 = n10 + n11;
        lArray = Arrays.copyOf(lArray, n12);
        System.arraycopy(lArray2, 0, lArray, n10, n11);
        f0.o(lArray, "result");
        return lArray;
    }

    private static final BigInteger S3(double[] dArray, f.h2.s.l l10) {
        long l11 = 0;
        BigInteger bigInteger = BigInteger.valueOf(l11);
        String string2 = "BigInteger.valueOf(this.toLong())";
        f0.o(bigInteger, string2);
        for (double d10 : dArray) {
            Object object = d10;
            object = (BigInteger)l10.invoke(object);
            bigInteger = bigInteger.add((BigInteger)object);
            object = "this.add(other)";
            f0.o(bigInteger, (String)object);
        }
        return bigInteger;
    }

    private static final String T(Object[] object) {
        int n10 = 3;
        boolean bl2 = f.d2.l.a(1, n10, 0);
        if (bl2) {
            return m.h(object);
        }
        object = Arrays.deepToString(object);
        f0.o(object, "java.util.Arrays.deepToString(this)");
        return object;
    }

    private static final String T0(Object[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    private static final int[] T1(int[] object, int n10, int n11) {
        block4: {
            block3: {
                int n12;
                block2: {
                    int n13 = 3;
                    n12 = f.d2.l.a(1, n13, 0);
                    if (n12 == 0) break block2;
                    object = n.K1(object, n10, n11);
                    break block3;
                }
                n12 = ((int[])object).length;
                if (n11 > n12) break block4;
                object = Arrays.copyOfRange(object, n10, n11);
                String string2 = "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)";
                f0.o(object, string2);
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("toIndex: ");
        stringBuilder.append(n11);
        stringBuilder.append(", size: ");
        int n14 = ((int[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    public static final Object[] T2(Object[] objectArray, Object object) {
        f0.p(objectArray, "$this$plus");
        int n10 = objectArray.length;
        int n11 = n10 + 1;
        objectArray = Arrays.copyOf(objectArray, n11);
        objectArray[n10] = object;
        f0.o(objectArray, "result");
        return objectArray;
    }

    private static final BigInteger T3(float[] fArray, f.h2.s.l l10) {
        long l11 = 0;
        BigInteger bigInteger = BigInteger.valueOf(l11);
        String string2 = "BigInteger.valueOf(this.toLong())";
        f0.o(bigInteger, string2);
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            object = (BigInteger)l10.invoke(object);
            bigInteger = bigInteger.add((BigInteger)object);
            object = "this.add(other)";
            f0.o(bigInteger, (String)object);
        }
        return bigInteger;
    }

    private static final /* synthetic */ boolean U(byte[] byArray, byte[] byArray2) {
        return Arrays.equals(byArray, byArray2);
    }

    private static final String U0(short[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    private static final long[] U1(long[] object, int n10, int n11) {
        block4: {
            block3: {
                int n12;
                block2: {
                    int n13 = 3;
                    n12 = f.d2.l.a(1, n13, 0);
                    if (n12 == 0) break block2;
                    object = n.L1(object, n10, n11);
                    break block3;
                }
                n12 = ((long[])object).length;
                if (n11 > n12) break block4;
                object = Arrays.copyOfRange(object, n10, n11);
                String string2 = "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)";
                f0.o(object, string2);
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("toIndex: ");
        stringBuilder.append(n11);
        stringBuilder.append(", size: ");
        int n14 = ((long[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    public static final Object[] U2(Object[] objectArray, Collection object) {
        f0.p(objectArray, "$this$plus");
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = objectArray.length;
        int n11 = object.size() + n10;
        objectArray = Arrays.copyOf(objectArray, n11);
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object e10 = object.next();
            int n12 = n10 + 1;
            objectArray[n10] = e10;
            n10 = n12;
        }
        f0.o(objectArray, "result");
        return objectArray;
    }

    private static final BigInteger U3(int[] nArray, f.h2.s.l l10) {
        long l11 = 0;
        BigInteger bigInteger = BigInteger.valueOf(l11);
        String string2 = "BigInteger.valueOf(this.toLong())";
        f0.o(bigInteger, string2);
        for (int n10 : nArray) {
            Object object = n10;
            object = (BigInteger)l10.invoke(object);
            bigInteger = bigInteger.add((BigInteger)object);
            object = "this.add(other)";
            f0.o(bigInteger, (String)object);
        }
        return bigInteger;
    }

    private static final /* synthetic */ boolean V(char[] cArray, char[] cArray2) {
        return Arrays.equals(cArray, cArray2);
    }

    private static final String V0(boolean[] object) {
        object = Arrays.toString(object);
        f0.o(object, "java.util.Arrays.toString(this)");
        return object;
    }

    private static final Object[] V1(Object[] object, int n10, int n11) {
        block4: {
            block3: {
                int n12;
                block2: {
                    int n13 = 3;
                    n12 = f.d2.l.a(1, n13, 0);
                    if (n12 == 0) break block2;
                    object = n.M1(object, n10, n11);
                    break block3;
                }
                n12 = ((Object[])object).length;
                if (n11 > n12) break block4;
                object = Arrays.copyOfRange(object, n10, n11);
                String string2 = "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)";
                f0.o(object, string2);
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("toIndex: ");
        stringBuilder.append(n11);
        stringBuilder.append(", size: ");
        int n14 = ((Object[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    public static final Object[] V2(Object[] objectArray, Object[] objectArray2) {
        f0.p(objectArray, "$this$plus");
        f0.p(objectArray2, "elements");
        int n10 = objectArray.length;
        int n11 = objectArray2.length;
        int n12 = n10 + n11;
        objectArray = Arrays.copyOf(objectArray, n12);
        System.arraycopy(objectArray2, 0, objectArray, n10, n11);
        f0.o(objectArray, "result");
        return objectArray;
    }

    private static final BigInteger V3(long[] lArray, f.h2.s.l l10) {
        long l11 = 0;
        BigInteger bigInteger = BigInteger.valueOf(l11);
        String string2 = "BigInteger.valueOf(this.toLong())";
        f0.o(bigInteger, string2);
        for (long l12 : lArray) {
            Object object = l12;
            object = (BigInteger)l10.invoke(object);
            bigInteger = bigInteger.add((BigInteger)object);
            object = "this.add(other)";
            f0.o(bigInteger, (String)object);
        }
        return bigInteger;
    }

    private static final /* synthetic */ boolean W(double[] dArray, double[] dArray2) {
        return Arrays.equals(dArray, dArray2);
    }

    public static final byte[] W0(byte[] byArray, byte[] byArray2, int n10, int n11, int n12) {
        f0.p(byArray, "$this$copyInto");
        f0.p(byArray2, "destination");
        System.arraycopy(byArray, n11, byArray2, n10, n12 -= n11);
        return byArray2;
    }

    private static final short[] W1(short[] object, int n10, int n11) {
        block4: {
            block3: {
                int n12;
                block2: {
                    int n13 = 3;
                    n12 = f.d2.l.a(1, n13, 0);
                    if (n12 == 0) break block2;
                    object = n.N1(object, n10, n11);
                    break block3;
                }
                n12 = ((short[])object).length;
                if (n11 > n12) break block4;
                object = Arrays.copyOfRange(object, n10, n11);
                String string2 = "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)";
                f0.o(object, string2);
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("toIndex: ");
        stringBuilder.append(n11);
        stringBuilder.append(", size: ");
        int n14 = ((short[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    public static final short[] W2(short[] sArray, Collection object) {
        f0.p(sArray, "$this$plus");
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = sArray.length;
        int n11 = object.size() + n10;
        sArray = Arrays.copyOf(sArray, n11);
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Number number = (Number)object.next();
            n11 = number.shortValue();
            int n12 = n10 + 1;
            sArray[n10] = n11;
            n10 = n12;
        }
        f0.o(sArray, "result");
        return sArray;
    }

    private static final BigInteger W3(Object[] objectArray, f.h2.s.l l10) {
        long l11 = 0;
        BigInteger bigInteger = BigInteger.valueOf(l11);
        String string2 = "BigInteger.valueOf(this.toLong())";
        f0.o(bigInteger, string2);
        for (Object object : objectArray) {
            object = (BigInteger)l10.invoke(object);
            bigInteger = bigInteger.add((BigInteger)object);
            object = "this.add(other)";
            f0.o(bigInteger, (String)object);
        }
        return bigInteger;
    }

    private static final /* synthetic */ boolean X(float[] fArray, float[] fArray2) {
        return Arrays.equals(fArray, fArray2);
    }

    public static final char[] X0(char[] cArray, char[] cArray2, int n10, int n11, int n12) {
        f0.p(cArray, "$this$copyInto");
        f0.p(cArray2, "destination");
        System.arraycopy(cArray, n11, cArray2, n10, n12 -= n11);
        return cArray2;
    }

    private static final boolean[] X1(boolean[] object, int n10, int n11) {
        block4: {
            block3: {
                int n12;
                block2: {
                    int n13 = 3;
                    n12 = f.d2.l.a(1, n13, 0);
                    if (n12 == 0) break block2;
                    object = n.O1(object, n10, n11);
                    break block3;
                }
                n12 = ((boolean[])object).length;
                if (n11 > n12) break block4;
                object = Arrays.copyOfRange(object, n10, n11);
                String string2 = "java.util.Arrays.copyOfR\u2026this, fromIndex, toIndex)";
                f0.o(object, string2);
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("toIndex: ");
        stringBuilder.append(n11);
        stringBuilder.append(", size: ");
        int n14 = ((boolean[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    public static final short[] X2(short[] sArray, short s10) {
        f0.p(sArray, "$this$plus");
        int n10 = sArray.length;
        int n11 = n10 + 1;
        sArray = Arrays.copyOf(sArray, n11);
        sArray[n10] = s10;
        f0.o(sArray, "result");
        return sArray;
    }

    private static final BigInteger X3(short[] sArray, f.h2.s.l l10) {
        long l11 = 0;
        BigInteger bigInteger = BigInteger.valueOf(l11);
        String string2 = "BigInteger.valueOf(this.toLong())";
        f0.o(bigInteger, string2);
        for (short s10 : sArray) {
            Object object = s10;
            object = (BigInteger)l10.invoke(object);
            bigInteger = bigInteger.add((BigInteger)object);
            object = "this.add(other)";
            f0.o(bigInteger, (String)object);
        }
        return bigInteger;
    }

    private static final /* synthetic */ boolean Y(int[] nArray, int[] nArray2) {
        return Arrays.equals(nArray, nArray2);
    }

    public static final double[] Y0(double[] dArray, double[] dArray2, int n10, int n11, int n12) {
        f0.p(dArray, "$this$copyInto");
        f0.p(dArray2, "destination");
        System.arraycopy(dArray, n11, dArray2, n10, n12 -= n11);
        return dArray2;
    }

    private static final byte Y1(byte[] byArray, int n10) {
        return byArray[n10];
    }

    public static final short[] Y2(short[] sArray, short[] sArray2) {
        f0.p(sArray, "$this$plus");
        f0.p(sArray2, "elements");
        int n10 = sArray.length;
        int n11 = sArray2.length;
        int n12 = n10 + n11;
        sArray = Arrays.copyOf(sArray, n12);
        System.arraycopy(sArray2, 0, sArray, n10, n11);
        f0.o(sArray, "result");
        return sArray;
    }

    private static final BigInteger Y3(boolean[] blArray, f.h2.s.l l10) {
        long l11 = 0;
        BigInteger bigInteger = BigInteger.valueOf(l11);
        String string2 = "BigInteger.valueOf(this.toLong())";
        f0.o(bigInteger, string2);
        for (boolean bl2 : blArray) {
            Object object = bl2;
            object = (BigInteger)l10.invoke(object);
            bigInteger = bigInteger.add((BigInteger)object);
            object = "this.add(other)";
            f0.o(bigInteger, (String)object);
        }
        return bigInteger;
    }

    private static final /* synthetic */ boolean Z(long[] lArray, long[] lArray2) {
        return Arrays.equals(lArray, lArray2);
    }

    public static final float[] Z0(float[] fArray, float[] fArray2, int n10, int n11, int n12) {
        f0.p(fArray, "$this$copyInto");
        f0.p(fArray2, "destination");
        System.arraycopy(fArray, n11, fArray2, n10, n12 -= n11);
        return fArray2;
    }

    private static final char Z1(char[] cArray, int n10) {
        return cArray[n10];
    }

    public static final boolean[] Z2(boolean[] blArray, Collection object) {
        f0.p(blArray, "$this$plus");
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = blArray.length;
        int n11 = object.size() + n10;
        blArray = Arrays.copyOf(blArray, n11);
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Boolean bl2 = (Boolean)object.next();
            n11 = (int)(bl2.booleanValue() ? 1 : 0);
            int n12 = n10 + 1;
            blArray[n10] = n11;
            n10 = n12;
        }
        f0.o(blArray, "result");
        return blArray;
    }

    public static final SortedSet Z3(byte[] byArray) {
        f0.p(byArray, "$this$toSortedSet");
        TreeSet treeSet = new TreeSet();
        return (SortedSet)ArraysKt___ArraysKt.Tx(byArray, treeSet);
    }

    private static final /* synthetic */ boolean a0(Object[] objectArray, Object[] objectArray2) {
        return Arrays.equals(objectArray, objectArray2);
    }

    public static final int[] a1(int[] nArray, int[] nArray2, int n10, int n11, int n12) {
        f0.p(nArray, "$this$copyInto");
        f0.p(nArray2, "destination");
        System.arraycopy(nArray, n11, nArray2, n10, n12 -= n11);
        return nArray2;
    }

    private static final double a2(double[] dArray, int n10) {
        return dArray[n10];
    }

    public static final boolean[] a3(boolean[] blArray, boolean bl2) {
        f0.p(blArray, "$this$plus");
        int n10 = blArray.length;
        int n11 = n10 + 1;
        blArray = Arrays.copyOf(blArray, n11);
        blArray[n10] = bl2;
        f0.o(blArray, "result");
        return blArray;
    }

    public static final SortedSet a4(char[] cArray) {
        f0.p(cArray, "$this$toSortedSet");
        TreeSet treeSet = new TreeSet();
        return (SortedSet)ArraysKt___ArraysKt.Ux(cArray, treeSet);
    }

    private static final /* synthetic */ boolean b0(short[] sArray, short[] sArray2) {
        return Arrays.equals(sArray, sArray2);
    }

    public static final long[] b1(long[] lArray, long[] lArray2, int n10, int n11, int n12) {
        f0.p(lArray, "$this$copyInto");
        f0.p(lArray2, "destination");
        System.arraycopy(lArray, n11, lArray2, n10, n12 -= n11);
        return lArray2;
    }

    private static final float b2(float[] fArray, int n10) {
        return fArray[n10];
    }

    public static final boolean[] b3(boolean[] blArray, boolean[] blArray2) {
        f0.p(blArray, "$this$plus");
        f0.p(blArray2, "elements");
        int n10 = blArray.length;
        int n11 = blArray2.length;
        int n12 = n10 + n11;
        blArray = Arrays.copyOf(blArray, n12);
        System.arraycopy(blArray2, 0, blArray, n10, n11);
        f0.o(blArray, "result");
        return blArray;
    }

    public static final SortedSet b4(double[] dArray) {
        f0.p(dArray, "$this$toSortedSet");
        TreeSet treeSet = new TreeSet();
        return (SortedSet)ArraysKt___ArraysKt.Vx(dArray, treeSet);
    }

    private static final /* synthetic */ boolean c0(boolean[] blArray, boolean[] blArray2) {
        return Arrays.equals(blArray, blArray2);
    }

    public static final Object[] c1(Object[] objectArray, Object[] objectArray2, int n10, int n11, int n12) {
        f0.p(objectArray, "$this$copyInto");
        f0.p(objectArray2, "destination");
        System.arraycopy(objectArray, n11, objectArray2, n10, n12 -= n11);
        return objectArray2;
    }

    private static final int c2(int[] nArray, int n10) {
        return nArray[n10];
    }

    private static final Object[] c3(Object[] objectArray, Object object) {
        return n.T2(objectArray, object);
    }

    public static final SortedSet c4(float[] fArray) {
        f0.p(fArray, "$this$toSortedSet");
        TreeSet treeSet = new TreeSet();
        return (SortedSet)ArraysKt___ArraysKt.Wx(fArray, treeSet);
    }

    private static final boolean d0(byte[] byArray, byte[] byArray2) {
        return Arrays.equals(byArray, byArray2);
    }

    public static final short[] d1(short[] sArray, short[] sArray2, int n10, int n11, int n12) {
        f0.p(sArray, "$this$copyInto");
        f0.p(sArray2, "destination");
        System.arraycopy(sArray, n11, sArray2, n10, n12 -= n11);
        return sArray2;
    }

    private static final long d2(long[] lArray, int n10) {
        return lArray[n10];
    }

    public static final void d3(byte[] byArray) {
        String string2 = "$this$sort";
        f0.p(byArray, string2);
        int n10 = byArray.length;
        int n11 = 1;
        if (n10 > n11) {
            Arrays.sort(byArray);
        }
    }

    public static final SortedSet d4(int[] nArray) {
        f0.p(nArray, "$this$toSortedSet");
        TreeSet treeSet = new TreeSet();
        return (SortedSet)ArraysKt___ArraysKt.Xx(nArray, treeSet);
    }

    private static final boolean e0(char[] cArray, char[] cArray2) {
        return Arrays.equals(cArray, cArray2);
    }

    public static final boolean[] e1(boolean[] blArray, boolean[] blArray2, int n10, int n11, int n12) {
        f0.p(blArray, "$this$copyInto");
        f0.p(blArray2, "destination");
        System.arraycopy(blArray, n11, blArray2, n10, n12 -= n11);
        return blArray2;
    }

    private static final Object e2(Object[] objectArray, int n10) {
        return objectArray[n10];
    }

    public static final void e3(byte[] byArray, int n10, int n11) {
        f0.p(byArray, "$this$sort");
        Arrays.sort(byArray, n10, n11);
    }

    public static final SortedSet e4(long[] lArray) {
        f0.p(lArray, "$this$toSortedSet");
        TreeSet treeSet = new TreeSet();
        return (SortedSet)ArraysKt___ArraysKt.Yx(lArray, treeSet);
    }

    private static final boolean f0(double[] dArray, double[] dArray2) {
        return Arrays.equals(dArray, dArray2);
    }

    public static /* synthetic */ byte[] f1(byte[] byArray, byte[] byArray2, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n10 = 0;
        }
        if ((n14 = n13 & 4) != 0) {
            n11 = 0;
        }
        if ((n13 &= 8) != 0) {
            n12 = byArray.length;
        }
        return n.W0(byArray, byArray2, n10, n11, n12);
    }

    private static final short f2(short[] sArray, int n10) {
        return sArray[n10];
    }

    public static final void f3(char[] cArray) {
        String string2 = "$this$sort";
        f0.p(cArray, string2);
        int n10 = cArray.length;
        int n11 = 1;
        if (n10 > n11) {
            Arrays.sort(cArray);
        }
    }

    public static final SortedSet f4(Comparable[] comparableArray) {
        f0.p(comparableArray, "$this$toSortedSet");
        TreeSet treeSet = new TreeSet();
        return (SortedSet)ArraysKt___ArraysKt.Zx(comparableArray, treeSet);
    }

    private static final boolean g0(float[] fArray, float[] fArray2) {
        return Arrays.equals(fArray, fArray2);
    }

    public static /* synthetic */ char[] g1(char[] cArray, char[] cArray2, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n10 = 0;
        }
        if ((n14 = n13 & 4) != 0) {
            n11 = 0;
        }
        if ((n13 &= 8) != 0) {
            n12 = cArray.length;
        }
        return n.X0(cArray, cArray2, n10, n11, n12);
    }

    private static final boolean g2(boolean[] blArray, int n10) {
        return blArray[n10];
    }

    public static final void g3(char[] cArray, int n10, int n11) {
        f0.p(cArray, "$this$sort");
        Arrays.sort(cArray, n10, n11);
    }

    public static final SortedSet g4(Object[] objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$toSortedSet");
        f0.p(comparator, "comparator");
        TreeSet treeSet = new TreeSet(comparator);
        return (SortedSet)ArraysKt___ArraysKt.Zx(objectArray, treeSet);
    }

    private static final boolean h0(int[] nArray, int[] nArray2) {
        return Arrays.equals(nArray, nArray2);
    }

    public static /* synthetic */ double[] h1(double[] dArray, double[] dArray2, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n10 = 0;
        }
        if ((n14 = n13 & 4) != 0) {
            n11 = 0;
        }
        if ((n13 &= 8) != 0) {
            n12 = dArray.length;
        }
        return n.Y0(dArray, dArray2, n10, n11, n12);
    }

    public static final void h2(byte[] byArray, byte by2, int n10, int n11) {
        f0.p(byArray, "$this$fill");
        Arrays.fill(byArray, n10, n11, by2);
    }

    public static final void h3(double[] dArray) {
        String string2 = "$this$sort";
        f0.p(dArray, string2);
        int n10 = dArray.length;
        int n11 = 1;
        if (n10 > n11) {
            Arrays.sort(dArray);
        }
    }

    public static final SortedSet h4(short[] sArray) {
        f0.p(sArray, "$this$toSortedSet");
        TreeSet treeSet = new TreeSet();
        return (SortedSet)ArraysKt___ArraysKt.ay(sArray, treeSet);
    }

    private static final boolean i0(long[] lArray, long[] lArray2) {
        return Arrays.equals(lArray, lArray2);
    }

    public static /* synthetic */ float[] i1(float[] fArray, float[] fArray2, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n10 = 0;
        }
        if ((n14 = n13 & 4) != 0) {
            n11 = 0;
        }
        if ((n13 &= 8) != 0) {
            n12 = fArray.length;
        }
        return n.Z0(fArray, fArray2, n10, n11, n12);
    }

    public static final void i2(char[] cArray, char c10, int n10, int n11) {
        f0.p(cArray, "$this$fill");
        Arrays.fill(cArray, n10, n11, c10);
    }

    public static final void i3(double[] dArray, int n10, int n11) {
        f0.p(dArray, "$this$sort");
        Arrays.sort(dArray, n10, n11);
    }

    public static final SortedSet i4(boolean[] blArray) {
        f0.p(blArray, "$this$toSortedSet");
        TreeSet treeSet = new TreeSet();
        return (SortedSet)ArraysKt___ArraysKt.by(blArray, treeSet);
    }

    private static final boolean j0(Object[] objectArray, Object[] objectArray2) {
        return Arrays.equals(objectArray, objectArray2);
    }

    public static /* synthetic */ int[] j1(int[] nArray, int[] nArray2, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n10 = 0;
        }
        if ((n14 = n13 & 4) != 0) {
            n11 = 0;
        }
        if ((n13 &= 8) != 0) {
            n12 = nArray.length;
        }
        return n.a1(nArray, nArray2, n10, n11, n12);
    }

    public static final void j2(double[] dArray, double d10, int n10, int n11) {
        f0.p(dArray, "$this$fill");
        Arrays.fill(dArray, n10, n11, d10);
    }

    public static final void j3(float[] fArray) {
        String string2 = "$this$sort";
        f0.p(fArray, string2);
        int n10 = fArray.length;
        int n11 = 1;
        if (n10 > n11) {
            Arrays.sort(fArray);
        }
    }

    public static final Boolean[] j4(boolean[] blArray) {
        f0.p(blArray, "$this$toTypedArray");
        int n10 = blArray.length;
        Boolean[] booleanArray = new Boolean[n10];
        for (boolean bl2 : blArray) {
            Boolean bl3;
            booleanArray[var4_4] = bl3 = Boolean.valueOf(bl2);
        }
        return booleanArray;
    }

    private static final boolean k0(short[] sArray, short[] sArray2) {
        return Arrays.equals(sArray, sArray2);
    }

    public static /* synthetic */ long[] k1(long[] lArray, long[] lArray2, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n10 = 0;
        }
        if ((n14 = n13 & 4) != 0) {
            n11 = 0;
        }
        if ((n13 &= 8) != 0) {
            n12 = lArray.length;
        }
        return n.b1(lArray, lArray2, n10, n11, n12);
    }

    public static final void k2(float[] fArray, float f10, int n10, int n11) {
        f0.p(fArray, "$this$fill");
        Arrays.fill(fArray, n10, n11, f10);
    }

    public static final void k3(float[] fArray, int n10, int n11) {
        f0.p(fArray, "$this$sort");
        Arrays.sort(fArray, n10, n11);
    }

    public static final Byte[] k4(byte[] byArray) {
        f0.p(byArray, "$this$toTypedArray");
        int n10 = byArray.length;
        Byte[] byteArray = new Byte[n10];
        for (byte by2 : byArray) {
            Byte by3;
            byteArray[var4_4] = by3 = Byte.valueOf(by2);
        }
        return byteArray;
    }

    private static final boolean l0(boolean[] blArray, boolean[] blArray2) {
        return Arrays.equals(blArray, blArray2);
    }

    public static /* synthetic */ Object[] l1(Object[] objectArray, Object[] objectArray2, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n10 = 0;
        }
        if ((n14 = n13 & 4) != 0) {
            n11 = 0;
        }
        if ((n13 &= 8) != 0) {
            n12 = objectArray.length;
        }
        return n.c1(objectArray, objectArray2, n10, n11, n12);
    }

    public static final void l2(int[] nArray, int n10, int n11, int n12) {
        f0.p(nArray, "$this$fill");
        Arrays.fill(nArray, n11, n12, n10);
    }

    public static final void l3(int[] nArray) {
        String string2 = "$this$sort";
        f0.p(nArray, string2);
        int n10 = nArray.length;
        int n11 = 1;
        if (n10 > n11) {
            Arrays.sort(nArray);
        }
    }

    public static final Character[] l4(char[] cArray) {
        f0.p(cArray, "$this$toTypedArray");
        int n10 = cArray.length;
        Character[] characterArray = new Character[n10];
        for (char c10 : cArray) {
            Character c11;
            characterArray[var4_4] = c11 = Character.valueOf(c10);
        }
        return characterArray;
    }

    private static final /* synthetic */ int m0(byte[] byArray) {
        return Arrays.hashCode(byArray);
    }

    public static /* synthetic */ short[] m1(short[] sArray, short[] sArray2, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n10 = 0;
        }
        if ((n14 = n13 & 4) != 0) {
            n11 = 0;
        }
        if ((n13 &= 8) != 0) {
            n12 = sArray.length;
        }
        return n.d1(sArray, sArray2, n10, n11, n12);
    }

    public static final void m2(long[] lArray, long l10, int n10, int n11) {
        f0.p(lArray, "$this$fill");
        Arrays.fill(lArray, n10, n11, l10);
    }

    public static final void m3(int[] nArray, int n10, int n11) {
        f0.p(nArray, "$this$sort");
        Arrays.sort(nArray, n10, n11);
    }

    public static final Double[] m4(double[] dArray) {
        f0.p(dArray, "$this$toTypedArray");
        int n10 = dArray.length;
        Double[] doubleArray = new Double[n10];
        for (double d10 : dArray) {
            Double d11;
            doubleArray[var4_4] = d11 = Double.valueOf(d10);
        }
        return doubleArray;
    }

    public static final List n(byte[] byArray) {
        f0.p(byArray, "$this$asList");
        n$a n$a = new n$a(byArray);
        return n$a;
    }

    private static final /* synthetic */ int n0(char[] cArray) {
        return Arrays.hashCode(cArray);
    }

    public static /* synthetic */ boolean[] n1(boolean[] blArray, boolean[] blArray2, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n10 = 0;
        }
        if ((n14 = n13 & 4) != 0) {
            n11 = 0;
        }
        if ((n13 &= 8) != 0) {
            n12 = blArray.length;
        }
        return n.e1(blArray, blArray2, n10, n11, n12);
    }

    public static final void n2(Object[] objectArray, Object object, int n10, int n11) {
        f0.p(objectArray, "$this$fill");
        Arrays.fill(objectArray, n10, n11, object);
    }

    public static final void n3(long[] lArray) {
        String string2 = "$this$sort";
        f0.p(lArray, string2);
        int n10 = lArray.length;
        int n11 = 1;
        if (n10 > n11) {
            Arrays.sort(lArray);
        }
    }

    public static final Float[] n4(float[] fArray) {
        f0.p(fArray, "$this$toTypedArray");
        int n10 = fArray.length;
        Float[] floatArray = new Float[n10];
        for (float f10 : fArray) {
            Float f11;
            floatArray[var4_4] = f11 = Float.valueOf(f10);
        }
        return floatArray;
    }

    public static final List o(char[] cArray) {
        f0.p(cArray, "$this$asList");
        n$h n$h = new n$h(cArray);
        return n$h;
    }

    private static final /* synthetic */ int o0(double[] dArray) {
        return Arrays.hashCode(dArray);
    }

    private static final byte[] o1(byte[] byArray) {
        int n10 = byArray.length;
        byArray = Arrays.copyOf(byArray, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, size)");
        return byArray;
    }

    public static final void o2(short[] sArray, short s10, int n10, int n11) {
        f0.p(sArray, "$this$fill");
        Arrays.fill(sArray, n10, n11, s10);
    }

    public static final void o3(long[] lArray, int n10, int n11) {
        f0.p(lArray, "$this$sort");
        Arrays.sort(lArray, n10, n11);
    }

    public static final Integer[] o4(int[] nArray) {
        f0.p(nArray, "$this$toTypedArray");
        int n10 = nArray.length;
        Integer[] integerArray = new Integer[n10];
        for (int n11 : nArray) {
            Integer n12;
            integerArray[var4_4] = n12 = Integer.valueOf(n11);
        }
        return integerArray;
    }

    public static final List p(double[] dArray) {
        f0.p(dArray, "$this$asList");
        n$f n$f = new n$f(dArray);
        return n$f;
    }

    private static final /* synthetic */ int p0(float[] fArray) {
        return Arrays.hashCode(fArray);
    }

    private static final byte[] p1(byte[] byArray, int n10) {
        byArray = Arrays.copyOf(byArray, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, newSize)");
        return byArray;
    }

    public static final void p2(boolean[] blArray, boolean bl2, int n10, int n11) {
        f0.p(blArray, "$this$fill");
        Arrays.fill(blArray, n10, n11, bl2);
    }

    private static final void p3(Comparable[] comparableArray) {
        Objects.requireNonNull(comparableArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        n.r3(comparableArray);
    }

    public static final Long[] p4(long[] lArray) {
        f0.p(lArray, "$this$toTypedArray");
        int n10 = lArray.length;
        Long[] longArray = new Long[n10];
        for (long l10 : lArray) {
            Long l11;
            longArray[var4_4] = l11 = Long.valueOf(l10);
        }
        return longArray;
    }

    public static final List q(float[] fArray) {
        f0.p(fArray, "$this$asList");
        n$e n$e = new n$e(fArray);
        return n$e;
    }

    private static final /* synthetic */ int q0(int[] nArray) {
        return Arrays.hashCode(nArray);
    }

    private static final char[] q1(char[] cArray) {
        int n10 = cArray.length;
        cArray = Arrays.copyOf(cArray, n10);
        f0.o(cArray, "java.util.Arrays.copyOf(this, size)");
        return cArray;
    }

    public static /* synthetic */ void q2(byte[] byArray, byte by2, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = byArray.length;
        }
        n.h2(byArray, by2, n10, n11);
    }

    public static final void q3(Comparable[] comparableArray, int n10, int n11) {
        f0.p(comparableArray, "$this$sort");
        Arrays.sort(comparableArray, n10, n11);
    }

    public static final Short[] q4(short[] sArray) {
        f0.p(sArray, "$this$toTypedArray");
        int n10 = sArray.length;
        Short[] shortArray = new Short[n10];
        for (short s10 : sArray) {
            Short s11;
            shortArray[var4_4] = s11 = Short.valueOf(s10);
        }
        return shortArray;
    }

    public static final List r(int[] nArray) {
        f0.p(nArray, "$this$asList");
        n$c n$c = new n$c(nArray);
        return n$c;
    }

    private static final /* synthetic */ int r0(long[] lArray) {
        return Arrays.hashCode(lArray);
    }

    private static final char[] r1(char[] cArray, int n10) {
        cArray = Arrays.copyOf(cArray, n10);
        f0.o(cArray, "java.util.Arrays.copyOf(this, newSize)");
        return cArray;
    }

    public static /* synthetic */ void r2(char[] cArray, char c10, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = cArray.length;
        }
        n.i2(cArray, c10, n10, n11);
    }

    public static final void r3(Object[] objectArray) {
        String string2 = "$this$sort";
        f0.p(objectArray, string2);
        int n10 = objectArray.length;
        int n11 = 1;
        if (n10 > n11) {
            Arrays.sort(objectArray);
        }
    }

    public static final List s(long[] lArray) {
        f0.p(lArray, "$this$asList");
        n$d n$d = new n$d(lArray);
        return n$d;
    }

    private static final /* synthetic */ int s0(Object[] objectArray) {
        return Arrays.hashCode(objectArray);
    }

    private static final double[] s1(double[] dArray) {
        int n10 = dArray.length;
        dArray = Arrays.copyOf(dArray, n10);
        f0.o(dArray, "java.util.Arrays.copyOf(this, size)");
        return dArray;
    }

    public static /* synthetic */ void s2(double[] dArray, double d10, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = dArray.length;
        }
        n.j2(dArray, d10, n10, n11);
    }

    public static final void s3(Object[] objectArray, int n10, int n11) {
        f0.p(objectArray, "$this$sort");
        Arrays.sort(objectArray, n10, n11);
    }

    public static final List t(Object[] object) {
        f0.p(object, "$this$asList");
        object = o.a(object);
        f0.o(object, "ArraysUtilJVM.asList(this)");
        return object;
    }

    private static final /* synthetic */ int t0(short[] sArray) {
        return Arrays.hashCode(sArray);
    }

    private static final double[] t1(double[] dArray, int n10) {
        dArray = Arrays.copyOf(dArray, n10);
        f0.o(dArray, "java.util.Arrays.copyOf(this, newSize)");
        return dArray;
    }

    public static /* synthetic */ void t2(float[] fArray, float f10, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = fArray.length;
        }
        n.k2(fArray, f10, n10, n11);
    }

    public static final void t3(short[] sArray) {
        String string2 = "$this$sort";
        f0.p(sArray, string2);
        int n10 = sArray.length;
        int n11 = 1;
        if (n10 > n11) {
            Arrays.sort(sArray);
        }
    }

    public static final List u(short[] sArray) {
        f0.p(sArray, "$this$asList");
        n$b n$b = new n$b(sArray);
        return n$b;
    }

    private static final /* synthetic */ int u0(boolean[] blArray) {
        return Arrays.hashCode(blArray);
    }

    private static final float[] u1(float[] fArray) {
        int n10 = fArray.length;
        fArray = Arrays.copyOf(fArray, n10);
        f0.o(fArray, "java.util.Arrays.copyOf(this, size)");
        return fArray;
    }

    public static /* synthetic */ void u2(int[] nArray, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n11 = 0;
        }
        if ((n13 &= 4) != 0) {
            n12 = nArray.length;
        }
        n.l2(nArray, n10, n11, n12);
    }

    public static final void u3(short[] sArray, int n10, int n11) {
        f0.p(sArray, "$this$sort");
        Arrays.sort(sArray, n10, n11);
    }

    public static final List v(boolean[] blArray) {
        f0.p(blArray, "$this$asList");
        n$g n$g = new n$g(blArray);
        return n$g;
    }

    private static final int v0(byte[] byArray) {
        return Arrays.hashCode(byArray);
    }

    private static final float[] v1(float[] fArray, int n10) {
        fArray = Arrays.copyOf(fArray, n10);
        f0.o(fArray, "java.util.Arrays.copyOf(this, newSize)");
        return fArray;
    }

    public static /* synthetic */ void v2(long[] lArray, long l10, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = lArray.length;
        }
        n.m2(lArray, l10, n10, n11);
    }

    public static /* synthetic */ void v3(byte[] byArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = byArray.length;
        }
        n.e3(byArray, n10, n11);
    }

    public static final int w(byte[] byArray, byte by2, int n10, int n11) {
        f0.p(byArray, "$this$binarySearch");
        return Arrays.binarySearch(byArray, n10, n11, by2);
    }

    private static final int w0(char[] cArray) {
        return Arrays.hashCode(cArray);
    }

    private static final int[] w1(int[] nArray) {
        int n10 = nArray.length;
        nArray = Arrays.copyOf(nArray, n10);
        f0.o(nArray, "java.util.Arrays.copyOf(this, size)");
        return nArray;
    }

    public static /* synthetic */ void w2(Object[] objectArray, Object object, int n10, int n11, int n12, Object object2) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = objectArray.length;
        }
        n.n2(objectArray, object, n10, n11);
    }

    public static /* synthetic */ void w3(char[] cArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = cArray.length;
        }
        n.g3(cArray, n10, n11);
    }

    public static final int x(char[] cArray, char c10, int n10, int n11) {
        f0.p(cArray, "$this$binarySearch");
        return Arrays.binarySearch(cArray, n10, n11, c10);
    }

    private static final int x0(double[] dArray) {
        return Arrays.hashCode(dArray);
    }

    private static final int[] x1(int[] nArray, int n10) {
        nArray = Arrays.copyOf(nArray, n10);
        f0.o(nArray, "java.util.Arrays.copyOf(this, newSize)");
        return nArray;
    }

    public static /* synthetic */ void x2(short[] sArray, short s10, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = sArray.length;
        }
        n.o2(sArray, s10, n10, n11);
    }

    public static /* synthetic */ void x3(double[] dArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = dArray.length;
        }
        n.i3(dArray, n10, n11);
    }

    public static final int y(double[] dArray, double d10, int n10, int n11) {
        f0.p(dArray, "$this$binarySearch");
        return Arrays.binarySearch(dArray, n10, n11, d10);
    }

    private static final int y0(float[] fArray) {
        return Arrays.hashCode(fArray);
    }

    private static final long[] y1(long[] lArray) {
        int n10 = lArray.length;
        lArray = Arrays.copyOf(lArray, n10);
        f0.o(lArray, "java.util.Arrays.copyOf(this, size)");
        return lArray;
    }

    public static /* synthetic */ void y2(boolean[] blArray, boolean bl2, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = blArray.length;
        }
        n.p2(blArray, bl2, n10, n11);
    }

    public static /* synthetic */ void y3(float[] fArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = fArray.length;
        }
        n.k3(fArray, n10, n11);
    }

    public static final int z(float[] fArray, float f10, int n10, int n11) {
        f0.p(fArray, "$this$binarySearch");
        return Arrays.binarySearch(fArray, n10, n11, f10);
    }

    private static final int z0(int[] nArray) {
        return Arrays.hashCode(nArray);
    }

    private static final long[] z1(long[] lArray, int n10) {
        lArray = Arrays.copyOf(lArray, n10);
        f0.o(lArray, "java.util.Arrays.copyOf(this, newSize)");
        return lArray;
    }

    public static final List z2(Object[] objectArray, Class clazz) {
        f0.p(objectArray, "$this$filterIsInstance");
        f0.p(clazz, "klass");
        ArrayList arrayList = new ArrayList();
        return (List)n.A2(objectArray, arrayList, clazz);
    }

    public static /* synthetic */ void z3(int[] nArray, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = nArray.length;
        }
        n.m3(nArray, n10, n11);
    }
}

