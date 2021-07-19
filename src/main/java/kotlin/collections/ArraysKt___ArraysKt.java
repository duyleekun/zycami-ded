/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.g1;
import f.h2.s.l;
import f.h2.s.p;
import f.h2.s.q;
import f.h2.t.f0;
import f.k2.e;
import f.k2.e$a;
import f.l2.k;
import f.n2.m;
import f.q2.n;
import f.w0;
import f.x1.a0;
import f.x1.c;
import f.x1.c$a;
import f.x1.c1;
import f.x1.d1;
import f.x1.e0;
import f.x1.j0;
import f.x1.s0;
import f.x1.t;
import f.x1.u;
import f.x1.y;
import f.y1.b;
import f.y1.b$b;
import f.y1.b$d;
import java.io.Serializable;
import java.lang.constant.Constable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt$a;
import kotlin.collections.ArraysKt___ArraysKt$b;
import kotlin.collections.ArraysKt___ArraysKt$c;
import kotlin.collections.ArraysKt___ArraysKt$d;
import kotlin.collections.ArraysKt___ArraysKt$e;
import kotlin.collections.ArraysKt___ArraysKt$f;
import kotlin.collections.ArraysKt___ArraysKt$g;
import kotlin.collections.ArraysKt___ArraysKt$h;
import kotlin.collections.ArraysKt___ArraysKt$i;
import kotlin.collections.ArraysKt___ArraysKt$j;
import kotlin.collections.ArraysKt___ArraysKt$k;
import kotlin.collections.ArraysKt___ArraysKt$l;
import kotlin.collections.ArraysKt___ArraysKt$m;
import kotlin.collections.ArraysKt___ArraysKt$n;
import kotlin.collections.ArraysKt___ArraysKt$o;
import kotlin.collections.ArraysKt___ArraysKt$p;
import kotlin.collections.ArraysKt___ArraysKt$q;
import kotlin.collections.ArraysKt___ArraysKt$r;
import kotlin.collections.ArraysKt___ArraysKt$s;
import kotlin.collections.ArraysKt___ArraysKt$withIndex$1;
import kotlin.collections.ArraysKt___ArraysKt$withIndex$2;
import kotlin.collections.ArraysKt___ArraysKt$withIndex$3;
import kotlin.collections.ArraysKt___ArraysKt$withIndex$4;
import kotlin.collections.ArraysKt___ArraysKt$withIndex$5;
import kotlin.collections.ArraysKt___ArraysKt$withIndex$6;
import kotlin.collections.ArraysKt___ArraysKt$withIndex$7;
import kotlin.collections.ArraysKt___ArraysKt$withIndex$8;
import kotlin.collections.ArraysKt___ArraysKt$withIndex$9;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ByteRef;
import kotlin.jvm.internal.Ref$CharRef;
import kotlin.jvm.internal.Ref$DoubleRef;
import kotlin.jvm.internal.Ref$FloatRef;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ShortRef;
import kotlin.sequences.SequencesKt__SequencesKt;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ArraysKt___ArraysKt
extends f.x1.n {
    public static final boolean A4(byte[] byArray) {
        String string2 = "$this$any";
        f0.p(byArray, string2);
        int n10 = byArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            byArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final Map A5(float[] fArray, l l10, l l11) {
        f0.p(fArray, "$this$associateBy");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        int n10 = s0.j(fArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            object = l10.invoke(object);
            Object object2 = Float.valueOf(f10);
            object2 = l11.invoke(object2);
            linkedHashMap.put(object, object2);
        }
        return linkedHashMap;
    }

    private static final Map A6(long[] lArray, Map map, l l10) {
        for (long l11 : lArray) {
            Long l12 = l11;
            Object object = l11;
            object = l10.invoke(object);
            map.put(l12, object);
        }
        return map;
    }

    private static final byte A7(byte[] byArray) {
        f0.p(byArray, "$this$component5");
        return byArray[4];
    }

    public static final List A8(short[] sArray, l l10) {
        f0.p(sArray, "$this$distinctBy");
        f0.p(l10, "selector");
        HashSet<Object> hashSet = new HashSet<Object>();
        ArrayList<Short> arrayList = new ArrayList<Short>();
        for (short s10 : sArray) {
            Object object = s10;
            boolean bl2 = hashSet.add(object = l10.invoke(object));
            if (!bl2) continue;
            Short s11 = s10;
            arrayList.add(s11);
        }
        return arrayList;
    }

    private static final Integer A9(int[] nArray, int n10) {
        return ArraysKt___ArraysKt.ie(nArray, n10);
    }

    public static final Collection Aa(boolean[] blArray, Collection collection, l l10) {
        f0.p(blArray, "$this$filterNotTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (boolean bl2 : blArray) {
            Boolean bl3 = bl2;
            boolean bl4 = bl3 = (Boolean)l10.invoke(bl3);
            if (bl4) continue;
            Boolean bl5 = bl2;
            collection.add(bl5);
        }
        return collection;
    }

    public static final Double Ab(double[] object) {
        String string2 = "$this$firstOrNull";
        f0.p(object, string2);
        int n10 = ((double[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            double d10 = object[0];
            object = d10;
        }
        return object;
    }

    public static final Object Ac(byte[] byArray, Object object, p p10) {
        f0.p(byArray, "$this$fold");
        String string2 = "operation";
        f0.p(p10, string2);
        for (byte by2 : byArray) {
            Byte by3 = by2;
            object = p10.invoke(object, by3);
        }
        return object;
    }

    public static final void Ad(short[] sArray, p p10) {
        f0.p(sArray, "$this$forEachIndexed");
        String string2 = "action";
        f0.p(p10, string2);
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Integer n12 = n11;
            ++n11;
            Short s11 = s10;
            p10.invoke(n12, s11);
        }
    }

    public static final Map Ae(short[] sArray, l l10) {
        f0.p(sArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (short s10 : sArray) {
            Object object = s10;
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Short s11 = s10;
            object2.add((Short)s11);
        }
        return linkedHashMap;
    }

    public static final Set Af(double[] object, Iterable iterable) {
        f0.p(object, "$this$intersect");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Jy(object);
        y.Q0((Collection)object, iterable);
        return object;
    }

    public static /* synthetic */ String Ag(byte[] byArray, CharSequence charSequence, CharSequence object, CharSequence charSequence2, int n10, CharSequence charSequence3, l l10, int n11, Object object2) {
        int n12 = n11 & 1;
        if (n12 != 0) {
            charSequence = ", ";
        }
        n12 = n11 & 2;
        CharSequence charSequence4 = "";
        object2 = n12 != 0 ? charSequence4 : object;
        int n13 = n11 & 4;
        if (n13 == 0) {
            charSequence4 = charSequence2;
        }
        n13 = n11 & 8;
        if (n13 != 0) {
            n10 = -1;
        }
        int n14 = n10;
        n13 = n11 & 0x10;
        if (n13 != 0) {
            charSequence3 = "...";
        }
        CharSequence charSequence5 = charSequence3;
        n13 = n11 & 0x20;
        if (n13 != 0) {
            l10 = null;
        }
        object = byArray;
        charSequence2 = charSequence;
        Object object3 = object2;
        charSequence3 = charSequence4;
        object2 = l10;
        return ArraysKt___ArraysKt.rg(byArray, charSequence, (CharSequence)object3, charSequence4, n14, charSequence5, l10);
    }

    public static final Short Ah(short[] object) {
        String string2 = "$this$lastOrNull";
        f0.p(object, string2);
        int n10 = ((short[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            boolean bl2 = false;
            object = null;
        } else {
            n10 = ((short[])object).length - n11;
            short s10 = object[n10];
            object = s10;
        }
        return object;
    }

    public static final Boolean Ai(boolean[] object, l l10) {
        f0.p(object, "$this$maxBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = ((boolean[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Td(object);
            if (n11 == 0) {
                object = n10 != 0;
            } else {
                Comparable<Boolean> comparable = n10 != 0;
                comparable = (Comparable)l10.invoke(comparable);
                if (n12 <= n11) {
                    while (true) {
                        int n13 = object[n12];
                        Comparable<Boolean> comparable2 = n13 != 0;
                        int n14 = comparable.compareTo((Boolean)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n14 < 0) {
                            n10 = n13;
                            comparable = comparable2;
                        }
                        if (n12 == n11) break;
                        ++n12;
                    }
                }
                object = n10 != 0;
            }
        }
        return object;
    }

    private static final Comparable Aj(short[] sArray, l l10) {
        Comparable<Short> comparable;
        int n10 = sArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray[0];
        comparable = (short)n10;
        comparable = (Comparable)l10.invoke(comparable);
        n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n12 <= n11) {
            while (true) {
                short s10 = sArray[n12];
                Comparable<Short> comparable2 = s10;
                int n13 = comparable.compareTo((Short)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 < 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Float Ak(float[] fArray, Comparator comparator) {
        f0.p(fArray, "$this$maxWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Jk(fArray, comparator);
    }

    private static final float Al(char[] object, l l10) {
        Serializable serializable;
        float f10;
        int n10 = ((char[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            serializable = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            n10 = object[0];
            serializable = Character.valueOf((char)n10);
            serializable = (Number)l10.invoke(serializable);
            f10 = ((Number)serializable).floatValue();
            n11 = ArraysKt___ArraysKt.Md(object);
            if (n12 <= n11) {
                while (true) {
                    char c10 = object[n12];
                    Serializable serializable2 = Character.valueOf(c10);
                    serializable2 = (Number)l10.invoke(serializable2);
                    float f12 = ((Number)serializable2).floatValue();
                    f10 = Math.min(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object Am(boolean[] object, Comparator comparator, l l10) {
        Object object2;
        int n10 = ((boolean[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            object2 = n10 != 0;
            object2 = l10.invoke(object2);
            n11 = ArraysKt___ArraysKt.Td(object);
            if (n12 <= n11) {
                while (true) {
                    boolean bl2 = object[n12];
                    Object object3 = bl2;
                    int n13 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n13 > 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final boolean An(short[] sArray) {
        String string2 = "$this$none";
        f0.p(sArray, string2);
        boolean bl2 = sArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            sArray = null;
        }
        return bl2;
    }

    public static final Byte Ao(byte[] byArray, e e10) {
        f0.p(byArray, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = byArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray.length;
        int n11 = e10.m(n10);
        return byArray[n11];
    }

    public static final char Ap(char[] object, p p10) {
        f0.p(object, "$this$reduceRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int c10 = ArraysKt___ArraysKt.Md((char[])object);
        if (c10 >= 0) {
            char c11;
            int n10 = c10 + -1;
            Object object3 = object[c10];
            while (n10 >= 0) {
                int n11 = n10 + -1;
                Character c12 = Character.valueOf((char)object[n10]);
                object2 = Character.valueOf(c11);
                object2 = (Character)p10.invoke(c12, object2);
                c11 = ((Character)object2).charValue();
                n10 = n11;
            }
            return c11;
        }
        object = new UnsupportedOperationException("Empty array can't be reduced.");
        throw object;
    }

    public static final void Aq(boolean[] blArray) {
        String string2 = "$this$reverse";
        f0.p(blArray, string2);
        int n10 = blArray.length / 2 + -1;
        if (n10 < 0) {
            return;
        }
        int n11 = ArraysKt___ArraysKt.Td(blArray);
        int n12 = 0;
        if (n10 >= 0) {
            while (true) {
                boolean bl2;
                boolean bl3 = blArray[n12];
                blArray[n12] = bl2 = blArray[n11];
                blArray[n11] = bl3;
                n11 += -1;
                if (n12 == n10) break;
                ++n12;
            }
        }
    }

    private static final List Ar(long[] lArray, q q10) {
        Number number;
        int n10 = lArray.length;
        Long l10 = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        long l11 = lArray[0];
        int n12 = lArray.length;
        ArrayList<Number> arrayList = new ArrayList<Number>(n12);
        Long l12 = l11;
        arrayList.add(l12);
        n12 = lArray.length;
        while (n11 < n12) {
            Number number2 = n11;
            number = l11;
            long l13 = lArray[n11];
            l10 = l13;
            number = (Number)q10.invoke(number2, number, l10);
            l11 = number.longValue();
            number2 = l11;
            arrayList.add(number2);
            ++n11;
        }
        return arrayList;
    }

    public static final void As(Object[] objectArray) {
        f0.p(objectArray, "$this$shuffle");
        e$a e$a = e.b;
        ArraysKt___ArraysKt.Bs(objectArray, e$a);
    }

    public static final List At(long[] lArray, Iterable object) {
        f0.p(lArray, "$this$slice");
        Object object2 = "indices";
        f0.p(object, (String)object2);
        int n10 = u.Y((Iterable)object, 10);
        if (n10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            n10 = ((Number)object.next()).intValue();
            long l10 = lArray[n10];
            object2 = l10;
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final byte[] Au(byte[] byArray) {
        String string2 = "$this$sortedArray";
        f0.p(byArray, string2);
        int n10 = byArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return byArray;
        }
        n10 = byArray.length;
        byArray = Arrays.copyOf(byArray, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, size)");
        f.x1.n.d3(byArray);
        return byArray;
    }

    public static final Set Av(byte[] object, Iterable iterable) {
        f0.p(object, "$this$subtract");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Hy(object);
        y.G0((Collection)object, iterable);
        return object;
    }

    private static final int Aw(Object[] objectArray, l l10) {
        int n10 = objectArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            object = (Number)l10.invoke(object);
            int n12 = ((Number)object).intValue();
            n11 += n12;
        }
        return n11;
    }

    public static final List Ax(double[] dArray, l l10) {
        f0.p(dArray, "$this$takeLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Nd(dArray); i10 >= 0; i10 += -1) {
            double d10 = dArray[i10];
            Constable constable = Double.valueOf(d10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return ArraysKt___ArraysKt.E8(dArray, ++i10);
        }
        return ArraysKt___ArraysKt.qy(dArray);
    }

    public static final List Ay(double[] dArray) {
        f0.p(dArray, "$this$toMutableList");
        int n10 = dArray.length;
        ArrayList<Double> arrayList = new ArrayList<Double>(n10);
        for (double d10 : dArray) {
            Double d11 = d10;
            arrayList.add(d11);
        }
        return arrayList;
    }

    public static final List Az(char[] cArray, char[] cArray2) {
        f0.p(cArray, "$this$zip");
        String string2 = "other";
        f0.p(cArray2, string2);
        int n10 = cArray.length;
        int n11 = cArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Character> arrayList = new ArrayList<Character>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = cArray[i10];
            char c11 = cArray2[i10];
            Serializable serializable = Character.valueOf(c10);
            Character c12 = Character.valueOf(c11);
            serializable = w0.a(serializable, c12);
            arrayList.add((Character)serializable);
        }
        return arrayList;
    }

    public static final boolean B4(byte[] byArray, l l10) {
        f0.p(byArray, "$this$any");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = byArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Constable constable = Byte.valueOf(byArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static final Map B5(int[] nArray, l l10) {
        f0.p(nArray, "$this$associateBy");
        String string2 = "keySelector";
        f0.p(l10, string2);
        int n10 = s0.j(nArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Integer> linkedHashMap = new LinkedHashMap<Object, Integer>(n10);
        for (int n12 : nArray) {
            Object object = n12;
            object = l10.invoke(object);
            Integer n13 = n12;
            linkedHashMap.put(object, n13);
        }
        return linkedHashMap;
    }

    public static final Map B6(Object[] objectArray, Map map, l l10) {
        f0.p(objectArray, "$this$associateWithTo");
        f0.p(map, "destination");
        String string2 = "valueSelector";
        f0.p(l10, string2);
        for (Object object : objectArray) {
            Object object2 = l10.invoke(object);
            map.put(object, object2);
        }
        return map;
    }

    private static final char B7(char[] cArray) {
        f0.p(cArray, "$this$component5");
        return cArray[4];
    }

    public static final List B8(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$distinctBy");
        f0.p(l10, "selector");
        HashSet<Object> hashSet = new HashSet<Object>();
        ArrayList<Boolean> arrayList = new ArrayList<Boolean>();
        for (boolean bl2 : blArray) {
            Object object = bl2;
            boolean bl3 = hashSet.add(object = l10.invoke(object));
            if (!bl3) continue;
            Boolean bl4 = bl2;
            arrayList.add(bl4);
        }
        return arrayList;
    }

    private static final Long B9(long[] lArray, int n10) {
        return ArraysKt___ArraysKt.je(lArray, n10);
    }

    public static final Collection Ba(byte[] byArray, Collection collection, l l10) {
        f0.p(byArray, "$this$filterTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (byte by2 : byArray) {
            Constable constable = Byte.valueOf(by2);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            Byte by3 = by2;
            collection.add(by3);
        }
        return collection;
    }

    public static final Double Bb(double[] dArray, l l10) {
        f0.p(dArray, "$this$firstOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (double d10 : dArray) {
            Constable constable = Double.valueOf(d10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return d10;
        }
        return null;
    }

    public static final Object Bc(char[] cArray, Object object, p p10) {
        f0.p(cArray, "$this$fold");
        String string2 = "operation";
        f0.p(p10, string2);
        for (char c10 : cArray) {
            Character c11 = Character.valueOf(c10);
            object = p10.invoke(object, c11);
        }
        return object;
    }

    public static final void Bd(boolean[] blArray, p p10) {
        f0.p(blArray, "$this$forEachIndexed");
        String string2 = "action";
        f0.p(p10, string2);
        int n10 = blArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            Integer n12 = n11;
            ++n11;
            Boolean bl3 = bl2;
            p10.invoke(n12, bl3);
        }
    }

    public static final Map Be(short[] sArray, l l10, l l11) {
        f0.p(sArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        f0.p(l11, "valueTransform");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (short s10 : sArray) {
            Object object = s10;
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = s10;
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return linkedHashMap;
    }

    public static final Set Bf(float[] object, Iterable iterable) {
        f0.p(object, "$this$intersect");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Ky(object);
        y.Q0((Collection)object, iterable);
        return object;
    }

    public static /* synthetic */ String Bg(char[] cArray, CharSequence charSequence, CharSequence object, CharSequence charSequence2, int n10, CharSequence charSequence3, l l10, int n11, Object object2) {
        int n12 = n11 & 1;
        if (n12 != 0) {
            charSequence = ", ";
        }
        n12 = n11 & 2;
        CharSequence charSequence4 = "";
        object2 = n12 != 0 ? charSequence4 : object;
        int n13 = n11 & 4;
        if (n13 == 0) {
            charSequence4 = charSequence2;
        }
        n13 = n11 & 8;
        if (n13 != 0) {
            n10 = -1;
        }
        int n14 = n10;
        n13 = n11 & 0x10;
        if (n13 != 0) {
            charSequence3 = "...";
        }
        CharSequence charSequence5 = charSequence3;
        n13 = n11 & 0x20;
        if (n13 != 0) {
            l10 = null;
        }
        object = cArray;
        charSequence2 = charSequence;
        Object object3 = object2;
        charSequence3 = charSequence4;
        object2 = l10;
        return ArraysKt___ArraysKt.sg(cArray, charSequence, (CharSequence)object3, charSequence4, n14, charSequence5, l10);
    }

    public static final Short Bh(short[] sArray, l l10) {
        f0.p(sArray, "$this$lastOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = sArray.length;
        while ((n10 += -1) >= 0) {
            short s10 = sArray[n10];
            Constable constable = Short.valueOf(s10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return s10;
        }
        return null;
    }

    public static final Byte Bi(byte[] object, l l10) {
        f0.p(object, "$this$maxBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = ((byte[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Ld(object);
            if (n11 == 0) {
                object = (byte)n10;
            } else {
                Comparable<Byte> comparable = (byte)n10;
                comparable = (Comparable)l10.invoke(comparable);
                if (n12 <= n11) {
                    while (true) {
                        int n13 = object[n12];
                        Comparable<Byte> comparable2 = (byte)n13;
                        int n14 = comparable.compareTo((Byte)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n14 < 0) {
                            n10 = n13;
                            comparable = comparable2;
                        }
                        if (n12 == n11) break;
                        ++n12;
                    }
                }
                object = (byte)n10;
            }
        }
        return object;
    }

    private static final Comparable Bj(boolean[] blArray, l l10) {
        Comparable<Boolean> comparable;
        int n10 = blArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = blArray[0];
        comparable = n10 != 0;
        comparable = (Comparable)l10.invoke(comparable);
        n11 = ArraysKt___ArraysKt.Td(blArray);
        if (n12 <= n11) {
            while (true) {
                boolean bl2 = blArray[n12];
                Comparable<Boolean> comparable2 = bl2;
                int n13 = comparable.compareTo((Boolean)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 < 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Integer Bk(int[] nArray, Comparator comparator) {
        f0.p(nArray, "$this$maxWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Kk(nArray, comparator);
    }

    private static final float Bl(double[] object, l l10) {
        Number number;
        float f10;
        int n10 = ((double[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            double d10 = object[0];
            number = d10;
            number = (Number)l10.invoke(number);
            f10 = number.floatValue();
            n11 = ArraysKt___ArraysKt.Nd(object);
            if (n12 <= n11) {
                while (true) {
                    double d11 = object[n12];
                    Number number2 = d11;
                    number2 = (Number)l10.invoke(number2);
                    float f12 = number2.floatValue();
                    f10 = Math.min(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object Bm(byte[] byArray, Comparator comparator, l l10) {
        Object object;
        int n10 = byArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray[0];
        object = (byte)n10;
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n12 <= n11) {
            while (true) {
                byte by2 = byArray[n12];
                Object object2 = by2;
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 > 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final boolean Bn(short[] sArray, l l10) {
        f0.p(sArray, "$this$none");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = sArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Constable constable = Short.valueOf(sArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return false;
        }
        return true;
    }

    private static final Character Bo(char[] cArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.Co(cArray, e$a);
    }

    public static final double Bp(double[] object, p p10) {
        f0.p(object, "$this$reduceRight");
        String string2 = "operation";
        f0.p(p10, string2);
        int n10 = ArraysKt___ArraysKt.Nd(object);
        if (n10 >= 0) {
            int n11 = n10 + -1;
            double d10 = object[n10];
            while (n11 >= 0) {
                n10 = n11 + -1;
                double d11 = object[n11];
                Number number = d11;
                Double d12 = d10;
                number = (Number)p10.invoke(number, d12);
                d10 = number.doubleValue();
                n11 = n10;
            }
            return d10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final void Bq(boolean[] blArray, int n10, int n11) {
        f0.p(blArray, "$this$reverse");
        c$a c$a = c.a;
        int n12 = blArray.length;
        c$a.d(n10, n11, n12);
        int n13 = (n10 + n11) / 2;
        if (n10 == n13) {
            return;
        }
        n11 += -1;
        while (n10 < n13) {
            boolean bl2;
            n12 = blArray[n10];
            blArray[n10] = bl2 = blArray[n11];
            blArray[n11] = n12;
            n11 += -1;
            ++n10;
        }
    }

    public static final List Br(Object[] objectArray, q q10) {
        f0.p(objectArray, "$this$runningReduceIndexed");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = objectArray.length;
        ArrayList<Object> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = objectArray[0];
        int n12 = objectArray.length;
        arrayList = new ArrayList<Object>(n12);
        arrayList.add(object);
        n12 = objectArray.length;
        while (n11 < n12) {
            Integer n13 = n11;
            Object object2 = objectArray[n11];
            object = q10.invoke(n13, object, object2);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    public static final void Bs(Object[] objectArray, e e10) {
        int n10;
        f0.p(objectArray, "$this$shuffle");
        String string2 = "random";
        f0.p(e10, string2);
        for (int i10 = ArraysKt___ArraysKt.Rd(objectArray); i10 >= (n10 = 1); i10 += -1) {
            Object object;
            n10 = i10 + 1;
            n10 = e10.m(n10);
            Object object2 = objectArray[i10];
            objectArray[i10] = object = objectArray[n10];
            objectArray[n10] = object2;
        }
    }

    public static final List Bt(long[] lArray, k k10) {
        f0.p(lArray, "$this$slice");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.s(f.x1.n.L1(lArray, n10, n11));
    }

    public static final char[] Bu(char[] cArray) {
        String string2 = "$this$sortedArray";
        f0.p(cArray, string2);
        int n10 = cArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return cArray;
        }
        n10 = cArray.length;
        cArray = Arrays.copyOf(cArray, n10);
        f0.o(cArray, "java.util.Arrays.copyOf(this, size)");
        f.x1.n.f3(cArray);
        return cArray;
    }

    public static final Set Bv(char[] object, Iterable iterable) {
        f0.p(object, "$this$subtract");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Iy(object);
        y.G0((Collection)object, iterable);
        return object;
    }

    private static final int Bw(short[] sArray, l l10) {
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Number number = sArray[i10];
            number = (Number)l10.invoke(number);
            int n12 = number.intValue();
            n11 += n12;
        }
        return n11;
    }

    public static final List Bx(float[] fArray, l l10) {
        f0.p(fArray, "$this$takeLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Od(fArray); i10 >= 0; i10 += -1) {
            float f10 = fArray[i10];
            Constable constable = Float.valueOf(f10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return ArraysKt___ArraysKt.F8(fArray, ++i10);
        }
        return ArraysKt___ArraysKt.ry(fArray);
    }

    public static final List By(float[] fArray) {
        f0.p(fArray, "$this$toMutableList");
        int n10 = fArray.length;
        ArrayList<Float> arrayList = new ArrayList<Float>(n10);
        for (float f10 : fArray) {
            Float f11 = Float.valueOf(f10);
            arrayList.add(f11);
        }
        return arrayList;
    }

    public static final List Bz(char[] cArray, char[] cArray2, p p10) {
        f0.p(cArray, "$this$zip");
        f0.p(cArray2, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = cArray.length;
        int n11 = cArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = cArray[i10];
            Object object = Character.valueOf(c10);
            char c11 = cArray2[i10];
            Character c12 = Character.valueOf(c11);
            object = p10.invoke(object, c12);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final boolean C4(char[] cArray) {
        String string2 = "$this$any";
        f0.p(cArray, string2);
        int n10 = cArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            cArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final Map C5(int[] nArray, l l10, l l11) {
        f0.p(nArray, "$this$associateBy");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        int n10 = s0.j(nArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (int n12 : nArray) {
            Object object = n12;
            object = l10.invoke(object);
            Object object2 = n12;
            object2 = l11.invoke(object2);
            linkedHashMap.put(object, object2);
        }
        return linkedHashMap;
    }

    private static final Map C6(short[] sArray, Map map, l l10) {
        for (short s10 : sArray) {
            Short s11 = s10;
            Object object = s10;
            object = l10.invoke(object);
            map.put(s11, object);
        }
        return map;
    }

    private static final double C7(double[] dArray) {
        f0.p(dArray, "$this$component5");
        return dArray[4];
    }

    public static final List C8(byte[] object, int n10) {
        f0.p(object, "$this$drop");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((byte[])object).length - n10, 0);
            return ArraysKt___ArraysKt.px((byte[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private static final Object C9(Object[] objectArray, int n10) {
        return ArraysKt___ArraysKt.ke(objectArray, n10);
    }

    public static final Collection Ca(char[] cArray, Collection collection, l l10) {
        f0.p(cArray, "$this$filterTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (char c10 : cArray) {
            Comparable<Character> comparable = Character.valueOf(c10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            Character c11 = Character.valueOf(c10);
            collection.add(c11);
        }
        return collection;
    }

    public static final Float Cb(float[] object) {
        String string2 = "$this$firstOrNull";
        f0.p(object, string2);
        int n10 = ((float[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            float f10 = 0.0f;
            object = null;
        } else {
            float f11 = object[0];
            object = Float.valueOf(f11);
        }
        return object;
    }

    public static final Object Cc(double[] dArray, Object object, p p10) {
        f0.p(dArray, "$this$fold");
        String string2 = "operation";
        f0.p(p10, string2);
        for (double d10 : dArray) {
            Double d11 = d10;
            object = p10.invoke(object, d11);
        }
        return object;
    }

    public static final k Cd(byte[] byArray) {
        f0.p(byArray, "$this$indices");
        int n10 = ArraysKt___ArraysKt.Ld(byArray);
        k k10 = new k(0, n10);
        return k10;
    }

    public static final Map Ce(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (boolean bl2 : blArray) {
            Object object = bl2;
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Boolean bl3 = bl2;
            object2.add((Boolean)bl3);
        }
        return linkedHashMap;
    }

    public static final Set Cf(int[] object, Iterable iterable) {
        f0.p(object, "$this$intersect");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Ly(object);
        y.Q0((Collection)object, iterable);
        return object;
    }

    public static /* synthetic */ String Cg(double[] dArray, CharSequence charSequence, CharSequence object, CharSequence charSequence2, int n10, CharSequence charSequence3, l l10, int n11, Object object2) {
        int n12 = n11 & 1;
        if (n12 != 0) {
            charSequence = ", ";
        }
        n12 = n11 & 2;
        CharSequence charSequence4 = "";
        object2 = n12 != 0 ? charSequence4 : object;
        int n13 = n11 & 4;
        if (n13 == 0) {
            charSequence4 = charSequence2;
        }
        n13 = n11 & 8;
        if (n13 != 0) {
            n10 = -1;
        }
        int n14 = n10;
        n13 = n11 & 0x10;
        if (n13 != 0) {
            charSequence3 = "...";
        }
        CharSequence charSequence5 = charSequence3;
        n13 = n11 & 0x20;
        if (n13 != 0) {
            l10 = null;
        }
        object = dArray;
        charSequence2 = charSequence;
        Object object3 = object2;
        charSequence3 = charSequence4;
        object2 = l10;
        return ArraysKt___ArraysKt.tg(dArray, charSequence, (CharSequence)object3, charSequence4, n14, charSequence5, l10);
    }

    public static final List Ch(byte[] byArray, l l10) {
        f0.p(byArray, "$this$map");
        f0.p(l10, "transform");
        int n10 = byArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (byte by2 : byArray) {
            Object object = by2;
            object = l10.invoke(object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Character Ci(char[] object, l l10) {
        f0.p(object, "$this$maxBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = ((char[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Md(object);
            if (n11 == 0) {
                object = Character.valueOf((char)n10);
            } else {
                Comparable<Character> comparable = Character.valueOf((char)n10);
                comparable = (Comparable)l10.invoke(comparable);
                if (n12 <= n11) {
                    while (true) {
                        int n13 = object[n12];
                        Comparable<Character> comparable2 = Character.valueOf((char)n13);
                        int n14 = comparable.compareTo((Character)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n14 < 0) {
                            n10 = n13;
                            comparable = comparable2;
                        }
                        if (n12 == n11) break;
                        ++n12;
                    }
                }
                object = Character.valueOf((char)n10);
            }
        }
        return object;
    }

    private static final Double Cj(byte[] byArray, l l10) {
        Number number;
        int n10 = byArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray[0];
        number = (byte)n10;
        number = (Number)l10.invoke(number);
        double d10 = number.doubleValue();
        int n12 = ArraysKt___ArraysKt.Ld(byArray);
        if (n11 <= n12) {
            while (true) {
                byte by2 = byArray[n11];
                Number number2 = by2;
                number2 = (Number)l10.invoke(number2);
                double d11 = number2.doubleValue();
                d10 = Math.max(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Long Ck(long[] lArray, Comparator comparator) {
        f0.p(lArray, "$this$maxWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Lk(lArray, comparator);
    }

    private static final float Cl(float[] object, l l10) {
        Number number;
        float f10;
        int n10 = ((float[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            number = Float.valueOf(object[0]);
            number = (Number)l10.invoke(number);
            f10 = number.floatValue();
            n11 = ArraysKt___ArraysKt.Od(object);
            if (n12 <= n11) {
                while (true) {
                    Number number2 = Float.valueOf(object[n12]);
                    number2 = (Number)l10.invoke(number2);
                    float f12 = number2.floatValue();
                    f10 = Math.min(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object Cm(char[] cArray, Comparator comparator, l l10) {
        Object object;
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray[0];
        object = Character.valueOf((char)n10);
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Md(cArray);
        if (n12 <= n11) {
            while (true) {
                char c10 = cArray[n12];
                Object object2 = Character.valueOf(c10);
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 > 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final boolean Cn(boolean[] blArray) {
        String string2 = "$this$none";
        f0.p(blArray, string2);
        boolean bl2 = blArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            blArray = null;
        }
        return bl2;
    }

    public static final Character Co(char[] cArray, e e10) {
        f0.p(cArray, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = cArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray.length;
        int n11 = e10.m(n10);
        return Character.valueOf(cArray[n11]);
    }

    public static final float Cp(float[] object, p p10) {
        f0.p(object, "$this$reduceRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Od(object);
        if (n10 >= 0) {
            int n11 = n10 + -1;
            float f10 = object[n10];
            while (n11 >= 0) {
                int n12 = n11 + -1;
                float f11 = object[n11];
                Float f12 = Float.valueOf(f11);
                object2 = Float.valueOf(f10);
                object2 = (Number)p10.invoke(f12, object2);
                f10 = ((Number)object2).floatValue();
                n11 = n12;
            }
            return f10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final List Cq(byte[] object) {
        String string2 = "$this$reversed";
        f0.p(object, string2);
        int n10 = ((byte[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = ArraysKt___ArraysKt.yy(object);
        a0.e1((List)object);
        return object;
    }

    private static final List Cr(short[] sArray, q q10) {
        Number number;
        int n10 = sArray.length;
        ArrayList<Number> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = sArray[0];
        int n12 = sArray.length;
        arrayList = new ArrayList<Number>(n12);
        Short s10 = (short)n10;
        arrayList.add(s10);
        n12 = sArray.length;
        while (n11 < n12) {
            Number number2 = n11;
            number = (short)n10;
            short s11 = sArray[n11];
            Short s12 = s11;
            number = (Number)q10.invoke(number2, number, s12);
            n10 = number.shortValue();
            number2 = (short)n10;
            arrayList.add(number2);
            ++n11;
        }
        return arrayList;
    }

    public static final void Cs(short[] sArray) {
        f0.p(sArray, "$this$shuffle");
        e$a e$a = e.b;
        ArraysKt___ArraysKt.Ds(sArray, e$a);
    }

    public static final List Ct(Object[] objectArray, Iterable object) {
        f0.p(objectArray, "$this$slice");
        Object object2 = "indices";
        f0.p(object, (String)object2);
        int n10 = u.Y((Iterable)object, 10);
        if (n10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            n10 = ((Number)object.next()).intValue();
            object2 = objectArray[n10];
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final double[] Cu(double[] dArray) {
        String string2 = "$this$sortedArray";
        f0.p(dArray, string2);
        int n10 = dArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return dArray;
        }
        n10 = dArray.length;
        dArray = Arrays.copyOf(dArray, n10);
        f0.o(dArray, "java.util.Arrays.copyOf(this, size)");
        f.x1.n.h3(dArray);
        return dArray;
    }

    public static final Set Cv(double[] object, Iterable iterable) {
        f0.p(object, "$this$subtract");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Jy(object);
        y.G0((Collection)object, iterable);
        return object;
    }

    private static final int Cw(boolean[] blArray, l l10) {
        int n10 = blArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Serializable serializable = Boolean.valueOf(blArray[i10]);
            serializable = (Number)l10.invoke(serializable);
            int n12 = ((Number)serializable).intValue();
            n11 += n12;
        }
        return n11;
    }

    public static final List Cx(int[] nArray, l l10) {
        f0.p(nArray, "$this$takeLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Pd(nArray); i10 >= 0; i10 += -1) {
            Constable constable = Integer.valueOf(nArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return ArraysKt___ArraysKt.G8(nArray, ++i10);
        }
        return ArraysKt___ArraysKt.sy(nArray);
    }

    public static final List Cy(int[] nArray) {
        f0.p(nArray, "$this$toMutableList");
        int n10 = nArray.length;
        ArrayList<Integer> arrayList = new ArrayList<Integer>(n10);
        for (int n11 : nArray) {
            Integer n12 = n11;
            arrayList.add(n12);
        }
        return arrayList;
    }

    public static final List Cz(char[] cArray, Object[] objectArray) {
        f0.p(cArray, "$this$zip");
        String string2 = "other";
        f0.p(objectArray, string2);
        int n10 = cArray.length;
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = cArray[i10];
            Object object = objectArray[i10];
            Pair pair = w0.a(Character.valueOf(c10), object);
            arrayList.add(pair);
        }
        return arrayList;
    }

    public static final boolean D4(char[] cArray, l l10) {
        f0.p(cArray, "$this$any");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = cArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable<Character> comparable = Character.valueOf(cArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static final Map D5(long[] lArray, l l10) {
        f0.p(lArray, "$this$associateBy");
        String string2 = "keySelector";
        f0.p(l10, string2);
        int n10 = s0.j(lArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Long> linkedHashMap = new LinkedHashMap<Object, Long>(n10);
        for (long l11 : lArray) {
            Object object = l11;
            object = l10.invoke(object);
            Long l12 = l11;
            linkedHashMap.put(object, l12);
        }
        return linkedHashMap;
    }

    private static final Map D6(boolean[] blArray, Map map, l l10) {
        for (boolean bl2 : blArray) {
            Boolean bl3 = bl2;
            Object object = bl2;
            object = l10.invoke(object);
            map.put(bl3, object);
        }
        return map;
    }

    private static final float D7(float[] fArray) {
        f0.p(fArray, "$this$component5");
        return fArray[4];
    }

    public static final List D8(char[] object, int n10) {
        f0.p(object, "$this$drop");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((char[])object).length - n10, 0);
            return ArraysKt___ArraysKt.qx((char[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private static final Short D9(short[] sArray, int n10) {
        return ArraysKt___ArraysKt.le(sArray, n10);
    }

    public static final Collection Da(double[] dArray, Collection collection, l l10) {
        f0.p(dArray, "$this$filterTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (double d10 : dArray) {
            Constable constable = Double.valueOf(d10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            Double d11 = d10;
            collection.add(d11);
        }
        return collection;
    }

    public static final Float Db(float[] fArray, l l10) {
        f0.p(fArray, "$this$firstOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (float f10 : fArray) {
            Constable constable = Float.valueOf(f10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return Float.valueOf(f10);
        }
        return null;
    }

    public static final Object Dc(float[] fArray, Object object, p p10) {
        f0.p(fArray, "$this$fold");
        String string2 = "operation";
        f0.p(p10, string2);
        for (float f10 : fArray) {
            Float f11 = Float.valueOf(f10);
            object = p10.invoke(object, f11);
        }
        return object;
    }

    public static final k Dd(char[] cArray) {
        f0.p(cArray, "$this$indices");
        int n10 = ArraysKt___ArraysKt.Md(cArray);
        k k10 = new k(0, n10);
        return k10;
    }

    public static final Map De(boolean[] blArray, l l10, l l11) {
        f0.p(blArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        f0.p(l11, "valueTransform");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (boolean bl2 : blArray) {
            Object object = bl2;
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = bl2;
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return linkedHashMap;
    }

    public static final Set Df(long[] object, Iterable iterable) {
        f0.p(object, "$this$intersect");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.My(object);
        y.Q0((Collection)object, iterable);
        return object;
    }

    public static /* synthetic */ String Dg(float[] fArray, CharSequence charSequence, CharSequence object, CharSequence charSequence2, int n10, CharSequence charSequence3, l l10, int n11, Object object2) {
        int n12 = n11 & 1;
        if (n12 != 0) {
            charSequence = ", ";
        }
        n12 = n11 & 2;
        CharSequence charSequence4 = "";
        object2 = n12 != 0 ? charSequence4 : object;
        int n13 = n11 & 4;
        if (n13 == 0) {
            charSequence4 = charSequence2;
        }
        n13 = n11 & 8;
        if (n13 != 0) {
            n10 = -1;
        }
        int n14 = n10;
        n13 = n11 & 0x10;
        if (n13 != 0) {
            charSequence3 = "...";
        }
        CharSequence charSequence5 = charSequence3;
        n13 = n11 & 0x20;
        if (n13 != 0) {
            l10 = null;
        }
        object = fArray;
        charSequence2 = charSequence;
        Object object3 = object2;
        charSequence3 = charSequence4;
        object2 = l10;
        return ArraysKt___ArraysKt.ug(fArray, charSequence, (CharSequence)object3, charSequence4, n14, charSequence5, l10);
    }

    public static final List Dh(char[] cArray, l l10) {
        f0.p(cArray, "$this$map");
        f0.p(l10, "transform");
        int n10 = cArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            object = l10.invoke(object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Double Di(double[] object, l l10) {
        f0.p(object, "$this$maxBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = ((double[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            double d10 = object[0];
            int n12 = ArraysKt___ArraysKt.Nd(object);
            if (n12 == 0) {
                object = d10;
            } else {
                Comparable<Double> comparable = d10;
                comparable = (Comparable)l10.invoke(comparable);
                if (n11 <= n12) {
                    while (true) {
                        double d11 = object[n11];
                        Comparable<Double> comparable2 = d11;
                        int n13 = comparable.compareTo((Double)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n13 < 0) {
                            d10 = d11;
                            comparable = comparable2;
                        }
                        if (n11 == n12) break;
                        ++n11;
                    }
                }
                object = d10;
            }
        }
        return object;
    }

    private static final Double Dj(char[] cArray, l l10) {
        Serializable serializable;
        int n10 = cArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            serializable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray[0];
        serializable = Character.valueOf((char)n10);
        serializable = (Number)l10.invoke(serializable);
        double d10 = ((Number)serializable).doubleValue();
        int n12 = ArraysKt___ArraysKt.Md(cArray);
        if (n11 <= n12) {
            while (true) {
                char c10 = cArray[n11];
                Serializable serializable2 = Character.valueOf(c10);
                serializable2 = (Number)l10.invoke(serializable2);
                double d11 = ((Number)serializable2).doubleValue();
                d10 = Math.max(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Object Dk(Object[] objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$maxWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Mk(objectArray, comparator);
    }

    private static final float Dl(int[] object, l l10) {
        Number number;
        float f10;
        int n10 = ((int[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            n10 = object[0];
            number = n10;
            number = (Number)l10.invoke(number);
            f10 = number.floatValue();
            n11 = ArraysKt___ArraysKt.Pd(object);
            if (n12 <= n11) {
                while (true) {
                    int n13 = object[n12];
                    Number number2 = n13;
                    number2 = (Number)l10.invoke(number2);
                    float f12 = number2.floatValue();
                    f10 = Math.min(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object Dm(double[] dArray, Comparator comparator, l l10) {
        Object object;
        int n10 = dArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        double d10 = dArray[0];
        object = d10;
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Nd(dArray);
        if (n12 <= n11) {
            while (true) {
                double d11 = dArray[n12];
                Object object2 = d11;
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 > 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final boolean Dn(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$none");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = blArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Boolean bl2 = blArray[i10];
            boolean bl3 = bl2 = (Boolean)l10.invoke(bl2);
            if (!bl3) continue;
            return false;
        }
        return true;
    }

    private static final Double Do(double[] dArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.Eo(dArray, e$a);
    }

    public static final int Dp(int[] object, p p10) {
        f0.p(object, "$this$reduceRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Pd(object);
        if (n10 >= 0) {
            int n11 = n10 + -1;
            n10 = object[n10];
            while (n11 >= 0) {
                int n12 = n11 + -1;
                Integer n13 = object[n11];
                object2 = n10;
                object2 = (Number)p10.invoke(n13, object2);
                n10 = ((Number)object2).intValue();
                n11 = n12;
            }
            return n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final List Dq(char[] object) {
        String string2 = "$this$reversed";
        f0.p(object, string2);
        int n10 = ((char[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = ArraysKt___ArraysKt.zy(object);
        a0.e1((List)object);
        return object;
    }

    private static final List Dr(boolean[] blArray, q q10) {
        Boolean bl2;
        int n10 = blArray.length;
        ArrayList<Comparable<Boolean>> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            bl2 = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = blArray[0];
        int n12 = blArray.length;
        arrayList = new ArrayList<Comparable<Boolean>>(n12);
        Boolean bl3 = n10 != 0;
        arrayList.add(bl3);
        n12 = blArray.length;
        while (n11 < n12) {
            Constable constable = n11;
            bl2 = n10 != 0;
            boolean bl4 = blArray[n11];
            Boolean bl5 = bl4;
            bl2 = (Boolean)q10.invoke(constable, bl2, bl5);
            n10 = (int)(bl2.booleanValue() ? 1 : 0);
            constable = Boolean.valueOf(n10 != 0);
            arrayList.add((Comparable<Boolean>)((Object)constable));
            ++n11;
        }
        return arrayList;
    }

    public static final void Ds(short[] sArray, e e10) {
        int n10;
        f0.p(sArray, "$this$shuffle");
        String string2 = "random";
        f0.p(e10, string2);
        for (int i10 = ArraysKt___ArraysKt.Sd(sArray); i10 >= (n10 = 1); i10 += -1) {
            short s10;
            n10 = i10 + 1;
            n10 = e10.m(n10);
            short s11 = sArray[i10];
            sArray[i10] = s10 = sArray[n10];
            sArray[n10] = s11;
        }
    }

    public static final List Dt(Object[] objectArray, k k10) {
        f0.p(objectArray, "$this$slice");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.t(f.x1.n.M1(objectArray, n10, n11));
    }

    public static final float[] Du(float[] fArray) {
        String string2 = "$this$sortedArray";
        f0.p(fArray, string2);
        int n10 = fArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return fArray;
        }
        n10 = fArray.length;
        fArray = Arrays.copyOf(fArray, n10);
        f0.o(fArray, "java.util.Arrays.copyOf(this, size)");
        f.x1.n.j3(fArray);
        return fArray;
    }

    public static final Set Dv(float[] object, Iterable iterable) {
        f0.p(object, "$this$subtract");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Ky(object);
        y.G0((Collection)object, iterable);
        return object;
    }

    private static final long Dw(byte[] byArray, l l10) {
        int n10 = byArray.length;
        long l11 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Number number = by2;
            number = (Number)l10.invoke(number);
            long l12 = number.longValue();
            l11 += l12;
        }
        return l11;
    }

    public static final List Dx(long[] lArray, l l10) {
        f0.p(lArray, "$this$takeLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Qd(lArray); i10 >= 0; i10 += -1) {
            long l11 = lArray[i10];
            Constable constable = Long.valueOf(l11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return ArraysKt___ArraysKt.H8(lArray, ++i10);
        }
        return ArraysKt___ArraysKt.ty(lArray);
    }

    public static final List Dy(long[] lArray) {
        f0.p(lArray, "$this$toMutableList");
        int n10 = lArray.length;
        ArrayList<Long> arrayList = new ArrayList<Long>(n10);
        for (long l10 : lArray) {
            Long l11 = l10;
            arrayList.add(l11);
        }
        return arrayList;
    }

    public static final List Dz(char[] cArray, Object[] objectArray, p p10) {
        f0.p(cArray, "$this$zip");
        f0.p(objectArray, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = cArray.length;
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = cArray[i10];
            Object object = Character.valueOf(c10);
            Object object2 = objectArray[i10];
            object = p10.invoke(object, object2);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final boolean E4(double[] dArray) {
        String string2 = "$this$any";
        f0.p(dArray, string2);
        int n10 = dArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            dArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final Map E5(long[] lArray, l l10, l l11) {
        f0.p(lArray, "$this$associateBy");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        int n10 = s0.j(lArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (long l12 : lArray) {
            Object object = l12;
            object = l10.invoke(object);
            Object object2 = l12;
            object2 = l11.invoke(object2);
            linkedHashMap.put(object, object2);
        }
        return linkedHashMap;
    }

    public static final double E6(byte[] byArray) {
        double d10;
        double d11;
        String string2 = "$this$average";
        f0.p(byArray, string2);
        int n10 = byArray.length;
        double d12 = d11 = 0.0;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            double d13 = by2;
            d12 += d13;
            ++n11;
        }
        if (n11 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            d10 = n11;
            d10 = d12 / d10;
        }
        return d10;
    }

    private static final int E7(int[] nArray) {
        f0.p(nArray, "$this$component5");
        return nArray[4];
    }

    public static final List E8(double[] object, int n10) {
        f0.p(object, "$this$drop");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((double[])object).length - n10, 0);
            return ArraysKt___ArraysKt.rx((double[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List E9(byte[] byArray, l l10) {
        f0.p(byArray, "$this$filter");
        f0.p(l10, "predicate");
        ArrayList<Byte> arrayList = new ArrayList<Byte>();
        for (byte by2 : byArray) {
            Constable constable = Byte.valueOf(by2);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            Byte by3 = by2;
            arrayList.add(by3);
        }
        return arrayList;
    }

    public static final Collection Ea(float[] fArray, Collection collection, l l10) {
        f0.p(fArray, "$this$filterTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (float f10 : fArray) {
            Constable constable = Float.valueOf(f10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            Float f11 = Float.valueOf(f10);
            collection.add(f11);
        }
        return collection;
    }

    public static final Integer Eb(int[] object) {
        String string2 = "$this$firstOrNull";
        f0.p(object, string2);
        int n10 = ((int[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            boolean bl2 = false;
            object = null;
        } else {
            int n11 = object[0];
            object = n11;
        }
        return object;
    }

    public static final Object Ec(int[] nArray, Object object, p p10) {
        f0.p(nArray, "$this$fold");
        String string2 = "operation";
        f0.p(p10, string2);
        for (int n10 : nArray) {
            Integer n11 = n10;
            object = p10.invoke(object, n11);
        }
        return object;
    }

    public static final k Ed(double[] dArray) {
        f0.p(dArray, "$this$indices");
        int n10 = ArraysKt___ArraysKt.Nd(dArray);
        k k10 = new k(0, n10);
        return k10;
    }

    public static final Map Ee(byte[] byArray, Map map, l l10) {
        f0.p(byArray, "$this$groupByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (byte by2 : byArray) {
            Object object = by2;
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Byte by3 = by2;
            object2.add((Byte)by3);
        }
        return map;
    }

    public static final Set Ef(Object[] object, Iterable iterable) {
        f0.p(object, "$this$intersect");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Ny(object);
        y.Q0((Collection)object, iterable);
        return object;
    }

    public static /* synthetic */ String Eg(int[] nArray, CharSequence charSequence, CharSequence object, CharSequence charSequence2, int n10, CharSequence charSequence3, l l10, int n11, Object object2) {
        int n12 = n11 & 1;
        if (n12 != 0) {
            charSequence = ", ";
        }
        n12 = n11 & 2;
        CharSequence charSequence4 = "";
        object2 = n12 != 0 ? charSequence4 : object;
        int n13 = n11 & 4;
        if (n13 == 0) {
            charSequence4 = charSequence2;
        }
        n13 = n11 & 8;
        if (n13 != 0) {
            n10 = -1;
        }
        int n14 = n10;
        n13 = n11 & 0x10;
        if (n13 != 0) {
            charSequence3 = "...";
        }
        CharSequence charSequence5 = charSequence3;
        n13 = n11 & 0x20;
        if (n13 != 0) {
            l10 = null;
        }
        object = nArray;
        charSequence2 = charSequence;
        Object object3 = object2;
        charSequence3 = charSequence4;
        object2 = l10;
        return ArraysKt___ArraysKt.vg(nArray, charSequence, (CharSequence)object3, charSequence4, n14, charSequence5, l10);
    }

    public static final List Eh(double[] dArray, l l10) {
        f0.p(dArray, "$this$map");
        f0.p(l10, "transform");
        int n10 = dArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (double d10 : dArray) {
            Object object = d10;
            object = l10.invoke(object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Float Ei(float[] object, l l10) {
        float f10;
        f0.p(object, "$this$maxBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = ((float[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            string2 = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            object = null;
        } else {
            f10 = object[0];
            n11 = ArraysKt___ArraysKt.Od(object);
            if (n11 == 0) {
                object = Float.valueOf(f10);
            } else {
                Comparable<Float> comparable = Float.valueOf(f10);
                comparable = (Comparable)l10.invoke(comparable);
                if (n12 <= n11) {
                    while (true) {
                        float f12 = object[n12];
                        Comparable<Float> comparable2 = Float.valueOf(f12);
                        int n13 = comparable.compareTo((Float)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n13 < 0) {
                            f10 = f12;
                            comparable = comparable2;
                        }
                        if (n12 == n11) break;
                        ++n12;
                    }
                }
                object = Float.valueOf(f10);
            }
        }
        return object;
    }

    private static final Double Ej(double[] dArray, l l10) {
        Number number;
        int n10 = dArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return null;
        }
        number = dArray[0];
        number = (Number)l10.invoke(number);
        double d10 = number.doubleValue();
        int n12 = ArraysKt___ArraysKt.Nd(dArray);
        if (n11 <= n12) {
            while (true) {
                Number number2 = dArray[n11];
                number2 = (Number)l10.invoke(number2);
                double d11 = number2.doubleValue();
                d10 = Math.max(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Short Ek(short[] sArray, Comparator comparator) {
        f0.p(sArray, "$this$maxWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Nk(sArray, comparator);
    }

    private static final float El(long[] object, l l10) {
        Number number;
        float f10;
        int n10 = ((long[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            long l11 = object[0];
            number = l11;
            number = (Number)l10.invoke(number);
            f10 = number.floatValue();
            n11 = ArraysKt___ArraysKt.Qd(object);
            if (n12 <= n11) {
                while (true) {
                    long l12 = object[n12];
                    Number number2 = l12;
                    number2 = (Number)l10.invoke(number2);
                    float f12 = number2.floatValue();
                    f10 = Math.min(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object Em(float[] fArray, Comparator comparator, l l10) {
        Object object;
        float f10;
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            object = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        f10 = fArray[0];
        object = Float.valueOf(f10);
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Od(fArray);
        if (n12 <= n11) {
            while (true) {
                float f12 = fArray[n12];
                Object object2 = Float.valueOf(f12);
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 > 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    private static final byte[] En(byte[] byArray, l l10) {
        int n10 = byArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Byte by3 = by2;
            l10.invoke(by3);
        }
        return byArray;
    }

    public static final Double Eo(double[] dArray, e e10) {
        f0.p(dArray, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = dArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = dArray.length;
        int n11 = e10.m(n10);
        return dArray[n11];
    }

    public static final long Ep(long[] object, p p10) {
        f0.p(object, "$this$reduceRight");
        String string2 = "operation";
        f0.p(p10, string2);
        int n10 = ArraysKt___ArraysKt.Qd(object);
        if (n10 >= 0) {
            int n11 = n10 + -1;
            long l10 = object[n10];
            while (n11 >= 0) {
                n10 = n11 + -1;
                long l11 = object[n11];
                Number number = l11;
                Long l12 = l10;
                number = (Number)p10.invoke(number, l12);
                l10 = number.longValue();
                n11 = n10;
            }
            return l10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final List Eq(double[] object) {
        String string2 = "$this$reversed";
        f0.p(object, string2);
        int n10 = ((double[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = ArraysKt___ArraysKt.Ay(object);
        a0.e1((List)object);
        return object;
    }

    private static final List Er(byte[] object, Object object2, p p10) {
        ArrayList<Object> arrayList;
        int n10 = ((byte[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            byte by2 = ((byte[])object).length + n12;
            arrayList = new ArrayList<Object>(by2);
            arrayList.add(object2);
            n12 = ((byte[])object).length;
            while (n11 < n12) {
                by2 = object[n11];
                Byte by3 = by2;
                object2 = p10.invoke(object2, by3);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final void Es(boolean[] blArray) {
        f0.p(blArray, "$this$shuffle");
        e$a e$a = e.b;
        ArraysKt___ArraysKt.Fs(blArray, e$a);
    }

    public static final List Et(short[] sArray, Iterable object) {
        short s10;
        f0.p(sArray, "$this$slice");
        Object object2 = "indices";
        f0.p(object, (String)object2);
        int s102 = u.Y((Iterable)((Object)object), 10);
        if (s102 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(s102);
        object = object.iterator();
        while ((s10 = object.hasNext()) != 0) {
            short s10 = ((Number)object.next()).intValue();
            s10 = sArray[s10];
            object2 = s10;
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final int[] Eu(int[] nArray) {
        String string2 = "$this$sortedArray";
        f0.p(nArray, string2);
        int n10 = nArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return nArray;
        }
        n10 = nArray.length;
        nArray = Arrays.copyOf(nArray, n10);
        f0.o(nArray, "java.util.Arrays.copyOf(this, size)");
        f.x1.n.l3(nArray);
        return nArray;
    }

    public static final Set Ev(int[] object, Iterable iterable) {
        f0.p(object, "$this$subtract");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Ly(object);
        y.G0((Collection)object, iterable);
        return object;
    }

    private static final long Ew(char[] cArray, l l10) {
        int n10 = cArray.length;
        long l11 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = cArray[i10];
            Serializable serializable = Character.valueOf(c10);
            serializable = (Number)l10.invoke(serializable);
            long l12 = ((Number)serializable).longValue();
            l11 += l12;
        }
        return l11;
    }

    public static final List Ex(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$takeLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Rd(objectArray); i10 >= 0; i10 += -1) {
            Object object = objectArray[i10];
            boolean bl2 = (Boolean)(object = (Boolean)l10.invoke(object));
            if (bl2) continue;
            return ArraysKt___ArraysKt.I8(objectArray, ++i10);
        }
        return ArraysKt___ArraysKt.uy(objectArray);
    }

    public static final List Ey(Object[] object) {
        f0.p(object, "$this$toMutableList");
        object = CollectionsKt__CollectionsKt.s(object);
        ArrayList arrayList = new ArrayList(object);
        return arrayList;
    }

    public static final List Ez(double[] dArray, Iterable object) {
        boolean bl2;
        f0.p(dArray, "$this$zip");
        String string2 = "other";
        f0.p(object, string2);
        int n10 = dArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n11);
        object = object.iterator();
        n11 = 0;
        Pair pair = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            double d10 = dArray[n11];
            pair = w0.a(d10, e10);
            arrayList.add(pair);
            n11 = n12;
        }
        return arrayList;
    }

    public static final boolean F4(double[] dArray, l l10) {
        f0.p(dArray, "$this$any");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (double d10 : dArray) {
            Constable constable = Double.valueOf(d10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static final Map F5(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$associateBy");
        String string2 = "keySelector";
        f0.p(l10, string2);
        int n10 = s0.j(objectArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (Object object : objectArray) {
            Object object2 = l10.invoke(object);
            linkedHashMap.put(object2, object);
        }
        return linkedHashMap;
    }

    public static final double F6(double[] dArray) {
        double d10;
        double d11;
        String string2 = "$this$average";
        f0.p(dArray, string2);
        int n10 = dArray.length;
        double d12 = d11 = 0.0;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d13 = dArray[i10];
            d12 += d13;
            ++n11;
        }
        if (n11 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            d10 = n11;
            d10 = d12 / d10;
        }
        return d10;
    }

    private static final long F7(long[] lArray) {
        f0.p(lArray, "$this$component5");
        return lArray[4];
    }

    public static final List F8(float[] object, int n10) {
        f0.p(object, "$this$drop");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((float[])object).length - n10, 0);
            return ArraysKt___ArraysKt.sx((float[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List F9(char[] cArray, l l10) {
        f0.p(cArray, "$this$filter");
        f0.p(l10, "predicate");
        ArrayList<Character> arrayList = new ArrayList<Character>();
        for (char c10 : cArray) {
            Comparable<Character> comparable = Character.valueOf(c10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            Character c11 = Character.valueOf(c10);
            arrayList.add(c11);
        }
        return arrayList;
    }

    public static final Collection Fa(int[] nArray, Collection collection, l l10) {
        f0.p(nArray, "$this$filterTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int n10 : nArray) {
            Constable constable = Integer.valueOf(n10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            Integer n11 = n10;
            collection.add(n11);
        }
        return collection;
    }

    public static final Integer Fb(int[] nArray, l l10) {
        f0.p(nArray, "$this$firstOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int n10 : nArray) {
            Constable constable = Integer.valueOf(n10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return n10;
        }
        return null;
    }

    public static final Object Fc(long[] lArray, Object object, p p10) {
        f0.p(lArray, "$this$fold");
        String string2 = "operation";
        f0.p(p10, string2);
        for (long l10 : lArray) {
            Long l11 = l10;
            object = p10.invoke(object, l11);
        }
        return object;
    }

    public static final k Fd(float[] fArray) {
        f0.p(fArray, "$this$indices");
        int n10 = ArraysKt___ArraysKt.Od(fArray);
        k k10 = new k(0, n10);
        return k10;
    }

    public static final Map Fe(byte[] byArray, Map map, l l10, l l11) {
        f0.p(byArray, "$this$groupByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (byte by2 : byArray) {
            Object object = by2;
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = by2;
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return map;
    }

    public static final Set Ff(short[] object, Iterable iterable) {
        f0.p(object, "$this$intersect");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Oy(object);
        y.Q0((Collection)object, iterable);
        return object;
    }

    public static /* synthetic */ String Fg(long[] lArray, CharSequence charSequence, CharSequence object, CharSequence charSequence2, int n10, CharSequence charSequence3, l l10, int n11, Object object2) {
        int n12 = n11 & 1;
        if (n12 != 0) {
            charSequence = ", ";
        }
        n12 = n11 & 2;
        CharSequence charSequence4 = "";
        object2 = n12 != 0 ? charSequence4 : object;
        int n13 = n11 & 4;
        if (n13 == 0) {
            charSequence4 = charSequence2;
        }
        n13 = n11 & 8;
        if (n13 != 0) {
            n10 = -1;
        }
        int n14 = n10;
        n13 = n11 & 0x10;
        if (n13 != 0) {
            charSequence3 = "...";
        }
        CharSequence charSequence5 = charSequence3;
        n13 = n11 & 0x20;
        if (n13 != 0) {
            l10 = null;
        }
        object = lArray;
        charSequence2 = charSequence;
        Object object3 = object2;
        charSequence3 = charSequence4;
        object2 = l10;
        return ArraysKt___ArraysKt.wg(lArray, charSequence, (CharSequence)object3, charSequence4, n14, charSequence5, l10);
    }

    public static final List Fh(float[] fArray, l l10) {
        f0.p(fArray, "$this$map");
        f0.p(l10, "transform");
        int n10 = fArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            object = l10.invoke(object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Integer Fi(int[] object, l l10) {
        f0.p(object, "$this$maxBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = ((int[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Pd(object);
            if (n11 == 0) {
                object = n10;
            } else {
                Comparable<Integer> comparable = n10;
                comparable = (Comparable)l10.invoke(comparable);
                if (n12 <= n11) {
                    while (true) {
                        int n13 = object[n12];
                        Comparable<Integer> comparable2 = n13;
                        int n14 = comparable.compareTo((Integer)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n14 < 0) {
                            n10 = n13;
                            comparable = comparable2;
                        }
                        if (n12 == n11) break;
                        ++n12;
                    }
                }
                object = n10;
            }
        }
        return object;
    }

    private static final Double Fj(float[] fArray, l l10) {
        Number number;
        float f10;
        int n10 = fArray.length;
        int n11 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n11;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        f10 = fArray[0];
        number = Float.valueOf(f10);
        number = (Number)l10.invoke(number);
        double d10 = number.doubleValue();
        int n12 = ArraysKt___ArraysKt.Od(fArray);
        if (n11 <= n12) {
            while (true) {
                float f12 = fArray[n11];
                Number number2 = Float.valueOf(f12);
                number2 = (Number)l10.invoke(number2);
                double d11 = number2.doubleValue();
                d10 = Math.max(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Boolean Fk(boolean[] blArray, Comparator comparator) {
        f0.p(blArray, "$this$maxWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = blArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = blArray[0];
        n11 = ArraysKt___ArraysKt.Td(blArray);
        if (n12 <= n11) {
            while (true) {
                Boolean bl2;
                int n13 = blArray[n12];
                Boolean bl3 = n10 != 0;
                int n14 = comparator.compare(bl3, bl2 = Boolean.valueOf(n13 != 0));
                if (n14 < 0) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return n10 != 0;
    }

    private static final float Fl(Object[] objectArray, l l10) {
        Object object;
        float f10;
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            object = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            object = objectArray[0];
            object = (Number)l10.invoke(object);
            f10 = ((Number)object).floatValue();
            n11 = ArraysKt___ArraysKt.Rd(objectArray);
            if (n12 <= n11) {
                while (true) {
                    Object object2 = objectArray[n12];
                    object2 = (Number)l10.invoke(object2);
                    float f12 = ((Number)object2).floatValue();
                    f10 = Math.min(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        objectArray = new NoSuchElementException();
        throw objectArray;
    }

    private static final Object Fm(int[] nArray, Comparator comparator, l l10) {
        Object object;
        int n10 = nArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray[0];
        object = n10;
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Pd(nArray);
        if (n12 <= n11) {
            while (true) {
                int n13 = nArray[n12];
                Object object2 = n13;
                int n14 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n14 > 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    private static final char[] Fn(char[] cArray, l l10) {
        int n10 = cArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = cArray[i10];
            Character c11 = Character.valueOf(c10);
            l10.invoke(c11);
        }
        return cArray;
    }

    private static final Float Fo(float[] fArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.Go(fArray, e$a);
    }

    public static final Object Fp(Object[] object, p p10) {
        f0.p(object, "$this$reduceRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Rd(object);
        if (n10 >= 0) {
            int n11 = n10 + -1;
            object2 = object[n10];
            while (n11 >= 0) {
                int n12 = n11 + -1;
                Object object3 = object[n11];
                object2 = p10.invoke(object3, object2);
                n11 = n12;
            }
            return object2;
        }
        object = new UnsupportedOperationException("Empty array can't be reduced.");
        throw object;
    }

    public static final List Fq(float[] object) {
        String string2 = "$this$reversed";
        f0.p(object, string2);
        int n10 = ((float[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = ArraysKt___ArraysKt.By(object);
        a0.e1((List)object);
        return object;
    }

    private static final List Fr(char[] object, Object object2, p p10) {
        ArrayList<Object> arrayList;
        int n10 = ((char[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            char c10 = ((char[])object).length + n12;
            arrayList = new ArrayList<Object>(c10);
            arrayList.add(object2);
            n12 = ((char[])object).length;
            while (n11 < n12) {
                c10 = object[n11];
                Character c11 = Character.valueOf(c10);
                object2 = p10.invoke(object2, c11);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final void Fs(boolean[] blArray, e e10) {
        int n10;
        f0.p(blArray, "$this$shuffle");
        String string2 = "random";
        f0.p(e10, string2);
        for (int i10 = ArraysKt___ArraysKt.Td(blArray); i10 >= (n10 = 1); i10 += -1) {
            boolean bl2;
            n10 = i10 + 1;
            n10 = e10.m(n10);
            boolean bl3 = blArray[i10];
            blArray[i10] = bl2 = blArray[n10];
            blArray[n10] = bl3;
        }
    }

    public static final List Ft(short[] sArray, k k10) {
        f0.p(sArray, "$this$slice");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.u(f.x1.n.N1(sArray, n10, n11));
    }

    public static final long[] Fu(long[] lArray) {
        String string2 = "$this$sortedArray";
        f0.p(lArray, string2);
        int n10 = lArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return lArray;
        }
        n10 = lArray.length;
        lArray = Arrays.copyOf(lArray, n10);
        f0.o(lArray, "java.util.Arrays.copyOf(this, size)");
        f.x1.n.n3(lArray);
        return lArray;
    }

    public static final Set Fv(long[] object, Iterable iterable) {
        f0.p(object, "$this$subtract");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.My(object);
        y.G0((Collection)object, iterable);
        return object;
    }

    private static final long Fw(double[] dArray, l l10) {
        int n10 = dArray.length;
        long l11 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            Number number = d10;
            number = (Number)l10.invoke(number);
            long l12 = number.longValue();
            l11 += l12;
        }
        return l11;
    }

    public static final List Fx(short[] sArray, l l10) {
        f0.p(sArray, "$this$takeLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Sd(sArray); i10 >= 0; i10 += -1) {
            Constable constable = Short.valueOf(sArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return ArraysKt___ArraysKt.J8(sArray, ++i10);
        }
        return ArraysKt___ArraysKt.vy(sArray);
    }

    public static final List Fy(short[] sArray) {
        f0.p(sArray, "$this$toMutableList");
        int n10 = sArray.length;
        ArrayList<Short> arrayList = new ArrayList<Short>(n10);
        for (short s10 : sArray) {
            Short s11 = s10;
            arrayList.add(s11);
        }
        return arrayList;
    }

    public static final List Fz(double[] dArray, Iterable object, p p10) {
        boolean bl2;
        f0.p(dArray, "$this$zip");
        f0.p(object, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = dArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        n11 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            double d10 = dArray[n11];
            object2 = d10;
            object2 = p10.invoke(object2, e10);
            arrayList.add(object2);
            n11 = n12;
        }
        return arrayList;
    }

    public static final boolean G4(float[] fArray) {
        String string2 = "$this$any";
        f0.p(fArray, string2);
        int n10 = fArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            fArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final Map G5(Object[] objectArray, l l10, l l11) {
        f0.p(objectArray, "$this$associateBy");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        int n10 = s0.j(objectArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (Object object : objectArray) {
            Object object2 = l10.invoke(object);
            object = l11.invoke(object);
            linkedHashMap.put(object2, object);
        }
        return linkedHashMap;
    }

    public static final double G6(float[] fArray) {
        double d10;
        double d11;
        String string2 = "$this$average";
        f0.p(fArray, string2);
        int n10 = fArray.length;
        double d12 = d11 = 0.0;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            double d13 = f10;
            d12 += d13;
            ++n11;
        }
        if (n11 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            d10 = n11;
            d10 = d12 / d10;
        }
        return d10;
    }

    private static final Object G7(Object[] objectArray) {
        f0.p(objectArray, "$this$component5");
        return objectArray[4];
    }

    public static final List G8(int[] object, int n10) {
        f0.p(object, "$this$drop");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((int[])object).length - n10, 0);
            return ArraysKt___ArraysKt.tx((int[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List G9(double[] dArray, l l10) {
        f0.p(dArray, "$this$filter");
        f0.p(l10, "predicate");
        ArrayList<Double> arrayList = new ArrayList<Double>();
        for (double d10 : dArray) {
            Constable constable = Double.valueOf(d10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            Double d11 = d10;
            arrayList.add(d11);
        }
        return arrayList;
    }

    public static final Collection Ga(long[] lArray, Collection collection, l l10) {
        f0.p(lArray, "$this$filterTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (long l11 : lArray) {
            Constable constable = Long.valueOf(l11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            Long l12 = l11;
            collection.add(l12);
        }
        return collection;
    }

    public static final Long Gb(long[] object) {
        String string2 = "$this$firstOrNull";
        f0.p(object, string2);
        int n10 = ((long[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            long l10 = object[0];
            object = l10;
        }
        return object;
    }

    public static final Object Gc(Object[] objectArray, Object object, p p10) {
        f0.p(objectArray, "$this$fold");
        String string2 = "operation";
        f0.p(p10, string2);
        for (Object object2 : objectArray) {
            object = p10.invoke(object, object2);
        }
        return object;
    }

    public static final k Gd(int[] nArray) {
        f0.p(nArray, "$this$indices");
        int n10 = ArraysKt___ArraysKt.Pd(nArray);
        k k10 = new k(0, n10);
        return k10;
    }

    public static final Map Ge(char[] cArray, Map map, l l10) {
        f0.p(cArray, "$this$groupByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Character c11 = Character.valueOf(c10);
            object2.add((Character)c11);
        }
        return map;
    }

    public static final Set Gf(boolean[] object, Iterable iterable) {
        f0.p(object, "$this$intersect");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Py(object);
        y.Q0((Collection)object, iterable);
        return object;
    }

    public static /* synthetic */ String Gg(Object[] objectArray, CharSequence charSequence, CharSequence objectArray2, CharSequence charSequence2, int n10, CharSequence charSequence3, l l10, int n11, Object object) {
        int n12 = n11 & 1;
        if (n12 != 0) {
            charSequence = ", ";
        }
        n12 = n11 & 2;
        CharSequence charSequence4 = "";
        object = n12 != 0 ? charSequence4 : objectArray2;
        int n13 = n11 & 4;
        if (n13 == 0) {
            charSequence4 = charSequence2;
        }
        n13 = n11 & 8;
        if (n13 != 0) {
            n10 = -1;
        }
        int n14 = n10;
        n13 = n11 & 0x10;
        if (n13 != 0) {
            charSequence3 = "...";
        }
        CharSequence charSequence5 = charSequence3;
        n13 = n11 & 0x20;
        if (n13 != 0) {
            l10 = null;
        }
        objectArray2 = objectArray;
        charSequence2 = charSequence;
        Object object2 = object;
        charSequence3 = charSequence4;
        object = l10;
        return ArraysKt___ArraysKt.xg(objectArray, charSequence, (CharSequence)object2, charSequence4, n14, charSequence5, l10);
    }

    public static final List Gh(int[] nArray, l l10) {
        f0.p(nArray, "$this$map");
        f0.p(l10, "transform");
        int n10 = nArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int n11 : nArray) {
            Object object = n11;
            object = l10.invoke(object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Long Gi(long[] object, l l10) {
        f0.p(object, "$this$maxBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = ((long[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            long l11 = object[0];
            int n12 = ArraysKt___ArraysKt.Qd(object);
            if (n12 == 0) {
                object = l11;
            } else {
                Comparable<Long> comparable = l11;
                comparable = (Comparable)l10.invoke(comparable);
                if (n11 <= n12) {
                    while (true) {
                        long l12 = object[n11];
                        Comparable<Long> comparable2 = l12;
                        int n13 = comparable.compareTo((Long)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n13 < 0) {
                            l11 = l12;
                            comparable = comparable2;
                        }
                        if (n11 == n12) break;
                        ++n11;
                    }
                }
                object = l11;
            }
        }
        return object;
    }

    private static final Double Gj(int[] nArray, l l10) {
        Number number;
        int n10 = nArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray[0];
        number = n10;
        number = (Number)l10.invoke(number);
        double d10 = number.doubleValue();
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 <= n12) {
            while (true) {
                int n13 = nArray[n11];
                Number number2 = n13;
                number2 = (Number)l10.invoke(number2);
                double d11 = number2.doubleValue();
                d10 = Math.max(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Byte Gk(byte[] byArray, Comparator comparator) {
        f0.p(byArray, "$this$maxWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = byArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray[0];
        n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n12 <= n11) {
            while (true) {
                Byte by2;
                int n13 = byArray[n12];
                Byte by3 = (byte)n10;
                int n14 = comparator.compare(by3, by2 = Byte.valueOf((byte)n13));
                if (n14 < 0) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return (byte)n10;
    }

    private static final float Gl(short[] object, l l10) {
        Number number;
        float f10;
        int n10 = ((short[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            n10 = object[0];
            number = (short)n10;
            number = (Number)l10.invoke(number);
            f10 = number.floatValue();
            n11 = ArraysKt___ArraysKt.Sd(object);
            if (n12 <= n11) {
                while (true) {
                    short s10 = object[n12];
                    Number number2 = s10;
                    number2 = (Number)l10.invoke(number2);
                    float f12 = number2.floatValue();
                    f10 = Math.min(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object Gm(long[] lArray, Comparator comparator, l l10) {
        Object object;
        int n10 = lArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        long l11 = lArray[0];
        object = l11;
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n12 <= n11) {
            while (true) {
                long l12 = lArray[n12];
                Object object2 = l12;
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 > 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    private static final double[] Gn(double[] dArray, l l10) {
        int n10 = dArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            Double d11 = d10;
            l10.invoke(d11);
        }
        return dArray;
    }

    public static final Float Go(float[] fArray, e e10) {
        f0.p(fArray, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = fArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = fArray.length;
        int n11 = e10.m(n10);
        return Float.valueOf(fArray[n11]);
    }

    public static final short Gp(short[] object, p p10) {
        f0.p(object, "$this$reduceRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int s10 = ArraysKt___ArraysKt.Sd((short[])object);
        if (s10 >= 0) {
            short s11;
            int n10 = s10 + -1;
            Object object3 = object[s10];
            while (n10 >= 0) {
                int n11 = n10 + -1;
                Short s12 = (short)object[n10];
                object2 = s11;
                object2 = (Number)p10.invoke(s12, object2);
                s11 = ((Number)object2).shortValue();
                n10 = n11;
            }
            return s11;
        }
        object = new UnsupportedOperationException("Empty array can't be reduced.");
        throw object;
    }

    public static final List Gq(int[] object) {
        String string2 = "$this$reversed";
        f0.p(object, string2);
        int n10 = ((int[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = ArraysKt___ArraysKt.Cy(object);
        a0.e1((List)object);
        return object;
    }

    private static final List Gr(double[] object, Object object2, p p10) {
        ArrayList<Object> arrayList;
        int n10 = ((double[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            int n13 = ((double[])object).length + n12;
            arrayList = new ArrayList<Object>(n13);
            arrayList.add(object2);
            n12 = ((double[])object).length;
            while (n11 < n12) {
                double d10 = object[n11];
                Double d11 = d10;
                object2 = p10.invoke(object2, d11);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final byte Gs(byte[] object) {
        String string2 = "$this$single";
        f0.p(object, string2);
        int n10 = ((byte[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                return object[0];
            }
            object = new IllegalArgumentException;
            object("Array has more than one element.");
            throw object;
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final List Gt(boolean[] blArray, Iterable object) {
        boolean bl2;
        f0.p(blArray, "$this$slice");
        Object object2 = "indices";
        f0.p(object, (String)object2);
        int bl22 = u.Y((Iterable)((Object)object), 10);
        if (bl22 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(bl22);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            boolean bl2 = ((Number)object.next()).intValue();
            bl2 = blArray[bl2];
            object2 = bl2;
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final Comparable[] Gu(Comparable[] comparableArray) {
        String string2 = "$this$sortedArray";
        f0.p(comparableArray, string2);
        int n10 = comparableArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return comparableArray;
        }
        n10 = comparableArray.length;
        comparableArray = Arrays.copyOf(comparableArray, n10);
        f0.o(comparableArray, "java.util.Arrays.copyOf(this, size)");
        Objects.requireNonNull(comparableArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        f.x1.n.r3(comparableArray);
        return comparableArray;
    }

    public static final Set Gv(Object[] object, Iterable iterable) {
        f0.p(object, "$this$subtract");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Ny(object);
        y.G0((Collection)object, iterable);
        return object;
    }

    private static final long Gw(float[] fArray, l l10) {
        int n10 = fArray.length;
        long l11 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Number number = Float.valueOf(f10);
            number = (Number)l10.invoke(number);
            long l12 = number.longValue();
            l11 += l12;
        }
        return l11;
    }

    public static final List Gx(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$takeLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Td(blArray); i10 >= 0; i10 += -1) {
            Boolean bl2 = blArray[i10];
            boolean bl3 = bl2 = (Boolean)l10.invoke(bl2);
            if (bl3) continue;
            return ArraysKt___ArraysKt.K8(blArray, ++i10);
        }
        return ArraysKt___ArraysKt.wy(blArray);
    }

    public static final List Gy(boolean[] blArray) {
        f0.p(blArray, "$this$toMutableList");
        int n10 = blArray.length;
        ArrayList<Boolean> arrayList = new ArrayList<Boolean>(n10);
        for (boolean bl2 : blArray) {
            Boolean bl3 = bl2;
            arrayList.add(bl3);
        }
        return arrayList;
    }

    public static final List Gz(double[] dArray, double[] dArray2) {
        f0.p(dArray, "$this$zip");
        String string2 = "other";
        f0.p(dArray2, string2);
        int n10 = dArray.length;
        int n11 = dArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Double> arrayList = new ArrayList<Double>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            double d11 = dArray2[i10];
            Serializable serializable = d10;
            Double d12 = d11;
            serializable = w0.a(serializable, d12);
            arrayList.add((Double)serializable);
        }
        return arrayList;
    }

    public static final boolean H4(float[] fArray, l l10) {
        f0.p(fArray, "$this$any");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (float f10 : fArray) {
            Constable constable = Float.valueOf(f10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static final Map H5(short[] sArray, l l10) {
        f0.p(sArray, "$this$associateBy");
        String string2 = "keySelector";
        f0.p(l10, string2);
        int n10 = s0.j(sArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Short> linkedHashMap = new LinkedHashMap<Object, Short>(n10);
        for (short s10 : sArray) {
            Object object = s10;
            object = l10.invoke(object);
            Short s11 = s10;
            linkedHashMap.put(object, s11);
        }
        return linkedHashMap;
    }

    public static final double H6(int[] nArray) {
        double d10;
        double d11;
        String string2 = "$this$average";
        f0.p(nArray, string2);
        int n10 = nArray.length;
        double d12 = d11 = 0.0;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            double d13 = n12;
            d12 += d13;
            ++n11;
        }
        if (n11 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            d10 = n11;
            d10 = d12 / d10;
        }
        return d10;
    }

    private static final short H7(short[] sArray) {
        f0.p(sArray, "$this$component5");
        return sArray[4];
    }

    public static final List H8(long[] object, int n10) {
        f0.p(object, "$this$drop");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((long[])object).length - n10, 0);
            return ArraysKt___ArraysKt.ux((long[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List H9(float[] fArray, l l10) {
        f0.p(fArray, "$this$filter");
        f0.p(l10, "predicate");
        ArrayList<Float> arrayList = new ArrayList<Float>();
        for (float f10 : fArray) {
            Constable constable = Float.valueOf(f10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            Float f11 = Float.valueOf(f10);
            arrayList.add(f11);
        }
        return arrayList;
    }

    public static final Collection Ha(Object[] objectArray, Collection collection, l l10) {
        f0.p(objectArray, "$this$filterTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (Object object : objectArray) {
            Boolean bl2 = (Boolean)l10.invoke(object);
            boolean bl3 = bl2;
            if (!bl3) continue;
            collection.add(object);
        }
        return collection;
    }

    public static final Long Hb(long[] lArray, l l10) {
        f0.p(lArray, "$this$firstOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (long l11 : lArray) {
            Constable constable = Long.valueOf(l11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return l11;
        }
        return null;
    }

    public static final Object Hc(short[] sArray, Object object, p p10) {
        f0.p(sArray, "$this$fold");
        String string2 = "operation";
        f0.p(p10, string2);
        for (short s10 : sArray) {
            Short s11 = s10;
            object = p10.invoke(object, s11);
        }
        return object;
    }

    public static final k Hd(long[] lArray) {
        f0.p(lArray, "$this$indices");
        int n10 = ArraysKt___ArraysKt.Qd(lArray);
        k k10 = new k(0, n10);
        return k10;
    }

    public static final Map He(char[] cArray, Map map, l l10, l l11) {
        f0.p(cArray, "$this$groupByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = Character.valueOf(c10);
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return map;
    }

    private static final boolean Hf(byte[] byArray) {
        boolean bl2 = byArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            byArray = null;
        }
        return bl2;
    }

    public static /* synthetic */ String Hg(short[] sArray, CharSequence charSequence, CharSequence object, CharSequence charSequence2, int n10, CharSequence charSequence3, l l10, int n11, Object object2) {
        int n12 = n11 & 1;
        if (n12 != 0) {
            charSequence = ", ";
        }
        n12 = n11 & 2;
        CharSequence charSequence4 = "";
        object2 = n12 != 0 ? charSequence4 : object;
        int n13 = n11 & 4;
        if (n13 == 0) {
            charSequence4 = charSequence2;
        }
        n13 = n11 & 8;
        if (n13 != 0) {
            n10 = -1;
        }
        int n14 = n10;
        n13 = n11 & 0x10;
        if (n13 != 0) {
            charSequence3 = "...";
        }
        CharSequence charSequence5 = charSequence3;
        n13 = n11 & 0x20;
        if (n13 != 0) {
            l10 = null;
        }
        object = sArray;
        charSequence2 = charSequence;
        Object object3 = object2;
        charSequence3 = charSequence4;
        object2 = l10;
        return ArraysKt___ArraysKt.yg(sArray, charSequence, (CharSequence)object3, charSequence4, n14, charSequence5, l10);
    }

    public static final List Hh(long[] lArray, l l10) {
        f0.p(lArray, "$this$map");
        f0.p(l10, "transform");
        int n10 = lArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (long l11 : lArray) {
            Object object = l11;
            object = l10.invoke(object);
            arrayList.add(object);
        }
        return arrayList;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static final Object Hi(Object[] objectArray, l l10) {
        void var0_3;
        void var1_4;
        f0.p(objectArray, "$this$maxBy");
        Object object = "selector";
        f0.p(var1_4, (String)object);
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return var0_3;
        }
        object = objectArray[0];
        n11 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n11 != 0) {
            Comparable comparable = (Comparable)var1_4.invoke(object);
            if (n12 <= n11) {
                while (true) {
                    Object object2;
                    Comparable comparable2;
                    int n13;
                    if ((n13 = comparable.compareTo(comparable2 = (Comparable)var1_4.invoke(object2 = objectArray[n12]))) < 0) {
                        object = object2;
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
        }
        Object object3 = object;
        return var0_3;
    }

    private static final Double Hj(long[] lArray, l l10) {
        Number number;
        int n10 = lArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return null;
        }
        long l11 = lArray[0];
        number = l11;
        number = (Number)l10.invoke(number);
        double d10 = number.doubleValue();
        int n12 = ArraysKt___ArraysKt.Qd(lArray);
        if (n11 <= n12) {
            while (true) {
                long l12 = lArray[n11];
                Number number2 = l12;
                number2 = (Number)l10.invoke(number2);
                double d11 = number2.doubleValue();
                d10 = Math.max(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Character Hk(char[] cArray, Comparator comparator) {
        f0.p(cArray, "$this$maxWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray[0];
        n11 = ArraysKt___ArraysKt.Md(cArray);
        if (n12 <= n11) {
            while (true) {
                Character c10;
                int n13 = cArray[n12];
                Character c11 = Character.valueOf((char)n10);
                int n14 = comparator.compare(c11, c10 = Character.valueOf((char)n13));
                if (n14 < 0) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Character.valueOf((char)n10);
    }

    private static final float Hl(boolean[] object, l l10) {
        Serializable serializable;
        float f10;
        int n10 = ((boolean[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            serializable = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            n10 = object[0];
            serializable = Boolean.valueOf(n10 != 0);
            serializable = (Number)l10.invoke(serializable);
            f10 = ((Number)serializable).floatValue();
            n11 = ArraysKt___ArraysKt.Td(object);
            if (n12 <= n11) {
                while (true) {
                    boolean bl2 = object[n12];
                    Serializable serializable2 = Boolean.valueOf(bl2);
                    serializable2 = (Number)l10.invoke(serializable2);
                    float f12 = ((Number)serializable2).floatValue();
                    f10 = Math.min(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object Hm(Object[] objectArray, Comparator comparator, l l10) {
        Object object;
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        object = objectArray[0];
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n12 <= n11) {
            while (true) {
                Object object2 = objectArray[n12];
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 > 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    private static final float[] Hn(float[] fArray, l l10) {
        int n10 = fArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Float f11 = Float.valueOf(f10);
            l10.invoke(f11);
        }
        return fArray;
    }

    private static final Integer Ho(int[] nArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.Io(nArray, e$a);
    }

    public static final boolean Hp(boolean[] object, p p10) {
        f0.p(object, "$this$reduceRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Td((boolean[])object);
        if (n10 >= 0) {
            boolean bl2;
            int n11 = n10 + -1;
            Object object3 = object[n10];
            while (n11 >= 0) {
                int n12 = n11 + -1;
                Boolean bl3 = (boolean)object[n11];
                object2 = bl2;
                object2 = (Boolean)p10.invoke(bl3, object2);
                bl2 = (Boolean)object2;
                n11 = n12;
            }
            return bl2;
        }
        object = new UnsupportedOperationException("Empty array can't be reduced.");
        throw object;
    }

    public static final List Hq(long[] object) {
        String string2 = "$this$reversed";
        f0.p(object, string2);
        int n10 = ((long[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = ArraysKt___ArraysKt.Dy(object);
        a0.e1((List)object);
        return object;
    }

    private static final List Hr(float[] object, Object object2, p p10) {
        ArrayList<Object> arrayList;
        int n10 = ((float[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            int n13 = ((float[])object).length + n12;
            arrayList = new ArrayList<Object>(n13);
            arrayList.add(object2);
            n12 = ((float[])object).length;
            while (n11 < n12) {
                float f10 = object[n11];
                Float f11 = Float.valueOf(f10);
                object2 = p10.invoke(object2, f11);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final byte Hs(byte[] object, l l10) {
        f0.p(object, "$this$single");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((byte[])object).length;
        boolean bl2 = false;
        Byte by2 = null;
        boolean bl3 = false;
        Byte by3 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by4 = object[i10];
            Constable constable = Byte.valueOf(by4);
            boolean bl4 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl4) continue;
            if (!bl3) {
                by3 = by4;
                bl2 = true;
                by2 = by3;
                bl3 = bl2;
                continue;
            }
            object = new IllegalArgumentException;
            object("Array contains more than one matching element.");
            throw object;
        }
        if (bl3) {
            Objects.requireNonNull(by2, "null cannot be cast to non-null type kotlin.Byte");
            return by2;
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final List Ht(boolean[] blArray, k k10) {
        f0.p(blArray, "$this$slice");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.v(f.x1.n.O1(blArray, n10, n11));
    }

    public static final short[] Hu(short[] sArray) {
        String string2 = "$this$sortedArray";
        f0.p(sArray, string2);
        int n10 = sArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return sArray;
        }
        n10 = sArray.length;
        sArray = Arrays.copyOf(sArray, n10);
        f0.o(sArray, "java.util.Arrays.copyOf(this, size)");
        f.x1.n.t3(sArray);
        return sArray;
    }

    public static final Set Hv(short[] object, Iterable iterable) {
        f0.p(object, "$this$subtract");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Oy(object);
        y.G0((Collection)object, iterable);
        return object;
    }

    private static final long Hw(int[] nArray, l l10) {
        int n10 = nArray.length;
        long l11 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = nArray[i10];
            Number number = n11;
            number = (Number)l10.invoke(number);
            long l12 = number.longValue();
            l11 += l12;
        }
        return l11;
    }

    public static final List Hx(byte[] byArray, l l10) {
        f0.p(byArray, "$this$takeWhile");
        f0.p(l10, "predicate");
        ArrayList<Byte> arrayList = new ArrayList<Byte>();
        for (byte by2 : byArray) {
            Constable constable = Byte.valueOf(by2);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) break;
            Byte by3 = by2;
            arrayList.add(by3);
        }
        return arrayList;
    }

    public static final Set Hy(byte[] byArray) {
        f0.p(byArray, "$this$toMutableSet");
        int n10 = s0.j(byArray.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet(n10);
        return (Set)ArraysKt___ArraysKt.Tx(byArray, linkedHashSet);
    }

    public static final List Hz(double[] dArray, double[] dArray2, p p10) {
        f0.p(dArray, "$this$zip");
        f0.p(dArray2, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = dArray.length;
        int n11 = dArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            Object object = d10;
            double d11 = dArray2[i10];
            Double d12 = d11;
            object = p10.invoke(object, d12);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final boolean I4(int[] nArray) {
        String string2 = "$this$any";
        f0.p(nArray, string2);
        int n10 = nArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            nArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final Map I5(short[] sArray, l l10, l l11) {
        f0.p(sArray, "$this$associateBy");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        int n10 = s0.j(sArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (short s10 : sArray) {
            Object object = s10;
            object = l10.invoke(object);
            Object object2 = s10;
            object2 = l11.invoke(object2);
            linkedHashMap.put(object, object2);
        }
        return linkedHashMap;
    }

    public static final double I6(long[] lArray) {
        double d10;
        double d11;
        String string2 = "$this$average";
        f0.p(lArray, string2);
        int n10 = lArray.length;
        double d12 = d11 = 0.0;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            double d13 = l10;
            d12 += d13;
            ++n11;
        }
        if (n11 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            d10 = n11;
            d10 = d12 / d10;
        }
        return d10;
    }

    private static final boolean I7(boolean[] blArray) {
        f0.p(blArray, "$this$component5");
        return blArray[4];
    }

    public static final List I8(Object[] object, int n10) {
        f0.p(object, "$this$drop");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((Object[])object).length - n10, 0);
            return ArraysKt___ArraysKt.vx((Object[])object, n10);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List I9(int[] nArray, l l10) {
        f0.p(nArray, "$this$filter");
        f0.p(l10, "predicate");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int n10 : nArray) {
            Constable constable = Integer.valueOf(n10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            Integer n11 = n10;
            arrayList.add(n11);
        }
        return arrayList;
    }

    public static final Collection Ia(short[] sArray, Collection collection, l l10) {
        f0.p(sArray, "$this$filterTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (short s10 : sArray) {
            Constable constable = Short.valueOf(s10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            Short s11 = s10;
            collection.add(s11);
        }
        return collection;
    }

    public static final Object Ib(Object[] object) {
        String string2 = "$this$firstOrNull";
        f0.p(object, string2);
        int n10 = ((Object[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        object = n10 != 0 ? null : object[0];
        return object;
    }

    public static final Object Ic(boolean[] blArray, Object object, p p10) {
        f0.p(blArray, "$this$fold");
        String string2 = "operation";
        f0.p(p10, string2);
        for (boolean bl2 : blArray) {
            Boolean bl3 = bl2;
            object = p10.invoke(object, bl3);
        }
        return object;
    }

    public static final k Id(Object[] objectArray) {
        f0.p(objectArray, "$this$indices");
        int n10 = ArraysKt___ArraysKt.Rd(objectArray);
        k k10 = new k(0, n10);
        return k10;
    }

    public static final Map Ie(double[] dArray, Map map, l l10) {
        f0.p(dArray, "$this$groupByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (double d10 : dArray) {
            Object object = d10;
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Double d11 = d10;
            object2.add((Double)d11);
        }
        return map;
    }

    private static final boolean If(char[] cArray) {
        boolean bl2 = cArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            cArray = null;
        }
        return bl2;
    }

    public static /* synthetic */ String Ig(boolean[] blArray, CharSequence charSequence, CharSequence object, CharSequence charSequence2, int n10, CharSequence charSequence3, l l10, int n11, Object object2) {
        int n12 = n11 & 1;
        if (n12 != 0) {
            charSequence = ", ";
        }
        n12 = n11 & 2;
        CharSequence charSequence4 = "";
        object2 = n12 != 0 ? charSequence4 : object;
        int n13 = n11 & 4;
        if (n13 == 0) {
            charSequence4 = charSequence2;
        }
        n13 = n11 & 8;
        if (n13 != 0) {
            n10 = -1;
        }
        int n14 = n10;
        n13 = n11 & 0x10;
        if (n13 != 0) {
            charSequence3 = "...";
        }
        CharSequence charSequence5 = charSequence3;
        n13 = n11 & 0x20;
        if (n13 != 0) {
            l10 = null;
        }
        object = blArray;
        charSequence2 = charSequence;
        Object object3 = object2;
        charSequence3 = charSequence4;
        object2 = l10;
        return ArraysKt___ArraysKt.zg(blArray, charSequence, (CharSequence)object3, charSequence4, n14, charSequence5, l10);
    }

    public static final List Ih(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$map");
        f0.p(l10, "transform");
        int n10 = objectArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (Object object : objectArray) {
            object = l10.invoke(object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Short Ii(short[] object, l l10) {
        f0.p(object, "$this$maxBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = ((short[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Sd(object);
            if (n11 == 0) {
                object = (short)n10;
            } else {
                Comparable<Short> comparable = (short)n10;
                comparable = (Comparable)l10.invoke(comparable);
                if (n12 <= n11) {
                    while (true) {
                        int n13 = object[n12];
                        Comparable<Short> comparable2 = (short)n13;
                        int n14 = comparable.compareTo((Short)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n14 < 0) {
                            n10 = n13;
                            comparable = comparable2;
                        }
                        if (n12 == n11) break;
                        ++n12;
                    }
                }
                object = (short)n10;
            }
        }
        return object;
    }

    private static final Double Ij(Object[] objectArray, l l10) {
        Object object;
        int n10 = objectArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        object = objectArray[0];
        object = (Number)l10.invoke(object);
        double d10 = ((Number)object).doubleValue();
        int n12 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n11 <= n12) {
            while (true) {
                Object object2 = objectArray[n11];
                object2 = (Number)l10.invoke(object2);
                double d11 = ((Number)object2).doubleValue();
                d10 = Math.max(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Double Ik(double[] dArray, Comparator comparator) {
        f0.p(dArray, "$this$maxWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = dArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        double d10 = dArray[0];
        int n12 = ArraysKt___ArraysKt.Nd(dArray);
        if (n11 <= n12) {
            while (true) {
                Double d11;
                double d12 = dArray[n11];
                Double d13 = d10;
                int n13 = comparator.compare(d13, d11 = Double.valueOf(d12));
                if (n13 < 0) {
                    d10 = d12;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    private static final Comparable Il(byte[] object, l l10) {
        Comparable<Byte> comparable;
        int n10 = ((byte[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            comparable = (byte)n10;
            comparable = (Comparable)l10.invoke(comparable);
            n11 = ArraysKt___ArraysKt.Ld(object);
            if (n12 <= n11) {
                while (true) {
                    byte by2 = object[n12];
                    Comparable<Byte> comparable2 = by2;
                    int n13 = comparable.compareTo((Byte)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n13 > 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object Im(short[] sArray, Comparator comparator, l l10) {
        Object object;
        int n10 = sArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray[0];
        object = (short)n10;
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n12 <= n11) {
            while (true) {
                short s10 = sArray[n12];
                Object object2 = s10;
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 > 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    private static final int[] In(int[] nArray, l l10) {
        int n10 = nArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = nArray[i10];
            Integer n12 = n11;
            l10.invoke(n12);
        }
        return nArray;
    }

    public static final Integer Io(int[] nArray, e e10) {
        f0.p(nArray, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = nArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray.length;
        int n11 = e10.m(n10);
        return nArray[n11];
    }

    public static final byte Ip(byte[] object, q q10) {
        f0.p(object, "$this$reduceRightIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int by2 = ArraysKt___ArraysKt.Ld((byte[])object);
        if (by2 >= 0) {
            byte by3;
            Object object3 = object[by2];
            for (int i10 = by2 + -1; i10 >= 0; i10 += -1) {
                Integer n10 = i10;
                Object object4 = object[i10];
                Byte by4 = (byte)object4;
                object2 = by3;
                object2 = (Number)q10.invoke(n10, by4, object2);
                by3 = ((Number)object2).byteValue();
            }
            return by3;
        }
        object = new UnsupportedOperationException("Empty array can't be reduced.");
        throw object;
    }

    public static final List Iq(Object[] object) {
        String string2 = "$this$reversed";
        f0.p(object, string2);
        int n10 = ((Object[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = ArraysKt___ArraysKt.Ey(object);
        a0.e1((List)object);
        return object;
    }

    private static final List Ir(int[] object, Object object2, p p10) {
        ArrayList<Object> arrayList;
        int n10 = ((int[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            int n13 = ((int[])object).length + n12;
            arrayList = new ArrayList<Object>(n13);
            arrayList.add(object2);
            n12 = ((int[])object).length;
            while (n11 < n12) {
                n13 = object[n11];
                Integer n14 = n13;
                object2 = p10.invoke(object2, n14);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final char Is(char[] object) {
        String string2 = "$this$single";
        f0.p(object, string2);
        int n10 = ((char[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                return object[0];
            }
            object = new IllegalArgumentException;
            object("Array has more than one element.");
            throw object;
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final byte[] It(byte[] byArray, Collection object) {
        int n10;
        f0.p(byArray, "$this$sliceArray");
        f0.p(object, "indices");
        int n11 = object.size();
        byte[] byArray2 = new byte[n11];
        object = object.iterator();
        int n12 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Number number = (Number)object.next();
            n10 = number.intValue();
            int n13 = n12 + 1;
            byArray2[n12] = n10 = byArray[n10];
            n12 = n13;
        }
        return byArray2;
    }

    public static final byte[] Iu(byte[] byArray) {
        String string2 = "$this$sortedArrayDescending";
        f0.p(byArray, string2);
        int n10 = byArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return byArray;
        }
        n10 = byArray.length;
        byArray = Arrays.copyOf(byArray, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysKt.cu(byArray);
        return byArray;
    }

    public static final Set Iv(boolean[] object, Iterable iterable) {
        f0.p(object, "$this$subtract");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Py(object);
        y.G0((Collection)object, iterable);
        return object;
    }

    private static final long Iw(long[] lArray, l l10) {
        int n10 = lArray.length;
        long l11 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            Number number = lArray[i10];
            number = (Number)l10.invoke(number);
            long l12 = number.longValue();
            l11 += l12;
        }
        return l11;
    }

    public static final List Ix(char[] cArray, l l10) {
        f0.p(cArray, "$this$takeWhile");
        f0.p(l10, "predicate");
        ArrayList<Character> arrayList = new ArrayList<Character>();
        for (char c10 : cArray) {
            Comparable<Character> comparable = Character.valueOf(c10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) break;
            Character c11 = Character.valueOf(c10);
            arrayList.add(c11);
        }
        return arrayList;
    }

    public static final Set Iy(char[] cArray) {
        f0.p(cArray, "$this$toMutableSet");
        int n10 = s0.j(f.l2.q.u(cArray.length, 128));
        LinkedHashSet linkedHashSet = new LinkedHashSet(n10);
        return (Set)ArraysKt___ArraysKt.Ux(cArray, linkedHashSet);
    }

    public static final List Iz(double[] dArray, Object[] objectArray) {
        f0.p(dArray, "$this$zip");
        String string2 = "other";
        f0.p(objectArray, string2);
        int n10 = dArray.length;
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            Object object = objectArray[i10];
            Pair pair = w0.a(d10, object);
            arrayList.add(pair);
        }
        return arrayList;
    }

    public static final boolean J4(int[] nArray, l l10) {
        f0.p(nArray, "$this$any");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = nArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Constable constable = Integer.valueOf(nArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static final Map J5(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$associateBy");
        String string2 = "keySelector";
        f0.p(l10, string2);
        int n10 = s0.j(blArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Boolean> linkedHashMap = new LinkedHashMap<Object, Boolean>(n10);
        for (boolean bl2 : blArray) {
            Object object = bl2;
            object = l10.invoke(object);
            Boolean bl3 = bl2;
            linkedHashMap.put(object, bl3);
        }
        return linkedHashMap;
    }

    public static final double J6(short[] sArray) {
        double d10;
        double d11;
        String string2 = "$this$average";
        f0.p(sArray, string2);
        int n10 = sArray.length;
        double d12 = d11 = 0.0;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            double d13 = s10;
            d12 += d13;
            ++n11;
        }
        if (n11 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            d10 = n11;
            d10 = d12 / d10;
        }
        return d10;
    }

    /*
     * WARNING - void declaration
     */
    public static final boolean J7(byte[] byArray, byte by2) {
        void var3_6;
        String string2 = "$this$contains";
        f0.p(byArray, string2);
        int bl2 = ArraysKt___ArraysKt.Xe(byArray, by2);
        if (bl2 >= 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            byArray = null;
        }
        return (boolean)var3_6;
    }

    public static final List J8(short[] object, int n10) {
        f0.p(object, "$this$drop");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((short[])object).length - n10, 0);
            return ArraysKt___ArraysKt.wx((short[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List J9(long[] lArray, l l10) {
        f0.p(lArray, "$this$filter");
        f0.p(l10, "predicate");
        ArrayList<Long> arrayList = new ArrayList<Long>();
        for (long l11 : lArray) {
            Constable constable = Long.valueOf(l11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            Long l12 = l11;
            arrayList.add(l12);
        }
        return arrayList;
    }

    public static final Collection Ja(boolean[] blArray, Collection collection, l l10) {
        f0.p(blArray, "$this$filterTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (boolean bl2 : blArray) {
            Boolean bl3 = bl2;
            boolean bl4 = bl3 = (Boolean)l10.invoke(bl3);
            if (!bl4) continue;
            Boolean bl5 = bl2;
            collection.add(bl5);
        }
        return collection;
    }

    public static final Object Jb(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$firstOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (Object object : objectArray) {
            Boolean bl2 = (Boolean)l10.invoke(object);
            boolean bl3 = bl2;
            if (!bl3) continue;
            return object;
        }
        return null;
    }

    public static final Object Jc(byte[] byArray, Object object, q q10) {
        f0.p(byArray, "$this$foldIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Integer n12 = n11;
            ++n11;
            Byte by3 = by2;
            object = q10.invoke(n12, object, by3);
        }
        return object;
    }

    public static final k Jd(short[] sArray) {
        f0.p(sArray, "$this$indices");
        int n10 = ArraysKt___ArraysKt.Sd(sArray);
        k k10 = new k(0, n10);
        return k10;
    }

    public static final Map Je(double[] dArray, Map map, l l10, l l11) {
        f0.p(dArray, "$this$groupByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (double d10 : dArray) {
            Object object = d10;
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = d10;
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return map;
    }

    private static final boolean Jf(double[] dArray) {
        boolean bl2 = dArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            dArray = null;
        }
        return bl2;
    }

    public static final byte Jg(byte[] object) {
        String string2 = "$this$last";
        f0.p(object, string2);
        int n10 = ((byte[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ArraysKt___ArraysKt.Ld(object);
            return object[n10];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final List Jh(short[] sArray, l l10) {
        f0.p(sArray, "$this$map");
        f0.p(l10, "transform");
        int n10 = sArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (short s10 : sArray) {
            Object object = s10;
            object = l10.invoke(object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Boolean Ji(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$maxByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = blArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = blArray[0];
        n11 = ArraysKt___ArraysKt.Td(blArray);
        if (n11 == 0) {
            return n10 != 0;
        }
        Comparable<Boolean> comparable = n10 != 0;
        comparable = (Comparable)l10.invoke(comparable);
        if (n12 <= n11) {
            while (true) {
                int n13 = blArray[n12];
                Comparable<Boolean> comparable2 = n13 != 0;
                int n14 = comparable.compareTo((Boolean)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n14 < 0) {
                    n10 = n13;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return n10 != 0;
    }

    private static final Double Jj(short[] sArray, l l10) {
        Number number;
        int n10 = sArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray[0];
        number = (short)n10;
        number = (Number)l10.invoke(number);
        double d10 = number.doubleValue();
        int n12 = ArraysKt___ArraysKt.Sd(sArray);
        if (n11 <= n12) {
            while (true) {
                short s10 = sArray[n11];
                Number number2 = s10;
                number2 = (Number)l10.invoke(number2);
                double d11 = number2.doubleValue();
                d10 = Math.max(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Float Jk(float[] fArray, Comparator comparator) {
        float f10;
        f0.p(fArray, "$this$maxWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            string2 = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        f10 = fArray[0];
        n11 = ArraysKt___ArraysKt.Od(fArray);
        if (n12 <= n11) {
            while (true) {
                Float f12;
                float f13 = fArray[n12];
                Float f14 = Float.valueOf(f10);
                int n13 = comparator.compare(f14, f12 = Float.valueOf(f13));
                if (n13 < 0) {
                    f10 = f13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    private static final Comparable Jl(char[] object, l l10) {
        Comparable<Character> comparable;
        int n10 = ((char[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            comparable = Character.valueOf((char)n10);
            comparable = (Comparable)l10.invoke(comparable);
            n11 = ArraysKt___ArraysKt.Md(object);
            if (n12 <= n11) {
                while (true) {
                    char c10 = object[n12];
                    Comparable<Character> comparable2 = Character.valueOf(c10);
                    int n13 = comparable.compareTo((Character)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n13 > 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object Jm(boolean[] blArray, Comparator comparator, l l10) {
        Object object;
        int n10 = blArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = blArray[0];
        object = n10 != 0;
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Td(blArray);
        if (n12 <= n11) {
            while (true) {
                boolean bl2 = blArray[n12];
                Object object2 = bl2;
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 > 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    private static final long[] Jn(long[] lArray, l l10) {
        int n10 = lArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = lArray[i10];
            Long l12 = l11;
            l10.invoke(l12);
        }
        return lArray;
    }

    private static final Long Jo(long[] lArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.Ko(lArray, e$a);
    }

    public static final char Jp(char[] object, q q10) {
        f0.p(object, "$this$reduceRightIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int c10 = ArraysKt___ArraysKt.Md((char[])object);
        if (c10 >= 0) {
            char c11;
            Object object3 = object[c10];
            for (int i10 = c10 + -1; i10 >= 0; i10 += -1) {
                Integer n10 = i10;
                Object object4 = object[i10];
                Character c12 = Character.valueOf((char)object4);
                object2 = Character.valueOf(c11);
                object2 = (Character)q10.invoke(n10, c12, object2);
                c11 = ((Character)object2).charValue();
            }
            return c11;
        }
        object = new UnsupportedOperationException("Empty array can't be reduced.");
        throw object;
    }

    public static final List Jq(short[] object) {
        String string2 = "$this$reversed";
        f0.p(object, string2);
        int n10 = ((short[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = ArraysKt___ArraysKt.Fy(object);
        a0.e1((List)object);
        return object;
    }

    private static final List Jr(long[] object, Object object2, p p10) {
        ArrayList<Object> arrayList;
        int n10 = ((long[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            int n13 = ((long[])object).length + n12;
            arrayList = new ArrayList<Object>(n13);
            arrayList.add(object2);
            n12 = ((long[])object).length;
            while (n11 < n12) {
                long l10 = object[n11];
                Long l11 = l10;
                object2 = p10.invoke(object2, l11);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final char Js(char[] object, l l10) {
        f0.p(object, "$this$single");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((char[])object).length;
        boolean bl2 = false;
        Character c10 = null;
        boolean bl3 = false;
        Character c11 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c12 = object[i10];
            Comparable<Character> comparable = Character.valueOf(c12);
            boolean bl4 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl4) continue;
            if (!bl3) {
                c11 = Character.valueOf(c12);
                bl2 = true;
                c10 = c11;
                bl3 = bl2;
                continue;
            }
            object = new IllegalArgumentException;
            object("Array contains more than one matching element.");
            throw object;
        }
        if (bl3) {
            Objects.requireNonNull(c10, "null cannot be cast to non-null type kotlin.Char");
            return c10.charValue();
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final byte[] Jt(byte[] byArray, k k10) {
        f0.p(byArray, "$this$sliceArray");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return new byte[0];
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.G1(byArray, n10, n11);
    }

    public static final char[] Ju(char[] cArray) {
        String string2 = "$this$sortedArrayDescending";
        f0.p(cArray, string2);
        int n10 = cArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return cArray;
        }
        n10 = cArray.length;
        cArray = Arrays.copyOf(cArray, n10);
        f0.o(cArray, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysKt.eu(cArray);
        return cArray;
    }

    public static final double Jv(double[] dArray) {
        String string2 = "$this$sum";
        f0.p(dArray, string2);
        int n10 = dArray.length;
        double d10 = 0.0;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d11 = dArray[i10];
            d10 += d11;
        }
        return d10;
    }

    public static final long Jw(Long[] longArray) {
        String string2 = "$this$sum";
        f0.p(longArray, string2);
        int n10 = longArray.length;
        long l10 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            Long l11 = longArray[i10];
            long l12 = l11;
            l10 += l12;
        }
        return l10;
    }

    public static final List Jx(double[] dArray, l l10) {
        f0.p(dArray, "$this$takeWhile");
        f0.p(l10, "predicate");
        ArrayList<Double> arrayList = new ArrayList<Double>();
        for (double d10 : dArray) {
            Constable constable = Double.valueOf(d10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) break;
            Double d11 = d10;
            arrayList.add(d11);
        }
        return arrayList;
    }

    public static final Set Jy(double[] dArray) {
        f0.p(dArray, "$this$toMutableSet");
        int n10 = s0.j(dArray.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet(n10);
        return (Set)ArraysKt___ArraysKt.Vx(dArray, linkedHashSet);
    }

    public static final List Jz(double[] dArray, Object[] objectArray, p p10) {
        f0.p(dArray, "$this$zip");
        f0.p(objectArray, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = dArray.length;
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            Object object = d10;
            Object object2 = objectArray[i10];
            object = p10.invoke(object, object2);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final boolean K4(long[] lArray) {
        String string2 = "$this$any";
        f0.p(lArray, string2);
        int n10 = lArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            lArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final Map K5(boolean[] blArray, l l10, l l11) {
        f0.p(blArray, "$this$associateBy");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        int n10 = s0.j(blArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (boolean bl2 : blArray) {
            Object object = bl2;
            object = l10.invoke(object);
            Object object2 = bl2;
            object2 = l11.invoke(object2);
            linkedHashMap.put(object, object2);
        }
        return linkedHashMap;
    }

    public static final double K6(Byte[] byteArray) {
        double d10;
        double d11;
        String string2 = "$this$average";
        f0.p(byteArray, string2);
        int n10 = byteArray.length;
        double d12 = d11 = 0.0;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Byte by2 = byteArray[i10];
            byte by3 = by2;
            double d13 = by3;
            d12 += d13;
            ++n11;
        }
        if (n11 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            d10 = n11;
            d10 = d12 / d10;
        }
        return d10;
    }

    /*
     * WARNING - void declaration
     */
    public static final boolean K7(char[] cArray, char c10) {
        void var3_6;
        String string2 = "$this$contains";
        f0.p(cArray, string2);
        int bl2 = ArraysKt___ArraysKt.Ye(cArray, c10);
        if (bl2 >= 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            cArray = null;
        }
        return (boolean)var3_6;
    }

    public static final List K8(boolean[] object, int n10) {
        f0.p(object, "$this$drop");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((boolean[])object).length - n10, 0);
            return ArraysKt___ArraysKt.xx((boolean[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List K9(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$filter");
        f0.p(l10, "predicate");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (Object object : objectArray) {
            Boolean bl2 = (Boolean)l10.invoke(object);
            boolean bl3 = bl2;
            if (!bl3) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Boolean Ka(boolean[] object, l l10) {
        block1: {
            int n10 = ((boolean[])object).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                boolean bl2 = object[i10];
                Boolean bl3 = bl2;
                boolean bl4 = bl3 = (Boolean)l10.invoke(bl3);
                if (!bl4) continue;
                object = bl2;
                break block1;
            }
            object = null;
        }
        return object;
    }

    public static final Short Kb(short[] object) {
        String string2 = "$this$firstOrNull";
        f0.p(object, string2);
        int n10 = ((short[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            boolean bl2 = false;
            object = null;
        } else {
            short s10 = object[0];
            object = s10;
        }
        return object;
    }

    public static final Object Kc(char[] cArray, Object object, q q10) {
        f0.p(cArray, "$this$foldIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        int n10 = cArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = cArray[i10];
            Integer n12 = n11;
            ++n11;
            Character c11 = Character.valueOf(c10);
            object = q10.invoke(n12, object, c11);
        }
        return object;
    }

    public static final k Kd(boolean[] blArray) {
        f0.p(blArray, "$this$indices");
        int n10 = ArraysKt___ArraysKt.Td(blArray);
        k k10 = new k(0, n10);
        return k10;
    }

    public static final Map Ke(float[] fArray, Map map, l l10) {
        f0.p(fArray, "$this$groupByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Float f11 = Float.valueOf(f10);
            object2.add((Float)f11);
        }
        return map;
    }

    private static final boolean Kf(float[] fArray) {
        boolean bl2 = fArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            fArray = null;
        }
        return bl2;
    }

    public static final byte Kg(byte[] object, l l10) {
        f0.p(object, "$this$last");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((byte[])object).length;
        while ((n10 += -1) >= 0) {
            byte by2 = object[n10];
            Constable constable = Byte.valueOf(by2);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return by2;
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final List Kh(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$map");
        f0.p(l10, "transform");
        int n10 = blArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (boolean bl2 : blArray) {
            Object object = bl2;
            object = l10.invoke(object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Byte Ki(byte[] byArray, l l10) {
        f0.p(byArray, "$this$maxByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = byArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray[0];
        n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n11 == 0) {
            return (byte)n10;
        }
        Comparable<Byte> comparable = (byte)n10;
        comparable = (Comparable)l10.invoke(comparable);
        if (n12 <= n11) {
            while (true) {
                int n13 = byArray[n12];
                Comparable<Byte> comparable2 = (byte)n13;
                int n14 = comparable.compareTo((Byte)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n14 < 0) {
                    n10 = n13;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return (byte)n10;
    }

    private static final Double Kj(boolean[] blArray, l l10) {
        Serializable serializable;
        int n10 = blArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            serializable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = blArray[0];
        serializable = Boolean.valueOf(n10 != 0);
        serializable = (Number)l10.invoke(serializable);
        double d10 = ((Number)serializable).doubleValue();
        int n12 = ArraysKt___ArraysKt.Td(blArray);
        if (n11 <= n12) {
            while (true) {
                boolean bl2 = blArray[n11];
                Serializable serializable2 = Boolean.valueOf(bl2);
                serializable2 = (Number)l10.invoke(serializable2);
                double d11 = ((Number)serializable2).doubleValue();
                d10 = Math.max(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Integer Kk(int[] nArray, Comparator comparator) {
        f0.p(nArray, "$this$maxWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = nArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray[0];
        n11 = ArraysKt___ArraysKt.Pd(nArray);
        if (n12 <= n11) {
            while (true) {
                Integer n13;
                int n14 = nArray[n12];
                Integer n15 = n10;
                int n16 = comparator.compare(n15, n13 = Integer.valueOf(n14));
                if (n16 < 0) {
                    n10 = n14;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return n10;
    }

    private static final Comparable Kl(double[] object, l l10) {
        Comparable<Double> comparable;
        int n10 = ((double[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 == 0) {
            double d10 = object[0];
            comparable = d10;
            comparable = (Comparable)l10.invoke(comparable);
            n11 = ArraysKt___ArraysKt.Nd(object);
            if (n12 <= n11) {
                while (true) {
                    double d11 = object[n12];
                    Comparable<Double> comparable2 = d11;
                    int n13 = comparable.compareTo((Double)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n13 > 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Byte Km(byte[] byArray) {
        String string2 = "$this$minOrNull";
        f0.p(byArray, string2);
        int n10 = byArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray[0];
        n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n12 <= n11) {
            while (true) {
                int n13;
                if (n10 > (n13 = byArray[n12])) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return (byte)n10;
    }

    private static final Object[] Kn(Object[] objectArray, l l10) {
        int n10 = objectArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            l10.invoke(object);
        }
        return objectArray;
    }

    public static final Long Ko(long[] lArray, e e10) {
        f0.p(lArray, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = lArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = lArray.length;
        int n11 = e10.m(n10);
        return lArray[n11];
    }

    public static final double Kp(double[] object, q q10) {
        f0.p(object, "$this$reduceRightIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Nd(object);
        if (n10 >= 0) {
            double d10 = object[n10];
            for (int i10 = n10 + -1; i10 >= 0; i10 += -1) {
                object2 = i10;
                double d11 = object[i10];
                Double d12 = d11;
                Double d13 = d10;
                object2 = (Number)q10.invoke(object2, d12, d13);
                d10 = ((Number)object2).doubleValue();
            }
            return d10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final List Kq(boolean[] object) {
        String string2 = "$this$reversed";
        f0.p(object, string2);
        int n10 = ((boolean[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = ArraysKt___ArraysKt.Gy(object);
        a0.e1((List)object);
        return object;
    }

    public static final List Kr(Object[] object, Object object2, p p10) {
        f0.p(object, "$this$scan");
        ArrayList<Object> arrayList = "operation";
        f0.p(p10, (String)((Object)arrayList));
        int n10 = ((Object[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            int n13 = ((Object[])object).length + n12;
            arrayList = new ArrayList<Object>(n13);
            arrayList.add(object2);
            n12 = ((Object[])object).length;
            while (n11 < n12) {
                Object object3 = object[n11];
                object2 = p10.invoke(object2, object3);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final double Ks(double[] object) {
        String string2 = "$this$single";
        f0.p(object, string2);
        int n10 = ((double[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                return object[0];
            }
            object = new IllegalArgumentException;
            object("Array has more than one element.");
            throw object;
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final char[] Kt(char[] cArray, Collection object) {
        int n10;
        f0.p(cArray, "$this$sliceArray");
        f0.p(object, "indices");
        int n11 = object.size();
        char[] cArray2 = new char[n11];
        object = object.iterator();
        int n12 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Number number = (Number)object.next();
            n10 = number.intValue();
            int n13 = n12 + 1;
            cArray2[n12] = n10 = cArray[n10];
            n12 = n13;
        }
        return cArray2;
    }

    public static final double[] Ku(double[] dArray) {
        String string2 = "$this$sortedArrayDescending";
        f0.p(dArray, string2);
        int n10 = dArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return dArray;
        }
        n10 = dArray.length;
        dArray = Arrays.copyOf(dArray, n10);
        f0.o(dArray, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysKt.gu(dArray);
        return dArray;
    }

    public static final float Kv(float[] fArray) {
        String string2 = "$this$sum";
        f0.p(fArray, string2);
        int n10 = fArray.length;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f11 = fArray[i10];
            f10 += f11;
        }
        return f10;
    }

    private static final long Kw(Object[] objectArray, l l10) {
        int n10 = objectArray.length;
        long l11 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            object = (Number)l10.invoke(object);
            long l12 = ((Number)object).longValue();
            l11 += l12;
        }
        return l11;
    }

    public static final List Kx(float[] fArray, l l10) {
        f0.p(fArray, "$this$takeWhile");
        f0.p(l10, "predicate");
        ArrayList<Float> arrayList = new ArrayList<Float>();
        for (float f10 : fArray) {
            Constable constable = Float.valueOf(f10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) break;
            Float f11 = Float.valueOf(f10);
            arrayList.add(f11);
        }
        return arrayList;
    }

    public static final Set Ky(float[] fArray) {
        f0.p(fArray, "$this$toMutableSet");
        int n10 = s0.j(fArray.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet(n10);
        return (Set)ArraysKt___ArraysKt.Wx(fArray, linkedHashSet);
    }

    public static final List Kz(float[] fArray, Iterable object) {
        boolean bl2;
        f0.p(fArray, "$this$zip");
        String string2 = "other";
        f0.p(object, string2);
        int n10 = fArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n11);
        object = object.iterator();
        n11 = 0;
        float f10 = 0.0f;
        Pair pair = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            f10 = fArray[n11];
            pair = w0.a(Float.valueOf(f10), e10);
            arrayList.add(pair);
            n11 = n12;
        }
        return arrayList;
    }

    public static final boolean L4(long[] lArray, l l10) {
        f0.p(lArray, "$this$any");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (long l11 : lArray) {
            Constable constable = Long.valueOf(l11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static final Map L5(byte[] byArray, Map map, l l10) {
        f0.p(byArray, "$this$associateByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (byte by2 : byArray) {
            Object object = by2;
            object = l10.invoke(object);
            Byte by3 = by2;
            map.put(object, by3);
        }
        return map;
    }

    public static final double L6(Double[] doubleArray) {
        double d10;
        double d11;
        String string2 = "$this$average";
        f0.p(doubleArray, string2);
        int n10 = doubleArray.length;
        double d12 = d11 = 0.0;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Double d13 = doubleArray[i10];
            double d14 = d13;
            d12 += d14;
            ++n11;
        }
        if (n11 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            d10 = n11;
            d10 = d12 / d10;
        }
        return d10;
    }

    /*
     * WARNING - void declaration
     */
    public static final boolean L7(double[] dArray, double d10) {
        void var4_6;
        String string2 = "$this$contains";
        f0.p(dArray, string2);
        int bl2 = ArraysKt___ArraysKt.Ze(dArray, d10);
        if (bl2 >= 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            dArray = null;
        }
        return (boolean)var4_6;
    }

    public static final List L8(byte[] object, int n10) {
        f0.p(object, "$this$dropLast");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((byte[])object).length - n10, 0);
            return ArraysKt___ArraysKt.gx((byte[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List L9(short[] sArray, l l10) {
        f0.p(sArray, "$this$filter");
        f0.p(l10, "predicate");
        ArrayList<Short> arrayList = new ArrayList<Short>();
        for (short s10 : sArray) {
            Constable constable = Short.valueOf(s10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            Short s11 = s10;
            arrayList.add(s11);
        }
        return arrayList;
    }

    private static final Byte La(byte[] object, l l10) {
        block1: {
            int n10 = ((byte[])object).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                byte by2 = object[i10];
                Constable constable = Byte.valueOf(by2);
                boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
                if (!bl2) continue;
                object = by2;
                break block1;
            }
            object = null;
        }
        return object;
    }

    public static final Short Lb(short[] sArray, l l10) {
        f0.p(sArray, "$this$firstOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (short s10 : sArray) {
            Constable constable = Short.valueOf(s10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return s10;
        }
        return null;
    }

    public static final Object Lc(double[] dArray, Object object, q q10) {
        f0.p(dArray, "$this$foldIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        int n10 = dArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            Integer n12 = n11;
            ++n11;
            Double d11 = d10;
            object = q10.invoke(n12, object, d11);
        }
        return object;
    }

    public static final int Ld(byte[] byArray) {
        f0.p(byArray, "$this$lastIndex");
        return byArray.length + -1;
    }

    public static final Map Le(float[] fArray, Map map, l l10, l l11) {
        f0.p(fArray, "$this$groupByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = Float.valueOf(f10);
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return map;
    }

    private static final boolean Lf(int[] nArray) {
        boolean bl2 = nArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            nArray = null;
        }
        return bl2;
    }

    public static final char Lg(char[] object) {
        String string2 = "$this$last";
        f0.p(object, string2);
        int n10 = ((char[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ArraysKt___ArraysKt.Md(object);
            return object[n10];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final List Lh(byte[] byArray, p p10) {
        f0.p(byArray, "$this$mapIndexed");
        f0.p(p10, "transform");
        int n10 = byArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = by2;
            object = p10.invoke(n12, object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Character Li(char[] cArray, l l10) {
        f0.p(cArray, "$this$maxByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray[0];
        n11 = ArraysKt___ArraysKt.Md(cArray);
        if (n11 == 0) {
            return Character.valueOf((char)n10);
        }
        Comparable<Character> comparable = Character.valueOf((char)n10);
        comparable = (Comparable)l10.invoke(comparable);
        if (n12 <= n11) {
            while (true) {
                int n13 = cArray[n12];
                Comparable<Character> comparable2 = Character.valueOf((char)n13);
                int n14 = comparable.compareTo((Character)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n14 < 0) {
                    n10 = n13;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Character.valueOf((char)n10);
    }

    private static final Float Lj(byte[] byArray, l l10) {
        Number number;
        float f10;
        int n10 = byArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray[0];
        number = (byte)n10;
        number = (Number)l10.invoke(number);
        f10 = number.floatValue();
        n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n12 <= n11) {
            while (true) {
                byte by2 = byArray[n12];
                Number number2 = by2;
                number2 = (Number)l10.invoke(number2);
                float f12 = number2.floatValue();
                f10 = Math.max(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final Long Lk(long[] lArray, Comparator comparator) {
        f0.p(lArray, "$this$maxWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = lArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        long l10 = lArray[0];
        int n12 = ArraysKt___ArraysKt.Qd(lArray);
        if (n11 <= n12) {
            while (true) {
                Long l11;
                long l12 = lArray[n11];
                Long l13 = l10;
                int n13 = comparator.compare(l13, l11 = Long.valueOf(l12));
                if (n13 < 0) {
                    l10 = l12;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return l10;
    }

    private static final Comparable Ll(float[] object, l l10) {
        Comparable<Float> comparable;
        float f10;
        int n10 = ((float[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            comparable = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            f10 = object[0];
            comparable = Float.valueOf(f10);
            comparable = (Comparable)l10.invoke(comparable);
            n11 = ArraysKt___ArraysKt.Od(object);
            if (n12 <= n11) {
                while (true) {
                    float f12 = object[n12];
                    Comparable<Float> comparable2 = Float.valueOf(f12);
                    int n13 = comparable.compareTo((Float)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n13 > 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Character Lm(char[] cArray) {
        String string2 = "$this$minOrNull";
        f0.p(cArray, string2);
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray[0];
        n11 = ArraysKt___ArraysKt.Md(cArray);
        if (n12 <= n11) {
            while (true) {
                int n13;
                int n14;
                if ((n14 = f0.t(n10, n13 = cArray[n12])) > 0) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Character.valueOf((char)n10);
    }

    private static final short[] Ln(short[] sArray, l l10) {
        int n10 = sArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Short s11 = s10;
            l10.invoke(s11);
        }
        return sArray;
    }

    private static final Object Lo(Object[] objectArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.Mo(objectArray, e$a);
    }

    public static final float Lp(float[] object, q q10) {
        f0.p(object, "$this$reduceRightIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Od(object);
        if (n10 >= 0) {
            float f10 = object[n10];
            for (int i10 = n10 + -1; i10 >= 0; i10 += -1) {
                Integer n11 = i10;
                float f11 = object[i10];
                Float f12 = Float.valueOf(f11);
                object2 = Float.valueOf(f10);
                object2 = (Number)q10.invoke(n11, f12, object2);
                f10 = ((Number)object2).floatValue();
            }
            return f10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final byte[] Lq(byte[] byArray) {
        Object object = "$this$reversedArray";
        f0.p(byArray, (String)object);
        int n10 = byArray.length;
        int n11 = 0;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return byArray;
        }
        n10 = byArray.length;
        object = new byte[n10];
        int n12 = ArraysKt___ArraysKt.Ld(byArray);
        if (n12 >= 0) {
            while (true) {
                int n13 = n12 - n11;
                byte by2 = byArray[n11];
                object[n13] = by2;
                if (n11 == n12) break;
                ++n11;
            }
        }
        return object;
    }

    private static final List Lr(short[] object, Object object2, p p10) {
        ArrayList<Object> arrayList;
        int n10 = ((short[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            short s10 = ((short[])object).length + n12;
            arrayList = new ArrayList<Object>(s10);
            arrayList.add(object2);
            n12 = ((short[])object).length;
            while (n11 < n12) {
                s10 = object[n11];
                Short s11 = s10;
                object2 = p10.invoke(object2, s11);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final double Ls(double[] object, l l10) {
        f0.p(object, "$this$single");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((double[])object).length;
        boolean bl2 = false;
        Double d10 = null;
        boolean bl3 = false;
        Double d11 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d12 = object[i10];
            Constable constable = Double.valueOf(d12);
            boolean bl4 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl4) continue;
            if (!bl3) {
                d11 = d12;
                bl2 = true;
                d10 = d11;
                bl3 = bl2;
                continue;
            }
            object = new IllegalArgumentException;
            object("Array contains more than one matching element.");
            throw object;
        }
        if (bl3) {
            Objects.requireNonNull(d10, "null cannot be cast to non-null type kotlin.Double");
            return d10;
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final char[] Lt(char[] cArray, k k10) {
        f0.p(cArray, "$this$sliceArray");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return new char[0];
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.H1(cArray, n10, n11);
    }

    public static final float[] Lu(float[] fArray) {
        String string2 = "$this$sortedArrayDescending";
        f0.p(fArray, string2);
        int n10 = fArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return fArray;
        }
        n10 = fArray.length;
        fArray = Arrays.copyOf(fArray, n10);
        f0.o(fArray, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysKt.iu(fArray);
        return fArray;
    }

    public static final int Lv(byte[] byArray) {
        String string2 = "$this$sum";
        f0.p(byArray, string2);
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            n11 += by2;
        }
        return n11;
    }

    private static final long Lw(short[] sArray, l l10) {
        int n10 = sArray.length;
        long l11 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Number number = s10;
            number = (Number)l10.invoke(number);
            long l12 = number.longValue();
            l11 += l12;
        }
        return l11;
    }

    public static final List Lx(int[] nArray, l l10) {
        f0.p(nArray, "$this$takeWhile");
        f0.p(l10, "predicate");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int n10 : nArray) {
            Constable constable = Integer.valueOf(n10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) break;
            Integer n11 = n10;
            arrayList.add(n11);
        }
        return arrayList;
    }

    public static final Set Ly(int[] nArray) {
        f0.p(nArray, "$this$toMutableSet");
        int n10 = s0.j(nArray.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet(n10);
        return (Set)ArraysKt___ArraysKt.Xx(nArray, linkedHashSet);
    }

    public static final List Lz(float[] fArray, Iterable object, p p10) {
        boolean bl2;
        f0.p(fArray, "$this$zip");
        f0.p(object, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = fArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        n11 = 0;
        float f10 = 0.0f;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            f10 = fArray[n11];
            object2 = Float.valueOf(f10);
            object2 = p10.invoke(object2, e10);
            arrayList.add(object2);
            n11 = n12;
        }
        return arrayList;
    }

    public static final boolean M4(Object[] objectArray) {
        String string2 = "$this$any";
        f0.p(objectArray, string2);
        int n10 = objectArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            objectArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final Map M5(byte[] byArray, Map map, l l10, l l11) {
        f0.p(byArray, "$this$associateByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (byte by2 : byArray) {
            Object object = by2;
            object = l10.invoke(object);
            Object object2 = by2;
            object2 = l11.invoke(object2);
            map.put(object, object2);
        }
        return map;
    }

    public static final double M6(Float[] floatArray) {
        double d10;
        double d11;
        String string2 = "$this$average";
        f0.p(floatArray, string2);
        int n10 = floatArray.length;
        double d12 = d11 = 0.0;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Float f10 = floatArray[i10];
            float f11 = f10.floatValue();
            double d13 = f11;
            d12 += d13;
            ++n11;
        }
        if (n11 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            d10 = n11;
            d10 = d12 / d10;
        }
        return d10;
    }

    /*
     * WARNING - void declaration
     */
    public static final boolean M7(float[] fArray, float f10) {
        void var3_6;
        String string2 = "$this$contains";
        f0.p(fArray, string2);
        int bl2 = ArraysKt___ArraysKt.af(fArray, f10);
        if (bl2 >= 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            fArray = null;
        }
        return (boolean)var3_6;
    }

    public static final List M8(char[] object, int n10) {
        f0.p(object, "$this$dropLast");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((char[])object).length - n10, 0);
            return ArraysKt___ArraysKt.hx((char[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List M9(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$filter");
        f0.p(l10, "predicate");
        ArrayList<Boolean> arrayList = new ArrayList<Boolean>();
        for (boolean bl2 : blArray) {
            Boolean bl3 = bl2;
            boolean bl4 = bl3 = (Boolean)l10.invoke(bl3);
            if (!bl4) continue;
            Boolean bl5 = bl2;
            arrayList.add(bl5);
        }
        return arrayList;
    }

    private static final Character Ma(char[] object, l l10) {
        block1: {
            int n10 = ((char[])object).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                char c10 = object[i10];
                Comparable<Character> comparable = Character.valueOf(c10);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (!bl2) continue;
                object = Character.valueOf(c10);
                break block1;
            }
            object = null;
        }
        return object;
    }

    public static final List Mb(byte[] byArray, l l10) {
        f0.p(byArray, "$this$flatMap");
        f0.p(l10, "transform");
        ArrayList arrayList = new ArrayList();
        for (byte by2 : byArray) {
            Object object = by2;
            object = (Iterable)l10.invoke(object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object Mc(float[] fArray, Object object, q q10) {
        f0.p(fArray, "$this$foldIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        int n10 = fArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Integer n12 = n11;
            ++n11;
            Float f11 = Float.valueOf(f10);
            object = q10.invoke(n12, object, f11);
        }
        return object;
    }

    public static final int Md(char[] cArray) {
        f0.p(cArray, "$this$lastIndex");
        return cArray.length + -1;
    }

    public static final Map Me(int[] nArray, Map map, l l10) {
        f0.p(nArray, "$this$groupByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (int n10 : nArray) {
            Object object = n10;
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Integer n11 = n10;
            object2.add((Integer)n11);
        }
        return map;
    }

    private static final boolean Mf(long[] lArray) {
        boolean bl2 = lArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            lArray = null;
        }
        return bl2;
    }

    public static final char Mg(char[] object, l l10) {
        f0.p(object, "$this$last");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((char[])object).length;
        while ((n10 += -1) >= 0) {
            char c10 = object[n10];
            Comparable<Character> comparable = Character.valueOf(c10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return c10;
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final List Mh(char[] cArray, p p10) {
        f0.p(cArray, "$this$mapIndexed");
        f0.p(p10, "transform");
        int n10 = cArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        n10 = cArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = cArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = Character.valueOf(c10);
            object = p10.invoke(n12, object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Double Mi(double[] dArray, l l10) {
        f0.p(dArray, "$this$maxByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = dArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        double d10 = dArray[0];
        int n12 = ArraysKt___ArraysKt.Nd(dArray);
        if (n12 == 0) {
            return d10;
        }
        Comparable<Double> comparable = d10;
        comparable = (Comparable)l10.invoke(comparable);
        if (n11 <= n12) {
            while (true) {
                double d11 = dArray[n11];
                Comparable<Double> comparable2 = d11;
                int n13 = comparable.compareTo((Double)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 < 0) {
                    d10 = d11;
                    comparable = comparable2;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    private static final Float Mj(char[] cArray, l l10) {
        Serializable serializable;
        float f10;
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            serializable = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray[0];
        serializable = Character.valueOf((char)n10);
        serializable = (Number)l10.invoke(serializable);
        f10 = ((Number)serializable).floatValue();
        n11 = ArraysKt___ArraysKt.Md(cArray);
        if (n12 <= n11) {
            while (true) {
                char c10 = cArray[n12];
                Serializable serializable2 = Character.valueOf(c10);
                serializable2 = (Number)l10.invoke(serializable2);
                float f12 = ((Number)serializable2).floatValue();
                f10 = Math.max(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final Object Mk(Object[] objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$maxWithOrNull");
        Object object = "comparator";
        f0.p(comparator, (String)object);
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        object = objectArray[0];
        n11 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n12 <= n11) {
            while (true) {
                Object object2;
                int n13;
                if ((n13 = comparator.compare(object, object2 = objectArray[n12])) < 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    private static final Comparable Ml(int[] object, l l10) {
        Comparable<Integer> comparable;
        int n10 = ((int[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            comparable = n10;
            comparable = (Comparable)l10.invoke(comparable);
            n11 = ArraysKt___ArraysKt.Pd(object);
            if (n12 <= n11) {
                while (true) {
                    int n13 = object[n12];
                    Comparable<Integer> comparable2 = n13;
                    int n14 = comparable.compareTo((Integer)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n14 > 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Comparable Mm(Comparable[] comparableArray) {
        Object object = "$this$minOrNull";
        f0.p(comparableArray, (String)object);
        int n10 = comparableArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        object = comparableArray[0];
        n11 = ArraysKt___ArraysKt.Rd(comparableArray);
        if (n12 <= n11) {
            while (true) {
                Comparable comparable;
                int n13;
                if ((n13 = object.compareTo(comparable = comparableArray[n12])) > 0) {
                    object = comparable;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    private static final boolean[] Mn(boolean[] blArray, l l10) {
        int n10 = blArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            Boolean bl3 = bl2;
            l10.invoke(bl3);
        }
        return blArray;
    }

    public static final Object Mo(Object[] objectArray, e e10) {
        f0.p(objectArray, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = objectArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = objectArray.length;
        int n11 = e10.m(n10);
        return objectArray[n11];
    }

    public static final int Mp(int[] object, q q10) {
        f0.p(object, "$this$reduceRightIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Pd(object);
        if (n10 >= 0) {
            int n11 = n10 + -1;
            n10 = object[n10];
            while (n11 >= 0) {
                Integer n12 = n11;
                int n13 = object[n11];
                Integer n14 = n13;
                object2 = n10;
                object2 = (Number)q10.invoke(n12, n14, object2);
                n10 = ((Number)object2).intValue();
                n11 += -1;
            }
            return n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final char[] Mq(char[] cArray) {
        Object object = "$this$reversedArray";
        f0.p(cArray, (String)object);
        int n10 = cArray.length;
        int n11 = 0;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return cArray;
        }
        n10 = cArray.length;
        object = new char[n10];
        int n12 = ArraysKt___ArraysKt.Md(cArray);
        if (n12 >= 0) {
            while (true) {
                int n13 = n12 - n11;
                char c10 = cArray[n11];
                object[n13] = c10;
                if (n11 == n12) break;
                ++n11;
            }
        }
        return object;
    }

    private static final List Mr(boolean[] object, Object object2, p p10) {
        ArrayList<Object> arrayList;
        int n10 = ((Object)object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            int bl2 = ((Object)object).length + n12;
            arrayList = new ArrayList<Object>(bl2);
            arrayList.add(object2);
            n12 = ((Object)object).length;
            while (n11 < n12) {
                Object object3 = object[n11];
                Boolean bl3 = (boolean)object3;
                object2 = p10.invoke(object2, bl3);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final float Ms(float[] object) {
        String string2 = "$this$single";
        f0.p(object, string2);
        int n10 = ((float[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                return object[0];
            }
            object = new IllegalArgumentException;
            object("Array has more than one element.");
            throw object;
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final double[] Mt(double[] dArray, Collection object) {
        int n10;
        f0.p(dArray, "$this$sliceArray");
        f0.p(object, "indices");
        int n11 = object.size();
        double[] dArray2 = new double[n11];
        object = object.iterator();
        int n12 = 0;
        while ((n10 = object.hasNext()) != 0) {
            double d10;
            Number number = (Number)object.next();
            n10 = number.intValue();
            int n13 = n12 + 1;
            dArray2[n12] = d10 = dArray[n10];
            n12 = n13;
        }
        return dArray2;
    }

    public static final int[] Mu(int[] nArray) {
        String string2 = "$this$sortedArrayDescending";
        f0.p(nArray, string2);
        int n10 = nArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return nArray;
        }
        n10 = nArray.length;
        nArray = Arrays.copyOf(nArray, n10);
        f0.o(nArray, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysKt.ku(nArray);
        return nArray;
    }

    public static final int Mv(int[] nArray) {
        String string2 = "$this$sum";
        f0.p(nArray, string2);
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            n11 += n12;
        }
        return n11;
    }

    private static final long Mw(boolean[] blArray, l l10) {
        int n10 = blArray.length;
        long l11 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            Serializable serializable = Boolean.valueOf(bl2);
            serializable = (Number)l10.invoke(serializable);
            long l12 = ((Number)serializable).longValue();
            l11 += l12;
        }
        return l11;
    }

    public static final List Mx(long[] lArray, l l10) {
        f0.p(lArray, "$this$takeWhile");
        f0.p(l10, "predicate");
        ArrayList<Long> arrayList = new ArrayList<Long>();
        for (long l11 : lArray) {
            Constable constable = Long.valueOf(l11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) break;
            Long l12 = l11;
            arrayList.add(l12);
        }
        return arrayList;
    }

    public static final Set My(long[] lArray) {
        f0.p(lArray, "$this$toMutableSet");
        int n10 = s0.j(lArray.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet(n10);
        return (Set)ArraysKt___ArraysKt.Yx(lArray, linkedHashSet);
    }

    public static final List Mz(float[] fArray, float[] fArray2) {
        f0.p(fArray, "$this$zip");
        String string2 = "other";
        f0.p(fArray2, string2);
        int n10 = fArray.length;
        int n11 = fArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Float> arrayList = new ArrayList<Float>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            float f11 = fArray2[i10];
            Serializable serializable = Float.valueOf(f10);
            Float f12 = Float.valueOf(f11);
            serializable = w0.a(serializable, f12);
            arrayList.add((Float)serializable);
        }
        return arrayList;
    }

    public static final boolean N4(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$any");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (Object object : objectArray) {
            boolean bl2 = (Boolean)(object = (Boolean)l10.invoke(object));
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static final Map N5(char[] cArray, Map map, l l10) {
        f0.p(cArray, "$this$associateByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            object = l10.invoke(object);
            Character c11 = Character.valueOf(c10);
            map.put(object, c11);
        }
        return map;
    }

    public static final double N6(Integer[] integerArray) {
        double d10;
        double d11;
        String string2 = "$this$average";
        f0.p(integerArray, string2);
        int n10 = integerArray.length;
        double d12 = d11 = 0.0;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Integer n12 = integerArray[i10];
            int n13 = n12;
            double d13 = n13;
            d12 += d13;
            ++n11;
        }
        if (n11 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            d10 = n11;
            d10 = d12 / d10;
        }
        return d10;
    }

    /*
     * WARNING - void declaration
     */
    public static final boolean N7(int[] nArray, int n10) {
        void var3_6;
        String string2 = "$this$contains";
        f0.p(nArray, string2);
        int bl2 = ArraysKt___ArraysKt.bf(nArray, n10);
        if (bl2 >= 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            nArray = null;
        }
        return (boolean)var3_6;
    }

    public static final List N8(double[] object, int n10) {
        f0.p(object, "$this$dropLast");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((double[])object).length - n10, 0);
            return ArraysKt___ArraysKt.ix((double[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List N9(byte[] byArray, p p10) {
        f0.p(byArray, "$this$filterIndexed");
        f0.p(p10, "predicate");
        ArrayList<Constable> arrayList = new ArrayList<Constable>();
        int n10 = byArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Byte by3 = by2;
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, by3))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                constable = Byte.valueOf(by2);
                arrayList.add(constable);
            }
            n11 = n12;
        }
        return arrayList;
    }

    private static final Double Na(double[] object, l l10) {
        block1: {
            int n10 = ((double[])object).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                double d10 = object[i10];
                Constable constable = Double.valueOf(d10);
                boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
                if (!bl2) continue;
                object = d10;
                break block1;
            }
            object = null;
        }
        return object;
    }

    public static final List Nb(char[] cArray, l l10) {
        f0.p(cArray, "$this$flatMap");
        f0.p(l10, "transform");
        ArrayList arrayList = new ArrayList();
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            object = (Iterable)l10.invoke(object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object Nc(int[] nArray, Object object, q q10) {
        f0.p(nArray, "$this$foldIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Integer n13 = n11;
            ++n11;
            Integer n14 = n12;
            object = q10.invoke(n13, object, n14);
        }
        return object;
    }

    public static final int Nd(double[] dArray) {
        f0.p(dArray, "$this$lastIndex");
        return dArray.length + -1;
    }

    public static final Map Ne(int[] nArray, Map map, l l10, l l11) {
        f0.p(nArray, "$this$groupByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (int n10 : nArray) {
            Object object = n10;
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = n10;
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return map;
    }

    private static final boolean Nf(Object[] objectArray) {
        boolean bl2 = objectArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            objectArray = null;
        }
        return bl2;
    }

    public static final double Ng(double[] object) {
        String string2 = "$this$last";
        f0.p(object, string2);
        int n10 = ((double[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ArraysKt___ArraysKt.Nd(object);
            return object[n10];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final List Nh(double[] dArray, p p10) {
        f0.p(dArray, "$this$mapIndexed");
        f0.p(p10, "transform");
        int n10 = dArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        n10 = dArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = d10;
            object = p10.invoke(n12, object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Float Ni(float[] fArray, l l10) {
        float f10;
        f0.p(fArray, "$this$maxByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            string2 = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        f10 = fArray[0];
        n11 = ArraysKt___ArraysKt.Od(fArray);
        if (n11 == 0) {
            return Float.valueOf(f10);
        }
        Comparable<Float> comparable = Float.valueOf(f10);
        comparable = (Comparable)l10.invoke(comparable);
        if (n12 <= n11) {
            while (true) {
                float f12 = fArray[n12];
                Comparable<Float> comparable2 = Float.valueOf(f12);
                int n13 = comparable.compareTo((Float)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 < 0) {
                    f10 = f12;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    private static final Float Nj(double[] dArray, l l10) {
        Number number;
        float f10;
        int n10 = dArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        double d10 = dArray[0];
        number = d10;
        number = (Number)l10.invoke(number);
        f10 = number.floatValue();
        n11 = ArraysKt___ArraysKt.Nd(dArray);
        if (n12 <= n11) {
            while (true) {
                double d11 = dArray[n12];
                Number number2 = d11;
                number2 = (Number)l10.invoke(number2);
                float f12 = number2.floatValue();
                f10 = Math.max(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final Short Nk(short[] sArray, Comparator comparator) {
        f0.p(sArray, "$this$maxWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = sArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray[0];
        n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n12 <= n11) {
            while (true) {
                Short s10;
                int n13 = sArray[n12];
                Short s11 = (short)n10;
                int n14 = comparator.compare(s11, s10 = Short.valueOf((short)n13));
                if (n14 < 0) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return (short)n10;
    }

    private static final Comparable Nl(long[] object, l l10) {
        Comparable<Long> comparable;
        int n10 = ((long[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 == 0) {
            long l11 = object[0];
            comparable = l11;
            comparable = (Comparable)l10.invoke(comparable);
            n11 = ArraysKt___ArraysKt.Qd(object);
            if (n12 <= n11) {
                while (true) {
                    long l12 = object[n12];
                    Comparable<Long> comparable2 = l12;
                    int n13 = comparable.compareTo((Long)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n13 > 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Double Nm(double[] dArray) {
        String string2 = "$this$minOrNull";
        f0.p(dArray, string2);
        int n10 = dArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        double d10 = dArray[0];
        int n12 = ArraysKt___ArraysKt.Nd(dArray);
        if (n11 <= n12) {
            while (true) {
                double d11 = dArray[n11];
                d10 = Math.min(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    private static final byte[] Nn(byte[] byArray, p p10) {
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Integer n12 = n11;
            ++n11;
            Byte by3 = by2;
            p10.invoke(n12, by3);
        }
        return byArray;
    }

    private static final Short No(short[] sArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.Oo(sArray, e$a);
    }

    public static final long Np(long[] object, q q10) {
        f0.p(object, "$this$reduceRightIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Qd(object);
        if (n10 >= 0) {
            long l10 = object[n10];
            for (int i10 = n10 + -1; i10 >= 0; i10 += -1) {
                object2 = i10;
                long l11 = object[i10];
                Long l12 = l11;
                Long l13 = l10;
                object2 = (Number)q10.invoke(object2, l12, l13);
                l10 = ((Number)object2).longValue();
            }
            return l10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final double[] Nq(double[] dArray) {
        Object object = "$this$reversedArray";
        f0.p(dArray, (String)object);
        int n10 = dArray.length;
        int n11 = 0;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return dArray;
        }
        n10 = dArray.length;
        object = new double[n10];
        int n12 = ArraysKt___ArraysKt.Nd(dArray);
        if (n12 >= 0) {
            while (true) {
                int n13 = n12 - n11;
                double d10 = dArray[n11];
                object[n13] = d10;
                if (n11 == n12) break;
                ++n11;
            }
        }
        return object;
    }

    private static final List Nr(byte[] object, Object object2, q q10) {
        ArrayList<Object> arrayList;
        int n10 = ((byte[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            int n13 = ((byte[])object).length + n12;
            arrayList = new ArrayList<Object>(n13);
            arrayList.add(object2);
            n12 = ((byte[])object).length;
            while (n11 < n12) {
                Integer n14 = n11;
                byte by2 = object[n11];
                Byte by3 = by2;
                object2 = q10.invoke(n14, object2, by3);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final float Ns(float[] object, l l10) {
        f0.p(object, "$this$single");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((float[])object).length;
        boolean bl2 = false;
        Float f10 = null;
        boolean bl3 = false;
        Float f11 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f12 = object[i10];
            Constable constable = Float.valueOf(f12);
            boolean bl4 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl4) continue;
            if (!bl3) {
                f11 = Float.valueOf(f12);
                bl2 = true;
                f10 = f11;
                bl3 = bl2;
                continue;
            }
            object = new IllegalArgumentException;
            object("Array contains more than one matching element.");
            throw object;
        }
        if (bl3) {
            Objects.requireNonNull(f10, "null cannot be cast to non-null type kotlin.Float");
            return f10.floatValue();
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final double[] Nt(double[] dArray, k k10) {
        f0.p(dArray, "$this$sliceArray");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return new double[0];
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.I1(dArray, n10, n11);
    }

    public static final long[] Nu(long[] lArray) {
        String string2 = "$this$sortedArrayDescending";
        f0.p(lArray, string2);
        int n10 = lArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return lArray;
        }
        n10 = lArray.length;
        lArray = Arrays.copyOf(lArray, n10);
        f0.o(lArray, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysKt.mu(lArray);
        return lArray;
    }

    public static final int Nv(short[] sArray) {
        String string2 = "$this$sum";
        f0.p(sArray, string2);
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            n11 += s10;
        }
        return n11;
    }

    public static final int Nw(Short[] shortArray) {
        String string2 = "$this$sum";
        f0.p(shortArray, string2);
        int n10 = shortArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Short s10 = shortArray[i10];
            short s11 = s10;
            n11 += s11;
        }
        return n11;
    }

    public static final List Nx(Object[] objectArray, l l10) {
        Object object;
        Boolean bl2;
        boolean bl3;
        f0.p(objectArray, "$this$takeWhile");
        f0.p(l10, "predicate");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n10 = objectArray.length;
        for (int i10 = 0; i10 < n10 && (bl3 = (bl2 = (Boolean)l10.invoke(object = objectArray[i10])).booleanValue()); ++i10) {
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Set Ny(Object[] objectArray) {
        f0.p(objectArray, "$this$toMutableSet");
        int n10 = s0.j(objectArray.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet(n10);
        return (Set)ArraysKt___ArraysKt.Zx(objectArray, linkedHashSet);
    }

    public static final List Nz(float[] fArray, float[] fArray2, p p10) {
        f0.p(fArray, "$this$zip");
        f0.p(fArray2, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = fArray.length;
        int n11 = fArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Object object = Float.valueOf(f10);
            float f11 = fArray2[i10];
            Float f12 = Float.valueOf(f11);
            object = p10.invoke(object, f12);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final boolean O4(short[] sArray) {
        String string2 = "$this$any";
        f0.p(sArray, string2);
        int n10 = sArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            sArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final Map O5(char[] cArray, Map map, l l10, l l11) {
        f0.p(cArray, "$this$associateByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            object = l10.invoke(object);
            Object object2 = Character.valueOf(c10);
            object2 = l11.invoke(object2);
            map.put(object, object2);
        }
        return map;
    }

    public static final double O6(Long[] longArray) {
        double d10;
        double d11;
        String string2 = "$this$average";
        f0.p(longArray, string2);
        int n10 = longArray.length;
        double d12 = d11 = 0.0;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Long l10 = longArray[i10];
            long l11 = l10;
            double d13 = l11;
            d12 += d13;
            ++n11;
        }
        if (n11 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            d10 = n11;
            d10 = d12 / d10;
        }
        return d10;
    }

    /*
     * WARNING - void declaration
     */
    public static final boolean O7(long[] lArray, long l10) {
        void var4_6;
        String string2 = "$this$contains";
        f0.p(lArray, string2);
        int bl2 = ArraysKt___ArraysKt.cf(lArray, l10);
        if (bl2 >= 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            lArray = null;
        }
        return (boolean)var4_6;
    }

    public static final List O8(float[] object, int n10) {
        f0.p(object, "$this$dropLast");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((float[])object).length - n10, 0);
            return ArraysKt___ArraysKt.jx((float[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List O9(char[] cArray, p p10) {
        f0.p(cArray, "$this$filterIndexed");
        f0.p(p10, "predicate");
        ArrayList<Constable> arrayList = new ArrayList<Constable>();
        int n10 = cArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = cArray[i10];
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Character c11 = Character.valueOf(c10);
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, c11))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                constable = Character.valueOf(c10);
                arrayList.add(constable);
            }
            n11 = n12;
        }
        return arrayList;
    }

    private static final Float Oa(float[] object, l l10) {
        block1: {
            int n10 = ((float[])object).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                float f10 = object[i10];
                Constable constable = Float.valueOf(f10);
                boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
                if (!bl2) continue;
                object = Float.valueOf(f10);
                break block1;
            }
            object = null;
        }
        return object;
    }

    public static final List Ob(double[] dArray, l l10) {
        f0.p(dArray, "$this$flatMap");
        f0.p(l10, "transform");
        ArrayList arrayList = new ArrayList();
        for (double d10 : dArray) {
            Object object = d10;
            object = (Iterable)l10.invoke(object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object Oc(long[] lArray, Object object, q q10) {
        f0.p(lArray, "$this$foldIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Integer n12 = n11;
            ++n11;
            Long l11 = l10;
            object = q10.invoke(n12, object, l11);
        }
        return object;
    }

    public static final int Od(float[] fArray) {
        f0.p(fArray, "$this$lastIndex");
        return fArray.length + -1;
    }

    public static final Map Oe(long[] lArray, Map map, l l10) {
        f0.p(lArray, "$this$groupByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (long l11 : lArray) {
            Object object = l11;
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Long l12 = l11;
            object2.add((Long)l12);
        }
        return map;
    }

    private static final boolean Of(short[] sArray) {
        boolean bl2 = sArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            sArray = null;
        }
        return bl2;
    }

    public static final double Og(double[] object, l l10) {
        f0.p(object, "$this$last");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((double[])object).length;
        while ((n10 += -1) >= 0) {
            double d10 = object[n10];
            Constable constable = Double.valueOf(d10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return d10;
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final List Oh(float[] fArray, p p10) {
        f0.p(fArray, "$this$mapIndexed");
        f0.p(p10, "transform");
        int n10 = fArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        n10 = fArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = Float.valueOf(f10);
            object = p10.invoke(n12, object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Integer Oi(int[] nArray, l l10) {
        f0.p(nArray, "$this$maxByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = nArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray[0];
        n11 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 == 0) {
            return n10;
        }
        Comparable<Integer> comparable = n10;
        comparable = (Comparable)l10.invoke(comparable);
        if (n12 <= n11) {
            while (true) {
                int n13 = nArray[n12];
                Comparable<Integer> comparable2 = n13;
                int n14 = comparable.compareTo((Integer)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n14 < 0) {
                    n10 = n13;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return n10;
    }

    private static final Float Oj(float[] fArray, l l10) {
        Number number;
        float f10;
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        number = Float.valueOf(fArray[0]);
        number = (Number)l10.invoke(number);
        f10 = number.floatValue();
        n11 = ArraysKt___ArraysKt.Od(fArray);
        if (n12 <= n11) {
            while (true) {
                Number number2 = Float.valueOf(fArray[n12]);
                number2 = (Number)l10.invoke(number2);
                float f12 = number2.floatValue();
                f10 = Math.max(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final Byte Ok(byte[] byArray) {
        f0.p(byArray, "$this$min");
        return ArraysKt___ArraysKt.Km(byArray);
    }

    private static final Comparable Ol(Object[] objectArray, l l10) {
        Object object;
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 == 0) {
            object = objectArray[0];
            object = (Comparable)l10.invoke(object);
            n11 = ArraysKt___ArraysKt.Rd(objectArray);
            if (n12 <= n11) {
                while (true) {
                    Object object2 = objectArray[n12];
                    int n13 = object.compareTo(object2 = (Comparable)l10.invoke(object2));
                    if (n13 > 0) {
                        object = object2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object;
        }
        objectArray = new NoSuchElementException();
        throw objectArray;
    }

    public static final Double Om(Double[] doubleArray) {
        Object object = "$this$minOrNull";
        f0.p(doubleArray, (String)object);
        int n10 = doubleArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        object = doubleArray[0];
        double d10 = (Double)object;
        int n12 = ArraysKt___ArraysKt.Rd(doubleArray);
        if (n11 <= n12) {
            while (true) {
                Double d11 = doubleArray[n11];
                double d12 = d11;
                d10 = Math.min(d10, d12);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    private static final char[] On(char[] cArray, p p10) {
        int n10 = cArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = cArray[i10];
            Integer n12 = n11;
            ++n11;
            Character c11 = Character.valueOf(c10);
            p10.invoke(n12, c11);
        }
        return cArray;
    }

    public static final Short Oo(short[] sArray, e e10) {
        f0.p(sArray, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = sArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray.length;
        int n11 = e10.m(n10);
        return sArray[n11];
    }

    public static final Object Op(Object[] object, q q10) {
        f0.p(object, "$this$reduceRightIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Rd(object);
        if (n10 >= 0) {
            object2 = object[n10];
            for (int i10 = n10 + -1; i10 >= 0; i10 += -1) {
                Integer n11 = i10;
                Object object3 = object[i10];
                object2 = q10.invoke(n11, object3, object2);
            }
            return object2;
        }
        object = new UnsupportedOperationException("Empty array can't be reduced.");
        throw object;
    }

    public static final float[] Oq(float[] fArray) {
        Object object = "$this$reversedArray";
        f0.p(fArray, (String)object);
        int n10 = fArray.length;
        int n11 = 0;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return fArray;
        }
        n10 = fArray.length;
        object = new float[n10];
        int n12 = ArraysKt___ArraysKt.Od(fArray);
        if (n12 >= 0) {
            while (true) {
                int n13 = n12 - n11;
                float f10 = fArray[n11];
                object[n13] = f10;
                if (n11 == n12) break;
                ++n11;
            }
        }
        return object;
    }

    private static final List Or(char[] object, Object object2, q q10) {
        ArrayList<Object> arrayList;
        int n10 = ((char[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            int n13 = ((char[])object).length + n12;
            arrayList = new ArrayList<Object>(n13);
            arrayList.add(object2);
            n12 = ((char[])object).length;
            while (n11 < n12) {
                Integer n14 = n11;
                char c10 = object[n11];
                Character c11 = Character.valueOf(c10);
                object2 = q10.invoke(n14, object2, c11);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final int Os(int[] object) {
        String string2 = "$this$single";
        f0.p(object, string2);
        int n10 = ((int[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                return object[0];
            }
            object = new IllegalArgumentException;
            object("Array has more than one element.");
            throw object;
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final float[] Ot(float[] fArray, Collection object) {
        int n10;
        f0.p(fArray, "$this$sliceArray");
        f0.p(object, "indices");
        int n11 = object.size();
        float[] fArray2 = new float[n11];
        object = object.iterator();
        int n12 = 0;
        while ((n10 = object.hasNext()) != 0) {
            float f10;
            Number number = (Number)object.next();
            n10 = number.intValue();
            int n13 = n12 + 1;
            fArray2[n12] = f10 = fArray[n10];
            n12 = n13;
        }
        return fArray2;
    }

    public static final Comparable[] Ou(Comparable[] comparableArray) {
        Object object = "$this$sortedArrayDescending";
        f0.p(comparableArray, (String)object);
        int n10 = comparableArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return comparableArray;
        }
        n10 = comparableArray.length;
        comparableArray = Arrays.copyOf(comparableArray, n10);
        f0.o(comparableArray, "java.util.Arrays.copyOf(this, size)");
        object = b.q();
        f.x1.n.E3(comparableArray, (Comparator)object);
        return comparableArray;
    }

    public static final long Ov(long[] lArray) {
        String string2 = "$this$sum";
        f0.p(lArray, string2);
        int n10 = lArray.length;
        long l10 = 0L;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = lArray[i10];
            l10 += l11;
        }
        return l10;
    }

    private static final int Ow(byte[] byArray, l l10) {
        int n10 = f.c1.h(0);
        int n11 = byArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            Comparable<Byte> comparable = byArray[i10];
            comparable = (f.c1)l10.invoke(comparable);
            int n12 = ((f.c1)comparable).a0();
            n10 = f.c1.h(n10 + n12);
        }
        return n10;
    }

    public static final List Ox(short[] sArray, l l10) {
        f0.p(sArray, "$this$takeWhile");
        f0.p(l10, "predicate");
        ArrayList<Short> arrayList = new ArrayList<Short>();
        for (short s10 : sArray) {
            Constable constable = Short.valueOf(s10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) break;
            Short s11 = s10;
            arrayList.add(s11);
        }
        return arrayList;
    }

    public static final Set Oy(short[] sArray) {
        f0.p(sArray, "$this$toMutableSet");
        int n10 = s0.j(sArray.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet(n10);
        return (Set)ArraysKt___ArraysKt.ay(sArray, linkedHashSet);
    }

    public static final List Oz(float[] fArray, Object[] objectArray) {
        f0.p(fArray, "$this$zip");
        String string2 = "other";
        f0.p(objectArray, string2);
        int n10 = fArray.length;
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Object object = objectArray[i10];
            Pair pair = w0.a(Float.valueOf(f10), object);
            arrayList.add(pair);
        }
        return arrayList;
    }

    public static final boolean P4(short[] sArray, l l10) {
        f0.p(sArray, "$this$any");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = sArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Constable constable = Short.valueOf(sArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public static final Map P5(double[] dArray, Map map, l l10) {
        f0.p(dArray, "$this$associateByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (double d10 : dArray) {
            Object object = d10;
            object = l10.invoke(object);
            Double d11 = d10;
            map.put(object, d11);
        }
        return map;
    }

    public static final double P6(Short[] shortArray) {
        double d10;
        double d11;
        String string2 = "$this$average";
        f0.p(shortArray, string2);
        int n10 = shortArray.length;
        double d12 = d11 = 0.0;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Short s10 = shortArray[i10];
            short s11 = s10;
            double d13 = s11;
            d12 += d13;
            ++n11;
        }
        if (n11 == 0) {
            d10 = 0.0 / 0.0;
        } else {
            d10 = n11;
            d10 = d12 / d10;
        }
        return d10;
    }

    /*
     * WARNING - void declaration
     */
    public static final boolean P7(Object[] objectArray, Object object) {
        void var3_6;
        String string2 = "$this$contains";
        f0.p(objectArray, string2);
        int bl2 = ArraysKt___ArraysKt.df(objectArray, object);
        if (bl2 >= 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            objectArray = null;
        }
        return (boolean)var3_6;
    }

    public static final List P8(int[] object, int n10) {
        f0.p(object, "$this$dropLast");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((int[])object).length - n10, 0);
            return ArraysKt___ArraysKt.kx((int[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List P9(double[] dArray, p p10) {
        f0.p(dArray, "$this$filterIndexed");
        f0.p(p10, "predicate");
        ArrayList<Constable> arrayList = new ArrayList<Constable>();
        int n10 = dArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Double d11 = d10;
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, d11))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                constable = Double.valueOf(d10);
                arrayList.add(constable);
            }
            n11 = n12;
        }
        return arrayList;
    }

    private static final Integer Pa(int[] object, l l10) {
        block1: {
            int n10 = ((int[])object).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11 = object[i10];
                Constable constable = Integer.valueOf(n11);
                boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
                if (!bl2) continue;
                object = n11;
                break block1;
            }
            object = null;
        }
        return object;
    }

    public static final List Pb(float[] fArray, l l10) {
        f0.p(fArray, "$this$flatMap");
        f0.p(l10, "transform");
        ArrayList arrayList = new ArrayList();
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            object = (Iterable)l10.invoke(object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object Pc(Object[] objectArray, Object object, q q10) {
        f0.p(objectArray, "$this$foldIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        int n10 = objectArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = objectArray[i10];
            Integer n12 = n11;
            ++n11;
            object = q10.invoke(n12, object, object2);
        }
        return object;
    }

    public static final int Pd(int[] nArray) {
        f0.p(nArray, "$this$lastIndex");
        return nArray.length + -1;
    }

    public static final Map Pe(long[] lArray, Map map, l l10, l l11) {
        f0.p(lArray, "$this$groupByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (long l12 : lArray) {
            Object object = l12;
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = l12;
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return map;
    }

    private static final boolean Pf(boolean[] blArray) {
        boolean bl2 = blArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            blArray = null;
        }
        return bl2;
    }

    public static final float Pg(float[] object) {
        String string2 = "$this$last";
        f0.p(object, string2);
        int n10 = ((float[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ArraysKt___ArraysKt.Od(object);
            return object[n10];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final List Ph(int[] nArray, p p10) {
        f0.p(nArray, "$this$mapIndexed");
        f0.p(p10, "transform");
        int n10 = nArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Integer n13 = n11;
            ++n11;
            Object object = n12;
            object = p10.invoke(n13, object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Long Pi(long[] lArray, l l10) {
        f0.p(lArray, "$this$maxByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = lArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        long l11 = lArray[0];
        int n12 = ArraysKt___ArraysKt.Qd(lArray);
        if (n12 == 0) {
            return l11;
        }
        Comparable<Long> comparable = l11;
        comparable = (Comparable)l10.invoke(comparable);
        if (n11 <= n12) {
            while (true) {
                long l12 = lArray[n11];
                Comparable<Long> comparable2 = l12;
                int n13 = comparable.compareTo((Long)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 < 0) {
                    l11 = l12;
                    comparable = comparable2;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return l11;
    }

    private static final Float Pj(int[] nArray, l l10) {
        Number number;
        float f10;
        int n10 = nArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray[0];
        number = n10;
        number = (Number)l10.invoke(number);
        f10 = number.floatValue();
        n11 = ArraysKt___ArraysKt.Pd(nArray);
        if (n12 <= n11) {
            while (true) {
                int n13 = nArray[n12];
                Number number2 = n13;
                number2 = (Number)l10.invoke(number2);
                float f12 = number2.floatValue();
                f10 = Math.max(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final Character Pk(char[] cArray) {
        f0.p(cArray, "$this$min");
        return ArraysKt___ArraysKt.Lm(cArray);
    }

    private static final Comparable Pl(short[] object, l l10) {
        Comparable<Short> comparable;
        int n10 = ((short[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            comparable = (short)n10;
            comparable = (Comparable)l10.invoke(comparable);
            n11 = ArraysKt___ArraysKt.Sd(object);
            if (n12 <= n11) {
                while (true) {
                    short s10 = object[n12];
                    Comparable<Short> comparable2 = s10;
                    int n13 = comparable.compareTo((Short)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n13 > 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Float Pm(float[] fArray) {
        float f10;
        String string2 = "$this$minOrNull";
        f0.p(fArray, string2);
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            string2 = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        f10 = fArray[0];
        n11 = ArraysKt___ArraysKt.Od(fArray);
        if (n12 <= n11) {
            while (true) {
                float f12 = fArray[n12];
                f10 = Math.min(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    private static final double[] Pn(double[] dArray, p p10) {
        int n10 = dArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            Integer n12 = n11;
            ++n11;
            Double d11 = d10;
            p10.invoke(n12, d11);
        }
        return dArray;
    }

    public static final byte Po(byte[] object, p p10) {
        f0.p(object, "$this$reduce");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ((byte[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Ld(object);
            if (n12 <= n11) {
                while (true) {
                    object2 = (byte)n10;
                    byte by2 = object[n12];
                    Byte by3 = by2;
                    object2 = (Number)p10.invoke(object2, by3);
                    n10 = ((Number)object2).byteValue();
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return (byte)n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final short Pp(short[] object, q q10) {
        f0.p(object, "$this$reduceRightIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int s10 = ArraysKt___ArraysKt.Sd((short[])object);
        if (s10 >= 0) {
            short s11;
            Object object3 = object[s10];
            for (int i10 = s10 + -1; i10 >= 0; i10 += -1) {
                Integer n10 = i10;
                Object object4 = object[i10];
                Short s12 = (short)object4;
                object2 = s11;
                object2 = (Number)q10.invoke(n10, s12, object2);
                s11 = ((Number)object2).shortValue();
            }
            return s11;
        }
        object = new UnsupportedOperationException("Empty array can't be reduced.");
        throw object;
    }

    public static final int[] Pq(int[] nArray) {
        Object object = "$this$reversedArray";
        f0.p(nArray, (String)object);
        int n10 = nArray.length;
        int n11 = 0;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return nArray;
        }
        n10 = nArray.length;
        object = new int[n10];
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n12 >= 0) {
            while (true) {
                int n13 = n12 - n11;
                int n14 = nArray[n11];
                object[n13] = n14;
                if (n11 == n12) break;
                ++n11;
            }
        }
        return object;
    }

    private static final List Pr(double[] object, Object object2, q q10) {
        ArrayList<Object> arrayList;
        int n10 = ((double[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            int n13 = ((double[])object).length + n12;
            arrayList = new ArrayList<Object>(n13);
            arrayList.add(object2);
            n12 = ((double[])object).length;
            while (n11 < n12) {
                Integer n14 = n11;
                double d10 = object[n11];
                Double d11 = d10;
                object2 = q10.invoke(n14, object2, d11);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final int Ps(int[] object, l l10) {
        f0.p(object, "$this$single");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((int[])object).length;
        boolean bl2 = false;
        Integer n11 = null;
        boolean bl3 = false;
        Integer n12 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n13 = object[i10];
            Constable constable = Integer.valueOf(n13);
            boolean bl4 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl4) continue;
            if (!bl3) {
                n12 = n13;
                bl2 = true;
                n11 = n12;
                bl3 = bl2;
                continue;
            }
            object = new IllegalArgumentException;
            object("Array contains more than one matching element.");
            throw object;
        }
        if (bl3) {
            Objects.requireNonNull(n11, "null cannot be cast to non-null type kotlin.Int");
            return n11;
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final float[] Pt(float[] fArray, k k10) {
        f0.p(fArray, "$this$sliceArray");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return new float[0];
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.J1(fArray, n10, n11);
    }

    public static final short[] Pu(short[] sArray) {
        String string2 = "$this$sortedArrayDescending";
        f0.p(sArray, string2);
        int n10 = sArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return sArray;
        }
        n10 = sArray.length;
        sArray = Arrays.copyOf(sArray, n10);
        f0.o(sArray, "java.util.Arrays.copyOf(this, size)");
        ArraysKt___ArraysKt.qu(sArray);
        return sArray;
    }

    public static final int Pv(byte[] byArray, l l10) {
        f0.p(byArray, "$this$sumBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Number number = byArray[i10];
            number = (Number)l10.invoke(number);
            int n12 = number.intValue();
            n11 += n12;
        }
        return n11;
    }

    private static final int Pw(char[] cArray, l l10) {
        int n10 = f.c1.h(0);
        int n11 = cArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            Comparable<Character> comparable = Character.valueOf(cArray[i10]);
            comparable = (f.c1)l10.invoke(comparable);
            int n12 = ((f.c1)comparable).a0();
            n10 = f.c1.h(n10 + n12);
        }
        return n10;
    }

    public static final List Px(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$takeWhile");
        f0.p(l10, "predicate");
        ArrayList<Boolean> arrayList = new ArrayList<Boolean>();
        for (boolean bl2 : blArray) {
            Boolean bl3 = bl2;
            boolean bl4 = bl3 = (Boolean)l10.invoke(bl3);
            if (!bl4) break;
            Boolean bl5 = bl2;
            arrayList.add(bl5);
        }
        return arrayList;
    }

    public static final Set Py(boolean[] blArray) {
        f0.p(blArray, "$this$toMutableSet");
        int n10 = s0.j(blArray.length);
        LinkedHashSet linkedHashSet = new LinkedHashSet(n10);
        return (Set)ArraysKt___ArraysKt.by(blArray, linkedHashSet);
    }

    public static final List Pz(float[] fArray, Object[] objectArray, p p10) {
        f0.p(fArray, "$this$zip");
        f0.p(objectArray, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = fArray.length;
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Object object = Float.valueOf(f10);
            Object object2 = objectArray[i10];
            object = p10.invoke(object, object2);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final boolean Q4(boolean[] blArray) {
        String string2 = "$this$any";
        f0.p(blArray, string2);
        int n10 = blArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            blArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final Map Q5(double[] dArray, Map map, l l10, l l11) {
        f0.p(dArray, "$this$associateByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (double d10 : dArray) {
            Object object = d10;
            object = l10.invoke(object);
            Object object2 = d10;
            object2 = l11.invoke(object2);
            map.put(object, object2);
        }
        return map;
    }

    private static final byte Q6(byte[] byArray) {
        f0.p(byArray, "$this$component1");
        return byArray[0];
    }

    /*
     * WARNING - void declaration
     */
    public static final boolean Q7(short[] sArray, short s10) {
        void var3_6;
        String string2 = "$this$contains";
        f0.p(sArray, string2);
        int bl2 = ArraysKt___ArraysKt.ef(sArray, s10);
        if (bl2 >= 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            sArray = null;
        }
        return (boolean)var3_6;
    }

    public static final List Q8(long[] object, int n10) {
        f0.p(object, "$this$dropLast");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((long[])object).length - n10, 0);
            return ArraysKt___ArraysKt.lx((long[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List Q9(float[] fArray, p p10) {
        f0.p(fArray, "$this$filterIndexed");
        f0.p(p10, "predicate");
        ArrayList<Constable> arrayList = new ArrayList<Constable>();
        int n10 = fArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Float f11 = Float.valueOf(f10);
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, f11))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                constable = Float.valueOf(f10);
                arrayList.add(constable);
            }
            n11 = n12;
        }
        return arrayList;
    }

    private static final Long Qa(long[] object, l l10) {
        block1: {
            int n10 = ((long[])object).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                long l11 = object[i10];
                Constable constable = Long.valueOf(l11);
                boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
                if (!bl2) continue;
                object = l11;
                break block1;
            }
            object = null;
        }
        return object;
    }

    public static final List Qb(int[] nArray, l l10) {
        f0.p(nArray, "$this$flatMap");
        f0.p(l10, "transform");
        ArrayList arrayList = new ArrayList();
        for (int n10 : nArray) {
            Object object = n10;
            object = (Iterable)l10.invoke(object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object Qc(short[] sArray, Object object, q q10) {
        f0.p(sArray, "$this$foldIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Integer n12 = n11;
            ++n11;
            Short s11 = s10;
            object = q10.invoke(n12, object, s11);
        }
        return object;
    }

    public static final int Qd(long[] lArray) {
        f0.p(lArray, "$this$lastIndex");
        return lArray.length + -1;
    }

    public static final Map Qe(Object[] objectArray, Map map, l l10) {
        f0.p(objectArray, "$this$groupByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (Object object : objectArray) {
            Object object2 = l10.invoke(object);
            Object object3 = map.get(object2);
            if (object3 == null) {
                object3 = new ArrayList();
                map.put(object2, object3);
            }
            object3 = (List)object3;
            object3.add((Object)object);
        }
        return map;
    }

    private static final boolean Qf(byte[] byArray) {
        int n10 = byArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            byArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final float Qg(float[] object, l l10) {
        f0.p(object, "$this$last");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((float[])object).length;
        while ((n10 += -1) >= 0) {
            float f10 = object[n10];
            Constable constable = Float.valueOf(f10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return f10;
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final List Qh(long[] lArray, p p10) {
        f0.p(lArray, "$this$mapIndexed");
        f0.p(p10, "transform");
        int n10 = lArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = l10;
            object = p10.invoke(n12, object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Object Qi(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$maxByOrNull");
        Object object = "selector";
        f0.p(l10, (String)object);
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        object = objectArray[0];
        n11 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n11 == 0) {
            return object;
        }
        Comparable comparable = (Comparable)l10.invoke(object);
        if (n12 <= n11) {
            while (true) {
                Object object2;
                Comparable comparable2;
                int n13;
                if ((n13 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(object2 = objectArray[n12]))) < 0) {
                    object = object2;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    private static final Float Qj(long[] lArray, l l10) {
        Number number;
        float f10;
        int n10 = lArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        long l11 = lArray[0];
        number = l11;
        number = (Number)l10.invoke(number);
        f10 = number.floatValue();
        n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n12 <= n11) {
            while (true) {
                long l12 = lArray[n12];
                Number number2 = l12;
                number2 = (Number)l10.invoke(number2);
                float f12 = number2.floatValue();
                f10 = Math.max(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final Comparable Qk(Comparable[] comparableArray) {
        f0.p(comparableArray, "$this$min");
        return ArraysKt___ArraysKt.Mm(comparableArray);
    }

    private static final Comparable Ql(boolean[] object, l l10) {
        Comparable<Boolean> comparable;
        int n10 = ((boolean[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            comparable = n10 != 0;
            comparable = (Comparable)l10.invoke(comparable);
            n11 = ArraysKt___ArraysKt.Td(object);
            if (n12 <= n11) {
                while (true) {
                    boolean bl2 = object[n12];
                    Comparable<Boolean> comparable2 = bl2;
                    int n13 = comparable.compareTo((Boolean)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n13 > 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Float Qm(Float[] floatArray) {
        float f10;
        Object object = "$this$minOrNull";
        f0.p(floatArray, (String)object);
        int n10 = floatArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            object = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        object = floatArray[0];
        f10 = ((Float)object).floatValue();
        n11 = ArraysKt___ArraysKt.Rd(floatArray);
        if (n12 <= n11) {
            while (true) {
                Float f12 = floatArray[n12];
                float f13 = f12.floatValue();
                f10 = Math.min(f10, f13);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    private static final float[] Qn(float[] fArray, p p10) {
        int n10 = fArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Integer n12 = n11;
            ++n11;
            Float f11 = Float.valueOf(f10);
            p10.invoke(n12, f11);
        }
        return fArray;
    }

    public static final char Qo(char[] object, p p10) {
        f0.p(object, "$this$reduce");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ((char[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Md(object);
            if (n12 <= n11) {
                while (true) {
                    object2 = Character.valueOf((char)n10);
                    char c10 = object[n12];
                    Character c11 = Character.valueOf(c10);
                    object2 = (Character)p10.invoke(object2, c11);
                    n10 = ((Character)object2).charValue();
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return (char)n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final boolean Qp(boolean[] object, q q10) {
        f0.p(object, "$this$reduceRightIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Td((boolean[])object);
        if (n10 >= 0) {
            boolean bl2;
            Object object3 = object[n10];
            for (int i10 = n10 + -1; i10 >= 0; i10 += -1) {
                Integer n11 = i10;
                Object object4 = object[i10];
                Boolean bl3 = (boolean)object4;
                object2 = bl2;
                object2 = (Boolean)q10.invoke(n11, bl3, object2);
                bl2 = (Boolean)object2;
            }
            return bl2;
        }
        object = new UnsupportedOperationException("Empty array can't be reduced.");
        throw object;
    }

    public static final long[] Qq(long[] lArray) {
        Object object = "$this$reversedArray";
        f0.p(lArray, (String)object);
        int n10 = lArray.length;
        int n11 = 0;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return lArray;
        }
        n10 = lArray.length;
        object = new long[n10];
        int n12 = ArraysKt___ArraysKt.Qd(lArray);
        if (n12 >= 0) {
            while (true) {
                int n13 = n12 - n11;
                long l10 = lArray[n11];
                object[n13] = l10;
                if (n11 == n12) break;
                ++n11;
            }
        }
        return object;
    }

    private static final List Qr(float[] object, Object object2, q q10) {
        ArrayList<Object> arrayList;
        int n10 = ((float[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            int n13 = ((float[])object).length + n12;
            arrayList = new ArrayList<Object>(n13);
            arrayList.add(object2);
            n12 = ((float[])object).length;
            while (n11 < n12) {
                Integer n14 = n11;
                float f10 = object[n11];
                Float f11 = Float.valueOf(f10);
                object2 = q10.invoke(n14, object2, f11);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final long Qs(long[] object) {
        String string2 = "$this$single";
        f0.p(object, string2);
        int n10 = ((long[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                return object[0];
            }
            object = new IllegalArgumentException;
            object("Array has more than one element.");
            throw object;
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final int[] Qt(int[] nArray, Collection object) {
        int n10;
        f0.p(nArray, "$this$sliceArray");
        f0.p(object, "indices");
        int n11 = object.size();
        int[] nArray2 = new int[n11];
        object = object.iterator();
        int n12 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Number number = (Number)object.next();
            n10 = number.intValue();
            int n13 = n12 + 1;
            nArray2[n12] = n10 = nArray[n10];
            n12 = n13;
        }
        return nArray2;
    }

    public static final Object[] Qu(Object[] objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$sortedArrayWith");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = objectArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return objectArray;
        }
        n10 = objectArray.length;
        objectArray = Arrays.copyOf(objectArray, n10);
        f0.o(objectArray, "java.util.Arrays.copyOf(this, size)");
        f.x1.n.E3(objectArray, comparator);
        return objectArray;
    }

    public static final int Qv(char[] cArray, l l10) {
        f0.p(cArray, "$this$sumBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = cArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Serializable serializable = Character.valueOf(cArray[i10]);
            serializable = (Number)l10.invoke(serializable);
            int n12 = ((Number)serializable).intValue();
            n11 += n12;
        }
        return n11;
    }

    private static final int Qw(double[] dArray, l l10) {
        int n10 = f.c1.h(0);
        for (double d10 : dArray) {
            Comparable<Double> comparable = d10;
            comparable = (f.c1)l10.invoke(comparable);
            int n11 = ((f.c1)comparable).a0();
            n10 = f.c1.h(n10 + n11);
        }
        return n10;
    }

    public static final boolean[] Qx(Boolean[] booleanArray) {
        String string2 = "$this$toBooleanArray";
        f0.p(booleanArray, string2);
        int n10 = booleanArray.length;
        boolean[] blArray = new boolean[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            Boolean bl3 = booleanArray[i10];
            blArray[i10] = bl2 = bl3.booleanValue();
        }
        return blArray;
    }

    public static final Set Qy(byte[] object) {
        LinkedHashSet linkedHashSet = "$this$toSet";
        f0.p(object, (String)((Object)linkedHashSet));
        int n10 = ((byte[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = s0.j(((byte[])object).length);
                linkedHashSet = new LinkedHashSet(n11);
                object = (Set)ArraysKt___ArraysKt.Tx(object, linkedHashSet);
            } else {
                n10 = 0;
                linkedHashSet = null;
                byte by2 = object[0];
                object = c1.f(by2);
            }
        } else {
            object = d1.k();
        }
        return object;
    }

    public static final List Qz(int[] nArray, Iterable object) {
        boolean bl2;
        f0.p(nArray, "$this$zip");
        String string2 = "other";
        f0.p(object, string2);
        int n10 = nArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n11);
        object = object.iterator();
        n11 = 0;
        Pair pair = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            pair = w0.a(nArray[n11], e10);
            arrayList.add(pair);
            n11 = n12;
        }
        return arrayList;
    }

    public static final boolean R4(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$any");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = blArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Boolean bl2 = blArray[i10];
            boolean bl3 = bl2 = (Boolean)l10.invoke(bl2);
            if (!bl3) continue;
            return true;
        }
        return false;
    }

    public static final Map R5(float[] fArray, Map map, l l10) {
        f0.p(fArray, "$this$associateByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            object = l10.invoke(object);
            Float f11 = Float.valueOf(f10);
            map.put(object, f11);
        }
        return map;
    }

    private static final char R6(char[] cArray) {
        f0.p(cArray, "$this$component1");
        return cArray[0];
    }

    /*
     * WARNING - void declaration
     */
    public static final boolean R7(boolean[] blArray, boolean bl2) {
        void var3_6;
        String string2 = "$this$contains";
        f0.p(blArray, string2);
        int bl3 = ArraysKt___ArraysKt.ff(blArray, bl2);
        if (bl3 >= 0) {
            boolean bl4 = true;
        } else {
            boolean bl5 = false;
            blArray = null;
        }
        return (boolean)var3_6;
    }

    public static final List R8(Object[] object, int n10) {
        f0.p(object, "$this$dropLast");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((Object[])object).length - n10, 0);
            return ArraysKt___ArraysKt.mx((Object[])object, n10);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List R9(int[] nArray, p p10) {
        f0.p(nArray, "$this$filterIndexed");
        f0.p(p10, "predicate");
        ArrayList<Constable> arrayList = new ArrayList<Constable>();
        int n10 = nArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            int n13 = n11 + 1;
            constable = Integer.valueOf(n11);
            Integer n14 = n12;
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, n14))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                constable = Integer.valueOf(n12);
                arrayList.add(constable);
            }
            n11 = n13;
        }
        return arrayList;
    }

    private static final Object Ra(Object[] objectArray, l l10) {
        Object object2;
        block2: {
            for (Object object2 : objectArray) {
                Boolean bl2 = (Boolean)l10.invoke(object2);
                boolean bl3 = bl2;
                if (!bl3) {
                    continue;
                }
                break block2;
            }
            object2 = null;
        }
        return object2;
    }

    public static final List Rb(long[] lArray, l l10) {
        f0.p(lArray, "$this$flatMap");
        f0.p(l10, "transform");
        ArrayList arrayList = new ArrayList();
        for (long l11 : lArray) {
            Object object = l11;
            object = (Iterable)l10.invoke(object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object Rc(boolean[] blArray, Object object, q q10) {
        f0.p(blArray, "$this$foldIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        int n10 = blArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            Integer n12 = n11;
            ++n11;
            Boolean bl3 = bl2;
            object = q10.invoke(n12, object, bl3);
        }
        return object;
    }

    public static final int Rd(Object[] objectArray) {
        f0.p(objectArray, "$this$lastIndex");
        return objectArray.length + -1;
    }

    public static final Map Re(Object[] objectArray, Map map, l l10, l l11) {
        f0.p(objectArray, "$this$groupByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (Object object : objectArray) {
            Object object2 = l10.invoke(object);
            Object object3 = map.get(object2);
            if (object3 == null) {
                object3 = new ArrayList();
                map.put(object2, object3);
            }
            object3 = (List)object3;
            object = l11.invoke(object);
            object3.add((Object)object);
        }
        return map;
    }

    private static final boolean Rf(char[] cArray) {
        int n10 = cArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            cArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final int Rg(int[] object) {
        String string2 = "$this$last";
        f0.p(object, string2);
        int n10 = ((int[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ArraysKt___ArraysKt.Pd(object);
            return object[n10];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final List Rh(Object[] objectArray, p p10) {
        f0.p(objectArray, "$this$mapIndexed");
        f0.p(p10, "transform");
        int n10 = objectArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        n10 = objectArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            Integer n12 = n11;
            ++n11;
            object = p10.invoke(n12, object);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Short Ri(short[] sArray, l l10) {
        f0.p(sArray, "$this$maxByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = sArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray[0];
        n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n11 == 0) {
            return (short)n10;
        }
        Comparable<Short> comparable = (short)n10;
        comparable = (Comparable)l10.invoke(comparable);
        if (n12 <= n11) {
            while (true) {
                int n13 = sArray[n12];
                Comparable<Short> comparable2 = (short)n13;
                int n14 = comparable.compareTo((Short)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n14 < 0) {
                    n10 = n13;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return (short)n10;
    }

    private static final Float Rj(Object[] objectArray, l l10) {
        Object object;
        float f10;
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            object = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        object = objectArray[0];
        object = (Number)l10.invoke(object);
        f10 = ((Number)object).floatValue();
        n11 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n12 <= n11) {
            while (true) {
                Object object2 = objectArray[n12];
                object2 = (Number)l10.invoke(object2);
                float f12 = ((Number)object2).floatValue();
                f10 = Math.max(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final Double Rk(double[] dArray) {
        f0.p(dArray, "$this$min");
        return ArraysKt___ArraysKt.Nm(dArray);
    }

    private static final Comparable Rl(byte[] byArray, l l10) {
        Comparable<Byte> comparable;
        int n10 = byArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray[0];
        comparable = (byte)n10;
        comparable = (Comparable)l10.invoke(comparable);
        n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n12 <= n11) {
            while (true) {
                byte by2 = byArray[n12];
                Comparable<Byte> comparable2 = by2;
                int n13 = comparable.compareTo((Byte)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 > 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Integer Rm(int[] nArray) {
        String string2 = "$this$minOrNull";
        f0.p(nArray, string2);
        int n10 = nArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray[0];
        n11 = ArraysKt___ArraysKt.Pd(nArray);
        if (n12 <= n11) {
            while (true) {
                int n13;
                if (n10 > (n13 = nArray[n12])) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return n10;
    }

    private static final int[] Rn(int[] nArray, p p10) {
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Integer n13 = n11;
            ++n11;
            Integer n14 = n12;
            p10.invoke(n13, n14);
        }
        return nArray;
    }

    public static final double Ro(double[] object, p p10) {
        f0.p(object, "$this$reduce");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ((double[])object).length;
        Double d10 = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            double d11 = object[0];
            int n12 = ArraysKt___ArraysKt.Nd(object);
            if (n11 <= n12) {
                while (true) {
                    object2 = d11;
                    double d12 = object[n11];
                    d10 = d12;
                    object2 = (Number)p10.invoke(object2, d10);
                    d11 = ((Number)object2).doubleValue();
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d11;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final Boolean Rp(boolean[] blArray, q q10) {
        boolean bl2;
        f0.p(blArray, "$this$reduceRightIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = ArraysKt___ArraysKt.Td(blArray);
        if (n10 < 0) {
            return null;
        }
        boolean bl3 = blArray[n10];
        for (int i10 = n10 + -1; i10 >= 0; i10 += -1) {
            Integer n11 = i10;
            boolean bl4 = blArray[i10];
            Boolean bl5 = bl4;
            object = bl2;
            object = (Boolean)q10.invoke(n11, bl5, object);
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public static final Object[] Rq(Object[] objectArray) {
        Object[] objectArray2 = "$this$reversedArray";
        f0.p(objectArray, (String)objectArray2);
        int n10 = objectArray.length;
        int n11 = 0;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            objectArray2 = null;
        }
        if (n10 != 0) {
            return objectArray;
        }
        n10 = objectArray.length;
        objectArray2 = f.x1.l.a(objectArray, n10);
        int n12 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n12 >= 0) {
            while (true) {
                Object object;
                int n13 = n12 - n11;
                objectArray2[n13] = object = objectArray[n11];
                if (n11 == n12) break;
                ++n11;
            }
        }
        return objectArray2;
    }

    private static final List Rr(int[] object, Object object2, q q10) {
        ArrayList<Object> arrayList;
        int n10 = ((int[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            int n13 = ((int[])object).length + n12;
            arrayList = new ArrayList<Object>(n13);
            arrayList.add(object2);
            n12 = ((int[])object).length;
            while (n11 < n12) {
                Integer n14 = n11;
                int n15 = object[n11];
                Integer n16 = n15;
                object2 = q10.invoke(n14, object2, n16);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final long Rs(long[] object, l l10) {
        f0.p(object, "$this$single");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((long[])object).length;
        boolean bl2 = false;
        Long l11 = null;
        boolean bl3 = false;
        Long l12 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l13 = object[i10];
            Constable constable = Long.valueOf(l13);
            boolean bl4 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl4) continue;
            if (!bl3) {
                l12 = l13;
                bl2 = true;
                l11 = l12;
                bl3 = bl2;
                continue;
            }
            object = new IllegalArgumentException;
            object("Array contains more than one matching element.");
            throw object;
        }
        if (bl3) {
            Objects.requireNonNull(l11, "null cannot be cast to non-null type kotlin.Long");
            return l11;
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final int[] Rt(int[] nArray, k k10) {
        f0.p(nArray, "$this$sliceArray");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return new int[0];
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.K1(nArray, n10, n11);
    }

    public static final List Ru(byte[] byArray, l l10) {
        f0.p(byArray, "$this$sortedBy");
        f0.p(l10, "selector");
        b$b b$b = new b$b(l10);
        return ArraysKt___ArraysKt.rv(byArray, b$b);
    }

    public static final int Rv(double[] dArray, l l10) {
        f0.p(dArray, "$this$sumBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = dArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            Number number = d10;
            number = (Number)l10.invoke(number);
            int n12 = number.intValue();
            n11 += n12;
        }
        return n11;
    }

    private static final int Rw(float[] fArray, l l10) {
        int n10 = f.c1.h(0);
        for (float f10 : fArray) {
            Comparable<Float> comparable = Float.valueOf(f10);
            comparable = (f.c1)l10.invoke(comparable);
            int n11 = ((f.c1)comparable).a0();
            n10 = f.c1.h(n10 + n11);
        }
        return n10;
    }

    public static final byte[] Rx(Byte[] byteArray) {
        String string2 = "$this$toByteArray";
        f0.p(byteArray, string2);
        int n10 = byteArray.length;
        byte[] byArray = new byte[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2;
            Byte by3 = byteArray[i10];
            byArray[i10] = by2 = by3.byteValue();
        }
        return byArray;
    }

    public static final Set Ry(char[] object) {
        LinkedHashSet linkedHashSet = "$this$toSet";
        f0.p(object, (String)((Object)linkedHashSet));
        int n10 = ((char[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = ((char[])object).length;
                int n12 = 128;
                n11 = s0.j(f.l2.q.u(n11, n12));
                linkedHashSet = new LinkedHashSet(n11);
                object = (Set)ArraysKt___ArraysKt.Ux(object, linkedHashSet);
            } else {
                n10 = 0;
                linkedHashSet = null;
                char c10 = object[0];
                object = c1.f(Character.valueOf(c10));
            }
        } else {
            object = d1.k();
        }
        return object;
    }

    public static final List Rz(int[] nArray, Iterable object, p p10) {
        boolean bl2;
        f0.p(nArray, "$this$zip");
        f0.p(object, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = nArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        n11 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            object2 = nArray[n11];
            object2 = p10.invoke(object2, e10);
            arrayList.add(object2);
            n11 = n12;
        }
        return arrayList;
    }

    public static final Iterable S4(byte[] byArray) {
        Object object = "$this$asIterable";
        f0.p(byArray, (String)object);
        int n10 = byArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = new ArraysKt___ArraysKt$b(byArray);
        return object;
    }

    public static final Map S5(float[] fArray, Map map, l l10, l l11) {
        f0.p(fArray, "$this$associateByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            object = l10.invoke(object);
            Object object2 = Float.valueOf(f10);
            object2 = l11.invoke(object2);
            map.put(object, object2);
        }
        return map;
    }

    private static final double S6(double[] dArray) {
        f0.p(dArray, "$this$component1");
        return dArray[0];
    }

    private static final int S7(byte[] byArray) {
        return byArray.length;
    }

    public static final List S8(short[] object, int n10) {
        f0.p(object, "$this$dropLast");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((short[])object).length - n10, 0);
            return ArraysKt___ArraysKt.nx((short[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List S9(long[] lArray, p p10) {
        f0.p(lArray, "$this$filterIndexed");
        f0.p(p10, "predicate");
        ArrayList<Constable> arrayList = new ArrayList<Constable>();
        int n10 = lArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Long l11 = l10;
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, l11))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                constable = Long.valueOf(l10);
                arrayList.add(constable);
            }
            n11 = n12;
        }
        return arrayList;
    }

    private static final Short Sa(short[] object, l l10) {
        block1: {
            int n10 = ((short[])object).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                short s10 = object[i10];
                Constable constable = Short.valueOf(s10);
                boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
                if (!bl2) continue;
                object = s10;
                break block1;
            }
            object = null;
        }
        return object;
    }

    public static final List Sb(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$flatMap");
        f0.p(l10, "transform");
        ArrayList arrayList = new ArrayList();
        for (Object object : objectArray) {
            object = (Iterable)l10.invoke(object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object Sc(byte[] byArray, Object object, p p10) {
        f0.p(byArray, "$this$foldRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Ld(byArray);
        while (n10 >= 0) {
            int n11 = n10 + -1;
            object2 = byArray[n10];
            object = p10.invoke(object2, object);
            n10 = n11;
        }
        return object;
    }

    public static final int Sd(short[] sArray) {
        f0.p(sArray, "$this$lastIndex");
        return sArray.length + -1;
    }

    public static final Map Se(short[] sArray, Map map, l l10) {
        f0.p(sArray, "$this$groupByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (short s10 : sArray) {
            Object object = s10;
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Short s11 = s10;
            object2.add((Short)s11);
        }
        return map;
    }

    private static final boolean Sf(double[] dArray) {
        int n10 = dArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            dArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final int Sg(int[] object, l l10) {
        f0.p(object, "$this$last");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((int[])object).length;
        while ((n10 += -1) >= 0) {
            int n11 = object[n10];
            Constable constable = Integer.valueOf(n11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return n11;
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final List Sh(short[] sArray, p p10) {
        f0.p(sArray, "$this$mapIndexed");
        f0.p(p10, "transform");
        int n10 = sArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = s10;
            object = p10.invoke(n12, object);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final double Si(byte[] object, l l10) {
        Number number;
        int n10 = ((byte[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            number = (byte)n10;
            number = (Number)l10.invoke(number);
            double d10 = number.doubleValue();
            int n12 = ArraysKt___ArraysKt.Ld(object);
            if (n11 <= n12) {
                while (true) {
                    byte by2 = object[n11];
                    Number number2 = by2;
                    number2 = (Number)l10.invoke(number2);
                    double d11 = number2.doubleValue();
                    d10 = Math.max(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Float Sj(short[] sArray, l l10) {
        Number number;
        float f10;
        int n10 = sArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray[0];
        number = (short)n10;
        number = (Number)l10.invoke(number);
        f10 = number.floatValue();
        n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n12 <= n11) {
            while (true) {
                short s10 = sArray[n12];
                Number number2 = s10;
                number2 = (Number)l10.invoke(number2);
                float f12 = number2.floatValue();
                f10 = Math.max(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final Double Sk(Double[] doubleArray) {
        f0.p(doubleArray, "$this$min");
        return ArraysKt___ArraysKt.Om(doubleArray);
    }

    private static final Comparable Sl(char[] cArray, l l10) {
        Comparable<Character> comparable;
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray[0];
        comparable = Character.valueOf((char)n10);
        comparable = (Comparable)l10.invoke(comparable);
        n11 = ArraysKt___ArraysKt.Md(cArray);
        if (n12 <= n11) {
            while (true) {
                char c10 = cArray[n12];
                Comparable<Character> comparable2 = Character.valueOf(c10);
                int n13 = comparable.compareTo((Character)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 > 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Long Sm(long[] lArray) {
        String string2 = "$this$minOrNull";
        f0.p(lArray, string2);
        int n10 = lArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        long l10 = lArray[0];
        int n12 = ArraysKt___ArraysKt.Qd(lArray);
        if (n11 <= n12) {
            while (true) {
                long l11;
                long l12;
                long l13;
                if ((l13 = (l12 = l10 - (l11 = lArray[n11])) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                    l10 = l11;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return l10;
    }

    private static final long[] Sn(long[] lArray, p p10) {
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Integer n12 = n11;
            ++n11;
            Long l11 = l10;
            p10.invoke(n12, l11);
        }
        return lArray;
    }

    public static final float So(float[] object, p p10) {
        float f10;
        f0.p(object, "$this$reduce");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ((float[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            object2 = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            f10 = object[0];
            n11 = ArraysKt___ArraysKt.Od(object);
            if (n12 <= n11) {
                while (true) {
                    object2 = Float.valueOf(f10);
                    float f12 = object[n12];
                    Float f13 = Float.valueOf(f12);
                    object2 = (Number)p10.invoke(object2, f13);
                    f10 = ((Number)object2).floatValue();
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final Byte Sp(byte[] byArray, q q10) {
        byte by2;
        f0.p(byArray, "$this$reduceRightIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int by22 = ArraysKt___ArraysKt.Ld(byArray);
        if (by22 < 0) {
            return null;
        }
        byte by3 = byArray[by22];
        for (int i10 = by22 + -1; i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            byte by4 = byArray[i10];
            Byte by5 = by4;
            object = by2;
            object = (Number)q10.invoke(n10, by5, object);
            by2 = ((Number)object).byteValue();
        }
        return by2;
    }

    public static final short[] Sq(short[] sArray) {
        Object object = "$this$reversedArray";
        f0.p(sArray, (String)object);
        int n10 = sArray.length;
        int n11 = 0;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return sArray;
        }
        n10 = sArray.length;
        object = new short[n10];
        int n12 = ArraysKt___ArraysKt.Sd(sArray);
        if (n12 >= 0) {
            while (true) {
                int n13 = n12 - n11;
                short s10 = sArray[n11];
                object[n13] = s10;
                if (n11 == n12) break;
                ++n11;
            }
        }
        return object;
    }

    private static final List Sr(long[] object, Object object2, q q10) {
        ArrayList<Object> arrayList;
        int n10 = ((long[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            int n13 = ((long[])object).length + n12;
            arrayList = new ArrayList<Object>(n13);
            arrayList.add(object2);
            n12 = ((long[])object).length;
            while (n11 < n12) {
                Integer n14 = n11;
                long l10 = object[n11];
                Long l11 = l10;
                object2 = q10.invoke(n14, object2, l11);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Object Ss(Object[] object) {
        String string2 = "$this$single";
        f0.p(object, string2);
        int n10 = ((Object[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                return object[0];
            }
            object = new IllegalArgumentException("Array has more than one element.");
            throw object;
        }
        object = new NoSuchElementException("Array is empty.");
        throw object;
    }

    public static final long[] St(long[] lArray, Collection object) {
        int n10;
        f0.p(lArray, "$this$sliceArray");
        f0.p(object, "indices");
        int n11 = object.size();
        long[] lArray2 = new long[n11];
        object = object.iterator();
        int n12 = 0;
        while ((n10 = object.hasNext()) != 0) {
            long l10;
            Number number = (Number)object.next();
            n10 = number.intValue();
            int n13 = n12 + 1;
            lArray2[n12] = l10 = lArray[n10];
            n12 = n13;
        }
        return lArray2;
    }

    public static final List Su(char[] cArray, l l10) {
        f0.p(cArray, "$this$sortedBy");
        f0.p(l10, "selector");
        b$b b$b = new b$b(l10);
        return ArraysKt___ArraysKt.sv(cArray, b$b);
    }

    public static final int Sv(float[] fArray, l l10) {
        f0.p(fArray, "$this$sumBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = fArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Number number = Float.valueOf(f10);
            number = (Number)l10.invoke(number);
            int n12 = number.intValue();
            n11 += n12;
        }
        return n11;
    }

    private static final int Sw(int[] nArray, l l10) {
        int n10 = f.c1.h(0);
        int n11 = nArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            Comparable<Integer> comparable = nArray[i10];
            comparable = (f.c1)l10.invoke(comparable);
            int n12 = ((f.c1)comparable).a0();
            n10 = f.c1.h(n10 + n12);
        }
        return n10;
    }

    public static final char[] Sx(Character[] characterArray) {
        String string2 = "$this$toCharArray";
        f0.p(characterArray, string2);
        int n10 = characterArray.length;
        char[] cArray = new char[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10;
            Character c11 = characterArray[i10];
            cArray[i10] = c10 = c11.charValue();
        }
        return cArray;
    }

    public static final Set Sy(double[] object) {
        LinkedHashSet linkedHashSet = "$this$toSet";
        f0.p(object, (String)((Object)linkedHashSet));
        int n10 = ((double[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = s0.j(((double[])object).length);
                linkedHashSet = new LinkedHashSet(n11);
                object = (Set)ArraysKt___ArraysKt.Vx(object, linkedHashSet);
            } else {
                n10 = 0;
                linkedHashSet = null;
                double d10 = object[0];
                object = c1.f(d10);
            }
        } else {
            object = d1.k();
        }
        return object;
    }

    public static final List Sz(int[] nArray, int[] nArray2) {
        f0.p(nArray, "$this$zip");
        String string2 = "other";
        f0.p(nArray2, string2);
        int n10 = nArray.length;
        int n11 = nArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Integer> arrayList = new ArrayList<Integer>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            int n13 = nArray2[i10];
            Serializable serializable = n12;
            Integer n14 = n13;
            serializable = w0.a(serializable, n14);
            arrayList.add((Integer)serializable);
        }
        return arrayList;
    }

    public static final Iterable T4(char[] cArray) {
        Object object = "$this$asIterable";
        f0.p(cArray, (String)object);
        int n10 = cArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = new ArraysKt___ArraysKt$i(cArray);
        return object;
    }

    public static final Map T5(int[] nArray, Map map, l l10) {
        f0.p(nArray, "$this$associateByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (int n10 : nArray) {
            Object object = n10;
            object = l10.invoke(object);
            Integer n11 = n10;
            map.put(object, n11);
        }
        return map;
    }

    private static final float T6(float[] fArray) {
        f0.p(fArray, "$this$component1");
        return fArray[0];
    }

    public static final int T7(byte[] byArray, l l10) {
        f0.p(byArray, "$this$count");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Constable constable = Byte.valueOf(byArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            ++n11;
        }
        return n11;
    }

    public static final List T8(boolean[] object, int n10) {
        f0.p(object, "$this$dropLast");
        boolean bl2 = n10 >= 0;
        if (bl2) {
            n10 = f.l2.q.n(((boolean[])object).length - n10, 0);
            return ArraysKt___ArraysKt.ox((boolean[])object, n10);
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List T9(Object[] objectArray, p p10) {
        f0.p(objectArray, "$this$filterIndexed");
        f0.p(p10, "predicate");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n10 = objectArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, object))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                arrayList.add(object);
            }
            n11 = n12;
        }
        return arrayList;
    }

    private static final Boolean Ta(boolean[] object, l l10) {
        block1: {
            int n10 = ((boolean[])object).length;
            while ((n10 += -1) >= 0) {
                boolean bl2 = object[n10];
                Boolean bl3 = bl2;
                boolean bl4 = bl3 = (Boolean)l10.invoke(bl3);
                if (!bl4) continue;
                object = bl2;
                break block1;
            }
            object = null;
        }
        return object;
    }

    public static final List Tb(short[] sArray, l l10) {
        f0.p(sArray, "$this$flatMap");
        f0.p(l10, "transform");
        ArrayList arrayList = new ArrayList();
        for (short s10 : sArray) {
            Object object = s10;
            object = (Iterable)l10.invoke(object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object Tc(char[] cArray, Object object, p p10) {
        f0.p(cArray, "$this$foldRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Md(cArray);
        while (n10 >= 0) {
            int n11 = n10 + -1;
            object2 = Character.valueOf(cArray[n10]);
            object = p10.invoke(object2, object);
            n10 = n11;
        }
        return object;
    }

    public static final int Td(boolean[] blArray) {
        f0.p(blArray, "$this$lastIndex");
        return blArray.length + -1;
    }

    public static final Map Te(short[] sArray, Map map, l l10, l l11) {
        f0.p(sArray, "$this$groupByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (short s10 : sArray) {
            Object object = s10;
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = s10;
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return map;
    }

    private static final boolean Tf(float[] fArray) {
        int n10 = fArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            fArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final long Tg(long[] object) {
        String string2 = "$this$last";
        f0.p(object, string2);
        int n10 = ((long[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ArraysKt___ArraysKt.Qd(object);
            return object[n10];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final List Th(boolean[] blArray, p p10) {
        f0.p(blArray, "$this$mapIndexed");
        f0.p(p10, "transform");
        int n10 = blArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        n10 = blArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = bl2;
            object = p10.invoke(n12, object);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final double Ti(char[] object, l l10) {
        Serializable serializable;
        int n10 = ((char[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            serializable = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            serializable = Character.valueOf((char)n10);
            serializable = (Number)l10.invoke(serializable);
            double d10 = ((Number)serializable).doubleValue();
            int n12 = ArraysKt___ArraysKt.Md(object);
            if (n11 <= n12) {
                while (true) {
                    char c10 = object[n11];
                    Serializable serializable2 = Character.valueOf(c10);
                    serializable2 = (Number)l10.invoke(serializable2);
                    double d11 = ((Number)serializable2).doubleValue();
                    d10 = Math.max(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Float Tj(boolean[] blArray, l l10) {
        Serializable serializable;
        float f10;
        int n10 = blArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            serializable = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = blArray[0];
        serializable = Boolean.valueOf(n10 != 0);
        serializable = (Number)l10.invoke(serializable);
        f10 = ((Number)serializable).floatValue();
        n11 = ArraysKt___ArraysKt.Td(blArray);
        if (n12 <= n11) {
            while (true) {
                boolean bl2 = blArray[n12];
                Serializable serializable2 = Boolean.valueOf(bl2);
                serializable2 = (Number)l10.invoke(serializable2);
                float f12 = ((Number)serializable2).floatValue();
                f10 = Math.max(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final Float Tk(float[] fArray) {
        f0.p(fArray, "$this$min");
        return ArraysKt___ArraysKt.Pm(fArray);
    }

    private static final Comparable Tl(double[] dArray, l l10) {
        Comparable<Double> comparable;
        int n10 = dArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 != 0) {
            return null;
        }
        double d10 = dArray[0];
        comparable = d10;
        comparable = (Comparable)l10.invoke(comparable);
        n11 = ArraysKt___ArraysKt.Nd(dArray);
        if (n12 <= n11) {
            while (true) {
                double d11 = dArray[n12];
                Comparable<Double> comparable2 = d11;
                int n13 = comparable.compareTo((Double)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 > 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Short Tm(short[] sArray) {
        String string2 = "$this$minOrNull";
        f0.p(sArray, string2);
        int n10 = sArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray[0];
        n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n12 <= n11) {
            while (true) {
                int n13;
                if (n10 > (n13 = sArray[n12])) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return (short)n10;
    }

    private static final Object[] Tn(Object[] objectArray, p p10) {
        int n10 = objectArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            Integer n12 = n11;
            ++n11;
            p10.invoke(n12, object);
        }
        return objectArray;
    }

    public static final int To(int[] object, p p10) {
        f0.p(object, "$this$reduce");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ((int[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Pd(object);
            if (n12 <= n11) {
                while (true) {
                    object2 = n10;
                    int n13 = object[n12];
                    Integer n14 = n13;
                    object2 = (Number)p10.invoke(object2, n14);
                    n10 = ((Number)object2).intValue();
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final Character Tp(char[] cArray, q q10) {
        char c10;
        f0.p(cArray, "$this$reduceRightIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int c102 = ArraysKt___ArraysKt.Md(cArray);
        if (c102 < 0) {
            return null;
        }
        char c11 = cArray[c102];
        for (int i10 = c102 + -1; i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            char c12 = cArray[i10];
            Character c13 = Character.valueOf(c12);
            object = Character.valueOf(c10);
            object = (Character)q10.invoke(n10, c13, object);
            c10 = ((Character)object).charValue();
        }
        return Character.valueOf(c10);
    }

    public static final boolean[] Tq(boolean[] blArray) {
        Object object = "$this$reversedArray";
        f0.p(blArray, (String)object);
        int n10 = blArray.length;
        int n11 = 0;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return blArray;
        }
        n10 = blArray.length;
        object = new boolean[n10];
        int n12 = ArraysKt___ArraysKt.Td(blArray);
        if (n12 >= 0) {
            while (true) {
                int n13 = n12 - n11;
                boolean bl2 = blArray[n11];
                object[n13] = bl2;
                if (n11 == n12) break;
                ++n11;
            }
        }
        return object;
    }

    public static final List Tr(Object[] object, Object object2, q q10) {
        f0.p(object, "$this$scanIndexed");
        ArrayList<Object> arrayList = "operation";
        f0.p(q10, (String)((Object)arrayList));
        int n10 = ((Object[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            int n13 = ((Object[])object).length + n12;
            arrayList = new ArrayList<Object>(n13);
            arrayList.add(object2);
            n12 = ((Object[])object).length;
            while (n11 < n12) {
                Integer n14 = n11;
                Object object3 = object[n11];
                object2 = q10.invoke(n14, object2, object3);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Object Ts(Object[] object, l l10) {
        f0.p(object, "$this$single");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((Object[])object).length;
        Object object2 = null;
        boolean bl2 = false;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object3 = object[i10];
            Boolean bl3 = (Boolean)l10.invoke(object3);
            boolean bl4 = bl3;
            if (!bl4) continue;
            if (!bl2) {
                bl2 = true;
                object2 = object3;
                continue;
            }
            object = new IllegalArgumentException("Array contains more than one matching element.");
            throw object;
        }
        if (bl2) {
            return object2;
        }
        object = new NoSuchElementException("Array contains no element matching the predicate.");
        throw object;
    }

    public static final long[] Tt(long[] lArray, k k10) {
        f0.p(lArray, "$this$sliceArray");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return new long[0];
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.L1(lArray, n10, n11);
    }

    public static final List Tu(double[] dArray, l l10) {
        f0.p(dArray, "$this$sortedBy");
        f0.p(l10, "selector");
        b$b b$b = new b$b(l10);
        return ArraysKt___ArraysKt.tv(dArray, b$b);
    }

    public static final int Tv(int[] nArray, l l10) {
        f0.p(nArray, "$this$sumBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Number number = nArray[i10];
            number = (Number)l10.invoke(number);
            int n12 = number.intValue();
            n11 += n12;
        }
        return n11;
    }

    private static final int Tw(long[] lArray, l l10) {
        int n10 = f.c1.h(0);
        for (long l11 : lArray) {
            Comparable<Long> comparable = l11;
            comparable = (f.c1)l10.invoke(comparable);
            int n11 = ((f.c1)comparable).a0();
            n10 = f.c1.h(n10 + n11);
        }
        return n10;
    }

    public static final Collection Tx(byte[] byArray, Collection collection) {
        f0.p(byArray, "$this$toCollection");
        String string2 = "destination";
        f0.p(collection, string2);
        for (byte by2 : byArray) {
            Byte by3 = by2;
            collection.add(by3);
        }
        return collection;
    }

    public static final Set Ty(float[] object) {
        LinkedHashSet linkedHashSet = "$this$toSet";
        f0.p(object, (String)((Object)linkedHashSet));
        int n10 = ((float[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = s0.j(((float[])object).length);
                linkedHashSet = new LinkedHashSet(n11);
                object = (Set)ArraysKt___ArraysKt.Wx(object, linkedHashSet);
            } else {
                n10 = 0;
                linkedHashSet = null;
                float f10 = object[0];
                object = c1.f(Float.valueOf(f10));
            }
        } else {
            object = d1.k();
        }
        return object;
    }

    public static final List Tz(int[] nArray, int[] nArray2, p p10) {
        f0.p(nArray, "$this$zip");
        f0.p(nArray2, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = nArray.length;
        int n11 = nArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Object object = n12;
            int n13 = nArray2[i10];
            Integer n14 = n13;
            object = p10.invoke(object, n14);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Iterable U4(double[] dArray) {
        Object object = "$this$asIterable";
        f0.p(dArray, (String)object);
        int n10 = dArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = new ArraysKt___ArraysKt$g(dArray);
        return object;
    }

    public static final Map U5(int[] nArray, Map map, l l10, l l11) {
        f0.p(nArray, "$this$associateByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (int n10 : nArray) {
            Object object = n10;
            object = l10.invoke(object);
            Object object2 = n10;
            object2 = l11.invoke(object2);
            map.put(object, object2);
        }
        return map;
    }

    private static final int U6(int[] nArray) {
        f0.p(nArray, "$this$component1");
        return nArray[0];
    }

    private static final int U7(char[] cArray) {
        return cArray.length;
    }

    public static final List U8(byte[] byArray, l l10) {
        f0.p(byArray, "$this$dropLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Ld(byArray); i10 >= 0; i10 += -1) {
            Constable constable = Byte.valueOf(byArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return ArraysKt___ArraysKt.gx(byArray, ++i10);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    public static final List U9(short[] sArray, p p10) {
        f0.p(sArray, "$this$filterIndexed");
        f0.p(p10, "predicate");
        ArrayList<Constable> arrayList = new ArrayList<Constable>();
        int n10 = sArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Short s11 = s10;
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, s11))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                constable = Short.valueOf(s10);
                arrayList.add(constable);
            }
            n11 = n12;
        }
        return arrayList;
    }

    private static final Byte Ua(byte[] object, l l10) {
        block1: {
            int n10 = ((byte[])object).length;
            while ((n10 += -1) >= 0) {
                byte by2 = object[n10];
                Constable constable = Byte.valueOf(by2);
                boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
                if (!bl2) continue;
                object = by2;
                break block1;
            }
            object = null;
        }
        return object;
    }

    public static final List Ub(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$flatMap");
        f0.p(l10, "transform");
        ArrayList arrayList = new ArrayList();
        for (boolean bl2 : blArray) {
            Object object = bl2;
            object = (Iterable)l10.invoke(object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object Uc(double[] dArray, Object object, p p10) {
        f0.p(dArray, "$this$foldRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Nd(dArray);
        while (n10 >= 0) {
            int n11 = n10 + -1;
            double d10 = dArray[n10];
            object2 = d10;
            object = p10.invoke(object2, object);
            n10 = n11;
        }
        return object;
    }

    private static final byte Ud(byte[] object, int n10, l l10) {
        byte by2;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Ld((byte[])object))) {
            by2 = object[n10];
        } else {
            object = n10;
            object = (Number)l10.invoke(object);
            by2 = ((Number)object).byteValue();
        }
        return by2;
    }

    public static final Map Ue(boolean[] blArray, Map map, l l10) {
        f0.p(blArray, "$this$groupByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (boolean bl2 : blArray) {
            Object object = bl2;
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Boolean bl3 = bl2;
            object2.add((Boolean)bl3);
        }
        return map;
    }

    private static final boolean Uf(int[] nArray) {
        int n10 = nArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            nArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final long Ug(long[] object, l l10) {
        f0.p(object, "$this$last");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((long[])object).length;
        while ((n10 += -1) >= 0) {
            long l11 = object[n10];
            Constable constable = Long.valueOf(l11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return l11;
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final List Uh(Object[] objectArray, p p10) {
        f0.p(objectArray, "$this$mapIndexedNotNull");
        f0.p(p10, "transform");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n10 = objectArray.length;
        int n11 = 0;
        Object object = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = objectArray[i10];
            int n12 = n11 + 1;
            object = n11;
            if ((object = p10.invoke(object, object2)) != null) {
                arrayList.add(object);
            }
            n11 = n12;
        }
        return arrayList;
    }

    private static final double Ui(double[] object, l l10) {
        Number number;
        int n10 = ((double[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 == 0) {
            number = object[0];
            number = (Number)l10.invoke(number);
            double d10 = number.doubleValue();
            int n12 = ArraysKt___ArraysKt.Nd(object);
            if (n11 <= n12) {
                while (true) {
                    Number number2 = object[n11];
                    number2 = (Number)l10.invoke(number2);
                    double d11 = number2.doubleValue();
                    d10 = Math.max(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object Uj(byte[] object, Comparator comparator, l l10) {
        Object object2;
        int n10 = ((byte[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            object2 = (byte)n10;
            object2 = l10.invoke(object2);
            n11 = ArraysKt___ArraysKt.Ld(object);
            if (n12 <= n11) {
                while (true) {
                    byte by2 = object[n12];
                    Object object3 = by2;
                    int n13 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n13 < 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Float Uk(Float[] floatArray) {
        f0.p(floatArray, "$this$min");
        return ArraysKt___ArraysKt.Qm(floatArray);
    }

    private static final Comparable Ul(float[] fArray, l l10) {
        Comparable<Float> comparable;
        float f10;
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            comparable = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        f10 = fArray[0];
        comparable = Float.valueOf(f10);
        comparable = (Comparable)l10.invoke(comparable);
        n11 = ArraysKt___ArraysKt.Od(fArray);
        if (n12 <= n11) {
            while (true) {
                float f12 = fArray[n12];
                Comparable<Float> comparable2 = Float.valueOf(f12);
                int n13 = comparable.compareTo((Float)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 > 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Boolean Um(boolean[] blArray, Comparator comparator) {
        f0.p(blArray, "$this$minWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.dn(blArray, comparator);
    }

    private static final short[] Un(short[] sArray, p p10) {
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Integer n12 = n11;
            ++n11;
            Short s11 = s10;
            p10.invoke(n12, s11);
        }
        return sArray;
    }

    public static final long Uo(long[] object, p p10) {
        f0.p(object, "$this$reduce");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ((long[])object).length;
        Long l10 = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            long l11 = object[0];
            int n12 = ArraysKt___ArraysKt.Qd(object);
            if (n11 <= n12) {
                while (true) {
                    object2 = l11;
                    long l12 = object[n11];
                    l10 = l12;
                    object2 = (Number)p10.invoke(object2, l10);
                    l11 = ((Number)object2).longValue();
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return l11;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final Double Up(double[] dArray, q q10) {
        f0.p(dArray, "$this$reduceRightIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = ArraysKt___ArraysKt.Nd(dArray);
        if (n10 < 0) {
            return null;
        }
        double d10 = dArray[n10];
        for (int i10 = n10 + -1; i10 >= 0; i10 += -1) {
            object = i10;
            double d11 = dArray[i10];
            Double d12 = d11;
            Double d13 = d10;
            object = (Number)q10.invoke(object, d12, d13);
            d10 = ((Number)object).doubleValue();
        }
        return d10;
    }

    private static final List Uq(byte[] byArray, Object object, p p10) {
        ArrayList<Object> arrayList;
        int n10 = byArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        byte by2 = byArray.length + n12;
        arrayList = new ArrayList<Object>(by2);
        arrayList.add(object);
        n12 = byArray.length;
        while (n11 < n12) {
            by2 = byArray[n11];
            Byte by3 = by2;
            object = p10.invoke(object, by3);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    private static final List Ur(short[] object, Object object2, q q10) {
        ArrayList<Object> arrayList;
        int n10 = ((short[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            int n13 = ((short[])object).length + n12;
            arrayList = new ArrayList<Object>(n13);
            arrayList.add(object2);
            n12 = ((short[])object).length;
            while (n11 < n12) {
                Integer n14 = n11;
                short s10 = object[n11];
                Short s11 = s10;
                object2 = q10.invoke(n14, object2, s11);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final short Us(short[] object) {
        String string2 = "$this$single";
        f0.p(object, string2);
        int n10 = ((short[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                return object[0];
            }
            object = new IllegalArgumentException;
            object("Array has more than one element.");
            throw object;
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final Object[] Ut(Object[] objectArray, Collection object) {
        int n10;
        f0.p(objectArray, "$this$sliceArray");
        f0.p(object, "indices");
        int n11 = object.size();
        Object[] objectArray2 = f.x1.l.a(objectArray, n11);
        object = object.iterator();
        int n12 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Object object2;
            n10 = ((Number)object.next()).intValue();
            int n13 = n12 + 1;
            objectArray2[n12] = object2 = objectArray[n10];
            n12 = n13;
        }
        return objectArray2;
    }

    public static final List Uu(float[] fArray, l l10) {
        f0.p(fArray, "$this$sortedBy");
        f0.p(l10, "selector");
        b$b b$b = new b$b(l10);
        return ArraysKt___ArraysKt.uv(fArray, b$b);
    }

    public static final int Uv(long[] lArray, l l10) {
        f0.p(lArray, "$this$sumBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = lArray[i10];
            Number number = l11;
            number = (Number)l10.invoke(number);
            int n12 = number.intValue();
            n11 += n12;
        }
        return n11;
    }

    private static final int Uw(Object[] objectArray, l l10) {
        int n10 = f.c1.h(0);
        for (Object object : objectArray) {
            object = (f.c1)l10.invoke(object);
            int n11 = ((f.c1)object).a0();
            n10 = f.c1.h(n10 + n11);
        }
        return n10;
    }

    public static final Collection Ux(char[] cArray, Collection collection) {
        f0.p(cArray, "$this$toCollection");
        String string2 = "destination";
        f0.p(collection, string2);
        for (char c10 : cArray) {
            Character c11 = Character.valueOf(c10);
            collection.add(c11);
        }
        return collection;
    }

    public static final Set Uy(int[] object) {
        LinkedHashSet linkedHashSet = "$this$toSet";
        f0.p(object, (String)((Object)linkedHashSet));
        int n10 = ((int[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = s0.j(((int[])object).length);
                linkedHashSet = new LinkedHashSet(n11);
                object = (Set)ArraysKt___ArraysKt.Xx(object, linkedHashSet);
            } else {
                n10 = 0;
                linkedHashSet = null;
                int n12 = object[0];
                object = c1.f(n12);
            }
        } else {
            object = d1.k();
        }
        return object;
    }

    public static final List Uz(int[] nArray, Object[] objectArray) {
        f0.p(nArray, "$this$zip");
        String string2 = "other";
        f0.p(objectArray, string2);
        int n10 = nArray.length;
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Object object = objectArray[i10];
            Pair pair = w0.a(n12, object);
            arrayList.add(pair);
        }
        return arrayList;
    }

    public static final Iterable V4(float[] fArray) {
        Object object = "$this$asIterable";
        f0.p(fArray, (String)object);
        int n10 = fArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = new ArraysKt___ArraysKt$f(fArray);
        return object;
    }

    public static final Map V5(long[] lArray, Map map, l l10) {
        f0.p(lArray, "$this$associateByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (long l11 : lArray) {
            Object object = l11;
            object = l10.invoke(object);
            Long l12 = l11;
            map.put(object, l12);
        }
        return map;
    }

    private static final long V6(long[] lArray) {
        f0.p(lArray, "$this$component1");
        return lArray[0];
    }

    public static final int V7(char[] cArray, l l10) {
        f0.p(cArray, "$this$count");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = cArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable<Character> comparable = Character.valueOf(cArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            ++n11;
        }
        return n11;
    }

    public static final List V8(char[] cArray, l l10) {
        f0.p(cArray, "$this$dropLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Md(cArray); i10 >= 0; i10 += -1) {
            Comparable<Character> comparable = Character.valueOf(cArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return ArraysKt___ArraysKt.hx(cArray, ++i10);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    public static final List V9(boolean[] blArray, p p10) {
        f0.p(blArray, "$this$filterIndexed");
        f0.p(p10, "predicate");
        ArrayList<Constable> arrayList = new ArrayList<Constable>();
        int n10 = blArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Boolean bl3 = bl2;
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, bl3))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                constable = Boolean.valueOf(bl2);
                arrayList.add(constable);
            }
            n11 = n12;
        }
        return arrayList;
    }

    private static final Character Va(char[] object, l l10) {
        block1: {
            int n10 = ((char[])object).length;
            while ((n10 += -1) >= 0) {
                char c10 = object[n10];
                Comparable<Character> comparable = Character.valueOf(c10);
                boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
                if (!bl2) continue;
                object = Character.valueOf(c10);
                break block1;
            }
            object = null;
        }
        return object;
    }

    private static final List Vb(byte[] byArray, p p10) {
        ArrayList arrayList = new ArrayList();
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = by2;
            object = (Iterable)p10.invoke(n12, object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object Vc(float[] fArray, Object object, p p10) {
        f0.p(fArray, "$this$foldRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Od(fArray);
        while (n10 >= 0) {
            int n11 = n10 + -1;
            float f10 = fArray[n10];
            object2 = Float.valueOf(f10);
            object = p10.invoke(object2, object);
            n10 = n11;
        }
        return object;
    }

    private static final char Vd(char[] object, int n10, l l10) {
        char c10;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Md((char[])object))) {
            c10 = object[n10];
        } else {
            object = n10;
            object = (Character)l10.invoke(object);
            c10 = ((Character)object).charValue();
        }
        return c10;
    }

    public static final Map Ve(boolean[] blArray, Map map, l l10, l l11) {
        f0.p(blArray, "$this$groupByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (boolean bl2 : blArray) {
            Object object = bl2;
            Object object2 = map.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                map.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = bl2;
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return map;
    }

    private static final boolean Vf(long[] lArray) {
        int n10 = lArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            lArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final Object Vg(Object[] object) {
        String string2 = "$this$last";
        f0.p(object, string2);
        int n10 = ((Object[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ArraysKt___ArraysKt.Rd(object);
            return object[n10];
        }
        object = new NoSuchElementException("Array is empty.");
        throw object;
    }

    public static final Collection Vh(Object[] objectArray, Collection collection, p p10) {
        f0.p(objectArray, "$this$mapIndexedNotNullTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = objectArray.length;
        int n11 = 0;
        Object object = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = objectArray[i10];
            int n12 = n11 + 1;
            object = n11;
            if ((object = p10.invoke(object, object2)) != null) {
                collection.add(object);
            }
            n11 = n12;
        }
        return collection;
    }

    private static final double Vi(float[] object, l l10) {
        Number number;
        float f10;
        int n10 = ((float[])object).length;
        int n11 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n11;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            f10 = object[0];
            number = Float.valueOf(f10);
            number = (Number)l10.invoke(number);
            double d10 = number.doubleValue();
            int n12 = ArraysKt___ArraysKt.Od(object);
            if (n11 <= n12) {
                while (true) {
                    float f12 = object[n11];
                    Number number2 = Float.valueOf(f12);
                    number2 = (Number)l10.invoke(number2);
                    double d11 = number2.doubleValue();
                    d10 = Math.max(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object Vj(char[] object, Comparator comparator, l l10) {
        Object object2;
        int n10 = ((char[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            object2 = Character.valueOf((char)n10);
            object2 = l10.invoke(object2);
            n11 = ArraysKt___ArraysKt.Md(object);
            if (n12 <= n11) {
                while (true) {
                    char c10 = object[n12];
                    Object object3 = Character.valueOf(c10);
                    int n13 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n13 < 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Integer Vk(int[] nArray) {
        f0.p(nArray, "$this$min");
        return ArraysKt___ArraysKt.Rm(nArray);
    }

    private static final Comparable Vl(int[] nArray, l l10) {
        Comparable<Integer> comparable;
        int n10 = nArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray[0];
        comparable = n10;
        comparable = (Comparable)l10.invoke(comparable);
        n11 = ArraysKt___ArraysKt.Pd(nArray);
        if (n12 <= n11) {
            while (true) {
                int n13 = nArray[n12];
                Comparable<Integer> comparable2 = n13;
                int n14 = comparable.compareTo((Integer)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n14 > 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Byte Vm(byte[] byArray, Comparator comparator) {
        f0.p(byArray, "$this$minWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.en(byArray, comparator);
    }

    private static final boolean[] Vn(boolean[] blArray, p p10) {
        int n10 = blArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            Integer n12 = n11;
            ++n11;
            Boolean bl3 = bl2;
            p10.invoke(n12, bl3);
        }
        return blArray;
    }

    public static final Object Vo(Object[] objectArray, p p10) {
        f0.p(objectArray, "$this$reduce");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 == 0) {
            object = objectArray[0];
            n11 = ArraysKt___ArraysKt.Rd(objectArray);
            if (n12 <= n11) {
                while (true) {
                    Object object2 = objectArray[n12];
                    object = p10.invoke(object, object2);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object;
        }
        objectArray = new UnsupportedOperationException("Empty array can't be reduced.");
        throw objectArray;
    }

    public static final Float Vp(float[] fArray, q q10) {
        f0.p(fArray, "$this$reduceRightIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = ArraysKt___ArraysKt.Od(fArray);
        if (n10 < 0) {
            return null;
        }
        float f10 = fArray[n10];
        for (int i10 = n10 + -1; i10 >= 0; i10 += -1) {
            Integer n11 = i10;
            float f11 = fArray[i10];
            Float f12 = Float.valueOf(f11);
            object = Float.valueOf(f10);
            object = (Number)q10.invoke(n11, f12, object);
            f10 = ((Number)object).floatValue();
        }
        return Float.valueOf(f10);
    }

    private static final List Vq(char[] cArray, Object object, p p10) {
        ArrayList<Object> arrayList;
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        char c10 = cArray.length + n12;
        arrayList = new ArrayList<Object>(c10);
        arrayList.add(object);
        n12 = cArray.length;
        while (n11 < n12) {
            c10 = cArray[n11];
            Character c11 = Character.valueOf(c10);
            object = p10.invoke(object, c11);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    private static final List Vr(boolean[] object, Object object2, q q10) {
        ArrayList<Object> arrayList;
        int n10 = ((boolean[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            object = t.k(object2);
        } else {
            int n13 = ((boolean[])object).length + n12;
            arrayList = new ArrayList<Object>(n13);
            arrayList.add(object2);
            n12 = ((boolean[])object).length;
            while (n11 < n12) {
                Integer n14 = n11;
                boolean bl2 = object[n11];
                Boolean bl3 = bl2;
                object2 = q10.invoke(n14, object2, bl3);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final short Vs(short[] object, l l10) {
        f0.p(object, "$this$single");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((short[])object).length;
        boolean bl2 = false;
        Short s10 = null;
        boolean bl3 = false;
        Short s11 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s12 = object[i10];
            Constable constable = Short.valueOf(s12);
            boolean bl4 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl4) continue;
            if (!bl3) {
                s11 = s12;
                bl2 = true;
                s10 = s11;
                bl3 = bl2;
                continue;
            }
            object = new IllegalArgumentException;
            object("Array contains more than one matching element.");
            throw object;
        }
        if (bl3) {
            Objects.requireNonNull(s10, "null cannot be cast to non-null type kotlin.Short");
            return s10;
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final Object[] Vt(Object[] objectArray, k k10) {
        f0.p(objectArray, "$this$sliceArray");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return f.x1.n.M1(objectArray, 0, 0);
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.M1(objectArray, n10, n11);
    }

    public static final List Vu(int[] nArray, l l10) {
        f0.p(nArray, "$this$sortedBy");
        f0.p(l10, "selector");
        b$b b$b = new b$b(l10);
        return ArraysKt___ArraysKt.vv(nArray, b$b);
    }

    public static final int Vv(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$sumBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = objectArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            object = (Number)l10.invoke(object);
            int n12 = ((Number)object).intValue();
            n11 += n12;
        }
        return n11;
    }

    private static final int Vw(short[] sArray, l l10) {
        int n10 = f.c1.h(0);
        int n11 = sArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            Comparable<Short> comparable = sArray[i10];
            comparable = (f.c1)l10.invoke(comparable);
            int n12 = ((f.c1)comparable).a0();
            n10 = f.c1.h(n10 + n12);
        }
        return n10;
    }

    public static final Collection Vx(double[] dArray, Collection collection) {
        f0.p(dArray, "$this$toCollection");
        String string2 = "destination";
        f0.p(collection, string2);
        for (double d10 : dArray) {
            Double d11 = d10;
            collection.add(d11);
        }
        return collection;
    }

    public static final Set Vy(long[] object) {
        LinkedHashSet linkedHashSet = "$this$toSet";
        f0.p(object, (String)((Object)linkedHashSet));
        int n10 = ((long[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = s0.j(((long[])object).length);
                linkedHashSet = new LinkedHashSet(n11);
                object = (Set)ArraysKt___ArraysKt.Yx(object, linkedHashSet);
            } else {
                n10 = 0;
                linkedHashSet = null;
                long l10 = object[0];
                object = c1.f(l10);
            }
        } else {
            object = d1.k();
        }
        return object;
    }

    public static final List Vz(int[] nArray, Object[] objectArray, p p10) {
        f0.p(nArray, "$this$zip");
        f0.p(objectArray, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = nArray.length;
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Object object = n12;
            Object object2 = objectArray[i10];
            object = p10.invoke(object, object2);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Iterable W4(int[] nArray) {
        Object object = "$this$asIterable";
        f0.p(nArray, (String)object);
        int n10 = nArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = new ArraysKt___ArraysKt$d(nArray);
        return object;
    }

    public static final Map W5(long[] lArray, Map map, l l10, l l11) {
        f0.p(lArray, "$this$associateByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (long l12 : lArray) {
            Object object = l12;
            object = l10.invoke(object);
            Object object2 = l12;
            object2 = l11.invoke(object2);
            map.put(object, object2);
        }
        return map;
    }

    private static final Object W6(Object[] objectArray) {
        f0.p(objectArray, "$this$component1");
        return objectArray[0];
    }

    private static final int W7(double[] dArray) {
        return dArray.length;
    }

    public static final List W8(double[] dArray, l l10) {
        f0.p(dArray, "$this$dropLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Nd(dArray); i10 >= 0; i10 += -1) {
            double d10 = dArray[i10];
            Constable constable = Double.valueOf(d10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return ArraysKt___ArraysKt.ix(dArray, ++i10);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    public static final Collection W9(byte[] byArray, Collection collection, p p10) {
        f0.p(byArray, "$this$filterIndexedTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(p10, string2);
        int n10 = byArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Byte by3 = by2;
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, by3))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                constable = Byte.valueOf(by2);
                collection.add(constable);
            }
            n11 = n12;
        }
        return collection;
    }

    private static final Double Wa(double[] object, l l10) {
        block1: {
            int n10 = ((double[])object).length;
            while ((n10 += -1) >= 0) {
                double d10 = object[n10];
                Constable constable = Double.valueOf(d10);
                boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
                if (!bl2) continue;
                object = d10;
                break block1;
            }
            object = null;
        }
        return object;
    }

    private static final List Wb(char[] cArray, p p10) {
        ArrayList arrayList = new ArrayList();
        int n10 = cArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = cArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = Character.valueOf(c10);
            object = (Iterable)p10.invoke(n12, object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object Wc(int[] nArray, Object object, p p10) {
        f0.p(nArray, "$this$foldRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Pd(nArray);
        while (n10 >= 0) {
            int n11 = n10 + -1;
            object2 = nArray[n10];
            object = p10.invoke(object2, object);
            n10 = n11;
        }
        return object;
    }

    private static final double Wd(double[] object, int n10, l l10) {
        double d10;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Nd((double[])object))) {
            d10 = object[n10];
        } else {
            object = n10;
            object = (Number)l10.invoke(object);
            d10 = ((Number)object).doubleValue();
        }
        return d10;
    }

    public static final e0 We(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$groupingBy");
        f0.p(l10, "keySelector");
        ArraysKt___ArraysKt$s arraysKt___ArraysKt$s = new ArraysKt___ArraysKt$s(objectArray, l10);
        return arraysKt___ArraysKt$s;
    }

    private static final boolean Wf(Object[] objectArray) {
        int n10 = objectArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            objectArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final Object Wg(Object[] object, l l10) {
        f0.p(object, "$this$last");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((Object[])object).length;
        while ((n10 += -1) >= 0) {
            Object object2 = object[n10];
            Boolean bl2 = (Boolean)l10.invoke(object2);
            boolean bl3 = bl2;
            if (!bl3) continue;
            return object2;
        }
        object = new NoSuchElementException("Array contains no element matching the predicate.");
        throw object;
    }

    public static final Collection Wh(byte[] byArray, Collection collection, p p10) {
        f0.p(byArray, "$this$mapIndexedTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = by2;
            object = p10.invoke(n12, object);
            collection.add(object);
        }
        return collection;
    }

    private static final double Wi(int[] object, l l10) {
        Number number;
        int n10 = ((int[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            number = n10;
            number = (Number)l10.invoke(number);
            double d10 = number.doubleValue();
            int n12 = ArraysKt___ArraysKt.Pd(object);
            if (n11 <= n12) {
                while (true) {
                    int n13 = object[n11];
                    Number number2 = n13;
                    number2 = (Number)l10.invoke(number2);
                    double d11 = number2.doubleValue();
                    d10 = Math.max(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object Wj(double[] object, Comparator comparator, l l10) {
        Object object2;
        int n10 = ((double[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            double d10 = object[0];
            object2 = d10;
            object2 = l10.invoke(object2);
            n11 = ArraysKt___ArraysKt.Nd(object);
            if (n12 <= n11) {
                while (true) {
                    double d11 = object[n12];
                    Object object3 = d11;
                    int n13 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n13 < 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Long Wk(long[] lArray) {
        f0.p(lArray, "$this$min");
        return ArraysKt___ArraysKt.Sm(lArray);
    }

    private static final Comparable Wl(long[] lArray, l l10) {
        Comparable<Long> comparable;
        int n10 = lArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 != 0) {
            return null;
        }
        long l11 = lArray[0];
        comparable = l11;
        comparable = (Comparable)l10.invoke(comparable);
        n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n12 <= n11) {
            while (true) {
                long l12 = lArray[n12];
                Comparable<Long> comparable2 = l12;
                int n13 = comparable.compareTo((Long)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 > 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Character Wm(char[] cArray, Comparator comparator) {
        f0.p(cArray, "$this$minWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.fn(cArray, comparator);
    }

    /*
     * WARNING - void declaration
     */
    public static final Pair Wn(byte[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$partition");
        f0.p(var1_2, "predicate");
        ArrayList<Byte> arrayList = new ArrayList<Byte>();
        ArrayList<Byte> arrayList2 = new ArrayList<Byte>();
        for (Object object2 : object) {
            Byte by2;
            Constable constable = Byte.valueOf((byte)object2);
            boolean bl2 = (Boolean)(constable = (Boolean)var1_2.invoke(constable));
            if (bl2) {
                by2 = (byte)object2;
                arrayList.add(by2);
                continue;
            }
            by2 = (byte)object2;
            arrayList2.add(by2);
        }
        Pair pair = new Pair(arrayList, arrayList2);
        return pair;
    }

    public static final short Wo(short[] object, p p10) {
        f0.p(object, "$this$reduce");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ((short[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Sd(object);
            if (n12 <= n11) {
                while (true) {
                    object2 = (short)n10;
                    short s10 = object[n12];
                    Short s11 = s10;
                    object2 = (Number)p10.invoke(object2, s11);
                    n10 = ((Number)object2).shortValue();
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return (short)n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final Integer Wp(int[] nArray, q q10) {
        f0.p(nArray, "$this$reduceRightIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = ArraysKt___ArraysKt.Pd(nArray);
        if (n10 < 0) {
            return null;
        }
        int n11 = n10 + -1;
        n10 = nArray[n10];
        while (n11 >= 0) {
            Integer n12 = n11;
            int n13 = nArray[n11];
            Integer n14 = n13;
            object = n10;
            object = (Number)q10.invoke(n12, n14, object);
            n10 = ((Number)object).intValue();
            n11 += -1;
        }
        return n10;
    }

    private static final List Wq(double[] dArray, Object object, p p10) {
        ArrayList<Object> arrayList;
        int n10 = dArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int n13 = dArray.length + n12;
        arrayList = new ArrayList<Object>(n13);
        arrayList.add(object);
        n12 = dArray.length;
        while (n11 < n12) {
            double d10 = dArray[n11];
            Double d11 = d10;
            object = p10.invoke(object, d11);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    private static final List Wr(byte[] object, p p10) {
        Ref$ByteRef ref$ByteRef;
        int n10 = ((byte[])object).length;
        byte by2 = 0;
        ArrayList<Byte> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            ref$ByteRef = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            ref$ByteRef = new Ref$ByteRef();
            ref$ByteRef.element = by2 = object[0];
            int n12 = ((byte[])object).length;
            arrayList = new ArrayList<Byte>(n12);
            Byte by3 = ref$ByteRef.element;
            arrayList.add(by3);
            n12 = ((byte[])object).length;
            while (n11 < n12) {
                byte by4;
                Byte by5 = ref$ByteRef.element;
                byte by6 = object[n11];
                Byte by7 = by6;
                ref$ByteRef.element = by4 = ((Number)p10.invoke(by5, by7)).byteValue();
                by5 = by4;
                arrayList.add(by5);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final boolean Ws(boolean[] object) {
        String string2 = "$this$single";
        f0.p(object, string2);
        int n10 = ((boolean[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                return object[0];
            }
            object = new IllegalArgumentException;
            object("Array has more than one element.");
            throw object;
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final short[] Wt(short[] sArray, Collection object) {
        int n10;
        f0.p(sArray, "$this$sliceArray");
        f0.p(object, "indices");
        int n11 = object.size();
        short[] sArray2 = new short[n11];
        object = object.iterator();
        int n12 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Number number = (Number)object.next();
            n10 = number.intValue();
            int n13 = n12 + 1;
            sArray2[n12] = n10 = sArray[n10];
            n12 = n13;
        }
        return sArray2;
    }

    public static final List Wu(long[] lArray, l l10) {
        f0.p(lArray, "$this$sortedBy");
        f0.p(l10, "selector");
        b$b b$b = new b$b(l10);
        return ArraysKt___ArraysKt.wv(lArray, b$b);
    }

    public static final int Wv(short[] sArray, l l10) {
        f0.p(sArray, "$this$sumBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Number number = sArray[i10];
            number = (Number)l10.invoke(number);
            int n12 = number.intValue();
            n11 += n12;
        }
        return n11;
    }

    private static final int Ww(boolean[] blArray, l l10) {
        int n10 = f.c1.h(0);
        int n11 = blArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            Comparable<Boolean> comparable = blArray[i10];
            comparable = (f.c1)l10.invoke(comparable);
            int n12 = ((f.c1)comparable).a0();
            n10 = f.c1.h(n10 + n12);
        }
        return n10;
    }

    public static final Collection Wx(float[] fArray, Collection collection) {
        f0.p(fArray, "$this$toCollection");
        String string2 = "destination";
        f0.p(collection, string2);
        for (float f10 : fArray) {
            Float f11 = Float.valueOf(f10);
            collection.add(f11);
        }
        return collection;
    }

    public static final Set Wy(Object[] object) {
        LinkedHashSet linkedHashSet = "$this$toSet";
        f0.p(object, (String)((Object)linkedHashSet));
        int n10 = ((Object[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = s0.j(((Object[])object).length);
                linkedHashSet = new LinkedHashSet(n11);
                object = (Set)ArraysKt___ArraysKt.Zx(object, linkedHashSet);
            } else {
                n10 = 0;
                linkedHashSet = null;
                object = c1.f(object[0]);
            }
        } else {
            object = d1.k();
        }
        return object;
    }

    public static final List Wz(long[] lArray, Iterable object) {
        boolean bl2;
        f0.p(lArray, "$this$zip");
        String string2 = "other";
        f0.p(object, string2);
        int n10 = lArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n11);
        object = object.iterator();
        n11 = 0;
        Pair pair = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            long l10 = lArray[n11];
            pair = w0.a(l10, e10);
            arrayList.add(pair);
            n11 = n12;
        }
        return arrayList;
    }

    public static final Iterable X4(long[] lArray) {
        Object object = "$this$asIterable";
        f0.p(lArray, (String)object);
        int n10 = lArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = new ArraysKt___ArraysKt$e(lArray);
        return object;
    }

    public static final Map X5(Object[] objectArray, Map map, l l10) {
        f0.p(objectArray, "$this$associateByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (Object object : objectArray) {
            Object object2 = l10.invoke(object);
            map.put(object2, object);
        }
        return map;
    }

    private static final short X6(short[] sArray) {
        f0.p(sArray, "$this$component1");
        return sArray[0];
    }

    public static final int X7(double[] dArray, l l10) {
        f0.p(dArray, "$this$count");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = dArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            Constable constable = Double.valueOf(d10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            ++n11;
        }
        return n11;
    }

    public static final List X8(float[] fArray, l l10) {
        f0.p(fArray, "$this$dropLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Od(fArray); i10 >= 0; i10 += -1) {
            float f10 = fArray[i10];
            Constable constable = Float.valueOf(f10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return ArraysKt___ArraysKt.jx(fArray, ++i10);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    public static final Collection X9(char[] cArray, Collection collection, p p10) {
        f0.p(cArray, "$this$filterIndexedTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(p10, string2);
        int n10 = cArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = cArray[i10];
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Character c11 = Character.valueOf(c10);
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, c11))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                constable = Character.valueOf(c10);
                collection.add(constable);
            }
            n11 = n12;
        }
        return collection;
    }

    private static final Float Xa(float[] object, l l10) {
        block1: {
            int n10 = ((float[])object).length;
            while ((n10 += -1) >= 0) {
                float f10 = object[n10];
                Constable constable = Float.valueOf(f10);
                boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
                if (!bl2) continue;
                object = Float.valueOf(f10);
                break block1;
            }
            object = null;
        }
        return object;
    }

    private static final List Xb(double[] dArray, p p10) {
        ArrayList arrayList = new ArrayList();
        int n10 = dArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = d10;
            object = (Iterable)p10.invoke(n12, object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object Xc(long[] lArray, Object object, p p10) {
        f0.p(lArray, "$this$foldRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Qd(lArray);
        while (n10 >= 0) {
            int n11 = n10 + -1;
            long l10 = lArray[n10];
            object2 = l10;
            object = p10.invoke(object2, object);
            n10 = n11;
        }
        return object;
    }

    private static final float Xd(float[] object, int n10, l l10) {
        float f10;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Od((float[])object))) {
            f10 = object[n10];
        } else {
            object = n10;
            object = (Number)l10.invoke(object);
            f10 = ((Number)object).floatValue();
        }
        return f10;
    }

    public static final int Xe(byte[] byArray, byte by2) {
        String string2 = "$this$indexOf";
        f0.p(byArray, string2);
        int n10 = byArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by3 = byArray[i10];
            if (by2 != by3) continue;
            return i10;
        }
        return -1;
    }

    private static final boolean Xf(short[] sArray) {
        int n10 = sArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            sArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final short Xg(short[] object) {
        String string2 = "$this$last";
        f0.p(object, string2);
        int n10 = ((short[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ArraysKt___ArraysKt.Sd(object);
            return object[n10];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final Collection Xh(char[] cArray, Collection collection, p p10) {
        f0.p(cArray, "$this$mapIndexedTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = cArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = cArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = Character.valueOf(c10);
            object = p10.invoke(n12, object);
            collection.add(object);
        }
        return collection;
    }

    private static final double Xi(long[] object, l l10) {
        Number number;
        int n10 = ((long[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 == 0) {
            long l11 = object[0];
            number = l11;
            number = (Number)l10.invoke(number);
            double d10 = number.doubleValue();
            int n12 = ArraysKt___ArraysKt.Qd(object);
            if (n11 <= n12) {
                while (true) {
                    long l12 = object[n11];
                    Number number2 = l12;
                    number2 = (Number)l10.invoke(number2);
                    double d11 = number2.doubleValue();
                    d10 = Math.max(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object Xj(float[] object, Comparator comparator, l l10) {
        Object object2;
        float f10;
        int n10 = ((float[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            object2 = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            f10 = object[0];
            object2 = Float.valueOf(f10);
            object2 = l10.invoke(object2);
            n11 = ArraysKt___ArraysKt.Od(object);
            if (n12 <= n11) {
                while (true) {
                    float f12 = object[n12];
                    Object object3 = Float.valueOf(f12);
                    int n13 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n13 < 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Short Xk(short[] sArray) {
        f0.p(sArray, "$this$min");
        return ArraysKt___ArraysKt.Tm(sArray);
    }

    private static final Comparable Xl(Object[] objectArray, l l10) {
        Object object;
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        object = objectArray[0];
        object = (Comparable)l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n12 <= n11) {
            while (true) {
                Object object2 = objectArray[n12];
                int n13 = object.compareTo(object2 = (Comparable)l10.invoke(object2));
                if (n13 > 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final Double Xm(double[] dArray, Comparator comparator) {
        f0.p(dArray, "$this$minWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.gn(dArray, comparator);
    }

    /*
     * WARNING - void declaration
     */
    public static final Pair Xn(char[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$partition");
        f0.p(var1_2, "predicate");
        ArrayList<Character> arrayList = new ArrayList<Character>();
        ArrayList<Character> arrayList2 = new ArrayList<Character>();
        for (Object object2 : object) {
            Character c10;
            Comparable<Character> comparable = Character.valueOf((char)object2);
            boolean bl2 = (Boolean)(comparable = (Boolean)var1_2.invoke(comparable));
            if (bl2) {
                c10 = Character.valueOf((char)object2);
                arrayList.add(c10);
                continue;
            }
            c10 = Character.valueOf((char)object2);
            arrayList2.add(c10);
        }
        Pair pair = new Pair(arrayList, arrayList2);
        return pair;
    }

    public static final boolean Xo(boolean[] object, p p10) {
        f0.p(object, "$this$reduce");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ((boolean[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Td(object);
            if (n12 <= n11) {
                while (true) {
                    object2 = n10 != 0;
                    boolean bl2 = object[n12];
                    Boolean bl3 = bl2;
                    object2 = (Boolean)p10.invoke(object2, bl3);
                    n10 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return n10 != 0;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final Long Xp(long[] lArray, q q10) {
        f0.p(lArray, "$this$reduceRightIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 < 0) {
            return null;
        }
        long l10 = lArray[n10];
        for (int i10 = n10 + -1; i10 >= 0; i10 += -1) {
            object = i10;
            long l11 = lArray[i10];
            Long l12 = l11;
            Long l13 = l10;
            object = (Number)q10.invoke(object, l12, l13);
            l10 = ((Number)object).longValue();
        }
        return l10;
    }

    private static final List Xq(float[] fArray, Object object, p p10) {
        ArrayList<Object> arrayList;
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int n13 = fArray.length + n12;
        arrayList = new ArrayList<Object>(n13);
        arrayList.add(object);
        n12 = fArray.length;
        while (n11 < n12) {
            float f10 = fArray[n11];
            Float f11 = Float.valueOf(f10);
            object = p10.invoke(object, f11);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    private static final List Xr(char[] object, p p10) {
        Ref$CharRef ref$CharRef;
        int n10 = ((char[])object).length;
        char c10 = '\u0000';
        ArrayList<Character> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            ref$CharRef = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            ref$CharRef = new Ref$CharRef();
            ref$CharRef.element = c10 = object[0];
            int n12 = ((char[])object).length;
            arrayList = new ArrayList<Character>(n12);
            Character c11 = Character.valueOf(ref$CharRef.element);
            arrayList.add(c11);
            n12 = ((char[])object).length;
            while (n11 < n12) {
                char c12;
                Character c13 = Character.valueOf(ref$CharRef.element);
                char c14 = object[n11];
                Character c15 = Character.valueOf(c14);
                ref$CharRef.element = c12 = ((Character)p10.invoke(c13, c15)).charValue();
                c13 = Character.valueOf(c12);
                arrayList.add(c13);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final boolean Xs(boolean[] object, l l10) {
        f0.p(object, "$this$single");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((boolean[])object).length;
        boolean bl2 = false;
        Boolean bl3 = null;
        boolean bl4 = false;
        Boolean bl5 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl6 = object[i10];
            Boolean bl7 = bl6;
            boolean bl8 = bl7 = (Boolean)l10.invoke(bl7);
            if (!bl8) continue;
            if (!bl4) {
                bl5 = bl6;
                bl2 = true;
                bl3 = bl5;
                bl4 = bl2;
                continue;
            }
            object = new IllegalArgumentException;
            object("Array contains more than one matching element.");
            throw object;
        }
        if (bl4) {
            Objects.requireNonNull(bl3, "null cannot be cast to non-null type kotlin.Boolean");
            return bl3;
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final short[] Xt(short[] sArray, k k10) {
        f0.p(sArray, "$this$sliceArray");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return new short[0];
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.N1(sArray, n10, n11);
    }

    public static final List Xu(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$sortedBy");
        f0.p(l10, "selector");
        b$b b$b = new b$b(l10);
        return ArraysKt___ArraysKt.xv(objectArray, b$b);
    }

    public static final int Xv(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$sumBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = blArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Serializable serializable = Boolean.valueOf(blArray[i10]);
            serializable = (Number)l10.invoke(serializable);
            int n12 = ((Number)serializable).intValue();
            n11 += n12;
        }
        return n11;
    }

    private static final long Xw(byte[] byArray, l l10) {
        long l11 = g1.h(0);
        for (byte by2 : byArray) {
            Comparable<Byte> comparable = by2;
            comparable = (g1)l10.invoke(comparable);
            long l12 = ((g1)comparable).a0();
            l11 = g1.h(l11 + l12);
        }
        return l11;
    }

    public static final Collection Xx(int[] nArray, Collection collection) {
        f0.p(nArray, "$this$toCollection");
        String string2 = "destination";
        f0.p(collection, string2);
        for (int n10 : nArray) {
            Integer n11 = n10;
            collection.add(n11);
        }
        return collection;
    }

    public static final Set Xy(short[] object) {
        LinkedHashSet linkedHashSet = "$this$toSet";
        f0.p(object, (String)((Object)linkedHashSet));
        int n10 = ((short[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = s0.j(((short[])object).length);
                linkedHashSet = new LinkedHashSet(n11);
                object = (Set)ArraysKt___ArraysKt.ay(object, linkedHashSet);
            } else {
                n10 = 0;
                linkedHashSet = null;
                short s10 = object[0];
                object = c1.f(s10);
            }
        } else {
            object = d1.k();
        }
        return object;
    }

    public static final List Xz(long[] lArray, Iterable object, p p10) {
        boolean bl2;
        f0.p(lArray, "$this$zip");
        f0.p(object, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = lArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        n11 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            long l10 = lArray[n11];
            object2 = l10;
            object2 = p10.invoke(object2, e10);
            arrayList.add(object2);
            n11 = n12;
        }
        return arrayList;
    }

    public static final Iterable Y4(Object[] objectArray) {
        Object object = "$this$asIterable";
        f0.p(objectArray, (String)object);
        int n10 = objectArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = new ArraysKt___ArraysKt$a(objectArray);
        return object;
    }

    public static final Map Y5(Object[] objectArray, Map map, l l10, l l11) {
        f0.p(objectArray, "$this$associateByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (Object object : objectArray) {
            Object object2 = l10.invoke(object);
            object = l11.invoke(object);
            map.put(object2, object);
        }
        return map;
    }

    private static final boolean Y6(boolean[] blArray) {
        f0.p(blArray, "$this$component1");
        return blArray[0];
    }

    private static final int Y7(float[] fArray) {
        return fArray.length;
    }

    public static final List Y8(int[] nArray, l l10) {
        f0.p(nArray, "$this$dropLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Pd(nArray); i10 >= 0; i10 += -1) {
            Constable constable = Integer.valueOf(nArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return ArraysKt___ArraysKt.kx(nArray, ++i10);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    public static final Collection Y9(double[] dArray, Collection collection, p p10) {
        f0.p(dArray, "$this$filterIndexedTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(p10, string2);
        int n10 = dArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Double d11 = d10;
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, d11))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                constable = Double.valueOf(d10);
                collection.add(constable);
            }
            n11 = n12;
        }
        return collection;
    }

    private static final Integer Ya(int[] object, l l10) {
        block1: {
            int n10 = ((int[])object).length;
            while ((n10 += -1) >= 0) {
                int n11 = object[n10];
                Constable constable = Integer.valueOf(n11);
                boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
                if (!bl2) continue;
                object = n11;
                break block1;
            }
            object = null;
        }
        return object;
    }

    private static final List Yb(float[] fArray, p p10) {
        ArrayList arrayList = new ArrayList();
        int n10 = fArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = Float.valueOf(f10);
            object = (Iterable)p10.invoke(n12, object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object Yc(Object[] objectArray, Object object, p p10) {
        f0.p(objectArray, "$this$foldRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Rd(objectArray);
        while (n10 >= 0) {
            int n11 = n10 + -1;
            object2 = objectArray[n10];
            object = p10.invoke(object2, object);
            n10 = n11;
        }
        return object;
    }

    private static final int Yd(int[] object, int n10, l l10) {
        int n11;
        int n12;
        if (n10 >= 0 && n10 <= (n12 = ArraysKt___ArraysKt.Pd((int[])object))) {
            n11 = object[n10];
        } else {
            object = n10;
            object = (Number)l10.invoke(object);
            n11 = ((Number)object).intValue();
        }
        return n11;
    }

    public static final int Ye(char[] cArray, char c10) {
        String string2 = "$this$indexOf";
        f0.p(cArray, string2);
        int n10 = cArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c11 = cArray[i10];
            if (c10 != c11) continue;
            return i10;
        }
        return -1;
    }

    private static final boolean Yf(boolean[] blArray) {
        int n10 = blArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            blArray = null;
        }
        return (n10 ^ n11) != 0;
    }

    public static final short Yg(short[] object, l l10) {
        f0.p(object, "$this$last");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((short[])object).length;
        while ((n10 += -1) >= 0) {
            short s10 = object[n10];
            Constable constable = Short.valueOf(s10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return s10;
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final Collection Yh(double[] dArray, Collection collection, p p10) {
        f0.p(dArray, "$this$mapIndexedTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = dArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = d10;
            object = p10.invoke(n12, object);
            collection.add(object);
        }
        return collection;
    }

    private static final double Yi(Object[] objectArray, l l10) {
        Object object;
        int n10 = objectArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 == 0) {
            object = objectArray[0];
            object = (Number)l10.invoke(object);
            double d10 = ((Number)object).doubleValue();
            int n12 = ArraysKt___ArraysKt.Rd(objectArray);
            if (n11 <= n12) {
                while (true) {
                    Object object2 = objectArray[n11];
                    object2 = (Number)l10.invoke(object2);
                    double d11 = ((Number)object2).doubleValue();
                    d10 = Math.max(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        objectArray = new NoSuchElementException();
        throw objectArray;
    }

    private static final Object Yj(int[] object, Comparator comparator, l l10) {
        Object object2;
        int n10 = ((int[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            object2 = n10;
            object2 = l10.invoke(object2);
            n11 = ArraysKt___ArraysKt.Pd(object);
            if (n12 <= n11) {
                while (true) {
                    int n13 = object[n12];
                    Object object3 = n13;
                    int n14 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n14 < 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Boolean Yk(boolean[] object, l l10) {
        f0.p(object, "$this$minBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = ((boolean[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Td(object);
            if (n11 == 0) {
                object = n10 != 0;
            } else {
                Comparable<Boolean> comparable = n10 != 0;
                comparable = (Comparable)l10.invoke(comparable);
                if (n12 <= n11) {
                    while (true) {
                        int n13 = object[n12];
                        Comparable<Boolean> comparable2 = n13 != 0;
                        int n14 = comparable.compareTo((Boolean)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n14 > 0) {
                            n10 = n13;
                            comparable = comparable2;
                        }
                        if (n12 == n11) break;
                        ++n12;
                    }
                }
                object = n10 != 0;
            }
        }
        return object;
    }

    private static final Comparable Yl(short[] sArray, l l10) {
        Comparable<Short> comparable;
        int n10 = sArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray[0];
        comparable = (short)n10;
        comparable = (Comparable)l10.invoke(comparable);
        n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n12 <= n11) {
            while (true) {
                short s10 = sArray[n12];
                Comparable<Short> comparable2 = s10;
                int n13 = comparable.compareTo((Short)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 > 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Float Ym(float[] fArray, Comparator comparator) {
        f0.p(fArray, "$this$minWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.hn(fArray, comparator);
    }

    /*
     * WARNING - void declaration
     */
    public static final Pair Yn(double[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$partition");
        f0.p(var1_2, "predicate");
        ArrayList<Double> arrayList = new ArrayList<Double>();
        ArrayList<Double> arrayList2 = new ArrayList<Double>();
        for (Object object2 : object) {
            Double d10;
            Constable constable = Double.valueOf((double)object2);
            boolean bl2 = (Boolean)(constable = (Boolean)var1_2.invoke(constable));
            if (bl2) {
                d10 = (double)object2;
                arrayList.add(d10);
                continue;
            }
            d10 = (double)object2;
            arrayList2.add(d10);
        }
        Pair pair = new Pair(arrayList, arrayList2);
        return pair;
    }

    public static final byte Yo(byte[] object, q q10) {
        f0.p(object, "$this$reduceIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = ((byte[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Ld(object);
            if (n12 <= n11) {
                while (true) {
                    Integer n13 = n12;
                    object2 = (byte)n10;
                    byte by2 = object[n12];
                    Byte by3 = by2;
                    object2 = (Number)q10.invoke(n13, object2, by3);
                    n10 = ((Number)object2).byteValue();
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return (byte)n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final Object Yp(Object[] objectArray, q q10) {
        f0.p(objectArray, "$this$reduceRightIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n10 < 0) {
            return null;
        }
        object = objectArray[n10];
        for (int i10 = n10 + -1; i10 >= 0; i10 += -1) {
            Integer n11 = i10;
            Object object2 = objectArray[i10];
            object = q10.invoke(n11, object2, object);
        }
        return object;
    }

    private static final List Yq(int[] nArray, Object object, p p10) {
        ArrayList<Object> arrayList;
        int n10 = nArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int n13 = nArray.length + n12;
        arrayList = new ArrayList<Object>(n13);
        arrayList.add(object);
        n12 = nArray.length;
        while (n11 < n12) {
            n13 = nArray[n11];
            Integer n14 = n13;
            object = p10.invoke(object, n14);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    private static final List Yr(double[] object, p p10) {
        Ref$DoubleRef ref$DoubleRef;
        int n10 = ((double[])object).length;
        ArrayList<Double> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            ref$DoubleRef = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            double d10;
            ref$DoubleRef = new Ref$DoubleRef();
            ref$DoubleRef.element = d10 = object[0];
            int n12 = ((double[])object).length;
            arrayList = new ArrayList<Double>(n12);
            d10 = ref$DoubleRef.element;
            Double d11 = d10;
            arrayList.add(d11);
            n12 = ((double[])object).length;
            while (n11 < n12) {
                double d12;
                Double d13 = ref$DoubleRef.element;
                double d14 = object[n11];
                Double d15 = d14;
                ref$DoubleRef.element = d12 = ((Number)p10.invoke(d13, d15)).doubleValue();
                d13 = d12;
                arrayList.add(d13);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Boolean Ys(boolean[] object) {
        String string2 = "$this$singleOrNull";
        f0.p(object, string2);
        int n10 = ((boolean[])object).length;
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            string2 = null;
            boolean bl2 = object[0];
            object = bl2;
        } else {
            boolean bl3 = false;
            object = null;
        }
        return object;
    }

    public static final boolean[] Yt(boolean[] blArray, Collection object) {
        int n10;
        f0.p(blArray, "$this$sliceArray");
        f0.p(object, "indices");
        int n11 = object.size();
        boolean[] blArray2 = new boolean[n11];
        object = object.iterator();
        int n12 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Number number = (Number)object.next();
            n10 = number.intValue();
            int n13 = n12 + 1;
            blArray2[n12] = n10 = blArray[n10];
            n12 = n13;
        }
        return blArray2;
    }

    public static final List Yu(short[] sArray, l l10) {
        f0.p(sArray, "$this$sortedBy");
        f0.p(l10, "selector");
        b$b b$b = new b$b(l10);
        return ArraysKt___ArraysKt.yv(sArray, b$b);
    }

    public static final double Yv(byte[] byArray, l l10) {
        f0.p(byArray, "$this$sumByDouble");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = byArray.length;
        double d10 = 0.0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Number number = by2;
            number = (Number)l10.invoke(number);
            double d11 = number.doubleValue();
            d10 += d11;
        }
        return d10;
    }

    private static final long Yw(char[] cArray, l l10) {
        long l11 = g1.h(0);
        for (char c10 : cArray) {
            Comparable<Character> comparable = Character.valueOf(c10);
            comparable = (g1)l10.invoke(comparable);
            long l12 = ((g1)comparable).a0();
            l11 = g1.h(l11 + l12);
        }
        return l11;
    }

    public static final Collection Yx(long[] lArray, Collection collection) {
        f0.p(lArray, "$this$toCollection");
        String string2 = "destination";
        f0.p(collection, string2);
        for (long l10 : lArray) {
            Long l11 = l10;
            collection.add(l11);
        }
        return collection;
    }

    public static final Set Yy(boolean[] object) {
        LinkedHashSet linkedHashSet = "$this$toSet";
        f0.p(object, (String)((Object)linkedHashSet));
        int n10 = ((boolean[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = s0.j(((boolean[])object).length);
                linkedHashSet = new LinkedHashSet(n11);
                object = (Set)ArraysKt___ArraysKt.by(object, linkedHashSet);
            } else {
                n10 = 0;
                linkedHashSet = null;
                boolean bl2 = object[0];
                object = c1.f(bl2);
            }
        } else {
            object = d1.k();
        }
        return object;
    }

    public static final List Yz(long[] lArray, long[] lArray2) {
        f0.p(lArray, "$this$zip");
        String string2 = "other";
        f0.p(lArray2, string2);
        int n10 = lArray.length;
        int n11 = lArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Long> arrayList = new ArrayList<Long>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            long l11 = lArray2[i10];
            Serializable serializable = l10;
            Long l12 = l11;
            serializable = w0.a(serializable, l12);
            arrayList.add((Long)serializable);
        }
        return arrayList;
    }

    public static final Iterable Z4(short[] sArray) {
        Object object = "$this$asIterable";
        f0.p(sArray, (String)object);
        int n10 = sArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = new ArraysKt___ArraysKt$c(sArray);
        return object;
    }

    public static final Map Z5(short[] sArray, Map map, l l10) {
        f0.p(sArray, "$this$associateByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (short s10 : sArray) {
            Object object = s10;
            object = l10.invoke(object);
            Short s11 = s10;
            map.put(object, s11);
        }
        return map;
    }

    private static final byte Z6(byte[] byArray) {
        f0.p(byArray, "$this$component2");
        return byArray[1];
    }

    public static final int Z7(float[] fArray, l l10) {
        f0.p(fArray, "$this$count");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = fArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Constable constable = Float.valueOf(f10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            ++n11;
        }
        return n11;
    }

    public static final List Z8(long[] lArray, l l10) {
        f0.p(lArray, "$this$dropLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Qd(lArray); i10 >= 0; i10 += -1) {
            long l11 = lArray[i10];
            Constable constable = Long.valueOf(l11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return ArraysKt___ArraysKt.lx(lArray, ++i10);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    public static final Collection Z9(float[] fArray, Collection collection, p p10) {
        f0.p(fArray, "$this$filterIndexedTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(p10, string2);
        int n10 = fArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Float f11 = Float.valueOf(f10);
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, f11))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                constable = Float.valueOf(f10);
                collection.add(constable);
            }
            n11 = n12;
        }
        return collection;
    }

    private static final Long Za(long[] object, l l10) {
        block1: {
            int n10 = ((long[])object).length;
            while ((n10 += -1) >= 0) {
                long l11 = object[n10];
                Constable constable = Long.valueOf(l11);
                boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
                if (!bl2) continue;
                object = l11;
                break block1;
            }
            object = null;
        }
        return object;
    }

    private static final List Zb(int[] nArray, p p10) {
        ArrayList arrayList = new ArrayList();
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Integer n13 = n11;
            ++n11;
            Object object = n12;
            object = (Iterable)p10.invoke(n13, object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object Zc(short[] sArray, Object object, p p10) {
        f0.p(sArray, "$this$foldRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Sd(sArray);
        while (n10 >= 0) {
            int n11 = n10 + -1;
            object2 = sArray[n10];
            object = p10.invoke(object2, object);
            n10 = n11;
        }
        return object;
    }

    private static final long Zd(long[] object, int n10, l l10) {
        long l11;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Qd((long[])object))) {
            l11 = object[n10];
        } else {
            object = n10;
            object = (Number)l10.invoke(object);
            l11 = ((Number)object).longValue();
        }
        return l11;
    }

    public static final int Ze(double[] dArray, double d10) {
        String string2 = "$this$indexOf";
        f0.p(dArray, string2);
        int n10 = dArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d11 = dArray[i10];
            double d12 = d10 - d11;
            Object object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
            if (object != false) continue;
            return i10;
        }
        return -1;
    }

    public static final Appendable Zf(byte[] byArray, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(byArray, "$this$joinTo");
        f0.p(appendable, "buffer");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        appendable.append(charSequence2);
        int n11 = byArray.length;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object;
            byte by2 = byArray[i10];
            int n13 = 1;
            if (++n12 > n13) {
                appendable.append(charSequence);
            }
            if (n10 >= 0 && n12 > n10) break;
            if (l10 != null) {
                object = by2;
                object = (CharSequence)l10.invoke(object);
                appendable.append((CharSequence)object);
                continue;
            }
            object = String.valueOf(by2);
            appendable.append((CharSequence)object);
        }
        if (n10 >= 0 && n12 > n10) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final boolean Zg(boolean[] object) {
        String string2 = "$this$last";
        f0.p(object, string2);
        int n10 = ((boolean[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ArraysKt___ArraysKt.Td(object);
            return object[n10];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final Collection Zh(float[] fArray, Collection collection, p p10) {
        f0.p(fArray, "$this$mapIndexedTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = fArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = Float.valueOf(f10);
            object = p10.invoke(n12, object);
            collection.add(object);
        }
        return collection;
    }

    private static final double Zi(short[] object, l l10) {
        Number number;
        int n10 = ((short[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            number = (short)n10;
            number = (Number)l10.invoke(number);
            double d10 = number.doubleValue();
            int n12 = ArraysKt___ArraysKt.Sd(object);
            if (n11 <= n12) {
                while (true) {
                    short s10 = object[n11];
                    Number number2 = s10;
                    number2 = (Number)l10.invoke(number2);
                    double d11 = number2.doubleValue();
                    d10 = Math.max(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object Zj(long[] object, Comparator comparator, l l10) {
        Object object2;
        int n10 = ((long[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            long l11 = object[0];
            object2 = l11;
            object2 = l10.invoke(object2);
            n11 = ArraysKt___ArraysKt.Qd(object);
            if (n12 <= n11) {
                while (true) {
                    long l12 = object[n12];
                    Object object3 = l12;
                    int n13 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n13 < 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Byte Zk(byte[] object, l l10) {
        f0.p(object, "$this$minBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = ((byte[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Ld(object);
            if (n11 == 0) {
                object = (byte)n10;
            } else {
                Comparable<Byte> comparable = (byte)n10;
                comparable = (Comparable)l10.invoke(comparable);
                if (n12 <= n11) {
                    while (true) {
                        int n13 = object[n12];
                        Comparable<Byte> comparable2 = (byte)n13;
                        int n14 = comparable.compareTo((Byte)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n14 > 0) {
                            n10 = n13;
                            comparable = comparable2;
                        }
                        if (n12 == n11) break;
                        ++n12;
                    }
                }
                object = (byte)n10;
            }
        }
        return object;
    }

    private static final Comparable Zl(boolean[] blArray, l l10) {
        Comparable<Boolean> comparable;
        int n10 = blArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = blArray[0];
        comparable = n10 != 0;
        comparable = (Comparable)l10.invoke(comparable);
        n11 = ArraysKt___ArraysKt.Td(blArray);
        if (n12 <= n11) {
            while (true) {
                boolean bl2 = blArray[n12];
                Comparable<Boolean> comparable2 = bl2;
                int n13 = comparable.compareTo((Boolean)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 > 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Integer Zm(int[] nArray, Comparator comparator) {
        f0.p(nArray, "$this$minWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.in(nArray, comparator);
    }

    /*
     * WARNING - void declaration
     */
    public static final Pair Zn(float[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$partition");
        f0.p(var1_2, "predicate");
        ArrayList<Float> arrayList = new ArrayList<Float>();
        ArrayList<Float> arrayList2 = new ArrayList<Float>();
        for (Object object2 : object) {
            Float f10;
            Constable constable = Float.valueOf((float)object2);
            boolean bl2 = (Boolean)(constable = (Boolean)var1_2.invoke(constable));
            if (bl2) {
                f10 = Float.valueOf((float)object2);
                arrayList.add(f10);
                continue;
            }
            f10 = Float.valueOf((float)object2);
            arrayList2.add(f10);
        }
        Pair pair = new Pair(arrayList, arrayList2);
        return pair;
    }

    public static final char Zo(char[] object, q q10) {
        f0.p(object, "$this$reduceIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = ((char[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Md(object);
            if (n12 <= n11) {
                while (true) {
                    Integer n13 = n12;
                    object2 = Character.valueOf((char)n10);
                    char c10 = object[n12];
                    Character c11 = Character.valueOf(c10);
                    object2 = (Character)q10.invoke(n13, object2, c11);
                    n10 = ((Character)object2).charValue();
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return (char)n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final Short Zp(short[] sArray, q q10) {
        short s10;
        f0.p(sArray, "$this$reduceRightIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int s102 = ArraysKt___ArraysKt.Sd(sArray);
        if (s102 < 0) {
            return null;
        }
        short s11 = sArray[s102];
        for (int i10 = s102 + -1; i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            short s12 = sArray[i10];
            Short s13 = s12;
            object = s10;
            object = (Number)q10.invoke(n10, s13, object);
            s10 = ((Number)object).shortValue();
        }
        return s10;
    }

    private static final List Zq(long[] lArray, Object object, p p10) {
        ArrayList<Object> arrayList;
        int n10 = lArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int n13 = lArray.length + n12;
        arrayList = new ArrayList<Object>(n13);
        arrayList.add(object);
        n12 = lArray.length;
        while (n11 < n12) {
            long l10 = lArray[n11];
            Long l11 = l10;
            object = p10.invoke(object, l11);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    private static final List Zr(float[] object, p p10) {
        Ref$FloatRef ref$FloatRef;
        int n10 = ((float[])object).length;
        float f10 = 0.0f;
        ArrayList<Float> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            ref$FloatRef = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            ref$FloatRef = new Ref$FloatRef();
            ref$FloatRef.element = f10 = object[0];
            int n12 = ((float[])object).length;
            arrayList = new ArrayList<Float>(n12);
            float f11 = ref$FloatRef.element;
            Float f12 = Float.valueOf(f11);
            arrayList.add(f12);
            n12 = ((float[])object).length;
            while (n11 < n12) {
                float f13;
                Float f14 = Float.valueOf(ref$FloatRef.element);
                float f15 = object[n11];
                Float f16 = Float.valueOf(f15);
                ref$FloatRef.element = f13 = ((Number)p10.invoke(f14, f16)).floatValue();
                f14 = Float.valueOf(f13);
                arrayList.add(f14);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Boolean Zs(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$singleOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = blArray.length;
        boolean bl2 = false;
        Boolean bl3 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl4 = blArray[i10];
            Boolean bl5 = bl4;
            boolean bl6 = bl5 = (Boolean)l10.invoke(bl5);
            if (!bl6) continue;
            if (bl2) {
                return null;
            }
            bl3 = bl4;
            bl2 = true;
        }
        if (!bl2) {
            return null;
        }
        return bl3;
    }

    public static final boolean[] Zt(boolean[] blArray, k k10) {
        f0.p(blArray, "$this$sliceArray");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return new boolean[0];
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.O1(blArray, n10, n11);
    }

    public static final List Zu(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$sortedBy");
        f0.p(l10, "selector");
        b$b b$b = new b$b(l10);
        return ArraysKt___ArraysKt.zv(blArray, b$b);
    }

    public static final double Zv(char[] cArray, l l10) {
        f0.p(cArray, "$this$sumByDouble");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = cArray.length;
        double d10 = 0.0;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = cArray[i10];
            Serializable serializable = Character.valueOf(c10);
            serializable = (Number)l10.invoke(serializable);
            double d11 = ((Number)serializable).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    private static final long Zw(double[] dArray, l l10) {
        long l11 = g1.h(0);
        for (double d10 : dArray) {
            Comparable<Double> comparable = d10;
            comparable = (g1)l10.invoke(comparable);
            long l12 = ((g1)comparable).a0();
            l11 = g1.h(l11 + l12);
        }
        return l11;
    }

    public static final Collection Zx(Object[] objectArray, Collection collection) {
        f0.p(objectArray, "$this$toCollection");
        String string2 = "destination";
        f0.p(collection, string2);
        for (Object object : objectArray) {
            collection.add(object);
        }
        return collection;
    }

    public static final short[] Zy(Short[] shortArray) {
        String string2 = "$this$toShortArray";
        f0.p(shortArray, string2);
        int n10 = shortArray.length;
        short[] sArray = new short[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10;
            Short s11 = shortArray[i10];
            sArray[i10] = s10 = s11.shortValue();
        }
        return sArray;
    }

    public static final List Zz(long[] lArray, long[] lArray2, p p10) {
        f0.p(lArray, "$this$zip");
        f0.p(lArray2, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = lArray.length;
        int n11 = lArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Object object = l10;
            long l11 = lArray2[i10];
            Long l12 = l11;
            object = p10.invoke(object, l12);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Iterable a5(boolean[] blArray) {
        Object object = "$this$asIterable";
        f0.p(blArray, (String)object);
        int n10 = blArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = new ArraysKt___ArraysKt$h(blArray);
        return object;
    }

    public static final Map a6(short[] sArray, Map map, l l10, l l11) {
        f0.p(sArray, "$this$associateByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (short s10 : sArray) {
            Object object = s10;
            object = l10.invoke(object);
            Object object2 = s10;
            object2 = l11.invoke(object2);
            map.put(object, object2);
        }
        return map;
    }

    private static final char a7(char[] cArray) {
        f0.p(cArray, "$this$component2");
        return cArray[1];
    }

    private static final int a8(int[] nArray) {
        return nArray.length;
    }

    public static final List a9(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$dropLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Rd(objectArray); i10 >= 0; i10 += -1) {
            Object object = objectArray[i10];
            boolean bl2 = (Boolean)(object = (Boolean)l10.invoke(object));
            if (bl2) continue;
            return ArraysKt___ArraysKt.mx(objectArray, ++i10);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    public static final List aA(long[] lArray, Object[] objectArray) {
        f0.p(lArray, "$this$zip");
        String string2 = "other";
        f0.p(objectArray, string2);
        int n10 = lArray.length;
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Object object = objectArray[i10];
            Pair pair = w0.a(l10, object);
            arrayList.add(pair);
        }
        return arrayList;
    }

    public static final Collection aa(int[] nArray, Collection collection, p p10) {
        f0.p(nArray, "$this$filterIndexedTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(p10, string2);
        int n10 = nArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            int n13 = n11 + 1;
            constable = Integer.valueOf(n11);
            Integer n14 = n12;
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, n14))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                constable = Integer.valueOf(n12);
                collection.add(constable);
            }
            n11 = n13;
        }
        return collection;
    }

    private static final Object ab(Object[] objectArray, l l10) {
        Object object;
        block1: {
            int n10 = objectArray.length;
            while ((n10 += -1) >= 0) {
                object = objectArray[n10];
                Boolean bl2 = (Boolean)l10.invoke(object);
                boolean bl3 = bl2;
                if (!bl3) continue;
                break block1;
            }
            object = null;
        }
        return object;
    }

    private static final List ac(long[] lArray, p p10) {
        ArrayList arrayList = new ArrayList();
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = l10;
            object = (Iterable)p10.invoke(n12, object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object ad(boolean[] blArray, Object object, p p10) {
        f0.p(blArray, "$this$foldRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ArraysKt___ArraysKt.Td(blArray);
        while (n10 >= 0) {
            int n11 = n10 + -1;
            object2 = blArray[n10];
            object = p10.invoke(object2, object);
            n10 = n11;
        }
        return object;
    }

    private static final Object ae(Object[] object, int n10, l l10) {
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Rd(object))) {
            object = object[n10];
        } else {
            object = n10;
            object = l10.invoke(object);
        }
        return object;
    }

    public static final int af(float[] fArray, float f10) {
        String string2 = "$this$indexOf";
        f0.p(fArray, string2);
        int n10 = fArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f11 = fArray[i10];
            float f12 = f10 - f11;
            Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
            if (object != false) continue;
            return i10;
        }
        return -1;
    }

    public static final Appendable ag(char[] cArray, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(cArray, "$this$joinTo");
        f0.p(appendable, "buffer");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        appendable.append(charSequence2);
        int n11 = cArray.length;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            char c10 = cArray[i10];
            int n13 = 1;
            if (++n12 > n13) {
                appendable.append(charSequence);
            }
            if (n10 >= 0 && n12 > n10) break;
            if (l10 != null) {
                Object object = Character.valueOf(c10);
                object = (CharSequence)l10.invoke(object);
                appendable.append((CharSequence)object);
                continue;
            }
            appendable.append(c10);
        }
        if (n10 >= 0 && n12 > n10) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final boolean ah(boolean[] object, l l10) {
        f0.p(object, "$this$last");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = ((boolean[])object).length;
        while ((n10 += -1) >= 0) {
            boolean bl2 = object[n10];
            Boolean bl3 = bl2;
            boolean bl4 = bl3 = (Boolean)l10.invoke(bl3);
            if (!bl4) continue;
            return bl2;
        }
        object = new NoSuchElementException;
        object("Array contains no element matching the predicate.");
        throw object;
    }

    public static final Collection ai(int[] nArray, Collection collection, p p10) {
        f0.p(nArray, "$this$mapIndexedTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Integer n13 = n11;
            ++n11;
            Object object = n12;
            object = p10.invoke(n13, object);
            collection.add(object);
        }
        return collection;
    }

    private static final double aj(boolean[] object, l l10) {
        Serializable serializable;
        int n10 = ((boolean[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            serializable = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            serializable = Boolean.valueOf(n10 != 0);
            serializable = (Number)l10.invoke(serializable);
            double d10 = ((Number)serializable).doubleValue();
            int n12 = ArraysKt___ArraysKt.Td(object);
            if (n11 <= n12) {
                while (true) {
                    boolean bl2 = object[n11];
                    Serializable serializable2 = Boolean.valueOf(bl2);
                    serializable2 = (Number)l10.invoke(serializable2);
                    double d11 = ((Number)serializable2).doubleValue();
                    d10 = Math.max(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object ak(Object[] objectArray, Comparator comparator, l l10) {
        Object object;
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 == 0) {
            object = objectArray[0];
            object = l10.invoke(object);
            n11 = ArraysKt___ArraysKt.Rd(objectArray);
            if (n12 <= n11) {
                while (true) {
                    Object object2 = objectArray[n12];
                    int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                    if (n13 < 0) {
                        object = object2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object;
        }
        objectArray = new NoSuchElementException();
        throw objectArray;
    }

    public static final Character al(char[] object, l l10) {
        f0.p(object, "$this$minBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = ((char[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Md(object);
            if (n11 == 0) {
                object = Character.valueOf((char)n10);
            } else {
                Comparable<Character> comparable = Character.valueOf((char)n10);
                comparable = (Comparable)l10.invoke(comparable);
                if (n12 <= n11) {
                    while (true) {
                        int n13 = object[n12];
                        Comparable<Character> comparable2 = Character.valueOf((char)n13);
                        int n14 = comparable.compareTo((Character)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n14 > 0) {
                            n10 = n13;
                            comparable = comparable2;
                        }
                        if (n12 == n11) break;
                        ++n12;
                    }
                }
                object = Character.valueOf((char)n10);
            }
        }
        return object;
    }

    private static final Double am(byte[] byArray, l l10) {
        Number number;
        int n10 = byArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray[0];
        number = (byte)n10;
        number = (Number)l10.invoke(number);
        double d10 = number.doubleValue();
        int n12 = ArraysKt___ArraysKt.Ld(byArray);
        if (n11 <= n12) {
            while (true) {
                byte by2 = byArray[n11];
                Number number2 = by2;
                number2 = (Number)l10.invoke(number2);
                double d11 = number2.doubleValue();
                d10 = Math.min(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Long an(long[] lArray, Comparator comparator) {
        f0.p(lArray, "$this$minWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.jn(lArray, comparator);
    }

    /*
     * WARNING - void declaration
     */
    public static final Pair ao(int[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$partition");
        f0.p(var1_2, "predicate");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        for (Object object2 : object) {
            Integer n10;
            Constable constable = Integer.valueOf((int)object2);
            boolean bl2 = (Boolean)(constable = (Boolean)var1_2.invoke(constable));
            if (bl2) {
                n10 = (int)object2;
                arrayList.add(n10);
                continue;
            }
            n10 = (int)object2;
            arrayList2.add(n10);
        }
        Pair pair = new Pair(arrayList, arrayList2);
        return pair;
    }

    public static final double ap(double[] object, q q10) {
        f0.p(object, "$this$reduceIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = ((double[])object).length;
        Double d10 = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            double d11 = object[0];
            int n12 = ArraysKt___ArraysKt.Nd(object);
            if (n11 <= n12) {
                while (true) {
                    Integer n13 = n11;
                    object2 = d11;
                    double d12 = object[n11];
                    d10 = d12;
                    object2 = (Number)q10.invoke(n13, object2, d10);
                    d11 = ((Number)object2).doubleValue();
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d11;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final Boolean aq(boolean[] blArray, p p10) {
        boolean bl2;
        f0.p(blArray, "$this$reduceRightOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = ArraysKt___ArraysKt.Td(blArray);
        if (n10 < 0) {
            return null;
        }
        int n11 = n10 + -1;
        boolean bl3 = blArray[n10];
        while (n11 >= 0) {
            int n12 = n11 + -1;
            Boolean bl4 = blArray[n11];
            object = bl2;
            object = (Boolean)p10.invoke(bl4, object);
            bl2 = (Boolean)object;
            n11 = n12;
        }
        return bl2;
    }

    public static final List ar(Object[] objectArray, Object object, p p10) {
        f0.p(objectArray, "$this$runningFold");
        ArrayList<Object> arrayList = "operation";
        f0.p(p10, (String)((Object)arrayList));
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int n13 = objectArray.length + n12;
        arrayList = new ArrayList<Object>(n13);
        arrayList.add(object);
        n12 = objectArray.length;
        while (n11 < n12) {
            Object object2 = objectArray[n11];
            object = p10.invoke(object, object2);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    private static final List as(int[] object, p p10) {
        Ref$IntRef ref$IntRef;
        int n10 = ((int[])object).length;
        int n11 = 0;
        ArrayList<Integer> arrayList = null;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            ref$IntRef = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = n11 = object[0];
            int n13 = ((int[])object).length;
            arrayList = new ArrayList<Integer>(n13);
            Integer n14 = ref$IntRef.element;
            arrayList.add(n14);
            n13 = ((int[])object).length;
            while (n12 < n13) {
                int n15;
                Integer n16 = ref$IntRef.element;
                int n17 = object[n12];
                Integer n18 = n17;
                ref$IntRef.element = n15 = ((Number)p10.invoke(n16, n18)).intValue();
                n16 = n15;
                arrayList.add(n16);
                ++n12;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Byte at(byte[] object) {
        String string2 = "$this$singleOrNull";
        f0.p(object, string2);
        int n10 = ((byte[])object).length;
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            string2 = null;
            byte by2 = object[0];
            object = by2;
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    public static final void au(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$sortBy");
        Object object = "selector";
        f0.p(l10, (String)object);
        int n10 = objectArray.length;
        int n11 = 1;
        if (n10 > n11) {
            object = new b$b(l10);
            f.x1.n.E3(objectArray, (Comparator)object);
        }
    }

    public static final List av(byte[] byArray, l l10) {
        f0.p(byArray, "$this$sortedByDescending");
        f0.p(l10, "selector");
        b$d b$d = new b$d(l10);
        return ArraysKt___ArraysKt.rv(byArray, b$d);
    }

    public static final double aw(double[] dArray, l l10) {
        f0.p(dArray, "$this$sumByDouble");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = dArray.length;
        double d10 = 0.0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Number number = dArray[i10];
            number = (Number)l10.invoke(number);
            double d11 = number.doubleValue();
            d10 += d11;
        }
        return d10;
    }

    private static final long ax(float[] fArray, l l10) {
        long l11 = g1.h(0);
        for (float f10 : fArray) {
            Comparable<Float> comparable = Float.valueOf(f10);
            comparable = (g1)l10.invoke(comparable);
            long l12 = ((g1)comparable).a0();
            l11 = g1.h(l11 + l12);
        }
        return l11;
    }

    public static final Collection ay(short[] sArray, Collection collection) {
        f0.p(sArray, "$this$toCollection");
        String string2 = "destination";
        f0.p(collection, string2);
        for (short s10 : sArray) {
            Short s11 = s10;
            collection.add(s11);
        }
        return collection;
    }

    public static final Set az(byte[] object, Iterable iterable) {
        f0.p(object, "$this$union");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Hy(object);
        y.q0((Collection)object, iterable);
        return object;
    }

    public static final m b5(byte[] byArray) {
        Object object = "$this$asSequence";
        f0.p(byArray, (String)object);
        int n10 = byArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return SequencesKt__SequencesKt.j();
        }
        object = new ArraysKt___ArraysKt$k(byArray);
        return object;
    }

    public static final Map b6(boolean[] blArray, Map map, l l10) {
        f0.p(blArray, "$this$associateByTo");
        f0.p(map, "destination");
        String string2 = "keySelector";
        f0.p(l10, string2);
        for (boolean bl2 : blArray) {
            Object object = bl2;
            object = l10.invoke(object);
            Boolean bl3 = bl2;
            map.put(object, bl3);
        }
        return map;
    }

    private static final double b7(double[] dArray) {
        f0.p(dArray, "$this$component2");
        return dArray[1];
    }

    public static final int b8(int[] nArray, l l10) {
        f0.p(nArray, "$this$count");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Constable constable = Integer.valueOf(nArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            ++n11;
        }
        return n11;
    }

    public static final List b9(short[] sArray, l l10) {
        f0.p(sArray, "$this$dropLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Sd(sArray); i10 >= 0; i10 += -1) {
            Constable constable = Short.valueOf(sArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return ArraysKt___ArraysKt.nx(sArray, ++i10);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    public static final List bA(long[] lArray, Object[] objectArray, p p10) {
        f0.p(lArray, "$this$zip");
        f0.p(objectArray, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = lArray.length;
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Object object = l10;
            Object object2 = objectArray[i10];
            object = p10.invoke(object, object2);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Collection ba(long[] lArray, Collection collection, p p10) {
        f0.p(lArray, "$this$filterIndexedTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(p10, string2);
        int n10 = lArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Long l11 = l10;
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, l11))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                constable = Long.valueOf(l10);
                collection.add(constable);
            }
            n11 = n12;
        }
        return collection;
    }

    private static final Short bb(short[] object, l l10) {
        block1: {
            int n10 = ((short[])object).length;
            while ((n10 += -1) >= 0) {
                short s10 = object[n10];
                Constable constable = Short.valueOf(s10);
                boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
                if (!bl2) continue;
                object = s10;
                break block1;
            }
            object = null;
        }
        return object;
    }

    private static final List bc(Object[] objectArray, p p10) {
        ArrayList arrayList = new ArrayList();
        int n10 = objectArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            Integer n12 = n11;
            ++n11;
            object = (Iterable)p10.invoke(n12, object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object bd(byte[] byArray, Object object, q q10) {
        f0.p(byArray, "$this$foldRightIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        for (int i10 = ArraysKt___ArraysKt.Ld(byArray); i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            byte by2 = byArray[i10];
            Byte by3 = by2;
            object = q10.invoke(n10, by3, object);
        }
        return object;
    }

    private static final short be(short[] object, int n10, l l10) {
        short s10;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Sd((short[])object))) {
            s10 = object[n10];
        } else {
            object = n10;
            object = (Number)l10.invoke(object);
            s10 = ((Number)object).shortValue();
        }
        return s10;
    }

    public static final int bf(int[] nArray, int n10) {
        String string2 = "$this$indexOf";
        f0.p(nArray, string2);
        int n11 = nArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12 = nArray[i10];
            if (n10 != n12) continue;
            return i10;
        }
        return -1;
    }

    public static final Appendable bg(double[] dArray, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(dArray, "$this$joinTo");
        f0.p(appendable, "buffer");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        appendable.append(charSequence2);
        int n11 = dArray.length;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object;
            double d10 = dArray[i10];
            int n13 = 1;
            if (++n12 > n13) {
                appendable.append(charSequence);
            }
            if (n10 >= 0 && n12 > n10) break;
            if (l10 != null) {
                object = d10;
                object = (CharSequence)l10.invoke(object);
                appendable.append((CharSequence)object);
                continue;
            }
            object = String.valueOf(d10);
            appendable.append((CharSequence)object);
        }
        if (n10 >= 0 && n12 > n10) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final int bh(byte[] byArray, byte by2) {
        String string2 = "$this$lastIndexOf";
        f0.p(byArray, string2);
        int n10 = byArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            byte by3 = byArray[n10];
            if (by2 == by3) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static final Collection bi(long[] lArray, Collection collection, p p10) {
        f0.p(lArray, "$this$mapIndexedTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = l10;
            object = p10.invoke(n12, object);
            collection.add(object);
        }
        return collection;
    }

    private static final float bj(byte[] object, l l10) {
        Number number;
        float f10;
        int n10 = ((byte[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            n10 = object[0];
            number = (byte)n10;
            number = (Number)l10.invoke(number);
            f10 = number.floatValue();
            n11 = ArraysKt___ArraysKt.Ld(object);
            if (n12 <= n11) {
                while (true) {
                    byte by2 = object[n12];
                    Number number2 = by2;
                    number2 = (Number)l10.invoke(number2);
                    float f12 = number2.floatValue();
                    f10 = Math.max(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object bk(short[] object, Comparator comparator, l l10) {
        Object object2;
        int n10 = ((short[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            object2 = (short)n10;
            object2 = l10.invoke(object2);
            n11 = ArraysKt___ArraysKt.Sd(object);
            if (n12 <= n11) {
                while (true) {
                    short s10 = object[n12];
                    Object object3 = s10;
                    int n13 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n13 < 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Double bl(double[] object, l l10) {
        f0.p(object, "$this$minBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = ((double[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            double d10 = object[0];
            int n12 = ArraysKt___ArraysKt.Nd(object);
            if (n12 == 0) {
                object = d10;
            } else {
                Comparable<Double> comparable = d10;
                comparable = (Comparable)l10.invoke(comparable);
                if (n11 <= n12) {
                    while (true) {
                        double d11 = object[n11];
                        Comparable<Double> comparable2 = d11;
                        int n13 = comparable.compareTo((Double)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n13 > 0) {
                            d10 = d11;
                            comparable = comparable2;
                        }
                        if (n11 == n12) break;
                        ++n11;
                    }
                }
                object = d10;
            }
        }
        return object;
    }

    private static final Double bm(char[] cArray, l l10) {
        Serializable serializable;
        int n10 = cArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            serializable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray[0];
        serializable = Character.valueOf((char)n10);
        serializable = (Number)l10.invoke(serializable);
        double d10 = ((Number)serializable).doubleValue();
        int n12 = ArraysKt___ArraysKt.Md(cArray);
        if (n11 <= n12) {
            while (true) {
                char c10 = cArray[n11];
                Serializable serializable2 = Character.valueOf(c10);
                serializable2 = (Number)l10.invoke(serializable2);
                double d11 = ((Number)serializable2).doubleValue();
                d10 = Math.min(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Object bn(Object[] objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$minWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.kn(objectArray, comparator);
    }

    /*
     * WARNING - void declaration
     */
    public static final Pair bo(long[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$partition");
        f0.p(var1_2, "predicate");
        ArrayList<Long> arrayList = new ArrayList<Long>();
        ArrayList<Long> arrayList2 = new ArrayList<Long>();
        for (Object object2 : object) {
            Long l11;
            Constable constable = Long.valueOf((long)object2);
            boolean bl2 = (Boolean)(constable = (Boolean)var1_2.invoke(constable));
            if (bl2) {
                l11 = (long)object2;
                arrayList.add(l11);
                continue;
            }
            l11 = (long)object2;
            arrayList2.add(l11);
        }
        Pair pair = new Pair(arrayList, arrayList2);
        return pair;
    }

    public static final float bp(float[] object, q q10) {
        float f10;
        f0.p(object, "$this$reduceIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = ((float[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            object2 = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            f10 = object[0];
            n11 = ArraysKt___ArraysKt.Od(object);
            if (n12 <= n11) {
                while (true) {
                    Integer n13 = n12;
                    object2 = Float.valueOf(f10);
                    float f12 = object[n12];
                    Float f13 = Float.valueOf(f12);
                    object2 = (Number)q10.invoke(n13, object2, f13);
                    f10 = ((Number)object2).floatValue();
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final Byte bq(byte[] byArray, p p10) {
        byte by2;
        f0.p(byArray, "$this$reduceRightOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int by22 = ArraysKt___ArraysKt.Ld(byArray);
        if (by22 < 0) {
            return null;
        }
        int n10 = by22 + -1;
        byte by3 = byArray[by22];
        while (n10 >= 0) {
            int n11 = n10 + -1;
            Byte by4 = byArray[n10];
            object = by2;
            object = (Number)p10.invoke(by4, object);
            by2 = ((Number)object).byteValue();
            n10 = n11;
        }
        return by2;
    }

    private static final List br(short[] sArray, Object object, p p10) {
        ArrayList<Object> arrayList;
        int n10 = sArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        short s10 = sArray.length + n12;
        arrayList = new ArrayList<Object>(s10);
        arrayList.add(object);
        n12 = sArray.length;
        while (n11 < n12) {
            s10 = sArray[n11];
            Short s11 = s10;
            object = p10.invoke(object, s11);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    private static final List bs(long[] object, p p10) {
        Ref$LongRef ref$LongRef;
        int n10 = ((long[])object).length;
        ArrayList<Long> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            ref$LongRef = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            long l10;
            ref$LongRef = new Ref$LongRef();
            ref$LongRef.element = l10 = object[0];
            int n12 = ((long[])object).length;
            arrayList = new ArrayList<Long>(n12);
            l10 = ref$LongRef.element;
            Long l11 = l10;
            arrayList.add(l11);
            n12 = ((long[])object).length;
            while (n11 < n12) {
                long l12;
                Long l13 = ref$LongRef.element;
                long l14 = object[n11];
                Long l15 = l14;
                ref$LongRef.element = l12 = ((Number)p10.invoke(l13, l15)).longValue();
                l13 = l12;
                arrayList.add(l13);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Byte bt(byte[] byArray, l l10) {
        f0.p(byArray, "$this$singleOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = byArray.length;
        boolean bl2 = false;
        Byte by2 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by3 = byArray[i10];
            Constable constable = Byte.valueOf(by3);
            boolean bl3 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl3) continue;
            if (bl2) {
                return null;
            }
            by2 = by3;
            bl2 = true;
        }
        if (!bl2) {
            return null;
        }
        return by2;
    }

    public static final void bu(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$sortByDescending");
        Object object = "selector";
        f0.p(l10, (String)object);
        int n10 = objectArray.length;
        int n11 = 1;
        if (n10 > n11) {
            object = new b$d(l10);
            f.x1.n.E3(objectArray, (Comparator)object);
        }
    }

    public static final List bv(char[] cArray, l l10) {
        f0.p(cArray, "$this$sortedByDescending");
        f0.p(l10, "selector");
        b$d b$d = new b$d(l10);
        return ArraysKt___ArraysKt.sv(cArray, b$d);
    }

    public static final double bw(float[] fArray, l l10) {
        f0.p(fArray, "$this$sumByDouble");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = fArray.length;
        double d10 = 0.0;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Number number = Float.valueOf(f10);
            number = (Number)l10.invoke(number);
            double d11 = number.doubleValue();
            d10 += d11;
        }
        return d10;
    }

    private static final long bx(int[] nArray, l l10) {
        long l11 = g1.h(0);
        for (int n10 : nArray) {
            Comparable<Integer> comparable = n10;
            comparable = (g1)l10.invoke(comparable);
            long l12 = ((g1)comparable).a0();
            l11 = g1.h(l11 + l12);
        }
        return l11;
    }

    public static final Collection by(boolean[] blArray, Collection collection) {
        f0.p(blArray, "$this$toCollection");
        String string2 = "destination";
        f0.p(collection, string2);
        for (boolean bl2 : blArray) {
            Boolean bl3 = bl2;
            collection.add(bl3);
        }
        return collection;
    }

    public static final Set bz(char[] object, Iterable iterable) {
        f0.p(object, "$this$union");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Iy(object);
        y.q0((Collection)object, iterable);
        return object;
    }

    public static final m c5(char[] cArray) {
        Object object = "$this$asSequence";
        f0.p(cArray, (String)object);
        int n10 = cArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return SequencesKt__SequencesKt.j();
        }
        object = new ArraysKt___ArraysKt$r(cArray);
        return object;
    }

    public static final Map c6(boolean[] blArray, Map map, l l10, l l11) {
        f0.p(blArray, "$this$associateByTo");
        f0.p(map, "destination");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        for (boolean bl2 : blArray) {
            Object object = bl2;
            object = l10.invoke(object);
            Object object2 = bl2;
            object2 = l11.invoke(object2);
            map.put(object, object2);
        }
        return map;
    }

    private static final float c7(float[] fArray) {
        f0.p(fArray, "$this$component2");
        return fArray[1];
    }

    private static final int c8(long[] lArray) {
        return lArray.length;
    }

    public static final List c9(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$dropLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Td(blArray); i10 >= 0; i10 += -1) {
            Boolean bl2 = blArray[i10];
            boolean bl3 = bl2 = (Boolean)l10.invoke(bl2);
            if (bl3) continue;
            return ArraysKt___ArraysKt.ox(blArray, ++i10);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    public static final List cA(Object[] objectArray, Iterable object) {
        boolean bl2;
        f0.p(objectArray, "$this$zip");
        String string2 = "other";
        f0.p(object, string2);
        int n10 = objectArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n11);
        object = object.iterator();
        n11 = 0;
        Pair pair = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            pair = w0.a(objectArray[n11], e10);
            arrayList.add(pair);
            n11 = n12;
        }
        return arrayList;
    }

    public static final Collection ca(Object[] objectArray, Collection collection, p p10) {
        f0.p(objectArray, "$this$filterIndexedTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(p10, string2);
        int n10 = objectArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, object))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                collection.add(object);
            }
            n11 = n12;
        }
        return collection;
    }

    public static final byte cb(byte[] object) {
        String string2 = "$this$first";
        f0.p(object, string2);
        int n10 = ((byte[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            return object[0];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    private static final List cc(short[] sArray, p p10) {
        ArrayList arrayList = new ArrayList();
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = s10;
            object = (Iterable)p10.invoke(n12, object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object cd(char[] cArray, Object object, q q10) {
        f0.p(cArray, "$this$foldRightIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        for (int i10 = ArraysKt___ArraysKt.Md(cArray); i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            char c10 = cArray[i10];
            Character c11 = Character.valueOf(c10);
            object = q10.invoke(n10, c11, object);
        }
        return object;
    }

    private static final boolean ce(boolean[] object, int n10, l l10) {
        boolean bl2;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Td((boolean[])object))) {
            bl2 = object[n10];
        } else {
            object = n10;
            object = (Boolean)l10.invoke(object);
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public static final int cf(long[] lArray, long l10) {
        String string2 = "$this$indexOf";
        f0.p(lArray, string2);
        int n10 = lArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = lArray[i10];
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object != false) continue;
            return i10;
        }
        return -1;
    }

    public static final Appendable cg(float[] fArray, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(fArray, "$this$joinTo");
        f0.p(appendable, "buffer");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        appendable.append(charSequence2);
        int n11 = fArray.length;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object;
            float f10 = fArray[i10];
            int n13 = 1;
            if (++n12 > n13) {
                appendable.append(charSequence);
            }
            if (n10 >= 0 && n12 > n10) break;
            if (l10 != null) {
                object = Float.valueOf(f10);
                object = (CharSequence)l10.invoke(object);
                appendable.append((CharSequence)object);
                continue;
            }
            object = String.valueOf(f10);
            appendable.append((CharSequence)object);
        }
        if (n10 >= 0 && n12 > n10) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final int ch(char[] cArray, char c10) {
        String string2 = "$this$lastIndexOf";
        f0.p(cArray, string2);
        int n10 = cArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            char c11 = cArray[n10];
            if (c10 == c11) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static final Collection ci(Object[] objectArray, Collection collection, p p10) {
        f0.p(objectArray, "$this$mapIndexedTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = objectArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            Integer n12 = n11;
            ++n11;
            object = p10.invoke(n12, object);
            collection.add(object);
        }
        return collection;
    }

    private static final float cj(char[] object, l l10) {
        Serializable serializable;
        float f10;
        int n10 = ((char[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            serializable = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            n10 = object[0];
            serializable = Character.valueOf((char)n10);
            serializable = (Number)l10.invoke(serializable);
            f10 = ((Number)serializable).floatValue();
            n11 = ArraysKt___ArraysKt.Md(object);
            if (n12 <= n11) {
                while (true) {
                    char c10 = object[n12];
                    Serializable serializable2 = Character.valueOf(c10);
                    serializable2 = (Number)l10.invoke(serializable2);
                    float f12 = ((Number)serializable2).floatValue();
                    f10 = Math.max(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object ck(boolean[] object, Comparator comparator, l l10) {
        Object object2;
        int n10 = ((boolean[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            object2 = n10 != 0;
            object2 = l10.invoke(object2);
            n11 = ArraysKt___ArraysKt.Td(object);
            if (n12 <= n11) {
                while (true) {
                    boolean bl2 = object[n12];
                    Object object3 = bl2;
                    int n13 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n13 < 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Float cl(float[] object, l l10) {
        float f10;
        f0.p(object, "$this$minBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = ((float[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            string2 = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            object = null;
        } else {
            f10 = object[0];
            n11 = ArraysKt___ArraysKt.Od(object);
            if (n11 == 0) {
                object = Float.valueOf(f10);
            } else {
                Comparable<Float> comparable = Float.valueOf(f10);
                comparable = (Comparable)l10.invoke(comparable);
                if (n12 <= n11) {
                    while (true) {
                        float f12 = object[n12];
                        Comparable<Float> comparable2 = Float.valueOf(f12);
                        int n13 = comparable.compareTo((Float)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n13 > 0) {
                            f10 = f12;
                            comparable = comparable2;
                        }
                        if (n12 == n11) break;
                        ++n12;
                    }
                }
                object = Float.valueOf(f10);
            }
        }
        return object;
    }

    private static final Double cm(double[] dArray, l l10) {
        Number number;
        int n10 = dArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return null;
        }
        number = dArray[0];
        number = (Number)l10.invoke(number);
        double d10 = number.doubleValue();
        int n12 = ArraysKt___ArraysKt.Nd(dArray);
        if (n11 <= n12) {
            while (true) {
                Number number2 = dArray[n11];
                number2 = (Number)l10.invoke(number2);
                double d11 = number2.doubleValue();
                d10 = Math.min(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Short cn(short[] sArray, Comparator comparator) {
        f0.p(sArray, "$this$minWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.ln(sArray, comparator);
    }

    /*
     * WARNING - void declaration
     */
    public static final Pair co(Object[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$partition");
        f0.p(var1_2, "predicate");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        for (Object object2 : object) {
            Boolean bl2 = (Boolean)var1_2.invoke(object2);
            boolean bl3 = bl2;
            if (bl3) {
                arrayList.add(object2);
                continue;
            }
            arrayList2.add(object2);
        }
        Pair pair = new Pair(arrayList, arrayList2);
        return pair;
    }

    public static final int cp(int[] object, q q10) {
        f0.p(object, "$this$reduceIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = ((int[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Pd(object);
            if (n12 <= n11) {
                while (true) {
                    Integer n13 = n12;
                    object2 = n10;
                    int n14 = object[n12];
                    Integer n15 = n14;
                    object2 = (Number)q10.invoke(n13, object2, n15);
                    n10 = ((Number)object2).intValue();
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final Character cq(char[] cArray, p p10) {
        char c10;
        f0.p(cArray, "$this$reduceRightOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int c102 = ArraysKt___ArraysKt.Md(cArray);
        if (c102 < 0) {
            return null;
        }
        int n10 = c102 + -1;
        char c11 = cArray[c102];
        while (n10 >= 0) {
            int n11 = n10 + -1;
            Character c12 = Character.valueOf(cArray[n10]);
            object = Character.valueOf(c10);
            object = (Character)p10.invoke(c12, object);
            c10 = ((Character)object).charValue();
            n10 = n11;
        }
        return Character.valueOf(c10);
    }

    private static final List cr(boolean[] blArray, Object object, p p10) {
        ArrayList<Object> arrayList;
        int n10 = blArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int bl2 = blArray.length + n12;
        arrayList = new ArrayList<Object>(bl2);
        arrayList.add(object);
        n12 = blArray.length;
        while (n11 < n12) {
            boolean bl3 = blArray[n11];
            Boolean bl4 = bl3;
            object = p10.invoke(object, bl4);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    public static final List cs(Object[] object, p p10) {
        f0.p(object, "$this$scanReduce");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int n10 = ((Object[])object).length;
        ArrayList<Object> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            object2 = object[0];
            int n12 = ((Object[])object).length;
            arrayList = new ArrayList<Object>(n12);
            arrayList.add(object2);
            n12 = ((Object[])object).length;
            while (n11 < n12) {
                Object object3 = object[n11];
                object2 = p10.invoke(object2, object3);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Character ct(char[] object) {
        String string2 = "$this$singleOrNull";
        f0.p(object, string2);
        int n10 = ((char[])object).length;
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            string2 = null;
            char c10 = object[0];
            object = Character.valueOf(c10);
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    public static final void cu(byte[] byArray) {
        String string2 = "$this$sortDescending";
        f0.p(byArray, string2);
        int n10 = byArray.length;
        int n11 = 1;
        if (n10 > n11) {
            f.x1.n.d3(byArray);
            ArraysKt___ArraysKt.kq(byArray);
        }
    }

    public static final List cv(double[] dArray, l l10) {
        f0.p(dArray, "$this$sortedByDescending");
        f0.p(l10, "selector");
        b$d b$d = new b$d(l10);
        return ArraysKt___ArraysKt.tv(dArray, b$d);
    }

    public static final double cw(int[] nArray, l l10) {
        f0.p(nArray, "$this$sumByDouble");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = nArray.length;
        double d10 = 0.0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = nArray[i10];
            Number number = n11;
            number = (Number)l10.invoke(number);
            double d11 = number.doubleValue();
            d10 += d11;
        }
        return d10;
    }

    private static final long cx(long[] lArray, l l10) {
        long l11 = g1.h(0);
        int n10 = lArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable<Long> comparable = lArray[i10];
            comparable = (g1)l10.invoke(comparable);
            long l12 = ((g1)comparable).a0();
            l11 = g1.h(l11 + l12);
        }
        return l11;
    }

    public static final double[] cy(Double[] doubleArray) {
        String string2 = "$this$toDoubleArray";
        f0.p(doubleArray, string2);
        int n10 = doubleArray.length;
        double[] dArray = new double[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10;
            Double d11 = doubleArray[i10];
            dArray[i10] = d10 = d11.doubleValue();
        }
        return dArray;
    }

    public static final Set cz(double[] object, Iterable iterable) {
        f0.p(object, "$this$union");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Jy(object);
        y.q0((Collection)object, iterable);
        return object;
    }

    public static final m d5(double[] dArray) {
        Object object = "$this$asSequence";
        f0.p(dArray, (String)object);
        int n10 = dArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return SequencesKt__SequencesKt.j();
        }
        object = new ArraysKt___ArraysKt$p(dArray);
        return object;
    }

    public static final Map d6(byte[] byArray, Map map, l l10) {
        f0.p(byArray, "$this$associateTo");
        f0.p(map, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (byte by2 : byArray) {
            Object object = by2;
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            map.put(object2, object);
        }
        return map;
    }

    private static final int d7(int[] nArray) {
        f0.p(nArray, "$this$component2");
        return nArray[1];
    }

    public static final int d8(long[] lArray, l l10) {
        f0.p(lArray, "$this$count");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = lArray[i10];
            Constable constable = Long.valueOf(l11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            ++n11;
        }
        return n11;
    }

    public static final List d9(byte[] byArray, l l10) {
        f0.p(byArray, "$this$dropWhile");
        f0.p(l10, "predicate");
        ArrayList<Byte> arrayList = new ArrayList<Byte>();
        int n10 = byArray.length;
        boolean bl2 = false;
        Byte by2 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by3 = byArray[i10];
            if (bl2) {
                Byte by4 = by3;
                arrayList.add(by4);
                continue;
            }
            Constable constable = Byte.valueOf(by3);
            boolean bl3 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl3) continue;
            by2 = by3;
            arrayList.add(by2);
            bl2 = true;
        }
        return arrayList;
    }

    public static final List dA(Object[] objectArray, Iterable object, p p10) {
        boolean bl2;
        f0.p(objectArray, "$this$zip");
        f0.p(object, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = objectArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        n11 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            object2 = objectArray[n11];
            object2 = p10.invoke(object2, e10);
            arrayList.add(object2);
            n11 = n12;
        }
        return arrayList;
    }

    public static final Collection da(short[] sArray, Collection collection, p p10) {
        f0.p(sArray, "$this$filterIndexedTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(p10, string2);
        int n10 = sArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Short s11 = s10;
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, s11))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                constable = Short.valueOf(s10);
                collection.add(constable);
            }
            n11 = n12;
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     */
    public static final byte db(byte[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$first");
        String string2 = "predicate";
        f0.p(var1_2, string2);
        for (Object object2 : object) {
            Constable constable = Byte.valueOf((byte)object2);
            boolean bl2 = (Boolean)(constable = (Boolean)var1_2.invoke(constable));
            if (!bl2) continue;
            return (byte)object2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Array contains no element matching the predicate.");
        throw noSuchElementException;
    }

    private static final List dc(boolean[] blArray, p p10) {
        ArrayList arrayList = new ArrayList();
        int n10 = blArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = bl2;
            object = (Iterable)p10.invoke(n12, object);
            y.q0(arrayList, (Iterable)object);
        }
        return arrayList;
    }

    public static final Object dd(double[] dArray, Object object, q q10) {
        f0.p(dArray, "$this$foldRightIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        for (int i10 = ArraysKt___ArraysKt.Nd(dArray); i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            double d10 = dArray[i10];
            Double d11 = d10;
            object = q10.invoke(n10, d11, object);
        }
        return object;
    }

    public static final Boolean de(boolean[] object, int n10) {
        int n11;
        String string2 = "$this$getOrNull";
        f0.p(object, string2);
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Td(object))) {
            boolean bl2 = object[n10];
            object = bl2;
        } else {
            boolean bl3 = false;
            object = null;
        }
        return object;
    }

    public static final int df(Object[] objectArray, Object object) {
        int n10;
        f0.p(objectArray, "$this$indexOf");
        if (object == null) {
            int n11 = objectArray.length;
            for (n10 = 0; n10 < n11; ++n10) {
                Object object2 = objectArray[n10];
                if (object2 != null) continue;
                return n10;
            }
        } else {
            int n12 = objectArray.length;
            while (n10 < n12) {
                Object object3 = objectArray[n10];
                boolean bl2 = f0.g(object, object3);
                if (bl2) {
                    return n10;
                }
                ++n10;
            }
        }
        return -1;
    }

    public static final Appendable dg(int[] nArray, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(nArray, "$this$joinTo");
        f0.p(appendable, "buffer");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        appendable.append(charSequence2);
        int n11 = nArray.length;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object;
            int n13 = nArray[i10];
            int n14 = 1;
            if (++n12 > n14) {
                appendable.append(charSequence);
            }
            if (n10 >= 0 && n12 > n10) break;
            if (l10 != null) {
                object = n13;
                object = (CharSequence)l10.invoke(object);
                appendable.append((CharSequence)object);
                continue;
            }
            object = String.valueOf(n13);
            appendable.append((CharSequence)object);
        }
        if (n10 >= 0 && n12 > n10) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final int dh(double[] dArray, double d10) {
        String string2 = "$this$lastIndexOf";
        f0.p(dArray, string2);
        int n10 = dArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            double d11 = dArray[n10];
            double d12 = d10 - d11;
            Object object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
            if (object == false) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static final Collection di(short[] sArray, Collection collection, p p10) {
        f0.p(sArray, "$this$mapIndexedTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = s10;
            object = p10.invoke(n12, object);
            collection.add(object);
        }
        return collection;
    }

    private static final float dj(double[] object, l l10) {
        Number number;
        float f10;
        int n10 = ((double[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            double d10 = object[0];
            number = d10;
            number = (Number)l10.invoke(number);
            f10 = number.floatValue();
            n11 = ArraysKt___ArraysKt.Nd(object);
            if (n12 <= n11) {
                while (true) {
                    double d11 = object[n12];
                    Number number2 = d11;
                    number2 = (Number)l10.invoke(number2);
                    float f12 = number2.floatValue();
                    f10 = Math.max(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object dk(byte[] byArray, Comparator comparator, l l10) {
        Object object;
        int n10 = byArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray[0];
        object = (byte)n10;
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n12 <= n11) {
            while (true) {
                byte by2 = byArray[n12];
                Object object2 = by2;
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 < 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final Integer dl(int[] object, l l10) {
        f0.p(object, "$this$minBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = ((int[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Pd(object);
            if (n11 == 0) {
                object = n10;
            } else {
                Comparable<Integer> comparable = n10;
                comparable = (Comparable)l10.invoke(comparable);
                if (n12 <= n11) {
                    while (true) {
                        int n13 = object[n12];
                        Comparable<Integer> comparable2 = n13;
                        int n14 = comparable.compareTo((Integer)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n14 > 0) {
                            n10 = n13;
                            comparable = comparable2;
                        }
                        if (n12 == n11) break;
                        ++n12;
                    }
                }
                object = n10;
            }
        }
        return object;
    }

    private static final Double dm(float[] fArray, l l10) {
        Number number;
        float f10;
        int n10 = fArray.length;
        int n11 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n11;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        f10 = fArray[0];
        number = Float.valueOf(f10);
        number = (Number)l10.invoke(number);
        double d10 = number.doubleValue();
        int n12 = ArraysKt___ArraysKt.Od(fArray);
        if (n11 <= n12) {
            while (true) {
                float f12 = fArray[n11];
                Number number2 = Float.valueOf(f12);
                number2 = (Number)l10.invoke(number2);
                double d11 = number2.doubleValue();
                d10 = Math.min(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Boolean dn(boolean[] blArray, Comparator comparator) {
        f0.p(blArray, "$this$minWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = blArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = blArray[0];
        n11 = ArraysKt___ArraysKt.Td(blArray);
        if (n12 <= n11) {
            while (true) {
                Boolean bl2;
                int n13 = blArray[n12];
                Boolean bl3 = n10 != 0;
                int n14 = comparator.compare(bl3, bl2 = Boolean.valueOf(n13 != 0));
                if (n14 > 0) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     */
    public static final Pair do(short[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$partition");
        f0.p(var1_2, "predicate");
        ArrayList<Short> arrayList = new ArrayList<Short>();
        ArrayList<Short> arrayList2 = new ArrayList<Short>();
        for (Object object2 : object) {
            Short s10;
            Constable constable = Short.valueOf((short)object2);
            boolean bl2 = (Boolean)(constable = (Boolean)var1_2.invoke(constable));
            if (bl2) {
                s10 = (short)object2;
                arrayList.add(s10);
                continue;
            }
            s10 = (short)object2;
            arrayList2.add(s10);
        }
        Pair pair = new Pair(arrayList, arrayList2);
        return pair;
    }

    public static final long dp(long[] object, q q10) {
        f0.p(object, "$this$reduceIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = ((long[])object).length;
        Long l10 = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            long l11 = object[0];
            int n12 = ArraysKt___ArraysKt.Qd(object);
            if (n11 <= n12) {
                while (true) {
                    Integer n13 = n11;
                    object2 = l11;
                    long l12 = object[n11];
                    l10 = l12;
                    object2 = (Number)q10.invoke(n13, object2, l10);
                    l11 = ((Number)object2).longValue();
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return l11;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final Double dq(double[] dArray, p p10) {
        f0.p(dArray, "$this$reduceRightOrNull");
        String string2 = "operation";
        f0.p(p10, string2);
        int n10 = ArraysKt___ArraysKt.Nd(dArray);
        if (n10 < 0) {
            return null;
        }
        int n11 = n10 + -1;
        double d10 = dArray[n10];
        while (n11 >= 0) {
            n10 = n11 + -1;
            double d11 = dArray[n11];
            Number number = d11;
            Double d12 = d10;
            number = (Number)p10.invoke(number, d12);
            d10 = number.doubleValue();
            n11 = n10;
        }
        return d10;
    }

    private static final List dr(byte[] byArray, Object object, q q10) {
        ArrayList<Object> arrayList;
        int n10 = byArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int n13 = byArray.length + n12;
        arrayList = new ArrayList<Object>(n13);
        arrayList.add(object);
        n12 = byArray.length;
        while (n11 < n12) {
            Integer n14 = n11;
            byte by2 = byArray[n11];
            Byte by3 = by2;
            object = q10.invoke(n14, object, by3);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    private static final List ds(short[] object, p p10) {
        Ref$ShortRef ref$ShortRef;
        int n10 = ((short[])object).length;
        short s10 = 0;
        ArrayList<Short> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            ref$ShortRef = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            ref$ShortRef = new Ref$ShortRef();
            ref$ShortRef.element = s10 = object[0];
            int n12 = ((short[])object).length;
            arrayList = new ArrayList<Short>(n12);
            Short s11 = ref$ShortRef.element;
            arrayList.add(s11);
            n12 = ((short[])object).length;
            while (n11 < n12) {
                short s12;
                Short s13 = ref$ShortRef.element;
                short s14 = object[n11];
                Short s15 = s14;
                ref$ShortRef.element = s12 = ((Number)p10.invoke(s13, s15)).shortValue();
                s13 = s12;
                arrayList.add(s13);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Character dt(char[] cArray, l l10) {
        f0.p(cArray, "$this$singleOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = cArray.length;
        boolean bl2 = false;
        Character c10 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c11 = cArray[i10];
            Comparable<Character> comparable = Character.valueOf(c11);
            boolean bl3 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl3) continue;
            if (bl2) {
                return null;
            }
            c10 = Character.valueOf(c11);
            bl2 = true;
        }
        if (!bl2) {
            return null;
        }
        return c10;
    }

    public static final void du(byte[] byArray, int n10, int n11) {
        f0.p(byArray, "$this$sortDescending");
        f.x1.n.e3(byArray, n10, n11);
        ArraysKt___ArraysKt.lq(byArray, n10, n11);
    }

    public static final List dv(float[] fArray, l l10) {
        f0.p(fArray, "$this$sortedByDescending");
        f0.p(l10, "selector");
        b$d b$d = new b$d(l10);
        return ArraysKt___ArraysKt.uv(fArray, b$d);
    }

    public static final double dw(long[] lArray, l l10) {
        f0.p(lArray, "$this$sumByDouble");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = lArray.length;
        double d10 = 0.0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = lArray[i10];
            Number number = l11;
            number = (Number)l10.invoke(number);
            double d11 = number.doubleValue();
            d10 += d11;
        }
        return d10;
    }

    private static final long dx(Object[] objectArray, l l10) {
        long l11 = g1.h(0);
        for (Object object : objectArray) {
            object = (g1)l10.invoke(object);
            long l12 = ((g1)object).a0();
            l11 = g1.h(l11 + l12);
        }
        return l11;
    }

    public static final float[] dy(Float[] floatArray) {
        String string2 = "$this$toFloatArray";
        f0.p(floatArray, string2);
        int n10 = floatArray.length;
        float[] fArray = new float[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10;
            Float f11 = floatArray[i10];
            fArray[i10] = f10 = f11.floatValue();
        }
        return fArray;
    }

    public static final Set dz(float[] object, Iterable iterable) {
        f0.p(object, "$this$union");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Ky(object);
        y.q0((Collection)object, iterable);
        return object;
    }

    public static final m e5(float[] fArray) {
        Object object = "$this$asSequence";
        f0.p(fArray, (String)object);
        int n10 = fArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return SequencesKt__SequencesKt.j();
        }
        object = new ArraysKt___ArraysKt$o(fArray);
        return object;
    }

    public static final Map e6(char[] cArray, Map map, l l10) {
        f0.p(cArray, "$this$associateTo");
        f0.p(map, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            map.put(object2, object);
        }
        return map;
    }

    private static final long e7(long[] lArray) {
        f0.p(lArray, "$this$component2");
        return lArray[1];
    }

    private static final int e8(Object[] objectArray) {
        return objectArray.length;
    }

    public static final List e9(char[] cArray, l l10) {
        f0.p(cArray, "$this$dropWhile");
        f0.p(l10, "predicate");
        ArrayList<Character> arrayList = new ArrayList<Character>();
        int n10 = cArray.length;
        boolean bl2 = false;
        Character c10 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c11 = cArray[i10];
            if (bl2) {
                Character c12 = Character.valueOf(c11);
                arrayList.add(c12);
                continue;
            }
            Comparable<Character> comparable = Character.valueOf(c11);
            boolean bl3 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl3) continue;
            c10 = Character.valueOf(c11);
            arrayList.add(c10);
            bl2 = true;
        }
        return arrayList;
    }

    public static final List eA(Object[] objectArray, Object[] objectArray2) {
        f0.p(objectArray, "$this$zip");
        String string2 = "other";
        f0.p(objectArray2, string2);
        int n10 = objectArray.length;
        int n11 = objectArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            Object object2 = objectArray2[i10];
            object = w0.a(object, object2);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Collection ea(boolean[] blArray, Collection collection, p p10) {
        f0.p(blArray, "$this$filterIndexedTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(p10, string2);
        int n10 = blArray.length;
        int n11 = 0;
        Constable constable = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            int n12 = n11 + 1;
            constable = Integer.valueOf(n11);
            Boolean bl3 = bl2;
            n11 = (int)(((Boolean)(constable = (Boolean)p10.invoke(constable, bl3))).booleanValue() ? 1 : 0);
            if (n11 != 0) {
                constable = Boolean.valueOf(bl2);
                collection.add(constable);
            }
            n11 = n12;
        }
        return collection;
    }

    public static final char eb(char[] object) {
        String string2 = "$this$first";
        f0.p(object, string2);
        int n10 = ((char[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            return object[0];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    private static final Collection ec(byte[] byArray, Collection collection, p p10) {
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = by2;
            object = (Iterable)p10.invoke(n12, object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final Object ed(float[] fArray, Object object, q q10) {
        f0.p(fArray, "$this$foldRightIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        for (int i10 = ArraysKt___ArraysKt.Od(fArray); i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            float f10 = fArray[i10];
            Float f11 = Float.valueOf(f10);
            object = q10.invoke(n10, f11, object);
        }
        return object;
    }

    public static final Byte ee(byte[] object, int n10) {
        int n11;
        String string2 = "$this$getOrNull";
        f0.p(object, string2);
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Ld(object))) {
            byte by2 = object[n10];
            object = by2;
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    public static final int ef(short[] sArray, short s10) {
        String string2 = "$this$indexOf";
        f0.p(sArray, string2);
        int n10 = sArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s11 = sArray[i10];
            if (s10 != s11) continue;
            return i10;
        }
        return -1;
    }

    public static final Appendable eg(long[] lArray, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(lArray, "$this$joinTo");
        f0.p(appendable, "buffer");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        appendable.append(charSequence2);
        int n11 = lArray.length;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object;
            long l11 = lArray[i10];
            int n13 = 1;
            if (++n12 > n13) {
                appendable.append(charSequence);
            }
            if (n10 >= 0 && n12 > n10) break;
            if (l10 != null) {
                object = l11;
                object = (CharSequence)l10.invoke(object);
                appendable.append((CharSequence)object);
                continue;
            }
            object = String.valueOf(l11);
            appendable.append((CharSequence)object);
        }
        if (n10 >= 0 && n12 > n10) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final int eh(float[] fArray, float f10) {
        String string2 = "$this$lastIndexOf";
        f0.p(fArray, string2);
        int n10 = fArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            float f11 = fArray[n10];
            float f12 = f10 - f11;
            Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
            if (object == false) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static final Collection ei(boolean[] blArray, Collection collection, p p10) {
        f0.p(blArray, "$this$mapIndexedTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = blArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = bl2;
            object = p10.invoke(n12, object);
            collection.add(object);
        }
        return collection;
    }

    private static final float ej(float[] object, l l10) {
        Number number;
        float f10;
        int n10 = ((float[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            number = Float.valueOf(object[0]);
            number = (Number)l10.invoke(number);
            f10 = number.floatValue();
            n11 = ArraysKt___ArraysKt.Od(object);
            if (n12 <= n11) {
                while (true) {
                    Number number2 = Float.valueOf(object[n12]);
                    number2 = (Number)l10.invoke(number2);
                    float f12 = number2.floatValue();
                    f10 = Math.max(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object ek(char[] cArray, Comparator comparator, l l10) {
        Object object;
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray[0];
        object = Character.valueOf((char)n10);
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Md(cArray);
        if (n12 <= n11) {
            while (true) {
                char c10 = cArray[n12];
                Object object2 = Character.valueOf(c10);
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 < 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final Long el(long[] object, l l10) {
        f0.p(object, "$this$minBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = ((long[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            long l11 = object[0];
            int n12 = ArraysKt___ArraysKt.Qd(object);
            if (n12 == 0) {
                object = l11;
            } else {
                Comparable<Long> comparable = l11;
                comparable = (Comparable)l10.invoke(comparable);
                if (n11 <= n12) {
                    while (true) {
                        long l12 = object[n11];
                        Comparable<Long> comparable2 = l12;
                        int n13 = comparable.compareTo((Long)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n13 > 0) {
                            l11 = l12;
                            comparable = comparable2;
                        }
                        if (n11 == n12) break;
                        ++n11;
                    }
                }
                object = l11;
            }
        }
        return object;
    }

    private static final Double em(int[] nArray, l l10) {
        Number number;
        int n10 = nArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray[0];
        number = n10;
        number = (Number)l10.invoke(number);
        double d10 = number.doubleValue();
        int n12 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 <= n12) {
            while (true) {
                int n13 = nArray[n11];
                Number number2 = n13;
                number2 = (Number)l10.invoke(number2);
                double d11 = number2.doubleValue();
                d10 = Math.min(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Byte en(byte[] byArray, Comparator comparator) {
        f0.p(byArray, "$this$minWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = byArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray[0];
        n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n12 <= n11) {
            while (true) {
                Byte by2;
                int n13 = byArray[n12];
                Byte by3 = (byte)n10;
                int n14 = comparator.compare(by3, by2 = Byte.valueOf((byte)n13));
                if (n14 > 0) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return (byte)n10;
    }

    /*
     * WARNING - void declaration
     */
    public static final Pair eo(boolean[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$partition");
        f0.p(var1_2, "predicate");
        ArrayList<Boolean> arrayList = new ArrayList<Boolean>();
        ArrayList<Boolean> arrayList2 = new ArrayList<Boolean>();
        for (Object object2 : object) {
            Boolean bl2;
            Boolean bl3 = (boolean)object2;
            boolean bl4 = bl3 = (Boolean)var1_2.invoke(bl3);
            if (bl4) {
                bl2 = (boolean)object2;
                arrayList.add(bl2);
                continue;
            }
            bl2 = (boolean)object2;
            arrayList2.add(bl2);
        }
        Pair pair = new Pair(arrayList, arrayList2);
        return pair;
    }

    public static final Object ep(Object[] objectArray, q q10) {
        f0.p(objectArray, "$this$reduceIndexed");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 == 0) {
            object = objectArray[0];
            n11 = ArraysKt___ArraysKt.Rd(objectArray);
            if (n12 <= n11) {
                while (true) {
                    Integer n13 = n12;
                    Object object2 = objectArray[n12];
                    object = q10.invoke(n13, object, object2);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object;
        }
        objectArray = new UnsupportedOperationException("Empty array can't be reduced.");
        throw objectArray;
    }

    public static final Float eq(float[] fArray, p p10) {
        f0.p(fArray, "$this$reduceRightOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = ArraysKt___ArraysKt.Od(fArray);
        if (n10 < 0) {
            return null;
        }
        int n11 = n10 + -1;
        float f10 = fArray[n10];
        while (n11 >= 0) {
            int n12 = n11 + -1;
            float f11 = fArray[n11];
            Float f12 = Float.valueOf(f11);
            object = Float.valueOf(f10);
            object = (Number)p10.invoke(f12, object);
            f10 = ((Number)object).floatValue();
            n11 = n12;
        }
        return Float.valueOf(f10);
    }

    private static final List er(char[] cArray, Object object, q q10) {
        ArrayList<Object> arrayList;
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int n13 = cArray.length + n12;
        arrayList = new ArrayList<Object>(n13);
        arrayList.add(object);
        n12 = cArray.length;
        while (n11 < n12) {
            Integer n14 = n11;
            char c10 = cArray[n11];
            Character c11 = Character.valueOf(c10);
            object = q10.invoke(n14, object, c11);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    private static final List es(boolean[] object, p p10) {
        Ref$BooleanRef ref$BooleanRef;
        int n10 = ((boolean[])object).length;
        boolean bl2 = false;
        ArrayList<Boolean> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            ref$BooleanRef = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            ref$BooleanRef = new Ref$BooleanRef();
            ref$BooleanRef.element = bl2 = object[0];
            int n12 = ((boolean[])object).length;
            arrayList = new ArrayList<Boolean>(n12);
            Boolean bl3 = ref$BooleanRef.element;
            arrayList.add(bl3);
            n12 = ((boolean[])object).length;
            while (n11 < n12) {
                boolean bl4;
                Boolean bl5 = ref$BooleanRef.element;
                boolean bl6 = object[n11];
                Boolean bl7 = bl6;
                ref$BooleanRef.element = bl4 = ((Boolean)p10.invoke(bl5, bl7)).booleanValue();
                bl5 = bl4;
                arrayList.add(bl5);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Double et(double[] object) {
        String string2 = "$this$singleOrNull";
        f0.p(object, string2);
        int n10 = ((double[])object).length;
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            string2 = null;
            double d10 = object[0];
            object = d10;
        } else {
            object = null;
        }
        return object;
    }

    public static final void eu(char[] cArray) {
        String string2 = "$this$sortDescending";
        f0.p(cArray, string2);
        int n10 = cArray.length;
        int n11 = 1;
        if (n10 > n11) {
            f.x1.n.f3(cArray);
            ArraysKt___ArraysKt.mq(cArray);
        }
    }

    public static final List ev(int[] nArray, l l10) {
        f0.p(nArray, "$this$sortedByDescending");
        f0.p(l10, "selector");
        b$d b$d = new b$d(l10);
        return ArraysKt___ArraysKt.vv(nArray, b$d);
    }

    public static final double ew(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$sumByDouble");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = objectArray.length;
        double d10 = 0.0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            object = (Number)l10.invoke(object);
            double d11 = ((Number)object).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    private static final long ex(short[] sArray, l l10) {
        long l11 = g1.h(0);
        for (short s10 : sArray) {
            Comparable<Short> comparable = s10;
            comparable = (g1)l10.invoke(comparable);
            long l12 = ((g1)comparable).a0();
            l11 = g1.h(l11 + l12);
        }
        return l11;
    }

    public static final HashSet ey(byte[] byArray) {
        f0.p(byArray, "$this$toHashSet");
        int n10 = s0.j(byArray.length);
        HashSet hashSet = new HashSet(n10);
        return (HashSet)ArraysKt___ArraysKt.Tx(byArray, hashSet);
    }

    public static final Set ez(int[] object, Iterable iterable) {
        f0.p(object, "$this$union");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Ly(object);
        y.q0((Collection)object, iterable);
        return object;
    }

    public static final m f5(int[] nArray) {
        Object object = "$this$asSequence";
        f0.p(nArray, (String)object);
        int n10 = nArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return SequencesKt__SequencesKt.j();
        }
        object = new ArraysKt___ArraysKt$m(nArray);
        return object;
    }

    public static final Map f6(double[] dArray, Map map, l l10) {
        f0.p(dArray, "$this$associateTo");
        f0.p(map, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (double d10 : dArray) {
            Object object = d10;
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            map.put(object2, object);
        }
        return map;
    }

    private static final Object f7(Object[] objectArray) {
        f0.p(objectArray, "$this$component2");
        return objectArray[1];
    }

    public static final int f8(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$count");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = objectArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            boolean bl2 = (Boolean)(object = (Boolean)l10.invoke(object));
            if (!bl2) continue;
            ++n11;
        }
        return n11;
    }

    public static final List f9(double[] dArray, l l10) {
        f0.p(dArray, "$this$dropWhile");
        f0.p(l10, "predicate");
        ArrayList<Double> arrayList = new ArrayList<Double>();
        int n10 = dArray.length;
        boolean bl2 = false;
        Double d10 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d11 = dArray[i10];
            if (bl2) {
                Double d12 = d11;
                arrayList.add(d12);
                continue;
            }
            Constable constable = Double.valueOf(d11);
            boolean bl3 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl3) continue;
            d10 = d11;
            arrayList.add(d10);
            bl2 = true;
        }
        return arrayList;
    }

    public static final List fA(Object[] objectArray, Object[] objectArray2, p p10) {
        f0.p(objectArray, "$this$zip");
        f0.p(objectArray2, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = objectArray.length;
        int n11 = objectArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            Object object2 = objectArray2[i10];
            object = p10.invoke(object, object2);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final /* synthetic */ List fa(Object[] objectArray) {
        f0.p(objectArray, "$this$filterIsInstance");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (Object object : objectArray) {
            String string2 = "R";
            f0.y(3, string2);
            boolean bl2 = object instanceof Object;
            if (!bl2) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    /*
     * WARNING - void declaration
     */
    public static final char fb(char[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$first");
        String string2 = "predicate";
        f0.p(var1_2, string2);
        for (Object object2 : object) {
            Comparable<Character> comparable = Character.valueOf((char)object2);
            boolean bl2 = (Boolean)(comparable = (Boolean)var1_2.invoke(comparable));
            if (!bl2) continue;
            return (char)object2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Array contains no element matching the predicate.");
        throw noSuchElementException;
    }

    private static final Collection fc(char[] cArray, Collection collection, p p10) {
        int n10 = cArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = cArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = Character.valueOf(c10);
            object = (Iterable)p10.invoke(n12, object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final Object fd(int[] nArray, Object object, q q10) {
        f0.p(nArray, "$this$foldRightIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        for (int i10 = ArraysKt___ArraysKt.Pd(nArray); i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            int n11 = nArray[i10];
            Integer n12 = n11;
            object = q10.invoke(n10, n12, object);
        }
        return object;
    }

    public static final Character fe(char[] object, int n10) {
        int n11;
        String string2 = "$this$getOrNull";
        f0.p(object, string2);
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Md(object))) {
            char c10 = object[n10];
            object = Character.valueOf(c10);
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    public static final int ff(boolean[] blArray, boolean bl2) {
        String string2 = "$this$indexOf";
        f0.p(blArray, string2);
        int n10 = blArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl3 = blArray[i10];
            if (bl2 != bl3) continue;
            return i10;
        }
        return -1;
    }

    public static final Appendable fg(Object[] objectArray, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(objectArray, "$this$joinTo");
        f0.p(appendable, "buffer");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        appendable.append(charSequence2);
        int n11 = objectArray.length;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object = objectArray[i10];
            int n13 = 1;
            if (++n12 > n13) {
                appendable.append(charSequence);
            }
            if (n10 >= 0 && n12 > n10) break;
            n.b(appendable, object, l10);
        }
        if (n10 >= 0 && n12 > n10) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final int fh(int[] nArray, int n10) {
        String string2 = "$this$lastIndexOf";
        f0.p(nArray, string2);
        int n11 = nArray.length;
        int n12 = -1;
        n11 += n12;
        while (n11 >= 0) {
            int n13 = nArray[n11];
            if (n10 == n13) {
                return n11;
            }
            n11 += -1;
        }
        return n12;
    }

    public static final List fi(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$mapNotNull");
        f0.p(l10, "transform");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (Object object : objectArray) {
            if ((object = l10.invoke(object)) == null) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final float fj(int[] object, l l10) {
        Number number;
        float f10;
        int n10 = ((int[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            n10 = object[0];
            number = n10;
            number = (Number)l10.invoke(number);
            f10 = number.floatValue();
            n11 = ArraysKt___ArraysKt.Pd(object);
            if (n12 <= n11) {
                while (true) {
                    int n13 = object[n12];
                    Number number2 = n13;
                    number2 = (Number)l10.invoke(number2);
                    float f12 = number2.floatValue();
                    f10 = Math.max(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object fk(double[] dArray, Comparator comparator, l l10) {
        Object object;
        int n10 = dArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        double d10 = dArray[0];
        object = d10;
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Nd(dArray);
        if (n12 <= n11) {
            while (true) {
                double d11 = dArray[n12];
                Object object2 = d11;
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 < 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static final Object fl(Object[] objectArray, l l10) {
        void var0_3;
        void var1_4;
        f0.p(objectArray, "$this$minBy");
        Object object = "selector";
        f0.p(var1_4, (String)object);
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return var0_3;
        }
        object = objectArray[0];
        n11 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n11 != 0) {
            Comparable comparable = (Comparable)var1_4.invoke(object);
            if (n12 <= n11) {
                while (true) {
                    Object object2;
                    Comparable comparable2;
                    int n13;
                    if ((n13 = comparable.compareTo(comparable2 = (Comparable)var1_4.invoke(object2 = objectArray[n12]))) > 0) {
                        object = object2;
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
        }
        Object object3 = object;
        return var0_3;
    }

    private static final Double fm(long[] lArray, l l10) {
        Number number;
        int n10 = lArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return null;
        }
        long l11 = lArray[0];
        number = l11;
        number = (Number)l10.invoke(number);
        double d10 = number.doubleValue();
        int n12 = ArraysKt___ArraysKt.Qd(lArray);
        if (n11 <= n12) {
            while (true) {
                long l12 = lArray[n11];
                Number number2 = l12;
                number2 = (Number)l10.invoke(number2);
                double d11 = number2.doubleValue();
                d10 = Math.min(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Character fn(char[] cArray, Comparator comparator) {
        f0.p(cArray, "$this$minWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray[0];
        n11 = ArraysKt___ArraysKt.Md(cArray);
        if (n12 <= n11) {
            while (true) {
                Character c10;
                int n13 = cArray[n12];
                Character c11 = Character.valueOf((char)n10);
                int n14 = comparator.compare(c11, c10 = Character.valueOf((char)n13));
                if (n14 > 0) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Character.valueOf((char)n10);
    }

    private static final byte fo(byte[] byArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.go(byArray, e$a);
    }

    public static final short fp(short[] object, q q10) {
        f0.p(object, "$this$reduceIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = ((short[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Sd(object);
            if (n12 <= n11) {
                while (true) {
                    Integer n13 = n12;
                    object2 = (short)n10;
                    short s10 = object[n12];
                    Short s11 = s10;
                    object2 = (Number)q10.invoke(n13, object2, s11);
                    n10 = ((Number)object2).shortValue();
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return (short)n10;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final Integer fq(int[] nArray, p p10) {
        f0.p(nArray, "$this$reduceRightOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = ArraysKt___ArraysKt.Pd(nArray);
        if (n10 < 0) {
            return null;
        }
        int n11 = n10 + -1;
        n10 = nArray[n10];
        while (n11 >= 0) {
            int n12 = n11 + -1;
            Integer n13 = nArray[n11];
            object = n10;
            object = (Number)p10.invoke(n13, object);
            n10 = ((Number)object).intValue();
            n11 = n12;
        }
        return n10;
    }

    private static final List fr(double[] dArray, Object object, q q10) {
        ArrayList<Object> arrayList;
        int n10 = dArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int n13 = dArray.length + n12;
        arrayList = new ArrayList<Object>(n13);
        arrayList.add(object);
        n12 = dArray.length;
        while (n11 < n12) {
            Integer n14 = n11;
            double d10 = dArray[n11];
            Double d11 = d10;
            object = q10.invoke(n14, object, d11);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    private static final List fs(byte[] object, q q10) {
        Ref$ByteRef ref$ByteRef;
        int n10 = ((byte[])object).length;
        byte by2 = 0;
        ArrayList<Number> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            ref$ByteRef = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            ref$ByteRef = new Ref$ByteRef();
            ref$ByteRef.element = by2 = object[0];
            int n12 = ((byte[])object).length;
            arrayList = new ArrayList<Number>(n12);
            Byte by3 = ref$ByteRef.element;
            arrayList.add(by3);
            n12 = ((byte[])object).length;
            while (n11 < n12) {
                byte by4;
                Number number = n11;
                byte by5 = ref$ByteRef.element;
                Byte by6 = by5;
                byte by7 = object[n11];
                Byte by8 = by7;
                ref$ByteRef.element = by4 = ((Number)q10.invoke(number, by6, by8)).byteValue();
                number = by4;
                arrayList.add(number);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Double ft(double[] dArray, l l10) {
        f0.p(dArray, "$this$singleOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = dArray.length;
        boolean bl2 = false;
        Double d10 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d11 = dArray[i10];
            Constable constable = Double.valueOf(d11);
            boolean bl3 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl3) continue;
            if (bl2) {
                return null;
            }
            d10 = d11;
            bl2 = true;
        }
        if (!bl2) {
            return null;
        }
        return d10;
    }

    public static final void fu(char[] cArray, int n10, int n11) {
        f0.p(cArray, "$this$sortDescending");
        f.x1.n.g3(cArray, n10, n11);
        ArraysKt___ArraysKt.nq(cArray, n10, n11);
    }

    public static final List fv(long[] lArray, l l10) {
        f0.p(lArray, "$this$sortedByDescending");
        f0.p(l10, "selector");
        b$d b$d = new b$d(l10);
        return ArraysKt___ArraysKt.wv(lArray, b$d);
    }

    public static final double fw(short[] sArray, l l10) {
        f0.p(sArray, "$this$sumByDouble");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = sArray.length;
        double d10 = 0.0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Number number = s10;
            number = (Number)l10.invoke(number);
            double d11 = number.doubleValue();
            d10 += d11;
        }
        return d10;
    }

    private static final long fx(boolean[] blArray, l l10) {
        long l11 = g1.h(0);
        for (boolean bl2 : blArray) {
            Comparable<Boolean> comparable = bl2;
            comparable = (g1)l10.invoke(comparable);
            long l12 = ((g1)comparable).a0();
            l11 = g1.h(l11 + l12);
        }
        return l11;
    }

    public static final HashSet fy(char[] cArray) {
        f0.p(cArray, "$this$toHashSet");
        int n10 = s0.j(f.l2.q.u(cArray.length, 128));
        HashSet hashSet = new HashSet(n10);
        return (HashSet)ArraysKt___ArraysKt.Ux(cArray, hashSet);
    }

    public static final Set fz(long[] object, Iterable iterable) {
        f0.p(object, "$this$union");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.My(object);
        y.q0((Collection)object, iterable);
        return object;
    }

    public static final m g5(long[] lArray) {
        Object object = "$this$asSequence";
        f0.p(lArray, (String)object);
        int n10 = lArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return SequencesKt__SequencesKt.j();
        }
        object = new ArraysKt___ArraysKt$n(lArray);
        return object;
    }

    public static final Map g6(float[] fArray, Map map, l l10) {
        f0.p(fArray, "$this$associateTo");
        f0.p(map, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            map.put(object2, object);
        }
        return map;
    }

    private static final short g7(short[] sArray) {
        f0.p(sArray, "$this$component2");
        return sArray[1];
    }

    private static final int g8(short[] sArray) {
        return sArray.length;
    }

    public static final List g9(float[] fArray, l l10) {
        f0.p(fArray, "$this$dropWhile");
        f0.p(l10, "predicate");
        ArrayList<Float> arrayList = new ArrayList<Float>();
        int n10 = fArray.length;
        boolean bl2 = false;
        Float f10 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f11 = fArray[i10];
            if (bl2) {
                Float f12 = Float.valueOf(f11);
                arrayList.add(f12);
                continue;
            }
            Constable constable = Float.valueOf(f11);
            boolean bl3 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl3) continue;
            f10 = Float.valueOf(f11);
            arrayList.add(f10);
            bl2 = true;
        }
        return arrayList;
    }

    public static final List gA(short[] sArray, Iterable object) {
        boolean bl2;
        f0.p(sArray, "$this$zip");
        String string2 = "other";
        f0.p(object, string2);
        int n10 = sArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n11);
        object = object.iterator();
        n11 = 0;
        Pair pair = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            pair = w0.a(sArray[n11], e10);
            arrayList.add(pair);
            n11 = n12;
        }
        return arrayList;
    }

    public static final /* synthetic */ Collection ga(Object[] objectArray, Collection collection) {
        f0.p(objectArray, "$this$filterIsInstanceTo");
        String string2 = "destination";
        f0.p(collection, string2);
        for (Object object : objectArray) {
            String string3 = "R";
            f0.y(3, string3);
            boolean bl2 = object instanceof Object;
            if (!bl2) continue;
            collection.add(object);
        }
        return collection;
    }

    public static final double gb(double[] object) {
        String string2 = "$this$first";
        f0.p(object, string2);
        int n10 = ((double[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            return object[0];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    private static final Collection gc(double[] dArray, Collection collection, p p10) {
        int n10 = dArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = d10;
            object = (Iterable)p10.invoke(n12, object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final Object gd(long[] lArray, Object object, q q10) {
        f0.p(lArray, "$this$foldRightIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        for (int i10 = ArraysKt___ArraysKt.Qd(lArray); i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            long l10 = lArray[i10];
            Long l11 = l10;
            object = q10.invoke(n10, l11, object);
        }
        return object;
    }

    public static final Double ge(double[] object, int n10) {
        int n11;
        String string2 = "$this$getOrNull";
        f0.p(object, string2);
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Nd(object))) {
            double d10 = object[n10];
            object = d10;
        } else {
            object = null;
        }
        return object;
    }

    public static final int gf(byte[] byArray, l l10) {
        f0.p(byArray, "$this$indexOfFirst");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = byArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Constable constable = Byte.valueOf(byArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return i10;
        }
        return -1;
    }

    public static final Appendable gg(short[] sArray, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(sArray, "$this$joinTo");
        f0.p(appendable, "buffer");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        appendable.append(charSequence2);
        int n11 = sArray.length;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object;
            short s10 = sArray[i10];
            int n13 = 1;
            if (++n12 > n13) {
                appendable.append(charSequence);
            }
            if (n10 >= 0 && n12 > n10) break;
            if (l10 != null) {
                object = s10;
                object = (CharSequence)l10.invoke(object);
                appendable.append((CharSequence)object);
                continue;
            }
            object = String.valueOf(s10);
            appendable.append((CharSequence)object);
        }
        if (n10 >= 0 && n12 > n10) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final int gh(long[] lArray, long l10) {
        String string2 = "$this$lastIndexOf";
        f0.p(lArray, string2);
        int n10 = lArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            long l11 = lArray[n10];
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object == false) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static final Collection gi(Object[] objectArray, Collection collection, l l10) {
        f0.p(objectArray, "$this$mapNotNullTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (Object object : objectArray) {
            if ((object = l10.invoke(object)) == null) continue;
            collection.add(object);
        }
        return collection;
    }

    private static final float gj(long[] object, l l10) {
        Number number;
        float f10;
        int n10 = ((long[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            long l11 = object[0];
            number = l11;
            number = (Number)l10.invoke(number);
            f10 = number.floatValue();
            n11 = ArraysKt___ArraysKt.Qd(object);
            if (n12 <= n11) {
                while (true) {
                    long l12 = object[n12];
                    Number number2 = l12;
                    number2 = (Number)l10.invoke(number2);
                    float f12 = number2.floatValue();
                    f10 = Math.max(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object gk(float[] fArray, Comparator comparator, l l10) {
        Object object;
        float f10;
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            object = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        f10 = fArray[0];
        object = Float.valueOf(f10);
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Od(fArray);
        if (n12 <= n11) {
            while (true) {
                float f12 = fArray[n12];
                Object object2 = Float.valueOf(f12);
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 < 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final Short gl(short[] object, l l10) {
        f0.p(object, "$this$minBy");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = ((short[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Sd(object);
            if (n11 == 0) {
                object = (short)n10;
            } else {
                Comparable<Short> comparable = (short)n10;
                comparable = (Comparable)l10.invoke(comparable);
                if (n12 <= n11) {
                    while (true) {
                        int n13 = object[n12];
                        Comparable<Short> comparable2 = (short)n13;
                        int n14 = comparable.compareTo((Short)(comparable2 = (Comparable)l10.invoke(comparable2)));
                        if (n14 > 0) {
                            n10 = n13;
                            comparable = comparable2;
                        }
                        if (n12 == n11) break;
                        ++n12;
                    }
                }
                object = (short)n10;
            }
        }
        return object;
    }

    private static final Double gm(Object[] objectArray, l l10) {
        Object object;
        int n10 = objectArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        object = objectArray[0];
        object = (Number)l10.invoke(object);
        double d10 = ((Number)object).doubleValue();
        int n12 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n11 <= n12) {
            while (true) {
                Object object2 = objectArray[n11];
                object2 = (Number)l10.invoke(object2);
                double d11 = ((Number)object2).doubleValue();
                d10 = Math.min(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Double gn(double[] dArray, Comparator comparator) {
        f0.p(dArray, "$this$minWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = dArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        double d10 = dArray[0];
        int n12 = ArraysKt___ArraysKt.Nd(dArray);
        if (n11 <= n12) {
            while (true) {
                Double d11;
                double d12 = dArray[n11];
                Double d13 = d10;
                int n13 = comparator.compare(d13, d11 = Double.valueOf(d12));
                if (n13 > 0) {
                    d10 = d12;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final byte go(byte[] object, e e10) {
        f0.p(object, "$this$random");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = ((byte[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ((byte[])object).length;
            int n11 = e10.m(n10);
            return object[n11];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final boolean gp(boolean[] object, q q10) {
        f0.p(object, "$this$reduceIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = ((boolean[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            n11 = ArraysKt___ArraysKt.Td(object);
            if (n12 <= n11) {
                while (true) {
                    Integer n13 = n12;
                    object2 = n10 != 0;
                    boolean bl2 = object[n12];
                    Boolean bl3 = bl2;
                    object2 = (Boolean)q10.invoke(n13, object2, bl3);
                    n10 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return n10 != 0;
        }
        object = new UnsupportedOperationException;
        object("Empty array can't be reduced.");
        throw object;
    }

    public static final Long gq(long[] lArray, p p10) {
        f0.p(lArray, "$this$reduceRightOrNull");
        String string2 = "operation";
        f0.p(p10, string2);
        int n10 = ArraysKt___ArraysKt.Qd(lArray);
        if (n10 < 0) {
            return null;
        }
        int n11 = n10 + -1;
        long l10 = lArray[n10];
        while (n11 >= 0) {
            n10 = n11 + -1;
            long l11 = lArray[n11];
            Number number = l11;
            Long l12 = l10;
            number = (Number)p10.invoke(number, l12);
            l10 = number.longValue();
            n11 = n10;
        }
        return l10;
    }

    private static final List gr(float[] fArray, Object object, q q10) {
        ArrayList<Object> arrayList;
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int n13 = fArray.length + n12;
        arrayList = new ArrayList<Object>(n13);
        arrayList.add(object);
        n12 = fArray.length;
        while (n11 < n12) {
            Integer n14 = n11;
            float f10 = fArray[n11];
            Float f11 = Float.valueOf(f10);
            object = q10.invoke(n14, object, f11);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    private static final List gs(char[] object, q q10) {
        Ref$CharRef ref$CharRef;
        int n10 = ((char[])object).length;
        char c10 = '\u0000';
        ArrayList<Comparable<Character>> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            ref$CharRef = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            ref$CharRef = new Ref$CharRef();
            ref$CharRef.element = c10 = object[0];
            int n12 = ((char[])object).length;
            arrayList = new ArrayList<Comparable<Character>>(n12);
            Character c11 = Character.valueOf(ref$CharRef.element);
            arrayList.add(c11);
            n12 = ((char[])object).length;
            while (n11 < n12) {
                char c12;
                Constable constable = n11;
                char c13 = ref$CharRef.element;
                Character c14 = Character.valueOf(c13);
                char c15 = object[n11];
                Character c16 = Character.valueOf(c15);
                ref$CharRef.element = c12 = ((Character)q10.invoke(constable, c14, c16)).charValue();
                constable = Character.valueOf(c12);
                arrayList.add((Comparable<Character>)((Object)constable));
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Float gt(float[] object) {
        String string2 = "$this$singleOrNull";
        f0.p(object, string2);
        int n10 = ((float[])object).length;
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            string2 = null;
            float f10 = object[0];
            object = Float.valueOf(f10);
        } else {
            float f11 = 0.0f;
            object = null;
        }
        return object;
    }

    public static final void gu(double[] dArray) {
        String string2 = "$this$sortDescending";
        f0.p(dArray, string2);
        int n10 = dArray.length;
        int n11 = 1;
        if (n10 > n11) {
            f.x1.n.h3(dArray);
            ArraysKt___ArraysKt.oq(dArray);
        }
    }

    public static final List gv(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$sortedByDescending");
        f0.p(l10, "selector");
        b$d b$d = new b$d(l10);
        return ArraysKt___ArraysKt.xv(objectArray, b$d);
    }

    public static final double gw(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$sumByDouble");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = blArray.length;
        double d10 = 0.0;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            Serializable serializable = Boolean.valueOf(bl2);
            serializable = (Number)l10.invoke(serializable);
            double d11 = ((Number)serializable).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final List gx(byte[] object, int n10) {
        ArrayList<Byte> arrayList;
        int n11;
        String string2 = "$this$take";
        f0.p(object, string2);
        int n12 = 1;
        int n13 = 0;
        if (n10 >= 0) {
            n11 = n12;
        } else {
            n11 = 0;
            arrayList = null;
        }
        if (n11 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n11 = ((byte[])object).length;
            if (n10 >= n11) {
                return ArraysKt___ArraysKt.oy((byte[])object);
            }
            if (n10 == n12) {
                return t.k((byte)object[0]);
            }
            arrayList = new ArrayList<Byte>(n10);
            int n14 = ((Object)object).length;
            int n15 = 0;
            while (n13 < n14) {
                Object object2 = object[n13];
                Byte by2 = (byte)object2;
                arrayList.add(by2);
                if ((n15 += n12) == n10) break;
                ++n13;
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final HashSet gy(double[] dArray) {
        f0.p(dArray, "$this$toHashSet");
        int n10 = s0.j(dArray.length);
        HashSet hashSet = new HashSet(n10);
        return (HashSet)ArraysKt___ArraysKt.Vx(dArray, hashSet);
    }

    public static final Set gz(Object[] object, Iterable iterable) {
        f0.p(object, "$this$union");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Ny(object);
        y.q0((Collection)object, iterable);
        return object;
    }

    public static final m h5(Object[] objectArray) {
        Object object = "$this$asSequence";
        f0.p(objectArray, (String)object);
        int n10 = objectArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return SequencesKt__SequencesKt.j();
        }
        object = new ArraysKt___ArraysKt$j(objectArray);
        return object;
    }

    public static final Map h6(int[] nArray, Map map, l l10) {
        f0.p(nArray, "$this$associateTo");
        f0.p(map, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (int n10 : nArray) {
            Object object = n10;
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            map.put(object2, object);
        }
        return map;
    }

    private static final boolean h7(boolean[] blArray) {
        f0.p(blArray, "$this$component2");
        return blArray[1];
    }

    public static final int h8(short[] sArray, l l10) {
        f0.p(sArray, "$this$count");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Constable constable = Short.valueOf(sArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            ++n11;
        }
        return n11;
    }

    public static final List h9(int[] nArray, l l10) {
        f0.p(nArray, "$this$dropWhile");
        f0.p(l10, "predicate");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n10 = nArray.length;
        boolean bl2 = false;
        Integer n11 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            if (bl2) {
                Integer n13 = n12;
                arrayList.add(n13);
                continue;
            }
            Constable constable = Integer.valueOf(n12);
            boolean bl3 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl3) continue;
            n11 = n12;
            arrayList.add(n11);
            bl2 = true;
        }
        return arrayList;
    }

    public static final List hA(short[] sArray, Iterable object, p p10) {
        boolean bl2;
        f0.p(sArray, "$this$zip");
        f0.p(object, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = sArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        n11 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            object2 = sArray[n11];
            object2 = p10.invoke(object2, e10);
            arrayList.add(object2);
            n11 = n12;
        }
        return arrayList;
    }

    public static final List ha(byte[] byArray, l l10) {
        f0.p(byArray, "$this$filterNot");
        f0.p(l10, "predicate");
        ArrayList<Byte> arrayList = new ArrayList<Byte>();
        for (byte by2 : byArray) {
            Constable constable = Byte.valueOf(by2);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            Byte by3 = by2;
            arrayList.add(by3);
        }
        return arrayList;
    }

    /*
     * WARNING - void declaration
     */
    public static final double hb(double[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$first");
        String string2 = "predicate";
        f0.p(var1_2, string2);
        for (Object object2 : object) {
            Constable constable = Double.valueOf((double)object2);
            boolean bl2 = (Boolean)(constable = (Boolean)var1_2.invoke(constable));
            if (!bl2) continue;
            return (double)object2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Array contains no element matching the predicate.");
        throw noSuchElementException;
    }

    private static final Collection hc(float[] fArray, Collection collection, p p10) {
        int n10 = fArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = Float.valueOf(f10);
            object = (Iterable)p10.invoke(n12, object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final Object hd(Object[] objectArray, Object object, q q10) {
        f0.p(objectArray, "$this$foldRightIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        for (int i10 = ArraysKt___ArraysKt.Rd(objectArray); i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            Object object2 = objectArray[i10];
            object = q10.invoke(n10, object2, object);
        }
        return object;
    }

    public static final Float he(float[] object, int n10) {
        int n11;
        String string2 = "$this$getOrNull";
        f0.p(object, string2);
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Od(object))) {
            float f10 = object[n10];
            object = Float.valueOf(f10);
        } else {
            float f11 = 0.0f;
            object = null;
        }
        return object;
    }

    public static final int hf(char[] cArray, l l10) {
        f0.p(cArray, "$this$indexOfFirst");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = cArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable<Character> comparable = Character.valueOf(cArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return i10;
        }
        return -1;
    }

    public static final Appendable hg(boolean[] blArray, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(blArray, "$this$joinTo");
        f0.p(appendable, "buffer");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        appendable.append(charSequence2);
        int n11 = blArray.length;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object;
            boolean bl2 = blArray[i10];
            int n13 = 1;
            if (++n12 > n13) {
                appendable.append(charSequence);
            }
            if (n10 >= 0 && n12 > n10) break;
            if (l10 != null) {
                object = bl2;
                object = (CharSequence)l10.invoke(object);
                appendable.append((CharSequence)object);
                continue;
            }
            object = String.valueOf(bl2);
            appendable.append((CharSequence)object);
        }
        if (n10 >= 0 && n12 > n10) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final int hh(Object[] objectArray, Object object) {
        String string2 = "$this$lastIndexOf";
        f0.p(objectArray, string2);
        int n10 = -1;
        if (object == null) {
            for (int i10 = objectArray.length + n10; i10 >= 0; i10 += -1) {
                Object object2 = objectArray[i10];
                if (object2 != null) continue;
                return i10;
            }
        } else {
            for (int i11 = objectArray.length + n10; i11 >= 0; i11 += -1) {
                Object object3 = objectArray[i11];
                boolean bl2 = f0.g(object, object3);
                if (!bl2) continue;
                return i11;
            }
        }
        return n10;
    }

    public static final Collection hi(byte[] byArray, Collection collection, l l10) {
        f0.p(byArray, "$this$mapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (byte by2 : byArray) {
            Object object = by2;
            object = l10.invoke(object);
            collection.add(object);
        }
        return collection;
    }

    private static final float hj(Object[] objectArray, l l10) {
        Object object;
        float f10;
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            object = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            object = objectArray[0];
            object = (Number)l10.invoke(object);
            f10 = ((Number)object).floatValue();
            n11 = ArraysKt___ArraysKt.Rd(objectArray);
            if (n12 <= n11) {
                while (true) {
                    Object object2 = objectArray[n12];
                    object2 = (Number)l10.invoke(object2);
                    float f12 = ((Number)object2).floatValue();
                    f10 = Math.max(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        objectArray = new NoSuchElementException();
        throw objectArray;
    }

    private static final Object hk(int[] nArray, Comparator comparator, l l10) {
        Object object;
        int n10 = nArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray[0];
        object = n10;
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Pd(nArray);
        if (n12 <= n11) {
            while (true) {
                int n13 = nArray[n12];
                Object object2 = n13;
                int n14 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n14 < 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final Boolean hl(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$minByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = blArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = blArray[0];
        n11 = ArraysKt___ArraysKt.Td(blArray);
        if (n11 == 0) {
            return n10 != 0;
        }
        Comparable<Boolean> comparable = n10 != 0;
        comparable = (Comparable)l10.invoke(comparable);
        if (n12 <= n11) {
            while (true) {
                int n13 = blArray[n12];
                Comparable<Boolean> comparable2 = n13 != 0;
                int n14 = comparable.compareTo((Boolean)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n14 > 0) {
                    n10 = n13;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return n10 != 0;
    }

    private static final Double hm(short[] sArray, l l10) {
        Number number;
        int n10 = sArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray[0];
        number = (short)n10;
        number = (Number)l10.invoke(number);
        double d10 = number.doubleValue();
        int n12 = ArraysKt___ArraysKt.Sd(sArray);
        if (n11 <= n12) {
            while (true) {
                short s10 = sArray[n11];
                Number number2 = s10;
                number2 = (Number)l10.invoke(number2);
                double d11 = number2.doubleValue();
                d10 = Math.min(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Float hn(float[] fArray, Comparator comparator) {
        float f10;
        f0.p(fArray, "$this$minWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            string2 = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        f10 = fArray[0];
        n11 = ArraysKt___ArraysKt.Od(fArray);
        if (n12 <= n11) {
            while (true) {
                Float f12;
                float f13 = fArray[n12];
                Float f14 = Float.valueOf(f10);
                int n13 = comparator.compare(f14, f12 = Float.valueOf(f13));
                if (n13 > 0) {
                    f10 = f13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    private static final char ho(char[] cArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.io(cArray, e$a);
    }

    public static final Boolean hp(boolean[] blArray, q q10) {
        f0.p(blArray, "$this$reduceIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = blArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = blArray[0];
        n11 = ArraysKt___ArraysKt.Td(blArray);
        if (n12 <= n11) {
            while (true) {
                Integer n13 = n12;
                object = n10 != 0;
                boolean bl2 = blArray[n12];
                Boolean bl3 = bl2;
                object = (Boolean)q10.invoke(n13, object, bl3);
                n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return n10 != 0;
    }

    public static final Object hq(Object[] objectArray, p p10) {
        f0.p(objectArray, "$this$reduceRightOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n10 < 0) {
            return null;
        }
        int n11 = n10 + -1;
        object = objectArray[n10];
        while (n11 >= 0) {
            int n12 = n11 + -1;
            Object object2 = objectArray[n11];
            object = p10.invoke(object2, object);
            n11 = n12;
        }
        return object;
    }

    private static final List hr(int[] nArray, Object object, q q10) {
        ArrayList<Object> arrayList;
        int n10 = nArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int n13 = nArray.length + n12;
        arrayList = new ArrayList<Object>(n13);
        arrayList.add(object);
        n12 = nArray.length;
        while (n11 < n12) {
            Integer n14 = n11;
            int n15 = nArray[n11];
            Integer n16 = n15;
            object = q10.invoke(n14, object, n16);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    private static final List hs(double[] object, q q10) {
        Ref$DoubleRef ref$DoubleRef;
        int n10 = ((double[])object).length;
        ArrayList<Number> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            ref$DoubleRef = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            double d10;
            ref$DoubleRef = new Ref$DoubleRef();
            ref$DoubleRef.element = d10 = object[0];
            int n12 = ((double[])object).length;
            arrayList = new ArrayList<Number>(n12);
            d10 = ref$DoubleRef.element;
            Double d11 = d10;
            arrayList.add(d11);
            n12 = ((double[])object).length;
            while (n11 < n12) {
                double d12;
                Number number = n11;
                double d13 = ref$DoubleRef.element;
                Double d14 = d13;
                double d15 = object[n11];
                Double d16 = d15;
                ref$DoubleRef.element = d12 = ((Number)q10.invoke(number, d14, d16)).doubleValue();
                number = d12;
                arrayList.add(number);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Float ht(float[] fArray, l l10) {
        f0.p(fArray, "$this$singleOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = fArray.length;
        boolean bl2 = false;
        Float f10 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f11 = fArray[i10];
            Constable constable = Float.valueOf(f11);
            boolean bl3 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl3) continue;
            if (bl2) {
                return null;
            }
            f10 = Float.valueOf(f11);
            bl2 = true;
        }
        if (!bl2) {
            return null;
        }
        return f10;
    }

    public static final void hu(double[] dArray, int n10, int n11) {
        f0.p(dArray, "$this$sortDescending");
        f.x1.n.i3(dArray, n10, n11);
        ArraysKt___ArraysKt.pq(dArray, n10, n11);
    }

    public static final List hv(short[] sArray, l l10) {
        f0.p(sArray, "$this$sortedByDescending");
        f0.p(l10, "selector");
        b$d b$d = new b$d(l10);
        return ArraysKt___ArraysKt.yv(sArray, b$d);
    }

    public static final int hw(Byte[] byteArray) {
        String string2 = "$this$sum";
        f0.p(byteArray, string2);
        int n10 = byteArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Byte by2 = byteArray[i10];
            byte by3 = by2;
            n11 += by3;
        }
        return n11;
    }

    public static final List hx(char[] object, int n10) {
        ArrayList<Character> arrayList;
        int n11;
        String string2 = "$this$take";
        f0.p(object, string2);
        int n12 = 1;
        int n13 = 0;
        if (n10 >= 0) {
            n11 = n12;
        } else {
            n11 = 0;
            arrayList = null;
        }
        if (n11 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n11 = ((char[])object).length;
            if (n10 >= n11) {
                return ArraysKt___ArraysKt.py((char[])object);
            }
            if (n10 == n12) {
                return t.k(Character.valueOf((char)object[0]));
            }
            arrayList = new ArrayList<Character>(n10);
            int n14 = ((Object)object).length;
            int n15 = 0;
            while (n13 < n14) {
                Object object2 = object[n13];
                Character c10 = Character.valueOf((char)object2);
                arrayList.add(c10);
                if ((n15 += n12) == n10) break;
                ++n13;
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final HashSet hy(float[] fArray) {
        f0.p(fArray, "$this$toHashSet");
        int n10 = s0.j(fArray.length);
        HashSet hashSet = new HashSet(n10);
        return (HashSet)ArraysKt___ArraysKt.Wx(fArray, hashSet);
    }

    public static final Set hz(short[] object, Iterable iterable) {
        f0.p(object, "$this$union");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Oy(object);
        y.q0((Collection)object, iterable);
        return object;
    }

    public static final m i5(short[] sArray) {
        Object object = "$this$asSequence";
        f0.p(sArray, (String)object);
        int n10 = sArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return SequencesKt__SequencesKt.j();
        }
        object = new ArraysKt___ArraysKt$l(sArray);
        return object;
    }

    public static final Map i6(long[] lArray, Map map, l l10) {
        f0.p(lArray, "$this$associateTo");
        f0.p(map, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (long l11 : lArray) {
            Object object = l11;
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            map.put(object2, object);
        }
        return map;
    }

    private static final byte i7(byte[] byArray) {
        f0.p(byArray, "$this$component3");
        return byArray[2];
    }

    private static final int i8(boolean[] blArray) {
        return blArray.length;
    }

    public static final List i9(long[] lArray, l l10) {
        f0.p(lArray, "$this$dropWhile");
        f0.p(l10, "predicate");
        ArrayList<Long> arrayList = new ArrayList<Long>();
        int n10 = lArray.length;
        boolean bl2 = false;
        Long l11 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l12 = lArray[i10];
            if (bl2) {
                Long l13 = l12;
                arrayList.add(l13);
                continue;
            }
            Constable constable = Long.valueOf(l12);
            boolean bl3 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl3) continue;
            l11 = l12;
            arrayList.add(l11);
            bl2 = true;
        }
        return arrayList;
    }

    public static final List iA(short[] sArray, Object[] objectArray) {
        f0.p(sArray, "$this$zip");
        String string2 = "other";
        f0.p(objectArray, string2);
        int n10 = sArray.length;
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Object object = objectArray[i10];
            Pair pair = w0.a(s10, object);
            arrayList.add(pair);
        }
        return arrayList;
    }

    public static final List ia(char[] cArray, l l10) {
        f0.p(cArray, "$this$filterNot");
        f0.p(l10, "predicate");
        ArrayList<Character> arrayList = new ArrayList<Character>();
        for (char c10 : cArray) {
            Comparable<Character> comparable = Character.valueOf(c10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            Character c11 = Character.valueOf(c10);
            arrayList.add(c11);
        }
        return arrayList;
    }

    public static final float ib(float[] object) {
        String string2 = "$this$first";
        f0.p(object, string2);
        int n10 = ((float[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            return object[0];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    private static final Collection ic(int[] nArray, Collection collection, p p10) {
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Integer n13 = n11;
            ++n11;
            Object object = n12;
            object = (Iterable)p10.invoke(n13, object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final Object id(short[] sArray, Object object, q q10) {
        f0.p(sArray, "$this$foldRightIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        for (int i10 = ArraysKt___ArraysKt.Sd(sArray); i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            short s10 = sArray[i10];
            Short s11 = s10;
            object = q10.invoke(n10, s11, object);
        }
        return object;
    }

    public static final Integer ie(int[] object, int n10) {
        int n11;
        String string2 = "$this$getOrNull";
        f0.p(object, string2);
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Pd(object))) {
            int n12 = object[n10];
            object = n12;
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    public static final int if(double[] dArray, l l10) {
        f0.p(dArray, "$this$indexOfFirst");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = dArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            Constable constable = Double.valueOf(d10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return i10;
        }
        return -1;
    }

    public static /* synthetic */ Appendable ig(byte[] byArray, Appendable appendable, CharSequence object, CharSequence object2, CharSequence charSequence, int n10, CharSequence charSequence2, l l10, int n11, Object object3) {
        l l11;
        int n12 = n11 & 2;
        Object object4 = n12 != 0 ? ", " : object;
        int n13 = n11 & 4;
        CharSequence charSequence3 = "";
        Object object5 = n13 != 0 ? charSequence3 : object2;
        int n14 = n11 & 8;
        if (n14 == 0) {
            charSequence3 = charSequence;
        }
        n14 = n11 & 0x10;
        n14 = n14 != 0 ? -1 : n10;
        int n15 = n11 & 0x20;
        CharSequence charSequence4 = n15 != 0 ? "..." : charSequence2;
        int n16 = n11 & 0x40;
        if (n16 != 0) {
            n16 = 0;
            l11 = null;
        } else {
            l11 = l10;
        }
        object = byArray;
        object2 = appendable;
        charSequence = object4;
        charSequence2 = charSequence3;
        return ArraysKt___ArraysKt.Zf(byArray, appendable, (CharSequence)object4, (CharSequence)object5, charSequence3, n14, charSequence4, l11);
    }

    public static final int ih(short[] sArray, short s10) {
        String string2 = "$this$lastIndexOf";
        f0.p(sArray, string2);
        int n10 = sArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            short s11 = sArray[n10];
            if (s10 == s11) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static final Collection ii(char[] cArray, Collection collection, l l10) {
        f0.p(cArray, "$this$mapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            object = l10.invoke(object);
            collection.add(object);
        }
        return collection;
    }

    private static final float ij(short[] object, l l10) {
        Number number;
        float f10;
        int n10 = ((short[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            n10 = object[0];
            number = (short)n10;
            number = (Number)l10.invoke(number);
            f10 = number.floatValue();
            n11 = ArraysKt___ArraysKt.Sd(object);
            if (n12 <= n11) {
                while (true) {
                    short s10 = object[n12];
                    Number number2 = s10;
                    number2 = (Number)l10.invoke(number2);
                    float f12 = number2.floatValue();
                    f10 = Math.max(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object ik(long[] lArray, Comparator comparator, l l10) {
        Object object;
        int n10 = lArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        long l11 = lArray[0];
        object = l11;
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n12 <= n11) {
            while (true) {
                long l12 = lArray[n12];
                Object object2 = l12;
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 < 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final Byte il(byte[] byArray, l l10) {
        f0.p(byArray, "$this$minByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = byArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray[0];
        n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n11 == 0) {
            return (byte)n10;
        }
        Comparable<Byte> comparable = (byte)n10;
        comparable = (Comparable)l10.invoke(comparable);
        if (n12 <= n11) {
            while (true) {
                int n13 = byArray[n12];
                Comparable<Byte> comparable2 = (byte)n13;
                int n14 = comparable.compareTo((Byte)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n14 > 0) {
                    n10 = n13;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return (byte)n10;
    }

    private static final Double im(boolean[] blArray, l l10) {
        Serializable serializable;
        int n10 = blArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            serializable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = blArray[0];
        serializable = Boolean.valueOf(n10 != 0);
        serializable = (Number)l10.invoke(serializable);
        double d10 = ((Number)serializable).doubleValue();
        int n12 = ArraysKt___ArraysKt.Td(blArray);
        if (n11 <= n12) {
            while (true) {
                boolean bl2 = blArray[n11];
                Serializable serializable2 = Boolean.valueOf(bl2);
                serializable2 = (Number)l10.invoke(serializable2);
                double d11 = ((Number)serializable2).doubleValue();
                d10 = Math.min(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Integer in(int[] nArray, Comparator comparator) {
        f0.p(nArray, "$this$minWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = nArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray[0];
        n11 = ArraysKt___ArraysKt.Pd(nArray);
        if (n12 <= n11) {
            while (true) {
                Integer n13;
                int n14 = nArray[n12];
                Integer n15 = n10;
                int n16 = comparator.compare(n15, n13 = Integer.valueOf(n14));
                if (n16 > 0) {
                    n10 = n14;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return n10;
    }

    public static final char io(char[] object, e e10) {
        f0.p(object, "$this$random");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = ((char[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ((char[])object).length;
            int n11 = e10.m(n10);
            return object[n11];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final Byte ip(byte[] byArray, q q10) {
        f0.p(byArray, "$this$reduceIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = byArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray[0];
        n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n12 <= n11) {
            while (true) {
                Integer n13 = n12;
                object = (byte)n10;
                byte by2 = byArray[n12];
                Byte by3 = by2;
                object = (Number)q10.invoke(n13, object, by3);
                n10 = ((Number)object).byteValue();
                if (n12 == n11) break;
                ++n12;
            }
        }
        return (byte)n10;
    }

    public static final Short iq(short[] sArray, p p10) {
        short s10;
        f0.p(sArray, "$this$reduceRightOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int s102 = ArraysKt___ArraysKt.Sd(sArray);
        if (s102 < 0) {
            return null;
        }
        int n10 = s102 + -1;
        short s11 = sArray[s102];
        while (n10 >= 0) {
            int n11 = n10 + -1;
            Short s12 = sArray[n10];
            object = s10;
            object = (Number)p10.invoke(s12, object);
            s10 = ((Number)object).shortValue();
            n10 = n11;
        }
        return s10;
    }

    private static final List ir(long[] lArray, Object object, q q10) {
        ArrayList<Object> arrayList;
        int n10 = lArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int n13 = lArray.length + n12;
        arrayList = new ArrayList<Object>(n13);
        arrayList.add(object);
        n12 = lArray.length;
        while (n11 < n12) {
            Integer n14 = n11;
            long l10 = lArray[n11];
            Long l11 = l10;
            object = q10.invoke(n14, object, l11);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    private static final List is(float[] object, q q10) {
        Ref$FloatRef ref$FloatRef;
        int n10 = ((float[])object).length;
        float f10 = 0.0f;
        ArrayList<Number> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            ref$FloatRef = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            ref$FloatRef = new Ref$FloatRef();
            ref$FloatRef.element = f10 = object[0];
            int n12 = ((float[])object).length;
            arrayList = new ArrayList<Number>(n12);
            float f11 = ref$FloatRef.element;
            Float f12 = Float.valueOf(f11);
            arrayList.add(f12);
            n12 = ((float[])object).length;
            while (n11 < n12) {
                float f13;
                Number number = n11;
                float f14 = ref$FloatRef.element;
                Float f15 = Float.valueOf(f14);
                float f16 = object[n11];
                Float f17 = Float.valueOf(f16);
                ref$FloatRef.element = f13 = ((Number)q10.invoke(number, f15, f17)).floatValue();
                number = Float.valueOf(f13);
                arrayList.add(number);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Integer it(int[] object) {
        String string2 = "$this$singleOrNull";
        f0.p(object, string2);
        int n10 = ((int[])object).length;
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            string2 = null;
            int n12 = object[0];
            object = n12;
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    public static final void iu(float[] fArray) {
        String string2 = "$this$sortDescending";
        f0.p(fArray, string2);
        int n10 = fArray.length;
        int n11 = 1;
        if (n10 > n11) {
            f.x1.n.j3(fArray);
            ArraysKt___ArraysKt.qq(fArray);
        }
    }

    public static final List iv(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$sortedByDescending");
        f0.p(l10, "selector");
        b$d b$d = new b$d(l10);
        return ArraysKt___ArraysKt.zv(blArray, b$d);
    }

    private static final double iw(byte[] byArray, l l10) {
        double d10 = 0.0;
        for (byte by2 : byArray) {
            Number number = by2;
            number = (Number)l10.invoke(number);
            double d11 = number.doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final List ix(double[] object, int n10) {
        ArrayList<Double> arrayList;
        int n11;
        String string2 = "$this$take";
        f0.p(object, string2);
        int n12 = 1;
        int n13 = 0;
        if (n10 >= 0) {
            n11 = n12;
        } else {
            n11 = 0;
            arrayList = null;
        }
        if (n11 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n11 = ((double[])object).length;
            if (n10 >= n11) {
                return ArraysKt___ArraysKt.qy((double[])object);
            }
            if (n10 == n12) {
                return t.k((double)object[0]);
            }
            arrayList = new ArrayList<Double>(n10);
            int n14 = ((Object)object).length;
            int n15 = 0;
            while (n13 < n14) {
                Object object2 = object[n13];
                Double d10 = (double)object2;
                arrayList.add(d10);
                if ((n15 += n12) == n10) break;
                ++n13;
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final HashSet iy(int[] nArray) {
        f0.p(nArray, "$this$toHashSet");
        int n10 = s0.j(nArray.length);
        HashSet hashSet = new HashSet(n10);
        return (HashSet)ArraysKt___ArraysKt.Xx(nArray, hashSet);
    }

    public static final Set iz(boolean[] object, Iterable iterable) {
        f0.p(object, "$this$union");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Py(object);
        y.q0((Collection)object, iterable);
        return object;
    }

    public static final m j5(boolean[] blArray) {
        Object object = "$this$asSequence";
        f0.p(blArray, (String)object);
        int n10 = blArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return SequencesKt__SequencesKt.j();
        }
        object = new ArraysKt___ArraysKt$q(blArray);
        return object;
    }

    public static final Map j6(Object[] objectArray, Map map, l l10) {
        f0.p(objectArray, "$this$associateTo");
        f0.p(map, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (Object object : objectArray) {
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            map.put(object2, object);
        }
        return map;
    }

    private static final char j7(char[] cArray) {
        f0.p(cArray, "$this$component3");
        return cArray[2];
    }

    public static final int j8(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$count");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = blArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Boolean bl2 = blArray[i10];
            boolean bl3 = bl2 = (Boolean)l10.invoke(bl2);
            if (!bl3) continue;
            ++n11;
        }
        return n11;
    }

    public static final List j9(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$dropWhile");
        f0.p(l10, "predicate");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n10 = objectArray.length;
        boolean bl2 = false;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            if (bl2) {
                arrayList.add(object);
                continue;
            }
            Boolean bl3 = (Boolean)l10.invoke(object);
            boolean bl4 = bl3;
            if (bl4) continue;
            arrayList.add(object);
            bl2 = true;
        }
        return arrayList;
    }

    public static final List jA(short[] sArray, Object[] objectArray, p p10) {
        f0.p(sArray, "$this$zip");
        f0.p(objectArray, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = sArray.length;
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Object object = s10;
            Object object2 = objectArray[i10];
            object = p10.invoke(object, object2);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final List ja(double[] dArray, l l10) {
        f0.p(dArray, "$this$filterNot");
        f0.p(l10, "predicate");
        ArrayList<Double> arrayList = new ArrayList<Double>();
        for (double d10 : dArray) {
            Constable constable = Double.valueOf(d10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            Double d11 = d10;
            arrayList.add(d11);
        }
        return arrayList;
    }

    /*
     * WARNING - void declaration
     */
    public static final float jb(float[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$first");
        String string2 = "predicate";
        f0.p(var1_2, string2);
        for (Object object2 : object) {
            Constable constable = Float.valueOf((float)object2);
            boolean bl2 = (Boolean)(constable = (Boolean)var1_2.invoke(constable));
            if (!bl2) continue;
            return (float)object2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Array contains no element matching the predicate.");
        throw noSuchElementException;
    }

    private static final Collection jc(long[] lArray, Collection collection, p p10) {
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = l10;
            object = (Iterable)p10.invoke(n12, object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final Object jd(boolean[] blArray, Object object, q q10) {
        f0.p(blArray, "$this$foldRightIndexed");
        String string2 = "operation";
        f0.p(q10, string2);
        for (int i10 = ArraysKt___ArraysKt.Td(blArray); i10 >= 0; i10 += -1) {
            Integer n10 = i10;
            boolean bl2 = blArray[i10];
            Boolean bl3 = bl2;
            object = q10.invoke(n10, bl3, object);
        }
        return object;
    }

    public static final Long je(long[] object, int n10) {
        int n11;
        String string2 = "$this$getOrNull";
        f0.p(object, string2);
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Qd(object))) {
            long l10 = object[n10];
            object = l10;
        } else {
            object = null;
        }
        return object;
    }

    public static final int jf(float[] fArray, l l10) {
        f0.p(fArray, "$this$indexOfFirst");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = fArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Constable constable = Float.valueOf(f10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return i10;
        }
        return -1;
    }

    public static /* synthetic */ Appendable jg(char[] cArray, Appendable appendable, CharSequence object, CharSequence object2, CharSequence charSequence, int n10, CharSequence charSequence2, l l10, int n11, Object object3) {
        l l11;
        int n12 = n11 & 2;
        Object object4 = n12 != 0 ? ", " : object;
        int n13 = n11 & 4;
        CharSequence charSequence3 = "";
        Object object5 = n13 != 0 ? charSequence3 : object2;
        int n14 = n11 & 8;
        if (n14 == 0) {
            charSequence3 = charSequence;
        }
        n14 = n11 & 0x10;
        n14 = n14 != 0 ? -1 : n10;
        int n15 = n11 & 0x20;
        CharSequence charSequence4 = n15 != 0 ? "..." : charSequence2;
        int n16 = n11 & 0x40;
        if (n16 != 0) {
            n16 = 0;
            l11 = null;
        } else {
            l11 = l10;
        }
        object = cArray;
        object2 = appendable;
        charSequence = object4;
        charSequence2 = charSequence3;
        return ArraysKt___ArraysKt.ag(cArray, appendable, (CharSequence)object4, (CharSequence)object5, charSequence3, n14, charSequence4, l11);
    }

    public static final int jh(boolean[] blArray, boolean bl2) {
        String string2 = "$this$lastIndexOf";
        f0.p(blArray, string2);
        int n10 = blArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            boolean bl3 = blArray[n10];
            if (bl2 == bl3) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static final Collection ji(double[] dArray, Collection collection, l l10) {
        f0.p(dArray, "$this$mapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (double d10 : dArray) {
            Object object = d10;
            object = l10.invoke(object);
            collection.add(object);
        }
        return collection;
    }

    private static final float jj(boolean[] object, l l10) {
        Serializable serializable;
        float f10;
        int n10 = ((boolean[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            serializable = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            n10 = object[0];
            serializable = Boolean.valueOf(n10 != 0);
            serializable = (Number)l10.invoke(serializable);
            f10 = ((Number)serializable).floatValue();
            n11 = ArraysKt___ArraysKt.Td(object);
            if (n12 <= n11) {
                while (true) {
                    boolean bl2 = object[n12];
                    Serializable serializable2 = Boolean.valueOf(bl2);
                    serializable2 = (Number)l10.invoke(serializable2);
                    float f12 = ((Number)serializable2).floatValue();
                    f10 = Math.max(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object jk(Object[] objectArray, Comparator comparator, l l10) {
        Object object;
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        object = objectArray[0];
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n12 <= n11) {
            while (true) {
                Object object2 = objectArray[n12];
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 < 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final Character jl(char[] cArray, l l10) {
        f0.p(cArray, "$this$minByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray[0];
        n11 = ArraysKt___ArraysKt.Md(cArray);
        if (n11 == 0) {
            return Character.valueOf((char)n10);
        }
        Comparable<Character> comparable = Character.valueOf((char)n10);
        comparable = (Comparable)l10.invoke(comparable);
        if (n12 <= n11) {
            while (true) {
                int n13 = cArray[n12];
                Comparable<Character> comparable2 = Character.valueOf((char)n13);
                int n14 = comparable.compareTo((Character)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n14 > 0) {
                    n10 = n13;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Character.valueOf((char)n10);
    }

    private static final Float jm(byte[] byArray, l l10) {
        Number number;
        float f10;
        int n10 = byArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray[0];
        number = (byte)n10;
        number = (Number)l10.invoke(number);
        f10 = number.floatValue();
        n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n12 <= n11) {
            while (true) {
                byte by2 = byArray[n12];
                Number number2 = by2;
                number2 = (Number)l10.invoke(number2);
                float f12 = number2.floatValue();
                f10 = Math.min(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final Long jn(long[] lArray, Comparator comparator) {
        f0.p(lArray, "$this$minWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = lArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        long l10 = lArray[0];
        int n12 = ArraysKt___ArraysKt.Qd(lArray);
        if (n11 <= n12) {
            while (true) {
                Long l11;
                long l12 = lArray[n11];
                Long l13 = l10;
                int n13 = comparator.compare(l13, l11 = Long.valueOf(l12));
                if (n13 > 0) {
                    l10 = l12;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return l10;
    }

    private static final double jo(double[] dArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.ko(dArray, e$a);
    }

    public static final Character jp(char[] cArray, q q10) {
        f0.p(cArray, "$this$reduceIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray[0];
        n11 = ArraysKt___ArraysKt.Md(cArray);
        if (n12 <= n11) {
            while (true) {
                Integer n13 = n12;
                object = Character.valueOf((char)n10);
                char c10 = cArray[n12];
                Character c11 = Character.valueOf(c10);
                object = (Character)q10.invoke(n13, object, c11);
                n10 = ((Character)object).charValue();
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Character.valueOf((char)n10);
    }

    public static final Object[] jq(Object[] object) {
        Object object2 = "$this$requireNoNulls";
        f0.p(object, (String)object2);
        int n10 = ((Object[])object).length;
        StringBuilder stringBuilder = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object3 = object[i10];
            if (object3 != null) {
                continue;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("null element found in ");
            stringBuilder.append(object);
            stringBuilder.append('.');
            object = stringBuilder.toString();
            object2 = new IllegalArgumentException((String)object);
            throw object2;
        }
        return object;
    }

    public static final List jr(Object[] objectArray, Object object, q q10) {
        f0.p(objectArray, "$this$runningFoldIndexed");
        ArrayList<Object> arrayList = "operation";
        f0.p(q10, (String)((Object)arrayList));
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int n13 = objectArray.length + n12;
        arrayList = new ArrayList<Object>(n13);
        arrayList.add(object);
        n12 = objectArray.length;
        while (n11 < n12) {
            Integer n14 = n11;
            Object object2 = objectArray[n11];
            object = q10.invoke(n14, object, object2);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    private static final List js(int[] object, q q10) {
        Ref$IntRef ref$IntRef;
        int n10 = ((int[])object).length;
        int n11 = 0;
        ArrayList<Integer> arrayList = null;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            ref$IntRef = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = n11 = object[0];
            int n13 = ((int[])object).length;
            arrayList = new ArrayList<Integer>(n13);
            Integer n14 = ref$IntRef.element;
            arrayList.add(n14);
            n13 = ((int[])object).length;
            while (n12 < n13) {
                int n15;
                Integer n16 = n12;
                int n17 = ref$IntRef.element;
                Integer n18 = n17;
                int n19 = object[n12];
                Integer n20 = n19;
                ref$IntRef.element = n15 = ((Number)q10.invoke(n16, n18, n20)).intValue();
                n16 = n15;
                arrayList.add(n16);
                ++n12;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Integer jt(int[] nArray, l l10) {
        f0.p(nArray, "$this$singleOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = nArray.length;
        boolean bl2 = false;
        Integer n11 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Constable constable = Integer.valueOf(n12);
            boolean bl3 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl3) continue;
            if (bl2) {
                return null;
            }
            n11 = n12;
            bl2 = true;
        }
        if (!bl2) {
            return null;
        }
        return n11;
    }

    public static final void ju(float[] fArray, int n10, int n11) {
        f0.p(fArray, "$this$sortDescending");
        f.x1.n.k3(fArray, n10, n11);
        ArraysKt___ArraysKt.rq(fArray, n10, n11);
    }

    public static final List jv(byte[] byArray) {
        f0.p(byArray, "$this$sortedDescending");
        int n10 = byArray.length;
        byArray = Arrays.copyOf(byArray, n10);
        f0.o(byArray, "java.util.Arrays.copyOf(this, size)");
        f.x1.n.d3(byArray);
        return ArraysKt___ArraysKt.Cq(byArray);
    }

    private static final double jw(char[] cArray, l l10) {
        double d10 = 0.0;
        for (char c10 : cArray) {
            Serializable serializable = Character.valueOf(c10);
            serializable = (Number)l10.invoke(serializable);
            double d11 = ((Number)serializable).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final List jx(float[] object, int n10) {
        ArrayList<Float> arrayList;
        int n11;
        String string2 = "$this$take";
        f0.p(object, string2);
        int n12 = 1;
        int n13 = 0;
        if (n10 >= 0) {
            n11 = n12;
        } else {
            n11 = 0;
            arrayList = null;
        }
        if (n11 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n11 = ((float[])object).length;
            if (n10 >= n11) {
                return ArraysKt___ArraysKt.ry((float[])object);
            }
            if (n10 == n12) {
                return t.k(Float.valueOf((float)object[0]));
            }
            arrayList = new ArrayList<Float>(n10);
            int n14 = ((Object)object).length;
            int n15 = 0;
            while (n13 < n14) {
                Object object2 = object[n13];
                Float f10 = Float.valueOf((float)object2);
                arrayList.add(f10);
                if ((n15 += n12) == n10) break;
                ++n13;
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final HashSet jy(long[] lArray) {
        f0.p(lArray, "$this$toHashSet");
        int n10 = s0.j(lArray.length);
        HashSet hashSet = new HashSet(n10);
        return (HashSet)ArraysKt___ArraysKt.Yx(lArray, hashSet);
    }

    public static final Iterable jz(byte[] byArray) {
        f0.p(byArray, "$this$withIndex");
        ArraysKt___ArraysKt$withIndex$2 arraysKt___ArraysKt$withIndex$2 = new ArraysKt___ArraysKt$withIndex$2(byArray);
        j0 j02 = new j0(arraysKt___ArraysKt$withIndex$2);
        return j02;
    }

    public static final Map k5(byte[] byArray, l l10) {
        f0.p(byArray, "$this$associate");
        String string2 = "transform";
        f0.p(l10, string2);
        int n10 = s0.j(byArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (byte by2 : byArray) {
            Object object = by2;
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            linkedHashMap.put(object2, object);
        }
        return linkedHashMap;
    }

    public static final Map k6(short[] sArray, Map map, l l10) {
        f0.p(sArray, "$this$associateTo");
        f0.p(map, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (short s10 : sArray) {
            Object object = s10;
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            map.put(object2, object);
        }
        return map;
    }

    private static final double k7(double[] dArray) {
        f0.p(dArray, "$this$component3");
        return dArray[2];
    }

    public static final List k8(byte[] byArray) {
        f0.p(byArray, "$this$distinct");
        return CollectionsKt___CollectionsKt.I5(ArraysKt___ArraysKt.Hy(byArray));
    }

    public static final List k9(short[] sArray, l l10) {
        f0.p(sArray, "$this$dropWhile");
        f0.p(l10, "predicate");
        ArrayList<Short> arrayList = new ArrayList<Short>();
        int n10 = sArray.length;
        boolean bl2 = false;
        Short s10 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s11 = sArray[i10];
            if (bl2) {
                Short s12 = s11;
                arrayList.add(s12);
                continue;
            }
            Constable constable = Short.valueOf(s11);
            boolean bl3 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl3) continue;
            s10 = s11;
            arrayList.add(s10);
            bl2 = true;
        }
        return arrayList;
    }

    public static final List kA(short[] sArray, short[] sArray2) {
        f0.p(sArray, "$this$zip");
        String string2 = "other";
        f0.p(sArray2, string2);
        int n10 = sArray.length;
        int n11 = sArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Short> arrayList = new ArrayList<Short>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            short s11 = sArray2[i10];
            Serializable serializable = s10;
            Short s12 = s11;
            serializable = w0.a(serializable, s12);
            arrayList.add((Short)serializable);
        }
        return arrayList;
    }

    public static final List ka(float[] fArray, l l10) {
        f0.p(fArray, "$this$filterNot");
        f0.p(l10, "predicate");
        ArrayList<Float> arrayList = new ArrayList<Float>();
        for (float f10 : fArray) {
            Constable constable = Float.valueOf(f10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            Float f11 = Float.valueOf(f10);
            arrayList.add(f11);
        }
        return arrayList;
    }

    public static final int kb(int[] object) {
        String string2 = "$this$first";
        f0.p(object, string2);
        int n10 = ((int[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            return object[0];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    private static final Collection kc(Object[] objectArray, Collection collection, p p10) {
        int n10 = objectArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            Integer n12 = n11;
            ++n11;
            object = (Iterable)p10.invoke(n12, object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final void kd(byte[] byArray, l l10) {
        f0.p(byArray, "$this$forEach");
        String string2 = "action";
        f0.p(l10, string2);
        for (byte by2 : byArray) {
            Byte by3 = by2;
            l10.invoke(by3);
        }
    }

    public static final Object ke(Object[] object, int n10) {
        int n11;
        String string2 = "$this$getOrNull";
        f0.p(object, string2);
        object = n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Rd(object)) ? object[n10] : null;
        return object;
    }

    public static final int kf(int[] nArray, l l10) {
        f0.p(nArray, "$this$indexOfFirst");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = nArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Constable constable = Integer.valueOf(nArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return i10;
        }
        return -1;
    }

    public static /* synthetic */ Appendable kg(double[] dArray, Appendable appendable, CharSequence object, CharSequence object2, CharSequence charSequence, int n10, CharSequence charSequence2, l l10, int n11, Object object3) {
        l l11;
        int n12 = n11 & 2;
        Object object4 = n12 != 0 ? ", " : object;
        int n13 = n11 & 4;
        CharSequence charSequence3 = "";
        Object object5 = n13 != 0 ? charSequence3 : object2;
        int n14 = n11 & 8;
        if (n14 == 0) {
            charSequence3 = charSequence;
        }
        n14 = n11 & 0x10;
        n14 = n14 != 0 ? -1 : n10;
        int n15 = n11 & 0x20;
        CharSequence charSequence4 = n15 != 0 ? "..." : charSequence2;
        int n16 = n11 & 0x40;
        if (n16 != 0) {
            n16 = 0;
            l11 = null;
        } else {
            l11 = l10;
        }
        object = dArray;
        object2 = appendable;
        charSequence = object4;
        charSequence2 = charSequence3;
        return ArraysKt___ArraysKt.bg(dArray, appendable, (CharSequence)object4, (CharSequence)object5, charSequence3, n14, charSequence4, l11);
    }

    public static final Boolean kh(boolean[] object) {
        String string2 = "$this$lastOrNull";
        f0.p(object, string2);
        int n10 = ((boolean[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            boolean bl2 = false;
            object = null;
        } else {
            n10 = ((boolean[])object).length - n11;
            boolean bl3 = object[n10];
            object = bl3;
        }
        return object;
    }

    public static final Collection ki(float[] fArray, Collection collection, l l10) {
        f0.p(fArray, "$this$mapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            object = l10.invoke(object);
            collection.add(object);
        }
        return collection;
    }

    private static final Comparable kj(byte[] object, l l10) {
        Comparable<Byte> comparable;
        int n10 = ((byte[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            comparable = (byte)n10;
            comparable = (Comparable)l10.invoke(comparable);
            n11 = ArraysKt___ArraysKt.Ld(object);
            if (n12 <= n11) {
                while (true) {
                    byte by2 = object[n12];
                    Comparable<Byte> comparable2 = by2;
                    int n13 = comparable.compareTo((Byte)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n13 < 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object kk(short[] sArray, Comparator comparator, l l10) {
        Object object;
        int n10 = sArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray[0];
        object = (short)n10;
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n12 <= n11) {
            while (true) {
                short s10 = sArray[n12];
                Object object2 = s10;
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 < 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final Double kl(double[] dArray, l l10) {
        f0.p(dArray, "$this$minByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = dArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        double d10 = dArray[0];
        int n12 = ArraysKt___ArraysKt.Nd(dArray);
        if (n12 == 0) {
            return d10;
        }
        Comparable<Double> comparable = d10;
        comparable = (Comparable)l10.invoke(comparable);
        if (n11 <= n12) {
            while (true) {
                double d11 = dArray[n11];
                Comparable<Double> comparable2 = d11;
                int n13 = comparable.compareTo((Double)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 > 0) {
                    d10 = d11;
                    comparable = comparable2;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    private static final Float km(char[] cArray, l l10) {
        Serializable serializable;
        float f10;
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            serializable = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray[0];
        serializable = Character.valueOf((char)n10);
        serializable = (Number)l10.invoke(serializable);
        f10 = ((Number)serializable).floatValue();
        n11 = ArraysKt___ArraysKt.Md(cArray);
        if (n12 <= n11) {
            while (true) {
                char c10 = cArray[n12];
                Serializable serializable2 = Character.valueOf(c10);
                serializable2 = (Number)l10.invoke(serializable2);
                float f12 = ((Number)serializable2).floatValue();
                f10 = Math.min(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final Object kn(Object[] objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$minWithOrNull");
        Object object = "comparator";
        f0.p(comparator, (String)object);
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        object = objectArray[0];
        n11 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n12 <= n11) {
            while (true) {
                Object object2;
                int n13;
                if ((n13 = comparator.compare(object, object2 = objectArray[n12])) > 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final double ko(double[] object, e e10) {
        f0.p(object, "$this$random");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = ((double[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ((double[])object).length;
            int n11 = e10.m(n10);
            return object[n11];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final Double kp(double[] dArray, q q10) {
        f0.p(dArray, "$this$reduceIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = dArray.length;
        Double d10 = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        double d11 = dArray[0];
        int n12 = ArraysKt___ArraysKt.Nd(dArray);
        if (n11 <= n12) {
            while (true) {
                Integer n13 = n11;
                object = d11;
                double d12 = dArray[n11];
                d10 = d12;
                object = (Number)q10.invoke(n13, object, d10);
                d11 = ((Number)object).doubleValue();
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d11;
    }

    public static final void kq(byte[] byArray) {
        String string2 = "$this$reverse";
        f0.p(byArray, string2);
        int n10 = byArray.length / 2 + -1;
        if (n10 < 0) {
            return;
        }
        int n11 = ArraysKt___ArraysKt.Ld(byArray);
        int n12 = 0;
        if (n10 >= 0) {
            while (true) {
                byte by2;
                byte by3 = byArray[n12];
                byArray[n12] = by2 = byArray[n11];
                byArray[n11] = by3;
                n11 += -1;
                if (n12 == n10) break;
                ++n12;
            }
        }
    }

    private static final List kr(short[] sArray, Object object, q q10) {
        ArrayList<Object> arrayList;
        int n10 = sArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int n13 = sArray.length + n12;
        arrayList = new ArrayList<Object>(n13);
        arrayList.add(object);
        n12 = sArray.length;
        while (n11 < n12) {
            Integer n14 = n11;
            short s10 = sArray[n11];
            Short s11 = s10;
            object = q10.invoke(n14, object, s11);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    private static final List ks(long[] object, q q10) {
        Ref$LongRef ref$LongRef;
        int n10 = ((long[])object).length;
        ArrayList<Number> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            ref$LongRef = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            long l10;
            ref$LongRef = new Ref$LongRef();
            ref$LongRef.element = l10 = object[0];
            int n12 = ((long[])object).length;
            arrayList = new ArrayList<Number>(n12);
            l10 = ref$LongRef.element;
            Long l11 = l10;
            arrayList.add(l11);
            n12 = ((long[])object).length;
            while (n11 < n12) {
                long l12;
                Number number = n11;
                long l13 = ref$LongRef.element;
                Long l14 = l13;
                long l15 = object[n11];
                Long l16 = l15;
                ref$LongRef.element = l12 = ((Number)q10.invoke(number, l14, l16)).longValue();
                number = l12;
                arrayList.add(number);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Long kt(long[] object) {
        String string2 = "$this$singleOrNull";
        f0.p(object, string2);
        int n10 = ((long[])object).length;
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            string2 = null;
            long l10 = object[0];
            object = l10;
        } else {
            object = null;
        }
        return object;
    }

    public static final void ku(int[] nArray) {
        String string2 = "$this$sortDescending";
        f0.p(nArray, string2);
        int n10 = nArray.length;
        int n11 = 1;
        if (n10 > n11) {
            f.x1.n.l3(nArray);
            ArraysKt___ArraysKt.sq(nArray);
        }
    }

    public static final List kv(char[] cArray) {
        f0.p(cArray, "$this$sortedDescending");
        int n10 = cArray.length;
        cArray = Arrays.copyOf(cArray, n10);
        f0.o(cArray, "java.util.Arrays.copyOf(this, size)");
        f.x1.n.f3(cArray);
        return ArraysKt___ArraysKt.Dq(cArray);
    }

    private static final double kw(double[] dArray, l l10) {
        double d10 = 0.0;
        int n10 = dArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Number number = dArray[i10];
            number = (Number)l10.invoke(number);
            double d11 = number.doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final List kx(int[] object, int n10) {
        ArrayList<Integer> arrayList;
        int n11;
        String string2 = "$this$take";
        f0.p(object, string2);
        int n12 = 1;
        int n13 = 0;
        if (n10 >= 0) {
            n11 = n12;
        } else {
            n11 = 0;
            arrayList = null;
        }
        if (n11 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n11 = ((int[])object).length;
            if (n10 >= n11) {
                return ArraysKt___ArraysKt.sy((int[])object);
            }
            if (n10 == n12) {
                return t.k((int)object[0]);
            }
            arrayList = new ArrayList<Integer>(n10);
            int n14 = ((Object)object).length;
            int n15 = 0;
            while (n13 < n14) {
                Object object2 = object[n13];
                Integer n16 = (int)object2;
                arrayList.add(n16);
                if ((n15 += n12) == n10) break;
                ++n13;
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final HashSet ky(Object[] objectArray) {
        f0.p(objectArray, "$this$toHashSet");
        int n10 = s0.j(objectArray.length);
        HashSet hashSet = new HashSet(n10);
        return (HashSet)ArraysKt___ArraysKt.Zx(objectArray, hashSet);
    }

    public static final Iterable kz(char[] cArray) {
        f0.p(cArray, "$this$withIndex");
        ArraysKt___ArraysKt$withIndex$9 arraysKt___ArraysKt$withIndex$9 = new ArraysKt___ArraysKt$withIndex$9(cArray);
        j0 j02 = new j0(arraysKt___ArraysKt$withIndex$9);
        return j02;
    }

    public static final Map l5(char[] cArray, l l10) {
        f0.p(cArray, "$this$associate");
        String string2 = "transform";
        f0.p(l10, string2);
        int n10 = s0.j(cArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            linkedHashMap.put(object2, object);
        }
        return linkedHashMap;
    }

    public static final Map l6(boolean[] blArray, Map map, l l10) {
        f0.p(blArray, "$this$associateTo");
        f0.p(map, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (boolean bl2 : blArray) {
            Object object = bl2;
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            map.put(object2, object);
        }
        return map;
    }

    private static final float l7(float[] fArray) {
        f0.p(fArray, "$this$component3");
        return fArray[2];
    }

    public static final List l8(char[] cArray) {
        f0.p(cArray, "$this$distinct");
        return CollectionsKt___CollectionsKt.I5(ArraysKt___ArraysKt.Iy(cArray));
    }

    public static final List l9(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$dropWhile");
        f0.p(l10, "predicate");
        ArrayList<Boolean> arrayList = new ArrayList<Boolean>();
        int n10 = blArray.length;
        boolean bl2 = false;
        Boolean bl3 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl4 = blArray[i10];
            if (bl2) {
                Boolean bl5 = bl4;
                arrayList.add(bl5);
                continue;
            }
            Boolean bl6 = bl4;
            boolean bl7 = bl6 = (Boolean)l10.invoke(bl6);
            if (bl7) continue;
            bl3 = bl4;
            arrayList.add(bl3);
            bl2 = true;
        }
        return arrayList;
    }

    public static final List lA(short[] sArray, short[] sArray2, p p10) {
        f0.p(sArray, "$this$zip");
        f0.p(sArray2, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = sArray.length;
        int n11 = sArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Object object = s10;
            short s11 = sArray2[i10];
            Short s12 = s11;
            object = p10.invoke(object, s12);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final List la(int[] nArray, l l10) {
        f0.p(nArray, "$this$filterNot");
        f0.p(l10, "predicate");
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int n10 : nArray) {
            Constable constable = Integer.valueOf(n10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            Integer n11 = n10;
            arrayList.add(n11);
        }
        return arrayList;
    }

    /*
     * WARNING - void declaration
     */
    public static final int lb(int[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$first");
        String string2 = "predicate";
        f0.p(var1_2, string2);
        for (Object object2 : object) {
            Constable constable = Integer.valueOf((int)object2);
            boolean bl2 = (Boolean)(constable = (Boolean)var1_2.invoke(constable));
            if (!bl2) continue;
            return (int)object2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Array contains no element matching the predicate.");
        throw noSuchElementException;
    }

    private static final Collection lc(short[] sArray, Collection collection, p p10) {
        int n10 = sArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s10 = sArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = s10;
            object = (Iterable)p10.invoke(n12, object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final void ld(char[] cArray, l l10) {
        f0.p(cArray, "$this$forEach");
        String string2 = "action";
        f0.p(l10, string2);
        for (char c10 : cArray) {
            Character c11 = Character.valueOf(c10);
            l10.invoke(c11);
        }
    }

    public static final Short le(short[] object, int n10) {
        int n11;
        String string2 = "$this$getOrNull";
        f0.p(object, string2);
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Sd(object))) {
            short s10 = object[n10];
            object = s10;
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    public static final int lf(long[] lArray, l l10) {
        f0.p(lArray, "$this$indexOfFirst");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = lArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = lArray[i10];
            Constable constable = Long.valueOf(l11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return i10;
        }
        return -1;
    }

    public static /* synthetic */ Appendable lg(float[] fArray, Appendable appendable, CharSequence object, CharSequence object2, CharSequence charSequence, int n10, CharSequence charSequence2, l l10, int n11, Object object3) {
        l l11;
        int n12 = n11 & 2;
        Object object4 = n12 != 0 ? ", " : object;
        int n13 = n11 & 4;
        CharSequence charSequence3 = "";
        Object object5 = n13 != 0 ? charSequence3 : object2;
        int n14 = n11 & 8;
        if (n14 == 0) {
            charSequence3 = charSequence;
        }
        n14 = n11 & 0x10;
        n14 = n14 != 0 ? -1 : n10;
        int n15 = n11 & 0x20;
        CharSequence charSequence4 = n15 != 0 ? "..." : charSequence2;
        int n16 = n11 & 0x40;
        if (n16 != 0) {
            n16 = 0;
            l11 = null;
        } else {
            l11 = l10;
        }
        object = fArray;
        object2 = appendable;
        charSequence = object4;
        charSequence2 = charSequence3;
        return ArraysKt___ArraysKt.cg(fArray, appendable, (CharSequence)object4, (CharSequence)object5, charSequence3, n14, charSequence4, l11);
    }

    public static final Boolean lh(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$lastOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = blArray.length;
        while ((n10 += -1) >= 0) {
            boolean bl2 = blArray[n10];
            Boolean bl3 = bl2;
            boolean bl4 = bl3 = (Boolean)l10.invoke(bl3);
            if (!bl4) continue;
            return bl2;
        }
        return null;
    }

    public static final Collection li(int[] nArray, Collection collection, l l10) {
        f0.p(nArray, "$this$mapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (int n10 : nArray) {
            Object object = n10;
            object = l10.invoke(object);
            collection.add(object);
        }
        return collection;
    }

    private static final Comparable lj(char[] object, l l10) {
        Comparable<Character> comparable;
        int n10 = ((char[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            comparable = Character.valueOf((char)n10);
            comparable = (Comparable)l10.invoke(comparable);
            n11 = ArraysKt___ArraysKt.Md(object);
            if (n12 <= n11) {
                while (true) {
                    char c10 = object[n12];
                    Comparable<Character> comparable2 = Character.valueOf(c10);
                    int n13 = comparable.compareTo((Character)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n13 < 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object lk(boolean[] blArray, Comparator comparator, l l10) {
        Object object;
        int n10 = blArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = blArray[0];
        object = n10 != 0;
        object = l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Td(blArray);
        if (n12 <= n11) {
            while (true) {
                boolean bl2 = blArray[n12];
                Object object2 = bl2;
                int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                if (n13 < 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final Float ll(float[] fArray, l l10) {
        float f10;
        f0.p(fArray, "$this$minByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            string2 = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        f10 = fArray[0];
        n11 = ArraysKt___ArraysKt.Od(fArray);
        if (n11 == 0) {
            return Float.valueOf(f10);
        }
        Comparable<Float> comparable = Float.valueOf(f10);
        comparable = (Comparable)l10.invoke(comparable);
        if (n12 <= n11) {
            while (true) {
                float f12 = fArray[n12];
                Comparable<Float> comparable2 = Float.valueOf(f12);
                int n13 = comparable.compareTo((Float)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 > 0) {
                    f10 = f12;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    private static final Float lm(double[] dArray, l l10) {
        Number number;
        float f10;
        int n10 = dArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        double d10 = dArray[0];
        number = d10;
        number = (Number)l10.invoke(number);
        f10 = number.floatValue();
        n11 = ArraysKt___ArraysKt.Nd(dArray);
        if (n12 <= n11) {
            while (true) {
                double d11 = dArray[n12];
                Number number2 = d11;
                number2 = (Number)l10.invoke(number2);
                float f12 = number2.floatValue();
                f10 = Math.min(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final Short ln(short[] sArray, Comparator comparator) {
        f0.p(sArray, "$this$minWithOrNull");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n10 = sArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray[0];
        n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n12 <= n11) {
            while (true) {
                Short s10;
                int n13 = sArray[n12];
                Short s11 = (short)n10;
                int n14 = comparator.compare(s11, s10 = Short.valueOf((short)n13));
                if (n14 > 0) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return (short)n10;
    }

    private static final float lo(float[] fArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.mo(fArray, e$a);
    }

    public static final Float lp(float[] fArray, q q10) {
        float f10;
        f0.p(fArray, "$this$reduceIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            object = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        f10 = fArray[0];
        n11 = ArraysKt___ArraysKt.Od(fArray);
        if (n12 <= n11) {
            while (true) {
                Integer n13 = n12;
                object = Float.valueOf(f10);
                float f12 = fArray[n12];
                Float f13 = Float.valueOf(f12);
                object = (Number)q10.invoke(n13, object, f13);
                f10 = ((Number)object).floatValue();
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final void lq(byte[] byArray, int n10, int n11) {
        f0.p(byArray, "$this$reverse");
        c$a c$a = c.a;
        int n12 = byArray.length;
        c$a.d(n10, n11, n12);
        int n13 = (n10 + n11) / 2;
        if (n10 == n13) {
            return;
        }
        n11 += -1;
        while (n10 < n13) {
            byte by2;
            n12 = byArray[n10];
            byArray[n10] = by2 = byArray[n11];
            byArray[n11] = n12;
            n11 += -1;
            ++n10;
        }
    }

    private static final List lr(boolean[] blArray, Object object, q q10) {
        ArrayList<Object> arrayList;
        int n10 = blArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            return t.k(object);
        }
        int n13 = blArray.length + n12;
        arrayList = new ArrayList<Object>(n13);
        arrayList.add(object);
        n12 = blArray.length;
        while (n11 < n12) {
            Integer n14 = n11;
            boolean bl2 = blArray[n11];
            Boolean bl3 = bl2;
            object = q10.invoke(n14, object, bl3);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    public static final List ls(Object[] object, q q10) {
        f0.p(object, "$this$scanReduceIndexed");
        Object object2 = "operation";
        f0.p(q10, (String)object2);
        int n10 = ((Object[])object).length;
        ArrayList<Object> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            object2 = object[0];
            int n12 = ((Object[])object).length;
            arrayList = new ArrayList<Object>(n12);
            arrayList.add(object2);
            n12 = ((Object[])object).length;
            while (n11 < n12) {
                Integer n13 = n11;
                Object object3 = object[n11];
                object2 = q10.invoke(n13, object2, object3);
                arrayList.add(object2);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Long lt(long[] lArray, l l10) {
        f0.p(lArray, "$this$singleOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = lArray.length;
        boolean bl2 = false;
        Long l11 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l12 = lArray[i10];
            Constable constable = Long.valueOf(l12);
            boolean bl3 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl3) continue;
            if (bl2) {
                return null;
            }
            l11 = l12;
            bl2 = true;
        }
        if (!bl2) {
            return null;
        }
        return l11;
    }

    public static final void lu(int[] nArray, int n10, int n11) {
        f0.p(nArray, "$this$sortDescending");
        f.x1.n.m3(nArray, n10, n11);
        ArraysKt___ArraysKt.tq(nArray, n10, n11);
    }

    public static final List lv(double[] dArray) {
        f0.p(dArray, "$this$sortedDescending");
        int n10 = dArray.length;
        dArray = Arrays.copyOf(dArray, n10);
        f0.o(dArray, "java.util.Arrays.copyOf(this, size)");
        f.x1.n.h3(dArray);
        return ArraysKt___ArraysKt.Eq(dArray);
    }

    private static final double lw(float[] fArray, l l10) {
        double d10 = 0.0;
        for (float f10 : fArray) {
            Number number = Float.valueOf(f10);
            number = (Number)l10.invoke(number);
            double d11 = number.doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final List lx(long[] object, int n10) {
        ArrayList<Long> arrayList;
        int n11;
        String string2 = "$this$take";
        f0.p(object, string2);
        int n12 = 1;
        int n13 = 0;
        if (n10 >= 0) {
            n11 = n12;
        } else {
            n11 = 0;
            arrayList = null;
        }
        if (n11 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n11 = ((long[])object).length;
            if (n10 >= n11) {
                return ArraysKt___ArraysKt.ty((long[])object);
            }
            if (n10 == n12) {
                return t.k((long)object[0]);
            }
            arrayList = new ArrayList<Long>(n10);
            int n14 = ((Object)object).length;
            int n15 = 0;
            while (n13 < n14) {
                Object object2 = object[n13];
                Long l10 = (long)object2;
                arrayList.add(l10);
                if ((n15 += n12) == n10) break;
                ++n13;
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final HashSet ly(short[] sArray) {
        f0.p(sArray, "$this$toHashSet");
        int n10 = s0.j(sArray.length);
        HashSet hashSet = new HashSet(n10);
        return (HashSet)ArraysKt___ArraysKt.ay(sArray, hashSet);
    }

    public static final Iterable lz(double[] dArray) {
        f0.p(dArray, "$this$withIndex");
        ArraysKt___ArraysKt$withIndex$7 arraysKt___ArraysKt$withIndex$7 = new ArraysKt___ArraysKt$withIndex$7(dArray);
        j0 j02 = new j0(arraysKt___ArraysKt$withIndex$7);
        return j02;
    }

    public static final Map m5(double[] dArray, l l10) {
        f0.p(dArray, "$this$associate");
        String string2 = "transform";
        f0.p(l10, string2);
        int n10 = s0.j(dArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (double d10 : dArray) {
            Object object = d10;
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            linkedHashMap.put(object2, object);
        }
        return linkedHashMap;
    }

    private static final Map m6(byte[] byArray, l l10) {
        int n10 = f.l2.q.n(s0.j(byArray.length), 16);
        LinkedHashMap<Byte, Object> linkedHashMap = new LinkedHashMap<Byte, Object>(n10);
        for (byte by2 : byArray) {
            Byte by3 = by2;
            Object object = by2;
            object = l10.invoke(object);
            linkedHashMap.put(by3, object);
        }
        return linkedHashMap;
    }

    private static final int m7(int[] nArray) {
        f0.p(nArray, "$this$component3");
        return nArray[2];
    }

    public static final List m8(double[] dArray) {
        f0.p(dArray, "$this$distinct");
        return CollectionsKt___CollectionsKt.I5(ArraysKt___ArraysKt.Jy(dArray));
    }

    private static final byte m9(byte[] object, int n10, l l10) {
        byte by2;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Ld((byte[])object))) {
            by2 = object[n10];
        } else {
            object = n10;
            object = (Number)l10.invoke(object);
            by2 = ((Number)object).byteValue();
        }
        return by2;
    }

    public static final List mA(boolean[] blArray, Iterable object) {
        boolean bl2;
        f0.p(blArray, "$this$zip");
        String string2 = "other";
        f0.p(object, string2);
        int n10 = blArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n11);
        object = object.iterator();
        n11 = 0;
        Pair pair = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            pair = w0.a(blArray[n11], e10);
            arrayList.add(pair);
            n11 = n12;
        }
        return arrayList;
    }

    public static final List ma(long[] lArray, l l10) {
        f0.p(lArray, "$this$filterNot");
        f0.p(l10, "predicate");
        ArrayList<Long> arrayList = new ArrayList<Long>();
        for (long l11 : lArray) {
            Constable constable = Long.valueOf(l11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            Long l12 = l11;
            arrayList.add(l12);
        }
        return arrayList;
    }

    public static final long mb(long[] object) {
        String string2 = "$this$first";
        f0.p(object, string2);
        int n10 = ((long[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            return object[0];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    private static final Collection mc(boolean[] blArray, Collection collection, p p10) {
        int n10 = blArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            Integer n12 = n11;
            ++n11;
            Object object = bl2;
            object = (Iterable)p10.invoke(n12, object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final void md(double[] dArray, l l10) {
        f0.p(dArray, "$this$forEach");
        String string2 = "action";
        f0.p(l10, string2);
        for (double d10 : dArray) {
            Double d11 = d10;
            l10.invoke(d11);
        }
    }

    public static final Map me(byte[] byArray, l l10) {
        f0.p(byArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (byte by2 : byArray) {
            Object object = by2;
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Byte by3 = by2;
            object2.add((Byte)by3);
        }
        return linkedHashMap;
    }

    public static final int mf(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$indexOfFirst");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = objectArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            boolean bl2 = (Boolean)(object = (Boolean)l10.invoke(object));
            if (!bl2) continue;
            return i10;
        }
        return -1;
    }

    public static /* synthetic */ Appendable mg(int[] nArray, Appendable appendable, CharSequence object, CharSequence object2, CharSequence charSequence, int n10, CharSequence charSequence2, l l10, int n11, Object object3) {
        l l11;
        int n12 = n11 & 2;
        Object object4 = n12 != 0 ? ", " : object;
        int n13 = n11 & 4;
        CharSequence charSequence3 = "";
        Object object5 = n13 != 0 ? charSequence3 : object2;
        int n14 = n11 & 8;
        if (n14 == 0) {
            charSequence3 = charSequence;
        }
        n14 = n11 & 0x10;
        n14 = n14 != 0 ? -1 : n10;
        int n15 = n11 & 0x20;
        CharSequence charSequence4 = n15 != 0 ? "..." : charSequence2;
        int n16 = n11 & 0x40;
        if (n16 != 0) {
            n16 = 0;
            l11 = null;
        } else {
            l11 = l10;
        }
        object = nArray;
        object2 = appendable;
        charSequence = object4;
        charSequence2 = charSequence3;
        return ArraysKt___ArraysKt.dg(nArray, appendable, (CharSequence)object4, (CharSequence)object5, charSequence3, n14, charSequence4, l11);
    }

    public static final Byte mh(byte[] object) {
        String string2 = "$this$lastOrNull";
        f0.p(object, string2);
        int n10 = ((byte[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            boolean bl2 = false;
            object = null;
        } else {
            n10 = ((byte[])object).length - n11;
            byte by2 = object[n10];
            object = by2;
        }
        return object;
    }

    public static final Collection mi(long[] lArray, Collection collection, l l10) {
        f0.p(lArray, "$this$mapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (long l11 : lArray) {
            Object object = l11;
            object = l10.invoke(object);
            collection.add(object);
        }
        return collection;
    }

    private static final Comparable mj(double[] object, l l10) {
        Comparable<Double> comparable;
        int n10 = ((double[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 == 0) {
            double d10 = object[0];
            comparable = d10;
            comparable = (Comparable)l10.invoke(comparable);
            n11 = ArraysKt___ArraysKt.Nd(object);
            if (n12 <= n11) {
                while (true) {
                    double d11 = object[n12];
                    Comparable<Double> comparable2 = d11;
                    int n13 = comparable.compareTo((Double)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n13 < 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Byte mk(byte[] byArray) {
        String string2 = "$this$maxOrNull";
        f0.p(byArray, string2);
        int n10 = byArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray[0];
        n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n12 <= n11) {
            while (true) {
                int n13;
                if (n10 < (n13 = byArray[n12])) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return (byte)n10;
    }

    public static final Integer ml(int[] nArray, l l10) {
        f0.p(nArray, "$this$minByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = nArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray[0];
        n11 = ArraysKt___ArraysKt.Pd(nArray);
        if (n11 == 0) {
            return n10;
        }
        Comparable<Integer> comparable = n10;
        comparable = (Comparable)l10.invoke(comparable);
        if (n12 <= n11) {
            while (true) {
                int n13 = nArray[n12];
                Comparable<Integer> comparable2 = n13;
                int n14 = comparable.compareTo((Integer)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n14 > 0) {
                    n10 = n13;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return n10;
    }

    private static final Float mm(float[] fArray, l l10) {
        Number number;
        float f10;
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        number = Float.valueOf(fArray[0]);
        number = (Number)l10.invoke(number);
        f10 = number.floatValue();
        n11 = ArraysKt___ArraysKt.Od(fArray);
        if (n12 <= n11) {
            while (true) {
                Number number2 = Float.valueOf(fArray[n12]);
                number2 = (Number)l10.invoke(number2);
                float f12 = number2.floatValue();
                f10 = Math.min(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final boolean mn(byte[] byArray) {
        String string2 = "$this$none";
        f0.p(byArray, string2);
        boolean bl2 = byArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            byArray = null;
        }
        return bl2;
    }

    public static final float mo(float[] object, e e10) {
        f0.p(object, "$this$random");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = ((float[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ((float[])object).length;
            int n11 = e10.m(n10);
            return object[n11];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final Integer mp(int[] nArray, q q10) {
        f0.p(nArray, "$this$reduceIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = nArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray[0];
        n11 = ArraysKt___ArraysKt.Pd(nArray);
        if (n12 <= n11) {
            while (true) {
                Integer n13 = n12;
                object = n10;
                int n14 = nArray[n12];
                Integer n15 = n14;
                object = (Number)q10.invoke(n13, object, n15);
                n10 = ((Number)object).intValue();
                if (n12 == n11) break;
                ++n12;
            }
        }
        return n10;
    }

    public static final void mq(char[] cArray) {
        String string2 = "$this$reverse";
        f0.p(cArray, string2);
        int n10 = cArray.length / 2 + -1;
        if (n10 < 0) {
            return;
        }
        int n11 = ArraysKt___ArraysKt.Md(cArray);
        int n12 = 0;
        if (n10 >= 0) {
            while (true) {
                char c10;
                char c11 = cArray[n12];
                cArray[n12] = c10 = cArray[n11];
                cArray[n11] = c11;
                n11 += -1;
                if (n12 == n10) break;
                ++n12;
            }
        }
    }

    private static final List mr(byte[] byArray, p p10) {
        Number number;
        int n10 = byArray.length;
        ArrayList<Byte> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = byArray[0];
        int n12 = byArray.length;
        arrayList = new ArrayList<Byte>(n12);
        Byte by2 = (byte)n10;
        arrayList.add(by2);
        n12 = byArray.length;
        while (n11 < n12) {
            number = (byte)n10;
            byte by3 = byArray[n11];
            Byte by4 = by3;
            number = (Number)p10.invoke(number, by4);
            n10 = number.byteValue();
            by4 = (byte)n10;
            arrayList.add(by4);
            ++n11;
        }
        return arrayList;
    }

    private static final List ms(short[] object, q q10) {
        Ref$ShortRef ref$ShortRef;
        int n10 = ((short[])object).length;
        short s10 = 0;
        ArrayList<Number> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            ref$ShortRef = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            ref$ShortRef = new Ref$ShortRef();
            ref$ShortRef.element = s10 = object[0];
            int n12 = ((short[])object).length;
            arrayList = new ArrayList<Number>(n12);
            Short s11 = ref$ShortRef.element;
            arrayList.add(s11);
            n12 = ((short[])object).length;
            while (n11 < n12) {
                short s12;
                Number number = n11;
                short s13 = ref$ShortRef.element;
                Short s14 = s13;
                short s15 = object[n11];
                Short s16 = s15;
                ref$ShortRef.element = s12 = ((Number)q10.invoke(number, s14, s16)).shortValue();
                number = s12;
                arrayList.add(number);
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Object mt(Object[] object) {
        String string2 = "$this$singleOrNull";
        f0.p(object, string2);
        int n10 = ((Object[])object).length;
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            string2 = null;
            object = object[0];
        } else {
            object = null;
        }
        return object;
    }

    public static final void mu(long[] lArray) {
        String string2 = "$this$sortDescending";
        f0.p(lArray, string2);
        int n10 = lArray.length;
        int n11 = 1;
        if (n10 > n11) {
            f.x1.n.n3(lArray);
            ArraysKt___ArraysKt.uq(lArray);
        }
    }

    public static final List mv(float[] fArray) {
        f0.p(fArray, "$this$sortedDescending");
        int n10 = fArray.length;
        fArray = Arrays.copyOf(fArray, n10);
        f0.o(fArray, "java.util.Arrays.copyOf(this, size)");
        f.x1.n.j3(fArray);
        return ArraysKt___ArraysKt.Fq(fArray);
    }

    private static final double mw(int[] nArray, l l10) {
        double d10 = 0.0;
        for (int n10 : nArray) {
            Number number = n10;
            number = (Number)l10.invoke(number);
            double d11 = number.doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final List mx(Object[] object, int n10) {
        ArrayList<Object> arrayList;
        int n11;
        String string2 = "$this$take";
        f0.p(object, string2);
        int n12 = 1;
        int n13 = 0;
        if (n10 >= 0) {
            n11 = n12;
        } else {
            n11 = 0;
            arrayList = null;
        }
        if (n11 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n11 = ((Object[])object).length;
            if (n10 >= n11) {
                return ArraysKt___ArraysKt.uy((Object[])object);
            }
            if (n10 == n12) {
                return t.k(object[0]);
            }
            arrayList = new ArrayList<Object>(n10);
            int n14 = ((Object)object).length;
            int n15 = 0;
            while (n13 < n14) {
                Object object2 = object[n13];
                arrayList.add(object2);
                if ((n15 += n12) == n10) break;
                ++n13;
            }
            return arrayList;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final HashSet my(boolean[] blArray) {
        f0.p(blArray, "$this$toHashSet");
        int n10 = s0.j(blArray.length);
        HashSet hashSet = new HashSet(n10);
        return (HashSet)ArraysKt___ArraysKt.by(blArray, hashSet);
    }

    public static final Iterable mz(float[] fArray) {
        f0.p(fArray, "$this$withIndex");
        ArraysKt___ArraysKt$withIndex$6 arraysKt___ArraysKt$withIndex$6 = new ArraysKt___ArraysKt$withIndex$6(fArray);
        j0 j02 = new j0(arraysKt___ArraysKt$withIndex$6);
        return j02;
    }

    public static final Map n5(float[] fArray, l l10) {
        f0.p(fArray, "$this$associate");
        String string2 = "transform";
        f0.p(l10, string2);
        int n10 = s0.j(fArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            linkedHashMap.put(object2, object);
        }
        return linkedHashMap;
    }

    private static final Map n6(char[] cArray, l l10) {
        int n10 = f.l2.q.n(s0.j(f.l2.q.u(cArray.length, 128)), 16);
        LinkedHashMap<Character, Object> linkedHashMap = new LinkedHashMap<Character, Object>(n10);
        for (char c10 : cArray) {
            Character c11 = Character.valueOf(c10);
            Object object = Character.valueOf(c10);
            object = l10.invoke(object);
            linkedHashMap.put(c11, object);
        }
        return linkedHashMap;
    }

    private static final long n7(long[] lArray) {
        f0.p(lArray, "$this$component3");
        return lArray[2];
    }

    public static final List n8(float[] fArray) {
        f0.p(fArray, "$this$distinct");
        return CollectionsKt___CollectionsKt.I5(ArraysKt___ArraysKt.Ky(fArray));
    }

    private static final char n9(char[] object, int n10, l l10) {
        char c10;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Md((char[])object))) {
            c10 = object[n10];
        } else {
            object = n10;
            object = (Character)l10.invoke(object);
            c10 = ((Character)object).charValue();
        }
        return c10;
    }

    public static final List nA(boolean[] blArray, Iterable object, p p10) {
        boolean bl2;
        f0.p(blArray, "$this$zip");
        f0.p(object, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = blArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        n11 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            object2 = blArray[n11];
            object2 = p10.invoke(object2, e10);
            arrayList.add(object2);
            n11 = n12;
        }
        return arrayList;
    }

    public static final List na(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$filterNot");
        f0.p(l10, "predicate");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (Object object : objectArray) {
            Boolean bl2 = (Boolean)l10.invoke(object);
            boolean bl3 = bl2;
            if (bl3) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    /*
     * WARNING - void declaration
     */
    public static final long nb(long[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$first");
        String string2 = "predicate";
        f0.p(var1_2, string2);
        for (Object object2 : object) {
            Constable constable = Long.valueOf((long)object2);
            boolean bl2 = (Boolean)(constable = (Boolean)var1_2.invoke(constable));
            if (!bl2) continue;
            return (long)object2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Array contains no element matching the predicate.");
        throw noSuchElementException;
    }

    private static final List nc(Object[] objectArray, p p10) {
        ArrayList arrayList = new ArrayList();
        int n10 = objectArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            Integer n12 = n11;
            ++n11;
            object = (m)p10.invoke(n12, object);
            y.r0(arrayList, (m)object);
        }
        return arrayList;
    }

    public static final void nd(float[] fArray, l l10) {
        f0.p(fArray, "$this$forEach");
        String string2 = "action";
        f0.p(l10, string2);
        for (float f10 : fArray) {
            Float f11 = Float.valueOf(f10);
            l10.invoke(f11);
        }
    }

    public static final Map ne(byte[] byArray, l l10, l l11) {
        f0.p(byArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        f0.p(l11, "valueTransform");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (byte by2 : byArray) {
            Object object = by2;
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = by2;
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return linkedHashMap;
    }

    public static final int nf(short[] sArray, l l10) {
        f0.p(sArray, "$this$indexOfFirst");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = sArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Constable constable = Short.valueOf(sArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return i10;
        }
        return -1;
    }

    public static /* synthetic */ Appendable ng(long[] lArray, Appendable appendable, CharSequence object, CharSequence object2, CharSequence charSequence, int n10, CharSequence charSequence2, l l10, int n11, Object object3) {
        l l11;
        int n12 = n11 & 2;
        Object object4 = n12 != 0 ? ", " : object;
        int n13 = n11 & 4;
        CharSequence charSequence3 = "";
        Object object5 = n13 != 0 ? charSequence3 : object2;
        int n14 = n11 & 8;
        if (n14 == 0) {
            charSequence3 = charSequence;
        }
        n14 = n11 & 0x10;
        n14 = n14 != 0 ? -1 : n10;
        int n15 = n11 & 0x20;
        CharSequence charSequence4 = n15 != 0 ? "..." : charSequence2;
        int n16 = n11 & 0x40;
        if (n16 != 0) {
            n16 = 0;
            l11 = null;
        } else {
            l11 = l10;
        }
        object = lArray;
        object2 = appendable;
        charSequence = object4;
        charSequence2 = charSequence3;
        return ArraysKt___ArraysKt.eg(lArray, appendable, (CharSequence)object4, (CharSequence)object5, charSequence3, n14, charSequence4, l11);
    }

    public static final Byte nh(byte[] byArray, l l10) {
        f0.p(byArray, "$this$lastOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = byArray.length;
        while ((n10 += -1) >= 0) {
            byte by2 = byArray[n10];
            Constable constable = Byte.valueOf(by2);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return by2;
        }
        return null;
    }

    public static final Collection ni(Object[] objectArray, Collection collection, l l10) {
        f0.p(objectArray, "$this$mapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (Object object : objectArray) {
            object = l10.invoke(object);
            collection.add(object);
        }
        return collection;
    }

    private static final Comparable nj(float[] object, l l10) {
        Comparable<Float> comparable;
        float f10;
        int n10 = ((float[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            comparable = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            f10 = object[0];
            comparable = Float.valueOf(f10);
            comparable = (Comparable)l10.invoke(comparable);
            n11 = ArraysKt___ArraysKt.Od(object);
            if (n12 <= n11) {
                while (true) {
                    float f12 = object[n12];
                    Comparable<Float> comparable2 = Float.valueOf(f12);
                    int n13 = comparable.compareTo((Float)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n13 < 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Character nk(char[] cArray) {
        String string2 = "$this$maxOrNull";
        f0.p(cArray, string2);
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray[0];
        n11 = ArraysKt___ArraysKt.Md(cArray);
        if (n12 <= n11) {
            while (true) {
                int n13;
                int n14;
                if ((n14 = f0.t(n10, n13 = cArray[n12])) < 0) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Character.valueOf((char)n10);
    }

    public static final Long nl(long[] lArray, l l10) {
        f0.p(lArray, "$this$minByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = lArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        long l11 = lArray[0];
        int n12 = ArraysKt___ArraysKt.Qd(lArray);
        if (n12 == 0) {
            return l11;
        }
        Comparable<Long> comparable = l11;
        comparable = (Comparable)l10.invoke(comparable);
        if (n11 <= n12) {
            while (true) {
                long l12 = lArray[n11];
                Comparable<Long> comparable2 = l12;
                int n13 = comparable.compareTo((Long)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 > 0) {
                    l11 = l12;
                    comparable = comparable2;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return l11;
    }

    private static final Float nm(int[] nArray, l l10) {
        Number number;
        float f10;
        int n10 = nArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray[0];
        number = n10;
        number = (Number)l10.invoke(number);
        f10 = number.floatValue();
        n11 = ArraysKt___ArraysKt.Pd(nArray);
        if (n12 <= n11) {
            while (true) {
                int n13 = nArray[n12];
                Number number2 = n13;
                number2 = (Number)l10.invoke(number2);
                float f12 = number2.floatValue();
                f10 = Math.min(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final boolean nn(byte[] byArray, l l10) {
        f0.p(byArray, "$this$none");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = byArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Constable constable = Byte.valueOf(byArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return false;
        }
        return true;
    }

    private static final int no(int[] nArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.oo(nArray, e$a);
    }

    public static final Long np(long[] lArray, q q10) {
        f0.p(lArray, "$this$reduceIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = lArray.length;
        Long l10 = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        long l11 = lArray[0];
        int n12 = ArraysKt___ArraysKt.Qd(lArray);
        if (n11 <= n12) {
            while (true) {
                Integer n13 = n11;
                object = l11;
                long l12 = lArray[n11];
                l10 = l12;
                object = (Number)q10.invoke(n13, object, l10);
                l11 = ((Number)object).longValue();
                if (n11 == n12) break;
                ++n11;
            }
        }
        return l11;
    }

    public static final void nq(char[] cArray, int n10, int n11) {
        f0.p(cArray, "$this$reverse");
        c$a c$a = c.a;
        int n12 = cArray.length;
        c$a.d(n10, n11, n12);
        int n13 = (n10 + n11) / 2;
        if (n10 == n13) {
            return;
        }
        n11 += -1;
        while (n10 < n13) {
            char c10;
            n12 = cArray[n10];
            cArray[n10] = c10 = cArray[n11];
            cArray[n11] = n12;
            n11 += -1;
            ++n10;
        }
    }

    private static final List nr(char[] cArray, p p10) {
        Character c10;
        int n10 = cArray.length;
        ArrayList<Character> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            c10 = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = cArray[0];
        int n12 = cArray.length;
        arrayList = new ArrayList<Character>(n12);
        Character c11 = Character.valueOf((char)n10);
        arrayList.add(c11);
        n12 = cArray.length;
        while (n11 < n12) {
            c10 = Character.valueOf((char)n10);
            char c12 = cArray[n11];
            Character c13 = Character.valueOf(c12);
            c10 = (Character)p10.invoke(c10, c13);
            n10 = c10.charValue();
            c13 = Character.valueOf((char)n10);
            arrayList.add(c13);
            ++n11;
        }
        return arrayList;
    }

    private static final List ns(boolean[] object, q q10) {
        Ref$BooleanRef ref$BooleanRef;
        int n10 = ((boolean[])object).length;
        boolean bl2 = false;
        ArrayList<Comparable<Boolean>> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            ref$BooleanRef = null;
        }
        if (n10 != 0) {
            object = CollectionsKt__CollectionsKt.E();
        } else {
            ref$BooleanRef = new Ref$BooleanRef();
            ref$BooleanRef.element = bl2 = object[0];
            int n12 = ((boolean[])object).length;
            arrayList = new ArrayList<Comparable<Boolean>>(n12);
            Boolean bl3 = ref$BooleanRef.element;
            arrayList.add(bl3);
            n12 = ((boolean[])object).length;
            while (n11 < n12) {
                boolean bl4;
                Constable constable = n11;
                boolean bl5 = ref$BooleanRef.element;
                Boolean bl6 = bl5;
                boolean bl7 = object[n11];
                Boolean bl8 = bl7;
                ref$BooleanRef.element = bl4 = ((Boolean)q10.invoke(constable, bl6, bl8)).booleanValue();
                constable = Boolean.valueOf(bl4);
                arrayList.add((Comparable<Boolean>)((Object)constable));
                ++n11;
            }
            object = arrayList;
        }
        return object;
    }

    public static final Object nt(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$singleOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = objectArray.length;
        boolean bl2 = false;
        Object object = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = objectArray[i10];
            Boolean bl3 = (Boolean)l10.invoke(object2);
            boolean bl4 = bl3;
            if (!bl4) continue;
            if (bl2) {
                return null;
            }
            bl2 = true;
            object = object2;
        }
        if (!bl2) {
            return null;
        }
        return object;
    }

    public static final void nu(long[] lArray, int n10, int n11) {
        f0.p(lArray, "$this$sortDescending");
        f.x1.n.o3(lArray, n10, n11);
        ArraysKt___ArraysKt.vq(lArray, n10, n11);
    }

    public static final List nv(int[] nArray) {
        f0.p(nArray, "$this$sortedDescending");
        int n10 = nArray.length;
        nArray = Arrays.copyOf(nArray, n10);
        f0.o(nArray, "java.util.Arrays.copyOf(this, size)");
        f.x1.n.l3(nArray);
        return ArraysKt___ArraysKt.Gq(nArray);
    }

    private static final double nw(long[] lArray, l l10) {
        double d10 = 0.0;
        for (long l11 : lArray) {
            Number number = l11;
            number = (Number)l10.invoke(number);
            double d11 = number.doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final List nx(short[] object, int n10) {
        ArrayList<Short> arrayList;
        int n11;
        String string2 = "$this$take";
        f0.p(object, string2);
        int n12 = 1;
        int n13 = 0;
        if (n10 >= 0) {
            n11 = n12;
        } else {
            n11 = 0;
            arrayList = null;
        }
        if (n11 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n11 = ((short[])object).length;
            if (n10 >= n11) {
                return ArraysKt___ArraysKt.vy((short[])object);
            }
            if (n10 == n12) {
                return t.k((short)object[0]);
            }
            arrayList = new ArrayList<Short>(n10);
            int n14 = ((Object)object).length;
            int n15 = 0;
            while (n13 < n14) {
                Object object2 = object[n13];
                Short s10 = (short)object2;
                arrayList.add(s10);
                if ((n15 += n12) == n10) break;
                ++n13;
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final int[] ny(Integer[] integerArray) {
        String string2 = "$this$toIntArray";
        f0.p(integerArray, string2);
        int n10 = integerArray.length;
        int[] nArray = new int[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            Integer n12 = integerArray[i10];
            nArray[i10] = n11 = n12.intValue();
        }
        return nArray;
    }

    public static final Iterable nz(int[] nArray) {
        f0.p(nArray, "$this$withIndex");
        ArraysKt___ArraysKt$withIndex$4 arraysKt___ArraysKt$withIndex$4 = new ArraysKt___ArraysKt$withIndex$4(nArray);
        j0 j02 = new j0(arraysKt___ArraysKt$withIndex$4);
        return j02;
    }

    public static final Map o5(int[] nArray, l l10) {
        f0.p(nArray, "$this$associate");
        String string2 = "transform";
        f0.p(l10, string2);
        int n10 = s0.j(nArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (int n12 : nArray) {
            Object object = n12;
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            linkedHashMap.put(object2, object);
        }
        return linkedHashMap;
    }

    private static final Map o6(double[] dArray, l l10) {
        int n10 = f.l2.q.n(s0.j(dArray.length), 16);
        LinkedHashMap<Double, Object> linkedHashMap = new LinkedHashMap<Double, Object>(n10);
        for (double d10 : dArray) {
            Double d11 = d10;
            Object object = d10;
            object = l10.invoke(object);
            linkedHashMap.put(d11, object);
        }
        return linkedHashMap;
    }

    private static final Object o7(Object[] objectArray) {
        f0.p(objectArray, "$this$component3");
        return objectArray[2];
    }

    public static final List o8(int[] nArray) {
        f0.p(nArray, "$this$distinct");
        return CollectionsKt___CollectionsKt.I5(ArraysKt___ArraysKt.Ly(nArray));
    }

    private static final double o9(double[] object, int n10, l l10) {
        double d10;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Nd((double[])object))) {
            d10 = object[n10];
        } else {
            object = n10;
            object = (Number)l10.invoke(object);
            d10 = ((Number)object).doubleValue();
        }
        return d10;
    }

    public static final List oA(boolean[] blArray, Object[] objectArray) {
        f0.p(blArray, "$this$zip");
        String string2 = "other";
        f0.p(objectArray, string2);
        int n10 = blArray.length;
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            Object object = objectArray[i10];
            Pair pair = w0.a(bl2, object);
            arrayList.add(pair);
        }
        return arrayList;
    }

    public static final List oa(short[] sArray, l l10) {
        f0.p(sArray, "$this$filterNot");
        f0.p(l10, "predicate");
        ArrayList<Short> arrayList = new ArrayList<Short>();
        for (short s10 : sArray) {
            Constable constable = Short.valueOf(s10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            Short s11 = s10;
            arrayList.add(s11);
        }
        return arrayList;
    }

    public static final Object ob(Object[] object) {
        String string2 = "$this$first";
        f0.p(object, string2);
        int n10 = ((Object[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            return object[0];
        }
        object = new NoSuchElementException("Array is empty.");
        throw object;
    }

    private static final Collection oc(Object[] objectArray, Collection collection, p p10) {
        int n10 = objectArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            Integer n12 = n11;
            ++n11;
            object = (m)p10.invoke(n12, object);
            y.r0(collection, (m)object);
        }
        return collection;
    }

    public static final void od(int[] nArray, l l10) {
        f0.p(nArray, "$this$forEach");
        String string2 = "action";
        f0.p(l10, string2);
        for (int n10 : nArray) {
            Integer n11 = n10;
            l10.invoke(n11);
        }
    }

    public static final Map oe(char[] cArray, l l10) {
        f0.p(cArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Character c11 = Character.valueOf(c10);
            object2.add((Character)c11);
        }
        return linkedHashMap;
    }

    public static final int of(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$indexOfFirst");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = blArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Boolean bl2 = blArray[i10];
            boolean bl3 = bl2 = (Boolean)l10.invoke(bl2);
            if (!bl3) continue;
            return i10;
        }
        return -1;
    }

    public static /* synthetic */ Appendable og(Object[] objectArray, Appendable appendable, CharSequence objectArray2, CharSequence object, CharSequence charSequence, int n10, CharSequence charSequence2, l l10, int n11, Object object2) {
        l l11;
        int n12 = n11 & 2;
        Object object3 = n12 != 0 ? ", " : objectArray2;
        int n13 = n11 & 4;
        CharSequence charSequence3 = "";
        Object object4 = n13 != 0 ? charSequence3 : object;
        int n14 = n11 & 8;
        if (n14 == 0) {
            charSequence3 = charSequence;
        }
        n14 = n11 & 0x10;
        n14 = n14 != 0 ? -1 : n10;
        int n15 = n11 & 0x20;
        CharSequence charSequence4 = n15 != 0 ? "..." : charSequence2;
        int n16 = n11 & 0x40;
        if (n16 != 0) {
            n16 = 0;
            l11 = null;
        } else {
            l11 = l10;
        }
        objectArray2 = objectArray;
        object = appendable;
        charSequence = object3;
        charSequence2 = charSequence3;
        return ArraysKt___ArraysKt.fg(objectArray, appendable, (CharSequence)object3, (CharSequence)object4, charSequence3, n14, charSequence4, l11);
    }

    public static final Character oh(char[] object) {
        String string2 = "$this$lastOrNull";
        f0.p(object, string2);
        int n10 = ((char[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            boolean bl2 = false;
            object = null;
        } else {
            n10 = ((char[])object).length - n11;
            char c10 = object[n10];
            object = Character.valueOf(c10);
        }
        return object;
    }

    public static final Collection oi(short[] sArray, Collection collection, l l10) {
        f0.p(sArray, "$this$mapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (short s10 : sArray) {
            Object object = s10;
            object = l10.invoke(object);
            collection.add(object);
        }
        return collection;
    }

    private static final Comparable oj(int[] object, l l10) {
        Comparable<Integer> comparable;
        int n10 = ((int[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            comparable = n10;
            comparable = (Comparable)l10.invoke(comparable);
            n11 = ArraysKt___ArraysKt.Pd(object);
            if (n12 <= n11) {
                while (true) {
                    int n13 = object[n12];
                    Comparable<Integer> comparable2 = n13;
                    int n14 = comparable.compareTo((Integer)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n14 < 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Comparable ok(Comparable[] comparableArray) {
        Object object = "$this$maxOrNull";
        f0.p(comparableArray, (String)object);
        int n10 = comparableArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        object = comparableArray[0];
        n11 = ArraysKt___ArraysKt.Rd(comparableArray);
        if (n12 <= n11) {
            while (true) {
                Comparable comparable;
                int n13;
                if ((n13 = object.compareTo(comparable = comparableArray[n12])) < 0) {
                    object = comparable;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final Object ol(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$minByOrNull");
        Object object = "selector";
        f0.p(l10, (String)object);
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        object = objectArray[0];
        n11 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n11 == 0) {
            return object;
        }
        Comparable comparable = (Comparable)l10.invoke(object);
        if (n12 <= n11) {
            while (true) {
                Object object2;
                Comparable comparable2;
                int n13;
                if ((n13 = comparable.compareTo(comparable2 = (Comparable)l10.invoke(object2 = objectArray[n12]))) > 0) {
                    object = object2;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    private static final Float om(long[] lArray, l l10) {
        Number number;
        float f10;
        int n10 = lArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        long l11 = lArray[0];
        number = l11;
        number = (Number)l10.invoke(number);
        f10 = number.floatValue();
        n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n12 <= n11) {
            while (true) {
                long l12 = lArray[n12];
                Number number2 = l12;
                number2 = (Number)l10.invoke(number2);
                float f12 = number2.floatValue();
                f10 = Math.min(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final boolean on(char[] cArray) {
        String string2 = "$this$none";
        f0.p(cArray, string2);
        boolean bl2 = cArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            cArray = null;
        }
        return bl2;
    }

    public static final int oo(int[] object, e e10) {
        f0.p(object, "$this$random");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = ((int[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ((int[])object).length;
            int n11 = e10.m(n10);
            return object[n11];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final Object op(Object[] objectArray, q q10) {
        f0.p(objectArray, "$this$reduceIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        object = objectArray[0];
        n11 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n12 <= n11) {
            while (true) {
                Integer n13 = n12;
                Object object2 = objectArray[n12];
                object = q10.invoke(n13, object, object2);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final void oq(double[] dArray) {
        String string2 = "$this$reverse";
        f0.p(dArray, string2);
        int n10 = dArray.length / 2 + -1;
        if (n10 < 0) {
            return;
        }
        int n11 = ArraysKt___ArraysKt.Nd(dArray);
        int n12 = 0;
        if (n10 >= 0) {
            while (true) {
                double d10;
                double d11 = dArray[n12];
                dArray[n12] = d10 = dArray[n11];
                dArray[n11] = d11;
                n11 += -1;
                if (n12 == n10) break;
                ++n12;
            }
        }
    }

    private static final List or(double[] dArray, p p10) {
        Number number;
        int n10 = dArray.length;
        Double d10 = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        double d11 = dArray[0];
        int n12 = dArray.length;
        ArrayList<Double> arrayList = new ArrayList<Double>(n12);
        Double d12 = d11;
        arrayList.add(d12);
        n12 = dArray.length;
        while (n11 < n12) {
            number = d11;
            double d13 = dArray[n11];
            d10 = d13;
            number = (Number)p10.invoke(number, d10);
            d11 = number.doubleValue();
            Double d14 = d11;
            arrayList.add(d14);
            ++n11;
        }
        return arrayList;
    }

    public static final void os(byte[] byArray) {
        f0.p(byArray, "$this$shuffle");
        e$a e$a = e.b;
        ArraysKt___ArraysKt.ps(byArray, e$a);
    }

    public static final Short ot(short[] object) {
        String string2 = "$this$singleOrNull";
        f0.p(object, string2);
        int n10 = ((short[])object).length;
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            string2 = null;
            short s10 = object[0];
            object = s10;
        } else {
            boolean bl2 = false;
            object = null;
        }
        return object;
    }

    public static final void ou(Comparable[] comparableArray) {
        f0.p(comparableArray, "$this$sortDescending");
        Comparator comparator = b.q();
        f.x1.n.E3(comparableArray, comparator);
    }

    public static final List ov(long[] lArray) {
        f0.p(lArray, "$this$sortedDescending");
        int n10 = lArray.length;
        lArray = Arrays.copyOf(lArray, n10);
        f0.o(lArray, "java.util.Arrays.copyOf(this, size)");
        f.x1.n.n3(lArray);
        return ArraysKt___ArraysKt.Hq(lArray);
    }

    public static final double ow(Double[] doubleArray) {
        String string2 = "$this$sum";
        f0.p(doubleArray, string2);
        int n10 = doubleArray.length;
        double d10 = 0.0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Double d11 = doubleArray[i10];
            double d12 = d11;
            d10 += d12;
        }
        return d10;
    }

    public static final List ox(boolean[] object, int n10) {
        ArrayList<Boolean> arrayList;
        int n11;
        String string2 = "$this$take";
        f0.p(object, string2);
        int n12 = 1;
        int n13 = 0;
        if (n10 >= 0) {
            n11 = n12;
        } else {
            n11 = 0;
            arrayList = null;
        }
        if (n11 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n11 = ((boolean[])object).length;
            if (n10 >= n11) {
                return ArraysKt___ArraysKt.wy((boolean[])object);
            }
            if (n10 == n12) {
                return t.k((boolean)object[0]);
            }
            arrayList = new ArrayList<Boolean>(n10);
            int n14 = ((Object)object).length;
            int n15 = 0;
            while (n13 < n14) {
                Object object2 = object[n13];
                Boolean bl2 = (boolean)object2;
                arrayList.add(bl2);
                if ((n15 += n12) == n10) break;
                ++n13;
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List oy(byte[] object) {
        String string2 = "$this$toList";
        f0.p(object, string2);
        int n10 = ((byte[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                object = ArraysKt___ArraysKt.yy(object);
            } else {
                n10 = 0;
                string2 = null;
                byte by2 = object[0];
                object = t.k(by2);
            }
        } else {
            object = CollectionsKt__CollectionsKt.E();
        }
        return object;
    }

    public static final Iterable oz(long[] lArray) {
        f0.p(lArray, "$this$withIndex");
        ArraysKt___ArraysKt$withIndex$5 arraysKt___ArraysKt$withIndex$5 = new ArraysKt___ArraysKt$withIndex$5(lArray);
        j0 j02 = new j0(arraysKt___ArraysKt$withIndex$5);
        return j02;
    }

    public static final Map p5(long[] lArray, l l10) {
        f0.p(lArray, "$this$associate");
        String string2 = "transform";
        f0.p(l10, string2);
        int n10 = s0.j(lArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (long l11 : lArray) {
            Object object = l11;
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            linkedHashMap.put(object2, object);
        }
        return linkedHashMap;
    }

    private static final Map p6(float[] fArray, l l10) {
        int n10 = f.l2.q.n(s0.j(fArray.length), 16);
        LinkedHashMap<Float, Object> linkedHashMap = new LinkedHashMap<Float, Object>(n10);
        for (float f10 : fArray) {
            Float f11 = Float.valueOf(f10);
            Object object = Float.valueOf(f10);
            object = l10.invoke(object);
            linkedHashMap.put(f11, object);
        }
        return linkedHashMap;
    }

    private static final short p7(short[] sArray) {
        f0.p(sArray, "$this$component3");
        return sArray[2];
    }

    public static final List p8(long[] lArray) {
        f0.p(lArray, "$this$distinct");
        return CollectionsKt___CollectionsKt.I5(ArraysKt___ArraysKt.My(lArray));
    }

    private static final float p9(float[] object, int n10, l l10) {
        float f10;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Od((float[])object))) {
            f10 = object[n10];
        } else {
            object = n10;
            object = (Number)l10.invoke(object);
            f10 = ((Number)object).floatValue();
        }
        return f10;
    }

    public static final List pA(boolean[] blArray, Object[] objectArray, p p10) {
        f0.p(blArray, "$this$zip");
        f0.p(objectArray, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = blArray.length;
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            Object object = bl2;
            Object object2 = objectArray[i10];
            object = p10.invoke(object, object2);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final List pa(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$filterNot");
        f0.p(l10, "predicate");
        ArrayList<Boolean> arrayList = new ArrayList<Boolean>();
        for (boolean bl2 : blArray) {
            Boolean bl3 = bl2;
            boolean bl4 = bl3 = (Boolean)l10.invoke(bl3);
            if (bl4) continue;
            Boolean bl5 = bl2;
            arrayList.add(bl5);
        }
        return arrayList;
    }

    /*
     * WARNING - void declaration
     */
    public static final Object pb(Object[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$first");
        String string2 = "predicate";
        f0.p(var1_2, string2);
        for (Object object2 : object) {
            Boolean bl2 = (Boolean)var1_2.invoke(object2);
            boolean bl3 = bl2;
            if (!bl3) continue;
            return object2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Array contains no element matching the predicate.");
        throw noSuchElementException;
    }

    public static final List pc(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$flatMap");
        f0.p(l10, "transform");
        ArrayList arrayList = new ArrayList();
        for (Object object : objectArray) {
            object = (m)l10.invoke(object);
            y.r0(arrayList, (m)object);
        }
        return arrayList;
    }

    public static final void pd(long[] lArray, l l10) {
        f0.p(lArray, "$this$forEach");
        String string2 = "action";
        f0.p(l10, string2);
        for (long l11 : lArray) {
            Long l12 = l11;
            l10.invoke(l12);
        }
    }

    public static final Map pe(char[] cArray, l l10, l l11) {
        f0.p(cArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        f0.p(l11, "valueTransform");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = Character.valueOf(c10);
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return linkedHashMap;
    }

    public static final int pf(byte[] byArray, l l10) {
        f0.p(byArray, "$this$indexOfLast");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = byArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            Constable constable = Byte.valueOf(byArray[n10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static /* synthetic */ Appendable pg(short[] sArray, Appendable appendable, CharSequence object, CharSequence object2, CharSequence charSequence, int n10, CharSequence charSequence2, l l10, int n11, Object object3) {
        l l11;
        int n12 = n11 & 2;
        Object object4 = n12 != 0 ? ", " : object;
        int n13 = n11 & 4;
        CharSequence charSequence3 = "";
        Object object5 = n13 != 0 ? charSequence3 : object2;
        int n14 = n11 & 8;
        if (n14 == 0) {
            charSequence3 = charSequence;
        }
        n14 = n11 & 0x10;
        n14 = n14 != 0 ? -1 : n10;
        int n15 = n11 & 0x20;
        CharSequence charSequence4 = n15 != 0 ? "..." : charSequence2;
        int n16 = n11 & 0x40;
        if (n16 != 0) {
            n16 = 0;
            l11 = null;
        } else {
            l11 = l10;
        }
        object = sArray;
        object2 = appendable;
        charSequence = object4;
        charSequence2 = charSequence3;
        return ArraysKt___ArraysKt.gg(sArray, appendable, (CharSequence)object4, (CharSequence)object5, charSequence3, n14, charSequence4, l11);
    }

    public static final Character ph(char[] cArray, l l10) {
        f0.p(cArray, "$this$lastOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = cArray.length;
        while ((n10 += -1) >= 0) {
            char c10 = cArray[n10];
            Comparable<Character> comparable = Character.valueOf(c10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return Character.valueOf(c10);
        }
        return null;
    }

    public static final Collection pi(boolean[] blArray, Collection collection, l l10) {
        f0.p(blArray, "$this$mapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (boolean bl2 : blArray) {
            Object object = bl2;
            object = l10.invoke(object);
            collection.add(object);
        }
        return collection;
    }

    private static final Comparable pj(long[] object, l l10) {
        Comparable<Long> comparable;
        int n10 = ((long[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 == 0) {
            long l11 = object[0];
            comparable = l11;
            comparable = (Comparable)l10.invoke(comparable);
            n11 = ArraysKt___ArraysKt.Qd(object);
            if (n12 <= n11) {
                while (true) {
                    long l12 = object[n12];
                    Comparable<Long> comparable2 = l12;
                    int n13 = comparable.compareTo((Long)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n13 < 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Double pk(double[] dArray) {
        String string2 = "$this$maxOrNull";
        f0.p(dArray, string2);
        int n10 = dArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        double d10 = dArray[0];
        int n12 = ArraysKt___ArraysKt.Nd(dArray);
        if (n11 <= n12) {
            while (true) {
                double d11 = dArray[n11];
                d10 = Math.max(d10, d11);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    public static final Short pl(short[] sArray, l l10) {
        f0.p(sArray, "$this$minByOrNull");
        String string2 = "selector";
        f0.p(l10, string2);
        int n10 = sArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray[0];
        n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n11 == 0) {
            return (short)n10;
        }
        Comparable<Short> comparable = (short)n10;
        comparable = (Comparable)l10.invoke(comparable);
        if (n12 <= n11) {
            while (true) {
                int n13 = sArray[n12];
                Comparable<Short> comparable2 = (short)n13;
                int n14 = comparable.compareTo((Short)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n14 > 0) {
                    n10 = n13;
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return (short)n10;
    }

    private static final Float pm(Object[] objectArray, l l10) {
        Object object;
        float f10;
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            object = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        object = objectArray[0];
        object = (Number)l10.invoke(object);
        f10 = ((Number)object).floatValue();
        n11 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n12 <= n11) {
            while (true) {
                Object object2 = objectArray[n12];
                object2 = (Number)l10.invoke(object2);
                float f12 = ((Number)object2).floatValue();
                f10 = Math.min(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final boolean pn(char[] cArray, l l10) {
        f0.p(cArray, "$this$none");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = cArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable<Character> comparable = Character.valueOf(cArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return false;
        }
        return true;
    }

    private static final long po(long[] lArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.qo(lArray, e$a);
    }

    public static final Short pp(short[] sArray, q q10) {
        f0.p(sArray, "$this$reduceIndexedOrNull");
        Object object = "operation";
        f0.p(q10, (String)object);
        int n10 = sArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray[0];
        n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n12 <= n11) {
            while (true) {
                Integer n13 = n12;
                object = (short)n10;
                short s10 = sArray[n12];
                Short s11 = s10;
                object = (Number)q10.invoke(n13, object, s11);
                n10 = ((Number)object).shortValue();
                if (n12 == n11) break;
                ++n12;
            }
        }
        return (short)n10;
    }

    public static final void pq(double[] dArray, int n10, int n11) {
        f0.p(dArray, "$this$reverse");
        c$a c$a = c.a;
        int n12 = dArray.length;
        c$a.d(n10, n11, n12);
        int n13 = (n10 + n11) / 2;
        if (n10 == n13) {
            return;
        }
        n11 += -1;
        while (n10 < n13) {
            double d10;
            double d11 = dArray[n10];
            dArray[n10] = d10 = dArray[n11];
            dArray[n11] = d11;
            n11 += -1;
            ++n10;
        }
    }

    private static final List pr(float[] fArray, p p10) {
        Number number;
        float f10;
        int n10 = fArray.length;
        ArrayList<Float> arrayList = null;
        int n11 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n11;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        f10 = fArray[0];
        int n12 = fArray.length;
        arrayList = new ArrayList<Float>(n12);
        Float f12 = Float.valueOf(f10);
        arrayList.add(f12);
        n12 = fArray.length;
        while (n11 < n12) {
            number = Float.valueOf(f10);
            float f13 = fArray[n11];
            Float f14 = Float.valueOf(f13);
            number = (Number)p10.invoke(number, f14);
            f10 = number.floatValue();
            f14 = Float.valueOf(f10);
            arrayList.add(f14);
            ++n11;
        }
        return arrayList;
    }

    public static final void ps(byte[] byArray, e e10) {
        int n10;
        f0.p(byArray, "$this$shuffle");
        String string2 = "random";
        f0.p(e10, string2);
        for (int i10 = ArraysKt___ArraysKt.Ld(byArray); i10 >= (n10 = 1); i10 += -1) {
            byte by2;
            n10 = i10 + 1;
            n10 = e10.m(n10);
            byte by3 = byArray[i10];
            byArray[i10] = by2 = byArray[n10];
            byArray[n10] = by3;
        }
    }

    public static final Short pt(short[] sArray, l l10) {
        f0.p(sArray, "$this$singleOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = sArray.length;
        boolean bl2 = false;
        Short s10 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            short s11 = sArray[i10];
            Constable constable = Short.valueOf(s11);
            boolean bl3 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl3) continue;
            if (bl2) {
                return null;
            }
            s10 = s11;
            bl2 = true;
        }
        if (!bl2) {
            return null;
        }
        return s10;
    }

    public static final void pu(Comparable[] comparableArray, int n10, int n11) {
        f0.p(comparableArray, "$this$sortDescending");
        Comparator comparator = b.q();
        f.x1.n.F3(comparableArray, comparator, n10, n11);
    }

    public static final List pv(Comparable[] comparableArray) {
        f0.p(comparableArray, "$this$sortedDescending");
        Comparator comparator = b.q();
        return ArraysKt___ArraysKt.xv(comparableArray, comparator);
    }

    private static final double pw(Object[] objectArray, l l10) {
        double d10 = 0.0;
        for (Object object : objectArray) {
            object = (Number)l10.invoke(object);
            double d11 = ((Number)object).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final List px(byte[] object, int n10) {
        ArrayList<Byte> arrayList = "$this$takeLast";
        f0.p(object, (String)((Object)arrayList));
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n12 = ((byte[])object).length;
            if (n10 >= n12) {
                return ArraysKt___ArraysKt.oy((byte[])object);
            }
            if (n10 == n11) {
                return t.k((byte)object[n12 -= n11]);
            }
            arrayList = new ArrayList<Byte>(n10);
            for (n10 = n12 - n10; n10 < n12; ++n10) {
                Object object2 = object[n10];
                Byte by2 = (byte)object2;
                arrayList.add(by2);
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List py(char[] object) {
        String string2 = "$this$toList";
        f0.p(object, string2);
        int n10 = ((char[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                object = ArraysKt___ArraysKt.zy(object);
            } else {
                n10 = 0;
                string2 = null;
                char c10 = object[0];
                object = t.k(Character.valueOf(c10));
            }
        } else {
            object = CollectionsKt__CollectionsKt.E();
        }
        return object;
    }

    public static final Iterable pz(Object[] objectArray) {
        f0.p(objectArray, "$this$withIndex");
        ArraysKt___ArraysKt$withIndex$1 arraysKt___ArraysKt$withIndex$1 = new ArraysKt___ArraysKt$withIndex$1(objectArray);
        j0 j02 = new j0(arraysKt___ArraysKt$withIndex$1);
        return j02;
    }

    public static final Map q5(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$associate");
        String string2 = "transform";
        f0.p(l10, string2);
        int n10 = s0.j(objectArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (Object object : objectArray) {
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            linkedHashMap.put(object2, object);
        }
        return linkedHashMap;
    }

    private static final Map q6(int[] nArray, l l10) {
        int n10 = f.l2.q.n(s0.j(nArray.length), 16);
        LinkedHashMap<Integer, Object> linkedHashMap = new LinkedHashMap<Integer, Object>(n10);
        for (int n11 : nArray) {
            Integer n12 = n11;
            Object object = n11;
            object = l10.invoke(object);
            linkedHashMap.put(n12, object);
        }
        return linkedHashMap;
    }

    private static final boolean q7(boolean[] blArray) {
        f0.p(blArray, "$this$component3");
        return blArray[2];
    }

    public static final List q8(Object[] objectArray) {
        f0.p(objectArray, "$this$distinct");
        return CollectionsKt___CollectionsKt.I5(ArraysKt___ArraysKt.Ny(objectArray));
    }

    private static final int q9(int[] object, int n10, l l10) {
        int n11;
        int n12;
        if (n10 >= 0 && n10 <= (n12 = ArraysKt___ArraysKt.Pd((int[])object))) {
            n11 = object[n10];
        } else {
            object = n10;
            object = (Number)l10.invoke(object);
            n11 = ((Number)object).intValue();
        }
        return n11;
    }

    public static final List qA(boolean[] blArray, boolean[] blArray2) {
        f0.p(blArray, "$this$zip");
        String string2 = "other";
        f0.p(blArray2, string2);
        int n10 = blArray.length;
        int n11 = blArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Boolean> arrayList = new ArrayList<Boolean>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            boolean bl3 = blArray2[i10];
            Serializable serializable = bl2;
            Boolean bl4 = bl3;
            serializable = w0.a(serializable, bl4);
            arrayList.add((Boolean)serializable);
        }
        return arrayList;
    }

    public static final List qa(Object[] objectArray) {
        f0.p(objectArray, "$this$filterNotNull");
        ArrayList arrayList = new ArrayList();
        return (List)ArraysKt___ArraysKt.ra(objectArray, arrayList);
    }

    public static final short qb(short[] object) {
        String string2 = "$this$first";
        f0.p(object, string2);
        int n10 = ((short[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            return object[0];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final Collection qc(Object[] objectArray, Collection collection, l l10) {
        f0.p(objectArray, "$this$flatMapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (Object object : objectArray) {
            object = (m)l10.invoke(object);
            y.r0(collection, (m)object);
        }
        return collection;
    }

    public static final void qd(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$forEach");
        String string2 = "action";
        f0.p(l10, string2);
        for (Object object : objectArray) {
            l10.invoke(object);
        }
    }

    public static final Map qe(double[] dArray, l l10) {
        f0.p(dArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (double d10 : dArray) {
            Object object = d10;
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Double d11 = d10;
            object2.add((Double)d11);
        }
        return linkedHashMap;
    }

    public static final int qf(char[] cArray, l l10) {
        f0.p(cArray, "$this$indexOfLast");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = cArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            Comparable<Character> comparable = Character.valueOf(cArray[n10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static /* synthetic */ Appendable qg(boolean[] blArray, Appendable appendable, CharSequence object, CharSequence object2, CharSequence charSequence, int n10, CharSequence charSequence2, l l10, int n11, Object object3) {
        l l11;
        int n12 = n11 & 2;
        Object object4 = n12 != 0 ? ", " : object;
        int n13 = n11 & 4;
        CharSequence charSequence3 = "";
        Object object5 = n13 != 0 ? charSequence3 : object2;
        int n14 = n11 & 8;
        if (n14 == 0) {
            charSequence3 = charSequence;
        }
        n14 = n11 & 0x10;
        n14 = n14 != 0 ? -1 : n10;
        int n15 = n11 & 0x20;
        CharSequence charSequence4 = n15 != 0 ? "..." : charSequence2;
        int n16 = n11 & 0x40;
        if (n16 != 0) {
            n16 = 0;
            l11 = null;
        } else {
            l11 = l10;
        }
        object = blArray;
        object2 = appendable;
        charSequence = object4;
        charSequence2 = charSequence3;
        return ArraysKt___ArraysKt.hg(blArray, appendable, (CharSequence)object4, (CharSequence)object5, charSequence3, n14, charSequence4, l11);
    }

    public static final Double qh(double[] object) {
        String string2 = "$this$lastOrNull";
        f0.p(object, string2);
        int n10 = ((double[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            n10 = ((double[])object).length - n11;
            double d10 = object[n10];
            object = d10;
        }
        return object;
    }

    public static final Byte qi(byte[] byArray) {
        f0.p(byArray, "$this$max");
        return ArraysKt___ArraysKt.mk(byArray);
    }

    private static final Comparable qj(Object[] objectArray, l l10) {
        Object object;
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 == 0) {
            object = objectArray[0];
            object = (Comparable)l10.invoke(object);
            n11 = ArraysKt___ArraysKt.Rd(objectArray);
            if (n12 <= n11) {
                while (true) {
                    Object object2 = objectArray[n12];
                    int n13 = object.compareTo(object2 = (Comparable)l10.invoke(object2));
                    if (n13 < 0) {
                        object = object2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object;
        }
        objectArray = new NoSuchElementException();
        throw objectArray;
    }

    public static final Double qk(Double[] doubleArray) {
        Object object = "$this$maxOrNull";
        f0.p(doubleArray, (String)object);
        int n10 = doubleArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        object = doubleArray[0];
        double d10 = (Double)object;
        int n12 = ArraysKt___ArraysKt.Rd(doubleArray);
        if (n11 <= n12) {
            while (true) {
                Double d11 = doubleArray[n11];
                double d12 = d11;
                d10 = Math.max(d10, d12);
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d10;
    }

    private static final double ql(byte[] object, l l10) {
        Number number;
        int n10 = ((byte[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            number = (byte)n10;
            number = (Number)l10.invoke(number);
            double d10 = number.doubleValue();
            int n12 = ArraysKt___ArraysKt.Ld(object);
            if (n11 <= n12) {
                while (true) {
                    byte by2 = object[n11];
                    Number number2 = by2;
                    number2 = (Number)l10.invoke(number2);
                    double d11 = number2.doubleValue();
                    d10 = Math.min(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Float qm(short[] sArray, l l10) {
        Number number;
        float f10;
        int n10 = sArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray[0];
        number = (short)n10;
        number = (Number)l10.invoke(number);
        f10 = number.floatValue();
        n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n12 <= n11) {
            while (true) {
                short s10 = sArray[n12];
                Number number2 = s10;
                number2 = (Number)l10.invoke(number2);
                float f12 = number2.floatValue();
                f10 = Math.min(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final boolean qn(double[] dArray) {
        String string2 = "$this$none";
        f0.p(dArray, string2);
        boolean bl2 = dArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            dArray = null;
        }
        return bl2;
    }

    public static final long qo(long[] object, e e10) {
        f0.p(object, "$this$random");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = ((long[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ((long[])object).length;
            int n11 = e10.m(n10);
            return object[n11];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final Boolean qp(boolean[] blArray, p p10) {
        f0.p(blArray, "$this$reduceOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = blArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = blArray[0];
        n11 = ArraysKt___ArraysKt.Td(blArray);
        if (n12 <= n11) {
            while (true) {
                object = n10 != 0;
                boolean bl2 = blArray[n12];
                Boolean bl3 = bl2;
                object = (Boolean)p10.invoke(object, bl3);
                n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return n10 != 0;
    }

    public static final void qq(float[] fArray) {
        String string2 = "$this$reverse";
        f0.p(fArray, string2);
        int n10 = fArray.length / 2 + -1;
        if (n10 < 0) {
            return;
        }
        int n11 = ArraysKt___ArraysKt.Od(fArray);
        int n12 = 0;
        if (n10 >= 0) {
            while (true) {
                float f10;
                float f11 = fArray[n12];
                fArray[n12] = f10 = fArray[n11];
                fArray[n11] = f11;
                n11 += -1;
                if (n12 == n10) break;
                ++n12;
            }
        }
    }

    private static final List qr(int[] nArray, p p10) {
        Number number;
        int n10 = nArray.length;
        ArrayList<Integer> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = nArray[0];
        int n12 = nArray.length;
        arrayList = new ArrayList<Integer>(n12);
        Integer n13 = n10;
        arrayList.add(n13);
        n12 = nArray.length;
        while (n11 < n12) {
            number = n10;
            int n14 = nArray[n11];
            Integer n15 = n14;
            number = (Number)p10.invoke(number, n15);
            n10 = number.intValue();
            n15 = n10;
            arrayList.add(n15);
            ++n11;
        }
        return arrayList;
    }

    public static final void qs(char[] cArray) {
        f0.p(cArray, "$this$shuffle");
        e$a e$a = e.b;
        ArraysKt___ArraysKt.rs(cArray, e$a);
    }

    public static final List qt(byte[] byArray, Iterable object) {
        byte by2;
        f0.p(byArray, "$this$slice");
        Object object2 = "indices";
        f0.p(object, (String)object2);
        int by22 = u.Y((Iterable)((Object)object), 10);
        if (by22 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(by22);
        object = object.iterator();
        while ((by2 = object.hasNext()) != 0) {
            byte by2 = ((Number)object.next()).intValue();
            by2 = byArray[by2];
            object2 = by2;
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final void qu(short[] sArray) {
        String string2 = "$this$sortDescending";
        f0.p(sArray, string2);
        int n10 = sArray.length;
        int n11 = 1;
        if (n10 > n11) {
            f.x1.n.t3(sArray);
            ArraysKt___ArraysKt.yq(sArray);
        }
    }

    public static final List qv(short[] sArray) {
        f0.p(sArray, "$this$sortedDescending");
        int n10 = sArray.length;
        sArray = Arrays.copyOf(sArray, n10);
        f0.o(sArray, "java.util.Arrays.copyOf(this, size)");
        f.x1.n.t3(sArray);
        return ArraysKt___ArraysKt.Jq(sArray);
    }

    private static final double qw(short[] sArray, l l10) {
        double d10 = 0.0;
        for (short s10 : sArray) {
            Number number = s10;
            number = (Number)l10.invoke(number);
            double d11 = number.doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final List qx(char[] object, int n10) {
        ArrayList<Character> arrayList = "$this$takeLast";
        f0.p(object, (String)((Object)arrayList));
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n12 = ((char[])object).length;
            if (n10 >= n12) {
                return ArraysKt___ArraysKt.py((char[])object);
            }
            if (n10 == n11) {
                return t.k(Character.valueOf((char)object[n12 -= n11]));
            }
            arrayList = new ArrayList<Character>(n10);
            for (n10 = n12 - n10; n10 < n12; ++n10) {
                Object object2 = object[n10];
                Character c10 = Character.valueOf((char)object2);
                arrayList.add(c10);
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List qy(double[] object) {
        String string2 = "$this$toList";
        f0.p(object, string2);
        int n10 = ((double[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                object = ArraysKt___ArraysKt.Ay(object);
            } else {
                n10 = 0;
                string2 = null;
                double d10 = object[0];
                object = t.k(d10);
            }
        } else {
            object = CollectionsKt__CollectionsKt.E();
        }
        return object;
    }

    public static final Iterable qz(short[] sArray) {
        f0.p(sArray, "$this$withIndex");
        ArraysKt___ArraysKt$withIndex$3 arraysKt___ArraysKt$withIndex$3 = new ArraysKt___ArraysKt$withIndex$3(sArray);
        j0 j02 = new j0(arraysKt___ArraysKt$withIndex$3);
        return j02;
    }

    public static final boolean r4(byte[] byArray, l l10) {
        f0.p(byArray, "$this$all");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = byArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Constable constable = Byte.valueOf(byArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static final Map r5(short[] sArray, l l10) {
        f0.p(sArray, "$this$associate");
        String string2 = "transform";
        f0.p(l10, string2);
        int n10 = s0.j(sArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (short s10 : sArray) {
            Object object = s10;
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            linkedHashMap.put(object2, object);
        }
        return linkedHashMap;
    }

    private static final Map r6(long[] lArray, l l10) {
        int n10 = f.l2.q.n(s0.j(lArray.length), 16);
        LinkedHashMap<Long, Object> linkedHashMap = new LinkedHashMap<Long, Object>(n10);
        for (long l11 : lArray) {
            Long l12 = l11;
            Object object = l11;
            object = l10.invoke(object);
            linkedHashMap.put(l12, object);
        }
        return linkedHashMap;
    }

    private static final byte r7(byte[] byArray) {
        f0.p(byArray, "$this$component4");
        return byArray[3];
    }

    public static final List r8(short[] sArray) {
        f0.p(sArray, "$this$distinct");
        return CollectionsKt___CollectionsKt.I5(ArraysKt___ArraysKt.Oy(sArray));
    }

    private static final long r9(long[] object, int n10, l l10) {
        long l11;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Qd((long[])object))) {
            l11 = object[n10];
        } else {
            object = n10;
            object = (Number)l10.invoke(object);
            l11 = ((Number)object).longValue();
        }
        return l11;
    }

    public static final List rA(boolean[] blArray, boolean[] blArray2, p p10) {
        f0.p(blArray, "$this$zip");
        f0.p(blArray2, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = blArray.length;
        int n11 = blArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = blArray[i10];
            Object object = bl2;
            boolean bl3 = blArray2[i10];
            Boolean bl4 = bl3;
            object = p10.invoke(object, bl4);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final Collection ra(Object[] objectArray, Collection collection) {
        f0.p(objectArray, "$this$filterNotNullTo");
        String string2 = "destination";
        f0.p(collection, string2);
        for (Object object : objectArray) {
            if (object == null) continue;
            collection.add(object);
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     */
    public static final short rb(short[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$first");
        String string2 = "predicate";
        f0.p(var1_2, string2);
        for (Object object2 : object) {
            Constable constable = Short.valueOf((short)object2);
            boolean bl2 = (Boolean)(constable = (Boolean)var1_2.invoke(constable));
            if (!bl2) continue;
            return (short)object2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Array contains no element matching the predicate.");
        throw noSuchElementException;
    }

    public static final Collection rc(byte[] byArray, Collection collection, l l10) {
        f0.p(byArray, "$this$flatMapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (byte by2 : byArray) {
            Object object = by2;
            object = (Iterable)l10.invoke(object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final void rd(short[] sArray, l l10) {
        f0.p(sArray, "$this$forEach");
        String string2 = "action";
        f0.p(l10, string2);
        for (short s10 : sArray) {
            Short s11 = s10;
            l10.invoke(s11);
        }
    }

    public static final Map re(double[] dArray, l l10, l l11) {
        f0.p(dArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        f0.p(l11, "valueTransform");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (double d10 : dArray) {
            Object object = d10;
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = d10;
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return linkedHashMap;
    }

    public static final int rf(double[] dArray, l l10) {
        f0.p(dArray, "$this$indexOfLast");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = dArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            double d10 = dArray[n10];
            Constable constable = Double.valueOf(d10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static final String rg(byte[] object, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(object, "$this$joinToString");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        StringBuilder stringBuilder = new StringBuilder();
        object = ((StringBuilder)ArraysKt___ArraysKt.Zf(object, stringBuilder, charSequence, charSequence2, charSequence3, n10, charSequence4, l10)).toString();
        f0.o(object, "joinTo(StringBuilder(), \u2026ed, transform).toString()");
        return object;
    }

    public static final Double rh(double[] dArray, l l10) {
        f0.p(dArray, "$this$lastOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = dArray.length;
        while ((n10 += -1) >= 0) {
            double d10 = dArray[n10];
            Constable constable = Double.valueOf(d10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return d10;
        }
        return null;
    }

    public static final Character ri(char[] cArray) {
        f0.p(cArray, "$this$max");
        return ArraysKt___ArraysKt.nk(cArray);
    }

    private static final Comparable rj(short[] object, l l10) {
        Comparable<Short> comparable;
        int n10 = ((short[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            comparable = (short)n10;
            comparable = (Comparable)l10.invoke(comparable);
            n11 = ArraysKt___ArraysKt.Sd(object);
            if (n12 <= n11) {
                while (true) {
                    short s10 = object[n12];
                    Comparable<Short> comparable2 = s10;
                    int n13 = comparable.compareTo((Short)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n13 < 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Float rk(float[] fArray) {
        float f10;
        String string2 = "$this$maxOrNull";
        f0.p(fArray, string2);
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            string2 = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        f10 = fArray[0];
        n11 = ArraysKt___ArraysKt.Od(fArray);
        if (n12 <= n11) {
            while (true) {
                float f12 = fArray[n12];
                f10 = Math.max(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    private static final double rl(char[] object, l l10) {
        Serializable serializable;
        int n10 = ((char[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            serializable = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            serializable = Character.valueOf((char)n10);
            serializable = (Number)l10.invoke(serializable);
            double d10 = ((Number)serializable).doubleValue();
            int n12 = ArraysKt___ArraysKt.Md(object);
            if (n11 <= n12) {
                while (true) {
                    char c10 = object[n11];
                    Serializable serializable2 = Character.valueOf(c10);
                    serializable2 = (Number)l10.invoke(serializable2);
                    double d11 = ((Number)serializable2).doubleValue();
                    d10 = Math.min(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Float rm(boolean[] blArray, l l10) {
        Serializable serializable;
        float f10;
        int n10 = blArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            serializable = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = blArray[0];
        serializable = Boolean.valueOf(n10 != 0);
        serializable = (Number)l10.invoke(serializable);
        f10 = ((Number)serializable).floatValue();
        n11 = ArraysKt___ArraysKt.Td(blArray);
        if (n12 <= n11) {
            while (true) {
                boolean bl2 = blArray[n12];
                Serializable serializable2 = Boolean.valueOf(bl2);
                serializable2 = (Number)l10.invoke(serializable2);
                float f12 = ((Number)serializable2).floatValue();
                f10 = Math.min(f10, f12);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final boolean rn(double[] dArray, l l10) {
        f0.p(dArray, "$this$none");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (double d10 : dArray) {
            Constable constable = Double.valueOf(d10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return false;
        }
        return true;
    }

    private static final Object ro(Object[] objectArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.so(objectArray, e$a);
    }

    public static final Byte rp(byte[] byArray, p p10) {
        f0.p(byArray, "$this$reduceOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = byArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray[0];
        n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n12 <= n11) {
            while (true) {
                object = (byte)n10;
                byte by2 = byArray[n12];
                Byte by3 = by2;
                object = (Number)p10.invoke(object, by3);
                n10 = ((Number)object).byteValue();
                if (n12 == n11) break;
                ++n12;
            }
        }
        return (byte)n10;
    }

    public static final void rq(float[] fArray, int n10, int n11) {
        f0.p(fArray, "$this$reverse");
        c$a c$a = c.a;
        int n12 = fArray.length;
        c$a.d(n10, n11, n12);
        int n13 = (n10 + n11) / 2;
        if (n10 == n13) {
            return;
        }
        n11 += -1;
        while (n10 < n13) {
            float f10;
            float f11 = fArray[n10];
            fArray[n10] = f10 = fArray[n11];
            fArray[n11] = f11;
            n11 += -1;
            ++n10;
        }
    }

    private static final List rr(long[] lArray, p p10) {
        Number number;
        int n10 = lArray.length;
        Long l10 = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        long l11 = lArray[0];
        int n12 = lArray.length;
        ArrayList<Long> arrayList = new ArrayList<Long>(n12);
        Long l12 = l11;
        arrayList.add(l12);
        n12 = lArray.length;
        while (n11 < n12) {
            number = l11;
            long l13 = lArray[n11];
            l10 = l13;
            number = (Number)p10.invoke(number, l10);
            l11 = number.longValue();
            Long l14 = l11;
            arrayList.add(l14);
            ++n11;
        }
        return arrayList;
    }

    public static final void rs(char[] cArray, e e10) {
        int n10;
        f0.p(cArray, "$this$shuffle");
        String string2 = "random";
        f0.p(e10, string2);
        for (int i10 = ArraysKt___ArraysKt.Md(cArray); i10 >= (n10 = 1); i10 += -1) {
            char c10;
            n10 = i10 + 1;
            n10 = e10.m(n10);
            char c11 = cArray[i10];
            cArray[i10] = c10 = cArray[n10];
            cArray[n10] = c11;
        }
    }

    public static final List rt(byte[] byArray, k k10) {
        f0.p(byArray, "$this$slice");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.n(f.x1.n.G1(byArray, n10, n11));
    }

    public static final void ru(short[] sArray, int n10, int n11) {
        f0.p(sArray, "$this$sortDescending");
        f.x1.n.u3(sArray, n10, n11);
        ArraysKt___ArraysKt.zq(sArray, n10, n11);
    }

    public static final List rv(byte[] objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$sortedWith");
        f0.p(comparator, "comparator");
        objectArray = f.x1.n.k4(objectArray);
        f.x1.n.E3(objectArray, comparator);
        return f.x1.n.t(objectArray);
    }

    private static final double rw(boolean[] blArray, l l10) {
        double d10 = 0.0;
        for (boolean bl2 : blArray) {
            Serializable serializable = Boolean.valueOf(bl2);
            serializable = (Number)l10.invoke(serializable);
            double d11 = ((Number)serializable).doubleValue();
            d10 += d11;
        }
        return d10;
    }

    public static final List rx(double[] object, int n10) {
        ArrayList<Double> arrayList = "$this$takeLast";
        f0.p(object, (String)((Object)arrayList));
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n12 = ((double[])object).length;
            if (n10 >= n12) {
                return ArraysKt___ArraysKt.qy((double[])object);
            }
            if (n10 == n11) {
                return t.k((double)object[n12 -= n11]);
            }
            arrayList = new ArrayList<Double>(n10);
            for (n10 = n12 - n10; n10 < n12; ++n10) {
                Object object2 = object[n10];
                Double d10 = (double)object2;
                arrayList.add(d10);
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List ry(float[] object) {
        String string2 = "$this$toList";
        f0.p(object, string2);
        int n10 = ((float[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                object = ArraysKt___ArraysKt.By(object);
            } else {
                n10 = 0;
                string2 = null;
                float f10 = object[0];
                object = t.k(Float.valueOf(f10));
            }
        } else {
            object = CollectionsKt__CollectionsKt.E();
        }
        return object;
    }

    public static final Iterable rz(boolean[] blArray) {
        f0.p(blArray, "$this$withIndex");
        ArraysKt___ArraysKt$withIndex$8 arraysKt___ArraysKt$withIndex$8 = new ArraysKt___ArraysKt$withIndex$8(blArray);
        j0 j02 = new j0(arraysKt___ArraysKt$withIndex$8);
        return j02;
    }

    public static final boolean s4(char[] cArray, l l10) {
        f0.p(cArray, "$this$all");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = cArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Comparable<Character> comparable = Character.valueOf(cArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static final Map s5(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$associate");
        String string2 = "transform";
        f0.p(l10, string2);
        int n10 = s0.j(blArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (boolean bl2 : blArray) {
            Object object = bl2;
            object = (Pair)l10.invoke(object);
            Object object2 = ((Pair)object).getFirst();
            object = ((Pair)object).getSecond();
            linkedHashMap.put(object2, object);
        }
        return linkedHashMap;
    }

    public static final Map s6(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$associateWith");
        f0.p(l10, "valueSelector");
        int n10 = f.l2.q.n(s0.j(objectArray.length), 16);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (Object object : objectArray) {
            Object object2 = l10.invoke(object);
            linkedHashMap.put(object, object2);
        }
        return linkedHashMap;
    }

    private static final char s7(char[] cArray) {
        f0.p(cArray, "$this$component4");
        return cArray[3];
    }

    public static final List s8(boolean[] blArray) {
        f0.p(blArray, "$this$distinct");
        return CollectionsKt___CollectionsKt.I5(ArraysKt___ArraysKt.Py(blArray));
    }

    private static final Object s9(Object[] object, int n10, l l10) {
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Rd(object))) {
            object = object[n10];
        } else {
            object = n10;
            object = l10.invoke(object);
        }
        return object;
    }

    public static final Collection sa(byte[] byArray, Collection collection, l l10) {
        f0.p(byArray, "$this$filterNotTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (byte by2 : byArray) {
            Constable constable = Byte.valueOf(by2);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            Byte by3 = by2;
            collection.add(by3);
        }
        return collection;
    }

    public static final boolean sb(boolean[] object) {
        String string2 = "$this$first";
        f0.p(object, string2);
        int n10 = ((boolean[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            return object[0];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final Collection sc(char[] cArray, Collection collection, l l10) {
        f0.p(cArray, "$this$flatMapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            object = (Iterable)l10.invoke(object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final void sd(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$forEach");
        String string2 = "action";
        f0.p(l10, string2);
        for (boolean bl2 : blArray) {
            Boolean bl3 = bl2;
            l10.invoke(bl3);
        }
    }

    public static final Map se(float[] fArray, l l10) {
        f0.p(fArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Float f11 = Float.valueOf(f10);
            object2.add((Float)f11);
        }
        return linkedHashMap;
    }

    public static final int sf(float[] fArray, l l10) {
        f0.p(fArray, "$this$indexOfLast");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = fArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            float f10 = fArray[n10];
            Constable constable = Float.valueOf(f10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static final String sg(char[] object, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(object, "$this$joinToString");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        StringBuilder stringBuilder = new StringBuilder();
        object = ((StringBuilder)ArraysKt___ArraysKt.ag(object, stringBuilder, charSequence, charSequence2, charSequence3, n10, charSequence4, l10)).toString();
        f0.o(object, "joinTo(StringBuilder(), \u2026ed, transform).toString()");
        return object;
    }

    public static final Float sh(float[] object) {
        String string2 = "$this$lastOrNull";
        f0.p(object, string2);
        int n10 = ((float[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            float f10 = 0.0f;
            object = null;
        } else {
            n10 = ((float[])object).length - n11;
            float f11 = object[n10];
            object = Float.valueOf(f11);
        }
        return object;
    }

    public static final Comparable si(Comparable[] comparableArray) {
        f0.p(comparableArray, "$this$max");
        return ArraysKt___ArraysKt.ok(comparableArray);
    }

    private static final Comparable sj(boolean[] object, l l10) {
        Comparable<Boolean> comparable;
        int n10 = ((boolean[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            comparable = n10 != 0;
            comparable = (Comparable)l10.invoke(comparable);
            n11 = ArraysKt___ArraysKt.Td(object);
            if (n12 <= n11) {
                while (true) {
                    boolean bl2 = object[n12];
                    Comparable<Boolean> comparable2 = bl2;
                    int n13 = comparable.compareTo((Boolean)(comparable2 = (Comparable)l10.invoke(comparable2)));
                    if (n13 < 0) {
                        comparable = comparable2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return comparable;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final Float sk(Float[] floatArray) {
        float f10;
        Object object = "$this$maxOrNull";
        f0.p(floatArray, (String)object);
        int n10 = floatArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            object = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        object = floatArray[0];
        f10 = ((Float)object).floatValue();
        n11 = ArraysKt___ArraysKt.Rd(floatArray);
        if (n12 <= n11) {
            while (true) {
                Float f12 = floatArray[n12];
                float f13 = f12.floatValue();
                f10 = Math.max(f10, f13);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    private static final double sl(double[] object, l l10) {
        Number number;
        int n10 = ((double[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 == 0) {
            number = object[0];
            number = (Number)l10.invoke(number);
            double d10 = number.doubleValue();
            int n12 = ArraysKt___ArraysKt.Nd(object);
            if (n11 <= n12) {
                while (true) {
                    Number number2 = object[n11];
                    number2 = (Number)l10.invoke(number2);
                    double d11 = number2.doubleValue();
                    d10 = Math.min(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object sm(byte[] object, Comparator comparator, l l10) {
        Object object2;
        int n10 = ((byte[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            object2 = (byte)n10;
            object2 = l10.invoke(object2);
            n11 = ArraysKt___ArraysKt.Ld(object);
            if (n12 <= n11) {
                while (true) {
                    byte by2 = object[n12];
                    Object object3 = by2;
                    int n13 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n13 > 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final boolean sn(float[] fArray) {
        String string2 = "$this$none";
        f0.p(fArray, string2);
        boolean bl2 = fArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            fArray = null;
        }
        return bl2;
    }

    public static final Object so(Object[] object, e e10) {
        f0.p(object, "$this$random");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = ((Object[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ((Object[])object).length;
            int n11 = e10.m(n10);
            return object[n11];
        }
        object = new NoSuchElementException("Array is empty.");
        throw object;
    }

    public static final Character sp(char[] cArray, p p10) {
        f0.p(cArray, "$this$reduceOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray[0];
        n11 = ArraysKt___ArraysKt.Md(cArray);
        if (n12 <= n11) {
            while (true) {
                object = Character.valueOf((char)n10);
                char c10 = cArray[n12];
                Character c11 = Character.valueOf(c10);
                object = (Character)p10.invoke(object, c11);
                n10 = ((Character)object).charValue();
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Character.valueOf((char)n10);
    }

    public static final void sq(int[] nArray) {
        String string2 = "$this$reverse";
        f0.p(nArray, string2);
        int n10 = nArray.length / 2 + -1;
        if (n10 < 0) {
            return;
        }
        int n11 = ArraysKt___ArraysKt.Pd(nArray);
        int n12 = 0;
        if (n10 >= 0) {
            while (true) {
                int n13;
                int n14 = nArray[n12];
                nArray[n12] = n13 = nArray[n11];
                nArray[n11] = n14;
                n11 += -1;
                if (n12 == n10) break;
                ++n12;
            }
        }
    }

    public static final List sr(Object[] objectArray, p p10) {
        f0.p(objectArray, "$this$runningReduce");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = objectArray.length;
        ArrayList<Object> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        object = objectArray[0];
        int n12 = objectArray.length;
        arrayList = new ArrayList<Object>(n12);
        arrayList.add(object);
        n12 = objectArray.length;
        while (n11 < n12) {
            Object object2 = objectArray[n11];
            object = p10.invoke(object, object2);
            arrayList.add(object);
            ++n11;
        }
        return arrayList;
    }

    public static final void ss(double[] dArray) {
        f0.p(dArray, "$this$shuffle");
        e$a e$a = e.b;
        ArraysKt___ArraysKt.ts(dArray, e$a);
    }

    public static final List st(char[] cArray, Iterable object) {
        char c10;
        f0.p(cArray, "$this$slice");
        Object object2 = "indices";
        f0.p(object, (String)object2);
        int c102 = u.Y((Iterable)((Object)object), 10);
        if (c102 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(c102);
        object = object.iterator();
        while ((c10 = object.hasNext()) != '\u0000') {
            char c10 = ((Number)object.next()).intValue();
            c10 = cArray[c10];
            object2 = Character.valueOf(c10);
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final List su(byte[] objectArray) {
        f0.p(objectArray, "$this$sorted");
        objectArray = f.x1.n.k4(objectArray);
        Objects.requireNonNull(objectArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        f.x1.n.r3(objectArray);
        return f.x1.n.t(objectArray);
    }

    public static final List sv(char[] objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$sortedWith");
        f0.p(comparator, "comparator");
        objectArray = f.x1.n.l4(objectArray);
        f.x1.n.E3(objectArray, comparator);
        return f.x1.n.t(objectArray);
    }

    public static final float sw(Float[] floatArray) {
        String string2 = "$this$sum";
        f0.p(floatArray, string2);
        int n10 = floatArray.length;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < n10; ++i10) {
            Float f11 = floatArray[i10];
            float f12 = f11.floatValue();
            f10 += f12;
        }
        return f10;
    }

    public static final List sx(float[] object, int n10) {
        ArrayList<Float> arrayList = "$this$takeLast";
        f0.p(object, (String)((Object)arrayList));
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n12 = ((float[])object).length;
            if (n10 >= n12) {
                return ArraysKt___ArraysKt.ry((float[])object);
            }
            if (n10 == n11) {
                return t.k(Float.valueOf((float)object[n12 -= n11]));
            }
            arrayList = new ArrayList<Float>(n10);
            for (n10 = n12 - n10; n10 < n12; ++n10) {
                Object object2 = object[n10];
                Float f10 = Float.valueOf((float)object2);
                arrayList.add(f10);
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List sy(int[] object) {
        String string2 = "$this$toList";
        f0.p(object, string2);
        int n10 = ((int[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                object = ArraysKt___ArraysKt.Cy(object);
            } else {
                n10 = 0;
                string2 = null;
                int n12 = object[0];
                object = t.k(n12);
            }
        } else {
            object = CollectionsKt__CollectionsKt.E();
        }
        return object;
    }

    public static final List sz(byte[] byArray, Iterable object) {
        boolean bl2;
        f0.p(byArray, "$this$zip");
        String string2 = "other";
        f0.p(object, string2);
        int n10 = byArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n11);
        object = object.iterator();
        n11 = 0;
        Pair pair = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            pair = w0.a(byArray[n11], e10);
            arrayList.add(pair);
            n11 = n12;
        }
        return arrayList;
    }

    public static final boolean t4(double[] dArray, l l10) {
        f0.p(dArray, "$this$all");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (double d10 : dArray) {
            Constable constable = Double.valueOf(d10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static final Map t5(byte[] byArray, l l10) {
        f0.p(byArray, "$this$associateBy");
        String string2 = "keySelector";
        f0.p(l10, string2);
        int n10 = s0.j(byArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Byte> linkedHashMap = new LinkedHashMap<Object, Byte>(n10);
        for (byte by2 : byArray) {
            Object object = by2;
            object = l10.invoke(object);
            Byte by3 = by2;
            linkedHashMap.put(object, by3);
        }
        return linkedHashMap;
    }

    private static final Map t6(short[] sArray, l l10) {
        int n10 = f.l2.q.n(s0.j(sArray.length), 16);
        LinkedHashMap<Short, Object> linkedHashMap = new LinkedHashMap<Short, Object>(n10);
        for (short s10 : sArray) {
            Short s11 = s10;
            Object object = s10;
            object = l10.invoke(object);
            linkedHashMap.put(s11, object);
        }
        return linkedHashMap;
    }

    private static final double t7(double[] dArray) {
        f0.p(dArray, "$this$component4");
        return dArray[3];
    }

    public static final List t8(byte[] byArray, l l10) {
        f0.p(byArray, "$this$distinctBy");
        f0.p(l10, "selector");
        HashSet<Object> hashSet = new HashSet<Object>();
        ArrayList<Byte> arrayList = new ArrayList<Byte>();
        for (byte by2 : byArray) {
            Object object = by2;
            boolean bl2 = hashSet.add(object = l10.invoke(object));
            if (!bl2) continue;
            Byte by3 = by2;
            arrayList.add(by3);
        }
        return arrayList;
    }

    private static final short t9(short[] object, int n10, l l10) {
        short s10;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Sd((short[])object))) {
            s10 = object[n10];
        } else {
            object = n10;
            object = (Number)l10.invoke(object);
            s10 = ((Number)object).shortValue();
        }
        return s10;
    }

    public static final Collection ta(char[] cArray, Collection collection, l l10) {
        f0.p(cArray, "$this$filterNotTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (char c10 : cArray) {
            Comparable<Character> comparable = Character.valueOf(c10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            Character c11 = Character.valueOf(c10);
            collection.add(c11);
        }
        return collection;
    }

    /*
     * WARNING - void declaration
     */
    public static final boolean tb(boolean[] object, l l10) {
        void var1_2;
        f0.p(object, "$this$first");
        String string2 = "predicate";
        f0.p(var1_2, string2);
        for (Object object2 : object) {
            Boolean bl2 = (boolean)object2;
            boolean bl3 = bl2 = (Boolean)var1_2.invoke(bl2);
            if (!bl3) continue;
            return (boolean)object2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Array contains no element matching the predicate.");
        throw noSuchElementException;
    }

    public static final Collection tc(double[] dArray, Collection collection, l l10) {
        f0.p(dArray, "$this$flatMapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (double d10 : dArray) {
            Object object = d10;
            object = (Iterable)l10.invoke(object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final void td(byte[] byArray, p p10) {
        f0.p(byArray, "$this$forEachIndexed");
        String string2 = "action";
        f0.p(p10, string2);
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Integer n12 = n11;
            ++n11;
            Byte by3 = by2;
            p10.invoke(n12, by3);
        }
    }

    public static final Map te(float[] fArray, l l10, l l11) {
        f0.p(fArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        f0.p(l11, "valueTransform");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = Float.valueOf(f10);
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return linkedHashMap;
    }

    public static final int tf(int[] nArray, l l10) {
        f0.p(nArray, "$this$indexOfLast");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = nArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            Constable constable = Integer.valueOf(nArray[n10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static final String tg(double[] object, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(object, "$this$joinToString");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        StringBuilder stringBuilder = new StringBuilder();
        object = ((StringBuilder)ArraysKt___ArraysKt.bg(object, stringBuilder, charSequence, charSequence2, charSequence3, n10, charSequence4, l10)).toString();
        f0.o(object, "joinTo(StringBuilder(), \u2026ed, transform).toString()");
        return object;
    }

    public static final Float th(float[] fArray, l l10) {
        f0.p(fArray, "$this$lastOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = fArray.length;
        while ((n10 += -1) >= 0) {
            float f10 = fArray[n10];
            Constable constable = Float.valueOf(f10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return Float.valueOf(f10);
        }
        return null;
    }

    public static final Double ti(double[] dArray) {
        f0.p(dArray, "$this$max");
        return ArraysKt___ArraysKt.pk(dArray);
    }

    private static final Comparable tj(byte[] byArray, l l10) {
        Comparable<Byte> comparable;
        int n10 = byArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = byArray[0];
        comparable = (byte)n10;
        comparable = (Comparable)l10.invoke(comparable);
        n11 = ArraysKt___ArraysKt.Ld(byArray);
        if (n12 <= n11) {
            while (true) {
                byte by2 = byArray[n12];
                Comparable<Byte> comparable2 = by2;
                int n13 = comparable.compareTo((Byte)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 < 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Integer tk(int[] nArray) {
        String string2 = "$this$maxOrNull";
        f0.p(nArray, string2);
        int n10 = nArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray[0];
        n11 = ArraysKt___ArraysKt.Pd(nArray);
        if (n12 <= n11) {
            while (true) {
                int n13;
                if (n10 < (n13 = nArray[n12])) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return n10;
    }

    private static final double tl(float[] object, l l10) {
        Number number;
        float f10;
        int n10 = ((float[])object).length;
        int n11 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n11;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            f10 = object[0];
            number = Float.valueOf(f10);
            number = (Number)l10.invoke(number);
            double d10 = number.doubleValue();
            int n12 = ArraysKt___ArraysKt.Od(object);
            if (n11 <= n12) {
                while (true) {
                    float f12 = object[n11];
                    Number number2 = Float.valueOf(f12);
                    number2 = (Number)l10.invoke(number2);
                    double d11 = number2.doubleValue();
                    d10 = Math.min(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object tm(char[] object, Comparator comparator, l l10) {
        Object object2;
        int n10 = ((char[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            object2 = Character.valueOf((char)n10);
            object2 = l10.invoke(object2);
            n11 = ArraysKt___ArraysKt.Md(object);
            if (n12 <= n11) {
                while (true) {
                    char c10 = object[n12];
                    Object object3 = Character.valueOf(c10);
                    int n13 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n13 > 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final boolean tn(float[] fArray, l l10) {
        f0.p(fArray, "$this$none");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (float f10 : fArray) {
            Constable constable = Float.valueOf(f10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return false;
        }
        return true;
    }

    private static final short to(short[] sArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.uo(sArray, e$a);
    }

    public static final Double tp(double[] dArray, p p10) {
        f0.p(dArray, "$this$reduceOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = dArray.length;
        Double d10 = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        double d11 = dArray[0];
        int n12 = ArraysKt___ArraysKt.Nd(dArray);
        if (n11 <= n12) {
            while (true) {
                object = d11;
                double d12 = dArray[n11];
                d10 = d12;
                object = (Number)p10.invoke(object, d10);
                d11 = ((Number)object).doubleValue();
                if (n11 == n12) break;
                ++n11;
            }
        }
        return d11;
    }

    public static final void tq(int[] nArray, int n10, int n11) {
        f0.p(nArray, "$this$reverse");
        c$a c$a = c.a;
        int n12 = nArray.length;
        c$a.d(n10, n11, n12);
        int n13 = (n10 + n11) / 2;
        if (n10 == n13) {
            return;
        }
        n11 += -1;
        while (n10 < n13) {
            int n14;
            n12 = nArray[n10];
            nArray[n10] = n14 = nArray[n11];
            nArray[n11] = n12;
            n11 += -1;
            ++n10;
        }
    }

    private static final List tr(short[] sArray, p p10) {
        Number number;
        int n10 = sArray.length;
        ArrayList<Short> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = sArray[0];
        int n12 = sArray.length;
        arrayList = new ArrayList<Short>(n12);
        Short s10 = (short)n10;
        arrayList.add(s10);
        n12 = sArray.length;
        while (n11 < n12) {
            number = (short)n10;
            short s11 = sArray[n11];
            Short s12 = s11;
            number = (Number)p10.invoke(number, s12);
            n10 = number.shortValue();
            s12 = (short)n10;
            arrayList.add(s12);
            ++n11;
        }
        return arrayList;
    }

    public static final void ts(double[] dArray, e e10) {
        int n10;
        f0.p(dArray, "$this$shuffle");
        String string2 = "random";
        f0.p(e10, string2);
        for (int i10 = ArraysKt___ArraysKt.Nd(dArray); i10 >= (n10 = 1); i10 += -1) {
            double d10;
            n10 = i10 + 1;
            n10 = e10.m(n10);
            double d11 = dArray[i10];
            dArray[i10] = d10 = dArray[n10];
            dArray[n10] = d11;
        }
    }

    public static final List tt(char[] cArray, k k10) {
        f0.p(cArray, "$this$slice");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.o(f.x1.n.H1(cArray, n10, n11));
    }

    public static final List tu(char[] objectArray) {
        f0.p(objectArray, "$this$sorted");
        objectArray = f.x1.n.l4(objectArray);
        Objects.requireNonNull(objectArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        f.x1.n.r3(objectArray);
        return f.x1.n.t(objectArray);
    }

    public static final List tv(double[] objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$sortedWith");
        f0.p(comparator, "comparator");
        objectArray = f.x1.n.m4(objectArray);
        f.x1.n.E3(objectArray, comparator);
        return f.x1.n.t(objectArray);
    }

    private static final int tw(byte[] byArray, l l10) {
        int n10 = byArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Number number = byArray[i10];
            number = (Number)l10.invoke(number);
            int n12 = number.intValue();
            n11 += n12;
        }
        return n11;
    }

    public static final List tx(int[] object, int n10) {
        ArrayList<Integer> arrayList = "$this$takeLast";
        f0.p(object, (String)((Object)arrayList));
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n12 = ((int[])object).length;
            if (n10 >= n12) {
                return ArraysKt___ArraysKt.sy((int[])object);
            }
            if (n10 == n11) {
                return t.k((int)object[n12 -= n11]);
            }
            arrayList = new ArrayList<Integer>(n10);
            for (n10 = n12 - n10; n10 < n12; ++n10) {
                Object object2 = object[n10];
                Integer n13 = (int)object2;
                arrayList.add(n13);
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List ty(long[] object) {
        String string2 = "$this$toList";
        f0.p(object, string2);
        int n10 = ((long[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                object = ArraysKt___ArraysKt.Dy(object);
            } else {
                n10 = 0;
                string2 = null;
                long l10 = object[0];
                object = t.k(l10);
            }
        } else {
            object = CollectionsKt__CollectionsKt.E();
        }
        return object;
    }

    public static final List tz(byte[] byArray, Iterable object, p p10) {
        boolean bl2;
        f0.p(byArray, "$this$zip");
        f0.p(object, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = byArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        n11 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            object2 = byArray[n11];
            object2 = p10.invoke(object2, e10);
            arrayList.add(object2);
            n11 = n12;
        }
        return arrayList;
    }

    public static final boolean u4(float[] fArray, l l10) {
        f0.p(fArray, "$this$all");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (float f10 : fArray) {
            Constable constable = Float.valueOf(f10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static final Map u5(byte[] byArray, l l10, l l11) {
        f0.p(byArray, "$this$associateBy");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        int n10 = s0.j(byArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (byte by2 : byArray) {
            Object object = by2;
            object = l10.invoke(object);
            Object object2 = by2;
            object2 = l11.invoke(object2);
            linkedHashMap.put(object, object2);
        }
        return linkedHashMap;
    }

    private static final Map u6(boolean[] blArray, l l10) {
        int n10 = f.l2.q.n(s0.j(blArray.length), 16);
        LinkedHashMap<Boolean, Object> linkedHashMap = new LinkedHashMap<Boolean, Object>(n10);
        for (boolean bl2 : blArray) {
            Boolean bl3 = bl2;
            Object object = bl2;
            object = l10.invoke(object);
            linkedHashMap.put(bl3, object);
        }
        return linkedHashMap;
    }

    private static final float u7(float[] fArray) {
        f0.p(fArray, "$this$component4");
        return fArray[3];
    }

    public static final List u8(char[] cArray, l l10) {
        f0.p(cArray, "$this$distinctBy");
        f0.p(l10, "selector");
        HashSet<Object> hashSet = new HashSet<Object>();
        ArrayList<Character> arrayList = new ArrayList<Character>();
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            boolean bl2 = hashSet.add(object = l10.invoke(object));
            if (!bl2) continue;
            Character c11 = Character.valueOf(c10);
            arrayList.add(c11);
        }
        return arrayList;
    }

    private static final boolean u9(boolean[] object, int n10, l l10) {
        boolean bl2;
        int n11;
        if (n10 >= 0 && n10 <= (n11 = ArraysKt___ArraysKt.Td((boolean[])object))) {
            bl2 = object[n10];
        } else {
            object = n10;
            object = (Boolean)l10.invoke(object);
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public static final Collection ua(double[] dArray, Collection collection, l l10) {
        f0.p(dArray, "$this$filterNotTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (double d10 : dArray) {
            Constable constable = Double.valueOf(d10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            Double d11 = d10;
            collection.add(d11);
        }
        return collection;
    }

    public static final Boolean ub(boolean[] object) {
        String string2 = "$this$firstOrNull";
        f0.p(object, string2);
        int n10 = ((boolean[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            boolean bl2 = false;
            object = null;
        } else {
            boolean bl3 = object[0];
            object = bl3;
        }
        return object;
    }

    public static final Collection uc(float[] fArray, Collection collection, l l10) {
        f0.p(fArray, "$this$flatMapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            object = (Iterable)l10.invoke(object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final void ud(char[] cArray, p p10) {
        f0.p(cArray, "$this$forEachIndexed");
        String string2 = "action";
        f0.p(p10, string2);
        int n10 = cArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = cArray[i10];
            Integer n12 = n11;
            ++n11;
            Character c11 = Character.valueOf(c10);
            p10.invoke(n12, c11);
        }
    }

    public static final Map ue(int[] nArray, l l10) {
        f0.p(nArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (int n10 : nArray) {
            Object object = n10;
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Integer n11 = n10;
            object2.add((Integer)n11);
        }
        return linkedHashMap;
    }

    public static final int uf(long[] lArray, l l10) {
        f0.p(lArray, "$this$indexOfLast");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = lArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            long l11 = lArray[n10];
            Constable constable = Long.valueOf(l11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static final String ug(float[] object, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(object, "$this$joinToString");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        StringBuilder stringBuilder = new StringBuilder();
        object = ((StringBuilder)ArraysKt___ArraysKt.cg(object, stringBuilder, charSequence, charSequence2, charSequence3, n10, charSequence4, l10)).toString();
        f0.o(object, "joinTo(StringBuilder(), \u2026ed, transform).toString()");
        return object;
    }

    public static final Integer uh(int[] object) {
        String string2 = "$this$lastOrNull";
        f0.p(object, string2);
        int n10 = ((int[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            boolean bl2 = false;
            object = null;
        } else {
            n10 = ((int[])object).length - n11;
            int n12 = object[n10];
            object = n12;
        }
        return object;
    }

    public static final Double ui(Double[] doubleArray) {
        f0.p(doubleArray, "$this$max");
        return ArraysKt___ArraysKt.qk(doubleArray);
    }

    private static final Comparable uj(char[] cArray, l l10) {
        Comparable<Character> comparable;
        int n10 = cArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = cArray[0];
        comparable = Character.valueOf((char)n10);
        comparable = (Comparable)l10.invoke(comparable);
        n11 = ArraysKt___ArraysKt.Md(cArray);
        if (n12 <= n11) {
            while (true) {
                char c10 = cArray[n12];
                Comparable<Character> comparable2 = Character.valueOf(c10);
                int n13 = comparable.compareTo((Character)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 < 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Long uk(long[] lArray) {
        String string2 = "$this$maxOrNull";
        f0.p(lArray, string2);
        int n10 = lArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        long l10 = lArray[0];
        int n12 = ArraysKt___ArraysKt.Qd(lArray);
        if (n11 <= n12) {
            while (true) {
                long l11;
                long l12;
                long l13;
                if ((l13 = (l12 = l10 - (l11 = lArray[n11])) == 0L ? 0 : (l12 < 0L ? -1 : 1)) < 0) {
                    l10 = l11;
                }
                if (n11 == n12) break;
                ++n11;
            }
        }
        return l10;
    }

    private static final double ul(int[] object, l l10) {
        Number number;
        int n10 = ((int[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            number = n10;
            number = (Number)l10.invoke(number);
            double d10 = number.doubleValue();
            int n12 = ArraysKt___ArraysKt.Pd(object);
            if (n11 <= n12) {
                while (true) {
                    int n13 = object[n11];
                    Number number2 = n13;
                    number2 = (Number)l10.invoke(number2);
                    double d11 = number2.doubleValue();
                    d10 = Math.min(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object um(double[] object, Comparator comparator, l l10) {
        Object object2;
        int n10 = ((double[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            double d10 = object[0];
            object2 = d10;
            object2 = l10.invoke(object2);
            n11 = ArraysKt___ArraysKt.Nd(object);
            if (n12 <= n11) {
                while (true) {
                    double d11 = object[n12];
                    Object object3 = d11;
                    int n13 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n13 > 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final boolean un(int[] nArray) {
        String string2 = "$this$none";
        f0.p(nArray, string2);
        boolean bl2 = nArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            nArray = null;
        }
        return bl2;
    }

    public static final short uo(short[] object, e e10) {
        f0.p(object, "$this$random");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = ((short[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ((short[])object).length;
            int n11 = e10.m(n10);
            return object[n11];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final Float up(float[] fArray, p p10) {
        float f10;
        f0.p(fArray, "$this$reduceOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            object = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        f10 = fArray[0];
        n11 = ArraysKt___ArraysKt.Od(fArray);
        if (n12 <= n11) {
            while (true) {
                object = Float.valueOf(f10);
                float f12 = fArray[n12];
                Float f13 = Float.valueOf(f12);
                object = (Number)p10.invoke(object, f13);
                f10 = ((Number)object).floatValue();
                if (n12 == n11) break;
                ++n12;
            }
        }
        return Float.valueOf(f10);
    }

    public static final void uq(long[] lArray) {
        String string2 = "$this$reverse";
        f0.p(lArray, string2);
        int n10 = lArray.length / 2 + -1;
        if (n10 < 0) {
            return;
        }
        int n11 = ArraysKt___ArraysKt.Qd(lArray);
        int n12 = 0;
        if (n10 >= 0) {
            while (true) {
                long l10;
                long l11 = lArray[n12];
                lArray[n12] = l10 = lArray[n11];
                lArray[n11] = l11;
                n11 += -1;
                if (n12 == n10) break;
                ++n12;
            }
        }
    }

    private static final List ur(boolean[] blArray, p p10) {
        Boolean bl2;
        int n10 = blArray.length;
        ArrayList<Boolean> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            bl2 = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = blArray[0];
        int n12 = blArray.length;
        arrayList = new ArrayList<Boolean>(n12);
        Boolean bl3 = n10 != 0;
        arrayList.add(bl3);
        n12 = blArray.length;
        while (n11 < n12) {
            bl2 = n10 != 0;
            boolean bl4 = blArray[n11];
            Boolean bl5 = bl4;
            bl2 = (Boolean)p10.invoke(bl2, bl5);
            n10 = (int)(bl2.booleanValue() ? 1 : 0);
            bl5 = n10 != 0;
            arrayList.add(bl5);
            ++n11;
        }
        return arrayList;
    }

    public static final void us(float[] fArray) {
        f0.p(fArray, "$this$shuffle");
        e$a e$a = e.b;
        ArraysKt___ArraysKt.vs(fArray, e$a);
    }

    public static final List ut(double[] dArray, Iterable object) {
        f0.p(dArray, "$this$slice");
        Object object2 = "indices";
        f0.p(object, (String)object2);
        int n10 = u.Y((Iterable)object, 10);
        if (n10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            n10 = ((Number)object.next()).intValue();
            double d10 = dArray[n10];
            object2 = d10;
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final List uu(double[] objectArray) {
        f0.p(objectArray, "$this$sorted");
        objectArray = f.x1.n.m4(objectArray);
        Objects.requireNonNull(objectArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        f.x1.n.r3(objectArray);
        return f.x1.n.t(objectArray);
    }

    public static final List uv(float[] objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$sortedWith");
        f0.p(comparator, "comparator");
        objectArray = f.x1.n.n4(objectArray);
        f.x1.n.E3(objectArray, comparator);
        return f.x1.n.t(objectArray);
    }

    private static final int uw(char[] cArray, l l10) {
        int n10 = cArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Serializable serializable = Character.valueOf(cArray[i10]);
            serializable = (Number)l10.invoke(serializable);
            int n12 = ((Number)serializable).intValue();
            n11 += n12;
        }
        return n11;
    }

    public static final List ux(long[] object, int n10) {
        ArrayList<Long> arrayList = "$this$takeLast";
        f0.p(object, (String)((Object)arrayList));
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n12 = ((long[])object).length;
            if (n10 >= n12) {
                return ArraysKt___ArraysKt.ty((long[])object);
            }
            if (n10 == n11) {
                return t.k((long)object[n12 -= n11]);
            }
            arrayList = new ArrayList<Long>(n10);
            for (n10 = n12 - n10; n10 < n12; ++n10) {
                Object object2 = object[n10];
                Long l10 = (long)object2;
                arrayList.add(l10);
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List uy(Object[] object) {
        String string2 = "$this$toList";
        f0.p(object, string2);
        int n10 = ((Object[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                object = ArraysKt___ArraysKt.Ey(object);
            } else {
                n10 = 0;
                string2 = null;
                object = t.k(object[0]);
            }
        } else {
            object = CollectionsKt__CollectionsKt.E();
        }
        return object;
    }

    public static final List uz(byte[] byArray, byte[] byArray2) {
        f0.p(byArray, "$this$zip");
        String string2 = "other";
        f0.p(byArray2, string2);
        int n10 = byArray.length;
        int n11 = byArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Byte> arrayList = new ArrayList<Byte>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            byte by3 = byArray2[i10];
            Serializable serializable = by2;
            Byte by4 = by3;
            serializable = w0.a(serializable, by4);
            arrayList.add((Byte)serializable);
        }
        return arrayList;
    }

    public static final boolean v4(int[] nArray, l l10) {
        f0.p(nArray, "$this$all");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = nArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Constable constable = Integer.valueOf(nArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static final Map v5(char[] cArray, l l10) {
        f0.p(cArray, "$this$associateBy");
        String string2 = "keySelector";
        f0.p(l10, string2);
        int n10 = s0.j(cArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Character> linkedHashMap = new LinkedHashMap<Object, Character>(n10);
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            object = l10.invoke(object);
            Character c11 = Character.valueOf(c10);
            linkedHashMap.put(object, c11);
        }
        return linkedHashMap;
    }

    private static final Map v6(byte[] byArray, Map map, l l10) {
        for (byte by2 : byArray) {
            Byte by3 = by2;
            Object object = by2;
            object = l10.invoke(object);
            map.put(by3, object);
        }
        return map;
    }

    private static final int v7(int[] nArray) {
        f0.p(nArray, "$this$component4");
        return nArray[3];
    }

    public static final List v8(double[] dArray, l l10) {
        f0.p(dArray, "$this$distinctBy");
        f0.p(l10, "selector");
        HashSet<Object> hashSet = new HashSet<Object>();
        ArrayList<Double> arrayList = new ArrayList<Double>();
        for (double d10 : dArray) {
            Object object = d10;
            boolean bl2 = hashSet.add(object = l10.invoke(object));
            if (!bl2) continue;
            Double d11 = d10;
            arrayList.add(d11);
        }
        return arrayList;
    }

    private static final Boolean v9(boolean[] blArray, int n10) {
        return ArraysKt___ArraysKt.de(blArray, n10);
    }

    public static final Collection va(float[] fArray, Collection collection, l l10) {
        f0.p(fArray, "$this$filterNotTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (float f10 : fArray) {
            Constable constable = Float.valueOf(f10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            Float f11 = Float.valueOf(f10);
            collection.add(f11);
        }
        return collection;
    }

    public static final Boolean vb(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$firstOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (boolean bl2 : blArray) {
            Boolean bl3 = bl2;
            boolean bl4 = bl3 = (Boolean)l10.invoke(bl3);
            if (!bl4) continue;
            return bl2;
        }
        return null;
    }

    public static final Collection vc(int[] nArray, Collection collection, l l10) {
        f0.p(nArray, "$this$flatMapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (int n10 : nArray) {
            Object object = n10;
            object = (Iterable)l10.invoke(object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final void vd(double[] dArray, p p10) {
        f0.p(dArray, "$this$forEachIndexed");
        String string2 = "action";
        f0.p(p10, string2);
        int n10 = dArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            Integer n12 = n11;
            ++n11;
            Double d11 = d10;
            p10.invoke(n12, d11);
        }
    }

    public static final Map ve(int[] nArray, l l10, l l11) {
        f0.p(nArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        f0.p(l11, "valueTransform");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (int n10 : nArray) {
            Object object = n10;
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = n10;
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return linkedHashMap;
    }

    public static final int vf(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$indexOfLast");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = objectArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            Object object = objectArray[n10];
            boolean bl2 = (Boolean)(object = (Boolean)l10.invoke(object));
            if (bl2) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static final String vg(int[] object, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(object, "$this$joinToString");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        StringBuilder stringBuilder = new StringBuilder();
        object = ((StringBuilder)ArraysKt___ArraysKt.dg(object, stringBuilder, charSequence, charSequence2, charSequence3, n10, charSequence4, l10)).toString();
        f0.o(object, "joinTo(StringBuilder(), \u2026ed, transform).toString()");
        return object;
    }

    public static final Integer vh(int[] nArray, l l10) {
        f0.p(nArray, "$this$lastOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = nArray.length;
        while ((n10 += -1) >= 0) {
            int n11 = nArray[n10];
            Constable constable = Integer.valueOf(n11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return n11;
        }
        return null;
    }

    public static final Float vi(float[] fArray) {
        f0.p(fArray, "$this$max");
        return ArraysKt___ArraysKt.rk(fArray);
    }

    private static final Comparable vj(double[] dArray, l l10) {
        Comparable<Double> comparable;
        int n10 = dArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 != 0) {
            return null;
        }
        double d10 = dArray[0];
        comparable = d10;
        comparable = (Comparable)l10.invoke(comparable);
        n11 = ArraysKt___ArraysKt.Nd(dArray);
        if (n12 <= n11) {
            while (true) {
                double d11 = dArray[n12];
                Comparable<Double> comparable2 = d11;
                int n13 = comparable.compareTo((Double)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 < 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Short vk(short[] sArray) {
        String string2 = "$this$maxOrNull";
        f0.p(sArray, string2);
        int n10 = sArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray[0];
        n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n12 <= n11) {
            while (true) {
                int n13;
                if (n10 < (n13 = sArray[n12])) {
                    n10 = n13;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return (short)n10;
    }

    private static final double vl(long[] object, l l10) {
        Number number;
        int n10 = ((long[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 == 0) {
            long l11 = object[0];
            number = l11;
            number = (Number)l10.invoke(number);
            double d10 = number.doubleValue();
            int n12 = ArraysKt___ArraysKt.Qd(object);
            if (n11 <= n12) {
                while (true) {
                    long l12 = object[n11];
                    Number number2 = l12;
                    number2 = (Number)l10.invoke(number2);
                    double d11 = number2.doubleValue();
                    d10 = Math.min(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object vm(float[] object, Comparator comparator, l l10) {
        Object object2;
        float f10;
        int n10 = ((float[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            object2 = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            f10 = object[0];
            object2 = Float.valueOf(f10);
            object2 = l10.invoke(object2);
            n11 = ArraysKt___ArraysKt.Od(object);
            if (n12 <= n11) {
                while (true) {
                    float f12 = object[n12];
                    Object object3 = Float.valueOf(f12);
                    int n13 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n13 > 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final boolean vn(int[] nArray, l l10) {
        f0.p(nArray, "$this$none");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = nArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Constable constable = Integer.valueOf(nArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return false;
        }
        return true;
    }

    private static final boolean vo(boolean[] blArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.wo(blArray, e$a);
    }

    public static final Integer vp(int[] nArray, p p10) {
        f0.p(nArray, "$this$reduceOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = nArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray[0];
        n11 = ArraysKt___ArraysKt.Pd(nArray);
        if (n12 <= n11) {
            while (true) {
                object = n10;
                int n13 = nArray[n12];
                Integer n14 = n13;
                object = (Number)p10.invoke(object, n14);
                n10 = ((Number)object).intValue();
                if (n12 == n11) break;
                ++n12;
            }
        }
        return n10;
    }

    public static final void vq(long[] lArray, int n10, int n11) {
        f0.p(lArray, "$this$reverse");
        c$a c$a = c.a;
        int n12 = lArray.length;
        c$a.d(n10, n11, n12);
        int n13 = (n10 + n11) / 2;
        if (n10 == n13) {
            return;
        }
        n11 += -1;
        while (n10 < n13) {
            long l10;
            long l11 = lArray[n10];
            lArray[n10] = l10 = lArray[n11];
            lArray[n11] = l11;
            n11 += -1;
            ++n10;
        }
    }

    private static final List vr(byte[] byArray, q q10) {
        Number number;
        int n10 = byArray.length;
        ArrayList<Number> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = byArray[0];
        int n12 = byArray.length;
        arrayList = new ArrayList<Number>(n12);
        Byte by2 = (byte)n10;
        arrayList.add(by2);
        n12 = byArray.length;
        while (n11 < n12) {
            Number number2 = n11;
            number = (byte)n10;
            byte by3 = byArray[n11];
            Byte by4 = by3;
            number = (Number)q10.invoke(number2, number, by4);
            n10 = number.byteValue();
            number2 = (byte)n10;
            arrayList.add(number2);
            ++n11;
        }
        return arrayList;
    }

    public static final void vs(float[] fArray, e e10) {
        int n10;
        f0.p(fArray, "$this$shuffle");
        String string2 = "random";
        f0.p(e10, string2);
        for (int i10 = ArraysKt___ArraysKt.Od(fArray); i10 >= (n10 = 1); i10 += -1) {
            float f10;
            n10 = i10 + 1;
            n10 = e10.m(n10);
            float f11 = fArray[i10];
            fArray[i10] = f10 = fArray[n10];
            fArray[n10] = f11;
        }
    }

    public static final List vt(double[] dArray, k k10) {
        f0.p(dArray, "$this$slice");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.p(f.x1.n.I1(dArray, n10, n11));
    }

    public static final List vu(float[] objectArray) {
        f0.p(objectArray, "$this$sorted");
        objectArray = f.x1.n.n4(objectArray);
        Objects.requireNonNull(objectArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        f.x1.n.r3(objectArray);
        return f.x1.n.t(objectArray);
    }

    public static final List vv(int[] objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$sortedWith");
        f0.p(comparator, "comparator");
        objectArray = f.x1.n.o4(objectArray);
        f.x1.n.E3(objectArray, comparator);
        return f.x1.n.t(objectArray);
    }

    private static final int vw(double[] dArray, l l10) {
        int n10 = dArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            Number number = d10;
            number = (Number)l10.invoke(number);
            int n12 = number.intValue();
            n11 += n12;
        }
        return n11;
    }

    public static final List vx(Object[] object, int n10) {
        ArrayList<Object> arrayList = "$this$takeLast";
        f0.p(object, (String)((Object)arrayList));
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n12 = ((Object[])object).length;
            if (n10 >= n12) {
                return ArraysKt___ArraysKt.uy((Object[])object);
            }
            if (n10 == n11) {
                return t.k(object[n12 -= n11]);
            }
            arrayList = new ArrayList<Object>(n10);
            for (n10 = n12 - n10; n10 < n12; ++n10) {
                Object object2 = object[n10];
                arrayList.add(object2);
            }
            return arrayList;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List vy(short[] object) {
        String string2 = "$this$toList";
        f0.p(object, string2);
        int n10 = ((short[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                object = ArraysKt___ArraysKt.Fy(object);
            } else {
                n10 = 0;
                string2 = null;
                short s10 = object[0];
                object = t.k(s10);
            }
        } else {
            object = CollectionsKt__CollectionsKt.E();
        }
        return object;
    }

    public static final List vz(byte[] byArray, byte[] byArray2, p p10) {
        f0.p(byArray, "$this$zip");
        f0.p(byArray2, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = byArray.length;
        int n11 = byArray2.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Object object = by2;
            byte by3 = byArray2[i10];
            Byte by4 = by3;
            object = p10.invoke(object, by4);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final boolean w4(long[] lArray, l l10) {
        f0.p(lArray, "$this$all");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (long l11 : lArray) {
            Constable constable = Long.valueOf(l11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static final Map w5(char[] cArray, l l10, l l11) {
        f0.p(cArray, "$this$associateBy");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        int n10 = s0.j(cArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (char c10 : cArray) {
            Object object = Character.valueOf(c10);
            object = l10.invoke(object);
            Object object2 = Character.valueOf(c10);
            object2 = l11.invoke(object2);
            linkedHashMap.put(object, object2);
        }
        return linkedHashMap;
    }

    private static final Map w6(char[] cArray, Map map, l l10) {
        for (char c10 : cArray) {
            Character c11 = Character.valueOf(c10);
            Object object = Character.valueOf(c10);
            object = l10.invoke(object);
            map.put(c11, object);
        }
        return map;
    }

    private static final long w7(long[] lArray) {
        f0.p(lArray, "$this$component4");
        return lArray[3];
    }

    public static final List w8(float[] fArray, l l10) {
        f0.p(fArray, "$this$distinctBy");
        f0.p(l10, "selector");
        HashSet<Object> hashSet = new HashSet<Object>();
        ArrayList<Float> arrayList = new ArrayList<Float>();
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            boolean bl2 = hashSet.add(object = l10.invoke(object));
            if (!bl2) continue;
            Float f11 = Float.valueOf(f10);
            arrayList.add(f11);
        }
        return arrayList;
    }

    private static final Byte w9(byte[] byArray, int n10) {
        return ArraysKt___ArraysKt.ee(byArray, n10);
    }

    public static final Collection wa(int[] nArray, Collection collection, l l10) {
        f0.p(nArray, "$this$filterNotTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int n10 : nArray) {
            Constable constable = Integer.valueOf(n10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            Integer n11 = n10;
            collection.add(n11);
        }
        return collection;
    }

    public static final Byte wb(byte[] object) {
        String string2 = "$this$firstOrNull";
        f0.p(object, string2);
        int n10 = ((byte[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            boolean bl2 = false;
            object = null;
        } else {
            byte by2 = object[0];
            object = by2;
        }
        return object;
    }

    public static final Collection wc(long[] lArray, Collection collection, l l10) {
        f0.p(lArray, "$this$flatMapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (long l11 : lArray) {
            Object object = l11;
            object = (Iterable)l10.invoke(object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final void wd(float[] fArray, p p10) {
        f0.p(fArray, "$this$forEachIndexed");
        String string2 = "action";
        f0.p(p10, string2);
        int n10 = fArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Integer n12 = n11;
            ++n11;
            Float f11 = Float.valueOf(f10);
            p10.invoke(n12, f11);
        }
    }

    public static final Map we(long[] lArray, l l10) {
        f0.p(lArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (long l11 : lArray) {
            Object object = l11;
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Long l12 = l11;
            object2.add((Long)l12);
        }
        return linkedHashMap;
    }

    public static final int wf(short[] sArray, l l10) {
        f0.p(sArray, "$this$indexOfLast");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = sArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            Constable constable = Short.valueOf(sArray[n10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static final String wg(long[] object, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(object, "$this$joinToString");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        StringBuilder stringBuilder = new StringBuilder();
        object = ((StringBuilder)ArraysKt___ArraysKt.eg(object, stringBuilder, charSequence, charSequence2, charSequence3, n10, charSequence4, l10)).toString();
        f0.o(object, "joinTo(StringBuilder(), \u2026ed, transform).toString()");
        return object;
    }

    public static final Long wh(long[] object) {
        String string2 = "$this$lastOrNull";
        f0.p(object, string2);
        int n10 = ((long[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            n10 = ((long[])object).length - n11;
            long l10 = object[n10];
            object = l10;
        }
        return object;
    }

    public static final Float wi(Float[] floatArray) {
        f0.p(floatArray, "$this$max");
        return ArraysKt___ArraysKt.sk(floatArray);
    }

    private static final Comparable wj(float[] fArray, l l10) {
        Comparable<Float> comparable;
        float f10;
        int n10 = fArray.length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            comparable = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return null;
        }
        f10 = fArray[0];
        comparable = Float.valueOf(f10);
        comparable = (Comparable)l10.invoke(comparable);
        n11 = ArraysKt___ArraysKt.Od(fArray);
        if (n12 <= n11) {
            while (true) {
                float f12 = fArray[n12];
                Comparable<Float> comparable2 = Float.valueOf(f12);
                int n13 = comparable.compareTo((Float)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 < 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Boolean wk(boolean[] blArray, Comparator comparator) {
        f0.p(blArray, "$this$maxWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Fk(blArray, comparator);
    }

    private static final double wl(Object[] objectArray, l l10) {
        Object object;
        int n10 = objectArray.length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 == 0) {
            object = objectArray[0];
            object = (Number)l10.invoke(object);
            double d10 = ((Number)object).doubleValue();
            int n12 = ArraysKt___ArraysKt.Rd(objectArray);
            if (n11 <= n12) {
                while (true) {
                    Object object2 = objectArray[n11];
                    object2 = (Number)l10.invoke(object2);
                    double d11 = ((Number)object2).doubleValue();
                    d10 = Math.min(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        objectArray = new NoSuchElementException();
        throw objectArray;
    }

    private static final Object wm(int[] object, Comparator comparator, l l10) {
        Object object2;
        int n10 = ((int[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            object2 = n10;
            object2 = l10.invoke(object2);
            n11 = ArraysKt___ArraysKt.Pd(object);
            if (n12 <= n11) {
                while (true) {
                    int n13 = object[n12];
                    Object object3 = n13;
                    int n14 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n14 > 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final boolean wn(long[] lArray) {
        String string2 = "$this$none";
        f0.p(lArray, string2);
        boolean bl2 = lArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            lArray = null;
        }
        return bl2;
    }

    public static final boolean wo(boolean[] object, e e10) {
        f0.p(object, "$this$random");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = ((boolean[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 == 0) {
            n10 = ((boolean[])object).length;
            int n11 = e10.m(n10);
            return object[n11];
        }
        object = new NoSuchElementException;
        object("Array is empty.");
        throw object;
    }

    public static final Long wp(long[] lArray, p p10) {
        f0.p(lArray, "$this$reduceOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = lArray.length;
        Long l10 = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        long l11 = lArray[0];
        int n12 = ArraysKt___ArraysKt.Qd(lArray);
        if (n11 <= n12) {
            while (true) {
                object = l11;
                long l12 = lArray[n11];
                l10 = l12;
                object = (Number)p10.invoke(object, l10);
                l11 = ((Number)object).longValue();
                if (n11 == n12) break;
                ++n11;
            }
        }
        return l11;
    }

    public static final void wq(Object[] objectArray) {
        String string2 = "$this$reverse";
        f0.p(objectArray, string2);
        int n10 = objectArray.length / 2 + -1;
        if (n10 < 0) {
            return;
        }
        int n11 = ArraysKt___ArraysKt.Rd(objectArray);
        int n12 = 0;
        if (n10 >= 0) {
            while (true) {
                Object object;
                Object object2 = objectArray[n12];
                objectArray[n12] = object = objectArray[n11];
                objectArray[n11] = object2;
                n11 += -1;
                if (n12 == n10) break;
                ++n12;
            }
        }
    }

    private static final List wr(char[] cArray, q q10) {
        Character c10;
        int n10 = cArray.length;
        ArrayList<Comparable<Character>> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            c10 = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = cArray[0];
        int n12 = cArray.length;
        arrayList = new ArrayList<Comparable<Character>>(n12);
        Character c11 = Character.valueOf((char)n10);
        arrayList.add(c11);
        n12 = cArray.length;
        while (n11 < n12) {
            Constable constable = n11;
            c10 = Character.valueOf((char)n10);
            char c12 = cArray[n11];
            Character c13 = Character.valueOf(c12);
            c10 = (Character)q10.invoke(constable, c10, c13);
            n10 = c10.charValue();
            constable = Character.valueOf((char)n10);
            arrayList.add((Comparable<Character>)((Object)constable));
            ++n11;
        }
        return arrayList;
    }

    public static final void ws(int[] nArray) {
        f0.p(nArray, "$this$shuffle");
        e$a e$a = e.b;
        ArraysKt___ArraysKt.xs(nArray, e$a);
    }

    public static final List wt(float[] fArray, Iterable object) {
        f0.p(fArray, "$this$slice");
        Object object2 = "indices";
        f0.p(object, (String)object2);
        float f10 = 1.4E-44f;
        int n10 = u.Y((Iterable)object, 10);
        if (n10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            n10 = ((Number)object.next()).intValue();
            f10 = fArray[n10];
            object2 = Float.valueOf(f10);
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final List wu(int[] objectArray) {
        f0.p(objectArray, "$this$sorted");
        objectArray = f.x1.n.o4(objectArray);
        Objects.requireNonNull(objectArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        f.x1.n.r3(objectArray);
        return f.x1.n.t(objectArray);
    }

    public static final List wv(long[] objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$sortedWith");
        f0.p(comparator, "comparator");
        objectArray = f.x1.n.p4(objectArray);
        f.x1.n.E3(objectArray, comparator);
        return f.x1.n.t(objectArray);
    }

    private static final int ww(float[] fArray, l l10) {
        int n10 = fArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            Number number = Float.valueOf(f10);
            number = (Number)l10.invoke(number);
            int n12 = number.intValue();
            n11 += n12;
        }
        return n11;
    }

    public static final List wx(short[] object, int n10) {
        ArrayList<Short> arrayList = "$this$takeLast";
        f0.p(object, (String)((Object)arrayList));
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n12 = ((short[])object).length;
            if (n10 >= n12) {
                return ArraysKt___ArraysKt.vy((short[])object);
            }
            if (n10 == n11) {
                return t.k((short)object[n12 -= n11]);
            }
            arrayList = new ArrayList<Short>(n10);
            for (n10 = n12 - n10; n10 < n12; ++n10) {
                Object object2 = object[n10];
                Short s10 = (short)object2;
                arrayList.add(s10);
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final List wy(boolean[] object) {
        String string2 = "$this$toList";
        f0.p(object, string2);
        int n10 = ((boolean[])object).length;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                object = ArraysKt___ArraysKt.Gy(object);
            } else {
                n10 = 0;
                string2 = null;
                boolean bl2 = object[0];
                object = t.k(bl2);
            }
        } else {
            object = CollectionsKt__CollectionsKt.E();
        }
        return object;
    }

    public static final List wz(byte[] byArray, Object[] objectArray) {
        f0.p(byArray, "$this$zip");
        String string2 = "other";
        f0.p(objectArray, string2);
        int n10 = byArray.length;
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Object object = objectArray[i10];
            Pair pair = w0.a(by2, object);
            arrayList.add(pair);
        }
        return arrayList;
    }

    public static final boolean x4(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$all");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (Object object : objectArray) {
            boolean bl2 = (Boolean)(object = (Boolean)l10.invoke(object));
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static final Map x5(double[] dArray, l l10) {
        f0.p(dArray, "$this$associateBy");
        String string2 = "keySelector";
        f0.p(l10, string2);
        int n10 = s0.j(dArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Double> linkedHashMap = new LinkedHashMap<Object, Double>(n10);
        for (double d10 : dArray) {
            Object object = d10;
            object = l10.invoke(object);
            Double d11 = d10;
            linkedHashMap.put(object, d11);
        }
        return linkedHashMap;
    }

    private static final Map x6(double[] dArray, Map map, l l10) {
        for (double d10 : dArray) {
            Double d11 = d10;
            Object object = d10;
            object = l10.invoke(object);
            map.put(d11, object);
        }
        return map;
    }

    private static final Object x7(Object[] objectArray) {
        f0.p(objectArray, "$this$component4");
        return objectArray[3];
    }

    public static final List x8(int[] nArray, l l10) {
        f0.p(nArray, "$this$distinctBy");
        f0.p(l10, "selector");
        HashSet<Object> hashSet = new HashSet<Object>();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int n10 : nArray) {
            Object object = n10;
            boolean bl2 = hashSet.add(object = l10.invoke(object));
            if (!bl2) continue;
            Integer n11 = n10;
            arrayList.add(n11);
        }
        return arrayList;
    }

    private static final Character x9(char[] cArray, int n10) {
        return ArraysKt___ArraysKt.fe(cArray, n10);
    }

    public static final Collection xa(long[] lArray, Collection collection, l l10) {
        f0.p(lArray, "$this$filterNotTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (long l11 : lArray) {
            Constable constable = Long.valueOf(l11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            Long l12 = l11;
            collection.add(l12);
        }
        return collection;
    }

    public static final Byte xb(byte[] byArray, l l10) {
        f0.p(byArray, "$this$firstOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (byte by2 : byArray) {
            Constable constable = Byte.valueOf(by2);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return by2;
        }
        return null;
    }

    public static final Collection xc(Object[] objectArray, Collection collection, l l10) {
        f0.p(objectArray, "$this$flatMapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (Object object : objectArray) {
            object = (Iterable)l10.invoke(object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final void xd(int[] nArray, p p10) {
        f0.p(nArray, "$this$forEachIndexed");
        String string2 = "action";
        f0.p(p10, string2);
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            Integer n13 = n11;
            ++n11;
            Integer n14 = n12;
            p10.invoke(n13, n14);
        }
    }

    public static final Map xe(long[] lArray, l l10, l l11) {
        f0.p(lArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        f0.p(l11, "valueTransform");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (long l12 : lArray) {
            Object object = l12;
            Object object2 = linkedHashMap.get(object = l10.invoke(object));
            if (object2 == null) {
                object2 = new ArrayList();
                linkedHashMap.put(object, object2);
            }
            object2 = (List)object2;
            Object object3 = l12;
            object3 = l11.invoke(object3);
            object2.add((Object)object3);
        }
        return linkedHashMap;
    }

    public static final int xf(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$indexOfLast");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = blArray.length;
        int n11 = -1;
        n10 += n11;
        while (n10 >= 0) {
            Boolean bl2 = blArray[n10];
            boolean bl3 = bl2 = (Boolean)l10.invoke(bl2);
            if (bl3) {
                return n10;
            }
            n10 += -1;
        }
        return n11;
    }

    public static final String xg(Object[] object, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(object, "$this$joinToString");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        StringBuilder stringBuilder = new StringBuilder();
        object = ((StringBuilder)ArraysKt___ArraysKt.fg(object, stringBuilder, charSequence, charSequence2, charSequence3, n10, charSequence4, l10)).toString();
        f0.o(object, "joinTo(StringBuilder(), \u2026ed, transform).toString()");
        return object;
    }

    public static final Long xh(long[] lArray, l l10) {
        f0.p(lArray, "$this$lastOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = lArray.length;
        while ((n10 += -1) >= 0) {
            long l11 = lArray[n10];
            Constable constable = Long.valueOf(l11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return l11;
        }
        return null;
    }

    public static final Integer xi(int[] nArray) {
        f0.p(nArray, "$this$max");
        return ArraysKt___ArraysKt.tk(nArray);
    }

    private static final Comparable xj(int[] nArray, l l10) {
        Comparable<Integer> comparable;
        int n10 = nArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = nArray[0];
        comparable = n10;
        comparable = (Comparable)l10.invoke(comparable);
        n11 = ArraysKt___ArraysKt.Pd(nArray);
        if (n12 <= n11) {
            while (true) {
                int n13 = nArray[n12];
                Comparable<Integer> comparable2 = n13;
                int n14 = comparable.compareTo((Integer)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n14 < 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Byte xk(byte[] byArray, Comparator comparator) {
        f0.p(byArray, "$this$maxWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Gk(byArray, comparator);
    }

    private static final double xl(short[] object, l l10) {
        Number number;
        int n10 = ((short[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            number = (short)n10;
            number = (Number)l10.invoke(number);
            double d10 = number.doubleValue();
            int n12 = ArraysKt___ArraysKt.Sd(object);
            if (n11 <= n12) {
                while (true) {
                    short s10 = object[n11];
                    Number number2 = s10;
                    number2 = (Number)l10.invoke(number2);
                    double d11 = number2.doubleValue();
                    d10 = Math.min(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object xm(long[] object, Comparator comparator, l l10) {
        Object object2;
        int n10 = ((long[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            long l11 = object[0];
            object2 = l11;
            object2 = l10.invoke(object2);
            n11 = ArraysKt___ArraysKt.Qd(object);
            if (n12 <= n11) {
                while (true) {
                    long l12 = object[n12];
                    Object object3 = l12;
                    int n13 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n13 > 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final boolean xn(long[] lArray, l l10) {
        f0.p(lArray, "$this$none");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (long l11 : lArray) {
            Constable constable = Long.valueOf(l11);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (!bl2) continue;
            return false;
        }
        return true;
    }

    private static final Boolean xo(boolean[] blArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.yo(blArray, e$a);
    }

    public static final Object xp(Object[] objectArray, p p10) {
        f0.p(objectArray, "$this$reduceOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        object = objectArray[0];
        n11 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n12 <= n11) {
            while (true) {
                Object object2 = objectArray[n12];
                object = p10.invoke(object, object2);
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final void xq(Object[] objectArray, int n10, int n11) {
        f0.p(objectArray, "$this$reverse");
        c$a c$a = c.a;
        int n12 = objectArray.length;
        c$a.d(n10, n11, n12);
        int n13 = (n10 + n11) / 2;
        if (n10 == n13) {
            return;
        }
        n11 += -1;
        while (n10 < n13) {
            Object object;
            Object object2 = objectArray[n10];
            objectArray[n10] = object = objectArray[n11];
            objectArray[n11] = object2;
            n11 += -1;
            ++n10;
        }
    }

    private static final List xr(double[] dArray, q q10) {
        Number number;
        int n10 = dArray.length;
        Double d10 = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        double d11 = dArray[0];
        int n12 = dArray.length;
        ArrayList<Number> arrayList = new ArrayList<Number>(n12);
        Double d12 = d11;
        arrayList.add(d12);
        n12 = dArray.length;
        while (n11 < n12) {
            Number number2 = n11;
            number = d11;
            double d13 = dArray[n11];
            d10 = d13;
            number = (Number)q10.invoke(number2, number, d10);
            d11 = number.doubleValue();
            number2 = d11;
            arrayList.add(number2);
            ++n11;
        }
        return arrayList;
    }

    public static final void xs(int[] nArray, e e10) {
        int n10;
        f0.p(nArray, "$this$shuffle");
        String string2 = "random";
        f0.p(e10, string2);
        for (int i10 = ArraysKt___ArraysKt.Pd(nArray); i10 >= (n10 = 1); i10 += -1) {
            int n11;
            n10 = i10 + 1;
            n10 = e10.m(n10);
            int n12 = nArray[i10];
            nArray[i10] = n11 = nArray[n10];
            nArray[n10] = n12;
        }
    }

    public static final List xt(float[] fArray, k k10) {
        f0.p(fArray, "$this$slice");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.q(f.x1.n.J1(fArray, n10, n11));
    }

    public static final List xu(long[] objectArray) {
        f0.p(objectArray, "$this$sorted");
        objectArray = f.x1.n.p4(objectArray);
        Objects.requireNonNull(objectArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        f.x1.n.r3(objectArray);
        return f.x1.n.t(objectArray);
    }

    public static final List xv(Object[] objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$sortedWith");
        f0.p(comparator, "comparator");
        return f.x1.n.t(ArraysKt___ArraysKt.Qu(objectArray, comparator));
    }

    private static final int xw(int[] nArray, l l10) {
        int n10 = nArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Number number = nArray[i10];
            number = (Number)l10.invoke(number);
            int n12 = number.intValue();
            n11 += n12;
        }
        return n11;
    }

    public static final List xx(boolean[] object, int n10) {
        ArrayList<Boolean> arrayList = "$this$takeLast";
        f0.p(object, (String)((Object)arrayList));
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        if (n12 != 0) {
            if (n10 == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
            n12 = ((boolean[])object).length;
            if (n10 >= n12) {
                return ArraysKt___ArraysKt.wy((boolean[])object);
            }
            if (n10 == n11) {
                return t.k((boolean)object[n12 -= n11]);
            }
            arrayList = new ArrayList<Boolean>(n10);
            for (n10 = n12 - n10; n10 < n12; ++n10) {
                Object object2 = object[n10];
                Boolean bl2 = (boolean)object2;
                arrayList.add(bl2);
            }
            return arrayList;
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Requested element count ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" is less than zero.");
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final long[] xy(Long[] longArray) {
        String string2 = "$this$toLongArray";
        f0.p(longArray, string2);
        int n10 = longArray.length;
        long[] lArray = new long[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10;
            Long l11 = longArray[i10];
            lArray[i10] = l10 = l11.longValue();
        }
        return lArray;
    }

    public static final List xz(byte[] byArray, Object[] objectArray, p p10) {
        f0.p(byArray, "$this$zip");
        f0.p(objectArray, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = byArray.length;
        int n11 = objectArray.length;
        n10 = Math.min(n10, n11);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2 = byArray[i10];
            Object object = by2;
            Object object2 = objectArray[i10];
            object = p10.invoke(object, object2);
            arrayList.add(object);
        }
        return arrayList;
    }

    public static final boolean y4(short[] sArray, l l10) {
        f0.p(sArray, "$this$all");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = sArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Constable constable = Short.valueOf(sArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static final Map y5(double[] dArray, l l10, l l11) {
        f0.p(dArray, "$this$associateBy");
        f0.p(l10, "keySelector");
        String string2 = "valueTransform";
        f0.p(l11, string2);
        int n10 = s0.j(dArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>(n10);
        for (double d10 : dArray) {
            Object object = d10;
            object = l10.invoke(object);
            Object object2 = d10;
            object2 = l11.invoke(object2);
            linkedHashMap.put(object, object2);
        }
        return linkedHashMap;
    }

    private static final Map y6(float[] fArray, Map map, l l10) {
        for (float f10 : fArray) {
            Float f11 = Float.valueOf(f10);
            Object object = Float.valueOf(f10);
            object = l10.invoke(object);
            map.put(f11, object);
        }
        return map;
    }

    private static final short y7(short[] sArray) {
        f0.p(sArray, "$this$component4");
        return sArray[3];
    }

    public static final List y8(long[] lArray, l l10) {
        f0.p(lArray, "$this$distinctBy");
        f0.p(l10, "selector");
        HashSet<Object> hashSet = new HashSet<Object>();
        ArrayList<Long> arrayList = new ArrayList<Long>();
        for (long l11 : lArray) {
            Object object = l11;
            boolean bl2 = hashSet.add(object = l10.invoke(object));
            if (!bl2) continue;
            Long l12 = l11;
            arrayList.add(l12);
        }
        return arrayList;
    }

    private static final Double y9(double[] dArray, int n10) {
        return ArraysKt___ArraysKt.ge(dArray, n10);
    }

    public static final Collection ya(Object[] objectArray, Collection collection, l l10) {
        f0.p(objectArray, "$this$filterNotTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (Object object : objectArray) {
            Boolean bl2 = (Boolean)l10.invoke(object);
            boolean bl3 = bl2;
            if (bl3) continue;
            collection.add(object);
        }
        return collection;
    }

    public static final Character yb(char[] object) {
        String string2 = "$this$firstOrNull";
        f0.p(object, string2);
        int n10 = ((char[])object).length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            boolean bl2 = false;
            object = null;
        } else {
            char c10 = object[0];
            object = Character.valueOf(c10);
        }
        return object;
    }

    public static final Collection yc(short[] sArray, Collection collection, l l10) {
        f0.p(sArray, "$this$flatMapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (short s10 : sArray) {
            Object object = s10;
            object = (Iterable)l10.invoke(object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final void yd(long[] lArray, p p10) {
        f0.p(lArray, "$this$forEachIndexed");
        String string2 = "action";
        f0.p(p10, string2);
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            Integer n12 = n11;
            ++n11;
            Long l11 = l10;
            p10.invoke(n12, l11);
        }
    }

    public static final Map ye(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (Object object : objectArray) {
            Object object2 = l10.invoke(object);
            Object object3 = linkedHashMap.get(object2);
            if (object3 == null) {
                object3 = new ArrayList();
                linkedHashMap.put(object2, object3);
            }
            object3 = (List)object3;
            object3.add((Object)object);
        }
        return linkedHashMap;
    }

    public static final Set yf(byte[] object, Iterable iterable) {
        f0.p(object, "$this$intersect");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Hy(object);
        y.Q0((Collection)object, iterable);
        return object;
    }

    public static final String yg(short[] object, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(object, "$this$joinToString");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        StringBuilder stringBuilder = new StringBuilder();
        object = ((StringBuilder)ArraysKt___ArraysKt.gg(object, stringBuilder, charSequence, charSequence2, charSequence3, n10, charSequence4, l10)).toString();
        f0.o(object, "joinTo(StringBuilder(), \u2026ed, transform).toString()");
        return object;
    }

    public static final Object yh(Object[] object) {
        String string2 = "$this$lastOrNull";
        f0.p(object, string2);
        int n10 = ((Object[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object = null;
        } else {
            n10 = ((Object[])object).length - n11;
            object = object[n10];
        }
        return object;
    }

    public static final Long yi(long[] lArray) {
        f0.p(lArray, "$this$max");
        return ArraysKt___ArraysKt.uk(lArray);
    }

    private static final Comparable yj(long[] lArray, l l10) {
        Comparable<Long> comparable;
        int n10 = lArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            comparable = null;
        }
        if (n10 != 0) {
            return null;
        }
        long l11 = lArray[0];
        comparable = l11;
        comparable = (Comparable)l10.invoke(comparable);
        n11 = ArraysKt___ArraysKt.Qd(lArray);
        if (n12 <= n11) {
            while (true) {
                long l12 = lArray[n12];
                Comparable<Long> comparable2 = l12;
                int n13 = comparable.compareTo((Long)(comparable2 = (Comparable)l10.invoke(comparable2)));
                if (n13 < 0) {
                    comparable = comparable2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return comparable;
    }

    public static final Character yk(char[] cArray, Comparator comparator) {
        f0.p(cArray, "$this$maxWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Hk(cArray, comparator);
    }

    private static final double yl(boolean[] object, l l10) {
        Serializable serializable;
        int n10 = ((boolean[])object).length;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            serializable = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            serializable = Boolean.valueOf(n10 != 0);
            serializable = (Number)l10.invoke(serializable);
            double d10 = ((Number)serializable).doubleValue();
            int n12 = ArraysKt___ArraysKt.Td(object);
            if (n11 <= n12) {
                while (true) {
                    boolean bl2 = object[n11];
                    Serializable serializable2 = Boolean.valueOf(bl2);
                    serializable2 = (Number)l10.invoke(serializable2);
                    double d11 = ((Number)serializable2).doubleValue();
                    d10 = Math.min(d10, d11);
                    if (n11 == n12) break;
                    ++n11;
                }
            }
            return d10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object ym(Object[] objectArray, Comparator comparator, l l10) {
        Object object;
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 == 0) {
            object = objectArray[0];
            object = l10.invoke(object);
            n11 = ArraysKt___ArraysKt.Rd(objectArray);
            if (n12 <= n11) {
                while (true) {
                    Object object2 = objectArray[n12];
                    int n13 = comparator.compare(object, object2 = l10.invoke(object2));
                    if (n13 > 0) {
                        object = object2;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object;
        }
        objectArray = new NoSuchElementException();
        throw objectArray;
    }

    public static final boolean yn(Object[] objectArray) {
        String string2 = "$this$none";
        f0.p(objectArray, string2);
        boolean bl2 = objectArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            objectArray = null;
        }
        return bl2;
    }

    public static final Boolean yo(boolean[] blArray, e e10) {
        f0.p(blArray, "$this$randomOrNull");
        String string2 = "random";
        f0.p(e10, string2);
        int n10 = blArray.length;
        if (n10 == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = blArray.length;
        int n11 = e10.m(n10);
        return blArray[n11];
    }

    public static final Short yp(short[] sArray, p p10) {
        f0.p(sArray, "$this$reduceOrNull");
        Object object = "operation";
        f0.p(p10, (String)object);
        int n10 = sArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        n10 = sArray[0];
        n11 = ArraysKt___ArraysKt.Sd(sArray);
        if (n12 <= n11) {
            while (true) {
                object = (short)n10;
                short s10 = sArray[n12];
                Short s11 = s10;
                object = (Number)p10.invoke(object, s11);
                n10 = ((Number)object).shortValue();
                if (n12 == n11) break;
                ++n12;
            }
        }
        return (short)n10;
    }

    public static final void yq(short[] sArray) {
        String string2 = "$this$reverse";
        f0.p(sArray, string2);
        int n10 = sArray.length / 2 + -1;
        if (n10 < 0) {
            return;
        }
        int n11 = ArraysKt___ArraysKt.Sd(sArray);
        int n12 = 0;
        if (n10 >= 0) {
            while (true) {
                short s10;
                short s11 = sArray[n12];
                sArray[n12] = s10 = sArray[n11];
                sArray[n11] = s11;
                n11 += -1;
                if (n12 == n10) break;
                ++n12;
            }
        }
    }

    private static final List yr(float[] fArray, q q10) {
        Number number;
        float f10;
        int n10 = fArray.length;
        ArrayList<Number> arrayList = null;
        int n11 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n11;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        f10 = fArray[0];
        int n12 = fArray.length;
        arrayList = new ArrayList<Number>(n12);
        Float f12 = Float.valueOf(f10);
        arrayList.add(f12);
        n12 = fArray.length;
        while (n11 < n12) {
            Number number2 = n11;
            number = Float.valueOf(f10);
            float f13 = fArray[n11];
            Float f14 = Float.valueOf(f13);
            number = (Number)q10.invoke(number2, number, f14);
            f10 = number.floatValue();
            number2 = Float.valueOf(f10);
            arrayList.add(number2);
            ++n11;
        }
        return arrayList;
    }

    public static final void ys(long[] lArray) {
        f0.p(lArray, "$this$shuffle");
        e$a e$a = e.b;
        ArraysKt___ArraysKt.zs(lArray, e$a);
    }

    public static final List yt(int[] nArray, Iterable object) {
        f0.p(nArray, "$this$slice");
        Object object2 = "indices";
        f0.p(object, (String)object2);
        int n10 = u.Y((Iterable)object, 10);
        if (n10 == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            n10 = ((Number)object.next()).intValue();
            n10 = nArray[n10];
            object2 = n10;
            arrayList.add(object2);
        }
        return arrayList;
    }

    public static final List yu(Comparable[] comparableArray) {
        f0.p(comparableArray, "$this$sorted");
        return f.x1.n.t(ArraysKt___ArraysKt.Gu(comparableArray));
    }

    public static final List yv(short[] objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$sortedWith");
        f0.p(comparator, "comparator");
        objectArray = f.x1.n.q4(objectArray);
        f.x1.n.E3(objectArray, comparator);
        return f.x1.n.t(objectArray);
    }

    private static final int yw(long[] lArray, l l10) {
        int n10 = lArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l11 = lArray[i10];
            Number number = l11;
            number = (Number)l10.invoke(number);
            int n12 = number.intValue();
            n11 += n12;
        }
        return n11;
    }

    public static final List yx(byte[] byArray, l l10) {
        f0.p(byArray, "$this$takeLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Ld(byArray); i10 >= 0; i10 += -1) {
            Constable constable = Byte.valueOf(byArray[i10]);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            return ArraysKt___ArraysKt.C8(byArray, ++i10);
        }
        return ArraysKt___ArraysKt.oy(byArray);
    }

    public static final List yy(byte[] byArray) {
        f0.p(byArray, "$this$toMutableList");
        int n10 = byArray.length;
        ArrayList<Byte> arrayList = new ArrayList<Byte>(n10);
        for (byte by2 : byArray) {
            Byte by3 = by2;
            arrayList.add(by3);
        }
        return arrayList;
    }

    public static final List yz(char[] cArray, Iterable object) {
        boolean bl2;
        f0.p(cArray, "$this$zip");
        String string2 = "other";
        f0.p(object, string2);
        int n10 = cArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Pair> arrayList = new ArrayList<Pair>(n11);
        object = object.iterator();
        n11 = 0;
        Pair pair = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            pair = w0.a(Character.valueOf(cArray[n11]), e10);
            arrayList.add(pair);
            n11 = n12;
        }
        return arrayList;
    }

    public static final boolean z4(boolean[] blArray, l l10) {
        f0.p(blArray, "$this$all");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = blArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            Boolean bl2 = blArray[i10];
            boolean bl3 = bl2 = (Boolean)l10.invoke(bl2);
            if (bl3) continue;
            return false;
        }
        return true;
    }

    public static final Map z5(float[] fArray, l l10) {
        f0.p(fArray, "$this$associateBy");
        String string2 = "keySelector";
        f0.p(l10, string2);
        int n10 = s0.j(fArray.length);
        int n11 = 16;
        n10 = f.l2.q.n(n10, n11);
        LinkedHashMap<Object, Float> linkedHashMap = new LinkedHashMap<Object, Float>(n10);
        for (float f10 : fArray) {
            Object object = Float.valueOf(f10);
            object = l10.invoke(object);
            Float f11 = Float.valueOf(f10);
            linkedHashMap.put(object, f11);
        }
        return linkedHashMap;
    }

    private static final Map z6(int[] nArray, Map map, l l10) {
        for (int n10 : nArray) {
            Integer n11 = n10;
            Object object = n10;
            object = l10.invoke(object);
            map.put(n11, object);
        }
        return map;
    }

    private static final boolean z7(boolean[] blArray) {
        f0.p(blArray, "$this$component4");
        return blArray[3];
    }

    public static final List z8(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$distinctBy");
        f0.p(l10, "selector");
        HashSet<Object> hashSet = new HashSet<Object>();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (Object object : objectArray) {
            Object object2 = l10.invoke(object);
            boolean bl2 = hashSet.add(object2);
            if (!bl2) continue;
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final Float z9(float[] fArray, int n10) {
        return ArraysKt___ArraysKt.he(fArray, n10);
    }

    public static final Collection za(short[] sArray, Collection collection, l l10) {
        f0.p(sArray, "$this$filterNotTo");
        f0.p(collection, "destination");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (short s10 : sArray) {
            Constable constable = Short.valueOf(s10);
            boolean bl2 = (Boolean)(constable = (Boolean)l10.invoke(constable));
            if (bl2) continue;
            Short s11 = s10;
            collection.add(s11);
        }
        return collection;
    }

    public static final Character zb(char[] cArray, l l10) {
        f0.p(cArray, "$this$firstOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (char c10 : cArray) {
            Comparable<Character> comparable = Character.valueOf(c10);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (!bl2) continue;
            return Character.valueOf(c10);
        }
        return null;
    }

    public static final Collection zc(boolean[] blArray, Collection collection, l l10) {
        f0.p(blArray, "$this$flatMapTo");
        f0.p(collection, "destination");
        String string2 = "transform";
        f0.p(l10, string2);
        for (boolean bl2 : blArray) {
            Object object = bl2;
            object = (Iterable)l10.invoke(object);
            y.q0(collection, (Iterable)object);
        }
        return collection;
    }

    public static final void zd(Object[] objectArray, p p10) {
        f0.p(objectArray, "$this$forEachIndexed");
        String string2 = "action";
        f0.p(p10, string2);
        int n10 = objectArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            Integer n12 = n11;
            ++n11;
            p10.invoke(n12, object);
        }
    }

    public static final Map ze(Object[] objectArray, l l10, l l11) {
        f0.p(objectArray, "$this$groupBy");
        f0.p(l10, "keySelector");
        f0.p(l11, "valueTransform");
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
        for (Object object : objectArray) {
            Object object2 = l10.invoke(object);
            Object object3 = linkedHashMap.get(object2);
            if (object3 == null) {
                object3 = new ArrayList();
                linkedHashMap.put(object2, object3);
            }
            object3 = (List)object3;
            object = l11.invoke(object);
            object3.add((Object)object);
        }
        return linkedHashMap;
    }

    public static final Set zf(char[] object, Iterable iterable) {
        f0.p(object, "$this$intersect");
        f0.p(iterable, "other");
        object = ArraysKt___ArraysKt.Iy(object);
        y.Q0((Collection)object, iterable);
        return object;
    }

    public static final String zg(boolean[] object, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int n10, CharSequence charSequence4, l l10) {
        f0.p(object, "$this$joinToString");
        f0.p(charSequence, "separator");
        f0.p(charSequence2, "prefix");
        f0.p(charSequence3, "postfix");
        f0.p(charSequence4, "truncated");
        StringBuilder stringBuilder = new StringBuilder();
        object = ((StringBuilder)ArraysKt___ArraysKt.hg(object, stringBuilder, charSequence, charSequence2, charSequence3, n10, charSequence4, l10)).toString();
        f0.o(object, "joinTo(StringBuilder(), \u2026ed, transform).toString()");
        return object;
    }

    public static final Object zh(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$lastOrNull");
        String string2 = "predicate";
        f0.p(l10, string2);
        int n10 = objectArray.length;
        while ((n10 += -1) >= 0) {
            Object object = objectArray[n10];
            Boolean bl2 = (Boolean)l10.invoke(object);
            boolean bl3 = bl2;
            if (!bl3) continue;
            return object;
        }
        return null;
    }

    public static final Short zi(short[] sArray) {
        f0.p(sArray, "$this$max");
        return ArraysKt___ArraysKt.vk(sArray);
    }

    private static final Comparable zj(Object[] objectArray, l l10) {
        Object object;
        int n10 = objectArray.length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            return null;
        }
        object = objectArray[0];
        object = (Comparable)l10.invoke(object);
        n11 = ArraysKt___ArraysKt.Rd(objectArray);
        if (n12 <= n11) {
            while (true) {
                Object object2 = objectArray[n12];
                int n13 = object.compareTo(object2 = (Comparable)l10.invoke(object2));
                if (n13 < 0) {
                    object = object2;
                }
                if (n12 == n11) break;
                ++n12;
            }
        }
        return object;
    }

    public static final Double zk(double[] dArray, Comparator comparator) {
        f0.p(dArray, "$this$maxWith");
        f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Ik(dArray, comparator);
    }

    private static final float zl(byte[] object, l l10) {
        Number number;
        float f10;
        int n10 = ((byte[])object).length;
        int n11 = 0;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == 0) {
            n10 = n12;
            f10 = f11;
        } else {
            n10 = 0;
            number = null;
            f10 = 0.0f;
        }
        if (n10 == 0) {
            n10 = object[0];
            number = (byte)n10;
            number = (Number)l10.invoke(number);
            f10 = number.floatValue();
            n11 = ArraysKt___ArraysKt.Ld(object);
            if (n12 <= n11) {
                while (true) {
                    byte by2 = object[n12];
                    Number number2 = by2;
                    number2 = (Number)l10.invoke(number2);
                    float f12 = number2.floatValue();
                    f10 = Math.min(f10, f12);
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return f10;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    private static final Object zm(short[] object, Comparator comparator, l l10) {
        Object object2;
        int n10 = ((short[])object).length;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 == 0) {
            n10 = object[0];
            object2 = (short)n10;
            object2 = l10.invoke(object2);
            n11 = ArraysKt___ArraysKt.Sd(object);
            if (n12 <= n11) {
                while (true) {
                    short s10 = object[n12];
                    Object object3 = s10;
                    int n13 = comparator.compare(object2, object3 = l10.invoke(object3));
                    if (n13 > 0) {
                        object2 = object3;
                    }
                    if (n12 == n11) break;
                    ++n12;
                }
            }
            return object2;
        }
        object = new NoSuchElementException;
        object();
        throw object;
    }

    public static final boolean zn(Object[] objectArray, l l10) {
        f0.p(objectArray, "$this$none");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (Object object : objectArray) {
            boolean bl2 = (Boolean)(object = (Boolean)l10.invoke(object));
            if (!bl2) continue;
            return false;
        }
        return true;
    }

    private static final Byte zo(byte[] byArray) {
        e$a e$a = e.b;
        return ArraysKt___ArraysKt.Ao(byArray, e$a);
    }

    public static final byte zp(byte[] object, p p10) {
        f0.p(object, "$this$reduceRight");
        Object object2 = "operation";
        f0.p(p10, (String)object2);
        int by2 = ArraysKt___ArraysKt.Ld((byte[])object);
        if (by2 >= 0) {
            byte by3;
            int n10 = by2 + -1;
            Object object3 = object[by2];
            while (n10 >= 0) {
                int n11 = n10 + -1;
                Byte by4 = (byte)object[n10];
                object2 = by3;
                object2 = (Number)p10.invoke(by4, object2);
                by3 = ((Number)object2).byteValue();
                n10 = n11;
            }
            return by3;
        }
        object = new UnsupportedOperationException("Empty array can't be reduced.");
        throw object;
    }

    public static final void zq(short[] sArray, int n10, int n11) {
        f0.p(sArray, "$this$reverse");
        c$a c$a = c.a;
        int n12 = sArray.length;
        c$a.d(n10, n11, n12);
        int n13 = (n10 + n11) / 2;
        if (n10 == n13) {
            return;
        }
        n11 += -1;
        while (n10 < n13) {
            short s10;
            n12 = sArray[n10];
            sArray[n10] = s10 = sArray[n11];
            sArray[n11] = n12;
            n11 += -1;
            ++n10;
        }
    }

    private static final List zr(int[] nArray, q q10) {
        Number number;
        int n10 = nArray.length;
        ArrayList<Integer> arrayList = null;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            number = null;
        }
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = nArray[0];
        int n12 = nArray.length;
        arrayList = new ArrayList<Integer>(n12);
        Integer n13 = n10;
        arrayList.add(n13);
        n12 = nArray.length;
        while (n11 < n12) {
            Integer n14 = n11;
            number = n10;
            int n15 = nArray[n11];
            Integer n16 = n15;
            number = (Number)q10.invoke(n14, number, n16);
            n10 = number.intValue();
            n14 = n10;
            arrayList.add(n14);
            ++n11;
        }
        return arrayList;
    }

    public static final void zs(long[] lArray, e e10) {
        int n10;
        f0.p(lArray, "$this$shuffle");
        String string2 = "random";
        f0.p(e10, string2);
        for (int i10 = ArraysKt___ArraysKt.Qd(lArray); i10 >= (n10 = 1); i10 += -1) {
            long l10;
            n10 = i10 + 1;
            n10 = e10.m(n10);
            long l11 = lArray[i10];
            lArray[i10] = l10 = lArray[n10];
            lArray[n10] = l11;
        }
    }

    public static final List zt(int[] nArray, k k10) {
        f0.p(nArray, "$this$slice");
        String string2 = "indices";
        f0.p(k10, string2);
        int n10 = k10.isEmpty();
        if (n10 != 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        n10 = k10.l();
        int n11 = k10.k() + 1;
        return f.x1.n.r(f.x1.n.K1(nArray, n10, n11));
    }

    public static final List zu(short[] objectArray) {
        f0.p(objectArray, "$this$sorted");
        objectArray = f.x1.n.q4(objectArray);
        Objects.requireNonNull(objectArray, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        f.x1.n.r3(objectArray);
        return f.x1.n.t(objectArray);
    }

    public static final List zv(boolean[] objectArray, Comparator comparator) {
        f0.p(objectArray, "$this$sortedWith");
        f0.p(comparator, "comparator");
        objectArray = f.x1.n.j4(objectArray);
        f.x1.n.E3(objectArray, comparator);
        return f.x1.n.t(objectArray);
    }

    public static final int zw(Integer[] integerArray) {
        String string2 = "$this$sum";
        f0.p(integerArray, string2);
        int n10 = integerArray.length;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Integer n12 = integerArray[i10];
            int n13 = n12;
            n11 += n13;
        }
        return n11;
    }

    public static final List zx(char[] cArray, l l10) {
        f0.p(cArray, "$this$takeLastWhile");
        String string2 = "predicate";
        f0.p(l10, string2);
        for (int i10 = ArraysKt___ArraysKt.Md(cArray); i10 >= 0; i10 += -1) {
            Comparable<Character> comparable = Character.valueOf(cArray[i10]);
            boolean bl2 = (Boolean)(comparable = (Boolean)l10.invoke(comparable));
            if (bl2) continue;
            return ArraysKt___ArraysKt.D8(cArray, ++i10);
        }
        return ArraysKt___ArraysKt.py(cArray);
    }

    public static final List zy(char[] cArray) {
        f0.p(cArray, "$this$toMutableList");
        int n10 = cArray.length;
        ArrayList<Character> arrayList = new ArrayList<Character>(n10);
        for (char c10 : cArray) {
            Character c11 = Character.valueOf(c10);
            arrayList.add(c11);
        }
        return arrayList;
    }

    public static final List zz(char[] cArray, Iterable object, p p10) {
        boolean bl2;
        f0.p(cArray, "$this$zip");
        f0.p(object, "other");
        String string2 = "transform";
        f0.p(p10, string2);
        int n10 = cArray.length;
        int n11 = Math.min(u.Y((Iterable)object, 10), n10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        n11 = 0;
        Object object2 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            if (n11 >= n10) break;
            int n12 = n11 + 1;
            object2 = Character.valueOf(cArray[n11]);
            object2 = p10.invoke(object2, e10);
            arrayList.add(object2);
            n11 = n12;
        }
        return arrayList;
    }
}

