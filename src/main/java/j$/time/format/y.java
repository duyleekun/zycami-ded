/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.time.format.C;
import j$.time.format.w;
import j$.time.format.x;
import j$.time.q.h;
import j$.time.q.u;
import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class y {
    private static final ConcurrentMap a;
    private static final Comparator b;
    public static final /* synthetic */ int c;

    static {
        Object object = new ConcurrentHashMap(16, 0.75f, 2);
        a = object;
        b = object = new w();
    }

    y() {
    }

    static /* synthetic */ Comparator a() {
        return b;
    }

    private static String b(String string2) {
        int n10 = Character.charCount(string2.codePointAt(0));
        return string2.substring(0, n10);
    }

    /*
     * WARNING - void declaration
     */
    public String c(u u10, long l10, C c10, Locale locale) {
        boolean bl2;
        Object object = u10;
        Object object2 = locale;
        ConcurrentMap concurrentMap = a;
        AbstractMap.SimpleImmutableEntry<u, Locale> simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry<u, Locale>(u10, locale);
        Object object3 = concurrentMap.get(simpleImmutableEntry);
        if (object3 == null) {
            object3 = C.d;
            Object object4 = C.f;
            Object object5 = C.b;
            HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
            Object object6 = h.F;
            if (u10 == object6) {
                int n10;
                void n13;
                object = DateFormatSymbols.getInstance(locale);
                object2 = new HashMap();
                object6 = new HashMap();
                object = ((DateFormatSymbols)object).getEras();
                boolean i10 = false;
                Object var16_22 = null;
                while (++n13 < (n10 = ((String[])object).length)) {
                    Object object7 = object[n13];
                    n10 = (int)(((String)object7).isEmpty() ? 1 : 0);
                    if (n10 != 0) continue;
                    long l11 = (long)n13;
                    Long l12 = l11;
                    Object object8 = object[n13];
                    ((HashMap)object2).put(l12, object8);
                    object7 = l11;
                    String string2 = y.b((String)object[n13]);
                    ((HashMap)object6).put(object7, string2);
                }
                bl2 = ((HashMap)object2).isEmpty();
                if (!bl2) {
                    hashMap.put(object5, object2);
                    hashMap.put(object3, object2);
                    hashMap.put(object4, object6);
                }
                object = new x(hashMap);
            } else {
                object6 = h.B;
                long l13 = 1L;
                if (u10 == object6) {
                    int n11;
                    void var15_18;
                    Long l14;
                    int n12;
                    object = DateFormatSymbols.getInstance(locale);
                    object2 = new HashMap();
                    object6 = new HashMap();
                    String[] stringArray = ((DateFormatSymbols)object).getMonths();
                    Object var22_38 = null;
                    for (int i10 = 0; i10 < (n12 = stringArray.length); ++i10) {
                        String string3 = stringArray[i10];
                        n12 = (int)(string3.isEmpty() ? 1 : 0);
                        if (n12 == 0) {
                            long l15 = (long)i10 + l13;
                            l14 = l15;
                            String string4 = stringArray[i10];
                            ((HashMap)object2).put(l14, string4);
                            l14 = l15;
                            string4 = y.b(stringArray[i10]);
                            ((HashMap)object6).put(l14, string4);
                        }
                        l13 = 1L;
                    }
                    boolean n14 = ((HashMap)object2).isEmpty();
                    if (!n14) {
                        hashMap.put(object5, object2);
                        hashMap.put(object4, object6);
                    }
                    object2 = new HashMap();
                    object = ((DateFormatSymbols)object).getShortMonths();
                    boolean i12 = false;
                    l14 = null;
                    while (++var15_18 < (n11 = ((Object)object).length)) {
                        object4 = object[var15_18];
                        n11 = (int)(((String)object4).isEmpty() ? 1 : 0);
                        if (n11 != 0) continue;
                        long l16 = (long)var15_18;
                        l13 = 1L;
                        object4 = l16 += l13;
                        object5 = object[var15_18];
                        ((HashMap)object2).put(object4, object5);
                    }
                    bl2 = ((HashMap)object2).isEmpty();
                    if (!bl2) {
                        hashMap.put(object3, object2);
                    }
                    object = new x(hashMap);
                } else {
                    object6 = h.t;
                    if (u10 == object6) {
                        object = DateFormatSymbols.getInstance(locale);
                        object2 = new HashMap();
                        object6 = ((DateFormatSymbols)object).getWeekdays();
                        long l17 = 1L;
                        Long l18 = l17;
                        int n13 = 2;
                        String string5 = object6[n13];
                        ((HashMap)object2).put(l18, string5);
                        l13 = 2;
                        Object object9 = l13;
                        int n14 = 3;
                        Object object10 = object6[n14];
                        ((HashMap)object2).put(object9, object10);
                        object9 = (long)3;
                        int n15 = 4;
                        object10 = object6[n15];
                        ((HashMap)object2).put(object9, object10);
                        object9 = (long)4;
                        int n16 = 5;
                        object10 = object6[n16];
                        ((HashMap)object2).put(object9, object10);
                        object9 = (long)5;
                        int n17 = 6;
                        object10 = object6[n17];
                        ((HashMap)object2).put(object9, object10);
                        object9 = (long)6;
                        int n18 = 7;
                        object10 = object6[n18];
                        ((HashMap)object2).put(object9, object10);
                        object9 = (long)7;
                        int n19 = 1;
                        object10 = object6[n19];
                        ((HashMap)object2).put(object9, object10);
                        hashMap.put(object5, object2);
                        object2 = new HashMap();
                        object5 = 1L;
                        object9 = y.b((String)object6[n13]);
                        ((HashMap)object2).put(object5, object9);
                        object5 = l13;
                        object9 = y.b((String)object6[n14]);
                        ((HashMap)object2).put(object5, object9);
                        object5 = Long.valueOf(3);
                        object9 = y.b((String)object6[n15]);
                        ((HashMap)object2).put(object5, object9);
                        object5 = Long.valueOf(4);
                        object9 = y.b((String)object6[n16]);
                        ((HashMap)object2).put(object5, object9);
                        object5 = Long.valueOf(5);
                        object9 = y.b((String)object6[n17]);
                        ((HashMap)object2).put(object5, object9);
                        object5 = Long.valueOf(6);
                        object9 = y.b((String)object6[n18]);
                        ((HashMap)object2).put(object5, object9);
                        long l19 = 7;
                        object5 = l19;
                        object6 = y.b((String)object6[n19]);
                        ((HashMap)object2).put(object5, object6);
                        hashMap.put(object4, object2);
                        object2 = new HashMap();
                        object = ((DateFormatSymbols)object).getShortWeekdays();
                        object4 = 1L;
                        object5 = object[n13];
                        ((HashMap)object2).put(object4, object5);
                        object4 = l13;
                        object5 = object[n14];
                        ((HashMap)object2).put(object4, object5);
                        object4 = (long)3;
                        object5 = object[n15];
                        ((HashMap)object2).put(object4, object5);
                        object4 = (long)4;
                        object5 = object[n16];
                        ((HashMap)object2).put(object4, object5);
                        object4 = (long)5;
                        object5 = object[n17];
                        ((HashMap)object2).put(object4, object5);
                        object4 = (long)6;
                        object5 = object[n18];
                        ((HashMap)object2).put(object4, object5);
                        long l20 = 7;
                        object4 = l20;
                        object = object[n19];
                        ((HashMap)object2).put(object4, object);
                        hashMap.put(object3, object2);
                        object = new x(hashMap);
                    } else {
                        object6 = h.s;
                        if (u10 == object6) {
                            int n20;
                            void var15_21;
                            object = DateFormatSymbols.getInstance(locale);
                            object2 = new HashMap();
                            object6 = new HashMap();
                            object = ((DateFormatSymbols)object).getAmPmStrings();
                            boolean bl3 = false;
                            Object var16_24 = null;
                            while (++var15_21 < (n20 = ((Object)object).length)) {
                                Object object11 = object[var15_21];
                                n20 = (int)(((String)object11).isEmpty() ? 1 : 0);
                                if (n20 != 0) continue;
                                l13 = (long)var15_21;
                                Long l21 = l13;
                                Object object12 = object[var15_21];
                                ((HashMap)object2).put(l21, object12);
                                object11 = l13;
                                String string6 = y.b((String)object[var15_21]);
                                ((HashMap)object6).put(object11, string6);
                            }
                            bl2 = ((HashMap)object2).isEmpty();
                            if (!bl2) {
                                hashMap.put(object5, object2);
                                hashMap.put(object3, object2);
                                hashMap.put(object4, object6);
                            }
                            object = new x(hashMap);
                        } else {
                            object = "";
                        }
                    }
                }
            }
            concurrentMap.putIfAbsent(simpleImmutableEntry, object);
            object3 = concurrentMap.get(simpleImmutableEntry);
        }
        if (bl2 = object3 instanceof x) {
            object3 = (x)object3;
            object2 = c10;
            return ((x)object3).a(l10, c10);
        }
        return null;
    }
}

