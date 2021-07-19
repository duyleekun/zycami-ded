/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.decoration;

import d.v.e.l.c1;
import d.v.h.d.a;
import d.v.v.q.h;
import java.util.List;
import java.util.concurrent.Executor;

public class DecorationUseCases {
    public static int[] a(int n10) {
        int n11 = (0xFF000000 & n10) >>> 24;
        n11 = (0xFF0000 & n10) >> 16;
        n11 = (0xFF00 & n10) >> 8;
        int[] nArray = new int[]{n11, n11, n11, n10 &= 0xFF};
        return nArray;
    }

    public static int b(List list, long l10) {
        int n10;
        int n11 = -1;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Long l11 = ((a)list.get(i10)).e();
            long l12 = l11;
            long l13 = l12 - l10;
            n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n10 > 0) continue;
            l11 = ((a)list.get(i10)).e();
            l12 = l11;
            a a10 = (a)list.get(i10);
            long l14 = a10.i();
            long l15 = l10 - (l12 += l14);
            n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
            if (n10 > 0) continue;
            n11 = i10;
        }
        return n11;
    }

    public static long c(List object, long l10) {
        int n10 = object.size();
        long l11 = 3000000L;
        if (n10 == 0) {
            return l11;
        }
        n10 = 0;
        Long l12 = ((a)object.get(0)).e();
        long l13 = l12;
        long l14 = l10 - l13;
        Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 < 0) {
            l12 = ((a)object.get(0)).e();
            l13 = l12 - l10;
        } else {
            l13 = l11;
        }
        int n11 = object.size() + -1;
        Long l15 = ((a)object.get(n11)).e();
        long l16 = l15;
        int n12 = object.size() + -1;
        a a10 = (a)object.get(n12);
        long l17 = a10.i();
        long l18 = l10 - (l16 += l17);
        n11 = (int)(l18 == 0L ? 0 : (l18 < 0L ? -1 : 1));
        if (n11 > 0) {
            l13 = l11;
        }
        while (n10 < (n11 = object.size() + -1)) {
            Long l19;
            long l20;
            long l21;
            long l22;
            l15 = ((a)object.get(n10)).e();
            l16 = l15;
            a10 = (a)object.get(n10);
            l17 = a10.i();
            long l23 = l10 - (l16 += l17);
            n11 = (int)(l23 == 0L ? 0 : (l23 < 0L ? -1 : 1));
            if (n11 > 0 && (l22 = (l21 = l10 - (l20 = (l19 = ((a)object.get(n11 = n10 + 1)).e()).longValue())) == 0L ? 0 : (l21 < 0L ? -1 : 1)) < 0) {
                object = ((a)object.get(n11)).e();
                l13 = (Long)object - l10;
                break;
            }
            ++n10;
        }
        return Math.min(l13, l11);
    }

    public static void d(String string2) {
        boolean bl2 = h.e(string2);
        if (bl2) {
            return;
        }
        Executor executor = c1.b().a();
        d.v.i.a.a a10 = new d.v.i.a.a(string2);
        executor.execute(a10);
    }

    public static /* synthetic */ void e(String string2) {
        h.i0(string2);
    }
}

