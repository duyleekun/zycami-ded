/*
 * Decompiled with CFR 0.151.
 */
package i.h.h;

import i.h.h.c;
import i.h.h.i;
import java.util.HashMap;
import java.util.Map;

public final class d {
    public static final char a = '{';
    public static final char b = '}';
    public static final String c = "{}";
    private static final char d = '\\';

    public static final c a(String string2, Object[] objectArray) {
        Throwable throwable = i.h.h.d.k(objectArray);
        if (throwable != null) {
            objectArray = i.h.h.d.s(objectArray);
        }
        return i.h.h.d.b(string2, objectArray, throwable);
    }

    public static final c b(String object, Object[] objectArray, Throwable throwable) {
        int n10;
        if (object == null) {
            object = new c(null, objectArray, throwable);
            return object;
        }
        if (objectArray == null) {
            objectArray = new c((String)object);
            return objectArray;
        }
        int n11 = ((String)object).length() + 50;
        Object object2 = new StringBuilder(n11);
        int n12 = 0;
        Object object3 = null;
        for (n11 = 0; n11 < (n10 = objectArray.length); ++n11) {
            block7: {
                block8: {
                    HashMap hashMap;
                    block5: {
                        int n13;
                        block6: {
                            String string2 = c;
                            n10 = ((String)object).indexOf(string2, n12);
                            if (n10 == (n13 = -1)) {
                                if (n12 == 0) {
                                    object2 = new c((String)object, objectArray, throwable);
                                    return object2;
                                }
                                n11 = ((String)object).length();
                                ((StringBuilder)object2).append((CharSequence)object, n12, n11);
                                object2 = ((StringBuilder)object2).toString();
                                object = new c((String)object2, objectArray, throwable);
                                return object;
                            }
                            n13 = (int)(i.h.h.d.n((String)object, n10) ? 1 : 0);
                            if (n13 == 0) break block5;
                            n13 = (int)(i.h.h.d.m((String)object, n10) ? 1 : 0);
                            if (n13 != 0) break block6;
                            n11 += -1;
                            n13 = n10 + -1;
                            ((StringBuilder)object2).append((CharSequence)object, n12, n13);
                            n12 = 123;
                            ((StringBuilder)object2).append((char)n12);
                            ++n10;
                            break block7;
                        }
                        n13 = n10 + -1;
                        ((StringBuilder)object2).append((CharSequence)object, n12, n13);
                        object3 = objectArray[n11];
                        hashMap = new HashMap();
                        i.h.h.d.f((StringBuilder)object2, object3, hashMap);
                        break block8;
                    }
                    ((StringBuilder)object2).append((CharSequence)object, n12, n10);
                    object3 = objectArray[n11];
                    hashMap = new HashMap();
                    i.h.h.d.f((StringBuilder)object2, object3, hashMap);
                }
                n10 += 2;
            }
            n12 = n10;
        }
        n11 = ((String)object).length();
        ((StringBuilder)object2).append((CharSequence)object, n12, n11);
        object2 = ((StringBuilder)object2).toString();
        object = new c((String)object2, objectArray, throwable);
        return object;
    }

