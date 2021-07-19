/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.voice;

import d.v.j.b;
import d.v.v.q.h;
import java.util.List;
import m.a.a;

public class VoiceUseCases {
    public static boolean a(int n10, long l10, List object) {
        boolean bl2 = b.h(n10, (List)object);
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        d.v.h.h.b b10 = (d.v.h.h.b)object.get(n10);
        boolean bl4 = b.b((String)(object = b10.k()));
        if (!bl4) {
            long l11 = b10.m();
            long l12 = b10.f();
            long l13 = l10;
            bl4 = b.a(l10, l11, l12);
            if (!bl4 && !(bl4 = VoiceUseCases.d(l13 = b10.m(), l10)) && (n10 = (int)(VoiceUseCases.d(l10, l13 = b10.f()) ? 1 : 0)) == 0) {
                return false;
            }
        }
        return bl3;
    }

    public static boolean b(int n10, long l10, long l11, List object) {
        long l12;
        boolean bl2 = b.h(n10, (List)object);
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        d.v.h.h.b b10 = (d.v.h.h.b)object.get(n10);
        boolean bl4 = b.b((String)(object = b10.k()));
        if (!bl4 && (n10 = (int)(b.j(l10, l11, l12 = b10.e()) ? 1 : 0)) == 0 && (n10 = (int)(VoiceUseCases.d(l10, l11) ? 1 : 0)) == 0) {
            return false;
        }
        return bl3;
    }

    public static boolean c(d.v.h.h.b b10) {
        long l10;
        long l11;
        boolean bl2;
        long l12;
        long l13;
        long l14;
        String string2;
        boolean bl3;
        return b10 == null || (bl3 = b.b(string2 = b10.k())) || (bl3 = b.j(l14 = b10.m(), l13 = b10.f(), l12 = b10.e())) || (bl2 = VoiceUseCases.d(l11 = b10.m(), l10 = b10.f()));
        {
        }
    }

    private static boolean d(long l10, long l11) {
        long l12 = l11 - l10;
        long l13 = 500000L;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        int n10 = 1;
        if ((l14 = l14 < 0 ? (long)n10 : (long)0) != false) {
            Object object;
            int n11 = 3;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object = Long.valueOf(l10);
            objectArray[n10] = object = Long.valueOf(l11);
            int n12 = 2;
            int n13 = 500000;
            Integer n14 = n13;
            objectArray[n12] = n14;
            object = "startTime:%d,endTime:%d,minTime:%d";
            a.b((String)object, objectArray);
        }
        return (boolean)l14;
    }

    public static long e(List list, long l10, String string2, boolean bl2) {
        int n10;
        long l11;
        Object object = list;
        long l12 = h.z();
        long l13 = 0L;
        if (bl2) {
            boolean bl3 = b.b(string2);
            if (bl3) {
                return l13;
            }
            l11 = Math.min(h.C(string2), l12);
        } else {
            l11 = l12;
        }
        int n11 = list.size();
        if (n11 == 0) {
            l13 = l10 + l11;
            long l14 = l13 - l12;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 > 0) {
                return l12 - l10;
            }
            return l11;
        }
        n11 = 0;
        Object object3 = ((d.v.h.h.b)list.get(0)).d();
        long l15 = (Long)object3;
        long l16 = l10 - l15;
        Object object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object4 < 0) {
            Long l17 = ((d.v.h.h.b)list.get(0)).d();
            l13 = l17 - l10;
        }
        object4 = list.size() + -1;
        object3 = (d.v.h.h.b)list.get((int)object4);
        Long l18 = ((d.v.h.h.b)object3).d();
        long l19 = l18;
        long l20 = ((d.v.h.h.b)object3).f();
        long l21 = ((d.v.h.h.b)object3).m();
        long l22 = l10 - (l19 += (l20 -= l21));
        object4 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
        if (object4 >= 0) {
            l13 = l12 - l10;
        }
        while (n11 < (n10 = list.size() + -1)) {
            long l23;
            Object object5 = (d.v.h.h.b)list.get(n11);
            d.v.h.h.b b10 = (d.v.h.h.b)list.get(++n11);
            object3 = ((d.v.h.h.b)object5).d();
            l15 = (Long)object3;
            long l24 = ((d.v.h.h.b)object5).f();
            long l25 = ((d.v.h.h.b)object5).m();
            long l26 = l10 - (l15 += (l24 -= l25));
            n10 = (int)(l26 == 0L ? 0 : (l26 < 0L ? -1 : 1));
            if (n10 < 0 || (n10 = (int)((l23 = l10 - (l15 = ((Long)(object5 = b10.d())).longValue())) == 0L ? 0 : (l23 < 0L ? -1 : 1))) >= 0) continue;
            object = b10.d();
            long l27 = (Long)object;
            l13 = l27 - l10;
            break;
        }
        return Math.min(l13, l11);
    }

    public static int f(List list, long l10) {
        int n10;
        int n11 = -1;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Long l11 = ((d.v.h.h.b)list.get(i10)).d();
            long l12 = l11;
            long l13 = l12 - l10;
            n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n10 > 0) continue;
            l11 = ((d.v.h.h.b)list.get(i10)).d();
            l12 = l11;
            d.v.h.h.b b10 = (d.v.h.h.b)list.get(i10);
            long l14 = b10.f();
            d.v.h.h.b b11 = (d.v.h.h.b)list.get(i10);
            long l15 = b11.m();
            long l16 = l10 - (l12 += (l14 -= l15));
            n10 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
            if (n10 > 0) continue;
            n11 = i10;
        }
        return n11;
    }
}

