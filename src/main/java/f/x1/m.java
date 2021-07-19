/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.d1;
import f.h1;
import f.h2.s.a;
import f.h2.t.f0;
import f.l2.q;
import f.n1;
import f.w0;
import f.x1.l;
import f.x1.y;
import f.z0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.unsigned.UArraysKt___UArraysKt;

public class m
extends l {
    public static final boolean g(Object[] objectArray, Object[] objectArray2) {
        int n10;
        int n11;
        boolean bl2 = true;
        if (objectArray == objectArray2) {
            return bl2;
        }
        if (objectArray != null && objectArray2 != null && (n11 = objectArray.length) == (n10 = objectArray2.length)) {
            n11 = objectArray.length;
            for (n10 = 0; n10 < n11; ++n10) {
                Object[] objectArray3 = objectArray[n10];
                Object[] objectArray4 = objectArray2[n10];
                if (objectArray3 == objectArray4) continue;
                if (objectArray3 != null && objectArray4 != null) {
                    boolean bl3;
                    boolean bl4 = objectArray3 instanceof Object[];
                    if (!(bl4 && (bl4 = objectArray4 instanceof Object[]) ? !(bl3 = m.g(objectArray3 = (Object[])objectArray3, objectArray4 = (Object[])objectArray4)) : ((bl4 = objectArray3 instanceof byte[]) && (bl4 = objectArray4 instanceof byte[]) ? !(bl3 = Arrays.equals((byte[])(objectArray3 = (Object[])((byte[])objectArray3)), (byte[])(objectArray4 = (Object[])((byte[])objectArray4)))) : ((bl4 = objectArray3 instanceof short[]) && (bl4 = objectArray4 instanceof short[]) ? !(bl3 = Arrays.equals((short[])(objectArray3 = (Object[])((short[])objectArray3)), (short[])(objectArray4 = (Object[])((short[])objectArray4)))) : ((bl4 = objectArray3 instanceof int[]) && (bl4 = objectArray4 instanceof int[]) ? !(bl3 = Arrays.equals((int[])(objectArray3 = (Object[])((int[])objectArray3)), (int[])(objectArray4 = (Object[])((int[])objectArray4)))) : ((bl4 = objectArray3 instanceof long[]) && (bl4 = objectArray4 instanceof long[]) ? !(bl3 = Arrays.equals((long[])(objectArray3 = (Object[])((long[])objectArray3)), (long[])(objectArray4 = (Object[])((long[])objectArray4)))) : ((bl4 = objectArray3 instanceof float[]) && (bl4 = objectArray4 instanceof float[]) ? !(bl3 = Arrays.equals((float[])(objectArray3 = (Object[])((float[])objectArray3)), (float[])(objectArray4 = (Object[])((float[])objectArray4)))) : ((bl4 = objectArray3 instanceof double[]) && (bl4 = objectArray4 instanceof double[]) ? !(bl3 = Arrays.equals((double[])(objectArray3 = (Object[])((double[])objectArray3)), (double[])(objectArray4 = (Object[])((double[])objectArray4)))) : ((bl4 = objectArray3 instanceof char[]) && (bl4 = objectArray4 instanceof char[]) ? !(bl3 = Arrays.equals((char[])(objectArray3 = (Object[])((char[])objectArray3)), (char[])(objectArray4 = (Object[])((char[])objectArray4)))) : ((bl4 = objectArray3 instanceof boolean[]) && (bl4 = objectArray4 instanceof boolean[]) ? !(bl3 = Arrays.equals((boolean[])(objectArray3 = (Object[])((boolean[])objectArray3)), (boolean[])(objectArray4 = (Object[])((boolean[])objectArray4)))) : ((bl4 = objectArray3 instanceof z0) && (bl4 = objectArray4 instanceof z0) ? !(bl3 = UArraysKt___UArraysKt.x0((byte[])(objectArray3 = (Object[])((z0)objectArray3).v()), (byte[])(objectArray4 = (Object[])((z0)objectArray4).v()))) : ((bl4 = objectArray3 instanceof n1) && (bl4 = objectArray4 instanceof n1) ? !(bl3 = UArraysKt___UArraysKt.u0((short[])(objectArray3 = (Object[])((n1)objectArray3).v()), (short[])(objectArray4 = (Object[])((n1)objectArray4).v()))) : ((bl4 = objectArray3 instanceof d1) && (bl4 = objectArray4 instanceof d1) ? !(bl3 = UArraysKt___UArraysKt.v0((int[])(objectArray3 = (Object[])((d1)objectArray3).v()), (int[])(objectArray4 = (Object[])((d1)objectArray4).v()))) : ((bl4 = objectArray3 instanceof h1) && (bl4 = objectArray4 instanceof h1) ? !(bl3 = UArraysKt___UArraysKt.z0((long[])(objectArray3 = (Object[])((h1)objectArray3).v()), (long[])(objectArray4 = (Object[])((h1)objectArray4).v()))) : (bl3 = f0.g(objectArray3, objectArray4) ^ bl2))))))))))))))) continue;
                    return false;
                }
                return false;
            }
            return bl2;
        }
        return false;
    }

    public static final String h(Object[] object) {
        if (object == null) {
            return "null";
        }
        int n10 = q.u(((Object[])object).length, 0x19999999) * 5 + 2;
        StringBuilder stringBuilder = new StringBuilder(n10);
        ArrayList arrayList = new ArrayList();
        m.i(object, stringBuilder, arrayList);
        object = stringBuilder.toString();
        f0.o(object, "StringBuilder(capacity).\u2026builderAction).toString()");
        return object;
    }

    private static final void i(Object[] objectArray, StringBuilder stringBuilder, List list) {
        int n10 = list.contains(objectArray);
        if (n10 != 0) {
            stringBuilder.append("[...]");
            return;
        }
        list.add(objectArray);
        stringBuilder.append('[');
        int n11 = objectArray.length;
        for (n10 = 0; n10 < n11; ++n10) {
            Object object;
            if (n10 != 0) {
                object = ", ";
                stringBuilder.append((String)object);
            }
            if ((object = objectArray[n10]) == null) {
                object = "null";
                stringBuilder.append((String)object);
                continue;
            }
            boolean bl2 = object instanceof Object[];
            if (bl2) {
                object = (Object[])object;
                m.i((Object[])object, stringBuilder, list);
                continue;
            }
            bl2 = object instanceof byte[];
            Object object2 = "java.util.Arrays.toString(this)";
            if (bl2) {
                object = Arrays.toString((byte[])object);
                f0.o(object, (String)object2);
                stringBuilder.append((String)object);
                continue;
            }
            bl2 = object instanceof short[];
            if (bl2) {
                object = Arrays.toString((short[])object);
                f0.o(object, (String)object2);
                stringBuilder.append((String)object);
                continue;
            }
            bl2 = object instanceof int[];
            if (bl2) {
                object = Arrays.toString((int[])object);
                f0.o(object, (String)object2);
                stringBuilder.append((String)object);
                continue;
            }
            bl2 = object instanceof long[];
            if (bl2) {
                object = Arrays.toString((long[])object);
                f0.o(object, (String)object2);
                stringBuilder.append((String)object);
                continue;
            }
            bl2 = object instanceof float[];
            if (bl2) {
                object = Arrays.toString((float[])object);
                f0.o(object, (String)object2);
                stringBuilder.append((String)object);
                continue;
            }
            bl2 = object instanceof double[];
            if (bl2) {
                object = Arrays.toString((double[])object);
                f0.o(object, (String)object2);
                stringBuilder.append((String)object);
                continue;
            }
            bl2 = object instanceof char[];
            if (bl2) {
                object = Arrays.toString((char[])object);
                f0.o(object, (String)object2);
                stringBuilder.append((String)object);
                continue;
            }
            bl2 = object instanceof boolean[];
            if (bl2) {
                object = Arrays.toString((boolean[])object);
                f0.o(object, (String)object2);
                stringBuilder.append((String)object);
                continue;
            }
            bl2 = object instanceof z0;
            object2 = null;
            if (bl2) {
                if ((object = (z0)object) != null) {
                    object2 = ((z0)object).v();
                }
                object = UArraysKt___UArraysKt.L0((byte[])object2);
                stringBuilder.append((String)object);
                continue;
            }
            bl2 = object instanceof n1;
            if (bl2) {
                if ((object = (n1)object) != null) {
                    object2 = ((n1)object).v();
                }
                object = UArraysKt___UArraysKt.P0((short[])object2);
                stringBuilder.append((String)object);
                continue;
            }
            bl2 = object instanceof d1;
            if (bl2) {
                if ((object = (d1)object) != null) {
                    object2 = ((d1)object).v();
                }
                object = UArraysKt___UArraysKt.O0((int[])object2);
                stringBuilder.append((String)object);
                continue;
            }
            bl2 = object instanceof h1;
            if (bl2) {
                if ((object = (h1)object) != null) {
                    object2 = ((h1)object).v();
                }
                object = UArraysKt___UArraysKt.R0((long[])object2);
                stringBuilder.append((String)object);
                continue;
            }
            object = object.toString();
            stringBuilder.append((String)object);
        }
        stringBuilder.append(']');
        int n12 = CollectionsKt__CollectionsKt.G(list);
        list.remove(n12);
    }

    public static final List j(Object[][] objectArray) {
        int n10;
        ArrayList arrayList = "$this$flatten";
        f0.p(objectArray, (String)((Object)arrayList));
        int n11 = objectArray.length;
        int n12 = 0;
        int n13 = 0;
        Object[] objectArray2 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            Object[] objectArray3 = objectArray[n10];
            int n14 = objectArray3.length;
            n13 += n14;
        }
        arrayList = new ArrayList(n13);
        n10 = objectArray.length;
        while (n12 < n10) {
            objectArray2 = objectArray[n12];
            y.s0(arrayList, objectArray2);
            ++n12;
        }
        return arrayList;
    }

    private static final Object k(Object[] object, a a10) {
        int n10 = ((Object[])object).length;
        n10 = n10 == 0 ? 1 : 0;
        if (n10 != 0) {
            object = a10.invoke();
        }
        return object;
    }

    private static final boolean l(Object[] objectArray) {
        int n10;
        block6: {
            int n11;
            block5: {
                n10 = 0;
                n11 = 1;
                if (objectArray == null) break block5;
                int n12 = objectArray.length;
                if (n12 == 0) {
                    n12 = n11;
                } else {
                    n12 = 0;
                    objectArray = null;
                }
                if (n12 == 0) break block6;
            }
            n10 = n11;
        }
        return n10 != 0;
    }

    public static final Pair m(Pair[] pairArray) {
        f0.p(pairArray, "$this$unzip");
        int n10 = pairArray.length;
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        int n11 = pairArray.length;
        ArrayList<Object> arrayList2 = new ArrayList<Object>(n11);
        for (Pair pair : pairArray) {
            Object object = pair.getFirst();
            arrayList.add(object);
            Object object2 = pair.getSecond();
            arrayList2.add(object2);
        }
        return w0.a(arrayList, arrayList2);
    }
}