    private static void c(StringBuilder stringBuilder, boolean[] blArray) {
        stringBuilder.append('[');
        int n10 = blArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = blArray[i10];
            stringBuilder.append(n11 != 0);
            n11 = n10 + -1;
            if (i10 == n11) continue;
            String string2 = ", ";
            stringBuilder.append(string2);
        }
        stringBuilder.append(']');
    }

    private static void d(StringBuilder stringBuilder, byte[] byArray) {
        stringBuilder.append('[');
        int n10 = byArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = byArray[i10];
            stringBuilder.append(n11);
            n11 = n10 + -1;
            if (i10 == n11) continue;
            String string2 = ", ";
            stringBuilder.append(string2);
        }
        stringBuilder.append(']');
    }

    private static void e(StringBuilder stringBuilder, char[] cArray) {
        stringBuilder.append('[');
        int n10 = cArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = cArray[i10];
            stringBuilder.append((char)n11);
            n11 = n10 + -1;
            if (i10 == n11) continue;
            String string2 = ", ";
            stringBuilder.append(string2);
        }
        stringBuilder.append(']');
    }

    private static void f(StringBuilder stringBuilder, Object objectArray, Map map) {
        if (objectArray == null) {
            stringBuilder.append("null");
            return;
        }
        Class<?> clazz = objectArray.getClass();
        boolean bl2 = clazz.isArray();
        if (!bl2) {
            i.h.h.d.q(stringBuilder, objectArray);
        } else {
            bl2 = objectArray instanceof boolean[];
            if (bl2) {
                objectArray = (boolean[])objectArray;
                i.h.h.d.c(stringBuilder, (boolean[])objectArray);
            } else {
                bl2 = objectArray instanceof byte[];
                if (bl2) {
                    objectArray = (byte[])objectArray;
                    i.h.h.d.d(stringBuilder, (byte[])objectArray);
                } else {
                    bl2 = objectArray instanceof char[];
                    if (bl2) {
                        objectArray = (char[])objectArray;
                        i.h.h.d.e(stringBuilder, (char[])objectArray);
                    } else {
                        bl2 = objectArray instanceof short[];
                        if (bl2) {
                            objectArray = (short[])objectArray;
                            i.h.h.d.r(stringBuilder, (short[])objectArray);
                        } else {
                            bl2 = objectArray instanceof int[];
                            if (bl2) {
                                objectArray = (int[])objectArray;
                                i.h.h.d.l(stringBuilder, (int[])objectArray);
                            } else {
                                bl2 = objectArray instanceof long[];
                                if (bl2) {
                                    objectArray = (long[])objectArray;
                                    i.h.h.d.o(stringBuilder, (long[])objectArray);
                                } else {
                                    bl2 = objectArray instanceof float[];
                                    if (bl2) {
                                        objectArray = (float[])objectArray;
                                        i.h.h.d.h(stringBuilder, (float[])objectArray);
                                    } else {
                                        bl2 = objectArray instanceof double[];
                                        if (bl2) {
                                            objectArray = (double[])objectArray;
                                            i.h.h.d.g(stringBuilder, (double[])objectArray);
                                        } else {
                                            objectArray = objectArray;
                                            i.h.h.d.p(stringBuilder, objectArray, map);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void g(StringBuilder stringBuilder, double[] dArray) {
        stringBuilder.append('[');
        int n10 = dArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            double d10 = dArray[i10];
            stringBuilder.append(d10);
            int n11 = n10 + -1;
            if (i10 == n11) continue;
            String string2 = ", ";
            stringBuilder.append(string2);
        }
        stringBuilder.append(']');
    }

    private static void h(StringBuilder stringBuilder, float[] fArray) {
        stringBuilder.append('[');
        int n10 = fArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = fArray[i10];
            stringBuilder.append(f10);
            int n11 = n10 + -1;
            if (i10 == n11) continue;
            String string2 = ", ";
            stringBuilder.append(string2);
        }
        stringBuilder.append(']');
    }

    public static final c i(String string2, Object object) {
        Object[] objectArray = new Object[]{object};
        return i.h.h.d.a(string2, objectArray);
    }

    public static final c j(String string2, Object object, Object object2) {
        Object[] objectArray = new Object[]{object, object2};
        return i.h.h.d.a(string2, objectArray);
    }

    public static final Throwable k(Object[] object) {
        int n10;
        if (object != null && (n10 = ((Object[])object).length) != 0) {
            n10 = ((Object[])object).length + -1;
            if ((n10 = (object = object[n10]) instanceof Throwable) != 0) {
                return (Throwable)object;
            }
        }
        return null;
    }

    private static void l(StringBuilder stringBuilder, int[] nArray) {
        stringBuilder.append('[');
        int n10 = nArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = nArray[i10];
            stringBuilder.append(n11);
            n11 = n10 + -1;
            if (i10 == n11) continue;
            String string2 = ", ";
            stringBuilder.append(string2);
        }
        stringBuilder.append(']');
    }

    public static final boolean m(String string2, int n10) {
        int n11 = 2;
        if (n10 >= n11) {
            n10 -= n11;
            char c10 = string2.charAt(n10);
            if (c10 == (n10 = 92)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean n(String string2, int n10) {
        if (n10 == 0) {
            return false;
        }
        int n11 = 1;
        n10 -= n11;
        char c10 = string2.charAt(n10);
        if (c10 == (n10 = 92)) {
            return n11 != 0;
        }
        return false;
    }

    private static void o(StringBuilder stringBuilder, long[] lArray) {
        stringBuilder.append('[');
        int n10 = lArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = lArray[i10];
            stringBuilder.append(l10);
            int n11 = n10 + -1;
            if (i10 == n11) continue;
            String string2 = ", ";
            stringBuilder.append(string2);
        }
        stringBuilder.append(']');
    }

    private static void p(StringBuilder stringBuilder, Object[] object, Map map) {
        stringBuilder.append('[');
        int n10 = map.containsKey(object);
        if (n10 == 0) {
            map.put(object, null);
            n10 = ((Object[])object).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object2 = object[i10];
                i.h.h.d.f(stringBuilder, object2, map);
                int n11 = n10 + -1;
                if (i10 == n11) continue;
                object2 = ", ";
                stringBuilder.append((String)object2);
            }
            map.remove(object);
        } else {
            object = "...";
            stringBuilder.append((String)object);
        }
        stringBuilder.append(']');
    }

    private static void q(StringBuilder stringBuilder, Object object) {
        String string2 = object.toString();
        try {
            stringBuilder.append(string2);
        }
        catch (Throwable throwable) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String string3 = "SLF4J: Failed toString() invocation on an object of type [";
            stringBuilder2.append(string3);
            object = object.getClass().getName();
            stringBuilder2.append((String)object);
            stringBuilder2.append("]");
            i.d(stringBuilder2.toString(), throwable);
            object = "[FAILED toString()]";
            stringBuilder.append((String)object);
        }
    }

    private static void r(StringBuilder stringBuilder, short[] sArray) {
        stringBuilder.append('[');
        int n10 = sArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = sArray[i10];
            stringBuilder.append(n11);
            n11 = n10 + -1;
            if (i10 == n11) continue;
            String string2 = ", ";
            stringBuilder.append(string2);
        }
        stringBuilder.append(']');
    }

    private static Object[] s(Object[] object) {
        int n10;
        if (object != null && (n10 = ((Object[])object).length) != 0) {
            n10 = ((Object[])object).length + -1;
            Object[] objectArray = new Object[n10];
            System.arraycopy(object, 0, objectArray, 0, n10);
            return objectArray;
        }
        object = new IllegalStateException("non-sensical empty or null argument array");
        throw object;
    }
}

