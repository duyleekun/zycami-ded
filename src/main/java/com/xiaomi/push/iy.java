/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.iy$a;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class iy {
    private static final Comparator a;

    static {
        iy$a iy$a = new iy$a(null);
        a = iy$a;
    }

    public static int a(byte by2, byte by3) {
        if (by2 < by3) {
            return -1;
        }
        if (by3 < by2) {
            return 1;
        }
        return 0;
    }

    public static int a(int n10, int n11) {
        if (n10 < n11) {
            return -1;
        }
        if (n11 < n10) {
            return 1;
        }
        return 0;
    }

    public static int a(long l10, long l11) {
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object < 0) {
            return -1;
        }
        Object object2 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        if (object2 < 0) {
            return 1;
        }
        return 0;
    }

    public static int a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static int a(String string2, String string3) {
        return string2.compareTo(string3);
    }

    public static int a(ByteBuffer byteBuffer, byte[] byArray, int n10) {
        int n11 = byteBuffer.remaining();
        byte[] byArray2 = byteBuffer.array();
        int n12 = byteBuffer.arrayOffset();
        int n13 = byteBuffer.position();
        System.arraycopy(byArray2, n12 += n13, byArray, n10, n11);
        return n11;
    }

    public static int a(List list, List list2) {
        int n10;
        int n11 = list.size();
        int n12 = list2.size();
        if ((n11 = iy.a(n11, n12)) != 0) {
            return n11;
        }
        n11 = 0;
        for (n12 = 0; n12 < (n10 = list.size()); ++n12) {
            Object e10;
            Comparator comparator = a;
            Object e11 = list.get(n12);
            n10 = comparator.compare(e11, e10 = list2.get(n12));
            if (n10 == 0) continue;
            return n10;
        }
        return 0;
    }

    public static int a(Map object, Map object2) {
        int n10 = object.size();
        int n11 = object2.size();
        if ((n10 = iy.a(n10, n11)) != 0) {
            return n10;
        }
        Object object3 = a;
        Object object4 = new TreeMap(object3);
        object4.putAll(object);
        object = object4.entrySet().iterator();
        object4 = new TreeMap(object3);
        object4.putAll(object2);
        object2 = object4.entrySet().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0 && (n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
            Object k10;
            object4 = (Map.Entry)object.next();
            object3 = (Map.Entry)object2.next();
            Comparator comparator = a;
            Object k11 = object4.getKey();
            int n12 = comparator.compare(k11, k10 = object3.getKey());
            if (n12 != 0) {
                return n12;
            }
            n10 = comparator.compare(object4 = object4.getValue(), object3 = object3.getValue());
            if (n10 == 0) continue;
            return n10;
        }
        return 0;
    }

    public static int a(Set object, Set object2) {
        int n10 = object.size();
        int n11 = object2.size();
        if ((n10 = iy.a(n10, n11)) != 0) {
            return n10;
        }
        Comparator<Object> comparator = a;
        Object object3 = new TreeSet(comparator);
        object3.addAll(object);
        object = new TreeSet(comparator);
        object.addAll(object2);
        object2 = object3.iterator();
        object = object.iterator();
        while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0 && (n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object e10;
            object3 = a;
            comparator = object2.next();
            n10 = object3.compare(comparator, e10 = object.next());
            if (n10 == 0) continue;
            return n10;
        }
        return 0;
    }

    public static int a(short s10, short s11) {
        if (s10 < s11) {
            return -1;
        }
        if (s11 < s10) {
            return 1;
        }
        return 0;
    }

    public static int a(boolean bl2, boolean bl3) {
        Boolean bl4 = bl2;
        Boolean bl5 = bl3;
        return bl4.compareTo(bl5);
    }

    public static int a(byte[] byArray, byte[] byArray2) {
        int n10;
        int n11 = byArray.length;
        int n12 = byArray2.length;
        if ((n11 = iy.a(n11, n12)) != 0) {
            return n11;
        }
        n11 = 0;
        for (n12 = 0; n12 < (n10 = byArray.length); ++n12) {
            n10 = byArray[n12];
            byte by2 = byArray2[n12];
            if ((n10 = iy.a((byte)n10, by2)) == 0) continue;
            return n10;
        }
        return 0;
    }

    public static String a(byte by2) {
        return Integer.toHexString((by2 | 0x100) & 0x1FF).toUpperCase().substring(1);
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        boolean bl2 = iy.a(byteBuffer);
        if (bl2) {
            return byteBuffer;
        }
        return ByteBuffer.wrap(iy.a(byteBuffer));
    }

    public static void a(ByteBuffer object, StringBuilder stringBuilder) {
        int n10;
        byte[] byArray = ((ByteBuffer)object).array();
        int n11 = ((ByteBuffer)object).arrayOffset();
        int n12 = ((Buffer)object).limit();
        int n13 = n12 - n11;
        n13 = n13 > (n10 = 128) ? n11 + 128 : n12;
        for (n10 = n11; n10 < n13; ++n10) {
            String string2;
            if (n10 > n11) {
                string2 = " ";
                stringBuilder.append(string2);
            }
            byte by2 = byArray[n10];
            string2 = iy.a(by2);
            stringBuilder.append(string2);
        }
        if (n12 != n13) {
            object = "...";
            stringBuilder.append((String)object);
        }
    }

    public static boolean a(ByteBuffer byteBuffer) {
        int n10;
        int n11 = byteBuffer.hasArray();
        if (n11 != 0 && (n11 = byteBuffer.position()) == 0 && (n11 = byteBuffer.arrayOffset()) == 0 && (n11 = byteBuffer.remaining()) == (n10 = byteBuffer.capacity())) {
            n10 = 1;
        } else {
            n10 = 0;
            byteBuffer = null;
        }
        return n10 != 0;
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        boolean bl2 = iy.a(byteBuffer);
        if (bl2) {
            return byteBuffer.array();
        }
        byte[] byArray = new byte[byteBuffer.remaining()];
        iy.a(byteBuffer, byArray, 0);
        return byArray;
    }
}

